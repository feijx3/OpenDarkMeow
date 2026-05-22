/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AnnotationsTypeAttribute
extends TypeAttribute<AnnotationsTypeAttribute> {
    @NotNull
    private final Annotations annotations;

    public AnnotationsTypeAttribute(@NotNull Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        this.annotations = annotations;
    }

    @NotNull
    public final Annotations getAnnotations() {
        return this.annotations;
    }

    @Override
    @Nullable
    public AnnotationsTypeAttribute intersect(@Nullable AnnotationsTypeAttribute other) {
        return Intrinsics.areEqual(other, this) ? this : null;
    }

    @Override
    @NotNull
    public AnnotationsTypeAttribute add(@Nullable AnnotationsTypeAttribute other) {
        if (other == null) {
            return this;
        }
        return new AnnotationsTypeAttribute(AnnotationsKt.composeAnnotations(this.annotations, other.annotations));
    }

    @Override
    @NotNull
    public KClass<? extends AnnotationsTypeAttribute> getKey() {
        return Reflection.getOrCreateKotlinClass(AnnotationsTypeAttribute.class);
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof AnnotationsTypeAttribute)) {
            return false;
        }
        return Intrinsics.areEqual(((AnnotationsTypeAttribute)other).annotations, this.annotations);
    }

    public int hashCode() {
        return this.annotations.hashCode();
    }
}

