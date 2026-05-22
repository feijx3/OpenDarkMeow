/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.network.handle.frame;

import java.util.List;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.Unpooled;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.handler.codec.ByteToMessageDecoder;
import net.darkmeow.irc.lib.io.netty.handler.codec.CorruptedFrameException;
import net.darkmeow.irc.network.FriendBuffer;

public class NettyVarInt21FrameDecoder
extends ByteToMessageDecoder {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        in.markReaderIndex();
        byte[] headerBytes = new byte[3];
        for (int i2 = 0; i2 < headerBytes.length; ++i2) {
            if (!in.isReadable()) {
                in.resetReaderIndex();
                return;
            }
            headerBytes[i2] = in.readByte();
            if (headerBytes[i2] < 0) continue;
            FriendBuffer buffer = new FriendBuffer(Unpooled.wrappedBuffer(headerBytes));
            try {
                int length = buffer.readVarInt();
                if (in.readableBytes() >= length) {
                    out.add(in.readBytes(length));
                    return;
                }
                in.resetReaderIndex();
            }
            finally {
                buffer.release();
            }
            return;
        }
        throw new CorruptedFrameException("Frame length exceeds 21-bit range.");
    }
}

