/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public interface PackageFragmentProviderOptimized
extends PackageFragmentProvider {
    public void collectPackageFragments(@NotNull FqName var1, @NotNull Collection<PackageFragmentDescriptor> var2);

    public boolean isEmpty(@NotNull FqName var1);
}

