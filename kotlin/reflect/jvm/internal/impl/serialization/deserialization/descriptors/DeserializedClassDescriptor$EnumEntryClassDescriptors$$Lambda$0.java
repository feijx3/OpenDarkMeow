/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

class DeserializedClassDescriptor$EnumEntryClassDescriptors$$Lambda$0
implements Function1 {
    private final DeserializedClassDescriptor.EnumEntryClassDescriptors arg$0;
    private final DeserializedClassDescriptor arg$1;

    public DeserializedClassDescriptor$EnumEntryClassDescriptors$$Lambda$0(DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors, DeserializedClassDescriptor deserializedClassDescriptor) {
        this.arg$0 = enumEntryClassDescriptors;
        this.arg$1 = deserializedClassDescriptor;
    }

    public Object invoke(Object object) {
        return DeserializedClassDescriptor.EnumEntryClassDescriptors.accessor$DeserializedClassDescriptor$EnumEntryClassDescriptors$lambda0(this.arg$0, this.arg$1, (Name)object);
    }
}

