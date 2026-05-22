/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class SimpleTypeWithEnhancement
extends DelegatingSimpleType
implements TypeWithEnhancement {
    @NotNull
    private final SimpleType delegate;
    @NotNull
    private final KotlinType enhancement;

    public SimpleTypeWithEnhancement(@NotNull SimpleType delegate, @NotNull KotlinType enhancement) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(enhancement, "enhancement");
        this.delegate = delegate;
        this.enhancement = enhancement;
    }

    @Override
    @NotNull
    protected SimpleType getDelegate() {
        return this.delegate;
    }

    @Override
    @NotNull
    public KotlinType getEnhancement() {
        return this.enhancement;
    }

    @Override
    @NotNull
    public SimpleType getOrigin() {
        return this.getDelegate();
    }

    @Override
    @NotNull
    public SimpleType replaceAttributes(@NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        UnwrappedType unwrappedType = TypeWithEnhancementKt.wrapEnhancement(this.getOrigin().replaceAttributes(newAttributes), this.getEnhancement());
        Intrinsics.checkNotNull(unwrappedType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (SimpleType)unwrappedType;
    }

    @Override
    @NotNull
    public SimpleType makeNullableAsSpecified(boolean newNullability) {
        UnwrappedType unwrappedType = TypeWithEnhancementKt.wrapEnhancement(this.getOrigin().makeNullableAsSpecified(newNullability), this.getEnhancement().unwrap().makeNullableAsSpecified(newNullability));
        Intrinsics.checkNotNull(unwrappedType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (SimpleType)unwrappedType;
    }

    @Override
    @NotNull
    public SimpleTypeWithEnhancement replaceDelegate(@NotNull SimpleType delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new SimpleTypeWithEnhancement(delegate, this.getEnhancement());
    }

    @Override
    @NotNull
    public SimpleTypeWithEnhancement refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinType kotlinType = kotlinTypeRefiner.refineType(this.getDelegate());
        Intrinsics.checkNotNull(kotlinType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new SimpleTypeWithEnhancement((SimpleType)kotlinType, kotlinTypeRefiner.refineType(this.getEnhancement()));
    }

    @Override
    @NotNull
    public String toString() {
        return "[@EnhancedForWarnings(" + this.getEnhancement() + ")] " + this.getOrigin();
    }
}

