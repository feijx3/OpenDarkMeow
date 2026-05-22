/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder$$Util;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaPackageFragmentProvider
implements PackageFragmentProviderOptimized {
    @NotNull
    private final LazyJavaResolverContext c;
    @NotNull
    private final CacheWithNotNullValues<FqName, LazyJavaPackageFragment> packageFragments;

    public LazyJavaPackageFragmentProvider(@NotNull JavaResolverComponents components) {
        Intrinsics.checkNotNullParameter(components, "components");
        this.c = new LazyJavaResolverContext(components, TypeParameterResolver.EMPTY.INSTANCE, LazyKt.lazyOf(null));
        this.packageFragments = this.c.getStorageManager().createCacheWithNotNullValues();
    }

    private final LazyJavaPackageFragment getPackageFragment(FqName fqName) {
        JavaPackage jPackage;
        JavaPackage javaPackage = JavaClassFinder$$Util.findPackage$default(this.c.getComponents().getFinder(), fqName, false, 2, null);
        if (javaPackage == null) {
            return null;
        }
        JavaPackage javaPackage2 = jPackage = javaPackage;
        LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider = this;
        return this.packageFragments.computeIfAbsent(fqName, new LazyJavaPackageFragmentProvider$$Lambda$0(lazyJavaPackageFragmentProvider, javaPackage2));
    }

    @Deprecated(message="for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    @NotNull
    public List<LazyJavaPackageFragment> getPackageFragments(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return CollectionsKt.listOfNotNull(this.getPackageFragment(fqName));
    }

    @Override
    public void collectPackageFragments(@NotNull FqName fqName, @NotNull Collection<PackageFragmentDescriptor> packageFragments) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(packageFragments, "packageFragments");
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(packageFragments, this.getPackageFragment(fqName));
    }

    @Override
    public boolean isEmpty(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return JavaClassFinder$$Util.findPackage$default(this.c.getComponents().getFinder(), fqName, false, 2, null) == null;
    }

    @NotNull
    public List<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        LazyJavaPackageFragment lazyJavaPackageFragment = this.getPackageFragment(fqName);
        List<FqName> list = lazyJavaPackageFragment != null ? lazyJavaPackageFragment.getSubPackageFqNames$descriptors_jvm() : null;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    @NotNull
    public String toString() {
        return "LazyJavaPackageFragmentProvider of module " + this.c.getComponents().getModule();
    }

    private static final LazyJavaPackageFragment getPackageFragment$lambda$0(LazyJavaPackageFragmentProvider this$0, JavaPackage $jPackage) {
        return new LazyJavaPackageFragment(this$0.c, $jPackage);
    }

    static /* synthetic */ LazyJavaPackageFragment accessor$LazyJavaPackageFragmentProvider$lambda0(LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, JavaPackage javaPackage) {
        return LazyJavaPackageFragmentProvider.getPackageFragment$lambda$0(lazyJavaPackageFragmentProvider, javaPackage);
    }
}

