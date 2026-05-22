/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.PlayerMessageSignature;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import java.util.UUID;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={OptionalPlayerMessageSignatureType.class})
public class PlayerMessageSignatureType
extends Type<PlayerMessageSignature> {
    public PlayerMessageSignatureType() {
        super(PlayerMessageSignature.class);
    }

    @Override
    public PlayerMessageSignature read(ByteBuf buffer) {
        return new PlayerMessageSignature((UUID)Types.UUID.read(buffer), (byte[])Types.BYTE_ARRAY_PRIMITIVE.read(buffer));
    }

    @Override
    public void write(ByteBuf buffer, PlayerMessageSignature value) {
        Types.UUID.write(buffer, value.uuid());
        Types.BYTE_ARRAY_PRIMITIVE.write(buffer, value.signatureBytes());
    }

    @NestHost(value=PlayerMessageSignatureType.class)
    public static final class OptionalPlayerMessageSignatureType
    extends OptionalType<PlayerMessageSignature> {
        public OptionalPlayerMessageSignatureType() {
            super(Types.PLAYER_MESSAGE_SIGNATURE);
        }
    }
}

