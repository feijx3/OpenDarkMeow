/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

class JvmBuiltInsCustomizer$$Lambda$0
implements Function0 {
    private final JvmBuiltInsCustomizer arg$0;
    private final StorageManager arg$1;

    public JvmBuiltInsCustomizer$$Lambda$0(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, StorageManager storageManager) {
        this.arg$0 = jvmBuiltInsCustomizer;
        this.arg$1 = storageManager;
    }

    public Object invoke() {
        return JvmBuiltInsCustomizer.accessor$JvmBuiltInsCustomizer$lambda0(this.arg$0, this.arg$1);
    }
}

