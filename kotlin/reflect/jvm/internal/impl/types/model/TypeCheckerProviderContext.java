/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import org.jetbrains.annotations.NotNull;

public interface TypeCheckerProviderContext {
    @NotNull
    public TypeCheckerState newTypeCheckerState(boolean var1, boolean var2, boolean var3);
}

