/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public interface PackageViewDescriptorFactory {
    @NotNull
    public static final Companion Companion = kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory$Companion.$$INSTANCE;

    @NotNull
    public PackageViewDescriptor compute(@NotNull ModuleDescriptorImpl var1, @NotNull FqName var2, @NotNull StorageManager var3);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        private static final ModuleCapability<PackageViewDescriptorFactory> CAPABILITY;

        private Companion() {
        }

        @NotNull
        public final ModuleCapability<PackageViewDescriptorFactory> getCAPABILITY() {
            return CAPABILITY;
        }

        static {
            $$INSTANCE = new Companion();
            CAPABILITY = new ModuleCapability("PackageViewDescriptorFactory");
        }
    }

    public static final class Default
    implements PackageViewDescriptorFactory {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        @Override
        @NotNull
        public PackageViewDescriptor compute(@NotNull ModuleDescriptorImpl module, @NotNull FqName fqName, @NotNull StorageManager storageManager) {
            Intrinsics.checkNotNullParameter(module, "module");
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            return new LazyPackageViewDescriptorImpl(module, fqName, storageManager);
        }
    }
}

