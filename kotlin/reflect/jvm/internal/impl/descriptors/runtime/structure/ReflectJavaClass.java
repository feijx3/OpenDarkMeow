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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwnerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClassifierType;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nReflectJavaClass.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaClass.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaClass\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,209:1\n183#2,2:210\n1#3:212\n1563#4:213\n1634#4,3:214\n11228#5:217\n11563#5,3:218\n11228#5:221\n11563#5,3:222\n11228#5:225\n11563#5,3:226\n*S KotlinDebug\n*F\n+ 1 ReflectJavaClass.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaClass\n*L\n51#1:210,2\n64#1:213\n64#1:214,3\n118#1:217\n118#1:218,3\n131#1:221\n131#1:222,3\n138#1:225\n138#1:226,3\n*E\n"})
public final class ReflectJavaClass
extends ReflectJavaElement
implements ReflectJavaAnnotationOwner,
ReflectJavaModifierListOwner,
JavaClass {
    @NotNull
    private final Class<?> klass;

    public ReflectJavaClass(@NotNull Class<?> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        this.klass = klass;
    }

    @Override
    @NotNull
    public Class<?> getElement() {
        return this.klass;
    }

    @Override
    public int getModifiers() {
        return this.klass.getModifiers();
    }

    @NotNull
    public List<Name> getInnerClassNames() {
        Class<?>[] classArray = this.klass.getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(classArray, "getDeclaredClasses(...)");
        return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filterNot(ArraysKt.asSequence((Object[])classArray), ReflectJavaClass$$Lambda$0.INSTANCE), ReflectJavaClass$$Lambda$1.INSTANCE));
    }

    @Override
    @NotNull
    public FqName getFqName() {
        return ReflectClassUtilKt.getClassId(this.klass).asSingleFqName();
    }

    @Override
    @Nullable
    public ReflectJavaClass getOuterClass() {
        ReflectJavaClass reflectJavaClass;
        Class<?> clazz = this.klass.getDeclaringClass();
        if (clazz != null) {
            Class<?> p0 = clazz;
            boolean bl2 = false;
            reflectJavaClass = new ReflectJavaClass(p0);
        } else {
            reflectJavaClass = null;
        }
        return reflectJavaClass;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Collection<JavaClassifierType> getSupertypes() {
        void $this$mapTo$iv$iv;
        if (Intrinsics.areEqual(this.klass, Object.class)) {
            return CollectionsKt.emptyList();
        }
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        Type type = this.klass.getGenericSuperclass();
        if (type == null) {
            type = (Type)((Object)Object.class);
        }
        spreadBuilder.add(type);
        spreadBuilder.addSpread(this.klass.getGenericInterfaces());
        Iterable $this$map$iv = CollectionsKt.listOf(spreadBuilder.toArray(new Type[spreadBuilder.size()]));
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            Type type2 = (Type)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(new ReflectJavaClassifierType((Type)p0));
        }
        return (List)destination$iv$iv;
    }

    @NotNull
    public List<ReflectJavaMethod> getMethods() {
        Method[] methodArray = this.klass.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(methodArray, "getDeclaredMethods(...)");
        ReflectJavaClass reflectJavaClass = this;
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filter(ArraysKt.asSequence((Object[])methodArray), new ReflectJavaClass$$Lambda$2(reflectJavaClass)), methods.2.INSTANCE));
    }

    private final boolean isEnumValuesOrValueOf(Method method) {
        boolean bl2;
        String string = method.getName();
        if (Intrinsics.areEqual(string, "values")) {
            Class<?>[] classArray = method.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(classArray, "getParameterTypes(...)");
            bl2 = ((Object[])classArray).length == 0;
        } else if (Intrinsics.areEqual(string, "valueOf")) {
            Object[] objectArray = new Class[]{String.class};
            bl2 = Arrays.equals(method.getParameterTypes(), objectArray);
        } else {
            bl2 = false;
        }
        return bl2;
    }

    @NotNull
    public List<ReflectJavaField> getFields() {
        Field[] fieldArray = this.klass.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(fieldArray, "getDeclaredFields(...)");
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(ArraysKt.asSequence((Object[])fieldArray), fields.1.INSTANCE), fields.2.INSTANCE));
    }

    @NotNull
    public List<ReflectJavaConstructor> getConstructors() {
        Constructor<?>[] constructorArray = this.klass.getDeclaredConstructors();
        Intrinsics.checkNotNullExpressionValue(constructorArray, "getDeclaredConstructors(...)");
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(ArraysKt.asSequence((Object[])constructorArray), constructors.1.INSTANCE), constructors.2.INSTANCE));
    }

    @Override
    public boolean hasDefaultConstructor() {
        return false;
    }

    @Override
    @Nullable
    public LightClassOriginKind getLightClassOriginKind() {
        return null;
    }

    @Override
    @NotNull
    public Name getName() {
        Name name;
        if (this.klass.isAnonymousClass()) {
            String string = this.klass.getName();
            Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
            Name name2 = Name.identifier(StringsKt.substringAfterLast$default(string, ".", null, 2, null));
            Intrinsics.checkNotNull(name2);
            name = name2;
        } else {
            Name name3 = Name.identifier(this.klass.getSimpleName());
            Intrinsics.checkNotNull(name3);
            name = name3;
        }
        return name;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        void $this$mapTo$iv$iv;
        TypeVariable<Class<?>>[] typeVariableArray = this.klass.getTypeParameters();
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
    public boolean isInterface() {
        return this.klass.isInterface();
    }

    @Override
    public boolean isAnnotationType() {
        return this.klass.isAnnotation();
    }

    @Override
    public boolean isEnum() {
        return this.klass.isEnum();
    }

    @Override
    public boolean isRecord() {
        Boolean bl2 = Java16SealedRecordLoader.INSTANCE.loadIsRecord(this.klass);
        return bl2 != null ? bl2 : false;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Collection<JavaRecordComponent> getRecordComponents() {
        void $this$mapTo$iv$iv;
        Object[] objectArray = Java16SealedRecordLoader.INSTANCE.loadGetRecordComponents(this.klass);
        if (objectArray == null) {
            objectArray = new Object[]{};
        }
        Object[] $this$map$iv = objectArray;
        boolean $i$f$map = false;
        Object[] objectArray2 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        int n2 = ((void)$this$mapTo$iv$iv).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void p0;
            void item$iv$iv;
            void var9_9 = item$iv$iv = $this$mapTo$iv$iv[i2];
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(new ReflectJavaRecordComponent(p0));
        }
        return (List)destination$iv$iv;
    }

    @Override
    public boolean isSealed() {
        Boolean bl2 = Java16SealedRecordLoader.INSTANCE.loadIsSealed(this.klass);
        return bl2 != null ? bl2 : false;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof ReflectJavaClass && Intrinsics.areEqual(this.klass, ((ReflectJavaClass)other).klass);
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    @NotNull
    public String toString() {
        return this.getClass().getName() + ": " + this.klass;
    }

    private static final boolean _get_innerClassNames_$lambda$0(Class it) {
        String string = it.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(string, "getSimpleName(...)");
        return ((CharSequence)string).length() == 0;
    }

    private static final Name _get_innerClassNames_$lambda$2(Class it) {
        Name name;
        String string;
        String p0 = string = it.getSimpleName();
        boolean bl2 = false;
        String string2 = Name.isValidIdentifier(p0) ? string : null;
        if (string2 != null) {
            p0 = string2;
            boolean bl3 = false;
            name = Name.identifier(p0);
        } else {
            name = null;
        }
        return name;
    }

    private static final boolean _get_methods_$lambda$7(ReflectJavaClass this$0, Method method) {
        boolean bl2;
        if (method.isSynthetic()) {
            bl2 = false;
        } else if (this$0.isEnum()) {
            Intrinsics.checkNotNull(method);
            bl2 = !this$0.isEnumValuesOrValueOf(method);
        } else {
            bl2 = true;
        }
        return bl2;
    }

    static /* synthetic */ boolean accessor$ReflectJavaClass$lambda0(Class clazz) {
        return ReflectJavaClass._get_innerClassNames_$lambda$0(clazz);
    }

    static /* synthetic */ Name accessor$ReflectJavaClass$lambda1(Class clazz) {
        return ReflectJavaClass._get_innerClassNames_$lambda$2(clazz);
    }

    static /* synthetic */ boolean accessor$ReflectJavaClass$lambda2(ReflectJavaClass reflectJavaClass, Method method) {
        return ReflectJavaClass._get_methods_$lambda$7(reflectJavaClass, method);
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

