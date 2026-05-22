/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={OptionalHolderSetType.class})
public class HolderSetType
extends Type<HolderSet> {
    public HolderSetType() {
        super(HolderSet.class);
    }

    @Override
    public HolderSet read(ByteBuf buffer) {
        int size = Types.VAR_INT.readPrimitive(buffer) - 1;
        if (size == -1) {
            String tag = (String)Types.STRING.read(buffer);
            return HolderSet.of(tag);
        }
        int[] values = new int[size];
        for (int i2 = 0; i2 < size; ++i2) {
            values[i2] = Types.VAR_INT.readPrimitive(buffer);
        }
        return HolderSet.of(values);
    }

    @Override
    public void write(ByteBuf buffer, HolderSet object) {
        if (object.hasTagKey()) {
            Types.VAR_INT.writePrimitive(buffer, 0);
            Types.STRING.write(buffer, object.tagKey());
        } else {
            int[] values = object.ids();
            Types.VAR_INT.writePrimitive(buffer, values.length + 1);
            for (int value : values) {
                Types.VAR_INT.writePrimitive(buffer, value);
            }
        }
    }

    @NestHost(value=HolderSetType.class)
    public static final class OptionalHolderSetType
    extends OptionalType<HolderSet> {
        public OptionalHolderSetType() {
            super(Types.HOLDER_SET);
        }
    }
}

