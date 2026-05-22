/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  amy
 *  aow
 *  aox
 *  aqb
 *  aqr
 *  aru
 *  aun
 *  awt
 *  axp
 *  axw
 *  axx
 *  bcz
 *  et
 */
package baritone;

import baritone.api.pathing.goals.Goal;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.BlockUtils;
import baritone.cb;
import baritone.fy;
import baritone.l;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class o {
    public final int a;
    public final int b;
    public final int c;
    public final double a;
    public double b = 1000000.0;
    public double c;
    public o a = null;
    public int d;

    public static l a(axw axw2) {
        int n2;
        int n3;
        axx[] axxArray;
        HashMap<String, List<et>> hashMap = new HashMap<String, List<et>>();
        BitSet bitSet = new BitSet(131072);
        try {
            axxArray = axw2.h();
            for (n3 = 0; n3 < 16; ++n3) {
                axx axx2 = axxArray[n3];
                if (axx2 == null) continue;
                axp axp2 = axx2.g();
                n2 = n3 << 4;
                for (int i2 = 0; i2 < 16; ++i2) {
                    int n4 = i2 | n2;
                    for (int i3 = 0; i3 < 16; ++i3) {
                        for (int i4 = 0; i4 < 16; ++i4) {
                            aow aow2;
                            int n5 = l.a(i4, n4, i3);
                            awt awt2 = axp2.a(i4, i2, i3);
                            int n6 = i3;
                            int n7 = n4;
                            int n8 = i4;
                            axw axw3 = axw2;
                            Object object = awt2;
                            object = ((aow2 = awt2.u()) == aox.j || aow2 == aox.i ? (cb.b((awt)object) ? fy.c : (n8 != 15 && cb.b((awt)axw3.a((int)(n8 + 1), (int)n7, (int)n6)) || n8 != 0 && cb.b((awt)axw3.a((int)(n8 - 1), (int)n7, (int)n6)) || n6 != 15 && cb.b((awt)axw3.a((int)n8, (int)n7, (int)(n6 + 1))) || n6 != 0 && cb.b((awt)axw3.a((int)n8, (int)n7, (int)(n6 - 1))) ? fy.c : (n8 == 0 || n8 == 15 || n6 == 0 || n6 == 15 ? (aru.a((amy)axw3.q(), (et)new et((int)(n8 + (axw3.b << 4)), (int)n7, (int)(n6 + (axw3.c << 4))), (bcz)object.a(), (awt)object) == -1000.0f ? fy.b : fy.c) : fy.b))) : (cb.a((aow)aow2) || cb.a((awt)object) ? fy.c : (aow2 == aox.a || aow2 instanceof aun || aow2 instanceof aqb || aow2 instanceof aqr ? fy.a : fy.d))).a;
                            bitSet.set(n5, (boolean)object[0]);
                            bitSet.set(n5 + 1, (boolean)object[1]);
                            Object object2 = awt2.u();
                            if (!l.a.contains(object2)) continue;
                            object2 = BlockUtils.blockToString(object2);
                            hashMap.computeIfAbsent((String)object2, string -> new ArrayList()).add(new et(i4, n4, i3));
                        }
                    }
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        axxArray = new awt[256];
        for (n3 = 0; n3 < 16; ++n3) {
            block7: for (int i5 = 0; i5 < 16; ++i5) {
                for (int i6 = 255; i6 >= 0; --i6) {
                    n2 = l.a(i5, i6, n3);
                    if (!bitSet.get(n2) && !bitSet.get(n2 + 1)) continue;
                    axxArray[n3 << 4 | i5] = axw2.a(i5, i6, n3);
                    continue block7;
                }
                axxArray[n3 << 4 | i5] = aox.a.t();
            }
        }
        return new l(axw2.b, axw2.c, bitSet, (awt[])axxArray, hashMap, System.currentTimeMillis());
    }

    public o(int n2, int n3, int n4, Goal goal) {
        this.a = goal.heuristic(n2, n3, n4);
        if (Double.isNaN(this.a)) {
            throw new IllegalStateException(goal + " calculated implausible heuristic");
        }
        this.d = -1;
        this.a = n2;
        this.b = n3;
        this.c = n4;
    }

    public final int hashCode() {
        return (int)BetterBlockPos.longHash(this.a, this.b, this.c);
    }

    public final boolean equals(Object object) {
        object = (o)object;
        return this.a == ((o)object).a && this.b == ((o)object).b && this.c == ((o)object).c;
    }
}

