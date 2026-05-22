/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

class JavaTypeResolver$$Lambda$0
implements Function0 {
    private final JavaTypeResolver arg$0;
    private final TypeParameterDescriptor arg$1;
    private final JavaTypeAttributes arg$2;
    private final TypeConstructor arg$3;
    private final JavaClassifierType arg$4;

    public JavaTypeResolver$$Lambda$0(JavaTypeResolver javaTypeResolver, TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes, TypeConstructor typeConstructor2, JavaClassifierType javaClassifierType) {
        this.arg$0 = javaTypeResolver;
        this.arg$1 = typeParameterDescriptor;
        this.arg$2 = javaTypeAttributes;
        this.arg$3 = typeConstructor2;
        this.arg$4 = javaClassifierType;
    }

    public Object invoke() {
        return JavaTypeResolver.accessor$JavaTypeResolver$lambda0(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4);
    }
}

