/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.calls;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

class ValueClassAwareCaller$$Lambda$0
implements Function1 {
    public static final ValueClassAwareCaller$$Lambda$0 INSTANCE = new ValueClassAwareCaller$$Lambda$0();

    public Object invoke(Object object) {
        return ValueClassAwareCaller.accessor$ValueClassAwareCaller$lambda0((ClassDescriptor)object);
    }
}

