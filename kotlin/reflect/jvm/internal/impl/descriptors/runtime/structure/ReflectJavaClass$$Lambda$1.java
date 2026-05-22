/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;

class ReflectJavaClass$$Lambda$1
implements Function1 {
    public static final ReflectJavaClass$$Lambda$1 INSTANCE = new ReflectJavaClass$$Lambda$1();

    public Object invoke(Object object) {
        return ReflectJavaClass.accessor$ReflectJavaClass$lambda1((Class)object);
    }
}

