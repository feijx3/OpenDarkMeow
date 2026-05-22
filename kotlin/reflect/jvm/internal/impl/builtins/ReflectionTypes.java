/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nReflectionTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectionTypes.kt\norg/jetbrains/kotlin/builtins/ReflectionTypes\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,225:1\n1563#2:226\n1634#2,3:227\n*S KotlinDebug\n*F\n+ 1 ReflectionTypes.kt\norg/jetbrains/kotlin/builtins/ReflectionTypes\n*L\n94#1:226\n94#1:227,3\n*E\n"})
public final class ReflectionTypes {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final NotFoundClasses notFoundClasses;
    @NotNull
    private final Lazy kotlinReflectScope$delegate;
    @NotNull
    private final ClassLookup kClass$delegate;
    @NotNull
    private final ClassLookup kProperty$delegate;
    @NotNull
    private final ClassLookup kProperty0$delegate;
    @NotNull
    private final ClassLookup kProperty1$delegate;
    @NotNull
    private final ClassLookup kProperty2$delegate;
    @NotNull
    private final ClassLookup kMutableProperty0$delegate;
    @NotNull
    private final ClassLookup kMutableProperty1$delegate;
    @NotNull
    private final ClassLookup kMutableProperty2$delegate;

    public ReflectionTypes(@NotNull ModuleDescriptor module, @NotNull NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        this.notFoundClasses = notFoundClasses;
        ModuleDescriptor moduleDescriptor = module;
        this.kotlinReflectScope$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ReflectionTypes$$Lambda$0(moduleDescriptor));
        this.kClass$delegate = new ClassLookup(1);
        this.kProperty$delegate = new ClassLookup(1);
        this.kProperty0$delegate = new ClassLookup(1);
        this.kProperty1$delegate = new ClassLookup(2);
        this.kProperty2$delegate = new ClassLookup(3);
        this.kMutableProperty0$delegate = new ClassLookup(1);
        this.kMutableProperty1$delegate = new ClassLookup(2);
        this.kMutableProperty2$delegate = new ClassLookup(3);
    }

    private final MemberScope getKotlinReflectScope() {
        Lazy lazy = this.kotlinReflectScope$delegate;
        return (MemberScope)lazy.getValue();
    }

    private final ClassDescriptor find(String className, int numberOfTypeParameters) {
        Name name = Name.identifier(className);
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        Name name2 = name;
        ClassifierDescriptor classifierDescriptor = this.getKotlinReflectScope().getContributedClassifier(name2, NoLookupLocation.FROM_REFLECTION);
        ClassDescriptor classDescriptor = classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
        if (classDescriptor == null) {
            classDescriptor = this.notFoundClasses.getClass(new ClassId(StandardNames.KOTLIN_REFLECT_FQ_NAME, name2), CollectionsKt.listOf(numberOfTypeParameters));
        }
        return classDescriptor;
    }

    @NotNull
    public final ClassDescriptor getKClass() {
        return this.kClass$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private static final MemberScope kotlinReflectScope_delegate$lambda$0(ModuleDescriptor $module) {
        return $module.getPackage(StandardNames.KOTLIN_REFLECT_FQ_NAME).getMemberScope();
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ReflectionTypes.class, "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), Reflection.property1(new PropertyReference1Impl(ReflectionTypes.class, "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), Reflection.property1(new PropertyReference1Impl(ReflectionTypes.class, "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), Reflection.property1(new PropertyReference1Impl(ReflectionTypes.class, "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), Reflection.property1(new PropertyReference1Impl(ReflectionTypes.class, "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), Reflection.property1(new PropertyReference1Impl(ReflectionTypes.class, "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), Reflection.property1(new PropertyReference1Impl(ReflectionTypes.class, "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), Reflection.property1(new PropertyReference1Impl(ReflectionTypes.class, "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
    }

    static /* synthetic */ MemberScope accessor$ReflectionTypes$lambda0(ModuleDescriptor moduleDescriptor) {
        return ReflectionTypes.kotlinReflectScope_delegate$lambda$0(moduleDescriptor);
    }

    private static final class ClassLookup {
        private final int numberOfTypeParameters;

        public ClassLookup(int numberOfTypeParameters) {
            this.numberOfTypeParameters = numberOfTypeParameters;
        }

        @NotNull
        public final ClassDescriptor getValue(@NotNull ReflectionTypes types, @NotNull KProperty<?> property) {
            Intrinsics.checkNotNullParameter(types, "types");
            Intrinsics.checkNotNullParameter(property, "property");
            return types.find(CapitalizeDecapitalizeKt.capitalizeAsciiOnly(property.getName()), this.numberOfTypeParameters);
        }
    }

    @SourceDebugExtension(value={"SMAP\nReflectionTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectionTypes.kt\norg/jetbrains/kotlin/builtins/ReflectionTypes$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,225:1\n1761#2,3:226\n*S KotlinDebug\n*F\n+ 1 ReflectionTypes.kt\norg/jetbrains/kotlin/builtins/ReflectionTypes$Companion\n*L\n122#1:226,3\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final KotlinType createKPropertyStarType(@NotNull ModuleDescriptor module) {
            Intrinsics.checkNotNullParameter(module, "module");
            ClassDescriptor classDescriptor = FindClassInModuleKt.findClassAcrossModuleDependencies(module, StandardNames.FqNames.kProperty);
            if (classDescriptor == null) {
                return null;
            }
            ClassDescriptor kPropertyClass = classDescriptor;
            TypeAttributes typeAttributes = TypeAttributes.Companion.getEmpty();
            List<TypeParameterDescriptor> list = kPropertyClass.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
            TypeParameterDescriptor typeParameterDescriptor = CollectionsKt.single(list);
            Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "single(...)");
            return KotlinTypeFactory.simpleNotNullType(typeAttributes, kPropertyClass, CollectionsKt.listOf(new StarProjectionImpl(typeParameterDescriptor)));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

