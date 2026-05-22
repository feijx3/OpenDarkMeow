/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

class DescriptorRendererImpl$$Lambda$1
implements Function1 {
    public static final DescriptorRendererImpl$$Lambda$1 INSTANCE = new DescriptorRendererImpl$$Lambda$1();

    public Object invoke(Object object) {
        return DescriptorRendererImpl.accessor$DescriptorRendererImpl$lambda1((KotlinType)object);
    }
}

