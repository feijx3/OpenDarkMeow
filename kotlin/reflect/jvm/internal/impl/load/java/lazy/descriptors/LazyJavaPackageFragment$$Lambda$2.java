/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;

class LazyJavaPackageFragment$$Lambda$2
implements Function0 {
    private final LazyJavaPackageFragment arg$0;

    public LazyJavaPackageFragment$$Lambda$2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        this.arg$0 = lazyJavaPackageFragment;
    }

    public Object invoke() {
        return LazyJavaPackageFragment.accessor$LazyJavaPackageFragment$lambda2(this.arg$0);
    }
}

