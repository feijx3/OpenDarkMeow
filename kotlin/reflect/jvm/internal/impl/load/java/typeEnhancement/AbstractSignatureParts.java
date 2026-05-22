/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nAbstractSignatureParts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSignatureParts.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/AbstractSignatureParts\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,234:1\n1#2:235\n1#2:258\n1#2:281\n774#3:236\n865#3,2:237\n1740#3,3:239\n1761#3,3:242\n1761#3,3:245\n1617#3,9:248\n1869#3:257\n1870#3:259\n1626#3:260\n1740#3,3:261\n1563#3:264\n1634#3,3:265\n1761#3,3:268\n1617#3,9:271\n1869#3:280\n1870#3:282\n1626#3:283\n1869#3,2:284\n3544#3,7:286\n*S KotlinDebug\n*F\n+ 1 AbstractSignatureParts.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/AbstractSignatureParts\n*L\n162#1:258\n188#1:281\n90#1:236\n90#1:237,2\n159#1:239,3\n161#1:242,3\n162#1:245,3\n162#1:248,9\n162#1:257\n162#1:259\n162#1:260\n165#1:261,3\n175#1:264\n175#1:265,3\n183#1:268,3\n188#1:271,9\n188#1:280\n188#1:282\n188#1:283\n201#1:284,2\n215#1:286,7\n*E\n"})
public abstract class AbstractSignatureParts<TAnnotation> {
    @NotNull
    public abstract AbstractAnnotationTypeQualifierResolver<TAnnotation> getAnnotationTypeQualifierResolver();

    public abstract boolean getEnableImprovementsInStrictMode();

    @NotNull
    public abstract Iterable<TAnnotation> getContainerAnnotations();

    @NotNull
    public abstract AnnotationQualifierApplicabilityType getContainerApplicabilityType();

    @Nullable
    public abstract JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers();

    public abstract boolean getContainerIsVarargParameter();

    public abstract boolean isCovariant();

    public abstract boolean getSkipRawTypeArguments();

    @NotNull
    public abstract TypeSystemContext getTypeSystem();

    public boolean getForceOnlyHeadTypeConstructor() {
        return false;
    }

    public abstract boolean forceWarning(@NotNull TAnnotation var1, @Nullable KotlinTypeMarker var2);

    @NotNull
    public abstract Iterable<TAnnotation> getAnnotations(@NotNull KotlinTypeMarker var1);

    @Nullable
    public abstract KotlinTypeMarker getEnhancedForWarnings(@NotNull KotlinTypeMarker var1);

    @Nullable
    public abstract FqNameUnsafe getFqNameUnsafe(@NotNull KotlinTypeMarker var1);

    public abstract boolean isEqual(@NotNull KotlinTypeMarker var1, @NotNull KotlinTypeMarker var2);

    public abstract boolean isArrayOrPrimitiveArray(@NotNull KotlinTypeMarker var1);

    public abstract boolean isFromJava(@NotNull TypeParameterMarker var1);

    public boolean isNotNullTypeParameterCompat(@NotNull KotlinTypeMarker $this$isNotNullTypeParameterCompat) {
        Intrinsics.checkNotNullParameter($this$isNotNullTypeParameterCompat, "<this>");
        return false;
    }

    private final NullabilityQualifier getNullabilityQualifier(KotlinTypeMarker $this$nullabilityQualifier) {
        TypeSystemContext $this$_get_nullabilityQualifier__u24lambda_u240 = this.getTypeSystem();
        boolean bl2 = false;
        return $this$_get_nullabilityQualifier__u24lambda_u240.isMarkedNullable($this$_get_nullabilityQualifier__u24lambda_u240.lowerBoundIfFlexible($this$nullabilityQualifier)) ? NullabilityQualifier.NULLABLE : (!$this$_get_nullabilityQualifier__u24lambda_u240.isMarkedNullable($this$_get_nullabilityQualifier__u24lambda_u240.upperBoundIfFlexible($this$nullabilityQualifier)) ? NullabilityQualifier.NOT_NULL : null);
    }

