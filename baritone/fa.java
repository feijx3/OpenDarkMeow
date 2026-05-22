/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bhb
 *  bhe
 *  bib
 *  buk
 *  bus
 *  bve
 *  bzf
 *  cdr
 *  cdy
 */
package baritone;

import baritone.api.BaritoneAPI;
import baritone.api.Settings;
import java.awt.Color;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public interface fa {
    public static final bve a = bve.a();
    public static final buk a = a.c();
    public static final bzf a = bib.z().ac();
    public static final cdr a = bib.z().N();
    public static final Settings a = BaritoneAPI.getSettings();
    public static final float[] a = new float[]{1.0f, 1.0f, 1.0f, 255.0f};

    public static void a(Color object, float f2) {
        object = ((Color)object).getColorComponents(null);
        fa.a[0] = (float)object[0];
        fa.a[1] = (float)object[1];
        fa.a[2] = (float)object[2];
        fa.a[3] = f2;
    }

    public static void a(Color color, float f2, float f3, boolean bl2) {
        bus.m();
        bus.a((int)770, (int)771, (int)1, (int)0);
        fa.a(color, f2);
        bus.d((float)f3);
        bus.z();
        bus.a((boolean)false);
        bus.g();
        if (bl2) {
            bus.j();
        }
        a.a(1, cdy.f);
    }

    public static void a(Color color, float f2, boolean bl2) {
        fa.a(color, 0.4f, f2, bl2);
    }

    public static void a(boolean bl2) {
        a.b();
        if (bl2) {
            bus.k();
        }
        bus.a((boolean)true);
        bus.y();
        bus.l();
        bus.f();
    }

    public static void a(bhb bhb2) {
        bhb2 = bhb2.d(-fa.a.h, -fa.a.i, -fa.a.j);
        a.b(bhb2.a, bhb2.b, bhb2.c).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.d, bhb2.b, bhb2.c).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.d, bhb2.b, bhb2.c).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.d, bhb2.b, bhb2.f).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.d, bhb2.b, bhb2.f).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.a, bhb2.b, bhb2.f).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.a, bhb2.b, bhb2.f).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.a, bhb2.b, bhb2.c).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.a, bhb2.e, bhb2.c).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.d, bhb2.e, bhb2.c).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.d, bhb2.e, bhb2.c).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.d, bhb2.e, bhb2.f).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.d, bhb2.e, bhb2.f).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.a, bhb2.e, bhb2.f).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.a, bhb2.e, bhb2.f).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.a, bhb2.e, bhb2.c).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.a, bhb2.b, bhb2.c).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.a, bhb2.e, bhb2.c).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.d, bhb2.b, bhb2.c).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.d, bhb2.e, bhb2.c).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.d, bhb2.b, bhb2.f).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.d, bhb2.e, bhb2.f).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.a, bhb2.b, bhb2.f).a(a[0], a[1], a[2], a[3]).d();
        a.b(bhb2.a, bhb2.e, bhb2.f).a(a[0], a[1], a[2], a[3]).d();
    }

    public static void a(bhb bhb2, double d2) {
        double d3 = d2;
        fa.a(bhb2.c(d3, d3, d2));
    }

    public static void a(bhe bhe2, bhe bhe3) {
        double d2 = bhe3.d;
        double d3 = bhe3.c;
        double d4 = bhe3.b;
        double d5 = bhe2.d;
        double d6 = bhe2.c;
        double d7 = bhe2.b;
        double d8 = fa.a.h;
        double d9 = fa.a.i;
        double d10 = fa.a.j;
        a.b(d7 - d8, d6 - d9, d5 - d10).a(a[0], a[1], a[2], a[3]).d();
        a.b(d4 - d8, d3 - d9, d2 - d10).a(a[0], a[1], a[2], a[3]).d();
    }
}

