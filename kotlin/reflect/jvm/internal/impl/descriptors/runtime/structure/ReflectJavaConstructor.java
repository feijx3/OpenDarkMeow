/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nReflectJavaConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaConstructor.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaConstructor\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,51:1\n11228#2:52\n11563#2,3:53\n*S KotlinDebug\n*F\n+ 1 ReflectJavaConstructor.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaConstructor\n*L\n49#1:52\n49#1:53,3\n*E\n"})
public final class ReflectJavaConstructor
extends ReflectJavaMember
implements JavaConstructor {
    @NotNull
    private final Constructor<?> member;

    public ReflectJavaConstructor(@NotNull Constructor<?> member) {
        Intrinsics.checkNotNullParameter(member, "member");
        this.member = member;
    }

    @Override
    @NotNull
    public Constructor<?> getMember() {
        return this.member;
    }

    @Override
    @NotNull
    public List<JavaValueParameter> getValueParameters() {
        Annotation[][] annotationArray;
        Type[] types = ((Constructor)this.getMember()).getGenericParameterTypes();
        Intrinsics.checkNotNull(types);
        if (types.length == 0) {
            return CollectionsKt.emptyList();
        }
        Class klass = ((Constructor)this.getMember()).getDeclaringClass();
        Type[] realTypes = klass.getDeclaringClass() != null && !Modifier.isStatic(klass.getModifiers()) ? ArraysKt.copyOfRange(types, 1, types.length) : types;
        Annotation[][] annotations = ((Constructor)this.getMember()).getParameterAnnotations();
        if (((Object[])annotations).length < realTypes.length) {
            throw new IllegalStateException("Illegal generic signature: " + this.getMember());
        }
        if (((Object[])annotations).length > realTypes.length) {
            Intrinsics.checkNotNull(annotations);
            annotationArray = (Annotation[][])ArraysKt.copyOfRange((Object[])annotations, ((Object[])annotations).length - realTypes.length, ((Object[])annotations).length);
        } else {
            annotationArray = annotations;
        }
        Annotation[][] realAnnotations = annotationArray;
        Intrinsics.checkNotNull(realTypes);
        Intrinsics.checkNotNull(realAnnotations);
        return this.getValueParameters(realTypes, realAnnotations, ((Constructor)this.getMember()).isVarArgs());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        void $this$mapTo$iv$iv;
        TypeVariable<Constructor<T>>[] typeVariableArray = ((Constructor)this.getMember()).getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeVariableArray, "getTypeParameters(...)");
        Object[] $this$map$iv = typeVariableArray;
        boolean $i$f$map = false;
        Object[] objectArray = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        for (void item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            TypeVariable typeVariable = (TypeVariable)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(new ReflectJavaTypeParameter((TypeVariable<?>)p0));
        }
        return (List)destination$iv$iv;
    }
}

