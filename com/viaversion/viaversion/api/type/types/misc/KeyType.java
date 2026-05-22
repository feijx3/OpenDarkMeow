/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={OptionalKeyType.class})
public class KeyType
extends Type<Key> {
    public KeyType() {
        super(Key.class);
    }

    @Override
    public Key read(ByteBuf buffer) {
        String identifier = (String)Types.STRING.read(buffer);
        return Key.of(identifier);
    }

    @Override
    public void write(ByteBuf buffer, Key key) {
        Types.STRING.write(buffer, key.original());
    }

    @Override
    public void write(Ops ops, Key value) {
        Types.STRING.write(ops, value.toString());
    }

    @NestHost(value=KeyType.class)
    public static final class OptionalKeyType
    extends OptionalType<Key> {
        public OptionalKeyType() {
            super(Types.RESOURCE_LOCATION);
        }
    }
}

