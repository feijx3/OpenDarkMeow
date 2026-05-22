/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

class JvmBuiltInClassDescriptorFactory$$Lambda$1
implements Function1 {
    public static final JvmBuiltInClassDescriptorFactory$$Lambda$1 INSTANCE = new JvmBuiltInClassDescriptorFactory$$Lambda$1();

    public Object invoke(Object object) {
        return JvmBuiltInClassDescriptorFactory.accessor$JvmBuiltInClassDescriptorFactory$lambda1((ModuleDescriptor)object);
    }
}

