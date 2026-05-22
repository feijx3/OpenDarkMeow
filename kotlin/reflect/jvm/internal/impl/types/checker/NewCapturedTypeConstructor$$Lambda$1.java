/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;

class NewCapturedTypeConstructor$$Lambda$1
implements Function0 {
    private final List arg$0;

    public NewCapturedTypeConstructor$$Lambda$1(List list) {
        this.arg$0 = list;
    }

    public Object invoke() {
        return NewCapturedTypeConstructor.accessor$NewCapturedTypeConstructor$lambda1(this.arg$0);
    }
}

