/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

class DeserializedClassDescriptor$DeserializedClassMemberScope$$Lambda$1
implements Function0 {
    private final DeserializedClassDescriptor.DeserializedClassMemberScope arg$0;

    public DeserializedClassDescriptor$DeserializedClassMemberScope$$Lambda$1(DeserializedClassDescriptor.DeserializedClassMemberScope deserializedClassMemberScope) {
        this.arg$0 = deserializedClassMemberScope;
    }

    public Object invoke() {
        return DeserializedClassDescriptor.DeserializedClassMemberScope.accessor$DeserializedClassDescriptor$DeserializedClassMemberScope$lambda1(this.arg$0);
    }
}

