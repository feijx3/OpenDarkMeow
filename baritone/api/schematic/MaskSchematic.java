/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  awt
 */
package baritone.api.schematic;

import baritone.api.schematic.AbstractSchematic;
import baritone.api.schematic.ISchematic;
import baritone.api.schematic.mask.Mask;
import java.util.List;

public abstract class MaskSchematic
extends AbstractSchematic {
    private final ISchematic schematic;

    public MaskSchematic(ISchematic iSchematic) {
        super(iSchematic.widthX(), iSchematic.heightY(), iSchematic.lengthZ());
        this.schematic = iSchematic;
    }

    protected abstract boolean partOfMask(int var1, int var2, int var3, awt var4);

    @Override
    public boolean inSchematic(int n2, int n3, int n4, awt awt2) {
        return this.schematic.inSchematic(n2, n3, n4, awt2) && this.partOfMask(n2, n3, n4, awt2);
    }

    @Override
    public awt desiredState(int n2, int n3, int n4, awt awt2, List<awt> list) {
        return this.schematic.desiredState(n2, n3, n4, awt2, list);
    }

    public static MaskSchematic create(ISchematic iSchematic, final Mask mask) {
        return new MaskSchematic(iSchematic){

            @Override
            protected final boolean partOfMask(int n2, int n3, int n4, awt awt2) {
                return mask.partOfMask(n2, n3, n4, awt2);
            }
        };
    }
}

