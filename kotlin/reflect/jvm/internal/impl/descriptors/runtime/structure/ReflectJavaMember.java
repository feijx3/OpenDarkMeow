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
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwnerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaValueParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nReflectJavaMember.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaMember.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaMember\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,105:1\n1#2:106\n*E\n"})
public abstract class ReflectJavaMember
extends ReflectJavaElement
implements ReflectJavaAnnotationOwner,
ReflectJavaModifierListOwner,
JavaMember {
    @NotNull
    public abstract Member getMember();

    @Override
    @NotNull
    public AnnotatedElement getElement() {
        Member member = this.getMember();
        Intrinsics.checkNotNull(member, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement)((Object)member);
    }

    @Override
    public int getModifiers() {
        return this.getMember().getModifiers();
    }

    @Override
    @NotNull
    public Name getName() {
        Object object;
        block3: {
            block2: {
                object = this.getMember().getName();
                if (object == null) break block2;
                String it = object;
                boolean bl2 = false;
                Name name = Name.identifier(it);
                object = name;
                if (name != null) break block3;
            }
            object = SpecialNames.NO_NAME_PROVIDED;
        }
        return object;
    }

    @Override
    @NotNull
    public ReflectJavaClass getContainingClass() {
        Class<?> clazz = this.getMember().getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(clazz, "getDeclaringClass(...)");
        return new ReflectJavaClass(clazz);
    }

    @NotNull
    protected final List<JavaValueParameter> getValueParameters(@NotNull Type[] parameterTypes, @NotNull Annotation[][] parameterAnnotations, boolean isVararg) {
        List<String> names;
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        Intrinsics.checkNotNullParameter(parameterAnnotations, "parameterAnnotations");
        ArrayList<ReflectJavaValueParameter> result = new ArrayList<ReflectJavaValueParameter>(parameterTypes.length);
        List<String> list = names = Java8ParameterNamesLoader.INSTANCE.loadParameterNames(this.getMember());
        int shift = list != null ? list.size() - parameterTypes.length : 0;
        int n2 = parameterTypes.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string;
            ReflectJavaType type = ReflectJavaType.Factory.create(parameterTypes[i2]);
            if (names != null) {
                List<String> $this$getValueParameters_u24lambda_u241;
                boolean bl2 = false;
                string = CollectionsKt.getOrNull($this$getValueParameters_u24lambda_u241, i2 + shift);
                if (string == null) {
                    throw new IllegalStateException(("No parameter with index " + i2 + '+' + shift + " (name=" + this.getName() + " type=" + type + ") in " + this).toString());
                }
            } else {
                string = null;
            }
            String name = string;
            boolean isParamVararg = isVararg && i2 == ArraysKt.getLastIndex(parameterTypes);
            result.add(new ReflectJavaValueParameter(type, parameterAnnotations[i2], name, isParamVararg));
        }
        return result;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof ReflectJavaMember && Intrinsics.areEqual(this.getMember(), ((ReflectJavaMember)other).getMember());
    }

    public int hashCode() {
        return this.getMember().hashCode();
    }

    @NotNull
    public String toString() {
        return this.getClass().getName() + ": " + this.getMember();
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

    @Override
    public boolean isAbstract() {
        return Modifier.isAbstract(this.getModifiers());
    }

    @Override
    public boolean isStatic() {
        return Modifier.isStatic(this.getModifiers());
    }

    @Override
    public boolean isFinal() {
        return Modifier.isFinal(this.getModifiers());
    }

    @Override
    @NotNull
    public Visibility getVisibility() {
        int modifiers = this.getModifiers();
        boolean bl2 = false;
        return Modifier.isPublic(modifiers) ? (Visibility)Visibilities.Public.INSTANCE : (Modifier.isPrivate(modifiers) ? (Visibility)Visibilities.Private.INSTANCE : (Modifier.isProtected(modifiers) ? (Modifier.isStatic(modifiers) ? (Visibility)JavaVisibilities.ProtectedStaticVisibility.INSTANCE : (Visibility)JavaVisibilities.ProtectedAndPackage.INSTANCE) : (Visibility)JavaVisibilities.PackageVisibility.INSTANCE));
    }
}

