/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;

class ContextKt$$Lambda$0
implements Function0 {
    private final LazyJavaResolverContext arg$0;
    private final ClassOrPackageFragmentDescriptor arg$1;

    public ContextKt$$Lambda$0(LazyJavaResolverContext lazyJavaResolverContext, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor) {
        this.arg$0 = lazyJavaResolverContext;
        this.arg$1 = classOrPackageFragmentDescriptor;
    }

    public Object invoke() {
        return ContextKt.accessor$ContextKt$lambda0(this.arg$0, this.arg$1);
    }
}

