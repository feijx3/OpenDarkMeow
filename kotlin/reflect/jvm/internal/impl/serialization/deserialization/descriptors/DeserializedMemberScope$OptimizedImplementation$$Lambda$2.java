/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

class DeserializedMemberScope$OptimizedImplementation$$Lambda$2
implements Function1 {
    private final DeserializedMemberScope.OptimizedImplementation arg$0;

    public DeserializedMemberScope$OptimizedImplementation$$Lambda$2(DeserializedMemberScope.OptimizedImplementation optimizedImplementation) {
        this.arg$0 = optimizedImplementation;
    }

    public Object invoke(Object object) {
        return DeserializedMemberScope.OptimizedImplementation.accessor$DeserializedMemberScope$OptimizedImplementation$lambda2(this.arg$0, (Name)object);
    }
}

