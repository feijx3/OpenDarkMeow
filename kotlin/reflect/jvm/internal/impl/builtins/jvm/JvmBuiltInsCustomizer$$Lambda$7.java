/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

class JvmBuiltInsCustomizer$$Lambda$7
implements Function1 {
    private final JvmBuiltInsCustomizer arg$0;

    public JvmBuiltInsCustomizer$$Lambda$7(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        this.arg$0 = jvmBuiltInsCustomizer;
    }

    public Object invoke(Object object) {
        return JvmBuiltInsCustomizer.accessor$JvmBuiltInsCustomizer$lambda7(this.arg$0, (CallableMemberDescriptor)object);
    }
}

