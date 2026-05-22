/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope;

class JvmPackageScope$$Lambda$0
implements Function0 {
    private final JvmPackageScope arg$0;

    public JvmPackageScope$$Lambda$0(JvmPackageScope jvmPackageScope) {
        this.arg$0 = jvmPackageScope;
    }

    public Object invoke() {
        return JvmPackageScope.accessor$JvmPackageScope$lambda0(this.arg$0);
    }
}

