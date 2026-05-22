/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.Ref;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nDescriptorUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DescriptorUtils.kt\norg/jetbrains/kotlin/resolve/descriptorUtil/DescriptorUtilsKt\n+ 2 ClassKind.kt\norg/jetbrains/kotlin/descriptors/ClassKindKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,466:1\n34#2:467\n827#3:468\n855#3,2:469\n1617#3,9:471\n1869#3:480\n1870#3:482\n1626#3:483\n827#3:484\n855#3,2:485\n827#3:489\n855#3,2:490\n360#3,7:493\n1761#3,3:500\n2746#3,3:503\n1563#3:506\n1634#3,3:507\n1#4:481\n1#4:492\n1310#5,2:487\n*S KotlinDebug\n*F\n+ 1 DescriptorUtils.kt\norg/jetbrains/kotlin/resolve/descriptorUtil/DescriptorUtilsKt\n*L\n148#1:467\n167#1:468\n167#1:469,2\n168#1:471,9\n168#1:480\n168#1:482\n168#1:483\n175#1:484\n175#1:485,2\n233#1:489\n233#1:490,2\n303#1:493,7\n449#1:500,3\n455#1:503,3\n208#1:506\n208#1:507,3\n168#1:481\n226#1:487,2\n*E\n"})
public final class DescriptorUtilsKt {
    @NotNull
    private static final Name RETENTION_PARAMETER_NAME;

    @NotNull
    public static final FqNameUnsafe getFqNameUnsafe(@NotNull DeclarationDescriptor $this$fqNameUnsafe) {
        Intrinsics.checkNotNullParameter($this$fqNameUnsafe, "<this>");
        FqNameUnsafe fqNameUnsafe = DescriptorUtils.getFqName($this$fqNameUnsafe);
        Intrinsics.checkNotNullExpressionValue(fqNameUnsafe, "getFqName(...)");
        return fqNameUnsafe;
    }

    @NotNull
    public static final FqName getFqNameSafe(@NotNull DeclarationDescriptor $this$fqNameSafe) {
        Intrinsics.checkNotNullParameter($this$fqNameSafe, "<this>");
        FqName fqName = DescriptorUtils.getFqNameSafe($this$fqNameSafe);
        Intrinsics.checkNotNullExpressionValue(fqName, "getFqNameSafe(...)");
        return fqName;
    }

    @NotNull
    public static final ModuleDescriptor getModule(@NotNull DeclarationDescriptor $this$module) {
        Intrinsics.checkNotNullParameter($this$module, "<this>");
        ModuleDescriptor moduleDescriptor = DescriptorUtils.getContainingModule($this$module);
        Intrinsics.checkNotNullExpressionValue(moduleDescriptor, "getContainingModule(...)");
        return moduleDescriptor;
    }

    @Nullable
    public static final ClassDescriptor resolveTopLevelClass(@NotNull ModuleDescriptor $this$resolveTopLevelClass, @NotNull FqName topLevelClassFqName, @NotNull LookupLocation location) {
        boolean bl2;
        Intrinsics.checkNotNullParameter($this$resolveTopLevelClass, "<this>");
        Intrinsics.checkNotNullParameter(topLevelClassFqName, "topLevelClassFqName");
        Intrinsics.checkNotNullParameter(location, "location");
        boolean bl3 = bl2 = !topLevelClassFqName.isRoot();
        if (_Assertions.ENABLED && !bl2) {
            String string = "Assertion failed";
            throw new AssertionError((Object)string);
        }
        ClassifierDescriptor classifierDescriptor = $this$resolveTopLevelClass.getPackage(topLevelClassFqName.parent()).getMemberScope().getContributedClassifier(topLevelClassFqName.shortName(), location);
        return classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
    }

