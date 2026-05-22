/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.PublishedApi
 */
package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a \u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002\u001a \u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0001\u001a \u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0001\u00a8\u0006\u000b"}, d2={"mod", "", "a", "b", "", "differenceModulo", "c", "getProgressionLastElement", "start", "end", "step", "kotlin-stdlib"})
public final class ProgressionUtilKt {
    private static final int mod(int a2, int b2) {
        int mod = a2 % b2;
        return mod >= 0 ? mod : mod + b2;
    }

    private static final long mod(long a2, long b2) {
        long mod = a2 % b2;
        return mod >= 0L ? mod : mod + b2;
    }

    private static final int differenceModulo(int a2, int b2, int c2) {
        return ProgressionUtilKt.mod(ProgressionUtilKt.mod(a2, c2) - ProgressionUtilKt.mod(b2, c2), c2);
    }

    private static final long differenceModulo(long a2, long b2, long c2) {
        return ProgressionUtilKt.mod(ProgressionUtilKt.mod(a2, c2) - ProgressionUtilKt.mod(b2, c2), c2);
    }

    @PublishedApi
    public static final int getProgressionLastElement(int start, int end, int step) {
        int n2;
        if (step > 0) {
            n2 = start >= end ? end : end - ProgressionUtilKt.differenceModulo(end, start, step);
        } else if (step < 0) {
            n2 = start <= end ? end : end + ProgressionUtilKt.differenceModulo(start, end, -step);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
        return n2;
    }

    @PublishedApi
    public static final long getProgressionLastElement(long start, long end, long step) {
        long l2;
        if (step > 0L) {
            l2 = start >= end ? end : end - ProgressionUtilKt.differenceModulo(end, start, step);
        } else if (step < 0L) {
            l2 = start <= end ? end : end + ProgressionUtilKt.differenceModulo(start, end, -step);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
        return l2;
    }
}

