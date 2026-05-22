/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aow
 *  aox
 *  awt
 *  bud
 *  com.google.common.collect.ImmutableSet
 *  et
 *  fa
 */
package baritone;

import baritone.a;
import baritone.api.IBaritone;
import baritone.api.pathing.movement.MovementStatus;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.input.Input;
import baritone.bz;
import baritone.ca;
import baritone.cb;
import baritone.cc;
import baritone.ex;
import baritone.fw;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class dc
extends ca {
    private static final double a = Math.sqrt(2.0);

    public dc(IBaritone iBaritone, BetterBlockPos betterBlockPos, fa fa2, fa fa3, int n2) {
        BetterBlockPos betterBlockPos2 = betterBlockPos;
        this(iBaritone, betterBlockPos2, betterBlockPos2.offset(fa2), betterBlockPos.offset(fa3), fa3, n2);
    }

    private dc(IBaritone iBaritone, BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2, BetterBlockPos betterBlockPos3, fa fa2, int n2) {
        this(iBaritone, betterBlockPos, betterBlockPos2.offset(fa2).up(n2), betterBlockPos2, betterBlockPos3);
    }

    private dc(IBaritone iBaritone, BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2, BetterBlockPos betterBlockPos3, BetterBlockPos betterBlockPos4) {
        super(iBaritone, betterBlockPos, betterBlockPos2, new BetterBlockPos[]{betterBlockPos3, betterBlockPos3.up(), betterBlockPos4, betterBlockPos4.up(), betterBlockPos2, betterBlockPos2.up()});
    }

    @Override
    public final boolean b(cc cc2) {
        cc2 = this.a.player();
        double d2 = ((bud)cc2).p;
        double d3 = ((bud)cc2).q - 1.0;
        double d4 = ((bud)cc2).r;
        if (this.a.playerFeet().equals(this.a)) {
            return true;
        }
        if (cb.b((IPlayerContext)this.a, new et(this.a.a, this.a.b - 1, this.b.c)) && cb.b((IPlayerContext)this.a, new et(this.b.a, this.a.b - 1, this.a.c))) {
            return true;
        }
        if (this.a.playerFeet().equals((Object)new BetterBlockPos(this.a.a, this.a.b, this.b.c)) || this.a.playerFeet().equals((Object)new BetterBlockPos(this.b.a, this.a.b, this.a.c))) {
            return cb.b((IPlayerContext)this.a, new BetterBlockPos(d2 + 0.25, d3, d4 + 0.25)) || cb.b((IPlayerContext)this.a, new BetterBlockPos(d2 + 0.25, d3, d4 - 0.25)) || cb.b((IPlayerContext)this.a, new BetterBlockPos(d2 - 0.25, d3, d4 + 0.25)) || cb.b((IPlayerContext)this.a, new BetterBlockPos(d2 - 0.25, d3, d4 - 0.25));
        }
        return true;
    }

    @Override
    public final double a(bz bz2) {
        fw fw2 = new fw();
        dc.a(bz2, this.a.a, this.a.b, this.a.c, this.b.a, this.b.c, fw2);
        if (fw2.b != this.b.b) {
            return 1000000.0;
        }
        return fw2.a;
    }

    @Override
    public final Set<BetterBlockPos> a() {
        BetterBlockPos betterBlockPos = new BetterBlockPos(this.a.a, this.a.b, this.b.c);
        BetterBlockPos betterBlockPos2 = new BetterBlockPos(this.b.a, this.a.b, this.a.c);
        if (this.b.b < this.a.b) {
            return ImmutableSet.of((Object)this.a, (Object)((Object)this.b.up()), (Object)((Object)betterBlockPos), (Object)((Object)betterBlockPos2), (Object)((Object)this.b), (Object)((Object)betterBlockPos.down()), (Object[])new BetterBlockPos[]{betterBlockPos2.down()});
        }
        if (this.b.b > this.a.b) {
            return ImmutableSet.of((Object)this.a, (Object)((Object)this.a.up()), (Object)((Object)betterBlockPos), (Object)((Object)betterBlockPos2), (Object)((Object)this.b), (Object)((Object)betterBlockPos.up()), (Object[])new BetterBlockPos[]{betterBlockPos2.up()});
        }
        return ImmutableSet.of((Object)this.a, (Object)((Object)this.b), (Object)((Object)betterBlockPos), (Object)((Object)betterBlockPos2));
    }

    public static void a(bz bz2, int n2, int n3, int n4, int n5, int n6, fw fw2) {
        awt awt2;
        awt awt3;
        if (!cb.a(bz2, n5, n3 + 1, n6)) {
            return;
        }
        awt awt4 = bz2.a(n5, n3, n6);
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        if (!cb.a(bz2, n5, n3, n6, awt4)) {
            bl2 = true;
            if (!(bz2.m && cb.a(bz2, n2, n3 + 2, n4) && cb.c(bz2, n5, n3, n6, awt4) && cb.a(bz2, n5, n3 + 2, n6))) {
                return;
            }
            awt3 = awt4;
            awt2 = bz2.a(n2, n3 - 1, n4);
        } else {
            awt3 = bz2.a(n5, n3 - 1, n6);
            awt2 = bz2.a(n2, n3 - 1, n4);
            bl4 = cb.d(bz2, n2, n3 - 1, n4, awt2) && cb.a(bz2, awt3);
            if (!bl4 && !cb.c(bz2, n5, n3 - 1, n6, awt3)) {
                bl3 = true;
                if (!(bz2.l && cb.c(bz2, n5, n3 - 2, n6) && cb.a(bz2, n5, n3 - 1, n6, awt3))) {
                    return;
                }
            }
            bl4 &= !bz2.j;
        }
        double d2 = 4.63284688441047;
        if (awt3.u() == aox.aW) {
            d2 = 6.949270326615705;
        } else if (!bl4 && awt3.u() == aox.j) {
            d2 = 4.63284688441047 + bz2.f * a;
        }
        awt2 = awt2.u();
        if (awt2 == aox.au || awt2 == aox.bn) {
            return;
        }
        if (awt2 == aox.aW) {
            d2 += 2.316423442205235;
        }
        if ((awt2 = bz2.a(n2, n3 - 1, n6).u()) == aox.df || cb.c((aow)awt2)) {
            return;
        }
        awt2 = bz2.a(n5, n3 - 1, n4).u();
        if (awt2 == aox.df || cb.c((aow)awt2)) {
            return;
        }
        awt2 = bz2.a(n2, n3, n4);
        boolean bl5 = false;
        if (cb.b((aow)awt2) || cb.b(awt4.u())) {
            if (bl2) {
                return;
            }
            d2 = bz2.b;
            bl5 = true;
        }
        awt4 = bz2.a(n2, n3, n6);
        awt awt5 = bz2.a(n5, n3, n4);
        if (bl2) {
            boolean bl6 = cb.a(bz2, n2, n3 + 2, n6);
            boolean bl7 = cb.a(bz2, n2, n3 + 1, n6);
            boolean bl8 = cb.a(bz2, n2, n3, n6, awt4);
            boolean bl9 = cb.a(bz2, n5, n3 + 2, n4);
            bl2 = cb.a(bz2, n5, n3 + 1, n4);
            boolean bl10 = cb.a(bz2, n5, n3, n4, awt5);
            if ((!bl6 || !bl7 || !bl8) && (!bl9 || !bl2 || !bl10) || cb.a(awt4.u()) || cb.a(awt5.u()) || bl6 && bl7 && cb.c(bz2, n2, n3, n6, awt4) || bl9 && bl2 && cb.c(bz2, n5, n3, n4, awt5) || !bl6 && bl7 && bl8 || !bl9 && bl2 && bl10) {
                return;
            }
            fw2.a = d2 * a + JUMP_ONE_BLOCK_COST;
            fw2.a = n5;
            fw2.c = n6;
            fw2.b = n3 + 1;
            return;
        }
        double d3 = cb.a(bz2, n2, n3, n6, awt4, false);
        double d4 = cb.a(bz2, n5, n3, n4, awt5, false);
        if (d3 != 0.0 && d4 != 0.0) {
            return;
        }
        awt awt6 = bz2.a(n2, n3 + 1, n6);
        if ((d3 += cb.a(bz2, n2, n3 + 1, n6, awt6, true)) != 0.0 && d4 != 0.0) {
            return;
        }
        awt awt7 = bz2.a(n5, n3 + 1, n4);
        if (d3 == 0.0 && (cb.a(awt5.u()) && awt5.u() != aox.j || cb.a(awt7.u()))) {
            return;
        }
        if (d3 != 0.0 && (d4 += cb.a(bz2, n5, n3 + 1, n4, awt7, true)) != 0.0) {
            return;
        }
        if (d4 == 0.0 && (cb.a(awt4.u()) && awt4.u() != aox.j || cb.a(awt6.u()))) {
            return;
        }
        if (d3 != 0.0 || d4 != 0.0) {
            d2 *= a - 0.001;
            if (awt2 == aox.au || awt2 == aox.bn) {
                return;
            }
        } else if (bz2.d && !bl5) {
            d2 *= 0.7692444761225944;
        }
        fw2.a = d2 * a;
        if (bl3) {
            fw2.a += Math.max(FALL_N_BLOCKS_COST[1], 0.9265693768820937);
            fw2.b = n3 - 1;
        } else {
            fw2.b = n3;
        }
        fw2.a = n5;
        fw2.c = n6;
    }

    @Override
    public final cc a(cc object) {
        boolean bl2;
        block8: {
            super.a((cc)object);
            if (((cc)object).a != MovementStatus.RUNNING) {
                return object;
            }
            if (this.a.playerFeet().equals((Object)this.b)) {
                cc cc2 = object;
                object = MovementStatus.SUCCESS;
                cc cc3 = cc2;
                cc2.a = object;
                return cc3;
            }
            if (!(this.a() || cb.f((IPlayerContext)this.a, (et)this.a) && this.b().contains((Object)this.a.playerFeet().up()))) {
                Object object2 = object;
                object = MovementStatus.UNREACHABLE;
                Object object3 = object2;
                object2.a = object;
                return object3;
            }
            if (this.b.b > this.a.b && this.a.player().q < (double)this.a.b + 0.1 && this.a.player().A) {
                ((cc)object).a(Input.JUMP, true);
            }
            dc dc2 = this;
            if (cb.f((IPlayerContext)dc2.a, dc2.a.playerFeet()) && !((Boolean)baritone.a.a().sprintInWater.value).booleanValue()) {
                bl2 = false;
            } else {
                for (int i2 = 0; i2 < 4; ++i2) {
                    if (cb.a((IPlayerContext)dc2.a, (BetterBlockPos)dc2.a[i2])) continue;
                    bl2 = false;
                    break block8;
                }
                bl2 = true;
            }
        }
        if (bl2) {
            ((cc)object).a(Input.SPRINT, true);
        }
        cb.a((IPlayerContext)this.a, (cc)object, (et)this.b);
        return object;
    }

    @Override
    public final boolean a(cc cc2) {
        return true;
    }

    @Override
    public final List<et> a(ex ex2) {
        if (this.a != null) {
            return this.a;
        }
        ArrayList<et> arrayList = new ArrayList<et>();
        for (int i2 = 4; i2 < 6; ++i2) {
            if (cb.a(ex2, this.a[i2].a, this.a[i2].b, this.a[i2].c)) continue;
            arrayList.add((et)this.a[i2]);
        }
        this.a = (double)arrayList;
        return arrayList;
    }

    @Override
    public final List<et> c(ex ex2) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        ArrayList<void> arrayList = new ArrayList<void>();
        for (int i2 = 0; i2 < 4; ++i2) {
            if (cb.a(ex2, this.a[i2].a, this.a[i2].b, this.a[i2].c)) continue;
            arrayList.add(this.a[i2]);
        }
        this.b = arrayList;
        return this.b;
    }
}

