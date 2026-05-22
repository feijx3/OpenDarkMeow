/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.math;

import kotlin.Metadata;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\n\n\u0002\u0010\t\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005J\u001a\u0010\u0004\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u001a\u0010\u0004\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\t2\b\b\u0002\u0010\u0007\u001a\u00020\tJ\u001a\u0010\u0004\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\nJ\u001a\u0010\u0004\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u000b2\b\b\u0002\u0010\u0007\u001a\u00020\u000b\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/utils/math/RandomUtils;", "", "<init>", "()V", "random", "", "min", "max", "", "", "", "", "DarkMeow"})
public final class RandomUtils {
    @NotNull
    public static final RandomUtils INSTANCE = new RandomUtils();

    private RandomUtils() {
    }

    public final double random(double min, double max) {
        return !(min == max) ? Random.Default.nextDouble(RangesKt.coerceAtMost(min, max), RangesKt.coerceAtLeast(min, max)) : max;
    }

    public static /* synthetic */ double random$default(RandomUtils randomUtils, double d2, double d3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            d2 = Double.MIN_VALUE;
        }
        if ((n2 & 2) != 0) {
            d3 = Double.MAX_VALUE;
        }
        return randomUtils.random(d2, d3);
    }

    public final float random(float min, float max) {
        return (float)this.random((double)min, (double)max);
    }

    public static /* synthetic */ float random$default(RandomUtils randomUtils, float f2, float f3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            f2 = Float.MIN_VALUE;
        }
        if ((n2 & 2) != 0) {
            f3 = Float.MAX_VALUE;
        }
        return randomUtils.random(f2, f3);
    }

    public final int random(int min, int max) {
        int n2;
        Integer n3;
        Integer n4 = min;
        int it = ((Number)n4).intValue();
        boolean bl2 = false;
        Integer n5 = n3 = it != max ? n4 : null;
        if (n3 != null) {
            int it2 = ((Number)n3).intValue();
            boolean bl3 = false;
            n2 = Random.Default.nextInt(RangesKt.coerceAtMost(min, max), RangesKt.coerceAtLeast(min, max));
        } else {
            n2 = min;
        }
        return n2;
    }

    public static /* synthetic */ int random$default(RandomUtils randomUtils, int n2, int n3, int n4, Object object) {
        if ((n4 & 1) != 0) {
            n2 = Integer.MIN_VALUE;
        }
        if ((n4 & 2) != 0) {
            n3 = Integer.MAX_VALUE;
        }
        return randomUtils.random(n2, n3);
    }

    public final short random(short min, short max) {
        return (short)this.random((int)min, (int)max);
    }

    public static /* synthetic */ short random$default(RandomUtils randomUtils, short s2, short s3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            s2 = Short.MIN_VALUE;
        }
        if ((n2 & 2) != 0) {
            s3 = Short.MAX_VALUE;
        }
        return randomUtils.random(s2, s3);
    }

    public final long random(long min, long max) {
        long l2;
        Long l3;
        Long l4 = min;
        long it = ((Number)l4).longValue();
        boolean bl2 = false;
        Long l5 = l3 = it != max ? l4 : null;
        if (l3 != null) {
            long it2 = ((Number)l3).longValue();
            boolean bl3 = false;
            l2 = Random.Default.nextLong(RangesKt.coerceAtMost(min, max), RangesKt.coerceAtLeast(min, max));
        } else {
            l2 = min;
        }
        return l2;
    }

    public static /* synthetic */ long random$default(RandomUtils randomUtils, long l2, long l3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = Long.MIN_VALUE;
        }
        if ((n2 & 2) != 0) {
            l3 = Long.MAX_VALUE;
        }
        return randomUtils.random(l2, l3);
    }
}

