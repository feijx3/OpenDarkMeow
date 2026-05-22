/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KTypeImpl;

class KTypeImpl$$Lambda$3
implements Function0 {
    private final KTypeImpl arg$0;
    private final int arg$1;
    private final Lazy arg$2;

    public KTypeImpl$$Lambda$3(KTypeImpl kTypeImpl, int n2, Lazy lazy) {
        this.arg$0 = kTypeImpl;
        this.arg$1 = n2;
        this.arg$2 = lazy;
    }

    public Object invoke() {
        return KTypeImpl.accessor$KTypeImpl$lambda3(this.arg$0, this.arg$1, this.arg$2);
    }
}

