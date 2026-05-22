/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  amy
 *  aqq
 *  bhb
 *  bhc
 *  bhc$a
 *  bhe
 *  bud
 *  et
 *  fq
 *  rk
 *  vg
 */
package baritone.api.utils;

import baritone.api.BaritoneAPI;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.RayTraceUtils;
import baritone.api.utils.Rotation;
import baritone.api.utils.VecUtils;
import java.util.Optional;

public final class RotationUtils {
    public static final double DEG_TO_RAD = Math.PI / 180;
    public static final float DEG_TO_RAD_F = (float)Math.PI / 180;
    public static final double RAD_TO_DEG = 57.29577951308232;
    public static final float RAD_TO_DEG_F = 57.29578f;
    private static final bhe[] BLOCK_SIDE_MULTIPLIERS = new bhe[]{new bhe(0.5, 0.0, 0.5), new bhe(0.5, 1.0, 0.5), new bhe(0.5, 0.5, 0.0), new bhe(0.5, 0.5, 1.0), new bhe(0.0, 0.5, 0.5), new bhe(1.0, 0.5, 0.5)};

    private RotationUtils() {
    }

    public static Rotation calcRotationFromCoords(et et2, et et3) {
        return RotationUtils.calcRotationFromVec3d(new bhe((fq)et2), new bhe((fq)et3));
    }

    public static Rotation wrapAnglesToRelative(Rotation rotation, Rotation rotation2) {
        if (rotation.yawIsReallyClose(rotation2)) {
            return new Rotation(rotation.getYaw(), rotation2.getPitch());
        }
        return rotation2.subtract(rotation).normalize().add(rotation);
    }

    public static Rotation calcRotationFromVec3d(bhe bhe2, bhe bhe3, Rotation rotation) {
        return RotationUtils.wrapAnglesToRelative(rotation, RotationUtils.calcRotationFromVec3d(bhe2, bhe3));
    }

    private static Rotation calcRotationFromVec3d(bhe object, bhe bhe2) {
        double[] dArray = new double[]{object.b - bhe2.b, object.c - bhe2.c, object.d - bhe2.d};
        object = dArray;
        double d2 = rk.c((double)dArray[0], (double)(-object[2]));
        double d3 = Math.sqrt((double)(object[0] * object[0] + object[2] * object[2]));
        double d4 = rk.c((double)object[1], (double)d3);
        return new Rotation((float)(d2 * 57.29577951308232), (float)(d4 * 57.29577951308232));
    }

    public static bhe calcLookDirectionFromRotation(Rotation rotation) {
        float f2 = rk.b((float)(-rotation.getYaw() * ((float)Math.PI / 180) - (float)Math.PI));
        float f3 = rk.a((float)(-rotation.getYaw() * ((float)Math.PI / 180) - (float)Math.PI));
        float f4 = -rk.b((float)(-rotation.getPitch() * ((float)Math.PI / 180)));
        float f5 = rk.a((float)(-rotation.getPitch() * ((float)Math.PI / 180)));
        return new bhe((double)(f3 * f4), (double)f5, (double)(f2 * f4));
    }

    @Deprecated
    public static bhe calcVec3dFromRotation(Rotation rotation) {
        return RotationUtils.calcLookDirectionFromRotation(rotation);
    }

    public static Optional<Rotation> reachable(IPlayerContext iPlayerContext, et et2) {
        return RotationUtils.reachable(iPlayerContext, et2, false);
    }

    public static Optional<Rotation> reachable(IPlayerContext iPlayerContext, et et2, boolean bl2) {
        return RotationUtils.reachable(iPlayerContext, et2, iPlayerContext.playerController().getBlockReachDistance(), bl2);
    }

    public static Optional<Rotation> reachable(IPlayerContext iPlayerContext, et et2, double d2) {
        return RotationUtils.reachable(iPlayerContext, et2, d2, false);
    }

