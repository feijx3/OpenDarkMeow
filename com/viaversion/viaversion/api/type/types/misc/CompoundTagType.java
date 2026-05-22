/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.NamedCompoundTagType;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.util.Map;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={OptionalCompoundTagType.class})
public class CompoundTagType
extends Type<CompoundTag> {
    public CompoundTagType() {
        super(CompoundTag.class);
    }

    @Override
    public CompoundTag read(ByteBuf buffer) {
        try {
            return NamedCompoundTagType.read(buffer, false);
        }
        catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override
    public void write(ByteBuf buffer, CompoundTag object) {
        try {
            NamedCompoundTagType.write(buffer, object, null);
        }
        catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override
    public void write(Ops ops, CompoundTag value) {
        ops.writeMap(map -> {
            for (Map.Entry<String, Tag> entry : value.entrySet()) {
                map.write(entry.getKey(), Types.TAG, entry.getValue());
            }
        });
    }

    @NestHost(value=CompoundTagType.class)
    public static final class OptionalCompoundTagType
    extends OptionalType<CompoundTag> {
        public OptionalCompoundTagType() {
            super(Types.COMPOUND_TAG);
        }
    }
}

