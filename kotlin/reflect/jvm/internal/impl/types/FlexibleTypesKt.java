/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nflexibleTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 flexibleTypes.kt\norg/jetbrains/kotlin/types/FlexibleTypesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,174:1\n295#2:175\n1740#2,3:176\n296#2:179\n1563#2:180\n1634#2,3:181\n1563#2:184\n1634#2,3:185\n*S KotlinDebug\n*F\n+ 1 flexibleTypes.kt\norg/jetbrains/kotlin/types/FlexibleTypesKt\n*L\n50#1:175\n51#1:176,3\n50#1:179\n62#1:180\n62#1:181,3\n65#1:184\n65#1:185,3\n*E\n"})
public final class FlexibleTypesKt {
    public static final boolean isFlexible(@NotNull KotlinType $this$isFlexible) {
        Intrinsics.checkNotNullParameter($this$isFlexible, "<this>");
        return $this$isFlexible.unwrap() instanceof FlexibleType;
    }

    @NotNull
    public static final FlexibleType asFlexibleType(@NotNull KotlinType $this$asFlexibleType) {
        Intrinsics.checkNotNullParameter($this$asFlexibleType, "<this>");
        UnwrappedType unwrappedType = $this$asFlexibleType.unwrap();
        Intrinsics.checkNotNull(unwrappedType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (FlexibleType)unwrappedType;
    }

    @NotNull
    public static final SimpleType lowerIfFlexible(@NotNull KotlinType $this$lowerIfFlexible) {
        SimpleType simpleType;
        Intrinsics.checkNotNullParameter($this$lowerIfFlexible, "<this>");
        UnwrappedType $this$lowerIfFlexible_u24lambda_u244 = $this$lowerIfFlexible.unwrap();
        boolean bl2 = false;
        UnwrappedType unwrappedType = $this$lowerIfFlexible_u24lambda_u244;
        if (unwrappedType instanceof FlexibleType) {
            simpleType = ((FlexibleType)$this$lowerIfFlexible_u24lambda_u244).getLowerBound();
        } else if (unwrappedType instanceof SimpleType) {
            simpleType = (SimpleType)$this$lowerIfFlexible_u24lambda_u244;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return simpleType;
    }

    @NotNull
    public static final SimpleType upperIfFlexible(@NotNull KotlinType $this$upperIfFlexible) {
        SimpleType simpleType;
        Intrinsics.checkNotNullParameter($this$upperIfFlexible, "<this>");
        UnwrappedType $this$upperIfFlexible_u24lambda_u245 = $this$upperIfFlexible.unwrap();
        boolean bl2 = false;
        UnwrappedType unwrappedType = $this$upperIfFlexible_u24lambda_u245;
        if (unwrappedType instanceof FlexibleType) {
            simpleType = ((FlexibleType)$this$upperIfFlexible_u24lambda_u245).getUpperBound();
        } else if (unwrappedType instanceof SimpleType) {
            simpleType = (SimpleType)$this$upperIfFlexible_u24lambda_u245;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return simpleType;
    }
}

