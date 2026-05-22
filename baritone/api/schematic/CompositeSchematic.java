/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  awt
 */
package baritone.api.schematic;

import baritone.api.schematic.AbstractSchematic;
import baritone.api.schematic.CompositeSchematicEntry;
import baritone.api.schematic.ISchematic;
import java.util.ArrayList;
import java.util.List;

public class CompositeSchematic
extends AbstractSchematic {
    private final List<CompositeSchematicEntry> schematics = new ArrayList<CompositeSchematicEntry>();
    private CompositeSchematicEntry[] schematicArr;

    private void recalcArr() {
        CompositeSchematicEntry[] compositeSchematicEntryArray = this.schematicArr = this.schematics.toArray(new CompositeSchematicEntry[0]);
        int n2 = this.schematicArr.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            CompositeSchematicEntry compositeSchematicEntry = compositeSchematicEntryArray[i2];
            this.x = Math.max(this.x, compositeSchematicEntry.x + compositeSchematicEntry.schematic.widthX());
            this.y = Math.max(this.y, compositeSchematicEntry.y + compositeSchematicEntry.schematic.heightY());
            this.z = Math.max(this.z, compositeSchematicEntry.z + compositeSchematicEntry.schematic.lengthZ());
        }
    }

    public CompositeSchematic(int n2, int n3, int n4) {
        super(n2, n3, n4);
        this.recalcArr();
    }

    public void put(ISchematic iSchematic, int n2, int n3, int n4) {
        this.schematics.add(new CompositeSchematicEntry(iSchematic, n2, n3, n4));
        this.recalcArr();
    }

    private CompositeSchematicEntry getSchematic(int n2, int n3, int n4, awt awt2) {
        CompositeSchematicEntry[] compositeSchematicEntryArray = this.schematicArr;
        int n5 = this.schematicArr.length;
        for (int i2 = 0; i2 < n5; ++i2) {
            CompositeSchematicEntry compositeSchematicEntry = compositeSchematicEntryArray[i2];
            if (n2 < compositeSchematicEntry.x || n3 < compositeSchematicEntry.y || n4 < compositeSchematicEntry.z || !compositeSchematicEntry.schematic.inSchematic(n2 - compositeSchematicEntry.x, n3 - compositeSchematicEntry.y, n4 - compositeSchematicEntry.z, awt2)) continue;
            return compositeSchematicEntry;
        }
        return null;
    }

    @Override
    public boolean inSchematic(int n2, int n3, int n4, awt awt2) {
        CompositeSchematicEntry compositeSchematicEntry = this.getSchematic(n2, n3, n4, awt2);
        return compositeSchematicEntry != null && compositeSchematicEntry.schematic.inSchematic(n2 - compositeSchematicEntry.x, n3 - compositeSchematicEntry.y, n4 - compositeSchematicEntry.z, awt2);
    }

    @Override
    public awt desiredState(int n2, int n3, int n4, awt awt2, List<awt> list) {
        CompositeSchematicEntry compositeSchematicEntry = this.getSchematic(n2, n3, n4, awt2);
        if (compositeSchematicEntry == null) {
            throw new IllegalStateException("couldn't find schematic for this position");
        }
        return compositeSchematicEntry.schematic.desiredState(n2 - compositeSchematicEntry.x, n3 - compositeSchematicEntry.y, n4 - compositeSchematicEntry.z, awt2, list);
    }

    @Override
    public void reset() {
        CompositeSchematicEntry[] compositeSchematicEntryArray = this.schematicArr;
        int n2 = this.schematicArr.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            compositeSchematicEntryArray[i2].schematic.reset();
        }
    }
}

