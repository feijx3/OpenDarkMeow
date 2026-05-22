/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nReflectJavaClassifierType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaClassifierType.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaClassifierType\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,64:1\n1#2:65\n1563#3:66\n1634#3,3:67\n*S KotlinDebug\n*F\n+ 1 ReflectJavaClassifierType.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaClassifierType\n*L\n50#1:66\n50#1:67,3\n*E\n"})
public final class ReflectJavaClassifierType
extends ReflectJavaType
implements JavaClassifierType {
    @NotNull
    private final Type reflectType;
    @NotNull
    private final JavaClassifier classifier;

    /*
     * WARNING - void declaration
     */
    public ReflectJavaClassifierType(@NotNull Type reflectType) {
        JavaClassifier javaClassifier;
        void $this$classifier_u24lambda_u240;
        Type type;
        Intrinsics.checkNotNullParameter(reflectType, "reflectType");
        this.reflectType = reflectType;
        ReflectJavaClassifierType reflectJavaClassifierType = this;
        ReflectJavaClassifierType reflectJavaClassifierType2 = this;
        boolean bl2 = false;
        Type type2 = type = $this$classifier_u24lambda_u240.getReflectType();
        if (type2 instanceof Class) {
            javaClassifier = new ReflectJavaClass((Class)type);
        } else if (type2 instanceof TypeVariable) {
            javaClassifier = new ReflectJavaTypeParameter((TypeVariable)type);
        } else if (type2 instanceof ParameterizedType) {
            Type type3 = ((ParameterizedType)type).getRawType();
            Intrinsics.checkNotNull(type3, "null cannot be cast to non-null type java.lang.Class<*>");
            javaClassifier = new ReflectJavaClass((Class)type3);
        } else {
            throw new IllegalStateException("Not a classifier type (" + type.getClass() + "): " + type);
        }
        JavaClassifier classifier = javaClassifier;
        reflectJavaClassifierType2.classifier = classifier;
    }

    @Override
    @NotNull
    public Type getReflectType() {
        return this.reflectType;
    }

    @Override
    @NotNull
    public JavaClassifier getClassifier() {
        return this.classifier;
    }

    @Override
    @NotNull
    public String getClassifierQualifiedName() {
        throw new UnsupportedOperationException("Type not found: " + this.getReflectType());
    }

    @Override
    @NotNull
    public String getPresentableText() {
        return this.getReflectType().toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean isRaw() {
        Type $this$_get_isRaw__u24lambda_u241 = this.getReflectType();
        boolean bl2 = false;
        if (!($this$_get_isRaw__u24lambda_u241 instanceof Class)) return false;
        TypeVariable<Class<T>>[] typeVariableArray = ((Class)$this$_get_isRaw__u24lambda_u241).getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeVariableArray, "getTypeParameters(...)");
        if (((Object[])typeVariableArray).length != 0) return true;
        return false;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<JavaType> getTypeArguments() {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Iterable iterable = ReflectClassUtilKt.getParameterizedTypeArguments(this.getReflectType());
        ReflectJavaType.Factory factory = ReflectJavaType.Factory;
        boolean $i$f$map = false;
        void var4_4 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            Type type = (Type)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(factory.create((Type)p0));
        }
        return (List)destination$iv$iv;
    }

    @Override
    @NotNull
    public Collection<JavaAnnotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override
    @Nullable
    public JavaAnnotation findAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return null;
    }

    @Override
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }
}

