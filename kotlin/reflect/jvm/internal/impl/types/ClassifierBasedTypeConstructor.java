/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nClassifierBasedTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassifierBasedTypeConstructor.kt\norg/jetbrains/kotlin/types/ClassifierBasedTypeConstructor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,81:1\n1#2:82\n*E\n"})
public abstract class ClassifierBasedTypeConstructor
implements TypeConstructor {
    private int hashCode;

    @Override
    @NotNull
    public abstract ClassifierDescriptor getDeclarationDescriptor();

    public int hashCode() {
        int computedHashCode;
        int n2;
        int cachedHashCode = this.hashCode;
        if (cachedHashCode != 0) {
            return cachedHashCode;
        }
        ClassifierDescriptor descriptor2 = this.getDeclarationDescriptor();
        int it = n2 = (computedHashCode = this.hasMeaningfulFqName(descriptor2) ? DescriptorUtils.getFqName(descriptor2).hashCode() : System.identityHashCode(this));
        boolean bl2 = false;
        this.hashCode = it;
        return n2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TypeConstructor)) {
            return false;
        }
        if (other.hashCode() != this.hashCode()) {
            return false;
        }
        if (((TypeConstructor)other).getParameters().size() != this.getParameters().size()) {
            return false;
        }
        ClassifierDescriptor myDescriptor = this.getDeclarationDescriptor();
        ClassifierDescriptor classifierDescriptor = ((TypeConstructor)other).getDeclarationDescriptor();
        if (classifierDescriptor == null) {
            return false;
        }
        ClassifierDescriptor otherDescriptor = classifierDescriptor;
        if (!this.hasMeaningfulFqName(myDescriptor) || !this.hasMeaningfulFqName(otherDescriptor)) {
            return false;
        }
        return this.isSameClassifier(otherDescriptor);
    }

    protected abstract boolean isSameClassifier(@NotNull ClassifierDescriptor var1);

    protected final boolean areFqNamesEqual(@NotNull ClassifierDescriptor first, @NotNull ClassifierDescriptor second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        if (!Intrinsics.areEqual(first.getName(), second.getName())) {
            return false;
        }
        DeclarationDescriptor a2 = first.getContainingDeclaration();
        for (DeclarationDescriptor b2 = second.getContainingDeclaration(); a2 != null && b2 != null; a2 = a2.getContainingDeclaration(), b2 = b2.getContainingDeclaration()) {
            if (a2 instanceof ModuleDescriptor) {
                return b2 instanceof ModuleDescriptor;
            }
            if (b2 instanceof ModuleDescriptor) {
                return false;
            }
            if (a2 instanceof PackageFragmentDescriptor) {
                return b2 instanceof PackageFragmentDescriptor && Intrinsics.areEqual(((PackageFragmentDescriptor)a2).getFqName(), ((PackageFragmentDescriptor)b2).getFqName());
            }
            if (b2 instanceof PackageFragmentDescriptor) {
                return false;
            }
            if (Intrinsics.areEqual(a2.getName(), b2.getName())) continue;
            return false;
        }
        return true;
    }

    private final boolean hasMeaningfulFqName(ClassifierDescriptor descriptor2) {
        return !ErrorUtils.isError(descriptor2) && !DescriptorUtils.isLocal(descriptor2);
    }
}

