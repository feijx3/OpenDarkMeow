/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  amn
 *  aow
 *  et
 */
package baritone.api.cache;

import baritone.api.utils.BlockOptionalMetaLookup;
import baritone.api.utils.IPlayerContext;
import java.util.List;

public interface IWorldScanner {
    public List<et> scanChunkRadius(IPlayerContext var1, BlockOptionalMetaLookup var2, int var3, int var4, int var5);

    default public List<et> scanChunkRadius(IPlayerContext iPlayerContext, List<aow> list, int n2, int n3, int n4) {
        return this.scanChunkRadius(iPlayerContext, new BlockOptionalMetaLookup(list.toArray(new aow[0])), n2, n3, n4);
    }

    public List<et> scanChunk(IPlayerContext var1, BlockOptionalMetaLookup var2, amn var3, int var4, int var5);

    default public List<et> scanChunk(IPlayerContext iPlayerContext, List<aow> list, amn amn2, int n2, int n3) {
        return this.scanChunk(iPlayerContext, new BlockOptionalMetaLookup(list), amn2, n2, n3);
    }

    public int repack(IPlayerContext var1);

    public int repack(IPlayerContext var1, int var2);
}

