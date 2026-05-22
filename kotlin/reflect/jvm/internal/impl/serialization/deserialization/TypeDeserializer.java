/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.SuspendFunctionTypeUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$4;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializerKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nTypeDeserializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/TypeDeserializer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,300:1\n1563#2:301\n1634#2,3:302\n1573#2:305\n1604#2,4:306\n1563#2:311\n1634#2,3:312\n1#3:310\n*S KotlinDebug\n*F\n+ 1 TypeDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/TypeDeserializer\n*L\n76#1:301\n76#1:302,3\n105#1:305\n105#1:306,4\n246#1:311\n246#1:312,3\n*E\n"})
public final class TypeDeserializer {
    @NotNull
    private final DeserializationContext c;
    @Nullable
    private final TypeDeserializer parent;
    @NotNull
    private final String debugName;
    @NotNull
    private final String containerPresentableName;
    @NotNull
    private final Function1<Integer, ClassifierDescriptor> classifierDescriptors;
    @NotNull
    private final Function1<Integer, ClassifierDescriptor> typeAliasDescriptors;
    @NotNull
    private final Map<Integer, TypeParameterDescriptor> typeParameterDescriptors;

    public TypeDeserializer(@NotNull DeserializationContext c2, @Nullable TypeDeserializer parent, @NotNull List<ProtoBuf.TypeParameter> typeParameterProtos, @NotNull String debugName, @NotNull String containerPresentableName) {
        Map map;
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(typeParameterProtos, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(debugName, "debugName");
        Intrinsics.checkNotNullParameter(containerPresentableName, "containerPresentableName");
        this.c = c2;
        this.parent = parent;
        this.debugName = debugName;
        this.containerPresentableName = containerPresentableName;
        TypeDeserializer typeDeserializer = this;
        this.classifierDescriptors = this.c.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$$Lambda$0(typeDeserializer));
        typeDeserializer = this;
        this.typeAliasDescriptors = this.c.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$$Lambda$1(typeDeserializer));
        TypeDeserializer typeDeserializer2 = this;
        if (typeParameterProtos.isEmpty()) {
            map = MapsKt.emptyMap();
        } else {
            LinkedHashMap result = new LinkedHashMap();
            Iterator iterator2 = ((Iterable)typeParameterProtos).iterator();
            int n2 = 0;
            TypeDeserializer typeDeserializer3 = typeDeserializer2;
            while (iterator2.hasNext()) {
                int index = n2++;
                ProtoBuf.TypeParameter proto = (ProtoBuf.TypeParameter)iterator2.next();
                ((Map)result).put(proto.getId(), new DeserializedTypeParameterDescriptor(this.c, proto, index));
            }
            typeDeserializer2 = typeDeserializer3;
            map = result;
        }
        typeDeserializer2.typeParameterDescriptors = map;
    }

    @NotNull
    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        return CollectionsKt.toList((Iterable)this.typeParameterDescriptors.values());
    }

    @NotNull
    public final KotlinType type(@NotNull ProtoBuf.Type proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        if (proto.hasFlexibleTypeCapabilitiesId()) {
            String id = this.c.getNameResolver().getString(proto.getFlexibleTypeCapabilitiesId());
            SimpleType lowerBound = TypeDeserializer.simpleType$default(this, proto, false, 2, null);
            ProtoBuf.Type type = ProtoTypeTableUtilKt.flexibleUpperBound(proto, this.c.getTypeTable());
            Intrinsics.checkNotNull(type);
            SimpleType upperBound = TypeDeserializer.simpleType$default(this, type, false, 2, null);
            return this.c.getComponents().getFlexibleTypeDeserializer().create(proto, id, lowerBound, upperBound);
        }
        return this.simpleType(proto, true);
    }

    /*
     * WARNING - void declaration
     */
    private final TypeAttributes toAttributes(List<? extends TypeAttributeTranslator> $this$toAttributes, Annotations annotations, TypeConstructor constructor, DeclarationDescriptor containingDeclaration) {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = $this$toAttributes;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void translator;
            TypeAttributeTranslator typeAttributeTranslator = (TypeAttributeTranslator)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(translator.toAttributes(annotations, constructor, containingDeclaration));
        }
        List translated = CollectionsKt.flatten((List)destination$iv$iv);
        return TypeAttributes.Companion.create(translated);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final SimpleType simpleType(@NotNull ProtoBuf.Type proto, boolean expandTypeAliases) {
        Object object;
        block15: {
            SimpleType simpleType;
            block14: {
                SimpleType simpleType2;
                void $this$mapIndexedTo$iv$iv;
                SimpleType localClassifierType;
                Intrinsics.checkNotNullParameter(proto, "proto");
                SimpleType simpleType3 = localClassifierType = proto.hasClassName() ? this.computeLocalClassifierReplacementType(proto.getClassName()) : (proto.hasTypeAliasName() ? this.computeLocalClassifierReplacementType(proto.getTypeAliasName()) : null);
                if (simpleType3 != null) {
                    return simpleType3;
                }
                TypeConstructor constructor = this.typeConstructor(proto);
                if (ErrorUtils.isError(constructor.getDeclarationDescriptor())) {
                    String[] stringArray = new String[]{constructor.toString()};
                    return ErrorUtils.INSTANCE.createErrorType(ErrorTypeKind.TYPE_FOR_ERROR_TYPE_CONSTRUCTOR, constructor, stringArray);
                }
                ProtoBuf.Type type = proto;
                TypeDeserializer typeDeserializer = this;
                DeserializedAnnotations annotations = new DeserializedAnnotations(this.c.getStorageManager(), new TypeDeserializer$$Lambda$2(typeDeserializer, type));
                TypeAttributes attributes = this.toAttributes(this.c.getComponents().getTypeAttributeTranslators(), annotations, constructor, this.c.getContainingDeclaration());
                Iterable $this$mapIndexed$iv = TypeDeserializer.simpleType$collectAllArguments(proto, this);
                boolean $i$f$mapIndexed = false;
                Iterable iterable = $this$mapIndexed$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                boolean $i$f$mapIndexedTo = false;
                int index$iv$iv = 0;
                for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
                    void argumentProto;
                    void index;
                    int n2;
                    if ((n2 = index$iv$iv++) < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ProtoBuf.Type.Argument argument = (ProtoBuf.Type.Argument)item$iv$iv;
                    int n3 = n2;
                    Collection collection = destination$iv$iv;
                    boolean bl2 = false;
                    List<TypeParameterDescriptor> list = constructor.getParameters();
                    Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
                    collection.add(this.typeArgument(CollectionsKt.getOrNull(list, (int)index), (ProtoBuf.Type.Argument)argumentProto));
                }
                List arguments = CollectionsKt.toList((List)destination$iv$iv);
                ClassifierDescriptor declarationDescriptor = constructor.getDeclarationDescriptor();
                if (expandTypeAliases && declarationDescriptor instanceof TypeAliasDescriptor) {
                    KotlinTypeFactory $this$simpleType_u24lambda_u245 = KotlinTypeFactory.INSTANCE;
                    boolean bl3 = false;
                    SimpleType expandedType = KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor)declarationDescriptor, arguments);
                    TypeAttributes expandedAttributes = this.toAttributes(this.c.getComponents().getTypeAttributeTranslators(), Annotations.Companion.create(CollectionsKt.plus((Iterable)annotations, (Iterable)expandedType.getAnnotations())), constructor, this.c.getContainingDeclaration());
                    simpleType2 = expandedType.makeNullableAsSpecified(KotlinTypeKt.isNullable(expandedType) || proto.getNullable()).replaceAttributes(expandedAttributes);
                } else if (Flags.SUSPEND_TYPE.get(proto.getFlags()).booleanValue()) {
                    simpleType2 = this.createSuspendFunctionType(attributes, constructor, arguments, proto.getNullable());
                } else {
                    SimpleType it = KotlinTypeFactory.simpleType$default(attributes, constructor, arguments, proto.getNullable(), null, 16, null);
                    boolean bl4 = false;
                    if (Flags.DEFINITELY_NOT_NULL_TYPE.get(proto.getFlags()).booleanValue()) {
                        DefinitelyNotNullType definitelyNotNullType = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, it, true, false, 4, null);
                        if (definitelyNotNullType == null) {
                            throw new IllegalStateException(("null DefinitelyNotNullType for '" + it + '\'').toString());
                        }
                        simpleType2 = definitelyNotNullType;
                    } else {
                        simpleType2 = it;
                    }
                }
                simpleType = simpleType2;
                object = ProtoTypeTableUtilKt.abbreviatedType(proto, this.c.getTypeTable());
                if (object == null) break block14;
                ProtoBuf.Type it = object;
                boolean bl5 = false;
                SimpleType simpleType4 = SpecialTypesKt.withAbbreviation(simpleType, this.simpleType(it, false));
                object = simpleType4;
                if (simpleType4 != null) break block15;
            }
            object = simpleType;
        }
        Object computedType = object;
        return computedType;
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeDeserializer typeDeserializer, ProtoBuf.Type type, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = true;
        }
        return typeDeserializer.simpleType(type, bl2);
    }

    private final TypeConstructor typeConstructor(ProtoBuf.Type proto) {
        ClassifierDescriptor classifierDescriptor;
        if (proto.hasClassName()) {
            classifierDescriptor = this.classifierDescriptors.invoke(proto.getClassName());
            if (classifierDescriptor == null) {
                classifierDescriptor = TypeDeserializer.typeConstructor$notFoundClass(this, proto, proto.getClassName());
            }
        } else if (proto.hasTypeParameter()) {
            TypeParameterDescriptor typeParameterDescriptor = this.loadTypeParameter(proto.getTypeParameter());
            if (typeParameterDescriptor == null) {
                String[] stringArray = new String[]{String.valueOf(proto.getTypeParameter()), this.containerPresentableName};
                return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER, stringArray);
            }
            classifierDescriptor = typeParameterDescriptor;
        } else if (proto.hasTypeParameterName()) {
            Object v2;
            String name;
            block13: {
                name = this.c.getNameResolver().getString(proto.getTypeParameterName());
                Iterable iterable = this.getOwnTypeParameters();
                for (Object t2 : iterable) {
                    TypeParameterDescriptor it = (TypeParameterDescriptor)t2;
                    boolean bl2 = false;
                    if (!Intrinsics.areEqual(it.getName().asString(), name)) continue;
                    v2 = t2;
                    break block13;
                }
                v2 = null;
            }
            TypeParameterDescriptor typeParameterDescriptor = v2;
            if (typeParameterDescriptor == null) {
                String[] stringArray = new String[]{name, this.c.getContainingDeclaration().toString()};
                return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME, stringArray);
            }
            classifierDescriptor = typeParameterDescriptor;
        } else if (proto.hasTypeAliasName()) {
            classifierDescriptor = this.typeAliasDescriptors.invoke(proto.getTypeAliasName());
            if (classifierDescriptor == null) {
                classifierDescriptor = TypeDeserializer.typeConstructor$notFoundClass(this, proto, proto.getTypeAliasName());
            }
        } else {
            return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.UNKNOWN_TYPE, new String[0]);
        }
        ClassifierDescriptor classifier = classifierDescriptor;
        TypeConstructor typeConstructor2 = classifier.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
        return typeConstructor2;
    }

    private final SimpleType createSuspendFunctionType(TypeAttributes attributes, TypeConstructor functionTypeConstructor, List<? extends TypeProjection> arguments, boolean nullable) {
        SimpleType result;
        SimpleType simpleType;
        SimpleType simpleType2;
        switch (functionTypeConstructor.getParameters().size() - arguments.size()) {
            case 0: {
                simpleType2 = this.createSuspendFunctionTypeForBasicCase(attributes, functionTypeConstructor, arguments, nullable);
                break;
            }
            case 1: {
                int arity = arguments.size() - 1;
                if (arity >= 0) {
                    TypeConstructor typeConstructor2 = functionTypeConstructor.getBuiltIns().getSuspendFunction(arity).getTypeConstructor();
                    Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
                    simpleType2 = KotlinTypeFactory.simpleType$default(attributes, typeConstructor2, arguments, nullable, null, 16, null);
                    break;
                }
                simpleType2 = null;
                break;
            }
            default: {
                simpleType2 = null;
            }
        }
        if ((simpleType = (result = simpleType2)) == null) {
            simpleType = ErrorUtils.INSTANCE.createErrorTypeWithArguments(ErrorTypeKind.INCONSISTENT_SUSPEND_FUNCTION, arguments, functionTypeConstructor, new String[0]);
        }
        return simpleType;
    }

    private final SimpleType createSuspendFunctionTypeForBasicCase(TypeAttributes attributes, TypeConstructor functionTypeConstructor, List<? extends TypeProjection> arguments, boolean nullable) {
        SimpleType functionType = KotlinTypeFactory.simpleType$default(attributes, functionTypeConstructor, arguments, nullable, null, 16, null);
        return !FunctionTypesKt.isFunctionType(functionType) ? null : this.transformRuntimeFunctionTypeToSuspendFunction(functionType);
    }

    private final SimpleType transformRuntimeFunctionTypeToSuspendFunction(KotlinType funType) {
        FqName continuationArgumentFqName;
        Object object = CollectionsKt.lastOrNull(FunctionTypesKt.getValueParameterTypesFromFunctionType(funType));
        if (object == null || (object = object.getType()) == null) {
            return null;
        }
        Object continuationArgumentType = object;
        ClassifierDescriptor classifierDescriptor = ((KotlinType)continuationArgumentType).getConstructor().getDeclarationDescriptor();
        FqName fqName = continuationArgumentFqName = classifierDescriptor != null ? DescriptorUtilsKt.getFqNameSafe(classifierDescriptor) : null;
        if (((KotlinType)continuationArgumentType).getArguments().size() != 1 || !Intrinsics.areEqual(continuationArgumentFqName, StandardNames.CONTINUATION_INTERFACE_FQ_NAME) && !Intrinsics.areEqual(continuationArgumentFqName, TypeDeserializerKt.access$getEXPERIMENTAL_CONTINUATION_FQ_NAME$p())) {
            return (SimpleType)funType;
        }
        KotlinType kotlinType = CollectionsKt.single(((KotlinType)continuationArgumentType).getArguments()).getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        KotlinType suspendReturnType = kotlinType;
        DeclarationDescriptor declarationDescriptor = this.c.getContainingDeclaration();
        CallableDescriptor callableDescriptor = declarationDescriptor instanceof CallableDescriptor ? (CallableDescriptor)declarationDescriptor : null;
        if (Intrinsics.areEqual(callableDescriptor != null ? DescriptorUtilsKt.fqNameOrNull(callableDescriptor) : null, SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            return this.createSimpleSuspendFunctionType(funType, suspendReturnType);
        }
        return this.createSimpleSuspendFunctionType(funType, suspendReturnType);
    }

    /*
     * WARNING - void declaration
     */
    private final SimpleType createSimpleSuspendFunctionType(KotlinType funType, KotlinType suspendReturnType) {
        Collection<KotlinType> collection;
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Iterable iterable = CollectionsKt.dropLast(FunctionTypesKt.getValueParameterTypesFromFunctionType(funType), 1);
        List<KotlinType> list = FunctionTypesKt.getContextReceiverTypesFromFunctionType(funType);
        KotlinType kotlinType = FunctionTypesKt.getReceiverTypeFromFunctionType(funType);
        Annotations annotations = funType.getAnnotations();
        KotlinBuiltIns kotlinBuiltIns = TypeUtilsKt.getBuiltIns(funType);
        boolean $i$f$map = false;
        void var5_9 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            TypeProjection typeProjection = (TypeProjection)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(p0.getType());
        }
        collection = (List)destination$iv$iv;
        return FunctionTypesKt.createFunctionType(kotlinBuiltIns, annotations, kotlinType, list, (List<? extends KotlinType>)collection, null, suspendReturnType, true).makeNullableAsSpecified(funType.isMarkedNullable());
    }

    private final TypeParameterDescriptor loadTypeParameter(int typeParameterId) {
        TypeParameterDescriptor typeParameterDescriptor = this.typeParameterDescriptors.get(typeParameterId);
        if (typeParameterDescriptor == null) {
            TypeDeserializer typeDeserializer = this.parent;
            typeParameterDescriptor = typeDeserializer != null ? typeDeserializer.loadTypeParameter(typeParameterId) : null;
        }
        return typeParameterDescriptor;
    }

    private final ClassifierDescriptor computeClassifierDescriptor(int fqNameIndex) {
        ClassId id = NameResolverUtilKt.getClassId(this.c.getNameResolver(), fqNameIndex);
        if (id.isLocal()) {
            return this.c.getComponents().deserializeClass(id);
        }
        return FindClassInModuleKt.findClassifierAcrossModuleDependencies(this.c.getComponents().getModuleDescriptor(), id);
    }

    private final SimpleType computeLocalClassifierReplacementType(int className) {
        if (NameResolverUtilKt.getClassId(this.c.getNameResolver(), className).isLocal()) {
            return this.c.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    private final ClassifierDescriptor computeTypeAliasDescriptor(int fqNameIndex) {
        ClassId id = NameResolverUtilKt.getClassId(this.c.getNameResolver(), fqNameIndex);
        if (id.isLocal()) {
            return null;
        }
        return FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(this.c.getComponents().getModuleDescriptor(), id);
    }

    private final TypeProjection typeArgument(TypeParameterDescriptor parameter, ProtoBuf.Type.Argument typeArgumentProto) {
        if (typeArgumentProto.getProjection() == ProtoBuf.Type.Argument.Projection.STAR) {
            return parameter == null ? (TypeProjection)new StarProjectionForAbsentTypeParameter(this.c.getComponents().getModuleDescriptor().getBuiltIns()) : (TypeProjection)new StarProjectionImpl(parameter);
        }
        ProtoBuf.Type.Argument.Projection projection = typeArgumentProto.getProjection();
        Intrinsics.checkNotNullExpressionValue(projection, "getProjection(...)");
        Variance projection2 = ProtoEnumFlags.INSTANCE.variance(projection);
        ProtoBuf.Type type = ProtoTypeTableUtilKt.type(typeArgumentProto, this.c.getTypeTable());
        if (type == null) {
            String[] stringArray = new String[]{typeArgumentProto.toString()};
            return new TypeProjectionImpl(ErrorUtils.createErrorType(ErrorTypeKind.NO_RECORDED_TYPE, stringArray));
        }
        ProtoBuf.Type type2 = type;
        return new TypeProjectionImpl(projection2, this.type(type2));
    }

    @NotNull
    public String toString() {
        return this.debugName + (this.parent == null ? "" : ". Child of " + this.parent.debugName);
    }

    private static final ClassifierDescriptor classifierDescriptors$lambda$0(TypeDeserializer this$0, int fqNameIndex) {
        return this$0.computeClassifierDescriptor(fqNameIndex);
    }

    private static final ClassifierDescriptor typeAliasDescriptors$lambda$1(TypeDeserializer this$0, int fqNameIndex) {
        return this$0.computeTypeAliasDescriptor(fqNameIndex);
    }

    private static final List simpleType$lambda$3(TypeDeserializer this$0, ProtoBuf.Type $proto) {
        return this$0.c.getComponents().getAnnotationAndConstantLoader().loadTypeAnnotations($proto, this$0.c.getNameResolver());
    }

    private static final List<ProtoBuf.Type.Argument> simpleType$collectAllArguments(ProtoBuf.Type $this$simpleType_u24collectAllArguments, TypeDeserializer this$0) {
        List<ProtoBuf.Type.Argument> list = $this$simpleType_u24collectAllArguments.getArgumentList();
        Intrinsics.checkNotNullExpressionValue(list, "getArgumentList(...)");
        Collection collection = list;
        ProtoBuf.Type type = ProtoTypeTableUtilKt.outerType($this$simpleType_u24collectAllArguments, this$0.c.getTypeTable());
        List<ProtoBuf.Type.Argument> list2 = type != null ? TypeDeserializer.simpleType$collectAllArguments(type, this$0) : null;
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        return CollectionsKt.plus(collection, (Iterable)list2);
    }

    private static final ProtoBuf.Type typeConstructor$notFoundClass$lambda$8(TypeDeserializer this$0, ProtoBuf.Type it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ProtoTypeTableUtilKt.outerType(it, this$0.c.getTypeTable());
    }

    private static final int typeConstructor$notFoundClass$lambda$9(ProtoBuf.Type it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getArgumentCount();
    }

    private static final ClassDescriptor typeConstructor$notFoundClass(TypeDeserializer this$0, ProtoBuf.Type $proto, int classIdIndex) {
        ClassId classId = NameResolverUtilKt.getClassId(this$0.c.getNameResolver(), classIdIndex);
        TypeDeserializer typeDeserializer = this$0;
        List<Integer> typeParametersCount2 = SequencesKt.toMutableList(SequencesKt.map(SequencesKt.generateSequence($proto, new TypeDeserializer$$Lambda$3(typeDeserializer)), TypeDeserializer$$Lambda$4.INSTANCE));
        int classNestingLevel2 = SequencesKt.count(SequencesKt.generateSequence(classId, (Function1)typeConstructor.notFoundClass.classNestingLevel.1.INSTANCE));
        while (typeParametersCount2.size() < classNestingLevel2) {
            typeParametersCount2.add(0);
        }
        return this$0.c.getComponents().getNotFoundClasses().getClass(classId, typeParametersCount2);
    }

    static /* synthetic */ ClassifierDescriptor accessor$TypeDeserializer$lambda0(TypeDeserializer typeDeserializer, int n2) {
        return TypeDeserializer.classifierDescriptors$lambda$0(typeDeserializer, n2);
    }

    static /* synthetic */ ClassifierDescriptor accessor$TypeDeserializer$lambda1(TypeDeserializer typeDeserializer, int n2) {
        return TypeDeserializer.typeAliasDescriptors$lambda$1(typeDeserializer, n2);
    }

    static /* synthetic */ List accessor$TypeDeserializer$lambda2(TypeDeserializer typeDeserializer, ProtoBuf.Type type) {
        return TypeDeserializer.simpleType$lambda$3(typeDeserializer, type);
    }

    static /* synthetic */ ProtoBuf.Type accessor$TypeDeserializer$lambda3(TypeDeserializer typeDeserializer, ProtoBuf.Type type) {
        return TypeDeserializer.typeConstructor$notFoundClass$lambda$8(typeDeserializer, type);
    }

    static /* synthetic */ int accessor$TypeDeserializer$lambda4(ProtoBuf.Type type) {
        return TypeDeserializer.typeConstructor$notFoundClass$lambda$9(type);
    }
}

