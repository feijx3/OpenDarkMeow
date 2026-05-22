/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

class DeserializedClassDescriptor$$Lambda$1
implements Function0 {
    private final DeserializedClassDescriptor arg$0;

    public DeserializedClassDescriptor$$Lambda$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        this.arg$0 = deserializedClassDescriptor;
    }

    public Object invoke() {
        return DeserializedClassDescriptor.accessor$DeserializedClassDescriptor$lambda1(this.arg$0);
    }
}

