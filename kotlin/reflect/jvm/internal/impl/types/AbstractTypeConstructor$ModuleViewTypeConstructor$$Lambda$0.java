/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;

class AbstractTypeConstructor$ModuleViewTypeConstructor$$Lambda$0
implements Function0 {
    private final AbstractTypeConstructor.ModuleViewTypeConstructor arg$0;
    private final AbstractTypeConstructor arg$1;

    public AbstractTypeConstructor$ModuleViewTypeConstructor$$Lambda$0(AbstractTypeConstructor.ModuleViewTypeConstructor moduleViewTypeConstructor, AbstractTypeConstructor abstractTypeConstructor) {
        this.arg$0 = moduleViewTypeConstructor;
        this.arg$1 = abstractTypeConstructor;
    }

    public Object invoke() {
        return AbstractTypeConstructor.ModuleViewTypeConstructor.accessor$AbstractTypeConstructor$ModuleViewTypeConstructor$lambda0(this.arg$0, this.arg$1);
    }
}

