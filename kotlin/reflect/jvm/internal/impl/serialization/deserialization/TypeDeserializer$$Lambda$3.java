/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;

class TypeDeserializer$$Lambda$3
implements Function1 {
    private final TypeDeserializer arg$0;

    public TypeDeserializer$$Lambda$3(TypeDeserializer typeDeserializer) {
        this.arg$0 = typeDeserializer;
    }

    public Object invoke(Object object) {
        return TypeDeserializer.accessor$TypeDeserializer$lambda3(this.arg$0, (ProtoBuf.Type)object);
    }
}

