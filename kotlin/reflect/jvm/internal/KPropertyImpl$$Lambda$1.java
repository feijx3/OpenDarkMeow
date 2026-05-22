/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KPropertyImpl;

class KPropertyImpl$$Lambda$1
implements Function0 {
    private final KPropertyImpl arg$0;

    public KPropertyImpl$$Lambda$1(KPropertyImpl kPropertyImpl) {
        this.arg$0 = kPropertyImpl;
    }

    public Object invoke() {
        return KPropertyImpl.accessor$KPropertyImpl$lambda1(this.arg$0);
    }
}

