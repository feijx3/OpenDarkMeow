/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types.math;

import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={OptionalBlockPositionType.class})
public class BlockPositionType1_8
extends Type<BlockPosition> {
    public BlockPositionType1_8() {
        super(BlockPosition.class);
    }

    @Override
    public BlockPosition read(ByteBuf buffer) {
        long val = buffer.readLong();
        long x2 = val >> 38;
        long y2 = val << 26 >> 52;
        long z2 = val << 38 >> 38;
        return new BlockPosition((int)x2, (short)y2, (int)z2);
    }

    @Override
    public void write(ByteBuf buffer, BlockPosition object) {
        buffer.writeLong(((long)object.x() & 0x3FFFFFFL) << 38 | ((long)object.y() & 0xFFFL) << 26 | (long)object.z() & 0x3FFFFFFL);
    }

    @NestHost(value=BlockPositionType1_8.class)
    public static final class OptionalBlockPositionType
    extends OptionalType<BlockPosition> {
        public OptionalBlockPositionType() {
            super(Types.BLOCK_POSITION1_8);
        }
    }
}

