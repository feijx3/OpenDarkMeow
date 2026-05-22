/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaTypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;

class LazyJavaTypeParameterResolver$$Lambda$0
implements Function1 {
    private final LazyJavaTypeParameterResolver arg$0;

    public LazyJavaTypeParameterResolver$$Lambda$0(LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver) {
        this.arg$0 = lazyJavaTypeParameterResolver;
    }

    public Object invoke(Object object) {
        return LazyJavaTypeParameterResolver.accessor$LazyJavaTypeParameterResolver$lambda0(this.arg$0, (JavaTypeParameter)object);
    }
}

