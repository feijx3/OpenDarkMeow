/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;

class JvmBuiltInsCustomizer$$Lambda$5
implements Function0 {
    private final LazyJavaClassDescriptor arg$0;
    private final ClassDescriptor arg$1;

    public JvmBuiltInsCustomizer$$Lambda$5(LazyJavaClassDescriptor lazyJavaClassDescriptor, ClassDescriptor classDescriptor) {
        this.arg$0 = lazyJavaClassDescriptor;
        this.arg$1 = classDescriptor;
    }

    public Object invoke() {
        return JvmBuiltInsCustomizer.accessor$JvmBuiltInsCustomizer$lambda5(this.arg$0, this.arg$1);
    }
}

