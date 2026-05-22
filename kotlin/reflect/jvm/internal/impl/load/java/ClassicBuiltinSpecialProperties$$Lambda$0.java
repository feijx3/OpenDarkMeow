/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties;

class ClassicBuiltinSpecialProperties$$Lambda$0
implements Function1 {
    public static final ClassicBuiltinSpecialProperties$$Lambda$0 INSTANCE = new ClassicBuiltinSpecialProperties$$Lambda$0();

    public Object invoke(Object object) {
        return ClassicBuiltinSpecialProperties.accessor$ClassicBuiltinSpecialProperties$lambda0((CallableMemberDescriptor)object);
    }
}

