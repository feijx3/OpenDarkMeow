/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.storage;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ChunkPosition;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandBlockStorage
implements StorableObject {
    private final Map<Long, Map<BlockPosition, CompoundTag>> storedCommandBlocks = new HashMap<Long, Map<BlockPosition, CompoundTag>>();
    private boolean permissions;

    public void unloadChunk(int x2, int z2) {
        this.storedCommandBlocks.remove(ChunkPosition.chunkKey(x2, z2));
    }

    public void addOrUpdateBlock(BlockPosition position, CompoundTag tag) {
        long chunkKey = ChunkPosition.chunkKeyForBlock(position.x(), position.z());
        Map blocks = this.storedCommandBlocks.computeIfAbsent(chunkKey, k2 -> new HashMap());
        blocks.put(position, tag);
    }

    public Optional<CompoundTag> getCommandBlock(BlockPosition position) {
        Map<BlockPosition, CompoundTag> blocks = this.storedCommandBlocks.get(ChunkPosition.chunkKeyForBlock(position.x(), position.z()));
        if (blocks == null) {
            return Optional.empty();
        }
        CompoundTag tag = blocks.get(position);
        if (tag == null) {
            return Optional.empty();
        }
        tag = tag.copy();
        tag.put("powered", new ByteTag(0));
        tag.put("auto", new ByteTag(0));
        tag.put("conditionMet", new ByteTag(0));
        return Optional.of(tag);
    }

    public void unloadChunks() {
        this.storedCommandBlocks.clear();
    }

    public boolean isPermissions() {
        return this.permissions;
    }

    public void setPermissions(boolean permissions) {
        this.permissions = permissions;
    }
}

