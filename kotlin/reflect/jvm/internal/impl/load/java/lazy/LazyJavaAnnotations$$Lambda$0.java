/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;

class LazyJavaAnnotations$$Lambda$0
implements Function1 {
    private final LazyJavaAnnotations arg$0;

    public LazyJavaAnnotations$$Lambda$0(LazyJavaAnnotations lazyJavaAnnotations) {
        this.arg$0 = lazyJavaAnnotations;
    }

    public Object invoke(Object object) {
        return LazyJavaAnnotations.accessor$LazyJavaAnnotations$lambda0(this.arg$0, (JavaAnnotation)object);
    }
}

