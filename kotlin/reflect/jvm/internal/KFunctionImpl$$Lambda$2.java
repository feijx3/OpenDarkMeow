/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KFunctionImpl;

class KFunctionImpl$$Lambda$2
implements Function0 {
    private final KFunctionImpl arg$0;

    public KFunctionImpl$$Lambda$2(KFunctionImpl kFunctionImpl) {
        this.arg$0 = kFunctionImpl;
    }

    public Object invoke() {
        return KFunctionImpl.accessor$KFunctionImpl$lambda2(this.arg$0);
    }
}

