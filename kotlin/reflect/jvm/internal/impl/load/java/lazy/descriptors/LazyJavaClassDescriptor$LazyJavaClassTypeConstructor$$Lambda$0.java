/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;

class LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$$Lambda$0
implements Function0 {
    private final LazyJavaClassDescriptor arg$0;

    public LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$$Lambda$0(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        this.arg$0 = lazyJavaClassDescriptor;
    }

    public Object invoke() {
        return LazyJavaClassDescriptor.LazyJavaClassTypeConstructor.accessor$LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$lambda0(this.arg$0);
    }
}

