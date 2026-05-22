/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.GameProfile;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public final class ProfilePropertyType
extends Type<GameProfile.Property> {
    public ProfilePropertyType() {
        super(GameProfile.Property.class);
    }

    @Override
    public GameProfile.Property read(ByteBuf buffer) {
        String name = (String)Types.STRING.read(buffer);
        String value = (String)Types.STRING.read(buffer);
        String signature = (String)Types.OPTIONAL_STRING.read(buffer);
        return new GameProfile.Property(name, value, signature);
    }

    @Override
    public void write(ByteBuf buffer, GameProfile.Property value) {
        Types.STRING.write(buffer, value.name());
        Types.STRING.write(buffer, value.value());
        Types.OPTIONAL_STRING.write(buffer, value.signature());
    }

    @Override
    public void write(Ops ops, GameProfile.Property value) {
        ops.writeMap(propertyMap -> propertyMap.write("name", Types.STRING, value.name()).write("value", Types.STRING, value.value()).writeOptional("signature", Types.STRING, value.signature()));
    }
}

