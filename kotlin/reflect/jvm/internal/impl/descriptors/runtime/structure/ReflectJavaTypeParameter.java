/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwnerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClassifierType;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nReflectJavaTypeParameter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaTypeParameter.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaTypeParameter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,50:1\n11228#2:51\n11563#2,3:52\n*S KotlinDebug\n*F\n+ 1 ReflectJavaTypeParameter.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaTypeParameter\n*L\n29#1:51\n29#1:52,3\n*E\n"})
public final class ReflectJavaTypeParameter
extends ReflectJavaElement
implements ReflectJavaAnnotationOwner,
JavaTypeParameter {
    @NotNull
    private final TypeVariable<?> typeVariable;

    public ReflectJavaTypeParameter(@NotNull TypeVariable<?> typeVariable) {
        Intrinsics.checkNotNullParameter(typeVariable, "typeVariable");
        this.typeVariable = typeVariable;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<ReflectJavaClassifierType> getUpperBounds() {
        void $this$mapTo$iv$iv;
        Type[] typeArray = this.typeVariable.getBounds();
        Intrinsics.checkNotNullExpressionValue(typeArray, "getBounds(...)");
        Object[] $this$map$iv = typeArray;
        boolean $i$f$map = false;
        Object[] objectArray = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        for (void item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            Type type = (Type)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(new ReflectJavaClassifierType((Type)p0));
        }
        List bounds = (List)destination$iv$iv;
        ReflectJavaClassifierType reflectJavaClassifierType = (ReflectJavaClassifierType)CollectionsKt.singleOrNull(bounds);
        if (Intrinsics.areEqual(reflectJavaClassifierType != null ? reflectJavaClassifierType.getReflectType() : null, Object.class)) {
            return CollectionsKt.emptyList();
        }
        return bounds;
    }

    @Override
    @Nullable
    public AnnotatedElement getElement() {
        TypeVariable<?> typeVariable = this.typeVariable;
        return typeVariable instanceof AnnotatedElement ? (AnnotatedElement)typeVariable : null;
    }

    @Override
    @NotNull
    public Name getName() {
        Name name = Name.identifier(this.typeVariable.getName());
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        return name;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof ReflectJavaTypeParameter && Intrinsics.areEqual(this.typeVariable, ((ReflectJavaTypeParameter)other).typeVariable);
    }

    public int hashCode() {
        return this.typeVariable.hashCode();
    }

    @NotNull
    public String toString() {
        return this.getClass().getName() + ": " + this.typeVariable;
    }

    @Override
    @NotNull
    public List<ReflectJavaAnnotation> getAnnotations() {
        Object object = this.getElement();
        if (object == null || (object = object.getDeclaredAnnotations()) == null || (object = ReflectJavaAnnotationOwnerKt.getAnnotations(object)) == null) {
            object = CollectionsKt.emptyList();
        }
        return object;
    }

    @Override
    @Nullable
    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Annotation[] annotationArray = this.getElement();
        return annotationArray != null && (annotationArray = annotationArray.getDeclaredAnnotations()) != null ? ReflectJavaAnnotationOwnerKt.findAnnotation(annotationArray, fqName) : null;
    }

    @Override
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }
}

