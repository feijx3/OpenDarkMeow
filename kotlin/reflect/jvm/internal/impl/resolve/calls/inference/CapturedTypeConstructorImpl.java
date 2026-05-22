/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CapturedTypeConstructorImpl
implements CapturedTypeConstructor {
    @NotNull
    private final TypeProjection projection;
    @Nullable
    private NewCapturedTypeConstructor newTypeConstructor;

    public CapturedTypeConstructorImpl(@NotNull TypeProjection projection) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(projection, "projection");
        this.projection = projection;
        boolean bl3 = bl2 = this.getProjection().getProjectionKind() != Variance.INVARIANT;
        if (_Assertions.ENABLED && !bl2) {
            boolean bl4 = false;
            String string = "Only nontrivial projections can be captured, not: " + this.getProjection();
            throw new AssertionError((Object)string);
        }
    }

    @Override
    @NotNull
    public TypeProjection getProjection() {
        return this.projection;
    }

    @Nullable
    public final NewCapturedTypeConstructor getNewTypeConstructor() {
        return this.newTypeConstructor;
    }

    public final void setNewTypeConstructor(@Nullable NewCapturedTypeConstructor newCapturedTypeConstructor) {
        this.newTypeConstructor = newCapturedTypeConstructor;
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public Collection<KotlinType> getSupertypes() {
        KotlinType kotlinType = this.getProjection().getProjectionKind() == Variance.OUT_VARIANCE ? this.getProjection().getType() : (KotlinType)this.getBuiltIns().getNullableAnyType();
        Intrinsics.checkNotNull(kotlinType);
        KotlinType superType = kotlinType;
        return CollectionsKt.listOf(superType);
    }

    @Override
    public boolean isDenotable() {
        return false;
    }

    @Nullable
    public Void getDeclarationDescriptor() {
        return null;
    }

    @NotNull
    public String toString() {
        return "CapturedTypeConstructor(" + this.getProjection() + ')';
    }

    @Override
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns kotlinBuiltIns = this.getProjection().getType().getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(kotlinBuiltIns, "getBuiltIns(...)");
        return kotlinBuiltIns;
    }

    @Override
    @NotNull
    public CapturedTypeConstructorImpl refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection typeProjection = this.getProjection().refine(kotlinTypeRefiner);
        Intrinsics.checkNotNullExpressionValue(typeProjection, "refine(...)");
        return new CapturedTypeConstructorImpl(typeProjection);
    }
}

