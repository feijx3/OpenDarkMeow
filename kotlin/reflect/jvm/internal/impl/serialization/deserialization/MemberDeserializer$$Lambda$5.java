/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;

class MemberDeserializer$$Lambda$5
implements Function0 {
    private final MemberDeserializer arg$0;
    private final ProtoContainer arg$1;
    private final MessageLite arg$2;
    private final AnnotatedCallableKind arg$3;
    private final int arg$4;
    private final ProtoBuf.ValueParameter arg$5;

    public MemberDeserializer$$Lambda$5(MemberDeserializer memberDeserializer, ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int n2, ProtoBuf.ValueParameter valueParameter) {
        this.arg$0 = memberDeserializer;
        this.arg$1 = protoContainer;
        this.arg$2 = messageLite;
        this.arg$3 = annotatedCallableKind;
        this.arg$4 = n2;
        this.arg$5 = valueParameter;
    }

    public Object invoke() {
        return MemberDeserializer.accessor$MemberDeserializer$lambda5(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4, this.arg$5);
    }
}

