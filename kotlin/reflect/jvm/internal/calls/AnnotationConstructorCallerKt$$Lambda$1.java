/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.calls;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;

class AnnotationConstructorCallerKt$$Lambda$1
implements Function0 {
    private final Class arg$0;
    private final Map arg$1;

    public AnnotationConstructorCallerKt$$Lambda$1(Class clazz, Map map) {
        this.arg$0 = clazz;
        this.arg$1 = map;
    }

    public Object invoke() {
        return AnnotationConstructorCallerKt.accessor$AnnotationConstructorCallerKt$lambda1(this.arg$0, this.arg$1);
    }
}

