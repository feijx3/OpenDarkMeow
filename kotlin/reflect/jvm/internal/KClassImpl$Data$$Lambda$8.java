/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KClassImpl;

class KClassImpl$Data$$Lambda$8
implements Function0 {
    private final KClassImpl.Data arg$0;
    private final KClassImpl arg$1;

    public KClassImpl$Data$$Lambda$8(KClassImpl.Data data, KClassImpl kClassImpl) {
        this.arg$0 = data;
        this.arg$1 = kClassImpl;
    }

    public Object invoke() {
        return KClassImpl.Data.accessor$KClassImpl$Data$lambda8(this.arg$0, this.arg$1);
    }
}

