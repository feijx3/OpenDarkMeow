/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractTypeRefiner {
    @NotNull
    public abstract KotlinTypeMarker refineType(@NotNull KotlinTypeMarker var1);
}

