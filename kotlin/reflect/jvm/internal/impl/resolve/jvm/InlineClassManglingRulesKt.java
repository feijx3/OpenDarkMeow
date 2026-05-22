/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\ninlineClassManglingRules.kt\nKotlin\n*S Kotlin\n*F\n+ 1 inlineClassManglingRules.kt\norg/jetbrains/kotlin/resolve/jvm/InlineClassManglingRulesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,53:1\n1761#2,3:54\n1761#2,3:57\n1#3:60\n*S KotlinDebug\n*F\n+ 1 inlineClassManglingRules.kt\norg/jetbrains/kotlin/resolve/jvm/InlineClassManglingRulesKt\n*L\n21#1:54,3\n27#1:57,3\n*E\n"})
public final class InlineClassManglingRulesKt {
    public static final boolean shouldHideConstructorDueToValueClassTypeValueParameters(@NotNull CallableMemberDescriptor descriptor2) {
        boolean bl2;
        block7: {
            Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
            ClassConstructorDescriptor classConstructorDescriptor = descriptor2 instanceof ClassConstructorDescriptor ? (ClassConstructorDescriptor)descriptor2 : null;
            if (classConstructorDescriptor == null) {
                return false;
            }
            ClassConstructorDescriptor constructorDescriptor = classConstructorDescriptor;
            if (DescriptorVisibilities.isPrivate(constructorDescriptor.getVisibility())) {
                return false;
            }
            ClassDescriptor classDescriptor = constructorDescriptor.getConstructedClass();
            Intrinsics.checkNotNullExpressionValue(classDescriptor, "getConstructedClass(...)");
            if (InlineClassesUtilsKt.isValueClass(classDescriptor)) {
                return false;
            }
            if (DescriptorUtils.isSealedClass(constructorDescriptor.getConstructedClass())) {
                return false;
            }
            List<ValueParameterDescriptor> list = constructorDescriptor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
            Iterable $this$any$iv = list;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    ValueParameterDescriptor it = (ValueParameterDescriptor)element$iv;
                    boolean bl3 = false;
                    KotlinType kotlinType = it.getType();
                    Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
                    if (!InlineClassManglingRulesKt.requiresFunctionNameManglingInParameterTypes(kotlinType)) continue;
                    bl2 = true;
                    break block7;
                }
                bl2 = false;
            }
        }
        return bl2;
    }

    public static final boolean isValueClassThatRequiresMangling(@NotNull DeclarationDescriptor $this$isValueClassThatRequiresMangling) {
        Intrinsics.checkNotNullParameter($this$isValueClassThatRequiresMangling, "<this>");
        return InlineClassesUtilsKt.isValueClass($this$isValueClassThatRequiresMangling) && !InlineClassManglingRulesKt.isDontMangleClass((ClassDescriptor)$this$isValueClassThatRequiresMangling);
    }

    public static final boolean isValueClassThatRequiresMangling(@NotNull KotlinType $this$isValueClassThatRequiresMangling) {
        boolean bl2;
        Intrinsics.checkNotNullParameter($this$isValueClassThatRequiresMangling, "<this>");
        ClassifierDescriptor classifierDescriptor = $this$isValueClassThatRequiresMangling.getConstructor().getDeclarationDescriptor();
        if (classifierDescriptor != null) {
            ClassifierDescriptor it = classifierDescriptor;
            boolean bl3 = false;
            bl2 = InlineClassesUtilsKt.isInlineClass(it) && InlineClassManglingRulesKt.isValueClassThatRequiresMangling(it) || InlineClassesUtilsKt.needsMfvcFlattening($this$isValueClassThatRequiresMangling);
        } else {
            bl2 = false;
        }
        return bl2;
    }

    private static final boolean requiresFunctionNameManglingInParameterTypes(KotlinType $this$requiresFunctionNameManglingInParameterTypes) {
        return InlineClassManglingRulesKt.isValueClassThatRequiresMangling($this$requiresFunctionNameManglingInParameterTypes) || InlineClassManglingRulesKt.isTypeParameterWithUpperBoundThatRequiresMangling($this$requiresFunctionNameManglingInParameterTypes, true);
    }

    private static final boolean isDontMangleClass(ClassDescriptor classDescriptor) {
        return Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(classDescriptor), StandardNames.RESULT_FQ_NAME);
    }

    private static final boolean isTypeParameterWithUpperBoundThatRequiresMangling(KotlinType $this$isTypeParameterWithUpperBoundThatRequiresMangling, boolean includeMfvc) {
        ClassifierDescriptor classifierDescriptor = $this$isTypeParameterWithUpperBoundThatRequiresMangling.getConstructor().getDeclarationDescriptor();
        TypeParameterDescriptor typeParameterDescriptor = classifierDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor)classifierDescriptor : null;
        if (typeParameterDescriptor == null) {
            return false;
        }
        TypeParameterDescriptor descriptor2 = typeParameterDescriptor;
        return (includeMfvc || !InlineClassesUtilsKt.isMultiFieldValueClass(descriptor2)) && InlineClassManglingRulesKt.requiresFunctionNameManglingInParameterTypes(TypeUtilsKt.getRepresentativeUpperBound(descriptor2));
    }
}

