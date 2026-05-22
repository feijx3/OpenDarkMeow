/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;

class ReflectJavaClass$$Lambda$2
implements Function1 {
    private final ReflectJavaClass arg$0;

    public ReflectJavaClass$$Lambda$2(ReflectJavaClass reflectJavaClass) {
        this.arg$0 = reflectJavaClass;
    }

    public Object invoke(Object object) {
        return ReflectJavaClass.accessor$ReflectJavaClass$lambda2(this.arg$0, (Method)object);
    }
}

