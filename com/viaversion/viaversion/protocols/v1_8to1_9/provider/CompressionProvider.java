/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.ChannelPipeline
 *  io.netty.handler.codec.DecoderException
 *  io.netty.handler.codec.MessageToByteEncoder
 *  io.netty.handler.codec.MessageToMessageDecoder
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.provider;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.platform.providers.Provider;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={Compressor.class, Decompressor.class, CompressionHandler.class})
public class CompressionProvider
implements Provider {
    public void handlePlayCompression(UserConnection user, int threshold) {
        if (!user.isClientSide()) {
            throw new IllegalStateException("PLAY state Compression packet is unsupported");
        }
        ChannelPipeline pipe = user.getChannel().pipeline();
        if (threshold < 0) {
            if (pipe.get("compress") != null) {
                pipe.remove("compress");
                pipe.remove("decompress");
            }
        } else if (pipe.get("compress") == null) {
            pipe.addBefore(Via.getManager().getInjector().getEncoderName(), "compress", (ChannelHandler)this.getEncoder(threshold));
            pipe.addBefore(Via.getManager().getInjector().getDecoderName(), "decompress", (ChannelHandler)this.getDecoder(threshold));
        } else {
            ((CompressionHandler)pipe.get("compress")).setCompressionThreshold(threshold);
            ((CompressionHandler)pipe.get("decompress")).setCompressionThreshold(threshold);
        }
    }

    protected CompressionHandler getEncoder(int threshold) {
        return new Compressor(threshold);
    }

    protected CompressionHandler getDecoder(int threshold) {
        return new Decompressor(threshold);
    }

    @NestHost(value=CompressionProvider.class)
    public static interface CompressionHandler
    extends ChannelHandler {
        public void setCompressionThreshold(int var1);
    }

    @NestHost(value=CompressionProvider.class)
    private static class Compressor
    extends MessageToByteEncoder<ByteBuf>
    implements CompressionHandler {
        private final Deflater deflater;
        private int threshold;

        public Compressor(int var1) {
            this.threshold = var1;
            this.deflater = new Deflater();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) throws Exception {
            int frameLength = in.readableBytes();
            if (frameLength < this.threshold) {
                out.writeByte(0);
                out.writeBytes(in);
                return;
            }
            Types.VAR_INT.writePrimitive(out, frameLength);
            ByteBuf temp = in;
            if (!in.hasArray()) {
                temp = ctx.alloc().heapBuffer().writeBytes(in);
            } else {
                in.retain();
            }
            ByteBuf output = ctx.alloc().heapBuffer();
            try {
                this.deflater.setInput(temp.array(), temp.arrayOffset() + temp.readerIndex(), temp.readableBytes());
                this.deflater.finish();
                while (!this.deflater.finished()) {
                    output.ensureWritable(4096);
                    output.writerIndex(output.writerIndex() + this.deflater.deflate(output.array(), output.arrayOffset() + output.writerIndex(), output.writableBytes()));
                }
                out.writeBytes(output);
            }
            finally {
                output.release();
                temp.release();
                this.deflater.reset();
            }
        }

        @Override
        public void setCompressionThreshold(int threshold) {
            this.threshold = threshold;
        }
    }

    @NestHost(value=CompressionProvider.class)
    private static class Decompressor
    extends MessageToMessageDecoder<ByteBuf>
    implements CompressionHandler {
        private final Inflater inflater;
        private int threshold;

        public Decompressor(int var1) {
            this.threshold = var1;
            this.inflater = new Inflater();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
            if (!in.isReadable()) {
                return;
            }
            int outLength = Types.VAR_INT.readPrimitive(in);
            if (outLength == 0) {
                out.add(in.readBytes(in.readableBytes()));
                return;
            }
            if (outLength < this.threshold) {
                throw new DecoderException(Decompressor.jvmdowngrader$concat$decode$1(outLength, this.threshold));
            }
            if (outLength > 0x200000) {
                throw new DecoderException(Decompressor.jvmdowngrader$concat$decode$1(outLength));
            }
            ByteBuf temp = in;
            if (!in.hasArray()) {
                temp = ctx.alloc().heapBuffer().writeBytes(in);
            } else {
                in.retain();
            }
            ByteBuf output = ctx.alloc().heapBuffer(outLength, outLength);
            try {
                this.inflater.setInput(temp.array(), temp.arrayOffset() + temp.readerIndex(), temp.readableBytes());
                output.writerIndex(output.writerIndex() + this.inflater.inflate(output.array(), output.arrayOffset(), outLength));
                out.add(output.retain());
            }
            finally {
                output.release();
                temp.release();
                this.inflater.reset();
            }
        }

        @Override
        public void setCompressionThreshold(int threshold) {
            this.threshold = threshold;
        }

        private static String jvmdowngrader$concat$decode$1(int n2, int n3) {
            return "Badly compressed packet - size of " + n2 + " is below server threshold of " + n3;
        }

        private static String jvmdowngrader$concat$decode$1(int n2) {
            return "Badly compressed packet - size of " + n2 + " is larger than protocol maximum of 2097152";
        }
    }
}