    @Nullable
    public static final ClassId getClassId(@Nullable ClassifierDescriptor $this$classId) {
        ClassId classId;
        DeclarationDescriptor declarationDescriptor = $this$classId;
        if (declarationDescriptor != null && (declarationDescriptor = declarationDescriptor.getContainingDeclaration()) != null) {
            DeclarationDescriptor owner = declarationDescriptor;
            boolean bl2 = false;
            DeclarationDescriptor declarationDescriptor2 = owner;
            if (declarationDescriptor2 instanceof PackageFragmentDescriptor) {
                FqName fqName = ((PackageFragmentDescriptor)owner).getFqName();
                Name name = $this$classId.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                classId = new ClassId(fqName, name);
            } else if (declarationDescriptor2 instanceof ClassifierDescriptorWithTypeParameters) {
                ClassId classId2 = DescriptorUtilsKt.getClassId(owner);
                if (classId2 != null) {
                    Name name = $this$classId.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    classId = classId2.createNestedClassId(name);
                } else {
                    classId = null;
                }
            } else {
                classId = null;
            }
        } else {
            classId = null;
        }
        return classId;
    }

    @Nullable
    public static final ClassDescriptor getSuperClassNotAny(@NotNull ClassDescriptor $this$getSuperClassNotAny) {
        Intrinsics.checkNotNullParameter($this$getSuperClassNotAny, "<this>");
        for (KotlinType supertype : $this$getSuperClassNotAny.getDefaultType().getConstructor().getSupertypes()) {
            ClassifierDescriptor superClassifier;
            if (KotlinBuiltIns.isAnyOrNullableAny(supertype) || !DescriptorUtils.isClassOrEnumClass(superClassifier = supertype.getConstructor().getDeclarationDescriptor())) continue;
            Intrinsics.checkNotNull(superClassifier, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return (ClassDescriptor)superClassifier;
        }
        return null;
    }

    @NotNull
    public static final KotlinBuiltIns getBuiltIns(@NotNull DeclarationDescriptor $this$builtIns) {
        Intrinsics.checkNotNullParameter($this$builtIns, "<this>");
        return DescriptorUtilsKt.getModule($this$builtIns).getBuiltIns();
    }

    public static final boolean declaresOrInheritsDefaultValue(@NotNull ValueParameterDescriptor $this$declaresOrInheritsDefaultValue) {
        Intrinsics.checkNotNullParameter($this$declaresOrInheritsDefaultValue, "<this>");
        Boolean bl2 = DFS.ifAny((Collection)CollectionsKt.listOf($this$declaresOrInheritsDefaultValue), DescriptorUtilsKt$$Lambda$0.INSTANCE, declaresOrInheritsDefaultValue.2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(bl2, "ifAny(...)");
        return bl2;
    }

    @NotNull
    public static final Sequence<DeclarationDescriptor> getParentsWithSelf(@NotNull DeclarationDescriptor $this$parentsWithSelf) {
        Intrinsics.checkNotNullParameter($this$parentsWithSelf, "<this>");
        return SequencesKt.generateSequence($this$parentsWithSelf, DescriptorUtilsKt$$Lambda$1.INSTANCE);
    }

    @NotNull
    public static final Sequence<DeclarationDescriptor> getParents(@NotNull DeclarationDescriptor $this$parents) {
        Intrinsics.checkNotNullParameter($this$parents, "<this>");
        return SequencesKt.drop(DescriptorUtilsKt.getParentsWithSelf($this$parents), 1);
    }

    @NotNull
    public static final CallableMemberDescriptor getPropertyIfAccessor(@NotNull CallableMemberDescriptor $this$propertyIfAccessor) {
        CallableMemberDescriptor callableMemberDescriptor;
        Intrinsics.checkNotNullParameter($this$propertyIfAccessor, "<this>");
        if ($this$propertyIfAccessor instanceof PropertyAccessorDescriptor) {
            PropertyDescriptor propertyDescriptor = ((PropertyAccessorDescriptor)$this$propertyIfAccessor).getCorrespondingProperty();
            Intrinsics.checkNotNullExpressionValue(propertyDescriptor, "getCorrespondingProperty(...)");
            callableMemberDescriptor = propertyDescriptor;
        } else {
            callableMemberDescriptor = $this$propertyIfAccessor;
        }
        return callableMemberDescriptor;
    }

    @Nullable
    public static final FqName fqNameOrNull(@NotNull DeclarationDescriptor $this$fqNameOrNull) {
        FqNameUnsafe fqNameUnsafe;
        Intrinsics.checkNotNullParameter($this$fqNameOrNull, "<this>");
        FqNameUnsafe it = fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe($this$fqNameOrNull);
        boolean bl2 = false;
        FqNameUnsafe fqNameUnsafe2 = it.isSafe() ? fqNameUnsafe : null;
        return fqNameUnsafe2 != null ? fqNameUnsafe2.toSafe() : null;
    }

    @Nullable
    public static final CallableMemberDescriptor firstOverridden(@NotNull CallableMemberDescriptor $this$firstOverridden, boolean useOriginal, @NotNull Function1<? super CallableMemberDescriptor, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$firstOverridden, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Ref.ObjectRef<CallableMemberDescriptor> result = new Ref.ObjectRef<CallableMemberDescriptor>();
        boolean bl2 = useOriginal;
        return (CallableMemberDescriptor)DFS.dfs((Collection)CollectionsKt.listOf($this$firstOverridden), new DescriptorUtilsKt$$Lambda$2(bl2), new DFS.AbstractNodeHandler<CallableMemberDescriptor, CallableMemberDescriptor>(result, predicate){
            final /* synthetic */ Ref.ObjectRef<CallableMemberDescriptor> $result;
            final /* synthetic */ Function1<CallableMemberDescriptor, Boolean> $predicate;
            {
                this.$result = $result;
                this.$predicate = $predicate;
            }

            public boolean beforeChildren(CallableMemberDescriptor current) {
                Intrinsics.checkNotNullParameter(current, "current");
                return this.$result.element == null;
            }

            public void afterChildren(CallableMemberDescriptor current) {
                Intrinsics.checkNotNullParameter(current, "current");
                if (this.$result.element == null && this.$predicate.invoke(current).booleanValue()) {
                    this.$result.element = current;
                }
            }

            public CallableMemberDescriptor result() {
                return (CallableMemberDescriptor)this.$result.element;
            }
        });
    }

    public static /* synthetic */ CallableMemberDescriptor firstOverridden$default(CallableMemberDescriptor callableMemberDescriptor, boolean bl2, Function1 function1, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = false;
        }
        return DescriptorUtilsKt.firstOverridden(callableMemberDescriptor, bl2, function1);
    }

    @NotNull
    public static final Sequence<CallableMemberDescriptor> overriddenTreeAsSequence(@NotNull CallableMemberDescriptor $this$overriddenTreeAsSequence, boolean useOriginal) {
        Intrinsics.checkNotNullParameter($this$overriddenTreeAsSequence, "<this>");
        CallableMemberDescriptor $this$overriddenTreeAsSequence_u24lambda_u2412 = useOriginal ? $this$overriddenTreeAsSequence.getOriginal() : $this$overriddenTreeAsSequence;
        boolean bl2 = false;
        CallableMemberDescriptor[] callableMemberDescriptorArray = new CallableMemberDescriptor[]{$this$overriddenTreeAsSequence_u24lambda_u2412};
        Sequence<CallableMemberDescriptor[]> sequence = SequencesKt.sequenceOf(callableMemberDescriptorArray);
        Collection<? extends CallableMemberDescriptor> collection = $this$overriddenTreeAsSequence_u24lambda_u2412.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(collection, "getOverriddenDescriptors(...)");
        boolean bl3 = useOriginal;
        return SequencesKt.plus(sequence, SequencesKt.flatMap(CollectionsKt.asSequence((Iterable)collection), new DescriptorUtilsKt$$Lambda$3(bl3)));
    }

    @Nullable
    public static final ClassDescriptor getAnnotationClass(@NotNull AnnotationDescriptor $this$annotationClass) {
        Intrinsics.checkNotNullParameter($this$annotationClass, "<this>");
        ClassifierDescriptor classifierDescriptor = $this$annotationClass.getType().getConstructor().getDeclarationDescriptor();
        return classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
    }

    @NotNull
    public static final KotlinTypeRefiner getKotlinTypeRefiner(@NotNull ModuleDescriptor $this$getKotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter($this$getKotlinTypeRefiner, "<this>");
        Ref<TypeRefinementSupport> ref = $this$getKotlinTypeRefiner.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        TypeRefinementSupport refinerCapability = ref != null ? ref.getValue() : null;
        return refinerCapability instanceof TypeRefinementSupport.Enabled ? ((TypeRefinementSupport.Enabled)refinerCapability).getTypeRefiner() : (KotlinTypeRefiner)KotlinTypeRefiner.Default.INSTANCE;
    }

    public static final boolean isTypeRefinementEnabled(@NotNull ModuleDescriptor $this$isTypeRefinementEnabled) {
        Intrinsics.checkNotNullParameter($this$isTypeRefinementEnabled, "<this>");
        Ref<TypeRefinementSupport> ref = $this$isTypeRefinementEnabled.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        return ref != null && (ref = ref.getValue()) != null ? ((TypeRefinementSupport)((Object)ref)).isEnabled() : false;
    }

    @Nullable
    public static final InlineClassRepresentation<SimpleType> getInlineClassRepresentation(@Nullable ClassDescriptor $this$inlineClassRepresentation) {
        ClassDescriptor classDescriptor = $this$inlineClassRepresentation;
        ValueClassRepresentation<SimpleType> valueClassRepresentation = classDescriptor != null ? classDescriptor.getValueClassRepresentation() : null;
        return valueClassRepresentation instanceof InlineClassRepresentation ? (InlineClassRepresentation)valueClassRepresentation : null;
    }

    @Nullable
    public static final MultiFieldValueClassRepresentation<SimpleType> getMultiFieldValueClassRepresentation(@Nullable ClassDescriptor $this$multiFieldValueClassRepresentation) {
        ClassDescriptor classDescriptor = $this$multiFieldValueClassRepresentation;
        ValueClassRepresentation<SimpleType> valueClassRepresentation = classDescriptor != null ? classDescriptor.getValueClassRepresentation() : null;
        return valueClassRepresentation instanceof MultiFieldValueClassRepresentation ? (MultiFieldValueClassRepresentation)valueClassRepresentation : null;
    }

    /*
     * WARNING - void declaration
     */
    private static final Iterable declaresOrInheritsDefaultValue$lambda$5(ValueParameterDescriptor current) {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = current.getOverriddenDescriptors();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(p0.getOriginal());
        }
        return (List)destination$iv$iv;
    }

