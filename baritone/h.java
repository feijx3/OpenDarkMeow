/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aru
 *  et
 */
package baritone;

import baritone.a;
import baritone.api.IBaritone;
import baritone.api.behavior.IPathingBehavior;
import baritone.api.event.events.PathEvent;
import baritone.api.event.events.PlayerUpdateEvent;
import baritone.api.event.events.RenderEvent;
import baritone.api.event.events.SprintStateEvent;
import baritone.api.event.events.TickEvent;
import baritone.api.pathing.calc.IPath;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalXZ;
import baritone.api.process.PathingCommand;
import baritone.api.process.PathingCommandType;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Helper;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.PathCalculationResult;
import baritone.api.utils.interfaces.IGoalRenderPos;
import baritone.bv;
import baritone.bw;
import baritone.bz;
import baritone.c;
import baritone.cb;
import baritone.dk;
import baritone.fc;
import baritone.fd;
import baritone.fe;
import baritone.fv;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class h
extends c
implements IPathingBehavior,
Helper {
    public dk a;
    public dk b;
    private Goal a;
    public bz a;
    private int a;
    private BetterBlockPos a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    public boolean a;
    private volatile bw a;
    private final Object a;
    private final Object b;
    private boolean g;
    private BetterBlockPos b;
    private final LinkedBlockingQueue<PathEvent> a = new Object();

    public h(a a2) {
        super(a2);
        this.b = new Object();
        this.a = new LinkedBlockingQueue();
    }

    private void a(PathEvent pathEvent) {
        ((AbstractQueue)((Object)this.a)).add(pathEvent);
    }

    private void c() {
        Object object = new ArrayList();
        ((LinkedBlockingQueue)((Object)this.a)).drainTo(object);
        this.a = ((ArrayList)object).contains((Object)PathEvent.CALC_FAILED);
        object = ((ArrayList)object).iterator();
        while (object.hasNext()) {
            PathEvent pathEvent = (PathEvent)((Object)object.next());
            ((a)((Object)this.a)).getGameEventHandler().onPathEvent(pathEvent);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void onTick(TickEvent object) {
        block50: {
            this.c();
            if (((TickEvent)object).getType() == TickEvent.Type.OUT) {
                this.b();
                ((a)((Object)this.a)).a.a();
                return;
            }
            this.b = this.a();
            object = ((a)((Object)this.a)).a;
            ((fe)object).a = ((fe)object).b;
            ((fe)object).b = null;
            Object object2 = ((fe)object).a.a;
            ((fe)object).a = ((fe)object).a();
            if (((fe)object).a == null) {
                ((h)object2).b();
                ((h)object2).a = null;
            } else {
                if (!Objects.equals(((fe)object).b, ((fe)object).a) && ((fe)object).a.commandType != PathingCommandType.REQUEST_PAUSE && ((fe)object).a != null && !((fe)object).a.isTemporary()) {
                    ((h)object2).b();
                }
                switch (((fe)object).a.commandType) {
                    case SET_GOAL_AND_PAUSE: {
                        ((h)object2).a(((fe)object).a);
                    }
                    case REQUEST_PAUSE: {
                        ((h)object2).c = true;
                        break;
                    }
                    case CANCEL_AND_SET_GOAL: {
                        ((h)object2).a = ((fe)object).a.goal;
                        ((h)object2).b();
                        break;
                    }
                    case FORCE_REVALIDATE_GOAL_AND_PATH: 
                    case REVALIDATE_GOAL_AND_PATH: {
                        if (((h)object2).isPathing() || ((h)object2).getInProgress().isPresent()) break;
                        ((h)object2).a(((fe)object).a);
                        break;
                    }
                    case SET_GOAL_AND_PATH: {
                        if (((fe)object).a.goal == null) break;
                        ((h)object2).a(((fe)object).a);
                        break;
                    }
                    default: {
                        throw new IllegalStateException();
                    }
                }
            }
            object = this;
            this.e = false;
            if (((h)object).c && ((h)object).b) {
                ((h)object).c = false;
                if (((h)object).d) {
                    ((a)((Object)((h)object).a)).a.clearAllKeys();
                    ((a)((Object)((h)object).a)).a.a.a();
                }
                ((h)object).d = false;
                ((h)object).e = true;
            } else {
                ((h)object).d = true;
                if (((h)object).f) {
                    ((h)object).f = false;
                    ((a)((Object)((h)object).a)).a.clearAllKeys();
                }
                object2 = ((h)object).b;
                synchronized (object2) {
                    Object object3 = ((h)object).a;
                    synchronized (object3) {
                        if (((h)object).a != null) {
                            BetterBlockPos betterBlockPos = ((h)object).a.a();
                            Optional<IPath> optional = ((h)object).a.bestPathSoFar();
                            if (!(((h)object).a != null && ((h)object).a.getPath().getDest().equals((Object)betterBlockPos) || betterBlockPos.equals((Object)((h)object).a.playerFeet()) || betterBlockPos.equals((Object)((h)object).b) || optional.isPresent() && (optional.get().positions().contains((Object)((h)object).a.playerFeet()) || optional.get().positions().contains((Object)((h)object).b)))) {
                                ((h)object).a.a();
                            }
                        }
                    }
                    if (((h)object).a == null) {
                        break block50;
                    }
                    ((h)object).b = ((h)object).a.a();
                    if (((h)object).a.a || ((h)object).a.b()) {
                        ((h)object).a = null;
                        if (((h)object).a == null || ((h)object).a.isInGoal(((h)object).a.playerFeet())) {
                            object.logDebug("All done. At " + ((h)object).a);
                            super.a(PathEvent.AT_GOAL);
                            ((h)object).b = null;
                            if (((Boolean)baritone.a.a().disconnectOnArrival.value).booleanValue()) {
                                ((h)object).a.world().O();
                            }
                            break block50;
                        }
                        if (((h)object).b != null && !((h)object).b.getPath().positions().contains((Object)((h)object).a.playerFeet()) && !((h)object).b.getPath().positions().contains((Object)((h)object).b)) {
                            object.logDebug("Discarding next path as it does not contain current position");
                            super.a(PathEvent.DISCARD_NEXT);
                            ((h)object).b = null;
                        }
                        if (((h)object).b != null) {
                            object.logDebug("Continuing on to planned next path");
                            super.a(PathEvent.CONTINUING_ONTO_PLANNED_NEXT);
                            ((h)object).a = ((h)object).b;
                            ((h)object).b = null;
                            ((h)object).a.a();
                            break block50;
                        }
                        object3 = ((h)object).a;
                        synchronized (object3) {
                            if (((h)object).a != null) {
                                super.a(PathEvent.PATH_FINISHED_NEXT_STILL_CALCULATING);
                                break block50;
                            }
                            super.a(PathEvent.CALC_STARTED);
                            Object object4 = object;
                            super.a(((h)object4).b, true, ((h)object).a);
                        }
                    }
                    if (((h)object).b && ((h)object).b != null) {
                        boolean bl2;
                        object3 = ((h)object).b;
                        if (!((dk)object3).a.player().z && !(((dk)object3).a.world().o((et)((dk)object3).a.playerFeet()).u() instanceof aru)) {
                            bl2 = false;
                        } else if (((dk)object3).a.player().t < -0.1) {
                            bl2 = false;
                        } else {
                            int n2 = ((dk)object3).a.positions().indexOf((Object)((dk)object3).a.playerFeet());
                            if (n2 == -1) {
                                bl2 = false;
                            } else {
                                ((dk)object3).a = n2;
                                ((dk)object3).a();
                                bl2 = true;
                            }
                        }
                        if (bl2) {
                            object.logDebug("Splicing into planned next path early...");
                            super.a(PathEvent.SPLICING_ONTO_NEXT_EARLY);
                            ((h)object).a = ((h)object).b;
                            ((h)object).b = null;
                            ((h)object).a.a();
                            break block50;
                        }
                    }
                    if (((Boolean)baritone.a.a().splicePath.value).booleanValue()) {
                        ((h)object).a = ((h)object).a.a(((h)object).b);
                    }
                    if (((h)object).b != null && ((h)object).a.getPath().getDest().equals((Object)((h)object).b.getPath().getDest())) {
                        ((h)object).b = null;
                    }
                    object3 = ((h)object).a;
                    synchronized (object3) {
                        if (((h)object).a != null) {
                            break block50;
                        }
                        if (((h)object).b != null) {
                            break block50;
                        }
                        if (((h)object).a == null || ((h)object).a.isInGoal(((h)object).a.getPath().getDest())) {
                            break block50;
                        }
                        if (object.ticksRemainingInSegment(false).get() < (double)((Integer)baritone.a.a().planningTickLookahead.value).intValue()) {
                            object.logDebug("Path almost over. Planning ahead...");
                            super.a(PathEvent.NEXT_SEGMENT_CALC_STARTED);
                            Object object5 = object;
                            super.a(((h)object5).a.getPath().getDest(), false, ((h)object).a);
                        }
                    }
                }
            }
        }
        ++this.a;
        this.c();
    }

    @Override
    public final void onPlayerSprintState(SprintStateEvent sprintStateEvent) {
        if (this.isPathing()) {
            sprintStateEvent.setState(this.a.b);
        }
    }

    @Override
    public final void onPlayerUpdate(PlayerUpdateEvent playerUpdateEvent) {
        if (this.a != null) {
            switch (playerUpdateEvent.getState()) {
                case PRE: {
                    this.g = this.a.minecraft().t.R;
                    this.a.minecraft().t.R = false;
                    return;
                }
                case POST: {
                    this.a.minecraft().t.R = this.g;
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final boolean a(PathingCommand object) {
        this.a = ((PathingCommand)object).goal;
        this.a = object instanceof fd ? ((fd)object).a : new bz((IBaritone)((Object)this.a), true);
        if (this.a == null) {
            return false;
        }
        if (this.a.isInGoal(this.a.playerFeet()) || this.a.isInGoal(this.b)) {
            return false;
        }
        object = this.b;
        synchronized (object) {
            if (this.a != null) {
                return false;
            }
            Object object2 = this.a;
            synchronized (object2) {
                if (this.a != null) {
                    return false;
                }
                this.a(PathEvent.CALC_STARTED);
                h h2 = this;
                h2.a(h2.b, true, this.a);
                return true;
            }
        }
    }

    @Override
    public final Goal getGoal() {
        return this.a;
    }

    @Override
    public final boolean isPathing() {
        return this.hasPath() && !this.e;
    }

    public final Optional<bw> getInProgress() {
        return Optional.ofNullable(this.a);
    }

    public final boolean a() {
        if (this.a == null) {
            return !((a)((Object)this.a)).getElytraProcess().isActive() || ((a)((Object)this.a)).getElytraProcess().isSafeToCancel();
        }
        return this.b;
    }

    private boolean b() {
        if (this.a()) {
            this.b();
            return true;
        }
        return false;
    }

    @Override
    public final boolean cancelEverything() {
        boolean bl2 = this.a();
        if (bl2) {
            this.b();
        }
        ((a)((Object)this.a)).a.a();
        return bl2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void a() {
        Object object = this.b;
        synchronized (object) {
            this.getInProgress().ifPresent(bw::a);
            if (!this.a()) {
                return;
            }
            this.a = null;
            this.b = null;
        }
        this.f = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void b() {
        this.a(PathEvent.CANCELED);
        Object object = this.b;
        synchronized (object) {
            this.getInProgress().ifPresent(bw::a);
            if (this.a != null) {
                this.a = null;
                this.b = null;
                ((a)((Object)this.a)).a.clearAllKeys();
                ((a)((Object)this.a)).a.a.a();
            }
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void forceCancel() {
        this.cancelEverything();
        this.b();
        Object object = this.a;
        synchronized (object) {
            this.a = null;
            return;
        }
    }

    @Override
    public final Optional<Double> estimatedTicksToGoal() {
        double d2;
        BetterBlockPos betterBlockPos = this.a.playerFeet();
        if (this.a == null || betterBlockPos == null || this.a == null) {
            return Optional.empty();
        }
        if (this.a.isInGoal(this.a.playerFeet())) {
            h h2 = this;
            h2.a(h2.b);
            return Optional.of(0.0);
        }
        if (this.a == 0) {
            return Optional.empty();
        }
        double d3 = this.a.heuristic(betterBlockPos.a, betterBlockPos.b, betterBlockPos.c);
        if (d3 == (d2 = this.a.heuristic(this.a.a, this.a.b, this.a.c))) {
            return Optional.empty();
        }
        return Optional.of(Math.abs(d3 - this.a.heuristic()) * (double)this.a / Math.abs(d2 - d3));
    }

    private void a(BetterBlockPos betterBlockPos) {
        this.a = 0;
        this.a = betterBlockPos;
    }

    public final BetterBlockPos a() {
        BetterBlockPos betterBlockPos2 = this.a.playerFeet();
        if (!cb.b((IPlayerContext)((Object)this.a), betterBlockPos2.down())) {
            if (this.a.player().z) {
                int n2;
                double d2 = this.a.player().p;
                double d3 = this.a.player().r;
                ArrayList<BetterBlockPos> arrayList = new ArrayList<BetterBlockPos>();
                for (n2 = -1; n2 <= 1; ++n2) {
                    for (int i2 = -1; i2 <= 1; ++i2) {
                        arrayList.add(new BetterBlockPos(betterBlockPos2.a + n2, betterBlockPos2.b, betterBlockPos2.c + i2));
                    }
                }
                arrayList.sort(Comparator.comparingDouble(betterBlockPos -> ((double)betterBlockPos.a + 0.5 - d2) * ((double)betterBlockPos.a + 0.5 - d2) + ((double)betterBlockPos.c + 0.5 - d3) * ((double)betterBlockPos.c + 0.5 - d3)));
                for (n2 = 0; n2 < 4; ++n2) {
                    BetterBlockPos betterBlockPos3 = (BetterBlockPos)((Object)arrayList.get(n2));
                    double d4 = Math.abs((double)betterBlockPos3.a + 0.5 - d2);
                    double d5 = Math.abs((double)betterBlockPos3.c + 0.5 - d3);
                    if (d4 > 0.8 && d5 > 0.8 || !cb.b((IPlayerContext)((Object)this.a), betterBlockPos3.down()) || !cb.a((IPlayerContext)((Object)this.a), betterBlockPos3) || !cb.a((IPlayerContext)((Object)this.a), betterBlockPos3.up())) continue;
                    return betterBlockPos3;
                }
            } else if (cb.b((IPlayerContext)((Object)this.a), betterBlockPos2.down().down())) {
                return betterBlockPos2.down();
            }
        }
        return betterBlockPos2;
    }

    private void a(et et2, boolean bl2, bz object) {
        long l2;
        long l3;
        if (!Thread.holdsLock(this.a)) {
            throw new IllegalStateException("Must be called with synchronization on pathCalcLock");
        }
        if (this.a != null) {
            throw new IllegalStateException("Already doing it");
        }
        if (!((bz)object).a) {
            throw new IllegalStateException("Improper context thread safety level");
        }
        Goal goal = this.a;
        if (goal == null) {
            this.logDebug("no goal");
            return;
        }
        if (this.a == null) {
            l3 = (Long)baritone.a.a().primaryTimeoutMS.value;
            l2 = (Long)baritone.a.a().failureTimeoutMS.value;
        } else {
            l3 = (Long)baritone.a.a().planAheadPrimaryTimeoutMS.value;
            l2 = (Long)baritone.a.a().planAheadFailureTimeoutMS.value;
        }
        object = h.a(et2, goal, this.a == null ? null : this.a.getPath(), (bz)object);
        if (!Objects.equals(((bw)object).getGoal(), goal)) {
            this.logDebug("Simplifying " + goal.getClass() + " to GoalXZ due to distance");
        }
        this.a = object;
        baritone.a.a().execute(() -> this.a(bl2, et2, goal, (bw)object, l3, l2));
    }

    private static bw a(et et2, Goal object, IPath iPath, bz bz2) {
        Goal goal = object;
        if (((Boolean)baritone.a.a().simplifyUnloadedYCoord.value).booleanValue() && object instanceof IGoalRenderPos && !bz2.a.a((object = ((IGoalRenderPos)object).getGoalPos()).p(), object.r())) {
            goal = new GoalXZ(object.p(), object.r());
        }
        object = new fv(bz2.a.getPlayerContext(), iPath, bz2);
        return new bv(et2.p(), et2.q(), et2.r(), goal, (fv)object, bz2);
    }

    @Override
    public final void onRenderPass(RenderEvent renderEvent) {
        fc.a(renderEvent, this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private /* synthetic */ void a(boolean bl2, et et2, Goal goal, bw object, long l2, long l3) {
        if (bl2) {
            this.logDebug("Starting to search for path from " + et2 + " to " + goal);
        }
        object = ((bw)object).calculate(l2, l3);
        Object object2 = this.b;
        synchronized (object2) {
            et et3 = ((PathCalculationResult)object).getPath().map(iPath -> new dk(this, (IPath)iPath));
            if (this.a == null) {
                if (et3.isPresent()) {
                    if (et3.get().getPath().positions().contains((Object)this.b)) {
                        this.a(PathEvent.CALC_FINISHED_NOW_EXECUTING);
                        this.a = et3.get();
                        et3 = et2;
                        this.a(new BetterBlockPos(et3));
                    } else {
                        this.logDebug("Warning: discarding orphan path segment with incorrect start");
                    }
                } else if (((PathCalculationResult)object).getType() != PathCalculationResult.Type.CANCELLATION && ((PathCalculationResult)object).getType() != PathCalculationResult.Type.EXCEPTION) {
                    this.a(PathEvent.CALC_FAILED);
                }
            } else if (this.b == null) {
                if (et3.isPresent()) {
                    if (et3.get().getPath().getSrc().equals((Object)this.a.getPath().getDest())) {
                        this.a(PathEvent.NEXT_SEGMENT_CALC_FINISHED);
                        this.b = (dk)et3.get();
                    } else {
                        this.logDebug("Warning: discarding orphan next segment with incorrect start");
                    }
                } else {
                    this.a(PathEvent.NEXT_CALC_FAILED);
                }
            } else {
                this.logDirect("Warning: PathingBehaivor illegal state! Discarding invalid path!");
            }
            if (bl2 && this.a != null && this.a.getPath() != null) {
                if (goal.isInGoal(this.a.getPath().getDest())) {
                    this.logDebug("Finished finding a path from " + et2 + " to " + goal + ". " + this.a.getPath().getNumNodesConsidered() + " nodes considered");
                } else {
                    this.logDebug("Found path segment from " + et2 + " towards " + goal + ". " + this.a.getPath().getNumNodesConsidered() + " nodes considered");
                }
            }
            Object object3 = this.a;
            synchronized (object3) {
                this.a = null;
            }
            return;
        }
    }
}

