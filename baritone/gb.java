/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aom
 *  awt
 */
package baritone;

import baritone.api.schematic.IStaticSchematic;
import baritone.api.schematic.MaskSchematic;
import java.util.OptionalInt;
import java.util.function.Predicate;

public final class gb
extends MaskSchematic {
    private final int[][] a;

    public gb(IStaticSchematic iStaticSchematic) {
        super(iStaticSchematic);
        int[][] nArray = new int[iStaticSchematic.widthX()][iStaticSchematic.lengthZ()];
        for (int i2 = 0; i2 < iStaticSchematic.widthX(); ++i2) {
            for (int i3 = 0; i3 < iStaticSchematic.lengthZ(); ++i3) {
                Object object;
                Object object2;
                block4: {
                    Predicate<awt> predicate = awt2 -> !(awt2.u() instanceof aom);
                    object2 = iStaticSchematic.getColumn(i2, i3);
                    for (int i4 = ((awt[])object2).length - 1; i4 >= 0; --i4) {
                        if (!predicate.test(object2[i4])) continue;
                        object = OptionalInt.of(i4);
                        break block4;
                    }
                    object = object2 = OptionalInt.empty();
                }
                if (((OptionalInt)object).isPresent()) {
                    nArray[i2][i3] = ((OptionalInt)object2).getAsInt();
                    continue;
                }
                System.out.println("Column " + i2 + "," + i3 + " has no blocks, but it's apparently map art? wtf");
                System.out.println("Letting it be whatever");
                nArray[i2][i3] = 256;
            }
        }
        this.a = nArray;
    }

    @Override
    public final boolean partOfMask(int n2, int n3, int n4, awt awt2) {
        return n3 >= this.a[n2][n4];
    }
}

