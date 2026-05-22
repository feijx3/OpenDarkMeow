/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancedTypeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPositionKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import org.jetbrains.annotations.NotNull;

public final class TypeEnhancementKt {
    @NotNull
    private static final Annotations ENHANCED_NULLABILITY_ANNOTATIONS;
    @NotNull
    private static final EnhancedTypeAnnotations ENHANCED_MUTABILITY_ANNOTATIONS;

    public static final boolean hasEnhancedNullability(@NotNull KotlinType $this$hasEnhancedNullability) {
        Intrinsics.checkNotNullParameter($this$hasEnhancedNullability, "<this>");
        return TypeEnhancementUtilsKt.hasEnhancedNullability(SimpleClassicTypeSystemContext.INSTANCE, $this$hasEnhancedNullability);
    }

    private static final Annotations compositeAnnotationsOrSingle(List<? extends Annotations> $this$compositeAnnotationsOrSingle) {
        Annotations annotations;
        switch ($this$compositeAnnotationsOrSingle.size()) {
            case 0: {
                throw new IllegalStateException("At least one Annotations object expected".toString());
            }
            case 1: {
                annotations = CollectionsKt.single($this$compositeAnnotationsOrSingle);
                break;
            }
            default: {
                annotations = new CompositeAnnotations(CollectionsKt.toList((Iterable)$this$compositeAnnotationsOrSingle));
            }
        }
        return annotations;
    }

    private static final ClassifierDescriptor enhanceMutability(ClassifierDescriptor $this$enhanceMutability, JavaTypeQualifiers qualifiers, TypeComponentPosition position) {
        JavaToKotlinClassMapper mapper = JavaToKotlinClassMapper.INSTANCE;
        return !TypeComponentPositionKt.shouldEnhance(position) ? null : (!($this$enhanceMutability instanceof ClassDescriptor) ? null : (qualifiers.getMutability() == MutabilityQualifier.READ_ONLY && position == TypeComponentPosition.FLEXIBLE_LOWER && mapper.isMutable((ClassDescriptor)$this$enhanceMutability) ? (ClassifierDescriptor)mapper.convertMutableToReadOnly((ClassDescriptor)$this$enhanceMutability) : (qualifiers.getMutability() == MutabilityQualifier.MUTABLE && position == TypeComponentPosition.FLEXIBLE_UPPER && mapper.isReadOnly((ClassDescriptor)$this$enhanceMutability) ? (ClassifierDescriptor)mapper.convertReadOnlyToMutable((ClassDescriptor)$this$enhanceMutability) : null)));
    }

    private static final Boolean getEnhancedNullability(JavaTypeQualifiers qualifiers, TypeComponentPosition position) {
        Boolean bl2;
        if (!TypeComponentPositionKt.shouldEnhance(position)) {
            return null;
        }
        NullabilityQualifier nullabilityQualifier = qualifiers.getNullability();
        switch (nullabilityQualifier == null ? -1 : WhenMappings.$EnumSwitchMapping$0[nullabilityQualifier.ordinal()]) {
            case 1: {
                bl2 = true;
                break;
            }
            case 2: {
                bl2 = false;
                break;
            }
            default: {
                bl2 = null;
            }
        }
        return bl2;
    }

    @NotNull
    public static final Annotations getENHANCED_NULLABILITY_ANNOTATIONS() {
        return ENHANCED_NULLABILITY_ANNOTATIONS;
    }

    public static final /* synthetic */ ClassifierDescriptor access$enhanceMutability(ClassifierDescriptor $receiver, JavaTypeQualifiers qualifiers, TypeComponentPosition position) {
        return TypeEnhancementKt.enhanceMutability($receiver, qualifiers, position);
    }

    public static final /* synthetic */ Boolean access$getEnhancedNullability(JavaTypeQualifiers qualifiers, TypeComponentPosition position) {
        return TypeEnhancementKt.getEnhancedNullability(qualifiers, position);
    }

    public static final /* synthetic */ Annotations access$compositeAnnotationsOrSingle(List $receiver) {
        return TypeEnhancementKt.compositeAnnotationsOrSingle($receiver);
    }

    public static final /* synthetic */ EnhancedTypeAnnotations access$getENHANCED_MUTABILITY_ANNOTATIONS$p() {
        return ENHANCED_MUTABILITY_ANNOTATIONS;
    }

    static {
        FqName fqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName, "ENHANCED_NULLABILITY_ANNOTATION");
        ENHANCED_NULLABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(fqName);
        FqName fqName2 = JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName2, "ENHANCED_MUTABILITY_ANNOTATION");
        ENHANCED_MUTABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(fqName2);
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[NullabilityQualifier.values().length];
            try {
                nArray[NullabilityQualifier.NULLABLE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[NullabilityQualifier.NOT_NULL.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

