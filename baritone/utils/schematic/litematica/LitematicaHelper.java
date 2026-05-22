/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ary
 *  atm
 *  awt
 *  fi.dy.masa.litematica.Litematica
 *  fi.dy.masa.litematica.data.DataManager
 *  fi.dy.masa.litematica.schematic.placement.SchematicPlacement
 *  fq
 */
package baritone.utils.schematic.litematica;

import baritone.gj;
import fi.dy.masa.litematica.Litematica;
import fi.dy.masa.litematica.data.DataManager;
import fi.dy.masa.litematica.schematic.placement.SchematicPlacement;
import java.io.File;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class LitematicaHelper {
    public static boolean a() {
        try {
            Class.forName(Litematica.class.getName());
            return true;
        }
        catch (ClassNotFoundException | NoClassDefFoundError throwable) {
            return false;
        }
    }

    public static boolean b() {
        return DataManager.getSchematicPlacementManager().getAllSchematicsPlacements().size() > 0;
    }

    public static String a(int n2) {
        return ((SchematicPlacement)DataManager.getSchematicPlacementManager().getAllSchematicsPlacements().get(n2)).getName();
    }

    private static fq a(int n2) {
        return ((SchematicPlacement)DataManager.getSchematicPlacementManager().getAllSchematicsPlacements().get(n2)).getOrigin();
    }

    public static File a(int n2) {
        return ((SchematicPlacement)DataManager.getSchematicPlacementManager().getAllSchematicsPlacements().get(n2)).getSchematicFile();
    }

    private static atm a(int n2) {
        return ((SchematicPlacement)DataManager.getSchematicPlacementManager().getAllSchematicsPlacements().get(n2)).getRotation();
    }

    private static ary a(int n2) {
        return ((SchematicPlacement)DataManager.getSchematicPlacementManager().getAllSchematicsPlacements().get(n2)).getMirror();
    }

    public static fq a(gj gj2, int n2) {
        fq fq2;
        int n3 = LitematicaHelper.a(n2).p();
        int n4 = LitematicaHelper.a(n2).q();
        int n5 = LitematicaHelper.a(n2).r();
        int n6 = gj2.a.p();
        int n7 = gj2.a.q();
        int n8 = gj2.a.r();
        int n9 = -(gj2.a() - 1);
        int n10 = -(gj2.c() - 1);
        ary ary2 = LitematicaHelper.a(n2);
        atm atm2 = LitematicaHelper.a(n2);
        block0 : switch (ary2) {
            case c: 
            case b: {
                switch (((ary2.ordinal() << 1) + atm2.ordinal()) % 4) {
                    case 1: {
                        fq2 = new fq(n3 + (n10 - n8), n4 + n7, n5 + (n9 - n6));
                        break block0;
                    }
                    case 2: {
                        fq2 = new fq(n3 + n6, n4 + n7, n5 + (n10 - n8));
                        break block0;
                    }
                    case 3: {
                        fq2 = new fq(n3 + n8, n4 + n7, n5 + n6);
                        break block0;
                    }
                }
                fq2 = new fq(n3 + (n9 - n6), n4 + n7, n5 + n8);
                break;
            }
            default: {
                switch (atm2) {
                    case b: {
                        fq2 = new fq(n3 + (n10 - n8), n4 + n7, n5 + n6);
                        break block0;
                    }
                    case c: {
                        fq2 = new fq(n3 + (n9 - n6), n4 + n7, n5 + (n10 - n8));
                        break block0;
                    }
                    case d: {
                        fq2 = new fq(n3 + n8, n4 + n7, n5 + (n9 - n6));
                        break block0;
                    }
                }
                fq2 = new fq(n3 + n6, n4 + n7, n5 + n8);
            }
        }
        return fq2;
    }

    private static fq a(fq fq2, int n2, int n3) {
        int n4 = n2;
        return new fq(n4 - (n4 - n3) - fq2.r(), fq2.q(), fq2.p());
    }

    public static gj a(gj gj2, int n2) {
        int n3 = LitematicaHelper.a(n2).ordinal() % 2 == 1 ? 1 : 0;
        gj gj3 = gj2;
        gj gj4 = new gj(gj3.a, n3 != 0);
        for (int i2 = 0; i2 < gj2.b(); ++i2) {
            for (int i3 = 0; i3 < gj2.c(); ++i3) {
                for (int i4 = 0; i4 < gj2.a(); ++i4) {
                    ary ary2 = LitematicaHelper.a(n2);
                    int n4 = gj2.c() - 1;
                    n3 = gj2.a() - 1;
                    gj3 = new fq(i4, i2, i3);
                    int n5 = gj3.p();
                    int n6 = gj3.r();
                    if (ary2 == ary.b) {
                        n6 = n4 - gj3.r();
                    } else if (ary2 == ary.c) {
                        n5 = n3 - gj3.p();
                    }
                    gj3 = new fq(n5, gj3.q(), n6);
                    for (n3 = 0; n3 < LitematicaHelper.a(n2).ordinal(); ++n3) {
                        gj3 = n3 % 2 == 0 ? LitematicaHelper.a((fq)gj3, gj2.a() - 1, gj2.c() - 1) : LitematicaHelper.a((fq)gj3, gj2.c() - 1, gj2.a() - 1);
                    }
                    awt awt2 = gj2.getDirect(i4, i2, i3);
                    try {
                        awt2 = awt2.a(LitematicaHelper.a(n2)).a(LitematicaHelper.a(n2));
                    }
                    catch (NullPointerException nullPointerException) {}
                    gj4.a(gj3.p(), gj3.q(), gj3.r(), awt2);
                }
            }
        }
        return gj4;
    }
}

