/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;

class LazyJavaClassMemberScope$$Lambda$0
implements Function0 {
    private final LazyJavaClassMemberScope arg$0;
    private final LazyJavaResolverContext arg$1;

    public LazyJavaClassMemberScope$$Lambda$0(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        this.arg$0 = lazyJavaClassMemberScope;
        this.arg$1 = lazyJavaResolverContext;
    }

    public Object invoke() {
        return LazyJavaClassMemberScope.accessor$LazyJavaClassMemberScope$lambda0(this.arg$0, this.arg$1);
    }
}

