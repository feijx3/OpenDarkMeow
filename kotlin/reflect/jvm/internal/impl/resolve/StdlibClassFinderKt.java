/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.CliStdlibClassFinderImpl;
import kotlin.reflect.jvm.internal.impl.resolve.StdlibClassFinder;
import org.jetbrains.annotations.NotNull;

public final class StdlibClassFinderKt {
    @NotNull
    private static final ModuleCapability<StdlibClassFinder> STDLIB_CLASS_FINDER_CAPABILITY = new ModuleCapability("StdlibClassFinder");

    @NotNull
    public static final StdlibClassFinder getStdlibClassFinder(@NotNull ModuleDescriptor $this$getStdlibClassFinder) {
        Intrinsics.checkNotNullParameter($this$getStdlibClassFinder, "<this>");
        StdlibClassFinder stdlibClassFinder = $this$getStdlibClassFinder.getCapability(STDLIB_CLASS_FINDER_CAPABILITY);
        if (stdlibClassFinder == null) {
            stdlibClassFinder = CliStdlibClassFinderImpl.INSTANCE;
        }
        return stdlibClassFinder;
    }
}

