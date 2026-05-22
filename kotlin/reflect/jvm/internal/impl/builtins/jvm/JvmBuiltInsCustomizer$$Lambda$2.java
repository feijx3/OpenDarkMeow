/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;

class JvmBuiltInsCustomizer$$Lambda$2
implements Function1 {
    private final JvmBuiltInsCustomizer arg$0;

    public JvmBuiltInsCustomizer$$Lambda$2(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        this.arg$0 = jvmBuiltInsCustomizer;
    }

    public Object invoke(Object object) {
        return JvmBuiltInsCustomizer.accessor$JvmBuiltInsCustomizer$lambda2(this.arg$0, (Pair)object);
    }
}

