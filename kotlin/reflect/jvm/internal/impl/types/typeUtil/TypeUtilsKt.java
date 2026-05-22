/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.AbstractStubType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$$Lambda$4;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$$Lambda$5;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nTypeUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeUtils.kt\norg/jetbrains/kotlin/types/typeUtil/TypeUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,390:1\n245#1,14:415\n260#1:433\n249#1,12:434\n245#1,14:446\n260#1:464\n249#1,12:465\n256#1,3:483\n260#1:490\n256#1,3:491\n260#1:498\n256#1,3:499\n260#1:506\n381#1:532\n381#1:533\n381#1:534\n1761#2,3:391\n1563#2:394\n1634#2,3:395\n1617#2,9:399\n1869#2:408\n1870#2:410\n1626#2:411\n774#2:412\n865#2,2:413\n1563#2:429\n1634#2,3:430\n1563#2:460\n1634#2,3:461\n1761#2,3:477\n1761#2,3:480\n1563#2:486\n1634#2,3:487\n1563#2:494\n1634#2,3:495\n1563#2:502\n1634#2,3:503\n1563#2:507\n1634#2,3:508\n1563#2:511\n1634#2,3:512\n1761#2,3:515\n295#2,2:518\n1563#2:520\n1634#2,3:521\n1563#2:524\n1634#2,3:525\n1563#2:528\n1634#2,3:529\n1#3:398\n1#3:409\n*S KotlinDebug\n*F\n+ 1 TypeUtils.kt\norg/jetbrains/kotlin/types/typeUtil/TypeUtilsKt\n*L\n184#1:415,14\n184#1:433\n184#1:434,12\n185#1:446,14\n185#1:464\n185#1:465,12\n248#1:483,3\n248#1:490\n249#1:491,3\n249#1:498\n251#1:499,3\n251#1:506\n373#1:532\n376#1:533\n379#1:534\n80#1:391,3\n131#1:394\n131#1:395,3\n167#1:399,9\n167#1:408\n167#1:410\n167#1:411\n173#1:412\n173#1:413,2\n184#1:429\n184#1:430,3\n185#1:460\n185#1:461,3\n223#1:477,3\n235#1:480,3\n248#1:486\n248#1:487,3\n249#1:494\n249#1:495,3\n251#1:502\n251#1:503,3\n258#1:507\n258#1:508,3\n265#1:511\n265#1:512,3\n291#1:515,3\n298#1:518,2\n308#1:520\n308#1:521,3\n327#1:524\n327#1:525,3\n335#1:528\n335#1:529,3\n167#1:409\n*E\n"})
public final class TypeUtilsKt {
    @NotNull
    public static final KotlinBuiltIns getBuiltIns(@NotNull KotlinType $this$builtIns) {
        Intrinsics.checkNotNullParameter($this$builtIns, "<this>");
        KotlinBuiltIns kotlinBuiltIns = $this$builtIns.getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(kotlinBuiltIns, "getBuiltIns(...)");
        return kotlinBuiltIns;
    }

    @NotNull
    public static final KotlinType makeNullable(@NotNull KotlinType $this$makeNullable) {
        Intrinsics.checkNotNullParameter($this$makeNullable, "<this>");
        KotlinType kotlinType = TypeUtils.makeNullable($this$makeNullable);
        Intrinsics.checkNotNullExpressionValue(kotlinType, "makeNullable(...)");
        return kotlinType;
    }

    @NotNull
    public static final KotlinType makeNotNullable(@NotNull KotlinType $this$makeNotNullable) {
        Intrinsics.checkNotNullParameter($this$makeNotNullable, "<this>");
        KotlinType kotlinType = TypeUtils.makeNotNullable($this$makeNotNullable);
        Intrinsics.checkNotNullExpressionValue(kotlinType, "makeNotNullable(...)");
        return kotlinType;
    }

    public static final boolean isNothing(@NotNull KotlinType $this$isNothing) {
        Intrinsics.checkNotNullParameter($this$isNothing, "<this>");
        return KotlinBuiltIns.isNothing($this$isNothing);
    }

    public static final boolean isBoolean(@NotNull KotlinType $this$isBoolean) {
        Intrinsics.checkNotNullParameter($this$isBoolean, "<this>");
        return KotlinBuiltIns.isBoolean($this$isBoolean);
    }

