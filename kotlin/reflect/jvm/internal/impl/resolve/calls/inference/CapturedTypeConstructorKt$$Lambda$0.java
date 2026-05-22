/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

class CapturedTypeConstructorKt$$Lambda$0
implements Function0 {
    private final TypeProjection arg$0;

    public CapturedTypeConstructorKt$$Lambda$0(TypeProjection typeProjection) {
        this.arg$0 = typeProjection;
    }

    public Object invoke() {
        return CapturedTypeConstructorKt.accessor$CapturedTypeConstructorKt$lambda0(this.arg$0);
    }
}

