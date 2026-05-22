/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bhc
 *  bhe
 *  vg
 */
package baritone.api.utils;

import baritone.api.utils.IPlayerContext;
import baritone.api.utils.Rotation;
import baritone.api.utils.RotationUtils;

public final class RayTraceUtils {
    private RayTraceUtils() {
    }

    public static bhc rayTraceTowards(vg vg2, Rotation rotation, double d2) {
        return RayTraceUtils.rayTraceTowards(vg2, rotation, d2, false);
    }

    public static bhc rayTraceTowards(vg vg2, Rotation rotation, double d2, boolean bl2) {
        bhe bhe2 = bl2 ? RayTraceUtils.inferSneakingEyePosition(vg2) : vg2.f(1.0f);
        rotation = RotationUtils.calcLookDirectionFromRotation(rotation);
        rotation = bhe2.b(((bhe)rotation).b * d2, ((bhe)rotation).c * d2, ((bhe)rotation).d * d2);
        return vg2.l.a(bhe2, (bhe)rotation, false, false, true);
    }

    public static bhe inferSneakingEyePosition(vg vg2) {
        return new bhe(vg2.p, vg2.q + IPlayerContext.eyeHeight(true), vg2.r);
    }
}

