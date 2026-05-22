/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;

class CompositeAnnotations$$Lambda$0
implements Function1 {
    private final FqName arg$0;

    public CompositeAnnotations$$Lambda$0(FqName fqName) {
        this.arg$0 = fqName;
    }

    public Object invoke(Object object) {
        return CompositeAnnotations.accessor$CompositeAnnotations$lambda0(this.arg$0, (Annotations)object);
    }
}

