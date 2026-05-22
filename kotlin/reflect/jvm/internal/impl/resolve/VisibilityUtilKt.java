/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import org.jetbrains.annotations.NotNull;

public final class VisibilityUtilKt {
    @NotNull
    public static final CallableMemberDescriptor findMemberWithMaxVisibility(@NotNull Collection<? extends CallableMemberDescriptor> descriptors) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(descriptors, "descriptors");
        boolean bl3 = bl2 = !descriptors.isEmpty();
        if (_Assertions.ENABLED && !bl2) {
            String string = "Assertion failed";
            throw new AssertionError((Object)string);
        }
        CallableMemberDescriptor descriptor2 = null;
        for (CallableMemberDescriptor callableMemberDescriptor : descriptors) {
            if (descriptor2 == null) {
                descriptor2 = callableMemberDescriptor;
                continue;
            }
            Integer result = DescriptorVisibilities.compare(descriptor2.getVisibility(), callableMemberDescriptor.getVisibility());
            if (result == null || result >= 0) continue;
            descriptor2 = callableMemberDescriptor;
        }
        CallableMemberDescriptor callableMemberDescriptor = descriptor2;
        Intrinsics.checkNotNull(callableMemberDescriptor);
        return callableMemberDescriptor;
    }
}

