/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  awt
 */
package baritone.api.schematic;

import baritone.api.schematic.AbstractSchematic;
import baritone.api.utils.BlockOptionalMeta;
import java.util.List;

public class FillSchematic
extends AbstractSchematic {
    private final BlockOptionalMeta bom;

    public FillSchematic(int n2, int n3, int n4, BlockOptionalMeta blockOptionalMeta) {
        super(n2, n3, n4);
        this.bom = blockOptionalMeta;
    }

    public FillSchematic(int n2, int n3, int n4, awt awt2) {
        this(n2, n3, n4, new BlockOptionalMeta(awt2.u(), awt2.u().e(awt2)));
    }

    public BlockOptionalMeta getBom() {
        return this.bom;
    }

    @Override
    public awt desiredState(int n2, int n3, int n4, awt awt2, List<awt> list) {
        if (this.bom.matches(awt2)) {
            return awt2;
        }
        for (awt awt3 : list) {
            if (!this.bom.matches(awt3)) continue;
            return awt3;
        }
        return this.bom.getAnyBlockState();
    }
}

