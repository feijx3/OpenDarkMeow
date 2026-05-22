/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;

class TypeDeserializer$$Lambda$1
implements Function1 {
    private final TypeDeserializer arg$0;

    public TypeDeserializer$$Lambda$1(TypeDeserializer typeDeserializer) {
        this.arg$0 = typeDeserializer;
    }

    public Object invoke(Object object) {
        return TypeDeserializer.accessor$TypeDeserializer$lambda1(this.arg$0, ((Number)object).intValue());
    }
}

