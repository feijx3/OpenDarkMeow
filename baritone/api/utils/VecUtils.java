/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  amu
 *  amy
 *  aqq
 *  awt
 *  bhe
 *  et
 *  vg
 */
package baritone.api.utils;

public final class VecUtils {
    private VecUtils() {
    }

    public static bhe calculateBlockCenter(amu amu2, et et2) {
        awt awt2 = amu2.o(et2);
        amu2 = awt2.e((amy)amu2, et2);
        double d2 = (amu2.a + amu2.d) / 2.0;
        double d3 = (amu2.b + amu2.e) / 2.0;
        double d4 = (amu2.c + amu2.f) / 2.0;
        if (awt2.u() instanceof aqq) {
            d3 = 0.0;
        }
        return new bhe((double)et2.p() + d2, (double)et2.q() + d3, (double)et2.r() + d4);
    }

    public static bhe getBlockPosCenter(et et2) {
        return new bhe((double)et2.p() + 0.5, (double)et2.q() + 0.5, (double)et2.r() + 0.5);
    }

    public static double distanceToCenter(et et2, double d2, double d3, double d4) {
        double d5 = (double)et2.p() + 0.5 - d2;
        double d6 = (double)et2.q() + 0.5 - d3;
        double d7 = (double)et2.r() + 0.5 - d4;
        double d8 = d5;
        double d9 = d6;
        double d10 = d7;
        return Math.sqrt(d8 * d8 + d9 * d9 + d10 * d10);
    }

    public static double entityDistanceToCenter(vg vg2, et et2) {
        return VecUtils.distanceToCenter(et2, vg2.p, vg2.q, vg2.r);
    }

    public static double entityFlatDistanceToCenter(vg vg2, et et2) {
        return VecUtils.distanceToCenter(et2, vg2.p, (double)et2.q() + 0.5, vg2.r);
    }
}

