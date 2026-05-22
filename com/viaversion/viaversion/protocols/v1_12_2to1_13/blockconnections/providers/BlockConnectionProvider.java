/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.providers;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.platform.providers.Provider;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.providers.UserBlockData;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class BlockConnectionProvider
implements Provider {
    public int getBlockData(UserConnection connection, int x2, int y2, int z2) {
        int oldId = this.getWorldBlockData(connection, x2, y2, z2);
        return Protocol1_12_2To1_13.MAPPINGS.getBlockMappings().getNewId(oldId);
    }

    public int getWorldBlockData(UserConnection connection, int x2, int y2, int z2) {
        return -1;
    }

    public void storeBlock(UserConnection connection, int x2, int y2, int z2, int blockState) {
    }

    public void removeBlock(UserConnection connection, int x2, int y2, int z2) {
    }

    public void clearStorage(UserConnection connection) {
    }

    public void modifiedBlock(UserConnection connection, BlockPosition position) {
    }

    public void unloadChunk(UserConnection connection, int x2, int z2) {
    }

    public void unloadChunkSection(UserConnection connection, int chunkX, int chunkY, int chunkZ) {
    }

    public boolean storesBlocks(UserConnection user, @Nullable BlockPosition position) {
        return false;
    }

    public UserBlockData forUser(UserConnection connection) {
        return (x2, y2, z2) -> this.getBlockData(connection, x2, y2, z2);
    }
}

