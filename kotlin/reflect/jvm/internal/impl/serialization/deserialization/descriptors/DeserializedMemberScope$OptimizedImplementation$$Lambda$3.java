/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

class DeserializedMemberScope$OptimizedImplementation$$Lambda$3
implements Function0 {
    private final DeserializedMemberScope.OptimizedImplementation arg$0;
    private final DeserializedMemberScope arg$1;

    public DeserializedMemberScope$OptimizedImplementation$$Lambda$3(DeserializedMemberScope.OptimizedImplementation optimizedImplementation, DeserializedMemberScope deserializedMemberScope) {
        this.arg$0 = optimizedImplementation;
        this.arg$1 = deserializedMemberScope;
    }

    public Object invoke() {
        return DeserializedMemberScope.OptimizedImplementation.accessor$DeserializedMemberScope$OptimizedImplementation$lambda3(this.arg$0, this.arg$1);
    }
}

