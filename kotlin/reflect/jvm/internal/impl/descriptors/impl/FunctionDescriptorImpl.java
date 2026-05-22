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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class FunctionDescriptorImpl
extends DeclarationDescriptorNonRootImpl
implements FunctionDescriptor {
    private List<TypeParameterDescriptor> typeParameters;
    private List<ValueParameterDescriptor> unsubstitutedValueParameters;
    private KotlinType unsubstitutedReturnType;
    private List<ReceiverParameterDescriptor> contextReceiverParameters;
    private ReceiverParameterDescriptor extensionReceiverParameter;
    private ReceiverParameterDescriptor dispatchReceiverParameter;
    private Modality modality;
    private DescriptorVisibility visibility;
    private boolean isOperator;
    private boolean isInfix;
    private boolean isExternal;
    private boolean isInline;
    private boolean isTailrec;
    private boolean isExpect;
    private boolean isActual;
    private boolean isHiddenToOvercomeSignatureClash;
    private boolean isHiddenForResolutionEverywhereBesideSupercalls;
    private boolean isSuspend;
    private boolean hasStableParameterNames;
    private boolean hasSynthesizedParameterNames;
    private Collection<? extends FunctionDescriptor> overriddenFunctions;
    private volatile Function0<Collection<FunctionDescriptor>> lazyOverriddenFunctionsTask;
    private final FunctionDescriptor original;
    private final CallableMemberDescriptor.Kind kind;
    @Nullable
    private FunctionDescriptor initialSignatureDescriptor;
    protected Map<CallableDescriptor.UserDataKey<?>, Object> userDataMap;

    protected FunctionDescriptorImpl(@NotNull DeclarationDescriptor containingDeclaration, @Nullable FunctionDescriptor original, @NotNull Annotations annotations, @NotNull Name name, @NotNull CallableMemberDescriptor.Kind kind2, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(0);
        }
        if (annotations == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(1);
        }
        if (name == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(2);
        }
        if (kind2 == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(3);
        }
        if (source == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(4);
        }
        super(containingDeclaration, annotations, name, source);
        this.visibility = DescriptorVisibilities.UNKNOWN;
        this.isOperator = false;
        this.isInfix = false;
        this.isExternal = false;
        this.isInline = false;
        this.isTailrec = false;
        this.isExpect = false;
        this.isActual = false;
        this.isHiddenToOvercomeSignatureClash = false;
        this.isHiddenForResolutionEverywhereBesideSupercalls = false;
        this.isSuspend = false;
        this.hasStableParameterNames = true;
        this.hasSynthesizedParameterNames = false;
        this.overriddenFunctions = null;
        this.lazyOverriddenFunctionsTask = null;
        this.initialSignatureDescriptor = null;
        this.userDataMap = null;
        this.original = original == null ? this : original;
        this.kind = kind2;
    }

    @NotNull
    public FunctionDescriptorImpl initialize(@Nullable ReceiverParameterDescriptor extensionReceiverParameter, @Nullable ReceiverParameterDescriptor dispatchReceiverParameter, @NotNull List<ReceiverParameterDescriptor> contextReceiverParameters, @NotNull List<? extends TypeParameterDescriptor> typeParameters, @NotNull List<ValueParameterDescriptor> unsubstitutedValueParameters, @Nullable KotlinType unsubstitutedReturnType, @Nullable Modality modality2, @NotNull DescriptorVisibility visibility2) {
        int i2;
        if (contextReceiverParameters == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(5);
        }
        if (typeParameters == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(6);
        }
        if (unsubstitutedValueParameters == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(7);
        }
        if (visibility2 == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(8);
        }
        this.typeParameters = CollectionsKt.toList(typeParameters);
        this.unsubstitutedValueParameters = CollectionsKt.toList(unsubstitutedValueParameters);
        this.unsubstitutedReturnType = unsubstitutedReturnType;
        this.modality = modality2;
        this.visibility = visibility2;
        this.extensionReceiverParameter = extensionReceiverParameter;
        this.dispatchReceiverParameter = dispatchReceiverParameter;
        this.contextReceiverParameters = contextReceiverParameters;
        for (i2 = 0; i2 < typeParameters.size(); ++i2) {
            TypeParameterDescriptor typeParameterDescriptor = typeParameters.get(i2);
            if (typeParameterDescriptor.getIndex() == i2) continue;
            throw new IllegalStateException(typeParameterDescriptor + " index is " + typeParameterDescriptor.getIndex() + " but position is " + i2);
        }
        for (i2 = 0; i2 < unsubstitutedValueParameters.size(); ++i2) {
            int firstValueParameterOffset = 0;
            ValueParameterDescriptor valueParameterDescriptor = unsubstitutedValueParameters.get(i2);
            if (valueParameterDescriptor.getIndex() == i2 + firstValueParameterOffset) continue;
            throw new IllegalStateException(valueParameterDescriptor + "index is " + valueParameterDescriptor.getIndex() + " but position is " + i2);
        }
        FunctionDescriptorImpl functionDescriptorImpl = this;
        if (functionDescriptorImpl == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(9);
        }
        return functionDescriptorImpl;
    }

    public void setVisibility(@NotNull DescriptorVisibility visibility2) {
        if (visibility2 == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(10);
        }
        this.visibility = visibility2;
    }

    public void setOperator(boolean isOperator) {
        this.isOperator = isOperator;
    }

    public void setInfix(boolean isInfix) {
        this.isInfix = isInfix;
    }

    public void setExternal(boolean isExternal) {
        this.isExternal = isExternal;
    }

    public void setInline(boolean isInline) {
        this.isInline = isInline;
    }

    public void setTailrec(boolean isTailrec) {
        this.isTailrec = isTailrec;
    }

    public void setExpect(boolean isExpect) {
        this.isExpect = isExpect;
    }

    public void setActual(boolean isActual) {
        this.isActual = isActual;
    }

    private void setHiddenToOvercomeSignatureClash(boolean hiddenToOvercomeSignatureClash) {
        this.isHiddenToOvercomeSignatureClash = hiddenToOvercomeSignatureClash;
    }

    private void setHiddenForResolutionEverywhereBesideSupercalls(boolean hiddenForResolutionEverywhereBesideSupercalls) {
        this.isHiddenForResolutionEverywhereBesideSupercalls = hiddenForResolutionEverywhereBesideSupercalls;
    }

    public void setSuspend(boolean suspend) {
        this.isSuspend = suspend;
    }

    public void setReturnType(@NotNull KotlinType unsubstitutedReturnType) {
        if (unsubstitutedReturnType == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(11);
        }
        if (this.unsubstitutedReturnType != null) {
            // empty if block
        }
        this.unsubstitutedReturnType = unsubstitutedReturnType;
    }

    public void setHasStableParameterNames(boolean hasStableParameterNames) {
        this.hasStableParameterNames = hasStableParameterNames;
    }

    public void setHasSynthesizedParameterNames(boolean hasSynthesizedParameterNames) {
        this.hasSynthesizedParameterNames = hasSynthesizedParameterNames;
    }

    @Override
    @NotNull
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> list = this.contextReceiverParameters;
        if (list == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(13);
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
    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        this.performOverriddenLazyCalculationIfNeeded();
        Collection<Object> collection = this.overriddenFunctions != null ? this.overriddenFunctions : Collections.emptyList();
        if (collection == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(14);
        }
        return collection;
    }

    private void performOverriddenLazyCalculationIfNeeded() {
        Function0<Collection<FunctionDescriptor>> overriddenTask = this.lazyOverriddenFunctionsTask;
        if (overriddenTask != null) {
            this.overriddenFunctions = overriddenTask.invoke();
            this.lazyOverriddenFunctionsTask = null;
        }
    }

    @Override
    @NotNull
    public Modality getModality() {
        Modality modality2 = this.modality;
        if (modality2 == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(15);
        }
        return modality2;
    }

    @Override
    @NotNull
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.visibility;
        if (descriptorVisibility == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(16);
        }
        return descriptorVisibility;
    }

    @Override
    public boolean isOperator() {
        if (this.isOperator) {
            return true;
        }
        for (FunctionDescriptor functionDescriptor : this.getOriginal().getOverriddenDescriptors()) {
            if (!functionDescriptor.isOperator()) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean isInfix() {
        if (this.isInfix) {
            return true;
        }
        for (FunctionDescriptor functionDescriptor : this.getOriginal().getOverriddenDescriptors()) {
            if (!functionDescriptor.isInfix()) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean isExternal() {
        return this.isExternal;
    }

    @Override
    public boolean isInline() {
        return this.isInline;
    }

    @Override
    public boolean isTailrec() {
        return this.isTailrec;
    }

    @Override
    public boolean isSuspend() {
        return this.isSuspend;
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
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> key) {
        if (this.userDataMap == null) {
            return null;
        }
        return (V)this.userDataMap.get(key);
    }

    @Override
    public boolean isHiddenToOvercomeSignatureClash() {
        return this.isHiddenToOvercomeSignatureClash;
    }

    @Override
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> overriddenDescriptors) {
        if (overriddenDescriptors == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(17);
        }
        this.overriddenFunctions = overriddenDescriptors;
        for (FunctionDescriptor functionDescriptor : this.overriddenFunctions) {
            if (!functionDescriptor.isHiddenForResolutionEverywhereBesideSupercalls()) continue;
            this.isHiddenForResolutionEverywhereBesideSupercalls = true;
            break;
        }
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
            FunctionDescriptorImpl.$$$reportNull$$$0(18);
        }
        return list;
    }

    @Override
    @NotNull
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> list = this.unsubstitutedValueParameters;
        if (list == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(19);
        }
        return list;
    }

    public boolean hasStableParameterNames() {
        return this.hasStableParameterNames;
    }

    @Override
    public boolean hasSynthesizedParameterNames() {
        return this.hasSynthesizedParameterNames;
    }

    @Override
    public KotlinType getReturnType() {
        return this.unsubstitutedReturnType;
    }

    @Override
    @NotNull
    public FunctionDescriptor getOriginal() {
        FunctionDescriptor functionDescriptor = this.original == this ? this : this.original.getOriginal();
        if (functionDescriptor == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(20);
        }
        return functionDescriptor;
    }

    @Override
    @NotNull
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind2 = this.kind;
        if (kind2 == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(21);
        }
        return kind2;
    }

    @Override
    public FunctionDescriptor substitute(@NotNull TypeSubstitutor originalSubstitutor) {
        if (originalSubstitutor == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(22);
        }
        if (originalSubstitutor.isEmpty()) {
            return this;
        }
        return this.newCopyBuilder(originalSubstitutor).setOriginal(this.getOriginal()).setPreserveSourceElement().setJustForTypeSubstitution(true).build();
    }

    @Override
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return this.isHiddenForResolutionEverywhereBesideSupercalls;
    }

    @Override
    @NotNull
    public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder() {
        CopyConfiguration copyConfiguration = this.newCopyBuilder(TypeSubstitutor.EMPTY);
        if (copyConfiguration == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(23);
        }
        return copyConfiguration;
    }

    @NotNull
    protected CopyConfiguration newCopyBuilder(@NotNull TypeSubstitutor substitutor) {
        if (substitutor == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(24);
        }
        return new CopyConfiguration(substitutor.getSubstitution(), this.getContainingDeclaration(), this.getModality(), this.getVisibility(), this.getKind(), this.getValueParameters(), this.getContextReceiverParameters(), this.getExtensionReceiverParameter(), this.getReturnType(), null);
    }

    @Nullable
    protected FunctionDescriptor doSubstitute(@NotNull CopyConfiguration configuration) {
        List<ValueParameterDescriptor> substitutedValueParameters;
        if (configuration == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(25);
        }
        boolean[] wereChanges = new boolean[1];
        Annotations resultAnnotations = configuration.additionalAnnotations != null ? AnnotationsKt.composeAnnotations(this.getAnnotations(), configuration.additionalAnnotations) : this.getAnnotations();
        FunctionDescriptorImpl substitutedDescriptor = this.createSubstitutedCopy(configuration.newOwner, configuration.original, configuration.kind, configuration.name, resultAnnotations, this.getSourceToUseForCopy(configuration.preserveSourceElement, configuration.original));
        List unsubstitutedTypeParameters = configuration.newTypeParameters == null ? this.getTypeParameters() : configuration.newTypeParameters;
        wereChanges[0] = wereChanges[0] | !unsubstitutedTypeParameters.isEmpty();
        ArrayList<TypeParameterDescriptor> substitutedTypeParameters = new ArrayList<TypeParameterDescriptor>(unsubstitutedTypeParameters.size());
        final TypeSubstitutor substitutor = DescriptorSubstitutor.substituteTypeParameters(unsubstitutedTypeParameters, configuration.substitution, substitutedDescriptor, substitutedTypeParameters, wereChanges);
        if (substitutor == null) {
            return null;
        }
        ArrayList<ReceiverParameterDescriptor> substitutedContextReceiverParameters = new ArrayList<ReceiverParameterDescriptor>();
        if (!configuration.newContextReceiverParameters.isEmpty()) {
            int index = 0;
            for (ReceiverParameterDescriptor newContextReceiverParameter : configuration.newContextReceiverParameters) {
                KotlinType substitutedContextReceiverType = substitutor.substitute(newContextReceiverParameter.getType(), Variance.IN_VARIANCE);
                if (substitutedContextReceiverType == null) {
                    return null;
                }
                ReceiverParameterDescriptor substitutedContextReceiverParameter = DescriptorFactory.createContextReceiverParameterForCallable(substitutedDescriptor, substitutedContextReceiverType, ((ImplicitContextReceiver)newContextReceiverParameter.getValue()).getCustomLabelName(), newContextReceiverParameter.getAnnotations(), index++);
                substitutedContextReceiverParameters.add(substitutedContextReceiverParameter);
                wereChanges[0] = wereChanges[0] | substitutedContextReceiverType != newContextReceiverParameter.getType();
            }
        }
        ReceiverParameterDescriptorImpl substitutedReceiverParameter = null;
        if (configuration.newExtensionReceiverParameter != null) {
            KotlinType substitutedExtensionReceiverType = substitutor.substitute(configuration.newExtensionReceiverParameter.getType(), Variance.IN_VARIANCE);
            if (substitutedExtensionReceiverType == null) {
                return null;
            }
            substitutedReceiverParameter = new ReceiverParameterDescriptorImpl(substitutedDescriptor, new ExtensionReceiver(substitutedDescriptor, substitutedExtensionReceiverType, configuration.newExtensionReceiverParameter.getValue()), configuration.newExtensionReceiverParameter.getAnnotations());
            wereChanges[0] = wereChanges[0] | substitutedExtensionReceiverType != configuration.newExtensionReceiverParameter.getType();
        }
        ReceiverParameterDescriptor substitutedExpectedThis = null;
        if (configuration.dispatchReceiverParameter != null) {
            substitutedExpectedThis = configuration.dispatchReceiverParameter.substitute(substitutor);
            if (substitutedExpectedThis == null) {
                return null;
            }
            wereChanges[0] = wereChanges[0] | substitutedExpectedThis != configuration.dispatchReceiverParameter;
        }
        if ((substitutedValueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(substitutedDescriptor, configuration.newValueParameterDescriptors, substitutor, configuration.dropOriginalInContainingParts, configuration.preserveSourceElement, wereChanges)) == null) {
            return null;
        }
        KotlinType substitutedReturnType = substitutor.substitute(configuration.newReturnType, Variance.OUT_VARIANCE);
        if (substitutedReturnType == null) {
            return null;
        }
        wereChanges[0] = wereChanges[0] | substitutedReturnType != configuration.newReturnType;
        if (!wereChanges[0] && configuration.justForTypeSubstitution) {
            return this;
        }
        substitutedDescriptor.initialize(substitutedReceiverParameter, substitutedExpectedThis, substitutedContextReceiverParameters, substitutedTypeParameters, substitutedValueParameters, substitutedReturnType, configuration.newModality, configuration.newVisibility);
        substitutedDescriptor.setOperator(this.isOperator);
        substitutedDescriptor.setInfix(this.isInfix);
        substitutedDescriptor.setExternal(this.isExternal);
        substitutedDescriptor.setInline(this.isInline);
        substitutedDescriptor.setTailrec(this.isTailrec);
        substitutedDescriptor.setSuspend(this.isSuspend);
        substitutedDescriptor.setExpect(this.isExpect);
        substitutedDescriptor.setActual(this.isActual);
        substitutedDescriptor.setHasStableParameterNames(this.hasStableParameterNames);
        substitutedDescriptor.setHiddenToOvercomeSignatureClash(configuration.isHiddenToOvercomeSignatureClash);
        substitutedDescriptor.setHiddenForResolutionEverywhereBesideSupercalls(configuration.isHiddenForResolutionEverywhereBesideSupercalls);
        substitutedDescriptor.setHasSynthesizedParameterNames(configuration.newHasSynthesizedParameterNames != null ? configuration.newHasSynthesizedParameterNames : this.hasSynthesizedParameterNames);
        if (!configuration.userDataMap.isEmpty() || this.userDataMap != null) {
            Map newMap = configuration.userDataMap;
            if (this.userDataMap != null) {
                for (Map.Entry<CallableDescriptor.UserDataKey<?>, Object> entry : this.userDataMap.entrySet()) {
                    if (newMap.containsKey(entry.getKey())) continue;
                    newMap.put(entry.getKey(), entry.getValue());
                }
            }
            substitutedDescriptor.userDataMap = newMap.size() == 1 ? Collections.singletonMap(newMap.keySet().iterator().next(), newMap.values().iterator().next()) : newMap;
        }
        if (configuration.signatureChange || this.getInitialSignatureDescriptor() != null) {
            FunctionDescriptor initialSignature = this.getInitialSignatureDescriptor() != null ? this.getInitialSignatureDescriptor() : this;
            FunctionDescriptor initialSignatureSubstituted = initialSignature.substitute(substitutor);
            substitutedDescriptor.setInitialSignatureDescriptor(initialSignatureSubstituted);
        }
        if (configuration.copyOverrides && !this.getOriginal().getOverriddenDescriptors().isEmpty()) {
            if (configuration.substitution.isEmpty()) {
                Function0<Collection<FunctionDescriptor>> overriddenFunctionsTask = this.lazyOverriddenFunctionsTask;
                if (overriddenFunctionsTask != null) {
                    substitutedDescriptor.lazyOverriddenFunctionsTask = overriddenFunctionsTask;
                } else {
                    substitutedDescriptor.setOverriddenDescriptors(this.getOverriddenDescriptors());
                }
            } else {
                substitutedDescriptor.lazyOverriddenFunctionsTask = new Function0<Collection<FunctionDescriptor>>(){

                    @Override
                    public Collection<FunctionDescriptor> invoke() {
                        SmartList<FunctionDescriptor> result = new SmartList<FunctionDescriptor>();
                        for (FunctionDescriptor functionDescriptor : FunctionDescriptorImpl.this.getOverriddenDescriptors()) {
                            result.add(functionDescriptor.substitute(substitutor));
                        }
                        return result;
                    }
                };
            }
        }
        return substitutedDescriptor;
    }

    @Override
    @NotNull
    public FunctionDescriptor copy(DeclarationDescriptor newOwner, Modality modality2, DescriptorVisibility visibility2, CallableMemberDescriptor.Kind kind2, boolean copyOverrides) {
        FunctionDescriptor functionDescriptor = this.newCopyBuilder().setOwner(newOwner).setModality(modality2).setVisibility(visibility2).setKind(kind2).setCopyOverrides(copyOverrides).build();
        if (functionDescriptor == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(26);
        }
        return functionDescriptor;
    }

    @NotNull
    protected abstract FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor var1, @Nullable FunctionDescriptor var2, @NotNull CallableMemberDescriptor.Kind var3, @Nullable Name var4, @NotNull Annotations var5, @NotNull SourceElement var6);

    @NotNull
    private SourceElement getSourceToUseForCopy(boolean preserveSource, @Nullable FunctionDescriptor original) {
        SourceElement sourceElement = preserveSource ? (original != null ? original : this.getOriginal()).getSource() : SourceElement.NO_SOURCE;
        if (sourceElement == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(27);
        }
        return sourceElement;
    }

    @Override
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor2, D data) {
        return visitor2.visitFunctionDescriptor(this, data);
    }

    @Nullable
    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor substitutedDescriptor, @NotNull List<ValueParameterDescriptor> unsubstitutedValueParameters, @NotNull TypeSubstitutor substitutor) {
        if (unsubstitutedValueParameters == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(28);
        }
        if (substitutor == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(29);
        }
        return FunctionDescriptorImpl.getSubstitutedValueParameters(substitutedDescriptor, unsubstitutedValueParameters, substitutor, false, false, null);
    }

    @Nullable
    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor substitutedDescriptor, @NotNull List<ValueParameterDescriptor> unsubstitutedValueParameters, @NotNull TypeSubstitutor substitutor, boolean dropOriginal, boolean preserveSourceElement, @Nullable boolean[] wereChanges) {
        if (unsubstitutedValueParameters == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(30);
        }
        if (substitutor == null) {
            FunctionDescriptorImpl.$$$reportNull$$$0(31);
        }
        ArrayList<ValueParameterDescriptor> result = new ArrayList<ValueParameterDescriptor>(unsubstitutedValueParameters.size());
        for (ValueParameterDescriptor unsubstitutedValueParameter : unsubstitutedValueParameters) {
            KotlinType substituteVarargElementType;
            KotlinType substitutedType = substitutor.substitute(unsubstitutedValueParameter.getType(), Variance.IN_VARIANCE);
            KotlinType varargElementType = unsubstitutedValueParameter.getVarargElementType();
            KotlinType kotlinType = substituteVarargElementType = varargElementType == null ? null : substitutor.substitute(varargElementType, Variance.IN_VARIANCE);
            if (substitutedType == null) {
                return null;
            }
            if ((substitutedType != unsubstitutedValueParameter.getType() || varargElementType != substituteVarargElementType) && wereChanges != null) {
                wereChanges[0] = true;
            }
            Function0<List<VariableDescriptor>> destructuringVariablesAction = null;
            if (unsubstitutedValueParameter instanceof ValueParameterDescriptorImpl.WithDestructuringDeclaration) {
                final List<VariableDescriptor> destructuringVariables = ((ValueParameterDescriptorImpl.WithDestructuringDeclaration)unsubstitutedValueParameter).getDestructuringVariables();
                destructuringVariablesAction = new Function0<List<VariableDescriptor>>(){

                    @Override
                    public List<VariableDescriptor> invoke() {
                        return destructuringVariables;
                    }
                };
            }
            result.add(ValueParameterDescriptorImpl.createWithDestructuringDeclarations(substitutedDescriptor, dropOriginal ? null : unsubstitutedValueParameter, unsubstitutedValueParameter.getIndex(), unsubstitutedValueParameter.getAnnotations(), unsubstitutedValueParameter.getName(), substitutedType, unsubstitutedValueParameter.declaresDefaultValue(), unsubstitutedValueParameter.isCrossinline(), unsubstitutedValueParameter.isNoinline(), substituteVarargElementType, preserveSourceElement ? unsubstitutedValueParameter.getSource() : SourceElement.NO_SOURCE, (Function0<? extends List<? extends VariableDescriptor>>)destructuringVariablesAction));
        }
        return result;
    }

    @Override
    @Nullable
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.initialSignatureDescriptor;
    }

    private void setInitialSignatureDescriptor(@Nullable FunctionDescriptor initialSignatureDescriptor) {
        this.initialSignatureDescriptor = initialSignatureDescriptor;
    }

    public <V> void putInUserDataMap(CallableDescriptor.UserDataKey<V> key, Object value) {
        if (this.userDataMap == null) {
            this.userDataMap = new LinkedHashMap();
        }
        this.userDataMap.put(key, value);
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
            case 9: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 23: 
            case 26: 
            case 27: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n2) {
            default: {
                n3 = 3;
                break;
            }
            case 9: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 23: 
            case 26: 
            case 27: {
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
            case 1: {
                objectArray2 = objectArray3;
                objectArray3[0] = "annotations";
                break;
            }
            case 2: {
                objectArray2 = objectArray3;
                objectArray3[0] = "name";
                break;
            }
            case 3: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kind";
                break;
            }
            case 4: {
                objectArray2 = objectArray3;
                objectArray3[0] = "source";
                break;
            }
            case 5: {
                objectArray2 = objectArray3;
                objectArray3[0] = "contextReceiverParameters";
                break;
            }
            case 6: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeParameters";
                break;
            }
            case 7: 
            case 28: 
            case 30: {
                objectArray2 = objectArray3;
                objectArray3[0] = "unsubstitutedValueParameters";
                break;
            }
            case 8: 
            case 10: {
                objectArray2 = objectArray3;
                objectArray3[0] = "visibility";
                break;
            }
            case 9: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 23: 
            case 26: 
            case 27: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            }
            case 11: {
                objectArray2 = objectArray3;
                objectArray3[0] = "unsubstitutedReturnType";
                break;
            }
            case 12: {
                objectArray2 = objectArray3;
                objectArray3[0] = "extensionReceiverParameter";
                break;
            }
            case 17: {
                objectArray2 = objectArray3;
                objectArray3[0] = "overriddenDescriptors";
                break;
            }
            case 22: {
                objectArray2 = objectArray3;
                objectArray3[0] = "originalSubstitutor";
                break;
            }
            case 24: 
            case 29: 
            case 31: {
                objectArray2 = objectArray3;
                objectArray3[0] = "substitutor";
                break;
            }
            case 25: {
                objectArray2 = objectArray3;
                objectArray3[0] = "configuration";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            }
            case 9: {
                objectArray = objectArray2;
                objectArray2[1] = "initialize";
                break;
            }
            case 13: {
                objectArray = objectArray2;
                objectArray2[1] = "getContextReceiverParameters";
                break;
            }
            case 14: {
                objectArray = objectArray2;
                objectArray2[1] = "getOverriddenDescriptors";
                break;
            }
            case 15: {
                objectArray = objectArray2;
                objectArray2[1] = "getModality";
                break;
            }
            case 16: {
                objectArray = objectArray2;
                objectArray2[1] = "getVisibility";
                break;
            }
            case 18: {
                objectArray = objectArray2;
                objectArray2[1] = "getTypeParameters";
                break;
            }
            case 19: {
                objectArray = objectArray2;
                objectArray2[1] = "getValueParameters";
                break;
            }
            case 20: {
                objectArray = objectArray2;
                objectArray2[1] = "getOriginal";
                break;
            }
            case 21: {
                objectArray = objectArray2;
                objectArray2[1] = "getKind";
                break;
            }
            case 23: {
                objectArray = objectArray2;
                objectArray2[1] = "newCopyBuilder";
                break;
            }
            case 26: {
                objectArray = objectArray2;
                objectArray2[1] = "copy";
                break;
            }
            case 27: {
                objectArray = objectArray2;
                objectArray2[1] = "getSourceToUseForCopy";
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
                objectArray[2] = "initialize";
                break;
            }
            case 9: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 23: 
            case 26: 
            case 27: {
                break;
            }
            case 10: {
                objectArray = objectArray;
                objectArray[2] = "setVisibility";
                break;
            }
            case 11: {
                objectArray = objectArray;
                objectArray[2] = "setReturnType";
                break;
            }
            case 12: {
                objectArray = objectArray;
                objectArray[2] = "setExtensionReceiverParameter";
                break;
            }
            case 17: {
                objectArray = objectArray;
                objectArray[2] = "setOverriddenDescriptors";
                break;
            }
            case 22: {
                objectArray = objectArray;
                objectArray[2] = "substitute";
                break;
            }
            case 24: {
                objectArray = objectArray;
                objectArray[2] = "newCopyBuilder";
                break;
            }
            case 25: {
                objectArray = objectArray;
                objectArray[2] = "doSubstitute";
                break;
            }
            case 28: 
            case 29: 
            case 30: 
            case 31: {
                objectArray = objectArray;
                objectArray[2] = "getSubstitutedValueParameters";
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n2) {
            default: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
            case 9: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 23: 
            case 26: 
            case 27: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }

    public class CopyConfiguration
    implements FunctionDescriptor.CopyBuilder<FunctionDescriptor> {
        @NotNull
        protected TypeSubstitution substitution;
        @NotNull
        protected DeclarationDescriptor newOwner;
        @NotNull
        protected Modality newModality;
        @NotNull
        protected DescriptorVisibility newVisibility;
        @Nullable
        protected FunctionDescriptor original;
        @NotNull
        protected CallableMemberDescriptor.Kind kind;
        @NotNull
        protected List<ValueParameterDescriptor> newValueParameterDescriptors;
        @NotNull
        protected List<ReceiverParameterDescriptor> newContextReceiverParameters;
        @Nullable
        protected ReceiverParameterDescriptor newExtensionReceiverParameter;
        @Nullable
        protected ReceiverParameterDescriptor dispatchReceiverParameter;
        @NotNull
        protected KotlinType newReturnType;
        @Nullable
        protected Name name;
        protected boolean copyOverrides;
        protected boolean signatureChange;
        protected boolean preserveSourceElement;
        protected boolean dropOriginalInContainingParts;
        private boolean isHiddenToOvercomeSignatureClash;
        private List<TypeParameterDescriptor> newTypeParameters;
        private Annotations additionalAnnotations;
        private boolean isHiddenForResolutionEverywhereBesideSupercalls;
        private Map<CallableDescriptor.UserDataKey<?>, Object> userDataMap;
        private Boolean newHasSynthesizedParameterNames;
        protected boolean justForTypeSubstitution;

        public CopyConfiguration(@NotNull TypeSubstitution substitution, @NotNull DeclarationDescriptor newOwner, @NotNull Modality newModality, @NotNull DescriptorVisibility newVisibility, @NotNull CallableMemberDescriptor.Kind kind2, @NotNull List<ValueParameterDescriptor> newValueParameterDescriptors, @Nullable List<ReceiverParameterDescriptor> newContextReceiverParameters, @NotNull ReceiverParameterDescriptor newExtensionReceiverParameter, @Nullable KotlinType newReturnType, Name name) {
            if (substitution == null) {
                CopyConfiguration.$$$reportNull$$$0(0);
            }
            if (newOwner == null) {
                CopyConfiguration.$$$reportNull$$$0(1);
            }
            if (newModality == null) {
                CopyConfiguration.$$$reportNull$$$0(2);
            }
            if (newVisibility == null) {
                CopyConfiguration.$$$reportNull$$$0(3);
            }
            if (kind2 == null) {
                CopyConfiguration.$$$reportNull$$$0(4);
            }
            if (newValueParameterDescriptors == null) {
                CopyConfiguration.$$$reportNull$$$0(5);
            }
            if (newContextReceiverParameters == null) {
                CopyConfiguration.$$$reportNull$$$0(6);
            }
            if (newReturnType == null) {
                CopyConfiguration.$$$reportNull$$$0(7);
            }
            this.original = null;
            this.dispatchReceiverParameter = FunctionDescriptorImpl.this.dispatchReceiverParameter;
            this.copyOverrides = true;
            this.signatureChange = false;
            this.preserveSourceElement = false;
            this.dropOriginalInContainingParts = false;
            this.isHiddenToOvercomeSignatureClash = FunctionDescriptorImpl.this.isHiddenToOvercomeSignatureClash();
            this.newTypeParameters = null;
            this.additionalAnnotations = null;
            this.isHiddenForResolutionEverywhereBesideSupercalls = FunctionDescriptorImpl.this.isHiddenForResolutionEverywhereBesideSupercalls();
            this.userDataMap = new LinkedHashMap();
            this.newHasSynthesizedParameterNames = null;
            this.justForTypeSubstitution = false;
            this.substitution = substitution;
            this.newOwner = newOwner;
            this.newModality = newModality;
            this.newVisibility = newVisibility;
            this.kind = kind2;
            this.newValueParameterDescriptors = newValueParameterDescriptors;
            this.newContextReceiverParameters = newContextReceiverParameters;
            this.newExtensionReceiverParameter = newExtensionReceiverParameter;
            this.newReturnType = newReturnType;
            this.name = name;
        }

        @NotNull
        public CopyConfiguration setOwner(@NotNull DeclarationDescriptor owner) {
            if (owner == null) {
                CopyConfiguration.$$$reportNull$$$0(8);
            }
            this.newOwner = owner;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(9);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setModality(@NotNull Modality modality2) {
            if (modality2 == null) {
                CopyConfiguration.$$$reportNull$$$0(10);
            }
            this.newModality = modality2;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(11);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setVisibility(@NotNull DescriptorVisibility visibility2) {
            if (visibility2 == null) {
                CopyConfiguration.$$$reportNull$$$0(12);
            }
            this.newVisibility = visibility2;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(13);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setKind(@NotNull CallableMemberDescriptor.Kind kind2) {
            if (kind2 == null) {
                CopyConfiguration.$$$reportNull$$$0(14);
            }
            this.kind = kind2;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(15);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setCopyOverrides(boolean copyOverrides) {
            this.copyOverrides = copyOverrides;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(16);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setName(@NotNull Name name) {
            if (name == null) {
                CopyConfiguration.$$$reportNull$$$0(17);
            }
            this.name = name;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(18);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setValueParameters(@NotNull List<ValueParameterDescriptor> parameters) {
            if (parameters == null) {
                CopyConfiguration.$$$reportNull$$$0(19);
            }
            this.newValueParameterDescriptors = parameters;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(20);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setTypeParameters(@NotNull List<TypeParameterDescriptor> parameters) {
            if (parameters == null) {
                CopyConfiguration.$$$reportNull$$$0(21);
            }
            this.newTypeParameters = parameters;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(22);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setReturnType(@NotNull KotlinType type) {
            if (type == null) {
                CopyConfiguration.$$$reportNull$$$0(23);
            }
            this.newReturnType = type;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(24);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setExtensionReceiverParameter(@Nullable ReceiverParameterDescriptor extensionReceiverParameter) {
            this.newExtensionReceiverParameter = extensionReceiverParameter;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(27);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setDispatchReceiverParameter(@Nullable ReceiverParameterDescriptor dispatchReceiverParameter) {
            this.dispatchReceiverParameter = dispatchReceiverParameter;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(28);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setOriginal(@Nullable CallableMemberDescriptor original) {
            this.original = (FunctionDescriptor)original;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(29);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setSignatureChange() {
            this.signatureChange = true;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(30);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setPreserveSourceElement() {
            this.preserveSourceElement = true;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(31);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setDropOriginalInContainingParts() {
            this.dropOriginalInContainingParts = true;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(32);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setHiddenToOvercomeSignatureClash() {
            this.isHiddenToOvercomeSignatureClash = true;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(33);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setHiddenForResolutionEverywhereBesideSupercalls() {
            this.isHiddenForResolutionEverywhereBesideSupercalls = true;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(34);
            }
            return copyConfiguration;
        }

        @NotNull
        public CopyConfiguration setAdditionalAnnotations(@NotNull Annotations additionalAnnotations) {
            if (additionalAnnotations == null) {
                CopyConfiguration.$$$reportNull$$$0(35);
            }
            this.additionalAnnotations = additionalAnnotations;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(36);
            }
            return copyConfiguration;
        }

        public CopyConfiguration setHasSynthesizedParameterNames(boolean value) {
            this.newHasSynthesizedParameterNames = value;
            return this;
        }

        @NotNull
        public CopyConfiguration setSubstitution(@NotNull TypeSubstitution substitution) {
            if (substitution == null) {
                CopyConfiguration.$$$reportNull$$$0(37);
            }
            this.substitution = substitution;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(38);
            }
            return copyConfiguration;
        }

        @Override
        @NotNull
        public <V> FunctionDescriptor.CopyBuilder<FunctionDescriptor> putUserData(@NotNull CallableDescriptor.UserDataKey<V> userDataKey, V value) {
            if (userDataKey == null) {
                CopyConfiguration.$$$reportNull$$$0(39);
            }
            this.userDataMap.put(userDataKey, value);
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(40);
            }
            return copyConfiguration;
        }

        @Override
        @Nullable
        public FunctionDescriptor build() {
            return FunctionDescriptorImpl.this.doSubstitute(this);
        }

        @NotNull
        public CopyConfiguration setJustForTypeSubstitution(boolean value) {
            this.justForTypeSubstitution = value;
            CopyConfiguration copyConfiguration = this;
            if (copyConfiguration == null) {
                CopyConfiguration.$$$reportNull$$$0(42);
            }
            return copyConfiguration;
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
                case 9: 
                case 11: 
                case 13: 
                case 15: 
                case 16: 
                case 18: 
                case 20: 
                case 22: 
                case 24: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 31: 
                case 32: 
                case 33: 
                case 34: 
                case 36: 
                case 38: 
                case 40: 
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
                case 9: 
                case 11: 
                case 13: 
                case 15: 
                case 16: 
                case 18: 
                case 20: 
                case 22: 
                case 24: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 31: 
                case 32: 
                case 33: 
                case 34: 
                case 36: 
                case 38: 
                case 40: 
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
                    objectArray3[0] = "substitution";
                    break;
                }
                case 1: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "newOwner";
                    break;
                }
                case 2: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "newModality";
                    break;
                }
                case 3: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "newVisibility";
                    break;
                }
                case 4: 
                case 14: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "kind";
                    break;
                }
                case 5: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "newValueParameterDescriptors";
                    break;
                }
                case 6: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "newContextReceiverParameters";
                    break;
                }
                case 7: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "newReturnType";
                    break;
                }
                case 8: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "owner";
                    break;
                }
                case 9: 
                case 11: 
                case 13: 
                case 15: 
                case 16: 
                case 18: 
                case 20: 
                case 22: 
                case 24: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 31: 
                case 32: 
                case 33: 
                case 34: 
                case 36: 
                case 38: 
                case 40: 
                case 41: 
                case 42: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                }
                case 10: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "modality";
                    break;
                }
                case 12: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "visibility";
                    break;
                }
                case 17: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "name";
                    break;
                }
                case 19: 
                case 21: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "parameters";
                    break;
                }
                case 23: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "type";
                    break;
                }
                case 25: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "contextReceiverParameters";
                    break;
                }
                case 35: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "additionalAnnotations";
                    break;
                }
                case 39: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "userDataKey";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                }
                case 9: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setOwner";
                    break;
                }
                case 11: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setModality";
                    break;
                }
                case 13: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setVisibility";
                    break;
                }
                case 15: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setKind";
                    break;
                }
                case 16: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setCopyOverrides";
                    break;
                }
                case 18: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setName";
                    break;
                }
                case 20: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setValueParameters";
                    break;
                }
                case 22: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setTypeParameters";
                    break;
                }
                case 24: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setReturnType";
                    break;
                }
                case 26: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setContextReceiverParameters";
                    break;
                }
                case 27: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setExtensionReceiverParameter";
                    break;
                }
                case 28: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setDispatchReceiverParameter";
                    break;
                }
                case 29: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setOriginal";
                    break;
                }
                case 30: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setSignatureChange";
                    break;
                }
                case 31: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setPreserveSourceElement";
                    break;
                }
                case 32: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setDropOriginalInContainingParts";
                    break;
                }
                case 33: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                }
                case 34: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                }
                case 36: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setAdditionalAnnotations";
                    break;
                }
                case 38: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setSubstitution";
                    break;
                }
                case 40: {
                    objectArray = objectArray2;
                    objectArray2[1] = "putUserData";
                    break;
                }
                case 41: {
                    objectArray = objectArray2;
                    objectArray2[1] = "getSubstitution";
                    break;
                }
                case 42: {
                    objectArray = objectArray2;
                    objectArray2[1] = "setJustForTypeSubstitution";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray;
                    objectArray[2] = "<init>";
                    break;
                }
                case 8: {
                    objectArray = objectArray;
                    objectArray[2] = "setOwner";
                    break;
                }
                case 9: 
                case 11: 
                case 13: 
                case 15: 
                case 16: 
                case 18: 
                case 20: 
                case 22: 
                case 24: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 31: 
                case 32: 
                case 33: 
                case 34: 
                case 36: 
                case 38: 
                case 40: 
                case 41: 
                case 42: {
                    break;
                }
                case 10: {
                    objectArray = objectArray;
                    objectArray[2] = "setModality";
                    break;
                }
                case 12: {
                    objectArray = objectArray;
                    objectArray[2] = "setVisibility";
                    break;
                }
                case 14: {
                    objectArray = objectArray;
                    objectArray[2] = "setKind";
                    break;
                }
                case 17: {
                    objectArray = objectArray;
                    objectArray[2] = "setName";
                    break;
                }
                case 19: {
                    objectArray = objectArray;
                    objectArray[2] = "setValueParameters";
                    break;
                }
                case 21: {
                    objectArray = objectArray;
                    objectArray[2] = "setTypeParameters";
                    break;
                }
                case 23: {
                    objectArray = objectArray;
                    objectArray[2] = "setReturnType";
                    break;
                }
                case 25: {
                    objectArray = objectArray;
                    objectArray[2] = "setContextReceiverParameters";
                    break;
                }
                case 35: {
                    objectArray = objectArray;
                    objectArray[2] = "setAdditionalAnnotations";
                    break;
                }
                case 37: {
                    objectArray = objectArray;
                    objectArray[2] = "setSubstitution";
                    break;
                }
                case 39: {
                    objectArray = objectArray;
                    objectArray[2] = "putUserData";
                    break;
                }
            }
            String string2 = String.format(string, objectArray);
            switch (n2) {
                default: {
                    runtimeException = new IllegalArgumentException(string2);
                    break;
                }
                case 9: 
                case 11: 
                case 13: 
                case 15: 
                case 16: 
                case 18: 
                case 20: 
                case 22: 
                case 24: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 31: 
                case 32: 
                case 33: 
                case 34: 
                case 36: 
                case 38: 
                case 40: 
                case 41: 
                case 42: {
                    runtimeException = new IllegalStateException(string2);
                    break;
                }
            }
            throw runtimeException;
        }
    }
}

