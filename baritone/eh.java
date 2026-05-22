/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acl
 *  aip
 *  aom
 *  aow
 *  aox
 *  aqm
 *  awt
 *  bud
 *  et
 *  fq
 *  vg
 */
package baritone;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.pathing.goals.GoalComposite;
import baritone.api.pathing.goals.GoalRunAway;
import baritone.api.pathing.goals.GoalTwoBlocks;
import baritone.api.process.IMineProcess;
import baritone.api.process.PathingCommand;
import baritone.api.process.PathingCommandType;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.BlockOptionalMeta;
import baritone.api.utils.BlockOptionalMetaLookup;
import baritone.api.utils.BlockUtils;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.Rotation;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.SettingsUtil;
import baritone.api.utils.input.Input;
import baritone.bz;
import baritone.cb;
import baritone.ei;
import baritone.eu;
import baritone.ex;
import baritone.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class eh
extends eu
implements IMineProcess {
    private BlockOptionalMetaLookup a;
    private List<et> a;
    private List<et> b;
    private Map<et, Long> a;
    private et a;
    private GoalRunAway a;
    private int a;
    private int b;

    public eh(baritone.a a2) {
        super(a2);
    }

    @Override
    public final boolean isActive() {
        return this.a != null;
    }

    @Override
    public final PathingCommand onTick(boolean bl2, boolean bl3) {
        Object object;
        Object object2;
        int n2;
        if (this.a > 0) {
            n2 = this.a.player().bv.a.stream().filter(aip2 -> this.a.has((aip)aip2)).mapToInt(aip::E).sum();
            System.out.println("Currently have " + n2 + " valid items");
            if (n2 >= this.a) {
                this.logDirect("Have " + n2 + " valid items");
                this.cancel();
                return null;
            }
        }
        if (bl2) {
            if (!this.a.isEmpty() && ((Boolean)baritone.a.a().blacklistClosestOnFailure.value).booleanValue()) {
                this.logDirect("Unable to find any path to " + this.a + ", blacklisting presumably unreachable closest instance...");
                if (((Boolean)baritone.a.a().notificationOnMineFail.value).booleanValue()) {
                    this.logNotification("Unable to find any path to " + this.a + ", blacklisting presumably unreachable closest instance...", true);
                }
                this.a.stream().min(Comparator.comparingDouble(arg_0 -> ((bud)this.a.player()).c(arg_0))).ifPresent(this.b::add);
                this.a.removeIf(this.b::contains);
            } else {
                this.logDirect("Unable to find any path to " + this.a + ", canceling mine");
                if (((Boolean)baritone.a.a().notificationOnMineFail.value).booleanValue()) {
                    this.logNotification("Unable to find any path to " + this.a + ", canceling mine", true);
                }
                this.cancel();
                return null;
            }
        }
        this.a();
        n2 = (Integer)baritone.a.a().mineGoalUpdateInterval.value;
        Object object3 = new ArrayList(this.a);
        if (n2 != 0 && this.b++ % n2 == 0) {
            bz bz2 = new bz((IBaritone)((Object)this.a), true);
            baritone.a.a().execute(() -> this.a((List<et>)object3, bz2));
        }
        if (((Boolean)baritone.a.a().legitMine.value).booleanValue() && !this.a()) {
            this.cancel();
            return null;
        }
        Object object4 = object3.stream().filter(et2 -> et2.p() == this.a.playerFeet().p() && et2.r() == this.a.playerFeet().r()).filter(et2 -> et2.q() >= this.a.playerFeet().q()).filter(et2 -> !(ex.a((IPlayerContext)((Object)this.a), et2).u() instanceof aom)).min(Comparator.comparingDouble(arg_0 -> ((bud)this.a.player()).c(arg_0)));
        ((baritone.a)((Object)this.a)).a.clearAllKeys();
        if (((Optional)object4).isPresent() && this.a.player().z) {
            object3 = ((Optional)object4).get();
            object4 = ((baritone.a)((Object)this.a)).a.a((et)object3);
            if (!cb.a(((baritone.a)((Object)this.a)).a, object3.p(), object3.q(), object3.r(), (awt)object4) && ((Optional)(object4 = RotationUtils.reachable((IPlayerContext)((Object)this.a), (et)object3))).isPresent() && bl3) {
                ((baritone.a)((Object)this.a)).a.updateTarget((Rotation)((Optional)object4).get(), true);
                cb.a((IPlayerContext)((Object)this.a), this.a.world().o((et)object3));
                if (this.a.isLookingAt((et)object3) || this.a.playerRotations().isReallyCloseTo((Rotation)((Optional)object4).get())) {
                    ((baritone.a)((Object)this.a)).a.setInputForceState(Input.CLICK_LEFT, true);
                }
                return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
            }
        }
        if ((object2 = ((eh)(object3 = this)).a()) == null) {
            object = null;
        } else {
            boolean bl4 = (Boolean)baritone.a.a().legitMine.value;
            Object object5 = ((eh)object3).a;
            if (!object5.isEmpty()) {
                bz bz3 = new bz((IBaritone)((Object)((eh)object3).a));
                object2 = eh.a(bz3, new ArrayList<et>((Collection<et>)object5), (BlockOptionalMetaLookup)object2, ((eh)object3).b, super.a());
                object5 = new GoalComposite((Goal[])object2.stream().map(arg_0 -> ((eh)object3).a((List)object2, bz3, arg_0)).toArray(Goal[]::new));
                ((eh)object3).a = object2;
                object = new PathingCommand((Goal)object5, bl4 ? PathingCommandType.FORCE_REVALIDATE_GOAL_AND_PATH : PathingCommandType.REVALIDATE_GOAL_AND_PATH);
            } else if (!bl4 && !((Boolean)baritone.a.a().exploreForBlocks.value).booleanValue()) {
                object = null;
            } else {
                int n3 = (Integer)baritone.a.a().legitMineYLevel.value;
                if (((eh)object3).a == null) {
                    ((eh)object3).a = ((eh)object3).a.playerFeet();
                }
                if (((eh)object3).a == null) {
                    ((eh)object3).a = new ei((eh)object3, (Integer)n3, ((eh)object3).a);
                }
                object = object3 = new PathingCommand(((eh)object3).a, PathingCommandType.REVALIDATE_GOAL_AND_PATH);
            }
        }
        if (object == null) {
            this.cancel();
            return null;
        }
        return object3;
    }

    private void a() {
        HashMap hashMap = new HashMap(this.a);
        this.a.getSelectedBlock().ifPresent(et2 -> {
            if (this.a.contains(et2)) {
                hashMap.put(et2, System.currentTimeMillis() + (Long)baritone.a.a().mineDropLoiterDurationMSThanksLouca.value);
            }
        });
        for (et et3 : this.a.keySet()) {
            if ((Long)hashMap.get(et3) >= System.currentTimeMillis()) continue;
            hashMap.remove(et3);
        }
        this.a = hashMap;
    }

    @Override
    public final void onLostControl() {
        this.mine(0, (BlockOptionalMetaLookup)null);
    }

    @Override
    public final String displayName0() {
        return "Mine " + this.a;
    }

    private void a(List<et> list, bz bz2) {
        BlockOptionalMetaLookup blockOptionalMetaLookup = this.a();
        if (blockOptionalMetaLookup == null) {
            return;
        }
        if (((Boolean)baritone.a.a().legitMine.value).booleanValue()) {
            return;
        }
        List<et> list2 = this.a();
        list = eh.a(bz2, blockOptionalMetaLookup, list, this.b, list2);
        list.addAll(list2);
        if (list.isEmpty() && !((Boolean)baritone.a.a().exploreForBlocks.value).booleanValue()) {
            this.logDirect("No locations for " + blockOptionalMetaLookup + " known, cancelling");
            if (((Boolean)baritone.a.a().notificationOnMineFail.value).booleanValue()) {
                this.logNotification("No locations for " + blockOptionalMetaLookup + " known, cancelling", true);
            }
            this.cancel();
            return;
        }
        this.a = list;
    }

    private boolean a(et et2, bz bz2, List<et> awt2) {
        if (awt2.contains(et2)) {
            return true;
        }
        awt2 = bz2.a.a(et2);
        if (((Boolean)baritone.a.a().internalMiningAirException.value).booleanValue() && awt2.u() instanceof aom) {
            return true;
        }
        return this.a.has(awt2) && eh.a(bz2, et2);
    }

    private List<et> a() {
        if (!((Boolean)baritone.a.a().mineScanDroppedItems.value).booleanValue()) {
            return Collections.emptyList();
        }
        ArrayList<et> arrayList = new ArrayList<et>();
        for (vg vg2 : this.a.world().e) {
            acl acl2;
            if (!(vg2 instanceof acl) || !this.a.has((acl2 = (acl)vg2).k())) continue;
            arrayList.add(new et(vg2));
        }
        arrayList.addAll(this.a.keySet());
        return arrayList;
    }

    public static List<et> a(bz bz2, BlockOptionalMetaLookup blockOptionalMetaLookup, List<et> list, List<et> list2, List<et> list3) {
        List<et> list4 = new ArrayList<et>();
        ArrayList<aow> arrayList = new ArrayList<aow>();
        Iterator<BlockOptionalMeta> iterator2 = blockOptionalMetaLookup.blocks().iterator();
        while (iterator2.hasNext()) {
            aow aow2 = iterator2.next().getBlock();
            if (l.a.contains((Object)aow2)) {
                BetterBlockPos betterBlockPos = bz2.a.getPlayerContext().playerFeet();
                list4.addAll(bz2.a.getCachedWorld().getLocationsOf(BlockUtils.blockToString(aow2), (Integer)baritone.a.a().maxCachedWorldScanCount.value, betterBlockPos.a, betterBlockPos.c, 2));
                continue;
            }
            arrayList.add(aow2);
        }
        list4 = eh.a(bz2, list4, blockOptionalMetaLookup, list2, list3);
        if (!arrayList.isEmpty() || ((Boolean)baritone.a.a().extendCacheOnThreshold.value).booleanValue() && list4.size() < 64) {
            list4.addAll(BaritoneAPI.getProvider().getWorldScanner().scanChunkRadius(bz2.a.getPlayerContext(), blockOptionalMetaLookup, 64, 10, 32));
        }
        list4.addAll(list);
        return eh.a(bz2, list4, blockOptionalMetaLookup, list2, list3);
    }

    private boolean a() {
        List<et> list = this.a();
        this.a.addAll(list);
        BetterBlockPos betterBlockPos = this.a.playerFeet();
        ex ex2 = new ex((IPlayerContext)((Object)this.a));
        BlockOptionalMetaLookup blockOptionalMetaLookup = this.a();
        if (blockOptionalMetaLookup == null) {
            return false;
        }
        for (int i2 = betterBlockPos.p() - 10; i2 <= betterBlockPos.p() + 10; ++i2) {
            for (int i3 = betterBlockPos.q() - 10; i3 <= betterBlockPos.q() + 10; ++i3) {
                for (int i4 = betterBlockPos.r() - 10; i4 <= betterBlockPos.r() + 10; ++i4) {
                    if (!blockOptionalMetaLookup.has(ex2.a(i2, i3, i4))) continue;
                    et et2 = new et(i2, i3, i4);
                    if ((!((Boolean)baritone.a.a().legitMineIncludeDiagonals.value).booleanValue() || !this.a.stream().anyMatch(et3 -> et3.n((fq)et2) <= 2.0)) && !RotationUtils.reachable((IPlayerContext)((Object)this.a), et2, 20.0).isPresent()) continue;
                    this.a.add(et2);
                }
            }
        }
        this.a = eh.a(new bz((IBaritone)((Object)this.a)), (List<et>)((Object)this.a), blockOptionalMetaLookup, this.b, list);
        return true;
    }

    private static List<et> a(bz object, List<et> list, BlockOptionalMetaLookup blockOptionalMetaLookup, List<et> list2, List<et> list3) {
        list3.removeIf(arg_0 -> eh.a(list, blockOptionalMetaLookup, (bz)object, arg_0));
        object = list.stream().distinct().filter(arg_0 -> eh.a((bz)object, blockOptionalMetaLookup, list3, arg_0)).filter(arg_0 -> eh.c((bz)object, arg_0)).filter(arg_0 -> eh.b((bz)object, arg_0)).filter(et2 -> et2.q() >= (Integer)baritone.a.a().minYLevelWhileMining.value).filter(et2 -> et2.q() <= (Integer)baritone.a.a().maxYLevelWhileMining.value).filter(et2 -> !list2.contains(et2)).sorted(Comparator.comparingDouble(arg_0 -> ((bud)((bz)object).a.getPlayerContext().player()).c(arg_0))).collect(Collectors.toList());
        if (object.size() > 64) {
            return object.subList(0, 64);
        }
        return object;
    }

    private static boolean a(bz bz2, et et2) {
        if (cb.a(bz2, et2.p(), et2.q(), et2.r(), bz2.a.a(et2), true) >= 1000000.0) {
            return false;
        }
        return bz2.a.a(et2.a()).u() != aox.h || bz2.a.a(et2.b()).u() != aox.h;
    }

    @Override
    public final void mineByName(int n2, String ... stringArray) {
        this.mine(n2, new BlockOptionalMetaLookup(stringArray));
    }

    @Override
    public final void mine(int n2, BlockOptionalMetaLookup blockOptionalMetaLookup) {
        this.a = blockOptionalMetaLookup;
        if (this.a() == null) {
            this.a = null;
        }
        this.a = n2;
        this.a = new ArrayList();
        this.b = new ArrayList<et>();
        this.a = null;
        this.a = null;
        this.a = new HashMap();
        if (blockOptionalMetaLookup != null) {
            this.a(new ArrayList<et>(), new bz((IBaritone)((Object)this.a)));
        }
    }

    private BlockOptionalMetaLookup a() {
        if (this.a == null) {
            return null;
        }
        if (!((Boolean)baritone.a.a().allowBreak.value).booleanValue()) {
            BlockOptionalMetaLookup blockOptionalMetaLookup = new BlockOptionalMetaLookup((BlockOptionalMeta[])this.a.blocks().stream().filter(blockOptionalMeta -> ((List)baritone.a.a().allowBreakAnyway.value).contains(blockOptionalMeta.getBlock())).toArray(BlockOptionalMeta[]::new));
            if (blockOptionalMetaLookup.blocks().isEmpty()) {
                this.logDirect("Unable to mine when allowBreak is false and target block is not in allowBreakAnyway!");
                return null;
            }
            return blockOptionalMetaLookup;
        }
        return this.a;
    }

    private static /* synthetic */ boolean b(bz bz2, et et2) {
        if (((Boolean)baritone.a.a().allowOnlyExposedOres.value).booleanValue()) {
            int n2 = (Integer)baritone.a.a().allowOnlyExposedOresDistance.value;
            for (int i2 = -n2; i2 <= n2; ++i2) {
                for (int i3 = -n2; i3 <= n2; ++i3) {
                    for (int i4 = -n2; i4 <= n2; ++i4) {
                        if (Math.abs(i2) + Math.abs(i3) + Math.abs(i4) > n2 || !cb.d(bz2.a(et2.p() + i2, et2.q() + i3, et2.r() + i4))) continue;
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    private static /* synthetic */ boolean c(bz bz2, et et2) {
        return eh.a(bz2, et2);
    }

    private static /* synthetic */ boolean a(bz bz2, BlockOptionalMetaLookup blockOptionalMetaLookup, List list, et et2) {
        return !bz2.a.a(et2.p(), et2.r()) || blockOptionalMetaLookup.has(bz2.a(et2.p(), et2.q(), et2.r())) || list.contains(et2);
    }

    private static /* synthetic */ boolean a(List object, BlockOptionalMetaLookup blockOptionalMetaLookup, bz bz2, et et2) {
        object = object.iterator();
        while (object.hasNext()) {
            et et3;
            et et4 = (et)object.next();
            if (!(et3.n((fq)et2) <= 9.0) || !blockOptionalMetaLookup.has(bz2.a(et4.p(), et4.q(), et4.r())) || !eh.a(bz2, et4)) continue;
            return true;
        }
        return false;
    }

    private /* synthetic */ Goal a(List object, bz bz2, et object2) {
        boolean bl2;
        et et2 = object2;
        bz bz3 = bz2;
        object2 = object;
        bz2 = et2;
        object = this;
        boolean bl3 = bl2 = !(((baritone.a)((Object)((eh)object).a)).a.a(bz2.a()).u() instanceof aqm);
        if (!((Boolean)baritone.a.a().forceInternalMining.value).booleanValue()) {
            if (bl2) {
                return new a((et)bz2);
            }
            return new GoalTwoBlocks((et)bz2);
        }
        boolean bl4 = super.a(bz2.a(), bz3, (List<et>)object2);
        boolean bl5 = super.a(bz2.b(), bz3, (List<et>)object2);
        boolean bl6 = super.a(bz2.c(2), bz3, (List<et>)object2);
        if (bl4 == bl5) {
            if (bl6 && bl2) {
                return new a((et)bz2);
            }
            return new GoalTwoBlocks((et)bz2);
        }
        if (bl4) {
            return new GoalBlock((et)bz2);
        }
        if (bl6 && bl2) {
            return new GoalTwoBlocks(bz2.b());
        }
        return new GoalBlock(bz2.b());
    }

    static final class a
    extends GoalTwoBlocks {
        public a(et et2) {
            super(et2);
        }

        @Override
        public final boolean isInGoal(int n2, int n3, int n4) {
            return n2 == this.x && (n3 == this.y || n3 == this.y - 1 || n3 == this.y - 2) && n4 == this.z;
        }

        @Override
        public final double heuristic(int n2, int n3, int n4) {
            return GoalBlock.calculate(n2 -= this.x, (n3 -= this.y) < -1 ? n3 + 2 : (n3 == -1 ? 0 : n3), n4 -= this.z);
        }

        @Override
        public final boolean equals(Object object) {
            return super.equals(object);
        }

        @Override
        public final int hashCode() {
            return super.hashCode() * 393857768;
        }

        @Override
        public final String toString() {
            return String.format("GoalThreeBlocks{x=%s,y=%s,z=%s}", SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z));
        }
    }
}

