/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.TypedArrayValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

class TypedArrayValue$$Lambda$0
implements Function1 {
    private final KotlinType arg$0;

    public TypedArrayValue$$Lambda$0(KotlinType kotlinType) {
        this.arg$0 = kotlinType;
    }

    public Object invoke(Object object) {
        return TypedArrayValue.accessor$TypedArrayValue$lambda0(this.arg$0, (ModuleDescriptor)object);
    }
}

