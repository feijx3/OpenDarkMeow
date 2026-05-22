/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aow
 *  aox
 *  awt
 *  com.google.common.collect.ImmutableSet
 *  et
 */
package baritone;

import baritone.a;
import baritone.api.cache.ICachedRegion;
import baritone.api.utils.BlockUtils;
import baritone.fy;
import baritone.l;
import baritone.p;
import com.google.common.collect.ImmutableSet;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class m
implements ICachedRegion {
    private final l[][] a;
    private final int a;
    private final int b;
    private final int c;
    private boolean a = new l[32][32];

    m(int n2, int n3, int n4) {
        this.a = n2;
        this.b = n3;
        this.a = false;
        this.c = n4;
    }

    @Override
    public final awt getBlock(int n2, int n3, int n4) {
        l l2 = this.a[n2 >> 4][n4 >> 4];
        if (l2 != null) {
            int n5;
            int n6 = this.c;
            int n7 = n4 & 0xF;
            n4 = n3;
            n3 = n2 & 0xF;
            Object object = l2;
            int n8 = n5 = l.a(n3, n4, n7);
            Object object2 = object;
            object2 = fy.a(((l)object2).a.get(n8), ((l)object2).a.get(n8 + 1));
            if (((l)object).a[n3 = n7 << 4 | n3] == n4 && object2 != fy.c) {
                return ((l)object).a[n3];
            }
            if (((l)object).a != null && (object = (String)((l)object).a.get(n5)) != null) {
                return BlockUtils.stringToBlockRequired((String)object).t();
            }
            if (object2 == fy.d) {
                if (n4 == 127 && n6 == -1) {
                    return aox.h.t();
                }
                if (n4 < 5 && n6 == 0) {
                    return aox.Z.t();
                }
            }
            n8 = n6;
            switch (p.a[((Enum)object2).ordinal()]) {
                case 1: {
                    return aox.a.t();
                }
                case 2: {
                    return aox.j.t();
                }
                case 3: {
                    return aox.l.t();
                }
                case 4: {
                    switch (n8) {
                        case -1: {
                            return aox.aV.t();
                        }
                        default: {
                            return aox.b.t();
                        }
                        case 1: 
                    }
                    return aox.bH.t();
                }
            }
            return null;
        }
        return null;
    }

    @Override
    public final boolean isCached(int n2, int n3) {
        return this.a[n2 >> 4][n3 >> 4] != null;
    }

    public final ArrayList<et> a(String string) {
        ArrayList<et> arrayList = new ArrayList<et>();
        for (int i2 = 0; i2 < 32; ++i2) {
            for (int i3 = 0; i3 < 32; ++i3) {
                ArrayList<et> arrayList2;
                if (this.a[i2][i3] == null || (arrayList2 = this.a[i2][i3].a(string)) == null) continue;
                arrayList.addAll(arrayList2);
            }
        }
        return arrayList;
    }

    public final synchronized void a(int n2, int n3, l l2) {
        this.a[n2][n3] = l2;
        this.a = true;
    }

    public final synchronized void a(String object) {
        if (!this.a) {
            return;
        }
        this.a();
        try {
            object = Paths.get((String)object, new String[0]);
            if (!Files.exists((Path)object, new LinkOption[0])) {
                Files.createDirectories((Path)object, new FileAttribute[0]);
            }
            System.out.println("Saving region " + this.a + "," + this.b + " to disk " + object);
            object = m.a((Path)object, this.a, this.b);
            if (!Files.exists((Path)object, new LinkOption[0])) {
                Files.createFile((Path)object, new FileAttribute[0]);
            }
            object = new FileOutputStream(object.toFile());
            Throwable throwable = null;
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream((OutputStream)object, 16384);
                Throwable throwable2 = null;
                try {
                    DataOutputStream dataOutputStream = new DataOutputStream(gZIPOutputStream);
                    Throwable throwable3 = null;
                    try {
                        int n2;
                        int n3;
                        dataOutputStream.writeInt(456022910);
                        for (n3 = 0; n3 < 32; ++n3) {
                            for (n2 = 0; n2 < 32; ++n2) {
                                Object object2 = this.a[n3][n2];
                                if (object2 == null) {
                                    dataOutputStream.write(0);
                                    continue;
                                }
                                dataOutputStream.write(1);
                                object2 = ((l)object2).a.toByteArray();
                                dataOutputStream.write((byte[])object2);
                                dataOutputStream.write(new byte[16384 - ((Object)object2).length]);
                            }
                        }
                        for (n3 = 0; n3 < 32; ++n3) {
                            for (n2 = 0; n2 < 32; ++n2) {
                                if (this.a[n3][n2] == null) continue;
                                for (int i2 = 0; i2 < 256; ++i2) {
                                    dataOutputStream.writeUTF(BlockUtils.blockToString(this.a[n3][n2].a[i2].u()));
                                }
                            }
                        }
                        for (n3 = 0; n3 < 32; ++n3) {
                            for (n2 = 0; n2 < 32; ++n2) {
                                if (this.a[n3][n2] == null) continue;
                                ImmutableSet<aow> immutableSet = this.a[n3][n2].a;
                                dataOutputStream.writeShort(immutableSet.entrySet().size());
                                for (Map.Entry entry : immutableSet.entrySet()) {
                                    dataOutputStream.writeUTF((String)entry.getKey());
                                    dataOutputStream.writeShort(((List)entry.getValue()).size());
                                    for (et et2 : (List)entry.getValue()) {
                                        dataOutputStream.writeByte((byte)(et2.r() << 4 | et2.p()));
                                        dataOutputStream.writeByte((byte)et2.q());
                                    }
                                }
                            }
                        }
                        for (n3 = 0; n3 < 32; ++n3) {
                            for (n2 = 0; n2 < 32; ++n2) {
                                if (this.a[n3][n2] == null) continue;
                                dataOutputStream.writeLong(this.a[n3][n2].a);
                            }
                        }
                    }
                    catch (Throwable throwable4) {
                        try {
                            Throwable throwable5 = throwable4;
                            throwable3 = throwable4;
                            throw throwable5;
                        }
                        catch (Throwable throwable6) {
                            if (throwable3 != null) {
                                try {
                                    dataOutputStream.close();
                                }
                                catch (Throwable throwable7) {
                                    throwable3.addSuppressed(throwable7);
                                }
                            } else {
                                dataOutputStream.close();
                            }
                            throw throwable6;
                        }
                    }
                    dataOutputStream.close();
                }
                catch (Throwable throwable5) {
                    try {
                        Throwable throwable9 = throwable5;
                        throwable2 = throwable5;
                        throw throwable9;
                    }
                    catch (Throwable throwable10) {
                        if (throwable2 != null) {
                            try {
                                gZIPOutputStream.close();
                            }
                            catch (Throwable throwable11) {
                                throwable2.addSuppressed(throwable11);
                            }
                        } else {
                            gZIPOutputStream.close();
                        }
                        throw throwable10;
                    }
                }
                gZIPOutputStream.close();
            }
            catch (Throwable throwable6) {
                try {
                    Throwable throwable13 = throwable6;
                    throwable = throwable6;
                    throw throwable13;
                }
                catch (Throwable throwable14) {
                    if (throwable != null) {
                        try {
                            ((FileOutputStream)object).close();
                        }
                        catch (Throwable throwable15) {
                            throwable.addSuppressed(throwable15);
                        }
                    } else {
                        ((FileOutputStream)object).close();
                    }
                    throw throwable14;
                }
            }
            ((FileOutputStream)object).close();
            this.a = false;
            System.out.println("Saved region successfully");
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public final synchronized void b(String object) {
        try {
            Object object2;
            object = Paths.get((String)object, new String[0]);
            if (!Files.exists((Path)object, new LinkOption[0])) {
                Files.createDirectories((Path)object, new FileAttribute[0]);
            }
            if (!Files.exists((Path)(object2 = m.a((Path)object, this.a, this.b)), new LinkOption[0])) {
                return;
            }
            System.out.println("Loading region " + this.a + "," + this.b + " from disk " + object);
            long l2 = System.nanoTime() / 1000000L;
            FileInputStream fileInputStream = new FileInputStream(object2.toFile());
            Throwable throwable = null;
            try {
                object = new GZIPInputStream((InputStream)fileInputStream, 32768);
                object2 = null;
                try {
                    DataInputStream dataInputStream = new DataInputStream((InputStream)object);
                    Throwable throwable2 = null;
                    try {
                        int n2;
                        int n3;
                        int n4;
                        int n5;
                        int n6 = dataInputStream.readInt();
                        if (n6 != 456022910) {
                            throw new IOException("Bad magic value ".concat(String.valueOf(n6)));
                        }
                        boolean[][] blArray = new boolean[32][32];
                        BitSet[][] bitSetArray = new BitSet[32][32];
                        Map[][] mapArray = new Map[32][32];
                        awt[][][] awtArray = new awt[32][32][];
                        long[][] lArray = new long[32][32];
                        for (n5 = 0; n5 < 32; ++n5) {
                            block25: for (n4 = 0; n4 < 32; ++n4) {
                                switch (dataInputStream.read()) {
                                    case 1: {
                                        byte[] byArray = new byte[16384];
                                        dataInputStream.readFully(byArray);
                                        bitSetArray[n5][n4] = BitSet.valueOf(byArray);
                                        mapArray[n5][n4] = new HashMap();
                                        awtArray[n5][n4] = new awt[256];
                                        blArray[n5][n4] = true;
                                        continue block25;
                                    }
                                    case 0: {
                                        continue block25;
                                    }
                                    default: {
                                        throw new IOException("Malformed stream");
                                    }
                                }
                            }
                        }
                        for (n5 = 0; n5 < 32; ++n5) {
                            for (n4 = 0; n4 < 32; ++n4) {
                                if (!blArray[n5][n4]) continue;
                                for (n3 = 0; n3 < 256; ++n3) {
                                    awtArray[n5][n4][n3] = BlockUtils.stringToBlockRequired(dataInputStream.readUTF()).t();
                                }
                            }
                        }
                        for (n5 = 0; n5 < 32; ++n5) {
                            for (n4 = 0; n4 < 32; ++n4) {
                                if (!blArray[n5][n4]) continue;
                                n3 = dataInputStream.readShort() & 0xFFFF;
                                for (int i2 = 0; i2 < n3; ++i2) {
                                    String string = dataInputStream.readUTF();
                                    BlockUtils.stringToBlockRequired(string);
                                    ArrayList<et> arrayList = new ArrayList<et>();
                                    mapArray[n5][n4].put(string, arrayList);
                                    n2 = dataInputStream.readShort() & 0xFFFF;
                                    if (n2 == 0) {
                                        n2 = 65536;
                                    }
                                    for (int i3 = 0; i3 < n2; ++i3) {
                                        int n7 = dataInputStream.readByte();
                                        int n8 = n7 & 0xF;
                                        n7 = n7 >>> 4 & 0xF;
                                        int n9 = dataInputStream.readByte() & 0xFF;
                                        arrayList.add(new et(n8, n9, n7));
                                    }
                                }
                            }
                        }
                        for (n5 = 0; n5 < 32; ++n5) {
                            for (n4 = 0; n4 < 32; ++n4) {
                                if (!blArray[n5][n4]) continue;
                                lArray[n5][n4] = dataInputStream.readLong();
                            }
                        }
                        for (n5 = 0; n5 < 32; ++n5) {
                            for (n4 = 0; n4 < 32; ++n4) {
                                if (!blArray[n5][n4]) continue;
                                n3 = this.a;
                                int n10 = this.b;
                                n2 = n5 + (n3 << 5);
                                int n11 = n4 + (n10 << 5);
                                this.a[n5][n4] = new l(n2, n11, bitSetArray[n5][n4], awtArray[n5][n4], mapArray[n5][n4], lArray[n5][n4]);
                            }
                        }
                    }
                    catch (Throwable throwable3) {
                        try {
                            Throwable throwable4 = throwable3;
                            throwable2 = throwable3;
                            throw throwable4;
                        }
                        catch (Throwable throwable5) {
                            if (throwable2 != null) {
                                try {
                                    dataInputStream.close();
                                }
                                catch (Throwable throwable6) {
                                    throwable2.addSuppressed(throwable6);
                                }
                            } else {
                                dataInputStream.close();
                            }
                            throw throwable5;
                        }
                    }
                    dataInputStream.close();
                }
                catch (Throwable throwable7) {
                    try {
                        Throwable throwable8 = throwable7;
                        object2 = throwable7;
                        throw throwable8;
                    }
                    catch (Throwable throwable9) {
                        if (object2 != null) {
                            try {
                                ((GZIPInputStream)object).close();
                            }
                            catch (Throwable throwable10) {
                                ((Throwable)object2).addSuppressed(throwable10);
                            }
                        } else {
                            ((GZIPInputStream)object).close();
                        }
                        throw throwable9;
                    }
                }
                ((GZIPInputStream)object).close();
            }
            catch (Throwable throwable11) {
                try {
                    object = throwable11;
                    throwable = throwable11;
                    throw object;
                }
                catch (Throwable throwable12) {
                    if (throwable != null) {
                        try {
                            fileInputStream.close();
                        }
                        catch (Throwable throwable13) {
                            throwable.addSuppressed(throwable13);
                        }
                    } else {
                        fileInputStream.close();
                    }
                    throw throwable12;
                }
            }
            fileInputStream.close();
            this.a();
            this.a = false;
            long l3 = System.nanoTime() / 1000000L;
            System.out.println("Loaded region successfully in " + (l3 - l2) + "ms");
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public final synchronized void a() {
        long l2 = (Long)baritone.a.a().cachedChunksExpirySeconds.value;
        if (l2 < 0L) {
            return;
        }
        long l3 = System.currentTimeMillis();
        long l4 = l3 - l2 * 1000L;
        for (int i2 = 0; i2 < 32; ++i2) {
            for (int i3 = 0; i3 < 32; ++i3) {
                if (this.a[i2][i3] == null || this.a[i2][i3].a >= l4) continue;
                System.out.println("Removing chunk " + (i2 + 32 * this.a) + "," + (i3 + 32 * this.b) + " because it was cached " + (l3 - this.a[i2][i3].a) / 1000L + " seconds ago, and max age is " + l2);
                this.a[i2][i3] = null;
            }
        }
    }

    public final synchronized l a() {
        l l2 = null;
        for (int i2 = 0; i2 < 32; ++i2) {
            for (int i3 = 0; i3 < 32; ++i3) {
                if (this.a[i2][i3] == null || l2 != null && this.a[i2][i3].a <= l2.a) continue;
                l2 = this.a[i2][i3];
            }
        }
        return l2;
    }

    @Override
    public final int getX() {
        return this.a;
    }

    @Override
    public final int getZ() {
        return this.b;
    }

    private static Path a(Path path, int n2, int n3) {
        return Paths.get(path.toString(), "r." + n2 + "." + n3 + ".bcr");
    }
}

