/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  awt
 */
package baritone.api.schematic.mask;

import baritone.api.schematic.mask.operator.BinaryOperatorMask;
import baritone.api.schematic.mask.operator.NotMask;
import baritone.api.utils.BooleanBinaryOperators;

public interface Mask {
    public boolean partOfMask(int var1, int var2, int var3, awt var4);

    public int widthX();

    public int heightY();

    public int lengthZ();

    default public Mask not() {
        return new NotMask(this);
    }

    default public Mask union(Mask mask) {
        return new BinaryOperatorMask(this, mask, BooleanBinaryOperators.OR);
    }

    default public Mask intersection(Mask mask) {
        return new BinaryOperatorMask(this, mask, BooleanBinaryOperators.AND);
    }

    default public Mask xor(Mask mask) {
        return new BinaryOperatorMask(this, mask, BooleanBinaryOperators.XOR);
    }
}

