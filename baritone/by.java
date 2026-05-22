/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.o;
import java.util.Arrays;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class by {
    private o[] a;
    public int a = new o[1024];

    public by() {
        this(0);
    }

    private by(byte by2) {
    }

    public final void a(o o2) {
        if (this.a >= this.a.length - 1) {
            this.a = Arrays.copyOf(this.a, this.a.length << 1);
        }
        ++this.a;
        o2.d = this.a;
        this.a[this.a] = o2;
        this.b(o2);
    }

    public final void b(o o2) {
        int n2 = o2.d;
        int n3 = n2 >>> 1;
        double d2 = o2.c;
        o o3 = this.a[n3];
        while (n2 > 1 && o3.c > d2) {
            this.a[n2] = o3;
            this.a[n3] = o2;
            o2.d = n3;
            o3.d = n2;
            n2 = n3;
            n3 = n2 >>> 1;
            o3 = this.a[n3];
        }
    }

    public final o a() {
        o o2;
        if (this.a == 0) {
            throw new IllegalStateException();
        }
        o o3 = this.a[1];
        this.a[1] = o2 = this.a[this.a];
        o2.d = 1;
        this.a[this.a] = null;
        --this.a;
        o3.d = -1;
        if (this.a < 2) {
            return o3;
        }
        int n2 = 1;
        int n3 = 2;
        double d2 = o2.c;
        do {
            o o4 = this.a[n3];
            double d3 = o4.c;
            if (n3 < this.a) {
                o o5 = this.a[n3 + 1];
                double d4 = o5.c;
                if (d3 > d4) {
                    ++n3;
                    d3 = d4;
                    o4 = o5;
                }
            }
            if (d2 <= d3) break;
            this.a[n2] = o4;
            this.a[n3] = o2;
            o2.d = n3;
            o4.d = n2;
            n2 = n3;
        } while ((n3 <<= 1) <= this.a);
        return o3;
    }
}

