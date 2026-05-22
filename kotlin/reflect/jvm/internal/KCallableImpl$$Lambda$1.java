/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KCallableImpl;

class KCallableImpl$$Lambda$1
implements Function0 {
    private final KCallableImpl arg$0;

    public KCallableImpl$$Lambda$1(KCallableImpl kCallableImpl) {
        this.arg$0 = kCallableImpl;
    }

    public Object invoke() {
        return KCallableImpl.accessor$KCallableImpl$lambda1(this.arg$0);
    }
}

