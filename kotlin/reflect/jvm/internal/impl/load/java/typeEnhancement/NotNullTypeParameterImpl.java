/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class NotNullTypeParameterImpl
extends DelegatingSimpleType
implements NotNullTypeParameter {
    @NotNull
    private final SimpleType delegate;

    public NotNullTypeParameterImpl(@NotNull SimpleType delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override
    @NotNull
    protected SimpleType getDelegate() {
        return this.delegate;
    }

    @Override
    public boolean isTypeParameter() {
        return true;
    }

    @Override
    @NotNull
    public KotlinType substitutionResult(@NotNull KotlinType replacement) {
        KotlinType kotlinType;
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        UnwrappedType unwrappedType = replacement.unwrap();
        if (!TypeUtilsKt.isTypeParameter(unwrappedType) && !TypeUtils.isNullableType(unwrappedType)) {
            return unwrappedType;
        }
        UnwrappedType unwrappedType2 = unwrappedType;
        if (unwrappedType2 instanceof SimpleType) {
            kotlinType = this.prepareReplacement((SimpleType)unwrappedType);
        } else if (unwrappedType2 instanceof FlexibleType) {
            kotlinType = TypeWithEnhancementKt.wrapEnhancement(KotlinTypeFactory.flexibleType(this.prepareReplacement(((FlexibleType)unwrappedType).getLowerBound()), this.prepareReplacement(((FlexibleType)unwrappedType).getUpperBound())), TypeWithEnhancementKt.getEnhancement(unwrappedType));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return kotlinType;
    }

    @Override
    public boolean isMarkedNullable() {
        return false;
    }

    private final SimpleType prepareReplacement(SimpleType $this$prepareReplacement) {
        SimpleType result = $this$prepareReplacement.makeNullableAsSpecified(false);
        if (!TypeUtilsKt.isTypeParameter($this$prepareReplacement)) {
            return result;
        }
        return new NotNullTypeParameterImpl(result);
    }

    @Override
    @NotNull
    public NotNullTypeParameterImpl replaceAttributes(@NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new NotNullTypeParameterImpl(this.getDelegate().replaceAttributes(newAttributes));
    }

    @Override
    @NotNull
    public SimpleType makeNullableAsSpecified(boolean newNullability) {
        return newNullability ? this.getDelegate().makeNullableAsSpecified(true) : (SimpleType)this;
    }

    @Override
    @NotNull
    public NotNullTypeParameterImpl replaceDelegate(@NotNull SimpleType delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new NotNullTypeParameterImpl(delegate);
    }
}

