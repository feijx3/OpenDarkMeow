/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

class LazyJavaStaticClassScope$$Lambda$1
implements Function1 {
    public static final LazyJavaStaticClassScope$$Lambda$1 INSTANCE = new LazyJavaStaticClassScope$$Lambda$1();

    public Object invoke(Object object) {
        return LazyJavaStaticClassScope.accessor$LazyJavaStaticClassScope$lambda1((MemberScope)object);
    }
}

