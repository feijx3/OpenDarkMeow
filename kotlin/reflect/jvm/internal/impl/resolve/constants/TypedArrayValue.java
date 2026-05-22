/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.TypedArrayValue$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class TypedArrayValue
extends ArrayValue {
    @NotNull
    private final KotlinType type;

    public TypedArrayValue(@NotNull List<? extends ConstantValue<?>> value, @NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        KotlinType kotlinType = type;
        super(value, new TypedArrayValue$$Lambda$0(kotlinType));
        this.type = type;
    }

    @NotNull
    public final KotlinType getType() {
        return this.type;
    }

    private static final KotlinType _init_$lambda$0(KotlinType $type, ModuleDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $type;
    }

    static /* synthetic */ KotlinType accessor$TypedArrayValue$lambda0(KotlinType kotlinType, ModuleDescriptor moduleDescriptor) {
        return TypedArrayValue._init_$lambda$0(kotlinType, moduleDescriptor);
    }
}

