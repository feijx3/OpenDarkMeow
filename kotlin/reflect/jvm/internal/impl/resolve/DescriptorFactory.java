/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collections;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.NameUtils;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.StdlibClassFinder;
import kotlin.reflect.jvm.internal.impl.resolve.StdlibClassFinderKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DescriptorFactory {
    @NotNull
    public static PropertySetterDescriptorImpl createDefaultSetter(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, @NotNull Annotations parameterAnnotations) {
        if (propertyDescriptor == null) {
            DescriptorFactory.$$$reportNull$$$0(0);
        }
        if (annotations == null) {
            DescriptorFactory.$$$reportNull$$$0(1);
        }
        if (parameterAnnotations == null) {
            DescriptorFactory.$$$reportNull$$$0(2);
        }
        return DescriptorFactory.createSetter(propertyDescriptor, annotations, parameterAnnotations, true, false, false, propertyDescriptor.getSource());
    }

    @NotNull
    public static PropertySetterDescriptorImpl createSetter(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, @NotNull Annotations parameterAnnotations, boolean isDefault, boolean isExternal, boolean isInline, @NotNull SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            DescriptorFactory.$$$reportNull$$$0(3);
        }
        if (annotations == null) {
            DescriptorFactory.$$$reportNull$$$0(4);
        }
        if (parameterAnnotations == null) {
            DescriptorFactory.$$$reportNull$$$0(5);
        }
        if (sourceElement == null) {
            DescriptorFactory.$$$reportNull$$$0(6);
        }
        return DescriptorFactory.createSetter(propertyDescriptor, annotations, parameterAnnotations, isDefault, isExternal, isInline, propertyDescriptor.getVisibility(), sourceElement);
    }

    @NotNull
    public static PropertySetterDescriptorImpl createSetter(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, @NotNull Annotations parameterAnnotations, boolean isDefault, boolean isExternal, boolean isInline, @NotNull DescriptorVisibility visibility2, @NotNull SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            DescriptorFactory.$$$reportNull$$$0(7);
        }
        if (annotations == null) {
            DescriptorFactory.$$$reportNull$$$0(8);
        }
        if (parameterAnnotations == null) {
            DescriptorFactory.$$$reportNull$$$0(9);
        }
        if (visibility2 == null) {
            DescriptorFactory.$$$reportNull$$$0(10);
        }
        if (sourceElement == null) {
            DescriptorFactory.$$$reportNull$$$0(11);
        }
        PropertySetterDescriptorImpl setterDescriptor = new PropertySetterDescriptorImpl(propertyDescriptor, annotations, propertyDescriptor.getModality(), visibility2, isDefault, isExternal, isInline, CallableMemberDescriptor.Kind.DECLARATION, null, sourceElement);
        ValueParameterDescriptorImpl parameter = PropertySetterDescriptorImpl.createSetterParameter(setterDescriptor, propertyDescriptor.getType(), parameterAnnotations);
        setterDescriptor.initialize(parameter);
        PropertySetterDescriptorImpl propertySetterDescriptorImpl = setterDescriptor;
        if (propertySetterDescriptorImpl == null) {
            DescriptorFactory.$$$reportNull$$$0(12);
        }
        return propertySetterDescriptorImpl;
    }

    @NotNull
    public static PropertyGetterDescriptorImpl createDefaultGetter(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations) {
        if (propertyDescriptor == null) {
            DescriptorFactory.$$$reportNull$$$0(13);
        }
        if (annotations == null) {
            DescriptorFactory.$$$reportNull$$$0(14);
        }
        return DescriptorFactory.createGetter(propertyDescriptor, annotations, true, false, false);
    }

    @NotNull
    public static PropertyGetterDescriptorImpl createGetter(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, boolean isDefault, boolean isExternal, boolean isInline) {
        if (propertyDescriptor == null) {
            DescriptorFactory.$$$reportNull$$$0(15);
        }
        if (annotations == null) {
            DescriptorFactory.$$$reportNull$$$0(16);
        }
        return DescriptorFactory.createGetter(propertyDescriptor, annotations, isDefault, isExternal, isInline, propertyDescriptor.getSource());
    }

    @NotNull
    public static PropertyGetterDescriptorImpl createGetter(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, boolean isDefault, boolean isExternal, boolean isInline, @NotNull SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            DescriptorFactory.$$$reportNull$$$0(17);
        }
        if (annotations == null) {
            DescriptorFactory.$$$reportNull$$$0(18);
        }
        if (sourceElement == null) {
            DescriptorFactory.$$$reportNull$$$0(19);
        }
        return new PropertyGetterDescriptorImpl(propertyDescriptor, annotations, propertyDescriptor.getModality(), propertyDescriptor.getVisibility(), isDefault, isExternal, isInline, CallableMemberDescriptor.Kind.DECLARATION, null, sourceElement);
    }

    @NotNull
    public static ClassConstructorDescriptorImpl createPrimaryConstructorForObject(@NotNull ClassDescriptor containingClass, @NotNull SourceElement source) {
        if (containingClass == null) {
            DescriptorFactory.$$$reportNull$$$0(20);
        }
        if (source == null) {
            DescriptorFactory.$$$reportNull$$$0(21);
        }
        return new DefaultClassConstructorDescriptor(containingClass, source, false);
    }

    @NotNull
    public static SimpleFunctionDescriptor createEnumValuesMethod(@NotNull ClassDescriptor enumClass) {
        if (enumClass == null) {
            DescriptorFactory.$$$reportNull$$$0(22);
        }
        SimpleFunctionDescriptorImpl values = SimpleFunctionDescriptorImpl.create(enumClass, Annotations.Companion.getEMPTY(), StandardNames.ENUM_VALUES, CallableMemberDescriptor.Kind.SYNTHESIZED, enumClass.getSource());
        FunctionDescriptorImpl functionDescriptorImpl = values.initialize((ReceiverParameterDescriptor)null, (ReceiverParameterDescriptor)null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (KotlinType)DescriptorUtilsKt.getBuiltIns(enumClass).getArrayType(Variance.INVARIANT, enumClass.getDefaultType()), Modality.FINAL, DescriptorVisibilities.PUBLIC);
        if (functionDescriptorImpl == null) {
            DescriptorFactory.$$$reportNull$$$0(23);
        }
        return functionDescriptorImpl;
    }

    @NotNull
    public static SimpleFunctionDescriptor createEnumValueOfMethod(@NotNull ClassDescriptor enumClass) {
        if (enumClass == null) {
            DescriptorFactory.$$$reportNull$$$0(24);
        }
        SimpleFunctionDescriptorImpl valueOf = SimpleFunctionDescriptorImpl.create(enumClass, Annotations.Companion.getEMPTY(), StandardNames.ENUM_VALUE_OF, CallableMemberDescriptor.Kind.SYNTHESIZED, enumClass.getSource());
        ValueParameterDescriptorImpl parameterDescriptor = new ValueParameterDescriptorImpl(valueOf, null, 0, Annotations.Companion.getEMPTY(), Name.identifier("value"), DescriptorUtilsKt.getBuiltIns(enumClass).getStringType(), false, false, false, null, enumClass.getSource());
        FunctionDescriptorImpl functionDescriptorImpl = valueOf.initialize((ReceiverParameterDescriptor)null, (ReceiverParameterDescriptor)null, Collections.emptyList(), Collections.emptyList(), Collections.singletonList(parameterDescriptor), (KotlinType)enumClass.getDefaultType(), Modality.FINAL, DescriptorVisibilities.PUBLIC);
        if (functionDescriptorImpl == null) {
            DescriptorFactory.$$$reportNull$$$0(25);
        }
        return functionDescriptorImpl;
    }

    @Nullable
    public static PropertyDescriptor createEnumEntriesProperty(@NotNull ClassDescriptor enumClass) {
        ModuleDescriptor module;
        StdlibClassFinder stdlibClassFinder;
        ClassDescriptor enumEntriesClass;
        if (enumClass == null) {
            DescriptorFactory.$$$reportNull$$$0(26);
        }
        if ((enumEntriesClass = (stdlibClassFinder = StdlibClassFinderKt.getStdlibClassFinder(module = DescriptorUtils.getContainingModule(enumClass))).findEnumEntriesClass(module)) == null) {
            return null;
        }
        PropertyDescriptorImpl entries = PropertyDescriptorImpl.create(enumClass, Annotations.Companion.getEMPTY(), Modality.FINAL, DescriptorVisibilities.PUBLIC, false, StandardNames.ENUM_ENTRIES, CallableMemberDescriptor.Kind.SYNTHESIZED, enumClass.getSource(), false, false, false, false, false, false);
        PropertyGetterDescriptorImpl getter = new PropertyGetterDescriptorImpl(entries, Annotations.Companion.getEMPTY(), Modality.FINAL, DescriptorVisibilities.PUBLIC, false, false, false, CallableMemberDescriptor.Kind.SYNTHESIZED, null, enumClass.getSource());
        entries.initialize(getter, null);
        entries.setType(KotlinTypeFactory.simpleType(TypeAttributes.Companion.getEmpty(), enumEntriesClass.getTypeConstructor(), Collections.singletonList(new TypeProjectionImpl(enumClass.getDefaultType())), false), Collections.emptyList(), null, null, Collections.<ReceiverParameterDescriptor>emptyList());
        getter.initialize(entries.getReturnType());
        return entries;
    }

    public static boolean isEnumValuesMethod(@NotNull FunctionDescriptor descriptor2) {
        if (descriptor2 == null) {
            DescriptorFactory.$$$reportNull$$$0(27);
        }
        return descriptor2.getName().equals(StandardNames.ENUM_VALUES) && DescriptorFactory.isEnumSpecialMethod(descriptor2);
    }

    public static boolean isEnumValueOfMethod(@NotNull FunctionDescriptor descriptor2) {
        if (descriptor2 == null) {
            DescriptorFactory.$$$reportNull$$$0(28);
        }
        return descriptor2.getName().equals(StandardNames.ENUM_VALUE_OF) && DescriptorFactory.isEnumSpecialMethod(descriptor2);
    }

    private static boolean isEnumSpecialMethod(@NotNull FunctionDescriptor descriptor2) {
        if (descriptor2 == null) {
            DescriptorFactory.$$$reportNull$$$0(29);
        }
        return descriptor2.getKind() == CallableMemberDescriptor.Kind.SYNTHESIZED && DescriptorUtils.isEnumClass(descriptor2.getContainingDeclaration());
    }

    @Nullable
    public static ReceiverParameterDescriptor createExtensionReceiverParameterForCallable(@NotNull CallableDescriptor owner, @Nullable KotlinType receiverParameterType, @NotNull Annotations annotations) {
        if (owner == null) {
            DescriptorFactory.$$$reportNull$$$0(30);
        }
        if (annotations == null) {
            DescriptorFactory.$$$reportNull$$$0(31);
        }
        return receiverParameterType == null ? null : new ReceiverParameterDescriptorImpl(owner, new ExtensionReceiver(owner, receiverParameterType, null), annotations);
    }

    @Nullable
    public static ReceiverParameterDescriptor createContextReceiverParameterForCallable(@NotNull CallableDescriptor owner, @Nullable KotlinType receiverParameterType, @Nullable Name customLabelName, @NotNull Annotations annotations, int index) {
        if (owner == null) {
            DescriptorFactory.$$$reportNull$$$0(32);
        }
        if (annotations == null) {
            DescriptorFactory.$$$reportNull$$$0(33);
        }
        return receiverParameterType == null ? null : new ReceiverParameterDescriptorImpl(owner, new ContextReceiver(owner, receiverParameterType, customLabelName, null), annotations, NameUtils.contextReceiverName(index));
    }

    @Nullable
    public static ReceiverParameterDescriptor createContextReceiverParameterForClass(@NotNull ClassDescriptor owner, @Nullable KotlinType receiverParameterType, @Nullable Name customLabelName, @NotNull Annotations annotations, int index) {
        if (owner == null) {
            DescriptorFactory.$$$reportNull$$$0(34);
        }
        if (annotations == null) {
            DescriptorFactory.$$$reportNull$$$0(35);
        }
        return receiverParameterType == null ? null : new ReceiverParameterDescriptorImpl(owner, new ContextClassReceiver(owner, receiverParameterType, customLabelName, null), annotations, NameUtils.contextReceiverName(index));
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
            case 12: 
            case 23: 
            case 25: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n2) {
            default: {
                n3 = 3;
                break;
            }
            case 12: 
            case 23: 
            case 25: {
                n3 = 2;
                break;
            }
        }
        Object[] objectArray3 = new Object[n3];
        switch (n2) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "propertyDescriptor";
                break;
            }
            case 1: 
            case 4: 
            case 8: 
            case 14: 
            case 16: 
            case 18: 
            case 31: 
            case 33: 
            case 35: {
                objectArray2 = objectArray3;
                objectArray3[0] = "annotations";
                break;
            }
            case 2: 
            case 5: 
            case 9: {
                objectArray2 = objectArray3;
                objectArray3[0] = "parameterAnnotations";
                break;
            }
            case 6: 
            case 11: 
            case 19: {
                objectArray2 = objectArray3;
                objectArray3[0] = "sourceElement";
                break;
            }
            case 10: {
                objectArray2 = objectArray3;
                objectArray3[0] = "visibility";
                break;
            }
            case 12: 
            case 23: 
            case 25: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            }
            case 20: {
                objectArray2 = objectArray3;
                objectArray3[0] = "containingClass";
                break;
            }
            case 21: {
                objectArray2 = objectArray3;
                objectArray3[0] = "source";
                break;
            }
            case 22: 
            case 24: 
            case 26: {
                objectArray2 = objectArray3;
                objectArray3[0] = "enumClass";
                break;
            }
            case 27: 
            case 28: 
            case 29: {
                objectArray2 = objectArray3;
                objectArray3[0] = "descriptor";
                break;
            }
            case 30: 
            case 32: 
            case 34: {
                objectArray2 = objectArray3;
                objectArray3[0] = "owner";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            }
            case 12: {
                objectArray = objectArray2;
                objectArray2[1] = "createSetter";
                break;
            }
            case 23: {
                objectArray = objectArray2;
                objectArray2[1] = "createEnumValuesMethod";
                break;
            }
            case 25: {
                objectArray = objectArray2;
                objectArray2[1] = "createEnumValueOfMethod";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray;
                objectArray[2] = "createDefaultSetter";
                break;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                objectArray = objectArray;
                objectArray[2] = "createSetter";
                break;
            }
            case 12: 
            case 23: 
            case 25: {
                break;
            }
            case 13: 
            case 14: {
                objectArray = objectArray;
                objectArray[2] = "createDefaultGetter";
                break;
            }
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: {
                objectArray = objectArray;
                objectArray[2] = "createGetter";
                break;
            }
            case 20: 
            case 21: {
                objectArray = objectArray;
                objectArray[2] = "createPrimaryConstructorForObject";
                break;
            }
            case 22: {
                objectArray = objectArray;
                objectArray[2] = "createEnumValuesMethod";
                break;
            }
            case 24: {
                objectArray = objectArray;
                objectArray[2] = "createEnumValueOfMethod";
                break;
            }
            case 26: {
                objectArray = objectArray;
                objectArray[2] = "createEnumEntriesProperty";
                break;
            }
            case 27: {
                objectArray = objectArray;
                objectArray[2] = "isEnumValuesMethod";
                break;
            }
            case 28: {
                objectArray = objectArray;
                objectArray[2] = "isEnumValueOfMethod";
                break;
            }
            case 29: {
                objectArray = objectArray;
                objectArray[2] = "isEnumSpecialMethod";
                break;
            }
            case 30: 
            case 31: {
                objectArray = objectArray;
                objectArray[2] = "createExtensionReceiverParameterForCallable";
                break;
            }
            case 32: 
            case 33: {
                objectArray = objectArray;
                objectArray[2] = "createContextReceiverParameterForCallable";
                break;
            }
            case 34: 
            case 35: {
                objectArray = objectArray;
                objectArray[2] = "createContextReceiverParameterForClass";
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n2) {
            default: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
            case 12: 
            case 23: 
            case 25: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }

    private static class DefaultClassConstructorDescriptor
    extends ClassConstructorDescriptorImpl {
        public DefaultClassConstructorDescriptor(@NotNull ClassDescriptor containingClass, @NotNull SourceElement source, boolean freedomForSealedInterfacesSupported) {
            if (containingClass == null) {
                DefaultClassConstructorDescriptor.$$$reportNull$$$0(0);
            }
            if (source == null) {
                DefaultClassConstructorDescriptor.$$$reportNull$$$0(1);
            }
            super(containingClass, null, Annotations.Companion.getEMPTY(), true, CallableMemberDescriptor.Kind.DECLARATION, source);
            this.initialize(Collections.<ValueParameterDescriptor>emptyList(), DescriptorUtils.getDefaultConstructorVisibility(containingClass, freedomForSealedInterfacesSupported));
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            Object[] objectArray;
            Object[] objectArray2 = new Object[3];
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[0] = "containingClass";
                    break;
                }
                case 1: {
                    objectArray = objectArray2;
                    objectArray2[0] = "source";
                    break;
                }
            }
            objectArray[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objectArray[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
        }
    }
}

