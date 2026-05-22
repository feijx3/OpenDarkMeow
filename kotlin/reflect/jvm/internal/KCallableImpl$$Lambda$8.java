/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

class KCallableImpl$$Lambda$8
implements Function0 {
    private final CallableMemberDescriptor arg$0;
    private final int arg$1;

    public KCallableImpl$$Lambda$8(CallableMemberDescriptor callableMemberDescriptor, int n2) {
        this.arg$0 = callableMemberDescriptor;
        this.arg$1 = n2;
    }

    public Object invoke() {
        return KCallableImpl.accessor$KCallableImpl$lambda8(this.arg$0, this.arg$1);
    }
}

