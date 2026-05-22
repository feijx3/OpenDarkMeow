/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KTypeImpl;

class KTypeImpl$$Lambda$0
implements Function0 {
    private final KTypeImpl arg$0;

    public KTypeImpl$$Lambda$0(KTypeImpl kTypeImpl) {
        this.arg$0 = kTypeImpl;
    }

    public Object invoke() {
        return KTypeImpl.accessor$KTypeImpl$lambda0(this.arg$0);
    }
}

