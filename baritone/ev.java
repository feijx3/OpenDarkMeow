/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.utils.IPlayerContext;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ev {
    final IPlayerContext a;
    boolean a;

    ev(IPlayerContext iPlayerContext) {
        this.a = iPlayerContext;
    }

    public final void a() {
        if (this.a.player() != null && this.a) {
            if (!this.a.playerController().hasBrokenBlock()) {
                this.a.playerController().setHittingBlock(true);
            }
            this.a.playerController().resetBlockRemoving();
            this.a = false;
        }
    }
}

