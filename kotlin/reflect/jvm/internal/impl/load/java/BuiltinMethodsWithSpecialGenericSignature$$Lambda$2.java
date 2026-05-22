/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;

class BuiltinMethodsWithSpecialGenericSignature$$Lambda$2
implements Function1 {
    public static final BuiltinMethodsWithSpecialGenericSignature$$Lambda$2 INSTANCE = new BuiltinMethodsWithSpecialGenericSignature$$Lambda$2();

    public Object invoke(Object object) {
        return BuiltinMethodsWithSpecialGenericSignature.accessor$BuiltinMethodsWithSpecialGenericSignature$lambda2((CallableMemberDescriptor)object);
    }
}

