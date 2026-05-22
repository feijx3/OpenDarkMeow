/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.AbstractStubType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.StubTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class StubTypeForBuilderInference
extends AbstractStubType
implements StubTypeMarker {
    @NotNull
    private final TypeConstructor constructor;
    @NotNull
    private final MemberScope memberScope;

    public StubTypeForBuilderInference(@NotNull NewTypeVariableConstructor originalTypeVariable, boolean isMarkedNullable, @NotNull TypeConstructor constructor) {
        Intrinsics.checkNotNullParameter(originalTypeVariable, "originalTypeVariable");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        super(originalTypeVariable, isMarkedNullable);
        this.constructor = constructor;
        this.memberScope = originalTypeVariable.getBuiltIns().getAnyType().getMemberScope();
    }

    @Override
    @NotNull
    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override
    @NotNull
    public AbstractStubType materialize(boolean newNullability) {
        return new StubTypeForBuilderInference(this.getOriginalTypeVariable(), newNullability, this.getConstructor());
    }

    @Override
    @NotNull
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    @Override
    @NotNull
    public String toString() {
        return "Stub (BI): " + this.getOriginalTypeVariable() + (this.isMarkedNullable() ? "?" : "");
    }
}

