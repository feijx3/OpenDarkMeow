/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;

class MemberDeserializer$$Lambda$3
implements Function0 {
    private final MemberDeserializer arg$0;
    private final boolean arg$1;
    private final ProtoBuf.Property arg$2;

    public MemberDeserializer$$Lambda$3(MemberDeserializer memberDeserializer, boolean bl2, ProtoBuf.Property property) {
        this.arg$0 = memberDeserializer;
        this.arg$1 = bl2;
        this.arg$2 = property;
    }

    public Object invoke() {
        return MemberDeserializer.accessor$MemberDeserializer$lambda3(this.arg$0, this.arg$1, this.arg$2);
    }
}

