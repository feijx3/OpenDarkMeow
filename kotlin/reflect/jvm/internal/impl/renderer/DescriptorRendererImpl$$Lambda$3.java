/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl;

class DescriptorRendererImpl$$Lambda$3
implements Function1 {
    public static final DescriptorRendererImpl$$Lambda$3 INSTANCE = new DescriptorRendererImpl$$Lambda$3();

    public Object invoke(Object object) {
        return DescriptorRendererImpl.accessor$DescriptorRendererImpl$lambda3((ValueParameterDescriptor)object);
    }
}

