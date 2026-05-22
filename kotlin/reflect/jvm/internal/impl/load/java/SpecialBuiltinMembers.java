/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Named;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JvmName(name="SpecialBuiltinMembers")
@SourceDebugExtension(value={"SMAP\nspecialBuiltinMembers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 specialBuiltinMembers.kt\norg/jetbrains/kotlin/load/java/SpecialBuiltinMembers\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n1#2:178\n*E\n"})
public final class SpecialBuiltinMembers {
    @Nullable
    public static final <T extends CallableMemberDescriptor> T getOverriddenBuiltinWithDifferentJvmName(@NotNull T $this$getOverriddenBuiltinWithDifferentJvmName) {
        Intrinsics.checkNotNullParameter($this$getOverriddenBuiltinWithDifferentJvmName, "<this>");
        if (!SpecialGenericSignatures.Companion.getORIGINAL_SHORT_NAMES().contains(((Named)$this$getOverriddenBuiltinWithDifferentJvmName).getName()) && !BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES().contains(DescriptorUtilsKt.getPropertyIfAccessor($this$getOverriddenBuiltinWithDifferentJvmName).getName())) {
            return null;
        }
        T t2 = $this$getOverriddenBuiltinWithDifferentJvmName;
        return (T)(t2 instanceof PropertyDescriptor || t2 instanceof PropertyAccessorDescriptor ? DescriptorUtilsKt.firstOverridden$default($this$getOverriddenBuiltinWithDifferentJvmName, false, SpecialBuiltinMembers$$Lambda$0.INSTANCE, 1, null) : (t2 instanceof SimpleFunctionDescriptor ? DescriptorUtilsKt.firstOverridden$default($this$getOverriddenBuiltinWithDifferentJvmName, false, SpecialBuiltinMembers$$Lambda$1.INSTANCE, 1, null) : null));
    }

    public static final boolean doesOverrideBuiltinWithDifferentJvmName(@NotNull CallableMemberDescriptor $this$doesOverrideBuiltinWithDifferentJvmName) {
        Intrinsics.checkNotNullParameter($this$doesOverrideBuiltinWithDifferentJvmName, "<this>");
        return SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName($this$doesOverrideBuiltinWithDifferentJvmName) != null;
    }

    @Nullable
    public static final <T extends CallableMemberDescriptor> T getOverriddenSpecialBuiltin(@NotNull T $this$getOverriddenSpecialBuiltin) {
        Intrinsics.checkNotNullParameter($this$getOverriddenSpecialBuiltin, "<this>");
        T t2 = SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName($this$getOverriddenSpecialBuiltin);
        if (t2 != null) {
            T it = t2;
            boolean bl2 = false;
            return it;
        }
        Name name = ((Named)$this$getOverriddenSpecialBuiltin).getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (!BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return null;
        }
        return (T)DescriptorUtilsKt.firstOverridden$default($this$getOverriddenSpecialBuiltin, false, SpecialBuiltinMembers$$Lambda$2.INSTANCE, 1, null);
    }

