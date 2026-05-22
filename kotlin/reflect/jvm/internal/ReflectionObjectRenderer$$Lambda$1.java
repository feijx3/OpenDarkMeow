/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

class ReflectionObjectRenderer$$Lambda$1
implements Function1 {
    public static final ReflectionObjectRenderer$$Lambda$1 INSTANCE = new ReflectionObjectRenderer$$Lambda$1();

    public Object invoke(Object object) {
        return ReflectionObjectRenderer.accessor$ReflectionObjectRenderer$lambda1((ValueParameterDescriptor)object);
    }
}

