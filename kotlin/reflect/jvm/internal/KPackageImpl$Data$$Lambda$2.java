/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KPackageImpl;

class KPackageImpl$Data$$Lambda$2
implements Function0 {
    private final KPackageImpl.Data arg$0;
    private final KPackageImpl arg$1;

    public KPackageImpl$Data$$Lambda$2(KPackageImpl.Data data, KPackageImpl kPackageImpl) {
        this.arg$0 = data;
        this.arg$1 = kPackageImpl;
    }

    public Object invoke() {
        return KPackageImpl.Data.accessor$KPackageImpl$Data$lambda2(this.arg$0, this.arg$1);
    }
}

