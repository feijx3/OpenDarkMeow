/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;

class LazyJavaStaticClassScope$$Lambda$0
implements Function1 {
    public static final LazyJavaStaticClassScope$$Lambda$0 INSTANCE = new LazyJavaStaticClassScope$$Lambda$0();

    public Object invoke(Object object) {
        return LazyJavaStaticClassScope.accessor$LazyJavaStaticClassScope$lambda0((JavaMember)object);
    }
}

