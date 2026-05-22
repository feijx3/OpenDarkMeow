/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.internal.InlineOnly
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.internal.InlineOnly;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.ExposingBufferByteArrayOutputStream;
import kotlin.io.FilesKt;
import kotlin.io.FilesKt__FilePathComponentsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=5, xi=49, d1={"\u0000\u008c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a!\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0087\b\u001a\u0017\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a!\u0010\u000b\u001a\u00020\f*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0087\b\u001a\u0017\u0010\r\u001a\u00020\u000e*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0002\u001a\u0012\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0010\u001a\u0012\u0010\u0014\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0010\u001a\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u0017\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u0019\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u001a\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d*\u00020\u0004H\u0000\u001a\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u001dH\u0000\u001aB\u0010#\u001a\u00020\u0012*\u00020\u000226\u0010$\u001a2\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00120%\u001aJ\u0010#\u001a\u00020\u0012*\u00020\u00022\u0006\u0010*\u001a\u00020\b26\u0010$\u001a2\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00120%\u001a7\u0010+\u001a\u00020\u0012*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00120,\u001a\r\u0010.\u001a\u00020/*\u00020\u0002H\u0087\b\u001a\r\u00100\u001a\u000201*\u00020\u0002H\u0087\b\u001a\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u001603*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001aL\u00104\u001a\u0002H5\"\u0004\b\u0000\u00105*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0018\u00106\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001607\u0012\u0004\u0012\u0002H50,H\u0086\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0002\u00108\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u00069"}, d2={"reader", "Ljava/io/InputStreamReader;", "Ljava/io/File;", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "writer", "Ljava/io/OutputStreamWriter;", "bufferedWriter", "Ljava/io/BufferedWriter;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "", "writeBytes", "", "array", "appendBytes", "readText", "", "writeText", "text", "appendText", "writeTextImpl", "Ljava/io/OutputStream;", "newReplaceEncoder", "Ljava/nio/charset/CharsetEncoder;", "kotlin.jvm.PlatformType", "byteBufferForEncoding", "Ljava/nio/ByteBuffer;", "chunkSize", "encoder", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "outputStream", "Ljava/io/FileOutputStream;", "readLines", "", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, xs="kotlin/io/FilesKt")
@SourceDebugExtension(value={"SMAP\nFileReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileReadWrite.kt\nkotlin/io/FilesKt__FileReadWriteKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,290:1\n1#2:291\n*E\n"})
class FilesKt__FileReadWriteKt
extends FilesKt__FilePathComponentsKt {
    @InlineOnly
    private static final InputStreamReader reader(File $this$reader, Charset charset) {
        Intrinsics.checkNotNullParameter($this$reader, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new InputStreamReader((InputStream)new FileInputStream($this$reader), charset);
    }

    static /* synthetic */ InputStreamReader reader$default(File $this$reader_u24default, Charset charset, int n2, Object object) {
        if ((n2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$reader_u24default, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new InputStreamReader((InputStream)new FileInputStream($this$reader_u24default), charset);
    }

    @InlineOnly
    private static final BufferedReader bufferedReader(File $this$bufferedReader, Charset charset, int bufferSize) {
        Intrinsics.checkNotNullParameter($this$bufferedReader, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Object object = $this$bufferedReader;
        object = new InputStreamReader((InputStream)new FileInputStream((File)object), charset);
        return object instanceof BufferedReader ? (BufferedReader)object : new BufferedReader((Reader)object, bufferSize);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(File $this$bufferedReader_u24default, Charset charset, int bufferSize, int n2, Object object) {
        if ((n2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((n2 & 2) != 0) {
            bufferSize = 8192;
        }
        Intrinsics.checkNotNullParameter($this$bufferedReader_u24default, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Object object2 = $this$bufferedReader_u24default;
        object2 = new InputStreamReader((InputStream)new FileInputStream((File)object2), charset);
        return object2 instanceof BufferedReader ? (BufferedReader)object2 : new BufferedReader((Reader)object2, bufferSize);
    }

    @InlineOnly
    private static final OutputStreamWriter writer(File $this$writer, Charset charset) {
        Intrinsics.checkNotNullParameter($this$writer, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new OutputStreamWriter((OutputStream)new FileOutputStream($this$writer), charset);
    }

    static /* synthetic */ OutputStreamWriter writer$default(File $this$writer_u24default, Charset charset, int n2, Object object) {
        if ((n2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$writer_u24default, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new OutputStreamWriter((OutputStream)new FileOutputStream($this$writer_u24default), charset);
    }

    @InlineOnly
    private static final BufferedWriter bufferedWriter(File $this$bufferedWriter, Charset charset, int bufferSize) {
        Intrinsics.checkNotNullParameter($this$bufferedWriter, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Object object = $this$bufferedWriter;
        object = new OutputStreamWriter((OutputStream)new FileOutputStream((File)object), charset);
        return object instanceof BufferedWriter ? (BufferedWriter)object : new BufferedWriter((Writer)object, bufferSize);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(File $this$bufferedWriter_u24default, Charset charset, int bufferSize, int n2, Object object) {
        if ((n2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((n2 & 2) != 0) {
            bufferSize = 8192;
        }
        Intrinsics.checkNotNullParameter($this$bufferedWriter_u24default, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Object object2 = $this$bufferedWriter_u24default;
        object2 = new OutputStreamWriter((OutputStream)new FileOutputStream((File)object2), charset);
        return object2 instanceof BufferedWriter ? (BufferedWriter)object2 : new BufferedWriter((Writer)object2, bufferSize);
    }

    @InlineOnly
    private static final PrintWriter printWriter(File $this$printWriter, Charset charset) {
        Intrinsics.checkNotNullParameter($this$printWriter, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        File file = $this$printWriter;
        int n2 = 8192;
        Object object = file;
        object = new OutputStreamWriter((OutputStream)new FileOutputStream((File)object), charset);
        return new PrintWriter(object instanceof BufferedWriter ? (BufferedWriter)object : new BufferedWriter((Writer)object, n2));
    }

    static /* synthetic */ PrintWriter printWriter$default(File $this$printWriter_u24default, Charset charset, int n2, Object object) {
        if ((n2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$printWriter_u24default, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        File file = $this$printWriter_u24default;
        int n3 = 8192;
        Object object2 = file;
        object2 = new OutputStreamWriter((OutputStream)new FileOutputStream((File)object2), charset);
        return new PrintWriter(object2 instanceof BufferedWriter ? (BufferedWriter)object2 : new BufferedWriter((Writer)object2, n3));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public static final byte[] readBytes(@NotNull File $this$readBytes) {
        byte[] byArray;
        Intrinsics.checkNotNullParameter($this$readBytes, "<this>");
        Closeable closeable = new FileInputStream($this$readBytes);
        Throwable throwable = null;
        try {
            byte[] byArray2;
            int read;
            long l2;
            FileInputStream input = (FileInputStream)closeable;
            boolean bl2 = false;
            int offset = 0;
            long length = l2 = $this$readBytes.length();
            boolean bl3 = false;
            if (length > Integer.MAX_VALUE) {
                throw new OutOfMemoryError("File " + $this$readBytes + " is too big (" + length + " bytes) to fit in memory.");
            }
            int remaining = (int)l2;
            byte[] result = new byte[remaining];
            while (remaining > 0 && (read = input.read(result, offset, remaining)) >= 0) {
                remaining -= read;
                offset += read;
            }
            if (remaining > 0) {
                byte[] byArray3 = Arrays.copyOf(result, offset);
                byArray2 = byArray3;
                Intrinsics.checkNotNullExpressionValue(byArray3, "copyOf(...)");
            } else {
                int extraByte = input.read();
                if (extraByte == -1) {
                    byArray2 = result;
                } else {
                    ExposingBufferByteArrayOutputStream extra = new ExposingBufferByteArrayOutputStream(8193);
                    extra.write(extraByte);
                    ByteStreamsKt.copyTo$default(input, extra, 0, 2, null);
                    int resultingSize = result.length + extra.size();
                    if (resultingSize < 0) {
                        throw new OutOfMemoryError("File " + $this$readBytes + " is too big to fit in memory.");
                    }
                    byte[] byArray4 = extra.getBuffer();
                    byte[] byArray5 = Arrays.copyOf(result, resultingSize);
                    Intrinsics.checkNotNullExpressionValue(byArray5, "copyOf(...)");
                    byArray2 = ArraysKt.copyInto(byArray4, byArray5, result.length, 0, extra.size());
                }
            }
            byArray = byArray2;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally(closeable, throwable);
        }
        return byArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void writeBytes(@NotNull File $this$writeBytes, @NotNull byte[] array) {
        Intrinsics.checkNotNullParameter($this$writeBytes, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        Closeable closeable = new FileOutputStream($this$writeBytes);
        Throwable throwable = null;
        try {
            FileOutputStream it = (FileOutputStream)closeable;
            boolean bl2 = false;
            it.write(array);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally(closeable, throwable);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void appendBytes(@NotNull File $this$appendBytes, @NotNull byte[] array) {
        Intrinsics.checkNotNullParameter($this$appendBytes, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        Closeable closeable = new FileOutputStream($this$appendBytes, true);
        Throwable throwable = null;
        try {
            FileOutputStream it = (FileOutputStream)closeable;
            boolean bl2 = false;
            it.write(array);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally(closeable, throwable);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public static final String readText(@NotNull File $this$readText, @NotNull Charset charset) {
        String string;
        Intrinsics.checkNotNullParameter($this$readText, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Object object = $this$readText;
        object = new InputStreamReader((InputStream)new FileInputStream((File)object), charset);
        Throwable throwable = null;
        try {
            InputStreamReader it = (InputStreamReader)object;
            boolean bl2 = false;
            string = TextStreamsKt.readText(it);
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)object, throwable);
        }
        return string;
    }

    public static /* synthetic */ String readText$default(File file, Charset charset, int n2, Object object) {
        if ((n2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return FilesKt.readText(file, charset);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void writeText(@NotNull File $this$writeText, @NotNull String text, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter($this$writeText, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Closeable closeable = new FileOutputStream($this$writeText);
        Throwable throwable = null;
        try {
            FileOutputStream it = (FileOutputStream)closeable;
            boolean bl2 = false;
            FilesKt.writeTextImpl(it, text, charset);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally(closeable, throwable);
        }
    }

    public static /* synthetic */ void writeText$default(File file, String string, Charset charset, int n2, Object object) {
        if ((n2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.writeText(file, string, charset);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void appendText(@NotNull File $this$appendText, @NotNull String text, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter($this$appendText, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Closeable closeable = new FileOutputStream($this$appendText, true);
        Throwable throwable = null;
        try {
            FileOutputStream it = (FileOutputStream)closeable;
            boolean bl2 = false;
            FilesKt.writeTextImpl(it, text, charset);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally(closeable, throwable);
        }
    }

    public static /* synthetic */ void appendText$default(File file, String string, Charset charset, int n2, Object object) {
        if ((n2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.appendText(file, string, charset);
    }

    public static final void writeTextImpl(@NotNull OutputStream $this$writeTextImpl, @NotNull String text, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter($this$writeTextImpl, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        int chunkSize = 8192;
        if (text.length() < 2 * chunkSize) {
            byte[] byArray = text.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(byArray, "getBytes(...)");
            $this$writeTextImpl.write(byArray);
            return;
        }
        CharsetEncoder encoder = FilesKt.newReplaceEncoder(charset);
        CharBuffer charBuffer = CharBuffer.allocate(chunkSize);
        Intrinsics.checkNotNull(encoder);
        ByteBuffer byteBuffer = FilesKt.byteBufferForEncoding(chunkSize, encoder);
        int startIndex = 0;
        int leftover = 0;
        while (startIndex < text.length()) {
            char[] cArray;
            int n2 = chunkSize - leftover;
            int n3 = text.length() - startIndex;
            int copyLength = Math.min(n2, n3);
            int endIndex = startIndex + copyLength;
            Object object = text;
            Intrinsics.checkNotNullExpressionValue(charBuffer.array(), "array(...)");
            ((String)object).getChars(startIndex, endIndex, cArray, leftover);
            charBuffer.limit(copyLength + leftover);
            Object it = object = encoder.encode(charBuffer, byteBuffer, endIndex == text.length());
            boolean bl2 = false;
            if (!((CoderResult)it).isUnderflow()) {
                throw new IllegalStateException("Check failed.");
            }
            $this$writeTextImpl.write(byteBuffer.array(), 0, byteBuffer.position());
            if (charBuffer.position() != charBuffer.limit()) {
                charBuffer.put(0, charBuffer.get());
                leftover = 1;
            } else {
                leftover = 0;
            }
            charBuffer.clear();
            byteBuffer.clear();
            startIndex = endIndex;
        }
    }

    public static final CharsetEncoder newReplaceEncoder(@NotNull Charset $this$newReplaceEncoder) {
        Intrinsics.checkNotNullParameter($this$newReplaceEncoder, "<this>");
        return $this$newReplaceEncoder.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    @NotNull
    public static final ByteBuffer byteBufferForEncoding(int chunkSize, @NotNull CharsetEncoder encoder) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int maxBytesPerChar = (int)Math.ceil(encoder.maxBytesPerChar());
        ByteBuffer byteBuffer = ByteBuffer.allocate(chunkSize * maxBytesPerChar);
        Intrinsics.checkNotNullExpressionValue(byteBuffer, "allocate(...)");
        return byteBuffer;
    }

    public static final void forEachBlock(@NotNull File $this$forEachBlock, @NotNull Function2<? super byte[], ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter($this$forEachBlock, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        FilesKt.forEachBlock($this$forEachBlock, 4096, action);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void forEachBlock(@NotNull File $this$forEachBlock, int blockSize, @NotNull Function2<? super byte[], ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter($this$forEachBlock, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        byte[] arr2 = new byte[RangesKt.coerceAtLeast(blockSize, 512)];
        Closeable closeable = new FileInputStream($this$forEachBlock);
        Throwable throwable = null;
        try {
            int size;
            FileInputStream input = (FileInputStream)closeable;
            boolean bl2 = false;
            while ((size = input.read(arr2)) > 0) {
                action.invoke((byte[])arr2, (Integer)size);
            }
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally(closeable, throwable);
        }
    }

    public static final void forEachLine(@NotNull File $this$forEachLine, @NotNull Charset charset, @NotNull Function1<? super String, Unit> action) {
        Intrinsics.checkNotNullParameter($this$forEachLine, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(action, "action");
        TextStreamsKt.forEachLine(new BufferedReader(new InputStreamReader((InputStream)new FileInputStream($this$forEachLine), charset)), action);
    }

    public static /* synthetic */ void forEachLine$default(File file, Charset charset, Function1 function1, int n2, Object object) {
        if ((n2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.forEachLine(file, charset, function1);
    }

    @InlineOnly
    private static final FileInputStream inputStream(File $this$inputStream) {
        Intrinsics.checkNotNullParameter($this$inputStream, "<this>");
        return new FileInputStream($this$inputStream);
    }

    @InlineOnly
    private static final FileOutputStream outputStream(File $this$outputStream) {
        Intrinsics.checkNotNullParameter($this$outputStream, "<this>");
        return new FileOutputStream($this$outputStream);
    }

    @NotNull
    public static final List<String> readLines(@NotNull File $this$readLines, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter($this$readLines, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        ArrayList result = new ArrayList();
        FilesKt.forEachLine($this$readLines, charset, arg_0 -> FilesKt__FileReadWriteKt.readLines$lambda$9$FilesKt__FileReadWriteKt(result, arg_0));
        return result;
    }

    public static /* synthetic */ List readLines$default(File file, Charset charset, int n2, Object object) {
        if ((n2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return FilesKt.readLines(file, charset);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final <T> T useLines(@NotNull File $this$useLines, @NotNull Charset charset, @NotNull Function1<? super Sequence<String>, ? extends T> block) {
        Intrinsics.checkNotNullParameter($this$useLines, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(block, "block");
        boolean $i$f$useLines = false;
        Object object = $this$useLines;
        int n2 = 8192;
        Object object2 = object;
        object2 = new InputStreamReader((InputStream)new FileInputStream((File)object2), charset);
        object = object2 instanceof BufferedReader ? (BufferedReader)object2 : new BufferedReader((Reader)object2, n2);
        Throwable throwable = null;
        try {
            BufferedReader it = (BufferedReader)object;
            boolean bl2 = false;
            object2 = block.invoke(TextStreamsKt.lineSequence(it));
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally((Closeable)object, throwable);
            InlineMarker.finallyEnd(1);
        }
        return (T)object2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static /* synthetic */ Object useLines$default(File $this$useLines_u24default, Charset charset, Function1 block, int n2, Object object) {
        if ((n2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$useLines_u24default, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(block, "block");
        boolean $i$f$useLines = false;
        object = $this$useLines_u24default;
        int n3 = 8192;
        Object object2 = object;
        object2 = new InputStreamReader((InputStream)new FileInputStream((File)object2), charset);
        object = object2 instanceof BufferedReader ? (BufferedReader)object2 : new BufferedReader((Reader)object2, n3);
        Throwable throwable = null;
        try {
            BufferedReader it = (BufferedReader)object;
            boolean bl2 = false;
            object2 = block.invoke(TextStreamsKt.lineSequence(it));
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally((Closeable)object, throwable);
            InlineMarker.finallyEnd(1);
        }
        return object2;
    }

    private static final Unit readLines$lambda$9$FilesKt__FileReadWriteKt(ArrayList $result, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $result.add(it);
        return Unit.INSTANCE;
    }
}

