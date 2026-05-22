/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

class AbstractTypeAliasDescriptor$$Lambda$2
implements Function1 {
    private final AbstractTypeAliasDescriptor arg$0;

    public AbstractTypeAliasDescriptor$$Lambda$2(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        this.arg$0 = abstractTypeAliasDescriptor;
    }

    public Object invoke(Object object) {
        return AbstractTypeAliasDescriptor.accessor$AbstractTypeAliasDescriptor$lambda2(this.arg$0, (KotlinTypeRefiner)object);
    }
}

