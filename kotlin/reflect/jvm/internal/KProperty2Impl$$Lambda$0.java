/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KProperty2Impl;

class KProperty2Impl$$Lambda$0
implements Function0 {
    private final KProperty2Impl arg$0;

    public KProperty2Impl$$Lambda$0(KProperty2Impl kProperty2Impl) {
        this.arg$0 = kProperty2Impl;
    }

    public Object invoke() {
        return KProperty2Impl.accessor$KProperty2Impl$lambda0(this.arg$0);
    }
}

