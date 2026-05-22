/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KPackageImpl;

class KPackageImpl$$Lambda$0
implements Function0 {
    private final KPackageImpl arg$0;

    public KPackageImpl$$Lambda$0(KPackageImpl kPackageImpl) {
        this.arg$0 = kPackageImpl;
    }

    public Object invoke() {
        return KPackageImpl.accessor$KPackageImpl$lambda0(this.arg$0);
    }
}

