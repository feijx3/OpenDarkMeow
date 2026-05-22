/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl;

class DeserializedPackageFragmentImpl$$Lambda$0
implements Function1 {
    private final DeserializedPackageFragmentImpl arg$0;

    public DeserializedPackageFragmentImpl$$Lambda$0(DeserializedPackageFragmentImpl deserializedPackageFragmentImpl) {
        this.arg$0 = deserializedPackageFragmentImpl;
    }

    public Object invoke(Object object) {
        return DeserializedPackageFragmentImpl.accessor$DeserializedPackageFragmentImpl$lambda0(this.arg$0, (ClassId)object);
    }
}

