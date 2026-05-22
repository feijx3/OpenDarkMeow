/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

class DeserializedClassDescriptor$EnumEntryClassDescriptors$$Lambda$2
implements Function0 {
    private final DeserializedClassDescriptor arg$0;
    private final ProtoBuf.EnumEntry arg$1;

    public DeserializedClassDescriptor$EnumEntryClassDescriptors$$Lambda$2(DeserializedClassDescriptor deserializedClassDescriptor, ProtoBuf.EnumEntry enumEntry) {
        this.arg$0 = deserializedClassDescriptor;
        this.arg$1 = enumEntry;
    }

    public Object invoke() {
        return DeserializedClassDescriptor.EnumEntryClassDescriptors.accessor$DeserializedClassDescriptor$EnumEntryClassDescriptors$lambda2(this.arg$0, this.arg$1);
    }
}

