/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiersKt;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nAbstractAnnotationTypeQualifierResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractAnnotationTypeQualifierResolver.kt\norg/jetbrains/kotlin/load/java/AbstractAnnotationTypeQualifierResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,234:1\n1#2:235\n1#2:241\n1#2:246\n1#2:268\n1761#3,3:236\n295#3,2:242\n1625#3:244\n1869#3:245\n1870#3:247\n1626#3:248\n1761#3,3:249\n1803#3,3:252\n1803#3,3:255\n1617#3,9:258\n1869#3:267\n1870#3:269\n1626#3:270\n72#4,2:239\n382#5,7:271\n*S KotlinDebug\n*F\n+ 1 AbstractAnnotationTypeQualifierResolver.kt\norg/jetbrains/kotlin/load/java/AbstractAnnotationTypeQualifierResolver\n*L\n42#1:241\n83#1:246\n164#1:268\n30#1:236,3\n81#1:242,2\n83#1:244\n83#1:245\n83#1:247\n83#1:248\n90#1:249,3\n126#1:252,3\n138#1:255,3\n164#1:258,9\n164#1:267\n164#1:269\n164#1:270\n42#1:239,2\n229#1:271,7\n*E\n"})
public abstract class AbstractAnnotationTypeQualifierResolver<TAnnotation> {
    @NotNull
    private static final Companion Companion;
    @NotNull
    private final JavaTypeEnhancementState javaTypeEnhancementState;
    @NotNull
    private final ConcurrentHashMap<Object, TAnnotation> resolvedNicknames;
    @NotNull
    private static final Map<String, AnnotationQualifierApplicabilityType> JAVA_APPLICABILITY_TYPES;

    public AbstractAnnotationTypeQualifierResolver(@NotNull JavaTypeEnhancementState javaTypeEnhancementState) {
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.javaTypeEnhancementState = javaTypeEnhancementState;
        this.resolvedNicknames = new ConcurrentHashMap();
    }

    @NotNull
    protected abstract Iterable<TAnnotation> getMetaAnnotations(@NotNull TAnnotation var1);

    @NotNull
    protected abstract Object getKey(@NotNull TAnnotation var1);

    @Nullable
    protected abstract FqName getFqName(@NotNull TAnnotation var1);

    @NotNull
    protected abstract Iterable<String> enumArguments(@NotNull TAnnotation var1, boolean var2);

    private final TAnnotation findAnnotation(TAnnotation $this$findAnnotation, FqName fqName) {
        TAnnotation TAnnotation;
        block1: {
            Iterable<TAnnotation> iterable = this.getMetaAnnotations($this$findAnnotation);
            Iterator<TAnnotation> iterator2 = iterable.iterator();
            while (iterator2.hasNext()) {
                TAnnotation TAnnotation2;
                TAnnotation it = TAnnotation2 = iterator2.next();
                boolean bl2 = false;
                if (!Intrinsics.areEqual(this.getFqName(it), fqName)) continue;
                TAnnotation = TAnnotation2;
                break block1;
            }
            TAnnotation = null;
        }
        return TAnnotation;
    }