    public static Optional<Rotation> reachable(IPlayerContext iPlayerContext, et et2, double d2, boolean bl2) {
        bhb bhb2;
        Optional<Rotation> optional;
        if (((Boolean)BaritoneAPI.getSettings().remainWithExistingLookDirection.value).booleanValue() && iPlayerContext.isLookingAt(et2)) {
            optional = iPlayerContext.playerRotations().add(new Rotation(0.0f, 1.0E-4f));
            if (bl2) {
                bhb2 = RayTraceUtils.rayTraceTowards((vg)iPlayerContext.player(), (Rotation)((Object)optional), d2, true);
                if (bhb2 != null && bhb2.a == bhc.a.b && bhb2.a().equals((Object)et2)) {
                    return Optional.of(optional);
                }
            } else {
                return Optional.of(optional);
            }
        }
        if ((optional = RotationUtils.reachableCenter(iPlayerContext, et2, d2, bl2)).isPresent()) {
            return optional;
        }
        bhb2 = iPlayerContext.world().o(et2).e((amy)iPlayerContext.world(), et2);
        bhe[] bheArray = BLOCK_SIDE_MULTIPLIERS;
        int n2 = BLOCK_SIDE_MULTIPLIERS.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            optional = bheArray[i2];
            double d3 = bhb2.a * ((bhe)optional).b + bhb2.d * (1.0 - ((bhe)optional).b);
            double d4 = bhb2.b * ((bhe)optional).c + bhb2.e * (1.0 - ((bhe)optional).c);
            double d5 = bhb2.c * ((bhe)optional).d + bhb2.f * (1.0 - ((bhe)optional).d);
            optional = RotationUtils.reachableOffset(iPlayerContext, et2, new bhe((fq)et2).b(d3, d4, d5), d2, bl2);
            if (!optional.isPresent()) continue;
            return optional;
        }
        return Optional.empty();
    }

    public static Optional<Rotation> reachableOffset(IPlayerContext iPlayerContext, et et2, bhe object, double d2, boolean bl2) {
        object = RotationUtils.calcRotationFromVec3d(bl2 ? RayTraceUtils.inferSneakingEyePosition((vg)iPlayerContext.player()) : iPlayerContext.player().f(1.0f), object, iPlayerContext.playerRotations());
        Rotation rotation = BaritoneAPI.getProvider().getBaritoneForPlayer(iPlayerContext.player()).getLookBehavior().getAimProcessor().peekRotation((Rotation)object);
        bhc bhc2 = RayTraceUtils.rayTraceTowards((vg)iPlayerContext.player(), rotation, d2, bl2);
        if (bhc2 != null && bhc2.a == bhc.a.b) {
            if (bhc2.a().equals((Object)et2)) {
                return Optional.of(object);
            }
            if (iPlayerContext.world().o(et2).u() instanceof aqq && bhc2.a().equals((Object)et2.b())) {
                return Optional.of(object);
            }
        }
        return Optional.empty();
    }

    public static Optional<Rotation> reachableCenter(IPlayerContext iPlayerContext, et et2, double d2, boolean bl2) {
        return RotationUtils.reachableOffset(iPlayerContext, et2, VecUtils.calculateBlockCenter(iPlayerContext.world(), et2), d2, bl2);
    }

    @Deprecated
    public static Optional<Rotation> reachable(bud bud2, et et2, double d2) {
        return RotationUtils.reachable(bud2, et2, d2, false);
    }

    @Deprecated
    public static Optional<Rotation> reachable(bud bud2, et et2, double d2, boolean bl2) {
        return RotationUtils.reachable(BaritoneAPI.getProvider().getBaritoneForPlayer(bud2).getPlayerContext(), et2, d2, bl2);
    }

    @Deprecated
    public static Optional<Rotation> reachableOffset(vg vg2, et et2, bhe object, double d2, boolean bl2) {
        object = RotationUtils.calcRotationFromVec3d(bl2 ? RayTraceUtils.inferSneakingEyePosition(vg2) : vg2.f(1.0f), object, new Rotation(vg2.v, vg2.w));
        bhc bhc2 = RayTraceUtils.rayTraceTowards(vg2, (Rotation)object, d2, bl2);
        if (bhc2 != null && bhc2.a == bhc.a.b) {
            if (bhc2.a().equals((Object)et2)) {
                return Optional.of(object);
            }
            if (vg2.l.o(et2).u() instanceof aqq && bhc2.a().equals((Object)et2.b())) {
                return Optional.of(object);
            }
        }
        return Optional.empty();
    }

    @Deprecated
    public static Optional<Rotation> reachableCenter(vg vg2, et et2, double d2, boolean bl2) {
        return RotationUtils.reachableOffset(vg2, et2, VecUtils.calculateBlockCenter(vg2.l, et2), d2, bl2);
    }
}