    public static final boolean isTypeParameter(@NotNull KotlinType $this$isTypeParameter) {
        Intrinsics.checkNotNullParameter($this$isTypeParameter, "<this>");
        return TypeUtils.isTypeParameter($this$isTypeParameter);
    }

    public static final boolean containsTypeParameter(@NotNull KotlinType $this$containsTypeParameter) {
        Intrinsics.checkNotNullParameter($this$containsTypeParameter, "<this>");
        return TypeUtils.contains($this$containsTypeParameter, TypeUtilsKt$$Lambda$0.INSTANCE);
    }

    public static final boolean isSubtypeOf(@NotNull KotlinType $this$isSubtypeOf, @NotNull KotlinType superType) {
        Intrinsics.checkNotNullParameter($this$isSubtypeOf, "<this>");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return KotlinTypeChecker.DEFAULT.isSubtypeOf($this$isSubtypeOf, superType);
    }

    @NotNull
    public static final KotlinType replaceAnnotations(@NotNull KotlinType $this$replaceAnnotations, @NotNull Annotations newAnnotations) {
        Intrinsics.checkNotNullParameter($this$replaceAnnotations, "<this>");
        Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
        if ($this$replaceAnnotations.getAnnotations().isEmpty() && newAnnotations.isEmpty()) {
            return $this$replaceAnnotations;
        }
        return $this$replaceAnnotations.unwrap().replaceAttributes(TypeAttributesKt.replaceAnnotations($this$replaceAnnotations.getAttributes(), newAnnotations));
    }

    @NotNull
    public static final TypeProjection createProjection(@NotNull KotlinType type, @NotNull Variance projectionKind, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter((Object)projectionKind, "projectionKind");
        TypeParameterDescriptor typeParameterDescriptor2 = typeParameterDescriptor;
        return new TypeProjectionImpl((typeParameterDescriptor2 != null ? typeParameterDescriptor2.getVariance() : null) == projectionKind ? Variance.INVARIANT : projectionKind, type);
    }

    @NotNull
    public static final TypeProjection asTypeProjection(@NotNull KotlinType $this$asTypeProjection) {
        Intrinsics.checkNotNullParameter($this$asTypeProjection, "<this>");
        return new TypeProjectionImpl($this$asTypeProjection);
    }

