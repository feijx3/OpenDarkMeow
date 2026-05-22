/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.a;
import baritone.api.process.PathingCommand;
import baritone.api.process.PathingCommandType;
import baritone.eu;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class eg
extends eu {
    private boolean a;
    private boolean b;
    private int a;

    public eg(a a2) {
        super(a2);
    }

    @Override
    public final boolean isActive() {
        return this.a.player() != null && this.a.world() != null;
    }

    public final boolean a() {
        this.a = true;
        return this.b && this.a > 1;
    }

    @Override
    public final PathingCommand onTick(boolean bl2, boolean bl3) {
        this.b = bl3;
        if (this.a) {
            eg eg2;
            this.a = false;
            eg eg3 = this;
            if (Math.sqrt(eg2.a.player().s * eg3.a.player().s + eg3.a.player().u * eg3.a.player().u) < 1.0E-5) {
                ++this.a;
            }
            return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
        }
        this.a = 0;
        return new PathingCommand(null, PathingCommandType.DEFER);
    }

    @Override
    public final void onLostControl() {
    }

    @Override
    public final String displayName0() {
        return "inventory pauser";
    }

    @Override
    public final double priority() {
        return 5.1;
    }

    @Override
    public final boolean isTemporary() {
        return true;
    }
}

