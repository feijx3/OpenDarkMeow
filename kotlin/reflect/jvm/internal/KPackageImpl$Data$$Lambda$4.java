/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KPackageImpl;

class KPackageImpl$Data$$Lambda$4
implements Function0 {
    private final KPackageImpl arg$0;
    private final KPackageImpl.Data arg$1;

    public KPackageImpl$Data$$Lambda$4(KPackageImpl kPackageImpl, KPackageImpl.Data data) {
        this.arg$0 = kPackageImpl;
        this.arg$1 = data;
    }

    public Object invoke() {
        return KPackageImpl.Data.accessor$KPackageImpl$Data$lambda4(this.arg$0, this.arg$1);
    }
}

