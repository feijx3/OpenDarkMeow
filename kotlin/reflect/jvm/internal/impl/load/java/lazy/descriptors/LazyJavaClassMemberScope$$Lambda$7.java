/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.name.Name;

class LazyJavaClassMemberScope$$Lambda$7
implements Function1 {
    private final LazyJavaClassMemberScope arg$0;

    public LazyJavaClassMemberScope$$Lambda$7(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        this.arg$0 = lazyJavaClassMemberScope;
    }

    public Object invoke(Object object) {
        return LazyJavaClassMemberScope.accessor$LazyJavaClassMemberScope$lambda7(this.arg$0, (Name)object);
    }
}

