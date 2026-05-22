/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  awt
 *  fa$a
 */
package baritone.api.schematic;

import java.util.List;

public interface ISchematic {
    default public boolean inSchematic(int n2, int n3, int n4, awt awt2) {
        return n2 >= 0 && n2 < this.widthX() && n3 >= 0 && n3 < this.heightY() && n4 >= 0 && n4 < this.lengthZ();
    }

    default public int size(fa.a a2) {
        switch (a2) {
            case a: {
                return this.widthX();
            }
            case b: {
                return this.heightY();
            }
            case c: {
                return this.lengthZ();
            }
        }
        throw new UnsupportedOperationException(String.valueOf(a2));
    }

    public awt desiredState(int var1, int var2, int var3, awt var4, List<awt> var5);

    default public void reset() {
    }

    public int widthX();

    public int heightY();

    public int lengthZ();
}

