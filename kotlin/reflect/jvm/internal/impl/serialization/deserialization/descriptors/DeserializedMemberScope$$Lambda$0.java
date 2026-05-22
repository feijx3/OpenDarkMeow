/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

class DeserializedMemberScope$$Lambda$0
implements Function0 {
    private final Function0 arg$0;

    public DeserializedMemberScope$$Lambda$0(Function0 function0) {
        this.arg$0 = function0;
    }

    public Object invoke() {
        return DeserializedMemberScope.accessor$DeserializedMemberScope$lambda0(this.arg$0);
    }
}

