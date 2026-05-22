/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

class AbstractTypeChecker$$Lambda$0
implements Function1 {
    private final Collection arg$0;
    private final TypeCheckerState arg$1;
    private final TypeSystemContext arg$2;
    private final RigidTypeMarker arg$3;

    public AbstractTypeChecker$$Lambda$0(Collection collection, TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker) {
        this.arg$0 = collection;
        this.arg$1 = typeCheckerState;
        this.arg$2 = typeSystemContext;
        this.arg$3 = rigidTypeMarker;
    }

    public Object invoke(Object object) {
        return AbstractTypeChecker.accessor$AbstractTypeChecker$lambda0(this.arg$0, this.arg$1, this.arg$2, this.arg$3, (TypeCheckerState.ForkPointContext)object);
    }
}

