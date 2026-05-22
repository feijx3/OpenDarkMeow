/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types.math;

import com.viaversion.viaversion.api.minecraft.Vector;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class VectorType
extends Type<Vector> {
    public VectorType() {
        super(Vector.class);
    }

    @Override
    public Vector read(ByteBuf buffer) {
        int x2 = Types.INT.read(buffer);
        int y2 = Types.INT.read(buffer);
        int z2 = Types.INT.read(buffer);
        return new Vector(x2, y2, z2);
    }

    @Override
    public void write(ByteBuf buffer, Vector object) {
        Types.INT.write(buffer, (Integer)object.blockX());
        Types.INT.write(buffer, (Integer)object.blockY());
        Types.INT.write(buffer, (Integer)object.blockZ());
    }
}

