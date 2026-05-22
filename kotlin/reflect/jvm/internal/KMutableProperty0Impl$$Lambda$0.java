/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KMutableProperty0Impl;

class KMutableProperty0Impl$$Lambda$0
implements Function0 {
    private final KMutableProperty0Impl arg$0;

    public KMutableProperty0Impl$$Lambda$0(KMutableProperty0Impl kMutableProperty0Impl) {
        this.arg$0 = kMutableProperty0Impl;
    }

    public Object invoke() {
        return KMutableProperty0Impl.accessor$KMutableProperty0Impl$lambda0(this.arg$0);
    }
}

