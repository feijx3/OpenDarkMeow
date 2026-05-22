/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;

class KPackageImpl$$Lambda$1
implements Function2 {
    public static final KPackageImpl$$Lambda$1 INSTANCE = new KPackageImpl$$Lambda$1();

    public Object invoke(Object object, Object object2) {
        return KPackageImpl.accessor$KPackageImpl$lambda1((MemberDeserializer)object, (ProtoBuf.Property)object2);
    }
}

