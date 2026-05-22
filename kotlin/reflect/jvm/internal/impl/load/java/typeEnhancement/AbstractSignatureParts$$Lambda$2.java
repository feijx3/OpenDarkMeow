/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

class AbstractSignatureParts$$Lambda$2
implements Function1 {
    private final AbstractSignatureParts arg$0;
    private final TypeSystemContext arg$1;

    public AbstractSignatureParts$$Lambda$2(AbstractSignatureParts abstractSignatureParts, TypeSystemContext typeSystemContext) {
        this.arg$0 = abstractSignatureParts;
        this.arg$1 = typeSystemContext;
    }

    public Object invoke(Object object) {
        return AbstractSignatureParts.accessor$AbstractSignatureParts$lambda2(this.arg$0, this.arg$1, (AbstractSignatureParts.TypeAndDefaultQualifiers)object);
    }
}

