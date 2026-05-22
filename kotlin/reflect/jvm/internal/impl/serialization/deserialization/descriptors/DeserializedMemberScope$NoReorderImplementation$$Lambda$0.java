/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

class DeserializedMemberScope$NoReorderImplementation$$Lambda$0
implements Function0 {
    private final DeserializedMemberScope.NoReorderImplementation arg$0;

    public DeserializedMemberScope$NoReorderImplementation$$Lambda$0(DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
        this.arg$0 = noReorderImplementation;
    }

    public Object invoke() {
        return DeserializedMemberScope.NoReorderImplementation.accessor$DeserializedMemberScope$NoReorderImplementation$lambda0(this.arg$0);
    }
}

