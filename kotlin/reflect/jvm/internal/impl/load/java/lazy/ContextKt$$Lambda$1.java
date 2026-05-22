/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;

class ContextKt$$Lambda$1
implements Function0 {
    private final LazyJavaResolverContext arg$0;
    private final Annotations arg$1;

    public ContextKt$$Lambda$1(LazyJavaResolverContext lazyJavaResolverContext, Annotations annotations) {
        this.arg$0 = lazyJavaResolverContext;
        this.arg$1 = annotations;
    }

    public Object invoke() {
        return ContextKt.accessor$ContextKt$lambda1(this.arg$0, this.arg$1);
    }
}

