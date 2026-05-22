/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;

class BuiltinMethodsWithDifferentJvmName$$Lambda$0
implements Function1 {
    private final SimpleFunctionDescriptor arg$0;

    public BuiltinMethodsWithDifferentJvmName$$Lambda$0(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        this.arg$0 = simpleFunctionDescriptor;
    }

    public Object invoke(Object object) {
        return BuiltinMethodsWithDifferentJvmName.accessor$BuiltinMethodsWithDifferentJvmName$lambda0(this.arg$0, (CallableMemberDescriptor)object);
    }
}

