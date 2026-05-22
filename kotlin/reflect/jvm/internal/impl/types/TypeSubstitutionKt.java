/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import org.jetbrains.annotations.NotNull;

public final class TypeSubstitutionKt {
    @JvmOverloads
    @NotNull
    public static final KotlinType replace(@NotNull KotlinType $this$replace, @NotNull List<? extends TypeProjection> newArguments, @NotNull Annotations newAnnotations, @NotNull List<? extends TypeProjection> newArgumentsForUpperBound) {
        KotlinType kotlinType;
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        Intrinsics.checkNotNullParameter(newArguments, "newArguments");
        Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
        Intrinsics.checkNotNullParameter(newArgumentsForUpperBound, "newArgumentsForUpperBound");
        if ((newArguments.isEmpty() || newArguments == $this$replace.getArguments()) && newAnnotations == $this$replace.getAnnotations()) {
            return $this$replace;
        }
        TypeAttributes newAttributes = TypeAttributesKt.replaceAnnotations($this$replace.getAttributes(), newAnnotations instanceof FilteredAnnotations && ((FilteredAnnotations)newAnnotations).isEmpty() ? Annotations.Companion.getEMPTY() : newAnnotations);
        UnwrappedType unwrapped = $this$replace.unwrap();
        if (unwrapped instanceof FlexibleType) {
            kotlinType = KotlinTypeFactory.flexibleType(TypeSubstitutionKt.replace(((FlexibleType)unwrapped).getLowerBound(), newArguments, newAttributes), TypeSubstitutionKt.replace(((FlexibleType)unwrapped).getUpperBound(), newArgumentsForUpperBound, newAttributes));
        } else if (unwrapped instanceof SimpleType) {
            kotlinType = TypeSubstitutionKt.replace((SimpleType)unwrapped, newArguments, newAttributes);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return kotlinType;
    }

    public static /* synthetic */ KotlinType replace$default(KotlinType kotlinType, List list, Annotations annotations, List list2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            list = kotlinType.getArguments();
        }
        if ((n2 & 2) != 0) {
            annotations = kotlinType.getAnnotations();
        }
        if ((n2 & 4) != 0) {
            list2 = list;
        }
        return TypeSubstitutionKt.replace(kotlinType, list, annotations, list2);
    }

    @JvmOverloads
    @NotNull
    public static final SimpleType replace(@NotNull SimpleType $this$replace, @NotNull List<? extends TypeProjection> newArguments, @NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        Intrinsics.checkNotNullParameter(newArguments, "newArguments");
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        if (newArguments.isEmpty() && newAttributes == $this$replace.getAttributes()) {
            return $this$replace;
        }
        if (newArguments.isEmpty()) {
            return $this$replace.replaceAttributes(newAttributes);
        }
        if ($this$replace instanceof ErrorType) {
            return ((ErrorType)$this$replace).replaceArguments(newArguments);
        }
        return KotlinTypeFactory.simpleType$default(newAttributes, $this$replace.getConstructor(), newArguments, $this$replace.isMarkedNullable(), null, 16, null);
    }

    public static /* synthetic */ SimpleType replace$default(SimpleType simpleType, List list, TypeAttributes typeAttributes, int n2, Object object) {
        if ((n2 & 1) != 0) {
            list = simpleType.getArguments();
        }
        if ((n2 & 2) != 0) {
            typeAttributes = simpleType.getAttributes();
        }
        return TypeSubstitutionKt.replace(simpleType, list, typeAttributes);
    }

    @NotNull
    public static final SimpleType asSimpleType(@NotNull KotlinType $this$asSimpleType) {
        Intrinsics.checkNotNullParameter($this$asSimpleType, "<this>");
        UnwrappedType unwrappedType = $this$asSimpleType.unwrap();
        SimpleType simpleType = unwrappedType instanceof SimpleType ? (SimpleType)unwrappedType : null;
        if (simpleType == null) {
            throw new IllegalStateException(("This is should be simple type: " + $this$asSimpleType).toString());
        }
        return simpleType;
    }

    @JvmOverloads
    @NotNull
    public static final KotlinType replace(@NotNull KotlinType $this$replace, @NotNull List<? extends TypeProjection> newArguments, @NotNull Annotations newAnnotations) {
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        Intrinsics.checkNotNullParameter(newArguments, "newArguments");
        Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
        return TypeSubstitutionKt.replace$default($this$replace, newArguments, newAnnotations, null, 4, null);
    }
}

