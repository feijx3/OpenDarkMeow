/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

class JvmBuiltIns$$Lambda$0
implements Function0 {
    private final JvmBuiltIns arg$0;
    private final StorageManager arg$1;

    public JvmBuiltIns$$Lambda$0(JvmBuiltIns jvmBuiltIns, StorageManager storageManager) {
        this.arg$0 = jvmBuiltIns;
        this.arg$1 = storageManager;
    }

    public Object invoke() {
        return JvmBuiltIns.accessor$JvmBuiltIns$lambda0(this.arg$0, this.arg$1);
    }
}

