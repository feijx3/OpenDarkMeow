/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.pathing.goals.Goal;
import baritone.api.process.ICustomGoalProcess;
import baritone.api.process.PathingCommand;
import baritone.api.process.PathingCommandType;
import baritone.dv;
import baritone.eu;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class du
extends eu
implements ICustomGoalProcess {
    private Goal a;
    private Goal b;
    private int a;

    public du(baritone.a a2) {
        super(a2);
    }

    @Override
    public final void setGoal(Goal goal) {
        this.a = goal;
        this.b = goal;
        if (((baritone.a)((Object)this.a)).getElytraProcess().isActive()) {
            ((baritone.a)((Object)this.a)).getElytraProcess().pathTo(goal);
        }
        if (this.a == baritone.du$a.a) {
            this.a = baritone.du$a.b;
        }
        if (this.a == baritone.du$a.d) {
            this.a = baritone.du$a.c;
        }
    }

    @Override
    public final void path() {
        this.a = baritone.du$a.c;
    }

    @Override
    public final Goal getGoal() {
        return this.a;
    }

    @Override
    public final Goal mostRecentGoal() {
        return this.b;
    }

    @Override
    public final boolean isActive() {
        return this.a != baritone.du$a.a;
    }

    @Override
    public final PathingCommand onTick(boolean bl2, boolean bl3) {
        switch (dv.a[this.a - 1]) {
            case 1: {
                return new PathingCommand(this.a, PathingCommandType.CANCEL_AND_SET_GOAL);
            }
            case 2: {
                PathingCommand pathingCommand = new PathingCommand(this.a, PathingCommandType.FORCE_REVALIDATE_GOAL_AND_PATH);
                this.a = baritone.du$a.d;
                return pathingCommand;
            }
            case 3: {
                if (bl2) {
                    this.onLostControl();
                    return new PathingCommand(this.a, PathingCommandType.CANCEL_AND_SET_GOAL);
                }
                if (this.a == null || this.a.isInGoal(this.a.playerFeet()) && this.a.isInGoal(((baritone.a)((Object)this.a)).a.a())) {
                    this.onLostControl();
                    if (((Boolean)baritone.a.a().disconnectOnArrival.value).booleanValue()) {
                        this.a.world().O();
                    }
                    if (((Boolean)baritone.a.a().notificationOnPathComplete.value).booleanValue()) {
                        this.logNotification("Pathing complete", false);
                    }
                    return new PathingCommand(this.a, PathingCommandType.CANCEL_AND_SET_GOAL);
                }
                return new PathingCommand(this.a, PathingCommandType.SET_GOAL_AND_PATH);
            }
        }
        throw new IllegalStateException();
    }

    @Override
    public final void onLostControl() {
        this.a = baritone.du$a.a;
        this.a = null;
    }

    @Override
    public final String displayName0() {
        return "Custom Goal " + this.a;
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    public static final class a
    extends Enum<a> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        private static final /* synthetic */ int[] a;

        public static int[] a() {
            return (int[])a.clone();
        }

        static {
            a = new int[]{1, 2, 3, 4};
        }
    }
}

