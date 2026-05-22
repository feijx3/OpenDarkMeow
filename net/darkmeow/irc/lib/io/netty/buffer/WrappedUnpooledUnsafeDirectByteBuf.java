/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.buffer;

import java.nio.ByteBuffer;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufAllocator;
import net.darkmeow.irc.lib.io.netty.buffer.UnpooledUnsafeDirectByteBuf;
import net.darkmeow.irc.lib.io.netty.util.internal.PlatformDependent;

final class WrappedUnpooledUnsafeDirectByteBuf
extends UnpooledUnsafeDirectByteBuf {
    WrappedUnpooledUnsafeDirectByteBuf(ByteBufAllocator alloc, long memoryAddress, int size, boolean doFree) {
        super(alloc, PlatformDependent.directBuffer(memoryAddress, size), size, doFree);
    }

    @Override
    protected void freeDirect(ByteBuffer buffer) {
        PlatformDependent.freeMemory(this.memoryAddress);
    }
}

