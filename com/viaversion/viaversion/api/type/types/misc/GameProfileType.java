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
import java.util.UUID;

public final class GameProfileType
extends Type<GameProfile> {
    public GameProfileType() {
        super(GameProfile.class);
    }

    @Override
    public GameProfile read(ByteBuf buffer) {
        String name = (String)Types.OPTIONAL_STRING.read(buffer);
        UUID id = (UUID)Types.OPTIONAL_UUID.read(buffer);
        GameProfile.Property[] properties = (GameProfile.Property[])Types.PROFILE_PROPERTY_ARRAY.read(buffer);
        return new GameProfile(name, id, properties);
    }

    @Override
    public void write(ByteBuf buffer, GameProfile value) {
        Types.OPTIONAL_STRING.write(buffer, value.name());
        Types.OPTIONAL_UUID.write(buffer, value.id());
        Types.PROFILE_PROPERTY_ARRAY.write(buffer, value.properties());
    }

    @Override
    public void write(Ops ops, GameProfile value) {
        ops.writeMap(map -> map.writeOptional("name", Types.STRING, value.name()).writeOptional("id", Types.STRING, value.id() != null ? value.id().toString() : null).write("properties", Types.PROFILE_PROPERTY_ARRAY, value.properties()));
    }
}

