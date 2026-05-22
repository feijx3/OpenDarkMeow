/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;

class LazyJavaScope$$Lambda$9
implements Function1 {
    public static final LazyJavaScope$$Lambda$9 INSTANCE = new LazyJavaScope$$Lambda$9();

    public Object invoke(Object object) {
        return LazyJavaScope.accessor$LazyJavaScope$lambda9((SimpleFunctionDescriptor)object);
    }
}

