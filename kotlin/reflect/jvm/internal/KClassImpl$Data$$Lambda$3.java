/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KClassImpl;

class KClassImpl$Data$$Lambda$3
implements Function0 {
    private final KClassImpl arg$0;
    private final KClassImpl.Data arg$1;

    public KClassImpl$Data$$Lambda$3(KClassImpl kClassImpl, KClassImpl.Data data) {
        this.arg$0 = kClassImpl;
        this.arg$1 = data;
    }

    public Object invoke() {
        return KClassImpl.Data.accessor$KClassImpl$Data$lambda3(this.arg$0, this.arg$1);
    }
}

