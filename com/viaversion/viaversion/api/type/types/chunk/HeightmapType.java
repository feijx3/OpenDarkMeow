/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types.chunk;

import com.viaversion.viaversion.api.minecraft.chunks.Heightmap;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public final class HeightmapType
extends Type<Heightmap> {
    public HeightmapType() {
        super(Heightmap.class);
    }

    @Override
    public Heightmap read(ByteBuf buffer) {
        int type = Types.VAR_INT.readPrimitive(buffer);
        long[] data = (long[])Types.LONG_ARRAY_PRIMITIVE.read(buffer);
        return new Heightmap(type, data);
    }

    @Override
    public void write(ByteBuf buffer, Heightmap value) {
        Types.VAR_INT.writePrimitive(buffer, value.type());
        Types.LONG_ARRAY_PRIMITIVE.write(buffer, value.data());
    }
}

