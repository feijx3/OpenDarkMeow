/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;

class LazyJavaAnnotationDescriptor$$Lambda$0
implements Function0 {
    private final LazyJavaAnnotationDescriptor arg$0;

    public LazyJavaAnnotationDescriptor$$Lambda$0(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        this.arg$0 = lazyJavaAnnotationDescriptor;
    }

    public Object invoke() {
        return LazyJavaAnnotationDescriptor.accessor$LazyJavaAnnotationDescriptor$lambda0(this.arg$0);
    }
}

