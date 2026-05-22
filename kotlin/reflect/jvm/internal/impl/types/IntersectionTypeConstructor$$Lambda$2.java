/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

class IntersectionTypeConstructor$$Lambda$2
implements Function1 {
    private final IntersectionTypeConstructor arg$0;

    public IntersectionTypeConstructor$$Lambda$2(IntersectionTypeConstructor intersectionTypeConstructor) {
        this.arg$0 = intersectionTypeConstructor;
    }

    public Object invoke(Object object) {
        return IntersectionTypeConstructor.accessor$IntersectionTypeConstructor$lambda2(this.arg$0, (KotlinTypeRefiner)object);
    }
}

