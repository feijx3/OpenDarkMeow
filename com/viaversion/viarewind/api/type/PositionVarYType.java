/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viarewind.api.type;

import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import java.util.function.IntFunction;

public class PositionVarYType<T extends Number>
extends Type<BlockPosition> {
    private final Type<T> yType;
    private final IntFunction<T> toY;

    public PositionVarYType(Type<T> yType, IntFunction<T> toY) {
        super(BlockPosition.class);
        this.yType = yType;
        this.toY = toY;
    }

    @Override
    public BlockPosition read(ByteBuf buffer) {
        int x2 = buffer.readInt();
        int y2 = ((Number)this.yType.read(buffer)).intValue();
        int z2 = buffer.readInt();
        return new BlockPosition(x2, y2, z2);
    }

    @Override
    public void write(ByteBuf buffer, BlockPosition value) {
        buffer.writeInt(value.x());
        this.yType.write(buffer, (Number)this.toY.apply(value.y()));
        buffer.writeInt(value.z());
    }
}

