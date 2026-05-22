/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aow
 */
package baritone.api.process;

import baritone.api.process.IBaritoneProcess;
import baritone.api.utils.BlockOptionalMeta;
import baritone.api.utils.BlockOptionalMetaLookup;
import java.util.stream.Stream;

public interface IMineProcess
extends IBaritoneProcess {
    public void mineByName(int var1, String ... var2);

    public void mine(int var1, BlockOptionalMetaLookup var2);

    default public void mine(BlockOptionalMetaLookup blockOptionalMetaLookup) {
        this.mine(0, blockOptionalMetaLookup);
    }

    default public void mineByName(String ... stringArray) {
        this.mineByName(0, stringArray);
    }

    default public void mine(int n2, BlockOptionalMeta ... blockOptionalMetaArray) {
        this.mine(n2, new BlockOptionalMetaLookup(blockOptionalMetaArray));
    }

    default public void mine(BlockOptionalMeta ... blockOptionalMetaArray) {
        this.mine(0, blockOptionalMetaArray);
    }

    default public void mine(int n2, aow ... aowArray) {
        this.mine(n2, new BlockOptionalMetaLookup((BlockOptionalMeta[])Stream.of(aowArray).map(BlockOptionalMeta::new).toArray(BlockOptionalMeta[]::new)));
    }

    default public void mine(aow ... aowArray) {
        this.mine(0, aowArray);
    }

    default public void cancel() {
        this.onLostControl();
    }
}

