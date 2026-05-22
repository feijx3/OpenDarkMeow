/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Deprecated;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nCompositePackageFragmentProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompositePackageFragmentProvider.kt\norg/jetbrains/kotlin/descriptors/impl/CompositePackageFragmentProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n1740#2,3:64\n*S KotlinDebug\n*F\n+ 1 CompositePackageFragmentProvider.kt\norg/jetbrains/kotlin/descriptors/impl/CompositePackageFragmentProvider\n*L\n51#1:64,3\n*E\n"})
public final class CompositePackageFragmentProvider
implements PackageFragmentProviderOptimized {
    @NotNull
    private final List<PackageFragmentProvider> providers;
    @NotNull
    private final String debugName;

    public CompositePackageFragmentProvider(@NotNull List<? extends PackageFragmentProvider> providers, @NotNull String debugName) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(providers, "providers");
        Intrinsics.checkNotNullParameter(debugName, "debugName");
        this.providers = providers;
        this.debugName = debugName;
        boolean bl3 = bl2 = this.providers.size() == CollectionsKt.toSet((Iterable)this.providers).size();
        if (_Assertions.ENABLED && !bl2) {
            boolean bl4 = false;
            String string = "providers.size is " + this.providers.size() + " while only " + CollectionsKt.toSet((Iterable)this.providers).size() + " unique providers";
            throw new AssertionError((Object)string);
        }
    }

    @Override
    @Deprecated(message="for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    @NotNull
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        ArrayList result = new ArrayList();
        for (PackageFragmentProvider provider : this.providers) {
            PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(provider, fqName, result);
        }
        return CollectionsKt.toList(result);
    }

    @Override
    public void collectPackageFragments(@NotNull FqName fqName, @NotNull Collection<PackageFragmentDescriptor> packageFragments) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(packageFragments, "packageFragments");
        for (PackageFragmentProvider provider : this.providers) {
            PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(provider, fqName, packageFragments);
        }
    }

    @Override
    public boolean isEmpty(@NotNull FqName fqName) {
        boolean bl2;
        block3: {
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Iterable $this$all$iv = this.providers;
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl2 = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    PackageFragmentProvider it = (PackageFragmentProvider)element$iv;
                    boolean bl3 = false;
                    if (PackageFragmentProviderKt.isEmpty(it, fqName)) continue;
                    bl2 = false;
                    break block3;
                }
                bl2 = true;
            }
        }
        return bl2;
    }

    @Override
    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        HashSet<FqName> result = new HashSet<FqName>();
        for (PackageFragmentProvider provider : this.providers) {
            result.addAll(provider.getSubPackagesOf(fqName, nameFilter));
        }
        return result;
    }

    @NotNull
    public String toString() {
        return this.debugName;
    }
}

