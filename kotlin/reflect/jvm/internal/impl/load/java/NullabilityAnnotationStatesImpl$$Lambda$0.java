/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStatesImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;

class NullabilityAnnotationStatesImpl$$Lambda$0
implements Function1 {
    private final NullabilityAnnotationStatesImpl arg$0;

    public NullabilityAnnotationStatesImpl$$Lambda$0(NullabilityAnnotationStatesImpl nullabilityAnnotationStatesImpl) {
        this.arg$0 = nullabilityAnnotationStatesImpl;
    }

    public Object invoke(Object object) {
        return NullabilityAnnotationStatesImpl.accessor$NullabilityAnnotationStatesImpl$lambda0(this.arg$0, (FqName)object);
    }
}

