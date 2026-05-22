/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  awt
 *  com.github.lunatrius.schematica.client.world.SchematicWorld
 *  et
 */
package baritone.utils.schematic.schematica;

import baritone.api.schematic.IStaticSchematic;
import com.github.lunatrius.schematica.client.world.SchematicWorld;
import java.util.List;

public final class SchematicAdapter
implements IStaticSchematic {
    private final SchematicWorld a;

    public SchematicAdapter(SchematicWorld schematicWorld) {
        this.a = schematicWorld;
    }

    @Override
    public final awt desiredState(int n2, int n3, int n4, awt awt2, List<awt> list) {
        return this.getDirect(n2, n3, n4);
    }

    @Override
    public final awt getDirect(int n2, int n3, int n4) {
        return this.a.getSchematic().getBlockState(new et(n2, n3, n4));
    }

    @Override
    public final int widthX() {
        return this.a.getSchematic().getWidth();
    }

    @Override
    public final int heightY() {
        return this.a.getSchematic().getHeight();
    }

    @Override
    public final int lengthZ() {
        return this.a.getSchematic().getLength();
    }
}

