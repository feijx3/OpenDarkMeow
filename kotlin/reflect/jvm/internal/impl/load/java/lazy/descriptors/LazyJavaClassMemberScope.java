/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.PropertiesConventionUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaForKotlinOverridePropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$4;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$5;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$6;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$7;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$8;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$9;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nLazyJavaClassMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaClassMemberScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassMemberScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 collections.kt\norg/jetbrains/kotlin/utils/CollectionsKt\n*L\n1#1,890:1\n1460#2,5:891\n1761#2,2:896\n1761#2,3:898\n1763#2:901\n1617#2,9:902\n1869#2:911\n1870#2:913\n1626#2:914\n1761#2,3:915\n1563#2:918\n1634#2,3:919\n827#2:922\n855#2,2:923\n774#2:925\n865#2,2:926\n1761#2,3:928\n1761#2,3:931\n2746#2,3:935\n774#2:938\n865#2,2:939\n774#2:941\n865#2,2:942\n1563#2:944\n1634#2,3:945\n2746#2,3:948\n295#2,2:951\n1563#2:953\n1634#2,3:954\n1460#2,5:957\n2746#2,3:962\n1374#2:965\n1460#2,2:966\n1563#2:968\n1634#2,3:969\n1462#2,3:972\n1563#2:975\n1634#2,3:976\n3301#2,10:979\n1460#2,5:989\n2746#2,3:994\n774#2:998\n865#2,2:999\n1208#2,2:1001\n1236#2,4:1003\n1#3:912\n1#3:934\n58#4:997\n*S KotlinDebug\n*F\n+ 1 LazyJavaClassMemberScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassMemberScope\n*L\n74#1:891,5\n160#1:896,2\n161#1:898,3\n160#1:901\n189#1:902,9\n189#1:911\n189#1:913\n189#1:914\n193#1:915,3\n199#1:918\n199#1:919,3\n202#1:922\n202#1:923,2\n211#1:925\n211#1:926,2\n216#1:928,3\n222#1:931,3\n322#1:935,3\n327#1:938\n327#1:939,2\n354#1:941\n354#1:942,2\n376#1:944\n376#1:945,3\n461#1:948,3\n470#1:951,2\n476#1:953\n476#1:954,3\n489#1:957,5\n495#1:962,3\n649#1:965\n649#1:966,2\n650#1:968\n650#1:969,3\n649#1:972,3\n698#1:975\n698#1:976,3\n749#1:979,10\n879#1:989,5\n95#1:994,3\n811#1:998\n811#1:999,2\n811#1:1001,2\n811#1:1003,4\n189#1:912\n105#1:997\n*E\n"})
public final class LazyJavaClassMemberScope
extends LazyJavaScope {
    @NotNull
    private final ClassDescriptor ownerDescriptor;
    @NotNull
    private final JavaClass jClass;
    private final boolean skipRefinement;
    @NotNull
    private final NotNullLazyValue<List<ClassConstructorDescriptor>> constructors;
    @NotNull
    private final NotNullLazyValue<Set<Name>> nestedClassIndex;
    @NotNull
    private final NotNullLazyValue<Set<Name>> generatedNestedClassNames;
    @NotNull
    private final NotNullLazyValue<Map<Name, JavaField>> enumEntryIndex;
    @NotNull
    private final MemoizedFunctionToNullable<Name, ClassDescriptor> nestedClasses;

    public LazyJavaClassMemberScope(@NotNull LazyJavaResolverContext c2, @NotNull ClassDescriptor ownerDescriptor, @NotNull JavaClass jClass, boolean skipRefinement, @Nullable LazyJavaClassMemberScope mainScope) {
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(ownerDescriptor, "ownerDescriptor");
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        super(c2, mainScope);
        this.ownerDescriptor = ownerDescriptor;
        this.jClass = jClass;
        this.skipRefinement = skipRefinement;
        Object object = c2;
        Object object2 = this;
        this.constructors = c2.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$$Lambda$0((LazyJavaClassMemberScope)object2, (LazyJavaResolverContext)object));
        object = this;
        this.nestedClassIndex = c2.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$$Lambda$1((LazyJavaClassMemberScope)object));
        object = this;
        object2 = c2;
        this.generatedNestedClassNames = c2.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$$Lambda$2((LazyJavaResolverContext)object2, (LazyJavaClassMemberScope)object));
        object = this;
        this.enumEntryIndex = c2.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$$Lambda$3((LazyJavaClassMemberScope)object));
        object = c2;
        object2 = this;
        this.nestedClasses = c2.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaClassMemberScope$$Lambda$4((LazyJavaClassMemberScope)object2, (LazyJavaResolverContext)object));
    }

    public /* synthetic */ LazyJavaClassMemberScope(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, JavaClass javaClass, boolean bl2, LazyJavaClassMemberScope lazyJavaClassMemberScope, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 0x10) != 0) {
            lazyJavaClassMemberScope = null;
        }
        this(lazyJavaResolverContext, classDescriptor, javaClass, bl2, lazyJavaClassMemberScope);
    }

    @Override
    @NotNull
    protected ClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    @Override
    @NotNull
    protected ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, LazyJavaClassMemberScope$$Lambda$5.INSTANCE);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    protected LinkedHashSet<Name> computeFunctionNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        void destination$iv;
        void $this$flatMapTo$iv;
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Collection<KotlinType> collection = this.getOwnerDescriptor().getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(collection, "getSupertypes(...)");
        Iterable iterable = collection;
        Collection collection2 = new LinkedHashSet();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv : $this$flatMapTo$iv) {
            KotlinType it = (KotlinType)element$iv;
            boolean bl2 = false;
            Iterable list$iv = it.getMemberScope().getFunctionNames();
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        iterable = destination$iv;
        LinkedHashSet $this$computeFunctionNames_u24lambda_u242 = (LinkedHashSet)iterable;
        boolean bl3 = false;
        $this$computeFunctionNames_u24lambda_u242.addAll((Collection)((DeclaredMemberIndex)this.getDeclaredMemberIndex().invoke()).getMethodNames());
        $this$computeFunctionNames_u24lambda_u242.addAll((Collection)((DeclaredMemberIndex)this.getDeclaredMemberIndex().invoke()).getRecordComponentNames());
        $this$computeFunctionNames_u24lambda_u242.addAll((Collection)this.computeClassNames(kindFilter, nameFilter));
        $this$computeFunctionNames_u24lambda_u242.addAll((Collection)this.getC().getComponents().getSyntheticPartsProvider().getMethodNames(this.getOwnerDescriptor(), this.getC()));
        return (LinkedHashSet)iterable;
    }

    @NotNull
    public final NotNullLazyValue<List<ClassConstructorDescriptor>> getConstructors$descriptors_jvm() {
        return this.constructors;
    }

    private final ClassConstructorDescriptor createDefaultRecordConstructor() {
        ClassDescriptor classDescriptor = this.getOwnerDescriptor();
        JavaClassConstructorDescriptor javaClassConstructorDescriptor = JavaClassConstructorDescriptor.createJavaConstructor(classDescriptor, Annotations.Companion.getEMPTY(), true, this.getC().getComponents().getSourceElementFactory().source(this.jClass));
        Intrinsics.checkNotNullExpressionValue(javaClassConstructorDescriptor, "createJavaConstructor(...)");
        JavaClassConstructorDescriptor constructorDescriptor = javaClassConstructorDescriptor;
        List<ValueParameterDescriptor> valueParameters = this.createRecordConstructorParameters(constructorDescriptor);
        constructorDescriptor.setHasSynthesizedParameterNames(false);
        constructorDescriptor.initialize(valueParameters, this.getConstructorVisibility(classDescriptor));
        constructorDescriptor.setHasStableParameterNames(false);
        constructorDescriptor.setReturnType(classDescriptor.getDefaultType());
        return constructorDescriptor;
    }

    private final List<ValueParameterDescriptor> createRecordConstructorParameters(ClassConstructorDescriptorImpl constructor) {
        Collection<JavaRecordComponent> components = this.jClass.getRecordComponents();
        ArrayList<ValueParameterDescriptorImpl> result = new ArrayList<ValueParameterDescriptorImpl>(components.size());
        JavaTypeAttributes attr = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 6, null);
        Iterator iterator2 = ((Iterable)components).iterator();
        int n2 = 0;
        while (iterator2.hasNext()) {
            int index = n2++;
            JavaRecordComponent component = (JavaRecordComponent)iterator2.next();
            KotlinType parameterType = this.getC().getTypeResolver().transformJavaType(component.getType(), attr);
            KotlinType varargElementType = component.isVararg() ? this.getC().getComponents().getModule().getBuiltIns().getArrayElementType(parameterType) : null;
            result.add(new ValueParameterDescriptorImpl(constructor, null, index, Annotations.Companion.getEMPTY(), component.getName(), parameterType, false, false, false, varargElementType, this.getC().getComponents().getSourceElementFactory().source(component)));
        }
        return result;
    }

    @Override
    protected boolean isVisibleAsFunction(@NotNull JavaMethodDescriptor $this$isVisibleAsFunction) {
        Intrinsics.checkNotNullParameter($this$isVisibleAsFunction, "<this>");
        if (this.jClass.isAnnotationType()) {
            return false;
        }
        return this.isVisibleAsFunctionInCurrentClass($this$isVisibleAsFunction);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean isVisibleAsFunctionInCurrentClass(SimpleFunctionDescriptor function) {
        boolean bl2;
        Name name = function.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Iterable $this$any$iv = PropertiesConventionUtilKt.getPropertyNamesCandidatesByAccessorName(name);
        boolean $i$f$any = false;
        if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
            bl2 = false;
        } else {
            for (Object element$iv : $this$any$iv) {
                boolean bl3;
                Name propertyName = (Name)element$iv;
                boolean bl4 = false;
                Iterable $this$any$iv2 = this.getPropertiesFromSupertypes(propertyName);
                boolean $i$f$any2 = false;
                if ($this$any$iv2 instanceof Collection && ((Collection)$this$any$iv2).isEmpty()) {
                    bl3 = false;
                } else {
                    for (Object element$iv2 : $this$any$iv2) {
                        PropertyDescriptor property = (PropertyDescriptor)element$iv2;
                        boolean bl5 = false;
                        SimpleFunctionDescriptor simpleFunctionDescriptor = function;
                        LazyJavaClassMemberScope lazyJavaClassMemberScope = this;
                        if (this.doesClassOverridesProperty(property, new LazyJavaClassMemberScope$$Lambda$6(simpleFunctionDescriptor, lazyJavaClassMemberScope))) {
                            if (property.isVar()) return false;
                            String string = function.getName().asString();
                            Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
                            if (!JvmAbi.isSetterName(string)) {
                                return false;
                            }
                        }
                        boolean bl6 = false;
                        if (!bl6) continue;
                        return false;
                    }
                    bl3 = false;
                }
                if (!bl3) continue;
                return false;
            }
            bl2 = false;
        }
        if (bl2) {
            return false;
        }
        if (this.doesOverrideRenamedBuiltins(function)) return false;
        if (this.shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(function)) return false;
        if (this.doesOverrideSuspendFunction(function)) return false;
        return true;
    }

    /*
     * WARNING - void declaration
     */
    private final boolean shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(SimpleFunctionDescriptor $this$shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters) {
        boolean bl2;
        block5: {
            void $this$mapNotNullTo$iv$iv;
            Name name = $this$shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (!BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
                return false;
            }
            Name name2 = $this$shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            Iterable $this$mapNotNull$iv = this.getFunctionsFromSupertypes(name2);
            boolean $i$f$mapNotNull = false;
            Iterable iterable = $this$mapNotNull$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$mapNotNullTo = false;
            void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
            while (iterator2.hasNext()) {
                FunctionDescriptor it$iv$iv;
                Object element$iv$iv$iv;
                Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                boolean bl3 = false;
                SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv$iv;
                boolean bl4 = false;
                if (BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(it) == null) continue;
                boolean bl5 = false;
                destination$iv$iv.add(it$iv$iv);
            }
            List candidatesToOverride = (List)destination$iv$iv;
            Iterable $this$any$iv = candidatesToOverride;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    FunctionDescriptor candidate = (FunctionDescriptor)element$iv;
                    boolean bl6 = false;
                    if (!this.hasSameJvmDescriptorButDoesNotOverride($this$shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters, candidate)) continue;
                    bl2 = true;
                    break block5;
                }
                bl2 = false;
            }
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    private final Collection<SimpleFunctionDescriptor> searchMethodsByNameWithoutBuiltinMagic(Name name) {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = ((DeclaredMemberIndex)this.getDeclaredMemberIndex().invoke()).findMethodsByName(name);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            JavaMethod javaMethod = (JavaMethod)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(this.resolveMethodToFunctionDescriptor((JavaMethod)it));
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    private final Collection<SimpleFunctionDescriptor> searchMethodsInSupertypesWithoutBuiltinMagic(Name name) {
        void $this$filterNotTo$iv$iv;
        Iterable $this$filterNot$iv = this.getFunctionsFromSupertypes(name);
        boolean $i$f$filterNot = false;
        Iterable iterable = $this$filterNot$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterNotTo = false;
        for (Object element$iv$iv : $this$filterNotTo$iv$iv) {
            SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv$iv;
            boolean bl2 = false;
            if (SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(it) || BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(it) != null) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    private final boolean doesOverrideRenamedBuiltins(SimpleFunctionDescriptor $this$doesOverrideRenamedBuiltins) {
        boolean bl2;
        block6: {
            void $this$filterTo$iv$iv;
            Name name = $this$doesOverrideRenamedBuiltins.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            Name name2 = SpecialGenericSignatures.Companion.getBuiltinFunctionNamesByJvmName(name);
            if (name2 == null) {
                return false;
            }
            Name builtinName = name2;
            Iterable $this$filter$iv = this.getFunctionsFromSupertypes(builtinName);
            boolean $i$f$filter = false;
            Iterable iterable = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv$iv;
                boolean bl3 = false;
                if (!SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(it)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            List builtinSpecialFromSuperTypes = (List)destination$iv$iv;
            if (builtinSpecialFromSuperTypes.isEmpty()) {
                return false;
            }
            SimpleFunctionDescriptor methodDescriptor = this.createRenamedCopy($this$doesOverrideRenamedBuiltins, builtinName);
            Iterable $this$any$iv = builtinSpecialFromSuperTypes;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv;
                    boolean bl4 = false;
                    if (!this.doesOverrideRenamedDescriptor(it, methodDescriptor)) continue;
                    bl2 = true;
                    break block6;
                }
                bl2 = false;
            }
        }
        return bl2;
    }

    private final boolean doesOverrideSuspendFunction(SimpleFunctionDescriptor $this$doesOverrideSuspendFunction) {
        boolean bl2;
        block4: {
            SimpleFunctionDescriptor simpleFunctionDescriptor = this.createSuspendView($this$doesOverrideSuspendFunction);
            if (simpleFunctionDescriptor == null) {
                return false;
            }
            SimpleFunctionDescriptor suspendView = simpleFunctionDescriptor;
            Name name = $this$doesOverrideSuspendFunction.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            Iterable $this$any$iv = this.getFunctionsFromSupertypes(name);
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    SimpleFunctionDescriptor overriddenCandidate = (SimpleFunctionDescriptor)element$iv;
                    boolean bl3 = false;
                    if (!(overriddenCandidate.isSuspend() && this.doesOverride(suspendView, overriddenCandidate))) continue;
                    bl2 = true;
                    break block4;
                }
                bl2 = false;
            }
        }
        return bl2;
    }

    /*
     * Unable to fully structure code
     */
    private final SimpleFunctionDescriptor createSuspendView(SimpleFunctionDescriptor $this$createSuspendView) {
        block7: {
            block6: {
                block5: {
                    v0 = $this$createSuspendView.getValueParameters();
                    Intrinsics.checkNotNullExpressionValue(v0, "getValueParameters(...)");
                    v1 = CollectionsKt.lastOrNull(v0);
                    if (v1 == null) break block5;
                    it = var4_2 = v1;
                    $i$a$-takeIf-LazyJavaClassMemberScope$createSuspendView$continuationParameter$1 = false;
                    var7_5 = it.getType().getConstructor().getDeclarationDescriptor();
                    if (var7_5 == null || (var8_6 = DescriptorUtilsKt.getFqNameUnsafe(var7_5)) == null) ** GOTO lbl-1000
                    p0 = var9_7 = var8_6;
                    $i$a$-takeIf-LazyJavaClassMemberScope$createSuspendView$continuationParameter$1$1 = false;
                    v2 = var12_10 = p0.isSafe() != false ? var9_7 : null;
                    if (var12_10 != null) {
                        v3 = var12_10.toSafe();
                    } else lbl-1000:
                    // 2 sources

                    {
                        v3 = null;
                    }
                    if ((v1 = Intrinsics.areEqual(v3, StandardNames.CONTINUATION_INTERFACE_FQ_NAME) != false ? var4_2 : null) != null) break block6;
                }
                return null;
            }
            continuationParameter = v1;
            v4 = $this$createSuspendView.newCopyBuilder();
            v5 = $this$createSuspendView.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(v5, "getValueParameters(...)");
            functionDescriptor = v4.setValueParameters(CollectionsKt.dropLast(v5, 1)).setReturnType(continuationParameter.getType().getArguments().get(0).getType()).build();
            v6 = (SimpleFunctionDescriptorImpl)functionDescriptor;
            if (v6 == null) break block7;
            v6.setSuspend(true);
        }
        return functionDescriptor;
    }

    private final SimpleFunctionDescriptor createRenamedCopy(SimpleFunctionDescriptor $this$createRenamedCopy, Name builtinName) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> copyBuilder;
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> $this$createRenamedCopy_u24lambda_u2417 = copyBuilder = $this$createRenamedCopy.newCopyBuilder();
        boolean bl2 = false;
        $this$createRenamedCopy_u24lambda_u2417.setName(builtinName);
        $this$createRenamedCopy_u24lambda_u2417.setSignatureChange();
        $this$createRenamedCopy_u24lambda_u2417.setPreserveSourceElement();
        SimpleFunctionDescriptor simpleFunctionDescriptor = copyBuilder.build();
        Intrinsics.checkNotNull(simpleFunctionDescriptor);
        return simpleFunctionDescriptor;
    }

    private final boolean doesOverrideRenamedDescriptor(SimpleFunctionDescriptor superDescriptor, FunctionDescriptor subDescriptor) {
        FunctionDescriptor functionDescriptor = BuiltinMethodsWithDifferentJvmName.INSTANCE.isRemoveAtByIndex(superDescriptor) ? subDescriptor.getOriginal() : subDescriptor;
        Intrinsics.checkNotNull(functionDescriptor);
        FunctionDescriptor subDescriptorToCheck = functionDescriptor;
        return this.doesOverride(subDescriptorToCheck, superDescriptor);
    }

    private final boolean doesOverride(CallableDescriptor $this$doesOverride, CallableDescriptor superDescriptor) {
        OverridingUtil.OverrideCompatibilityInfo.Result result = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(superDescriptor, $this$doesOverride, true).getResult();
        Intrinsics.checkNotNullExpressionValue((Object)result, "getResult(...)");
        OverridingUtil.OverrideCompatibilityInfo.Result commonOverridabilityResult = result;
        return commonOverridabilityResult == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE && !JavaIncompatibilityRulesOverridabilityCondition.Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(superDescriptor, $this$doesOverride);
    }

    private final SimpleFunctionDescriptor findGetterOverride(PropertyDescriptor $this$findGetterOverride, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions) {
        String specialGetterName;
        PropertyGetterDescriptor overriddenBuiltinProperty;
        PropertyGetterDescriptor propertyGetterDescriptor = $this$findGetterOverride.getGetter();
        PropertyGetterDescriptor propertyGetterDescriptor2 = overriddenBuiltinProperty = propertyGetterDescriptor != null ? (PropertyGetterDescriptor)SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName((CallableMemberDescriptor)propertyGetterDescriptor) : null;
        String string = specialGetterName = propertyGetterDescriptor2 != null ? ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(propertyGetterDescriptor2) : null;
        if (specialGetterName != null && !SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(this.getOwnerDescriptor(), overriddenBuiltinProperty)) {
            return this.findGetterByName($this$findGetterOverride, specialGetterName, functions);
        }
        String string2 = $this$findGetterOverride.getName().asString();
        Intrinsics.checkNotNullExpressionValue(string2, "asString(...)");
        return this.findGetterByName($this$findGetterOverride, JvmAbi.getterName(string2), functions);
    }

    private final SimpleFunctionDescriptor findGetterByName(PropertyDescriptor $this$findGetterByName, String getterName, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        block3: {
            Name name = Name.identifier(getterName);
            Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
            for (SimpleFunctionDescriptor descriptor2 : (Iterable)functions.invoke(name)) {
                SimpleFunctionDescriptor simpleFunctionDescriptor2;
                SimpleFunctionDescriptor simpleFunctionDescriptor3;
                boolean bl2 = false;
                if (descriptor2.getValueParameters().size() != 0) {
                    simpleFunctionDescriptor3 = null;
                } else {
                    boolean bl3;
                    SimpleFunctionDescriptor simpleFunctionDescriptor4;
                    SimpleFunctionDescriptor it = simpleFunctionDescriptor4 = descriptor2;
                    boolean bl4 = false;
                    KotlinType kotlinType = descriptor2.getReturnType();
                    simpleFunctionDescriptor3 = (kotlinType == null ? (bl3 = false) : KotlinTypeChecker.DEFAULT.isSubtypeOf(kotlinType, $this$findGetterByName.getType())) ? simpleFunctionDescriptor4 : null;
                }
                if ((simpleFunctionDescriptor2 = simpleFunctionDescriptor3) == null) continue;
                simpleFunctionDescriptor = simpleFunctionDescriptor2;
                break block3;
            }
            simpleFunctionDescriptor = null;
        }
        return simpleFunctionDescriptor;
    }

    private final SimpleFunctionDescriptor findSetterOverride(PropertyDescriptor $this$findSetterOverride, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        block7: {
            String string = $this$findSetterOverride.getName().asString();
            Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
            Name name = Name.identifier(JvmAbi.setterName(string));
            Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
            for (SimpleFunctionDescriptor descriptor2 : (Iterable)functions.invoke(name)) {
                SimpleFunctionDescriptor simpleFunctionDescriptor2;
                SimpleFunctionDescriptor simpleFunctionDescriptor3;
                boolean bl2 = false;
                if (descriptor2.getValueParameters().size() != 1) {
                    simpleFunctionDescriptor3 = null;
                } else {
                    KotlinType kotlinType = descriptor2.getReturnType();
                    if (kotlinType == null) {
                        simpleFunctionDescriptor3 = null;
                    } else if (!KotlinBuiltIns.isUnit(kotlinType)) {
                        simpleFunctionDescriptor3 = null;
                    } else {
                        SimpleFunctionDescriptor simpleFunctionDescriptor4;
                        SimpleFunctionDescriptor it = simpleFunctionDescriptor4 = descriptor2;
                        boolean bl3 = false;
                        List<ValueParameterDescriptor> list = descriptor2.getValueParameters();
                        Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
                        simpleFunctionDescriptor3 = KotlinTypeChecker.DEFAULT.equalTypes(CollectionsKt.single(list).getType(), $this$findSetterOverride.getType()) ? simpleFunctionDescriptor4 : null;
                    }
                }
                if ((simpleFunctionDescriptor2 = simpleFunctionDescriptor3) == null) continue;
                simpleFunctionDescriptor = simpleFunctionDescriptor2;
                break block7;
            }
            simpleFunctionDescriptor = null;
        }
        return simpleFunctionDescriptor;
    }

    private final boolean doesClassOverridesProperty(PropertyDescriptor property, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions) {
        if (JavaDescriptorUtilKt.isJavaField(property)) {
            return false;
        }
        SimpleFunctionDescriptor getter = this.findGetterOverride(property, functions);
        SimpleFunctionDescriptor setter = this.findSetterOverride(property, functions);
        if (getter == null) {
            return false;
        }
        if (!property.isVar()) {
            return true;
        }
        return setter != null && setter.getModality() == getter.getModality();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    protected void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> result, @NotNull Name name) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = this.getFunctionsFromSupertypes(name);
        if (!SpecialGenericSignatures.Companion.getSameAsRenamedInJvmBuiltin(name) && !BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            boolean bl2;
            Iterable $this$none$iv;
            block7: {
                $this$none$iv = functionsFromSupertypes;
                boolean $i$f$none = false;
                if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                    bl2 = true;
                } else {
                    for (Object element$iv : $this$none$iv) {
                        FunctionDescriptor p0 = (FunctionDescriptor)element$iv;
                        boolean bl3 = false;
                        if (!p0.isSuspend()) continue;
                        bl2 = false;
                        break block7;
                    }
                    bl2 = true;
                }
            }
            if (bl2) {
                void $this$filterTo$iv$iv2;
                void $this$filter$iv;
                $this$none$iv = functionsFromSupertypes;
                Name name2 = name;
                Collection<SimpleFunctionDescriptor> collection = result;
                LazyJavaClassMemberScope lazyJavaClassMemberScope = this;
                boolean $i$f$filter = false;
                Iterator iterator2 = $this$filter$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                for (Object element$iv$iv : $this$filterTo$iv$iv2) {
                    SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv$iv;
                    boolean bl4 = false;
                    if (!this.isVisibleAsFunctionInCurrentClass(it)) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                List list = (List)destination$iv$iv;
                lazyJavaClassMemberScope.addFunctionFromSupertypes(collection, name2, list, false);
                return;
            }
        }
        SmartSet specialBuiltinsFromSuperTypes = SmartSet.Companion.create();
        Collection collection = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, (Collection)functionsFromSupertypes, CollectionsKt.emptyList(), this.getOwnerDescriptor(), ErrorReporter.DO_NOTHING, this.getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(collection, "resolveOverridesForNonStaticMembers(...)");
        Collection mergedFunctionFromSuperTypes = collection;
        this.addOverriddenSpecialMethods(name, result, mergedFunctionFromSuperTypes, result, (Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>>)new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>((Object)this){

            public final Collection<SimpleFunctionDescriptor> invoke(Name p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                return LazyJavaClassMemberScope.access$searchMethodsByNameWithoutBuiltinMagic((LazyJavaClassMemberScope)this.receiver, p0);
            }
        });
        this.addOverriddenSpecialMethods(name, result, mergedFunctionFromSuperTypes, specialBuiltinsFromSuperTypes, (Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>>)new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>((Object)this){

            public final Collection<SimpleFunctionDescriptor> invoke(Name p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                return LazyJavaClassMemberScope.access$searchMethodsInSupertypesWithoutBuiltinMagic((LazyJavaClassMemberScope)this.receiver, p0);
            }
        });
        Iterable $this$filter$iv = functionsFromSupertypes;
        boolean $i$f$filter = false;
        Iterable bl3 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv$iv;
            boolean bl5 = false;
            if (!this.isVisibleAsFunctionInCurrentClass(it)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List visibleFunctionsFromSupertypes = CollectionsKt.plus((Collection)((List)destination$iv$iv), (Iterable)specialBuiltinsFromSuperTypes);
        this.addFunctionFromSupertypes(result, name, visibleFunctionsFromSupertypes, true);
    }

    /*
     * WARNING - void declaration
     */
    private final void addFunctionFromSupertypes(Collection<SimpleFunctionDescriptor> result, Name name, Collection<? extends SimpleFunctionDescriptor> functionsFromSupertypes, boolean isSpecialBuiltinName) {
        boolean bl2;
        Collection<SimpleFunctionDescriptor> collection = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, functionsFromSupertypes, result, this.getOwnerDescriptor(), this.getC().getComponents().getErrorReporter(), this.getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(collection, "resolveOverridesForNonStaticMembers(...)");
        Collection<SimpleFunctionDescriptor> additionalOverrides = collection;
        if (!isSpecialBuiltinName) {
            bl2 = result.addAll(additionalOverrides);
        } else {
            void $this$mapTo$iv$iv;
            void $this$map$iv;
            List<SimpleFunctionDescriptor> allDescriptors = CollectionsKt.plus(result, (Iterable)additionalOverrides);
            Iterable iterable = additionalOverrides;
            Collection<SimpleFunctionDescriptor> collection2 = result;
            boolean $i$f$map = false;
            void var9_10 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                SimpleFunctionDescriptor simpleFunctionDescriptor;
                void resolvedOverride;
                SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor)item$iv$iv;
                Collection collection3 = destination$iv$iv;
                boolean bl3 = false;
                if ((SimpleFunctionDescriptor)SpecialBuiltinMembers.getOverriddenSpecialBuiltin((CallableMemberDescriptor)resolvedOverride) == null) {
                    Intrinsics.checkNotNull(resolvedOverride);
                    simpleFunctionDescriptor = resolvedOverride;
                } else {
                    SimpleFunctionDescriptor overriddenBuiltin;
                    Intrinsics.checkNotNull(resolvedOverride);
                    simpleFunctionDescriptor = this.createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden((SimpleFunctionDescriptor)resolvedOverride, overriddenBuiltin, (Collection<? extends SimpleFunctionDescriptor>)allDescriptors);
                }
                collection3.add(simpleFunctionDescriptor);
            }
            bl2 = collection2.addAll((List)destination$iv$iv);
        }
    }

    private final void addOverriddenSpecialMethods(Name name, Collection<? extends SimpleFunctionDescriptor> alreadyDeclaredFunctions, Collection<? extends SimpleFunctionDescriptor> candidatesForOverride, Collection<SimpleFunctionDescriptor> result, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions) {
        for (SimpleFunctionDescriptor simpleFunctionDescriptor : candidatesForOverride) {
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(result, this.obtainOverrideForBuiltinWithDifferentJvmName(simpleFunctionDescriptor, functions, name, alreadyDeclaredFunctions));
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(result, this.obtainOverrideForBuiltInWithErasedValueParametersInJava(simpleFunctionDescriptor, functions, alreadyDeclaredFunctions));
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(result, this.obtainOverrideForSuspend(simpleFunctionDescriptor, functions));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final SimpleFunctionDescriptor obtainOverrideForBuiltInWithErasedValueParametersInJava(SimpleFunctionDescriptor descriptor2, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions, Collection<? extends SimpleFunctionDescriptor> alreadyDeclaredFunctions) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        FunctionDescriptor functionDescriptor = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(descriptor2);
        if (functionDescriptor == null) {
            return null;
        }
        FunctionDescriptor overriddenBuiltin = functionDescriptor;
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = this.createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(overriddenBuiltin, functions);
        if (simpleFunctionDescriptor2 == null) return null;
        SimpleFunctionDescriptor p0 = simpleFunctionDescriptor = simpleFunctionDescriptor2;
        boolean bl2 = false;
        if (!this.isVisibleAsFunctionInCurrentClass(p0)) return null;
        SimpleFunctionDescriptor simpleFunctionDescriptor3 = simpleFunctionDescriptor;
        SimpleFunctionDescriptor simpleFunctionDescriptor4 = simpleFunctionDescriptor3;
        if (simpleFunctionDescriptor4 == null) return null;
        SimpleFunctionDescriptor simpleFunctionDescriptor5 = this.createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(simpleFunctionDescriptor4, overriddenBuiltin, alreadyDeclaredFunctions);
        return simpleFunctionDescriptor5;
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltinWithDifferentJvmName(SimpleFunctionDescriptor descriptor2, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions, Name name, Collection<? extends SimpleFunctionDescriptor> alreadyDeclaredFunctions) {
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor)SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName((CallableMemberDescriptor)descriptor2);
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        SimpleFunctionDescriptor overriddenBuiltin = simpleFunctionDescriptor;
        String string = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(overriddenBuiltin);
        Intrinsics.checkNotNull(string);
        String nameInJava = string;
        Name name2 = Name.identifier(nameInJava);
        Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
        for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : functions.invoke(name2)) {
            SimpleFunctionDescriptor renamedCopy = this.createRenamedCopy(simpleFunctionDescriptor2, name);
            if (!this.doesOverrideRenamedDescriptor(overriddenBuiltin, renamedCopy)) continue;
            return this.createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(renamedCopy, overriddenBuiltin, alreadyDeclaredFunctions);
        }
        return null;
    }

    private final SimpleFunctionDescriptor obtainOverrideForSuspend(SimpleFunctionDescriptor descriptor2, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        block4: {
            if (!descriptor2.isSuspend()) {
                return null;
            }
            Name name = descriptor2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            for (SimpleFunctionDescriptor overrideCandidate : (Iterable)functions.invoke(name)) {
                SimpleFunctionDescriptor simpleFunctionDescriptor2;
                SimpleFunctionDescriptor simpleFunctionDescriptor3;
                boolean bl2 = false;
                if (this.createSuspendView(overrideCandidate) != null) {
                    SimpleFunctionDescriptor simpleFunctionDescriptor4;
                    SimpleFunctionDescriptor suspendView = simpleFunctionDescriptor4;
                    boolean bl3 = false;
                    simpleFunctionDescriptor3 = this.doesOverride(suspendView, descriptor2) ? simpleFunctionDescriptor4 : null;
                } else {
                    simpleFunctionDescriptor3 = null;
                }
                if ((simpleFunctionDescriptor2 = simpleFunctionDescriptor3) == null) continue;
                simpleFunctionDescriptor = simpleFunctionDescriptor2;
                break block4;
            }
            simpleFunctionDescriptor = null;
        }
        return simpleFunctionDescriptor;
    }

    private final SimpleFunctionDescriptor createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(SimpleFunctionDescriptor $this$createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden, CallableDescriptor specialBuiltin, Collection<? extends SimpleFunctionDescriptor> alreadyDeclaredFunctions) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        boolean bl2;
        block5: {
            Iterable $this$none$iv = alreadyDeclaredFunctions;
            boolean $i$f$none = false;
            if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                bl2 = true;
            } else {
                for (Object element$iv : $this$none$iv) {
                    SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv;
                    boolean bl3 = false;
                    if (!(!Intrinsics.areEqual($this$createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden, it) && it.getInitialSignatureDescriptor() == null && this.doesOverride(it, specialBuiltin))) continue;
                    bl2 = false;
                    break block5;
                }
                bl2 = true;
            }
        }
        if (bl2) {
            simpleFunctionDescriptor = $this$createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden;
        } else {
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = $this$createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
            Intrinsics.checkNotNull(simpleFunctionDescriptor2);
            simpleFunctionDescriptor = simpleFunctionDescriptor2;
        }
        return simpleFunctionDescriptor;
    }

    /*
     * WARNING - void declaration
     */
    private final SimpleFunctionDescriptor createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(FunctionDescriptor overridden, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        Object v1;
        block4: {
            Name name = overridden.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            Iterable $this$firstOrNull$iv = functions.invoke(name);
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv;
                boolean bl2 = false;
                if (!this.hasSameJvmDescriptorButDoesNotOverride(it, overridden)) continue;
                v1 = element$iv;
                break block4;
            }
            v1 = null;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = v1;
        if (simpleFunctionDescriptor2 != null) {
            void $this$mapTo$iv$iv;
            void $this$map$iv;
            FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> copyBuilder;
            SimpleFunctionDescriptor override = simpleFunctionDescriptor2;
            boolean bl3 = false;
            FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> $this$createOverrideForBuiltinFunctionWithErasedParameterIfNeeded_u24lambda_u2433_u24lambda_u2432 = copyBuilder = override.newCopyBuilder();
            boolean bl4 = false;
            List<ValueParameterDescriptor> list = overridden.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
            Iterable iterable = list;
            FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> copyBuilder2 = $this$createOverrideForBuiltinFunctionWithErasedParameterIfNeeded_u24lambda_u2433_u24lambda_u2432;
            boolean $i$f$map = false;
            void var13_15 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void p0;
                ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl5 = false;
                collection.add(p0.getType());
            }
            Collection collection = (List)destination$iv$iv;
            List<ValueParameterDescriptor> list2 = override.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(list2, "getValueParameters(...)");
            copyBuilder2.setValueParameters(UtilKt.copyValueParameters(collection, (Collection<? extends ValueParameterDescriptor>)list2, overridden));
            $this$createOverrideForBuiltinFunctionWithErasedParameterIfNeeded_u24lambda_u2433_u24lambda_u2432.setSignatureChange();
            $this$createOverrideForBuiltinFunctionWithErasedParameterIfNeeded_u24lambda_u2433_u24lambda_u2432.setPreserveSourceElement();
            $this$createOverrideForBuiltinFunctionWithErasedParameterIfNeeded_u24lambda_u2433_u24lambda_u2432.putUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS, true);
            simpleFunctionDescriptor = copyBuilder.build();
        } else {
            simpleFunctionDescriptor = null;
        }
        return simpleFunctionDescriptor;
    }

    /*
     * WARNING - void declaration
     */
    private final Set<SimpleFunctionDescriptor> getFunctionsFromSupertypes(Name name) {
        void var3_3;
        void $this$flatMapTo$iv;
        Iterable iterable = this.computeSupertypes();
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv : $this$flatMapTo$iv) {
            KotlinType it = (KotlinType)element$iv;
            boolean bl2 = false;
            Iterable list$iv = it.getMemberScope().getContributedFunctions(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        return (Set)var3_3;
    }

    @Override
    protected void computeImplicitlyDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> result, @NotNull Name name) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.jClass.isRecord() && ((DeclaredMemberIndex)this.getDeclaredMemberIndex().invoke()).findRecordComponentByName(name) != null) {
            boolean bl2;
            block5: {
                Iterable $this$none$iv = result;
                boolean $i$f$none = false;
                if (((Collection)$this$none$iv).isEmpty()) {
                    bl2 = true;
                } else {
                    for (Object element$iv : $this$none$iv) {
                        SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv;
                        boolean bl3 = false;
                        if (!it.getValueParameters().isEmpty()) continue;
                        bl2 = false;
                        break block5;
                    }
                    bl2 = true;
                }
            }
            if (bl2) {
                JavaRecordComponent javaRecordComponent = ((DeclaredMemberIndex)this.getDeclaredMemberIndex().invoke()).findRecordComponentByName(name);
                Intrinsics.checkNotNull(javaRecordComponent);
                result.add(this.resolveRecordComponentToFunctionDescriptor(javaRecordComponent));
            }
        }
        this.getC().getComponents().getSyntheticPartsProvider().generateMethods(this.getOwnerDescriptor(), name, result, this.getC());
    }

    private final JavaMethodDescriptor resolveRecordComponentToFunctionDescriptor(JavaRecordComponent recordComponent) {
        Annotations annotations = LazyJavaAnnotationsKt.resolveAnnotations(this.getC(), recordComponent);
        JavaMethodDescriptor javaMethodDescriptor = JavaMethodDescriptor.createJavaMethod(this.getOwnerDescriptor(), annotations, recordComponent.getName(), this.getC().getComponents().getSourceElementFactory().source(recordComponent), true);
        Intrinsics.checkNotNullExpressionValue(javaMethodDescriptor, "createJavaMethod(...)");
        JavaMethodDescriptor functionDescriptorImpl = javaMethodDescriptor;
        JavaTypeAttributes returnTypeAttrs = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 6, null);
        KotlinType returnType = this.getC().getTypeResolver().transformJavaType(recordComponent.getType(), returnTypeAttrs);
        functionDescriptorImpl.initialize(null, this.getDispatchReceiverParameter(), CollectionsKt.<ReceiverParameterDescriptor>emptyList(), CollectionsKt.emptyList(), CollectionsKt.<ValueParameterDescriptor>emptyList(), returnType, Modality.Companion.convertFromFlags(false, false, true), DescriptorVisibilities.PUBLIC, null);
        functionDescriptorImpl.setParameterNamesStatus(false, false);
        this.getC().getComponents().getJavaResolverCache().recordMethod(recordComponent, functionDescriptorImpl);
        return functionDescriptorImpl;
    }

    @Override
    protected void computeNonDeclaredProperties(@NotNull Name name, @NotNull Collection<PropertyDescriptor> result) {
        Set<PropertyDescriptor> propertiesFromSupertypes;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.jClass.isAnnotationType()) {
            this.computeAnnotationProperties(name, result);
        }
        if ((propertiesFromSupertypes = this.getPropertiesFromSupertypes(name)).isEmpty()) {
            return;
        }
        SmartSet handledProperties = SmartSet.Companion.create();
        SmartSet propertiesOverridesFromSuperTypes = SmartSet.Companion.create();
        LazyJavaClassMemberScope lazyJavaClassMemberScope = this;
        this.addPropertyOverrideByMethod(propertiesFromSupertypes, result, handledProperties, new LazyJavaClassMemberScope$$Lambda$7(lazyJavaClassMemberScope));
        lazyJavaClassMemberScope = this;
        this.addPropertyOverrideByMethod(SetsKt.minus(propertiesFromSupertypes, handledProperties), propertiesOverridesFromSuperTypes, null, new LazyJavaClassMemberScope$$Lambda$8(lazyJavaClassMemberScope));
        Collection<PropertyDescriptor> collection = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, (Collection)SetsKt.plus(propertiesFromSupertypes, propertiesOverridesFromSuperTypes), result, this.getOwnerDescriptor(), this.getC().getComponents().getErrorReporter(), this.getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(collection, "resolveOverridesForNonStaticMembers(...)");
        result.addAll(collection);
    }

    private final void addPropertyOverrideByMethod(Set<? extends PropertyDescriptor> propertiesFromSupertypes, Collection<PropertyDescriptor> result, Set<PropertyDescriptor> handledProperties, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions) {
        for (PropertyDescriptor propertyDescriptor : propertiesFromSupertypes) {
            JavaPropertyDescriptor newProperty = this.createPropertyDescriptorByMethods(propertyDescriptor, functions);
            if (newProperty == null) continue;
            result.add(newProperty);
            Set<PropertyDescriptor> set = handledProperties;
            if (set == null) break;
            set.add(propertyDescriptor);
            break;
        }
    }

    private final void computeAnnotationProperties(Name name, Collection<PropertyDescriptor> result) {
        JavaMethod javaMethod = (JavaMethod)CollectionsKt.singleOrNull((Iterable)((DeclaredMemberIndex)this.getDeclaredMemberIndex().invoke()).findMethodsByName(name));
        if (javaMethod == null) {
            return;
        }
        JavaMethod method = javaMethod;
        result.add(LazyJavaClassMemberScope.createPropertyDescriptorWithDefaultGetter$default(this, method, null, Modality.FINAL, 2, null));
    }

    private final JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter(JavaMethod method, KotlinType givenType, Modality modality2) {
        Annotations annotations = LazyJavaAnnotationsKt.resolveAnnotations(this.getC(), method);
        JavaPropertyDescriptor javaPropertyDescriptor = JavaPropertyDescriptor.create(this.getOwnerDescriptor(), annotations, modality2, UtilsKt.toDescriptorVisibility(method.getVisibility()), false, method.getName(), this.getC().getComponents().getSourceElementFactory().source(method), false);
        Intrinsics.checkNotNullExpressionValue(javaPropertyDescriptor, "create(...)");
        JavaPropertyDescriptor propertyDescriptor = javaPropertyDescriptor;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = DescriptorFactory.createDefaultGetter(propertyDescriptor, Annotations.Companion.getEMPTY());
        Intrinsics.checkNotNullExpressionValue(propertyGetterDescriptorImpl, "createDefaultGetter(...)");
        PropertyGetterDescriptorImpl getter = propertyGetterDescriptorImpl;
        propertyDescriptor.initialize(getter, null);
        KotlinType kotlinType = givenType;
        if (kotlinType == null) {
            kotlinType = this.computeMethodReturnType(method, ContextKt.childForMethod$default(this.getC(), propertyDescriptor, method, 0, 4, null));
        }
        KotlinType returnType = kotlinType;
        propertyDescriptor.setType(returnType, CollectionsKt.emptyList(), this.getDispatchReceiverParameter(), null, CollectionsKt.<ReceiverParameterDescriptor>emptyList());
        getter.initialize(returnType);
        return propertyDescriptor;
    }

    static /* synthetic */ JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter$default(LazyJavaClassMemberScope lazyJavaClassMemberScope, JavaMethod javaMethod, KotlinType kotlinType, Modality modality2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            kotlinType = null;
        }
        return lazyJavaClassMemberScope.createPropertyDescriptorWithDefaultGetter(javaMethod, kotlinType, modality2);
    }

    private final JavaPropertyDescriptor createPropertyDescriptorByMethods(PropertyDescriptor overriddenProperty, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> functions) {
        JavaForKotlinOverridePropertyDescriptor javaForKotlinOverridePropertyDescriptor;
        PropertyAccessorDescriptorImpl propertyAccessorDescriptorImpl;
        boolean bl2;
        boolean bl3;
        SimpleFunctionDescriptor setterMethod;
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        if (!this.doesClassOverridesProperty(overriddenProperty, functions)) {
            return null;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = this.findGetterOverride(overriddenProperty, functions);
        Intrinsics.checkNotNull(simpleFunctionDescriptor2);
        SimpleFunctionDescriptor getterMethod = simpleFunctionDescriptor2;
        if (overriddenProperty.isVar()) {
            SimpleFunctionDescriptor simpleFunctionDescriptor3 = this.findSetterOverride(overriddenProperty, functions);
            simpleFunctionDescriptor = simpleFunctionDescriptor3;
            Intrinsics.checkNotNull(simpleFunctionDescriptor3);
        } else {
            simpleFunctionDescriptor = null;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor4 = setterMethod = simpleFunctionDescriptor;
        if (simpleFunctionDescriptor4 != null) {
            SimpleFunctionDescriptor it = simpleFunctionDescriptor4;
            boolean bl4 = false;
            bl3 = it.getModality() == getterMethod.getModality();
        } else {
            bl3 = bl2 = true;
        }
        if (_Assertions.ENABLED && !bl2) {
            boolean $i$a$-assert-LazyJavaClassMemberScope$createPropertyDescriptorByMethods$32 = false;
            SimpleFunctionDescriptor simpleFunctionDescriptor5 = setterMethod;
            String $i$a$-assert-LazyJavaClassMemberScope$createPropertyDescriptorByMethods$32 = "Different accessors modalities when creating overrides for " + overriddenProperty + " in " + this.getOwnerDescriptor() + "for getter is " + (Object)((Object)getterMethod.getModality()) + ", but for setter is " + (Object)((Object)(simpleFunctionDescriptor5 != null ? simpleFunctionDescriptor5.getModality() : null));
            throw new AssertionError((Object)$i$a$-assert-LazyJavaClassMemberScope$createPropertyDescriptorByMethods$32);
        }
        JavaForKotlinOverridePropertyDescriptor propertyDescriptor = new JavaForKotlinOverridePropertyDescriptor(this.getOwnerDescriptor(), getterMethod, setterMethod, overriddenProperty);
        KotlinType kotlinType = getterMethod.getReturnType();
        Intrinsics.checkNotNull(kotlinType);
        propertyDescriptor.setType(kotlinType, CollectionsKt.emptyList(), this.getDispatchReceiverParameter(), null, CollectionsKt.<ReceiverParameterDescriptor>emptyList());
        PropertyGetterDescriptorImpl bl4 = DescriptorFactory.createGetter(propertyDescriptor, getterMethod.getAnnotations(), false, false, false, getterMethod.getSource());
        PropertyAccessorDescriptorImpl $this$createPropertyDescriptorByMethods_u24lambda_u2440 = bl4;
        boolean bl5 = false;
        $this$createPropertyDescriptorByMethods_u24lambda_u2440.setInitialSignatureDescriptor(getterMethod);
        ((PropertyGetterDescriptorImpl)$this$createPropertyDescriptorByMethods_u24lambda_u2440).initialize(propertyDescriptor.getType());
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = bl4;
        Intrinsics.checkNotNullExpressionValue(propertyGetterDescriptorImpl, "apply(...)");
        PropertyGetterDescriptorImpl getter = propertyGetterDescriptorImpl;
        if (setterMethod != null) {
            List<ValueParameterDescriptor> list = setterMethod.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
            ValueParameterDescriptor valueParameterDescriptor = CollectionsKt.firstOrNull(list);
            if (valueParameterDescriptor == null) {
                throw new AssertionError((Object)("No parameter found for " + setterMethod));
            }
            ValueParameterDescriptor parameter = valueParameterDescriptor;
            PropertyAccessorDescriptorImpl $this$createPropertyDescriptorByMethods_u24lambda_u2441 = $this$createPropertyDescriptorByMethods_u24lambda_u2440 = DescriptorFactory.createSetter(propertyDescriptor, setterMethod.getAnnotations(), parameter.getAnnotations(), false, false, false, setterMethod.getVisibility(), setterMethod.getSource());
            boolean bl6 = false;
            $this$createPropertyDescriptorByMethods_u24lambda_u2441.setInitialSignatureDescriptor(setterMethod);
            propertyAccessorDescriptorImpl = $this$createPropertyDescriptorByMethods_u24lambda_u2440;
        } else {
            propertyAccessorDescriptorImpl = null;
        }
        PropertyAccessorDescriptorImpl setter = propertyAccessorDescriptorImpl;
        JavaForKotlinOverridePropertyDescriptor $this$createPropertyDescriptorByMethods_u24lambda_u2442 = javaForKotlinOverridePropertyDescriptor = propertyDescriptor;
        boolean bl7 = false;
        $this$createPropertyDescriptorByMethods_u24lambda_u2442.initialize(getter, (PropertySetterDescriptor)((Object)setter));
        return javaForKotlinOverridePropertyDescriptor;
    }

    /*
     * WARNING - void declaration
     */
    private final Set<PropertyDescriptor> getPropertiesFromSupertypes(Name name) {
        void $this$flatMapTo$iv$iv;
        Iterable $this$flatMap$iv = this.computeSupertypes();
        boolean $i$f$flatMap = false;
        Iterable iterable = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            void $this$mapTo$iv$iv;
            KotlinType it = (KotlinType)element$iv$iv;
            boolean bl2 = false;
            Iterable $this$map$iv = it.getMemberScope().getContributedVariables(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            boolean $i$f$map = false;
            Iterable iterable2 = $this$map$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void p2;
                PropertyDescriptor propertyDescriptor = (PropertyDescriptor)item$iv$iv;
                Collection collection = destination$iv$iv2;
                boolean bl3 = false;
                collection.add(p2);
            }
            Iterable list$iv$iv = (List)destination$iv$iv2;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return CollectionsKt.toSet((List)destination$iv$iv);
    }

    private final Collection<KotlinType> computeSupertypes() {
        if (this.skipRefinement) {
            Collection<KotlinType> collection = this.getOwnerDescriptor().getTypeConstructor().getSupertypes();
            Intrinsics.checkNotNullExpressionValue(collection, "getSupertypes(...)");
            return collection;
        }
        return this.getC().getComponents().getKotlinTypeChecker().getKotlinTypeRefiner().refineSupertypes(this.getOwnerDescriptor());
    }

    @Override
    @NotNull
    protected LazyJavaScope.MethodSignatureData resolveMethodSignature(@NotNull JavaMethod method, @NotNull List<? extends TypeParameterDescriptor> methodTypeParameters, @NotNull KotlinType returnType, @NotNull List<? extends ValueParameterDescriptor> valueParameters) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(methodTypeParameters, "methodTypeParameters");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(valueParameters, "valueParameters");
        SignaturePropagator.PropagatedSignature propagatedSignature = this.getC().getComponents().getSignaturePropagator().resolvePropagatedSignature(method, this.getOwnerDescriptor(), returnType, null, valueParameters, methodTypeParameters);
        Intrinsics.checkNotNullExpressionValue(propagatedSignature, "resolvePropagatedSignature(...)");
        SignaturePropagator.PropagatedSignature propagated = propagatedSignature;
        KotlinType kotlinType = propagated.getReturnType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getReturnType(...)");
        KotlinType kotlinType2 = propagated.getReceiverType();
        List<ValueParameterDescriptor> list = propagated.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
        List<TypeParameterDescriptor> list2 = propagated.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(list2, "getTypeParameters(...)");
        boolean bl2 = propagated.hasStableParameterNames();
        List<String> list3 = propagated.getErrors();
        Intrinsics.checkNotNullExpressionValue(list3, "getErrors(...)");
        return new LazyJavaScope.MethodSignatureData(kotlinType, kotlinType2, list, list2, bl2, list3);
    }

    private final boolean hasSameJvmDescriptorButDoesNotOverride(SimpleFunctionDescriptor $this$hasSameJvmDescriptorButDoesNotOverride, FunctionDescriptor builtinWithErasedParameters) {
        String string = MethodSignatureMappingKt.computeJvmDescriptor$default($this$hasSameJvmDescriptorButDoesNotOverride, false, false, 2, null);
        FunctionDescriptor functionDescriptor = builtinWithErasedParameters.getOriginal();
        Intrinsics.checkNotNullExpressionValue(functionDescriptor, "getOriginal(...)");
        return Intrinsics.areEqual(string, MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 2, null)) && !this.doesOverride($this$hasSameJvmDescriptorButDoesNotOverride, builtinWithErasedParameters);
    }

    /*
     * WARNING - void declaration
     */
    private final JavaClassConstructorDescriptor resolveConstructor(JavaConstructor constructor) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        ClassDescriptor classDescriptor = this.getOwnerDescriptor();
        JavaClassConstructorDescriptor javaClassConstructorDescriptor = JavaClassConstructorDescriptor.createJavaConstructor(classDescriptor, LazyJavaAnnotationsKt.resolveAnnotations(this.getC(), constructor), false, this.getC().getComponents().getSourceElementFactory().source(constructor));
        Intrinsics.checkNotNullExpressionValue(javaClassConstructorDescriptor, "createJavaConstructor(...)");
        JavaClassConstructorDescriptor constructorDescriptor = javaClassConstructorDescriptor;
        LazyJavaResolverContext c2 = ContextKt.childForMethod(this.getC(), constructorDescriptor, constructor, classDescriptor.getDeclaredTypeParameters().size());
        LazyJavaScope.ResolvedValueParameters valueParameters = this.resolveValueParameters(c2, constructorDescriptor, constructor.getValueParameters());
        List<TypeParameterDescriptor> list = classDescriptor.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getDeclaredTypeParameters(...)");
        Iterable iterable = constructor.getTypeParameters();
        Collection collection = list;
        boolean $i$f$map = false;
        void var9_9 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p2;
            JavaTypeParameter javaTypeParameter = (JavaTypeParameter)item$iv$iv;
            Collection collection2 = destination$iv$iv;
            boolean bl2 = false;
            TypeParameterDescriptor typeParameterDescriptor = c2.getTypeParameterResolver().resolveTypeParameter((JavaTypeParameter)p2);
            Intrinsics.checkNotNull(typeParameterDescriptor);
            collection2.add(typeParameterDescriptor);
        }
        List<TypeParameterDescriptor> constructorTypeParameters = CollectionsKt.plus(collection, (Iterable)((List)destination$iv$iv));
        constructorDescriptor.initialize(valueParameters.getDescriptors(), UtilsKt.toDescriptorVisibility(constructor.getVisibility()), constructorTypeParameters);
        constructorDescriptor.setHasStableParameterNames(false);
        constructorDescriptor.setHasSynthesizedParameterNames(valueParameters.getHasSynthesizedNames());
        constructorDescriptor.setReturnType(classDescriptor.getDefaultType());
        c2.getComponents().getJavaResolverCache().recordConstructor(constructor, constructorDescriptor);
        return constructorDescriptor;
    }

    private final ClassConstructorDescriptor createDefaultConstructor() {
        boolean isAnnotation = this.jClass.isAnnotationType();
        if (!(!this.jClass.isInterface() && this.jClass.hasDefaultConstructor() || isAnnotation)) {
            return null;
        }
        ClassDescriptor classDescriptor = this.getOwnerDescriptor();
        JavaClassConstructorDescriptor javaClassConstructorDescriptor = JavaClassConstructorDescriptor.createJavaConstructor(classDescriptor, Annotations.Companion.getEMPTY(), true, this.getC().getComponents().getSourceElementFactory().source(this.jClass));
        Intrinsics.checkNotNullExpressionValue(javaClassConstructorDescriptor, "createJavaConstructor(...)");
        JavaClassConstructorDescriptor constructorDescriptor = javaClassConstructorDescriptor;
        List<ValueParameterDescriptor> valueParameters = isAnnotation ? this.createAnnotationConstructorParameters(constructorDescriptor) : Collections.emptyList();
        constructorDescriptor.setHasSynthesizedParameterNames(false);
        constructorDescriptor.initialize(valueParameters, this.getConstructorVisibility(classDescriptor));
        constructorDescriptor.setHasStableParameterNames(true);
        constructorDescriptor.setReturnType(classDescriptor.getDefaultType());
        this.getC().getComponents().getJavaResolverCache().recordConstructor(this.jClass, constructorDescriptor);
        return constructorDescriptor;
    }

    private final DescriptorVisibility getConstructorVisibility(ClassDescriptor classDescriptor) {
        DescriptorVisibility descriptorVisibility = classDescriptor.getVisibility();
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "getVisibility(...)");
        DescriptorVisibility visibility2 = descriptorVisibility;
        if (Intrinsics.areEqual(visibility2, JavaDescriptorVisibilities.PROTECTED_STATIC_VISIBILITY)) {
            DescriptorVisibility descriptorVisibility2 = JavaDescriptorVisibilities.PROTECTED_AND_PACKAGE;
            Intrinsics.checkNotNullExpressionValue(descriptorVisibility2, "PROTECTED_AND_PACKAGE");
            return descriptorVisibility2;
        }
        return visibility2;
    }

    private final List<ValueParameterDescriptor> createAnnotationConstructorParameters(ClassConstructorDescriptorImpl constructor) {
        Object object;
        Collection<JavaMethod> methods2 = this.jClass.getMethods();
        ArrayList result = new ArrayList(methods2.size());
        JavaTypeAttributes attr = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, true, false, null, 6, null);
        Iterable $this$partition$iv = methods2;
        boolean $i$f$partition = false;
        ArrayList first$iv = new ArrayList();
        ArrayList second$iv = new ArrayList();
        for (Object element$iv : $this$partition$iv) {
            JavaMethod it = (JavaMethod)element$iv;
            boolean bl2 = false;
            boolean bl3 = Intrinsics.areEqual(it.getName(), JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME) ? first$iv.add(element$iv) : second$iv.add(element$iv);
        }
        Pair pair = new Pair(first$iv, second$iv);
        List methodsNamedValue = pair.component1();
        List otherMethods = pair.component2();
        boolean bl4 = first$iv = methodsNamedValue.size() <= 1;
        if (_Assertions.ENABLED && !first$iv) {
            boolean $i$a$-assert-LazyJavaClassMemberScope$createAnnotationConstructorParameters$32 = false;
            String $i$a$-assert-LazyJavaClassMemberScope$createAnnotationConstructorParameters$32 = "There can't be more than one method named 'value' in annotation class: " + this.jClass;
            throw new AssertionError((Object)$i$a$-assert-LazyJavaClassMemberScope$createAnnotationConstructorParameters$32);
        }
        JavaMethod methodNamedValue = (JavaMethod)CollectionsKt.firstOrNull(methodsNamedValue);
        if (methodNamedValue != null) {
            JavaType parameterNamedValueJavaType = methodNamedValue.getReturnType();
            object = parameterNamedValueJavaType instanceof JavaArrayType ? new Pair<KotlinType, KotlinType>(this.getC().getTypeResolver().transformArrayType((JavaArrayType)parameterNamedValueJavaType, attr, true), this.getC().getTypeResolver().transformJavaType(((JavaArrayType)parameterNamedValueJavaType).getComponentType(), attr)) : new Pair<KotlinType, Object>(this.getC().getTypeResolver().transformJavaType(parameterNamedValueJavaType, attr), null);
            KotlinType parameterType = (KotlinType)((Pair)object).component1();
            KotlinType varargType = (KotlinType)((Pair)object).component2();
            this.addAnnotationValueParameter(result, constructor, 0, methodNamedValue, parameterType, varargType);
        }
        int startIndex = methodNamedValue != null ? 1 : 0;
        object = ((Iterable)otherMethods).iterator();
        int n2 = 0;
        while (object.hasNext()) {
            int index = n2++;
            JavaMethod method = (JavaMethod)object.next();
            KotlinType parameterType = this.getC().getTypeResolver().transformJavaType(method.getReturnType(), attr);
            this.addAnnotationValueParameter(result, constructor, index + startIndex, method, parameterType, null);
        }
        return result;
    }

    /*
     * WARNING - void declaration
     */
    private final void addAnnotationValueParameter(List<ValueParameterDescriptor> $this$addAnnotationValueParameter, ConstructorDescriptor constructor, int index, JavaMethod method, KotlinType returnType, KotlinType varargElementType) {
        KotlinType kotlinType;
        List<ValueParameterDescriptor> list = $this$addAnnotationValueParameter;
        CallableDescriptor callableDescriptor = constructor;
        ValueParameterDescriptor valueParameterDescriptor = null;
        int n2 = index;
        Annotations annotations = Annotations.Companion.getEMPTY();
        Name name = method.getName();
        KotlinType kotlinType2 = TypeUtils.makeNotNullable(returnType);
        KotlinType kotlinType3 = kotlinType2;
        Intrinsics.checkNotNullExpressionValue(kotlinType2, "makeNotNullable(...)");
        boolean bl2 = method.getHasAnnotationParameterDefaultValue();
        boolean bl3 = false;
        boolean bl4 = false;
        KotlinType kotlinType4 = varargElementType;
        if (kotlinType4 != null) {
            void it;
            KotlinType kotlinType5 = kotlinType4;
            boolean bl5 = bl4;
            boolean bl6 = bl3;
            boolean bl7 = bl2;
            KotlinType kotlinType6 = kotlinType3;
            Name name2 = name;
            Annotations annotations2 = annotations;
            int n3 = n2;
            ValueParameterDescriptor valueParameterDescriptor2 = valueParameterDescriptor;
            CallableDescriptor callableDescriptor2 = callableDescriptor;
            List<ValueParameterDescriptor> list2 = list;
            boolean bl8 = false;
            KotlinType kotlinType7 = TypeUtils.makeNotNullable((KotlinType)it);
            list = list2;
            callableDescriptor = callableDescriptor2;
            valueParameterDescriptor = valueParameterDescriptor2;
            n2 = n3;
            annotations = annotations2;
            name = name2;
            kotlinType3 = kotlinType6;
            bl2 = bl7;
            bl3 = bl6;
            bl4 = bl5;
            kotlinType = kotlinType7;
        } else {
            kotlinType = null;
        }
        SourceElement sourceElement = this.getC().getComponents().getSourceElementFactory().source(method);
        KotlinType kotlinType8 = kotlinType;
        boolean bl9 = bl4;
        boolean bl10 = bl3;
        boolean bl11 = bl2;
        KotlinType kotlinType9 = kotlinType3;
        Name name3 = name;
        Annotations annotations3 = annotations;
        int n4 = n2;
        ValueParameterDescriptor valueParameterDescriptor3 = valueParameterDescriptor;
        CallableDescriptor callableDescriptor3 = callableDescriptor;
        list.add(new ValueParameterDescriptorImpl(callableDescriptor3, valueParameterDescriptor3, n4, annotations3, name3, kotlinType9, bl11, bl10, bl9, kotlinType8, sourceElement));
    }

    @Override
    @Nullable
    protected ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return DescriptorUtils.getDispatchReceiverParameterIfNeeded(this.getOwnerDescriptor());
    }

    @Override
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        this.recordLookup(name, location);
        Object object = (LazyJavaClassMemberScope)this.getMainScope();
        return object != null && (object = ((LazyJavaClassMemberScope)object).nestedClasses) != null && (object = (ClassDescriptor)object.invoke(name)) != null ? (ClassifierDescriptor)object : (ClassifierDescriptor)this.nestedClasses.invoke(name);
    }

    @Override
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        this.recordLookup(name, location);
        return super.getContributedFunctions(name, location);
    }

    @Override
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        this.recordLookup(name, location);
        return super.getContributedVariables(name, location);
    }

    @Override
    @NotNull
    protected Set<Name> computeClassNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        return SetsKt.plus((Set)this.nestedClassIndex.invoke(), ((Map)this.enumEntryIndex.invoke()).keySet());
    }

    @Override
    @NotNull
    protected Set<Name> computePropertyNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        if (this.jClass.isAnnotationType()) {
            return this.getFunctionNames();
        }
        LinkedHashSet result = new LinkedHashSet(((DeclaredMemberIndex)this.getDeclaredMemberIndex().invoke()).getFieldNames());
        Collection<KotlinType> collection = this.getOwnerDescriptor().getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(collection, "getSupertypes(...)");
        Iterable $this$flatMapTo$iv = collection;
        boolean $i$f$flatMapTo = false;
        for (Object element$iv : $this$flatMapTo$iv) {
            KotlinType supertype = (KotlinType)element$iv;
            boolean bl2 = false;
            Iterable list$iv = supertype.getMemberScope().getVariableNames();
            CollectionsKt.addAll((Collection)result, list$iv);
        }
        return (Set)((Collection)result);
    }

    @Override
    public void recordLookup(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        kotlin.reflect.jvm.internal.impl.incremental.UtilsKt.record(this.getC().getComponents().getLookupTracker(), location, this.getOwnerDescriptor(), name);
    }

    @Override
    @NotNull
    public String toString() {
        return "Lazy Java member scope for " + this.jClass.getFqName();
    }

    private static final boolean computeMemberIndex$lambda$0(JavaMember it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !it.isStatic();
    }

    private static final List constructors$lambda$5(LazyJavaClassMemberScope this$0, LazyJavaResolverContext $c) {
        Collection collection;
        Collection<JavaConstructor> constructors2 = this$0.jClass.getConstructors();
        ArrayList<ClassConstructorDescriptor> result = new ArrayList<ClassConstructorDescriptor>(constructors2.size());
        for (JavaConstructor constructor : constructors2) {
            JavaClassConstructorDescriptor descriptor2 = this$0.resolveConstructor(constructor);
            result.add(descriptor2);
        }
        if (this$0.jClass.isRecord()) {
            boolean bl2;
            ClassConstructorDescriptor defaultConstructor;
            block8: {
                defaultConstructor = this$0.createDefaultRecordConstructor();
                String jvmDescriptor = MethodSignatureMappingKt.computeJvmDescriptor$default(defaultConstructor, false, false, 2, null);
                Iterable $this$none$iv = result;
                boolean $i$f$none = false;
                if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                    bl2 = true;
                } else {
                    for (Object element$iv : $this$none$iv) {
                        ClassConstructorDescriptor it = (ClassConstructorDescriptor)element$iv;
                        boolean bl3 = false;
                        if (!Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default(it, false, false, 2, null), jvmDescriptor)) continue;
                        bl2 = false;
                        break block8;
                    }
                    bl2 = true;
                }
            }
            if (bl2) {
                result.add(defaultConstructor);
                $c.getComponents().getJavaResolverCache().recordConstructor(this$0.jClass, defaultConstructor);
            }
        }
        $c.getComponents().getSyntheticPartsProvider().generateConstructors(this$0.getOwnerDescriptor(), (List<ClassConstructorDescriptor>)result, $c);
        SignatureEnhancement signatureEnhancement = $c.getComponents().getSignatureEnhancement();
        LazyJavaResolverContext lazyJavaResolverContext = $c;
        Collection $this$ifEmpty$iv = result;
        boolean $i$f$ifEmpty = false;
        if ($this$ifEmpty$iv.isEmpty()) {
            LazyJavaResolverContext lazyJavaResolverContext2 = lazyJavaResolverContext;
            SignatureEnhancement signatureEnhancement2 = signatureEnhancement;
            boolean bl4 = false;
            List<ClassConstructorDescriptor> list = CollectionsKt.listOfNotNull(this$0.createDefaultConstructor());
            signatureEnhancement = signatureEnhancement2;
            lazyJavaResolverContext = lazyJavaResolverContext2;
            collection = list;
        } else {
            collection = $this$ifEmpty$iv;
        }
        return CollectionsKt.toList(signatureEnhancement.enhanceSignatures(lazyJavaResolverContext, collection));
    }

    private static final Collection isVisibleAsFunctionInCurrentClass$lambda$8$lambda$7$lambda$6(SimpleFunctionDescriptor $function, LazyJavaClassMemberScope this$0, Name accessorName) {
        Intrinsics.checkNotNullParameter(accessorName, "accessorName");
        return Intrinsics.areEqual($function.getName(), accessorName) ? (Collection)CollectionsKt.listOf($function) : (Collection)CollectionsKt.plus(this$0.searchMethodsByNameWithoutBuiltinMagic(accessorName), (Iterable)this$0.searchMethodsInSupertypesWithoutBuiltinMagic(accessorName));
    }

    private static final Collection computeNonDeclaredProperties$lambda$36(LazyJavaClassMemberScope this$0, Name it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.searchMethodsByNameWithoutBuiltinMagic(it);
    }

    private static final Collection computeNonDeclaredProperties$lambda$37(LazyJavaClassMemberScope this$0, Name it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.searchMethodsInSupertypesWithoutBuiltinMagic(it);
    }

    private static final Set nestedClassIndex$lambda$49(LazyJavaClassMemberScope this$0) {
        return CollectionsKt.toSet((Iterable)this$0.jClass.getInnerClassNames());
    }

    private static final Set generatedNestedClassNames$lambda$50(LazyJavaResolverContext $c, LazyJavaClassMemberScope this$0) {
        return CollectionsKt.toSet((Iterable)$c.getComponents().getSyntheticPartsProvider().getNestedClassNames(this$0.getOwnerDescriptor(), $c));
    }

    /*
     * WARNING - void declaration
     */
    private static final Map enumEntryIndex$lambda$53(LazyJavaClassMemberScope this$0) {
        void $this$associateByTo$iv$iv;
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this$0.jClass.getFields();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Iterable destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            JavaField it = (JavaField)element$iv$iv;
            boolean bl2 = false;
            if (!it.isEnumEntry()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$associateBy$iv = (List)destination$iv$iv;
        boolean $i$f$associateBy = false;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        destination$iv$iv = $this$associateBy$iv;
        Map destination$iv$iv2 = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv : $this$associateByTo$iv$iv) {
            void f2;
            JavaField bl2 = (JavaField)element$iv$iv;
            Map map = destination$iv$iv2;
            boolean bl3 = false;
            map.put(f2.getName(), element$iv$iv);
        }
        return destination$iv$iv2;
    }

    private static final Set nestedClasses$lambda$59$lambda$58(LazyJavaClassMemberScope this$0) {
        return SetsKt.plus(this$0.getFunctionNames(), (Iterable)this$0.getVariableNames());
    }

    private static final ClassDescriptor nestedClasses$lambda$59(LazyJavaClassMemberScope this$0, LazyJavaResolverContext $c, Name name) {
        ClassDescriptor classDescriptor;
        block9: {
            EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor;
            block10: {
                List<ClassDescriptor> list;
                Name name2;
                block8: {
                    LazyJavaClassDescriptor lazyJavaClassDescriptor;
                    Intrinsics.checkNotNullParameter(name, "name");
                    name2 = name;
                    if (!((Set)this$0.nestedClassIndex.invoke()).contains(name2)) break block8;
                    JavaClassFinder javaClassFinder = $c.getComponents().getFinder();
                    ClassId classId = DescriptorUtilsKt.getClassId(this$0.getOwnerDescriptor());
                    Intrinsics.checkNotNull(classId);
                    JavaClass javaClass = javaClassFinder.findClass(new JavaClassFinder.Request(classId.createNestedClassId(name), null, this$0.jClass, 2, null));
                    if (javaClass != null) {
                        JavaClass it = javaClass;
                        boolean bl2 = false;
                        LazyJavaClassDescriptor lazyJavaClassDescriptor2 = new LazyJavaClassDescriptor($c, this$0.getOwnerDescriptor(), it, null, 8, null);
                        JavaClassesTracker javaClassesTracker = $c.getComponents().getJavaClassesTracker();
                        JavaClassDescriptor p0 = lazyJavaClassDescriptor2;
                        boolean bl3 = false;
                        javaClassesTracker.reportClass(p0);
                        lazyJavaClassDescriptor = lazyJavaClassDescriptor2;
                    } else {
                        lazyJavaClassDescriptor = null;
                    }
                    classDescriptor = lazyJavaClassDescriptor;
                    break block9;
                }
                if (!((Set)this$0.generatedNestedClassNames.invoke()).contains(name2)) break block10;
                LazyJavaResolverContext $this$nestedClasses_u24lambda_u2459_u24lambda_u2457 = $c;
                boolean bl4 = false;
                List<ClassDescriptor> $this$nestedClasses_u24lambda_u2459_u24lambda_u2457_u24lambda_u2456 = list = CollectionsKt.createListBuilder();
                boolean bl5 = false;
                $c.getComponents().getSyntheticPartsProvider().generateNestedClass(this$0.getOwnerDescriptor(), name, $this$nestedClasses_u24lambda_u2459_u24lambda_u2457_u24lambda_u2456, $c);
                List<ClassDescriptor> classes = CollectionsKt.build(list);
                switch (classes.size()) {
                    case 0: {
                        classDescriptor = null;
                        break block9;
                    }
                    case 1: {
                        classDescriptor = CollectionsKt.single(classes);
                        break block9;
                    }
                    default: {
                        String string = "Multiple classes with same name are generated: " + classes;
                        throw new IllegalStateException(string.toString());
                    }
                }
            }
            JavaField field = (JavaField)((Map)this$0.enumEntryIndex.invoke()).get(name);
            if (field != null) {
                LazyJavaClassMemberScope lazyJavaClassMemberScope = this$0;
                NotNullLazyValue<Set<Name>> enumMemberNames = $c.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$$Lambda$9(lazyJavaClassMemberScope));
                enumEntrySyntheticClassDescriptor = EnumEntrySyntheticClassDescriptor.create($c.getStorageManager(), this$0.getOwnerDescriptor(), name, enumMemberNames, LazyJavaAnnotationsKt.resolveAnnotations($c, field), $c.getComponents().getSourceElementFactory().source(field));
            } else {
                enumEntrySyntheticClassDescriptor = null;
            }
            classDescriptor = enumEntrySyntheticClassDescriptor;
        }
        return classDescriptor;
    }

    public static final /* synthetic */ Collection access$searchMethodsByNameWithoutBuiltinMagic(LazyJavaClassMemberScope $this, Name name) {
        return $this.searchMethodsByNameWithoutBuiltinMagic(name);
    }

    public static final /* synthetic */ Collection access$searchMethodsInSupertypesWithoutBuiltinMagic(LazyJavaClassMemberScope $this, Name name) {
        return $this.searchMethodsInSupertypesWithoutBuiltinMagic(name);
    }

    static /* synthetic */ List accessor$LazyJavaClassMemberScope$lambda0(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        return LazyJavaClassMemberScope.constructors$lambda$5(lazyJavaClassMemberScope, lazyJavaResolverContext);
    }

    static /* synthetic */ Set accessor$LazyJavaClassMemberScope$lambda1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        return LazyJavaClassMemberScope.nestedClassIndex$lambda$49(lazyJavaClassMemberScope);
    }

    static /* synthetic */ Set accessor$LazyJavaClassMemberScope$lambda2(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        return LazyJavaClassMemberScope.generatedNestedClassNames$lambda$50(lazyJavaResolverContext, lazyJavaClassMemberScope);
    }

    static /* synthetic */ Map accessor$LazyJavaClassMemberScope$lambda3(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        return LazyJavaClassMemberScope.enumEntryIndex$lambda$53(lazyJavaClassMemberScope);
    }

    static /* synthetic */ ClassDescriptor accessor$LazyJavaClassMemberScope$lambda4(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext, Name name) {
        return LazyJavaClassMemberScope.nestedClasses$lambda$59(lazyJavaClassMemberScope, lazyJavaResolverContext, name);
    }

    static /* synthetic */ boolean accessor$LazyJavaClassMemberScope$lambda5(JavaMember javaMember) {
        return LazyJavaClassMemberScope.computeMemberIndex$lambda$0(javaMember);
    }

    static /* synthetic */ Collection accessor$LazyJavaClassMemberScope$lambda6(SimpleFunctionDescriptor simpleFunctionDescriptor, LazyJavaClassMemberScope lazyJavaClassMemberScope, Name name) {
        return LazyJavaClassMemberScope.isVisibleAsFunctionInCurrentClass$lambda$8$lambda$7$lambda$6(simpleFunctionDescriptor, lazyJavaClassMemberScope, name);
    }

    static /* synthetic */ Collection accessor$LazyJavaClassMemberScope$lambda7(LazyJavaClassMemberScope lazyJavaClassMemberScope, Name name) {
        return LazyJavaClassMemberScope.computeNonDeclaredProperties$lambda$36(lazyJavaClassMemberScope, name);
    }

    static /* synthetic */ Collection accessor$LazyJavaClassMemberScope$lambda8(LazyJavaClassMemberScope lazyJavaClassMemberScope, Name name) {
        return LazyJavaClassMemberScope.computeNonDeclaredProperties$lambda$37(lazyJavaClassMemberScope, name);
    }

    static /* synthetic */ Set accessor$LazyJavaClassMemberScope$lambda9(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        return LazyJavaClassMemberScope.nestedClasses$lambda$59$lambda$58(lazyJavaClassMemberScope);
    }
}

