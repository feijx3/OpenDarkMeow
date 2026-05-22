/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KTypeParameterImpl;

class KTypeParameterImpl$$Lambda$0
implements Function0 {
    private final KTypeParameterImpl arg$0;

    public KTypeParameterImpl$$Lambda$0(KTypeParameterImpl kTypeParameterImpl) {
        this.arg$0 = kTypeParameterImpl;
    }

    public Object invoke() {
        return KTypeParameterImpl.accessor$KTypeParameterImpl$lambda0(this.arg$0);
    }
}

