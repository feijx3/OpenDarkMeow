/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;

class LazyJavaPackageScope$$Lambda$1
implements Function1 {
    private final LazyJavaPackageScope arg$0;
    private final LazyJavaResolverContext arg$1;

    public LazyJavaPackageScope$$Lambda$1(LazyJavaPackageScope lazyJavaPackageScope, LazyJavaResolverContext lazyJavaResolverContext) {
        this.arg$0 = lazyJavaPackageScope;
        this.arg$1 = lazyJavaResolverContext;
    }

    public Object invoke(Object object) {
        return LazyJavaPackageScope.accessor$LazyJavaPackageScope$lambda1(this.arg$0, this.arg$1, (LazyJavaPackageScope.FindClassRequest)object);
    }
}

