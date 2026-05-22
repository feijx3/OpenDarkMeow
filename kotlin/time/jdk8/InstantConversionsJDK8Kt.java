/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  kotlin.jvm.JvmName
 *  kotlin.time.ExperimentalTime
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.time.jdk8;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ExperimentalTime;
import kotlin.time.Instant;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0007\u00a8\u0006\u0004"}, d2={"toJavaInstant", "Ljava/time/Instant;", "Lkotlin/time/Instant;", "toKotlinInstant", "kotlin-stdlib-jdk8"}, pn="kotlin.time")
@JvmName(name="InstantConversionsJDK8Kt")
public final class InstantConversionsJDK8Kt {
    @SinceKotlin(version="2.1")
    @ExperimentalTime
    @NotNull
    public static final java.time.Instant toJavaInstant(@NotNull Instant $this$toJavaInstant) {
        Intrinsics.checkNotNullParameter($this$toJavaInstant, "<this>");
        java.time.Instant instant = java.time.Instant.ofEpochSecond($this$toJavaInstant.getEpochSeconds(), $this$toJavaInstant.getNanosecondsOfSecond());
        Intrinsics.checkNotNullExpressionValue(instant, "ofEpochSecond(...)");
        return instant;
    }

    @SinceKotlin(version="2.1")
    @ExperimentalTime
    @NotNull
    public static final Instant toKotlinInstant(@NotNull java.time.Instant $this$toKotlinInstant) {
        Intrinsics.checkNotNullParameter($this$toKotlinInstant, "<this>");
        return Instant.Companion.fromEpochSeconds($this$toKotlinInstant.getEpochSecond(), $this$toKotlinInstant.getNano());
    }
}

