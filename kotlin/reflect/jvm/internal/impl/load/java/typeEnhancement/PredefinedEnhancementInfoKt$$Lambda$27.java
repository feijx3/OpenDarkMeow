/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;

class PredefinedEnhancementInfoKt$$Lambda$27
implements Function1 {
    private final String arg$0;
    private final String arg$1;

    public PredefinedEnhancementInfoKt$$Lambda$27(String string, String string2) {
        this.arg$0 = string;
        this.arg$1 = string2;
    }

    public Object invoke(Object object) {
        return PredefinedEnhancementInfoKt.accessor$PredefinedEnhancementInfoKt$lambda27(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder)object);
    }
}

