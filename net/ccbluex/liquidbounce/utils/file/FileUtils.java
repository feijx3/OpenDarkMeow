/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.apache.commons.io.IOUtils
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.utils.file;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.utils.file.ImageUtils;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/utils/file/FileUtils;", "", "<init>", "()V", "readResourceFileAsStream", "Ljava/io/InputStream;", "file", "", "readResourceFileAsString", "unpackResourceFile", "Ljava/io/FileOutputStream;", "optFile", "Ljava/io/File;", "unpackResourceFileWebpToPng", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nFileUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileUtils.kt\nnet/ccbluex/liquidbounce/utils/file/FileUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,55:1\n1#2:56\n*E\n"})
public final class FileUtils {
    @NotNull
    public static final FileUtils INSTANCE = new FileUtils();

    private FileUtils() {
    }

    @Nullable
    public final InputStream readResourceFileAsStream(@NotNull String file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return DarkMeow.class.getClassLoader().getResourceAsStream(file);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @NotNull
    public final String readResourceFileAsString(@NotNull String file) {
        String string;
        Intrinsics.checkNotNullParameter(file, "file");
        InputStream inputStream = this.readResourceFileAsStream(file);
        if (inputStream == null) return "";
        InputStream stream = inputStream;
        boolean bl2 = false;
        Closeable closeable = new BufferedReader(new InputStreamReader(stream));
        Throwable throwable = null;
        try {
            BufferedReader it = (BufferedReader)closeable;
            boolean bl3 = false;
            string = TextStreamsKt.readText(it);
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally(closeable, throwable);
        }
        String string2 = string;
        if (string2 == null) return "";
        String string3 = string2;
        return string3;
    }

    @NotNull
    public final FileOutputStream unpackResourceFile(@NotNull String file, @NotNull File optFile) {
        FileOutputStream fileOutputStream;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(optFile, "optFile");
        FileOutputStream it = fileOutputStream = new FileOutputStream(optFile);
        boolean bl2 = false;
        IOUtils.copy((InputStream)INSTANCE.readResourceFileAsStream(file), (OutputStream)it);
        it = fileOutputStream;
        boolean bl3 = false;
        it.close();
        return fileOutputStream;
    }

    @NotNull
    public final FileOutputStream unpackResourceFileWebpToPng(@NotNull String file, @NotNull File optFile) {
        FileOutputStream fileOutputStream;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(optFile, "optFile");
        FileOutputStream it = fileOutputStream = new FileOutputStream(optFile);
        boolean bl2 = false;
        InputStream inputStream = INSTANCE.readResourceFileAsStream(file);
        if (inputStream != null) {
            InputStream it1 = inputStream;
            boolean bl3 = false;
            ImageUtils.INSTANCE.convertWebPToPNG(it1, it);
        }
        it = fileOutputStream;
        boolean bl4 = false;
        it.close();
        return fileOutputStream;
    }
}

