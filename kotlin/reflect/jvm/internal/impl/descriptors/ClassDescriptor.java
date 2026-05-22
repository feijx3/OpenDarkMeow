/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ClassDescriptor
extends ClassOrPackageFragmentDescriptor,
ClassifierDescriptorWithTypeParameters {
    @NotNull
    public MemberScope getMemberScope(@NotNull TypeSubstitution var1);

    @NotNull
    public MemberScope getUnsubstitutedMemberScope();

    @NotNull
    public MemberScope getUnsubstitutedInnerClassesScope();

    @NotNull
    public MemberScope getStaticScope();

    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors();

    @Override
    @NotNull
    public DeclarationDescriptor getContainingDeclaration();

    @Override
    @NotNull
    public SimpleType getDefaultType();

    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor();

    @NotNull
    public ClassKind getKind();

    @Override
    @NotNull
    public Modality getModality();

    @Override
    @NotNull
    public DescriptorVisibility getVisibility();

    public boolean isCompanionObject();

    public boolean isData();

    public boolean isInline();

    public boolean isFun();

    public boolean isValue();

    @NotNull
    public ReceiverParameterDescriptor getThisAsReceiverParameter();

    @NotNull
    public List<ReceiverParameterDescriptor> getContextReceivers();

    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor();

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters();

    @Nullable
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation();

    @Override
    @NotNull
    public ClassDescriptor getOriginal();
}

