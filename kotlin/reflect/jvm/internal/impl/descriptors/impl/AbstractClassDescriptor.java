/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyClassReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.LazySubstitutingClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractClassDescriptor
extends ModuleAwareClassDescriptor {
    private final Name name;
    protected final NotNullLazyValue<SimpleType> defaultType;
    private final NotNullLazyValue<MemberScope> unsubstitutedInnerClassesScope;
    private final NotNullLazyValue<ReceiverParameterDescriptor> thisAsReceiverParameter;

    public AbstractClassDescriptor(@NotNull StorageManager storageManager, @NotNull Name name) {
        if (storageManager == null) {
            AbstractClassDescriptor.$$$reportNull$$$0(0);
        }
        if (name == null) {
            AbstractClassDescriptor.$$$reportNull$$$0(1);
        }
        this.name = name;
        this.defaultType = storageManager.createLazyValue(new Function0<SimpleType>(){

            @Override
            public SimpleType invoke() {
                return TypeUtils.makeUnsubstitutedType(AbstractClassDescriptor.this, AbstractClassDescriptor.this.getUnsubstitutedMemberScope(), new Function1<KotlinTypeRefiner, SimpleType>(){

                    @Override
                    public SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
                        ClassifierDescriptor descriptor2 = kotlinTypeRefiner.refineDescriptor(AbstractClassDescriptor.this);
                        if (descriptor2 == null) {
                            return (SimpleType)AbstractClassDescriptor.this.defaultType.invoke();
                        }
                        if (descriptor2 instanceof TypeAliasDescriptor) {
                            return KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor)descriptor2, TypeUtils.getDefaultTypeProjections(descriptor2.getTypeConstructor().getParameters()));
                        }
                        if (descriptor2 instanceof ModuleAwareClassDescriptor) {
                            TypeConstructor refinedConstructor = descriptor2.getTypeConstructor().refine(kotlinTypeRefiner);
                            return TypeUtils.makeUnsubstitutedType(refinedConstructor, ((ModuleAwareClassDescriptor)descriptor2).getUnsubstitutedMemberScope(kotlinTypeRefiner), (Function1<KotlinTypeRefiner, SimpleType>)this);
                        }
                        return descriptor2.getDefaultType();
                    }
                });
            }
        });
        this.unsubstitutedInnerClassesScope = storageManager.createLazyValue(new Function0<MemberScope>(){

            @Override
            public MemberScope invoke() {
                return new InnerClassesScopeWrapper(AbstractClassDescriptor.this.getUnsubstitutedMemberScope());
            }
        });
        this.thisAsReceiverParameter = storageManager.createLazyValue(new Function0<ReceiverParameterDescriptor>(){

            @Override
            public ReceiverParameterDescriptor invoke() {
                return new LazyClassReceiverParameterDescriptor(AbstractClassDescriptor.this);
            }
        });
    }

    @Override
    @NotNull
    public Name getName() {
        Name name = this.name;
        if (name == null) {
            AbstractClassDescriptor.$$$reportNull$$$0(2);
        }
        return name;
    }

    @Override
    @NotNull
    public ClassDescriptor getOriginal() {
        AbstractClassDescriptor abstractClassDescriptor = this;
        if (abstractClassDescriptor == null) {
            AbstractClassDescriptor.$$$reportNull$$$0(3);
        }
        return abstractClassDescriptor;
    }

    @Override
    @NotNull
    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope memberScope = (MemberScope)this.unsubstitutedInnerClassesScope.invoke();
        if (memberScope == null) {
            AbstractClassDescriptor.$$$reportNull$$$0(4);
        }
        return memberScope;
    }

    @Override
    @NotNull
    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        ReceiverParameterDescriptor receiverParameterDescriptor = (ReceiverParameterDescriptor)this.thisAsReceiverParameter.invoke();
        if (receiverParameterDescriptor == null) {
            AbstractClassDescriptor.$$$reportNull$$$0(5);
        }
        return receiverParameterDescriptor;
    }

    @Override
    @NotNull
    public List<ReceiverParameterDescriptor> getContextReceivers() {
        List<ReceiverParameterDescriptor> list = Collections.emptyList();
        if (list == null) {
            AbstractClassDescriptor.$$$reportNull$$$0(6);
        }
        return list;
    }

    @Override
    @NotNull
    public MemberScope getMemberScope(@NotNull TypeSubstitution typeSubstitution, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        if (typeSubstitution == null) {
            AbstractClassDescriptor.$$$reportNull$$$0(10);
        }
        if (kotlinTypeRefiner == null) {
            AbstractClassDescriptor.$$$reportNull$$$0(11);
        }
        if (typeSubstitution.isEmpty()) {
            MemberScope memberScope = this.getUnsubstitutedMemberScope(kotlinTypeRefiner);
            if (memberScope == null) {
                AbstractClassDescriptor.$$$reportNull$$$0(12);
            }
            return memberScope;
        }
        TypeSubstitutor substitutor = TypeSubstitutor.create(typeSubstitution);
        return new SubstitutingScope(this.getUnsubstitutedMemberScope(kotlinTypeRefiner), substitutor);
    }

    @Override
    @NotNull
    public MemberScope getMemberScope(@NotNull TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            AbstractClassDescriptor.$$$reportNull$$$0(15);
        }
        MemberScope memberScope = this.getMemberScope(typeSubstitution, DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (memberScope == null) {
            AbstractClassDescriptor.$$$reportNull$$$0(16);
        }
        return memberScope;
    }

    @Override
    @NotNull
    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope memberScope = this.getUnsubstitutedMemberScope(DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (memberScope == null) {
            AbstractClassDescriptor.$$$reportNull$$$0(17);
        }
        return memberScope;
    }

    @Override
    @NotNull
    public ClassDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
        if (substitutor == null) {
            AbstractClassDescriptor.$$$reportNull$$$0(18);
        }
        if (substitutor.isEmpty()) {
            AbstractClassDescriptor abstractClassDescriptor = this;
            if (abstractClassDescriptor == null) {
                AbstractClassDescriptor.$$$reportNull$$$0(19);
            }
            return abstractClassDescriptor;
        }
        return new LazySubstitutingClassDescriptor(this, substitutor);
    }

    @Override
    @NotNull
    public SimpleType getDefaultType() {
        SimpleType simpleType = (SimpleType)this.defaultType.invoke();
        if (simpleType == null) {
            AbstractClassDescriptor.$$$reportNull$$$0(20);
        }
        return simpleType;
    }

    @Override
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor2, D data) {
        return visitor2.visitClassDescriptor(this, data);
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
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 9: 
            case 12: 
            case 14: 
            case 16: 
            case 17: 
            case 19: 
            case 20: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n2) {
            default: {
                n3 = 3;
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 9: 
            case 12: 
            case 14: 
            case 16: 
            case 17: 
            case 19: 
            case 20: {
                n3 = 2;
                break;
            }
        }
        Object[] objectArray3 = new Object[n3];
        switch (n2) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "storageManager";
                break;
            }
            case 1: {
                objectArray2 = objectArray3;
                objectArray3[0] = "name";
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 9: 
            case 12: 
            case 14: 
            case 16: 
            case 17: 
            case 19: 
            case 20: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            }
            case 7: 
            case 13: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeArguments";
                break;
            }
            case 8: 
            case 11: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlinTypeRefiner";
                break;
            }
            case 10: 
            case 15: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeSubstitution";
                break;
            }
            case 18: {
                objectArray2 = objectArray3;
                objectArray3[0] = "substitutor";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            }
            case 2: {
                objectArray = objectArray2;
                objectArray2[1] = "getName";
                break;
            }
            case 3: {
                objectArray = objectArray2;
                objectArray2[1] = "getOriginal";
                break;
            }
            case 4: {
                objectArray = objectArray2;
                objectArray2[1] = "getUnsubstitutedInnerClassesScope";
                break;
            }
            case 5: {
                objectArray = objectArray2;
                objectArray2[1] = "getThisAsReceiverParameter";
                break;
            }
            case 6: {
                objectArray = objectArray2;
                objectArray2[1] = "getContextReceivers";
                break;
            }
            case 9: 
            case 12: 
            case 14: 
            case 16: {
                objectArray = objectArray2;
                objectArray2[1] = "getMemberScope";
                break;
            }
            case 17: {
                objectArray = objectArray2;
                objectArray2[1] = "getUnsubstitutedMemberScope";
                break;
            }
            case 19: {
                objectArray = objectArray2;
                objectArray2[1] = "substitute";
                break;
            }
            case 20: {
                objectArray = objectArray2;
                objectArray2[1] = "getDefaultType";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray;
                objectArray[2] = "<init>";
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 9: 
            case 12: 
            case 14: 
            case 16: 
            case 17: 
            case 19: 
            case 20: {
                break;
            }
            case 7: 
            case 8: 
            case 10: 
            case 11: 
            case 13: 
            case 15: {
                objectArray = objectArray;
                objectArray[2] = "getMemberScope";
                break;
            }
            case 18: {
                objectArray = objectArray;
                objectArray[2] = "substitute";
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n2) {
            default: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 9: 
            case 12: 
            case 14: 
            case 16: 
            case 17: 
            case 19: 
            case 20: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }
}

