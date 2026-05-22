/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

class AbstractTypeAliasDescriptor$$Lambda$1
implements Function1 {
    private final AbstractTypeAliasDescriptor arg$0;

    public AbstractTypeAliasDescriptor$$Lambda$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        this.arg$0 = abstractTypeAliasDescriptor;
    }

    public Object invoke(Object object) {
        return AbstractTypeAliasDescriptor.accessor$AbstractTypeAliasDescriptor$lambda1(this.arg$0, (UnwrappedType)object);
    }
}

