/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ClassDescriptorImpl
extends ClassDescriptorBase {
    private final Modality modality;
    private final ClassKind kind;
    private final TypeConstructor typeConstructor;
    private MemberScope unsubstitutedMemberScope;
    private Set<ClassConstructorDescriptor> constructors;
    private ClassConstructorDescriptor primaryConstructor;

    public ClassDescriptorImpl(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Name name, @NotNull Modality modality2, @NotNull ClassKind kind2, @NotNull Collection<KotlinType> supertypes, @NotNull SourceElement source, boolean isExternal, @NotNull StorageManager storageManager) {
        if (containingDeclaration == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(0);
        }
        if (name == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(1);
        }
        if (modality2 == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(2);
        }
        if (kind2 == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(3);
        }
        if (supertypes == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(4);
        }
        if (source == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(5);
        }
        if (storageManager == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(6);
        }
        super(storageManager, containingDeclaration, name, source, isExternal);
        assert (modality2 != Modality.SEALED) : "Implement getSealedSubclasses() for this class: " + this.getClass();
        this.modality = modality2;
        this.kind = kind2;
        this.typeConstructor = new ClassTypeConstructorImpl(this, Collections.emptyList(), supertypes, storageManager);
    }

    public final void initialize(@NotNull MemberScope unsubstitutedMemberScope, @NotNull Set<ClassConstructorDescriptor> constructors2, @Nullable ClassConstructorDescriptor primaryConstructor) {
        if (unsubstitutedMemberScope == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(7);
        }
        if (constructors2 == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(8);
        }
        this.unsubstitutedMemberScope = unsubstitutedMemberScope;
        this.constructors = constructors2;
        this.primaryConstructor = primaryConstructor;
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        Annotations annotations = Annotations.Companion.getEMPTY();
        if (annotations == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(9);
        }
        return annotations;
    }

    @Override
    @NotNull
    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor2 = this.typeConstructor;
        if (typeConstructor2 == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(10);
        }
        return typeConstructor2;
    }

    @Override
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors() {
        Set<ClassConstructorDescriptor> set = this.constructors;
        if (set == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(11);
        }
        return set;
    }

    @Override
    @NotNull
    public MemberScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(12);
        }
        MemberScope memberScope = this.unsubstitutedMemberScope;
        if (memberScope == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(13);
        }
        return memberScope;
    }

    @Override
    @NotNull
    public MemberScope getStaticScope() {
        MemberScope.Empty empty = MemberScope.Empty.INSTANCE;
        if (empty == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(14);
        }
        return empty;
    }

    @Override
    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override
    @NotNull
    public ClassKind getKind() {
        ClassKind classKind = this.kind;
        if (classKind == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(15);
        }
        return classKind;
    }

    @Override
    public boolean isCompanionObject() {
        return false;
    }

    @Override
    public boolean isExpect() {
        return false;
    }

    @Override
    public boolean isActual() {
        return false;
    }

    @Override
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return this.primaryConstructor;
    }

    @Override
    @NotNull
    public Modality getModality() {
        Modality modality2 = this.modality;
        if (modality2 == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(16);
        }
        return modality2;
    }

    @Override
    @NotNull
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PUBLIC;
        if (descriptorVisibility == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(17);
        }
        return descriptorVisibility;
    }

    @Override
    public boolean isData() {
        return false;
    }

    @Override
    public boolean isInline() {
        return false;
    }

    @Override
    public boolean isFun() {
        return false;
    }

    @Override
    public boolean isValue() {
        return false;
    }

    @Override
    public boolean isInner() {
        return false;
    }

    public String toString() {
        return "class " + this.getName();
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> list = Collections.emptyList();
        if (list == null) {
            ClassDescriptorImpl.$$$reportNull$$$0(18);
        }
        return list;
    }

    @Override
    @Nullable
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
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
            case 9: 
            case 10: 
            case 11: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
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
            case 9: 
            case 10: 
            case 11: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: {
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
                objectArray3[0] = "name";
                break;
            }
            case 2: {
                objectArray2 = objectArray3;
                objectArray3[0] = "modality";
                break;
            }
            case 3: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kind";
                break;
            }
            case 4: {
                objectArray2 = objectArray3;
                objectArray3[0] = "supertypes";
                break;
            }
            case 5: {
                objectArray2 = objectArray3;
                objectArray3[0] = "source";
                break;
            }
            case 6: {
                objectArray2 = objectArray3;
                objectArray3[0] = "storageManager";
                break;
            }
            case 7: {
                objectArray2 = objectArray3;
                objectArray3[0] = "unsubstitutedMemberScope";
                break;
            }
            case 8: {
                objectArray2 = objectArray3;
                objectArray3[0] = "constructors";
                break;
            }
            case 9: 
            case 10: 
            case 11: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            }
            case 12: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlinTypeRefiner";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            }
            case 9: {
                objectArray = objectArray2;
                objectArray2[1] = "getAnnotations";
                break;
            }
            case 10: {
                objectArray = objectArray2;
                objectArray2[1] = "getTypeConstructor";
                break;
            }
            case 11: {
                objectArray = objectArray2;
                objectArray2[1] = "getConstructors";
                break;
            }
            case 13: {
                objectArray = objectArray2;
                objectArray2[1] = "getUnsubstitutedMemberScope";
                break;
            }
            case 14: {
                objectArray = objectArray2;
                objectArray2[1] = "getStaticScope";
                break;
            }
            case 15: {
                objectArray = objectArray2;
                objectArray2[1] = "getKind";
                break;
            }
            case 16: {
                objectArray = objectArray2;
                objectArray2[1] = "getModality";
                break;
            }
            case 17: {
                objectArray = objectArray2;
                objectArray2[1] = "getVisibility";
                break;
            }
            case 18: {
                objectArray = objectArray2;
                objectArray2[1] = "getDeclaredTypeParameters";
                break;
            }
            case 19: {
                objectArray = objectArray2;
                objectArray2[1] = "getSealedSubclasses";
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
                objectArray = objectArray;
                objectArray[2] = "initialize";
                break;
            }
            case 9: 
            case 10: 
            case 11: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: {
                break;
            }
            case 12: {
                objectArray = objectArray;
                objectArray[2] = "getUnsubstitutedMemberScope";
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
            case 10: 
            case 11: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }
}

