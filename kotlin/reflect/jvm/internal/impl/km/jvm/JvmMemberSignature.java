/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km.jvm;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public abstract class JvmMemberSignature {
    private JvmMemberSignature() {
    }

    @NotNull
    public abstract String getName();

    @NotNull
    public abstract String getDescriptor();

    @NotNull
    public abstract String toString();

    public /* synthetic */ JvmMemberSignature(DefaultConstructorMarker $constructor_marker) {
        this();
    }
}

