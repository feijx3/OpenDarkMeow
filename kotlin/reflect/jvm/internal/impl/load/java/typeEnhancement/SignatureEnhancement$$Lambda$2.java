/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;

class SignatureEnhancement$$Lambda$2
implements Function1 {
    public static final SignatureEnhancement$$Lambda$2 INSTANCE = new SignatureEnhancement$$Lambda$2();

    public Object invoke(Object object) {
        return SignatureEnhancement.accessor$SignatureEnhancement$lambda2((CallableMemberDescriptor)object);
    }
}

