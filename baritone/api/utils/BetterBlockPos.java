/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  et
 *  fa
 *  fq
 *  javax.annotation.Nonnull
 *  rk
 */
package baritone.api.utils;

import baritone.api.utils.SettingsUtil;
import javax.annotation.Nonnull;

public final class BetterBlockPos
extends et {
    private static final int NUM_X_BITS = 26;
    private static final int NUM_Z_BITS = 26;
    private static final int NUM_Y_BITS = 12;
    private static final int Y_SHIFT = 26;
    private static final int X_SHIFT = 38;
    private static final long X_MASK = 0x3FFFFFFL;
    private static final long Y_MASK = 4095L;
    private static final long Z_MASK = 0x3FFFFFFL;
    public static final BetterBlockPos ORIGIN = new BetterBlockPos(0, 0, 0);
    public final int a;
    public final int b;
    public final int c;

    public BetterBlockPos(int n2, int n3, int n4) {
        super(n2, n3, n4);
        this.a = n2;
        this.b = n3;
        this.c = n4;
    }

    public BetterBlockPos(double d2, double d3, double d4) {
        this(rk.c((double)d2), rk.c((double)d3), rk.c((double)d4));
    }

    public BetterBlockPos(et et2) {
        this(et2.p(), et2.q(), et2.r());
    }

    public static BetterBlockPos from(et et2) {
        if (et2 == null) {
            return null;
        }
        return new BetterBlockPos(et2);
    }

    public final int hashCode() {
        return (int)BetterBlockPos.longHash(this.a, this.b, this.c);
    }

    public static long longHash(BetterBlockPos betterBlockPos) {
        return BetterBlockPos.longHash(betterBlockPos.a, betterBlockPos.b, betterBlockPos.c);
    }

    public static long longHash(int n2, int n3, int n4) {
        long l2 = 11206370049L + (long)n2;
        l2 = 8734625L * l2 + (long)n3;
        return 2873465L * l2 + (long)n4;
    }

    public final boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof BetterBlockPos) {
            object = (BetterBlockPos)((Object)object);
            return ((BetterBlockPos)((Object)object)).a == this.a && ((BetterBlockPos)((Object)object)).b == this.b && ((BetterBlockPos)((Object)object)).c == this.c;
        }
        return (object = (et)object).p() == this.a && object.q() == this.b && object.r() == this.c;
    }

    public final BetterBlockPos up() {
        return new BetterBlockPos(this.a, this.b + 1, this.c);
    }

    public final BetterBlockPos up(int n2) {
        if (n2 == 0) {
            return this;
        }
        return new BetterBlockPos(this.a, this.b + n2, this.c);
    }

    public final BetterBlockPos down() {
        return new BetterBlockPos(this.a, this.b - 1, this.c);
    }

    public final BetterBlockPos down(int n2) {
        if (n2 == 0) {
            return this;
        }
        return new BetterBlockPos(this.a, this.b - n2, this.c);
    }

    public final BetterBlockPos offset(fa fa2) {
        fa2 = fa2.n();
        return new BetterBlockPos(this.a + fa2.p(), this.b + fa2.q(), this.c + fa2.r());
    }

    public final BetterBlockPos offset(fa fa2, int n2) {
        if (n2 == 0) {
            return this;
        }
        fa2 = fa2.n();
        return new BetterBlockPos(this.a + fa2.p() * n2, this.b + fa2.q() * n2, this.c + fa2.r() * n2);
    }

    public final BetterBlockPos north() {
        return new BetterBlockPos(this.a, this.b, this.c - 1);
    }

    public final BetterBlockPos north(int n2) {
        if (n2 == 0) {
            return this;
        }
        return new BetterBlockPos(this.a, this.b, this.c - n2);
    }

    public final BetterBlockPos south() {
        return new BetterBlockPos(this.a, this.b, this.c + 1);
    }

    public final BetterBlockPos south(int n2) {
        if (n2 == 0) {
            return this;
        }
        return new BetterBlockPos(this.a, this.b, this.c + n2);
    }

    public final BetterBlockPos east() {
        return new BetterBlockPos(this.a + 1, this.b, this.c);
    }

    public final BetterBlockPos east(int n2) {
        if (n2 == 0) {
            return this;
        }
        return new BetterBlockPos(this.a + n2, this.b, this.c);
    }

    public final BetterBlockPos west() {
        return new BetterBlockPos(this.a - 1, this.b, this.c);
    }

    public final BetterBlockPos west(int n2) {
        if (n2 == 0) {
            return this;
        }
        return new BetterBlockPos(this.a - n2, this.b, this.c);
    }

    public final double distanceSq(BetterBlockPos betterBlockPos) {
        double d2 = (double)this.a - (double)betterBlockPos.a;
        double d3 = (double)this.b - (double)betterBlockPos.b;
        double d4 = (double)this.c - (double)betterBlockPos.c;
        double d5 = d2;
        double d6 = d3;
        double d7 = d4;
        return d5 * d5 + d6 * d6 + d7 * d7;
    }

    public final double distanceTo(BetterBlockPos betterBlockPos) {
        double d2 = (double)this.a - (double)betterBlockPos.a;
        double d3 = (double)this.b - (double)betterBlockPos.b;
        double d4 = (double)this.c - (double)betterBlockPos.c;
        double d5 = d2;
        double d6 = d3;
        double d7 = d4;
        return Math.sqrt(d5 * d5 + d6 * d6 + d7 * d7);
    }

    @Nonnull
    public final String toString() {
        return String.format("BetterBlockPos{x=%s,y=%s,z=%s}", SettingsUtil.maybeCensor(this.a), SettingsUtil.maybeCensor(this.b), SettingsUtil.maybeCensor(this.c));
    }

    public static long serializeToLong(int n2, int n3, int n4) {
        return ((long)n2 & 0x3FFFFFFL) << 38 | ((long)n3 & 0xFFFL) << 26 | (long)n4 & 0x3FFFFFFL;
    }

    public static BetterBlockPos deserializeFromLong(long l2) {
        int n2 = (int)(l2 >> 38);
        int n3 = (int)(l2 << 26 >> 52);
        int n4 = (int)(l2 << 38 >> 38);
        return new BetterBlockPos(n2, n3, n4);
    }

    public final /* synthetic */ et a(fa fa2, int n2) {
        return this.offset(fa2, n2);
    }

    public final /* synthetic */ et a(fa fa2) {
        return this.offset(fa2);
    }

    public final /* synthetic */ et g(int n2) {
        return this.east(n2);
    }

    public final /* synthetic */ et f() {
        return this.east();
    }

    public final /* synthetic */ et f(int n2) {
        return this.west(n2);
    }

    public final /* synthetic */ et e() {
        return this.west();
    }

    public final /* synthetic */ et e(int n2) {
        return this.south(n2);
    }

    public final /* synthetic */ et d() {
        return this.south();
    }

    public final /* synthetic */ et d(int n2) {
        return this.north(n2);
    }

    public final /* synthetic */ et c() {
        return this.north();
    }

    public final /* synthetic */ et c(int n2) {
        return this.down(n2);
    }

    public final /* synthetic */ et b() {
        return this.down();
    }

    public final /* synthetic */ et b(int n2) {
        return this.up(n2);
    }

    public final /* synthetic */ et a() {
        return this.up();
    }

    public final /* synthetic */ fq d(fq fq2) {
        return super.c(fq2);
    }

    public final /* synthetic */ int compareTo(Object object) {
        return super.l((fq)object);
    }
}