    private final JavaTypeQualifiers extractQualifiers(KotlinTypeMarker $this$extractQualifiers) {
        NullabilityQualifier forErrors = this.getNullabilityQualifier($this$extractQualifiers);
        NullabilityQualifier nullabilityQualifier = forErrors;
        if (nullabilityQualifier == null) {
            KotlinTypeMarker kotlinTypeMarker = this.getEnhancedForWarnings($this$extractQualifiers);
            nullabilityQualifier = kotlinTypeMarker != null ? this.getNullabilityQualifier(kotlinTypeMarker) : null;
        }
        NullabilityQualifier forErrorsOrWarnings = nullabilityQualifier;
        TypeSystemContext $this$extractQualifiers_u24lambda_u241 = this.getTypeSystem();
        boolean bl2 = false;
        MutabilityQualifier mutability = JavaToKotlinClassMap.INSTANCE.isReadOnly(this.getFqNameUnsafe($this$extractQualifiers_u24lambda_u241.lowerBoundIfFlexible($this$extractQualifiers))) ? MutabilityQualifier.READ_ONLY : (JavaToKotlinClassMap.INSTANCE.isMutable(this.getFqNameUnsafe($this$extractQualifiers_u24lambda_u241.upperBoundIfFlexible($this$extractQualifiers))) ? MutabilityQualifier.MUTABLE : null);
        TypeSystemContext $this$extractQualifiers_u24lambda_u242 = this.getTypeSystem();
        boolean bl3 = false;
        boolean isNotNullTypeParameter = $this$extractQualifiers_u24lambda_u242.isDefinitelyNotNullType($this$extractQualifiers) || this.isNotNullTypeParameterCompat($this$extractQualifiers);
        return new JavaTypeQualifiers(forErrorsOrWarnings, mutability, isNotNullTypeParameter, forErrorsOrWarnings != forErrors);
    }

