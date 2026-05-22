/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

class AbstractTypeChecker$$Lambda$1
implements Function0 {
    private final TypeCheckerState arg$0;
    private final TypeSystemContext arg$1;
    private final RigidTypeMarker arg$2;
    private final RigidTypeMarker arg$3;

    public AbstractTypeChecker$$Lambda$1(TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
        this.arg$0 = typeCheckerState;
        this.arg$1 = typeSystemContext;
        this.arg$2 = rigidTypeMarker;
        this.arg$3 = rigidTypeMarker2;
    }

    public Object invoke() {
        return AbstractTypeChecker.accessor$AbstractTypeChecker$lambda1(this.arg$0, this.arg$1, this.arg$2, this.arg$3);
    }
}

