/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

class JvmBuiltInClassDescriptorFactory$$Lambda$0
implements Function0 {
    private final JvmBuiltInClassDescriptorFactory arg$0;
    private final StorageManager arg$1;

    public JvmBuiltInClassDescriptorFactory$$Lambda$0(JvmBuiltInClassDescriptorFactory jvmBuiltInClassDescriptorFactory, StorageManager storageManager) {
        this.arg$0 = jvmBuiltInClassDescriptorFactory;
        this.arg$1 = storageManager;
    }

    public Object invoke() {
        return JvmBuiltInClassDescriptorFactory.accessor$JvmBuiltInClassDescriptorFactory$lambda0(this.arg$0, this.arg$1);
    }
}

