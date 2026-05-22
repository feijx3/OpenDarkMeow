/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.PacketBuffer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import net.minecraft.network.PacketBuffer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/utils/HytPacketUtils;", "", "<init>", "()V", "decodePacketByte", "", "buffer", "Lnet/minecraft/network/PacketBuffer;", "encodePacketByte", "", "json", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nHytPacketUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HytPacketUtils.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/utils/HytPacketUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,39:1\n1#2:40\n*E\n"})
public final class HytPacketUtils {
    @NotNull
    public static final HytPacketUtils INSTANCE = new HytPacketUtils();

    private HytPacketUtils() {
    }

    @NotNull
    public final String decodePacketByte(@NotNull PacketBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        byte[] byArray = new byte[buffer.readableBytes()];
        buffer.readBytes(byArray);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(byArray));
            byte[] array = new byte[256];
            int read = 0;
            while (true) {
                int n2;
                int it = n2 = gzipInputStream.read(array);
                boolean bl2 = false;
                read = it;
                if (n2 < 0) break;
                byteArrayOutputStream.write(array, 0, read);
            }
            String string = byteArrayOutputStream.toString(Charsets.UTF_8.name());
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        catch (Throwable throwable) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            stream.write(byArray);
            String string = stream.toString(Charsets.UTF_8.name());
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    @NotNull
    public final byte[] encodePacketByte(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        String string = json;
        String string2 = Charsets.UTF_8.name();
        Intrinsics.checkNotNullExpressionValue(string2, "name(...)");
        Charset charset = Charset.forName(string2);
        Intrinsics.checkNotNullExpressionValue(charset, "forName(...)");
        Charset charset2 = charset;
        byte[] byArray = string.getBytes(charset2);
        Intrinsics.checkNotNullExpressionValue(byArray, "getBytes(...)");
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byArray);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        GZIPOutputStream out = new GZIPOutputStream(bout);
        byte[] array = new byte[256];
        int read = 0;
        while (true) {
            int n2;
            int it = n2 = arrayInputStream.read(array);
            boolean bl2 = false;
            read = it;
            if (n2 < 0) break;
            out.write(array, 0, read);
        }
        out.close();
        out.finish();
        byte[] byArray2 = bout.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byArray2, "toByteArray(...)");
        return byArray2;
    }
}

