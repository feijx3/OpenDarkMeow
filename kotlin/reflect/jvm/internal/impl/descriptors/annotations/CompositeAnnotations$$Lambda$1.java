/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;

class CompositeAnnotations$$Lambda$1
implements Function1 {
    public static final CompositeAnnotations$$Lambda$1 INSTANCE = new CompositeAnnotations$$Lambda$1();

    public Object invoke(Object object) {
        return CompositeAnnotations.accessor$CompositeAnnotations$lambda1((Annotations)object);
    }
}

