/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;

class TypeDeserializer$$Lambda$4
implements Function1 {
    public static final TypeDeserializer$$Lambda$4 INSTANCE = new TypeDeserializer$$Lambda$4();

    public Object invoke(Object object) {
        return TypeDeserializer.accessor$TypeDeserializer$lambda4((ProtoBuf.Type)object);
    }
}

