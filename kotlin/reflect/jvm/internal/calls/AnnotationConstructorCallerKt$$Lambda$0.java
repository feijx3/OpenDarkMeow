/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.calls;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;

class AnnotationConstructorCallerKt$$Lambda$0
implements Function0 {
    private final Map arg$0;

    public AnnotationConstructorCallerKt$$Lambda$0(Map map) {
        this.arg$0 = map;
    }

    public Object invoke() {
        return AnnotationConstructorCallerKt.accessor$AnnotationConstructorCallerKt$lambda0(this.arg$0);
    }
}

