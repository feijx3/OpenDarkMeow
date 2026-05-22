/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck;

class ReturnsCheck$ReturnsUnit$$Lambda$0
implements Function1 {
    public static final ReturnsCheck$ReturnsUnit$$Lambda$0 INSTANCE = new ReturnsCheck$ReturnsUnit$$Lambda$0();

    public Object invoke(Object object) {
        return ReturnsCheck.ReturnsUnit.accessor$ReturnsCheck$ReturnsUnit$lambda0((KotlinBuiltIns)object);
    }
}

