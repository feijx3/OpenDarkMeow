/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types.entitydata;

import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.type.types.entitydata.EntityDataTypeTemplate;
import io.netty.buffer.ByteBuf;

public abstract class OldEntityDataType
extends EntityDataTypeTemplate {
    private static final int END = 127;

    @Override
    public EntityData read(ByteBuf buffer) {
        byte index = buffer.readByte();
        if (index == 127) {
            return null;
        }
        EntityDataType type = this.getType((index & 0xE0) >> 5);
        return new EntityData(index & 0x1F, type, type.type().read(buffer));
    }

    protected abstract EntityDataType getType(int var1);

    @Override
    public void write(ByteBuf buffer, EntityData object) {
        if (object == null) {
            buffer.writeByte(127);
        } else {
            int index = (object.dataType().typeId() << 5 | object.id() & 0x1F) & 0xFF;
            buffer.writeByte(index);
            object.dataType().type().write(buffer, object.getValue());
        }
    }
}

