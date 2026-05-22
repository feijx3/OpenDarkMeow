/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DescriptorBasedTypeSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactoryImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfigurationImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nmethodSignatureMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 methodSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/MethodSignatureMappingKt\n+ 2 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponentsKt\n*L\n1#1,200:1\n13#2:201\n*S KotlinDebug\n*F\n+ 1 methodSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/MethodSignatureMappingKt\n*L\n81#1:201\n*E\n"})
public final class MethodSignatureMappingKt {
    @NotNull
    public static final String computeJvmDescriptor(@NotNull FunctionDescriptor $this$computeJvmDescriptor, boolean withReturnType, boolean withName) {
        StringBuilder stringBuilder;
        Intrinsics.checkNotNullParameter($this$computeJvmDescriptor, "<this>");
        StringBuilder $this$computeJvmDescriptor_u24lambda_u241 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        if (withName) {
            String string;
            if ($this$computeJvmDescriptor instanceof ConstructorDescriptor) {
                string = "<init>";
            } else {
                String string2 = $this$computeJvmDescriptor.getName().asString();
                string = string2;
                Intrinsics.checkNotNullExpressionValue(string2, "asString(...)");
            }
            $this$computeJvmDescriptor_u24lambda_u241.append(string);
        }
        $this$computeJvmDescriptor_u24lambda_u241.append("(");
        ReceiverParameterDescriptor receiverParameterDescriptor = $this$computeJvmDescriptor.getExtensionReceiverParameter();
        if (receiverParameterDescriptor != null) {
            ReceiverParameterDescriptor it = receiverParameterDescriptor;
            boolean bl3 = false;
            KotlinType kotlinType = it.getType();
            Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
            MethodSignatureMappingKt.appendErasedType($this$computeJvmDescriptor_u24lambda_u241, kotlinType);
        }
        for (ValueParameterDescriptor parameter : $this$computeJvmDescriptor.getValueParameters()) {
            KotlinType kotlinType = parameter.getType();
            Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
            MethodSignatureMappingKt.appendErasedType($this$computeJvmDescriptor_u24lambda_u241, kotlinType);
        }
        $this$computeJvmDescriptor_u24lambda_u241.append(")");
        if (withReturnType) {
            if (DescriptorBasedTypeSignatureMappingKt.hasVoidReturnType($this$computeJvmDescriptor)) {
                $this$computeJvmDescriptor_u24lambda_u241.append("V");
            } else {
                KotlinType kotlinType = $this$computeJvmDescriptor.getReturnType();
                Intrinsics.checkNotNull(kotlinType);
                MethodSignatureMappingKt.appendErasedType($this$computeJvmDescriptor_u24lambda_u241, kotlinType);
            }
        }
        return stringBuilder.toString();
    }

