/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

class RawSubstitution$$Lambda$0
implements Function1 {
    private final ClassDescriptor arg$0;
    private final RawSubstitution arg$1;
    private final SimpleType arg$2;
    private final JavaTypeAttributes arg$3;

    public RawSubstitution$$Lambda$0(ClassDescriptor classDescriptor, RawSubstitution rawSubstitution, SimpleType simpleType, JavaTypeAttributes javaTypeAttributes) {
        this.arg$0 = classDescriptor;
        this.arg$1 = rawSubstitution;
        this.arg$2 = simpleType;
        this.arg$3 = javaTypeAttributes;
    }

    public Object invoke(Object object) {
        return RawSubstitution.accessor$RawSubstitution$lambda0(this.arg$0, this.arg$1, this.arg$2, this.arg$3, (KotlinTypeRefiner)object);
    }
}

