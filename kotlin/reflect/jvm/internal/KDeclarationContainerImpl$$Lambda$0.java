/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;

class KDeclarationContainerImpl$$Lambda$0
implements Function2 {
    public static final KDeclarationContainerImpl$$Lambda$0 INSTANCE = new KDeclarationContainerImpl$$Lambda$0();

    public Object invoke(Object object, Object object2) {
        return KDeclarationContainerImpl.accessor$KDeclarationContainerImpl$lambda0((DescriptorVisibility)object, (DescriptorVisibility)object2);
    }
}

