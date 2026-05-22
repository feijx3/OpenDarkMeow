/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

public interface TypeCheckingProcedureCallbacks {
    public boolean assertEqualTypeConstructors(@NotNull TypeConstructor var1, @NotNull TypeConstructor var2);
}

