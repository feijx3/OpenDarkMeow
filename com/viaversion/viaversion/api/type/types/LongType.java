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

@NestMembers(value={OptionalLongType.class})
public class LongType
extends Type<Long>
implements TypeConverter<Long> {
    public LongType() {
        super(Long.class);
    }

    @Override
    @Deprecated
    public Long read(ByteBuf buffer) {
        return buffer.readLong();
    }

    @Override
    @Deprecated
    public void write(ByteBuf buffer, Long object) {
        buffer.writeLong(object.longValue());
    }

    @Override
    public void write(Ops ops, Long value) {
        ops.writeLong(value);
    }

    @Override
    public Long from(Object o2) {
        if (o2 instanceof Number) {
            Number number = (Number)o2;
            return number.longValue();
        }
        if (o2 instanceof Boolean) {
            Boolean boo = (Boolean)o2;
            return boo != false ? 1L : 0L;
        }
        throw new UnsupportedOperationException();
    }

    public long readPrimitive(ByteBuf buffer) {
        return buffer.readLong();
    }

    public void writePrimitive(ByteBuf buffer, long object) {
        buffer.writeLong(object);
    }

    @NestHost(value=LongType.class)
    public static final class OptionalLongType
    extends OptionalType<Long> {
        public OptionalLongType() {
            super(Types.LONG);
        }
    }
}

