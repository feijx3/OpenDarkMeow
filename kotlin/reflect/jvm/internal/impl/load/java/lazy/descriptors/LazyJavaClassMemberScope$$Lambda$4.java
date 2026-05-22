/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.name.Name;

class LazyJavaClassMemberScope$$Lambda$4
implements Function1 {
    private final LazyJavaClassMemberScope arg$0;
    private final LazyJavaResolverContext arg$1;

    public LazyJavaClassMemberScope$$Lambda$4(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        this.arg$0 = lazyJavaClassMemberScope;
        this.arg$1 = lazyJavaResolverContext;
    }

    public Object invoke(Object object) {
        return LazyJavaClassMemberScope.accessor$LazyJavaClassMemberScope$lambda4(this.arg$0, this.arg$1, (Name)object);
    }
}

