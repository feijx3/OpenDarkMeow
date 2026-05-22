/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;

class JavaAnnotationDescriptor$$Lambda$0
implements Function0 {
    private final LazyJavaResolverContext arg$0;
    private final JavaAnnotationDescriptor arg$1;

    public JavaAnnotationDescriptor$$Lambda$0(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationDescriptor javaAnnotationDescriptor) {
        this.arg$0 = lazyJavaResolverContext;
        this.arg$1 = javaAnnotationDescriptor;
    }

    public Object invoke() {
        return JavaAnnotationDescriptor.accessor$JavaAnnotationDescriptor$lambda0(this.arg$0, this.arg$1);
    }
}

