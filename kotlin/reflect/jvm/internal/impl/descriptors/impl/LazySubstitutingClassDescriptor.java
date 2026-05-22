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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.DefaultTypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LazySubstitutingClassDescriptor
extends ModuleAwareClassDescriptor {
    private final ModuleAwareClassDescriptor original;
    private final TypeSubstitutor originalSubstitutor;
    private TypeSubstitutor newSubstitutor;
    private List<TypeParameterDescriptor> typeConstructorParameters;
    private List<TypeParameterDescriptor> declaredTypeParameters;
    private TypeConstructor typeConstructor;

    public LazySubstitutingClassDescriptor(ModuleAwareClassDescriptor descriptor2, TypeSubstitutor substitutor) {
        this.original = descriptor2;
        this.originalSubstitutor = substitutor;
    }

    private TypeSubstitutor getSubstitutor() {
        if (this.newSubstitutor == null) {
            if (this.originalSubstitutor.isEmpty()) {
                this.newSubstitutor = this.originalSubstitutor;
            } else {
                List<TypeParameterDescriptor> originalTypeParameters = this.original.getTypeConstructor().getParameters();
                this.typeConstructorParameters = new ArrayList<TypeParameterDescriptor>(originalTypeParameters.size());
                this.newSubstitutor = DescriptorSubstitutor.substituteTypeParameters(originalTypeParameters, this.originalSubstitutor.getSubstitution(), this, this.typeConstructorParameters);
                this.declaredTypeParameters = CollectionsKt.filter(this.typeConstructorParameters, new Function1<TypeParameterDescriptor, Boolean>(){

                    @Override
                    public Boolean invoke(TypeParameterDescriptor descriptor2) {
                        return !descriptor2.isCapturedFromOuterDeclaration();
                    }
                });
            }
        }
        return this.newSubstitutor;
    }

    @Override
    @NotNull
    public TypeConstructor getTypeConstructor() {
        TypeConstructor originalTypeConstructor = this.original.getTypeConstructor();
        if (this.originalSubstitutor.isEmpty()) {
            TypeConstructor typeConstructor2 = originalTypeConstructor;
            if (typeConstructor2 == null) {
                LazySubstitutingClassDescriptor.$$$reportNull$$$0(0);
            }
            return typeConstructor2;
        }
        if (this.typeConstructor == null) {
            TypeSubstitutor substitutor = this.getSubstitutor();
            Collection<KotlinType> originalSupertypes = originalTypeConstructor.getSupertypes();
            ArrayList<KotlinType> supertypes = new ArrayList<KotlinType>(originalSupertypes.size());
            for (KotlinType supertype : originalSupertypes) {
                supertypes.add(substitutor.substitute(supertype, Variance.INVARIANT));
            }
            this.typeConstructor = new ClassTypeConstructorImpl(this, this.typeConstructorParameters, supertypes, LockBasedStorageManager.NO_LOCKS);
        }
        TypeConstructor typeConstructor3 = this.typeConstructor;
        if (typeConstructor3 == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(1);
        }
        return typeConstructor3;
    }

    @Override
    @NotNull
    public MemberScope getMemberScope(@NotNull TypeSubstitution typeSubstitution, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        if (typeSubstitution == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(5);
        }
        if (kotlinTypeRefiner == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(6);
        }
        MemberScope memberScope = this.original.getMemberScope(typeSubstitution, kotlinTypeRefiner);
        if (this.originalSubstitutor.isEmpty()) {
            MemberScope memberScope2 = memberScope;
            if (memberScope2 == null) {
                LazySubstitutingClassDescriptor.$$$reportNull$$$0(7);
            }
            return memberScope2;
        }
        return new SubstitutingScope(memberScope, this.getSubstitutor());
    }

    @Override
    @NotNull
    public MemberScope getMemberScope(@NotNull TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(10);
        }
        MemberScope memberScope = this.getMemberScope(typeSubstitution, DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (memberScope == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(11);
        }
        return memberScope;
    }

    @Override
    @NotNull
    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope memberScope = this.getUnsubstitutedMemberScope(DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this.original)));
        if (memberScope == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(12);
        }
        return memberScope;
    }

    @Override
    @NotNull
    public MemberScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(13);
        }
        MemberScope memberScope = this.original.getUnsubstitutedMemberScope(kotlinTypeRefiner);
        if (this.originalSubstitutor.isEmpty()) {
            MemberScope memberScope2 = memberScope;
            if (memberScope2 == null) {
                LazySubstitutingClassDescriptor.$$$reportNull$$$0(14);
            }
            return memberScope2;
        }
        return new SubstitutingScope(memberScope, this.getSubstitutor());
    }

    @Override
    @NotNull
    public MemberScope getStaticScope() {
        MemberScope memberScope = this.original.getStaticScope();
        if (memberScope == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(15);
        }
        return memberScope;
    }

    @Override
    @NotNull
    public SimpleType getDefaultType() {
        List<TypeProjection> typeProjections = TypeUtils.getDefaultTypeProjections(this.getTypeConstructor().getParameters());
        SimpleType simpleType = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(DefaultTypeAttributeTranslator.INSTANCE.toAttributes(this.getAnnotations(), null, null), this.getTypeConstructor(), typeProjections, false, this.getUnsubstitutedMemberScope());
        if (simpleType == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(16);
        }
        return simpleType;
    }

    @Override
    @NotNull
    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        throw new UnsupportedOperationException();
    }

    @Override
    @NotNull
    public List<ReceiverParameterDescriptor> getContextReceivers() {
        List<ReceiverParameterDescriptor> list = Collections.emptyList();
        if (list == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(17);
        }
        return list;
    }

    @Override
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors() {
        Collection<ClassConstructorDescriptor> originalConstructors = this.original.getConstructors();
        ArrayList<ClassConstructorDescriptor> result = new ArrayList<ClassConstructorDescriptor>(originalConstructors.size());
        for (ClassConstructorDescriptor constructor : originalConstructors) {
            ClassConstructorDescriptor copy = (ClassConstructorDescriptor)constructor.newCopyBuilder().setOriginal(constructor.getOriginal()).setModality(constructor.getModality()).setVisibility(constructor.getVisibility()).setKind(constructor.getKind()).setCopyOverrides(false).build();
            result.add(copy.substitute(this.getSubstitutor()));
        }
        ArrayList<ClassConstructorDescriptor> arrayList = result;
        if (arrayList == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(18);
        }
        return arrayList;
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        Annotations annotations = this.original.getAnnotations();
        if (annotations == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(19);
        }
        return annotations;
    }

    @Override
    @NotNull
    public Name getName() {
        Name name = this.original.getName();
        if (name == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(20);
        }
        return name;
    }

    @Override
    @NotNull
    public ClassDescriptor getOriginal() {
        ClassifierDescriptor classifierDescriptor = this.original.getOriginal();
        if (classifierDescriptor == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(21);
        }
        return classifierDescriptor;
    }

    @Override
    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.original.getContainingDeclaration();
        if (declarationDescriptor == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(22);
        }
        return declarationDescriptor;
    }

    @Override
    @NotNull
    public ClassDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
        if (substitutor == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(23);
        }
        if (substitutor.isEmpty()) {
            LazySubstitutingClassDescriptor lazySubstitutingClassDescriptor = this;
            if (lazySubstitutingClassDescriptor == null) {
                LazySubstitutingClassDescriptor.$$$reportNull$$$0(24);
            }
            return lazySubstitutingClassDescriptor;
        }
        return new LazySubstitutingClassDescriptor(this, TypeSubstitutor.createChainedSubstitutor(substitutor.getSubstitution(), this.getSubstitutor().getSubstitution()));
    }

    @Override
    public ClassDescriptor getCompanionObjectDescriptor() {
        return this.original.getCompanionObjectDescriptor();
    }

    @Override
    @NotNull
    public ClassKind getKind() {
        ClassKind classKind = this.original.getKind();
        if (classKind == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(25);
        }
        return classKind;
    }

    @Override
    @NotNull
    public Modality getModality() {
        Modality modality2 = this.original.getModality();
        if (modality2 == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(26);
        }
        return modality2;
    }

    @Override
    @NotNull
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.original.getVisibility();
        if (descriptorVisibility == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(27);
        }
        return descriptorVisibility;
    }

    @Override
    public boolean isInner() {
        return this.original.isInner();
    }

    @Override
    public boolean isData() {
        return this.original.isData();
    }

    @Override
    public boolean isInline() {
        return this.original.isInline();
    }

    @Override
    public boolean isFun() {
        return this.original.isFun();
    }

    @Override
    public boolean isValue() {
        return this.original.isValue();
    }

    @Override
    public boolean isExternal() {
        return this.original.isExternal();
    }

    @Override
    public boolean isCompanionObject() {
        return this.original.isCompanionObject();
    }

    @Override
    public boolean isExpect() {
        return this.original.isExpect();
    }

    @Override
    public boolean isActual() {
        return this.original.isActual();
    }

    @Override
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor2, D data) {
        return visitor2.visitClassDescriptor(this, data);
    }

    @Override
    @NotNull
    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope memberScope = this.original.getUnsubstitutedInnerClassesScope();
        if (memberScope == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(28);
        }
        return memberScope;
    }

    @Override
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return this.original.getUnsubstitutedPrimaryConstructor();
    }

    @Override
    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        if (sourceElement == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(29);
        }
        return sourceElement;
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        this.getSubstitutor();
        List<TypeParameterDescriptor> list = this.declaredTypeParameters;
        if (list == null) {
            LazySubstitutingClassDescriptor.$$$reportNull$$$0(30);
        }
        return list;
    }

    @Override
    @Nullable
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        ValueClassRepresentation<SimpleType> representation = this.original.getValueClassRepresentation();
        if (representation == null) {
            return null;
        }
        return representation.mapUnderlyingType(new Function1<SimpleType, SimpleType>(){

            @Override
            public SimpleType invoke(SimpleType type) {
                return LazySubstitutingClassDescriptor.this.substituteSimpleType(type);
            }
        });
    }

    @Nullable
    private SimpleType substituteSimpleType(@Nullable SimpleType type) {
        if (type == null || this.originalSubstitutor.isEmpty()) {
            return type;
        }
        TypeSubstitutor substitutor = this.getSubstitutor();
        KotlinType substitutedType = substitutor.substitute(type, Variance.INVARIANT);
        assert (substitutedType instanceof SimpleType) : "Substitution for SimpleType should also be a SimpleType, but it is " + substitutedType + "\nUnsubstituted: " + type;
        return (SimpleType)substitutedType;
    }

    private static /* synthetic */ void $$$reportNull$$$0(int n2) {
        RuntimeException runtimeException;
        Object[] objectArray;
        Object[] objectArray2;
        int n3;
        String string;
        switch (n2) {
            default: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
            case 2: 
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 10: 
            case 13: 
            case 23: {
                string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
            }
        }
        switch (n2) {
            default: {
                n3 = 2;
                break;
            }
            case 2: 
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 10: 
            case 13: 
            case 23: {
                n3 = 3;
                break;
            }
        }
        Object[] objectArray3 = new Object[n3];
        switch (n2) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                break;
            }
            case 2: 
            case 8: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeArguments";
                break;
            }
            case 3: 
            case 6: 
            case 13: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlinTypeRefiner";
                break;
            }
            case 5: 
            case 10: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeSubstitution";
                break;
            }
            case 23: {
                objectArray2 = objectArray3;
                objectArray3[0] = "substitutor";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "getTypeConstructor";
                break;
            }
            case 2: 
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 10: 
            case 13: 
            case 23: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                break;
            }
            case 4: 
            case 7: 
            case 9: 
            case 11: {
                objectArray = objectArray2;
                objectArray2[1] = "getMemberScope";
                break;
            }
            case 12: 
            case 14: {
                objectArray = objectArray2;
                objectArray2[1] = "getUnsubstitutedMemberScope";
                break;
            }
            case 15: {
                objectArray = objectArray2;
                objectArray2[1] = "getStaticScope";
                break;
            }
            case 16: {
                objectArray = objectArray2;
                objectArray2[1] = "getDefaultType";
                break;
            }
            case 17: {
                objectArray = objectArray2;
                objectArray2[1] = "getContextReceivers";
                break;
            }
            case 18: {
                objectArray = objectArray2;
                objectArray2[1] = "getConstructors";
                break;
            }
            case 19: {
                objectArray = objectArray2;
                objectArray2[1] = "getAnnotations";
                break;
            }
            case 20: {
                objectArray = objectArray2;
                objectArray2[1] = "getName";
                break;
            }
            case 21: {
                objectArray = objectArray2;
                objectArray2[1] = "getOriginal";
                break;
            }
            case 22: {
                objectArray = objectArray2;
                objectArray2[1] = "getContainingDeclaration";
                break;
            }
            case 24: {
                objectArray = objectArray2;
                objectArray2[1] = "substitute";
                break;
            }
            case 25: {
                objectArray = objectArray2;
                objectArray2[1] = "getKind";
                break;
            }
            case 26: {
                objectArray = objectArray2;
                objectArray2[1] = "getModality";
                break;
            }
            case 27: {
                objectArray = objectArray2;
                objectArray2[1] = "getVisibility";
                break;
            }
            case 28: {
                objectArray = objectArray2;
                objectArray2[1] = "getUnsubstitutedInnerClassesScope";
                break;
            }
            case 29: {
                objectArray = objectArray2;
                objectArray2[1] = "getSource";
                break;
            }
            case 30: {
                objectArray = objectArray2;
                objectArray2[1] = "getDeclaredTypeParameters";
                break;
            }
            case 31: {
                objectArray = objectArray2;
                objectArray2[1] = "getSealedSubclasses";
                break;
            }
        }
        switch (n2) {
            default: {
                break;
            }
            case 2: 
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 10: {
                objectArray = objectArray;
                objectArray[2] = "getMemberScope";
                break;
            }
            case 13: {
                objectArray = objectArray;
                objectArray[2] = "getUnsubstitutedMemberScope";
                break;
            }
            case 23: {
                objectArray = objectArray;
                objectArray[2] = "substitute";
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n2) {
            default: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
            case 2: 
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 10: 
            case 13: 
            case 23: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
        }
        throw runtimeException;
    }
}

