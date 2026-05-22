/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin._Assertions;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public class ArrayValue
extends ConstantValue<List<? extends ConstantValue<?>>> {
    @NotNull
    private final Function1<ModuleDescriptor, KotlinType> computeType;

    public ArrayValue(@NotNull List<? extends ConstantValue<?>> value, @NotNull Function1<? super ModuleDescriptor, ? extends KotlinType> computeType) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(computeType, "computeType");
        super(value);
        this.computeType = computeType;
    }

    @Override
    @NotNull
    public KotlinType getType(@NotNull ModuleDescriptor module) {
        boolean bl2;
        KotlinType kotlinType;
        Intrinsics.checkNotNullParameter(module, "module");
        KotlinType type = kotlinType = this.computeType.invoke(module);
        boolean bl3 = false;
        boolean bl4 = bl2 = KotlinBuiltIns.isArray(type) || KotlinBuiltIns.isPrimitiveArray(type) || KotlinBuiltIns.isUnsignedArrayType(type);
        if (_Assertions.ENABLED && !bl2) {
            boolean bl5 = false;
            String string = "Type should be an array, but was " + type + ": " + this.getValue();
            throw new AssertionError((Object)string);
        }
        return kotlinType;
    }
}

