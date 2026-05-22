/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  awt
 *  fa
 *  fq
 */
package baritone;

import baritone.api.schematic.ISchematic;
import baritone.api.schematic.MaskSchematic;
import baritone.api.selection.ISelection;
import java.util.stream.Stream;

public final class gd
extends MaskSchematic {
    private final ISelection[] a;

    public gd(ISchematic iSchematic, fq fq2, ISelection[] iSelectionArray) {
        super(iSchematic);
        this.a = (ISelection[])Stream.of(iSelectionArray).map(iSelection -> iSelection.shift(fa.e, fq2.p()).shift(fa.a, fq2.q()).shift(fa.c, fq2.r())).toArray(ISelection[]::new);
    }

    @Override
    public final boolean partOfMask(int n2, int n3, int n4, awt iSelectionArray) {
        iSelectionArray = this.a;
        int n5 = this.a.length;
        for (int i2 = 0; i2 < n5; ++i2) {
            ISelection iSelection = iSelectionArray[i2];
            if (n2 < iSelection.min().a || n3 < iSelection.min().b || n4 < iSelection.min().c || n2 > iSelection.max().a || n3 > iSelection.max().b || n4 > iSelection.max().c) continue;
            return true;
        }
        return false;
    }
}

