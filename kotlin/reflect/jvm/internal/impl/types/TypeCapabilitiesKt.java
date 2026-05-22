/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeCapabilitiesKt {
    public static final boolean isCustomTypeParameter(@NotNull KotlinType $this$isCustomTypeParameter) {
        Intrinsics.checkNotNullParameter($this$isCustomTypeParameter, "<this>");
        UnwrappedType unwrappedType = $this$isCustomTypeParameter.unwrap();
        CustomTypeParameter customTypeParameter = unwrappedType instanceof CustomTypeParameter ? (CustomTypeParameter)((Object)unwrappedType) : null;
        return customTypeParameter != null ? customTypeParameter.isTypeParameter() : false;
    }

    @Nullable
    public static final CustomTypeParameter getCustomTypeParameter(@NotNull KotlinType $this$getCustomTypeParameter) {
        CustomTypeParameter customTypeParameter;
        Intrinsics.checkNotNullParameter($this$getCustomTypeParameter, "<this>");
        UnwrappedType unwrappedType = $this$getCustomTypeParameter.unwrap();
        CustomTypeParameter customTypeParameter2 = unwrappedType instanceof CustomTypeParameter ? (CustomTypeParameter)((Object)unwrappedType) : null;
        if (customTypeParameter2 != null) {
            CustomTypeParameter it = customTypeParameter2;
            boolean bl2 = false;
            customTypeParameter = it.isTypeParameter() ? it : null;
        } else {
            customTypeParameter = null;
        }
        return customTypeParameter;
    }
}

