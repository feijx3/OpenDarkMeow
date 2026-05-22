/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides;

class DescriptorEquivalenceForOverrides$$Lambda$1
implements Function2 {
    public static final DescriptorEquivalenceForOverrides$$Lambda$1 INSTANCE = new DescriptorEquivalenceForOverrides$$Lambda$1();

    public Object invoke(Object object, Object object2) {
        return DescriptorEquivalenceForOverrides.accessor$DescriptorEquivalenceForOverrides$lambda1((DeclarationDescriptor)object, (DeclarationDescriptor)object2);
    }
}

