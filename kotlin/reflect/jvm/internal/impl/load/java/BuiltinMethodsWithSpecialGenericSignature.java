/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nspecialBuiltinMembers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 specialBuiltinMembers.kt\norg/jetbrains/kotlin/load/java/BuiltinMethodsWithSpecialGenericSignature\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n1#2:178\n*E\n"})
public final class BuiltinMethodsWithSpecialGenericSignature
extends SpecialGenericSignatures {
    @NotNull
    public static final BuiltinMethodsWithSpecialGenericSignature INSTANCE = new BuiltinMethodsWithSpecialGenericSignature();

    private BuiltinMethodsWithSpecialGenericSignature() {
    }

    private final boolean getHasErasedValueParametersInJava(CallableMemberDescriptor $this$hasErasedValueParametersInJava) {
        return CollectionsKt.contains((Iterable)SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SIGNATURES(), MethodSignatureMappingKt.computeJvmSignature($this$hasErasedValueParametersInJava));
    }

    @JvmStatic
    @Nullable
    public static final FunctionDescriptor getOverriddenBuiltinFunctionWithErasedValueParametersInJava(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        Name name = functionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (!INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return null;
        }
        return (FunctionDescriptor)DescriptorUtilsKt.firstOverridden$default(functionDescriptor, false, BuiltinMethodsWithSpecialGenericSignature$$Lambda$0.INSTANCE, 1, null);
    }

    public final boolean getSameAsBuiltinMethodWithErasedValueParameters(@NotNull Name $this$sameAsBuiltinMethodWithErasedValueParameters) {
        Intrinsics.checkNotNullParameter($this$sameAsBuiltinMethodWithErasedValueParameters, "<this>");
        return SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains($this$sameAsBuiltinMethodWithErasedValueParameters);
    }

    @JvmStatic
    @Nullable
    public static final SpecialGenericSignatures.SpecialSignatureInfo getSpecialSignatureInfo(@NotNull CallableMemberDescriptor $this$getSpecialSignatureInfo) {
        Intrinsics.checkNotNullParameter($this$getSpecialSignatureInfo, "<this>");
        if (!SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains($this$getSpecialSignatureInfo.getName())) {
            return null;
        }
        Object object = DescriptorUtilsKt.firstOverridden$default($this$getSpecialSignatureInfo, false, BuiltinMethodsWithSpecialGenericSignature$$Lambda$2.INSTANCE, 1, null);
        if (object == null || (object = MethodSignatureMappingKt.computeJvmSignature((CallableDescriptor)object)) == null) {
            return null;
        }
        Object builtinSignature = object;
        return SpecialGenericSignatures.Companion.getSpecialSignatureInfo((String)builtinSignature);
    }

    private static final boolean getOverriddenBuiltinFunctionWithErasedValueParametersInJava$lambda$0(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.getHasErasedValueParametersInJava(it);
    }

    private static final boolean getSpecialSignatureInfo$lambda$3(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof FunctionDescriptor && INSTANCE.getHasErasedValueParametersInJava(it);
    }

    static /* synthetic */ boolean accessor$BuiltinMethodsWithSpecialGenericSignature$lambda0(CallableMemberDescriptor callableMemberDescriptor) {
        return BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava$lambda$0(callableMemberDescriptor);
    }

    static /* synthetic */ boolean accessor$BuiltinMethodsWithSpecialGenericSignature$lambda2(CallableMemberDescriptor callableMemberDescriptor) {
        return BuiltinMethodsWithSpecialGenericSignature.getSpecialSignatureInfo$lambda$3(callableMemberDescriptor);
    }
}

