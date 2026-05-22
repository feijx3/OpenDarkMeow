/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;

class AbstractTypeConstructor$$Lambda$2
implements Function1 {
    private final AbstractTypeConstructor arg$0;

    public AbstractTypeConstructor$$Lambda$2(AbstractTypeConstructor abstractTypeConstructor) {
        this.arg$0 = abstractTypeConstructor;
    }

    public Object invoke(Object object) {
        return AbstractTypeConstructor.accessor$AbstractTypeConstructor$lambda2(this.arg$0, (AbstractTypeConstructor.Supertypes)object);
    }
}

