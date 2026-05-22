/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  awt
 */
package baritone.api.schematic;

import baritone.api.schematic.ISchematic;
import baritone.api.schematic.MaskSchematic;

public class WallsSchematic
extends MaskSchematic {
    public WallsSchematic(ISchematic iSchematic) {
        super(iSchematic);
    }

    @Override
    protected boolean partOfMask(int n2, int n3, int n4, awt awt2) {
        return n2 == 0 || n4 == 0 || n2 == this.widthX() - 1 || n4 == this.lengthZ() - 1;
    }
}