    private static final DeclarationDescriptor _get_parentsWithSelf_$lambda$8(DeclarationDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getContainingDeclaration();
    }

    private static final Iterable firstOverridden$lambda$10(boolean $useOriginal, CallableMemberDescriptor current) {
        CallableMemberDescriptor descriptor2;
        Object object;
        CallableMemberDescriptor callableMemberDescriptor;
        if ($useOriginal) {
            CallableMemberDescriptor callableMemberDescriptor2 = current;
            callableMemberDescriptor = callableMemberDescriptor2 != null ? callableMemberDescriptor2.getOriginal() : null;
        } else {
            callableMemberDescriptor = current;
        }
        return (object = (descriptor2 = callableMemberDescriptor)) != null && (object = object.getOverriddenDescriptors()) != null ? (Iterable)object : (Iterable)CollectionsKt.emptyList();
    }

    private static final Sequence overriddenTreeAsSequence$lambda$12$lambda$11(boolean $useOriginal, CallableMemberDescriptor it) {
        Intrinsics.checkNotNull(it);
        return DescriptorUtilsKt.overriddenTreeAsSequence(it, $useOriginal);
    }

    static {
        Name name = Name.identifier("value");
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        RETENTION_PARAMETER_NAME = name;
    }

    static /* synthetic */ Iterable accessor$DescriptorUtilsKt$lambda0(ValueParameterDescriptor valueParameterDescriptor) {
        return DescriptorUtilsKt.declaresOrInheritsDefaultValue$lambda$5(valueParameterDescriptor);
    }

    static /* synthetic */ DeclarationDescriptor accessor$DescriptorUtilsKt$lambda1(DeclarationDescriptor declarationDescriptor) {
        return DescriptorUtilsKt._get_parentsWithSelf_$lambda$8(declarationDescriptor);
    }

    static /* synthetic */ Iterable accessor$DescriptorUtilsKt$lambda2(boolean bl2, CallableMemberDescriptor callableMemberDescriptor) {
        return DescriptorUtilsKt.firstOverridden$lambda$10(bl2, callableMemberDescriptor);
    }

    static /* synthetic */ Sequence accessor$DescriptorUtilsKt$lambda3(boolean bl2, CallableMemberDescriptor callableMemberDescriptor) {
        return DescriptorUtilsKt.overriddenTreeAsSequence$lambda$12$lambda$11(bl2, callableMemberDescriptor);
    }
}

