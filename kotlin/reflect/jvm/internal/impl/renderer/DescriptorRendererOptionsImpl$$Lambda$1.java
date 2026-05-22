/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl;

class DescriptorRendererOptionsImpl$$Lambda$1
implements Function1 {
    public static final DescriptorRendererOptionsImpl$$Lambda$1 INSTANCE = new DescriptorRendererOptionsImpl$$Lambda$1();

    public Object invoke(Object object) {
        return DescriptorRendererOptionsImpl.accessor$DescriptorRendererOptionsImpl$lambda1((ValueParameterDescriptor)object);
    }
}

