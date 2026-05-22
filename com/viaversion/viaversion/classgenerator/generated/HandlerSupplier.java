/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.handler.codec.MessageToMessageDecoder
 *  io.netty.handler.codec.MessageToMessageEncoder
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.classgenerator.generated;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.bukkit.handlers.BukkitDecodeHandler;
import com.viaversion.viaversion.bukkit.handlers.BukkitEncodeHandler;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={DefaultHandlerSupplier.class})
public interface HandlerSupplier {
    public MessageToMessageEncoder<ByteBuf> newEncodeHandler(UserConnection var1);

    public MessageToMessageDecoder<ByteBuf> newDecodeHandler(UserConnection var1);

    @NestHost(value=HandlerSupplier.class)
    public static final class DefaultHandlerSupplier
    implements HandlerSupplier {
        @Override
        public MessageToMessageEncoder<ByteBuf> newEncodeHandler(UserConnection connection) {
            return new BukkitEncodeHandler(connection);
        }

        @Override
        public MessageToMessageDecoder<ByteBuf> newDecodeHandler(UserConnection connection) {
            return new BukkitDecodeHandler(connection);
        }
    }
}

