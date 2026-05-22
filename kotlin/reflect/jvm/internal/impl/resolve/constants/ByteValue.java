/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueConstant;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class ByteValue
extends IntegerValueConstant<Byte> {
    public ByteValue(byte value) {
        super(value);
    }

    @Override
    @NotNull
    public SimpleType getType(@NotNull ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        SimpleType simpleType = module.getBuiltIns().getByteType();
        Intrinsics.checkNotNullExpressionValue(simpleType, "getByteType(...)");
        return simpleType;
    }

    @Override
    @NotNull
    public String toString() {
        return ((Number)this.getValue()).intValue() + ".toByte()";
    }
}

