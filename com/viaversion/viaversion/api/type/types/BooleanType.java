/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.TypeConverter;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={OptionalBooleanType.class})
public class BooleanType
extends Type<Boolean>
implements TypeConverter<Boolean> {
    public BooleanType() {
        super(Boolean.class);
    }

    @Override
    public Boolean read(ByteBuf buffer) {
        return buffer.readBoolean();
    }

    @Override
    public void write(ByteBuf buffer, Boolean object) {
        buffer.writeBoolean(object.booleanValue());
    }

    @Override
    public Boolean from(Object o2) {
        if (o2 instanceof Number) {
            Number number = (Number)o2;
            return number.intValue() == 1;
        }
        return (Boolean)o2;
    }

    @Override
    public void write(Ops ops, Boolean value) {
        ops.writeBoolean(value);
    }

    @NestHost(value=BooleanType.class)
    public static final class OptionalBooleanType
    extends OptionalType<Boolean> {
        public OptionalBooleanType() {
            super(Types.BOOLEAN);
        }
    }
}

