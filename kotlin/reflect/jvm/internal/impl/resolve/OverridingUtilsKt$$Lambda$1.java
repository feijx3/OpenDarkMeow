/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

class OverridingUtilsKt$$Lambda$1
implements Function1 {
    private final SmartSet arg$0;

    public OverridingUtilsKt$$Lambda$1(SmartSet smartSet) {
        this.arg$0 = smartSet;
    }

    public Object invoke(Object object) {
        return OverridingUtilsKt.accessor$OverridingUtilsKt$lambda1(this.arg$0, object);
    }
}

