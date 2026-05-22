/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import org.jetbrains.annotations.NotNull;

public interface TypeSystemOptimizationContext {
    public boolean identicalArguments(@NotNull RigidTypeMarker var1, @NotNull RigidTypeMarker var2);
}

