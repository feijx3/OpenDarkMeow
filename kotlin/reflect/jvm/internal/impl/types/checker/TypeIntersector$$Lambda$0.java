/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector;

class TypeIntersector$$Lambda$0
implements Function0 {
    private final Set arg$0;

    public TypeIntersector$$Lambda$0(Set set) {
        this.arg$0 = set;
    }

    public Object invoke() {
        return TypeIntersector.accessor$TypeIntersector$lambda0(this.arg$0);
    }
}

