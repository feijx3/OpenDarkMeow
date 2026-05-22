/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

class IntersectionTypeConstructor$$Lambda$1
implements Function1 {
    public static final IntersectionTypeConstructor$$Lambda$1 INSTANCE = new IntersectionTypeConstructor$$Lambda$1();

    public Object invoke(Object object) {
        return IntersectionTypeConstructor.accessor$IntersectionTypeConstructor$lambda1((KotlinType)object);
    }
}

