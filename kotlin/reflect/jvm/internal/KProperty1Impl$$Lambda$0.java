/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KProperty1Impl;

class KProperty1Impl$$Lambda$0
implements Function0 {
    private final KProperty1Impl arg$0;

    public KProperty1Impl$$Lambda$0(KProperty1Impl kProperty1Impl) {
        this.arg$0 = kProperty1Impl;
    }

    public Object invoke() {
        return KProperty1Impl.accessor$KProperty1Impl$lambda0(this.arg$0);
    }
}

