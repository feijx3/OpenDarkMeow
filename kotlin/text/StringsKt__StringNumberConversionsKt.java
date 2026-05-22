/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=5, xi=49, d1={"\u0000.\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007\u00a2\u0006\u0002\u0010\u0003\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010\u0006\u001a\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0002H\u0007\u00a2\u0006\u0002\u0010\t\u001a\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010\n\u001a\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005*\u00020\u0002H\u0007\u00a2\u0006\u0002\u0010\f\u001a\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u0002H\u0007\u00a2\u0006\u0002\u0010\u0010\u001a\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010\u0011\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0000\u00a8\u0006\u0015"}, d2={"toByteOrNull", "", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "numberFormatError", "", "input", "kotlin-stdlib"}, xs="kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsKt
extends StringsKt__StringNumberConversionsJVMKt {
    @SinceKotlin(version="1.1")
    @Nullable
    public static final Byte toByteOrNull(@NotNull String $this$toByteOrNull) {
        Intrinsics.checkNotNullParameter($this$toByteOrNull, "<this>");
        return StringsKt.toByteOrNull($this$toByteOrNull, 10);
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Byte toByteOrNull(@NotNull String $this$toByteOrNull, int radix) {
        Intrinsics.checkNotNullParameter($this$toByteOrNull, "<this>");
        Integer n2 = StringsKt.toIntOrNull($this$toByteOrNull, radix);
        if (n2 == null) {
            return null;
        }
        int n3 = n2;
        if (n3 < -128 || n3 > 127) {
            return null;
        }
        return (byte)n3;
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Short toShortOrNull(@NotNull String $this$toShortOrNull) {
        Intrinsics.checkNotNullParameter($this$toShortOrNull, "<this>");
        return StringsKt.toShortOrNull($this$toShortOrNull, 10);
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Short toShortOrNull(@NotNull String $this$toShortOrNull, int radix) {
        Intrinsics.checkNotNullParameter($this$toShortOrNull, "<this>");
        Integer n2 = StringsKt.toIntOrNull($this$toShortOrNull, radix);
        if (n2 == null) {
            return null;
        }
        int n3 = n2;
        if (n3 < Short.MIN_VALUE || n3 > Short.MAX_VALUE) {
            return null;
        }
        return (short)n3;
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Integer toIntOrNull(@NotNull String $this$toIntOrNull) {
        Intrinsics.checkNotNullParameter($this$toIntOrNull, "<this>");
        return StringsKt.toIntOrNull($this$toIntOrNull, 10);
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Integer toIntOrNull(@NotNull String $this$toIntOrNull, int radix) {
        int limitForMaxRadix;
        int limit;
        boolean isNegative;
        int length;
        block14: {
            int start;
            block13: {
                Intrinsics.checkNotNullParameter($this$toIntOrNull, "<this>");
                CharsKt.checkRadix(radix);
                length = $this$toIntOrNull.length();
                if (length == 0) {
                    return null;
                }
                start = 0;
                isNegative = false;
                limit = 0;
                char firstChar = $this$toIntOrNull.charAt(0);
                if (Intrinsics.compare(firstChar, 48) >= 0) break block13;
                if (length == 1) {
                    return null;
                }
                start = 1;
                switch (firstChar) {
                    case '-': {
                        isNegative = true;
                        limit = Integer.MIN_VALUE;
                        break block14;
                    }
                    case '+': {
                        isNegative = false;
                        limit = -2147483647;
                        break block14;
                    }
                    default: {
                        return null;
                    }
                }
            }
            start = 0;
            isNegative = false;
            limit = -2147483647;
        }
        int limitBeforeMul = limitForMaxRadix = -59652323;
        int result = 0;
        for (int i2 = start; i2 < length; ++i2) {
            int digit = CharsKt.digitOf($this$toIntOrNull.charAt(i2), radix);
            if (digit < 0) {
                return null;
            }
            if (result < limitBeforeMul) {
                if (limitBeforeMul == limitForMaxRadix) {
                    limitBeforeMul = limit / radix;
                    if (result < limitBeforeMul) {
                        return null;
                    }
                } else {
                    return null;
                }
            }
            if ((result *= radix) < limit + digit) {
                return null;
            }
            result -= digit;
        }
        return isNegative ? Integer.valueOf(result) : Integer.valueOf(-result);
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Long toLongOrNull(@NotNull String $this$toLongOrNull) {
        Intrinsics.checkNotNullParameter($this$toLongOrNull, "<this>");
        return StringsKt.toLongOrNull($this$toLongOrNull, 10);
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Long toLongOrNull(@NotNull String $this$toLongOrNull, int radix) {
        long limitForMaxRadix;
        long limit;
        boolean isNegative;
        int length;
        block14: {
            int start;
            block13: {
                Intrinsics.checkNotNullParameter($this$toLongOrNull, "<this>");
                CharsKt.checkRadix(radix);
                length = $this$toLongOrNull.length();
                if (length == 0) {
                    return null;
                }
                start = 0;
                isNegative = false;
                limit = 0L;
                char firstChar = $this$toLongOrNull.charAt(0);
                if (Intrinsics.compare(firstChar, 48) >= 0) break block13;
                if (length == 1) {
                    return null;
                }
                start = 1;
                switch (firstChar) {
                    case '-': {
                        isNegative = true;
                        limit = Long.MIN_VALUE;
                        break block14;
                    }
                    case '+': {
                        isNegative = false;
                        limit = -9223372036854775807L;
                        break block14;
                    }
                    default: {
                        return null;
                    }
                }
            }
            start = 0;
            isNegative = false;
            limit = -9223372036854775807L;
        }
        long limitBeforeMul = limitForMaxRadix = -256204778801521550L;
        long result = 0L;
        for (int i2 = start; i2 < length; ++i2) {
            int digit = CharsKt.digitOf($this$toLongOrNull.charAt(i2), radix);
            if (digit < 0) {
                return null;
            }
            if (result < limitBeforeMul) {
                if (limitBeforeMul == limitForMaxRadix) {
                    limitBeforeMul = limit / (long)radix;
                    if (result < limitBeforeMul) {
                        return null;
                    }
                } else {
                    return null;
                }
            }
            if ((result *= (long)radix) < limit + (long)digit) {
                return null;
            }
            result -= (long)digit;
        }
        return isNegative ? Long.valueOf(result) : Long.valueOf(-result);
    }

    @NotNull
    public static final Void numberFormatError(@NotNull String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }
}

