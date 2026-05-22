/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.km.internal;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.km.internal.WritersKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

class WritersKt$$Lambda$1
implements Function1 {
    private final ProtoBuf.VersionRequirement.Builder arg$0;

    public WritersKt$$Lambda$1(ProtoBuf.VersionRequirement.Builder builder) {
        this.arg$0 = builder;
    }

    public Object invoke(Object object) {
        return WritersKt.accessor$WritersKt$lambda1(this.arg$0, ((Number)object).intValue());
    }
}

