/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.a;
import baritone.api.pathing.calc.IPath;
import baritone.api.pathing.goals.Goal;
import baritone.api.utils.BetterBlockPos;
import baritone.bw;
import baritone.bx;
import baritone.by;
import baritone.bz;
import baritone.cd;
import baritone.fu;
import baritone.fv;
import baritone.fw;
import baritone.o;
import java.util.Optional;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bv
extends bw {
    private final fv a;
    private final bz a;

    public bv(int n2, int n3, int n4, Goal goal, fv fv2, bz bz2) {
        super(n2, n3, n4, goal, bz2);
        this.a = fv2;
        this.a = bz2;
    }

    @Override
    protected final Optional<IPath> a(long l2, long l3) {
        long l4;
        this.a = this.a((int)this.a, this.b, this.c, BetterBlockPos.longHash((int)this.a, this.b, this.c));
        ((o)((Object)this.a)).b = 0.0;
        ((o)((Object)this.a)).c = ((o)((Object)this.a)).a;
        by by2 = new by();
        by2.a((o)((Object)this.a));
        double[] dArray = new double[7];
        for (int i2 = 0; i2 < 7; ++i2) {
            dArray[i2] = ((o)((Object)this.a)).a;
            this.a[i2] = this.a;
        }
        fw fw2 = new fw();
        fu fu2 = new fu(this.a.a.al());
        long l5 = System.currentTimeMillis();
        boolean bl2 = (Boolean)baritone.a.a().slowPath.value;
        if (bl2) {
            this.logDebug("slowPath is on, path timeout will be " + baritone.a.a().slowPathTimeoutMS.value + "ms instead of " + l2 + "ms");
        }
        long l6 = l5 + (bl2 ? (Long)baritone.a.a().slowPathTimeoutMS.value : l2);
        long l7 = l5 + (bl2 ? (Long)baritone.a.a().slowPathTimeoutMS.value : l3);
        boolean bl3 = true;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        boolean bl4 = !this.a.a.isEmpty();
        int n5 = (Integer)baritone.a.a().pathingMaxChunkBorderFetch.value;
        double d2 = (Boolean)baritone.a.a().minimumImprovementRepropagation.value != false ? 0.01 : 0.0;
        cd[] cdArray = cd.values();
        while (!(by2.a == 0) && n4 < n5 && this.a == false && ((n2 & 0x3F) != 0 || (l4 = System.currentTimeMillis()) - l7 < 0L && (bl3 || l4 - l6 < 0L))) {
            o o2;
            if (bl2) {
                try {
                    Thread.sleep((Long)baritone.a.a().slowPathTimeDelayMS.value);
                }
                catch (InterruptedException interruptedException) {}
            }
            this.b = o2 = by2.a();
            ++n2;
            if (this.a.isInGoal(o2.a, o2.b, o2.c)) {
                this.logDebug("Took " + (System.currentTimeMillis() - l5) + "ms, " + n3 + " movements considered");
                return Optional.of(new bx((o)((Object)this.a), o2, n2, (Goal)((Object)this.a), this.a));
            }
            cd[] cdArray2 = cdArray;
            int n6 = cdArray.length;
            for (int i3 = 0; i3 < n6; ++i3) {
                int n7;
                int n8;
                Object object = cdArray2[i3];
                int n9 = o2.a + object.a;
                int n10 = o2.c + object.c;
                if (!(n9 >> 4 == o2.a >> 4 && n10 >> 4 == o2.c >> 4 || this.a.a.b(n8 = n9, n7 = n10))) {
                    if (object.a) continue;
                    ++n4;
                    continue;
                }
                if (!object.a && !fu2.a(n9, n10) || o2.b + object.b > 256 || o2.b + object.b < 0) continue;
                fw2.a();
                object.a(this.a, o2.a, o2.b, o2.c, fw2);
                ++n3;
                double d3 = fw2.a;
                if (d3 >= 1000000.0) continue;
                if (d3 <= 0.0 || Double.isNaN(d3)) {
                    throw new IllegalStateException((Object)object + " calculated implausible cost " + d3);
                }
                if (object.a && !fu2.a(fw2.a, fw2.c)) continue;
                if (!(object.a || fw2.a == n9 && fw2.c == n10)) {
                    throw new IllegalStateException((Object)object + " " + fw2.a + " " + n9 + " " + fw2.c + " " + n10);
                }
                if (!object.b && fw2.b != o2.b + object.b) {
                    throw new IllegalStateException((Object)object + " " + fw2.b + " " + (o2.b + object.b));
                }
                long l8 = BetterBlockPos.longHash(fw2.a, fw2.b, fw2.c);
                if (bl4) {
                    long l9 = l8;
                    d3 *= this.a.a.get(l9);
                }
                object = this.a(fw2.a, fw2.b, fw2.c, l8);
                double d4 = o2.b + d3;
                if (!(((o)object).b - d4 > d2)) continue;
                ((o)object).a = o2;
                ((o)object).b = d4;
                ((o)object).c = d4 + ((o)object).a;
                if (((o)object).d != -1) {
                    by2.b((o)object);
                } else {
                    by2.a((o)object);
                }
                for (n9 = 0; n9 < 7; ++n9) {
                    double d5 = ((o)object).a + ((o)object).b / a[n9];
                    if (!(dArray[n9] - d5 > d2)) continue;
                    dArray[n9] = d5;
                    this.a[n9] = object;
                    if (!bl3 || !(this.a((o)object) > 25.0)) continue;
                    bl3 = false;
                }
            }
        }
        if (this.a != false) {
            return Optional.empty();
        }
        System.out.println(n3 + " movements considered");
        System.out.println("Open set size: " + by2.a);
        System.out.println("PathNode map size: " + ((bw)this).a.size());
        System.out.println((int)((double)n2 / (double)((float)(System.currentTimeMillis() - l5) / 1000.0f)) + " nodes per second");
        Optional<IPath> optional = this.a(true, n2);
        if (optional.isPresent()) {
            this.logDebug("Took " + (System.currentTimeMillis() - l5) + "ms, " + n3 + " movements considered");
        }
        return optional;
    }
}

