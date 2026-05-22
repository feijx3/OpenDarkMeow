/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class PackageFragmentProviderKt {
    @NotNull
    public static final List<PackageFragmentDescriptor> packageFragments(@NotNull PackageFragmentProvider $this$packageFragments, @NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter($this$packageFragments, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        List packageFragments = new ArrayList();
        PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible($this$packageFragments, fqName, packageFragments);
        return packageFragments;
    }

    public static final boolean isEmpty(@NotNull PackageFragmentProvider $this$isEmpty, @NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter($this$isEmpty, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return $this$isEmpty instanceof PackageFragmentProviderOptimized ? ((PackageFragmentProviderOptimized)$this$isEmpty).isEmpty(fqName) : PackageFragmentProviderKt.packageFragments($this$isEmpty, fqName).isEmpty();
    }

    public static final void collectPackageFragmentsOptimizedIfPossible(@NotNull PackageFragmentProvider $this$collectPackageFragmentsOptimizedIfPossible, @NotNull FqName fqName, @NotNull Collection<PackageFragmentDescriptor> packageFragments) {
        Intrinsics.checkNotNullParameter($this$collectPackageFragmentsOptimizedIfPossible, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(packageFragments, "packageFragments");
        if ($this$collectPackageFragmentsOptimizedIfPossible instanceof PackageFragmentProviderOptimized) {
            ((PackageFragmentProviderOptimized)$this$collectPackageFragmentsOptimizedIfPossible).collectPackageFragments(fqName, packageFragments);
        } else {
            packageFragments.addAll((Collection<PackageFragmentDescriptor>)$this$collectPackageFragmentsOptimizedIfPossible.getPackageFragments(fqName));
        }
    }
}

