/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

class IntersectionTypeConstructor$$Lambda$0
implements Function1 {
    private final Function1 arg$0;

    public IntersectionTypeConstructor$$Lambda$0(Function1 function1) {
        this.arg$0 = function1;
    }

    public Object invoke(Object object) {
        return IntersectionTypeConstructor.accessor$IntersectionTypeConstructor$lambda0(this.arg$0, (KotlinType)object);
    }
}

