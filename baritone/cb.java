/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  alm
 *  aow
 *  aox
 *  aph
 *  aqa
 *  aqb
 *  aqb$b
 *  aqh
 *  aqm
 *  aqp
 *  arf
 *  arf$a
 *  arm
 *  aru
 *  asa
 *  att
 *  atw
 *  aud
 *  aur
 *  auy
 *  awt
 *  axf
 *  axj
 *  bhc
 *  bhc$a
 *  bhe
 *  et
 *  fa
 *  fa$a
 *  vg
 *  vp
 */
package baritone;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.pathing.movement.ActionCosts;
import baritone.api.pathing.movement.MovementStatus;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Helper;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.RayTraceUtils;
import baritone.api.utils.Rotation;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.VecUtils;
import baritone.api.utils.input.Input;
import baritone.bz;
import baritone.ca;
import baritone.cc;
import baritone.dm;
import baritone.dn;
import baritone.ex;
import baritone.fi;
import java.util.List;
import java.util.Optional;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public interface cb
extends ActionCosts,
Helper {
    public static boolean a(ex ex2, int n2, int n3, int n4, awt awt2) {
        if (!ex2.a.b(n2, n4)) {
            return true;
        }
        return ((List)baritone.a.a().blocksToDisallowBreaking.value).contains(awt2 = awt2.u()) || awt2 == aox.aI || awt2 instanceof asa || cb.a(ex2, n2, n3 + 1, n4, true) || cb.a(ex2, n2 + 1, n3, n4, false) || cb.a(ex2, n2 - 1, n3, n4, false) || cb.a(ex2, n2, n3, n4 + 1, false) || cb.a(ex2, n2, n3, n4 - 1, false);
    }

    public static boolean a(ex ex2, int n2, int n3, int n4, boolean bl2) {
        awt awt2 = ex2.a(n2, n3, n4);
        aow aow2 = awt2.u();
        if (!bl2 && aow2 instanceof aqm && ((Boolean)baritone.a.a().avoidUpdatingFallingBlocks.value).booleanValue() && aqm.x((awt)ex2.a(n2, n3 - 1, n4))) {
            return true;
        }
        if (aow2 instanceof aru) {
            if (bl2 || ((Boolean)baritone.a.a().strictLiquidCheck.value).booleanValue()) {
                return true;
            }
            if ((Integer)awt2.c((axj)aru.b) == 0) {
                return true;
            }
            return !(ex2.a(n2, n3 - 1, n4).u() instanceof aru);
        }
        return false;
    }

    public static boolean a(IPlayerContext iPlayerContext, BetterBlockPos betterBlockPos) {
        return cb.a(new ex(iPlayerContext), betterBlockPos.a, betterBlockPos.b, betterBlockPos.c);
    }

    public static boolean a(ex ex2, int n2, int n3, int n4) {
        return cb.b(ex2, n2, n3, n4, ex2.a(n2, n3, n4));
    }

    public static boolean a(bz bz2, int n2, int n3, int n4, awt awt2) {
        return bz2.a.a(bz2.a, n2, n3, n4, awt2);
    }

    public static boolean a(bz bz2, int n2, int n3, int n4) {
        return bz2.a.a(bz2.a, n2, n3, n4, bz2.a(n2, n3, n4));
    }

    public static boolean b(ex ex2, int n2, int n3, int n4, awt awt2) {
        int n5 = cb.a(awt2);
        if (n5 == dn.a) {
            return true;
        }
        if (n5 == dn.c) {
            return false;
        }
        return cb.c(ex2, n2, n3, n4, awt2);
    }

    public static int a(awt awt2) {
        aow aow2 = awt2.u();
        if (aow2 == aox.a) {
            return dn.a;
        }
        if (aow2 == aox.ab || aow2 == aox.bS || aow2 == aox.G || aow2 == aox.bF || aow2 == aox.bN || aow2 instanceof att || aow2 instanceof aur || aow2 == aox.cQ) {
            return dn.c;
        }
        if (((List)baritone.a.a().blocksToAvoid.value).contains(aow2)) {
            return dn.c;
        }
        if (aow2 instanceof aqa || aow2 instanceof aqp) {
            if (aow2 == aox.aA) {
                return dn.c;
            }
            return dn.a;
        }
        if (aow2 == aox.cy) {
            return dn.b;
        }
        if (aow2 instanceof atw) {
            return dn.b;
        }
        if (aow2 instanceof aru) {
            if ((Integer)awt2.c((axj)aru.b) != 0) {
                return dn.c;
            }
            return dn.b;
        }
        if (aow2 instanceof aph) {
            return dn.c;
        }
        try {
            if (aow2.b(null, null)) {
                return dn.a;
            }
            return dn.c;
        }
        catch (Throwable throwable) {
            System.out.println("The block " + awt2.u().c() + " requires a special case due to the exception " + throwable.getMessage());
            return dn.b;
        }
    }

    public static boolean c(ex ex2, int n2, int n3, int n4, awt awt2) {
        aow aow2 = awt2.u();
        if (aow2 == aox.cy) {
            return cb.b(ex2, n2, n3 - 1, n4);
        }
        if (aow2 instanceof atw) {
            if (!ex2.a(n2, n4)) {
                return true;
            }
            if ((Integer)awt2.c((axj)atw.a) >= 3) {
                return false;
            }
            return cb.b(ex2, n2, n3 - 1, n4);
        }
        if (aow2 instanceof aru) {
            if (cb.a(n2, n3, n4, awt2, ex2)) {
                return false;
            }
            if (((Boolean)baritone.a.a().assumeWalkOnWater.value).booleanValue()) {
                return false;
            }
            if ((ex2 = ex2.a(n2, n3 + 1, n4)).u() instanceof aru || ex2.u() instanceof auy) {
                return false;
            }
            return aow2 == aox.j || aow2 == aox.i;
        }
        return aow2.b(ex2.a, (et)ex2.a.c(n2, n3, n4));
    }

    public static int b(awt awt2) {
        aow aow2 = awt2.u();
        if (aow2 == aox.a) {
            return dn.a;
        }
        if (aow2 == aox.ab || aow2 == aox.bS || aow2 == aox.G || aow2 == aox.bn || aow2 == aox.au || aow2 == aox.bN || aow2 instanceof aqa || aow2 instanceof aqp || aow2 instanceof atw || aow2 instanceof aru || aow2 instanceof aur || aow2 instanceof aqh || aow2 instanceof att) {
            return dn.c;
        }
        try {
            if (aow2.b(null, null)) {
                return dn.a;
            }
            return dn.c;
        }
        catch (Throwable throwable) {
            System.out.println("The block " + awt2.u().c() + " requires a special case due to the exception " + throwable.getMessage());
            return dn.b;
        }
    }

    public static boolean b(bz bz2, int n2, int n3, int n4) {
        return cb.b(bz2, n2, n3, n4, bz2.a(n2, n3, n4));
    }

    public static boolean b(bz bz2, int n2, int n3, int n4, awt awt2) {
        return bz2.a.b(bz2.a, n2, n3, n4, awt2);
    }

    public static boolean a(IPlayerContext iPlayerContext, et et2) {
        awt awt2 = iPlayerContext.world().o(et2);
        int n2 = cb.b(awt2);
        if (n2 == dn.a) {
            return true;
        }
        if (n2 == dn.c) {
            return false;
        }
        return cb.d(new ex(iPlayerContext), et2.p(), et2.q(), et2.r(), awt2);
    }

    public static boolean d(ex ex2, int n2, int n3, int n4, awt awt2) {
        return awt2.u().b(ex2.a, (et)ex2.a.c(n2, n3, n4));
    }

    public static boolean a(int n2, int n3, awt awt2, ex ex2) {
        aow aow2 = awt2.u();
        if (aow2 == aox.a || cb.b(aow2)) {
            return true;
        }
        if (aow2 instanceof atw) {
            if (!ex2.a(n2, n3)) {
                return true;
            }
            return (Integer)awt2.c((axj)atw.a) == 1;
        }
        if (aow2 instanceof aqb) {
            aqb.b b2 = (aqb.b)awt2.c((axj)aqb.a);
            return b2 == aqb.b.d || b2 == aqb.b.c;
        }
        return awt2.a().j();
    }

    public static boolean a(IPlayerContext iPlayerContext, et object, et et2) {
        if (et2.equals(object)) {
            return false;
        }
        if (!((iPlayerContext = ex.a(iPlayerContext, object)).u() instanceof aqa)) {
            return true;
        }
        et et3 = object;
        axf axf2 = aqa.b;
        object = iPlayerContext;
        iPlayerContext = et3;
        if (!et2.equals((Object)iPlayerContext)) {
            fa.a a2 = ((fa)object.c((axj)arm.D)).k();
            boolean bl2 = (Boolean)object.c((axj)axf2);
            if (et2.c().equals((Object)iPlayerContext) || et2.d().equals((Object)iPlayerContext)) {
                iPlayerContext = fa.a.c;
            } else if (et2.f().equals((Object)iPlayerContext) || et2.e().equals((Object)iPlayerContext)) {
                iPlayerContext = fa.a.a;
            } else {
                return true;
            }
            if (a2 == iPlayerContext == bl2) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(IPlayerContext iPlayerContext, et et2, et et3) {
        if (et3.equals((Object)et2)) {
            return false;
        }
        if (!((iPlayerContext = ex.a(iPlayerContext, et2)).u() instanceof aqp)) {
            return true;
        }
        return (Boolean)iPlayerContext.c((axj)aqp.a);
    }

    public static boolean a(aow aow2) {
        return aow2 instanceof aru || aow2 == aox.df || aow2 == aox.aK || aow2 == aox.ab || aow2 == aox.bF || aow2 == aox.G;
    }

    public static boolean e(ex ex2, int n2, int n3, int n4, awt awt2) {
        int n5 = cb.c(awt2);
        if (n5 == dn.a) {
            return true;
        }
        if (n5 == dn.c) {
            return false;
        }
        return cb.f(ex2, n2, n3, n4, awt2);
    }

    public static int c(awt awt2) {
        aow aow2 = awt2.u();
        if (awt2.k() && aow2 != aox.df) {
            return dn.a;
        }
        if (aow2 == aox.au || aow2 == aox.bn && ((Boolean)baritone.a.a().allowVines.value).booleanValue()) {
            return dn.a;
        }
        if (aow2 == aox.ak || aow2 == aox.da) {
            return dn.a;
        }
        if (aow2 == aox.bQ || aow2 == aox.ae || aow2 == aox.cg) {
            return dn.a;
        }
        if (aow2 == aox.w || aow2 == aox.cG) {
            return dn.a;
        }
        if (aow2 instanceof aud) {
            return dn.a;
        }
        if (cb.b(aow2)) {
            return dn.b;
        }
        if (cb.c(aow2) && ((Boolean)baritone.a.a().assumeWalkOnLava.value).booleanValue()) {
            return dn.b;
        }
        if (aow2 instanceof arf) {
            if (!((Boolean)baritone.a.a().allowWalkOnBottomSlab.value).booleanValue()) {
                if (((arf)aow2).e()) {
                    return dn.a;
                }
                if (awt2.c((axj)arf.a) != arf.a.b) {
                    return dn.a;
                }
                return dn.c;
            }
            return dn.a;
        }
        return dn.c;
    }

    public static boolean f(ex ex2, int n2, int n3, int n4, awt awt2) {
        aow aow2 = awt2.u();
        if (cb.b(aow2)) {
            aow aow3 = ex2.a(n2, n3 + 1, n4).u();
            if (aow3 == aox.bx || aow3 == aox.cy) {
                return true;
            }
            if (cb.a(n2, n3, n4, awt2, ex2) || aow2 == aox.i) {
                return cb.b(aow3) && (Boolean)baritone.a.a().assumeWalkOnWater.value == false;
            }
            return cb.b(aow3) ^ (Boolean)baritone.a.a().assumeWalkOnWater.value;
        }
        return cb.c(aow2) && !cb.a(n2, n3, n4, awt2, ex2) && (Boolean)baritone.a.a().assumeWalkOnLava.value != false;
    }

    public static boolean c(bz object, int n2, int n3, int n4, awt awt2) {
        awt awt3 = awt2;
        int n5 = n4;
        n4 = n3;
        n3 = n2;
        ex ex2 = ((bz)object).a;
        object = ((bz)object).a;
        int n6 = aow.i.a((Object)awt3);
        int n7 = ((dm)object).a[n6];
        if ((n7 & 1) == 0) {
            n7 = ((dm)object).a(n6, awt3);
        }
        if ((n7 & 4) != 0) {
            return cb.f(ex2, n3, n4, n5, awt3);
        }
        return (n7 & 2) != 0;
    }

    public static boolean c(bz bz2, int n2, int n3, int n4) {
        return cb.c(bz2, n2, n3, n4, bz2.a(n2, n3, n4));
    }

    public static boolean b(IPlayerContext iPlayerContext, et et2) {
        return cb.b(new ex(iPlayerContext), et2.p(), et2.q(), et2.r());
    }

    public static boolean b(IPlayerContext iPlayerContext, BetterBlockPos betterBlockPos) {
        return cb.b(new ex(iPlayerContext), betterBlockPos.a, betterBlockPos.b, betterBlockPos.c);
    }

    public static boolean b(ex ex2, int n2, int n3, int n4) {
        return cb.e(ex2, n2, n3, n4, ex2.a(n2, n3, n4));
    }

    public static boolean a(bz bz2, awt awt2) {
        return bz2.a != 0 && (awt2.u() == aox.j || awt2.u() == aox.i) && (Integer)awt2.c((axj)aru.b) == 0;
    }

    public static boolean c(IPlayerContext iPlayerContext, et et2) {
        et2 = ex.a(iPlayerContext, et2);
        return alm.i((vp)iPlayerContext.player()) && (et2.u() == aox.j || et2.u() == aox.i) && (Integer)et2.c((axj)aru.b) == 0;
    }

    public static boolean d(bz bz2, int n2, int n3, int n4, awt awt2) {
        if ((awt2 = awt2.u()) == aox.au || awt2 == aox.bn) {
            return false;
        }
        if (awt2 instanceof aru) {
            if (bz2.j) {
                return false;
            }
            if (bz2.a(n2, n3 + 1, n4) instanceof aru) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(ex ex2, int n2, int n3, int n4) {
        awt awt2 = ex2.a(n2, n3, n4);
        n3 = n4;
        return ex2.a.b(n2, n3) && (awt2.k() || awt2.b() || awt2.u() == aox.w || awt2.u() == aox.cG);
    }

    public static boolean d(IPlayerContext iPlayerContext, et et2) {
        return cb.c(new ex(iPlayerContext), et2.p(), et2.q(), et2.r());
    }

    public static double a(bz bz2, int n2, int n3, int n4, boolean bl2) {
        return cb.a(bz2, n2, n3, n4, bz2.a(n2, n3, n4), bl2);
    }

    public static double a(bz bz2, int n2, int n3, int n4, awt awt2, boolean bl2) {
        aow aow2 = awt2.u();
        if (!cb.a(bz2, n2, n3, n4, awt2)) {
            double d2;
            double d3;
            if (aow2 instanceof aru) {
                return 1000000.0;
            }
            double d4 = bz2.b(n2, n3, n4, awt2);
            if (d3 >= 1000000.0) {
                return 1000000.0;
            }
            if (cb.a(bz2.a, n2, n3, n4, awt2)) {
                return 1000000.0;
            }
            double d5 = bz2.a.a(awt2);
            if (d2 <= 0.0) {
                return 1000000.0;
            }
            double d6 = (1.0 / d5 + bz2.c) * d4;
            if (bl2 && (awt2 = bz2.a(n2, n3 + 1, n4)).u() instanceof aqm) {
                d6 += cb.a(bz2, n2, n3 + 1, n4, awt2, true);
            }
            return d6;
        }
        return 0.0;
    }

    public static boolean a(awt awt2) {
        return awt2.u() instanceof arf && !((arf)awt2.u()).e() && awt2.c((axj)arf.a) == arf.a.b;
    }

    public static void a(IPlayerContext iPlayerContext, awt awt2) {
        cb.a(iPlayerContext, awt2, new fi(iPlayerContext.player()), (Boolean)BaritoneAPI.getSettings().preferSilkTouch.value);
    }

    public static void a(IPlayerContext iPlayerContext, awt awt2, fi fi2, boolean bl2) {
        if (((Boolean)baritone.a.a().autoTool.value).booleanValue() && !((Boolean)baritone.a.a().assumeExternalAutoTool.value).booleanValue()) {
            iPlayerContext.player().bv.d = fi2.a(awt2.u(), bl2, false);
        }
    }

    public static void a(IPlayerContext iPlayerContext, cc cc2, et et2) {
        cc2.a(new cc.a(RotationUtils.calcRotationFromVec3d(iPlayerContext.playerHead(), VecUtils.getBlockPosCenter(et2), iPlayerContext.playerRotations()).withPitch(iPlayerContext.playerRotations().getPitch()), false)).a(Input.MOVE_FORWARD, true);
    }

    public static boolean b(aow aow2) {
        return aow2 == aox.i || aow2 == aox.j;
    }

    public static boolean e(IPlayerContext iPlayerContext, et et2) {
        return cb.b(ex.a(iPlayerContext, et2));
    }

    public static boolean c(aow aow2) {
        return aow2 == aox.k || aow2 == aox.l;
    }

    public static boolean f(IPlayerContext iPlayerContext, et et2) {
        return ex.a(iPlayerContext, et2) instanceof aru;
    }

    public static boolean b(awt awt2) {
        return awt2.u() instanceof aru && (Integer)awt2.c((axj)aru.b) != 0;
    }

    public static boolean a(int n2, int n3, int n4, awt awt2, ex ex2) {
        if (!(awt2.u() instanceof aru)) {
            return false;
        }
        if ((Integer)awt2.c((axj)aru.b) != 0) {
            return true;
        }
        return cb.b(ex2.a(n2 + 1, n3, n4)) || cb.b(ex2.a(n2 - 1, n3, n4)) || cb.b(ex2.a(n2, n3, n4 + 1)) || cb.b(ex2.a(n2, n3, n4 - 1));
    }

    public static int a(cc cc2, IBaritone iBaritone, et et2, boolean bl2, boolean bl3) {
        et et3;
        IPlayerContext iPlayerContext = iBaritone.getPlayerContext();
        Optional<Rotation> optional = RotationUtils.reachable(iPlayerContext, et2, bl3);
        boolean bl4 = false;
        if (optional.isPresent()) {
            cc2.a(new cc.a(optional.get(), true));
            bl4 = true;
        }
        for (int i2 = 0; i2 < 5; ++i2) {
            et3 = et2.a(ca.a[i2]);
            if (!cb.d(iPlayerContext, et3)) continue;
            if (!((baritone.a)iBaritone).a.a(false, et2.p(), et2.q(), et2.r())) {
                Helper.HELPER.logDebug("bb pls get me some blocks. dirt, netherrack, cobble");
                cc2.a = MovementStatus.UNREACHABLE;
                return a.c;
            }
            double d2 = ((double)(et2.p() + et3.p()) + 1.0) * 0.5;
            double d3 = ((double)(et2.q() + et3.q()) + 0.5) * 0.5;
            double d4 = ((double)(et2.r() + et3.r()) + 1.0) * 0.5;
            Rotation rotation = RotationUtils.calcRotationFromVec3d(bl3 ? RayTraceUtils.inferSneakingEyePosition((vg)iPlayerContext.player()) : iPlayerContext.playerHead(), new bhe(d2, d3, d4), iPlayerContext.playerRotations());
            Rotation rotation2 = iBaritone.getLookBehavior().getAimProcessor().peekRotation(rotation);
            rotation2 = RayTraceUtils.rayTraceTowards((vg)iPlayerContext.player(), rotation2, iPlayerContext.playerController().getBlockReachDistance(), bl3);
            if (rotation2 == null || ((bhc)rotation2).a != bhc.a.b || !rotation2.a().equals((Object)et3) || !rotation2.a().a(((bhc)rotation2).b).equals((Object)et2)) continue;
            cc2.a(new cc.a(rotation, true));
            bl4 = true;
            if (!bl2) break;
        }
        if (iPlayerContext.getSelectedBlock().isPresent()) {
            et et4 = iPlayerContext.getSelectedBlock().get();
            et3 = iPlayerContext.objectMouseOver().b;
            if (et4.equals((Object)et2) || cb.d(iPlayerContext, et4) && et4.a((fa)et3).equals((Object)et2)) {
                if (bl3) {
                    cc2.a(Input.SNEAK, true);
                }
                ((baritone.a)iBaritone).a.a(true, et2.p(), et2.q(), et2.r());
                return a.a;
            }
        }
        if (bl4) {
            if (bl3) {
                cc2.a(Input.SNEAK, true);
            }
            ((baritone.a)iBaritone).a.a(true, et2.p(), et2.q(), et2.r());
            return a.b;
        }
        return a.c;
    }

    public static boolean d(aow aow2) {
        return aow2 == aox.a || aow2 == aox.k || aow2 == aox.i || aow2 == aox.j;
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    public static final class a
    extends Enum<a> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] a;

        public static int[] a() {
            return (int[])a.clone();
        }

        static {
            a = new int[]{1, 2, 3};
        }
    }
}

