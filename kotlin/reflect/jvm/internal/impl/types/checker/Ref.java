/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import org.jetbrains.annotations.NotNull;

public final class Ref<T> {
    @NotNull
    private T value;

    @NotNull
    public final T getValue() {
        return this.value;
    }
}

