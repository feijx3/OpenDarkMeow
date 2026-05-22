/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

class KDeclarationContainerImpl$$Lambda$2
implements Function1 {
    public static final KDeclarationContainerImpl$$Lambda$2 INSTANCE = new KDeclarationContainerImpl$$Lambda$2();

    public Object invoke(Object object) {
        return KDeclarationContainerImpl.accessor$KDeclarationContainerImpl$lambda2((PropertyDescriptor)object);
    }
}

