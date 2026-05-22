/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KClassImpl;

class KClassImpl$$Lambda$0
implements Function0 {
    private final KClassImpl arg$0;

    public KClassImpl$$Lambda$0(KClassImpl kClassImpl) {
        this.arg$0 = kClassImpl;
    }

    public Object invoke() {
        return KClassImpl.accessor$KClassImpl$lambda0(this.arg$0);
    }
}

