/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

class KClassImpl$Data$$Lambda$19
implements Function0 {
    private final KotlinType arg$0;
    private final KClassImpl.Data arg$1;
    private final KClassImpl arg$2;

    public KClassImpl$Data$$Lambda$19(KotlinType kotlinType, KClassImpl.Data data, KClassImpl kClassImpl) {
        this.arg$0 = kotlinType;
        this.arg$1 = data;
        this.arg$2 = kClassImpl;
    }

    public Object invoke() {
        return KClassImpl.Data.accessor$KClassImpl$Data$lambda19(this.arg$0, this.arg$1, this.arg$2);
    }
}

