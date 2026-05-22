/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDeclarationsFromSupertypeConflictDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.CliSealedClassInheritorsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextClassReceiver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ValueClassUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$$Lambda$4;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$$Lambda$5;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassTypeConstructor$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$EnumEntryClassDescriptors$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$EnumEntryClassDescriptors$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$EnumEntryClassDescriptors$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nDeserializedClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,429:1\n295#2,2:430\n774#2:432\n865#2,2:433\n1563#2:435\n1634#2,3:436\n1563#2:439\n1634#2,3:440\n1617#2,9:443\n1869#2:452\n1870#2:454\n1626#2:455\n669#2,11:457\n1#3:453\n1#3:456\n*S KotlinDebug\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor\n*L\n141#1:430,2\n153#1:432\n153#1:433,2\n153#1:435\n153#1:436,3\n159#1:439\n159#1:440,3\n190#1:443,9\n190#1:452\n190#1:454\n190#1:455\n220#1:457,11\n190#1:453\n*E\n"})
public final class DeserializedClassDescriptor
extends AbstractClassDescriptor
implements DeserializedDescriptor {
    @NotNull
    private final ProtoBuf.Class classProto;
    @NotNull
    private final BinaryVersion metadataVersion;
    @NotNull
    private final SourceElement sourceElement;
    @NotNull
    private final ClassId classId;
    @NotNull
    private final Modality modality;
    @NotNull
    private final DescriptorVisibility visibility;
    @NotNull
    private final ClassKind kind;
    @NotNull
    private final DeserializationContext c;
    private final boolean hasEnumEntriesMetadataFlag;
    @NotNull
    private final MemberScopeImpl staticScope;
    @NotNull
    private final DeserializedClassTypeConstructor typeConstructor;
    @NotNull
    private final ScopesHolderForClass<DeserializedClassMemberScope> memberScopeHolder;
    @Nullable
    private final EnumEntryClassDescriptors enumEntries;
    @NotNull
    private final DeclarationDescriptor containingDeclaration;
    @NotNull
    private final NullableLazyValue<ClassConstructorDescriptor> primaryConstructor;
    @NotNull
    private final NotNullLazyValue<Collection<ClassConstructorDescriptor>> constructors;
    @NotNull
    private final NullableLazyValue<ClassDescriptor> companionObjectDescriptor;
    @NotNull
    private final NotNullLazyValue<Collection<ClassDescriptor>> sealedSubclasses;
    @NotNull
    private final NullableLazyValue<ValueClassRepresentation<SimpleType>> valueClassRepresentation;
    @NotNull
    private final ProtoContainer.Class thisAsProtoContainer;
    @NotNull
    private final Annotations annotations;

    public DeserializedClassDescriptor(@NotNull DeserializationContext outerContext, @NotNull ProtoBuf.Class classProto, @NotNull NameResolver nameResolver, @NotNull BinaryVersion metadataVersion, @NotNull SourceElement sourceElement) {
        Annotations annotations;
        MemberScopeImpl memberScopeImpl;
        Intrinsics.checkNotNullParameter(outerContext, "outerContext");
        Intrinsics.checkNotNullParameter(classProto, "classProto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(sourceElement, "sourceElement");
        super(outerContext.getStorageManager(), NameResolverUtilKt.getClassId(nameResolver, classProto.getFqName()).getShortClassName());
        this.classProto = classProto;
        this.metadataVersion = metadataVersion;
        this.sourceElement = sourceElement;
        this.classId = NameResolverUtilKt.getClassId(nameResolver, this.classProto.getFqName());
        this.modality = ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(this.classProto.getFlags()));
        this.visibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(this.classProto.getFlags()));
        this.kind = ProtoEnumFlags.INSTANCE.classKind(Flags.CLASS_KIND.get(this.classProto.getFlags()));
        DeclarationDescriptor declarationDescriptor = this;
        List<ProtoBuf.TypeParameter> list = this.classProto.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(list, "getTypeParameterList(...)");
        ProtoBuf.TypeTable typeTable = this.classProto.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
        TypeTable typeTable2 = new TypeTable(typeTable);
        ProtoBuf.VersionRequirementTable versionRequirementTable = this.classProto.getVersionRequirementTable();
        Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "getVersionRequirementTable(...)");
        this.c = outerContext.childContext(declarationDescriptor, list, nameResolver, typeTable2, VersionRequirementTable.Companion.create(versionRequirementTable), this.metadataVersion);
        Boolean bl2 = Flags.HAS_ENUM_ENTRIES.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bl2, "get(...)");
        this.hasEnumEntriesMetadataFlag = bl2;
        if (this.kind == ClassKind.ENUM_CLASS) {
            boolean enumEntriesCanBeUsed = this.hasEnumEntriesMetadataFlag || Intrinsics.areEqual(this.c.getComponents().getEnumEntriesDeserializationSupport().canSynthesizeEnumEntries(), true);
            memberScopeImpl = new StaticScopeForKotlinEnum(this.c.getStorageManager(), this, enumEntriesCanBeUsed);
        } else {
            memberScopeImpl = MemberScope.Empty.INSTANCE;
        }
        this.staticScope = memberScopeImpl;
        this.typeConstructor = new DeserializedClassTypeConstructor();
        this.memberScopeHolder = ScopesHolderForClass.Companion.create(this, this.c.getStorageManager(), this.c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), (Function1)new Function1<KotlinTypeRefiner, DeserializedClassMemberScope>((Object)this){

            public final DeserializedClassMemberScope invoke(KotlinTypeRefiner p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                return (DeserializedClassDescriptor)this.receiver.new DeserializedClassMemberScope(p0);
            }
        });
        this.enumEntries = this.kind == ClassKind.ENUM_CLASS ? new EnumEntryClassDescriptors() : null;
        this.containingDeclaration = outerContext.getContainingDeclaration();
        DeserializedClassDescriptor deserializedClassDescriptor = this;
        this.primaryConstructor = this.c.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$$Lambda$0(deserializedClassDescriptor));
        deserializedClassDescriptor = this;
        this.constructors = this.c.getStorageManager().createLazyValue(new DeserializedClassDescriptor$$Lambda$1(deserializedClassDescriptor));
        deserializedClassDescriptor = this;
        this.companionObjectDescriptor = this.c.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$$Lambda$2(deserializedClassDescriptor));
        deserializedClassDescriptor = this;
        this.sealedSubclasses = this.c.getStorageManager().createLazyValue(new DeserializedClassDescriptor$$Lambda$3(deserializedClassDescriptor));
        deserializedClassDescriptor = this;
        this.valueClassRepresentation = this.c.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$$Lambda$4(deserializedClassDescriptor));
        DeclarationDescriptor declarationDescriptor2 = this.containingDeclaration;
        DeserializedClassDescriptor deserializedClassDescriptor2 = declarationDescriptor2 instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor)declarationDescriptor2 : null;
        this.thisAsProtoContainer = new ProtoContainer.Class(this.classProto, this.c.getNameResolver(), this.c.getTypeTable(), this.sourceElement, deserializedClassDescriptor2 != null ? deserializedClassDescriptor2.thisAsProtoContainer : null);
        if (!Flags.HAS_ANNOTATIONS.get(this.classProto.getFlags()).booleanValue()) {
            annotations = Annotations.Companion.getEMPTY();
        } else {
            deserializedClassDescriptor = this;
            annotations = new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new DeserializedClassDescriptor$$Lambda$5(deserializedClassDescriptor));
        }
        this.annotations = annotations;
    }

    @NotNull
    public final ProtoBuf.Class getClassProto() {
        return this.classProto;
    }

    @NotNull
    public final BinaryVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    @NotNull
    public final DeserializationContext getC() {
        return this.c;
    }

    private final DeserializedClassMemberScope getMemberScope() {
        return this.memberScopeHolder.getScope(this.c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner());
    }

    @NotNull
    public final ProtoContainer.Class getThisAsProtoContainer$deserialization() {
        return this.thisAsProtoContainer;
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @Override
    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    @Override
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
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
        return this.visibility;
    }

    @Override
    public boolean isInner() {
        Boolean bl2 = Flags.IS_INNER.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bl2, "get(...)");
        return bl2;
    }

    @Override
    public boolean isData() {
        Boolean bl2 = Flags.IS_DATA.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bl2, "get(...)");
        return bl2;
    }

    @Override
    public boolean isInline() {
        return Flags.IS_VALUE_CLASS.get(this.classProto.getFlags()) != false && this.metadataVersion.isAtMost(1, 4, 1);
    }

    @Override
    public boolean isExpect() {
        Boolean bl2 = Flags.IS_EXPECT_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bl2, "get(...)");
        return bl2;
    }

    @Override
    public boolean isActual() {
        return false;
    }

    @Override
    public boolean isExternal() {
        Boolean bl2 = Flags.IS_EXTERNAL_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bl2, "get(...)");
        return bl2;
    }

    @Override
    public boolean isFun() {
        Boolean bl2 = Flags.IS_FUN_INTERFACE.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bl2, "get(...)");
        return bl2;
    }

    @Override
    public boolean isValue() {
        return Flags.IS_VALUE_CLASS.get(this.classProto.getFlags()) != false && this.metadataVersion.isAtLeast(1, 4, 2);
    }

    @Override
    @NotNull
    protected MemberScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.memberScopeHolder.getScope(kotlinTypeRefiner);
    }

    @Override
    @NotNull
    public MemberScopeImpl getStaticScope() {
        return this.staticScope;
    }

    @Override
    public boolean isCompanionObject() {
        return Flags.CLASS_KIND.get(this.classProto.getFlags()) == ProtoBuf.Class.Kind.COMPANION_OBJECT;
    }

    private final ClassConstructorDescriptor computePrimaryConstructor() {
        ClassConstructorDescriptor classConstructorDescriptor;
        Object v1;
        block4: {
            if (this.kind.isSingleton()) {
                ClassConstructorDescriptorImpl classConstructorDescriptorImpl;
                ClassConstructorDescriptorImpl $this$computePrimaryConstructor_u24lambda_u246 = classConstructorDescriptorImpl = DescriptorFactory.createPrimaryConstructorForObject(this, SourceElement.NO_SOURCE);
                boolean bl2 = false;
                $this$computePrimaryConstructor_u24lambda_u246.setReturnType(this.getDefaultType());
                return classConstructorDescriptorImpl;
            }
            List<ProtoBuf.Constructor> list = this.classProto.getConstructorList();
            Intrinsics.checkNotNullExpressionValue(list, "getConstructorList(...)");
            Iterable $this$firstOrNull$iv = list;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                ProtoBuf.Constructor it = (ProtoBuf.Constructor)element$iv;
                boolean bl3 = false;
                if (!(Flags.IS_SECONDARY.get(it.getFlags()) == false)) continue;
                v1 = element$iv;
                break block4;
            }
            v1 = null;
        }
        ProtoBuf.Constructor constructor = v1;
        if (constructor != null) {
            ProtoBuf.Constructor constructorProto = constructor;
            boolean bl4 = false;
            classConstructorDescriptor = this.c.getMemberDeserializer().loadConstructor(constructorProto, true);
        } else {
            classConstructorDescriptor = null;
        }
        return classConstructorDescriptor;
    }

    @Override
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor)this.primaryConstructor.invoke();
    }

    private final Collection<ClassConstructorDescriptor> computeConstructors() {
        return CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)this.computeSecondaryConstructors(), (Iterable)CollectionsKt.listOfNotNull(this.getUnsubstitutedPrimaryConstructor())), (Iterable)this.c.getComponents().getAdditionalClassPartsProvider().getConstructors(this));
    }

    /*
     * WARNING - void declaration
     */
    private final List<ClassConstructorDescriptor> computeSecondaryConstructors() {
        void $this$mapTo$iv$iv;
        ProtoBuf.Constructor it;
        Iterable $this$filterTo$iv$iv;
        List<ProtoBuf.Constructor> list = this.classProto.getConstructorList();
        Intrinsics.checkNotNullExpressionValue(list, "getConstructorList(...)");
        Iterable $this$filter$iv = list;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (ProtoBuf.Constructor)element$iv$iv;
            boolean bl2 = false;
            Boolean bl3 = Flags.IS_SECONDARY.get(it.getFlags());
            Intrinsics.checkNotNullExpressionValue(bl3, "get(...)");
            if (!bl3.booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$map$iv = (List)destination$iv$iv;
        boolean $i$f$map = false;
        $this$filterTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            it = (ProtoBuf.Constructor)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl4 = false;
            MemberDeserializer memberDeserializer = this.c.getMemberDeserializer();
            Intrinsics.checkNotNull(it);
            collection.add(memberDeserializer.loadConstructor(it, false));
        }
        return (List)destination$iv$iv;
    }

    @Override
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors() {
        return (Collection)this.constructors.invoke();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<ReceiverParameterDescriptor> getContextReceivers() {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = ProtoTypeTableUtilKt.contextReceiverTypes(this.classProto, this.c.getTypeTable());
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            ProtoBuf.Type type = (ProtoBuf.Type)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            KotlinType contextReceiverType = this.c.getTypeDeserializer().type((ProtoBuf.Type)it);
            collection.add(new ReceiverParameterDescriptorImpl(this.getThisAsReceiverParameter(), new ContextClassReceiver(this, contextReceiverType, null, null), Annotations.Companion.getEMPTY()));
        }
        return (List)destination$iv$iv;
    }

    private final ClassDescriptor computeCompanionObjectDescriptor() {
        if (!this.classProto.hasCompanionObjectName()) {
            return null;
        }
        Name companionObjectName = NameResolverUtilKt.getName(this.c.getNameResolver(), this.classProto.getCompanionObjectName());
        ClassifierDescriptor classifierDescriptor = this.getMemberScope().getContributedClassifier(companionObjectName, NoLookupLocation.FROM_DESERIALIZATION);
        return classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
    }

    @Override
    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor() {
        return (ClassDescriptor)this.companionObjectDescriptor.invoke();
    }

    public final boolean hasNestedClass$deserialization(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.getMemberScope().getClassNames$deserialization().contains(name);
    }

    /*
     * WARNING - void declaration
     */
    private final Collection<ClassDescriptor> computeSubclassesForSealedClass() {
        if (this.modality != Modality.SEALED) {
            return CollectionsKt.emptyList();
        }
        List<Integer> fqNames = this.classProto.getSealedSubclassFqNameList();
        Intrinsics.checkNotNull(fqNames);
        if (!((Collection)fqNames).isEmpty()) {
            void $this$mapNotNullTo$iv$iv;
            Iterable $this$mapNotNull$iv = fqNames;
            boolean $i$f$mapNotNull = false;
            Iterable iterable = $this$mapNotNull$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$mapNotNullTo = false;
            void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
            while (iterator2.hasNext()) {
                ClassDescriptor it$iv$iv;
                Object element$iv$iv$iv;
                Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                boolean bl2 = false;
                Integer index = (Integer)element$iv$iv;
                boolean bl3 = false;
                DeserializationComponents deserializationComponents = this.c.getComponents();
                NameResolver nameResolver = this.c.getNameResolver();
                Intrinsics.checkNotNull(index);
                if (deserializationComponents.deserializeClass(NameResolverUtilKt.getClassId(nameResolver, index)) == null) continue;
                boolean bl4 = false;
                destination$iv$iv.add(it$iv$iv);
            }
            return (List)destination$iv$iv;
        }
        return CliSealedClassInheritorsProvider.INSTANCE.computeSealedSubclasses(this, false);
    }

    @Override
    @Nullable
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return (ValueClassRepresentation)this.valueClassRepresentation.invoke();
    }

    private final ValueClassRepresentation<SimpleType> computeValueClassRepresentation() {
        if (!this.isInline() && !this.isValue()) {
            return null;
        }
        ValueClassRepresentation<SimpleType> valueClassRepresentation = ValueClassUtilKt.loadValueClassRepresentation(this.classProto, this.c.getNameResolver(), this.c.getTypeTable(), (Function1)new Function1<ProtoBuf.Type, SimpleType>((Object)this.c.getTypeDeserializer()){

            public final SimpleType invoke(ProtoBuf.Type p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                return TypeDeserializer.simpleType$default((TypeDeserializer)this.receiver, p0, false, 2, null);
            }
        }, (Function1)new Function1<Name, SimpleType>((Object)this){

            public final SimpleType invoke(Name p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                return DeserializedClassDescriptor.access$getValueClassPropertyType((DeserializedClassDescriptor)this.receiver, p0);
            }
        });
        if (valueClassRepresentation != null) {
            ValueClassRepresentation<SimpleType> it = valueClassRepresentation;
            boolean bl2 = false;
            return it;
        }
        if (!this.metadataVersion.isAtLeast(1, 5, 1)) {
            ClassConstructorDescriptor classConstructorDescriptor = this.getUnsubstitutedPrimaryConstructor();
            if (classConstructorDescriptor == null) {
                throw new IllegalStateException(("Inline class has no primary constructor: " + this).toString());
            }
            ClassConstructorDescriptor constructor = classConstructorDescriptor;
            List<ValueParameterDescriptor> list = constructor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
            Name name = CollectionsKt.first(list).getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            Name propertyName = name;
            SimpleType simpleType = this.getValueClassPropertyType(propertyName);
            if (simpleType == null) {
                throw new IllegalStateException(("Value class has no underlying property: " + this).toString());
            }
            SimpleType propertyType = simpleType;
            return new InlineClassRepresentation<RigidTypeMarker>(propertyName, propertyType);
        }
        return null;
    }

    private final SimpleType getValueClassPropertyType(Name propertyName) {
        Object v0;
        block2: {
            Iterable $this$singleOrNull$iv = this.getMemberScope().getContributedVariables(propertyName, NoLookupLocation.FROM_DESERIALIZATION);
            boolean $i$f$singleOrNull = false;
            Object single$iv = null;
            boolean found$iv = false;
            for (Object element$iv : $this$singleOrNull$iv) {
                PropertyDescriptor it = (PropertyDescriptor)element$iv;
                boolean bl2 = false;
                if (!(it.getExtensionReceiverParameter() == null)) continue;
                if (found$iv) {
                    v0 = null;
                    break block2;
                }
                single$iv = element$iv;
                found$iv = true;
            }
            v0 = !found$iv ? null : single$iv;
        }
        PropertyDescriptor propertyDescriptor = v0;
        return (SimpleType)(propertyDescriptor != null ? propertyDescriptor.getType() : null);
    }

    @NotNull
    public String toString() {
        return "deserialized " + (this.isExpect() ? "expect " : "") + "class " + this.getName();
    }

    @Override
    @NotNull
    public SourceElement getSource() {
        return this.sourceElement;
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.c.getTypeDeserializer().getOwnTypeParameters();
    }

    private static final ClassConstructorDescriptor primaryConstructor$lambda$0(DeserializedClassDescriptor this$0) {
        return this$0.computePrimaryConstructor();
    }

    private static final Collection constructors$lambda$1(DeserializedClassDescriptor this$0) {
        return this$0.computeConstructors();
    }

    private static final ClassDescriptor companionObjectDescriptor$lambda$2(DeserializedClassDescriptor this$0) {
        return this$0.computeCompanionObjectDescriptor();
    }

    private static final Collection sealedSubclasses$lambda$3(DeserializedClassDescriptor this$0) {
        return this$0.computeSubclassesForSealedClass();
    }

    private static final ValueClassRepresentation valueClassRepresentation$lambda$4(DeserializedClassDescriptor this$0) {
        return this$0.computeValueClassRepresentation();
    }

    private static final List annotations$lambda$5(DeserializedClassDescriptor this$0) {
        return CollectionsKt.toList(this$0.c.getComponents().getAnnotationAndConstantLoader().loadClassAnnotations(this$0.thisAsProtoContainer));
    }

    public static final /* synthetic */ SimpleType access$getValueClassPropertyType(DeserializedClassDescriptor $this, Name propertyName) {
        return $this.getValueClassPropertyType(propertyName);
    }

    static /* synthetic */ ClassConstructorDescriptor accessor$DeserializedClassDescriptor$lambda0(DeserializedClassDescriptor deserializedClassDescriptor) {
        return DeserializedClassDescriptor.primaryConstructor$lambda$0(deserializedClassDescriptor);
    }

    static /* synthetic */ Collection accessor$DeserializedClassDescriptor$lambda1(DeserializedClassDescriptor deserializedClassDescriptor) {
        return DeserializedClassDescriptor.constructors$lambda$1(deserializedClassDescriptor);
    }

    static /* synthetic */ ClassDescriptor accessor$DeserializedClassDescriptor$lambda2(DeserializedClassDescriptor deserializedClassDescriptor) {
        return DeserializedClassDescriptor.companionObjectDescriptor$lambda$2(deserializedClassDescriptor);
    }

    static /* synthetic */ Collection accessor$DeserializedClassDescriptor$lambda3(DeserializedClassDescriptor deserializedClassDescriptor) {
        return DeserializedClassDescriptor.sealedSubclasses$lambda$3(deserializedClassDescriptor);
    }

    static /* synthetic */ ValueClassRepresentation accessor$DeserializedClassDescriptor$lambda4(DeserializedClassDescriptor deserializedClassDescriptor) {
        return DeserializedClassDescriptor.valueClassRepresentation$lambda$4(deserializedClassDescriptor);
    }

    static /* synthetic */ List accessor$DeserializedClassDescriptor$lambda5(DeserializedClassDescriptor deserializedClassDescriptor) {
        return DeserializedClassDescriptor.annotations$lambda$5(deserializedClassDescriptor);
    }

    @SourceDebugExtension(value={"SMAP\nDeserializedClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$DeserializedClassMemberScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n*L\n1#1,429:1\n1563#2:430\n1634#2,3:431\n1460#2,5:435\n1460#2,5:440\n1#3:434\n211#4,5:445\n*S KotlinDebug\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$DeserializedClassMemberScope\n*L\n274#1:430\n274#1:431,3\n354#1:435,5\n360#1:440,5\n366#1:445,5\n*E\n"})
    private final class DeserializedClassMemberScope
    extends DeserializedMemberScope {
        @NotNull
        private final KotlinTypeRefiner kotlinTypeRefiner;
        @NotNull
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
        @NotNull
        private final NotNullLazyValue<Collection<KotlinType>> refinedSupertypes;

        /*
         * WARNING - void declaration
         */
        public DeserializedClassMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
            void it;
            Object object;
            void $this$mapTo$iv$iv;
            void $this$map$iv;
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            DeserializationContext deserializationContext = DeserializedClassDescriptor.this.getC();
            List<ProtoBuf.Function> list = DeserializedClassDescriptor.this.getClassProto().getFunctionList();
            Intrinsics.checkNotNullExpressionValue(list, "getFunctionList(...)");
            List<ProtoBuf.Property> list2 = DeserializedClassDescriptor.this.getClassProto().getPropertyList();
            Intrinsics.checkNotNullExpressionValue(list2, "getPropertyList(...)");
            List<ProtoBuf.TypeAlias> list3 = DeserializedClassDescriptor.this.getClassProto().getTypeAliasList();
            Intrinsics.checkNotNullExpressionValue(list3, "getTypeAliasList(...)");
            List<Integer> list4 = DeserializedClassDescriptor.this.getClassProto().getNestedClassNameList();
            Intrinsics.checkNotNullExpressionValue(list4, "getNestedClassNameList(...)");
            Iterable iterable = list4;
            Object object2 = DeserializedClassDescriptor.this.getC().getNameResolver();
            List<ProtoBuf.TypeAlias> list5 = list3;
            List<ProtoBuf.Property> list6 = list2;
            List<ProtoBuf.Function> list7 = list;
            DeserializationContext deserializationContext2 = deserializationContext;
            DeserializedClassMemberScope deserializedClassMemberScope = this;
            boolean $i$f$map = false;
            void var6_11 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void p0;
                int n2 = ((Number)item$iv$iv).intValue();
                object = destination$iv$iv;
                boolean bl2 = false;
                object.add(NameResolverUtilKt.getName((NameResolver)object2, (int)p0));
            }
            object2 = object = (List)destination$iv$iv;
            boolean bl3 = false;
            DeserializedClassMemberScope deserializedClassMemberScope2 = it;
            object = new DeserializedClassDescriptor$DeserializedClassMemberScope$$Lambda$0((List)((Object)deserializedClassMemberScope2));
            super(deserializationContext2, list7, list6, list5, (Function0<? extends Collection<Name>>)object);
            this.kotlinTypeRefiner = kotlinTypeRefiner;
            deserializedClassMemberScope2 = this;
            this.allDescriptors = this.getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassMemberScope$$Lambda$1(deserializedClassMemberScope2));
            deserializedClassMemberScope2 = this;
            this.refinedSupertypes = this.getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassMemberScope$$Lambda$2(deserializedClassMemberScope2));
        }

        private final DeserializedClassDescriptor getClassDescriptor() {
            return DeserializedClassDescriptor.this;
        }

        @Override
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
            Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
            return (Collection)this.allDescriptors.invoke();
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
        protected boolean isDeclaredFunctionAvailable(@NotNull SimpleFunctionDescriptor function) {
            Intrinsics.checkNotNullParameter(function, "function");
            return this.getC().getComponents().getPlatformDependentDeclarationFilter().isFunctionAvailable(DeserializedClassDescriptor.this, function);
        }

        @Override
        protected void computeNonDeclaredFunctions(@NotNull Name name, @NotNull List<SimpleFunctionDescriptor> functions) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(functions, "functions");
            ArrayList<? extends SimpleFunctionDescriptor> fromSupertypes = new ArrayList<SimpleFunctionDescriptor>();
            for (KotlinType supertype : (Collection)this.refinedSupertypes.invoke()) {
                fromSupertypes.addAll(supertype.getMemberScope().getContributedFunctions(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            functions.addAll(this.getC().getComponents().getAdditionalClassPartsProvider().getFunctions(name, DeserializedClassDescriptor.this));
            this.generateFakeOverrides(name, (Collection)fromSupertypes, functions);
        }

        @Override
        protected void computeNonDeclaredProperties(@NotNull Name name, @NotNull List<PropertyDescriptor> descriptors) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(descriptors, "descriptors");
            ArrayList<? extends PropertyDescriptor> fromSupertypes = new ArrayList<PropertyDescriptor>();
            for (KotlinType supertype : (Collection)this.refinedSupertypes.invoke()) {
                fromSupertypes.addAll(supertype.getMemberScope().getContributedVariables(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            this.generateFakeOverrides(name, (Collection)fromSupertypes, descriptors);
        }

        private final <D extends CallableMemberDescriptor> void generateFakeOverrides(Name name, Collection<? extends D> fromSupertypes, List<D> result) {
            ArrayList fromCurrent = new ArrayList(result);
            this.getC().getComponents().getKotlinTypeChecker().getOverridingUtil().generateOverridesInFunctionGroup(name, fromSupertypes, fromCurrent, this.getClassDescriptor(), new NonReportingOverrideStrategy(result){
                final /* synthetic */ List<D> $result;
                {
                    this.$result = $result;
                }

                public void addFakeOverride(CallableMemberDescriptor fakeOverride) {
                    Intrinsics.checkNotNullParameter(fakeOverride, "fakeOverride");
                    OverridingUtil.resolveUnknownVisibilityForMember(fakeOverride, null);
                    this.$result.add(fakeOverride);
                }

                protected void conflict(CallableMemberDescriptor fromSuper, CallableMemberDescriptor fromCurrent) {
                    Intrinsics.checkNotNullParameter(fromSuper, "fromSuper");
                    Intrinsics.checkNotNullParameter(fromCurrent, "fromCurrent");
                    if (fromCurrent instanceof FunctionDescriptorImpl) {
                        ((FunctionDescriptorImpl)fromCurrent).putInUserDataMap(DeserializedDeclarationsFromSupertypeConflictDataKey.INSTANCE, fromSuper);
                    }
                }
            });
        }

        /*
         * WARNING - void declaration
         */
        @Override
        @NotNull
        protected Set<Name> getNonDeclaredFunctionNames() {
            DeserializedClassDescriptor deserializedClassDescriptor;
            void $this$flatMapTo$iv;
            Iterable iterable = this.getClassDescriptor().typeConstructor.getSupertypes();
            Collection destination$iv = new LinkedHashSet();
            boolean $i$f$flatMapTo = false;
            for (Object element$iv : $this$flatMapTo$iv) {
                KotlinType it = (KotlinType)element$iv;
                boolean bl2 = false;
                Iterable list$iv = it.getMemberScope().getFunctionNames();
                CollectionsKt.addAll(destination$iv, list$iv);
            }
            iterable = deserializedClassDescriptor;
            deserializedClassDescriptor = DeserializedClassDescriptor.this;
            LinkedHashSet $this$getNonDeclaredFunctionNames_u24lambda_u245 = (LinkedHashSet)iterable;
            boolean bl3 = false;
            $this$getNonDeclaredFunctionNames_u24lambda_u245.addAll(this.getC().getComponents().getAdditionalClassPartsProvider().getFunctionsNames(deserializedClassDescriptor));
            return (Set)iterable;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        @NotNull
        protected Set<Name> getNonDeclaredVariableNames() {
            void var2_2;
            void $this$flatMapTo$iv;
            Iterable iterable = this.getClassDescriptor().typeConstructor.getSupertypes();
            Collection destination$iv = new LinkedHashSet();
            boolean $i$f$flatMapTo = false;
            for (Object element$iv : $this$flatMapTo$iv) {
                KotlinType it = (KotlinType)element$iv;
                boolean bl2 = false;
                Iterable list$iv = it.getMemberScope().getVariableNames();
                CollectionsKt.addAll(destination$iv, list$iv);
            }
            return (Set)var2_2;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        @Nullable
        protected Set<Name> getNonDeclaredClassifierNames() {
            Object v0;
            block2: {
                void var2_2;
                void $this$flatMapToNullable$iv;
                Iterable iterable = this.getClassDescriptor().typeConstructor.getSupertypes();
                Collection destination$iv = new LinkedHashSet();
                boolean $i$f$flatMapToNullable = false;
                for (Object element$iv : $this$flatMapToNullable$iv) {
                    Iterable list$iv;
                    KotlinType it = (KotlinType)element$iv;
                    boolean bl2 = false;
                    if ((Iterable)it.getMemberScope().getClassifierNames() == null) {
                        v0 = null;
                        break block2;
                    }
                    CollectionsKt.addAll(destination$iv, list$iv);
                }
                v0 = var2_2;
            }
            return v0;
        }

        @Override
        @Nullable
        public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation location) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(location, "location");
            this.recordLookup(name, location);
            Object object = this.getClassDescriptor().enumEntries;
            if (object != null && (object = ((EnumEntryClassDescriptors)object).findEnumEntry(name)) != null) {
                Object it = object;
                boolean bl2 = false;
                return (ClassifierDescriptor)it;
            }
            return super.getContributedClassifier(name, location);
        }

        @Override
        @NotNull
        protected ClassId createClassId(@NotNull Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return DeserializedClassDescriptor.this.classId.createNestedClassId(name);
        }

        @Override
        protected void addEnumEntryDescriptors(@NotNull Collection<DeclarationDescriptor> result, @NotNull Function1<? super Name, Boolean> nameFilter) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
            EnumEntryClassDescriptors enumEntryClassDescriptors = this.getClassDescriptor().enumEntries;
            Collection collection = enumEntryClassDescriptors != null ? enumEntryClassDescriptors.all() : null;
            if (collection == null) {
                collection = CollectionsKt.emptyList();
            }
            result.addAll(collection);
        }

        @Override
        public void recordLookup(@NotNull Name name, @NotNull LookupLocation location) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(location, "location");
            UtilsKt.record(this.getC().getComponents().getLookupTracker(), location, this.getClassDescriptor(), name);
        }

        private static final List _init_$lambda$1$lambda$0(List $it) {
            return $it;
        }

        private static final Collection allDescriptors$lambda$2(DeserializedClassMemberScope this$0) {
            return this$0.computeDescriptors(DescriptorKindFilter.ALL, MemberScope.Companion.getALL_NAME_FILTER(), NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        }

        private static final Collection refinedSupertypes$lambda$3(DeserializedClassMemberScope this$0) {
            return this$0.kotlinTypeRefiner.refineSupertypes(this$0.getClassDescriptor());
        }

        static /* synthetic */ List accessor$DeserializedClassDescriptor$DeserializedClassMemberScope$lambda0(List list) {
            return DeserializedClassMemberScope._init_$lambda$1$lambda$0(list);
        }

        static /* synthetic */ Collection accessor$DeserializedClassDescriptor$DeserializedClassMemberScope$lambda1(DeserializedClassMemberScope deserializedClassMemberScope) {
            return DeserializedClassMemberScope.allDescriptors$lambda$2(deserializedClassMemberScope);
        }

        static /* synthetic */ Collection accessor$DeserializedClassDescriptor$DeserializedClassMemberScope$lambda2(DeserializedClassMemberScope deserializedClassMemberScope) {
            return DeserializedClassMemberScope.refinedSupertypes$lambda$3(deserializedClassMemberScope);
        }
    }

    @SourceDebugExtension(value={"SMAP\nDeserializedClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$DeserializedClassTypeConstructor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,429:1\n1563#2:430\n1634#2,3:431\n1617#2,9:434\n1869#2:443\n1870#2:445\n1626#2:446\n1563#2:447\n1634#2,3:448\n1#3:444\n*S KotlinDebug\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$DeserializedClassTypeConstructor\n*L\n241#1:430\n241#1:431,3\n245#1:434,9\n245#1:443\n245#1:445\n245#1:446\n252#1:447\n252#1:448,3\n245#1:444\n*E\n"})
    private final class DeserializedClassTypeConstructor
    extends AbstractClassTypeConstructor {
        @NotNull
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;

        public DeserializedClassTypeConstructor() {
            super(DeserializedClassDescriptor.this.getC().getStorageManager());
            DeserializedClassDescriptor deserializedClassDescriptor = DeserializedClassDescriptor.this;
            this.parameters = DeserializedClassDescriptor.this.getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassTypeConstructor$$Lambda$0(deserializedClassDescriptor));
        }

        /*
         * WARNING - void declaration
         */
        @Override
        @NotNull
        protected Collection<KotlinType> computeSupertypes() {
            void $this$mapNotNullTo$iv$iv;
            Object supertypeProto;
            Object object;
            Iterable $this$mapTo$iv$iv;
            void $this$map$iv;
            Iterable iterable = ProtoTypeTableUtilKt.supertypes(DeserializedClassDescriptor.this.getClassProto(), DeserializedClassDescriptor.this.getC().getTypeTable());
            DeserializedClassDescriptor deserializedClassDescriptor = DeserializedClassDescriptor.this;
            boolean $i$f$map = false;
            void var5_4 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                ProtoBuf.Type type = (ProtoBuf.Type)item$iv$iv;
                object = destination$iv$iv;
                boolean bl2 = false;
                object.add(deserializedClassDescriptor.getC().getTypeDeserializer().type((ProtoBuf.Type)supertypeProto));
            }
            List result = CollectionsKt.plus((Collection)((List)destination$iv$iv), (Iterable)DeserializedClassDescriptor.this.getC().getComponents().getAdditionalClassPartsProvider().getSupertypes(DeserializedClassDescriptor.this));
            Iterable $this$mapNotNull$iv = result;
            boolean $i$f$mapNotNull = false;
            $this$mapTo$iv$iv = $this$mapNotNull$iv;
            destination$iv$iv = new ArrayList();
            boolean $i$f$mapNotNullTo = false;
            void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            boolean $i$f$forEach = false;
            supertypeProto = $this$forEach$iv$iv$iv.iterator();
            while (supertypeProto.hasNext()) {
                NotFoundClasses.MockClassDescriptor it$iv$iv;
                Object element$iv$iv$iv;
                Object element$iv$iv = element$iv$iv$iv = supertypeProto.next();
                boolean bl3 = false;
                KotlinType supertype = (KotlinType)element$iv$iv;
                boolean bl4 = false;
                ClassifierDescriptor classifierDescriptor = supertype.getConstructor().getDeclarationDescriptor();
                if ((classifierDescriptor instanceof NotFoundClasses.MockClassDescriptor ? (NotFoundClasses.MockClassDescriptor)classifierDescriptor : null) == null) continue;
                it$iv$iv = it$iv$iv;
                boolean bl5 = false;
                destination$iv$iv.add(it$iv$iv);
            }
            List unresolved = (List)destination$iv$iv;
            if (!((Collection)unresolved).isEmpty()) {
                Collection<Object> collection;
                void $this$map$iv2;
                $this$mapNotNull$iv = unresolved;
                ClassDescriptor classDescriptor = DeserializedClassDescriptor.this;
                object = DeserializedClassDescriptor.this.getC().getComponents().getErrorReporter();
                $i$f$map = false;
                $this$mapNotNullTo$iv$iv = $this$map$iv2;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void it;
                    supertypeProto = (NotFoundClasses.MockClassDescriptor)item$iv$iv;
                    collection = destination$iv$iv;
                    boolean bl6 = false;
                    Object object2 = DescriptorUtilsKt.getClassId((ClassifierDescriptor)it);
                    if (object2 == null || (object2 = ((ClassId)object2).asSingleFqName()) == null || (object2 = ((FqName)object2).asString()) == null) {
                        String string = it.getName().asString();
                        object2 = string;
                        Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
                    }
                    collection.add(object2);
                }
                collection = (List)destination$iv$iv;
                object.reportIncompleteHierarchy(classDescriptor, (List<String>)collection);
            }
            return CollectionsKt.toList(result);
        }

        @Override
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return (List)this.parameters.invoke();
        }

        @Override
        public boolean isDenotable() {
            return true;
        }

        @Override
        @NotNull
        public DeserializedClassDescriptor getDeclarationDescriptor() {
            return DeserializedClassDescriptor.this;
        }

        @NotNull
        public String toString() {
            String string = DeserializedClassDescriptor.this.getName().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        @Override
        @NotNull
        protected SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }

        private static final List parameters$lambda$0(DeserializedClassDescriptor this$0) {
            return TypeParameterUtilsKt.computeConstructorTypeParameters(this$0);
        }

        static /* synthetic */ List accessor$DeserializedClassDescriptor$DeserializedClassTypeConstructor$lambda0(DeserializedClassDescriptor deserializedClassDescriptor) {
            return DeserializedClassTypeConstructor.parameters$lambda$0(deserializedClassDescriptor);
        }
    }

    @SourceDebugExtension(value={"SMAP\nDeserializedClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$EnumEntryClassDescriptors\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,429:1\n1208#2,2:430\n1236#2,4:432\n1634#2,3:436\n1634#2,3:439\n1617#2,9:442\n1869#2:451\n1870#2:453\n1626#2:454\n1#3:452\n*S KotlinDebug\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$EnumEntryClassDescriptors\n*L\n389#1:430,2\n389#1:432,4\n421#1:436,3\n422#1:439,3\n426#1:442,9\n426#1:451\n426#1:453\n426#1:454\n426#1:452\n*E\n"})
    private final class EnumEntryClassDescriptors {
        @NotNull
        private final Map<Name, ProtoBuf.EnumEntry> enumEntryProtos;
        @NotNull
        private final MemoizedFunctionToNullable<Name, ClassDescriptor> enumEntryByName;
        @NotNull
        private final NotNullLazyValue<Set<Name>> enumMemberNames;

        /*
         * WARNING - void declaration
         */
        public EnumEntryClassDescriptors() {
            void $this$associateByTo$iv$iv;
            void $this$associateBy$iv;
            List<ProtoBuf.EnumEntry> list = DeserializedClassDescriptor.this.getClassProto().getEnumEntryList();
            Intrinsics.checkNotNullExpressionValue(list, "getEnumEntryList(...)");
            Iterable iterable = list;
            DeserializedClassDescriptor deserializedClassDescriptor = DeserializedClassDescriptor.this;
            EnumEntryClassDescriptors enumEntryClassDescriptors = this;
            boolean $i$f$associateBy = false;
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
            void var6_7 = $this$associateBy$iv;
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            boolean $i$f$associateByTo = false;
            for (Object element$iv$iv : $this$associateByTo$iv$iv) {
                void it;
                ProtoBuf.EnumEntry enumEntry = (ProtoBuf.EnumEntry)element$iv$iv;
                Map map = destination$iv$iv;
                boolean bl2 = false;
                map.put(NameResolverUtilKt.getName(deserializedClassDescriptor.getC().getNameResolver(), it.getName()), element$iv$iv);
            }
            enumEntryClassDescriptors.enumEntryProtos = destination$iv$iv;
            Object object = DeserializedClassDescriptor.this;
            EnumEntryClassDescriptors enumEntryClassDescriptors2 = this;
            this.enumEntryByName = DeserializedClassDescriptor.this.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new DeserializedClassDescriptor$EnumEntryClassDescriptors$$Lambda$0(enumEntryClassDescriptors2, (DeserializedClassDescriptor)object));
            object = this;
            this.enumMemberNames = DeserializedClassDescriptor.this.getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$EnumEntryClassDescriptors$$Lambda$1((EnumEntryClassDescriptors)object));
        }

        @Nullable
        public final ClassDescriptor findEnumEntry(@NotNull Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return (ClassDescriptor)this.enumEntryByName.invoke(name);
        }

        private final Set<Name> computeEnumMemberNames() {
            ProtoBuf.Property it;
            Collection collection;
            Iterable $this$mapTo$iv;
            HashSet<Name> result = new HashSet<Name>();
            for (KotlinType supertype : DeserializedClassDescriptor.this.getTypeConstructor().getSupertypes()) {
                for (DeclarationDescriptor descriptor2 : ResolutionScope.DefaultImpls.getContributedDescriptors$default(supertype.getMemberScope(), null, null, 3, null)) {
                    if (!(descriptor2 instanceof SimpleFunctionDescriptor) && !(descriptor2 instanceof PropertyDescriptor)) continue;
                    result.add(((CallableMemberDescriptor)descriptor2).getName());
                }
            }
            List<ProtoBuf.Function> list = DeserializedClassDescriptor.this.getClassProto().getFunctionList();
            Intrinsics.checkNotNullExpressionValue(list, "getFunctionList(...)");
            Iterable iterable = list;
            DeserializedClassDescriptor deserializedClassDescriptor = DeserializedClassDescriptor.this;
            boolean $i$f$mapTo = false;
            for (Object item$iv : $this$mapTo$iv) {
                ProtoBuf.Function function = (ProtoBuf.Function)item$iv;
                collection = result;
                boolean bl2 = false;
                collection.add(NameResolverUtilKt.getName(deserializedClassDescriptor.getC().getNameResolver(), ((ProtoBuf.Function)((Object)it)).getName()));
            }
            Set set = (Set)((Collection)result);
            List<ProtoBuf.Property> list2 = DeserializedClassDescriptor.this.getClassProto().getPropertyList();
            Intrinsics.checkNotNullExpressionValue(list2, "getPropertyList(...)");
            $this$mapTo$iv = list2;
            deserializedClassDescriptor = DeserializedClassDescriptor.this;
            collection = set;
            $i$f$mapTo = false;
            for (Object item$iv : $this$mapTo$iv) {
                it = (ProtoBuf.Property)item$iv;
                Collection collection2 = result;
                boolean bl3 = false;
                collection2.add(NameResolverUtilKt.getName(deserializedClassDescriptor.getC().getNameResolver(), it.getName()));
            }
            return SetsKt.plus(collection, (Iterable)result);
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final Collection<ClassDescriptor> all() {
            void $this$mapNotNullTo$iv$iv;
            Iterable $this$mapNotNull$iv = this.enumEntryProtos.keySet();
            boolean $i$f$mapNotNull = false;
            Iterable iterable = $this$mapNotNull$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$mapNotNullTo = false;
            void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
            while (iterator2.hasNext()) {
                ClassDescriptor it$iv$iv;
                Object element$iv$iv$iv;
                Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                boolean bl2 = false;
                Name name = (Name)element$iv$iv;
                boolean bl3 = false;
                if (this.findEnumEntry(name) == null) continue;
                boolean bl4 = false;
                destination$iv$iv.add(it$iv$iv);
            }
            return (List)destination$iv$iv;
        }

        private static final List enumEntryByName$lambda$3$lambda$2$lambda$1(DeserializedClassDescriptor this$0, ProtoBuf.EnumEntry $proto) {
            return CollectionsKt.toList(this$0.getC().getComponents().getAnnotationAndConstantLoader().loadEnumEntryAnnotations(this$0.getThisAsProtoContainer$deserialization(), $proto));
        }

        private static final ClassDescriptor enumEntryByName$lambda$3(EnumEntryClassDescriptors this$0, DeserializedClassDescriptor this$1, Name name) {
            EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor;
            Intrinsics.checkNotNullParameter(name, "name");
            ProtoBuf.EnumEntry enumEntry = this$0.enumEntryProtos.get(name);
            if (enumEntry != null) {
                ProtoBuf.EnumEntry proto = enumEntry;
                boolean bl2 = false;
                ProtoBuf.EnumEntry enumEntry2 = proto;
                DeserializedClassDescriptor deserializedClassDescriptor = this$1;
                enumEntrySyntheticClassDescriptor = EnumEntrySyntheticClassDescriptor.create(this$1.getC().getStorageManager(), this$1, name, this$0.enumMemberNames, new DeserializedAnnotations(this$1.getC().getStorageManager(), new DeserializedClassDescriptor$EnumEntryClassDescriptors$$Lambda$2(deserializedClassDescriptor, enumEntry2)), SourceElement.NO_SOURCE);
            } else {
                enumEntrySyntheticClassDescriptor = null;
            }
            return enumEntrySyntheticClassDescriptor;
        }

        private static final Set enumMemberNames$lambda$4(EnumEntryClassDescriptors this$0) {
            return this$0.computeEnumMemberNames();
        }

        static /* synthetic */ ClassDescriptor accessor$DeserializedClassDescriptor$EnumEntryClassDescriptors$lambda0(EnumEntryClassDescriptors enumEntryClassDescriptors, DeserializedClassDescriptor deserializedClassDescriptor, Name name) {
            return EnumEntryClassDescriptors.enumEntryByName$lambda$3(enumEntryClassDescriptors, deserializedClassDescriptor, name);
        }

        static /* synthetic */ Set accessor$DeserializedClassDescriptor$EnumEntryClassDescriptors$lambda1(EnumEntryClassDescriptors enumEntryClassDescriptors) {
            return EnumEntryClassDescriptors.enumMemberNames$lambda$4(enumEntryClassDescriptors);
        }

        static /* synthetic */ List accessor$DeserializedClassDescriptor$EnumEntryClassDescriptors$lambda2(DeserializedClassDescriptor deserializedClassDescriptor, ProtoBuf.EnumEntry enumEntry) {
            return EnumEntryClassDescriptors.enumEntryByName$lambda$3$lambda$2$lambda$1(deserializedClassDescriptor, enumEntry);
        }
    }
}

