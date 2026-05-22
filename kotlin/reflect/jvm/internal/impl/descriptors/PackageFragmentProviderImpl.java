/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nPackageFragmentProviderImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PackageFragmentProviderImpl.kt\norg/jetbrains/kotlin/descriptors/PackageFragmentProviderImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,42:1\n865#2,2:43\n2746#2,3:45\n774#2:48\n865#2,2:49\n*S KotlinDebug\n*F\n+ 1 PackageFragmentProviderImpl.kt\norg/jetbrains/kotlin/descriptors/PackageFragmentProviderImpl\n*L\n26#1:43,2\n30#1:45,3\n34#1:48\n34#1:49,2\n*E\n"})
public final class PackageFragmentProviderImpl
implements PackageFragmentProviderOptimized {
    @NotNull
    private final Collection<PackageFragmentDescriptor> packageFragments;

    public PackageFragmentProviderImpl(@NotNull Collection<? extends PackageFragmentDescriptor> packageFragments) {
        Intrinsics.checkNotNullParameter(packageFragments, "packageFragments");
        this.packageFragments = packageFragments;
    }

    @Override
    public void collectPackageFragments(@NotNull FqName fqName, @NotNull Collection<PackageFragmentDescriptor> packageFragments) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(packageFragments, "packageFragments");
        Iterable $this$filterTo$iv = this.packageFragments;
        boolean $i$f$filterTo = false;
        for (Object element$iv : $this$filterTo$iv) {
            PackageFragmentDescriptor it = (PackageFragmentDescriptor)element$iv;
            boolean bl2 = false;
            if (!Intrinsics.areEqual(it.getFqName(), fqName)) continue;
            packageFragments.add((PackageFragmentDescriptor)element$iv);
        }
    }

    @Override
    public boolean isEmpty(@NotNull FqName fqName) {
        boolean bl2;
        block3: {
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Iterable $this$none$iv = this.packageFragments;
            boolean $i$f$none = false;
            if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                bl2 = true;
            } else {
                for (Object element$iv : $this$none$iv) {
                    PackageFragmentDescriptor it = (PackageFragmentDescriptor)element$iv;
                    boolean bl3 = false;
                    if (!Intrinsics.areEqual(it.getFqName(), fqName)) continue;
                    bl2 = false;
                    break block3;
                }
                bl2 = true;
            }
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Deprecated(message="for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    @NotNull
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName fqName) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Iterable $this$filter$iv = this.packageFragments;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            PackageFragmentDescriptor it = (PackageFragmentDescriptor)element$iv$iv;
            boolean bl2 = false;
            if (!Intrinsics.areEqual(it.getFqName(), fqName)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @Override
    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        FqName fqName2 = fqName;
        return SequencesKt.toList(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence((Iterable)this.packageFragments), PackageFragmentProviderImpl$$Lambda$0.INSTANCE), new PackageFragmentProviderImpl$$Lambda$1(fqName2)));
    }

    private static final FqName getSubPackagesOf$lambda$3(PackageFragmentDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getFqName();
    }

    private static final boolean getSubPackagesOf$lambda$4(FqName $fqName, FqName it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !it.isRoot() && Intrinsics.areEqual(it.parent(), $fqName);
    }

    static /* synthetic */ FqName accessor$PackageFragmentProviderImpl$lambda0(PackageFragmentDescriptor packageFragmentDescriptor) {
        return PackageFragmentProviderImpl.getSubPackagesOf$lambda$3(packageFragmentDescriptor);
    }

    static /* synthetic */ boolean accessor$PackageFragmentProviderImpl$lambda1(FqName fqName, FqName fqName2) {
        return PackageFragmentProviderImpl.getSubPackagesOf$lambda$4(fqName, fqName2);
    }
}

