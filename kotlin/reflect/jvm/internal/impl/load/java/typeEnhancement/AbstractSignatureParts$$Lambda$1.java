/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo;

class AbstractSignatureParts$$Lambda$1
implements Function1 {
    private final TypeEnhancementInfo arg$0;
    private final JavaTypeQualifiers[] arg$1;

    public AbstractSignatureParts$$Lambda$1(TypeEnhancementInfo typeEnhancementInfo, JavaTypeQualifiers[] javaTypeQualifiersArray) {
        this.arg$0 = typeEnhancementInfo;
        this.arg$1 = javaTypeQualifiersArray;
    }

    public Object invoke(Object object) {
        return AbstractSignatureParts.accessor$AbstractSignatureParts$lambda1(this.arg$0, this.arg$1, ((Number)object).intValue());
    }
}

