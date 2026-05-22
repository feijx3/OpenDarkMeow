/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KmVersion {
    private final int major;
    private final int minor;
    private final int patch;

    public KmVersion(int major, int minor, int patch) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
    }

    @NotNull
    public String toString() {
        return "" + this.major + '.' + this.minor + '.' + this.patch;
    }

    public final int component1() {
        return this.major;
    }

    public final int component2() {
        return this.minor;
    }

    public final int component3() {
        return this.patch;
    }

    public int hashCode() {
        int result = Integer.hashCode(this.major);
        result = result * 31 + Integer.hashCode(this.minor);
        result = result * 31 + Integer.hashCode(this.patch);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KmVersion)) {
            return false;
        }
        KmVersion kmVersion = (KmVersion)other;
        if (this.major != kmVersion.major) {
            return false;
        }
        if (this.minor != kmVersion.minor) {
            return false;
        }
        return this.patch == kmVersion.patch;
    }
}

