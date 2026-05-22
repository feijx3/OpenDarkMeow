/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.random;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;
import kotlin.random.KotlinRandom;
import kotlin.random.PlatformRandom;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a\t\u0010\u0004\u001a\u00020\u0002H\u0081\b\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000\u00a8\u0006\n"}, d2={"asJavaRandom", "Ljava/util/Random;", "Lkotlin/random/Random;", "asKotlinRandom", "defaultPlatformRandom", "doubleFromParts", "", "hi26", "", "low27", "kotlin-stdlib"})
public final class PlatformRandomKt {
    @SinceKotlin(version="1.3")
    @NotNull
    public static final java.util.Random asJavaRandom(@NotNull Random $this$asJavaRandom) {
        Intrinsics.checkNotNullParameter($this$asJavaRandom, "<this>");
        Object object = $this$asJavaRandom instanceof AbstractPlatformRandom ? (AbstractPlatformRandom)$this$asJavaRandom : null;
        if (object == null || (object = ((AbstractPlatformRandom)object).getImpl()) == null) {
            object = new KotlinRandom($this$asJavaRandom);
        }
        return object;
    }

    @SinceKotlin(version="1.3")
    @NotNull
    public static final Random asKotlinRandom(@NotNull java.util.Random $this$asKotlinRandom) {
        Intrinsics.checkNotNullParameter($this$asKotlinRandom, "<this>");
        Object object = $this$asKotlinRandom instanceof KotlinRandom ? (KotlinRandom)$this$asKotlinRandom : null;
        if (object == null || (object = ((KotlinRandom)object).getImpl()) == null) {
            object = new PlatformRandom($this$asKotlinRandom);
        }
        return object;
    }

    @InlineOnly
    private static final Random defaultPlatformRandom() {
        return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }

    public static final double doubleFromParts(int hi26, int low27) {
        return (double)(((long)hi26 << 27) + (long)low27) / 9.007199254740992E15;
    }
}

