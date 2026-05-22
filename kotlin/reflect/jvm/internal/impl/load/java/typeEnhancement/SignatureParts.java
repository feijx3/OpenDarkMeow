/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameterImpl;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nsignatureEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 signatureEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureParts\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,296:1\n1#2:297\n*E\n"})
final class SignatureParts
extends AbstractSignatureParts<AnnotationDescriptor> {
    @Nullable
    private final Annotated typeContainer;
    private final boolean isCovariant;
    @NotNull
    private final LazyJavaResolverContext containerContext;
    @NotNull
    private final AnnotationQualifierApplicabilityType containerApplicabilityType;
    private final boolean skipRawTypeArguments;

    public SignatureParts(@Nullable Annotated typeContainer, boolean isCovariant, @NotNull LazyJavaResolverContext containerContext, @NotNull AnnotationQualifierApplicabilityType containerApplicabilityType, boolean skipRawTypeArguments) {
        Intrinsics.checkNotNullParameter(containerContext, "containerContext");
        Intrinsics.checkNotNullParameter((Object)containerApplicabilityType, "containerApplicabilityType");
        this.typeContainer = typeContainer;
        this.isCovariant = isCovariant;
        this.containerContext = containerContext;
        this.containerApplicabilityType = containerApplicabilityType;
        this.skipRawTypeArguments = skipRawTypeArguments;
    }

    public /* synthetic */ SignatureParts(Annotated annotated, boolean bl2, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean bl3, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 0x10) != 0) {
            bl3 = false;
        }
        this(annotated, bl2, lazyJavaResolverContext, annotationQualifierApplicabilityType, bl3);
    }

    @Override
    public boolean isCovariant() {
        return this.isCovariant;
    }

    @Override
    @NotNull
    public AnnotationQualifierApplicabilityType getContainerApplicabilityType() {
        return this.containerApplicabilityType;
    }

    @Override
    public boolean getSkipRawTypeArguments() {
        return this.skipRawTypeArguments;
    }

    @NotNull
    public AnnotationTypeQualifierResolver getAnnotationTypeQualifierResolver() {
        return this.containerContext.getComponents().getAnnotationTypeQualifierResolver();
    }

    @Override
    public boolean getEnableImprovementsInStrictMode() {
        return this.containerContext.getComponents().getSettings().getTypeEnhancementImprovementsInStrictMode();
    }

    @Override
    @NotNull
    public Iterable<AnnotationDescriptor> getContainerAnnotations() {
        Object object = this.typeContainer;
        return object != null && (object = object.getAnnotations()) != null ? (Iterable)object : (Iterable)CollectionsKt.emptyList();
    }

    @Override
    @Nullable
    public JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers() {
        return this.containerContext.getDefaultTypeQualifiers();
    }

    @Override
    public boolean getContainerIsVarargParameter() {
        return this.typeContainer instanceof ValueParameterDescriptor && ((ValueParameterDescriptor)this.typeContainer).getVarargElementType() != null;
    }

    @Override
    @NotNull
    public TypeSystemInferenceExtensionContext getTypeSystem() {
        return SimpleClassicTypeSystemContext.INSTANCE;
    }

    @Override
    public boolean forceWarning(@NotNull AnnotationDescriptor $this$forceWarning, @Nullable KotlinTypeMarker unenhancedType) {
        Intrinsics.checkNotNullParameter($this$forceWarning, "<this>");
        return $this$forceWarning instanceof PossiblyExternalAnnotationDescriptor && ((PossiblyExternalAnnotationDescriptor)$this$forceWarning).isIdeExternalAnnotation() || $this$forceWarning instanceof LazyJavaAnnotationDescriptor && !this.getEnableImprovementsInStrictMode() && (((LazyJavaAnnotationDescriptor)$this$forceWarning).isFreshlySupportedTypeUseAnnotation() || this.getContainerApplicabilityType() == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS) || unenhancedType != null && KotlinBuiltIns.isPrimitiveArray((KotlinType)unenhancedType) && this.getAnnotationTypeQualifierResolver().isTypeUseAnnotation($this$forceWarning) && !this.containerContext.getComponents().getSettings().getEnhancePrimitiveArrays();
    }

    @Override
    @NotNull
    public Iterable<AnnotationDescriptor> getAnnotations(@NotNull KotlinTypeMarker $this$annotations) {
        Intrinsics.checkNotNullParameter($this$annotations, "<this>");
        return ((KotlinType)$this$annotations).getAnnotations();
    }

    @Override
    @Nullable
    public KotlinType getEnhancedForWarnings(@NotNull KotlinTypeMarker $this$enhancedForWarnings) {
        Intrinsics.checkNotNullParameter($this$enhancedForWarnings, "<this>");
        return TypeWithEnhancementKt.getEnhancement((KotlinType)$this$enhancedForWarnings);
    }

    @Override
    @Nullable
    public FqNameUnsafe getFqNameUnsafe(@NotNull KotlinTypeMarker $this$fqNameUnsafe) {
        FqNameUnsafe fqNameUnsafe;
        Intrinsics.checkNotNullParameter($this$fqNameUnsafe, "<this>");
        ClassDescriptor classDescriptor = TypeUtils.getClassDescriptor((KotlinType)$this$fqNameUnsafe);
        if (classDescriptor != null) {
            ClassDescriptor it = classDescriptor;
            boolean bl2 = false;
            fqNameUnsafe = DescriptorUtils.getFqName(it);
        } else {
            fqNameUnsafe = null;
        }
        return fqNameUnsafe;
    }

    @Override
    public boolean isNotNullTypeParameterCompat(@NotNull KotlinTypeMarker $this$isNotNullTypeParameterCompat) {
        Intrinsics.checkNotNullParameter($this$isNotNullTypeParameterCompat, "<this>");
        return ((KotlinType)$this$isNotNullTypeParameterCompat).unwrap() instanceof NotNullTypeParameterImpl;
    }

    @Override
    public boolean isEqual(@NotNull KotlinTypeMarker $this$isEqual, @NotNull KotlinTypeMarker other) {
        Intrinsics.checkNotNullParameter($this$isEqual, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return this.containerContext.getComponents().getKotlinTypeChecker().equalTypes((KotlinType)$this$isEqual, (KotlinType)other);
    }

    @Override
    public boolean isArrayOrPrimitiveArray(@NotNull KotlinTypeMarker $this$isArrayOrPrimitiveArray) {
        Intrinsics.checkNotNullParameter($this$isArrayOrPrimitiveArray, "<this>");
        return KotlinBuiltIns.isArrayOrPrimitiveArray((KotlinType)$this$isArrayOrPrimitiveArray);
    }

    @Override
    public boolean isFromJava(@NotNull TypeParameterMarker $this$isFromJava) {
        Intrinsics.checkNotNullParameter($this$isFromJava, "<this>");
        return $this$isFromJava instanceof LazyJavaTypeParameterDescriptor;
    }

    @Override
    @Nullable
    protected NullabilityQualifierWithMigrationStatus getDefaultNullability(@Nullable NullabilityQualifierWithMigrationStatus referencedParameterBoundsNullability, @Nullable JavaDefaultQualifiers defaultTypeQualifiers) {
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = referencedParameterBoundsNullability;
        if (nullabilityQualifierWithMigrationStatus == null || (nullabilityQualifierWithMigrationStatus = NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatus, NullabilityQualifier.NOT_NULL, false, 2, null)) == null) {
            JavaDefaultQualifiers javaDefaultQualifiers = defaultTypeQualifiers;
            nullabilityQualifierWithMigrationStatus = javaDefaultQualifiers != null ? javaDefaultQualifiers.getNullabilityQualifier() : null;
        }
        return nullabilityQualifierWithMigrationStatus;
    }
}

