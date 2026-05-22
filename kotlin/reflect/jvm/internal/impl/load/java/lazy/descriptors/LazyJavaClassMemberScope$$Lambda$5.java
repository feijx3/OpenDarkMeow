/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;

class LazyJavaClassMemberScope$$Lambda$5
implements Function1 {
    public static final LazyJavaClassMemberScope$$Lambda$5 INSTANCE = new LazyJavaClassMemberScope$$Lambda$5();

    public Object invoke(Object object) {
        return LazyJavaClassMemberScope.accessor$LazyJavaClassMemberScope$lambda5((JavaMember)object);
    }
}

