/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  et
 */
package baritone.api.process;

import baritone.api.process.IBaritoneProcess;

public interface IFarmProcess
extends IBaritoneProcess {
    public void farm(int var1, et var2);

    default public void farm() {
        this.farm(0, null);
    }

    default public void farm(int n2) {
        this.farm(n2, null);
    }
}

