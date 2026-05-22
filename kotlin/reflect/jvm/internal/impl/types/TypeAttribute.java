/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class TypeAttribute<T extends TypeAttribute<? extends T>> {
    @Nullable
    public abstract T intersect(@Nullable T var1);

    @NotNull
    public abstract T add(@Nullable T var1);

    @NotNull
    public abstract KClass<? extends T> getKey();
}

