/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck;

class ReturnsCheck$ReturnsInt$$Lambda$0
implements Function1 {
    public static final ReturnsCheck$ReturnsInt$$Lambda$0 INSTANCE = new ReturnsCheck$ReturnsInt$$Lambda$0();

    public Object invoke(Object object) {
        return ReturnsCheck.ReturnsInt.accessor$ReturnsCheck$ReturnsInt$lambda0((KotlinBuiltIns)object);
    }
}

