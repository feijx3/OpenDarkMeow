/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SimpleFunctionDescriptorImpl
extends FunctionDescriptorImpl
implements SimpleFunctionDescriptor {
    protected SimpleFunctionDescriptorImpl(@NotNull DeclarationDescriptor containingDeclaration, @Nullable SimpleFunctionDescriptor original, @NotNull Annotations annotations, @NotNull Name name, @NotNull CallableMemberDescriptor.Kind kind2, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(0);
        }
        if (annotations == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(1);
        }
        if (name == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(2);
        }
        if (kind2 == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(3);
        }
        if (source == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(4);
        }
        super(containingDeclaration, original, annotations, name, kind2, source);
    }

    @NotNull
    public static SimpleFunctionDescriptorImpl create(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations, @NotNull Name name, @NotNull CallableMemberDescriptor.Kind kind2, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(5);
        }
        if (annotations == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(6);
        }
        if (name == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(7);
        }
        if (kind2 == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(8);
        }
        if (source == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(9);
        }
        return new SimpleFunctionDescriptorImpl(containingDeclaration, null, annotations, name, kind2, source);
    }

    @Override
    @NotNull
    public SimpleFunctionDescriptorImpl initialize(@Nullable ReceiverParameterDescriptor extensionReceiverParameter, @Nullable ReceiverParameterDescriptor dispatchReceiverParameter, @NotNull List<ReceiverParameterDescriptor> contextReceiverParameters, @NotNull List<? extends TypeParameterDescriptor> typeParameters, @NotNull List<ValueParameterDescriptor> unsubstitutedValueParameters, @Nullable KotlinType unsubstitutedReturnType, @Nullable Modality modality2, @NotNull DescriptorVisibility visibility2) {
        if (contextReceiverParameters == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(14);
        }
        if (typeParameters == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(15);
        }
        if (unsubstitutedValueParameters == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(16);
        }
        if (visibility2 == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(17);
        }
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImpl = this.initialize(extensionReceiverParameter, dispatchReceiverParameter, contextReceiverParameters, typeParameters, unsubstitutedValueParameters, unsubstitutedReturnType, modality2, visibility2, null);
        if (simpleFunctionDescriptorImpl == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(18);
        }
        return simpleFunctionDescriptorImpl;
    }

    @NotNull
    public SimpleFunctionDescriptorImpl initialize(@Nullable ReceiverParameterDescriptor extensionReceiverParameter, @Nullable ReceiverParameterDescriptor dispatchReceiverParameter, @NotNull List<ReceiverParameterDescriptor> contextReceiverParameters, @NotNull List<? extends TypeParameterDescriptor> typeParameters, @NotNull List<ValueParameterDescriptor> unsubstitutedValueParameters, @Nullable KotlinType unsubstitutedReturnType, @Nullable Modality modality2, @NotNull DescriptorVisibility visibility2, @Nullable Map<? extends CallableDescriptor.UserDataKey<?>, ?> userData) {
        if (contextReceiverParameters == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(19);
        }
        if (typeParameters == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(20);
        }
        if (unsubstitutedValueParameters == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(21);
        }
        if (visibility2 == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(22);
        }
        super.initialize(extensionReceiverParameter, dispatchReceiverParameter, contextReceiverParameters, typeParameters, unsubstitutedValueParameters, unsubstitutedReturnType, modality2, visibility2);
        if (userData != null && !userData.isEmpty()) {
            this.userDataMap = new LinkedHashMap(userData);
        }
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImpl = this;
        if (simpleFunctionDescriptorImpl == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(23);
        }
        return simpleFunctionDescriptorImpl;
    }

    @Override
    @NotNull
    public SimpleFunctionDescriptor getOriginal() {
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor)super.getOriginal();
        if (simpleFunctionDescriptor == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(24);
        }
        return simpleFunctionDescriptor;
    }

    @Override
    @NotNull
    protected FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @Nullable FunctionDescriptor original, @NotNull CallableMemberDescriptor.Kind kind2, @Nullable Name newName, @NotNull Annotations annotations, @NotNull SourceElement source) {
        if (newOwner == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(25);
        }
        if (kind2 == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(26);
        }
        if (annotations == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(27);
        }
        if (source == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(28);
        }
        return new SimpleFunctionDescriptorImpl(newOwner, (SimpleFunctionDescriptor)original, annotations, newName != null ? newName : this.getName(), kind2, source);
    }

    @Override
    @NotNull
    public SimpleFunctionDescriptor copy(DeclarationDescriptor newOwner, Modality modality2, DescriptorVisibility visibility2, CallableMemberDescriptor.Kind kind2, boolean copyOverrides) {
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor)super.copy(newOwner, modality2, visibility2, kind2, copyOverrides);
        if (simpleFunctionDescriptor == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(29);
        }
        return simpleFunctionDescriptor;
    }

    @Override
    @NotNull
    public FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder() {
        FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> copyBuilder = super.newCopyBuilder();
        if (copyBuilder == null) {
            SimpleFunctionDescriptorImpl.$$$reportNull$$$0(30);
        }
        return copyBuilder;
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
            case 23: 
            case 24: 
            case 29: 
            case 30: {
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
            case 23: 
            case 24: 
            case 29: 
            case 30: {
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
            case 27: {
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
            case 8: 
            case 26: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kind";
                break;
            }
            case 4: 
            case 9: 
            case 28: {
                objectArray2 = objectArray3;
                objectArray3[0] = "source";
                break;
            }
            case 10: 
            case 15: 
            case 20: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeParameters";
                break;
            }
            case 11: 
            case 16: 
            case 21: {
                objectArray2 = objectArray3;
                objectArray3[0] = "unsubstitutedValueParameters";
                break;
            }
            case 12: 
            case 17: 
            case 22: {
                objectArray2 = objectArray3;
                objectArray3[0] = "visibility";
                break;
            }
            case 13: 
            case 18: 
            case 23: 
            case 24: 
            case 29: 
            case 30: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            }
            case 14: 
            case 19: {
                objectArray2 = objectArray3;
                objectArray3[0] = "contextReceiverParameters";
                break;
            }
            case 25: {
                objectArray2 = objectArray3;
                objectArray3[0] = "newOwner";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            }
            case 13: 
            case 18: 
            case 23: {
                objectArray = objectArray2;
                objectArray2[1] = "initialize";
                break;
            }
            case 24: {
                objectArray = objectArray2;
                objectArray2[1] = "getOriginal";
                break;
            }
            case 29: {
                objectArray = objectArray2;
                objectArray2[1] = "copy";
                break;
            }
            case 30: {
                objectArray = objectArray2;
                objectArray2[1] = "newCopyBuilder";
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
            case 8: 
            case 9: {
                objectArray = objectArray;
                objectArray[2] = "create";
                break;
            }
            case 10: 
            case 11: 
            case 12: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 19: 
            case 20: 
            case 21: 
            case 22: {
                objectArray = objectArray;
                objectArray[2] = "initialize";
                break;
            }
            case 13: 
            case 18: 
            case 23: 
            case 24: 
            case 29: 
            case 30: {
                break;
            }
            case 25: 
            case 26: 
            case 27: 
            case 28: {
                objectArray = objectArray;
                objectArray[2] = "createSubstitutedCopy";
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
            case 23: 
            case 24: 
            case 29: 
            case 30: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }
}

