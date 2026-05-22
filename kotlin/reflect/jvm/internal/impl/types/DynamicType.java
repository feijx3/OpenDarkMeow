/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class DynamicType
extends FlexibleType
implements DynamicTypeMarker {
    @NotNull
    private final TypeAttributes attributes;

    public DynamicType(@NotNull KotlinBuiltIns builtIns, @NotNull TypeAttributes attributes) {
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        SimpleType simpleType = builtIns.getNothingType();
        Intrinsics.checkNotNullExpressionValue(simpleType, "getNothingType(...)");
        SimpleType simpleType2 = builtIns.getNullableAnyType();
        Intrinsics.checkNotNullExpressionValue(simpleType2, "getNullableAnyType(...)");
        super(simpleType, simpleType2);
        this.attributes = attributes;
    }

    @Override
    @NotNull
    public TypeAttributes getAttributes() {
        return this.attributes;
    }

    @Override
    @NotNull
    public SimpleType getDelegate() {
        return this.getUpperBound();
    }

    @Override
    @NotNull
    public DynamicType makeNullableAsSpecified(boolean newNullability) {
        return this;
    }

    @Override
    public boolean isMarkedNullable() {
        return false;
    }

    @Override
    @NotNull
    public DynamicType replaceAttributes(@NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new DynamicType(TypeUtilsKt.getBuiltIns(this.getDelegate()), newAttributes);
    }

    @Override
    @NotNull
    public String render(@NotNull DescriptorRenderer renderer, @NotNull DescriptorRendererOptions options) {
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        Intrinsics.checkNotNullParameter(options, "options");
        return "dynamic";
    }

    @Override
    @NotNull
    public DynamicType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}

