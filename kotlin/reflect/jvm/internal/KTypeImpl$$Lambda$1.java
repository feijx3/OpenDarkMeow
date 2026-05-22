/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KTypeImpl;

class KTypeImpl$$Lambda$1
implements Function0 {
    private final KTypeImpl arg$0;
    private final Function0 arg$1;

    public KTypeImpl$$Lambda$1(KTypeImpl kTypeImpl, Function0 function0) {
        this.arg$0 = kTypeImpl;
        this.arg$1 = function0;
    }

    public Object invoke() {
        return KTypeImpl.accessor$KTypeImpl$lambda1(this.arg$0, this.arg$1);
    }
}

