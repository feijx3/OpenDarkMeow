/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.AbstractReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ContextClassReceiver
extends AbstractReceiverValue
implements ImplicitContextReceiver {
    @NotNull
    private final ClassDescriptor classDescriptor;
    @Nullable
    private final Name customLabelName;

    public ContextClassReceiver(@NotNull ClassDescriptor classDescriptor, @NotNull KotlinType receiverType, @Nullable Name customLabelName, @Nullable ReceiverValue original) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        Intrinsics.checkNotNullParameter(receiverType, "receiverType");
        super(receiverType, original);
        this.classDescriptor = classDescriptor;
        this.customLabelName = customLabelName;
    }

    @Override
    @Nullable
    public Name getCustomLabelName() {
        return this.customLabelName;
    }

    @NotNull
    public String toString() {
        return this.getType() + ": Ctx { " + this.classDescriptor + " }";
    }
}

