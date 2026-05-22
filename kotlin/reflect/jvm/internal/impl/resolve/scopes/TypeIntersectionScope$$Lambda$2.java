/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;

class TypeIntersectionScope$$Lambda$2
implements Function1 {
    public static final TypeIntersectionScope$$Lambda$2 INSTANCE = new TypeIntersectionScope$$Lambda$2();

    public Object invoke(Object object) {
        return TypeIntersectionScope.accessor$TypeIntersectionScope$lambda2((CallableDescriptor)object);
    }
}

