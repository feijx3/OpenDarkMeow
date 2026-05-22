/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.full;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;
import kotlin.reflect.full.KClasses;

class KClasses$$Lambda$0
implements Function0 {
    private final KClass arg$0;

    public KClasses$$Lambda$0(KClass kClass) {
        this.arg$0 = kClass;
    }

    public Object invoke() {
        return KClasses.accessor$KClasses$lambda0(this.arg$0);
    }
}