    /*
     * Unable to fully structure code
     */
    private final JavaTypeQualifiers extractQualifiersFromAnnotations(TypeAndDefaultQualifiers $this$extractQualifiersFromAnnotations) {
        block13: {
            block12: {
                if ($this$extractQualifiersFromAnnotations.getType() == null) {
                    $this$extractQualifiersFromAnnotations_u24lambda_u243 = this.getTypeSystem();
                    $i$a$-with-AbstractSignatureParts$extractQualifiersFromAnnotations$1 = false;
                    v0 = $this$extractQualifiersFromAnnotations.getTypeParameterForArgument();
                    if ((v0 != null ? $this$extractQualifiersFromAnnotations_u24lambda_u243.getVariance(v0) : null) == TypeVariance.IN) {
                        return JavaTypeQualifiers.Companion.getNONE();
                    }
                }
                isHeadTypeConstructor = $this$extractQualifiersFromAnnotations.getTypeParameterForArgument() == null;
                v1 = $this$extractQualifiersFromAnnotations.getType();
                if (v1 == null || (v1 = this.getAnnotations((KotlinTypeMarker)v1)) == null) {
                    v1 = CollectionsKt.emptyList();
                }
                typeAnnotations = v1;
                $this$extractQualifiersFromAnnotations_u24lambda_u244 = this.getTypeSystem();
                $i$a$-with-AbstractSignatureParts$extractQualifiersFromAnnotations$typeParameterUse$1 = false;
                v2 = $this$extractQualifiersFromAnnotations.getType();
                typeParameterUse = v2 != null && (v2 = $this$extractQualifiersFromAnnotations_u24lambda_u244.typeConstructor((KotlinTypeMarker)v2)) != null ? $this$extractQualifiersFromAnnotations_u24lambda_u244.getTypeParameterClassifier((TypeConstructorMarker)v2) : null;
                typeParameterBounds = this.getContainerApplicabilityType() == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
                if (isHeadTypeConstructor) break block12;
                v3 = typeAnnotations;
                break block13;
            }
            if (typeParameterBounds || !this.getEnableImprovementsInStrictMode()) ** GOTO lbl-1000
            v4 = $this$extractQualifiersFromAnnotations.getType();
            v5 = v4 != null ? this.isArrayOrPrimitiveArray(v4) : false;
            if (v5) {
                $this$filter$iv = this.getContainerAnnotations();
                $i$f$filter = false;
                var9_13 = $this$filter$iv;
                destination$iv$iv = new ArrayList<E>();
                $i$f$filterTo = false;
                var12_17 = $this$filterTo$iv$iv.iterator();
                while (var12_17.hasNext()) {
                    it = element$iv$iv = var12_17.next();
                    $i$a$-filter-AbstractSignatureParts$extractQualifiersFromAnnotations$composedAnnotation$1 = false;
                    if (!(this.getAnnotationTypeQualifierResolver().isTypeUseAnnotation(it) == false)) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                v3 = CollectionsKt.plus((Collection)((List)destination$iv$iv), typeAnnotations);
            } else lbl-1000:
            // 2 sources

            {
                v3 = CollectionsKt.plus(this.getContainerAnnotations(), typeAnnotations);
            }
        }
        composedAnnotation = v3;
        annotationsMutability = this.getAnnotationTypeQualifierResolver().extractMutability(composedAnnotation);
        var19_23 = $this$extractQualifiersFromAnnotations;
        var20_24 = this;
        annotationsNullability = this.getAnnotationTypeQualifierResolver().extractNullability(composedAnnotation, (Function1<TAnnotation, Boolean>)new AbstractSignatureParts$$Lambda$0(var20_24, var19_23));
        if (annotationsNullability != null) {
            return new JavaTypeQualifiers(annotationsNullability.getQualifier(), annotationsMutability, annotationsNullability.getQualifier() == NullabilityQualifier.NOT_NULL && typeParameterUse != null, annotationsNullability.isForWarningOnly());
        }
        applicabilityType = isHeadTypeConstructor != false || typeParameterBounds != false ? this.getContainerApplicabilityType() : AnnotationQualifierApplicabilityType.TYPE_USE;
        v6 = $this$extractQualifiersFromAnnotations.getDefaultQualifiers();
        defaultTypeQualifier = v6 != null ? v6.get(applicabilityType) : null;
        v7 = typeParameterUse;
        referencedParameterBoundsNullability = v7 != null ? this.getBoundsNullability(v7) : null;
        defaultNullability = this.getDefaultNullability(referencedParameterBoundsNullability, defaultTypeQualifier);
        v8 = referencedParameterBoundsNullability;
        if ((v8 != null ? v8.getQualifier() : null) == NullabilityQualifier.NOT_NULL) ** GOTO lbl-1000
        if (typeParameterUse != null) {
            v9 = defaultTypeQualifier;
            v10 = v9 != null ? v9.getDefinitelyNotNull() : false;
            ** if (!v10) goto lbl-1000
        }
        ** GOTO lbl-1000
lbl-1000:
        // 2 sources

        {
            v11 = true;
            ** GOTO lbl66
        }
lbl-1000:
        // 2 sources

        {
            v11 = false;
        }
lbl66:
        // 2 sources

        definitelyNotNull = v11;
        $i$a$-filter-AbstractSignatureParts$extractQualifiersFromAnnotations$composedAnnotation$1 = $this$extractQualifiersFromAnnotations.getTypeParameterForArgument();
        if ($i$a$-filter-AbstractSignatureParts$extractQualifiersFromAnnotations$composedAnnotation$1 != null && (var16_25 = this.getBoundsNullability($i$a$-filter-AbstractSignatureParts$extractQualifiersFromAnnotations$composedAnnotation$1)) != null) {
            it = var16_25;
            $i$a$-let-AbstractSignatureParts$extractQualifiersFromAnnotations$substitutedParameterBoundsNullability$1 = false;
            v12 = it.getQualifier() == NullabilityQualifier.NULLABLE ? NullabilityQualifierWithMigrationStatus.copy$default(it, NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null) : it;
        } else {
            v12 = null;
        }
        substitutedParameterBoundsNullability = v12;
        v13 = result = this.mostSpecific(substitutedParameterBoundsNullability, defaultNullability);
        v14 = result;
        return new JavaTypeQualifiers(v13 != null ? v13.getQualifier() : null, annotationsMutability, definitelyNotNull, v14 != null ? v14.isForWarningOnly() : false);
    }

    @Nullable
    protected abstract NullabilityQualifierWithMigrationStatus getDefaultNullability(@Nullable NullabilityQualifierWithMigrationStatus var1, @Nullable JavaDefaultQualifiers var2);

    private final NullabilityQualifierWithMigrationStatus mostSpecific(NullabilityQualifierWithMigrationStatus a2, NullabilityQualifierWithMigrationStatus b2) {
        if (a2 == null) {
            return b2;
        }
        if (b2 == null) {
            return a2;
        }
        if (a2.isForWarningOnly() && !b2.isForWarningOnly()) {
            return b2;
        }
        if (!a2.isForWarningOnly() && b2.isForWarningOnly()) {
            return a2;
        }
        if (a2.getQualifier().compareTo((Enum)b2.getQualifier()) < 0) {
            return b2;
        }
        if (a2.getQualifier().compareTo((Enum)b2.getQualifier()) > 0) {
            return a2;
        }
        return b2;
    }

    /*
     * WARNING - void declaration
     */
    private final NullabilityQualifierWithMigrationStatus getBoundsNullability(TypeParameterMarker $this$boundsNullability) {
        boolean bl2;
        List enhancedBounds;
        List bounds;
        block22: {
            List list;
            boolean bl3;
            boolean $i$f$any;
            Iterable $this$any$iv;
            KotlinTypeMarker it;
            TypeSystemContext $this$_get_boundsNullability__u24lambda_u2413;
            block20: {
                boolean bl4;
                block19: {
                    $this$_get_boundsNullability__u24lambda_u2413 = this.getTypeSystem();
                    boolean bl5 = false;
                    if (!this.isFromJava($this$boundsNullability)) {
                        return null;
                    }
                    bounds = $this$_get_boundsNullability__u24lambda_u2413.getUpperBounds($this$boundsNullability);
                    Iterable $this$all$iv = bounds;
                    boolean $i$f$all = false;
                    if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                        bl4 = true;
                    } else {
                        for (Object element$iv : $this$all$iv) {
                            it = (KotlinTypeMarker)element$iv;
                            boolean bl6 = false;
                            if ($this$_get_boundsNullability__u24lambda_u2413.isError(it)) continue;
                            bl4 = false;
                            break block19;
                        }
                        bl4 = true;
                    }
                }
                if (bl4) {
                    return null;
                }
                $this$any$iv = bounds;
                $i$f$any = false;
                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                    bl3 = false;
                } else {
                    for (Object element$iv : $this$any$iv) {
                        it = (KotlinTypeMarker)element$iv;
                        boolean bl7 = false;
                        if (!(this.getNullabilityQualifier(it) != null)) continue;
                        bl3 = true;
                        break block20;
                    }
                    bl3 = false;
                }
            }
            if (bl3) {
                list = bounds;
            } else {
                boolean bl8;
                block21: {
                    $this$any$iv = bounds;
                    $i$f$any = false;
                    if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                        bl8 = false;
                    } else {
                        for (Object element$iv : $this$any$iv) {
                            it = (KotlinTypeMarker)element$iv;
                            boolean bl9 = false;
                            if (!(this.getEnhancedForWarnings(it) != null)) continue;
                            bl8 = true;
                            break block21;
                        }
                        bl8 = false;
                    }
                }
                if (bl8) {
                    void $this$mapNotNullTo$iv$iv;
                    Iterable $this$mapNotNull$iv = bounds;
                    boolean $i$f$mapNotNull = false;
                    Iterable iterable = $this$mapNotNull$iv;
                    Collection destination$iv$iv = new ArrayList();
                    boolean $i$f$mapNotNullTo = false;
                    void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                    boolean $i$f$forEach = false;
                    Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
                    while (iterator2.hasNext()) {
                        KotlinTypeMarker it$iv$iv;
                        Object element$iv$iv$iv;
                        Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                        boolean bl10 = false;
                        KotlinTypeMarker it2 = (KotlinTypeMarker)element$iv$iv;
                        boolean bl11 = false;
                        if (this.getEnhancedForWarnings(it2) == null) continue;
                        boolean bl12 = false;
                        destination$iv$iv.add(it$iv$iv);
                    }
                    list = (List)destination$iv$iv;
                } else {
                    return null;
                }
            }
            enhancedBounds = list;
            Iterable $this$all$iv = enhancedBounds;
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl2 = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    KotlinTypeMarker it3 = (KotlinTypeMarker)element$iv;
                    boolean bl13 = false;
                    if ($this$_get_boundsNullability__u24lambda_u2413.isNullableType(it3)) continue;
                    bl2 = false;
                    break block22;
                }
                bl2 = true;
            }
        }
        NullabilityQualifier qualifier = bl2 ? NullabilityQualifier.NULLABLE : NullabilityQualifier.NOT_NULL;
        return new NullabilityQualifierWithMigrationStatus(qualifier, enhancedBounds != bounds);
    }

    /*
     * Unable to fully structure code
     */
    @NotNull
    public final Function1<Integer, JavaTypeQualifiers> computeIndexedQualifiers(@NotNull KotlinTypeMarker $this$computeIndexedQualifiers, @NotNull Iterable<? extends KotlinTypeMarker> overrides, @Nullable TypeEnhancementInfo predefined, boolean ignoreDeclarationNullabilityAnnotations) {
        Intrinsics.checkNotNullParameter($this$computeIndexedQualifiers, "<this>");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        indexedThisType = this.toIndexed($this$computeIndexedQualifiers);
        $this$map$iv = overrides;
        $i$f$map = false;
        var9_10 = $this$map$iv;
        destination$iv$iv = (JavaTypeQualifiers[])new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        $i$f$mapTo = false;
        for (T item$iv$iv : $this$mapTo$iv$iv) {
            var14_22 = (KotlinTypeMarker)item$iv$iv;
            var30_25 = destination$iv$iv;
            $i$a$-map-AbstractSignatureParts$computeIndexedQualifiers$indexedFromSupertypes$1 = false;
            var30_25.add(this.toIndexed((KotlinTypeMarker)it));
        }
        indexedFromSupertypes = (List)destination$iv$iv;
        if (this.getForceOnlyHeadTypeConstructor()) ** GOTO lbl-1000
        if (this.isCovariant()) {
            block9: {
                $this$any$iv = overrides;
                $i$f$any = false;
                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                    v0 = false;
                } else {
                    var10_12 = $this$any$iv.iterator();
                    while (var10_12.hasNext()) {
                        it = element$iv = var10_12.next();
                        $i$a$-any-AbstractSignatureParts$computeIndexedQualifiers$onlyHeadTypeConstructor$1 = false;
                        if (!(this.isEqual($this$computeIndexedQualifiers, it) == false)) continue;
                        v0 = true;
                        break block9;
                    }
                    v0 = false;
                }
            }
            ** if (!v0) goto lbl-1000
        }
        ** GOTO lbl-1000
