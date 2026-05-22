/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class InconsistentKotlinMetadataException
extends IllegalArgumentException {
    public InconsistentKotlinMetadataException(@NotNull String message, @Nullable Throwable cause) {
        Intrinsics.checkNotNullParameter(message, "message");
        super(message, cause);
    }

    public /* synthetic */ InconsistentKotlinMetadataException(String string, Throwable throwable, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            throwable = null;
        }
        this(string, throwable);
    }
}

