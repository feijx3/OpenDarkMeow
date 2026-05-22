/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class StarProjectionImpl
extends TypeProjectionBase {
    @NotNull
    private final TypeParameterDescriptor typeParameter;
    @NotNull
    private final Lazy _type$delegate;

    public StarProjectionImpl(@NotNull TypeParameterDescriptor typeParameter) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        this.typeParameter = typeParameter;
        StarProjectionImpl starProjectionImpl = this;
        this._type$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new StarProjectionImpl$$Lambda$0(starProjectionImpl));
    }

    @Override
    public boolean isStarProjection() {
        return true;
    }

    @Override
    @NotNull
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    private final KotlinType get_type() {
        Lazy lazy = this._type$delegate;
        return (KotlinType)lazy.getValue();
    }

    @Override
    @NotNull
    public KotlinType getType() {
        return this.get_type();
    }

    @Override
    @NotNull
    public TypeProjection refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    private static final KotlinType _type_delegate$lambda$0(StarProjectionImpl this$0) {
        return StarProjectionImplKt.starProjectionType(this$0.typeParameter);
    }

    static /* synthetic */ KotlinType accessor$StarProjectionImpl$lambda0(StarProjectionImpl starProjectionImpl) {
        return StarProjectionImpl._type_delegate$lambda$0(starProjectionImpl);
    }
}

