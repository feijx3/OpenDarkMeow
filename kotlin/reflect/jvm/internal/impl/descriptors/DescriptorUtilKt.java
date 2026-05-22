/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\ndescriptorUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 descriptorUtil.kt\norg/jetbrains/kotlin/descriptors/DescriptorUtilKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 coreLib.kt\norg/jetbrains/kotlin/utils/CoreLibKt\n*L\n1#1,113:1\n1#2:114\n19#3:115\n*S KotlinDebug\n*F\n+ 1 descriptorUtil.kt\norg/jetbrains/kotlin/descriptors/DescriptorUtilKt\n*L\n38#1:115\n*E\n"})
public final class DescriptorUtilKt {
    @Nullable
    public static final ClassDescriptor resolveClassByFqName(@NotNull ModuleDescriptor $this$resolveClassByFqName, @NotNull FqName fqName, @NotNull LookupLocation lookupLocation) {
        MemberScope memberScope;
        ClassDescriptor classDescriptor;
        Intrinsics.checkNotNullParameter($this$resolveClassByFqName, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(lookupLocation, "lookupLocation");
        if (fqName.isRoot()) {
            return null;
        }
        ClassifierDescriptor classifierDescriptor = $this$resolveClassByFqName.getPackage(fqName.parent()).getMemberScope().getContributedClassifier(fqName.shortName(), lookupLocation);
        ClassDescriptor classDescriptor2 = classDescriptor = classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
        if (classDescriptor != null) {
            ClassDescriptor it = classDescriptor;
            boolean bl2 = false;
            return it;
        }
        classifierDescriptor = DescriptorUtilKt.resolveClassByFqName($this$resolveClassByFqName, fqName.parent(), lookupLocation);
        classDescriptor = classifierDescriptor != null && (memberScope = classifierDescriptor.getUnsubstitutedInnerClassesScope()) != null ? memberScope.getContributedClassifier(fqName.shortName(), lookupLocation) : null;
        return classDescriptor instanceof ClassDescriptor ? classDescriptor : null;
    }

    public static final boolean isTopLevelInPackage(@NotNull DeclarationDescriptor $this$isTopLevelInPackage) {
        Intrinsics.checkNotNullParameter($this$isTopLevelInPackage, "<this>");
        return $this$isTopLevelInPackage.getContainingDeclaration() instanceof PackageFragmentDescriptor;
    }

    @Nullable
    public static final ClassifierDescriptor getTopLevelContainingClassifier(@NotNull DeclarationDescriptor $this$getTopLevelContainingClassifier) {
        Intrinsics.checkNotNullParameter($this$getTopLevelContainingClassifier, "<this>");
        DeclarationDescriptor containingDeclaration = $this$getTopLevelContainingClassifier.getContainingDeclaration();
        if (containingDeclaration == null || $this$getTopLevelContainingClassifier instanceof PackageFragmentDescriptor) {
            return null;
        }
        return !DescriptorUtilKt.isTopLevelInPackage(containingDeclaration) ? DescriptorUtilKt.getTopLevelContainingClassifier(containingDeclaration) : (containingDeclaration instanceof ClassifierDescriptor ? (ClassifierDescriptor)containingDeclaration : null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean isTypedEqualsInValueClass(@NotNull FunctionDescriptor $this$isTypedEqualsInValueClass) {
        ClassDescriptor classDescriptor;
        Intrinsics.checkNotNullParameter($this$isTypedEqualsInValueClass, "<this>");
        DeclarationDescriptor declarationDescriptor = $this$isTypedEqualsInValueClass.getContainingDeclaration();
        if (!(declarationDescriptor instanceof ClassDescriptor)) return false;
        ClassDescriptor classDescriptor2 = (ClassDescriptor)declarationDescriptor;
        Annotated annotated = classDescriptor2;
        if (classDescriptor2 == null) return false;
        ClassDescriptor it = classDescriptor = annotated;
        boolean bl2 = false;
        if (!InlineClassesUtilsKt.isValueClass(it)) return false;
        ClassDescriptor classDescriptor3 = classDescriptor;
        annotated = classDescriptor3;
        if (classDescriptor3 == null) return false;
        SimpleType simpleType = annotated.getDefaultType();
        annotated = simpleType;
        if (simpleType == null) return false;
        if ((annotated = TypeUtilsKt.replaceArgumentsWithStarProjections((KotlinType)annotated)) == null) {
            return false;
        }
        Annotated annotated2 = annotated;
        KotlinType kotlinType = $this$isTypedEqualsInValueClass.getReturnType();
        if (kotlinType == null) {
            return false;
        }
        KotlinType returnType = kotlinType;
        if (!Intrinsics.areEqual($this$isTypedEqualsInValueClass.getName(), OperatorNameConventions.EQUALS)) return false;
        if (!TypeUtilsKt.isBoolean(returnType)) {
            if (!TypeUtilsKt.isNothing(returnType)) return false;
        }
        if ($this$isTypedEqualsInValueClass.getValueParameters().size() != 1) return false;
        KotlinType kotlinType2 = $this$isTypedEqualsInValueClass.getValueParameters().get(0).getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType2, "getType(...)");
        if (!Intrinsics.areEqual(TypeUtilsKt.replaceArgumentsWithStarProjections(kotlinType2), annotated2)) return false;
        if (!$this$isTypedEqualsInValueClass.getContextReceiverParameters().isEmpty()) return false;
        if ($this$isTypedEqualsInValueClass.getExtensionReceiverParameter() != null) return false;
        return true;
    }
}

