/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\ntypeEnhancementUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeEnhancementUtils.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/TypeEnhancementUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,73:1\n1#2:74\n1#2:85\n1#2:98\n1#2:111\n1617#3,9:75\n1869#3:84\n1870#3:86\n1626#3:87\n1617#3,9:88\n1869#3:97\n1870#3:99\n1626#3:100\n1617#3,9:101\n1869#3:110\n1870#3:112\n1626#3:113\n1761#3,3:114\n*S KotlinDebug\n*F\n+ 1 typeEnhancementUtils.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/TypeEnhancementUtilsKt\n*L\n43#1:85\n45#1:98\n47#1:111\n43#1:75,9\n43#1:84\n43#1:86\n43#1:87\n45#1:88,9\n45#1:97\n45#1:99\n45#1:100\n47#1:101,9\n47#1:110\n47#1:112\n47#1:113\n58#1:114,3\n*E\n"})
public final class TypeEnhancementUtilsKt {
    private static final <T> T select(Set<? extends T> $this$select, T low, T high, T own, boolean isCovariant) {
        Object object;
        block8: {
            block7: {
                if (isCovariant) {
                    T t2;
                    T supertypeQualifier;
                    Object object2 = $this$select.contains(low) ? low : (supertypeQualifier = $this$select.contains(high) ? high : null);
                    if (Intrinsics.areEqual(supertypeQualifier, low) && Intrinsics.areEqual(own, high)) {
                        t2 = null;
                    } else {
                        t2 = own;
                        if (t2 == null) {
                            t2 = supertypeQualifier;
                        }
                    }
                    return t2;
                }
                object = own;
                if (object == null) break block7;
                T it = object;
                boolean bl2 = false;
                Set set = CollectionsKt.toSet((Iterable)SetsKt.plus($this$select, own));
                object = set;
                if (set != null) break block8;
            }
            object = $this$select;
        }
        Object effectiveSet = object;
        return CollectionsKt.singleOrNull((Iterable)effectiveSet);
    }

    private static final NullabilityQualifier select(Set<? extends NullabilityQualifier> $this$select, NullabilityQualifier own, boolean isCovariant) {
        return own == NullabilityQualifier.FORCE_FLEXIBILITY ? NullabilityQualifier.FORCE_FLEXIBILITY : TypeEnhancementUtilsKt.select($this$select, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, own, isCovariant);
    }