    public static final boolean contains(@NotNull KotlinType $this$contains, @NotNull Function1<? super UnwrappedType, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return TypeUtils.contains($this$contains, predicate);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final KotlinType replaceArgumentsWithStarProjections(@NotNull KotlinType $this$replaceArgumentsWithStarProjections) {
        UnwrappedType unwrappedType;
        UnwrappedType unwrapped$iv;
        Intrinsics.checkNotNullParameter($this$replaceArgumentsWithStarProjections, "<this>");
        KotlinType $this$replaceArgumentsByParametersWith$iv = $this$replaceArgumentsWithStarProjections;
        boolean $i$f$replaceArgumentsByParametersWith = false;
        UnwrappedType unwrappedType2 = unwrapped$iv = $this$replaceArgumentsByParametersWith$iv.unwrap();
        if (unwrappedType2 instanceof FlexibleType) {
            SimpleType simpleType;
            List newArguments$iv$iv;
            Collection collection;
            Iterable $this$mapTo$iv$iv$iv$iv;
            boolean $i$f$mapTo;
            Collection destination$iv$iv$iv$iv;
            boolean $i$f$map;
            Iterable $this$map$iv$iv$iv;
            SimpleType simpleType2;
            SimpleType $this$replaceArgumentsByParametersWith$iv$iv = ((FlexibleType)unwrapped$iv).getLowerBound();
            boolean $i$f$replaceArgumentsByParametersWith2 = false;
            if ($this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getParameters().isEmpty() || $this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getDeclarationDescriptor() == null) {
                simpleType2 = $this$replaceArgumentsByParametersWith$iv$iv;
            } else {
                List<TypeParameterDescriptor> list = $this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
                $this$map$iv$iv$iv = list;
                $i$f$map = false;
                Iterable iterable = $this$map$iv$iv$iv;
                destination$iv$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv$iv, 10));
                $i$f$mapTo = false;
                for (Object item$iv$iv$iv$iv : $this$mapTo$iv$iv$iv$iv) {
                    void p0;
                    TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv$iv$iv;
                    collection = destination$iv$iv$iv$iv;
                    boolean bl2 = false;
                    collection.add(new StarProjectionImpl((TypeParameterDescriptor)p0));
                }
                newArguments$iv$iv = (List)destination$iv$iv$iv$iv;
                simpleType2 = TypeSubstitutionKt.replace$default($this$replaceArgumentsByParametersWith$iv$iv, newArguments$iv$iv, null, 2, null);
            }
            $this$replaceArgumentsByParametersWith$iv$iv = ((FlexibleType)unwrapped$iv).getUpperBound();
            SimpleType simpleType3 = simpleType2;
            $i$f$replaceArgumentsByParametersWith2 = false;
            if ($this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getParameters().isEmpty() || $this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getDeclarationDescriptor() == null) {
                simpleType = $this$replaceArgumentsByParametersWith$iv$iv;
            } else {
                List<TypeParameterDescriptor> list = $this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
                $this$map$iv$iv$iv = list;
                $i$f$map = false;
                $this$mapTo$iv$iv$iv$iv = $this$map$iv$iv$iv;
                destination$iv$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv$iv, 10));
                $i$f$mapTo = false;
                for (Object item$iv$iv$iv$iv : $this$mapTo$iv$iv$iv$iv) {
                    void p0;
                    TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv$iv$iv;
                    collection = destination$iv$iv$iv$iv;
                    boolean bl3 = false;
                    collection.add(new StarProjectionImpl((TypeParameterDescriptor)p0));
                }
                newArguments$iv$iv = (List)destination$iv$iv$iv$iv;
                simpleType = TypeSubstitutionKt.replace$default($this$replaceArgumentsByParametersWith$iv$iv, newArguments$iv$iv, null, 2, null);
            }
            unwrappedType = KotlinTypeFactory.flexibleType(simpleType3, simpleType);
        } else if (unwrappedType2 instanceof SimpleType) {
            SimpleType simpleType;
            SimpleType $this$replaceArgumentsByParametersWith$iv$iv = (SimpleType)unwrapped$iv;
            boolean $i$f$replaceArgumentsByParametersWith3 = false;
            if ($this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getParameters().isEmpty() || $this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getDeclarationDescriptor() == null) {
                simpleType = $this$replaceArgumentsByParametersWith$iv$iv;
            } else {
                List<TypeParameterDescriptor> list = $this$replaceArgumentsByParametersWith$iv$iv.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
                Iterable $this$map$iv$iv$iv = list;
                boolean $i$f$map = false;
                Iterable $this$mapTo$iv$iv$iv$iv = $this$map$iv$iv$iv;
                Collection destination$iv$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv$iv$iv : $this$mapTo$iv$iv$iv$iv) {
                    TypeParameterDescriptor p0 = (TypeParameterDescriptor)item$iv$iv$iv$iv;
                    Collection collection = destination$iv$iv$iv$iv;
                    boolean bl4 = false;
                    collection.add(new StarProjectionImpl(p0));
                }
                List newArguments$iv$iv = (List)destination$iv$iv$iv$iv;
                simpleType = TypeSubstitutionKt.replace$default($this$replaceArgumentsByParametersWith$iv$iv, newArguments$iv$iv, null, 2, null);
            }
            unwrappedType = simpleType;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(unwrappedType, unwrapped$iv);
    }

    @NotNull
    public static final Set<TypeParameterDescriptor> extractTypeParametersFromUpperBounds(@NotNull KotlinType $this$extractTypeParametersFromUpperBounds, @Nullable Set<? extends TypeParameterDescriptor> visitedTypeParameters) {
        Set set;
        Intrinsics.checkNotNullParameter($this$extractTypeParametersFromUpperBounds, "<this>");
        Set it = set = (Set)new LinkedHashSet();
        boolean bl2 = false;
        TypeUtilsKt.extractTypeParametersFromUpperBounds($this$extractTypeParametersFromUpperBounds, $this$extractTypeParametersFromUpperBounds, it, visitedTypeParameters);
        return set;
    }

    private static final void extractTypeParametersFromUpperBounds(KotlinType $this$extractTypeParametersFromUpperBounds, KotlinType baseType, Set<TypeParameterDescriptor> to, Set<? extends TypeParameterDescriptor> visitedTypeParameters) {
        ClassifierDescriptor declarationDescriptor = $this$extractTypeParametersFromUpperBounds.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            if (!Intrinsics.areEqual($this$extractTypeParametersFromUpperBounds.getConstructor(), baseType.getConstructor())) {
                ((Collection)to).add(declarationDescriptor);
            } else {
                for (KotlinType upperBound : ((TypeParameterDescriptor)declarationDescriptor).getUpperBounds()) {
                    Intrinsics.checkNotNull(upperBound);
                    TypeUtilsKt.extractTypeParametersFromUpperBounds(upperBound, baseType, to, visitedTypeParameters);
                }
            }
        } else {
            ClassifierDescriptor classifierDescriptor = $this$extractTypeParametersFromUpperBounds.getConstructor().getDeclarationDescriptor();
            ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = classifierDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters)classifierDescriptor : null;
            List<TypeParameterDescriptor> typeParameters = classifierDescriptorWithTypeParameters != null ? classifierDescriptorWithTypeParameters.getDeclaredTypeParameters() : null;
            Iterator iterator2 = ((Iterable)$this$extractTypeParametersFromUpperBounds.getArguments()).iterator();
            int n2 = 0;
            while (iterator2.hasNext()) {
                int i2 = n2++;
                TypeProjection argument = (TypeProjection)iterator2.next();
                List<TypeParameterDescriptor> list = typeParameters;
                TypeParameterDescriptor typeParameter = list != null ? CollectionsKt.getOrNull(list, i2) : null;
                boolean isTypeParameterVisited = typeParameter != null && visitedTypeParameters != null && visitedTypeParameters.contains(typeParameter);
                if (isTypeParameterVisited || argument.isStarProjection() || CollectionsKt.contains((Iterable)to, argument.getType().getConstructor().getDeclarationDescriptor()) || Intrinsics.areEqual(argument.getType().getConstructor(), baseType.getConstructor())) continue;
                KotlinType kotlinType = argument.getType();
                Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
                TypeUtilsKt.extractTypeParametersFromUpperBounds(kotlinType, baseType, to, visitedTypeParameters);
            }
        }
    }

    @JvmOverloads
    public static final boolean hasTypeParameterRecursiveBounds(@NotNull TypeParameterDescriptor typeParameter, @Nullable TypeConstructor selfConstructor, @Nullable Set<? extends TypeParameterDescriptor> visitedTypeParameters) {
        boolean bl2;
        block3: {
            Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
            List<KotlinType> list = typeParameter.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(list, "getUpperBounds(...)");
            Iterable $this$any$iv = list;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    KotlinType upperBound = (KotlinType)element$iv;
                    boolean bl3 = false;
                    Intrinsics.checkNotNull(upperBound);
                    if (!(TypeUtilsKt.containsSelfTypeParameter(upperBound, typeParameter.getDefaultType().getConstructor(), visitedTypeParameters) && (selfConstructor == null || Intrinsics.areEqual(upperBound.getConstructor(), selfConstructor)))) continue;
                    bl2 = true;
                    break block3;
                }
                bl2 = false;
            }
        }
        return bl2;
    }

    public static /* synthetic */ boolean hasTypeParameterRecursiveBounds$default(TypeParameterDescriptor typeParameterDescriptor, TypeConstructor typeConstructor2, Set set, int n2, Object object) {
        if ((n2 & 2) != 0) {
            typeConstructor2 = null;
        }
        if ((n2 & 4) != 0) {
            set = null;
        }
        return TypeUtilsKt.hasTypeParameterRecursiveBounds(typeParameterDescriptor, typeConstructor2, set);
    }

    private static final boolean containsSelfTypeParameter(KotlinType $this$containsSelfTypeParameter, TypeConstructor baseConstructor, Set<? extends TypeParameterDescriptor> visitedTypeParameters) {
        boolean bl2;
        block6: {
            if (Intrinsics.areEqual($this$containsSelfTypeParameter.getConstructor(), baseConstructor)) {
                return true;
            }
            ClassifierDescriptor classifierDescriptor = $this$containsSelfTypeParameter.getConstructor().getDeclarationDescriptor();
            ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = classifierDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters)classifierDescriptor : null;
            List<TypeParameterDescriptor> typeParameters = classifierDescriptorWithTypeParameters != null ? classifierDescriptorWithTypeParameters.getDeclaredTypeParameters() : null;
            Iterable $this$any$iv = CollectionsKt.withIndex((Iterable)$this$containsSelfTypeParameter.getArguments());
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                Iterator iterator2 = $this$any$iv.iterator();
                while (iterator2.hasNext()) {
                    boolean bl3;
                    boolean isTypeParameterVisited;
                    IndexedValue element$iv;
                    IndexedValue indexedValue = element$iv = iterator2.next();
                    boolean bl4 = false;
                    int i2 = indexedValue.component1();
                    TypeProjection argument = (TypeProjection)indexedValue.component2();
                    List<TypeParameterDescriptor> list = typeParameters;
                    TypeParameterDescriptor typeParameter = list != null ? CollectionsKt.getOrNull(list, i2) : null;
                    boolean bl5 = isTypeParameterVisited = typeParameter != null && visitedTypeParameters != null && visitedTypeParameters.contains(typeParameter);
                    if (isTypeParameterVisited || argument.isStarProjection()) {
                        bl3 = false;
                    } else {
                        KotlinType kotlinType = argument.getType();
                        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
                        bl3 = TypeUtilsKt.containsSelfTypeParameter(kotlinType, baseConstructor, visitedTypeParameters);
                    }
                    if (!bl3) continue;
                    bl2 = true;
                    break block6;
                }
                bl2 = false;
            }
        }
        return bl2;
    }

    public static final boolean containsTypeAliasParameters(@NotNull KotlinType $this$containsTypeAliasParameters) {
        Intrinsics.checkNotNullParameter($this$containsTypeAliasParameters, "<this>");
        return TypeUtilsKt.contains($this$containsTypeAliasParameters, TypeUtilsKt$$Lambda$2.INSTANCE);
    }

    public static final boolean isTypeAliasParameter(@NotNull ClassifierDescriptor $this$isTypeAliasParameter) {
        Intrinsics.checkNotNullParameter($this$isTypeAliasParameter, "<this>");
        return $this$isTypeAliasParameter instanceof TypeParameterDescriptor && ((TypeParameterDescriptor)$this$isTypeAliasParameter).getContainingDeclaration() instanceof TypeAliasDescriptor;
    }

    public static final boolean requiresTypeAliasExpansion(@NotNull KotlinType $this$requiresTypeAliasExpansion) {
        Intrinsics.checkNotNullParameter($this$requiresTypeAliasExpansion, "<this>");
        return TypeUtilsKt.contains($this$requiresTypeAliasExpansion, TypeUtilsKt$$Lambda$4.INSTANCE);
    }

    @NotNull
    public static final KotlinType getRepresentativeUpperBound(@NotNull TypeParameterDescriptor $this$representativeUpperBound) {
        KotlinType kotlinType;
        Object v4;
        block3: {
            boolean bl2;
            Intrinsics.checkNotNullParameter($this$representativeUpperBound, "<this>");
            List<KotlinType> list = $this$representativeUpperBound.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(list, "getUpperBounds(...)");
            boolean bl3 = bl2 = !((Collection)list).isEmpty();
            if (_Assertions.ENABLED && !bl2) {
                boolean $i$a$-assert-TypeUtilsKt$representativeUpperBound$22 = false;
                String $i$a$-assert-TypeUtilsKt$representativeUpperBound$22 = "Upper bounds should not be empty: " + $this$representativeUpperBound;
                throw new AssertionError((Object)$i$a$-assert-TypeUtilsKt$representativeUpperBound$22);
            }
            List<KotlinType> list2 = $this$representativeUpperBound.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(list2, "getUpperBounds(...)");
            Iterable $this$firstOrNull$iv = list2;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                ClassDescriptor classDescriptor;
                KotlinType it = (KotlinType)element$iv;
                boolean bl4 = false;
                ClassifierDescriptor classifierDescriptor = it.getConstructor().getDeclarationDescriptor();
                ClassDescriptor classDescriptor2 = classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
                if (!(classDescriptor2 == null ? false : (classDescriptor = classDescriptor2).getKind() != ClassKind.INTERFACE && classDescriptor.getKind() != ClassKind.ANNOTATION_CLASS)) continue;
                v4 = element$iv;
                break block3;
            }
            v4 = null;
        }
        if ((kotlinType = (KotlinType)v4) == null) {
            List<KotlinType> list = $this$representativeUpperBound.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(list, "getUpperBounds(...)");
            KotlinType kotlinType2 = CollectionsKt.first(list);
            Intrinsics.checkNotNullExpressionValue(kotlinType2, "first(...)");
            kotlinType = kotlinType2;
        }
        return kotlinType;
    }

    public static final boolean shouldBeUpdated(@Nullable KotlinType $this$shouldBeUpdated) {
        return $this$shouldBeUpdated == null || TypeUtilsKt.contains($this$shouldBeUpdated, TypeUtilsKt$$Lambda$5.INSTANCE);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean isStubType(@NotNull KotlinType $this$isStubType) {
        Intrinsics.checkNotNullParameter($this$isStubType, "<this>");
        if ($this$isStubType instanceof AbstractStubType) return true;
        KotlinType $this$isDefNotNullStubType$iv = $this$isStubType;
        boolean $i$f$isDefNotNullStubType = false;
        if (!($this$isDefNotNullStubType$iv instanceof DefinitelyNotNullType)) return false;
        if (!(((DefinitelyNotNullType)$this$isDefNotNullStubType$iv).getOriginal() instanceof AbstractStubType)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean isStubTypeForBuilderInference(@NotNull KotlinType $this$isStubTypeForBuilderInference) {
        Intrinsics.checkNotNullParameter($this$isStubTypeForBuilderInference, "<this>");
        if ($this$isStubTypeForBuilderInference instanceof StubTypeForBuilderInference) return true;
        KotlinType $this$isDefNotNullStubType$iv = $this$isStubTypeForBuilderInference;
        boolean $i$f$isDefNotNullStubType = false;
        if (!($this$isDefNotNullStubType$iv instanceof DefinitelyNotNullType)) return false;
        if (!(((DefinitelyNotNullType)$this$isDefNotNullStubType$iv).getOriginal() instanceof StubTypeForBuilderInference)) return false;
        return true;
    }

    public static final boolean isUnresolvedType(@NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return type instanceof ErrorType && ((ErrorType)type).getKind().isUnresolved();
    }

    @JvmOverloads
    public static final boolean hasTypeParameterRecursiveBounds(@NotNull TypeParameterDescriptor typeParameter) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        return TypeUtilsKt.hasTypeParameterRecursiveBounds$default(typeParameter, null, null, 6, null);
    }

    private static final Boolean containsTypeParameter$lambda$0(UnwrappedType t2) {
        return TypeUtils.isTypeParameter(t2);
    }

    private static final boolean containsTypeAliasParameters$lambda$13(UnwrappedType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ClassifierDescriptor classifierDescriptor = it.getConstructor().getDeclarationDescriptor();
        return classifierDescriptor != null ? TypeUtilsKt.isTypeAliasParameter(classifierDescriptor) : false;
    }

    private static final boolean requiresTypeAliasExpansion$lambda$16(UnwrappedType it) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(it, "it");
        ClassifierDescriptor classifierDescriptor = it.getConstructor().getDeclarationDescriptor();
        if (classifierDescriptor != null) {
            ClassifierDescriptor it2 = classifierDescriptor;
            boolean bl3 = false;
            bl2 = it2 instanceof TypeAliasDescriptor || it2 instanceof TypeParameterDescriptor;
        } else {
            bl2 = false;
        }
        return bl2;
    }

    private static final boolean shouldBeUpdated$lambda$23(UnwrappedType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof StubTypeForBuilderInference || it.getConstructor() instanceof TypeVariableTypeConstructorMarker || KotlinTypeKt.isError(it);
    }

    static /* synthetic */ Boolean accessor$TypeUtilsKt$lambda0(UnwrappedType unwrappedType) {
        return TypeUtilsKt.containsTypeParameter$lambda$0(unwrappedType);
    }

    static /* synthetic */ boolean accessor$TypeUtilsKt$lambda2(UnwrappedType unwrappedType) {
        return TypeUtilsKt.containsTypeAliasParameters$lambda$13(unwrappedType);
    }

    static /* synthetic */ boolean accessor$TypeUtilsKt$lambda4(UnwrappedType unwrappedType) {
        return TypeUtilsKt.requiresTypeAliasExpansion$lambda$16(unwrappedType);
    }

    static /* synthetic */ boolean accessor$TypeUtilsKt$lambda5(UnwrappedType unwrappedType) {
        return TypeUtilsKt.shouldBeUpdated$lambda$23(unwrappedType);
    }
}

