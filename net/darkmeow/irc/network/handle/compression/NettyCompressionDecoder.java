/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.network.handle.compression;

import java.util.List;
import java.util.zip.Inflater;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.Unpooled;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.handler.codec.ByteToMessageDecoder;
import net.darkmeow.irc.lib.io.netty.handler.codec.DecoderException;
import net.darkmeow.irc.network.FriendBuffer;

public class NettyCompressionDecoder
extends ByteToMessageDecoder {
    private final Inflater inflater = new Inflater();
    private int threshold;

    public NettyCompressionDecoder(int thresholdIn) {
        this.threshold = thresholdIn;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() != 0) {
            FriendBuffer buffer = new FriendBuffer(in);
            int i2 = buffer.readVarInt();
            if (i2 == 0) {
                out.add(buffer.readBytes(buffer.readableBytes()));
            } else {
                if (i2 < this.threshold) {
                    throw new DecoderException("Badly compressed packet - size of " + i2 + " is below server threshold of " + this.threshold);
                }
                byte[] compressedData = new byte[buffer.readableBytes()];
                buffer.readBytes(compressedData);
                this.inflater.setInput(compressedData);
                byte[] uncompressedData = new byte[i2];
                this.inflater.inflate(uncompressedData);
                out.add(Unpooled.wrappedBuffer(uncompressedData));
                this.inflater.reset();
            }
        }
    }

    public void setCompressionThreshold(int thresholdIn) {
        this.threshold = thresholdIn;
    }
}

