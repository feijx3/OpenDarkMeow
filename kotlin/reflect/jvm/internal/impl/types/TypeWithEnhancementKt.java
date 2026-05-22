/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nTypeWithEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeWithEnhancement.kt\norg/jetbrains/kotlin/types/TypeWithEnhancementKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,169:1\n1563#2:170\n1634#2,3:171\n1740#2,3:174\n*S KotlinDebug\n*F\n+ 1 TypeWithEnhancement.kt\norg/jetbrains/kotlin/types/TypeWithEnhancementKt\n*L\n97#1:170\n97#1:171,3\n112#1:174,3\n*E\n"})
public final class TypeWithEnhancementKt {
    @Nullable
    public static final KotlinType getEnhancement(@NotNull KotlinType $this$getEnhancement) {
        Intrinsics.checkNotNullParameter($this$getEnhancement, "<this>");
        return $this$getEnhancement instanceof TypeWithEnhancement ? ((TypeWithEnhancement)((Object)$this$getEnhancement)).getEnhancement() : null;
    }

    @NotNull
    public static final UnwrappedType inheritEnhancement(@NotNull UnwrappedType $this$inheritEnhancement, @NotNull KotlinType origin, @NotNull Function1<? super KotlinType, ? extends KotlinType> transform) {
        Intrinsics.checkNotNullParameter($this$inheritEnhancement, "<this>");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(transform, "transform");
        KotlinType kotlinType = TypeWithEnhancementKt.getEnhancement(origin);
        return TypeWithEnhancementKt.wrapEnhancement($this$inheritEnhancement, kotlinType != null ? transform.invoke(kotlinType) : null);
    }

    @NotNull
    public static final UnwrappedType inheritEnhancement(@NotNull UnwrappedType $this$inheritEnhancement, @NotNull KotlinType origin) {
        Intrinsics.checkNotNullParameter($this$inheritEnhancement, "<this>");
        Intrinsics.checkNotNullParameter(origin, "origin");
        return TypeWithEnhancementKt.wrapEnhancement($this$inheritEnhancement, TypeWithEnhancementKt.getEnhancement(origin));
    }

    @NotNull
    public static final UnwrappedType wrapEnhancement(@NotNull UnwrappedType $this$wrapEnhancement, @Nullable KotlinType enhancement) {
        UnwrappedType unwrappedType;
        Intrinsics.checkNotNullParameter($this$wrapEnhancement, "<this>");
        if ($this$wrapEnhancement instanceof TypeWithEnhancement) {
            return TypeWithEnhancementKt.wrapEnhancement(((TypeWithEnhancement)((Object)$this$wrapEnhancement)).getOrigin(), enhancement);
        }
        if (enhancement == null || Intrinsics.areEqual(enhancement, $this$wrapEnhancement)) {
            return $this$wrapEnhancement;
        }
        UnwrappedType unwrappedType2 = $this$wrapEnhancement;
        if (unwrappedType2 instanceof SimpleType) {
            unwrappedType = new SimpleTypeWithEnhancement((SimpleType)$this$wrapEnhancement, enhancement);
        } else if (unwrappedType2 instanceof FlexibleType) {
            unwrappedType = new FlexibleTypeWithEnhancement((FlexibleType)$this$wrapEnhancement, enhancement);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return unwrappedType;
    }
}

