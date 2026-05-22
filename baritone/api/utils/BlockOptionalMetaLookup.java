/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aip
 *  aow
 *  awt
 *  com.google.common.collect.ImmutableSet
 */
package baritone.api.utils;

import baritone.api.utils.BlockOptionalMeta;
import baritone.api.utils.accessor.IItemStack;
import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class BlockOptionalMetaLookup {
    private final ImmutableSet<aow> blockSet;
    private final ImmutableSet<awt> blockStateSet;
    private final ImmutableSet<Integer> stackHashes;
    private final BlockOptionalMeta[] boms;

    public BlockOptionalMetaLookup(BlockOptionalMeta ... blockOptionalMetaArray) {
        this.boms = blockOptionalMetaArray;
        HashSet<aow> hashSet = new HashSet<aow>();
        HashSet<awt> hashSet2 = new HashSet<awt>();
        HashSet<Integer> hashSet3 = new HashSet<Integer>();
        for (BlockOptionalMeta blockOptionalMeta : blockOptionalMetaArray) {
            hashSet.add(blockOptionalMeta.getBlock());
            hashSet2.addAll(blockOptionalMeta.getAllBlockStates());
            hashSet3.addAll(blockOptionalMeta.stackHashes());
        }
        this.blockSet = ImmutableSet.copyOf(hashSet);
        this.blockStateSet = ImmutableSet.copyOf(hashSet2);
        this.stackHashes = ImmutableSet.copyOf(hashSet3);
    }

    public BlockOptionalMetaLookup(aow ... aowArray) {
        this((BlockOptionalMeta[])Stream.of(aowArray).map(BlockOptionalMeta::new).toArray(BlockOptionalMeta[]::new));
    }

    public BlockOptionalMetaLookup(List<aow> list) {
        this((BlockOptionalMeta[])list.stream().map(BlockOptionalMeta::new).toArray(BlockOptionalMeta[]::new));
    }

    public BlockOptionalMetaLookup(String ... stringArray) {
        this((BlockOptionalMeta[])Stream.of(stringArray).map(BlockOptionalMeta::new).toArray(BlockOptionalMeta[]::new));
    }

    public boolean has(aow aow2) {
        return this.blockSet.contains((Object)aow2);
    }

    public boolean has(awt awt2) {
        return this.blockStateSet.contains((Object)awt2);
    }

    public boolean has(aip aip2) {
        int n2 = ((IItemStack)aip2).getBaritoneHash();
        return this.stackHashes.contains((Object)n2) || this.stackHashes.contains((Object)(n2 - aip2.i()));
    }

    public List<BlockOptionalMeta> blocks() {
        return Arrays.asList(this.boms);
    }

    public String toString() {
        return String.format("BlockOptionalMetaLookup{%s}", Arrays.toString(this.boms));
    }
}

