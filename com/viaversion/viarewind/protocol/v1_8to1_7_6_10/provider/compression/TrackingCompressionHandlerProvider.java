/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelPipeline
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider.compression;

import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viarewind.api.minecraft.netty.EmptyChannelHandler;
import com.viaversion.viarewind.api.minecraft.netty.ForwardMessageToByteEncoder;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider.CompressionHandlerProvider;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider.compression.CompressionDecoder;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider.compression.CompressionEncoder;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;

public class TrackingCompressionHandlerProvider
extends CompressionHandlerProvider {
    @Override
    public void onHandleLoginCompressionPacket(UserConnection user, int threshold) {
        ChannelPipeline pipeline = user.getChannel().pipeline();
        if (user.isClientSide()) {
            pipeline.addBefore(Via.getManager().getInjector().getEncoderName(), ViaRewind.getPlatform().compressHandlerName(), this.getEncoder(threshold));
            pipeline.addBefore(Via.getManager().getInjector().getDecoderName(), ViaRewind.getPlatform().decompressHandlerName(), this.getDecoder(threshold));
        } else {
            this.setCompressionEnabled(user, true);
        }
    }

    @Override
    public void onTransformPacket(UserConnection user) {
        if (this.isCompressionEnabled(user)) {
            ChannelPipeline pipeline = user.getChannel().pipeline();
            String compressor = null;
            String decompressor = null;
            if (pipeline.get(ViaRewind.getPlatform().compressHandlerName()) != null) {
                compressor = ViaRewind.getPlatform().compressHandlerName();
                decompressor = ViaRewind.getPlatform().decompressHandlerName();
            }
            if (compressor == null) {
                throw new IllegalStateException("Couldn't remove compression for 1.7!");
            }
            pipeline.replace(decompressor, decompressor, (ChannelHandler)new EmptyChannelHandler());
            pipeline.replace(compressor, compressor, (ChannelHandler)new ForwardMessageToByteEncoder());
            this.setCompressionEnabled(user, false);
        }
    }

    @Override
    public ChannelHandler getEncoder(int threshold) {
        return new CompressionEncoder(threshold);
    }

    @Override
    public ChannelHandler getDecoder(int threshold) {
        return new CompressionDecoder(threshold);
    }
}

