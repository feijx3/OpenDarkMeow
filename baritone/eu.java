/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.a;
import baritone.api.process.IBaritoneProcess;
import baritone.api.utils.Helper;
import baritone.api.utils.IPlayerContext;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class eu
implements IBaritoneProcess,
Helper {
    public final a a;
    protected final IPlayerContext a;

    public eu(a a2) {
        this.a = a2;
        this.a = a2.getPlayerContext();
    }

    @Override
    public boolean isTemporary() {
        return false;
    }
}

