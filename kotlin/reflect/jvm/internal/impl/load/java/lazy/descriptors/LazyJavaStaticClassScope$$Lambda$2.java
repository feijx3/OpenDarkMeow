/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

class LazyJavaStaticClassScope$$Lambda$2
implements Function1 {
    private final Name arg$0;

    public LazyJavaStaticClassScope$$Lambda$2(Name name) {
        this.arg$0 = name;
    }

    public Object invoke(Object object) {
        return LazyJavaStaticClassScope.accessor$LazyJavaStaticClassScope$lambda2(this.arg$0, (MemberScope)object);
    }
}

