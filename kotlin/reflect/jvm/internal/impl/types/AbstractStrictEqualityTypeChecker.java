/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;

public final class AbstractStrictEqualityTypeChecker {
    @NotNull
    public static final AbstractStrictEqualityTypeChecker INSTANCE = new AbstractStrictEqualityTypeChecker();

    private AbstractStrictEqualityTypeChecker() {
    }

    public final boolean strictEqualTypes(@NotNull TypeSystemContext context, @NotNull KotlinTypeMarker a2, @NotNull KotlinTypeMarker b2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        return this.strictEqualTypesInternal(context, a2, b2);
    }

    private final boolean strictEqualTypesInternal(TypeSystemContext $this$strictEqualTypesInternal, KotlinTypeMarker a2, KotlinTypeMarker b2) {
        if (a2 == b2) {
            return true;
        }
        RigidTypeMarker simpleA = $this$strictEqualTypesInternal.asRigidType(a2);
        RigidTypeMarker simpleB = $this$strictEqualTypesInternal.asRigidType(b2);
        if (simpleA != null && simpleB != null) {
            return this.strictEqualRigidTypes($this$strictEqualTypesInternal, simpleA, simpleB);
        }
        FlexibleTypeMarker flexibleA = $this$strictEqualTypesInternal.asFlexibleType(a2);
        FlexibleTypeMarker flexibleB = $this$strictEqualTypesInternal.asFlexibleType(b2);
        if (flexibleA != null && flexibleB != null) {
            return this.strictEqualRigidTypes($this$strictEqualTypesInternal, $this$strictEqualTypesInternal.lowerBound(flexibleA), $this$strictEqualTypesInternal.lowerBound(flexibleB)) && this.strictEqualRigidTypes($this$strictEqualTypesInternal, $this$strictEqualTypesInternal.upperBound(flexibleA), $this$strictEqualTypesInternal.upperBound(flexibleB));
        }
        return false;
    }

    private final boolean strictEqualRigidTypes(TypeSystemContext $this$strictEqualRigidTypes, RigidTypeMarker a2, RigidTypeMarker b2) {
        if ($this$strictEqualRigidTypes.argumentsCount(a2) != $this$strictEqualRigidTypes.argumentsCount(b2) || $this$strictEqualRigidTypes.isMarkedNullable(a2) != $this$strictEqualRigidTypes.isMarkedNullable(b2) || $this$strictEqualRigidTypes.isDefinitelyNotNullType(a2) != $this$strictEqualRigidTypes.isDefinitelyNotNullType(b2) || !$this$strictEqualRigidTypes.areEqualTypeConstructors($this$strictEqualRigidTypes.typeConstructor(a2), $this$strictEqualRigidTypes.typeConstructor(b2))) {
            return false;
        }
        if ($this$strictEqualRigidTypes.identicalArguments(a2, b2)) {
            return true;
        }
        int n2 = $this$strictEqualRigidTypes.argumentsCount(a2);
        for (int i2 = 0; i2 < n2; ++i2) {
            TypeArgumentMarker aArg = $this$strictEqualRigidTypes.getArgument(a2, i2);
            TypeArgumentMarker bArg = $this$strictEqualRigidTypes.getArgument(b2, i2);
            if ($this$strictEqualRigidTypes.isStarProjection(aArg) != $this$strictEqualRigidTypes.isStarProjection(bArg)) {
                return false;
            }
            if ($this$strictEqualRigidTypes.isStarProjection(aArg)) continue;
            if ($this$strictEqualRigidTypes.getVariance(aArg) != $this$strictEqualRigidTypes.getVariance(bArg)) {
                return false;
            }
            KotlinTypeMarker kotlinTypeMarker = $this$strictEqualRigidTypes.getType(aArg);
            Intrinsics.checkNotNull(kotlinTypeMarker);
            KotlinTypeMarker kotlinTypeMarker2 = $this$strictEqualRigidTypes.getType(bArg);
            Intrinsics.checkNotNull(kotlinTypeMarker2);
            if (this.strictEqualTypesInternal($this$strictEqualRigidTypes, kotlinTypeMarker, kotlinTypeMarker2)) continue;
            return false;
        }
        return true;
    }
}

