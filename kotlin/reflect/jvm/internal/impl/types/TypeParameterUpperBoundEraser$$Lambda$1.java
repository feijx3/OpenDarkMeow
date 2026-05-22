/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;

class TypeParameterUpperBoundEraser$$Lambda$1
implements Function1 {
    private final TypeParameterUpperBoundEraser arg$0;

    public TypeParameterUpperBoundEraser$$Lambda$1(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser) {
        this.arg$0 = typeParameterUpperBoundEraser;
    }

    public Object invoke(Object object) {
        return TypeParameterUpperBoundEraser.accessor$TypeParameterUpperBoundEraser$lambda1(this.arg$0, (TypeParameterUpperBoundEraser.DataToEraseUpperBound)object);
    }
}

