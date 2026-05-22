/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

class DescriptorUtilsKt$$Lambda$0
implements DFS.Neighbors {
    public static final DescriptorUtilsKt$$Lambda$0 INSTANCE = new DescriptorUtilsKt$$Lambda$0();

    public Iterable getNeighbors(Object object) {
        return DescriptorUtilsKt.accessor$DescriptorUtilsKt$lambda0((ValueParameterDescriptor)object);
    }
}

