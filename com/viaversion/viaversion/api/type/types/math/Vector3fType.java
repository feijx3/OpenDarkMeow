/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types.math;

import com.viaversion.viaversion.api.minecraft.Vector3f;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;

public class Vector3fType
extends Type<Vector3f> {
    public Vector3fType() {
        super(Vector3f.class);
    }

    @Override
    public Vector3f read(ByteBuf buffer) {
        float x2 = buffer.readFloat();
        float y2 = buffer.readFloat();
        float z2 = buffer.readFloat();
        return new Vector3f(x2, y2, z2);
    }

    @Override
    public void write(ByteBuf buffer, Vector3f object) {
        buffer.writeFloat(object.x());
        buffer.writeFloat(object.y());
        buffer.writeFloat(object.z());
    }
}

