/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aow
 *  awt
 */
package baritone;

import baritone.cb;
import baritone.dn;
import baritone.ex;

public final class dm {
    public final int[] a = new int[aow.i.a()];

    public final int a(int n2, awt awt2) {
        int n3;
        int n4 = 0;
        int n5 = cb.c(awt2);
        if (n5 == dn.a) {
            n4 = 2;
        }
        if (n5 == dn.b) {
            n4 |= 4;
        }
        if ((n5 = cb.a(awt2)) == dn.a) {
            n4 |= 8;
        }
        if (n5 == dn.b) {
            n4 |= 0x10;
        }
        if ((n3 = cb.b(awt2)) == dn.a) {
            n4 |= 0x20;
        }
        if (n3 == dn.b) {
            n4 |= 0x40;
        }
        this.a[n2] = n4 |= 1;
        return n4;
    }

    public final boolean a(ex ex2, int n2, int n3, int n4, awt awt2) {
        int n5 = aow.i.a((Object)awt2);
        int n6 = this.a[n5];
        if ((n6 & 1) == 0) {
            n6 = this.a(n5, awt2);
        }
        if ((n6 & 0x10) != 0) {
            return cb.c(ex2, n2, n3, n4, awt2);
        }
        return (n6 & 8) != 0;
    }

    public final boolean b(ex ex2, int n2, int n3, int n4, awt awt2) {
        int n5 = aow.i.a((Object)awt2);
        int n6 = this.a[n5];
        if ((n6 & 1) == 0) {
            n6 = this.a(n5, awt2);
        }
        if ((n6 & 0x40) != 0) {
            return cb.d(ex2, n2, n3, n4, awt2);
        }
        return (n6 & 0x20) != 0;
    }
}

