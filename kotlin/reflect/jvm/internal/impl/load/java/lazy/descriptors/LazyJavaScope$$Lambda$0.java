/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;

class LazyJavaScope$$Lambda$0
implements Function0 {
    private final LazyJavaScope arg$0;

    public LazyJavaScope$$Lambda$0(LazyJavaScope lazyJavaScope) {
        this.arg$0 = lazyJavaScope;
    }

    public Object invoke() {
        return LazyJavaScope.accessor$LazyJavaScope$lambda0(this.arg$0);
    }
}

