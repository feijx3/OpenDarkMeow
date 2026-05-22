/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;

public class ReceiverParameterDescriptorImpl
extends AbstractReceiverParameterDescriptor {
    private final DeclarationDescriptor containingDeclaration;
    private ReceiverValue value;

    public ReceiverParameterDescriptorImpl(@NotNull DeclarationDescriptor containingDeclaration, @NotNull ReceiverValue value, @NotNull Annotations annotations) {
        if (containingDeclaration == null) {
            ReceiverParameterDescriptorImpl.$$$reportNull$$$0(0);
        }
        if (value == null) {
            ReceiverParameterDescriptorImpl.$$$reportNull$$$0(1);
        }
        if (annotations == null) {
            ReceiverParameterDescriptorImpl.$$$reportNull$$$0(2);
        }
        this(containingDeclaration, value, annotations, SpecialNames.THIS);
    }

    public ReceiverParameterDescriptorImpl(@NotNull DeclarationDescriptor containingDeclaration, @NotNull ReceiverValue value, @NotNull Annotations annotations, @NotNull Name name) {
        if (containingDeclaration == null) {
            ReceiverParameterDescriptorImpl.$$$reportNull$$$0(3);
        }
        if (value == null) {
            ReceiverParameterDescriptorImpl.$$$reportNull$$$0(4);
        }
        if (annotations == null) {
            ReceiverParameterDescriptorImpl.$$$reportNull$$$0(5);
        }
        if (name == null) {
            ReceiverParameterDescriptorImpl.$$$reportNull$$$0(6);
        }
        super(annotations, name);
        this.containingDeclaration = containingDeclaration;
        this.value = value;
    }

    @Override
    @NotNull
    public ReceiverValue getValue() {
        ReceiverValue receiverValue = this.value;
        if (receiverValue == null) {
            ReceiverParameterDescriptorImpl.$$$reportNull$$$0(7);
        }
        return receiverValue;
    }

    @Override
    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.containingDeclaration;
        if (declarationDescriptor == null) {
            ReceiverParameterDescriptorImpl.$$$reportNull$$$0(8);
        }
        return declarationDescriptor;
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
            case 7: 
            case 8: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n2) {
            default: {
                n3 = 3;
                break;
            }
            case 7: 
            case 8: {
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
            case 4: {
                objectArray2 = objectArray3;
                objectArray3[0] = "value";
                break;
            }
            case 2: 
            case 5: {
                objectArray2 = objectArray3;
                objectArray3[0] = "annotations";
                break;
            }
            case 6: {
                objectArray2 = objectArray3;
                objectArray3[0] = "name";
                break;
            }
            case 7: 
            case 8: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            }
            case 9: {
                objectArray2 = objectArray3;
                objectArray3[0] = "newOwner";
                break;
            }
            case 10: {
                objectArray2 = objectArray3;
                objectArray3[0] = "outType";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            }
            case 7: {
                objectArray = objectArray2;
                objectArray2[1] = "getValue";
                break;
            }
            case 8: {
                objectArray = objectArray2;
                objectArray2[1] = "getContainingDeclaration";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray;
                objectArray[2] = "<init>";
                break;
            }
            case 7: 
            case 8: {
                break;
            }
            case 9: {
                objectArray = objectArray;
                objectArray[2] = "copy";
                break;
            }
            case 10: {
                objectArray = objectArray;
                objectArray[2] = "setOutType";
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n2) {
            default: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
            case 7: 
            case 8: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }
}

