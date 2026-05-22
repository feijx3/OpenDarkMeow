/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationLevelValue;
import org.jetbrains.annotations.NotNull;

public abstract class DeprecationInfo
implements Comparable<DeprecationInfo> {
    @NotNull
    public abstract DeprecationLevelValue getDeprecationLevel();

    public abstract boolean getPropagatesToOverrides();

    @Override
    public int compareTo(@NotNull DeprecationInfo other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int lr = this.getDeprecationLevel().compareTo((Enum)other.getDeprecationLevel());
        return lr == 0 && !this.getPropagatesToOverrides() && other.getPropagatesToOverrides() ? 1 : lr;
    }
}

