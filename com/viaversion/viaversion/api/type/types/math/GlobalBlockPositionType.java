/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types.math;

import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.GlobalBlockPosition;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={OptionalGlobalPositionType.class})
public class GlobalBlockPositionType
extends Type<GlobalBlockPosition> {
    public GlobalBlockPositionType() {
        super(GlobalBlockPosition.class);
    }

    @Override
    public GlobalBlockPosition read(ByteBuf buffer) {
        String dimension = (String)Types.STRING.read(buffer);
        return ((BlockPosition)Types.BLOCK_POSITION1_14.read(buffer)).withDimension(dimension);
    }

    @Override
    public void write(ByteBuf buffer, GlobalBlockPosition object) {
        Types.STRING.write(buffer, object.dimension());
        Types.BLOCK_POSITION1_14.write(buffer, (BlockPosition)object);
    }

    @Override
    public void write(Ops ops, GlobalBlockPosition value) {
        ops.writeMap(map -> map.write("dimension", Types.RESOURCE_LOCATION, Key.of(value.dimension())).write("pos", Types.BLOCK_POSITION1_14, value));
    }

    @NestHost(value=GlobalBlockPositionType.class)
    public static final class OptionalGlobalPositionType
    extends OptionalType<GlobalBlockPosition> {
        public OptionalGlobalPositionType() {
            super(Types.GLOBAL_POSITION);
        }
    }
}

