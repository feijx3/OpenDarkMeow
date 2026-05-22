/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorWithInitializerImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PropertyDescriptorImpl
extends VariableDescriptorWithInitializerImpl
implements PropertyDescriptor {
    private final Modality modality;
    private DescriptorVisibility visibility;
    private Collection<? extends PropertyDescriptor> overriddenProperties;
    private final PropertyDescriptor original;
    private final CallableMemberDescriptor.Kind kind;
    private final boolean lateInit;
    private final boolean isConst;
    private final boolean isExpect;
    private final boolean isActual;
    private final boolean isExternal;
    private final boolean isDelegated;
    private List<ReceiverParameterDescriptor> contextReceiverParameters;
    private ReceiverParameterDescriptor dispatchReceiverParameter;
    private ReceiverParameterDescriptor extensionReceiverParameter;
    private List<TypeParameterDescriptor> typeParameters;
    private PropertyGetterDescriptorImpl getter;
    private PropertySetterDescriptor setter;
    private boolean setterProjectedOut;
    private FieldDescriptor backingField;
    private FieldDescriptor delegateField;

    protected PropertyDescriptorImpl(@NotNull DeclarationDescriptor containingDeclaration, @Nullable PropertyDescriptor original, @NotNull Annotations annotations, @NotNull Modality modality2, @NotNull DescriptorVisibility visibility2, boolean isVar, @NotNull Name name, @NotNull CallableMemberDescriptor.Kind kind2, @NotNull SourceElement source, boolean lateInit, boolean isConst, boolean isExpect, boolean isActual, boolean isExternal, boolean isDelegated) {
        if (containingDeclaration == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(0);
        }
        if (annotations == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(1);
        }
        if (modality2 == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(2);
        }
        if (visibility2 == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(3);
        }
        if (name == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(4);
        }
        if (kind2 == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(5);
        }
        if (source == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(6);
        }
        super(containingDeclaration, annotations, name, null, isVar, source);
        this.overriddenProperties = null;
        this.contextReceiverParameters = Collections.emptyList();
        this.modality = modality2;
        this.visibility = visibility2;
        this.original = original == null ? this : original;
        this.kind = kind2;
        this.lateInit = lateInit;
        this.isConst = isConst;
        this.isExpect = isExpect;
        this.isActual = isActual;
        this.isExternal = isExternal;
        this.isDelegated = isDelegated;
    }

    @NotNull
    public static PropertyDescriptorImpl create(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations, @NotNull Modality modality2, @NotNull DescriptorVisibility visibility2, boolean isVar, @NotNull Name name, @NotNull CallableMemberDescriptor.Kind kind2, @NotNull SourceElement source, boolean lateInit, boolean isConst, boolean isExpect, boolean isActual, boolean isExternal, boolean isDelegated) {
        if (containingDeclaration == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(7);
        }
        if (annotations == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(8);
        }
        if (modality2 == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(9);
        }
        if (visibility2 == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(10);
        }
        if (name == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(11);
        }
        if (kind2 == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(12);
        }
        if (source == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(13);
        }
        return new PropertyDescriptorImpl(containingDeclaration, null, annotations, modality2, visibility2, isVar, name, kind2, source, lateInit, isConst, isExpect, isActual, isExternal, isDelegated);
    }

    public void setInType(@NotNull KotlinType inType) {
        if (inType == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(14);
        }
    }

    public void setType(@NotNull KotlinType outType, @NotNull List<? extends TypeParameterDescriptor> typeParameters, @Nullable ReceiverParameterDescriptor dispatchReceiverParameter, @Nullable ReceiverParameterDescriptor extensionReceiverParameter, @NotNull List<ReceiverParameterDescriptor> contextReceiverParameters) {
        if (outType == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(17);
        }
        if (typeParameters == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(18);
        }
        if (contextReceiverParameters == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(19);
        }
        this.setOutType(outType);
        this.typeParameters = new ArrayList<TypeParameterDescriptor>(typeParameters);
        this.extensionReceiverParameter = extensionReceiverParameter;
        this.dispatchReceiverParameter = dispatchReceiverParameter;
        this.contextReceiverParameters = contextReceiverParameters;
    }

    public void initialize(@Nullable PropertyGetterDescriptorImpl getter, @Nullable PropertySetterDescriptor setter) {
        this.initialize(getter, setter, null, null);
    }

    public void initialize(@Nullable PropertyGetterDescriptorImpl getter, @Nullable PropertySetterDescriptor setter, @Nullable FieldDescriptor backingField, @Nullable FieldDescriptor delegateField) {
        this.getter = getter;
        this.setter = setter;
        this.backingField = backingField;
        this.delegateField = delegateField;
    }

    public void setSetterProjectedOut(boolean setterProjectedOut) {
        this.setterProjectedOut = setterProjectedOut;
    }

    public void setVisibility(@NotNull DescriptorVisibility visibility2) {
        if (visibility2 == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(20);
        }
        this.visibility = visibility2;
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> parameters = this.typeParameters;
        if (parameters == null) {
            throw new IllegalStateException("typeParameters == null for " + this);
        }
        List<TypeParameterDescriptor> list = parameters;
        if (list == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(21);
        }
        return list;
    }

    @Override
    @NotNull
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> list = this.contextReceiverParameters;
        if (list == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(22);
        }
        return list;
    }

    @Override
    @Nullable
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    @Override
    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    @Override
    @NotNull
    public KotlinType getReturnType() {
        KotlinType kotlinType = this.getType();
        if (kotlinType == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(23);
        }
        return kotlinType;
    }

    @Override
    @NotNull
    public Modality getModality() {
        Modality modality2 = this.modality;
        if (modality2 == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(24);
        }
        return modality2;
    }

    @Override
    @NotNull
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.visibility;
        if (descriptorVisibility == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(25);
        }
        return descriptorVisibility;
    }

    @Override
    @Nullable
    public PropertyGetterDescriptorImpl getGetter() {
        return this.getter;
    }

    @Override
    @Nullable
    public PropertySetterDescriptor getSetter() {
        return this.setter;
    }

    public boolean isSetterProjectedOut() {
        return this.setterProjectedOut;
    }

    @Override
    public boolean isLateInit() {
        return this.lateInit;
    }

    @Override
    public boolean isConst() {
        return this.isConst;
    }

    @Override
    public boolean isExternal() {
        return this.isExternal;
    }

    @Override
    public boolean isDelegated() {
        return this.isDelegated;
    }

    @Override
    @NotNull
    public List<PropertyAccessorDescriptor> getAccessors() {
        ArrayList<PropertyAccessorDescriptor> result = new ArrayList<PropertyAccessorDescriptor>(2);
        if (this.getter != null) {
            result.add(this.getter);
        }
        if (this.setter != null) {
            result.add(this.setter);
        }
        ArrayList<PropertyAccessorDescriptor> arrayList = result;
        if (arrayList == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(26);
        }
        return arrayList;
    }

    @Override
    public PropertyDescriptor substitute(@NotNull TypeSubstitutor originalSubstitutor) {
        if (originalSubstitutor == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(27);
        }
        if (originalSubstitutor.isEmpty()) {
            return this;
        }
        return this.newCopyBuilder().setSubstitution(originalSubstitutor.getSubstitution()).setOriginal(this.getOriginal()).build();
    }

    @NotNull
    public CopyConfiguration newCopyBuilder() {
        return new CopyConfiguration();
    }

    @NotNull
    private SourceElement getSourceToUseForCopy(boolean preserveSource, @Nullable PropertyDescriptor original) {
        SourceElement sourceElement = preserveSource ? (original != null ? original : this.getOriginal()).getSource() : SourceElement.NO_SOURCE;
        if (sourceElement == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(28);
        }
        return sourceElement;
    }

    @Nullable
    protected PropertyDescriptor doSubstitute(@NotNull CopyConfiguration copyConfiguration) {
        PropertySetterDescriptorImpl newSetter;
        PropertyGetterDescriptorImpl newGetter;
        ReceiverParameterDescriptor substitutedDispatchReceiver;
        ReceiverParameterDescriptor dispatchReceiver;
        KotlinType originalOutType;
        if (copyConfiguration == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(29);
        }
        PropertyDescriptorImpl substitutedDescriptor = this.createSubstitutedCopy(copyConfiguration.owner, copyConfiguration.modality, copyConfiguration.visibility, copyConfiguration.original, copyConfiguration.kind, copyConfiguration.name, this.getSourceToUseForCopy(copyConfiguration.preserveSourceElement, copyConfiguration.original));
        List originalTypeParameters = copyConfiguration.newTypeParameters == null ? this.getTypeParameters() : copyConfiguration.newTypeParameters;
        ArrayList<TypeParameterDescriptor> substitutedTypeParameters = new ArrayList<TypeParameterDescriptor>(originalTypeParameters.size());
        TypeSubstitutor substitutor = DescriptorSubstitutor.substituteTypeParameters(originalTypeParameters, copyConfiguration.substitution, substitutedDescriptor, substitutedTypeParameters);
        KotlinType outType = substitutor.substitute(originalOutType = copyConfiguration.returnType, Variance.OUT_VARIANCE);
        if (outType == null) {
            return null;
        }
        KotlinType inType = substitutor.substitute(originalOutType, Variance.IN_VARIANCE);
        if (inType != null) {
            substitutedDescriptor.setInType(inType);
        }
        if ((dispatchReceiver = copyConfiguration.dispatchReceiverParameter) != null) {
            substitutedDispatchReceiver = dispatchReceiver.substitute(substitutor);
            if (substitutedDispatchReceiver == null) {
                return null;
            }
        } else {
            substitutedDispatchReceiver = null;
        }
        ReceiverParameterDescriptor substitutedExtensionReceiver = this.extensionReceiverParameter != null ? PropertyDescriptorImpl.substituteParameterDescriptor(substitutor, substitutedDescriptor, this.extensionReceiverParameter) : null;
        ArrayList<ReceiverParameterDescriptor> substitutedContextReceivers = new ArrayList<ReceiverParameterDescriptor>();
        for (ReceiverParameterDescriptor contextReceiverParameter : this.contextReceiverParameters) {
            ReceiverParameterDescriptor substitutedContextReceiver = PropertyDescriptorImpl.substituteContextParameterDescriptor(substitutor, substitutedDescriptor, contextReceiverParameter);
            if (substitutedContextReceiver == null) continue;
            substitutedContextReceivers.add(substitutedContextReceiver);
        }
        substitutedDescriptor.setType(outType, substitutedTypeParameters, substitutedDispatchReceiver, substitutedExtensionReceiver, substitutedContextReceivers);
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = newGetter = this.getter == null ? null : new PropertyGetterDescriptorImpl(substitutedDescriptor, this.getter.getAnnotations(), copyConfiguration.modality, PropertyDescriptorImpl.normalizeVisibility(this.getter.getVisibility(), copyConfiguration.kind), this.getter.isDefault(), this.getter.isExternal(), this.getter.isInline(), copyConfiguration.kind, copyConfiguration.getOriginalGetter(), SourceElement.NO_SOURCE);
        if (newGetter != null) {
            KotlinType returnType = this.getter.getReturnType();
            newGetter.setInitialSignatureDescriptor(PropertyDescriptorImpl.getSubstitutedInitialSignatureDescriptor(substitutor, this.getter));
            newGetter.initialize(returnType != null ? substitutor.substitute(returnType, Variance.OUT_VARIANCE) : null);
        }
        PropertySetterDescriptorImpl propertySetterDescriptorImpl = newSetter = this.setter == null ? null : new PropertySetterDescriptorImpl(substitutedDescriptor, this.setter.getAnnotations(), copyConfiguration.modality, PropertyDescriptorImpl.normalizeVisibility(this.setter.getVisibility(), copyConfiguration.kind), this.setter.isDefault(), this.setter.isExternal(), this.setter.isInline(), copyConfiguration.kind, copyConfiguration.getOriginalSetter(), SourceElement.NO_SOURCE);
        if (newSetter != null) {
            List<ValueParameterDescriptor> substitutedValueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(newSetter, this.setter.getValueParameters(), substitutor, false, false, null);
            if (substitutedValueParameters == null) {
                substitutedDescriptor.setSetterProjectedOut(true);
                substitutedValueParameters = Collections.singletonList(PropertySetterDescriptorImpl.createSetterParameter(newSetter, DescriptorUtilsKt.getBuiltIns(copyConfiguration.owner).getNothingType(), this.setter.getValueParameters().get(0).getAnnotations()));
            }
            if (substitutedValueParameters.size() != 1) {
                throw new IllegalStateException();
            }
            newSetter.setInitialSignatureDescriptor(PropertyDescriptorImpl.getSubstitutedInitialSignatureDescriptor(substitutor, this.setter));
            newSetter.initialize(substitutedValueParameters.get(0));
        }
        substitutedDescriptor.initialize(newGetter, newSetter, this.backingField == null ? null : new FieldDescriptorImpl(this.backingField.getAnnotations(), substitutedDescriptor), this.delegateField == null ? null : new FieldDescriptorImpl(this.delegateField.getAnnotations(), substitutedDescriptor));
        if (copyConfiguration.copyOverrides) {
            SmartSet overridden = SmartSet.create();
            for (PropertyDescriptor propertyDescriptor : this.getOverriddenDescriptors()) {
                overridden.add(propertyDescriptor.substitute(substitutor));
            }
            substitutedDescriptor.setOverriddenDescriptors(overridden);
        }
        if (this.isConst() && this.compileTimeInitializerFactory != null) {
            substitutedDescriptor.setCompileTimeInitializer(this.compileTimeInitializer, this.compileTimeInitializerFactory);
        }
        return substitutedDescriptor;
    }

    private static DescriptorVisibility normalizeVisibility(DescriptorVisibility prev, CallableMemberDescriptor.Kind kind2) {
        if (kind2 == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && DescriptorVisibilities.isPrivate(prev.normalize())) {
            return DescriptorVisibilities.INVISIBLE_FAKE;
        }
        return prev;
    }

    private static ReceiverParameterDescriptor substituteParameterDescriptor(TypeSubstitutor substitutor, PropertyDescriptor substitutedPropertyDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor) {
        KotlinType substitutedType = substitutor.substitute(receiverParameterDescriptor.getType(), Variance.IN_VARIANCE);
        if (substitutedType == null) {
            return null;
        }
        return new ReceiverParameterDescriptorImpl(substitutedPropertyDescriptor, new ExtensionReceiver(substitutedPropertyDescriptor, substitutedType, receiverParameterDescriptor.getValue()), receiverParameterDescriptor.getAnnotations());
    }

    private static ReceiverParameterDescriptor substituteContextParameterDescriptor(TypeSubstitutor substitutor, PropertyDescriptor substitutedPropertyDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor) {
        KotlinType substitutedType = substitutor.substitute(receiverParameterDescriptor.getType(), Variance.IN_VARIANCE);
        if (substitutedType == null) {
            return null;
        }
        return new ReceiverParameterDescriptorImpl(substitutedPropertyDescriptor, new ContextReceiver(substitutedPropertyDescriptor, substitutedType, ((ImplicitContextReceiver)receiverParameterDescriptor.getValue()).getCustomLabelName(), receiverParameterDescriptor.getValue()), receiverParameterDescriptor.getAnnotations());
    }

    private static FunctionDescriptor getSubstitutedInitialSignatureDescriptor(@NotNull TypeSubstitutor substitutor, @NotNull PropertyAccessorDescriptor accessorDescriptor) {
        if (substitutor == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(30);
        }
        if (accessorDescriptor == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(31);
        }
        return accessorDescriptor.getInitialSignatureDescriptor() != null ? accessorDescriptor.getInitialSignatureDescriptor().substitute(substitutor) : null;
    }

    @NotNull
    protected PropertyDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @NotNull Modality newModality, @NotNull DescriptorVisibility newVisibility, @Nullable PropertyDescriptor original, @NotNull CallableMemberDescriptor.Kind kind2, @NotNull Name newName, @NotNull SourceElement source) {
        if (newOwner == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(32);
        }
        if (newModality == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(33);
        }
        if (newVisibility == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(34);
        }
        if (kind2 == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(35);
        }
        if (newName == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(36);
        }
        if (source == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(37);
        }
        return new PropertyDescriptorImpl(newOwner, original, this.getAnnotations(), newModality, newVisibility, this.isVar(), newName, kind2, source, this.isLateInit(), this.isConst(), this.isExpect(), this.isActual(), this.isExternal(), this.isDelegated());
    }

    @Override
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor2, D data) {
        return visitor2.visitPropertyDescriptor(this, data);
    }

    @Override
    @NotNull
    public PropertyDescriptor getOriginal() {
        PropertyDescriptor propertyDescriptor = this.original == this ? this : this.original.getOriginal();
        if (propertyDescriptor == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(38);
        }
        return propertyDescriptor;
    }

    @Override
    @NotNull
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind2 = this.kind;
        if (kind2 == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(39);
        }
        return kind2;
    }

    @Override
    public boolean isExpect() {
        return this.isExpect;
    }

    @Override
    public boolean isActual() {
        return this.isActual;
    }

    @Override
    @Nullable
    public FieldDescriptor getBackingField() {
        return this.backingField;
    }

    @Override
    @Nullable
    public FieldDescriptor getDelegateField() {
        return this.delegateField;
    }

    @Override
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> overriddenDescriptors) {
        if (overriddenDescriptors == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(40);
        }
        this.overriddenProperties = overriddenDescriptors;
    }

    @Override
    @NotNull
    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        Collection<Object> collection = this.overriddenProperties != null ? this.overriddenProperties : Collections.emptyList();
        if (collection == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(41);
        }
        return collection;
    }

    @Override
    @NotNull
    public PropertyDescriptor copy(DeclarationDescriptor newOwner, Modality modality2, DescriptorVisibility visibility2, CallableMemberDescriptor.Kind kind2, boolean copyOverrides) {
        PropertyDescriptor propertyDescriptor = this.newCopyBuilder().setOwner(newOwner).setOriginal(null).setModality(modality2).setVisibility(visibility2).setKind(kind2).setCopyOverrides(copyOverrides).build();
        if (propertyDescriptor == null) {
            PropertyDescriptorImpl.$$$reportNull$$$0(42);
        }
        return propertyDescriptor;
    }

    @Override
    @Nullable
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> key) {
        return null;
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
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 28: 
            case 38: 
            case 39: 
            case 41: 
            case 42: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n2) {
            default: {
                n3 = 3;
                break;
            }
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 28: 
            case 38: 
            case 39: 
            case 41: 
            case 42: {
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
            case 8: {
                objectArray2 = objectArray3;
                objectArray3[0] = "annotations";
                break;
            }
            case 2: 
            case 9: {
                objectArray2 = objectArray3;
                objectArray3[0] = "modality";
                break;
            }
            case 3: 
            case 10: 
            case 20: {
                objectArray2 = objectArray3;
                objectArray3[0] = "visibility";
                break;
            }
            case 4: 
            case 11: {
                objectArray2 = objectArray3;
                objectArray3[0] = "name";
                break;
            }
            case 5: 
            case 12: 
            case 35: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kind";
                break;
            }
            case 6: 
            case 13: 
            case 37: {
                objectArray2 = objectArray3;
                objectArray3[0] = "source";
                break;
            }
            case 14: {
                objectArray2 = objectArray3;
                objectArray3[0] = "inType";
                break;
            }
            case 15: 
            case 17: {
                objectArray2 = objectArray3;
                objectArray3[0] = "outType";
                break;
            }
            case 16: 
            case 18: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeParameters";
                break;
            }
            case 19: {
                objectArray2 = objectArray3;
                objectArray3[0] = "contextReceiverParameters";
                break;
            }
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 28: 
            case 38: 
            case 39: 
            case 41: 
            case 42: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                break;
            }
            case 27: {
                objectArray2 = objectArray3;
                objectArray3[0] = "originalSubstitutor";
                break;
            }
            case 29: {
                objectArray2 = objectArray3;
                objectArray3[0] = "copyConfiguration";
                break;
            }
            case 30: {
                objectArray2 = objectArray3;
                objectArray3[0] = "substitutor";
                break;
            }
            case 31: {
                objectArray2 = objectArray3;
                objectArray3[0] = "accessorDescriptor";
                break;
            }
            case 32: {
                objectArray2 = objectArray3;
                objectArray3[0] = "newOwner";
                break;
            }
            case 33: {
                objectArray2 = objectArray3;
                objectArray3[0] = "newModality";
                break;
            }
            case 34: {
                objectArray2 = objectArray3;
                objectArray3[0] = "newVisibility";
                break;
            }
            case 36: {
                objectArray2 = objectArray3;
                objectArray3[0] = "newName";
                break;
            }
            case 40: {
                objectArray2 = objectArray3;
                objectArray3[0] = "overriddenDescriptors";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                break;
            }
            case 21: {
                objectArray = objectArray2;
                objectArray2[1] = "getTypeParameters";
                break;
            }
            case 22: {
                objectArray = objectArray2;
                objectArray2[1] = "getContextReceiverParameters";
                break;
            }
            case 23: {
                objectArray = objectArray2;
                objectArray2[1] = "getReturnType";
                break;
            }
            case 24: {
                objectArray = objectArray2;
                objectArray2[1] = "getModality";
                break;
            }
            case 25: {
                objectArray = objectArray2;
                objectArray2[1] = "getVisibility";
                break;
            }
            case 26: {
                objectArray = objectArray2;
                objectArray2[1] = "getAccessors";
                break;
            }
            case 28: {
                objectArray = objectArray2;
                objectArray2[1] = "getSourceToUseForCopy";
                break;
            }
            case 38: {
                objectArray = objectArray2;
                objectArray2[1] = "getOriginal";
                break;
            }
            case 39: {
                objectArray = objectArray2;
                objectArray2[1] = "getKind";
                break;
            }
            case 41: {
                objectArray = objectArray2;
                objectArray2[1] = "getOverriddenDescriptors";
                break;
            }
            case 42: {
                objectArray = objectArray2;
                objectArray2[1] = "copy";
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
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: {
                objectArray = objectArray;
                objectArray[2] = "create";
                break;
            }
            case 14: {
                objectArray = objectArray;
                objectArray[2] = "setInType";
                break;
            }
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: {
                objectArray = objectArray;
                objectArray[2] = "setType";
                break;
            }
            case 20: {
                objectArray = objectArray;
                objectArray[2] = "setVisibility";
                break;
            }
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 28: 
            case 38: 
            case 39: 
            case 41: 
            case 42: {
                break;
            }
            case 27: {
                objectArray = objectArray;
                objectArray[2] = "substitute";
                break;
            }
            case 29: {
                objectArray = objectArray;
                objectArray[2] = "doSubstitute";
                break;
            }
            case 30: 
            case 31: {
                objectArray = objectArray;
                objectArray[2] = "getSubstitutedInitialSignatureDescriptor";
                break;
            }
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: {
                objectArray = objectArray;
                objectArray[2] = "createSubstitutedCopy";
                break;
            }
            case 40: {
                objectArray = objectArray;
                objectArray[2] = "setOverriddenDescriptors";
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n2) {
            default: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 28: 
            case 38: 
            case 39: 
            case 41: 
            case 42: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }

    public class CopyConfiguration {
        private DeclarationDescriptor owner;
        private Modality modality;
        private DescriptorVisibility visibility;
        private PropertyDescriptor original;
        private boolean preserveSourceElement;
        private CallableMemberDescriptor.Kind kind;
        private TypeSubstitution substitution;
        private boolean copyOverrides;
        private ReceiverParameterDescriptor dispatchReceiverParameter;
        private List<TypeParameterDescriptor> newTypeParameters;
        private Name name;
        private KotlinType returnType;

        public CopyConfiguration() {
            this.owner = PropertyDescriptorImpl.this.getContainingDeclaration();
            this.modality = PropertyDescriptorImpl.this.getModality();
            this.visibility = PropertyDescriptorImpl.this.getVisibility();
            this.original = null;
            this.preserveSourceElement = false;
            this.kind = PropertyDescriptorImpl.this.getKind();
            this.substitution = TypeSubstitution.EMPTY;
            this.copyOverrides = true;
            this.dispatchReceiverParameter = PropertyDescriptorImpl.this.dispatchReceiverParameter;
            this.newTypeParameters = null;
            this.name = PropertyDescriptorImpl.this.getName();
            this.returnType = PropertyDescriptorImpl.this.getType();
        }

        @NotNull
        public CopyConfiguration setOwner(@NotNull DeclarationDescriptor owner) {
            if (owner == null) {
                CopyConfiguration.$$$reportNull$$$0(0);
            }
            this.owner = owner;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(1);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setOriginal(@Nullable CallableMemberDescriptor original) {
            this.original = (PropertyDescriptor)original;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(2);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setModality(@NotNull Modality modality2) {
            if (modality2 == null) {
                CopyConfiguration.$$$reportNull$$$0(6);
            }
            this.modality = modality2;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(7);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setVisibility(@NotNull DescriptorVisibility visibility2) {
            if (visibility2 == null) {
                CopyConfiguration.$$$reportNull$$$0(8);
            }
            this.visibility = visibility2;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(9);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setKind(@NotNull CallableMemberDescriptor.Kind kind2) {
            if (kind2 == null) {
                CopyConfiguration.$$$reportNull$$$0(10);
            }
            this.kind = kind2;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(11);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setSubstitution(@NotNull TypeSubstitution substitution) {
            if (substitution == null) {
                CopyConfiguration.$$$reportNull$$$0(15);
            }
            this.substitution = substitution;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(16);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setCopyOverrides(boolean copyOverrides) {
            this.copyOverrides = copyOverrides;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(17);
            }
            return copyConfiguration;
        }

        @Nullable
        public PropertyDescriptor build() {
            return PropertyDescriptorImpl.this.doSubstitute(this);
        }

        PropertyGetterDescriptor getOriginalGetter() {
            if (this.original == null) {
                return null;
            }
            return this.original.getGetter();
        }

        PropertySetterDescriptor getOriginalSetter() {
            if (this.original == null) {
                return null;
            }
            return this.original.getSetter();
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
                case 1: 
                case 2: 
                case 3: 
                case 5: 
                case 7: 
                case 9: 
                case 11: 
                case 13: 
                case 14: 
                case 16: 
                case 17: 
                case 19: {
                    string = "@NotNull method %s.%s must not return null";
                    break;
                }
            }
            switch (n2) {
                default: {
                    n3 = 3;
                    break;
                }
                case 1: 
                case 2: 
                case 3: 
                case 5: 
                case 7: 
                case 9: 
                case 11: 
                case 13: 
                case 14: 
                case 16: 
                case 17: 
                case 19: {
                    n3 = 2;
                    break;
                }
            }
            Object[] objectArray3 = new Object[n3];
            switch (n2) {
                default: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "owner";
                    break;
                }
                case 1: 
                case 2: 
                case 3: 
                case 5: 
                case 7: 
                case 9: 
                case 11: 
                case 13: 
                case 14: 
                case 16: 
                case 17: 
                case 19: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                }
                case 4: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "type";
                    break;
                }
                case 6: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "modality";
                    break;
                }
                case 8: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "visibility";
                    break;
                }
                case 10: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "kind";
                    break;
                }
                case 12: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "typeParameters";
                    break;
                }
                case 15: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "substitution";
                    break;
                }
                case 18: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "name";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                }
                case 1: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setOwner";
                    break;
                }
                case 2: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setOriginal";
                    break;
                }
                case 3: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setPreserveSourceElement";
                    break;
                }
                case 5: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setReturnType";
                    break;
                }
                case 7: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setModality";
                    break;
                }
                case 9: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setVisibility";
                    break;
                }
                case 11: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setKind";
                    break;
                }
                case 13: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setTypeParameters";
                    break;
                }
                case 14: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setDispatchReceiverParameter";
                    break;
                }
                case 16: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setSubstitution";
                    break;
                }
                case 17: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setCopyOverrides";
                    break;
                }
                case 19: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setName";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray;
                    objectArray[2] = "setOwner";
                    break;
                }
                case 1: 
                case 2: 
                case 3: 
                case 5: 
                case 7: 
                case 9: 
                case 11: 
                case 13: 
                case 14: 
                case 16: 
                case 17: 
                case 19: {
                    break;
                }
                case 4: {
                    objectArray = objectArray;
                    objectArray[2] = "setReturnType";
                    break;
                }
                case 6: {
                    objectArray = objectArray;
                    objectArray[2] = "setModality";
                    break;
                }
                case 8: {
                    objectArray = objectArray;
                    objectArray[2] = "setVisibility";
                    break;
                }
                case 10: {
                    objectArray = objectArray;
                    objectArray[2] = "setKind";
                    break;
                }
                case 12: {
                    objectArray = objectArray;
                    objectArray[2] = "setTypeParameters";
                    break;
                }
                case 15: {
                    objectArray = objectArray;
                    objectArray[2] = "setSubstitution";
                    break;
                }
                case 18: {
                    objectArray = objectArray;
                    objectArray[2] = "setName";
                    break;
                }
            }
            String string2 = String.format(string, objectArray);
            switch (n2) {
                default: {
                    runtimeException = new IllegalArgumentException(string2);
                    break;
                }
                case 1: 
                case 2: 
                case 3: 
                case 5: 
                case 7: 
                case 9: 
                case 11: 
                case 13: 
                case 14: 
                case 16: 
                case 17: 
                case 19: {
                    runtimeException = new IllegalStateException(string2);
                    break;
                }
            }
            throw runtimeException;
        }
    }
}

