/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.util.TypeRegistry;

class TypeRegistry$$Lambda$0
implements Function1 {
    private final TypeRegistry arg$0;

    public TypeRegistry$$Lambda$0(TypeRegistry typeRegistry) {
        this.arg$0 = typeRegistry;
    }

    public Object invoke(Object object) {
        return TypeRegistry.accessor$TypeRegistry$lambda0(this.arg$0, (String)object);
    }
}

