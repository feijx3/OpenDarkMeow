/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks;

class OperatorChecks$$Lambda$2
implements Function1 {
    public static final OperatorChecks$$Lambda$2 INSTANCE = new OperatorChecks$$Lambda$2();

    public Object invoke(Object object) {
        return OperatorChecks.accessor$OperatorChecks$lambda2((FunctionDescriptor)object);
    }
}

