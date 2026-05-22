/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractDeserializedPackageFragmentProvider
implements PackageFragmentProviderOptimized {
    @NotNull
    private final StorageManager storageManager;
    @NotNull
    private final KotlinMetadataFinder finder;
    @NotNull
    private final ModuleDescriptor moduleDescriptor;
    protected DeserializationComponents components;
    @NotNull
    private final MemoizedFunctionToNullable<FqName, PackageFragmentDescriptor> fragments;

    public AbstractDeserializedPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull KotlinMetadataFinder finder, @NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(finder, "finder");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        this.storageManager = storageManager;
        this.finder = finder;
        this.moduleDescriptor = moduleDescriptor;
        AbstractDeserializedPackageFragmentProvider abstractDeserializedPackageFragmentProvider = this;
        this.fragments = this.storageManager.createMemoizedFunctionWithNullableValues(new AbstractDeserializedPackageFragmentProvider$$Lambda$0(abstractDeserializedPackageFragmentProvider));
    }

    @NotNull
    protected final StorageManager getStorageManager() {
        return this.storageManager;
    }

    @NotNull
    protected final KotlinMetadataFinder getFinder() {
        return this.finder;
    }

    @NotNull
    protected final ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    @NotNull
    protected final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents != null) {
            return deserializationComponents;
        }
        Intrinsics.throwUninitializedPropertyAccessException("components");
        return null;
    }

    protected final void setComponents(@NotNull DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }

    @Nullable
    protected abstract DeserializedPackageFragment findPackage(@NotNull FqName var1);

    @Override
    public void collectPackageFragments(@NotNull FqName fqName, @NotNull Collection<PackageFragmentDescriptor> packageFragments) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(packageFragments, "packageFragments");
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(packageFragments, this.fragments.invoke(fqName));
    }

    @Override
    public boolean isEmpty(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        PackageFragmentDescriptor descriptor2 = this.fragments.isComputed(fqName) ? (PackageFragmentDescriptor)this.fragments.invoke(fqName) : (PackageFragmentDescriptor)this.findPackage(fqName);
        return descriptor2 == null;
    }

    @Override
    @Deprecated(message="for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    @NotNull
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return CollectionsKt.listOfNotNull(this.fragments.invoke(fqName));
    }

    @Override
    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return SetsKt.emptySet();
    }

    private static final PackageFragmentDescriptor fragments$lambda$1(AbstractDeserializedPackageFragmentProvider this$0, FqName fqName) {
        DeserializedPackageFragment deserializedPackageFragment;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        DeserializedPackageFragment deserializedPackageFragment2 = this$0.findPackage(fqName);
        if (deserializedPackageFragment2 != null) {
            DeserializedPackageFragment deserializedPackageFragment3;
            DeserializedPackageFragment $this$fragments_u24lambda_u241_u24lambda_u240 = deserializedPackageFragment3 = deserializedPackageFragment2;
            boolean bl2 = false;
            $this$fragments_u24lambda_u241_u24lambda_u240.initialize(this$0.getComponents());
            deserializedPackageFragment = deserializedPackageFragment3;
        } else {
            deserializedPackageFragment = null;
        }
        return deserializedPackageFragment;
    }

    static /* synthetic */ PackageFragmentDescriptor accessor$AbstractDeserializedPackageFragmentProvider$lambda0(AbstractDeserializedPackageFragmentProvider abstractDeserializedPackageFragmentProvider, FqName fqName) {
        return AbstractDeserializedPackageFragmentProvider.fragments$lambda$1(abstractDeserializedPackageFragmentProvider, fqName);
    }
}

