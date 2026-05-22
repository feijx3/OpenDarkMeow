/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides;

class DescriptorEquivalenceForOverrides$$Lambda$3
implements Function2 {
    private final CallableDescriptor arg$0;
    private final CallableDescriptor arg$1;

    public DescriptorEquivalenceForOverrides$$Lambda$3(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        this.arg$0 = callableDescriptor;
        this.arg$1 = callableDescriptor2;
    }

    public Object invoke(Object object, Object object2) {
        return DescriptorEquivalenceForOverrides.accessor$DescriptorEquivalenceForOverrides$lambda3(this.arg$0, this.arg$1, (DeclarationDescriptor)object, (DeclarationDescriptor)object2);
    }
}

