/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl;

class LazyPackageViewDescriptorImpl$$Lambda$0
implements Function0 {
    private final LazyPackageViewDescriptorImpl arg$0;

    public LazyPackageViewDescriptorImpl$$Lambda$0(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        this.arg$0 = lazyPackageViewDescriptorImpl;
    }

    public Object invoke() {
        return LazyPackageViewDescriptorImpl.accessor$LazyPackageViewDescriptorImpl$lambda0(this.arg$0);
    }
}

