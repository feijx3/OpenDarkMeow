/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.jvm.JvmStatic
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.misc;

import java.util.Random;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="\u5728 2025.6.6 \u4ee5\u540e\u7528\u8fd9\u4e2a\u65b9\u6cd5\u6b7b\u5988")
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000eJ\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/utils/misc/RandomUtils;", "", "<init>", "()V", "nextInt", "", "startInclusive", "endExclusive", "nextDouble", "", "endInclusive", "nextFloat", "", "randomNumber", "", "length", "randomString", "random", "chars", "", "DarkMeow"})
public final class RandomUtils {
    @NotNull
    public static final RandomUtils INSTANCE = new RandomUtils();

    private RandomUtils() {
    }

    @JvmStatic
    public static final int nextInt(int startInclusive, int endExclusive) {
        return endExclusive - startInclusive <= 0 ? startInclusive : startInclusive + new Random().nextInt(endExclusive - startInclusive);
    }

    public final double nextDouble(double startInclusive, double endInclusive) {
        return startInclusive == endInclusive || endInclusive - startInclusive <= 0.0 ? startInclusive : startInclusive + (endInclusive - startInclusive) * Math.random();
    }

    public final float nextFloat(float startInclusive, float endInclusive) {
        return startInclusive == endInclusive || endInclusive - startInclusive <= 0.0f ? startInclusive : (float)((double)startInclusive + (double)(endInclusive - startInclusive) * Math.random());
    }

    @NotNull
    public final String randomNumber(int length) {
        return this.random(length, "123456789");
    }

    @JvmStatic
    @NotNull
    public static final String randomString(int length) {
        return INSTANCE.random(length, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
    }

    @NotNull
    public final String random(int length, @NotNull String chars) {
        Intrinsics.checkNotNullParameter(chars, "chars");
        char[] cArray = chars.toCharArray();
        Intrinsics.checkNotNullExpressionValue(cArray, "toCharArray(...)");
        return this.random(length, cArray);
    }

    @NotNull
    public final String random(int length, @NotNull char[] chars) {
        Intrinsics.checkNotNullParameter(chars, "chars");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < length; ++i2) {
            stringBuilder.append(chars[new Random().nextInt(chars.length)]);
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}

