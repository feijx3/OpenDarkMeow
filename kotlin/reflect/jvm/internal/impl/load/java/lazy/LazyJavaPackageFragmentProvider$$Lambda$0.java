/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;

class LazyJavaPackageFragmentProvider$$Lambda$0
implements Function0 {
    private final LazyJavaPackageFragmentProvider arg$0;
    private final JavaPackage arg$1;

    public LazyJavaPackageFragmentProvider$$Lambda$0(LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, JavaPackage javaPackage) {
        this.arg$0 = lazyJavaPackageFragmentProvider;
        this.arg$1 = javaPackage;
    }

    public Object invoke() {
        return LazyJavaPackageFragmentProvider.accessor$LazyJavaPackageFragmentProvider$lambda0(this.arg$0, this.arg$1);
    }
}

