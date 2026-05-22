/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ResolutionAnchorProviderKt {
    @NotNull
    private static final ModuleCapability<ResolutionAnchorProvider> RESOLUTION_ANCHOR_PROVIDER_CAPABILITY = new ModuleCapability("ResolutionAnchorProvider");

    @Nullable
    public static final ModuleDescriptor getResolutionAnchorIfAny(@NotNull ModuleDescriptor $this$getResolutionAnchorIfAny) {
        Intrinsics.checkNotNullParameter($this$getResolutionAnchorIfAny, "<this>");
        ResolutionAnchorProvider resolutionAnchorProvider = $this$getResolutionAnchorIfAny.getCapability(RESOLUTION_ANCHOR_PROVIDER_CAPABILITY);
        return resolutionAnchorProvider != null ? resolutionAnchorProvider.getResolutionAnchor($this$getResolutionAnchorIfAny) : null;
    }
}

