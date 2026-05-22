/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

class DescriptorRendererImpl$$Lambda$2
implements Function1 {
    private final DescriptorRendererImpl arg$0;

    public DescriptorRendererImpl$$Lambda$2(DescriptorRendererImpl descriptorRendererImpl) {
        this.arg$0 = descriptorRendererImpl;
    }

    public Object invoke(Object object) {
        return DescriptorRendererImpl.accessor$DescriptorRendererImpl$lambda2(this.arg$0, (TypeProjection)object);
    }
}

