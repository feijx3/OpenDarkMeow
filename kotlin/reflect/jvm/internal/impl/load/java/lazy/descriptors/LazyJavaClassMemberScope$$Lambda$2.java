/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;

class LazyJavaClassMemberScope$$Lambda$2
implements Function0 {
    private final LazyJavaResolverContext arg$0;
    private final LazyJavaClassMemberScope arg$1;

    public LazyJavaClassMemberScope$$Lambda$2(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        this.arg$0 = lazyJavaResolverContext;
        this.arg$1 = lazyJavaClassMemberScope;
    }

    public Object invoke() {
        return LazyJavaClassMemberScope.accessor$LazyJavaClassMemberScope$lambda2(this.arg$0, this.arg$1);
    }
}

