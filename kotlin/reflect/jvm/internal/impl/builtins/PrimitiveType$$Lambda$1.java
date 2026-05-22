/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;

class PrimitiveType$$Lambda$1
implements Function0 {
    private final PrimitiveType arg$0;

    public PrimitiveType$$Lambda$1(PrimitiveType primitiveType) {
        this.arg$0 = primitiveType;
    }

    public Object invoke() {
        return PrimitiveType.accessor$PrimitiveType$lambda1(this.arg$0);
    }
}

