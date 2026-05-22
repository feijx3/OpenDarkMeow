/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawProjectionComputer;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nJavaTypeResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaTypeResolver.kt\norg/jetbrains/kotlin/load/java/lazy/types/JavaTypeResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 coreLib.kt\norg/jetbrains/kotlin/utils/CoreLibKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,321:1\n1#2:322\n19#3:323\n1563#4:324\n1634#4,3:325\n1563#4:328\n1634#4,3:329\n1563#4:332\n1634#4,3:333\n*S KotlinDebug\n*F\n+ 1 JavaTypeResolver.kt\norg/jetbrains/kotlin/load/java/lazy/types/JavaTypeResolver\n*L\n144#1:323\n205#1:324\n205#1:325,3\n263#1:328\n263#1:329,3\n267#1:332\n267#1:333,3\n*E\n"})
public final class JavaTypeResolver {
    @NotNull
    private final LazyJavaResolverContext c;
    @NotNull
    private final TypeParameterResolver typeParameterResolver;
    @NotNull
    private final RawProjectionComputer projectionComputer;
    @NotNull
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    public JavaTypeResolver(@NotNull LazyJavaResolverContext c2, @NotNull TypeParameterResolver typeParameterResolver) {
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(typeParameterResolver, "typeParameterResolver");
        this.c = c2;
        this.typeParameterResolver = typeParameterResolver;
        this.projectionComputer = new RawProjectionComputer();
        this.typeParameterUpperBoundEraser = new TypeParameterUpperBoundEraser(this.projectionComputer, null, 2, null);
    }

    @NotNull
    public final KotlinType transformJavaType(@Nullable JavaType javaType, @NotNull JavaTypeAttributes attr) {
        Object object;
        block5: {
            JavaType javaType2;
            block8: {
                block9: {
                    block7: {
                        block6: {
                            block4: {
                                Intrinsics.checkNotNullParameter(attr, "attr");
                                javaType2 = javaType;
                                if (!(javaType2 instanceof JavaPrimitiveType)) break block4;
                                PrimitiveType primitiveType = ((JavaPrimitiveType)javaType).getType();
                                SimpleType simpleType = primitiveType != null ? this.c.getModule().getBuiltIns().getPrimitiveKotlinType(primitiveType) : this.c.getModule().getBuiltIns().getUnitType();
                                Intrinsics.checkNotNull(simpleType);
                                object = simpleType;
                                break block5;
                            }
                            if (!(javaType2 instanceof JavaClassifierType)) break block6;
                            object = this.transformJavaClassifierType((JavaClassifierType)javaType, attr);
                            break block5;
                        }
                        if (!(javaType2 instanceof JavaArrayType)) break block7;
                        object = JavaTypeResolver.transformArrayType$default(this, (JavaArrayType)javaType, attr, false, 4, null);
                        break block5;
                    }
                    if (!(javaType2 instanceof JavaWildcardType)) break block8;
                    object = ((JavaWildcardType)javaType).getBound();
                    if (object == null) break block9;
                    Object it = object;
                    boolean bl2 = false;
                    KotlinType kotlinType = this.transformJavaType((JavaType)it, attr);
                    object = kotlinType;
                    if (kotlinType != null) break block5;
                }
                SimpleType simpleType = this.c.getModule().getBuiltIns().getDefaultBound();
                Intrinsics.checkNotNullExpressionValue(simpleType, "getDefaultBound(...)");
                object = simpleType;
                break block5;
            }
            if (javaType2 == null) {
                SimpleType simpleType = this.c.getModule().getBuiltIns().getDefaultBound();
                Intrinsics.checkNotNullExpressionValue(simpleType, "getDefaultBound(...)");
                object = simpleType;
            } else {
                throw new UnsupportedOperationException("Unsupported type: " + javaType);
            }
        }
        return object;
    }

