/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;

class TypeDeserializer$$Lambda$2
implements Function0 {
    private final TypeDeserializer arg$0;
    private final ProtoBuf.Type arg$1;

    public TypeDeserializer$$Lambda$2(TypeDeserializer typeDeserializer, ProtoBuf.Type type) {
        this.arg$0 = typeDeserializer;
        this.arg$1 = type;
    }

    public Object invoke() {
        return TypeDeserializer.accessor$TypeDeserializer$lambda2(this.arg$0, this.arg$1);
    }
}

