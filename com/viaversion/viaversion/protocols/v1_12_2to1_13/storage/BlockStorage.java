/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import java.util.HashMap;
import java.util.Map;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={ReplacementData.class})
public class BlockStorage
implements StorableObject {
    private static final IntSet WHITELIST;
    private final Map<BlockPosition, ReplacementData> blocks = new HashMap<BlockPosition, ReplacementData>();

    public void store(BlockPosition position, int block) {
        this.store(position, block, -1);
    }

    public void store(BlockPosition position, int block, int replacementId) {
        if (!WHITELIST.contains(block)) {
            return;
        }
        this.blocks.put(position, new ReplacementData(block, replacementId));
    }

    public boolean isWelcome(int block) {
        return WHITELIST.contains(block);
    }

    public boolean contains(BlockPosition position) {
        return this.blocks.containsKey(position);
    }

    public ReplacementData get(BlockPosition position) {
        return this.blocks.get(position);
    }

    public ReplacementData remove(BlockPosition position) {
        return this.blocks.remove(position);
    }

    static {
        int i2;
        WHITELIST = new IntOpenHashSet(46);
        WHITELIST.add(5266);
        for (i2 = 0; i2 < 16; ++i2) {
            WHITELIST.add(972 + i2);
        }
        for (i2 = 0; i2 < 20; ++i2) {
            WHITELIST.add(6854 + i2);
        }
        for (i2 = 0; i2 < 4; ++i2) {
            WHITELIST.add(7110 + i2);
        }
        for (i2 = 0; i2 < 5; ++i2) {
            WHITELIST.add(5447 + i2);
        }
    }

    @NestHost(value=BlockStorage.class)
    public static final class ReplacementData {
        private final int original;
        private int replacement;

        public ReplacementData(int original, int replacement) {
            this.original = original;
            this.replacement = replacement;
        }

        public int getOriginal() {
            return this.original;
        }

        public int getReplacement() {
            return this.replacement;
        }

        public void setReplacement(int replacement) {
            this.replacement = replacement;
        }
    }
}

