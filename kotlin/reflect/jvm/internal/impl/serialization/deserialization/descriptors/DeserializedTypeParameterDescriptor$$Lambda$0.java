/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;

class DeserializedTypeParameterDescriptor$$Lambda$0
implements Function0 {
    private final DeserializedTypeParameterDescriptor arg$0;

    public DeserializedTypeParameterDescriptor$$Lambda$0(DeserializedTypeParameterDescriptor deserializedTypeParameterDescriptor) {
        this.arg$0 = deserializedTypeParameterDescriptor;
    }

    public Object invoke() {
        return DeserializedTypeParameterDescriptor.accessor$DeserializedTypeParameterDescriptor$lambda0(this.arg$0);
    }
}

