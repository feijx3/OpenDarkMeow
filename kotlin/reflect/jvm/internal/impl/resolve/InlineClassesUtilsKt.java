/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\ninlineClassesUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 inlineClassesUtils.kt\norg/jetbrains/kotlin/resolve/InlineClassesUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n1563#2:91\n1634#2,3:92\n1563#2:96\n1634#2,3:97\n1761#2,3:100\n1#3:95\n*S KotlinDebug\n*F\n+ 1 inlineClassesUtils.kt\norg/jetbrains/kotlin/resolve/InlineClassesUtilsKt\n*L\n40#1:91\n40#1:92,3\n56#1:96\n56#1:97,3\n67#1:100,3\n*E\n"})
public final class InlineClassesUtilsKt {
    @NotNull
    private static final FqName JVM_INLINE_ANNOTATION_FQ_NAME = new FqName("kotlin.jvm.JvmInline");
    @NotNull
    private static final ClassId JVM_INLINE_ANNOTATION_CLASS_ID = ClassId.Companion.topLevel(JVM_INLINE_ANNOTATION_FQ_NAME);
    @NotNull
    private static final FqName JVM_NAME_ANNOTATION_FQ_NAME = new FqName("kotlin.jvm.JvmName");

    public static final boolean isInlineClass(@NotNull DeclarationDescriptor $this$isInlineClass) {
        Intrinsics.checkNotNullParameter($this$isInlineClass, "<this>");
        return $this$isInlineClass instanceof ClassDescriptor && ((ClassDescriptor)$this$isInlineClass).getValueClassRepresentation() instanceof InlineClassRepresentation;
    }

    public static final boolean isMultiFieldValueClass(@NotNull DeclarationDescriptor $this$isMultiFieldValueClass) {
        Intrinsics.checkNotNullParameter($this$isMultiFieldValueClass, "<this>");
        return $this$isMultiFieldValueClass instanceof ClassDescriptor && ((ClassDescriptor)$this$isMultiFieldValueClass).getValueClassRepresentation() instanceof MultiFieldValueClassRepresentation;
    }

    public static final boolean isValueClass(@NotNull DeclarationDescriptor $this$isValueClass) {
        Intrinsics.checkNotNullParameter($this$isValueClass, "<this>");
        return InlineClassesUtilsKt.isInlineClass($this$isValueClass) || InlineClassesUtilsKt.isMultiFieldValueClass($this$isValueClass);
    }

    @Nullable
    public static final KotlinType unsubstitutedUnderlyingType(@NotNull KotlinType $this$unsubstitutedUnderlyingType) {
        Intrinsics.checkNotNullParameter($this$unsubstitutedUnderlyingType, "<this>");
        ClassifierDescriptor classifierDescriptor = $this$unsubstitutedUnderlyingType.getConstructor().getDeclarationDescriptor();
        Object object = classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
        return object != null && (object = DescriptorUtilsKt.getInlineClassRepresentation((ClassDescriptor)object)) != null ? (SimpleType)((InlineClassRepresentation)object).getUnderlyingType() : null;
    }

    public static final boolean isInlineClassType(@NotNull KotlinType $this$isInlineClassType) {
        Intrinsics.checkNotNullParameter($this$isInlineClassType, "<this>");
        ClassifierDescriptor classifierDescriptor = $this$isInlineClassType.getConstructor().getDeclarationDescriptor();
        return classifierDescriptor != null ? InlineClassesUtilsKt.isInlineClass(classifierDescriptor) : false;
    }

    public static final boolean isValueClassType(@NotNull KotlinType $this$isValueClassType) {
        Intrinsics.checkNotNullParameter($this$isValueClassType, "<this>");
        ClassifierDescriptor classifierDescriptor = $this$isValueClassType.getConstructor().getDeclarationDescriptor();
        return classifierDescriptor != null ? InlineClassesUtilsKt.isValueClass(classifierDescriptor) : false;
    }

