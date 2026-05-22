/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

class DeserializedMemberScope$NoReorderImplementation$$Lambda$9
implements Function0 {
    private final DeserializedMemberScope.NoReorderImplementation arg$0;
    private final DeserializedMemberScope arg$1;

    public DeserializedMemberScope$NoReorderImplementation$$Lambda$9(DeserializedMemberScope.NoReorderImplementation noReorderImplementation, DeserializedMemberScope deserializedMemberScope) {
        this.arg$0 = noReorderImplementation;
        this.arg$1 = deserializedMemberScope;
    }

    public Object invoke() {
        return DeserializedMemberScope.NoReorderImplementation.accessor$DeserializedMemberScope$NoReorderImplementation$lambda9(this.arg$0, this.arg$1);
    }
}

