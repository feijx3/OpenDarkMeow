/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aow
 *  aox
 *  aqm
 *  awt
 *  bhe
 *  com.google.common.collect.ImmutableSet
 *  et
 *  fq
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.pathing.movement.MovementStatus;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.input.Input;
import baritone.bz;
import baritone.ca;
import baritone.cb;
import baritone.cc;
import baritone.ex;
import baritone.fw;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class db
extends ca {
    private int a;
    public boolean a = false;

    public db(IBaritone iBaritone, BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2) {
        super(iBaritone, betterBlockPos, betterBlockPos2, new BetterBlockPos[]{betterBlockPos2.up(2), betterBlockPos2.up(), betterBlockPos2}, betterBlockPos2.down());
    }

    @Override
    public final void reset() {
        super.reset();
        this.a = 0;
        this.a = false;
    }

    @Override
    public final double a(bz bz2) {
        fw fw2 = new fw();
        db.a(bz2, this.a.a, this.a.b, this.a.c, this.b.a, this.b.c, fw2);
        if (fw2.b != this.b.b) {
            return 1000000.0;
        }
        return fw2.a;
    }

    @Override
    public final Set<BetterBlockPos> a() {
        return ImmutableSet.of((Object)this.a, (Object)((Object)this.b.up()), (Object)((Object)this.b));
    }

    public static void a(bz bz2, int n2, int n3, int n4, int n5, int n6, fw fw2) {
        double d2;
        double d3;
        double d4;
        awt awt2 = bz2.a(n5, n3 - 1, n6);
        double d5 = 0.0 + cb.a(bz2, n5, n3 - 1, n6, awt2, false);
        if (d4 >= 1000000.0) {
            return;
        }
        d5 += cb.a(bz2, n5, n3, n6, false);
        if (d3 >= 1000000.0) {
            return;
        }
        d5 += cb.a(bz2, n5, n3 + 1, n6, true);
        if (d2 >= 1000000.0) {
            return;
        }
        aow aow2 = bz2.a(n2, n3 - 1, n4).u();
        if (aow2 == aox.au || aow2 == aox.bn) {
            return;
        }
        awt awt3 = bz2.a(n5, n3 - 2, n6);
        if (!cb.c(bz2, n5, n3 - 2, n6, awt3)) {
            db.a(bz2, n3, n5, n6, d5, awt3, fw2);
            return;
        }
        if (awt2.u() == aox.au || awt2.u() == aox.bn) {
            return;
        }
        if (cb.a(bz2, awt2)) {
            return;
        }
        double d6 = 3.7062775075283763;
        if (aow2 == aox.aW) {
            d6 = 7.4125550150567525;
        }
        fw2.a = n5;
        fw2.b = n3 - 1;
        fw2.c = n6;
        fw2.a = d5 += d6 + Math.max(FALL_N_BLOCKS_COST[1], 0.9265693768820937);
    }

    public static boolean a(bz bz2, int n2, int n3, int n4, double d2, awt awt2, fw fw2) {
        if (d2 != 0.0 && bz2.a(n3, n2 + 2, n4).u() instanceof aqm) {
            return false;
        }
        if (!cb.a(bz2, n3, n2 - 2, n4, awt2)) {
            return false;
        }
        double d3 = 0.0;
        int n5 = n2;
        int n6 = 3;
        int n7;
        while ((n7 = n2 - n6) >= 0) {
            boolean bl2 = n6 >= bz2.b;
            awt awt3 = bz2.a(n3, n7, n4);
            int n8 = n6 - (n2 - n5);
            double d4 = 3.7062775075283763 + FALL_N_BLOCKS_COST[n8] + d2 + d3;
            if (bl2 && cb.b(awt3.u())) {
                if (!cb.a(bz2, n3, n7, n4, awt3)) {
                    return false;
                }
                if (bz2.j) {
                    return false;
                }
                if (cb.a(n3, n7, n4, awt3, bz2.a)) {
                    return false;
                }
                if (!cb.c(bz2, n3, n7 - 1, n4)) {
                    return false;
                }
                fw2.a = n3;
                fw2.b = n7;
                fw2.c = n4;
                fw2.a = d4;
                return false;
            }
            if (bl2 && bz2.k && cb.c(awt3.u())) {
                fw2.a = n3;
                fw2.b = n7;
                fw2.c = n4;
                fw2.a = d4;
                return false;
            }
            if (n8 <= 11 && (awt3.u() == aox.bn || awt3.u() == aox.au)) {
                d3 = d3 + FALL_N_BLOCKS_COST[n8 - 1] + 6.666666666666667;
                n5 = n7;
            } else if (!cb.a(bz2, n3, n7, n4, awt3)) {
                if (!cb.c(bz2, n3, n7, n4, awt3)) {
                    return false;
                }
                if (cb.a(awt3)) {
                    return false;
                }
                if (bl2 && n8 <= bz2.c + 1) {
                    fw2.a = n3;
                    fw2.b = n7 + 1;
                    fw2.c = n4;
                    fw2.a = d4;
                    return false;
                }
                if (bl2 && bz2.b && n8 <= bz2.d + 1) {
                    fw2.a = n3;
                    fw2.b = n7 + 1;
                    fw2.c = n4;
                    fw2.a = d4 + bz2.a();
                    return true;
                }
                return false;
            }
            ++n6;
        }
        return false;
    }

    @Override
    public final cc a(cc object) {
        super.a((cc)object);
        if (((cc)object).a != MovementStatus.RUNNING) {
            return object;
        }
        Object object2 = this.a.playerFeet();
        et et2 = new et((this.b.p() << 1) - this.a.p(), this.b.q(), (this.b.r() << 1) - this.a.r());
        if ((object2.equals((Object)this.b) || object2.equals(et2)) && (cb.f((IPlayerContext)this.a, this.b) || this.a.player().q - (double)this.b.q() < 0.5)) {
            cc cc2 = object;
            object = MovementStatus.SUCCESS;
            object2 = cc2;
            cc2.a = object;
            return object2;
        }
        if (this.b()) {
            double d2 = ((double)this.a.p() + 0.5) * 0.17 + ((double)this.b.p() + 0.5) * 0.83;
            double d3 = ((double)this.a.r() + 0.5) * 0.17 + ((double)this.b.r() + 0.5) * 0.83;
            ((cc)object).a(new cc.a(RotationUtils.calcRotationFromVec3d(this.a.playerHead(), new bhe(d2, (double)this.b.q(), d3), this.a.playerRotations()).withPitch(this.a.playerRotations().getPitch()), false)).a(Input.MOVE_FORWARD, true);
            return object;
        }
        double d4 = this.a.player().p - ((double)this.b.p() + 0.5);
        double d5 = this.a.player().r - ((double)this.b.r() + 0.5);
        double d6 = d4;
        double d7 = d5;
        double d8 = Math.sqrt(d6 * d6 + d7 * d7);
        double d9 = this.a.player().p - ((double)this.a.p() + 0.5);
        double d10 = this.a.player().r - ((double)this.a.r() + 0.5);
        double d11 = d9;
        double d12 = d10;
        double d13 = Math.sqrt(d11 * d11 + d12 * d12);
        if (!object2.equals((Object)this.b) || d8 > 0.25) {
            if (this.a++ < 20 && d13 < 1.25) {
                cb.a((IPlayerContext)this.a, (cc)object, et2);
            } else {
                cb.a((IPlayerContext)this.a, (cc)object, (et)this.b);
            }
        }
        return object;
    }

    public final boolean b() {
        if (this.a) {
            return true;
        }
        et et2 = this.b.b((fq)this.a.down()).a((fq)this.b);
        if (this.c()) {
            return true;
        }
        for (int i2 = 0; i2 <= 2; ++i2) {
            if (!cb.a(ex.a((IPlayerContext)this.a, et2.b(i2)))) continue;
            return true;
        }
        return false;
    }

    public final boolean c() {
        et et2 = this.b.b((fq)this.a.down()).a((fq)this.b);
        return !cb.a((IPlayerContext)this.a, new BetterBlockPos(et2)) && cb.a((IPlayerContext)this.a, new BetterBlockPos(et2).up()) && cb.a((IPlayerContext)this.a, new BetterBlockPos(et2).up(2));
    }
}

