/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KFunctionImpl;

class KFunctionImpl$$Lambda$1
implements Function0 {
    private final KFunctionImpl arg$0;

    public KFunctionImpl$$Lambda$1(KFunctionImpl kFunctionImpl) {
        this.arg$0 = kFunctionImpl;
    }

    public Object invoke() {
        return KFunctionImpl.accessor$KFunctionImpl$lambda1(this.arg$0);
    }
}

