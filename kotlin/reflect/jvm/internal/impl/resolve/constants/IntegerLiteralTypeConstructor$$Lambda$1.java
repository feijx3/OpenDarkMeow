/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

class IntegerLiteralTypeConstructor$$Lambda$1
implements Function1 {
    public static final IntegerLiteralTypeConstructor$$Lambda$1 INSTANCE = new IntegerLiteralTypeConstructor$$Lambda$1();

    public Object invoke(Object object) {
        return IntegerLiteralTypeConstructor.accessor$IntegerLiteralTypeConstructor$lambda1((KotlinType)object);
    }
}

