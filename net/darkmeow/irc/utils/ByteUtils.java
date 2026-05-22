/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.utils;

import java.util.function.Consumer;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.Unpooled;

public class ByteUtils {
    public static byte[] concatByteArrays(byte[] ... arrays) {
        return ByteUtils.buildByteArray(buffer -> {
            for (byte[] arr2 : arrays) {
                buffer.writeBytes(arr2);
            }
        });
    }

    public static byte[] buildByteArray(Consumer<ByteBuf> writer) {
        ByteBuf buffer = Unpooled.buffer();
        writer.accept(buffer);
        byte[] result = new byte[buffer.readableBytes()];
        buffer.readBytes(result);
        return result;
    }
}

