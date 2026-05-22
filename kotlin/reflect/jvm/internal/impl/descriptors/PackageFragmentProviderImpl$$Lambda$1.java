/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;

class PackageFragmentProviderImpl$$Lambda$1
implements Function1 {
    private final FqName arg$0;

    public PackageFragmentProviderImpl$$Lambda$1(FqName fqName) {
        this.arg$0 = fqName;
    }

    public Object invoke(Object object) {
        return PackageFragmentProviderImpl.accessor$PackageFragmentProviderImpl$lambda1(this.arg$0, (FqName)object);
    }
}

