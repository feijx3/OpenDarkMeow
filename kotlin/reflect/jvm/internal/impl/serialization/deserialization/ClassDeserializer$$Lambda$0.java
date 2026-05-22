/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;

class ClassDeserializer$$Lambda$0
implements Function1 {
    private final ClassDeserializer arg$0;

    public ClassDeserializer$$Lambda$0(ClassDeserializer classDeserializer) {
        this.arg$0 = classDeserializer;
    }

    public Object invoke(Object object) {
        return ClassDeserializer.accessor$ClassDeserializer$lambda0(this.arg$0, (ClassDeserializer.ClassKey)object);
    }
}

