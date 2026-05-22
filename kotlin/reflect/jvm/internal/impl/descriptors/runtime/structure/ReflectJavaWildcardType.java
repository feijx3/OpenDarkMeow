/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nReflectJavaWildcardType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaWildcardType.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaWildcardType\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,45:1\n1#2:46\n*E\n"})
public final class ReflectJavaWildcardType
extends ReflectJavaType
implements JavaWildcardType {
    @NotNull
    private final WildcardType reflectType;
    @NotNull
    private final Collection<JavaAnnotation> annotations;
    private final boolean isDeprecatedInJavaDoc;

    public ReflectJavaWildcardType(@NotNull WildcardType reflectType) {
        Intrinsics.checkNotNullParameter(reflectType, "reflectType");
        this.reflectType = reflectType;
        this.annotations = CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    protected WildcardType getReflectType() {
        return this.reflectType;
    }

    @Override
    @Nullable
    public ReflectJavaType getBound() {
        ReflectJavaType reflectJavaType;
        Type[] upperBounds = this.getReflectType().getUpperBounds();
        Type[] lowerBounds = this.getReflectType().getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + this.getReflectType());
        }
        if (lowerBounds.length == 1) {
            Intrinsics.checkNotNull(lowerBounds);
            Type type = ArraysKt.single(lowerBounds);
            Intrinsics.checkNotNullExpressionValue(type, "single(...)");
            reflectJavaType = ReflectJavaType.Factory.create(type);
        } else if (upperBounds.length == 1) {
            Intrinsics.checkNotNull(upperBounds);
            Type ub2 = ArraysKt.single(upperBounds);
            boolean bl2 = false;
            if (!Intrinsics.areEqual(ub2, Object.class)) {
                Intrinsics.checkNotNull(ub2);
                reflectJavaType = ReflectJavaType.Factory.create(ub2);
            } else {
                reflectJavaType = null;
            }
        } else {
            reflectJavaType = null;
        }
        return reflectJavaType;
    }

    @Override
    public boolean isExtends() {
        Type[] typeArray = this.getReflectType().getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(typeArray, "getUpperBounds(...)");
        return !Intrinsics.areEqual(ArraysKt.firstOrNull((Object[])typeArray), Object.class);
    }

    @Override
    @NotNull
    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override
    public boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }
}

