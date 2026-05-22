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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.MappingUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nLazyJavaClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaClassDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,322:1\n1761#2,3:323\n1761#2,3:326\n1056#2:334\n1563#2:336\n1634#2,3:337\n1152#3:329\n1321#3:330\n1322#3:332\n1153#3:333\n1#4:331\n1#4:335\n*S KotlinDebug\n*F\n+ 1 LazyJavaClassDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassDescriptor\n*L\n185#1:323,3\n188#1:326,3\n202#1:334\n151#1:336\n151#1:337,3\n200#1:329\n200#1:330\n200#1:332\n200#1:333\n200#1:331\n*E\n"})
public final class LazyJavaClassDescriptor
extends ClassDescriptorBase
implements JavaClassDescriptor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final LazyJavaResolverContext outerContext;
    @NotNull
    private final JavaClass jClass;
    @Nullable
    private final ClassDescriptor additionalSupertypeClassDescriptor;
    @NotNull
    private final LazyJavaResolverContext c;
    @NotNull
    private final Lazy moduleAnnotations$delegate;
    @NotNull
    private final ClassKind kind;
    @NotNull
    private final Modality modality;
    @NotNull
    private final Visibility visibility;
    private final boolean isInner;
    @NotNull
    private final LazyJavaClassTypeConstructor typeConstructor;
    @NotNull
    private final LazyJavaClassMemberScope unsubstitutedMemberScope;
    @NotNull
    private final ScopesHolderForClass<LazyJavaClassMemberScope> scopeHolder;
    @NotNull
    private final InnerClassesScopeWrapper innerClassesScope;
    @NotNull
    private final LazyJavaStaticClassScope staticScope;
    @NotNull
    private final Annotations annotations;
    @NotNull
    private final NotNullLazyValue<List<TypeParameterDescriptor>> declaredParameters;
    @NotNull
    private static final Set<String> PUBLIC_METHOD_NAMES_IN_OBJECT;

    public LazyJavaClassDescriptor(@NotNull LazyJavaResolverContext outerContext, @NotNull DeclarationDescriptor containingDeclaration, @NotNull JavaClass jClass, @Nullable ClassDescriptor additionalSupertypeClassDescriptor) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(outerContext, "outerContext");
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        super(outerContext.getStorageManager(), containingDeclaration, jClass.getName(), outerContext.getComponents().getSourceElementFactory().source(jClass), false);
        this.outerContext = outerContext;
        this.jClass = jClass;
        this.additionalSupertypeClassDescriptor = additionalSupertypeClassDescriptor;
        this.c = ContextKt.childForClassOrPackage$default(this.outerContext, this, this.jClass, 0, 4, null);
        this.c.getComponents().getJavaResolverCache().recordClass(this.jClass, this);
        boolean bl3 = bl2 = this.jClass.getLightClassOriginKind() == null;
        if (_Assertions.ENABLED && !bl2) {
            boolean bl4 = false;
            String string = "Creating LazyJavaClassDescriptor for light class " + this.jClass;
            throw new AssertionError((Object)string);
        }
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this;
        this.moduleAnnotations$delegate = LazyKt.lazy(new LazyJavaClassDescriptor$$Lambda$0(lazyJavaClassDescriptor));
        ClassKind classKind = this.jClass.isAnnotationType() ? ClassKind.ANNOTATION_CLASS : (this.jClass.isInterface() ? ClassKind.INTERFACE : (this.kind = this.jClass.isEnum() ? ClassKind.ENUM_CLASS : ClassKind.CLASS));
        this.modality = this.jClass.isAnnotationType() || this.jClass.isEnum() ? Modality.FINAL : Modality.Companion.convertFromFlags(this.jClass.isSealed(), this.jClass.isSealed() || this.jClass.isAbstract() || this.jClass.isInterface(), !this.jClass.isFinal());
        this.visibility = this.jClass.getVisibility();
        this.isInner = this.jClass.getOuterClass() != null && !this.jClass.isStatic();
        this.typeConstructor = new LazyJavaClassTypeConstructor();
        this.unsubstitutedMemberScope = new LazyJavaClassMemberScope(this.c, this, this.jClass, this.additionalSupertypeClassDescriptor != null, null, 16, null);
        lazyJavaClassDescriptor = this;
        this.scopeHolder = ScopesHolderForClass.Companion.create(this, this.c.getStorageManager(), this.c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new LazyJavaClassDescriptor$$Lambda$1(lazyJavaClassDescriptor));
        this.innerClassesScope = new InnerClassesScopeWrapper(this.unsubstitutedMemberScope);
        this.staticScope = new LazyJavaStaticClassScope(this.c, this.jClass, this);
        this.annotations = LazyJavaAnnotationsKt.resolveAnnotations(this.c, this.jClass);
        lazyJavaClassDescriptor = this;
        this.declaredParameters = this.c.getStorageManager().createLazyValue(new LazyJavaClassDescriptor$$Lambda$2(lazyJavaClassDescriptor));
    }

    public /* synthetic */ LazyJavaClassDescriptor(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaClass javaClass, ClassDescriptor classDescriptor, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 8) != 0) {
            classDescriptor = null;
        }
        this(lazyJavaResolverContext, declarationDescriptor, javaClass, classDescriptor);
    }

    @NotNull
    public final JavaClass getJClass() {
        return this.jClass;
    }

    @Nullable
    public final List<JavaAnnotation> getModuleAnnotations() {
        Lazy lazy = this.moduleAnnotations$delegate;
        return (List)lazy.getValue();
    }

    @Override
    @NotNull
    public ClassKind getKind() {
        return this.kind;
    }

    @Override
    @NotNull
    public Modality getModality() {
        return this.modality;
    }

    @Override
    @NotNull
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility;
        if (Intrinsics.areEqual(this.visibility, DescriptorVisibilities.PRIVATE) && this.jClass.getOuterClass() == null) {
            DescriptorVisibility descriptorVisibility2 = JavaDescriptorVisibilities.PACKAGE_VISIBILITY;
            Intrinsics.checkNotNull(descriptorVisibility2);
            descriptorVisibility = descriptorVisibility2;
        } else {
            descriptorVisibility = UtilsKt.toDescriptorVisibility(this.visibility);
        }
        return descriptorVisibility;
    }

    @Override
    public boolean isInner() {
        return this.isInner;
    }

    @Override
    public boolean isData() {
        return false;
    }

    @Override
    public boolean isInline() {
        return false;
    }

    @Override
    public boolean isCompanionObject() {
        return false;
    }

    @Override
    public boolean isExpect() {
        return false;
    }

    @Override
    public boolean isActual() {
        return false;
    }

    @Override
    public boolean isFun() {
        return false;
    }

    @Override
    public boolean isValue() {
        return false;
    }

    @Override
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override
    @NotNull
    protected LazyJavaClassMemberScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.scopeHolder.getScope(kotlinTypeRefiner);
    }

    @Override
    @NotNull
    public MemberScope getUnsubstitutedInnerClassesScope() {
        return this.innerClassesScope;
    }

    @Override
    @NotNull
    public MemberScope getStaticScope() {
        return this.staticScope;
    }

    @Override
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override
    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override
    @NotNull
    public LazyJavaClassMemberScope getUnsubstitutedMemberScope() {
        MemberScope memberScope = super.getUnsubstitutedMemberScope();
        Intrinsics.checkNotNull(memberScope, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
        return (LazyJavaClassMemberScope)memberScope;
    }

    @NotNull
    public List<ClassConstructorDescriptor> getConstructors() {
        return (List)this.unsubstitutedMemberScope.getConstructors$descriptors_jvm().invoke();
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return (List)this.declaredParameters.invoke();
    }

    @Override
    @Nullable
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return null;
    }

    @NotNull
    public String toString() {
        return "Lazy Java class " + DescriptorUtilsKt.getFqNameUnsafe(this);
    }

    @NotNull
    public final LazyJavaClassDescriptor copy$descriptors_jvm(@NotNull JavaResolverCache javaResolverCache, @Nullable ClassDescriptor additionalSupertypeClassDescriptor) {
        Intrinsics.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        LazyJavaResolverContext lazyJavaResolverContext = ContextKt.replaceComponents(this.c, this.c.getComponents().replace(javaResolverCache));
        DeclarationDescriptor declarationDescriptor = this.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(declarationDescriptor, "getContainingDeclaration(...)");
        return new LazyJavaClassDescriptor(lazyJavaResolverContext, declarationDescriptor, this.jClass, additionalSupertypeClassDescriptor);
    }

    private static final List moduleAnnotations_delegate$lambda$2(LazyJavaClassDescriptor this$0) {
        List<JavaAnnotation> list;
        ClassId classId = DescriptorUtilsKt.getClassId(this$0);
        if (classId != null) {
            ClassId it = classId;
            boolean bl2 = false;
            list = this$0.outerContext.getComponents().getJavaModuleResolver().getAnnotationsForModuleOwnerOfClass(it);
        } else {
            list = null;
        }
        return list;
    }

    private static final LazyJavaClassMemberScope scopeHolder$lambda$3(LazyJavaClassDescriptor this$0, KotlinTypeRefiner it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new LazyJavaClassMemberScope(this$0.c, this$0, this$0.jClass, this$0.additionalSupertypeClassDescriptor != null, this$0.unsubstitutedMemberScope);
    }

    /*
     * WARNING - void declaration
     */
    private static final List declaredParameters$lambda$5(LazyJavaClassDescriptor this$0) {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = this$0.jClass.getTypeParameters();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p2;
            JavaTypeParameter javaTypeParameter = (JavaTypeParameter)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            TypeParameterDescriptor typeParameterDescriptor = this$0.c.getTypeParameterResolver().resolveTypeParameter((JavaTypeParameter)p2);
            if (typeParameterDescriptor == null) {
                throw new AssertionError((Object)("Parameter " + p2 + " surely belongs to class " + this$0.jClass + ", so it must be resolved"));
            }
            collection.add(typeParameterDescriptor);
        }
        return (List)destination$iv$iv;
    }

    static {
        String[] stringArray = new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"};
        PUBLIC_METHOD_NAMES_IN_OBJECT = SetsKt.setOf(stringArray);
    }

    static /* synthetic */ List accessor$LazyJavaClassDescriptor$lambda0(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        return LazyJavaClassDescriptor.moduleAnnotations_delegate$lambda$2(lazyJavaClassDescriptor);
    }

    static /* synthetic */ LazyJavaClassMemberScope accessor$LazyJavaClassDescriptor$lambda1(LazyJavaClassDescriptor lazyJavaClassDescriptor, KotlinTypeRefiner kotlinTypeRefiner) {
        return LazyJavaClassDescriptor.scopeHolder$lambda$3(lazyJavaClassDescriptor, kotlinTypeRefiner);
    }

    static /* synthetic */ List accessor$LazyJavaClassDescriptor$lambda2(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        return LazyJavaClassDescriptor.declaredParameters$lambda$5(lazyJavaClassDescriptor);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @SourceDebugExtension(value={"SMAP\nLazyJavaClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaClassDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassDescriptor$LazyJavaClassTypeConstructor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,322:1\n1563#2:323\n1634#2,3:324\n1563#2:327\n1634#2,3:328\n1563#2:331\n1634#2,3:332\n*S KotlinDebug\n*F\n+ 1 LazyJavaClassDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassDescriptor$LazyJavaClassTypeConstructor\n*L\n254#1:323\n254#1:324,3\n280#1:327\n280#1:328,3\n285#1:331\n285#1:332,3\n*E\n"})
    private final class LazyJavaClassTypeConstructor
    extends AbstractClassTypeConstructor {
        @NotNull
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;

        public LazyJavaClassTypeConstructor() {
            super(LazyJavaClassDescriptor.this.c.getStorageManager());
            LazyJavaClassDescriptor lazyJavaClassDescriptor = LazyJavaClassDescriptor.this;
            this.parameters = LazyJavaClassDescriptor.this.c.getStorageManager().createLazyValue(new LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$$Lambda$0(lazyJavaClassDescriptor));
        }

        @Override
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return (List)this.parameters.invoke();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        @NotNull
        protected Collection<KotlinType> computeSupertypes() {
            KotlinType kotlinType;
            Object object;
            Annotated enhancedKotlinType;
            Annotated kotlinType2;
            Collection<JavaClassifierType> javaTypes = LazyJavaClassDescriptor.this.getJClass().getSupertypes();
            ArrayList<Annotated> result = new ArrayList<Annotated>(javaTypes.size());
            ArrayList<JavaClassifierType> incomplete = new ArrayList<JavaClassifierType>(0);
            KotlinType purelyImplementedSupertype = this.getPurelyImplementedSupertype();
            for (JavaClassifierType javaClassifierType : javaTypes) {
                kotlinType2 = LazyJavaClassDescriptor.this.c.getTypeResolver().transformJavaType(javaClassifierType, JavaTypeAttributesKt.toAttributes$default(TypeUsage.SUPERTYPE, false, false, null, 7, null));
                enhancedKotlinType = LazyJavaClassDescriptor.this.c.getComponents().getSignatureEnhancement().enhanceSuperType((KotlinType)kotlinType2, LazyJavaClassDescriptor.this.c);
                if (((KotlinType)enhancedKotlinType).getConstructor().getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor) {
                    incomplete.add(javaClassifierType);
                }
                KotlinType kotlinType3 = purelyImplementedSupertype;
                if (Intrinsics.areEqual(((KotlinType)enhancedKotlinType).getConstructor(), kotlinType3 != null ? kotlinType3.getConstructor() : null) || KotlinBuiltIns.isAnyOrNullableAny((KotlinType)enhancedKotlinType)) continue;
                result.add(enhancedKotlinType);
            }
            Collection collection = result;
            ClassDescriptor classDescriptor = LazyJavaClassDescriptor.this.additionalSupertypeClassDescriptor;
            if (classDescriptor != null) {
                void it;
                ClassDescriptor classDescriptor2 = classDescriptor;
                kotlinType2 = LazyJavaClassDescriptor.this;
                enhancedKotlinType = classDescriptor2;
                object = collection;
                boolean bl2 = false;
                kotlinType = MappingUtilKt.createMappedTypeParametersSubstitution((ClassDescriptor)it, kotlinType2).buildSubstitutor().substitute(it.getDefaultType(), Variance.INVARIANT);
                collection = object;
            } else {
                kotlinType = null;
            }
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection, kotlinType);
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull((Collection)result, purelyImplementedSupertype);
            if (!((Collection)incomplete).isEmpty()) {
                Collection<String> collection2;
                void $this$mapTo$iv$iv;
                void $this$map$iv;
                Iterable iterable = incomplete;
                ClassDescriptor classDescriptor3 = this.getDeclarationDescriptor();
                object = LazyJavaClassDescriptor.this.c.getComponents().getErrorReporter();
                boolean bl2 = false;
                kotlinType2 = $this$map$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void javaType;
                    JavaType javaType2 = (JavaType)item$iv$iv;
                    collection2 = destination$iv$iv;
                    boolean bl3 = false;
                    Intrinsics.checkNotNull(javaType, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                    collection2.add(((JavaClassifierType)javaType).getPresentableText());
                }
                collection2 = (List)destination$iv$iv;
                object.reportIncompleteHierarchy(classDescriptor3, (List<String>)collection2);
            }
            return !((Collection)result).isEmpty() ? (Collection)CollectionsKt.toList((Iterable)result) : (Collection)CollectionsKt.listOf(LazyJavaClassDescriptor.this.c.getModule().getBuiltIns().getAnyType());
        }

        /*
         * WARNING - void declaration
         */
        private final KotlinType getPurelyImplementedSupertype() {
            List list;
            int n2;
            Collection collection;
            Iterable destination$iv$iv;
            FqName annotatedPurelyImplementedFqName;
            FqName fqName;
            FqName fqName2;
            FqName fqName3 = this.getPurelyImplementsFqNameFromAnnotation();
            if (fqName3 != null) {
                FqName fqName4;
                FqName fqName5 = fqName4 = fqName3;
                boolean bl2 = false;
                fqName2 = !fqName5.isRoot() && fqName5.startsWith(StandardNames.BUILT_INS_PACKAGE_NAME) ? fqName4 : null;
            } else {
                fqName2 = null;
            }
            if ((fqName = (annotatedPurelyImplementedFqName = fqName2)) == null && (fqName = FakePureImplementationsProvider.INSTANCE.getPurelyImplementedInterface(DescriptorUtilsKt.getFqNameSafe(LazyJavaClassDescriptor.this))) == null) {
                return null;
            }
            FqName purelyImplementedFqName = fqName;
            ClassDescriptor classDescriptor = DescriptorUtilsKt.resolveTopLevelClass(LazyJavaClassDescriptor.this.c.getModule(), purelyImplementedFqName, NoLookupLocation.FROM_JAVA_LOADER);
            if (classDescriptor == null) {
                return null;
            }
            ClassDescriptor classDescriptor2 = classDescriptor;
            int supertypeParameterCount = classDescriptor2.getTypeConstructor().getParameters().size();
            List<TypeParameterDescriptor> list2 = LazyJavaClassDescriptor.this.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(list2, "getParameters(...)");
            List<TypeParameterDescriptor> typeParameters = list2;
            int typeParameterCount = typeParameters.size();
            if (typeParameterCount == supertypeParameterCount) {
                void $this$mapTo$iv$iv;
                Iterable $this$map$iv = typeParameters;
                boolean $i$f$map = false;
                Iterable iterable = $this$map$iv;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void parameter;
                    TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
                    collection = destination$iv$iv;
                    n2 = 0;
                    collection.add(new TypeProjectionImpl(Variance.INVARIANT, parameter.getDefaultType()));
                }
                list = (List)destination$iv$iv;
            } else if (typeParameterCount == 1 && supertypeParameterCount > 1 && annotatedPurelyImplementedFqName == null) {
                void $this$mapTo$iv$iv;
                TypeProjectionImpl parameter = new TypeProjectionImpl(Variance.INVARIANT, CollectionsKt.single(typeParameters).getDefaultType());
                Iterable $this$map$iv = new IntRange(1, supertypeParameterCount);
                boolean $i$f$map = false;
                destination$iv$iv = $this$map$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                Iterator iterator2 = $this$mapTo$iv$iv.iterator();
                while (iterator2.hasNext()) {
                    int item$iv$iv;
                    n2 = item$iv$iv = ((IntIterator)iterator2).nextInt();
                    collection = destination$iv$iv2;
                    boolean bl3 = false;
                    collection.add(parameter);
                }
                list = (List)destination$iv$iv2;
            } else {
                return null;
            }
            List parametersAsTypeProjections = list;
            return KotlinTypeFactory.simpleNotNullType(TypeAttributes.Companion.getEmpty(), classDescriptor2, parametersAsTypeProjections);
        }

        private final FqName getPurelyImplementsFqNameFromAnnotation() {
            Annotations annotations = LazyJavaClassDescriptor.this.getAnnotations();
            FqName fqName = JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION;
            Intrinsics.checkNotNullExpressionValue(fqName, "PURELY_IMPLEMENTS_ANNOTATION");
            AnnotationDescriptor annotationDescriptor = annotations.findAnnotation(fqName);
            if (annotationDescriptor == null) {
                return null;
            }
            AnnotationDescriptor annotation = annotationDescriptor;
            Object t2 = CollectionsKt.singleOrNull((Iterable)annotation.getAllValueArguments().values());
            Object object = t2 instanceof StringValue ? (StringValue)t2 : null;
            if (object == null || (object = (String)((ConstantValue)object).getValue()) == null) {
                return null;
            }
            Object fqNameString = object;
            if (!FqNamesUtilKt.isValidJavaFqName((String)fqNameString)) {
                return null;
            }
            return new FqName((String)fqNameString);
        }

        @Override
        @NotNull
        protected SupertypeLoopChecker getSupertypeLoopChecker() {
            return LazyJavaClassDescriptor.this.c.getComponents().getSupertypeLoopChecker();
        }

        @Override
        public boolean isDenotable() {
            return true;
        }

        @Override
        @NotNull
        public ClassDescriptor getDeclarationDescriptor() {
            return LazyJavaClassDescriptor.this;
        }

        @NotNull
        public String toString() {
            String string = LazyJavaClassDescriptor.this.getName().asString();
            Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
            return string;
        }

        private static final List parameters$lambda$0(LazyJavaClassDescriptor this$0) {
            return TypeParameterUtilsKt.computeConstructorTypeParameters(this$0);
        }

        static /* synthetic */ List accessor$LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$lambda0(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
            return LazyJavaClassTypeConstructor.parameters$lambda$0(lazyJavaClassDescriptor);
        }
    }
}

