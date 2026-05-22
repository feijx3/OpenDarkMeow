/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ExpandedTypeUtilsKt {
    @Nullable
    public static final KotlinTypeMarker computeExpandedTypeForInlineClass(@NotNull TypeSystemCommonBackendContext $this$computeExpandedTypeForInlineClass, @NotNull KotlinTypeMarker inlineClassType) {
        Intrinsics.checkNotNullParameter($this$computeExpandedTypeForInlineClass, "<this>");
        Intrinsics.checkNotNullParameter(inlineClassType, "inlineClassType");
        return ExpandedTypeUtilsKt.computeExpandedTypeInner($this$computeExpandedTypeForInlineClass, inlineClassType, new HashSet<TypeConstructorMarker>());
    }

    private static final KotlinTypeMarker computeExpandedTypeInner(TypeSystemCommonBackendContext $this$computeExpandedTypeInner, KotlinTypeMarker kotlinType, HashSet<TypeConstructorMarker> visitedClassifiers) {
        KotlinTypeMarker kotlinTypeMarker;
        TypeConstructorMarker classifier = $this$computeExpandedTypeInner.typeConstructor(kotlinType);
        if (!visitedClassifiers.add(classifier)) {
            return null;
        }
        TypeParameterMarker typeParameter = $this$computeExpandedTypeInner.getTypeParameterClassifier(classifier);
        if (typeParameter != null) {
            KotlinTypeMarker upperBound = $this$computeExpandedTypeInner.getRepresentativeUpperBound(typeParameter);
            KotlinTypeMarker kotlinTypeMarker2 = ExpandedTypeUtilsKt.computeExpandedTypeInner($this$computeExpandedTypeInner, upperBound, visitedClassifiers);
            if (kotlinTypeMarker2 != null) {
                KotlinTypeMarker expandedUpperBound = kotlinTypeMarker2;
                boolean bl2 = false;
                boolean upperBoundIsPrimitiveOrInlineClass = $this$computeExpandedTypeInner.isInlineClass($this$computeExpandedTypeInner.typeConstructor(upperBound)) || upperBound instanceof SimpleTypeMarker && $this$computeExpandedTypeInner.isPrimitiveType((SimpleTypeMarker)upperBound);
                kotlinTypeMarker = expandedUpperBound instanceof SimpleTypeMarker && $this$computeExpandedTypeInner.isPrimitiveType((SimpleTypeMarker)expandedUpperBound) && $this$computeExpandedTypeInner.isNullableType(kotlinType) && upperBoundIsPrimitiveOrInlineClass ? $this$computeExpandedTypeInner.makeNullable(upperBound) : ($this$computeExpandedTypeInner.isNullableType(expandedUpperBound) || !$this$computeExpandedTypeInner.isMarkedNullable(kotlinType) ? expandedUpperBound : $this$computeExpandedTypeInner.makeNullable(expandedUpperBound));
            } else {
                kotlinTypeMarker = null;
            }
        } else if ($this$computeExpandedTypeInner.isInlineClass(classifier)) {
            KotlinTypeMarker kotlinTypeMarker3 = $this$computeExpandedTypeInner.getUnsubstitutedUnderlyingType(kotlinType);
            if (kotlinTypeMarker3 == null) {
                return null;
            }
            KotlinTypeMarker underlyingType = kotlinTypeMarker3;
            KotlinTypeMarker kotlinTypeMarker4 = ExpandedTypeUtilsKt.computeExpandedTypeInner($this$computeExpandedTypeInner, underlyingType, visitedClassifiers);
            if (kotlinTypeMarker4 == null) {
                return null;
            }
            KotlinTypeMarker expandedUnderlyingType = kotlinTypeMarker4;
            kotlinTypeMarker = !$this$computeExpandedTypeInner.isNullableType(kotlinType) ? expandedUnderlyingType : ($this$computeExpandedTypeInner.isNullableType(expandedUnderlyingType) ? kotlinType : (expandedUnderlyingType instanceof SimpleTypeMarker && $this$computeExpandedTypeInner.isPrimitiveType((SimpleTypeMarker)expandedUnderlyingType) ? kotlinType : $this$computeExpandedTypeInner.makeNullable(expandedUnderlyingType)));
        } else {
            kotlinTypeMarker = kotlinType;
        }
        return kotlinTypeMarker;
    }
}

