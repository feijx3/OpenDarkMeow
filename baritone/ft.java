/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acu
 *  ade
 *  adf
 *  adn
 *  et
 */
package baritone;

import baritone.a;
import baritone.api.utils.IPlayerContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ft {
    final int a;
    final int b;
    final int c;
    final double a;
    final int d;
    private final int e;

    private ft(et et2, double d2, int n2) {
        this(et2.p(), et2.q(), et2.r(), d2, n2);
    }

    private ft(int n2, int n3, int n4, double d2, int n5) {
        this.a = n2;
        this.b = n3;
        this.c = n4;
        this.a = d2;
        this.d = n5;
        int n6 = n5;
        this.e = n6 * n6;
    }

    public static List<ft> a(IPlayerContext iPlayerContext) {
        if (!((Boolean)baritone.a.a().avoidance.value).booleanValue()) {
            return Collections.emptyList();
        }
        ArrayList<ft> arrayList = new ArrayList<ft>();
        double d2 = (Double)baritone.a.a().mobSpawnerAvoidanceCoefficient.value;
        double d3 = (Double)baritone.a.a().mobAvoidanceCoefficient.value;
        if (d2 != 1.0) {
            iPlayerContext.worldData().getCachedWorld().getLocationsOf("mob_spawner", 1, iPlayerContext.playerFeet().a, iPlayerContext.playerFeet().c, 2).forEach(et2 -> arrayList.add(new ft((et)et2, d2, (Integer)baritone.a.a().mobSpawnerAvoidanceRadius.value)));
        }
        if (d3 != 1.0) {
            iPlayerContext.world().e.stream().filter(vg2 -> vg2 instanceof ade).filter(vg2 -> !(vg2 instanceof adn) || (double)iPlayerContext.player().aw() < 0.5).filter(vg2 -> !(vg2 instanceof adf) || ((adf)vg2).dp()).filter(vg2 -> !(vg2 instanceof acu) || ((acu)vg2).do()).forEach(vg2 -> arrayList.add(new ft(new et(vg2), d3, (Integer)baritone.a.a().mobAvoidanceRadius.value)));
        }
        return arrayList;
    }
}

