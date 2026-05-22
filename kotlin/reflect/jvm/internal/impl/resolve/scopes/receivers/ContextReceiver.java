/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.AbstractReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ContextReceiver
extends AbstractReceiverValue
implements ImplicitContextReceiver {
    @NotNull
    private final CallableDescriptor declarationDescriptor;
    @Nullable
    private final Name customLabelName;

    public ContextReceiver(@NotNull CallableDescriptor declarationDescriptor, @NotNull KotlinType receiverType, @Nullable Name customLabelName, @Nullable ReceiverValue original) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        Intrinsics.checkNotNullParameter(receiverType, "receiverType");
        super(receiverType, original);
        this.declarationDescriptor = declarationDescriptor;
        this.customLabelName = customLabelName;
    }

    @NotNull
    public CallableDescriptor getDeclarationDescriptor() {
        return this.declarationDescriptor;
    }

    @Override
    @Nullable
    public Name getCustomLabelName() {
        return this.customLabelName;
    }

    @NotNull
    public String toString() {
        return "Cxt { " + this.getDeclarationDescriptor() + " }";
    }
}

