/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader$Companion$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public interface BuiltInsLoader {
    @NotNull
    public static final Companion Companion = kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader$Companion.$$INSTANCE;

    @NotNull
    public PackageFragmentProvider createPackageFragmentProvider(@NotNull StorageManager var1, @NotNull ModuleDescriptor var2, @NotNull Iterable<? extends ClassDescriptorFactory> var3, @NotNull PlatformDependentDeclarationFilter var4, @NotNull AdditionalClassPartsProvider var5, boolean var6);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        private static final Lazy<BuiltInsLoader> Instance$delegate;

        private Companion() {
        }

        @NotNull
        public final BuiltInsLoader getInstance() {
            Lazy<BuiltInsLoader> lazy = Instance$delegate;
            return lazy.getValue();
        }

        private static final BuiltInsLoader Instance_delegate$lambda$0() {
            ServiceLoader<BuiltInsLoader> implementations = ServiceLoader.load(BuiltInsLoader.class, BuiltInsLoader.class.getClassLoader());
            Intrinsics.checkNotNull(implementations);
            BuiltInsLoader builtInsLoader = (BuiltInsLoader)CollectionsKt.firstOrNull((Iterable)implementations);
            if (builtInsLoader == null) {
                throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
            }
            return builtInsLoader;
        }

        static {
            $$INSTANCE = new Companion();
            Instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, BuiltInsLoader$Companion$$Lambda$0.INSTANCE);
        }

        static /* synthetic */ BuiltInsLoader accessor$BuiltInsLoader$Companion$lambda0() {
            return kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader$Companion.Instance_delegate$lambda$0();
        }
    }
}

