/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AnnotationsContainerWithConstants;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;

class AbstractBinaryClassAnnotationAndConstantLoader$$Lambda$2
implements Function2 {
    public static final AbstractBinaryClassAnnotationAndConstantLoader$$Lambda$2 INSTANCE = new AbstractBinaryClassAnnotationAndConstantLoader$$Lambda$2();

    public Object invoke(Object object, Object object2) {
        return AbstractBinaryClassAnnotationAndConstantLoader.accessor$AbstractBinaryClassAnnotationAndConstantLoader$lambda2((AnnotationsContainerWithConstants)object, (MemberSignature)object2);
    }
}

