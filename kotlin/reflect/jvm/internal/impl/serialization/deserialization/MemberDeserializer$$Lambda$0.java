/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;

class MemberDeserializer$$Lambda$0
implements Function0 {
    private final MemberDeserializer arg$0;
    private final ProtoBuf.Property arg$1;
    private final DeserializedPropertyDescriptor arg$2;

    public MemberDeserializer$$Lambda$0(MemberDeserializer memberDeserializer, ProtoBuf.Property property, DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        this.arg$0 = memberDeserializer;
        this.arg$1 = property;
        this.arg$2 = deserializedPropertyDescriptor;
    }

    public Object invoke() {
        return MemberDeserializer.accessor$MemberDeserializer$lambda0(this.arg$0, this.arg$1, this.arg$2);
    }
}

