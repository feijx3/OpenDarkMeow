/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;

class PredefinedEnhancementInfoKt$$Lambda$8
implements Function1 {
    private final String arg$0;

    public PredefinedEnhancementInfoKt$$Lambda$8(String string) {
        this.arg$0 = string;
    }

    public Object invoke(Object object) {
        return PredefinedEnhancementInfoKt.accessor$PredefinedEnhancementInfoKt$lambda8(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder)object);
    }
}

