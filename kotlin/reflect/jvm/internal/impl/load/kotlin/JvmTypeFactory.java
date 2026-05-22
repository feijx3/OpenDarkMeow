/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import org.jetbrains.annotations.NotNull;

public interface JvmTypeFactory<T> {
    @NotNull
    public T boxType(@NotNull T var1);

    @NotNull
    public T createFromString(@NotNull String var1);

    @NotNull
    public T createPrimitiveType(@NotNull PrimitiveType var1);

    @NotNull
    public T createObjectType(@NotNull String var1);

    @NotNull
    public String toString(@NotNull T var1);

    @NotNull
    public T getJavaLangClassType();
}

