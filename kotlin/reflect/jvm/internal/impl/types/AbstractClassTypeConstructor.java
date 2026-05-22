/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractClassTypeConstructor
extends AbstractTypeConstructor {
    public AbstractClassTypeConstructor(@NotNull StorageManager storageManager) {
        if (storageManager == null) {
            AbstractClassTypeConstructor.$$$reportNull$$$0(0);
        }
        super(storageManager);
    }

    @Override
    @NotNull
    public abstract ClassDescriptor getDeclarationDescriptor();

    @Override
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns kotlinBuiltIns = DescriptorUtilsKt.getBuiltIns(this.getDeclarationDescriptor());
        if (kotlinBuiltIns == null) {
            AbstractClassTypeConstructor.$$$reportNull$$$0(1);
        }
        return kotlinBuiltIns;
    }

    @Override
    protected boolean isSameClassifier(@NotNull ClassifierDescriptor classifier) {
        if (classifier == null) {
            AbstractClassTypeConstructor.$$$reportNull$$$0(2);
        }
        return classifier instanceof ClassDescriptor && this.areFqNamesEqual(this.getDeclarationDescriptor(), classifier);
    }

    @Override
    @NotNull
    protected Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean useCompanions) {
        DeclarationDescriptor containingDeclaration = this.getDeclarationDescriptor().getContainingDeclaration();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            List<KotlinType> list = Collections.emptyList();
            if (list == null) {
                AbstractClassTypeConstructor.$$$reportNull$$$0(3);
            }
            return list;
        }
        SmartList<KotlinType> additionalNeighbours = new SmartList<KotlinType>();
        ClassDescriptor containingClassDescriptor = (ClassDescriptor)containingDeclaration;
        additionalNeighbours.add(containingClassDescriptor.getDefaultType());
        ClassDescriptor companion = containingClassDescriptor.getCompanionObjectDescriptor();
        if (useCompanions && companion != null) {
            additionalNeighbours.add(companion.getDefaultType());
        }
        SmartList<KotlinType> smartList = additionalNeighbours;
        if (smartList == null) {
            AbstractClassTypeConstructor.$$$reportNull$$$0(4);
        }
        return smartList;
    }

    @Override
    @Nullable
    protected KotlinType defaultSupertypeIfEmpty() {
        if (KotlinBuiltIns.isSpecialClassWithNoSupertypes(this.getDeclarationDescriptor())) {
            return null;
        }
        return this.getBuiltIns().getAnyType();
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
            case 3: 
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
            case 1: 
            case 3: 
            case 4: {
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
            case 1: 
            case 3: 
            case 4: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
                break;
            }
            case 2: {
                objectArray2 = objectArray3;
                objectArray3[0] = "classifier";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
                break;
            }
            case 1: {
                objectArray = objectArray2;
                objectArray2[1] = "getBuiltIns";
                break;
            }
            case 3: 
            case 4: {
                objectArray = objectArray2;
                objectArray2[1] = "getAdditionalNeighboursInSupertypeGraph";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray;
                objectArray[2] = "<init>";
                break;
            }
            case 1: 
            case 3: 
            case 4: {
                break;
            }
            case 2: {
                objectArray = objectArray;
                objectArray[2] = "isSameClassifier";
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
            case 3: 
            case 4: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }
}

