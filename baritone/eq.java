/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bhb
 *  et
 *  fa
 *  fq
 */
package baritone;

import baritone.api.selection.ISelection;
import baritone.api.utils.BetterBlockPos;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class eq
implements ISelection {
    private final BetterBlockPos a;
    private final BetterBlockPos b;
    private final BetterBlockPos c;
    private final BetterBlockPos d;
    private final fq a;
    private final bhb a;

    public eq(BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2) {
        this.a = betterBlockPos;
        this.b = betterBlockPos2;
        this.c = new BetterBlockPos(Math.min(betterBlockPos.a, betterBlockPos2.a), Math.min(betterBlockPos.b, betterBlockPos2.b), Math.min(betterBlockPos.c, betterBlockPos2.c));
        this.d = new BetterBlockPos(Math.max(betterBlockPos.a, betterBlockPos2.a), Math.max(betterBlockPos.b, betterBlockPos2.b), Math.max(betterBlockPos.c, betterBlockPos2.c));
        this.a = new fq(this.d.a - this.c.a + 1, this.d.b - this.c.b + 1, this.d.c - this.c.c + 1);
        this.a = new bhb((et)this.c, this.d.a(1, 1, 1));
    }

    @Override
    public final BetterBlockPos pos1() {
        return this.a;
    }

    @Override
    public final BetterBlockPos pos2() {
        return this.b;
    }

    @Override
    public final BetterBlockPos min() {
        return this.c;
    }

    @Override
    public final BetterBlockPos max() {
        return this.d;
    }

    @Override
    public final fq size() {
        return this.a;
    }

    @Override
    public final bhb aabb() {
        return this.a;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public final String toString() {
        return String.format("Selection{pos1=%s,pos2=%s}", new Object[]{this.a, this.b});
    }

    private boolean a(fa fa2) {
        boolean bl2 = fa2.c().a() < 0;
        switch (fa2.k()) {
            case a: {
                return this.b.a > this.a.a ^ bl2;
            }
            case b: {
                return this.b.b > this.a.b ^ bl2;
            }
            case c: {
                return this.b.c > this.a.c ^ bl2;
            }
        }
        throw new IllegalStateException("Bad EnumFacing.Axis");
    }

    @Override
    public final ISelection expand(fa fa2, int n2) {
        if (this.a(fa2)) {
            return new eq(this.a, this.b.offset(fa2, n2));
        }
        return new eq(this.a.offset(fa2, n2), this.b);
    }

    @Override
    public final ISelection contract(fa fa2, int n2) {
        if (this.a(fa2)) {
            return new eq(this.a.offset(fa2, n2), this.b);
        }
        return new eq(this.a, this.b.offset(fa2, n2));
    }

    @Override
    public final ISelection shift(fa fa2, int n2) {
        return new eq(this.a.offset(fa2, n2), this.b.offset(fa2, n2));
    }
}

