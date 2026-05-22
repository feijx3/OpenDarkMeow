/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.FallbackBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$4;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$5;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$6;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$7;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$8;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizerKt;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSignatures;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.MappingUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilterKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nJvmBuiltInsCustomizer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmBuiltInsCustomizer.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,376:1\n1761#2,3:377\n1617#2,9:380\n1869#2:389\n1870#2:391\n1626#2:392\n1563#2:393\n1634#2,3:394\n774#2:397\n865#2:398\n1761#2,3:399\n866#2:402\n774#2:403\n865#2:404\n2746#2,3:405\n866#2:408\n1563#2:409\n1634#2,3:410\n1761#2,3:413\n1617#2,9:416\n1869#2:425\n1870#2:427\n1626#2:428\n1#3:390\n1#3:426\n*S KotlinDebug\n*F\n+ 1 JvmBuiltInsCustomizer.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer\n*L\n120#1:377,3\n136#1:380,9\n136#1:389\n136#1:391\n136#1:392\n195#1:393\n195#1:394,3\n209#1:397\n209#1:398\n214#1:399,3\n209#1:402\n317#1:403\n317#1:404\n319#1:405,3\n317#1:408\n326#1:409\n326#1:410,3\n353#1:413,3\n257#1:416,9\n257#1:425\n257#1:427\n257#1:428\n136#1:390\n257#1:426\n*E\n"})
public final class JvmBuiltInsCustomizer
implements AdditionalClassPartsProvider,
PlatformDependentDeclarationFilter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ModuleDescriptor moduleDescriptor;
    @NotNull
    private final JavaToKotlinClassMapper j2kClassMapper;
    @NotNull
    private final NotNullLazyValue settings$delegate;
    @NotNull
    private final KotlinType mockSerializableType;
    @NotNull
    private final NotNullLazyValue cloneableType$delegate;
    @NotNull
    private final CacheWithNotNullValues<FqName, ClassDescriptor> javaAnalogueClassesWithCustomSupertypeCache;
    @NotNull
    private final NotNullLazyValue notConsideredDeprecation$delegate;
    @NotNull
    private final MemoizedFunctionToNotNull<Pair<String, String>, Annotations> deprecationForSomeOfTheListMethods;

    public JvmBuiltInsCustomizer(@NotNull ModuleDescriptor moduleDescriptor, @NotNull StorageManager storageManager, @NotNull Function0<JvmBuiltIns.Settings> settingsComputation) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(settingsComputation, "settingsComputation");
        this.moduleDescriptor = moduleDescriptor;
        this.j2kClassMapper = JavaToKotlinClassMapper.INSTANCE;
        this.settings$delegate = storageManager.createLazyValue(settingsComputation);
        this.mockSerializableType = this.createMockJavaIoSerializableType(storageManager);
        Object object = storageManager;
        JvmBuiltInsCustomizer jvmBuiltInsCustomizer = this;
        this.cloneableType$delegate = storageManager.createLazyValue(new JvmBuiltInsCustomizer$$Lambda$0(jvmBuiltInsCustomizer, (StorageManager)object));
        this.javaAnalogueClassesWithCustomSupertypeCache = storageManager.createCacheWithNotNullValues();
        object = this;
        this.notConsideredDeprecation$delegate = storageManager.createLazyValue(new JvmBuiltInsCustomizer$$Lambda$1((JvmBuiltInsCustomizer)object));
        object = this;
        this.deprecationForSomeOfTheListMethods = storageManager.createMemoizedFunction(new JvmBuiltInsCustomizer$$Lambda$2((JvmBuiltInsCustomizer)object));
    }

    private final JvmBuiltIns.Settings getSettings() {
        return (JvmBuiltIns.Settings)StorageKt.getValue(this.settings$delegate, (Object)this, $$delegatedProperties[0]);
    }

    private final SimpleType getCloneableType() {
        return (SimpleType)StorageKt.getValue(this.cloneableType$delegate, (Object)this, $$delegatedProperties[1]);
    }

    private final Annotations getNotConsideredDeprecation() {
        return (Annotations)StorageKt.getValue(this.notConsideredDeprecation$delegate, (Object)this, $$delegatedProperties[2]);
    }

    private final KotlinType createMockJavaIoSerializableType(StorageManager $this$createMockJavaIoSerializableType) {
        ModuleDescriptor moduleDescriptor = this.moduleDescriptor;
        FqName fqName = new FqName("java.io");
        PackageFragmentDescriptorImpl mockJavaIoPackageFragment2 = new PackageFragmentDescriptorImpl(moduleDescriptor, fqName){

            public MemberScope.Empty getMemberScope() {
                return MemberScope.Empty.INSTANCE;
            }
        };
        JvmBuiltInsCustomizer jvmBuiltInsCustomizer = this;
        List<LazyWrappedType> superTypes = CollectionsKt.listOf(new LazyWrappedType($this$createMockJavaIoSerializableType, new JvmBuiltInsCustomizer$$Lambda$3(jvmBuiltInsCustomizer)));
        ClassDescriptorImpl mockSerializableClass = new ClassDescriptorImpl(mockJavaIoPackageFragment2, Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, (Collection<KotlinType>)superTypes, SourceElement.NO_SOURCE, false, $this$createMockJavaIoSerializableType);
        mockSerializableClass.initialize(MemberScope.Empty.INSTANCE, SetsKt.<ClassConstructorDescriptor>emptySet(), null);
        SimpleType simpleType = mockSerializableClass.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(simpleType, "getDefaultType(...)");
        return simpleType;
    }

    @Override
    @NotNull
    public Collection<KotlinType> getSupertypes(@NotNull ClassDescriptor classDescriptor) {
        Collection collection;
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        FqNameUnsafe fqName = DescriptorUtilsKt.getFqNameUnsafe(classDescriptor);
        if (JvmBuiltInsSignatures.INSTANCE.isArrayOrPrimitiveArray(fqName)) {
            KotlinType[] kotlinTypeArray = new KotlinType[]{this.getCloneableType(), this.mockSerializableType};
            collection = CollectionsKt.listOf(kotlinTypeArray);
        } else {
            collection = JvmBuiltInsSignatures.INSTANCE.isSerializableInJava(fqName) ? (Collection)CollectionsKt.listOf(this.mockSerializableType) : (Collection)CollectionsKt.emptyList();
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    @Override
    @NotNull
    public Collection<SimpleFunctionDescriptor> getFunctions(@NotNull Name name, @NotNull ClassDescriptor classDescriptor) {
        void $this$mapNotNullTo$iv$iv;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (Intrinsics.areEqual(name, CloneableClassScope.Companion.getCLONE_NAME()) && classDescriptor instanceof DeserializedClassDescriptor && KotlinBuiltIns.isArrayOrPrimitiveArray(classDescriptor)) {
            boolean bl2;
            block20: {
                List<ProtoBuf.Function> list = ((DeserializedClassDescriptor)classDescriptor).getClassProto().getFunctionList();
                Intrinsics.checkNotNullExpressionValue(list, "getFunctionList(...)");
                Iterable $this$any$iv = list;
                boolean $i$f$any = false;
                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                    bl2 = false;
                } else {
                    for (Object element$iv : $this$any$iv) {
                        ProtoBuf.Function functionProto = (ProtoBuf.Function)element$iv;
                        boolean bl3 = false;
                        if (!Intrinsics.areEqual(NameResolverUtilKt.getName(((DeserializedClassDescriptor)classDescriptor).getC().getNameResolver(), functionProto.getName()), CloneableClassScope.Companion.getCLONE_NAME())) continue;
                        bl2 = true;
                        break block20;
                    }
                    bl2 = false;
                }
            }
            if (bl2) {
                return CollectionsKt.emptyList();
            }
            return CollectionsKt.listOf(this.createCloneForArray((DeserializedClassDescriptor)classDescriptor, (SimpleFunctionDescriptor)CollectionsKt.single((Iterable)this.getCloneableType().getMemberScope().getContributedFunctions(name, NoLookupLocation.FROM_BUILTINS))));
        }
        if (!this.getSettings().isAdditionalBuiltInsFeatureSupported()) {
            return CollectionsKt.emptyList();
        }
        Name name2 = name;
        Iterable $this$mapNotNull$iv = this.getAdditionalFunctions(classDescriptor, new JvmBuiltInsCustomizer$$Lambda$4(name2));
        boolean $i$f$mapNotNull = false;
        Iterable iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (true) {
            SimpleFunctionDescriptor simpleFunctionDescriptor;
            block21: {
                Object element$iv$iv$iv;
                if (!iterator2.hasNext()) {
                    return (List)destination$iv$iv;
                }
                Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                boolean bl4 = false;
                SimpleFunctionDescriptor additionalMember = (SimpleFunctionDescriptor)element$iv$iv;
                boolean bl5 = false;
                DeclarationDescriptor declarationDescriptor = additionalMember.getContainingDeclaration();
                Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                Object object = additionalMember.substitute(MappingUtilKt.createMappedTypeParametersSubstitution((ClassDescriptor)declarationDescriptor, classDescriptor).buildSubstitutor());
                Intrinsics.checkNotNull(object, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
                SimpleFunctionDescriptor substitutedWithKotlinTypeParameters = (SimpleFunctionDescriptor)object;
                Object $this$getFunctions_u24lambda_u247_u24lambda_u246 = object = substitutedWithKotlinTypeParameters.newCopyBuilder();
                boolean bl6 = false;
                $this$getFunctions_u24lambda_u247_u24lambda_u246.setOwner(classDescriptor);
                $this$getFunctions_u24lambda_u247_u24lambda_u246.setDispatchReceiverParameter(classDescriptor.getThisAsReceiverParameter());
                $this$getFunctions_u24lambda_u247_u24lambda_u246.setPreserveSourceElement();
                JDKMemberStatus memberStatus = this.getJdkMethodStatus(additionalMember);
                switch (WhenMappings.$EnumSwitchMapping$0[memberStatus.ordinal()]) {
                    case 1: {
                        FunctionDescriptor.CopyBuilder copyBuilder;
                        if (ModalityUtilsKt.isFinalClass(classDescriptor)) {
                            simpleFunctionDescriptor = null;
                            break block21;
                        } else {
                            copyBuilder = $this$getFunctions_u24lambda_u247_u24lambda_u246.setHiddenForResolutionEverywhereBesideSupercalls();
                            break;
                        }
                    }
                    case 2: {
                        Annotations annotations;
                        Name name3 = additionalMember.getName();
                        if (Intrinsics.areEqual(name3, JvmBuiltInsCustomizerKt.access$getGET_FIRST_LIST_NAME$p())) {
                            annotations = (Annotations)this.deprecationForSomeOfTheListMethods.invoke(TuplesKt.to(additionalMember.getName().asString(), "first"));
                        } else {
                            if (!Intrinsics.areEqual(name3, JvmBuiltInsCustomizerKt.access$getGET_LAST_LIST_NAME$p())) {
                                throw new IllegalStateException(("Unexpected name: " + additionalMember.getName()).toString());
                            }
                            annotations = (Annotations)this.deprecationForSomeOfTheListMethods.invoke(TuplesKt.to(additionalMember.getName().asString(), "last"));
                        }
                        FunctionDescriptor.CopyBuilder copyBuilder = $this$getFunctions_u24lambda_u247_u24lambda_u246.setAdditionalAnnotations(annotations);
                        break;
                    }
                    case 3: {
                        FunctionDescriptor.CopyBuilder copyBuilder = $this$getFunctions_u24lambda_u247_u24lambda_u246.setAdditionalAnnotations(this.getNotConsideredDeprecation());
                        break;
                    }
                    case 4: {
                        simpleFunctionDescriptor = null;
                        break block21;
                    }
                    case 5: {
                        FunctionDescriptor.CopyBuilder copyBuilder = Unit.INSTANCE;
                        break;
                    }
                    default: {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                Object d2 = object.build();
                Intrinsics.checkNotNull(d2);
                simpleFunctionDescriptor = (SimpleFunctionDescriptor)d2;
            }
            if (simpleFunctionDescriptor == null) continue;
            SimpleFunctionDescriptor it$iv$iv = simpleFunctionDescriptor;
            boolean bl7 = false;
            destination$iv$iv.add(it$iv$iv);
        }
    }

    @NotNull
    public Set<Name> getFunctionsNames(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (!this.getSettings().isAdditionalBuiltInsFeatureSupported()) {
            return SetsKt.emptySet();
        }
        Object object = this.getJavaAnalogue(classDescriptor);
        if (object == null || (object = ((LazyJavaClassDescriptor)object).getUnsubstitutedMemberScope()) == null || (object = ((LazyJavaScope)object).getFunctionNames()) == null) {
            object = SetsKt.emptySet();
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    private final Collection<SimpleFunctionDescriptor> getAdditionalFunctions(ClassDescriptor classDescriptor, Function1<? super MemberScope, ? extends Collection<? extends SimpleFunctionDescriptor>> functionsByScope) {
        void $this$filterTo$iv$iv;
        void $this$filter$iv;
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.getJavaAnalogue(classDescriptor);
        if (lazyJavaClassDescriptor == null) {
            return CollectionsKt.emptyList();
        }
        LazyJavaClassDescriptor javaAnalogueDescriptor = lazyJavaClassDescriptor;
        Collection<ClassDescriptor> kotlinClassDescriptors = this.j2kClassMapper.mapPlatformClass(DescriptorUtilsKt.getFqNameSafe(javaAnalogueDescriptor), FallbackBuiltIns.Companion.getInstance());
        ClassDescriptor classDescriptor2 = (ClassDescriptor)CollectionsKt.lastOrNull((Iterable)kotlinClassDescriptors);
        if (classDescriptor2 == null) {
            return CollectionsKt.emptyList();
        }
        ClassDescriptor kotlinMutableClassIfContainer = classDescriptor2;
        Iterable iterable = kotlinClassDescriptors;
        SmartSet.Companion companion = SmartSet.Companion;
        boolean $i$f$map = false;
        void var9_11 = $this$map$iv;
        Iterable destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            ClassDescriptor classDescriptor3 = (ClassDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(DescriptorUtilsKt.getFqNameSafe((DeclarationDescriptor)it));
        }
        SmartSet kotlinVersions = companion.create((List)destination$iv$iv);
        boolean isMutable = this.j2kClassMapper.isMutable(classDescriptor);
        ClassDescriptor classDescriptor4 = kotlinMutableClassIfContainer;
        LazyJavaClassDescriptor lazyJavaClassDescriptor2 = javaAnalogueDescriptor;
        ClassDescriptor fakeJavaClassDescriptor = this.javaAnalogueClassesWithCustomSupertypeCache.computeIfAbsent(DescriptorUtilsKt.getFqNameSafe(javaAnalogueDescriptor), new JvmBuiltInsCustomizer$$Lambda$5(lazyJavaClassDescriptor2, classDescriptor4));
        MemberScope memberScope = fakeJavaClassDescriptor.getUnsubstitutedMemberScope();
        Intrinsics.checkNotNullExpressionValue(memberScope, "getUnsubstitutedMemberScope(...)");
        MemberScope scope = memberScope;
        destination$iv$iv = functionsByScope.invoke(scope);
        boolean $i$f$filter = false;
        Iterator iterator2 = $this$filter$iv;
        Collection destination$iv$iv2 = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            boolean bl3;
            SimpleFunctionDescriptor analogueMember = (SimpleFunctionDescriptor)element$iv$iv;
            boolean bl4 = false;
            if (analogueMember.getKind() != CallableMemberDescriptor.Kind.DECLARATION) {
                bl3 = false;
            } else if (!analogueMember.getVisibility().isPublicAPI()) {
                bl3 = false;
            } else if (KotlinBuiltIns.isDeprecated(analogueMember)) {
                bl3 = false;
            } else {
                boolean bl5;
                block13: {
                    Collection<? extends FunctionDescriptor> collection = analogueMember.getOverriddenDescriptors();
                    Intrinsics.checkNotNullExpressionValue(collection, "getOverriddenDescriptors(...)");
                    Iterable $this$any$iv = collection;
                    boolean $i$f$any = false;
                    if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                        bl5 = false;
                    } else {
                        for (Object element$iv : $this$any$iv) {
                            FunctionDescriptor it = (FunctionDescriptor)element$iv;
                            boolean bl6 = false;
                            DeclarationDescriptor declarationDescriptor = it.getContainingDeclaration();
                            Intrinsics.checkNotNullExpressionValue(declarationDescriptor, "getContainingDeclaration(...)");
                            if (!kotlinVersions.contains(DescriptorUtilsKt.getFqNameSafe(declarationDescriptor))) continue;
                            bl5 = true;
                            break block13;
                        }
                        bl5 = false;
                    }
                }
                bl3 = bl5 ? false : !this.isMutabilityViolation(analogueMember, isMutable);
            }
            if (!bl3) continue;
            destination$iv$iv2.add(element$iv$iv);
        }
        return (List)destination$iv$iv2;
    }

    private final SimpleFunctionDescriptor createCloneForArray(DeserializedClassDescriptor arrayClassDescriptor, SimpleFunctionDescriptor cloneFromCloneable) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> copyBuilder;
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> $this$createCloneForArray_u24lambda_u2412 = copyBuilder = cloneFromCloneable.newCopyBuilder();
        boolean bl2 = false;
        $this$createCloneForArray_u24lambda_u2412.setOwner(arrayClassDescriptor);
        $this$createCloneForArray_u24lambda_u2412.setVisibility(DescriptorVisibilities.PUBLIC);
        $this$createCloneForArray_u24lambda_u2412.setReturnType(arrayClassDescriptor.getDefaultType());
        $this$createCloneForArray_u24lambda_u2412.setDispatchReceiverParameter(arrayClassDescriptor.getThisAsReceiverParameter());
        SimpleFunctionDescriptor simpleFunctionDescriptor = copyBuilder.build();
        Intrinsics.checkNotNull(simpleFunctionDescriptor);
        return simpleFunctionDescriptor;
    }

    private final boolean isMutabilityViolation(SimpleFunctionDescriptor $this$isMutabilityViolation, boolean isMutable) {
        DeclarationDescriptor declarationDescriptor = $this$isMutabilityViolation.getContainingDeclaration();
        Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor owner = (ClassDescriptor)declarationDescriptor;
        String jvmDescriptor = MethodSignatureMappingKt.computeJvmDescriptor$default($this$isMutabilityViolation, false, false, 3, null);
        if (JvmBuiltInsSignatures.INSTANCE.getMUTABLE_METHOD_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, owner, jvmDescriptor)) ^ isMutable) {
            return true;
        }
        JvmBuiltInsCustomizer jvmBuiltInsCustomizer = this;
        Boolean bl2 = DFS.ifAny((Collection)CollectionsKt.listOf($this$isMutabilityViolation), JvmBuiltInsCustomizer$$Lambda$6.INSTANCE, new JvmBuiltInsCustomizer$$Lambda$7(jvmBuiltInsCustomizer));
        Intrinsics.checkNotNullExpressionValue(bl2, "ifAny(...)");
        return bl2;
    }

    private final JDKMemberStatus getJdkMethodStatus(FunctionDescriptor $this$getJdkMethodStatus) {
        DeclarationDescriptor declarationDescriptor = $this$getJdkMethodStatus.getContainingDeclaration();
        Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor owner = (ClassDescriptor)declarationDescriptor;
        String jvmDescriptor = MethodSignatureMappingKt.computeJvmDescriptor$default($this$getJdkMethodStatus, false, false, 3, null);
        Ref.ObjectRef<JDKMemberStatus> result = new Ref.ObjectRef<JDKMemberStatus>();
        JvmBuiltInsCustomizer jvmBuiltInsCustomizer = this;
        Object r2 = DFS.dfs((Collection)CollectionsKt.listOf(owner), new JvmBuiltInsCustomizer$$Lambda$8(jvmBuiltInsCustomizer), new DFS.AbstractNodeHandler<ClassDescriptor, JDKMemberStatus>(jvmDescriptor, result){
            final /* synthetic */ String $jvmDescriptor;
            final /* synthetic */ Ref.ObjectRef<JDKMemberStatus> $result;
            {
                this.$jvmDescriptor = $jvmDescriptor;
                this.$result = $result;
            }

            public boolean beforeChildren(ClassDescriptor javaClassDescriptor) {
                String signature;
                Intrinsics.checkNotNullParameter(javaClassDescriptor, "javaClassDescriptor");
                String string = signature = MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, javaClassDescriptor, this.$jvmDescriptor);
                if (JvmBuiltInsSignatures.INSTANCE.getHIDDEN_METHOD_SIGNATURES().contains(string)) {
                    this.$result.element = JDKMemberStatus.HIDDEN;
                } else if (JvmBuiltInsSignatures.INSTANCE.getVISIBLE_METHOD_SIGNATURES().contains(string)) {
                    this.$result.element = JDKMemberStatus.VISIBLE;
                } else if (JvmBuiltInsSignatures.INSTANCE.getDEPRECATED_LIST_METHODS().contains(string)) {
                    this.$result.element = JDKMemberStatus.DEPRECATED_LIST_METHODS;
                } else if (JvmBuiltInsSignatures.INSTANCE.getDROP_LIST_METHOD_SIGNATURES().contains(string)) {
                    this.$result.element = JDKMemberStatus.DROP;
                }
                return this.$result.element == null;
            }

            public JDKMemberStatus result() {
                JDKMemberStatus jDKMemberStatus = (JDKMemberStatus)((Object)this.$result.element);
                if (jDKMemberStatus == null) {
                    jDKMemberStatus = JDKMemberStatus.NOT_CONSIDERED;
                }
                return jDKMemberStatus;
            }
        });
        Intrinsics.checkNotNullExpressionValue(r2, "dfs(...)");
        return (JDKMemberStatus)((Object)r2);
    }

    private final LazyJavaClassDescriptor getJavaAnalogue(ClassDescriptor $this$getJavaAnalogue) {
        if (KotlinBuiltIns.isAny($this$getJavaAnalogue)) {
            return null;
        }
        if (!KotlinBuiltIns.isUnderKotlinPackage($this$getJavaAnalogue)) {
            return null;
        }
        FqNameUnsafe fqName = DescriptorUtilsKt.getFqNameUnsafe($this$getJavaAnalogue);
        if (!fqName.isSafe()) {
            return null;
        }
        Object object = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqName);
        if (object == null || (object = ((ClassId)object).asSingleFqName()) == null) {
            return null;
        }
        Object javaAnalogueFqName = object;
        ClassDescriptor classDescriptor = DescriptorUtilKt.resolveClassByFqName(this.getSettings().getOwnerModuleDescriptor(), (FqName)javaAnalogueFqName, NoLookupLocation.FROM_BUILTINS);
        return classDescriptor instanceof LazyJavaClassDescriptor ? (LazyJavaClassDescriptor)classDescriptor : null;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (classDescriptor.getKind() != ClassKind.CLASS || !this.getSettings().isAdditionalBuiltInsFeatureSupported()) {
            return CollectionsKt.emptyList();
        }
        v0 = this.getJavaAnalogue(classDescriptor);
        if (v0 == null) {
            return CollectionsKt.emptyList();
        }
        javaAnalogueDescriptor = v0;
        v1 = JavaToKotlinClassMapper.mapJavaToKotlin$default(this.j2kClassMapper, DescriptorUtilsKt.getFqNameSafe(javaAnalogueDescriptor), FallbackBuiltIns.Companion.getInstance(), null, 4, null);
        if (v1 == null) {
            return CollectionsKt.emptyList();
        }
        defaultKotlinVersion = v1;
        substitutor = MappingUtilKt.createMappedTypeParametersSubstitution(defaultKotlinVersion, javaAnalogueDescriptor).buildSubstitutor();
        $this$filter$iv = javaAnalogueDescriptor.getConstructors();
        $i$f$filter = false;
        var7_7 = $this$filter$iv;
        destination$iv$iv = new ArrayList<E>();
        $i$f$filterTo = false;
        for (T element$iv$iv : $this$filterTo$iv$iv) {
            block11: {
                javaConstructor = (ClassConstructorDescriptor)element$iv$iv;
                $i$a$-filter-JvmBuiltInsCustomizer$getConstructors$1 = false;
                if (!javaConstructor.getVisibility().isPublicAPI()) ** GOTO lbl-1000
                v2 = defaultKotlinVersion.getConstructors();
                Intrinsics.checkNotNullExpressionValue(v2, "getConstructors(...)");
                $this$none$iv = v2;
                $i$f$none = false;
                if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                    v3 = true;
                } else {
                    for (T element$iv : $this$none$iv) {
                        it = (ClassConstructorDescriptor)element$iv;
                        $i$a$-none-JvmBuiltInsCustomizer$getConstructors$1$1 = false;
                        Intrinsics.checkNotNull(it);
                        if (!JvmBuiltInsCustomizer.getConstructors$isEffectivelyTheSameAs(it, substitutor, javaConstructor)) continue;
                        v3 = false;
                        break block11;
                    }
                    v3 = true;
                }
            }
            if (v3 && !this.isTrivialCopyConstructorFor(javaConstructor, classDescriptor) && !KotlinBuiltIns.isDeprecated(javaConstructor) && !JvmBuiltInsSignatures.INSTANCE.getHIDDEN_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, javaAnalogueDescriptor, MethodSignatureMappingKt.computeJvmDescriptor$default(javaConstructor, false, false, 3, null)))) {
                v4 = true;
            } else lbl-1000:
            // 2 sources

            {
                v4 = false;
            }
            if (!v4) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        $i$f$map = false;
        $this$filterTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        $i$f$mapTo = false;
        for (T item$iv$iv : $this$mapTo$iv$iv) {
            javaConstructor = (ClassConstructorDescriptor)item$iv$iv;
            var20_22 = destination$iv$iv;
            $i$a$-map-JvmBuiltInsCustomizer$getConstructors$2 = false;
            $this$getConstructors_u24lambda_u2420_u24lambda_u2419 = var14_14 = javaConstructor.newCopyBuilder();
            $i$a$-apply-JvmBuiltInsCustomizer$getConstructors$2$1 = false;
            $this$getConstructors_u24lambda_u2420_u24lambda_u2419.setOwner(classDescriptor);
            $this$getConstructors_u24lambda_u2420_u24lambda_u2419.setReturnType(classDescriptor.getDefaultType());
            $this$getConstructors_u24lambda_u2420_u24lambda_u2419.setPreserveSourceElement();
            $this$getConstructors_u24lambda_u2420_u24lambda_u2419.setSubstitution(substitutor.getSubstitution());
            if (!JvmBuiltInsSignatures.INSTANCE.getVISIBLE_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, javaAnalogueDescriptor, MethodSignatureMappingKt.computeJvmDescriptor$default(javaConstructor, false, false, 3, null)))) {
                $this$getConstructors_u24lambda_u2420_u24lambda_u2419.setAdditionalAnnotations(this.getNotConsideredDeprecation());
            }
            var17_19 = var14_14.build();
            Intrinsics.checkNotNull(var17_19, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
            var20_22.add((ClassConstructorDescriptor)var17_19);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean isFunctionAvailable(@NotNull ClassDescriptor classDescriptor, @NotNull SimpleFunctionDescriptor functionDescriptor) {
        boolean bl2;
        block6: {
            void $this$any$iv;
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            LazyJavaClassDescriptor lazyJavaClassDescriptor = this.getJavaAnalogue(classDescriptor);
            if (lazyJavaClassDescriptor == null) {
                return true;
            }
            LazyJavaClassDescriptor javaAnalogueClassDescriptor = lazyJavaClassDescriptor;
            if (!functionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME())) {
                return true;
            }
            if (!this.getSettings().isAdditionalBuiltInsFeatureSupported()) {
                return false;
            }
            String jvmDescriptor = MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 3, null);
            LazyJavaClassMemberScope lazyJavaClassMemberScope = javaAnalogueClassDescriptor.getUnsubstitutedMemberScope();
            Name name = functionDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            Iterable iterable = lazyJavaClassMemberScope.getContributedFunctions(name, NoLookupLocation.FROM_BUILTINS);
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv;
                    boolean bl3 = false;
                    if (!Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default(it, false, false, 3, null), jvmDescriptor)) continue;
                    bl2 = true;
                    break block6;
                }
                bl2 = false;
            }
        }
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean isTrivialCopyConstructorFor(ConstructorDescriptor $this$isTrivialCopyConstructorFor, ClassDescriptor classDescriptor) {
        if ($this$isTrivialCopyConstructorFor.getValueParameters().size() != 1) return false;
        List<ValueParameterDescriptor> list = $this$isTrivialCopyConstructorFor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
        ClassifierDescriptor classifierDescriptor = CollectionsKt.single(list).getType().getConstructor().getDeclarationDescriptor();
        if (!Intrinsics.areEqual(classifierDescriptor != null ? DescriptorUtilsKt.getFqNameUnsafe(classifierDescriptor) : null, DescriptorUtilsKt.getFqNameUnsafe(classDescriptor))) return false;
        return true;
    }

    private static final SimpleType cloneableType_delegate$lambda$0(JvmBuiltInsCustomizer this$0, StorageManager $storageManager) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this$0.getSettings().getOwnerModuleDescriptor(), JvmBuiltInClassDescriptorFactory.Companion.getCLONEABLE_CLASS_ID(), new NotFoundClasses($storageManager, this$0.getSettings().getOwnerModuleDescriptor())).getDefaultType();
    }

    private static final Annotations notConsideredDeprecation_delegate$lambda$1(JvmBuiltInsCustomizer this$0) {
        AnnotationDescriptor annotation = AnnotationUtilKt.createDeprecatedAnnotation$default(this$0.moduleDescriptor.getBuiltIns(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, true, 6, null);
        return Annotations.Companion.create(CollectionsKt.listOf(annotation));
    }

    private static final Annotations deprecationForSomeOfTheListMethods$lambda$2(JvmBuiltInsCustomizer this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        String methodName = (String)pair.component1();
        String extensionName = (String)pair.component2();
        KotlinBuiltIns kotlinBuiltIns = this$0.moduleDescriptor.getBuiltIns();
        String string = '\'' + methodName + "()' member of List is redundant in Kotlin and might be removed soon. Please use '" + extensionName + "()' stdlib extension instead";
        String string2 = extensionName + "()";
        AnnotationDescriptor annotation = AnnotationUtilKt.createDeprecatedAnnotation(kotlinBuiltIns, string, string2, "HIDDEN", false);
        return Annotations.Companion.create(CollectionsKt.listOf(annotation));
    }

    private static final KotlinType createMockJavaIoSerializableType$lambda$3(JvmBuiltInsCustomizer this$0) {
        SimpleType simpleType = this$0.moduleDescriptor.getBuiltIns().getAnyType();
        Intrinsics.checkNotNullExpressionValue(simpleType, "getAnyType(...)");
        return simpleType;
    }

    private static final Collection getFunctions$lambda$5(Name $name, MemberScope it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getContributedFunctions($name, NoLookupLocation.FROM_BUILTINS);
    }

    private static final ClassDescriptor getAdditionalFunctions$lambda$9(LazyJavaClassDescriptor $javaAnalogueDescriptor, ClassDescriptor $kotlinMutableClassIfContainer) {
        JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
        Intrinsics.checkNotNullExpressionValue(javaResolverCache, "EMPTY");
        return $javaAnalogueDescriptor.copy$descriptors_jvm(javaResolverCache, $kotlinMutableClassIfContainer);
    }

    private static final Iterable isMutabilityViolation$lambda$13(CallableMemberDescriptor it) {
        return it.getOriginal().getOverriddenDescriptors();
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final Boolean isMutabilityViolation$lambda$14(JvmBuiltInsCustomizer this$0, CallableMemberDescriptor overridden) {
        boolean bl2;
        if (overridden.getKind() == CallableMemberDescriptor.Kind.DECLARATION) {
            JavaToKotlinClassMapper javaToKotlinClassMapper = this$0.j2kClassMapper;
            DeclarationDescriptor declarationDescriptor = overridden.getContainingDeclaration();
            Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            if (javaToKotlinClassMapper.isMutable((ClassDescriptor)declarationDescriptor)) {
                bl2 = true;
                return bl2;
            }
        }
        bl2 = false;
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    private static final Iterable getJdkMethodStatus$lambda$16(JvmBuiltInsCustomizer this$0, ClassDescriptor it) {
        void $this$mapNotNullTo$iv$iv;
        Collection<KotlinType> collection = it.getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(collection, "getSupertypes(...)");
        Iterable $this$mapNotNull$iv = collection;
        boolean $i$f$mapNotNull = false;
        Iterable iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            ClassDescriptor classDescriptor;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl2 = false;
            KotlinType supertype = (KotlinType)element$iv$iv;
            boolean bl3 = false;
            ClassifierDescriptor classifierDescriptor = supertype.getConstructor().getDeclarationDescriptor();
            ClassifierDescriptor classifierDescriptor2 = classifierDescriptor != null ? classifierDescriptor.getOriginal() : null;
            if ((classifierDescriptor2 instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor2 : null) == null) {
                classDescriptor = null;
            } else {
                ClassDescriptor superClassDescriptor;
                superClassDescriptor = superClassDescriptor;
                LazyJavaClassDescriptor lazyJavaClassDescriptor = this$0.getJavaAnalogue(superClassDescriptor);
                classDescriptor = lazyJavaClassDescriptor != null ? (ClassDescriptor)lazyJavaClassDescriptor : superClassDescriptor;
            }
            if (classDescriptor == null) continue;
            ClassDescriptor it$iv$iv = classDescriptor;
            boolean bl4 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    private static final boolean getConstructors$isEffectivelyTheSameAs(ConstructorDescriptor $this$getConstructors_u24isEffectivelyTheSameAs, TypeSubstitutor substitutor, ConstructorDescriptor javaConstructor) {
        return OverridingUtil.getBothWaysOverridability($this$getConstructors_u24isEffectivelyTheSameAs, javaConstructor.substitute(substitutor)) == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(JvmBuiltInsCustomizer.class, "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;", 0)), Reflection.property1(new PropertyReference1Impl(JvmBuiltInsCustomizer.class, "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;", 0)), Reflection.property1(new PropertyReference1Impl(JvmBuiltInsCustomizer.class, "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ SimpleType accessor$JvmBuiltInsCustomizer$lambda0(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, StorageManager storageManager) {
        return JvmBuiltInsCustomizer.cloneableType_delegate$lambda$0(jvmBuiltInsCustomizer, storageManager);
    }

    static /* synthetic */ Annotations accessor$JvmBuiltInsCustomizer$lambda1(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        return JvmBuiltInsCustomizer.notConsideredDeprecation_delegate$lambda$1(jvmBuiltInsCustomizer);
    }

    static /* synthetic */ Annotations accessor$JvmBuiltInsCustomizer$lambda2(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, Pair pair) {
        return JvmBuiltInsCustomizer.deprecationForSomeOfTheListMethods$lambda$2(jvmBuiltInsCustomizer, pair);
    }

    static /* synthetic */ KotlinType accessor$JvmBuiltInsCustomizer$lambda3(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        return JvmBuiltInsCustomizer.createMockJavaIoSerializableType$lambda$3(jvmBuiltInsCustomizer);
    }

    static /* synthetic */ Collection accessor$JvmBuiltInsCustomizer$lambda4(Name name, MemberScope memberScope) {
        return JvmBuiltInsCustomizer.getFunctions$lambda$5(name, memberScope);
    }

    static /* synthetic */ ClassDescriptor accessor$JvmBuiltInsCustomizer$lambda5(LazyJavaClassDescriptor lazyJavaClassDescriptor, ClassDescriptor classDescriptor) {
        return JvmBuiltInsCustomizer.getAdditionalFunctions$lambda$9(lazyJavaClassDescriptor, classDescriptor);
    }

    static /* synthetic */ Iterable accessor$JvmBuiltInsCustomizer$lambda6(CallableMemberDescriptor callableMemberDescriptor) {
        return JvmBuiltInsCustomizer.isMutabilityViolation$lambda$13(callableMemberDescriptor);
    }

    static /* synthetic */ Boolean accessor$JvmBuiltInsCustomizer$lambda7(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, CallableMemberDescriptor callableMemberDescriptor) {
        return JvmBuiltInsCustomizer.isMutabilityViolation$lambda$14(jvmBuiltInsCustomizer, callableMemberDescriptor);
    }

    static /* synthetic */ Iterable accessor$JvmBuiltInsCustomizer$lambda8(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, ClassDescriptor classDescriptor) {
        return JvmBuiltInsCustomizer.getJdkMethodStatus$lambda$16(jvmBuiltInsCustomizer, classDescriptor);
    }

    private static final class JDKMemberStatus
    extends Enum<JDKMemberStatus> {
        public static final /* enum */ JDKMemberStatus HIDDEN = new JDKMemberStatus();
        public static final /* enum */ JDKMemberStatus VISIBLE = new JDKMemberStatus();
        public static final /* enum */ JDKMemberStatus DEPRECATED_LIST_METHODS = new JDKMemberStatus();
        public static final /* enum */ JDKMemberStatus NOT_CONSIDERED = new JDKMemberStatus();
        public static final /* enum */ JDKMemberStatus DROP = new JDKMemberStatus();
        private static final /* synthetic */ JDKMemberStatus[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static JDKMemberStatus[] values() {
            return (JDKMemberStatus[])$VALUES.clone();
        }

        public static JDKMemberStatus valueOf(String value) {
            return Enum.valueOf(JDKMemberStatus.class, value);
        }

        static {
            $VALUES = jDKMemberStatusArray = new JDKMemberStatus[]{JDKMemberStatus.HIDDEN, JDKMemberStatus.VISIBLE, JDKMemberStatus.DEPRECATED_LIST_METHODS, JDKMemberStatus.NOT_CONSIDERED, JDKMemberStatus.DROP};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[JDKMemberStatus.values().length];
            try {
                nArray[JDKMemberStatus.HIDDEN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[JDKMemberStatus.DEPRECATED_LIST_METHODS.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[JDKMemberStatus.NOT_CONSIDERED.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[JDKMemberStatus.DROP.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[JDKMemberStatus.VISIBLE.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

