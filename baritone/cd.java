/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.utils.BetterBlockPos;
import baritone.bz;
import baritone.ca;
import baritone.ce;
import baritone.cf;
import baritone.cg;
import baritone.ch;
import baritone.ci;
import baritone.cj;
import baritone.ck;
import baritone.cl;
import baritone.cm;
import baritone.cn;
import baritone.co;
import baritone.cp;
import baritone.cq;
import baritone.cr;
import baritone.cs;
import baritone.ct;
import baritone.cu;
import baritone.cv;
import baritone.cw;
import baritone.cx;
import baritone.cy;
import baritone.cz;
import baritone.fw;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class cd
extends Enum<cd> {
    private static /* enum */ cd a = new ce();
    private static /* enum */ cd b = new cp();
    private static /* enum */ cd c = new ct();
    private static /* enum */ cd d = new cu();
    private static /* enum */ cd e = new cv();
    private static /* enum */ cd f = new cw();
    private static /* enum */ cd g = new cx();
    private static /* enum */ cd h = new cy();
    private static /* enum */ cd i = new cz();
    private static /* enum */ cd j = new cf();
    private static /* enum */ cd k = new cg();
    private static /* enum */ cd l = new ch();
    private static /* enum */ cd m = new ci();
    private static /* enum */ cd n = new cj();
    private static /* enum */ cd o = new ck();
    private static /* enum */ cd p = new cl();
    private static /* enum */ cd q = new cm();
    private static /* enum */ cd r = new cn();
    private static /* enum */ cd s = new co();
    private static /* enum */ cd t = new cq();
    private static /* enum */ cd u = new cr();
    private static /* enum */ cd v = new cs();
    public final boolean a;
    public final boolean b;
    public final int a;
    public final int b;
    public final int c;
    private static final /* synthetic */ cd[] a;

    public static cd[] values() {
        return (cd[])a.clone();
    }

    public static cd valueOf(String string) {
        return Enum.valueOf(cd.class, string);
    }

    private cd(int n3, int n4, int n5, boolean bl2, boolean bl3) {
        this.a = n3;
        this.b = n4;
        this.c = n5;
        this.a = bl2;
        this.b = bl3;
    }

    private cd(int n3, int n4, int n5) {
        this(n3, n4, n5, false, false);
    }

    public abstract ca a(bz var1, BetterBlockPos var2);

    public void a(bz bz2, int n2, int n3, int n4, fw fw2) {
        if (this.a || this.b) {
            throw new UnsupportedOperationException();
        }
        fw2.a = n2 + this.a;
        fw2.b = n3 + this.b;
        fw2.c = n4 + this.c;
        fw2.a = this.a(bz2, n2, n3, n4);
    }

    public double a(bz bz2, int n2, int n3, int n4) {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ cd(String string, int n2, int n3, int n4, int n5, byte by2) {
        this(n3, n4, n5);
    }

    /* synthetic */ cd(String string, int n2, int n3, int n4, int n5, boolean bl2) {
        this(n3, n4, n5, bl2, true);
    }

    static {
        a = new cd[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v};
    }
}

