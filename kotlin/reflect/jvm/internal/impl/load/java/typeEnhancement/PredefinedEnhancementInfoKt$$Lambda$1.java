/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

class PredefinedEnhancementInfoKt$$Lambda$1
implements Function1 {
    private final SignatureBuildingComponents arg$0;

    public PredefinedEnhancementInfoKt$$Lambda$1(SignatureBuildingComponents signatureBuildingComponents) {
        this.arg$0 = signatureBuildingComponents;
    }

    public Object invoke(Object object) {
        return PredefinedEnhancementInfoKt.accessor$PredefinedEnhancementInfoKt$lambda1(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder)object);
    }
}

