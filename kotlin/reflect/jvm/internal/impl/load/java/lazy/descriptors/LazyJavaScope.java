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
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$10;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$11;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$4;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$5;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$6;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$7;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$8;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$$Lambda$9;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nLazyJavaScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,408:1\n1491#2:409\n1516#2,3:410\n1519#2,3:420\n1563#2:423\n1634#2,3:424\n1563#2:427\n1634#2,3:428\n382#3,7:413\n*S KotlinDebug\n*F\n+ 1 LazyJavaScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaScope\n*L\n129#1:409\n129#1:410,3\n129#1:420,3\n165#1:423\n165#1:424,3\n212#1:427\n212#1:428,3\n129#1:413,7\n*E\n"})
public abstract class LazyJavaScope
extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final LazyJavaResolverContext c;
    @Nullable
    private final LazyJavaScope mainScope;
    @NotNull
    private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
    @NotNull
    private final NotNullLazyValue<DeclaredMemberIndex> declaredMemberIndex;
    @NotNull
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> declaredFunctions;
    @NotNull
    private final MemoizedFunctionToNullable<Name, PropertyDescriptor> declaredField;
    @NotNull
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
    @NotNull
    private final NotNullLazyValue functionNamesLazy$delegate;
    @NotNull
    private final NotNullLazyValue propertyNamesLazy$delegate;
    @NotNull
    private final NotNullLazyValue classNamesLazy$delegate;
    @NotNull
    private final MemoizedFunctionToNotNull<Name, List<PropertyDescriptor>> properties;

    public LazyJavaScope(@NotNull LazyJavaResolverContext c2, @Nullable LazyJavaScope mainScope) {
        Intrinsics.checkNotNullParameter(c2, "c");
        this.c = c2;
        this.mainScope = mainScope;
        LazyJavaScope lazyJavaScope = this;
        this.allDescriptors = this.c.getStorageManager().createRecursionTolerantLazyValue(new LazyJavaScope$$Lambda$0(lazyJavaScope), CollectionsKt.emptyList());
        lazyJavaScope = this;
        this.declaredMemberIndex = this.c.getStorageManager().createLazyValue(new LazyJavaScope$$Lambda$1(lazyJavaScope));
        lazyJavaScope = this;
        this.declaredFunctions = this.c.getStorageManager().createMemoizedFunction(new LazyJavaScope$$Lambda$2(lazyJavaScope));
        lazyJavaScope = this;
        this.declaredField = this.c.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaScope$$Lambda$3(lazyJavaScope));
        lazyJavaScope = this;
        this.functions = this.c.getStorageManager().createMemoizedFunction(new LazyJavaScope$$Lambda$4(lazyJavaScope));
        lazyJavaScope = this;
        this.functionNamesLazy$delegate = this.c.getStorageManager().createLazyValue(new LazyJavaScope$$Lambda$5(lazyJavaScope));
        lazyJavaScope = this;
        this.propertyNamesLazy$delegate = this.c.getStorageManager().createLazyValue(new LazyJavaScope$$Lambda$6(lazyJavaScope));
        lazyJavaScope = this;
        this.classNamesLazy$delegate = this.c.getStorageManager().createLazyValue(new LazyJavaScope$$Lambda$7(lazyJavaScope));
        lazyJavaScope = this;
        this.properties = this.c.getStorageManager().createMemoizedFunction(new LazyJavaScope$$Lambda$8(lazyJavaScope));
    }

    public /* synthetic */ LazyJavaScope(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaScope lazyJavaScope, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            lazyJavaScope = null;
        }
        this(lazyJavaResolverContext, lazyJavaScope);
    }

    @NotNull
    protected final LazyJavaResolverContext getC() {
        return this.c;
    }

    @Nullable
    protected final LazyJavaScope getMainScope() {
        return this.mainScope;
    }

    @NotNull
    protected abstract DeclarationDescriptor getOwnerDescriptor();

    @NotNull
    protected final NotNullLazyValue<Collection<DeclarationDescriptor>> getAllDescriptors() {
        return this.allDescriptors;
    }

    @NotNull
    protected final NotNullLazyValue<DeclaredMemberIndex> getDeclaredMemberIndex() {
        return this.declaredMemberIndex;
    }

    @NotNull
    protected abstract DeclaredMemberIndex computeMemberIndex();

    protected abstract void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> var1, @NotNull Name var2);

    protected void computeImplicitlyDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> result, @NotNull Name name) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @Nullable
    protected abstract ReceiverParameterDescriptor getDispatchReceiverParameter();

    /*
     * WARNING - void declaration
     */
    private final void retainMostSpecificMethods(Set<SimpleFunctionDescriptor> $this$retainMostSpecificMethods) {
        void $this$groupByTo$iv$iv;
        Iterable $this$groupBy$iv = $this$retainMostSpecificMethods;
        boolean $i$f$groupBy = false;
        Iterable iterable = $this$groupBy$iv;
        Map destination$iv$iv = new LinkedHashMap();
        boolean $i$f$groupByTo = false;
        for (Object element$iv$iv : $this$groupByTo$iv$iv) {
            Object object;
            SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv$iv;
            boolean bl2 = false;
            String key$iv$iv = MethodSignatureMappingKt.computeJvmDescriptor$default(it, false, false, 2, null);
            Map $this$getOrPut$iv$iv$iv = destination$iv$iv;
            boolean $i$f$getOrPut = false;
            Object value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                boolean bl3 = false;
                List answer$iv$iv$iv = new ArrayList();
                $this$getOrPut$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                object = answer$iv$iv$iv;
            } else {
                object = value$iv$iv$iv;
            }
            List list$iv$iv = (List)object;
            list$iv$iv.add(element$iv$iv);
        }
        Collection groups2 = destination$iv$iv.values();
        for (List group : groups2) {
            if (group.size() == 1) continue;
            Collection mostSpecificMethods = OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(group, LazyJavaScope$$Lambda$9.INSTANCE);
            $this$retainMostSpecificMethods.removeAll(group);
            $this$retainMostSpecificMethods.addAll(mostSpecificMethods);
        }
    }

    protected boolean isVisibleAsFunction(@NotNull JavaMethodDescriptor $this$isVisibleAsFunction) {
        Intrinsics.checkNotNullParameter($this$isVisibleAsFunction, "<this>");
        return true;
    }

    @NotNull
    protected abstract MethodSignatureData resolveMethodSignature(@NotNull JavaMethod var1, @NotNull List<? extends TypeParameterDescriptor> var2, @NotNull KotlinType var3, @NotNull List<? extends ValueParameterDescriptor> var4);

    /*
     * WARNING - void declaration
     */
    @NotNull
    protected final JavaMethodDescriptor resolveMethodToFunctionDescriptor(@NotNull JavaMethod method) {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        Object object;
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(method, "method");
        Annotations annotations = LazyJavaAnnotationsKt.resolveAnnotations(this.c, method);
        JavaMethodDescriptor javaMethodDescriptor = JavaMethodDescriptor.createJavaMethod(this.getOwnerDescriptor(), annotations, method.getName(), this.c.getComponents().getSourceElementFactory().source(method), ((DeclaredMemberIndex)this.declaredMemberIndex.invoke()).findRecordComponentByName(method.getName()) != null && method.getValueParameters().isEmpty());
        Intrinsics.checkNotNullExpressionValue(javaMethodDescriptor, "createJavaMethod(...)");
        JavaMethodDescriptor functionDescriptorImpl = javaMethodDescriptor;
        LazyJavaResolverContext c2 = ContextKt.childForMethod$default(this.c, functionDescriptorImpl, method, 0, 4, null);
        Iterable $this$map$iv = method.getTypeParameters();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p2;
            JavaTypeParameter javaTypeParameter = (JavaTypeParameter)item$iv$iv;
            object = destination$iv$iv;
            boolean bl2 = false;
            TypeParameterDescriptor typeParameterDescriptor = c2.getTypeParameterResolver().resolveTypeParameter((JavaTypeParameter)p2);
            Intrinsics.checkNotNull(typeParameterDescriptor);
            object.add(typeParameterDescriptor);
        }
        List methodTypeParameters = (List)destination$iv$iv;
        ResolvedValueParameters valueParameters = this.resolveValueParameters(c2, functionDescriptorImpl, method.getValueParameters());
        KotlinType returnType = this.computeMethodReturnType(method, c2);
        MethodSignatureData effectiveSignature = this.resolveMethodSignature(method, methodTypeParameters, returnType, valueParameters.getDescriptors());
        Object object2 = functionDescriptorImpl;
        KotlinType kotlinType = effectiveSignature.getReceiverType();
        if (kotlinType != null) {
            void it;
            KotlinType kotlinType2 = kotlinType;
            object = object2;
            boolean bl3 = false;
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(functionDescriptorImpl, (KotlinType)it, Annotations.Companion.getEMPTY());
            object2 = object;
        } else {
            receiverParameterDescriptor = null;
        }
        ((JavaMethodDescriptor)object2).initialize(receiverParameterDescriptor, this.getDispatchReceiverParameter(), CollectionsKt.<ReceiverParameterDescriptor>emptyList(), effectiveSignature.getTypeParameters(), effectiveSignature.getValueParameters(), effectiveSignature.getReturnType(), Modality.Companion.convertFromFlags(false, method.isAbstract(), !method.isFinal()), UtilsKt.toDescriptorVisibility(method.getVisibility()), effectiveSignature.getReceiverType() != null ? MapsKt.mapOf(TuplesKt.to(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER, CollectionsKt.first(valueParameters.getDescriptors()))) : MapsKt.emptyMap());
        functionDescriptorImpl.setParameterNamesStatus(effectiveSignature.getHasStableParameterNames(), valueParameters.getHasSynthesizedNames());
        if (!((Collection)effectiveSignature.getErrors()).isEmpty()) {
            c2.getComponents().getSignaturePropagator().reportSignatureErrors(functionDescriptorImpl, effectiveSignature.getErrors());
        }
        return functionDescriptorImpl;
    }

    @NotNull
    protected final KotlinType computeMethodReturnType(@NotNull JavaMethod method, @NotNull LazyJavaResolverContext c2) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(c2, "c");
        boolean annotationMethod = method.getContainingClass().isAnnotationType();
        JavaTypeAttributes returnTypeAttrs = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, annotationMethod, false, null, 6, null);
        return c2.getTypeResolver().transformJavaType(method.getReturnType(), returnTypeAttrs);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    protected final ResolvedValueParameters resolveValueParameters(@NotNull LazyJavaResolverContext c2, @NotNull FunctionDescriptor function, @NotNull List<? extends JavaValueParameter> jValueParameters) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(function, "function");
        Intrinsics.checkNotNullParameter(jValueParameters, "jValueParameters");
        boolean synthesizedNames = false;
        Iterable $this$map$iv = CollectionsKt.withIndex((Iterable)jValueParameters);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Name name;
            Pair<KotlinType, Object> pair;
            IndexedValue indexedValue = (IndexedValue)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            int index = indexedValue.component1();
            JavaValueParameter javaParameter = (JavaValueParameter)indexedValue.component2();
            Annotations annotations = LazyJavaAnnotationsKt.resolveAnnotations(c2, javaParameter);
            JavaTypeAttributes typeUsage = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null);
            if (javaParameter.isVararg()) {
                JavaArrayType paramType;
                JavaType javaType = javaParameter.getType();
                if ((javaType instanceof JavaArrayType ? (JavaArrayType)javaType : null) == null) {
                    throw new AssertionError((Object)("Vararg parameter should be an array: " + javaParameter));
                }
                paramType = paramType;
                KotlinType outType = c2.getTypeResolver().transformArrayType(paramType, typeUsage, true);
                pair = TuplesKt.to(outType, c2.getModule().getBuiltIns().getArrayElementType(outType));
            } else {
                pair = TuplesKt.to(c2.getTypeResolver().transformJavaType(javaParameter.getType(), typeUsage), null);
            }
            Pair<KotlinType, Object> pair2 = pair;
            KotlinType outType = pair2.component1();
            KotlinType varargElementType = pair2.component2();
            if (Intrinsics.areEqual(function.getName().asString(), "equals") && jValueParameters.size() == 1 && Intrinsics.areEqual(c2.getModule().getBuiltIns().getNullableAnyType(), outType)) {
                name = Name.identifier("other");
            } else {
                Name javaName = javaParameter.getName();
                if (javaName == null) {
                    synthesizedNames = true;
                }
                if ((name = javaName) == null) {
                    Name name2 = Name.identifier("" + 'p' + index);
                    name = name2;
                    Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
                }
            }
            Name name3 = name;
            Intrinsics.checkNotNull(name3);
            Name name4 = name3;
            collection.add(new ValueParameterDescriptorImpl(function, null, index, annotations, name4, outType, false, false, false, varargElementType, c2.getComponents().getSourceElementFactory().source(javaParameter)));
        }
        List descriptors = CollectionsKt.toList((List)destination$iv$iv);
        return new ResolvedValueParameters(descriptors, synthesizedNames);
    }

    private final Set<Name> getFunctionNamesLazy() {
        return (Set)StorageKt.getValue(this.functionNamesLazy$delegate, (Object)this, $$delegatedProperties[0]);
    }

    private final Set<Name> getPropertyNamesLazy() {
        return (Set)StorageKt.getValue(this.propertyNamesLazy$delegate, (Object)this, $$delegatedProperties[1]);
    }

    private final Set<Name> getClassNamesLazy() {
        return (Set)StorageKt.getValue(this.classNamesLazy$delegate, (Object)this, $$delegatedProperties[2]);
    }

    @Override
    @NotNull
    public Set<Name> getFunctionNames() {
        return this.getFunctionNamesLazy();
    }

    @Override
    @NotNull
    public Set<Name> getVariableNames() {
        return this.getPropertyNamesLazy();
    }

    @Override
    @NotNull
    public Set<Name> getClassifierNames() {
        return this.getClassNamesLazy();
    }

    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        if (!this.getFunctionNames().contains(name)) {
            return CollectionsKt.emptyList();
        }
        return (Collection)this.functions.invoke(name);
    }

    @NotNull
    protected abstract Set<Name> computeFunctionNames(@NotNull DescriptorKindFilter var1, @Nullable Function1<? super Name, Boolean> var2);

    protected abstract void computeNonDeclaredProperties(@NotNull Name var1, @NotNull Collection<PropertyDescriptor> var2);

    @NotNull
    protected abstract Set<Name> computePropertyNames(@NotNull DescriptorKindFilter var1, @Nullable Function1<? super Name, Boolean> var2);

    private final PropertyDescriptor resolveProperty(JavaField field) {
        Ref.ObjectRef propertyDescriptor = new Ref.ObjectRef();
        propertyDescriptor.element = this.createPropertyDescriptor(field);
        ((PropertyDescriptorImpl)propertyDescriptor.element).initialize(null, null, null, null);
        KotlinType propertyType = this.getPropertyType(field);
        ((PropertyDescriptorImpl)propertyDescriptor.element).setType(propertyType, CollectionsKt.emptyList(), this.getDispatchReceiverParameter(), null, CollectionsKt.<ReceiverParameterDescriptor>emptyList());
        DeclarationDescriptor declarationDescriptor = this.getOwnerDescriptor();
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor)declarationDescriptor : null;
        if (classDescriptor != null) {
            ClassDescriptor classDescriptor2 = classDescriptor;
            boolean bl2 = false;
            propertyDescriptor.element = this.c.getComponents().getSyntheticPartsProvider().modifyField(classDescriptor2, (PropertyDescriptorImpl)propertyDescriptor.element, this.c);
        }
        if (DescriptorUtils.shouldRecordInitializerForProperty((VariableDescriptor)propertyDescriptor.element, ((PropertyDescriptorImpl)propertyDescriptor.element).getType())) {
            Ref.ObjectRef objectRef = propertyDescriptor;
            JavaField javaField = field;
            LazyJavaScope lazyJavaScope = this;
            ((PropertyDescriptorImpl)propertyDescriptor.element).setCompileTimeInitializerFactory(new LazyJavaScope$$Lambda$10(lazyJavaScope, javaField, objectRef));
        }
        this.c.getComponents().getJavaResolverCache().recordField(field, (PropertyDescriptor)propertyDescriptor.element);
        return (PropertyDescriptor)propertyDescriptor.element;
    }

    private final PropertyDescriptorImpl createPropertyDescriptor(JavaField field) {
        boolean isVar = !field.isFinal();
        Annotations annotations = LazyJavaAnnotationsKt.resolveAnnotations(this.c, field);
        JavaPropertyDescriptor javaPropertyDescriptor = JavaPropertyDescriptor.create(this.getOwnerDescriptor(), annotations, Modality.FINAL, UtilsKt.toDescriptorVisibility(field.getVisibility()), isVar, field.getName(), this.c.getComponents().getSourceElementFactory().source(field), this.isFinalStatic(field));
        Intrinsics.checkNotNullExpressionValue(javaPropertyDescriptor, "create(...)");
        return javaPropertyDescriptor;
    }

    private final boolean isFinalStatic(JavaField $this$isFinalStatic) {
        return $this$isFinalStatic.isFinal() && $this$isFinalStatic.isStatic();
    }

    private final KotlinType getPropertyType(JavaField field) {
        boolean isNotNullable;
        KotlinType propertyType = this.c.getTypeResolver().transformJavaType(field.getType(), JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null));
        boolean bl2 = isNotNullable = (KotlinBuiltIns.isPrimitiveType(propertyType) || KotlinBuiltIns.isString(propertyType)) && this.isFinalStatic(field) && field.getHasConstantNotNullInitializer();
        if (isNotNullable) {
            KotlinType kotlinType = TypeUtils.makeNotNullable(propertyType);
            Intrinsics.checkNotNullExpressionValue(kotlinType, "makeNotNullable(...)");
            return kotlinType;
        }
        return propertyType;
    }

    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        if (!this.getVariableNames().contains(name)) {
            return CollectionsKt.emptyList();
        }
        return (Collection)this.properties.invoke(name);
    }

    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return (Collection)this.allDescriptors.invoke();
    }

    @NotNull
    protected final List<DeclarationDescriptor> computeDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        NoLookupLocation location = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet<CallableMemberDescriptor> result = new LinkedHashSet<CallableMemberDescriptor>();
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (Name name : this.computeClassNames(kindFilter, nameFilter)) {
                if (!nameFilter.invoke(name).booleanValue()) continue;
                kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull((Collection)result, this.getContributedClassifier(name, location));
            }
        }
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) && !kindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (Name name : this.computeFunctionNames(kindFilter, nameFilter)) {
                if (!nameFilter.invoke(name).booleanValue()) continue;
                result.addAll(this.getContributedFunctions(name, location));
            }
        }
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) && !kindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (Name name : this.computePropertyNames(kindFilter, nameFilter)) {
                if (!nameFilter.invoke(name).booleanValue()) continue;
                result.addAll(this.getContributedVariables(name, location));
            }
        }
        return CollectionsKt.toList((Iterable)result);
    }

    @NotNull
    protected abstract Set<Name> computeClassNames(@NotNull DescriptorKindFilter var1, @Nullable Function1<? super Name, Boolean> var2);

    @NotNull
    public String toString() {
        return "Lazy scope for " + this.getOwnerDescriptor();
    }

    private static final Collection allDescriptors$lambda$0(LazyJavaScope this$0) {
        return this$0.computeDescriptors(DescriptorKindFilter.ALL, MemberScope.Companion.getALL_NAME_FILTER());
    }

    private static final DeclaredMemberIndex declaredMemberIndex$lambda$1(LazyJavaScope this$0) {
        return this$0.computeMemberIndex();
    }

    private static final Collection declaredFunctions$lambda$2(LazyJavaScope this$0, Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this$0.mainScope != null) {
            return (Collection)this$0.mainScope.declaredFunctions.invoke(name);
        }
        List result = new ArrayList();
        for (JavaMethod method : ((DeclaredMemberIndex)this$0.declaredMemberIndex.invoke()).findMethodsByName(name)) {
            JavaMethodDescriptor descriptor2 = this$0.resolveMethodToFunctionDescriptor(method);
            if (!this$0.isVisibleAsFunction(descriptor2)) continue;
            this$0.c.getComponents().getJavaResolverCache().recordMethod(method, descriptor2);
            result.add(descriptor2);
        }
        this$0.computeImplicitlyDeclaredFunctions(result, name);
        return result;
    }

    private static final PropertyDescriptor declaredField$lambda$3(LazyJavaScope this$0, Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this$0.mainScope != null) {
            return (PropertyDescriptor)this$0.mainScope.declaredField.invoke(name);
        }
        JavaField field = ((DeclaredMemberIndex)this$0.declaredMemberIndex.invoke()).findFieldByName(name);
        return field != null && !field.isEnumEntry() ? this$0.resolveProperty(field) : null;
    }

    private static final Collection functions$lambda$4(LazyJavaScope this$0, Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        LinkedHashSet result = new LinkedHashSet((Collection)this$0.declaredFunctions.invoke(name));
        this$0.retainMostSpecificMethods(result);
        this$0.computeNonDeclaredFunctions(result, name);
        return CollectionsKt.toList(this$0.c.getComponents().getSignatureEnhancement().enhanceSignatures(this$0.c, result));
    }

    private static final CallableDescriptor retainMostSpecificMethods$lambda$6(SimpleFunctionDescriptor $this$selectMostSpecificInEachOverridableGroup) {
        Intrinsics.checkNotNullParameter($this$selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return $this$selectMostSpecificInEachOverridableGroup;
    }

    private static final Set functionNamesLazy_delegate$lambda$10(LazyJavaScope this$0) {
        return this$0.computeFunctionNames(DescriptorKindFilter.FUNCTIONS, null);
    }

    private static final Set propertyNamesLazy_delegate$lambda$11(LazyJavaScope this$0) {
        return this$0.computePropertyNames(DescriptorKindFilter.VARIABLES, null);
    }

    private static final Set classNamesLazy_delegate$lambda$12(LazyJavaScope this$0) {
        return this$0.computeClassNames(DescriptorKindFilter.CLASSIFIERS, null);
    }

    private static final List properties$lambda$13(LazyJavaScope this$0, Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        ArrayList properties = new ArrayList();
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(properties, this$0.declaredField.invoke(name));
        this$0.computeNonDeclaredProperties(name, properties);
        return DescriptorUtils.isAnnotationClass(this$0.getOwnerDescriptor()) ? CollectionsKt.toList(properties) : CollectionsKt.toList(this$0.c.getComponents().getSignatureEnhancement().enhanceSignatures(this$0.c, properties));
    }

    private static final ConstantValue resolveProperty$lambda$16$lambda$15(LazyJavaScope this$0, JavaField $field, Ref.ObjectRef $propertyDescriptor) {
        return this$0.c.getComponents().getJavaPropertyInitializerEvaluator().getInitializerConstant($field, (PropertyDescriptor)$propertyDescriptor.element);
    }

    private static final NullableLazyValue resolveProperty$lambda$16(LazyJavaScope this$0, JavaField $field, Ref.ObjectRef $propertyDescriptor) {
        Ref.ObjectRef objectRef = $propertyDescriptor;
        JavaField javaField = $field;
        LazyJavaScope lazyJavaScope = this$0;
        return this$0.c.getStorageManager().createNullableLazyValue(new LazyJavaScope$$Lambda$11(lazyJavaScope, javaField, objectRef));
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LazyJavaScope.class, "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;", 0)), Reflection.property1(new PropertyReference1Impl(LazyJavaScope.class, "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;", 0)), Reflection.property1(new PropertyReference1Impl(LazyJavaScope.class, "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ Collection accessor$LazyJavaScope$lambda0(LazyJavaScope lazyJavaScope) {
        return LazyJavaScope.allDescriptors$lambda$0(lazyJavaScope);
    }

    static /* synthetic */ DeclaredMemberIndex accessor$LazyJavaScope$lambda1(LazyJavaScope lazyJavaScope) {
        return LazyJavaScope.declaredMemberIndex$lambda$1(lazyJavaScope);
    }

    static /* synthetic */ Collection accessor$LazyJavaScope$lambda2(LazyJavaScope lazyJavaScope, Name name) {
        return LazyJavaScope.declaredFunctions$lambda$2(lazyJavaScope, name);
    }

    static /* synthetic */ PropertyDescriptor accessor$LazyJavaScope$lambda3(LazyJavaScope lazyJavaScope, Name name) {
        return LazyJavaScope.declaredField$lambda$3(lazyJavaScope, name);
    }

    static /* synthetic */ Collection accessor$LazyJavaScope$lambda4(LazyJavaScope lazyJavaScope, Name name) {
        return LazyJavaScope.functions$lambda$4(lazyJavaScope, name);
    }

    static /* synthetic */ Set accessor$LazyJavaScope$lambda5(LazyJavaScope lazyJavaScope) {
        return LazyJavaScope.functionNamesLazy_delegate$lambda$10(lazyJavaScope);
    }

    static /* synthetic */ Set accessor$LazyJavaScope$lambda6(LazyJavaScope lazyJavaScope) {
        return LazyJavaScope.propertyNamesLazy_delegate$lambda$11(lazyJavaScope);
    }

    static /* synthetic */ Set accessor$LazyJavaScope$lambda7(LazyJavaScope lazyJavaScope) {
        return LazyJavaScope.classNamesLazy_delegate$lambda$12(lazyJavaScope);
    }

    static /* synthetic */ List accessor$LazyJavaScope$lambda8(LazyJavaScope lazyJavaScope, Name name) {
        return LazyJavaScope.properties$lambda$13(lazyJavaScope, name);
    }

    static /* synthetic */ CallableDescriptor accessor$LazyJavaScope$lambda9(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        return LazyJavaScope.retainMostSpecificMethods$lambda$6(simpleFunctionDescriptor);
    }

    static /* synthetic */ NullableLazyValue accessor$LazyJavaScope$lambda10(LazyJavaScope lazyJavaScope, JavaField javaField, Ref.ObjectRef objectRef) {
        return LazyJavaScope.resolveProperty$lambda$16(lazyJavaScope, javaField, objectRef);
    }

    static /* synthetic */ ConstantValue accessor$LazyJavaScope$lambda11(LazyJavaScope lazyJavaScope, JavaField javaField, Ref.ObjectRef objectRef) {
        return LazyJavaScope.resolveProperty$lambda$16$lambda$15(lazyJavaScope, javaField, objectRef);
    }

    protected static final class MethodSignatureData {
        @NotNull
        private final KotlinType returnType;
        @Nullable
        private final KotlinType receiverType;
        @NotNull
        private final List<ValueParameterDescriptor> valueParameters;
        @NotNull
        private final List<TypeParameterDescriptor> typeParameters;
        private final boolean hasStableParameterNames;
        @NotNull
        private final List<String> errors;

        public MethodSignatureData(@NotNull KotlinType returnType, @Nullable KotlinType receiverType, @NotNull List<? extends ValueParameterDescriptor> valueParameters, @NotNull List<? extends TypeParameterDescriptor> typeParameters, boolean hasStableParameterNames, @NotNull List<String> errors) {
            Intrinsics.checkNotNullParameter(returnType, "returnType");
            Intrinsics.checkNotNullParameter(valueParameters, "valueParameters");
            Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
            Intrinsics.checkNotNullParameter(errors, "errors");
            this.returnType = returnType;
            this.receiverType = receiverType;
            this.valueParameters = valueParameters;
            this.typeParameters = typeParameters;
            this.hasStableParameterNames = hasStableParameterNames;
            this.errors = errors;
        }

        @NotNull
        public final KotlinType getReturnType() {
            return this.returnType;
        }

        @Nullable
        public final KotlinType getReceiverType() {
            return this.receiverType;
        }

        @NotNull
        public final List<ValueParameterDescriptor> getValueParameters() {
            return this.valueParameters;
        }

        @NotNull
        public final List<TypeParameterDescriptor> getTypeParameters() {
            return this.typeParameters;
        }

        public final boolean getHasStableParameterNames() {
            return this.hasStableParameterNames;
        }

        @NotNull
        public final List<String> getErrors() {
            return this.errors;
        }

        @NotNull
        public String toString() {
            return "MethodSignatureData(returnType=" + this.returnType + ", receiverType=" + this.receiverType + ", valueParameters=" + this.valueParameters + ", typeParameters=" + this.typeParameters + ", hasStableParameterNames=" + this.hasStableParameterNames + ", errors=" + this.errors + ')';
        }

        public int hashCode() {
            int result = this.returnType.hashCode();
            result = result * 31 + (this.receiverType == null ? 0 : this.receiverType.hashCode());
            result = result * 31 + ((Object)this.valueParameters).hashCode();
            result = result * 31 + ((Object)this.typeParameters).hashCode();
            result = result * 31 + Boolean.hashCode(this.hasStableParameterNames);
            result = result * 31 + ((Object)this.errors).hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MethodSignatureData)) {
                return false;
            }
            MethodSignatureData methodSignatureData = (MethodSignatureData)other;
            if (!Intrinsics.areEqual(this.returnType, methodSignatureData.returnType)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.receiverType, methodSignatureData.receiverType)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.valueParameters, methodSignatureData.valueParameters)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.typeParameters, methodSignatureData.typeParameters)) {
                return false;
            }
            if (this.hasStableParameterNames != methodSignatureData.hasStableParameterNames) {
                return false;
            }
            return Intrinsics.areEqual(this.errors, methodSignatureData.errors);
        }
    }

    protected static final class ResolvedValueParameters {
        @NotNull
        private final List<ValueParameterDescriptor> descriptors;
        private final boolean hasSynthesizedNames;

        public ResolvedValueParameters(@NotNull List<? extends ValueParameterDescriptor> descriptors, boolean hasSynthesizedNames) {
            Intrinsics.checkNotNullParameter(descriptors, "descriptors");
            this.descriptors = descriptors;
            this.hasSynthesizedNames = hasSynthesizedNames;
        }

        @NotNull
        public final List<ValueParameterDescriptor> getDescriptors() {
            return this.descriptors;
        }

        public final boolean getHasSynthesizedNames() {
            return this.hasSynthesizedNames;
        }
    }
}

