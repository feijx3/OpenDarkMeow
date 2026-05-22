/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KFunctionImpl;

class KFunctionImpl$$Lambda$0
implements Function0 {
    private final KFunctionImpl arg$0;
    private final String arg$1;

    public KFunctionImpl$$Lambda$0(KFunctionImpl kFunctionImpl, String string) {
        this.arg$0 = kFunctionImpl;
        this.arg$1 = string;
    }

    public Object invoke() {
        return KFunctionImpl.accessor$KFunctionImpl$lambda0(this.arg$0, this.arg$1);
    }
}

