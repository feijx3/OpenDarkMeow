/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

class DescriptorUtilsKt$$Lambda$3
implements Function1 {
    private final boolean arg$0;

    public DescriptorUtilsKt$$Lambda$3(boolean bl2) {
        this.arg$0 = bl2;
    }

    public Object invoke(Object object) {
        return DescriptorUtilsKt.accessor$DescriptorUtilsKt$lambda3(this.arg$0, (CallableMemberDescriptor)object);
    }
}

