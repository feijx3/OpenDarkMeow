/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttributeKt;
import kotlin.reflect.jvm.internal.impl.types.DynamicType;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nTypeAliasExpander.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAliasExpander.kt\norg/jetbrains/kotlin/types/TypeAliasExpander\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,278:1\n1#2:279\n1634#3,3:280\n1573#3:283\n1604#3,4:284\n1573#3:288\n1604#3,4:289\n1878#3,3:293\n*S KotlinDebug\n*F\n+ 1 TypeAliasExpander.kt\norg/jetbrains/kotlin/types/TypeAliasExpander\n*L\n148#1:280,3\n197#1:283\n197#1:284,4\n232#1:288\n232#1:289,4\n249#1:293,3\n*E\n"})
public final class TypeAliasExpander {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final TypeAliasExpansionReportStrategy reportStrategy;
    private final boolean shouldCheckBounds;
    @NotNull
    private static final TypeAliasExpander NON_REPORTING = new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false);

    public TypeAliasExpander(@NotNull TypeAliasExpansionReportStrategy reportStrategy, boolean shouldCheckBounds) {
        Intrinsics.checkNotNullParameter(reportStrategy, "reportStrategy");
        this.reportStrategy = reportStrategy;
        this.shouldCheckBounds = shouldCheckBounds;
    }

    @NotNull
    public final SimpleType expand(@NotNull TypeAliasExpansion typeAliasExpansion, @NotNull TypeAttributes attributes) {
        Intrinsics.checkNotNullParameter(typeAliasExpansion, "typeAliasExpansion");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return this.expandRecursively(typeAliasExpansion, attributes, false, 0, true);
    }

    private final SimpleType expandRecursively(TypeAliasExpansion typeAliasExpansion, TypeAttributes attributes, boolean isNullable, int recursionDepth, boolean withAbbreviatedType) {
        boolean bl2;
        TypeProjectionImpl underlyingProjection = new TypeProjectionImpl(Variance.INVARIANT, typeAliasExpansion.getDescriptor().getUnderlyingType());
        TypeProjection expandedProjection = this.expandTypeProjection(underlyingProjection, typeAliasExpansion, null, recursionDepth);
        KotlinType kotlinType = expandedProjection.getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        SimpleType expandedType = TypeSubstitutionKt.asSimpleType(kotlinType);
        if (KotlinTypeKt.isError(expandedType)) {
            return expandedType;
        }
        boolean bl3 = bl2 = expandedProjection.getProjectionKind() == Variance.INVARIANT;
        if (_Assertions.ENABLED && !bl2) {
            boolean bl4 = false;
            String string = "Type alias expansion: result for " + typeAliasExpansion.getDescriptor() + " is " + (Object)((Object)expandedProjection.getProjectionKind()) + ", should be invariant";
            throw new AssertionError((Object)string);
        }
        this.checkRepeatedAnnotations(expandedType.getAnnotations(), AnnotationsTypeAttributeKt.getAnnotations(attributes));
        SimpleType it = this.combineAttributes(expandedType, attributes);
        boolean bl5 = false;
        SimpleType simpleType = TypeUtils.makeNullableIfNeeded(it, isNullable);
        Intrinsics.checkNotNullExpressionValue(simpleType, "let(...)");
        SimpleType expandedTypeWithExtraAnnotations = simpleType;
        return withAbbreviatedType ? SpecialTypesKt.withAbbreviation(expandedTypeWithExtraAnnotations, this.createAbbreviation(typeAliasExpansion, attributes, isNullable)) : expandedTypeWithExtraAnnotations;
    }

    private final SimpleType createAbbreviation(TypeAliasExpansion $this$createAbbreviation, TypeAttributes attributes, boolean isNullable) {
        TypeConstructor typeConstructor2 = $this$createAbbreviation.getDescriptor().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(attributes, typeConstructor2, $this$createAbbreviation.getArguments(), isNullable, MemberScope.Empty.INSTANCE);
    }

    private final TypeProjection expandTypeProjection(TypeProjection underlyingProjection, TypeAliasExpansion typeAliasExpansion, TypeParameterDescriptor typeParameterDescriptor, int recursionDepth) {
        Variance variance;
        Object object;
        Variance substitutionVariance;
        Variance variance2;
        TypeAliasExpander.Companion.assertRecursionDepth(recursionDepth, typeAliasExpansion.getDescriptor());
        if (underlyingProjection.isStarProjection()) {
            TypeParameterDescriptor typeParameterDescriptor2 = typeParameterDescriptor;
            Intrinsics.checkNotNull(typeParameterDescriptor2);
            TypeProjection typeProjection = TypeUtils.makeStarProjection(typeParameterDescriptor2);
            Intrinsics.checkNotNullExpressionValue(typeProjection, "makeStarProjection(...)");
            return typeProjection;
        }
        KotlinType kotlinType = underlyingProjection.getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        KotlinType underlyingType = kotlinType;
        TypeProjection typeProjection = typeAliasExpansion.getReplacement(underlyingType.getConstructor());
        if (typeProjection == null) {
            return this.expandNonArgumentTypeProjection(underlyingProjection, typeAliasExpansion, recursionDepth);
        }
        TypeProjection argument = typeProjection;
        if (argument.isStarProjection()) {
            TypeParameterDescriptor typeParameterDescriptor3 = typeParameterDescriptor;
            Intrinsics.checkNotNull(typeParameterDescriptor3);
            TypeProjection typeProjection2 = TypeUtils.makeStarProjection(typeParameterDescriptor3);
            Intrinsics.checkNotNullExpressionValue(typeProjection2, "makeStarProjection(...)");
            return typeProjection2;
        }
        UnwrappedType argumentType = argument.getType().unwrap();
        TypeAliasExpander $this$expandTypeProjection_u24lambda_u242 = this;
        boolean bl2 = false;
        Variance variance3 = argument.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue((Object)variance3, "getProjectionKind(...)");
        Variance argumentVariance = variance3;
        Variance variance4 = underlyingProjection.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue((Object)variance4, "getProjectionKind(...)");
        Variance underlyingVariance = variance4;
        if (underlyingVariance == argumentVariance) {
            variance2 = argumentVariance;
        } else if (underlyingVariance == Variance.INVARIANT) {
            variance2 = argumentVariance;
        } else if (argumentVariance == Variance.INVARIANT) {
            variance2 = underlyingVariance;
        } else {
            $this$expandTypeProjection_u24lambda_u242.reportStrategy.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, argumentType);
            variance2 = substitutionVariance = argumentVariance;
        }
        if ((object = typeParameterDescriptor) == null || (object = object.getVariance()) == null) {
            object = Variance.INVARIANT;
        }
        Object parameterVariance = object;
        if (parameterVariance == substitutionVariance) {
            variance = substitutionVariance;
        } else if (parameterVariance == Variance.INVARIANT) {
            variance = substitutionVariance;
        } else if (substitutionVariance == Variance.INVARIANT) {
            variance = Variance.INVARIANT;
        } else {
            $this$expandTypeProjection_u24lambda_u242.reportStrategy.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, argumentType);
            variance = substitutionVariance;
        }
        Variance resultingVariance = variance;
        this.checkRepeatedAnnotations(underlyingType.getAnnotations(), argumentType.getAnnotations());
        UnwrappedType substitutedType = argumentType instanceof DynamicType ? (UnwrappedType)this.combineAttributes((DynamicType)argumentType, underlyingType.getAttributes()) : (UnwrappedType)this.combineNullabilityAndAnnotations(TypeSubstitutionKt.asSimpleType(argumentType), underlyingType);
        return new TypeProjectionImpl(resultingVariance, substitutedType);
    }

    private final DynamicType combineAttributes(DynamicType $this$combineAttributes, TypeAttributes newAttributes) {
        return $this$combineAttributes.replaceAttributes(this.createdCombinedAttributes($this$combineAttributes, newAttributes));
    }

    private final SimpleType combineAttributes(SimpleType $this$combineAttributes, TypeAttributes newAttributes) {
        return KotlinTypeKt.isError($this$combineAttributes) ? $this$combineAttributes : TypeSubstitutionKt.replace$default($this$combineAttributes, null, this.createdCombinedAttributes($this$combineAttributes, newAttributes), 1, null);
    }

    private final TypeAttributes createdCombinedAttributes(KotlinType $this$createdCombinedAttributes, TypeAttributes newAttributes) {
        if (KotlinTypeKt.isError($this$createdCombinedAttributes)) {
            return $this$createdCombinedAttributes.getAttributes();
        }
        return newAttributes.add($this$createdCombinedAttributes.getAttributes());
    }

    /*
     * WARNING - void declaration
     */
    private final void checkRepeatedAnnotations(Annotations existingAnnotations, Annotations newAnnotations) {
        void destination$iv;
        void $this$mapTo$iv;
        Iterable iterable = existingAnnotations;
        Collection collection = new HashSet();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor)item$iv;
            void var11_10 = destination$iv;
            boolean bl2 = false;
            var11_10.add(it.getFqName());
        }
        HashSet existingAnnotationFqNames = (HashSet)destination$iv;
        for (AnnotationDescriptor annotation : newAnnotations) {
            if (!existingAnnotationFqNames.contains(annotation.getFqName())) continue;
            this.reportStrategy.repeatedAnnotation(annotation);
        }
    }

    private final SimpleType combineNullability(SimpleType $this$combineNullability, KotlinType fromType) {
        SimpleType simpleType = TypeUtils.makeNullableIfNeeded($this$combineNullability, fromType.isMarkedNullable());
        Intrinsics.checkNotNullExpressionValue(simpleType, "makeNullableIfNeeded(...)");
        return simpleType;
    }

    private final SimpleType combineNullabilityAndAnnotations(SimpleType $this$combineNullabilityAndAnnotations, KotlinType fromType) {
        return this.combineAttributes(this.combineNullability($this$combineNullabilityAndAnnotations, fromType), fromType.getAttributes());
    }

    /*
     * WARNING - void declaration
     */
    private final TypeProjection expandNonArgumentTypeProjection(TypeProjection originalProjection, TypeAliasExpansion typeAliasExpansion, int recursionDepth) {
        TypeProjection typeProjection;
        boolean bl2;
        UnwrappedType originalType = originalProjection.getType().unwrap();
        if (DynamicTypesKt.isDynamic(originalType)) {
            return originalProjection;
        }
        SimpleType type = TypeSubstitutionKt.asSimpleType(originalType);
        if (KotlinTypeKt.isError(type) || !TypeUtilsKt.requiresTypeAliasExpansion(type)) {
            return originalProjection;
        }
        TypeConstructor typeConstructor2 = type.getConstructor();
        ClassifierDescriptor typeDescriptor = typeConstructor2.getDeclarationDescriptor();
        boolean bl3 = bl2 = typeConstructor2.getParameters().size() == type.getArguments().size();
        if (_Assertions.ENABLED && !bl2) {
            boolean $i$a$-assert-TypeAliasExpander$expandNonArgumentTypeProjection$22 = false;
            String $i$a$-assert-TypeAliasExpander$expandNonArgumentTypeProjection$22 = "Unexpected malformed type: " + type;
            throw new AssertionError((Object)$i$a$-assert-TypeAliasExpander$expandNonArgumentTypeProjection$22);
        }
        ClassifierDescriptor classifierDescriptor = typeDescriptor;
        if (classifierDescriptor instanceof TypeParameterDescriptor) {
            typeProjection = originalProjection;
        } else if (classifierDescriptor instanceof TypeAliasDescriptor) {
            void $this$mapIndexedTo$iv$iv;
            if (typeAliasExpansion.isRecursion((TypeAliasDescriptor)typeDescriptor)) {
                this.reportStrategy.recursiveTypeAlias((TypeAliasDescriptor)typeDescriptor);
                String[] $i$a$-assert-TypeAliasExpander$expandNonArgumentTypeProjection$22 = new String[]{((TypeAliasDescriptor)typeDescriptor).getName().toString()};
                return new TypeProjectionImpl(Variance.INVARIANT, ErrorUtils.createErrorType(ErrorTypeKind.RECURSIVE_TYPE_ALIAS, $i$a$-assert-TypeAliasExpander$expandNonArgumentTypeProjection$22));
            }
            Iterable $this$mapIndexed$iv = type.getArguments();
            boolean $i$f$mapIndexed = false;
            Iterable iterable = $this$mapIndexed$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            boolean $i$f$mapIndexedTo = false;
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
                void i2;
                void typeAliasArgument;
                int n2;
                if ((n2 = index$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                TypeProjection typeProjection2 = (TypeProjection)item$iv$iv;
                int n3 = n2;
                Collection collection = destination$iv$iv;
                boolean bl4 = false;
                collection.add(this.expandTypeProjection((TypeProjection)typeAliasArgument, typeAliasExpansion, typeConstructor2.getParameters().get((int)i2), recursionDepth + 1));
            }
            List expandedArguments = (List)destination$iv$iv;
            TypeAliasExpansion nestedExpansion = TypeAliasExpansion.Companion.create(typeAliasExpansion, (TypeAliasDescriptor)typeDescriptor, expandedArguments);
            SimpleType nestedExpandedType = this.expandRecursively(nestedExpansion, type.getAttributes(), type.isMarkedNullable(), recursionDepth + 1, false);
            SimpleType substitutedType = this.substituteArguments(type, typeAliasExpansion, recursionDepth);
            SimpleType typeWithAbbreviation = DynamicTypesKt.isDynamic(nestedExpandedType) ? nestedExpandedType : SpecialTypesKt.withAbbreviation(nestedExpandedType, substitutedType);
            typeProjection = new TypeProjectionImpl(originalProjection.getProjectionKind(), typeWithAbbreviation);
        } else {
            SimpleType substitutedType = this.substituteArguments(type, typeAliasExpansion, recursionDepth);
            this.checkTypeArgumentsSubstitution(type, substitutedType);
            typeProjection = new TypeProjectionImpl(originalProjection.getProjectionKind(), substitutedType);
        }
        return typeProjection;
    }

    /*
     * WARNING - void declaration
     */
    private final SimpleType substituteArguments(SimpleType $this$substituteArguments, TypeAliasExpansion typeAliasExpansion, int recursionDepth) {
        void $this$mapIndexedTo$iv$iv;
        TypeConstructor typeConstructor2 = $this$substituteArguments.getConstructor();
        Iterable $this$mapIndexed$iv = $this$substituteArguments.getArguments();
        boolean $i$f$mapIndexed = false;
        Iterable iterable = $this$mapIndexed$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        boolean $i$f$mapIndexedTo = false;
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
            void i2;
            void originalArgument;
            int n2;
            if ((n2 = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection)item$iv$iv;
            int n3 = n2;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            TypeProjection projection = this.expandTypeProjection((TypeProjection)originalArgument, typeAliasExpansion, typeConstructor2.getParameters().get((int)i2), recursionDepth + 1);
            collection.add(projection.isStarProjection() ? projection : (TypeProjection)new TypeProjectionImpl(projection.getProjectionKind(), TypeUtils.makeNullableIfNeeded(projection.getType(), originalArgument.getType().isMarkedNullable())));
        }
        List substitutedArguments = (List)destination$iv$iv;
        return TypeSubstitutionKt.replace$default($this$substituteArguments, substitutedArguments, null, 2, null);
    }

    /*
     * WARNING - void declaration
     */
    private final void checkTypeArgumentsSubstitution(KotlinType unsubstitutedType, KotlinType substitutedType) {
        TypeSubstitutor typeSubstitutor2 = TypeSubstitutor.create(substitutedType);
        Intrinsics.checkNotNullExpressionValue(typeSubstitutor2, "create(...)");
        TypeSubstitutor typeSubstitutor3 = typeSubstitutor2;
        Iterable $this$forEachIndexed$iv = substitutedType.getArguments();
        boolean $i$f$forEachIndexed = false;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            void substitutedArgument;
            int n2;
            if ((n2 = index$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection)item$iv;
            int i2 = n2;
            boolean bl2 = false;
            if (substitutedArgument.isStarProjection()) continue;
            KotlinType kotlinType = substitutedArgument.getType();
            Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
            if (TypeUtilsKt.containsTypeAliasParameters(kotlinType)) continue;
            TypeProjection unsubstitutedArgument = unsubstitutedType.getArguments().get(i2);
            TypeParameterDescriptor typeParameter = unsubstitutedType.getConstructor().getParameters().get(i2);
            if (!this.shouldCheckBounds) continue;
            KotlinType kotlinType2 = unsubstitutedArgument.getType();
            Intrinsics.checkNotNullExpressionValue(kotlinType2, "getType(...)");
            KotlinType kotlinType3 = substitutedArgument.getType();
            Intrinsics.checkNotNullExpressionValue(kotlinType3, "getType(...)");
            Intrinsics.checkNotNull(typeParameter);
            this.reportStrategy.boundsViolationInSubstitution(typeSubstitutor3, kotlinType2, kotlinType3, typeParameter);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        private final void assertRecursionDepth(int recursionDepth, TypeAliasDescriptor typeAliasDescriptor) {
            if (recursionDepth > 100) {
                throw new AssertionError((Object)("Too deep recursion while expanding type alias " + typeAliasDescriptor.getName()));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