    public static final boolean needsMfvcFlattening(@NotNull KotlinType $this$needsMfvcFlattening) {
        boolean bl2;
        Intrinsics.checkNotNullParameter($this$needsMfvcFlattening, "<this>");
        ClassifierDescriptor classifierDescriptor = $this$needsMfvcFlattening.getConstructor().getDeclarationDescriptor();
        if (classifierDescriptor != null) {
            ClassifierDescriptor $this$needsMfvcFlattening_u24lambda_u241 = classifierDescriptor;
            boolean bl3 = false;
            bl2 = InlineClassesUtilsKt.isMultiFieldValueClass($this$needsMfvcFlattening_u24lambda_u241) && !SimpleClassicTypeSystemContext.INSTANCE.isNullableType($this$needsMfvcFlattening);
        } else {
            bl2 = false;
        }
        return bl2;
    }

    @Nullable
    public static final KotlinType substitutedUnderlyingType(@NotNull KotlinType $this$substitutedUnderlyingType) {
        KotlinType kotlinType;
        Intrinsics.checkNotNullParameter($this$substitutedUnderlyingType, "<this>");
        KotlinType kotlinType2 = InlineClassesUtilsKt.unsubstitutedUnderlyingType($this$substitutedUnderlyingType);
        if (kotlinType2 != null) {
            KotlinType it = kotlinType2;
            boolean bl2 = false;
            kotlinType = TypeSubstitutor.create($this$substitutedUnderlyingType).substitute(it, Variance.INVARIANT);
        } else {
            kotlinType = null;
        }
        return kotlinType;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean isGetterOfUnderlyingPropertyOfValueClass(@NotNull CallableDescriptor $this$isGetterOfUnderlyingPropertyOfValueClass) {
        Intrinsics.checkNotNullParameter($this$isGetterOfUnderlyingPropertyOfValueClass, "<this>");
        if (!($this$isGetterOfUnderlyingPropertyOfValueClass instanceof PropertyGetterDescriptor)) return false;
        PropertyDescriptor propertyDescriptor = ((PropertyGetterDescriptor)$this$isGetterOfUnderlyingPropertyOfValueClass).getCorrespondingProperty();
        Intrinsics.checkNotNullExpressionValue(propertyDescriptor, "getCorrespondingProperty(...)");
        if (!InlineClassesUtilsKt.isUnderlyingPropertyOfValueClass(propertyDescriptor)) return false;
        return true;
    }

    public static final boolean isUnderlyingPropertyOfInlineClass(@NotNull VariableDescriptor $this$isUnderlyingPropertyOfInlineClass) {
        DeclarationDescriptor declarationDescriptor;
        Object object;
        Intrinsics.checkNotNullParameter($this$isUnderlyingPropertyOfInlineClass, "<this>");
        return $this$isUnderlyingPropertyOfInlineClass.getExtensionReceiverParameter() == null && Intrinsics.areEqual((object = (declarationDescriptor = $this$isUnderlyingPropertyOfInlineClass.getContainingDeclaration()) instanceof ClassDescriptor ? (ClassDescriptor)declarationDescriptor : null) != null && (object = DescriptorUtilsKt.getInlineClassRepresentation((ClassDescriptor)object)) != null ? ((InlineClassRepresentation)object).getUnderlyingPropertyName() : null, $this$isUnderlyingPropertyOfInlineClass.getName());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean isUnderlyingPropertyOfValueClass(@NotNull VariableDescriptor $this$isUnderlyingPropertyOfValueClass) {
        Intrinsics.checkNotNullParameter($this$isUnderlyingPropertyOfValueClass, "<this>");
        if ($this$isUnderlyingPropertyOfValueClass.getExtensionReceiverParameter() != null) return false;
        DeclarationDescriptor declarationDescriptor = $this$isUnderlyingPropertyOfValueClass.getContainingDeclaration();
        if (!(declarationDescriptor instanceof ClassDescriptor)) return false;
        ClassDescriptor classDescriptor = (ClassDescriptor)declarationDescriptor;
        Object object = classDescriptor;
        if (classDescriptor == null) return false;
        ValueClassRepresentation<SimpleType> valueClassRepresentation = object.getValueClassRepresentation();
        object = valueClassRepresentation;
        if (valueClassRepresentation == null) return false;
        Name name = $this$isUnderlyingPropertyOfValueClass.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (!((ValueClassRepresentation)object).containsPropertyWithName(name)) return false;
        return true;
    }
}

