/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.network.handle.compression;

import java.util.zip.Deflater;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.handler.codec.MessageToByteEncoder;
import net.darkmeow.irc.network.FriendBuffer;

public class NettyCompressionEncoder
extends MessageToByteEncoder<ByteBuf> {
    private final byte[] buffer = new byte[8192];
    private final Deflater deflater = new Deflater();
    private int threshold;

    public NettyCompressionEncoder(int thresholdIn) {
        this.threshold = thresholdIn;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) {
        int i2 = in.readableBytes();
        FriendBuffer buffer = new FriendBuffer(out);
        if (i2 < this.threshold) {
            buffer.writeVarInt(0);
            buffer.writeBytes(in);
        } else {
            byte[] rawData = new byte[i2];
            in.readBytes(rawData);
            buffer.writeVarInt(rawData.length);
            this.deflater.setInput(rawData, 0, i2);
            this.deflater.finish();
            while (!this.deflater.finished()) {
                int j2 = this.deflater.deflate(this.buffer);
                buffer.writeBytes(this.buffer, 0, j2);
            }
            this.deflater.reset();
        }
    }

    public void setCompressionThreshold(int thresholdIn) {
        this.threshold = thresholdIn;
    }
}

