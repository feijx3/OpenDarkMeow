/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;

class DescriptorEquivalenceForOverrides$$Lambda$2
implements KotlinTypeChecker.TypeConstructorEquality {
    private final boolean arg$0;
    private final CallableDescriptor arg$1;
    private final CallableDescriptor arg$2;

    public DescriptorEquivalenceForOverrides$$Lambda$2(boolean bl2, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        this.arg$0 = bl2;
        this.arg$1 = callableDescriptor;
        this.arg$2 = callableDescriptor2;
    }

    @Override
    public boolean equals(TypeConstructor typeConstructor2, TypeConstructor typeConstructor3) {
        return DescriptorEquivalenceForOverrides.accessor$DescriptorEquivalenceForOverrides$lambda2(this.arg$0, this.arg$1, this.arg$2, typeConstructor2, typeConstructor3);
    }
}

