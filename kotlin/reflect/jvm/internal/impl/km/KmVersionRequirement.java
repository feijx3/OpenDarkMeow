/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.KmVersion;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KmVersionRequirement {
    public KmVersionRequirementVersionKind kind;
    public KmVersionRequirementLevel level;
    @Nullable
    private Integer errorCode;
    @Nullable
    private String message;
    public KmVersion version;

    @NotNull
    public final KmVersionRequirementVersionKind getKind() {
        KmVersionRequirementVersionKind kmVersionRequirementVersionKind = this.kind;
        if (kmVersionRequirementVersionKind != null) {
            return kmVersionRequirementVersionKind;
        }
        Intrinsics.throwUninitializedPropertyAccessException("kind");
        return null;
    }

    public final void setKind(@NotNull KmVersionRequirementVersionKind kmVersionRequirementVersionKind) {
        Intrinsics.checkNotNullParameter((Object)kmVersionRequirementVersionKind, "<set-?>");
        this.kind = kmVersionRequirementVersionKind;
    }

    @NotNull
    public final KmVersionRequirementLevel getLevel() {
        KmVersionRequirementLevel kmVersionRequirementLevel = this.level;
        if (kmVersionRequirementLevel != null) {
            return kmVersionRequirementLevel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("level");
        return null;
    }

    public final void setLevel(@NotNull KmVersionRequirementLevel kmVersionRequirementLevel) {
        Intrinsics.checkNotNullParameter((Object)kmVersionRequirementLevel, "<set-?>");
        this.level = kmVersionRequirementLevel;
    }

    @Nullable
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(@Nullable Integer n2) {
        this.errorCode = n2;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(@Nullable String string) {
        this.message = string;
    }

    @NotNull
    public final KmVersion getVersion() {
        KmVersion kmVersion = this.version;
        if (kmVersion != null) {
            return kmVersion;
        }
        Intrinsics.throwUninitializedPropertyAccessException("version");
        return null;
    }

    public final void setVersion(@NotNull KmVersion kmVersion) {
        Intrinsics.checkNotNullParameter(kmVersion, "<set-?>");
        this.version = kmVersion;
    }

    @NotNull
    public String toString() {
        return "KmVersionRequirement(kind=" + (Object)((Object)this.getKind()) + ", level=" + (Object)((Object)this.getLevel()) + ", version=" + this.getVersion() + ", errorCode=" + this.errorCode + ", message=" + this.message + ')';
    }
}

