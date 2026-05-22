/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

class LazyWrappedType$$Lambda$0
implements Function0 {
    private final KotlinTypeRefiner arg$0;
    private final LazyWrappedType arg$1;

    public LazyWrappedType$$Lambda$0(KotlinTypeRefiner kotlinTypeRefiner, LazyWrappedType lazyWrappedType) {
        this.arg$0 = kotlinTypeRefiner;
        this.arg$1 = lazyWrappedType;
    }

    public Object invoke() {
        return LazyWrappedType.accessor$LazyWrappedType$lambda0(this.arg$0, this.arg$1);
    }
}

