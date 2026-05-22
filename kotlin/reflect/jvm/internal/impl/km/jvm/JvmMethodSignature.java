/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km.jvm;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMemberSignature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmMethodSignature
extends JvmMemberSignature {
    @NotNull
    private final String name;
    @NotNull
    private final String descriptor;

    public JvmMethodSignature(@NotNull String name, @NotNull String descriptor2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        super(null);
        this.name = name;
        this.descriptor = descriptor2;
    }

    @Override
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override
    @NotNull
    public String getDescriptor() {
        return this.descriptor;
    }

    @Override
    @NotNull
    public String toString() {
        return this.getName() + this.getDescriptor();
    }

    public int hashCode() {
        int result = this.name.hashCode();
        result = result * 31 + this.descriptor.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JvmMethodSignature)) {
            return false;
        }
        JvmMethodSignature jvmMethodSignature = (JvmMethodSignature)other;
        if (!Intrinsics.areEqual(this.name, jvmMethodSignature.name)) {
            return false;
        }
        return Intrinsics.areEqual(this.descriptor, jvmMethodSignature.descriptor);
    }
}

