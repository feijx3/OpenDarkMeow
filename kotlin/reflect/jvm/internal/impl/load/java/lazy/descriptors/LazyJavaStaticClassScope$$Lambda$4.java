/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

class LazyJavaStaticClassScope$$Lambda$4
implements Function1 {
    public static final LazyJavaStaticClassScope$$Lambda$4 INSTANCE = new LazyJavaStaticClassScope$$Lambda$4();

    public Object invoke(Object object) {
        return LazyJavaStaticClassScope.accessor$LazyJavaStaticClassScope$lambda4((KotlinType)object);
    }
}

