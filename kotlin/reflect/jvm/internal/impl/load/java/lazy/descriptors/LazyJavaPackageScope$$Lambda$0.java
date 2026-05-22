/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;

class LazyJavaPackageScope$$Lambda$0
implements Function0 {
    private final LazyJavaResolverContext arg$0;
    private final LazyJavaPackageScope arg$1;

    public LazyJavaPackageScope$$Lambda$0(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaPackageScope lazyJavaPackageScope) {
        this.arg$0 = lazyJavaResolverContext;
        this.arg$1 = lazyJavaPackageScope;
    }

    public Object invoke() {
        return LazyJavaPackageScope.accessor$LazyJavaPackageScope$lambda0(this.arg$0, this.arg$1);
    }
}

