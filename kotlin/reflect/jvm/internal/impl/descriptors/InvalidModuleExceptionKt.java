/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleNotifier;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

public final class InvalidModuleExceptionKt {
    @NotNull
    private static final ModuleCapability<InvalidModuleNotifier> INVALID_MODULE_NOTIFIER_CAPABILITY = new ModuleCapability("InvalidModuleNotifier");

    public static final void moduleInvalidated(@NotNull ModuleDescriptor $this$moduleInvalidated) {
        InvalidModuleNotifier capability;
        Intrinsics.checkNotNullParameter($this$moduleInvalidated, "<this>");
        InvalidModuleNotifier invalidModuleNotifier = capability = $this$moduleInvalidated.getCapability(INVALID_MODULE_NOTIFIER_CAPABILITY);
        if (invalidModuleNotifier == null) {
            ModuleDescriptor $this$moduleInvalidated_u24lambda_u240 = $this$moduleInvalidated;
            boolean bl2 = false;
            throw new InvalidModuleException("Accessing invalid module descriptor " + $this$moduleInvalidated_u24lambda_u240);
        }
        invalidModuleNotifier.notifyModuleInvalidated($this$moduleInvalidated);
    }
}

