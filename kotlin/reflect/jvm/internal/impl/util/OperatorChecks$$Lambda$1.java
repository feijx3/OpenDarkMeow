/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks;

class OperatorChecks$$Lambda$1
implements Function1 {
    public static final OperatorChecks$$Lambda$1 INSTANCE = new OperatorChecks$$Lambda$1();

    public Object invoke(Object object) {
        return OperatorChecks.accessor$OperatorChecks$lambda1((FunctionDescriptor)object);
    }
}

