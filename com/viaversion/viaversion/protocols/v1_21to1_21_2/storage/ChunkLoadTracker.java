/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.ChunkPosition;
import java.util.HashSet;
import java.util.Set;

public class ChunkLoadTracker
implements StorableObject {
    private final Set<Long> loadedChunks = new HashSet<Long>();

    public void addChunk(int x2, int z2) {
        this.loadedChunks.add(ChunkPosition.chunkKey(x2, z2));
    }

    public void removeChunk(int x2, int z2) {
        this.loadedChunks.remove(ChunkPosition.chunkKey(x2, z2));
    }

    public boolean isChunkLoaded(int x2, int z2) {
        return this.loadedChunks.contains(ChunkPosition.chunkKey(x2, z2));
    }

    public void clear() {
        this.loadedChunks.clear();
    }
}

