/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  awt
 */
package baritone.api.schematic;

import baritone.api.schematic.ISchematic;

public interface IStaticSchematic
extends ISchematic {
    public awt getDirect(int var1, int var2, int var3);

    default public awt[] getColumn(int n2, int n3) {
        awt[] awtArray = new awt[this.heightY()];
        for (int i2 = 0; i2 < this.heightY(); ++i2) {
            awtArray[i2] = this.getDirect(n2, i2, n3);
        }
        return awtArray;
    }
}

