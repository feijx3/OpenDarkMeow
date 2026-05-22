/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaIncompatibilityRulesOverridabilityCondition
implements ExternalOverridabilityCondition {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Override
    @NotNull
    public ExternalOverridabilityCondition.Result isOverridable(@NotNull CallableDescriptor superDescriptor, @NotNull CallableDescriptor subDescriptor, @Nullable ClassDescriptor subClassDescriptor) {
        Intrinsics.checkNotNullParameter(superDescriptor, "superDescriptor");
        Intrinsics.checkNotNullParameter(subDescriptor, "subDescriptor");
        if (this.isIncompatibleInAccordanceWithBuiltInOverridabilityRules(superDescriptor, subDescriptor, subClassDescriptor)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        if (Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(superDescriptor, subDescriptor)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }

    private final boolean isIncompatibleInAccordanceWithBuiltInOverridabilityRules(CallableDescriptor superDescriptor, CallableDescriptor subDescriptor, ClassDescriptor subClassDescriptor) {
        boolean isOneOfDescriptorsHidden;
        FunctionDescriptor functionDescriptor;
        if (!(superDescriptor instanceof CallableMemberDescriptor) || !(subDescriptor instanceof FunctionDescriptor) || KotlinBuiltIns.isBuiltIn(subDescriptor)) {
            return false;
        }
        Name name = ((FunctionDescriptor)subDescriptor).getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (!BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            Name name2 = ((FunctionDescriptor)subDescriptor).getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            if (!SpecialGenericSignatures.Companion.getSameAsRenamedInJvmBuiltin(name2)) {
                return false;
            }
        }
        CallableMemberDescriptor overriddenBuiltin = SpecialBuiltinMembers.getOverriddenSpecialBuiltin((CallableMemberDescriptor)superDescriptor);
        CallableDescriptor callableDescriptor = superDescriptor;
        FunctionDescriptor functionDescriptor2 = functionDescriptor = callableDescriptor instanceof FunctionDescriptor ? (FunctionDescriptor)callableDescriptor : null;
        boolean bl2 = isOneOfDescriptorsHidden = !(functionDescriptor != null ? ((FunctionDescriptor)subDescriptor).isHiddenToOvercomeSignatureClash() == functionDescriptor.isHiddenToOvercomeSignatureClash() : false);
        if (isOneOfDescriptorsHidden && (overriddenBuiltin == null || !((FunctionDescriptor)subDescriptor).isHiddenToOvercomeSignatureClash())) {
            return true;
        }
        if (!(subClassDescriptor instanceof JavaClassDescriptor) || ((FunctionDescriptor)subDescriptor).getInitialSignatureDescriptor() != null) {
            return false;
        }
        if (overriddenBuiltin == null || SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(subClassDescriptor, overriddenBuiltin)) {
            return false;
        }
        if (overriddenBuiltin instanceof FunctionDescriptor && superDescriptor instanceof FunctionDescriptor && BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor)overriddenBuiltin) != null) {
            String string = MethodSignatureMappingKt.computeJvmDescriptor$default((FunctionDescriptor)subDescriptor, false, false, 2, null);
            FunctionDescriptor functionDescriptor3 = ((FunctionDescriptor)superDescriptor).getOriginal();
            Intrinsics.checkNotNullExpressionValue(functionDescriptor3, "getOriginal(...)");
            if (Intrinsics.areEqual(string, MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor3, false, false, 2, null))) {
                return false;
            }
        }
        return true;
    }

    @Override
    @NotNull
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    public static final class Companion {
        private Companion() {
        }

        public final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(@NotNull CallableDescriptor superDescriptor, @NotNull CallableDescriptor subDescriptor) {
            boolean bl2;
            Intrinsics.checkNotNullParameter(superDescriptor, "superDescriptor");
            Intrinsics.checkNotNullParameter(subDescriptor, "subDescriptor");
            if (!(subDescriptor instanceof JavaMethodDescriptor) || !(superDescriptor instanceof FunctionDescriptor)) {
                return false;
            }
            boolean bl3 = bl2 = ((JavaMethodDescriptor)subDescriptor).getValueParameters().size() == ((FunctionDescriptor)superDescriptor).getValueParameters().size();
            if (_Assertions.ENABLED && !bl2) {
                boolean bl4 = false;
                String string = "External overridability condition with CONFLICTS_ONLY should not be run with different value parameters size";
                throw new AssertionError((Object)string);
            }
            List<ValueParameterDescriptor> list = ((JavaMethodDescriptor)subDescriptor).getOriginal().getValueParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
            Iterable iterable = list;
            List<ValueParameterDescriptor> list2 = ((FunctionDescriptor)superDescriptor).getOriginal().getValueParameters();
            Intrinsics.checkNotNullExpressionValue(list2, "getValueParameters(...)");
            for (Pair pair : CollectionsKt.zip(iterable, (Iterable)list2)) {
                ValueParameterDescriptor subParameter = (ValueParameterDescriptor)pair.component1();
                ValueParameterDescriptor superParameter = (ValueParameterDescriptor)pair.component2();
                FunctionDescriptor functionDescriptor = (FunctionDescriptor)subDescriptor;
                Intrinsics.checkNotNull(subParameter);
                boolean isSubPrimitive = this.mapValueParameterType(functionDescriptor, subParameter) instanceof JvmType.Primitive;
                FunctionDescriptor functionDescriptor2 = (FunctionDescriptor)superDescriptor;
                Intrinsics.checkNotNull(superParameter);
                boolean isSuperPrimitive = this.mapValueParameterType(functionDescriptor2, superParameter) instanceof JvmType.Primitive;
                if (isSubPrimitive == isSuperPrimitive) continue;
                return true;
            }
            return false;
        }

        private final JvmType mapValueParameterType(FunctionDescriptor f2, ValueParameterDescriptor valueParameterDescriptor) {
            JvmType jvmType;
            if (MethodSignatureMappingKt.forceSingleValueParameterBoxing(f2) || this.isPrimitiveCompareTo(f2)) {
                KotlinType kotlinType = valueParameterDescriptor.getType();
                Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
                jvmType = MethodSignatureMappingKt.mapToJvmType(TypeUtilsKt.makeNullable(kotlinType));
            } else {
                KotlinType kotlinType = valueParameterDescriptor.getType();
                Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
                jvmType = MethodSignatureMappingKt.mapToJvmType(kotlinType);
            }
            return jvmType;
        }

        private final boolean isPrimitiveCompareTo(FunctionDescriptor f2) {
            if (f2.getValueParameters().size() != 1) {
                return false;
            }
            DeclarationDescriptor declarationDescriptor = f2.getContainingDeclaration();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor)declarationDescriptor : null;
            if (classDescriptor == null) {
                return false;
            }
            ClassDescriptor classDescriptor2 = classDescriptor;
            List<ValueParameterDescriptor> list = f2.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
            ClassifierDescriptor classifierDescriptor = CollectionsKt.single(list).getType().getConstructor().getDeclarationDescriptor();
            ClassDescriptor classDescriptor3 = classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
            if (classDescriptor3 == null) {
                return false;
            }
            ClassDescriptor parameterClass = classDescriptor3;
            return KotlinBuiltIns.isPrimitiveClass(classDescriptor2) && Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(classDescriptor2), DescriptorUtilsKt.getFqNameSafe(parameterClass));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

