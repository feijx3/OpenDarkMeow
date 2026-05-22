/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.name.Name;

class LazyJavaScope$$Lambda$4
implements Function1 {
    private final LazyJavaScope arg$0;

    public LazyJavaScope$$Lambda$4(LazyJavaScope lazyJavaScope) {
        this.arg$0 = lazyJavaScope;
    }

    public Object invoke(Object object) {
        return LazyJavaScope.accessor$LazyJavaScope$lambda4(this.arg$0, (Name)object);
    }
}

