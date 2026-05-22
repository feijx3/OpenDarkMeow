/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;

class LazyJavaClassMemberScope$$Lambda$9
implements Function0 {
    private final LazyJavaClassMemberScope arg$0;

    public LazyJavaClassMemberScope$$Lambda$9(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        this.arg$0 = lazyJavaClassMemberScope;
    }

    public Object invoke() {
        return LazyJavaClassMemberScope.accessor$LazyJavaClassMemberScope$lambda9(this.arg$0);
    }
}

