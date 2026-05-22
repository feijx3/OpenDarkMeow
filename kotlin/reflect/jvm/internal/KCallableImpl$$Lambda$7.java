/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;

class KCallableImpl$$Lambda$7
implements Function0 {
    private final ReceiverParameterDescriptor arg$0;

    public KCallableImpl$$Lambda$7(ReceiverParameterDescriptor receiverParameterDescriptor) {
        this.arg$0 = receiverParameterDescriptor;
    }

    public Object invoke() {
        return KCallableImpl.accessor$KCallableImpl$lambda7(this.arg$0);
    }
}

