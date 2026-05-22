/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types.math;

import com.viaversion.viaversion.api.minecraft.EulerAngle;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class EulerAngleType
extends Type<EulerAngle> {
    public EulerAngleType() {
        super(EulerAngle.class);
    }

    @Override
    public EulerAngle read(ByteBuf buffer) {
        float x2 = Types.FLOAT.readPrimitive(buffer);
        float y2 = Types.FLOAT.readPrimitive(buffer);
        float z2 = Types.FLOAT.readPrimitive(buffer);
        return new EulerAngle(x2, y2, z2);
    }

    @Override
    public void write(ByteBuf buffer, EulerAngle object) {
        Types.FLOAT.writePrimitive(buffer, object.x());
        Types.FLOAT.writePrimitive(buffer, object.y());
        Types.FLOAT.writePrimitive(buffer, object.z());
    }
}