lbl-1000:
        // 2 sources

        {
            v1 = true;
            ** GOTO lbl38
        }
lbl-1000:
        // 2 sources

        {
            v1 = false;
        }
lbl38:
        // 2 sources

        onlyHeadTypeConstructor = v1;
        treeSize = onlyHeadTypeConstructor != false ? 1 : indexedThisType.size();
        var11_16 = new JavaTypeQualifiers[treeSize];
        for (var10_13 = 0; var10_13 < treeSize; ++var10_13) {
            var12_18 = var10_13;
            qualifiers = this.extractQualifiersFromAnnotations(indexedThisType.get(var12_18));
            $i$a$-map-AbstractSignatureParts$computeIndexedQualifiers$indexedFromSupertypes$1 = indexedFromSupertypes;
            var31_41 = var12_18;
            var30_25 = var11_16;
            $i$f$mapNotNull = false;
            var17_28 = $this$mapNotNull$iv;
            destination$iv$iv = new ArrayList<E>();
            $i$f$mapNotNullTo = false;
            $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            $i$f$forEach = false;
            var22_33 = $this$forEach$iv$iv$iv.iterator();
            while (var22_33.hasNext()) {
                element$iv$iv = element$iv$iv$iv = var22_33.next();
                $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1$iv$iv = false;
                it = (List)element$iv$iv;
                $i$a$-mapNotNull-AbstractSignatureParts$computeIndexedQualifiers$computedResult$1$superQualifiers$1 = false;
                v2 = (TypeAndDefaultQualifiers)CollectionsKt.getOrNull(it, var12_18);
                if ((v2 != null && (v2 = v2.getType()) != null ? this.extractQualifiers((KotlinTypeMarker)v2) : null) == null) continue;
                it$iv$iv = it$iv$iv;
                $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv = false;
                destination$iv$iv.add(it$iv$iv);
            }
            superQualifiers = var32_42 = (List)destination$iv$iv;
            var30_25[var31_41] = TypeEnhancementUtilsKt.computeQualifiersForOverride(qualifiers, superQualifiers, var12_18 == 0 && this.isCovariant() != false, var12_18 == 0 && this.getContainerIsVarargParameter() != false, ignoreDeclarationNullabilityAnnotations);
        }
        var33_43 = computedResult = var11_16;
        var34_44 = predefined;
        return new AbstractSignatureParts$$Lambda$1(var34_44, var33_43);
    }

    private final <T> void flattenTree(T $this$flattenTree, List<T> result, Function1<? super T, ? extends Iterable<? extends T>> children2) {
        block1: {
            result.add($this$flattenTree);
            Iterable<T> iterable = children2.invoke($this$flattenTree);
            if (iterable == null) break block1;
            Iterable<T> $this$forEach$iv = iterable;
            boolean $i$f$forEach = false;
            Iterator<T> iterator2 = $this$forEach$iv.iterator();
            while (iterator2.hasNext()) {
                T element$iv;
                T it = element$iv = iterator2.next();
                boolean bl2 = false;
                this.flattenTree(it, result, children2);
            }
        }
    }

    private final <T> List<T> flattenTree(T $this$flattenTree, Function1<? super T, ? extends Iterable<? extends T>> children2) {
        ArrayList arrayList;
        ArrayList it = arrayList = new ArrayList(1);
        boolean bl2 = false;
        this.flattenTree($this$flattenTree, it, children2);
        return arrayList;
    }

    private final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(KotlinTypeMarker $this$extractAndMergeDefaultQualifiers, JavaTypeQualifiersByElementType oldQualifiers) {
        return this.getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers(oldQualifiers, this.getAnnotations($this$extractAndMergeDefaultQualifiers));
    }

    private final List<TypeAndDefaultQualifiers> toIndexed(KotlinTypeMarker $this$toIndexed) {
        TypeSystemContext $this$toIndexed_u24lambda_u2423 = this.getTypeSystem();
        boolean bl2 = false;
        TypeSystemContext typeSystemContext = $this$toIndexed_u24lambda_u2423;
        AbstractSignatureParts abstractSignatureParts = this;
        return this.flattenTree(new TypeAndDefaultQualifiers($this$toIndexed, this.extractAndMergeDefaultQualifiers($this$toIndexed, this.getContainerDefaultTypeQualifiers()), null), new AbstractSignatureParts$$Lambda$2(abstractSignatureParts, typeSystemContext));
    }

    private static final boolean extractQualifiersFromAnnotations$lambda$6(AbstractSignatureParts this$0, TypeAndDefaultQualifiers $this_extractQualifiersFromAnnotations, Object $this$extractNullability) {
        Intrinsics.checkNotNullParameter($this$extractNullability, "$this$extractNullability");
        return this$0.forceWarning($this$extractNullability, $this_extractQualifiersFromAnnotations.getType());
    }

    private static final JavaTypeQualifiers computeIndexedQualifiers$lambda$18(TypeEnhancementInfo $predefined, JavaTypeQualifiers[] $computedResult, int index) {
        Object object = $predefined;
        if (object == null || (object = ((TypeEnhancementInfo)object).getMap()) == null || (object = (JavaTypeQualifiers)object.get(index)) == null) {
            JavaTypeQualifiers[] javaTypeQualifiersArray = $computedResult;
            boolean bl2 = 0 <= index ? index < javaTypeQualifiersArray.length : false;
            if (bl2) {
                object = javaTypeQualifiersArray[index];
            } else {
                int it = index;
                boolean bl3 = false;
                object = JavaTypeQualifiers.Companion.getNONE();
            }
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    private static final Iterable toIndexed$lambda$23$lambda$22(AbstractSignatureParts this$0, TypeSystemContext $this_with, TypeAndDefaultQualifiers it) {
        List list;
        List<TypeParameterMarker> list2;
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.getSkipRawTypeArguments()) {
            KotlinTypeMarker kotlinTypeMarker = it.getType();
            boolean bl2 = kotlinTypeMarker != null ? $this_with.isRawType(kotlinTypeMarker) : false;
            if (bl2) {
                return null;
            }
        }
        if ((list2 = it.getType()) != null && (list2 = $this_with.typeConstructor((KotlinTypeMarker)((Object)list2))) != null && (list2 = $this_with.getParameters((TypeConstructorMarker)((Object)list2))) != null) {
            void $this$zip$iv;
            Iterable iterable = list2;
            Iterable other$iv = $this_with.getArguments(it.getType());
            boolean $i$f$zip = false;
            Iterator first$iv = $this$zip$iv.iterator();
            Iterator second$iv = other$iv.iterator();
            ArrayList<TypeAndDefaultQualifiers> list$iv = new ArrayList<TypeAndDefaultQualifiers>(Math.min(CollectionsKt.collectionSizeOrDefault($this$zip$iv, 10), CollectionsKt.collectionSizeOrDefault(other$iv, 10)));
            while (first$iv.hasNext() && second$iv.hasNext()) {
                void parameter;
                void arg;
                TypeArgumentMarker typeArgumentMarker = (TypeArgumentMarker)second$iv.next();
                TypeParameterMarker typeParameterMarker = (TypeParameterMarker)first$iv.next();
                ArrayList<TypeAndDefaultQualifiers> arrayList = list$iv;
                boolean bl3 = false;
                KotlinTypeMarker type = $this_with.getType((TypeArgumentMarker)arg);
                arrayList.add(type == null ? new TypeAndDefaultQualifiers(null, it.getDefaultQualifiers(), (TypeParameterMarker)parameter) : new TypeAndDefaultQualifiers(type, this$0.extractAndMergeDefaultQualifiers(type, it.getDefaultQualifiers()), (TypeParameterMarker)parameter));
            }
            list = list$iv;
        } else {
            list = null;
        }
        return list;
    }

    static /* synthetic */ boolean accessor$AbstractSignatureParts$lambda0(AbstractSignatureParts abstractSignatureParts, TypeAndDefaultQualifiers typeAndDefaultQualifiers, Object object) {
        return AbstractSignatureParts.extractQualifiersFromAnnotations$lambda$6(abstractSignatureParts, typeAndDefaultQualifiers, object);
    }

    static /* synthetic */ JavaTypeQualifiers accessor$AbstractSignatureParts$lambda1(TypeEnhancementInfo typeEnhancementInfo, JavaTypeQualifiers[] javaTypeQualifiersArray, int n2) {
        return AbstractSignatureParts.computeIndexedQualifiers$lambda$18(typeEnhancementInfo, javaTypeQualifiersArray, n2);
    }

    static /* synthetic */ Iterable accessor$AbstractSignatureParts$lambda2(AbstractSignatureParts abstractSignatureParts, TypeSystemContext typeSystemContext, TypeAndDefaultQualifiers typeAndDefaultQualifiers) {
        return AbstractSignatureParts.toIndexed$lambda$23$lambda$22(abstractSignatureParts, typeSystemContext, typeAndDefaultQualifiers);
    }

    private static final class TypeAndDefaultQualifiers {
        @Nullable
        private final KotlinTypeMarker type;
        @Nullable
        private final JavaTypeQualifiersByElementType defaultQualifiers;
        @Nullable
        private final TypeParameterMarker typeParameterForArgument;

        public TypeAndDefaultQualifiers(@Nullable KotlinTypeMarker type, @Nullable JavaTypeQualifiersByElementType defaultQualifiers, @Nullable TypeParameterMarker typeParameterForArgument) {
            this.type = type;
            this.defaultQualifiers = defaultQualifiers;
            this.typeParameterForArgument = typeParameterForArgument;
        }

        @Nullable
        public final KotlinTypeMarker getType() {
            return this.type;
        }

        @Nullable
        public final JavaTypeQualifiersByElementType getDefaultQualifiers() {
            return this.defaultQualifiers;
        }

        @Nullable
        public final TypeParameterMarker getTypeParameterForArgument() {
            return this.typeParameterForArgument;
        }
    }
}

