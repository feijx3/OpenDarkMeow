/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;

class StarProjectionImpl$$Lambda$0
implements Function0 {
    private final StarProjectionImpl arg$0;

    public StarProjectionImpl$$Lambda$0(StarProjectionImpl starProjectionImpl) {
        this.arg$0 = starProjectionImpl;
    }

    public Object invoke() {
        return StarProjectionImpl.accessor$StarProjectionImpl$lambda0(this.arg$0);
    }
}

