/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

class LazyJavaClassDescriptor$$Lambda$1
implements Function1 {
    private final LazyJavaClassDescriptor arg$0;

    public LazyJavaClassDescriptor$$Lambda$1(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        this.arg$0 = lazyJavaClassDescriptor;
    }

    public Object invoke(Object object) {
        return LazyJavaClassDescriptor.accessor$LazyJavaClassDescriptor$lambda1(this.arg$0, (KotlinTypeRefiner)object);
    }
}

