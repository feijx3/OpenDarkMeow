/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class Visibility {
    @NotNull
    private final String name;
    private final boolean isPublicAPI;

    protected Visibility(@NotNull String name, boolean isPublicAPI) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.isPublicAPI = isPublicAPI;
    }

    public final boolean isPublicAPI() {
        return this.isPublicAPI;
    }

    @NotNull
    public String getInternalDisplayName() {
        return this.name;
    }

    @Nullable
    public Integer compareTo(@NotNull Visibility visibility2) {
        Intrinsics.checkNotNullParameter(visibility2, "visibility");
        return Visibilities.INSTANCE.compareLocal$compiler_common(this, visibility2);
    }

    @NotNull
    public final String toString() {
        return this.getInternalDisplayName();
    }

    @NotNull
    public Visibility normalize() {
        return this;
    }
}

