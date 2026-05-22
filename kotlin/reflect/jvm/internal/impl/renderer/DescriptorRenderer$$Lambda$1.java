/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;

class DescriptorRenderer$$Lambda$1
implements Function1 {
    public static final DescriptorRenderer$$Lambda$1 INSTANCE = new DescriptorRenderer$$Lambda$1();

    public Object invoke(Object object) {
        return DescriptorRenderer.accessor$DescriptorRenderer$lambda1((DescriptorRendererOptions)object);
    }
}

