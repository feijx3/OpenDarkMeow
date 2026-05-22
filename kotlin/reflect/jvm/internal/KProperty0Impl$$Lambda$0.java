/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KProperty0Impl;

class KProperty0Impl$$Lambda$0
implements Function0 {
    private final KProperty0Impl arg$0;

    public KProperty0Impl$$Lambda$0(KProperty0Impl kProperty0Impl) {
        this.arg$0 = kProperty0Impl;
    }

    public Object invoke() {
        return KProperty0Impl.accessor$KProperty0Impl$lambda0(this.arg$0);
    }
}

