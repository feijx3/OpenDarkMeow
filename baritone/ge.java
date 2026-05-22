/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  awt
 */
package baritone;

import baritone.api.schematic.AbstractSchematic;
import baritone.api.schematic.IStaticSchematic;
import java.util.List;

public class ge
extends AbstractSchematic
implements IStaticSchematic {
    protected awt[][][] a;

    @Override
    public awt desiredState(int n2, int n3, int n4, awt awt2, List<awt> list) {
        return this.a[n2][n4][n3];
    }

    @Override
    public awt getDirect(int n2, int n3, int n4) {
        return this.a[n2][n4][n3];
    }

    @Override
    public awt[] getColumn(int n2, int n3) {
        return this.a[n2][n3];
    }
}

