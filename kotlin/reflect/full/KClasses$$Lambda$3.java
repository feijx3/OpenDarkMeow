/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.full;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.full.KClasses;

class KClasses$$Lambda$3
implements Function1 {
    private final KClass arg$0;

    public KClasses$$Lambda$3(KClass kClass) {
        this.arg$0 = kClass;
    }

    public Object invoke(Object object) {
        return KClasses.accessor$KClasses$lambda3(this.arg$0, (KClass)object);
    }
}