    @NotNull
    public final KotlinType transformArrayType(@NotNull JavaArrayType arrayType, @NotNull JavaTypeAttributes attr, boolean isVararg) {
        Intrinsics.checkNotNullParameter(arrayType, "arrayType");
        Intrinsics.checkNotNullParameter(attr, "attr");
        JavaType javaComponentType = arrayType.getComponentType();
        JavaPrimitiveType javaPrimitiveType = javaComponentType instanceof JavaPrimitiveType ? (JavaPrimitiveType)javaComponentType : null;
        PrimitiveType primitiveType = javaPrimitiveType != null ? javaPrimitiveType.getType() : null;
        LazyJavaAnnotations annotations = new LazyJavaAnnotations(this.c, arrayType, true);
        if (primitiveType != null) {
            SimpleType it = this.c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(primitiveType);
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            Annotations[] annotationsArray = new Annotations[]{it.getAnnotations(), annotations};
            KotlinType kotlinType = TypeUtilsKt.replaceAnnotations(it, new CompositeAnnotations(annotationsArray));
            Intrinsics.checkNotNull(kotlinType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            SimpleType kotlinType2 = (SimpleType)kotlinType;
            return attr.isForAnnotationParameter() ? (KotlinType)kotlinType2 : (KotlinType)KotlinTypeFactory.flexibleType(kotlinType2, kotlinType2.makeNullableAsSpecified(true));
        }
        KotlinType componentType = this.transformJavaType(javaComponentType, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, attr.isForAnnotationParameter(), false, null, 6, null));
        if (attr.isForAnnotationParameter()) {
            Variance projectionKind = isVararg ? Variance.OUT_VARIANCE : Variance.INVARIANT;
            SimpleType simpleType = this.c.getModule().getBuiltIns().getArrayType(projectionKind, componentType, annotations);
            Intrinsics.checkNotNullExpressionValue(simpleType, "getArrayType(...)");
            return simpleType;
        }
        SimpleType simpleType = this.c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, componentType, annotations);
        Intrinsics.checkNotNullExpressionValue(simpleType, "getArrayType(...)");
        return KotlinTypeFactory.flexibleType(simpleType, this.c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, componentType, annotations).makeNullableAsSpecified(true));
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver javaTypeResolver, JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean bl2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        return javaTypeResolver.transformArrayType(javaArrayType, javaTypeAttributes, bl2);
    }

    private final KotlinType transformJavaClassifierType(JavaClassifierType javaType, JavaTypeAttributes attr) {
        boolean useFlexible = !attr.isForAnnotationParameter() && attr.getHowThisTypeIsUsed() != TypeUsage.SUPERTYPE;
        boolean isRaw = javaType.isRaw();
        if (!isRaw && !useFlexible) {
            SimpleType simpleType = this.computeSimpleJavaClassifierType(javaType, attr, null);
            return simpleType != null ? (KotlinType)simpleType : (KotlinType)JavaTypeResolver.transformJavaClassifierType$errorType(javaType);
        }
        SimpleType simpleType = this.computeSimpleJavaClassifierType(javaType, attr.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
        if (simpleType == null) {
            return JavaTypeResolver.transformJavaClassifierType$errorType(javaType);
        }
        SimpleType lower = simpleType;
        SimpleType simpleType2 = this.computeSimpleJavaClassifierType(javaType, attr.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), lower);
        if (simpleType2 == null) {
            return JavaTypeResolver.transformJavaClassifierType$errorType(javaType);
        }
        SimpleType upper = simpleType2;
        return isRaw ? (KotlinType)new RawTypeImpl(lower, upper) : (KotlinType)KotlinTypeFactory.flexibleType(lower, upper);
    }

    private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType javaType, JavaTypeAttributes attr, SimpleType lowerResult) {
        Object object = lowerResult;
        if (object == null || (object = ((KotlinType)object).getAttributes()) == null) {
            object = TypeAttributesKt.toDefaultAttributes(new LazyJavaAnnotations(this.c, javaType, false, 4, null));
        }
        Object attributes = object;
        TypeConstructor typeConstructor2 = this.computeTypeConstructor(javaType, attr);
        if (typeConstructor2 == null) {
            return null;
        }
        TypeConstructor constructor = typeConstructor2;
        boolean isNullable = this.isNullable(attr);
        SimpleType simpleType = lowerResult;
        if (Intrinsics.areEqual(simpleType != null ? simpleType.getConstructor() : null, constructor) && !javaType.isRaw() && isNullable) {
            return lowerResult.makeNullableAsSpecified(true);
        }
        List<TypeProjection> arguments = this.computeArguments(javaType, attr, constructor);
        return KotlinTypeFactory.simpleType$default((TypeAttributes)attributes, constructor, arguments, isNullable, null, 16, null);
    }

    private final TypeConstructor computeTypeConstructor(JavaClassifierType javaType, JavaTypeAttributes attr) {
        Object object;
        JavaClassifier javaClassifier = javaType.getClassifier();
        if (javaClassifier == null) {
            return this.createNotFoundClass(javaType);
        }
        JavaClassifier classifier = javaClassifier;
        JavaClassifier javaClassifier2 = classifier;
        if (javaClassifier2 instanceof JavaClass) {
            ClassDescriptor classData;
            FqName $this$sure$iv = ((JavaClass)classifier).getFqName();
            boolean $i$f$sure = false;
            FqName fqName = $this$sure$iv;
            if (fqName == null) {
                boolean bl2 = false;
                String string = "Class type should have a FQ name: " + classifier;
                throw new AssertionError((Object)string);
            }
            FqName fqName2 = fqName;
            ClassDescriptor classDescriptor = this.mapKotlinClass(javaType, attr, fqName2);
            if (classDescriptor == null) {
                classDescriptor = this.c.getComponents().getModuleClassResolver().resolveClass((JavaClass)classifier);
            }
            if ((object = (classData = classDescriptor)) == null || (object = object.getTypeConstructor()) == null) {
                object = this.createNotFoundClass(javaType);
            }
        } else if (javaClassifier2 instanceof JavaTypeParameter) {
            TypeParameterDescriptor typeParameterDescriptor = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter)classifier);
            object = typeParameterDescriptor != null ? typeParameterDescriptor.getTypeConstructor() : null;
        } else {
            throw new IllegalStateException("Unknown classifier kind: " + classifier);
        }
        return object;
    }

    private final TypeConstructor createNotFoundClass(JavaClassifierType javaType) {
        ClassId classId = ClassId.Companion.topLevel(new FqName(javaType.getClassifierQualifiedName()));
        TypeConstructor typeConstructor2 = this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(classId, CollectionsKt.listOf(0)).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
        return typeConstructor2;
    }

    private final ClassDescriptor mapKotlinClass(JavaClassifierType javaType, JavaTypeAttributes attr, FqName fqName) {
        if (attr.isForAnnotationParameter() && Intrinsics.areEqual(fqName, JavaTypeResolverKt.access$getJAVA_LANG_CLASS_FQ_NAME$p())) {
            return this.c.getComponents().getReflectionTypes().getKClass();
        }
        JavaToKotlinClassMapper javaToKotlin = JavaToKotlinClassMapper.INSTANCE;
        ClassDescriptor classDescriptor = JavaToKotlinClassMapper.mapJavaToKotlin$default(javaToKotlin, fqName, this.c.getModule().getBuiltIns(), null, 4, null);
        if (classDescriptor == null) {
            return null;
        }
        ClassDescriptor kotlinDescriptor = classDescriptor;
        if (javaToKotlin.isReadOnly(kotlinDescriptor) && (attr.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || attr.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE || this.argumentsMakeSenseOnlyForMutableContainer(javaType, kotlinDescriptor))) {
            return javaToKotlin.convertReadOnlyToMutable(kotlinDescriptor);
        }
        return kotlinDescriptor;
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(JavaClassifierType $this$argumentsMakeSenseOnlyForMutableContainer, ClassDescriptor readOnlyContainer) {
        Variance variance;
        if (!JavaTypesKt.isSuperWildcard(CollectionsKt.lastOrNull($this$argumentsMakeSenseOnlyForMutableContainer.getTypeArguments()))) {
            return false;
        }
        List<TypeParameterDescriptor> list = JavaToKotlinClassMapper.INSTANCE.convertReadOnlyToMutable(readOnlyContainer).getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
        TypeParameterDescriptor typeParameterDescriptor = CollectionsKt.lastOrNull(list);
        if (typeParameterDescriptor == null || (variance = typeParameterDescriptor.getVariance()) == null) {
            return false;
        }
        Variance mutableLastParameterVariance = variance;
        return mutableLastParameterVariance != Variance.OUT_VARIANCE;
    }

    /*
     * WARNING - void declaration
     */
    private final List<TypeProjection> computeRawTypeArguments(JavaClassifierType javaType, List<? extends TypeParameterDescriptor> typeParameters, TypeConstructor constructor, JavaTypeAttributes attr) {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = typeParameters;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            TypeProjection typeProjection;
            void parameter;
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            if (TypeUtilsKt.hasTypeParameterRecursiveBounds((TypeParameterDescriptor)parameter, null, attr.getVisitedTypeParameters())) {
                typeProjection = TypeUtils.makeStarProjection((TypeParameterDescriptor)parameter, attr);
            } else {
                JavaClassifierType javaClassifierType = javaType;
                TypeConstructor typeConstructor2 = constructor;
                JavaTypeAttributes javaTypeAttributes = attr;
                void var19_19 = parameter;
                JavaTypeResolver javaTypeResolver = this;
                LazyWrappedType erasedUpperBound = new LazyWrappedType(this.c.getStorageManager(), new JavaTypeResolver$$Lambda$0(javaTypeResolver, (TypeParameterDescriptor)var19_19, javaTypeAttributes, typeConstructor2, javaClassifierType));
                typeProjection = this.projectionComputer.computeProjection((TypeParameterDescriptor)parameter, attr.markIsRaw(javaType.isRaw()), this.typeParameterUpperBoundEraser, erasedUpperBound);
            }
            collection.add(typeProjection);
        }
        return (List)destination$iv$iv;
    }

    /*
     * Unable to fully structure code
     */
    private final List<TypeProjection> computeArguments(JavaClassifierType javaType, JavaTypeAttributes attr, TypeConstructor constructor) {
        isRaw = javaType.isRaw();
        if (isRaw) ** GOTO lbl-1000
        if (javaType.getTypeArguments().isEmpty()) {
            v0 = constructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(v0, "getParameters(...)");
            ** if (!(((Collection)v0).isEmpty() == false)) goto lbl-1000
        }
        ** GOTO lbl-1000
lbl-1000:
        // 2 sources

        {
            v1 = true;
            ** GOTO lbl11
        }
lbl-1000:
        // 2 sources

        {
            v1 = false;
        }
lbl11:
        // 2 sources

        eraseTypeParameters = v1;
        v2 = constructor.getParameters();
        Intrinsics.checkNotNullExpressionValue(v2, "getParameters(...)");
        typeParameters = v2;
        if (eraseTypeParameters) {
            return this.computeRawTypeArguments(javaType, typeParameters, constructor, attr);
        }
        if (typeParameters.size() != javaType.getTypeArguments().size()) {
            $this$map$iv = typeParameters;
            $i$f$map = false;
            var9_11 = $this$map$iv;
            destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            $i$f$mapTo = false;
            for (T item$iv$iv : $this$mapTo$iv$iv) {
                var14_21 = (TypeParameterDescriptor)item$iv$iv;
                var20_27 = destination$iv$iv;
                $i$a$-map-JavaTypeResolver$computeArguments$1 = false;
                var16_25 = new String[]{p.getName().asString()};
                var20_27.add(new TypeProjectionImpl(ErrorUtils.createErrorType(ErrorTypeKind.MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER, var16_25)));
            }
            return CollectionsKt.toList((List)destination$iv$iv);
        }
        $this$map$iv = CollectionsKt.withIndex((Iterable)javaType.getTypeArguments());
        $i$f$map = false;
        $this$mapTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        $i$f$mapTo = false;
        var12_18 = $this$mapTo$iv$iv.iterator();
        while (var12_18.hasNext()) {
            p = item$iv$iv = var12_18.next();
            var20_28 = destination$iv$iv;
            $i$a$-map-JavaTypeResolver$computeArguments$2 = false;
            i = indexedArgument.component1();
            javaTypeArgument = (JavaType)indexedArgument.component2();
            v3 = var18_31 = i < typeParameters.size();
            if (_Assertions.ENABLED && !var18_31) {
                $i$a$-assert-JavaTypeResolver$computeArguments$2$1 = false;
                var19_33 = "Argument index should be less then type parameters count, but " + i + " > " + typeParameters.size();
                throw new AssertionError((Object)var19_33);
            }
            parameter = typeParameters.get(i);
            v4 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null);
            Intrinsics.checkNotNull(parameter);
            var20_28.add(this.transformToTypeProjection(javaTypeArgument, v4, parameter));
        }
        return CollectionsKt.toList((List)destination$iv$iv);
    }

    private final TypeProjection transformToTypeProjection(JavaType javaType, JavaTypeAttributes attr, TypeParameterDescriptor typeParameter) {
        TypeProjection typeProjection;
        if (javaType instanceof JavaWildcardType) {
            Variance projectionKind;
            JavaType bound = ((JavaWildcardType)javaType).getBound();
            Variance variance = projectionKind = ((JavaWildcardType)javaType).isExtends() ? Variance.OUT_VARIANCE : Variance.IN_VARIANCE;
            if (bound == null || this.isConflictingArgumentFor(projectionKind, typeParameter)) {
                TypeProjection typeProjection2 = TypeUtils.makeStarProjection(typeParameter, attr);
                typeProjection = typeProjection2;
                Intrinsics.checkNotNullExpressionValue(typeProjection2, "makeStarProjection(...)");
            } else {
                AnnotationDescriptor nullabilityAnnotationOnWildcard = UtilsKt.extractNullabilityAnnotationOnBoundedWildcard(this.c, (JavaWildcardType)javaType);
                KotlinType it = this.transformJavaType(bound, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null));
                boolean bl2 = false;
                KotlinType transformedJavaType = nullabilityAnnotationOnWildcard != null ? TypeUtilsKt.replaceAnnotations(it, Annotations.Companion.create(CollectionsKt.plus((Iterable)it.getAnnotations(), nullabilityAnnotationOnWildcard))) : it;
                typeProjection = TypeUtilsKt.createProjection(transformedJavaType, projectionKind, typeParameter);
            }
        } else {
            typeProjection = new TypeProjectionImpl(Variance.INVARIANT, this.transformJavaType(javaType, attr));
        }
        return typeProjection;
    }

    private final boolean isConflictingArgumentFor(Variance $this$isConflictingArgumentFor, TypeParameterDescriptor typeParameter) {
        if (typeParameter.getVariance() == Variance.INVARIANT) {
            return false;
        }
        return $this$isConflictingArgumentFor != typeParameter.getVariance();
    }

    private final boolean isNullable(JavaTypeAttributes $this$isNullable) {
        if ($this$isNullable.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND) {
            return false;
        }
        return !$this$isNullable.isForAnnotationParameter() && $this$isNullable.getHowThisTypeIsUsed() != TypeUsage.SUPERTYPE;
    }

    private static final ErrorType transformJavaClassifierType$errorType(JavaClassifierType $javaType) {
        String[] stringArray = new String[]{$javaType.getPresentableText()};
        return ErrorUtils.createErrorType(ErrorTypeKind.UNRESOLVED_JAVA_CLASS, stringArray);
    }

    private static final KotlinType computeRawTypeArguments$lambda$4$lambda$3(JavaTypeResolver this$0, TypeParameterDescriptor $parameter, JavaTypeAttributes $attr, TypeConstructor $constructor, JavaClassifierType $javaType) {
        ClassifierDescriptor classifierDescriptor = $constructor.getDeclarationDescriptor();
        return this$0.typeParameterUpperBoundEraser.getErasedUpperBound($parameter, $attr.withDefaultType(classifierDescriptor != null ? classifierDescriptor.getDefaultType() : null).markIsRaw($javaType.isRaw()));
    }

    static /* synthetic */ KotlinType accessor$JavaTypeResolver$lambda0(JavaTypeResolver javaTypeResolver, TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes, TypeConstructor typeConstructor2, JavaClassifierType javaClassifierType) {
        return JavaTypeResolver.computeRawTypeArguments$lambda$4$lambda$3(javaTypeResolver, typeParameterDescriptor, javaTypeAttributes, typeConstructor2, javaClassifierType);
    }
}

