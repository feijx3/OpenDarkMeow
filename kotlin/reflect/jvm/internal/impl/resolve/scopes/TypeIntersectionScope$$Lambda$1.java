/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;

class TypeIntersectionScope$$Lambda$1
implements Function1 {
    public static final TypeIntersectionScope$$Lambda$1 INSTANCE = new TypeIntersectionScope$$Lambda$1();

    public Object invoke(Object object) {
        return TypeIntersectionScope.accessor$TypeIntersectionScope$lambda1((PropertyDescriptor)object);
    }
}

