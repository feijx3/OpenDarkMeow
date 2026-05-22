/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UnsignedValueConstant;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;

public final class UByteValue
extends UnsignedValueConstant<Byte> {
    public UByteValue(byte byteValue) {
        super(byteValue);
    }

    @Override
    @NotNull
    public KotlinType getType(@NotNull ModuleDescriptor module) {
        KotlinType kotlinType;
        Intrinsics.checkNotNullParameter(module, "module");
        Annotated annotated = FindClassInModuleKt.findClassAcrossModuleDependencies(module, StandardNames.FqNames.uByte);
        if (annotated != null && (annotated = annotated.getDefaultType()) != null) {
            kotlinType = (KotlinType)annotated;
        } else {
            String[] stringArray = new String[]{"UByte"};
            kotlinType = ErrorUtils.createErrorType(ErrorTypeKind.NOT_FOUND_UNSIGNED_TYPE, stringArray);
        }
        return kotlinType;
    }

    @Override
    @NotNull
    public String toString() {
        return ((Number)this.getValue()).intValue() + ".toUByte()";
    }
}

