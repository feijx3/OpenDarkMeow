/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaClassConstructorDescriptor
extends ClassConstructorDescriptorImpl
implements JavaCallableMemberDescriptor {
    private Boolean hasStableParameterNames;
    private Boolean hasSynthesizedParameterNames;

    protected JavaClassConstructorDescriptor(@NotNull ClassDescriptor containingDeclaration, @Nullable JavaClassConstructorDescriptor original, @NotNull Annotations annotations, boolean isPrimary, @NotNull CallableMemberDescriptor.Kind kind2, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(0);
        }
        if (annotations == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(1);
        }
        if (kind2 == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(2);
        }
        if (source == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(3);
        }
        super(containingDeclaration, original, annotations, isPrimary, kind2, source);
        this.hasStableParameterNames = null;
        this.hasSynthesizedParameterNames = null;
    }

    @NotNull
    public static JavaClassConstructorDescriptor createJavaConstructor(@NotNull ClassDescriptor containingDeclaration, @NotNull Annotations annotations, boolean isPrimary, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(4);
        }
        if (annotations == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(5);
        }
        if (source == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(6);
        }
        return new JavaClassConstructorDescriptor(containingDeclaration, null, annotations, isPrimary, CallableMemberDescriptor.Kind.DECLARATION, source);
    }

    @Override
    public boolean hasStableParameterNames() {
        assert (this.hasStableParameterNames != null) : "hasStableParameterNames was not set: " + this;
        return this.hasStableParameterNames;
    }

    @Override
    public void setHasStableParameterNames(boolean hasStableParameterNames) {
        this.hasStableParameterNames = hasStableParameterNames;
    }

    @Override
    public boolean hasSynthesizedParameterNames() {
        assert (this.hasSynthesizedParameterNames != null) : "hasSynthesizedParameterNames was not set: " + this;
        return this.hasSynthesizedParameterNames;
    }

    @Override
    public void setHasSynthesizedParameterNames(boolean hasSynthesizedParameterNames) {
        this.hasSynthesizedParameterNames = hasSynthesizedParameterNames;
    }

    @Override
    @NotNull
    protected JavaClassConstructorDescriptor createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @Nullable FunctionDescriptor original, @NotNull CallableMemberDescriptor.Kind kind2, @Nullable Name newName, @NotNull Annotations annotations, @NotNull SourceElement source) {
        if (newOwner == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(7);
        }
        if (kind2 == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(8);
        }
        if (annotations == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(9);
        }
        if (source == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(10);
        }
        if (kind2 != CallableMemberDescriptor.Kind.DECLARATION && kind2 != CallableMemberDescriptor.Kind.SYNTHESIZED) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + newOwner + "\nkind: " + (Object)((Object)kind2));
        }
        assert (newName == null) : "Attempt to rename constructor: " + this;
        JavaClassConstructorDescriptor result = this.createDescriptor((ClassDescriptor)newOwner, (JavaClassConstructorDescriptor)original, kind2, source, annotations);
        result.setHasStableParameterNames(this.hasStableParameterNames());
        result.setHasSynthesizedParameterNames(this.hasSynthesizedParameterNames());
        JavaClassConstructorDescriptor javaClassConstructorDescriptor = result;
        if (javaClassConstructorDescriptor == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(11);
        }
        return javaClassConstructorDescriptor;
    }

    @NotNull
    protected JavaClassConstructorDescriptor createDescriptor(@NotNull ClassDescriptor newOwner, @Nullable JavaClassConstructorDescriptor original, @NotNull CallableMemberDescriptor.Kind kind2, @NotNull SourceElement sourceElement, @NotNull Annotations annotations) {
        if (newOwner == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(12);
        }
        if (kind2 == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(13);
        }
        if (sourceElement == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(14);
        }
        if (annotations == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(15);
        }
        return new JavaClassConstructorDescriptor(newOwner, original, annotations, this.isPrimary, kind2, sourceElement);
    }

    @Override
    @NotNull
    public JavaClassConstructorDescriptor enhance(@Nullable KotlinType enhancedReceiverType, @NotNull List<KotlinType> enhancedValueParameterTypes, @NotNull KotlinType enhancedReturnType, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> additionalUserData) {
        if (enhancedValueParameterTypes == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(16);
        }
        if (enhancedReturnType == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(17);
        }
        JavaClassConstructorDescriptor enhanced = this.createSubstitutedCopy(this.getContainingDeclaration(), null, this.getKind(), null, this.getAnnotations(), this.getSource());
        ReceiverParameterDescriptor enhancedReceiver = enhancedReceiverType == null ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(enhanced, enhancedReceiverType, Annotations.Companion.getEMPTY());
        enhanced.initialize(enhancedReceiver, this.getDispatchReceiverParameter(), CollectionsKt.<ReceiverParameterDescriptor>emptyList(), this.getTypeParameters(), UtilKt.copyValueParameters(enhancedValueParameterTypes, this.getValueParameters(), enhanced), enhancedReturnType, this.getModality(), this.getVisibility());
        if (additionalUserData != null) {
            enhanced.putInUserDataMap(additionalUserData.getFirst(), additionalUserData.getSecond());
        }
        JavaClassConstructorDescriptor javaClassConstructorDescriptor = enhanced;
        if (javaClassConstructorDescriptor == null) {
            JavaClassConstructorDescriptor.$$$reportNull$$$0(18);
        }
        return javaClassConstructorDescriptor;
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
            case 11: 
            case 18: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n2) {
            default: {
                n3 = 3;
                break;
            }
            case 11: 
            case 18: {
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
            case 5: 
            case 9: 
            case 15: {
                objectArray2 = objectArray3;
                objectArray3[0] = "annotations";
                break;
            }
            case 2: 
            case 8: 
            case 13: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kind";
                break;
            }
            case 3: 
            case 6: 
            case 10: {
                objectArray2 = objectArray3;
                objectArray3[0] = "source";
                break;
            }
            case 7: 
            case 12: {
                objectArray2 = objectArray3;
                objectArray3[0] = "newOwner";
                break;
            }
            case 11: 
            case 18: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            }
            case 14: {
                objectArray2 = objectArray3;
                objectArray3[0] = "sourceElement";
                break;
            }
            case 16: {
                objectArray2 = objectArray3;
                objectArray3[0] = "enhancedValueParameterTypes";
                break;
            }
            case 17: {
                objectArray2 = objectArray3;
                objectArray3[0] = "enhancedReturnType";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            }
            case 11: {
                objectArray = objectArray2;
                objectArray2[1] = "createSubstitutedCopy";
                break;
            }
            case 18: {
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
            case 4: 
            case 5: 
            case 6: {
                objectArray = objectArray;
                objectArray[2] = "createJavaConstructor";
                break;
            }
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                objectArray = objectArray;
                objectArray[2] = "createSubstitutedCopy";
                break;
            }
            case 11: 
            case 18: {
                break;
            }
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                objectArray = objectArray;
                objectArray[2] = "createDescriptor";
                break;
            }
            case 16: 
            case 17: {
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
            case 11: 
            case 18: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }
}

