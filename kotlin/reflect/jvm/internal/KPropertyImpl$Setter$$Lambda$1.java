/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KPropertyImpl;

class KPropertyImpl$Setter$$Lambda$1
implements Function0 {
    private final KPropertyImpl.Setter arg$0;

    public KPropertyImpl$Setter$$Lambda$1(KPropertyImpl.Setter setter) {
        this.arg$0 = setter;
    }

    public Object invoke() {
        return KPropertyImpl.Setter.accessor$KPropertyImpl$Setter$lambda1(this.arg$0);
    }
}