    @Nullable
    public static final String getJvmMethodNameIfSpecial(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        String string;
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "callableMemberDescriptor");
        CallableMemberDescriptor callableMemberDescriptor2 = SpecialBuiltinMembers.getOverriddenBuiltinThatAffectsJvmName(callableMemberDescriptor);
        if (callableMemberDescriptor2 == null || (callableMemberDescriptor2 = DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor2)) == null) {
            return null;
        }
        CallableMemberDescriptor overriddenBuiltin = callableMemberDescriptor2;
        CallableMemberDescriptor callableMemberDescriptor3 = overriddenBuiltin;
        if (callableMemberDescriptor3 instanceof PropertyDescriptor) {
            string = ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(overriddenBuiltin);
        } else if (callableMemberDescriptor3 instanceof SimpleFunctionDescriptor) {
            Name name = BuiltinMethodsWithDifferentJvmName.INSTANCE.getJvmName((SimpleFunctionDescriptor)overriddenBuiltin);
            string = name != null ? name.asString() : null;
        } else {
            string = null;
        }
        return string;
    }

    private static final CallableMemberDescriptor getOverriddenBuiltinThatAffectsJvmName(CallableMemberDescriptor callableMemberDescriptor) {
        return KotlinBuiltIns.isBuiltIn(callableMemberDescriptor) ? SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(callableMemberDescriptor) : null;
    }

    public static final boolean hasRealKotlinSuperClassWithOverrideOf(@NotNull ClassDescriptor $this$hasRealKotlinSuperClassWithOverrideOf, @NotNull CallableDescriptor specialCallableDescriptor) {
        Intrinsics.checkNotNullParameter($this$hasRealKotlinSuperClassWithOverrideOf, "<this>");
        Intrinsics.checkNotNullParameter(specialCallableDescriptor, "specialCallableDescriptor");
        DeclarationDescriptor declarationDescriptor = specialCallableDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        SimpleType simpleType = ((ClassDescriptor)declarationDescriptor).getDefaultType();
        Intrinsics.checkNotNullExpressionValue(simpleType, "getDefaultType(...)");
        SimpleType builtinContainerDefaultType = simpleType;
        ClassDescriptor superClassDescriptor = DescriptorUtils.getSuperClassDescriptor($this$hasRealKotlinSuperClassWithOverrideOf);
        while (superClassDescriptor != null) {
            if (!(superClassDescriptor instanceof JavaClassDescriptor)) {
                boolean doesOverrideBuiltinDeclaration;
                boolean bl2 = doesOverrideBuiltinDeclaration = TypeCheckingProcedure.findCorrespondingSupertype(superClassDescriptor.getDefaultType(), builtinContainerDefaultType) != null;
                if (doesOverrideBuiltinDeclaration) {
                    return !KotlinBuiltIns.isBuiltIn(superClassDescriptor);
                }
            }
            superClassDescriptor = DescriptorUtils.getSuperClassDescriptor(superClassDescriptor);
        }
        return false;
    }

    public static final boolean isFromJava(@NotNull CallableMemberDescriptor $this$isFromJava) {
        Intrinsics.checkNotNullParameter($this$isFromJava, "<this>");
        CallableMemberDescriptor descriptor2 = DescriptorUtilsKt.getPropertyIfAccessor($this$isFromJava);
        return descriptor2.getContainingDeclaration() instanceof JavaClassDescriptor;
    }

    public static final boolean isFromJavaOrBuiltins(@NotNull CallableMemberDescriptor $this$isFromJavaOrBuiltins) {
        Intrinsics.checkNotNullParameter($this$isFromJavaOrBuiltins, "<this>");
        return SpecialBuiltinMembers.isFromJava($this$isFromJavaOrBuiltins) || KotlinBuiltIns.isBuiltIn($this$isFromJavaOrBuiltins);
    }

    private static final boolean getOverriddenBuiltinWithDifferentJvmName$lambda$0(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ClassicBuiltinSpecialProperties.INSTANCE.hasBuiltinSpecialPropertyFqName(DescriptorUtilsKt.getPropertyIfAccessor(it));
    }

    private static final boolean getOverriddenBuiltinWithDifferentJvmName$lambda$1(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return BuiltinMethodsWithDifferentJvmName.INSTANCE.isBuiltinFunctionWithDifferentNameInJvm((SimpleFunctionDescriptor)it);
    }

    private static final boolean getOverriddenSpecialBuiltin$lambda$3(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return KotlinBuiltIns.isBuiltIn(it) && BuiltinMethodsWithSpecialGenericSignature.getSpecialSignatureInfo(it) != null;
    }

    static /* synthetic */ boolean accessor$SpecialBuiltinMembers$lambda0(CallableMemberDescriptor callableMemberDescriptor) {
        return SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName$lambda$0(callableMemberDescriptor);
    }

    static /* synthetic */ boolean accessor$SpecialBuiltinMembers$lambda1(CallableMemberDescriptor callableMemberDescriptor) {
        return SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName$lambda$1(callableMemberDescriptor);
    }

    static /* synthetic */ boolean accessor$SpecialBuiltinMembers$lambda2(CallableMemberDescriptor callableMemberDescriptor) {
        return SpecialBuiltinMembers.getOverriddenSpecialBuiltin$lambda$3(callableMemberDescriptor);
    }
}

