/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class DescriptorVisibility {
    protected DescriptorVisibility() {
    }

    @NotNull
    public abstract Visibility getDelegate();

    public final boolean isPublicAPI() {
        return this.getDelegate().isPublicAPI();
    }

    public abstract boolean isVisible(@Nullable ReceiverValue var1, @NotNull DeclarationDescriptorWithVisibility var2, @NotNull DeclarationDescriptor var3, boolean var4);

    @Nullable
    public final Integer compareTo(@NotNull DescriptorVisibility visibility2) {
        Intrinsics.checkNotNullParameter(visibility2, "visibility");
        return this.getDelegate().compareTo(visibility2.getDelegate());
    }

    @NotNull
    public abstract String getInternalDisplayName();

    @NotNull
    public final String toString() {
        return this.getDelegate().toString();
    }

    @NotNull
    public abstract DescriptorVisibility normalize();
}

