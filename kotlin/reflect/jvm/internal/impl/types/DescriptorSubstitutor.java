/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DescriptorSubstitutor {
    @NotNull
    public static TypeSubstitutor substituteTypeParameters(@NotNull List<TypeParameterDescriptor> typeParameters, @NotNull TypeSubstitution originalSubstitution, @NotNull DeclarationDescriptor newContainingDeclaration, @NotNull List<TypeParameterDescriptor> result) {
        TypeSubstitutor substitutor;
        if (typeParameters == null) {
            DescriptorSubstitutor.$$$reportNull$$$0(0);
        }
        if (originalSubstitution == null) {
            DescriptorSubstitutor.$$$reportNull$$$0(1);
        }
        if (newContainingDeclaration == null) {
            DescriptorSubstitutor.$$$reportNull$$$0(2);
        }
        if (result == null) {
            DescriptorSubstitutor.$$$reportNull$$$0(3);
        }
        if ((substitutor = DescriptorSubstitutor.substituteTypeParameters(typeParameters, originalSubstitution, newContainingDeclaration, result, null)) == null) {
            throw new AssertionError((Object)"Substitution failed");
        }
        TypeSubstitutor typeSubstitutor2 = substitutor;
        if (typeSubstitutor2 == null) {
            DescriptorSubstitutor.$$$reportNull$$$0(4);
        }
        return typeSubstitutor2;
    }

    @Nullable
    public static TypeSubstitutor substituteTypeParameters(@NotNull List<TypeParameterDescriptor> typeParameters, @NotNull TypeSubstitution originalSubstitution, @NotNull DeclarationDescriptor newContainingDeclaration, @NotNull List<TypeParameterDescriptor> result, @Nullable boolean[] wereChanges) {
        if (typeParameters == null) {
            DescriptorSubstitutor.$$$reportNull$$$0(5);
        }
        if (originalSubstitution == null) {
            DescriptorSubstitutor.$$$reportNull$$$0(6);
        }
        if (newContainingDeclaration == null) {
            DescriptorSubstitutor.$$$reportNull$$$0(7);
        }
        if (result == null) {
            DescriptorSubstitutor.$$$reportNull$$$0(8);
        }
        HashMap<TypeConstructor, TypeProjectionImpl> mutableSubstitutionMap = new HashMap<TypeConstructor, TypeProjectionImpl>();
        HashMap<TypeParameterDescriptor, TypeParameterDescriptorImpl> substitutedMap = new HashMap<TypeParameterDescriptor, TypeParameterDescriptorImpl>();
        int index = 0;
        for (TypeParameterDescriptor descriptor2 : typeParameters) {
            TypeParameterDescriptorImpl substituted = TypeParameterDescriptorImpl.createForFurtherModification(newContainingDeclaration, descriptor2.getAnnotations(), descriptor2.isReified(), descriptor2.getVariance(), descriptor2.getName(), index++, SourceElement.NO_SOURCE, descriptor2.getStorageManager());
            mutableSubstitutionMap.put(descriptor2.getTypeConstructor(), new TypeProjectionImpl(substituted.getDefaultType()));
            substitutedMap.put(descriptor2, substituted);
            result.add(substituted);
        }
        TypeConstructorSubstitution mutableSubstitution = TypeConstructorSubstitution.createByConstructorsMap(mutableSubstitutionMap);
        TypeSubstitutor substitutor = TypeSubstitutor.createChainedSubstitutor(originalSubstitution, mutableSubstitution);
        TypeSubstitutor nonApproximatingSubstitutor = TypeSubstitutor.createChainedSubstitutor(originalSubstitution.replaceWithNonApproximating(), mutableSubstitution);
        for (TypeParameterDescriptor descriptor3 : typeParameters) {
            TypeParameterDescriptorImpl substituted = (TypeParameterDescriptorImpl)substitutedMap.get(descriptor3);
            for (KotlinType upperBound : descriptor3.getUpperBounds()) {
                ClassifierDescriptor upperBoundDeclaration = upperBound.getConstructor().getDeclarationDescriptor();
                TypeSubstitutor boundSubstitutor = upperBoundDeclaration instanceof TypeParameterDescriptor && TypeUtilsKt.hasTypeParameterRecursiveBounds((TypeParameterDescriptor)upperBoundDeclaration) ? substitutor : nonApproximatingSubstitutor;
                KotlinType substitutedBound = boundSubstitutor.substitute(upperBound, Variance.OUT_VARIANCE);
                if (substitutedBound == null) {
                    return null;
                }
                if (substitutedBound != upperBound && wereChanges != null) {
                    wereChanges[0] = true;
                }
                substituted.addUpperBound(substitutedBound);
            }
            substituted.setInitialized();
        }
        return substitutor;
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
            case 4: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n2) {
            default: {
                n3 = 3;
                break;
            }
            case 4: {
                n3 = 2;
                break;
            }
        }
        Object[] objectArray3 = new Object[n3];
        switch (n2) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeParameters";
                break;
            }
            case 1: 
            case 6: {
                objectArray2 = objectArray3;
                objectArray3[0] = "originalSubstitution";
                break;
            }
            case 2: 
            case 7: {
                objectArray2 = objectArray3;
                objectArray3[0] = "newContainingDeclaration";
                break;
            }
            case 3: 
            case 8: {
                objectArray2 = objectArray3;
                objectArray3[0] = "result";
                break;
            }
            case 4: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            }
            case 4: {
                objectArray = objectArray2;
                objectArray2[1] = "substituteTypeParameters";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray;
                objectArray[2] = "substituteTypeParameters";
                break;
            }
            case 4: {
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n2) {
            default: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
            case 4: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }
}

