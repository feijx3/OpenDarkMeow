/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

class DeserializedClassDescriptor$DeserializedClassMemberScope$$Lambda$0
implements Function0 {
    private final List arg$0;

    public DeserializedClassDescriptor$DeserializedClassMemberScope$$Lambda$0(List list) {
        this.arg$0 = list;
    }

    public Object invoke() {
        return DeserializedClassDescriptor.DeserializedClassMemberScope.accessor$DeserializedClassDescriptor$DeserializedClassMemberScope$lambda0(this.arg$0);
    }
}

