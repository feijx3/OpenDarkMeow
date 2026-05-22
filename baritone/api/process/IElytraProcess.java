/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  et
 */
package baritone.api.process;

import baritone.api.pathing.goals.Goal;
import baritone.api.process.IBaritoneProcess;

public interface IElytraProcess
extends IBaritoneProcess {
    public void repackChunks();

    public et currentDestination();

    public void pathTo(et var1);

    public void pathTo(Goal var1);

    public void resetState();

    public boolean isLoaded();

    public boolean isSafeToCancel();
}

