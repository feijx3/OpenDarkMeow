/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;

class SignatureEnhancement$$Lambda$1
implements Function1 {
    private final ValueParameterDescriptor arg$0;

    public SignatureEnhancement$$Lambda$1(ValueParameterDescriptor valueParameterDescriptor) {
        this.arg$0 = valueParameterDescriptor;
    }

    public Object invoke(Object object) {
        return SignatureEnhancement.accessor$SignatureEnhancement$lambda1(this.arg$0, (CallableMemberDescriptor)object);
    }
}

