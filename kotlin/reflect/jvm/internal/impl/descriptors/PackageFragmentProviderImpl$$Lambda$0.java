/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl;

class PackageFragmentProviderImpl$$Lambda$0
implements Function1 {
    public static final PackageFragmentProviderImpl$$Lambda$0 INSTANCE = new PackageFragmentProviderImpl$$Lambda$0();

    public Object invoke(Object object) {
        return PackageFragmentProviderImpl.accessor$PackageFragmentProviderImpl$lambda0((PackageFragmentDescriptor)object);
    }
}

