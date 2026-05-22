/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  amn
 *  awt
 *  et
 */
package baritone.api.event.events;

import baritone.api.utils.Pair;
import java.util.List;

public final class BlockChangeEvent {
    private final amn chunk;
    private final List<Pair<et, awt>> blocks;

    public BlockChangeEvent(amn amn2, List<Pair<et, awt>> list) {
        this.chunk = amn2;
        this.blocks = list;
    }

    public final amn getChunkPos() {
        return this.chunk;
    }

    public final List<Pair<et, awt>> getBlocks() {
        return this.blocks;
    }
}