    private final boolean hasAnnotation(TAnnotation $this$hasAnnotation, FqName fqName) {
        boolean bl2;
        block3: {
            Iterable<TAnnotation> $this$any$iv = this.getMetaAnnotations($this$hasAnnotation);
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                Iterator<TAnnotation> iterator2 = $this$any$iv.iterator();
                while (iterator2.hasNext()) {
                    TAnnotation element$iv;
                    TAnnotation it = element$iv = iterator2.next();
                    boolean bl3 = false;
                    if (!Intrinsics.areEqual(this.getFqName(it), fqName)) continue;
                    bl2 = true;
                    break block3;
                }
                bl2 = false;
            }
        }
        return bl2;
    }

    public abstract boolean isK2();

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final TAnnotation resolveTypeQualifierAnnotation(@NotNull TAnnotation annotation) {
        void $this$getOrPut$iv;
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        if (this.javaTypeEnhancementState.getJsr305().isDisabled()) {
            return null;
        }
        if (CollectionsKt.contains((Iterable)JvmAnnotationNamesKt.getBUILT_IN_TYPE_QUALIFIER_ANNOTATIONS(), this.getFqName(annotation)) || this.hasAnnotation(annotation, JvmAnnotationNamesKt.getJAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME())) {
            return annotation;
        }
        if (!this.hasAnnotation(annotation, JvmAnnotationNamesKt.getJAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME())) {
            return null;
        }
        ConcurrentMap concurrentMap = this.resolvedNicknames;
        Object key$iv = this.getKey(annotation);
        boolean $i$f$getOrPut = false;
        Object v2 = $this$getOrPut$iv.get(key$iv);
        if (v2 == null) {
            Object v3;
            block7: {
                boolean bl2 = false;
                for (TAnnotation p0 : this.getMetaAnnotations(annotation)) {
                    boolean bl3 = false;
                    TAnnotation TAnnotation = this.resolveTypeQualifierAnnotation(p0);
                    if (TAnnotation == null) continue;
                    v3 = TAnnotation;
                    break block7;
                }
                v3 = null;
            }
            if (v3 == null) {
                return null;
            }
            Object default$iv = v3;
            boolean bl4 = false;
            v2 = $this$getOrPut$iv.putIfAbsent(key$iv, default$iv);
            if (v2 == null) {
                v2 = default$iv;
            }
        }
        return (TAnnotation)v2;
    }

    private final JavaDefaultQualifiers resolveQualifierBuiltInDefaultAnnotation(TAnnotation annotation) {
        JavaDefaultQualifiers javaDefaultQualifiers;
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations()) {
            return null;
        }
        JavaDefaultQualifiers javaDefaultQualifiers2 = JavaDefaultQualifiersKt.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(this.getFqName(annotation));
        if (javaDefaultQualifiers2 != null) {
            ReportLevel reportLevel;
            JavaDefaultQualifiers qualifierForDefaultingAnnotation = javaDefaultQualifiers2;
            boolean bl2 = false;
            ReportLevel it = reportLevel = this.resolveDefaultAnnotationState(annotation);
            boolean bl3 = false;
            ReportLevel reportLevel2 = it != ReportLevel.IGNORE ? reportLevel : null;
            if (reportLevel2 == null) {
                return null;
            }
            ReportLevel state = reportLevel2;
            javaDefaultQualifiers = JavaDefaultQualifiers.copy$default(qualifierForDefaultingAnnotation, NullabilityQualifierWithMigrationStatus.copy$default(qualifierForDefaultingAnnotation.getNullabilityQualifier(), null, state.isWarning(), 1, null), null, false, 6, null);
        } else {
            javaDefaultQualifiers = null;
        }
        return javaDefaultQualifiers;
    }

    private final ReportLevel resolveDefaultAnnotationState(TAnnotation annotation) {
        FqName annotationFqname = this.getFqName(annotation);
        if (annotationFqname != null && JavaDefaultQualifiersKt.getJSPECIFY_DEFAULT_ANNOTATIONS().containsKey(annotationFqname)) {
            return this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(annotationFqname);
        }
        return this.resolveJsr305AnnotationState(annotation);
    }

    private final Set<AnnotationQualifierApplicabilityType> allIfTypeUse(Set<? extends AnnotationQualifierApplicabilityType> $this$allIfTypeUse) {
        return $this$allIfTypeUse.contains((Object)AnnotationQualifierApplicabilityType.TYPE_USE) ? SetsKt.plus(SetsKt.minus(ArraysKt.toSet(AnnotationQualifierApplicabilityType.values()), AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS), (Iterable)$this$allIfTypeUse) : $this$allIfTypeUse;
    }

    /*
     * WARNING - void declaration
     */
    private final Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> resolveTypeQualifierDefaultAnnotation(TAnnotation annotation) {
        void destination$iv;
        void $this$mapNotNullTo$iv;
        Object a2;
        Iterable<Object> $this$firstOrNull$iv;
        TAnnotation typeQualifierDefault;
        block5: {
            if (this.javaTypeEnhancementState.getJsr305().isDisabled()) {
                return null;
            }
            TAnnotation TAnnotation = this.findAnnotation(annotation, JvmAnnotationNamesKt.getJAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME());
            if (TAnnotation == null) {
                return null;
            }
            typeQualifierDefault = TAnnotation;
            $this$firstOrNull$iv = this.getMetaAnnotations(annotation);
            boolean $i$f$firstOrNull = false;
            Iterator<TAnnotation> iterator2 = $this$firstOrNull$iv.iterator();
            while (iterator2.hasNext()) {
                TAnnotation element$iv;
                TAnnotation it = element$iv = iterator2.next();
                boolean bl2 = false;
                if (!(this.resolveTypeQualifierAnnotation(it) != null)) continue;
                a2 = element$iv;
                break block5;
            }
            a2 = null;
        }
        if (a2 == null) {
            return null;
        }
        Object typeQualifier = a2;
        $this$firstOrNull$iv = this.enumArguments(typeQualifierDefault, true);
        Collection $i$f$firstOrNull = new LinkedHashSet();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv = $this$mapNotNullTo$iv;
        boolean $i$f$forEach = false;
        Iterator iterator3 = $this$forEach$iv$iv.iterator();
        while (iterator3.hasNext()) {
            AnnotationQualifierApplicabilityType it$iv;
            Object element$iv$iv;
            Object element$iv = element$iv$iv = iterator3.next();
            boolean bl3 = false;
            String it = (String)element$iv;
            boolean bl4 = false;
            if (JAVA_APPLICABILITY_TYPES.get(it) == null) continue;
            boolean bl5 = false;
            destination$iv.add(it$iv);
        }
        Set applicability = (Set)destination$iv;
        return new Pair<Object, Set<AnnotationQualifierApplicabilityType>>(typeQualifier, this.allIfTypeUse(applicability));
    }

    public final boolean isTypeUseAnnotation(@NotNull TAnnotation annotation) {
        boolean bl2;
        block4: {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            TAnnotation TAnnotation = this.findAnnotation(annotation, StandardNames.FqNames.target);
            if (TAnnotation == null) {
                return false;
            }
            TAnnotation target = TAnnotation;
            Iterable<String> $this$any$iv = this.enumArguments(target, false);
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                Iterator<String> iterator2 = $this$any$iv.iterator();
                while (iterator2.hasNext()) {
                    String element$iv;
                    String it = element$iv = iterator2.next();
                    boolean bl3 = false;
                    if (!Intrinsics.areEqual(it, "TYPE")) continue;
                    bl2 = true;
                    break block4;
                }
                bl2 = false;
            }
        }
        return bl2;
    }

    private final ReportLevel resolveJsr305AnnotationState(TAnnotation annotation) {
        ReportLevel reportLevel = this.resolveJsr305CustomState(annotation);
        if (reportLevel != null) {
            ReportLevel it = reportLevel;
            boolean bl2 = false;
            return it;
        }
        return this.javaTypeEnhancementState.getJsr305().getGlobalLevel();
    }

    private final ReportLevel resolveJsr305CustomState(TAnnotation annotation) {
        ReportLevel reportLevel;
        block15: {
            ReportLevel reportLevel2 = this.javaTypeEnhancementState.getJsr305().getUserDefinedLevelForSpecificAnnotation().get(this.getFqName(annotation));
            if (reportLevel2 != null) {
                ReportLevel it = reportLevel2;
                boolean bl2 = false;
                return it;
            }
            Object object = this.findAnnotation(annotation, JvmAnnotationNamesKt.getUNDER_MIGRATION_ANNOTATION_FQ_NAME());
            if (object == null || (object = this.enumArguments(object, false)) == null || (object = (String)CollectionsKt.firstOrNull(object)) == null) {
                return null;
            }
            TAnnotation enumValue = object;
            reportLevel = this.javaTypeEnhancementState.getJsr305().getMigrationLevel();
            if (reportLevel != null) break block15;
            switch (enumValue) {
                case "STRICT": {
                    reportLevel = ReportLevel.STRICT;
                    break;
                }
                case "WARN": {
                    reportLevel = ReportLevel.WARN;
                    break;
                }
                case "IGNORE": {
                    reportLevel = ReportLevel.IGNORE;
                    break;
                }
                default: {
                    reportLevel = null;
                }
            }
        }
        return reportLevel;
    }

    private final NullabilityQualifierWithMigrationStatus extractNullability(TAnnotation annotation, Function1<? super TAnnotation, Boolean> forceWarning) {
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = this.knownNullability(annotation, forceWarning.invoke(annotation));
        if (nullabilityQualifierWithMigrationStatus != null) {
            NullabilityQualifierWithMigrationStatus it = nullabilityQualifierWithMigrationStatus;
            boolean bl2 = false;
            return it;
        }
        TAnnotation TAnnotation = this.resolveTypeQualifierAnnotation(annotation);
        if (TAnnotation == null) {
            return null;
        }
        TAnnotation typeQualifierAnnotation = TAnnotation;
        ReportLevel jsr305State = this.resolveJsr305AnnotationState(annotation);
        if (jsr305State.isIgnore()) {
            return null;
        }
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2 = this.knownNullability(typeQualifierAnnotation, forceWarning.invoke(typeQualifierAnnotation));
        return nullabilityQualifierWithMigrationStatus2 != null ? NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatus2, null, jsr305State.isWarning(), 1, null) : null;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final NullabilityQualifierWithMigrationStatus extractNullability(@NotNull Iterable<? extends TAnnotation> annotations, @NotNull Function1<? super TAnnotation, Boolean> forceWarning) {
        void $this$fold$iv;
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(forceWarning, "forceWarning");
        Iterable<? extends TAnnotation> iterable = annotations;
        NullabilityQualifierWithMigrationStatus initial$iv = null;
        boolean $i$f$fold = false;
        NullabilityQualifierWithMigrationStatus accumulator$iv = initial$iv;
        Iterator iterator2 = $this$fold$iv.iterator();
        while (iterator2.hasNext()) {
            NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus;
            void annotation;
            Object element$iv;
            Object t2 = element$iv = iterator2.next();
            NullabilityQualifierWithMigrationStatus found = accumulator$iv;
            boolean bl2 = false;
            NullabilityQualifierWithMigrationStatus extracted = this.extractNullability(annotation, forceWarning);
            if (found == null) {
                nullabilityQualifierWithMigrationStatus = extracted;
            } else if (extracted == null || Intrinsics.areEqual(extracted, found)) {
                nullabilityQualifierWithMigrationStatus = found;
            } else if (extracted.isForWarningOnly() && !found.isForWarningOnly()) {
                nullabilityQualifierWithMigrationStatus = found;
            } else if (!extracted.isForWarningOnly() && found.isForWarningOnly()) {
                nullabilityQualifierWithMigrationStatus = extracted;
            } else {
                return null;
            }
            accumulator$iv = nullabilityQualifierWithMigrationStatus;
        }
        return accumulator$iv;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Nullable
    public final MutabilityQualifier extractMutability(@NotNull Iterable<? extends TAnnotation> annotations) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        var2_2 = annotations;
        initial$iv = null;
        $i$f$fold = false;
        accumulator$iv = initial$iv;
        var6_6 = $this$fold$iv.iterator();
        while (var6_6.hasNext()) {
            block4: {
                var8_8 = element$iv = var6_6.next();
                found = accumulator$iv;
                $i$a$-fold-AbstractAnnotationTypeQualifierResolver$extractMutability$1 = false;
                var11_11 /* !! */  = this.getFqName(annotation);
                if (!CollectionsKt.contains((Iterable)JvmAnnotationNamesKt.getREAD_ONLY_ANNOTATIONS(), var11_11 /* !! */ )) break block4;
                v0 = MutabilityQualifier.READ_ONLY;
                ** GOTO lbl20
            }
            if (!CollectionsKt.contains((Iterable)JvmAnnotationNamesKt.getMUTABLE_ANNOTATIONS(), var11_11 /* !! */ )) {
                v1 /* !! */  = found;
            } else {
                v0 = MutabilityQualifier.MUTABLE;
lbl20:
                // 2 sources

                it /* !! */  = var11_11 /* !! */  = v0;
                $i$a$-also-AbstractAnnotationTypeQualifierResolver$extractMutability$1$1 = false;
                if (found != null && found != it /* !! */ ) {
                    return null;
                }
                v1 /* !! */  = var11_11 /* !! */ ;
            }
            accumulator$iv = v1 /* !! */ ;
        }
        return accumulator$iv;
    }

    private final JavaDefaultQualifiers extractDefaultQualifiers(TAnnotation annotation) {
        ReportLevel jsr305State;
        Object object = this.resolveQualifierBuiltInDefaultAnnotation(annotation);
        if (object != null) {
            JavaDefaultQualifiers it = object;
            boolean bl2 = false;
            return it;
        }
        Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> pair = this.resolveTypeQualifierDefaultAnnotation(annotation);
        if (pair == null) {
            return null;
        }
        object = pair;
        Object typeQualifier = ((Pair)object).component1();
        Set applicability = (Set)((Pair)object).component2();
        ReportLevel reportLevel = this.resolveJsr305CustomState(annotation);
        if (reportLevel == null) {
            reportLevel = this.resolveJsr305AnnotationState(typeQualifier);
        }
        if ((jsr305State = reportLevel).isIgnore()) {
            return null;
        }
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = this.extractNullability(typeQualifier, AbstractAnnotationTypeQualifierResolver$$Lambda$1.INSTANCE);
        if (nullabilityQualifierWithMigrationStatus == null) {
            return null;
        }
        NullabilityQualifierWithMigrationStatus nullabilityQualifier = nullabilityQualifierWithMigrationStatus;
        return new JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifier, null, jsr305State.isWarning(), 1, null), applicability, false, 4, null);
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(@Nullable JavaTypeQualifiersByElementType oldQualifiers, @NotNull Iterable<? extends TAnnotation> annotations) {
        EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> enumMap;
        void $this$mapNotNullTo$iv$iv;
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations()) {
            return oldQualifiers;
        }
        Iterable<? extends TAnnotation> $this$mapNotNull$iv = annotations;
        boolean $i$f$mapNotNull = false;
        Iterable<? extends TAnnotation> iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean bl2 = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            JavaDefaultQualifiers it$iv$iv;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl22 = false;
            Object it = element$iv$iv;
            boolean bl3 = false;
            if (this.extractDefaultQualifiers(it) == null) continue;
            boolean bl4 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        List extractedQualifiers = (List)destination$iv$iv;
        if (extractedQualifiers.isEmpty()) {
            return oldQualifiers;
        }
        EnumMap newQualifiers = new EnumMap(AnnotationQualifierApplicabilityType.class);
        for (JavaDefaultQualifiers extractedQualifier : extractedQualifiers) {
            for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : extractedQualifier.getQualifierApplicabilityTypes()) {
                JavaDefaultQualifiers preexistingQualifier;
                if (!((Map)newQualifiers).containsKey((Object)annotationQualifierApplicabilityType) || !this.isK2()) {
                    ((Map)newQualifiers).put(annotationQualifierApplicabilityType, extractedQualifier);
                    continue;
                }
                if ((JavaDefaultQualifiers)newQualifiers.get((Object)annotationQualifierApplicabilityType) == null) continue;
                NullabilityQualifierWithMigrationStatus preexistingNullability = preexistingQualifier.getNullabilityQualifier();
                NullabilityQualifierWithMigrationStatus extractedNullability = extractedQualifier.getNullabilityQualifier();
                ((Map)newQualifiers).put(annotationQualifierApplicabilityType, Intrinsics.areEqual(extractedNullability, preexistingNullability) ? preexistingQualifier : (extractedNullability.isForWarningOnly() && !preexistingNullability.isForWarningOnly() ? preexistingQualifier : (!extractedNullability.isForWarningOnly() && preexistingNullability.isForWarningOnly() ? extractedQualifier : null)));
            }
        }
        Object object = oldQualifiers;
        if (object != null && (object = ((JavaTypeQualifiersByElementType)object).getDefaultQualifiers()) != null) {
            Object p0 = object;
            boolean bl5 = false;
            enumMap = new EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers>((EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers>)p0);
        } else {
            enumMap = new EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers>(AnnotationQualifierApplicabilityType.class);
        }
        EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> defaultQualifiersByType = enumMap;
        boolean wasUpdate = false;
        for (Map.Entry entry : ((Map)newQualifiers).entrySet()) {
            AnnotationQualifierApplicabilityType applicabilityType = (AnnotationQualifierApplicabilityType)((Object)entry.getKey());
            JavaDefaultQualifiers newQualifier = (JavaDefaultQualifiers)entry.getValue();
            if (newQualifier == null) continue;
            ((Map)defaultQualifiersByType).put(applicabilityType, newQualifier);
            wasUpdate = true;
        }
        return !wasUpdate ? oldQualifiers : new JavaTypeQualifiersByElementType(defaultQualifiersByType);
    }

    /*
     * Unable to fully structure code
     */
    private final NullabilityQualifierWithMigrationStatus knownNullability(TAnnotation annotation, boolean forceWarning) {
        block10: {
            block13: {
                block14: {
                    block12: {
                        block11: {
                            block9: {
                                v0 = this.getFqName(annotation);
                                if (v0 == null) {
                                    return null;
                                }
                                fqName = v0;
                                reportLevel = this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(fqName);
                                if (reportLevel.isIgnore()) {
                                    return null;
                                }
                                var6_5 = fqName;
                                if (!JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS().contains(var6_5)) break block9;
                                v1 = NullabilityQualifier.NOT_NULL;
                                break block10;
                            }
                            if (!JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS().contains(var6_5)) break block11;
                            v1 = NullabilityQualifier.NULLABLE;
                            break block10;
                        }
                        if (!JvmAnnotationNamesKt.getFORCE_FLEXIBILITY_ANNOTATIONS().contains(var6_5)) break block12;
                        v1 = NullabilityQualifier.FORCE_FLEXIBILITY;
                        break block10;
                    }
                    if (!Intrinsics.areEqual(var6_5, JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION_FQ_NAME())) break block13;
                    var7_6 = CollectionsKt.firstOrNull(this.enumArguments(annotation, false));
                    if (var7_6 == null) ** GOTO lbl37
                    switch (var7_6.hashCode()) {
                        case 73135176: {
                            if (var7_6.equals("MAYBE")) break;
                            ** break;
                        }
                        case 74175084: {
                            if (var7_6.equals("NEVER")) break;
                            ** break;
                        }
                        case 433141802: {
                            if (!var7_6.equals("UNKNOWN")) {
                                ** break;
                            }
                            break block14;
                        }
                        case 1933739535: {
                            if (!var7_6.equals("ALWAYS")) ** break;
lbl37:
                            // 2 sources

                            v1 = NullabilityQualifier.NOT_NULL;
                            break block10;
                        }
                    }
                    v1 = NullabilityQualifier.NULLABLE;
                    break block10;
                }
                v1 = NullabilityQualifier.FORCE_FLEXIBILITY;
                break block10;
lbl44:
                // 5 sources

                return null;
            }
            return null;
        }
        nullability = v1;
        return new NullabilityQualifierWithMigrationStatus(nullability, reportLevel.isWarning() != false || forceWarning != false);
    }

    private static final boolean extractDefaultQualifiers$lambda$16(Object $this$extractNullability) {
        Intrinsics.checkNotNullParameter($this$extractNullability, "$this$extractNullability");
        return false;
    }

    /*
     * WARNING - void declaration
     */
    static {
        Map map;
        Companion = new Companion(null);
        Map $this$JAVA_APPLICABILITY_TYPES_u24lambda_u2420 = map = (Map)new LinkedHashMap();
        boolean bl2 = false;
        for (AnnotationQualifierApplicabilityType type : AnnotationQualifierApplicabilityType.values()) {
            void $this$getOrPut$iv;
            Map map2 = $this$JAVA_APPLICABILITY_TYPES_u24lambda_u2420;
            String key$iv = type.getJavaTarget();
            boolean $i$f$getOrPut = false;
            Object value$iv = $this$getOrPut$iv.get(key$iv);
            if (value$iv != null) continue;
            boolean bl3 = false;
            AnnotationQualifierApplicabilityType answer$iv = type;
            $this$getOrPut$iv.put(key$iv, answer$iv);
        }
        JAVA_APPLICABILITY_TYPES = map;
    }

    static /* synthetic */ boolean accessor$AbstractAnnotationTypeQualifierResolver$lambda1(Object object) {
        return AbstractAnnotationTypeQualifierResolver.extractDefaultQualifiers$lambda$16(object);
    }

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

