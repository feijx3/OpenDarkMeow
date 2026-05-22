/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bhe
 *  et
 *  fq
 *  rr
 *  vg
 */
package baritone;

import baritone.a;
import baritone.api.IBaritone;
import baritone.api.pathing.calc.IPath;
import baritone.api.pathing.movement.IMovement;
import baritone.api.pathing.movement.MovementStatus;
import baritone.api.pathing.path.IPathExecutor;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Helper;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.VecUtils;
import baritone.api.utils.input.Input;
import baritone.bw;
import baritone.bz;
import baritone.ca;
import baritone.cb;
import baritone.da;
import baritone.db;
import baritone.dc;
import baritone.de;
import baritone.df;
import baritone.dh;
import baritone.dj;
import baritone.dl;
import baritone.ex;
import baritone.h;
import java.util.HashSet;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class dk
implements IPathExecutor,
Helper {
    public final IPath a;
    public int a;
    private int b;
    private int c;
    private Double a;
    private Integer a;
    public boolean a;
    private boolean c;
    public HashSet<et> a;
    public HashSet<et> b;
    public HashSet<et> c = true;
    private final h a;
    public final IPlayerContext a = new HashSet();
    public boolean b = (int)new HashSet();

    public dk(h h2, IPath iPath) {
        this.c = (int)new HashSet();
        this.a = h2;
        this.a = h2.a;
        this.a = iPath;
        this.a = 0;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final boolean a() {
        block46: {
            block48: {
                block50: {
                    block49: {
                        block47: {
                            block44: {
                                block45: {
                                    if (this.a == this.a.length() - 1) {
                                        ++this.a;
                                    }
                                    if (this.a >= this.a.length()) {
                                        return true;
                                    }
                                    var1_1 = (rr<bhe, et>)this.a.movements().get(this.a);
                                    var2_2 = this.a.playerFeet();
                                    if (!var1_1.b().contains(var2_2)) {
                                        for (var3_4 = 0; var3_4 < this.a && var3_4 < this.a.length(); ++var3_4) {
                                            if (!((ca)this.a.movements().get(var3_4)).b().contains(var2_2)) continue;
                                            var2_3 = this.a;
                                            for (var3_4 = this.a = var3_4; var3_4 <= var2_3; ++var3_4) {
                                                this.a.movements().get(var3_4).reset();
                                            }
                                            this.b();
                                            this.a();
                                            return false;
                                        }
                                        for (var3_4 = this.a + 3; var3_4 < this.a.length() - 1; ++var3_4) {
                                            if (!((ca)this.a.movements().get(var3_4)).b().contains(var2_2)) continue;
                                            if (var3_4 - this.a > 2) {
                                                this.logDebug("Skipping forward " + (var3_4 - this.a) + " steps, to " + var3_4);
                                            }
                                            this.a = var3_4 - 1;
                                            this.b();
                                            this.a();
                                            return false;
                                        }
                                    }
                                    v0 = this;
                                    var3_5 = v0.a(v0.a);
                                    if (this.a(var3_5, 2.0)) {
                                        ++this.b;
                                        System.out.println("FAR AWAY FROM PATH FOR " + this.b + " TICKS. Current distance: " + var3_5.a() + ". Threshold: 2.0");
                                        if ((double)this.b > 200.0) {
                                            this.logDebug("Too far away from path for too long, cancelling path");
                                            this.c();
                                            return false;
                                        }
                                    } else {
                                        this.b = 0;
                                    }
                                    if (this.a(var3_5, 3.0)) {
                                        this.logDebug("too far from path");
                                        this.c();
                                        return false;
                                    }
                                    var2_2 = new ex(this.a);
                                    for (var3_6 = this.a - 10; var3_6 < this.a + 10; ++var3_6) {
                                        if (var3_6 < 0 || var3_6 >= this.a.movements().size()) continue;
                                        var6_18 = (ca)this.a.movements().get(var3_6);
                                        var7_22 = var6_18.a((ex)var2_2);
                                        var4_10 = var6_18.b((ex)var2_2);
                                        var5_17 = var6_18.c((ex)var2_2);
                                        var6_18.resetBlockCache();
                                        if (!var7_22.equals(var6_18.a((ex)var2_2))) {
                                            this.c = true;
                                        }
                                        if (!var4_10.equals(var6_18.b((ex)var2_2))) {
                                            this.c = true;
                                        }
                                        if (var5_17.equals(var6_18.c((ex)var2_2))) continue;
                                        this.c = true;
                                    }
                                    if (this.c) {
                                        var3_7 = new HashSet<et>();
                                        var6_18 = new HashSet<E>();
                                        var7_22 = new HashSet<E>();
                                        for (var4_11 = this.a; var4_11 < this.a.movements().size(); ++var4_11) {
                                            var5_17 = (ca)this.a.movements().get(var4_11);
                                            var3_7.addAll(var5_17.a((ex)var2_2));
                                            var6_18.addAll(var5_17.b((ex)var2_2));
                                            var7_22.addAll(var5_17.c((ex)var2_2));
                                        }
                                        this.a = var3_7;
                                        this.b = (int)var6_18;
                                        this.c = (int)var7_22;
                                        this.c = false;
                                    }
                                    if (this.a < this.a.movements().size() - 1) {
                                        var3_8 = this.a.movements().get(this.a + 1);
                                        if (!this.a.a.a.a(var3_8.getDest().a, var3_8.getDest().c)) {
                                            this.logDebug("Pausing since destination is at edge of loaded chunks");
                                            this.a();
                                            return true;
                                        }
                                    }
                                    var3_9 = var1_1.safeToCancel();
                                    if (this.a == null || this.a != this.a) {
                                        this.a = this.a;
                                        this.a = var1_1.getCost();
                                        for (var6_19 = 1; var6_19 < (Integer)baritone.a.a().costVerificationLookahead.value && this.a + var6_19 < this.a.length() - 1; ++var6_19) {
                                            if (!(((ca)this.a.movements().get(this.a + var6_19)).a(this.a.a) >= 1000000.0) || !var3_9) continue;
                                            this.logDebug("Something has changed in the world and a future movement has become impossible. Cancelling.");
                                            this.c();
                                            return true;
                                        }
                                    }
                                    var4_12 /* !! */  = this.a.a;
                                    var2_2 = var1_1;
                                    var1_1.a = null;
                                    var5_17 = var4_12 /* !! */ ;
                                    var4_12 /* !! */  = var2_2;
                                    if (var4_12 /* !! */ .a == null) {
                                        var4_12 /* !! */ .a = var4_12 /* !! */ .a((bz)var5_17);
                                    }
                                    var6_20 = var4_12 /* !! */ .a;
                                    if (v1 >= 1000000.0 && var3_9) {
                                        this.logDebug("Something has changed in the world and this movement has become impossible. Cancelling.");
                                        this.c();
                                        return true;
                                    }
                                    if (!var1_1.calculatedWhileLoaded() && var6_20 - this.a > (Double)baritone.a.a().maxCostIncrease.value && var3_9) {
                                        this.logDebug("Original cost " + this.a + " current cost " + var6_20 + ". Cancelling.");
                                        this.c();
                                        return true;
                                    }
                                    var2_2 = this;
                                    var4_12 /* !! */  = var2_2.a.getInProgress();
                                    if (var4_12 /* !! */ .isPresent() == false ? false : (var2_2.a.player().z == false ? false : (cb.b(var2_2.a, var2_2.a.playerFeet().down()) == false ? false : (cb.a(var2_2.a, var2_2.a.playerFeet()) == false || cb.a(var2_2.a, var2_2.a.playerFeet().up()) == false ? false : (var2_2.a.movements().get(var2_2.a).safeToCancel() == false ? false : ((var4_12 /* !! */  = ((bw)var4_12 /* !! */ .get()).bestPathSoFar()).isPresent() == false ? false : ((var4_12 /* !! */  = ((IPath)var4_12 /* !! */ .get()).positions()).size() < 3 ? false : var4_12 /* !! */ .subList(1, var4_12 /* !! */ .size()).contains((Object)var2_2.a.playerFeet())))))))) {
                                        this.logDebug("Pausing since current best path is a backtrack");
                                        this.a();
                                        return true;
                                    }
                                    var4_12 /* !! */  = var1_1.update();
                                    if (var4_12 /* !! */  == MovementStatus.UNREACHABLE || var4_12 /* !! */  == MovementStatus.FAILED) {
                                        this.logDebug("Movement returns status ".concat(String.valueOf(var4_12 /* !! */ )));
                                        this.c();
                                        return true;
                                    }
                                    if (var4_12 /* !! */  == MovementStatus.SUCCESS) {
                                        ++this.a;
                                        this.b();
                                        this.a();
                                        return true;
                                    }
                                    var2_2 = this;
                                    var4_13 = var2_2.a.a.a.isInputForcedDown(Input.SPRINT);
                                    var2_2.a.a.a.setInputForceState(Input.SPRINT, false);
                                    if (!new bz((IBaritone)var2_2.a.a, (boolean)false).d) ** GOTO lbl-1000
                                    var5_17 = var2_2.a.movements().get(var2_2.a);
                                    if (!(var5_17 instanceof dh) || var2_2.a >= var2_2.a.length() - 3 || !((var1_1 = var2_2.a.movements().get(var2_2.a + 1)) instanceof da) || !dk.a(var2_2.a, (dh)var5_17, (da)var1_1, var2_2.a.movements().get(var2_2.a + 2))) break block44;
                                    var6_21 = var5_17;
                                    var1_1 = var2_2.a;
                                    if (Math.abs((double)var6_21.getDirection().p() * ((double)var6_21.getSrc().c + 0.5 - var1_1.player().r)) + Math.abs((double)var6_21.getDirection().r() * ((double)var6_21.getSrc().a + 0.5 - var1_1.player().p)) > 0.1) ** GOTO lbl-1000
                                    var7_22 = var6_21.getSrc().b((fq)var6_21.getDirection()).b(2);
                                    if (cb.a((IPlayerContext)var1_1, var7_22)) {
                                        v2 = true;
                                    } else if (Math.abs((double)var6_21.getDirection().p() * ((double)var7_22.p() + 0.5 - var1_1.player().p)) + Math.abs((double)var6_21.getDirection().r() * ((double)var7_22.r() + 0.5 - var1_1.player().r)) > 0.8) {
                                        v2 = true;
                                    } else lbl-1000:
                                    // 2 sources

                                    {
                                        v2 = false;
                                    }
                                    if (!v2) break block45;
                                    var2_2.logDebug("Skipping traverse to straight ascend");
                                    ++var2_2.a;
                                    super.b();
                                    var2_2.a();
                                    var2_2.a.a.a.setInputForceState(Input.JUMP, true);
                                    v3 = true;
                                    break block46;
                                }
                                var2_2.logDebug("Too far to the side to safely sprint ascend");
                            }
                            if (!var4_13) break block47;
                            v3 = true;
                            break block46;
                        }
                        if (!(var5_17 instanceof db)) break block48;
                        if (var2_2.a < var2_2.a.length() - 2 && cb.c(var2_2.a, (var1_1 = var2_2.a.movements().get(var2_2.a + 1)).getDest().down()) && (var1_1 instanceof dh || var1_1 instanceof df)) {
                            var4_13 = (Boolean)baritone.a.a().allowPlace.value != false && var2_2.a.a.a.a() != false && var1_1 instanceof df != false;
                            if (var5_17.getDirection().a().a((fq)var1_1.getDirection()).equals((Object)et.a) == false && var5_17.getDirection().a().c((fq)var1_1.getDirection()).equals((Object)et.a) != false && !var4_13) {
                                ((db)var5_17).a = true;
                            }
                        }
                        if (!((db)var5_17).b() || ((db)var5_17).c()) break block49;
                        var2_2.logDebug("Sprinting would be unsafe");
                        ** GOTO lbl-1000
                    }
                    if (var2_2.a >= var2_2.a.length() - 2) break block48;
                    var1_1 = var2_2.a.movements().get(var2_2.a + 1);
                    if (!(var1_1 instanceof da) || !var5_17.getDirection().a().equals((Object)var1_1.getDirection().b())) break block50;
                    ++var2_2.a;
                    super.b();
                    var2_2.a();
                    var2_2.logDebug("Skipping descend to straight ascend");
                    v3 = true;
                    break block46;
                }
                if (!dk.a(var2_2.a, (IMovement)var5_17, (IMovement)var1_1)) break block48;
                if (var1_1 instanceof db && var2_2.a < var2_2.a.length() - 3 && (var4_14 = var2_2.a.movements().get(var2_2.a + 2)) instanceof db && !dk.a(var2_2.a, (IMovement)var1_1, var4_14)) ** GOTO lbl-1000
                if (var2_2.a.playerFeet().equals((Object)var5_17.getDest())) {
                    ++var2_2.a;
                    super.b();
                    var2_2.a();
                }
                v3 = true;
                break block46;
            }
            if (!(var5_17 instanceof da) || var2_2.a == 0) ** GOTO lbl-1000
            var1_1 = var2_2.a.movements().get(var2_2.a - 1);
            if (var1_1 instanceof db && var1_1.getDirection().a().equals((Object)var5_17.getDirection().b()) && var2_2.a.player().q >= (double)(var4_15 = var5_17.getSrc().up()).q() - 0.07) {
                var2_2.a.a.a.setInputForceState(Input.JUMP, false);
                v3 = true;
            } else if (var2_2.a < var2_2.a.length() - 2 && var1_1 instanceof dh && dk.a(var2_2.a, (dh)var1_1, (da)var5_17, var2_2.a.movements().get(var2_2.a + 1))) {
                v3 = true;
            } else if (var5_17 instanceof de && (var1_1 = super.a((de)var5_17)) != null) {
                var4_16 = new BetterBlockPos((et)var1_1.b());
                if (!var2_2.a.positions().contains((Object)var4_16)) {
                    throw new IllegalStateException();
                }
                if (var2_2.a.playerFeet().equals((Object)var4_16)) {
                    var2_2.a = var2_2.a.positions().indexOf((Object)var4_16);
                    super.b();
                    var2_2.a();
                    v3 = true;
                } else {
                    var2_2.a();
                    var2_2.a.a.a.updateTarget(RotationUtils.calcRotationFromVec3d(var2_2.a.playerHead(), (bhe)var1_1.a(), var2_2.a.playerRotations()), false);
                    var2_2.a.a.a.setInputForceState(Input.MOVE_FORWARD, true);
                    v3 = true;
                }
            } else lbl-1000:
            // 4 sources

            {
                v3 = var2_2.b = false;
            }
        }
        if (!this.b) {
            this.a.player().f(false);
        }
        ++this.c;
        if ((double)this.c > this.a + (double)((Integer)baritone.a.a().movementTimeoutTicks.value).intValue()) {
            this.logDebug("This movement has taken too long (" + this.c + " ticks, expected " + this.a + "). Cancelling.");
            this.c();
            return true;
        }
        return var3_9;
    }

    private rr<Double, et> a(IPath object) {
        double d2 = -1.0;
        et et2 = null;
        object = object.movements().iterator();
        while (object.hasNext()) {
            for (et et3 : ((ca)object.next()).b()) {
                double d3 = VecUtils.entityDistanceToCenter((vg)this.a.player(), et3);
                if (!(d3 < d2) && d2 != -1.0) continue;
                d2 = d3;
                et2 = et3;
            }
        }
        return new rr((Object)d2, et2);
    }

    private boolean a(rr<Double, et> et2, double d2) {
        if ((Double)et2.a() > d2) {
            if (this.a.movements().get(this.a) instanceof de) {
                et2 = this.a.positions().get(this.a + 1);
                return VecUtils.entityFlatDistanceToCenter((vg)this.a.player(), et2) >= d2;
            }
            return true;
        }
        return false;
    }

    private rr<bhe, et> a(de de2) {
        IMovement iMovement;
        int n2;
        et et2 = de2.getDirection();
        if (et2.q() < -3) {
            return null;
        }
        if (!de2.a.isEmpty()) {
            return null;
        }
        et2 = new fq(et2.p(), 0, et2.r());
        block0: for (n2 = this.a + 1; n2 < this.a.length() - 1 && n2 < this.a + 3 && (iMovement = this.a.movements().get(n2)) instanceof dh && et2.equals((Object)iMovement.getDirection()); ++n2) {
            for (int i2 = iMovement.getDest().b; i2 <= de2.getSrc().b + 1; ++i2) {
                et et3 = new et(iMovement.getDest().a, i2, iMovement.getDest().c);
                if (!cb.a(this.a, et3)) break block0;
            }
            if (!cb.b(this.a, iMovement.getDest().down())) break;
        }
        if (--n2 == this.a) {
            return null;
        }
        double d2 = (double)(n2 - this.a) - 0.4;
        return new rr((Object)new bhe((double)et2.p() * d2 + (double)de2.getDest().a + 0.5, (double)de2.getDest().b, (double)et2.r() * d2 + (double)de2.getDest().c + 0.5), (Object)de2.getDest().a(et2.p() * (n2 - this.a), 0, et2.r() * (n2 - this.a)));
    }

    private static boolean a(IPlayerContext iPlayerContext, dh dh2, da da2, IMovement iMovement) {
        if (!((Boolean)baritone.a.a().sprintAscends.value).booleanValue()) {
            return false;
        }
        if (!dh2.getDirection().equals((Object)da2.getDirection().b())) {
            return false;
        }
        if (iMovement.getDirection().p() != da2.getDirection().p() || iMovement.getDirection().r() != da2.getDirection().r()) {
            return false;
        }
        if (!cb.b(iPlayerContext, dh2.getDest().down())) {
            return false;
        }
        if (!cb.b(iPlayerContext, da2.getDest().down())) {
            return false;
        }
        if (!da2.a.isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < 2; ++i2) {
            for (int i3 = 0; i3 < 3; ++i3) {
                BetterBlockPos betterBlockPos = dh2.getSrc().up(i3);
                if (i2 == 1) {
                    betterBlockPos = betterBlockPos.a((fq)dh2.getDirection());
                }
                if (cb.a(iPlayerContext, (et)betterBlockPos)) continue;
                return false;
            }
        }
        if (cb.a(iPlayerContext.world().o((et)dh2.getSrc().up(3)).u())) {
            return false;
        }
        return !cb.a(iPlayerContext.world().o((et)da2.getDest().up(2)).u());
    }

    private static boolean a(IPlayerContext iPlayerContext, IMovement iMovement, IMovement iMovement2) {
        if (iMovement2 instanceof db && iMovement2.getDirection().equals((Object)iMovement.getDirection())) {
            return true;
        }
        if (!cb.b(iPlayerContext, iMovement.getDest().a((fq)iMovement.getDirection()))) {
            return false;
        }
        if (iMovement2 instanceof dh && iMovement2.getDirection().b().equals((Object)iMovement.getDirection())) {
            return true;
        }
        return iMovement2 instanceof dc && (Boolean)baritone.a.a().allowOvershootDiagonalDescend.value != false;
    }

    private void b() {
        this.a();
        this.c = 0;
    }

    public final void a() {
        ((a)((Object)this.a.a)).a.clearAllKeys();
    }

    private void c() {
        this.a();
        ((a)((Object)this.a.a)).a.a.a();
        this.a = this.a.length() + 3;
        this.a = true;
    }

    @Override
    public final int getPosition() {
        return this.a;
    }

    public final dk a(dk dk2) {
        if (dk2 == null) {
            return this.a();
        }
        return dl.a(this.a, dk2.a).map(dl2 -> {
            if (!dl2.getDest().equals((Object)dk2.getPath().getDest())) {
                throw new IllegalStateException();
            }
            dk2 = new dk(this.a, (IPath)dl2);
            new dk(this.a, (IPath)dl2).a = this.a;
            dk2.a = this.a;
            dk2.a = this.a;
            dk2.c = this.c;
            return dk2;
        }).orElseGet(this::a);
    }

    private dk a() {
        if (this.a > (Integer)baritone.a.a().maxPathHistoryLength.value) {
            int n2 = (Integer)baritone.a.a().pathHistoryCutoffAmount.value;
            IPath iPath = this.a;
            Object object = new dj(iPath, n2, iPath.length() - 1);
            if (!object.getDest().equals((Object)this.a.getDest())) {
                throw new IllegalStateException();
            }
            this.logDebug("Discarding earliest segment movements, length cut from " + this.a.length() + " to " + object.length());
            object = new dk(this.a, (IPath)object);
            v1.a = this.a - n2;
            ((dk)object).a = this.a;
            if (this.a != null) {
                ((dk)object).a = this.a - n2;
            }
            ((dk)object).c = this.c;
            return object;
        }
        return this;
    }

    @Override
    public final IPath getPath() {
        return this.a;
    }

    public final boolean b() {
        return this.a >= this.a.length();
    }
}

