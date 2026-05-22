/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BackwardsBlockStorage
implements StorableObject {
    private static final IntSet WHITELIST;
    private final Map<BlockPosition, Integer> blocks = new ConcurrentHashMap<BlockPosition, Integer>();

    public void checkAndStore(BlockPosition position, int block) {
        if (!WHITELIST.contains(block)) {
            this.blocks.remove(position);
            return;
        }
        this.blocks.put(position, block);
    }

    public @Nullable Integer get(BlockPosition position) {
        return this.blocks.get(position);
    }

    public int remove(BlockPosition position) {
        return this.blocks.remove(position);
    }

    public void clear() {
        this.blocks.clear();
    }

    public Map<BlockPosition, Integer> getBlocks() {
        return this.blocks;
    }

    static {
        int i2;
        WHITELIST = new IntOpenHashSet(779);
        for (i2 = 5265; i2 <= 5286; ++i2) {
            WHITELIST.add(i2);
        }
        for (i2 = 0; i2 < 256; ++i2) {
            WHITELIST.add(748 + i2);
        }
        for (i2 = 6854; i2 <= 7173; ++i2) {
            WHITELIST.add(i2);
        }
        WHITELIST.add(1647);
        for (i2 = 5447; i2 <= 5566; ++i2) {
            WHITELIST.add(i2);
        }
        for (i2 = 1028; i2 <= 1039; ++i2) {
            WHITELIST.add(i2);
        }
        for (i2 = 1047; i2 <= 1082; ++i2) {
            WHITELIST.add(i2);
        }
        for (i2 = 1099; i2 <= 1110; ++i2) {
            WHITELIST.add(i2);
        }
    }
}

