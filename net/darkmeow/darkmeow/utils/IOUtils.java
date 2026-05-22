/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2={"Lnet/darkmeow/darkmeow/utils/IOUtils;", "", "<init>", "()V", "readText", "", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "bufferSize", "", "DarkMeow"})
public final class IOUtils {
    @NotNull
    public static final IOUtils INSTANCE = new IOUtils();

    private IOUtils() {
    }

    @NotNull
    public final String readText(@NotNull InputStream $this$readText, @NotNull Charset charset, int bufferSize) {
        Intrinsics.checkNotNullParameter($this$readText, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        StringWriter stringWriter = new StringWriter();
        InputStream inputStream = $this$readText;
        int n2 = bufferSize / 2;
        inputStream = inputStream instanceof BufferedInputStream ? (BufferedInputStream)inputStream : new BufferedInputStream(inputStream, n2);
        TextStreamsKt.copyTo(new InputStreamReader(inputStream, charset), stringWriter, bufferSize / 2);
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String readText$default(IOUtils iOUtils, InputStream inputStream, Charset charset, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((n3 & 2) != 0) {
            n2 = 8192;
        }
        return iOUtils.readText(inputStream, charset, n2);
    }
}

