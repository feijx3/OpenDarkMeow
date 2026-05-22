/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acl
 *  ahs
 *  aht
 *  ain
 *  aip
 *  air
 *  amu
 *  aom
 *  aow
 *  aox
 *  aoz
 *  apm
 *  aps
 *  ase
 *  aso
 *  asr$a
 *  awt
 *  axj
 *  bhc$a
 *  bhe
 *  et
 *  fa
 *  fa$c
 *  fq
 *  vg
 */
package baritone;

import baritone.api.BaritoneAPI;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.pathing.goals.GoalComposite;
import baritone.api.pathing.goals.GoalGetToBlock;
import baritone.api.process.IFarmProcess;
import baritone.api.process.PathingCommand;
import baritone.api.process.PathingCommandType;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.RayTraceUtils;
import baritone.api.utils.Rotation;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.input.Input;
import baritone.cb;
import baritone.dq;
import baritone.eb;
import baritone.ec;
import baritone.eu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ea
extends eu
implements IFarmProcess {
    private boolean a;
    private List<et> a;
    private int a;
    private int b;
    private et a;
    private static final List<ain> b;
    private static final List<ain> c;

    public ea(baritone.a a2) {
        super(a2);
    }

    @Override
    public final boolean isActive() {
        return this.a;
    }

    @Override
    public final void farm(int n2, et et2) {
        this.a = et2 == null ? this.a.getPlayerContext().playerFeet() : et2;
        this.b = n2;
        this.a = true;
        this.a = null;
    }

    private static boolean a(amu amu2, et et2, awt awt2) {
        for (a a2 : baritone.ea$a.values()) {
            if (a2.a != awt2.u()) continue;
            return a2.a(amu2, et2, awt2);
        }
        return false;
    }

    private boolean a(aip aip2) {
        return b.contains(aip2.c());
    }

    private boolean b(aip aip2) {
        return !aip2.b() && aip2.c() instanceof aht && ahs.a((int)aip2.j()) == ahs.a;
    }

    private boolean c(aip aip2) {
        return !aip2.b() && aip2.c().equals(air.bG);
    }

    private boolean d(aip aip2) {
        return !aip2.b() && aip2.c() instanceof aht && ahs.a((int)aip2.j()) == ahs.m;
    }

    @Override
    public final PathingCommand onTick(boolean bl2, boolean bl3) {
        fa fa2;
        Optional<Rotation> optional3;
        Object object3;
        Object object22;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (a object32 : baritone.ea$a.values()) {
            arrayList.add(object32.a);
        }
        if (((Boolean)baritone.a.a().replantCrops.value).booleanValue()) {
            arrayList.add(aox.ak);
            arrayList.add(aox.r);
            if (((Boolean)baritone.a.a().replantNetherWart.value).booleanValue()) {
                arrayList.add(aox.aW);
            }
        }
        if ((Integer)baritone.a.a().mineGoalUpdateInterval.value != 0 && this.a++ % (Integer)baritone.a.a().mineGoalUpdateInterval.value == 0) {
            baritone.a.a().execute(() -> {
                this.a = BaritoneAPI.getProvider().getWorldScanner().scanChunkRadius((IPlayerContext)this.a, arrayList, 256, 10, 10);
            });
        }
        if (this.a == null) {
            return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList<Object> arrayList3 = new ArrayList<Object>();
        ArrayList<Object> arrayList4 = new ArrayList<Object>();
        ArrayList<Object> arrayList5 = new ArrayList<Object>();
        arrayList = new ArrayList();
        block1: for (Object object22 : this.a) {
            if (this.b != 0 && object22.h(this.a.p(), this.a.q(), this.a.r()) > (double)this.b) continue;
            object3 = this.a.world().o((et)object22);
            boolean bl4 = this.a.world().o(object22.a()).u() instanceof aom;
            if (object3.u() == aox.ak) {
                if (!bl4) continue;
                arrayList3.add(object22);
                continue;
            }
            if (object3.u() == aox.aW) {
                if (!bl4) continue;
                arrayList5.add(object22);
                continue;
            }
            if (object3.u() == aox.r) {
                if (object3.c((axj)aso.b) != asr.a.d) continue;
                optional3 = fa.c.a.iterator();
                while (optional3.hasNext()) {
                    fa2 = (fa)optional3.next();
                    if (!(this.a.world().o(object22.a(fa2)).u() instanceof aom)) continue;
                    arrayList.add(object22);
                    continue block1;
                }
                continue;
            }
            if (ea.a(this.a.world(), (et)object22, (awt)object3)) {
                arrayList2.add(object22);
                continue;
            }
            if (!(object3.u() instanceof aoz) || !(optional3 = (aoz)object3.u()).a(this.a.world(), (et)object22, (awt)object3, true) || !optional3.a(this.a.world(), this.a.world().r, (et)object22, (awt)object3)) continue;
            arrayList4.add(object22);
        }
        this.a.a.clearAllKeys();
        Optional<Rotation> optional2 = arrayList2.iterator();
        while (optional2.hasNext()) {
            object22 = (et)optional2.next();
            object3 = RotationUtils.reachable((IPlayerContext)this.a, (et)object22);
            if (!((Optional)object3).isPresent() || !bl3) continue;
            this.a.a.updateTarget((Rotation)((Optional)object3).get(), true);
            cb.a((IPlayerContext)this.a, this.a.world().o((et)object22));
            if (this.a.isLookingAt((et)object22)) {
                this.a.a.setInputForceState(Input.CLICK_LEFT, true);
            }
            return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
        }
        optional2 = new ArrayList<Object>(arrayList3);
        ((ArrayList)((Object)optional2)).addAll(arrayList5);
        object22 = ((ArrayList)((Object)optional2)).iterator();
        while (object22.hasNext()) {
            object3 = (et)object22.next();
            boolean optional4 = arrayList5.contains(object3);
            optional3 = RotationUtils.reachableOffset((IPlayerContext)this.a, (et)object3, new bhe((double)object3.p() + 0.5, (double)(object3.q() + 1), (double)object3.r() + 0.5), this.a.playerController().getBlockReachDistance(), false);
            if (!optional3.isPresent() || !bl3 || !this.a.a.a(true, optional4 ? this::c : this::a)) continue;
            fa2 = RayTraceUtils.rayTraceTowards((vg)this.a.player(), (Rotation)optional3.get(), this.a.playerController().getBlockReachDistance());
            if (fa2.a != bhc.a.b || fa2.b != fa.b) continue;
            this.a.a.updateTarget((Rotation)optional3.get(), true);
            if (this.a.isLookingAt((et)object3)) {
                this.a.a.setInputForceState(Input.CLICK_RIGHT, true);
            }
            return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
        }
        for (Object object3 : arrayList) {
            for (Optional<Rotation> optional3 : fa.c.a) {
                if (!(this.a.world().o(object3.a((fa)optional3)).u() instanceof aom) || !(optional2 = RotationUtils.reachableOffset((IPlayerContext)this.a, (et)object3, (bhe)(fa2 = new bhe((fq)object3).b(0.5, 0.5, 0.5).e(new bhe(optional3.n()).a(0.5))), this.a.playerController().getBlockReachDistance(), false)).isPresent() || !bl3 || !this.a.a.a(true, this::d)) continue;
                fa2 = RayTraceUtils.rayTraceTowards((vg)this.a.player(), optional2.get(), this.a.playerController().getBlockReachDistance());
                if (fa2.a != bhc.a.b || fa2.b != optional3) continue;
                this.a.a.updateTarget(optional2.get(), true);
                if (this.a.isLookingAt((et)object3)) {
                    this.a.a.setInputForceState(Input.CLICK_RIGHT, true);
                }
                return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
            }
        }
        for (Object object3 : arrayList4) {
            Optional<Rotation> et3 = RotationUtils.reachable((IPlayerContext)this.a, (et)object3);
            if (!et3.isPresent() || !bl3 || !this.a.a.a(true, this::b)) continue;
            this.a.a.updateTarget(et3.get(), true);
            if (this.a.isLookingAt((et)object3)) {
                this.a.a.setInputForceState(Input.CLICK_RIGHT, true);
            }
            return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
        }
        if (bl2) {
            this.logDirect("Farm failed");
            if (((Boolean)baritone.a.a().notificationOnFarmFail.value).booleanValue()) {
                this.logNotification("Farm failed", true);
            }
            this.onLostControl();
            return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
        }
        object22 = new ArrayList();
        object3 = arrayList2.iterator();
        while (object3.hasNext()) {
            et et4 = (et)object3.next();
            object22.add(new dq.c(et4));
        }
        if (this.a.a.a(false, this::a)) {
            for (et et5 : arrayList3) {
                object22.add(new GoalBlock(et5.a()));
            }
        }
        if (this.a.a.a(false, this::c)) {
            for (et et6 : arrayList5) {
                object22.add(new GoalBlock(et6.a()));
            }
        }
        if (this.a.a.a(false, this::d)) {
            for (et vg2 : arrayList) {
                optional3 = fa.c.a.iterator();
                while (optional3.hasNext()) {
                    fa2 = (fa)optional3.next();
                    if (!(this.a.world().o(vg2.a(fa2)).u() instanceof aom)) continue;
                    object22.add(new GoalGetToBlock(vg2.a(fa2)));
                }
            }
        }
        if (this.a.a.a(false, this::b)) {
            for (et et2 : arrayList4) {
                object22.add(new GoalBlock(et2));
            }
        }
        for (vg vg2 : this.a.world().e) {
            if (!(vg2 instanceof acl) || !vg2.z || !c.contains((optional3 = (acl)vg2).k().c()) && !this.d(optional3.k())) continue;
            object22.add(new GoalBlock(new et(vg2.p, vg2.q + 0.1, vg2.r)));
        }
        return new PathingCommand(new GoalComposite(object22.toArray(new Goal[0])), PathingCommandType.SET_GOAL_AND_PATH);
    }

    @Override
    public final void onLostControl() {
        this.a = false;
    }

    @Override
    public final String displayName0() {
        return "Farming";
    }

    static {
        b = (int)Arrays.asList(air.cV, air.bp, air.Q, air.bo, air.cd, air.cc);
        c = Arrays.asList(air.cV, air.cW, air.bp, air.bn, ain.a((aow)aox.bk), air.Q, air.R, air.bo, ain.a((aow)aox.aU), air.cd, air.cc, air.bG, air.aR, ain.a((aow)aox.aK));
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    static class a
    extends Enum<a> {
        private static /* enum */ a a = new a((aps)aox.aj);
        private static /* enum */ a b = new a((aps)aox.cb);
        private static /* enum */ a c = new a((aps)aox.cc);
        private static /* enum */ a d = new a((aps)aox.cZ);
        private static /* enum */ a e = new a(aox.aU, awt2 -> true);
        private static /* enum */ a f = new a(aox.bk, awt2 -> true);
        private static /* enum */ a g = new a(aox.bB, awt2 -> (Integer)awt2.c((axj)ase.a) >= 3);
        private static /* enum */ a h = new a(aox.bN, awt2 -> (Integer)awt2.c((axj)apm.a) >= 2);
        private static /* enum */ a i = new eb();
        private static /* enum */ a j = new ec();
        public final aow a;
        private Predicate<awt> a;
        private static final /* synthetic */ a[] a;

        public static a[] values() {
            return (a[])a.clone();
        }

        public static a valueOf(String string) {
            return Enum.valueOf(a.class, string);
        }

        private a(aps aps2) {
            aps aps3 = aps2;
            this((aow)aps3, arg_0 -> ((aps)aps3).z(arg_0));
        }

        private a(aow aow2, Predicate<awt> predicate) {
            this.a = aow2;
            this.a = predicate;
        }

        public boolean a(amu amu2, et et2, awt awt2) {
            return this.a.test(awt2);
        }

        /* synthetic */ a(String string, int n2, aow aow2) {
            this(aow2, null);
        }

        static {
            a = new a[]{a, b, c, d, e, f, g, h, i, j};
        }
    }
}

