/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IncompatibleVersionErrorData<T> {
    private final T actualVersion;
    private final T compilerVersion;
    private final T languageVersion;
    private final T expectedVersion;
    @NotNull
    private final String filePath;

    public IncompatibleVersionErrorData(T actualVersion, T compilerVersion, T languageVersion, T expectedVersion, @NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.actualVersion = actualVersion;
        this.compilerVersion = compilerVersion;
        this.languageVersion = languageVersion;
        this.expectedVersion = expectedVersion;
        this.filePath = filePath;
    }

    @NotNull
    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.actualVersion + ", compilerVersion=" + this.compilerVersion + ", languageVersion=" + this.languageVersion + ", expectedVersion=" + this.expectedVersion + ", filePath=" + this.filePath + ')';
    }

    public int hashCode() {
        int result = this.actualVersion == null ? 0 : this.actualVersion.hashCode();
        result = result * 31 + (this.compilerVersion == null ? 0 : this.compilerVersion.hashCode());
        result = result * 31 + (this.languageVersion == null ? 0 : this.languageVersion.hashCode());
        result = result * 31 + (this.expectedVersion == null ? 0 : this.expectedVersion.hashCode());
        result = result * 31 + this.filePath.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IncompatibleVersionErrorData)) {
            return false;
        }
        IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData)other;
        if (!Intrinsics.areEqual(this.actualVersion, incompatibleVersionErrorData.actualVersion)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.compilerVersion, incompatibleVersionErrorData.compilerVersion)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.languageVersion, incompatibleVersionErrorData.languageVersion)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.expectedVersion, incompatibleVersionErrorData.expectedVersion)) {
            return false;
        }
        return Intrinsics.areEqual(this.filePath, incompatibleVersionErrorData.filePath);
    }
}

