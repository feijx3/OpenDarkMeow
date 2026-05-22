/*
 * Decompiled with CFR 0.152.
 */
package dev.babbaj.pathfinder;

import dev.babbaj.pathfinder.PathSegment;
import dev.babbaj.pathfinder.xz.x;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class NetherPathfinder {
    public static int CACHE_MISS_GENERATE = 0;
    public static int CACHE_MISS_AIR = 1;
    public static int CACHE_MISS_SOLID = 2;
    private static final boolean IS_LOADED;

    public static native long newContext(long var0);

    public static native void freeContext(long var0);

    public static native void insertChunkData(long var0, int var2, int var3, boolean[] var4);

    public static native long getOrCreateChunk(long var0, int var2, int var3);

    public static native long getChunkPointer(long var0, int var2, int var3);

    public static native void cullFarChunks(long var0, int var2, int var3, int var4);

    public static native PathSegment pathFind(long var0, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, boolean var9, int var10, boolean var11);

    private static native void raytrace0(long var0, int var2, int var3, double[] var4, double[] var5, boolean[] var6, double[] var7);

    public static void raytrace(long l2, int n2, int n3, double[] dArray, double[] dArray2, boolean[] blArray, double[] dArray3) {
        if (dArray.length < n3 * 3 || dArray2.length < n3 * 3 || blArray.length < n3 || dArray3 != null && dArray3.length < n3 * 3) {
            throw new IllegalArgumentException("Bad array lengths idiot");
        }
        NetherPathfinder.raytrace0(l2, n2, n3, dArray, dArray2, blArray, dArray3);
    }

    private static native int isVisibleMulti0(long var0, int var2, int var3, double[] var4, double[] var5, boolean var6);

    public static int isVisibleMulti(long l2, int n2, int n3, double[] dArray, double[] dArray2, boolean bl2) {
        if (dArray.length < n3 * 3 || dArray2.length < n3 * 3) {
            throw new IllegalArgumentException("Bad array lengths idiot");
        }
        return NetherPathfinder.isVisibleMulti0(l2, n2, n3, dArray, dArray2, bl2);
    }

    public static native boolean isVisible(long var0, int var2, double var3, double var5, double var7, double var9, double var11, double var13);

    public static native boolean cancel(long var0);

    static native long getX2Index();

    public static boolean isThisSystemSupported() {
        return IS_LOADED;
    }

    private static String getNativeLibName() {
        if (Integer.parseInt(System.getProperty("sun.arch.data.model")) != 64) {
            throw new UnsupportedOperationException("Unsupported architecture (64-bit required)");
        }
        String string = System.getProperty("os.name").toLowerCase();
        String string2 = System.getProperty("os.arch").toLowerCase();
        if (string2.contains("arm") || string2.contains("aarch64")) {
            string2 = "aarch64";
        } else if (string2.equals("x86_64") || string2.equals("amd64")) {
            string2 = "x86_64";
        } else {
            throw new UnsupportedOperationException("Unsupported architecture: ".concat(String.valueOf(string2)));
        }
        if (string.contains("linux")) {
            return "libnether_pathfinder-" + string2 + ".so";
        }
        if (string.contains("windows")) {
            return "nether_pathfinder-" + string2 + ".dll";
        }
        if (string.contains("mac")) {
            return "libnether_pathfinder-" + string2 + ".dylib";
        }
        throw new UnsupportedOperationException("Unsupported operating system: ".concat(String.valueOf(string)));
    }

    private static byte[] getNativeLib(String object) {
        Object object2;
        Throwable throwable = null;
        try (InputStream inputStream = NetherPathfinder.class.getClassLoader().getResourceAsStream("natives.zip.xz");){
            Object object3;
            object2 = new x(inputStream);
            Throwable throwable2 = null;
            try {
                object3 = new ZipInputStream((InputStream)object2);
                Throwable throwable3 = null;
                try {
                    Object object4;
                    while ((object4 = ((ZipInputStream)object3).getNextEntry()) != null) {
                        int n2;
                        if (!((ZipEntry)object4).getName().equals(object)) continue;
                        object = new ByteArrayOutputStream();
                        object4 = new byte[4096];
                        while ((n2 = ((FilterInputStream)object3).read((byte[])object4)) != -1) {
                            ((ByteArrayOutputStream)object).write((byte[])object4, 0, n2);
                        }
                        object = ((ByteArrayOutputStream)object).toByteArray();
                        return object;
                    }
                }
                catch (Throwable throwable4) {
                    Throwable throwable5 = throwable4;
                    throwable3 = throwable4;
                    throw throwable5;
                }
                finally {
                    if (throwable3 != null) {
                        try {
                            ((ZipInputStream)object3).close();
                        }
                        catch (Throwable throwable6) {
                            throwable3.addSuppressed(throwable6);
                        }
                    } else {
                        ((ZipInputStream)object3).close();
                    }
                }
            }
            catch (Throwable throwable7) {
                object3 = throwable7;
                throwable2 = throwable7;
                throw object3;
            }
            finally {
                if (throwable2 != null) {
                    try {
                        ((x)object2).close();
                    }
                    catch (Throwable throwable8) {
                        throwable2.addSuppressed(throwable8);
                    }
                } else {
                    ((x)object2).close();
                }
            }
        }
        catch (Throwable throwable9) {
            object2 = throwable9;
            throwable = throwable9;
            throw object2;
        }
        throw new NullPointerException("Failed to find pathfinder library: ".concat(String.valueOf(object)));
    }

    private static void tryLoadLibrary() {
        Object object = NetherPathfinder.getNativeLibName();
        byte[] byArray = NetherPathfinder.getNativeLib((String)object);
        object = ((String)object).split("\\.");
        object = Files.createTempFile(object[0], "." + object[1], new FileAttribute[0]);
        System.out.println("[nether-pathfinder] Created temp file at " + object.toAbsolutePath());
        try {
            Files.write((Path)object, byArray, new OpenOption[0]);
            System.load(object.toAbsolutePath().toString());
        }
        catch (Throwable throwable) {
            try {
                Files.delete((Path)object);
            }
            catch (IOException iOException) {
                System.err.println("[nether-pathfinder] Failed to delete temp file");
            }
            if (!object.toFile().delete()) {
                object.toFile().deleteOnExit();
            }
            throw throwable;
        }
        try {
            Files.delete((Path)object);
        }
        catch (IOException iOException) {
            System.err.println("[nether-pathfinder] Failed to delete temp file");
        }
        if (!object.toFile().delete()) {
            object.toFile().deleteOnExit();
            return;
        }
    }

    static {
        boolean bl2 = false;
        try {
            NetherPathfinder.tryLoadLibrary();
            System.out.println("[nether-pathfinder] Loaded shared library");
            bl2 = true;
        }
        catch (Throwable throwable) {
            System.err.println("[nether-pathfinder] Failed to load shared library");
            throwable.printStackTrace();
        }
        IS_LOADED = bl2;
    }
}

