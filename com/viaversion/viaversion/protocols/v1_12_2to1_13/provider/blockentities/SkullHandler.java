/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.blockentities;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.BlockEntityProvider;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.storage.BlockStorage;

public class SkullHandler
implements BlockEntityProvider.BlockEntityHandler {
    private static final int SKULL_WALL_START = 5447;
    private static final int SKULL_END = 5566;

    @Override
    public int transform(UserConnection user, CompoundTag tag) {
        BlockPosition position;
        BlockStorage storage = user.get(BlockStorage.class);
        if (!storage.contains(position = new BlockPosition(tag.getNumberTag("x").asInt(), tag.getNumberTag("y").asShort(), tag.getNumberTag("z").asInt()))) {
            Protocol1_12_2To1_13.LOGGER.warning(SkullHandler.jvmdowngrader$concat$transform$1(String.valueOf(tag)));
            return -1;
        }
        int id = storage.get(position).getOriginal();
        if (id >= 5447 && id <= 5566) {
            NumberTag rot;
            NumberTag skullType = tag.getNumberTag("SkullType");
            if (skullType != null) {
                id += skullType.asInt() * 20;
            }
            if ((rot = tag.getNumberTag("Rot")) != null) {
                id += rot.asInt();
            }
        } else {
            Protocol1_12_2To1_13.LOGGER.warning(SkullHandler.jvmdowngrader$concat$transform$2(String.valueOf(tag)));
            return -1;
        }
        return id;
    }

    private static String jvmdowngrader$concat$transform$1(String string) {
        return "Received an head update packet, but there is no head! O_o " + string;
    }

    private static String jvmdowngrader$concat$transform$2(String string) {
        return "Why does this block have the skull block entity? " + string;
    }
}

