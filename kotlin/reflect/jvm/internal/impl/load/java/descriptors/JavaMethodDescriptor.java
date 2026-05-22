/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaMethodDescriptor
extends SimpleFunctionDescriptorImpl
implements JavaCallableMemberDescriptor {
    public static final CallableDescriptor.UserDataKey<ValueParameterDescriptor> ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER = new CallableDescriptor.UserDataKey<ValueParameterDescriptor>(){};
    public static final CallableDescriptor.UserDataKey<Boolean> HAS_ERASED_VALUE_PARAMETERS = new CallableDescriptor.UserDataKey<Boolean>(){};
    private ParameterNamesStatus parameterNamesStatus;
    private final boolean isForRecordComponent;

    protected JavaMethodDescriptor(@NotNull DeclarationDescriptor containingDeclaration, @Nullable SimpleFunctionDescriptor original, @NotNull Annotations annotations, @NotNull Name name, @NotNull CallableMemberDescriptor.Kind kind2, @NotNull SourceElement source, boolean isForRecordComponent) {
        if (containingDeclaration == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(0);
        }
        if (annotations == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(1);
        }
        if (name == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(2);
        }
        if (kind2 == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(3);
        }
        if (source == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(4);
        }
        super(containingDeclaration, original, annotations, name, kind2, source);
        this.parameterNamesStatus = null;
        this.isForRecordComponent = isForRecordComponent;
    }

    @NotNull
    public static JavaMethodDescriptor createJavaMethod(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations, @NotNull Name name, @NotNull SourceElement source, boolean isForRecordComponent) {
        if (containingDeclaration == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(5);
        }
        if (annotations == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(6);
        }
        if (name == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(7);
        }
        if (source == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(8);
        }
        return new JavaMethodDescriptor(containingDeclaration, null, annotations, name, CallableMemberDescriptor.Kind.DECLARATION, source, isForRecordComponent);
    }

    @Override
    @NotNull
    public SimpleFunctionDescriptorImpl initialize(@Nullable ReceiverParameterDescriptor extensionReceiverParameter, @Nullable ReceiverParameterDescriptor dispatchReceiverParameter, @NotNull List<ReceiverParameterDescriptor> contextReceiverParameters, @NotNull List<? extends TypeParameterDescriptor> typeParameters, @NotNull List<ValueParameterDescriptor> unsubstitutedValueParameters, @Nullable KotlinType unsubstitutedReturnType, @Nullable Modality modality2, @NotNull DescriptorVisibility visibility2, @Nullable Map<? extends CallableDescriptor.UserDataKey<?>, ?> userData) {
        if (contextReceiverParameters == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(9);
        }
        if (typeParameters == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(10);
        }
        if (unsubstitutedValueParameters == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(11);
        }
        if (visibility2 == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(12);
        }
        SimpleFunctionDescriptorImpl descriptor2 = super.initialize(extensionReceiverParameter, dispatchReceiverParameter, contextReceiverParameters, typeParameters, unsubstitutedValueParameters, unsubstitutedReturnType, modality2, visibility2, userData);
        this.setOperator(OperatorChecks.INSTANCE.check(descriptor2).isSuccess());
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImpl = descriptor2;
        if (simpleFunctionDescriptorImpl == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(13);
        }
        return simpleFunctionDescriptorImpl;
    }

    @Override
    public boolean hasStableParameterNames() {
        assert (this.parameterNamesStatus != null) : "Parameter names status was not set: " + this;
        return this.parameterNamesStatus.isStable;
    }

    @Override
    public boolean hasSynthesizedParameterNames() {
        assert (this.parameterNamesStatus != null) : "Parameter names status was not set: " + this;
        return this.parameterNamesStatus.isSynthesized;
    }

    public void setParameterNamesStatus(boolean hasStableParameterNames, boolean hasSynthesizedParameterNames) {
        this.parameterNamesStatus = ParameterNamesStatus.get(hasStableParameterNames, hasSynthesizedParameterNames);
    }

    @Override
    @NotNull
    protected JavaMethodDescriptor createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @Nullable FunctionDescriptor original, @NotNull CallableMemberDescriptor.Kind kind2, @Nullable Name newName, @NotNull Annotations annotations, @NotNull SourceElement source) {
        if (newOwner == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(14);
        }
        if (kind2 == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(15);
        }
        if (annotations == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(16);
        }
        if (source == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(17);
        }
        JavaMethodDescriptor result = new JavaMethodDescriptor(newOwner, (SimpleFunctionDescriptor)original, annotations, newName != null ? newName : this.getName(), kind2, source, this.isForRecordComponent);
        result.setParameterNamesStatus(this.hasStableParameterNames(), this.hasSynthesizedParameterNames());
        JavaMethodDescriptor javaMethodDescriptor = result;
        if (javaMethodDescriptor == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(18);
        }
        return javaMethodDescriptor;
    }

    @Override
    @NotNull
    public JavaMethodDescriptor enhance(@Nullable KotlinType enhancedReceiverType, @NotNull List<KotlinType> enhancedValueParameterTypes, @NotNull KotlinType enhancedReturnType, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> additionalUserData) {
        if (enhancedValueParameterTypes == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(19);
        }
        if (enhancedReturnType == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(20);
        }
        List<ValueParameterDescriptor> enhancedValueParameters = UtilKt.copyValueParameters(enhancedValueParameterTypes, this.getValueParameters(), this);
        ReceiverParameterDescriptor enhancedReceiver = enhancedReceiverType == null ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(this, enhancedReceiverType, Annotations.Companion.getEMPTY());
        JavaMethodDescriptor enhancedMethod = (JavaMethodDescriptor)this.newCopyBuilder().setValueParameters(enhancedValueParameters).setReturnType(enhancedReturnType).setExtensionReceiverParameter(enhancedReceiver).setDropOriginalInContainingParts().setPreserveSourceElement().build();
        assert (enhancedMethod != null) : "null after substitution while enhancing " + this;
        if (additionalUserData != null) {
            enhancedMethod.putInUserDataMap(additionalUserData.getFirst(), additionalUserData.getSecond());
        }
        JavaMethodDescriptor javaMethodDescriptor = enhancedMethod;
        if (javaMethodDescriptor == null) {
            JavaMethodDescriptor.$$$reportNull$$$0(21);
        }
        return javaMethodDescriptor;
    }

    private static /* synthetic */ void $$$reportNull$$$0(int n2) {
        RuntimeException runtimeException;
        Object[] objectArray;
        Object[] objectArray2;
        int n3;
        String string;
        switch (n2) {
            default: {
                string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
            }
            case 13: 
            case 18: 
            case 21: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n2) {
            default: {
                n3 = 3;
                break;
            }
            case 13: 
            case 18: 
            case 21: {
                n3 = 2;
                break;
            }
        }
        Object[] objectArray3 = new Object[n3];
        switch (n2) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "containingDeclaration";
                break;
            }
            case 1: 
            case 6: 
            case 16: {
                objectArray2 = objectArray3;
                objectArray3[0] = "annotations";
                break;
            }
            case 2: 
            case 7: {
                objectArray2 = objectArray3;
                objectArray3[0] = "name";
                break;
            }
            case 3: 
            case 15: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kind";
                break;
            }
            case 4: 
            case 8: 
            case 17: {
                objectArray2 = objectArray3;
                objectArray3[0] = "source";
                break;
            }
            case 9: {
                objectArray2 = objectArray3;
                objectArray3[0] = "contextReceiverParameters";
                break;
            }
            case 10: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeParameters";
                break;
            }
            case 11: {
                objectArray2 = objectArray3;
                objectArray3[0] = "unsubstitutedValueParameters";
                break;
            }
            case 12: {
                objectArray2 = objectArray3;
                objectArray3[0] = "visibility";
                break;
            }
            case 13: 
            case 18: 
            case 21: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            }
            case 14: {
                objectArray2 = objectArray3;
                objectArray3[0] = "newOwner";
                break;
            }
            case 19: {
                objectArray2 = objectArray3;
                objectArray3[0] = "enhancedValueParameterTypes";
                break;
            }
            case 20: {
                objectArray2 = objectArray3;
                objectArray3[0] = "enhancedReturnType";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            }
            case 13: {
                objectArray = objectArray2;
                objectArray2[1] = "initialize";
                break;
            }
            case 18: {
                objectArray = objectArray2;
                objectArray2[1] = "createSubstitutedCopy";
                break;
            }
            case 21: {
                objectArray = objectArray2;
                objectArray2[1] = "enhance";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray;
                objectArray[2] = "<init>";
                break;
            }
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                objectArray = objectArray;
                objectArray[2] = "createJavaMethod";
                break;
            }
            case 9: 
            case 10: 
            case 11: 
            case 12: {
                objectArray = objectArray;
                objectArray[2] = "initialize";
                break;
            }
            case 13: 
            case 18: 
            case 21: {
                break;
            }
            case 14: 
            case 15: 
            case 16: 
            case 17: {
                objectArray = objectArray;
                objectArray[2] = "createSubstitutedCopy";
                break;
            }
            case 19: 
            case 20: {
                objectArray = objectArray;
                objectArray[2] = "enhance";
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n2) {
            default: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
            case 13: 
            case 18: 
            case 21: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }

    private static enum ParameterNamesStatus {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);

        public final boolean isStable;
        public final boolean isSynthesized;

        private ParameterNamesStatus(boolean isStable, boolean isSynthesized) {
            this.isStable = isStable;
            this.isSynthesized = isSynthesized;
        }

        @NotNull
        public static ParameterNamesStatus get(boolean stable, boolean synthesized) {
            ParameterNamesStatus parameterNamesStatus = stable ? (synthesized ? STABLE_SYNTHESIZED : STABLE_DECLARED) : (synthesized ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED);
            if (parameterNamesStatus == null) {
                ParameterNamesStatus.$$$reportNull$$$0(0);
            }
            return parameterNamesStatus;
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"));
        }
    }
}

