/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aow
 *  awt
 *  axj
 *  fq
 *  fy
 *  javax.annotation.Nullable
 *  nf
 *  org.apache.commons.lang3.Validate
 */
package baritone;

import baritone.fr;
import baritone.ge;
import java.util.Optional;
import javax.annotation.Nullable;
import org.apache.commons.lang3.Validate;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class gj
extends ge {
    public final fq a;
    public final fy a;

    public gj(fy fy2, boolean bl2) {
        this.a = fy2;
        this.a = new fq(this.a("x"), this.a("y"), this.a("z"));
        this.y = Math.abs(this.a.p("Metadata").p("EnclosingSize").h("y"));
        if (bl2) {
            this.x = Math.abs(this.a.p("Metadata").p("EnclosingSize").h("z"));
            this.z = Math.abs(this.a.p("Metadata").p("EnclosingSize").h("x"));
        } else {
            this.x = Math.abs(this.a.p("Metadata").p("EnclosingSize").h("x"));
            this.z = Math.abs(this.a.p("Metadata").p("EnclosingSize").h("z"));
        }
        this.a = new awt[this.x][this.z][this.y];
        this.a();
    }

    private static String[] a(fy fy2) {
        return fy2.p("Regions").c().toArray(new String[0]);
    }

    private static int a(fy fy2, String string, String string2) {
        int n2 = fy2.p("Regions").p(string).p("Position").h(string2);
        int n3 = fy2.p("Regions").p(string).p("Size").h(string2);
        if (n3 < 0) {
            ++n3;
        }
        int n4 = n2;
        return Math.min(n4, n4 + n3);
    }

    private static awt a(aow aow2, fy fy2) {
        awt awt2 = aow2.t();
        for (Object object : fy2.c().toArray()) {
            Object object2 = aow2.s().a((String)object);
            object = fy2.l((String)object);
            if (object2 == null) continue;
            axj axj2 = object2;
            object2 = object;
            object = axj2;
            if (!((Optional)(object2 = object.b((String)object2).toJavaUtil())).isPresent()) {
                throw new IllegalArgumentException("Invalid value for property ".concat(String.valueOf(object)));
            }
            awt2 = awt2.a((axj)object, (Comparable)((Optional)object2).get());
        }
        return awt2;
    }

    private int a(String string) {
        int n2 = Integer.MAX_VALUE;
        for (String string2 : gj.a(this.a)) {
            n2 = Math.min(n2, gj.a(this.a, string2, string));
        }
        return n2;
    }

    private void a() {
        for (String string : gj.a(this.a)) {
            Object object;
            Object object2 = object = this.a.p("Regions").p(string).c("BlockStatePalette", 10);
            Object object3 = new awt[object.c()];
            for (int i2 = 0; i2 < object2.c(); ++i2) {
                aow aow2 = (aow)aow.h.c((Object)new nf(((fy)object2.i(i2)).l("Name")));
                fy fy2 = ((fy)object2.i(i2)).p("Properties");
                object3[i2] = gj.a(aow2, fy2);
            }
            awt[] awtArray = object3;
            int n2 = object.c();
            int n3 = (int)Math.max(2.0, Math.ceil(Math.log(n2) / Math.log(2.0)));
            object3 = string;
            object2 = this.a;
            long l2 = Math.abs(object2.p("Regions").p((String)object3).p("Size").h("x") * object2.p("Regions").p((String)object3).p("Size").h("y") * object2.p("Regions").p((String)object3).p("Size").h("z"));
            object3 = string;
            object2 = ((fr)this.a.p("Regions").p((String)object3).c("BlockStates")).getLongArray();
            object = new a(n3, l2, (long[])object2);
            gj gj2 = this;
            gj2.a(gj2.a, string, awtArray, (a)object);
        }
    }

    private void a(fy fy2, String string, awt[] awtArray, a a2) {
        fq fq2 = new fq(gj.a(fy2, string, "x"), gj.a(fy2, string, "y"), gj.a(fy2, string, "z"));
        int n2 = 0;
        for (int i2 = 0; i2 < this.y; ++i2) {
            for (int i3 = 0; i3 < this.z; ++i3) {
                for (int i4 = 0; i4 < this.x; ++i4) {
                    int n3;
                    int n4 = i3;
                    int n5 = i2;
                    int n6 = i4;
                    String string2 = string;
                    Object object = fy2;
                    if (!(n6 >= 0 && n5 >= 0 && n4 >= 0 && n6 < Math.abs(object.p("Regions").p(string2).p("Size").h("x")) && n5 < Math.abs(object.p("Regions").p(string2).p("Size").h("y")) && n4 < Math.abs(object.p("Regions").p(string2).p("Size").h("z")))) continue;
                    fq fq3 = this.a[i4 - (this.a.p() - fq2.p())][i3 - (this.a.r() - fq2.r())];
                    int n7 = i2 - (this.a.q() - fq2.q());
                    long l2 = n2;
                    object = a2;
                    Validate.inclusiveBetween((long)0L, (long)(object.b - 1L), (long)l2);
                    long l3 = l2 * (long)object.a;
                    int n8 = (int)(l3 >> 6);
                    int n9 = (int)((l2 + 1L) * (long)object.a - 1L >> 6);
                    n6 = (int)(l3 & 0x3FL);
                    if (n8 == n9) {
                        n3 = (int)(object.a[n8] >>> n6 & object.a);
                    } else {
                        int n10 = 64 - n6;
                        n3 = (int)((object.a[n8] >>> n6 | object.a[n9] << n10) & object.a);
                    }
                    fq3[n7] = awtArray[n3];
                    ++n2;
                }
            }
        }
    }

    public final int a() {
        return this.x;
    }

    public final int b() {
        return this.y;
    }

    public final int c() {
        return this.z;
    }

    public final void a(int n2, int n3, int n4, awt awt2) {
        this.a[n2][n4][n3] = awt2;
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    static final class a {
        final long[] a;
        final int a;
        final long a;
        final long b;

        public a(int n2, long l2, @Nullable long[] lArray) {
            long l3;
            Validate.inclusiveBetween((long)1L, (long)32L, (long)n2);
            this.b = l2;
            this.a = n2;
            this.a = (1L << n2) - 1L;
            if (lArray != null) {
                this.a = lArray;
                return;
            }
            long l4 = l2 * (long)n2;
            n2 = 1;
            if (64L == 0L) {
                l3 = 0L;
            } else if (l4 == 0L) {
                l3 = 64L;
            } else {
                long l5;
                if (l4 < 0L) {
                    n2 = -1;
                }
                l3 = (l5 = l4 % (64L * (long)n2)) == 0L ? l4 : l4 + 64L * (long)n2 - l5;
            }
            this.a = new long[(int)(l3 / 64L)];
        }
    }
}

