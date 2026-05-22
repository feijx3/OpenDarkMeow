/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

public abstract class WrappedType
extends KotlinType {
    public WrappedType() {
        super(null);
    }

    public boolean isComputed() {
        return true;
    }

    @NotNull
    protected abstract KotlinType getDelegate();

    @Override
    @NotNull
    public TypeConstructor getConstructor() {
        return this.getDelegate().getConstructor();
    }

    @Override
    @NotNull
    public List<TypeProjection> getArguments() {
        return this.getDelegate().getArguments();
    }

    @Override
    public boolean isMarkedNullable() {
        return this.getDelegate().isMarkedNullable();
    }

    @Override
    @NotNull
    public MemberScope getMemberScope() {
        return this.getDelegate().getMemberScope();
    }

    @Override
    @NotNull
    public TypeAttributes getAttributes() {
        return this.getDelegate().getAttributes();
    }

    @Override
    @NotNull
    public final UnwrappedType unwrap() {
        KotlinType result = this.getDelegate();
        while (result instanceof WrappedType) {
            result = ((WrappedType)result).getDelegate();
        }
        KotlinType kotlinType = result;
        Intrinsics.checkNotNull(kotlinType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
        return (UnwrappedType)kotlinType;
    }

    @NotNull
    public String toString() {
        return this.isComputed() ? this.getDelegate().toString() : "<Not computed yet>";
    }
}

