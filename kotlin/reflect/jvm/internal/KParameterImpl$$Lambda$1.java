/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KParameterImpl;

class KParameterImpl$$Lambda$1
implements Function0 {
    private final KParameterImpl arg$0;

    public KParameterImpl$$Lambda$1(KParameterImpl kParameterImpl) {
        this.arg$0 = kParameterImpl;
    }

    public Object invoke() {
        return KParameterImpl.accessor$KParameterImpl$lambda1(this.arg$0);
    }
}

