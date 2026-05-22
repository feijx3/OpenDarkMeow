/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.ErasedOverridabilityCondition;

class ErasedOverridabilityCondition$$Lambda$0
implements Function1 {
    public static final ErasedOverridabilityCondition$$Lambda$0 INSTANCE = new ErasedOverridabilityCondition$$Lambda$0();

    public Object invoke(Object object) {
        return ErasedOverridabilityCondition.accessor$ErasedOverridabilityCondition$lambda0((ValueParameterDescriptor)object);
    }
}

