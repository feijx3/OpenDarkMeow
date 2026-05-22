/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider;

class AbstractDeserializedPackageFragmentProvider$$Lambda$0
implements Function1 {
    private final AbstractDeserializedPackageFragmentProvider arg$0;

    public AbstractDeserializedPackageFragmentProvider$$Lambda$0(AbstractDeserializedPackageFragmentProvider abstractDeserializedPackageFragmentProvider) {
        this.arg$0 = abstractDeserializedPackageFragmentProvider;
    }

    public Object invoke(Object object) {
        return AbstractDeserializedPackageFragmentProvider.accessor$AbstractDeserializedPackageFragmentProvider$lambda0(this.arg$0, (FqName)object);
    }
}

