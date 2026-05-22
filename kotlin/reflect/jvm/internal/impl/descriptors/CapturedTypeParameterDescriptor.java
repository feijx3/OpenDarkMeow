/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

final class CapturedTypeParameterDescriptor
implements TypeParameterDescriptor {
    @NotNull
    private final TypeParameterDescriptor originalDescriptor;
    @NotNull
    private final DeclarationDescriptor declarationDescriptor;
    private final int declaredTypeParametersCount;

    public CapturedTypeParameterDescriptor(@NotNull TypeParameterDescriptor originalDescriptor, @NotNull DeclarationDescriptor declarationDescriptor, int declaredTypeParametersCount) {
        Intrinsics.checkNotNullParameter(originalDescriptor, "originalDescriptor");
        Intrinsics.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        this.originalDescriptor = originalDescriptor;
        this.declarationDescriptor = declarationDescriptor;
        this.declaredTypeParametersCount = declaredTypeParametersCount;
    }

    @Override
    public boolean isCapturedFromOuterDeclaration() {
        return true;
    }

    @Override
    @NotNull
    public TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor typeParameterDescriptor = this.originalDescriptor.getOriginal();
        Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "getOriginal(...)");
        return typeParameterDescriptor;
    }

    @Override
    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        return this.declarationDescriptor;
    }

    @Override
    public int getIndex() {
        return this.declaredTypeParametersCount + this.originalDescriptor.getIndex();
    }

    @NotNull
    public String toString() {
        return this.originalDescriptor + "[inner-copy]";
    }

    @Override
    public boolean isReified() {
        return this.originalDescriptor.isReified();
    }

    @Override
    @NotNull
    public Variance getVariance() {
        Variance variance = this.originalDescriptor.getVariance();
        Intrinsics.checkNotNullExpressionValue((Object)variance, "getVariance(...)");
        return variance;
    }

    @Override
    @NotNull
    public List<KotlinType> getUpperBounds() {
        List<KotlinType> list = this.originalDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(list, "getUpperBounds(...)");
        return list;
    }

    @Override
    @NotNull
    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor2 = this.originalDescriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
        return typeConstructor2;
    }

    @Override
    @NotNull
    public StorageManager getStorageManager() {
        StorageManager storageManager = this.originalDescriptor.getStorageManager();
        Intrinsics.checkNotNullExpressionValue(storageManager, "getStorageManager(...)");
        return storageManager;
    }

    @Override
    @NotNull
    public SimpleType getDefaultType() {
        SimpleType simpleType = this.originalDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(simpleType, "getDefaultType(...)");
        return simpleType;
    }

    @Override
    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = this.originalDescriptor.getSource();
        Intrinsics.checkNotNullExpressionValue(sourceElement, "getSource(...)");
        return sourceElement;
    }

    @Override
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor2, D data) {
        return this.originalDescriptor.accept(visitor2, data);
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        return this.originalDescriptor.getAnnotations();
    }

    @Override
    @NotNull
    public Name getName() {
        Name name = this.originalDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }
}

