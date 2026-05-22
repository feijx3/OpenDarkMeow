/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

class DescriptorUtilsKt$$Lambda$2
implements DFS.Neighbors {
    private final boolean arg$0;

    public DescriptorUtilsKt$$Lambda$2(boolean bl2) {
        this.arg$0 = bl2;
    }

    public Iterable getNeighbors(Object object) {
        return DescriptorUtilsKt.accessor$DescriptorUtilsKt$lambda2(this.arg$0, (CallableMemberDescriptor)object);
    }
}

