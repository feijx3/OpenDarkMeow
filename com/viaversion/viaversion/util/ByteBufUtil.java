/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.ByteBufAllocator
 */
package com.viaversion.viaversion.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public final class ByteBufUtil {
    public static ByteBuf copy(ByteBufAllocator allocator, ByteBuf from) {
        int bytes = from.readableBytes();
        return allocator.buffer(bytes).writeBytes(from, bytes);
    }
}

