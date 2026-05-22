/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  et
 *  vg
 */
package baritone;

import baritone.a;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalComposite;
import baritone.api.pathing.goals.GoalNear;
import baritone.api.pathing.goals.GoalXZ;
import baritone.api.process.IFollowProcess;
import baritone.api.process.PathingCommand;
import baritone.api.process.PathingCommandType;
import baritone.eu;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ed
extends eu
implements IFollowProcess {
    private Predicate<vg> a;
    private List<vg> a;

    public ed(a a2) {
        super(a2);
    }

    @Override
    public final PathingCommand onTick(boolean bl2, boolean bl3) {
        this.a();
        GoalComposite goalComposite = new GoalComposite((Goal[])this.a.stream().map(this::a).toArray(Goal[]::new));
        return new PathingCommand(goalComposite, PathingCommandType.REVALIDATE_GOAL_AND_PATH);
    }

    private Goal a(vg vg2) {
        if ((Double)baritone.a.a().followOffsetDistance.value == 0.0) {
            vg2 = new et(vg2);
        } else {
            GoalXZ goalXZ = GoalXZ.fromDirection(vg2.d(), ((Float)baritone.a.a().followOffsetDirection.value).floatValue(), (Double)baritone.a.a().followOffsetDistance.value);
            vg2 = new et((double)goalXZ.getX(), vg2.q, (double)goalXZ.getZ());
        }
        return new GoalNear((et)vg2, (Integer)baritone.a.a().followRadius.value);
    }

    private boolean a(vg vg2) {
        if (vg2 == null) {
            return false;
        }
        if (vg2.F) {
            return false;
        }
        if (vg2.equals((Object)this.a.player())) {
            return false;
        }
        return this.a.world().e.contains(vg2);
    }

    private void a() {
        this.a = Stream.of(this.a.world().e, this.a.world().i).flatMap(Collection::stream).filter(this::a).filter(this.a).distinct().collect(Collectors.toList());
    }

    @Override
    public final boolean isActive() {
        if (this.a == null) {
            return false;
        }
        this.a();
        return !this.a.isEmpty();
    }

    @Override
    public final void onLostControl() {
        this.a = null;
        this.a = null;
    }

    @Override
    public final String displayName0() {
        return "Following " + this.a;
    }

    @Override
    public final void follow(Predicate<vg> predicate) {
        this.a = predicate;
    }

    @Override
    public final List<vg> following() {
        return this.a;
    }

    @Override
    public final Predicate<vg> currentFilter() {
        return this.a;
    }
}

