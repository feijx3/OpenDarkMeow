/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aox
 *  aru
 *  aud
 *  awt
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
import java.util.HashSet;
import java.util.Set;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class df
extends ca {
    private static final BetterBlockPos[] b = new BetterBlockPos[0];
    private final fa a;
    private final int a;
    private final boolean a;

    private df(IBaritone iBaritone, BetterBlockPos betterBlockPos, int n2, fa fa2, boolean bl2) {
        BetterBlockPos betterBlockPos2 = betterBlockPos;
        super(iBaritone, betterBlockPos2, betterBlockPos2.offset(fa2, n2).up(bl2 ? 1 : 0), b, betterBlockPos.offset(fa2, n2).down(bl2 ? 0 : 1));
        this.a = fa2;
        this.a = n2;
        this.a = bl2;
    }

    public static df a(bz bz2, BetterBlockPos betterBlockPos, fa fa2) {
        fw fw2 = new fw();
        df.a(bz2, betterBlockPos.a, betterBlockPos.b, betterBlockPos.c, fa2, fw2);
        int n2 = Math.abs(fw2.a - betterBlockPos.a) + Math.abs(fw2.c - betterBlockPos.c);
        return new df(bz2.a, betterBlockPos, n2, fa2, fw2.b > betterBlockPos.b);
    }

    public static void a(bz bz2, int n2, int n3, int n4, fa fa2, fw fw2) {
        awt awt2;
        int n5;
        int n6;
        int n7;
        if (!bz2.f) {
            return;
        }
        if (n3 == 256 && !bz2.h) {
            return;
        }
        int n8 = fa2.g();
        if (!cb.b(bz2, n2 + n8, n3, n4 + (n7 = fa2.i()))) {
            return;
        }
        awt awt3 = bz2.a(n2 + n8, n3 - 1, n4 + n7);
        if (cb.c(bz2, n2 + n8, n3 - 1, n4 + n7, awt3)) {
            return;
        }
        if (cb.a(awt3.u()) && awt3.u() != aox.j && awt3.u() != aox.i) {
            return;
        }
        if (!cb.b(bz2, n2 + n8, n3 + 1, n4 + n7)) {
            return;
        }
        if (!cb.b(bz2, n2 + n8, n3 + 2, n4 + n7)) {
            return;
        }
        if (!cb.b(bz2, n2, n3 + 2, n4)) {
            return;
        }
        awt3 = bz2.a(n2, n3 - 1, n4);
        if (awt3.u() == aox.bn || awt3.u() == aox.au || awt3.u() instanceof aud || cb.a(awt3)) {
            return;
        }
        if (bz2.j && awt3.u() instanceof aru) {
            return;
        }
        if (bz2.a(n2, n3, n4) instanceof aru) {
            return;
        }
        int n9 = awt3.u() == aox.aW ? 2 : (bz2.d ? 4 : 3);
        int n10 = 1;
        int n11 = 2;
        while (n11 <= n9 && cb.b(bz2, n6 = n2 + n8 * n11, n3 + 1, n5 = n4 + n7 * n11) && cb.b(bz2, n6, n3 + 2, n5)) {
            awt2 = bz2.a.a(n6, n3, n5);
            if (!cb.b(bz2, n6, n3, n5, awt2)) {
                if (n11 > 3 || !bz2.i || !bz2.d || !cb.c(bz2, n6, n3, n5, awt2) || !df.d(bz2.a, n6 + n8, n3 + 1, n5 + n7)) break;
                fw2.a = n6;
                fw2.b = n3 + 1;
                fw2.c = n5;
                fw2.a = (double)n11 * 3.563791874554526 + bz2.e;
                return;
            }
            awt awt4 = bz2.a.a(n6, n3 - 1, n5);
            if (awt4.u() != aox.ak && cb.c(bz2, n6, n3 - 1, n5, awt4) || Math.min(16, bz2.a + 2) >= n11 && cb.a(bz2, awt4)) {
                if (!df.d(bz2.a, n6 + n8, n3, n5 + n7)) break;
                fw2.a = n6;
                fw2.b = n3;
                fw2.c = n5;
                fw2.a = df.a(n11) + bz2.e;
                return;
            }
            if (!cb.b(bz2, n6, n3 + 3, n5)) break;
            n10 = n11++;
        }
        if (!bz2.g) {
            return;
        }
        for (n11 = n10; n11 > 1; --n11) {
            n6 = n2 + n11 * n8;
            n5 = n4 + n11 * n7;
            awt2 = bz2.a(n6, n3 - 1, n5);
            double d2 = bz2.a(n6, n3 - 1, n5, awt2);
            if (d2 >= 1000000.0 || !cb.a(n6, n5, awt2, bz2.a) || !df.d(bz2.a, n6 + n8, n3, n5 + n7)) continue;
            for (n9 = 0; n9 < 5; ++n9) {
                n10 = n6 + a[n9].g();
                int n12 = n3 - 1 + a[n9].h();
                int n13 = n5 + a[n9].i();
                if (n10 == n6 - n8 && n13 == n5 - n7 || !cb.c(bz2.a, n10, n12, n13)) continue;
                fw2.a = n6;
                fw2.b = n3;
                fw2.c = n5;
                fw2.a = df.a(n11) + d2 + bz2.e;
                return;
            }
        }
    }

    private static boolean d(ex ex2, int n2, int n3, int n4) {
        return !cb.a(ex2.a(n2, n3, n4).u()) && !cb.a(ex2.a(n2, n3 + 1, n4).u());
    }

    private static double a(int n2) {
        switch (n2) {
            case 2: {
                return 9.26569376882094;
            }
            case 3: {
                return 13.89854065323141;
            }
            case 4: {
                return 14.255167498218103;
            }
        }
        throw new IllegalStateException("LOL ".concat(String.valueOf(n2)));
    }

    @Override
    public final double a(bz bz2) {
        fw fw2 = new fw();
        df.a(bz2, this.a.a, this.a.b, this.a.c, this.a, fw2);
        if (fw2.a != this.b.a || fw2.b != this.b.b || fw2.c != this.b.c) {
            return 1000000.0;
        }
        return fw2.a;
    }

    @Override
    public final Set<BetterBlockPos> a() {
        HashSet<BetterBlockPos> hashSet = new HashSet<BetterBlockPos>();
        for (int i2 = 0; i2 <= this.a; ++i2) {
            for (int i3 = 0; i3 < 2; ++i3) {
                hashSet.add(this.a.offset(this.a, i2).up(i3));
            }
        }
        return hashSet;
    }

    @Override
    public final boolean b(cc cc2) {
        return cc2.a != MovementStatus.RUNNING;
    }

    @Override
    public final cc a(cc cc2) {
        super.a(cc2);
        if (cc2.a != MovementStatus.RUNNING) {
            return cc2;
        }
        if (this.a.playerFeet().b < this.a.b) {
            this.logDebug("sorry");
            MovementStatus movementStatus = MovementStatus.UNREACHABLE;
            cc cc3 = cc2;
            cc2.a = movementStatus;
            return cc3;
        }
        if (this.a >= 4 || this.a) {
            cc2.a(Input.SPRINT, true);
        }
        cb.a((IPlayerContext)this.a, cc2, (et)this.b);
        if (this.a.playerFeet().equals(this.b)) {
            Object object = ex.a((IPlayerContext)this.a, (et)this.b);
            if (object == aox.bn || object == aox.au) {
                MovementStatus movementStatus = MovementStatus.SUCCESS;
                object = cc2;
                cc2.a = movementStatus;
                return object;
            }
            if (this.a.player().q - (double)this.a.playerFeet().q() < 0.094) {
                cc2.a = MovementStatus.SUCCESS;
            }
        } else if (!this.a.playerFeet().equals(this.a)) {
            if (this.a.playerFeet().equals((Object)this.a.offset(this.a)) || this.a.player().q - (double)this.a.b > 1.0E-4) {
                if (((Boolean)baritone.a.a().allowPlace.value).booleanValue() && ((a)this.a).a.a() && !cb.b((IPlayerContext)this.a, this.b.down()) && !this.a.player().z && cb.a(cc2, (IBaritone)this.a, this.b.down(), true, false) == cb.a.a) {
                    cc2.a(Input.CLICK_RIGHT, true);
                }
                if (this.a == 3 && !this.a) {
                    double d2 = (double)this.a.a + 0.5 - this.a.player().p;
                    double d3 = (double)this.a.c + 0.5 - this.a.player().r;
                    if (Math.max(Math.abs(d2), Math.abs(d3)) < 0.7) {
                        return cc2;
                    }
                }
                cc2.a(Input.JUMP, true);
            } else if (!this.a.playerFeet().equals((Object)this.b.offset(this.a, -1))) {
                cc2.a(Input.SPRINT, false);
                if (this.a.playerFeet().equals((Object)this.a.offset(this.a, -1))) {
                    cb.a((IPlayerContext)this.a, cc2, (et)this.a);
                } else {
                    cb.a((IPlayerContext)this.a, cc2, (et)this.a.offset(this.a, -1));
                }
            }
        }
        return cc2;
    }
}

