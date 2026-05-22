/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

class KDeclarationContainerImpl$$Lambda$3
implements Function1 {
    public static final KDeclarationContainerImpl$$Lambda$3 INSTANCE = new KDeclarationContainerImpl$$Lambda$3();

    public Object invoke(Object object) {
        return KDeclarationContainerImpl.accessor$KDeclarationContainerImpl$lambda3((FunctionDescriptor)object);
    }
}

