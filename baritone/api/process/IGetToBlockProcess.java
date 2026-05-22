/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aow
 */
package baritone.api.process;

import baritone.api.process.IBaritoneProcess;
import baritone.api.utils.BlockOptionalMeta;

public interface IGetToBlockProcess
extends IBaritoneProcess {
    public void getToBlock(BlockOptionalMeta var1);

    default public void getToBlock(aow aow2) {
        this.getToBlock(new BlockOptionalMeta(aow2));
    }

    public boolean blacklistClosest();
}

