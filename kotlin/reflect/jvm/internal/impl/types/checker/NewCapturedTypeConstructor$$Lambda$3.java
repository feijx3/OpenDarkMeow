/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;

class NewCapturedTypeConstructor$$Lambda$3
implements Function0 {
    private final NewCapturedTypeConstructor arg$0;
    private final KotlinTypeRefiner arg$1;

    public NewCapturedTypeConstructor$$Lambda$3(NewCapturedTypeConstructor newCapturedTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner) {
        this.arg$0 = newCapturedTypeConstructor;
        this.arg$1 = kotlinTypeRefiner;
    }

    public Object invoke() {
        return NewCapturedTypeConstructor.accessor$NewCapturedTypeConstructor$lambda3(this.arg$0, this.arg$1);
    }
}

