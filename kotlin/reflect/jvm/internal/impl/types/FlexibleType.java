/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import org.jetbrains.annotations.NotNull;

public abstract class FlexibleType
extends UnwrappedType
implements FlexibleTypeMarker {
    @NotNull
    private final SimpleType lowerBound;
    @NotNull
    private final SimpleType upperBound;

    public FlexibleType(@NotNull SimpleType lowerBound, @NotNull SimpleType upperBound) {
        Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        Intrinsics.checkNotNullParameter(upperBound, "upperBound");
        super(null);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @NotNull
    public final SimpleType getLowerBound() {
        return this.lowerBound;
    }

    @NotNull
    public final SimpleType getUpperBound() {
        return this.upperBound;
    }

    @NotNull
    public abstract SimpleType getDelegate();

    @NotNull
    public abstract String render(@NotNull DescriptorRenderer var1, @NotNull DescriptorRendererOptions var2);

    @Override
    @NotNull
    public TypeAttributes getAttributes() {
        return this.getDelegate().getAttributes();
    }

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

    @NotNull
    public String toString() {
        return DescriptorRenderer.DEBUG_TEXT.renderType(this);
    }
}

