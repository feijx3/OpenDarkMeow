/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  agi
 *  aow
 *  aox
 *  awt
 *  bud
 *  et
 */
package baritone;

import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.pathing.goals.GoalComposite;
import baritone.api.pathing.goals.GoalGetToBlock;
import baritone.api.pathing.goals.GoalTwoBlocks;
import baritone.api.process.IGetToBlockProcess;
import baritone.api.process.PathingCommand;
import baritone.api.process.PathingCommandType;
import baritone.api.utils.BlockOptionalMeta;
import baritone.api.utils.BlockOptionalMetaLookup;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.Rotation;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.input.Input;
import baritone.bz;
import baritone.ef;
import baritone.eh;
import baritone.eu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ee
extends eu
implements IGetToBlockProcess {
    private BlockOptionalMeta a;
    private List<et> a;
    private List<et> b;
    private et a;
    private int a = 0;
    private int b = 0;

    public ee(baritone.a a2) {
        super(a2);
    }

    @Override
    public final void getToBlock(BlockOptionalMeta blockOptionalMeta) {
        this.onLostControl();
        this.a = blockOptionalMeta;
        this.a = this.a.playerFeet();
        this.b = new ArrayList<et>();
        this.b = 0;
        this.a(new ArrayList<et>(), new a(this, false));
    }

    @Override
    public final boolean isActive() {
        return this.a != null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final synchronized PathingCommand onTick(boolean bl2, boolean bl3) {
        void var2_4;
        if (this.a == null) {
            this.a(new ArrayList<et>(), new a(this, false));
        }
        if (this.a.isEmpty()) {
            if (((Boolean)baritone.a.a().exploreForBlocks.value).booleanValue() && !bl2) {
                return new PathingCommand(new ef(this, this.a), PathingCommandType.FORCE_REVALIDATE_GOAL_AND_PATH);
            }
            this.logDirect("No known locations of " + this.a + ", canceling GetToBlock");
            if (var2_4 != false) {
                this.onLostControl();
            }
            return new PathingCommand(null, PathingCommandType.CANCEL_AND_SET_GOAL);
        }
        GoalComposite goalComposite = new GoalComposite((Goal[])this.a.stream().map(this::a).toArray(Goal[]::new));
        if (bl2) {
            if (((Boolean)baritone.a.a().blacklistClosestOnFailure.value).booleanValue()) {
                this.logDirect("Unable to find any path to " + this.a + ", blacklisting presumably unreachable closest instances...");
                this.blacklistClosest();
                return this.onTick(false, (boolean)var2_4);
            }
            this.logDirect("Unable to find any path to " + this.a + ", canceling GetToBlock");
            if (var2_4 != false) {
                this.onLostControl();
            }
            return new PathingCommand(goalComposite, PathingCommandType.CANCEL_AND_SET_GOAL);
        }
        int arrayList = (Integer)baritone.a.a().mineGoalUpdateInterval.value;
        if (arrayList != 0 && this.a++ % arrayList == 0) {
            ArrayList arrayList2 = new ArrayList(this.a);
            a a2 = new a(this, true);
            baritone.a.a().execute(() -> this.a(arrayList, a2));
        }
        if (goalComposite.isInGoal(this.a.playerFeet()) && goalComposite.isInGoal(((baritone.a)((Object)this.a)).a.a()) && var2_4 != false) {
            if (ee.a(this.a.getBlock())) {
                if (this.a()) {
                    this.onLostControl();
                    return new PathingCommand(null, PathingCommandType.CANCEL_AND_SET_GOAL);
                }
            } else {
                this.onLostControl();
                return new PathingCommand(null, PathingCommandType.CANCEL_AND_SET_GOAL);
            }
        }
        return new PathingCommand(goalComposite, PathingCommandType.REVALIDATE_GOAL_AND_PATH);
    }

    @Override
    public final synchronized boolean blacklistClosest() {
        ArrayList<et> arrayList = new ArrayList<et>();
        this.a.stream().min(Comparator.comparingDouble(arg_0 -> ((bud)this.a.player()).c(arg_0))).ifPresent(arrayList::add);
        block0: while (true) {
            Iterator iterator2 = this.a.iterator();
            while (iterator2.hasNext()) {
                et et2 = (et)iterator2.next();
                Iterator iterator3 = arrayList.iterator();
                while (iterator3.hasNext()) {
                    int n2;
                    int n3;
                    et et3;
                    et et4 = et3 = (et)iterator3.next();
                    et3 = et2;
                    int n4 = Math.abs(et3.p() - et4.p());
                    if (!(n4 + (n3 = Math.abs(et3.q() - et4.q())) + (n2 = Math.abs(et3.r() - et4.r())) == 1)) continue;
                    arrayList.add(et2);
                    this.a.remove(et2);
                    continue block0;
                }
            }
            break;
        }
        arrayList.size();
        this.logDebug("Blacklisting unreachable locations ".concat(String.valueOf(arrayList)));
        this.b.addAll(arrayList);
        return !arrayList.isEmpty();
    }

    @Override
    public final synchronized void onLostControl() {
        this.a = null;
        this.a = null;
        this.a = null;
        this.b = null;
        ((baritone.a)((Object)this.a)).a.clearAllKeys();
    }

    @Override
    public final String displayName0() {
        if (this.a.isEmpty()) {
            return "Exploring randomly to find " + this.a + ", no known locations";
        }
        return "Get To " + this.a + ", " + this.a.size() + " known locations";
    }

    private synchronized void a(List<et> list, bz bz2) {
        list = eh.a(bz2, new BlockOptionalMetaLookup(this.a), list, this.b, Collections.emptyList());
        list.removeIf(this.b::contains);
        this.a = list;
    }

    private Goal a(et et2) {
        aow aow2 = this.a.getBlock();
        if ((Boolean)baritone.a.a().enterPortal.value != false && aow2 == aox.aY) {
            return new GoalTwoBlocks(et2);
        }
        aow2 = this.a.getBlock();
        if (ee.a(aow2) && (aow2 == aox.bQ || aow2 == aox.ae || aow2 == aox.cg) && ((baritone.a)((Object)this.a)).a.a(et2.a()).k()) {
            return new GoalBlock(et2.a());
        }
        return new GoalGetToBlock(et2);
    }

    private boolean a() {
        Iterator iterator2 = this.a.iterator();
        while (iterator2.hasNext()) {
            Object object = (et)iterator2.next();
            if (!((Optional)(object = RotationUtils.reachable((IPlayerContext)((Object)this.a), (et)object, this.a.playerController().getBlockReachDistance()))).isPresent()) continue;
            ((baritone.a)((Object)this.a)).a.updateTarget((Rotation)((Optional)object).get(), true);
            if (this.a.contains(this.a.getSelectedBlock().orElse(null))) {
                ((baritone.a)((Object)this.a)).a.setInputForceState(Input.CLICK_RIGHT, true);
                System.out.println(this.a.player().by);
                if (!(this.a.player().by instanceof agi)) {
                    return true;
                }
            }
            if (this.b++ > 20) {
                this.logDirect("Right click timed out");
                return true;
            }
            return false;
        }
        this.logDirect("Arrived but failed to right click open");
        return true;
    }

    private static boolean a(aow aow2) {
        if (!((Boolean)baritone.a.a().rightClickContainerOnArrival.value).booleanValue()) {
            return false;
        }
        return aow2 == aox.ai || aow2 == aox.al || aow2 == aox.am || aow2 == aox.bQ || aow2 == aox.ae || aow2 == aox.cg;
    }

    public final class a
    extends bz {
        private /* synthetic */ ee a;

        public a(ee ee2, boolean bl2) {
            this.a = ee2;
            super(((eu)ee2).a, bl2);
        }

        @Override
        public final double b(int n2, int n3, int n4, awt awt2) {
            return 1.0;
        }
    }
}

