/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class SubtypePathNode {
    @NotNull
    private final KotlinType type;
    @Nullable
    private final SubtypePathNode previous;

    public SubtypePathNode(@NotNull KotlinType type, @Nullable SubtypePathNode previous) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.previous = previous;
    }

    @NotNull
    public final KotlinType getType() {
        return this.type;
    }

    @Nullable
    public final SubtypePathNode getPrevious() {
        return this.previous;
    }
}

