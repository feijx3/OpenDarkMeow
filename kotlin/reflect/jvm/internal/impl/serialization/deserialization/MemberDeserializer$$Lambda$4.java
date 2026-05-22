/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;

class MemberDeserializer$$Lambda$4
implements Function0 {
    private final MemberDeserializer arg$0;
    private final MessageLite arg$1;
    private final AnnotatedCallableKind arg$2;

    public MemberDeserializer$$Lambda$4(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        this.arg$0 = memberDeserializer;
        this.arg$1 = messageLite;
        this.arg$2 = annotatedCallableKind;
    }

    public Object invoke() {
        return MemberDeserializer.accessor$MemberDeserializer$lambda4(this.arg$0, this.arg$1, this.arg$2);
    }
}

