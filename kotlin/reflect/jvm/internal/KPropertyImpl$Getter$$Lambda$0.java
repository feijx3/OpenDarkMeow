/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KPropertyImpl;

class KPropertyImpl$Getter$$Lambda$0
implements Function0 {
    private final KPropertyImpl.Getter arg$0;

    public KPropertyImpl$Getter$$Lambda$0(KPropertyImpl.Getter getter) {
        this.arg$0 = getter;
    }

    public Object invoke() {
        return KPropertyImpl.Getter.accessor$KPropertyImpl$Getter$lambda0(this.arg$0);
    }
}

