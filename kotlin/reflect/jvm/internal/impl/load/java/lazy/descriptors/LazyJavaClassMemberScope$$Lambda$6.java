/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.name.Name;

class LazyJavaClassMemberScope$$Lambda$6
implements Function1 {
    private final SimpleFunctionDescriptor arg$0;
    private final LazyJavaClassMemberScope arg$1;

    public LazyJavaClassMemberScope$$Lambda$6(SimpleFunctionDescriptor simpleFunctionDescriptor, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        this.arg$0 = simpleFunctionDescriptor;
        this.arg$1 = lazyJavaClassMemberScope;
    }

    public Object invoke(Object object) {
        return LazyJavaClassMemberScope.accessor$LazyJavaClassMemberScope$lambda6(this.arg$0, this.arg$1, (Name)object);
    }
}

