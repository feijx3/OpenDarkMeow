/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;

class JvmBuiltIns$$Lambda$2
implements Function0 {
    private final JvmBuiltIns arg$0;

    public JvmBuiltIns$$Lambda$2(JvmBuiltIns jvmBuiltIns) {
        this.arg$0 = jvmBuiltIns;
    }

    public Object invoke() {
        return JvmBuiltIns.accessor$JvmBuiltIns$lambda2(this.arg$0);
    }
}