    public static /* synthetic */ String computeJvmDescriptor$default(FunctionDescriptor functionDescriptor, boolean bl2, boolean bl3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = true;
        }
        if ((n2 & 2) != 0) {
            bl3 = true;
        }
        return MethodSignatureMappingKt.computeJvmDescriptor(functionDescriptor, bl2, bl3);
    }

    public static final boolean forceSingleValueParameterBoxing(@NotNull CallableDescriptor f2) {
        Intrinsics.checkNotNullParameter(f2, "f");
        if (!(f2 instanceof FunctionDescriptor)) {
            return false;
        }
        if (!Intrinsics.areEqual(((FunctionDescriptor)f2).getName().asString(), "remove") || ((FunctionDescriptor)f2).getValueParameters().size() != 1 || SpecialBuiltinMembers.isFromJavaOrBuiltins((CallableMemberDescriptor)f2)) {
            return false;
        }
        List<ValueParameterDescriptor> list = ((FunctionDescriptor)f2).getOriginal().getValueParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
        KotlinType kotlinType = CollectionsKt.single(list).getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        JvmType jvmType = MethodSignatureMappingKt.mapToJvmType(kotlinType);
        JvmType.Primitive primitive = jvmType instanceof JvmType.Primitive ? (JvmType.Primitive)jvmType : null;
        if ((primitive != null ? primitive.getJvmPrimitiveType() : null) != JvmPrimitiveType.INT) {
            return false;
        }
        FunctionDescriptor functionDescriptor = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor)f2);
        if (functionDescriptor == null) {
            return false;
        }
        FunctionDescriptor overridden = functionDescriptor;
        List<ValueParameterDescriptor> list2 = overridden.getOriginal().getValueParameters();
        Intrinsics.checkNotNullExpressionValue(list2, "getValueParameters(...)");
        KotlinType kotlinType2 = CollectionsKt.single(list2).getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType2, "getType(...)");
        JvmType overriddenParameterType = MethodSignatureMappingKt.mapToJvmType(kotlinType2);
        DeclarationDescriptor declarationDescriptor = overridden.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(declarationDescriptor, "getContainingDeclaration(...)");
        return Intrinsics.areEqual(DescriptorUtilsKt.getFqNameUnsafe(declarationDescriptor), StandardNames.FqNames.mutableCollection.toUnsafe()) && overriddenParameterType instanceof JvmType.Object && Intrinsics.areEqual(((JvmType.Object)overriddenParameterType).getInternalName(), "java/lang/Object");
    }

    @Nullable
    public static final String computeJvmSignature(@NotNull CallableDescriptor $this$computeJvmSignature) {
        Intrinsics.checkNotNullParameter($this$computeJvmSignature, "<this>");
        boolean $i$f$signatures = false;
        SignatureBuildingComponents $this$computeJvmSignature_u24lambda_u244 = SignatureBuildingComponents.INSTANCE;
        boolean bl2 = false;
        if (DescriptorUtils.isLocal($this$computeJvmSignature)) {
            return null;
        }
        DeclarationDescriptor declarationDescriptor = $this$computeJvmSignature.getContainingDeclaration();
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor)declarationDescriptor : null;
        if (classDescriptor == null) {
            return null;
        }
        ClassDescriptor classDescriptor2 = classDescriptor;
        if (classDescriptor2.getName().isSpecial()) {
            return null;
        }
        declarationDescriptor = $this$computeJvmSignature.getOriginal();
        SimpleFunctionDescriptor simpleFunctionDescriptor = declarationDescriptor instanceof SimpleFunctionDescriptor ? (SimpleFunctionDescriptor)declarationDescriptor : null;
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        return MethodSignatureBuildingUtilsKt.signature($this$computeJvmSignature_u24lambda_u244, classDescriptor2, MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, null));
    }

    @NotNull
    public static final String getInternalName(@NotNull ClassDescriptor $this$internalName) {
        Intrinsics.checkNotNullParameter($this$internalName, "<this>");
        ClassId classId = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(DescriptorUtilsKt.getFqNameSafe($this$internalName).toUnsafe());
        if (classId != null) {
            ClassId it = classId;
            boolean bl2 = false;
            String string = JvmClassName.internalNameByClassId(it);
            Intrinsics.checkNotNullExpressionValue(string, "internalNameByClassId(...)");
            return string;
        }
        return DescriptorBasedTypeSignatureMappingKt.computeInternalName$default($this$internalName, null, 2, null);
    }

    private static final void appendErasedType(StringBuilder $this$appendErasedType, KotlinType type) {
        $this$appendErasedType.append(MethodSignatureMappingKt.mapToJvmType(type));
    }

    @NotNull
    public static final JvmType mapToJvmType(@NotNull KotlinType $this$mapToJvmType) {
        Intrinsics.checkNotNullParameter($this$mapToJvmType, "<this>");
        return (JvmType)DescriptorBasedTypeSignatureMappingKt.mapType$default($this$mapToJvmType, JvmTypeFactoryImpl.INSTANCE, TypeMappingMode.DEFAULT, TypeMappingConfigurationImpl.INSTANCE, null, null, 32, null);
    }
}

