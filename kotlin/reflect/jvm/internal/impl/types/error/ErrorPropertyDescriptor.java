/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
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
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ErrorPropertyDescriptor
implements PropertyDescriptor {
    private final /* synthetic */ PropertyDescriptorImpl $$delegate_0;

    /*
     * WARNING - void declaration
     */
    public ErrorPropertyDescriptor() {
        void $this$__delegate_0_u24lambda_u240;
        PropertyDescriptorImpl propertyDescriptorImpl;
        PropertyDescriptorImpl propertyDescriptorImpl2 = propertyDescriptorImpl = PropertyDescriptorImpl.create(ErrorUtils.INSTANCE.getErrorClass(), Annotations.Companion.getEMPTY(), Modality.OPEN, DescriptorVisibilities.PUBLIC, true, Name.special(ErrorEntity.ERROR_PROPERTY.getDebugText()), CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE, false, false, false, false, false, false);
        ErrorPropertyDescriptor errorPropertyDescriptor = this;
        boolean bl2 = false;
        $this$__delegate_0_u24lambda_u240.setType(ErrorUtils.INSTANCE.getErrorPropertyType(), CollectionsKt.emptyList(), null, null, CollectionsKt.<ReceiverParameterDescriptor>emptyList());
        errorPropertyDescriptor.$$delegate_0 = propertyDescriptorImpl;
    }

    @Override
    @NotNull
    public List<PropertyAccessorDescriptor> getAccessors() {
        List<PropertyAccessorDescriptor> list = this.$$delegate_0.getAccessors();
        Intrinsics.checkNotNullExpressionValue(list, "getAccessors(...)");
        return list;
    }

    @Override
    @NotNull
    public PropertyDescriptor getOriginal() {
        PropertyDescriptor propertyDescriptor = this.$$delegate_0.getOriginal();
        Intrinsics.checkNotNullExpressionValue(propertyDescriptor, "getOriginal(...)");
        return propertyDescriptor;
    }

    @Override
    @NotNull
    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        Collection<? extends PropertyDescriptor> collection = this.$$delegate_0.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(collection, "getOverriddenDescriptors(...)");
        return collection;
    }

    @Override
    @Nullable
    public FieldDescriptor getBackingField() {
        return this.$$delegate_0.getBackingField();
    }

    @Override
    @Nullable
    public FieldDescriptor getDelegateField() {
        return this.$$delegate_0.getDelegateField();
    }

    @Override
    public PropertyDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
        Intrinsics.checkNotNullParameter(substitutor, "substitutor");
        return this.$$delegate_0.substitute(substitutor);
    }

    @Override
    @Nullable
    public PropertyGetterDescriptor getGetter() {
        return this.$$delegate_0.getGetter();
    }

    @Override
    @Nullable
    public PropertySetterDescriptor getSetter() {
        return this.$$delegate_0.getSetter();
    }

    @Override
    public boolean isDelegated() {
        return this.$$delegate_0.isDelegated();
    }

    @Override
    public boolean isVar() {
        return this.$$delegate_0.isVar();
    }

    @Override
    @Nullable
    public ConstantValue<?> getCompileTimeInitializer() {
        return this.$$delegate_0.getCompileTimeInitializer();
    }

    @Override
    public boolean isConst() {
        return this.$$delegate_0.isConst();
    }

    @Override
    public boolean isLateInit() {
        return this.$$delegate_0.isLateInit();
    }

    @Override
    @NotNull
    public KotlinType getType() {
        KotlinType kotlinType = this.$$delegate_0.getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        return kotlinType;
    }

    @Override
    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.$$delegate_0.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(declarationDescriptor, "getContainingDeclaration(...)");
        return declarationDescriptor;
    }

    @Override
    @NotNull
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> list = this.$$delegate_0.getContextReceiverParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getContextReceiverParameters(...)");
        return list;
    }

    @Override
    @Nullable
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.$$delegate_0.getExtensionReceiverParameter();
    }

    @Override
    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.$$delegate_0.getDispatchReceiverParameter();
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.$$delegate_0.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getTypeParameters(...)");
        return list;
    }

    @Override
    @Nullable
    public KotlinType getReturnType() {
        return this.$$delegate_0.getReturnType();
    }

    @Override
    @NotNull
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> list = this.$$delegate_0.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
        return list;
    }

    @Override
    public boolean hasSynthesizedParameterNames() {
        return this.$$delegate_0.hasSynthesizedParameterNames();
    }

    @Override
    @Nullable
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> key) {
        return this.$$delegate_0.getUserData(key);
    }

    @Override
    @NotNull
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.$$delegate_0.getVisibility();
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "getVisibility(...)");
        return descriptorVisibility;
    }

    @Override
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor2, D data) {
        return this.$$delegate_0.accept(visitor2, data);
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        Annotations annotations = this.$$delegate_0.getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations, "<get-annotations>(...)");
        return annotations;
    }

    @Override
    @NotNull
    public Name getName() {
        Name name = this.$$delegate_0.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    @Override
    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = this.$$delegate_0.getSource();
        Intrinsics.checkNotNullExpressionValue(sourceElement, "getSource(...)");
        return sourceElement;
    }

    @Override
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> overriddenDescriptors) {
        Intrinsics.checkNotNullParameter(overriddenDescriptors, "overriddenDescriptors");
        this.$$delegate_0.setOverriddenDescriptors(overriddenDescriptors);
    }

    @Override
    @NotNull
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind2 = this.$$delegate_0.getKind();
        Intrinsics.checkNotNullExpressionValue((Object)kind2, "getKind(...)");
        return kind2;
    }

    @Override
    @NotNull
    public CallableMemberDescriptor copy(DeclarationDescriptor newOwner, Modality modality2, DescriptorVisibility visibility2, CallableMemberDescriptor.Kind kind2, boolean copyOverrides) {
        PropertyDescriptor propertyDescriptor = this.$$delegate_0.copy(newOwner, modality2, visibility2, kind2, copyOverrides);
        Intrinsics.checkNotNullExpressionValue(propertyDescriptor, "copy(...)");
        return propertyDescriptor;
    }

    @Override
    @NotNull
    public Modality getModality() {
        Modality modality2 = this.$$delegate_0.getModality();
        Intrinsics.checkNotNullExpressionValue((Object)modality2, "getModality(...)");
        return modality2;
    }

    @Override
    public boolean isExpect() {
        return this.$$delegate_0.isExpect();
    }

    @Override
    public boolean isActual() {
        return this.$$delegate_0.isActual();
    }

    @Override
    public boolean isExternal() {
        return this.$$delegate_0.isExternal();
    }
}

