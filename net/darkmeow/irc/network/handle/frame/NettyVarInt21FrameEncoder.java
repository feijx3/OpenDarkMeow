/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.network.handle.frame;

import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.handler.codec.MessageToByteEncoder;
import net.darkmeow.irc.network.FriendBuffer;

public class NettyVarInt21FrameEncoder
extends MessageToByteEncoder<ByteBuf> {
    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) {
        int readableBytes = in.readableBytes();
        int varIntSize = FriendBuffer.getVarIntSize(readableBytes);
        if (varIntSize > 3) {
            throw new IllegalArgumentException("Unable to fit " + readableBytes + " bytes into " + 3);
        }
        FriendBuffer buffer = new FriendBuffer(out);
        buffer.ensureWritable(varIntSize + readableBytes);
        buffer.writeVarInt(readableBytes);
        buffer.writeBytes(in, in.readerIndex(), readableBytes);
    }
}

