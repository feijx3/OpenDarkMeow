/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts;

class AbstractSignatureParts$$Lambda$0
implements Function1 {
    private final AbstractSignatureParts arg$0;
    private final AbstractSignatureParts.TypeAndDefaultQualifiers arg$1;

    public AbstractSignatureParts$$Lambda$0(AbstractSignatureParts abstractSignatureParts, AbstractSignatureParts.TypeAndDefaultQualifiers typeAndDefaultQualifiers) {
        this.arg$0 = abstractSignatureParts;
        this.arg$1 = typeAndDefaultQualifiers;
    }

    public Object invoke(Object object) {
        return AbstractSignatureParts.accessor$AbstractSignatureParts$lambda0(this.arg$0, this.arg$1, object);
    }
}

