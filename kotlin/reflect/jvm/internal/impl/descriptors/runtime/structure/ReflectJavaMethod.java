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
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nReflectJavaMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaMethod.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaMethod\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,37:1\n1#2:38\n11228#3:39\n11563#3,3:40\n*S KotlinDebug\n*F\n+ 1 ReflectJavaMethod.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaMethod\n*L\n35#1:39\n35#1:40,3\n*E\n"})
public final class ReflectJavaMethod
extends ReflectJavaMember
implements JavaMethod {
    @NotNull
    private final Method member;

    public ReflectJavaMethod(@NotNull Method member) {
        Intrinsics.checkNotNullParameter(member, "member");
        this.member = member;
    }

    @Override
    @NotNull
    public Method getMember() {
        return this.member;
    }

    @Override
    @NotNull
    public List<JavaValueParameter> getValueParameters() {
        Type[] typeArray = this.getMember().getGenericParameterTypes();
        Intrinsics.checkNotNullExpressionValue(typeArray, "getGenericParameterTypes(...)");
        Annotation[][] annotationArray = this.getMember().getParameterAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotationArray, "getParameterAnnotations(...)");
        return this.getValueParameters(typeArray, annotationArray, this.getMember().isVarArgs());
    }

    @Override
    @NotNull
    public ReflectJavaType getReturnType() {
        Type type = this.getMember().getGenericReturnType();
        Intrinsics.checkNotNullExpressionValue(type, "getGenericReturnType(...)");
        return ReflectJavaType.Factory.create(type);
    }

    @Override
    @Nullable
    public JavaAnnotationArgument getAnnotationParameterDefaultValue() {
        ReflectJavaAnnotationArgument reflectJavaAnnotationArgument;
        Object object = this.getMember().getDefaultValue();
        if (object != null) {
            Object it = object;
            boolean bl2 = false;
            reflectJavaAnnotationArgument = ReflectJavaAnnotationArgument.Factory.create(it, null);
        } else {
            reflectJavaAnnotationArgument = null;
        }
        return reflectJavaAnnotationArgument;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        void $this$mapTo$iv$iv;
        TypeVariable<Method>[] typeVariableArray = this.getMember().getTypeParameters();
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

    @Override
    public boolean getHasAnnotationParameterDefaultValue() {
        return this.getAnnotationParameterDefaultValue() != null;
    }
}

