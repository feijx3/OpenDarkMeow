/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  axn
 */
package baritone;

public final class fu {
    private final double a;
    private final double b;
    private final double c;
    private final double d;

    public fu(axn axn2) {
        this.a = axn2.b();
        this.b = axn2.d();
        this.c = axn2.c();
        this.d = axn2.e();
    }

    public final boolean a(int n2, int n3) {
        return (double)(n2 + 1) > this.a && (double)n2 < this.b && (double)(n3 + 1) > this.c && (double)n3 < this.d;
    }

    public final boolean b(int n2, int n3) {
        return (double)n2 > this.a && (double)(n2 + 1) < this.b && (double)n3 > this.c && (double)(n3 + 1) < this.d;
    }
}