    private static final NullabilityQualifier getNullabilityForErrors(JavaTypeQualifiers $this$nullabilityForErrors) {
        return $this$nullabilityForErrors.isNullabilityQualifierForWarning() ? null : $this$nullabilityForErrors.getNullability();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @NotNull
    public static final JavaTypeQualifiers computeQualifiersForOverride(@NotNull JavaTypeQualifiers $this$computeQualifiersForOverride, @NotNull Collection<JavaTypeQualifiers> superQualifiers, boolean isCovariant, boolean isForVarargParameter, boolean ignoreDeclarationNullabilityAnnotations) {
        block11: {
            Intrinsics.checkNotNullParameter($this$computeQualifiersForOverride, "<this>");
            Intrinsics.checkNotNullParameter(superQualifiers, "superQualifiers");
            $this$mapNotNull$iv = superQualifiers;
            $i$f$mapNotNull = false;
            var8_9 = $this$mapNotNull$iv;
            destination$iv$iv /* !! */  = new ArrayList<E>();
            $i$f$mapNotNullTo = false;
            $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            $i$f$forEach = false;
            for (Object element$iv$iv$iv : $this$forEach$iv$iv$iv) {
                element$iv$iv = element$iv$iv$iv;
                $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1$iv$iv = false;
                it = (JavaTypeQualifiers)element$iv$iv;
                $i$a$-mapNotNull-TypeEnhancementUtilsKt$computeQualifiersForOverride$newNullabilityForErrors$1 = false;
                if (TypeEnhancementUtilsKt.getNullabilityForErrors(it) == null) continue;
                $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv = false;
                destination$iv$iv /* !! */ .add(it$iv$iv);
            }
            newNullabilityForErrors = TypeEnhancementUtilsKt.select(CollectionsKt.toSet((List)destination$iv$iv /* !! */ ), TypeEnhancementUtilsKt.getNullabilityForErrors($this$computeQualifiersForOverride), isCovariant);
            v0 = newNullabilityForErrors;
            if (v0 == null) {
                $this$mapNotNull$iv = superQualifiers;
                $i$f$mapNotNull = false;
                destination$iv$iv /* !! */  = $this$mapNotNull$iv;
                destination$iv$iv = new ArrayList<E>();
                $i$f$mapNotNullTo = false;
                $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                $i$f$forEach = false;
                element$iv$iv$iv = $this$forEach$iv$iv$iv.iterator();
                while (element$iv$iv$iv.hasNext()) {
                    element$iv$iv /* !! */  = element$iv$iv$iv /* !! */  = element$iv$iv$iv.next();
                    $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1$iv$iv = false;
                    it = (JavaTypeQualifiers)element$iv$iv /* !! */ ;
                    $i$a$-mapNotNull-TypeEnhancementUtilsKt$computeQualifiersForOverride$newNullability$1 = false;
                    if (it.getNullability() == null) continue;
                    $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv = false;
                    destination$iv$iv.add(it$iv$iv);
                }
                v0 = TypeEnhancementUtilsKt.select(CollectionsKt.toSet((List)destination$iv$iv), $this$computeQualifiersForOverride.getNullability(), isCovariant);
            }
            newNullability = v0;
            $this$mapNotNull$iv = superQualifiers;
            $i$f$mapNotNull = false;
            destination$iv$iv = $this$mapNotNull$iv;
            destination$iv$iv = new ArrayList<E>();
            $i$f$mapNotNullTo = false;
            $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            $i$f$forEach = false;
            element$iv$iv$iv /* !! */  = $this$forEach$iv$iv$iv.iterator();
            while (element$iv$iv$iv /* !! */ .hasNext()) {
                element$iv$iv = element$iv$iv$iv = element$iv$iv$iv /* !! */ .next();
                $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1$iv$iv = false;
                it = (JavaTypeQualifiers)element$iv$iv;
                $i$a$-mapNotNull-TypeEnhancementUtilsKt$computeQualifiersForOverride$newMutability$1 = false;
                if (it.getMutability() == null) continue;
                $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv = false;
                destination$iv$iv.add(it$iv$iv);
            }
            newMutability = TypeEnhancementUtilsKt.select(CollectionsKt.toSet((List)destination$iv$iv), MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, $this$computeQualifiersForOverride.getMutability(), isCovariant);
            v1 = newNullability;
            if (v1 != null) {
                it = $i$f$mapNotNull = v1;
                $i$a$-takeUnless-TypeEnhancementUtilsKt$computeQualifiersForOverride$realNullability$1 = false;
                v2 = !(ignoreDeclarationNullabilityAnnotations != false || isForVarargParameter != false && it == NullabilityQualifier.NULLABLE) ? $i$f$mapNotNull : null;
            } else {
                v2 = null;
            }
            realNullability = v2;
            v3 = isForWarning = realNullability != null && newNullabilityForErrors == null;
            if (realNullability != NullabilityQualifier.NOT_NULL) ** GOTO lbl-1000
            if (TypeEnhancementUtilsKt.isDefinitelyNotNullAndSameSeverity($this$computeQualifiersForOverride, isForWarning)) ** GOTO lbl-1000
            $this$any$iv = superQualifiers;
            $i$f$any = false;
            if (((Collection)$this$any$iv).isEmpty()) {
                v4 = false;
            } else {
                for (T element$iv : $this$any$iv) {
                    it = (JavaTypeQualifiers)element$iv;
                    $i$a$-any-TypeEnhancementUtilsKt$computeQualifiersForOverride$definitelyNotNull$1 = false;
                    if (!TypeEnhancementUtilsKt.isDefinitelyNotNullAndSameSeverity(it, isForWarning)) continue;
                    v4 = true;
                    break block11;
                }
                v4 = false;
            }
        }
        if (v4) lbl-1000:
        // 2 sources

        {
            v5 = true;
        } else lbl-1000:
        // 2 sources

        {
            v5 = false;
        }
        definitelyNotNull = v5;
        return new JavaTypeQualifiers(realNullability, newMutability, definitelyNotNull, isForWarning);
    }

    private static final boolean isDefinitelyNotNullAndSameSeverity(JavaTypeQualifiers $this$isDefinitelyNotNullAndSameSeverity, boolean isForWarning) {
        return $this$isDefinitelyNotNullAndSameSeverity.isNullabilityQualifierForWarning() == isForWarning && $this$isDefinitelyNotNullAndSameSeverity.getDefinitelyNotNull();
    }

    public static final boolean hasEnhancedNullability(@NotNull TypeSystemCommonBackendContext $this$hasEnhancedNullability, @NotNull KotlinTypeMarker type) {
        Intrinsics.checkNotNullParameter($this$hasEnhancedNullability, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        FqName fqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName, "ENHANCED_NULLABILITY_ANNOTATION");
        return $this$hasEnhancedNullability.hasAnnotation(type, fqName);
    }
}

