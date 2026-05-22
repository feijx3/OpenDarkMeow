/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;

class LazyJavaScope$$Lambda$11
implements Function0 {
    private final LazyJavaScope arg$0;
    private final JavaField arg$1;
    private final Ref.ObjectRef arg$2;

    public LazyJavaScope$$Lambda$11(LazyJavaScope lazyJavaScope, JavaField javaField, Ref.ObjectRef objectRef) {
        this.arg$0 = lazyJavaScope;
        this.arg$1 = javaField;
        this.arg$2 = objectRef;
    }

    public Object invoke() {
        return LazyJavaScope.accessor$LazyJavaScope$lambda11(this.arg$0, this.arg$1, this.arg$2);
    }
}

