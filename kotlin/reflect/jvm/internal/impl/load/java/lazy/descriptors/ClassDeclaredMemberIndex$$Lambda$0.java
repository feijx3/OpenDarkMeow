/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;

class ClassDeclaredMemberIndex$$Lambda$0
implements Function1 {
    private final ClassDeclaredMemberIndex arg$0;

    public ClassDeclaredMemberIndex$$Lambda$0(ClassDeclaredMemberIndex classDeclaredMemberIndex) {
        this.arg$0 = classDeclaredMemberIndex;
    }

    public Object invoke(Object object) {
        return ClassDeclaredMemberIndex.accessor$ClassDeclaredMemberIndex$lambda0(this.arg$0, (JavaMethod)object);
    }
}

