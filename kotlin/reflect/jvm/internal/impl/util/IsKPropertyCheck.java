/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class IsKPropertyCheck
implements Check {
    @NotNull
    public static final IsKPropertyCheck INSTANCE = new IsKPropertyCheck();
    @NotNull
    private static final String description = "second parameter must be of type KProperty<*> or its supertype";

    private IsKPropertyCheck() {
    }

    @Override
    @NotNull
    public String getDescription() {
        return description;
    }

    @Override
    public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        ValueParameterDescriptor secondParameter = functionDescriptor.getValueParameters().get(1);
        Intrinsics.checkNotNull(secondParameter);
        KotlinType kotlinType = ReflectionTypes.Companion.createKPropertyStarType(DescriptorUtilsKt.getModule(secondParameter));
        if (kotlinType != null) {
            KotlinType kotlinType2 = secondParameter.getType();
            Intrinsics.checkNotNullExpressionValue(kotlinType2, "getType(...)");
            bl2 = TypeUtilsKt.isSubtypeOf(kotlinType, TypeUtilsKt.makeNotNullable(kotlinType2));
        } else {
            bl2 = false;
        }
        return bl2;
    }

    @Override
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }
}

