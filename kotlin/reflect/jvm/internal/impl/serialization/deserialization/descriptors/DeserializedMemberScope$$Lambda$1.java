/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

class DeserializedMemberScope$$Lambda$1
implements Function0 {
    private final DeserializedMemberScope arg$0;

    public DeserializedMemberScope$$Lambda$1(DeserializedMemberScope deserializedMemberScope) {
        this.arg$0 = deserializedMemberScope;
    }

    public Object invoke() {
        return DeserializedMemberScope.accessor$DeserializedMemberScope$lambda1(this.arg$0);
    }
}

