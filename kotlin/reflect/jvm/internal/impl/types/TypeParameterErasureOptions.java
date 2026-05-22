/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

public final class TypeParameterErasureOptions {
    private final boolean leaveNonTypeParameterTypes;
    private final boolean intersectUpperBounds;

    public TypeParameterErasureOptions(boolean leaveNonTypeParameterTypes, boolean intersectUpperBounds) {
        this.leaveNonTypeParameterTypes = leaveNonTypeParameterTypes;
        this.intersectUpperBounds = intersectUpperBounds;
    }

    public final boolean getLeaveNonTypeParameterTypes() {
        return this.leaveNonTypeParameterTypes;
    }

    public final boolean getIntersectUpperBounds() {
        return this.intersectUpperBounds;
    }
}

