/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;

class AbstractBinaryClassAnnotationAndConstantLoader$$Lambda$0
implements Function1 {
    private final AbstractBinaryClassAnnotationAndConstantLoader arg$0;

    public AbstractBinaryClassAnnotationAndConstantLoader$$Lambda$0(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader) {
        this.arg$0 = abstractBinaryClassAnnotationAndConstantLoader;
    }

    public Object invoke(Object object) {
        return AbstractBinaryClassAnnotationAndConstantLoader.accessor$AbstractBinaryClassAnnotationAndConstantLoader$lambda0(this.arg$0, (KotlinJvmBinaryClass)object);
    }
}

