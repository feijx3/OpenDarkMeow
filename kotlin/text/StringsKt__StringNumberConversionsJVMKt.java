/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringBuilderKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=5, xi=49, d1={"\u0000V\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\u0010\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u000e\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u000f\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\u0001H\u0087\b\u001a\r\u0010\t\u001a\u00020\u0002*\u00020\u0001H\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0005*\u00020\u0001H\u0087\b\u001a\u0015\u0010\n\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\u0004*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\f\u001a\u00020\u0006*\u00020\u0001H\u0087\b\u001a\u0015\u0010\f\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u0001H\u0087\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0001H\u0087\b\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u0001H\u0007\u00a2\u0006\u0002\u0010\u0012\u001a\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0010*\u00020\u0001H\u0007\u00a2\u0006\u0002\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0016*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0015\u001a\u00020\u0016*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u00020\u0001H\u0007\u001a\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\r\u0010\u0018\u001a\u00020\u0019*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bH\u0087\b\u001a\u000e\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u00020\u0001H\u0007\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bH\u0007\u001a4\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u001f\u001a\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u001e0!H\u0082\b\u00a2\u0006\u0004\b\"\u0010#\u001a\u0015\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\b&\u001a \u0010'\u001a\u0004\u0018\u00010\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0083\b\u00a2\u0006\u0002\b*\u001a\u0012\u0010+\u001a\u00020\b*\u00020,H\u0083\b\u00a2\u0006\u0002\b-\u001a\u0012\u0010.\u001a\u00020\b*\u00020,H\u0083\b\u00a2\u0006\u0002\b/\u001a\u0012\u00100\u001a\u00020\u0004*\u00020,H\u0083\b\u00a2\u0006\u0002\b1\u001a6\u00102\u001a\u00020\u0004*\u00020\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b0!H\u0083\b\u00a2\u0006\u0002\b4\u001a6\u00105\u001a\u00020\u0004*\u00020\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b0!H\u0083\b\u00a2\u0006\u0002\b6\u001a>\u00107\u001a\u00020\u0004*\u00020\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u00108\u001a\u00020\b2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b0!H\u0083\b\u00a2\u0006\u0002\b9\u00a8\u0006:"}, d2={"toString", "", "", "radix", "", "", "", "toBoolean", "", "toByte", "toShort", "toInt", "toLong", "toFloat", "", "toDouble", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toBigInteger", "Ljava/math/BigInteger;", "toBigIntegerOrNull", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "screenFloatValue", "T", "str", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "isValidFloat", "s", "isValidFloat$StringsKt__StringNumberConversionsJVMKt", "guessNamedFloatConstant", "start", "endInclusive", "guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt", "isAsciiDigit", "", "isAsciiDigit$StringsKt__StringNumberConversionsJVMKt", "isHexLetter", "isHexLetter$StringsKt__StringNumberConversionsJVMKt", "asciiLetterToLowerCaseCode", "asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt", "advanceWhile", "predicate", "advanceWhile$StringsKt__StringNumberConversionsJVMKt", "backtrackWhile", "backtrackWhile$StringsKt__StringNumberConversionsJVMKt", "advanceAndValidateMantissa", "hexFormat", "advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt", "kotlin-stdlib"}, xs="kotlin/text/StringsKt")
@SourceDebugExtension(value={"SMAP\nStringNumberConversionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,512:1\n267#1,7:513\n267#1,7:520\n267#1,7:527\n267#1,7:534\n1#2:541\n*S KotlinDebug\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n*L\n166#1:513,7\n173#1:520,7\n253#1:527,7\n264#1:534,7\n*E\n"})
class StringsKt__StringNumberConversionsJVMKt
extends StringsKt__StringBuilderKt {
    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final String toString(byte $this$toString, int radix) {
        String string = Integer.toString($this$toString, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final String toString(short $this$toString, int radix) {
        String string = Integer.toString($this$toString, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final String toString(int $this$toString, int radix) {
        String string = Integer.toString($this$toString, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final String toString(long $this$toString, int radix) {
        String string = Long.toString($this$toString, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @SinceKotlin(version="1.4")
    @InlineOnly
    private static final boolean toBoolean(String $this$toBoolean) {
        return Boolean.parseBoolean($this$toBoolean);
    }

    @InlineOnly
    private static final byte toByte(String $this$toByte) {
        Intrinsics.checkNotNullParameter($this$toByte, "<this>");
        return Byte.parseByte($this$toByte);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final byte toByte(String $this$toByte, int radix) {
        Intrinsics.checkNotNullParameter($this$toByte, "<this>");
        return Byte.parseByte($this$toByte, CharsKt.checkRadix(radix));
    }

    @InlineOnly
    private static final short toShort(String $this$toShort) {
        Intrinsics.checkNotNullParameter($this$toShort, "<this>");
        return Short.parseShort($this$toShort);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final short toShort(String $this$toShort, int radix) {
        Intrinsics.checkNotNullParameter($this$toShort, "<this>");
        return Short.parseShort($this$toShort, CharsKt.checkRadix(radix));
    }

    @InlineOnly
    private static final int toInt(String $this$toInt) {
        Intrinsics.checkNotNullParameter($this$toInt, "<this>");
        return Integer.parseInt($this$toInt);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final int toInt(String $this$toInt, int radix) {
        Intrinsics.checkNotNullParameter($this$toInt, "<this>");
        return Integer.parseInt($this$toInt, CharsKt.checkRadix(radix));
    }

    @InlineOnly
    private static final long toLong(String $this$toLong) {
        Intrinsics.checkNotNullParameter($this$toLong, "<this>");
        return Long.parseLong($this$toLong);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final long toLong(String $this$toLong, int radix) {
        Intrinsics.checkNotNullParameter($this$toLong, "<this>");
        return Long.parseLong($this$toLong, CharsKt.checkRadix(radix));
    }

    @InlineOnly
    private static final float toFloat(String $this$toFloat) {
        Intrinsics.checkNotNullParameter($this$toFloat, "<this>");
        return Float.parseFloat($this$toFloat);
    }

    @InlineOnly
    private static final double toDouble(String $this$toDouble) {
        Intrinsics.checkNotNullParameter($this$toDouble, "<this>");
        return Double.parseDouble($this$toDouble);
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Float toFloatOrNull(@NotNull String $this$toFloatOrNull) {
        Float f2;
        Intrinsics.checkNotNullParameter($this$toFloatOrNull, "<this>");
        boolean $i$f$screenFloatValue = false;
        try {
            Float f3;
            if (StringsKt__StringNumberConversionsJVMKt.isValidFloat$StringsKt__StringNumberConversionsJVMKt($this$toFloatOrNull)) {
                String p0 = $this$toFloatOrNull;
                boolean bl2 = false;
                f3 = Float.valueOf(Float.parseFloat(p0));
            } else {
                f3 = null;
            }
            f2 = f3;
        }
        catch (NumberFormatException numberFormatException) {
            f2 = null;
        }
        return f2;
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Double toDoubleOrNull(@NotNull String $this$toDoubleOrNull) {
        Double d2;
        Intrinsics.checkNotNullParameter($this$toDoubleOrNull, "<this>");
        boolean $i$f$screenFloatValue = false;
        try {
            Double d3;
            if (StringsKt__StringNumberConversionsJVMKt.isValidFloat$StringsKt__StringNumberConversionsJVMKt($this$toDoubleOrNull)) {
                String p0 = $this$toDoubleOrNull;
                boolean bl2 = false;
                d3 = Double.parseDouble(p0);
            } else {
                d3 = null;
            }
            d2 = d3;
        }
        catch (NumberFormatException numberFormatException) {
            d2 = null;
        }
        return d2;
    }

    @SinceKotlin(version="1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(String $this$toBigInteger) {
        Intrinsics.checkNotNullParameter($this$toBigInteger, "<this>");
        return new BigInteger($this$toBigInteger);
    }

    @SinceKotlin(version="1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(String $this$toBigInteger, int radix) {
        Intrinsics.checkNotNullParameter($this$toBigInteger, "<this>");
        return new BigInteger($this$toBigInteger, CharsKt.checkRadix(radix));
    }

    @SinceKotlin(version="1.2")
    @Nullable
    public static final BigInteger toBigIntegerOrNull(@NotNull String $this$toBigIntegerOrNull) {
        Intrinsics.checkNotNullParameter($this$toBigIntegerOrNull, "<this>");
        return StringsKt.toBigIntegerOrNull($this$toBigIntegerOrNull, 10);
    }

    @SinceKotlin(version="1.2")
    @Nullable
    public static final BigInteger toBigIntegerOrNull(@NotNull String $this$toBigIntegerOrNull, int radix) {
        Intrinsics.checkNotNullParameter($this$toBigIntegerOrNull, "<this>");
        CharsKt.checkRadix(radix);
        int length = $this$toBigIntegerOrNull.length();
        switch (length) {
            case 0: {
                return null;
            }
            case 1: {
                if (CharsKt.digitOf($this$toBigIntegerOrNull.charAt(0), radix) >= 0) break;
                return null;
            }
            default: {
                int start;
                for (int index = start = $this$toBigIntegerOrNull.charAt(0) == '-' ? 1 : 0; index < length; ++index) {
                    if (CharsKt.digitOf($this$toBigIntegerOrNull.charAt(index), radix) >= 0) continue;
                    return null;
                }
            }
        }
        return new BigInteger($this$toBigIntegerOrNull, CharsKt.checkRadix(radix));
    }

    @SinceKotlin(version="1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(String $this$toBigDecimal) {
        Intrinsics.checkNotNullParameter($this$toBigDecimal, "<this>");
        return new BigDecimal($this$toBigDecimal);
    }

    @SinceKotlin(version="1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(String $this$toBigDecimal, MathContext mathContext) {
        Intrinsics.checkNotNullParameter($this$toBigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal($this$toBigDecimal, mathContext);
    }

    @SinceKotlin(version="1.2")
    @Nullable
    public static final BigDecimal toBigDecimalOrNull(@NotNull String $this$toBigDecimalOrNull) {
        BigDecimal bigDecimal;
        Intrinsics.checkNotNullParameter($this$toBigDecimalOrNull, "<this>");
        boolean $i$f$screenFloatValue = false;
        try {
            BigDecimal bigDecimal2;
            if (StringsKt__StringNumberConversionsJVMKt.isValidFloat$StringsKt__StringNumberConversionsJVMKt($this$toBigDecimalOrNull)) {
                String it = $this$toBigDecimalOrNull;
                boolean bl2 = false;
                bigDecimal2 = new BigDecimal(it);
            } else {
                bigDecimal2 = null;
            }
            bigDecimal = bigDecimal2;
        }
        catch (NumberFormatException numberFormatException) {
            bigDecimal = null;
        }
        return bigDecimal;
    }

    @SinceKotlin(version="1.2")
    @Nullable
    public static final BigDecimal toBigDecimalOrNull(@NotNull String $this$toBigDecimalOrNull, @NotNull MathContext mathContext) {
        BigDecimal bigDecimal;
        Intrinsics.checkNotNullParameter($this$toBigDecimalOrNull, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        boolean $i$f$screenFloatValue = false;
        try {
            BigDecimal bigDecimal2;
            if (StringsKt__StringNumberConversionsJVMKt.isValidFloat$StringsKt__StringNumberConversionsJVMKt($this$toBigDecimalOrNull)) {
                String it = $this$toBigDecimalOrNull;
                boolean bl2 = false;
                bigDecimal2 = new BigDecimal(it, mathContext);
            } else {
                bigDecimal2 = null;
            }
            bigDecimal = bigDecimal2;
        }
        catch (NumberFormatException numberFormatException) {
            bigDecimal = null;
        }
        return bigDecimal;
    }

    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String str, Function1<? super String, ? extends T> parse) {
        T t2;
        boolean $i$f$screenFloatValue = false;
        try {
            t2 = StringsKt__StringNumberConversionsJVMKt.isValidFloat$StringsKt__StringNumberConversionsJVMKt(str) ? (T)parse.invoke(str) : null;
        }
        catch (NumberFormatException numberFormatException) {
            t2 = null;
        }
        return t2;
    }

    private static final boolean isValidFloat$StringsKt__StringNumberConversionsJVMKt(String s2) {
        int l2;
        char it;
        boolean bl2;
        char it2;
        int n2;
        int n3;
        int n4;
        char it3;
        int n5;
        int start = 0;
        int endInclusive = s2.length() - 1;
        String string = s2;
        for (n5 = start; n5 <= endInclusive; ++n5) {
            it3 = string.charAt(n5);
            boolean bl3 = false;
            if (!(it3 <= ' ')) break;
        }
        if ((start = n5) > endInclusive) {
            return false;
        }
        string = s2;
        for (n5 = endInclusive; n5 > start; --n5) {
            it3 = string.charAt(n5);
            boolean bl4 = false;
            if (!(it3 <= ' ')) break;
        }
        endInclusive = n5;
        if (s2.charAt(start) == '+' || s2.charAt(start) == '-') {
            ++start;
        }
        if (start > endInclusive) {
            return false;
        }
        boolean isHex = false;
        if (s2.charAt(start) == '0') {
            if (++start > endInclusive) {
                return true;
            }
            if ((s2.charAt(start) | 0x20) == 120) {
                int n6;
                int n7;
                String string2 = s2;
                n3 = n4 = ++start;
                String string3 = string2;
                for (n2 = n4; n2 <= endInclusive; ++n2) {
                    it2 = string3.charAt(n2);
                    n7 = 0;
                    if (!((it2 - 48 & 0xFFFF) < 10 || ((it2 | 0x20) - 97 & 0xFFFF) < 6)) break;
                }
                boolean bl5 = bl2 = n3 != (n4 = n2);
                if (n4 > endInclusive) {
                    n6 = -1;
                } else {
                    n2 = 0;
                    if (string2.charAt(n4) == '.') {
                        n3 = ++n4;
                        String it4 = string2;
                        for (n7 = n4; n7 <= endInclusive; ++n7) {
                            it = it4.charAt(n7);
                            boolean bl6 = false;
                            if (!((it - 48 & 0xFFFF) < 10 || ((it | 0x20) - 97 & 0xFFFF) < 6)) break;
                        }
                        n2 = n3 != (n4 = n7) ? 1 : 0;
                    }
                    n6 = start = !bl2 && n2 == 0 ? -1 : n4;
                }
                if (start == -1 || start > endInclusive) {
                    return false;
                }
                isHex = true;
            } else {
                --start;
            }
        }
        if (!isHex) {
            int n8;
            String string4 = s2;
            n3 = n4 = start;
            String string5 = string4;
            for (n2 = n4; n2 <= endInclusive; ++n2) {
                it2 = string5.charAt(n2);
                boolean bl7 = false;
                boolean bl8 = (it2 - 48 & 0xFFFF) < 10;
                if (!bl8) break;
            }
            boolean bl9 = bl2 = n3 != (n4 = n2);
            if (n4 > endInclusive) {
                n8 = n4;
            } else {
                int n9;
                n2 = 0;
                if (string4.charAt(n4) == '.') {
                    n3 = ++n4;
                    String string6 = string4;
                    for (n9 = n4; n9 <= endInclusive; ++n9) {
                        it = string6.charAt(n9);
                        boolean bl10 = false;
                        boolean bl11 = (it - 48 & 0xFFFF) < 10;
                        if (!bl11) break;
                    }
                    int n10 = n2 = n3 != (n4 = n9) ? 1 : 0;
                }
                if (!bl2 && n2 == 0) {
                    String string7;
                    n9 = endInclusive;
                    String string8 = n9 == n4 + 3 - 1 ? "NaN" : (string7 = n9 == n4 + 8 - 1 ? "Infinity" : null);
                    n8 = string7 == null ? -1 : (StringsKt.indexOf((CharSequence)string4, string7, n4, false) == n4 ? endInclusive + 1 : -1);
                } else {
                    n8 = start = n4;
                }
            }
            if (start == -1) {
                return false;
            }
            if (start > endInclusive) {
                return true;
            }
        }
        if ((l2 = s2.charAt(start++) | 0x20) != (isHex ? 112 : 101)) {
            return !isHex && (l2 == 102 || l2 == 100) && start > endInclusive;
        }
        if (start > endInclusive) {
            return false;
        }
        if ((s2.charAt(start) == '+' || s2.charAt(start) == '-') && ++start > endInclusive) {
            return false;
        }
        String string9 = s2;
        for (n4 = start; n4 <= endInclusive; ++n4) {
            char it5 = string9.charAt(n4);
            boolean bl12 = false;
            boolean bl13 = (it5 - 48 & 0xFFFF) < 10;
            if (!bl13) break;
        }
        if ((start = n4) > endInclusive) {
            return true;
        }
        if (start == endInclusive) {
            l2 = s2.charAt(start) | 0x20;
            return l2 == 102 || l2 == 100;
        }
        return false;
    }

    @InlineOnly
    private static final String guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt(int start, int endInclusive) {
        int n2 = endInclusive;
        return n2 == start + 3 - 1 ? "NaN" : (n2 == start + 8 - 1 ? "Infinity" : null);
    }

    @InlineOnly
    private static final boolean isAsciiDigit$StringsKt__StringNumberConversionsJVMKt(char $this$isAsciiDigit) {
        return ($this$isAsciiDigit - 48 & 0xFFFF) < 10;
    }

    @InlineOnly
    private static final boolean isHexLetter$StringsKt__StringNumberConversionsJVMKt(char $this$isHexLetter) {
        return (($this$isHexLetter | 0x20) - 97 & 0xFFFF) < 6;
    }

    @InlineOnly
    private static final int asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt(char $this$asciiLetterToLowerCaseCode) {
        return $this$asciiLetterToLowerCaseCode | 0x20;
    }

    @InlineOnly
    private static final int advanceWhile$StringsKt__StringNumberConversionsJVMKt(String $this$advanceWhile, int start, int endInclusive, Function1<? super Character, Boolean> predicate) {
        int start2;
        for (start2 = start; start2 <= endInclusive && predicate.invoke(Character.valueOf($this$advanceWhile.charAt(start2))).booleanValue(); ++start2) {
        }
        return start2;
    }

    @InlineOnly
    private static final int backtrackWhile$StringsKt__StringNumberConversionsJVMKt(String $this$backtrackWhile, int start, int endInclusive, Function1<? super Character, Boolean> predicate) {
        int endInclusive2;
        for (endInclusive2 = endInclusive; endInclusive2 > start && predicate.invoke(Character.valueOf($this$backtrackWhile.charAt(endInclusive2))).booleanValue(); --endInclusive2) {
        }
        return endInclusive2;
    }

    @InlineOnly
    private static final int advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt(String $this$advanceAndValidateMantissa, int start, int endInclusive, boolean hexFormat, Function1<? super Character, Boolean> predicate) {
        int n2;
        boolean hasIntegerPart;
        int n3;
        int start2;
        int checkpoint = start2 = start;
        String string = $this$advanceAndValidateMantissa;
        for (n3 = start2; n3 <= endInclusive && predicate.invoke(Character.valueOf(string.charAt(n3))).booleanValue(); ++n3) {
        }
        start2 = n3;
        boolean bl2 = hasIntegerPart = checkpoint != start2;
        if (start2 > endInclusive) {
            return hexFormat ? -1 : start2;
        }
        boolean hasFractionalPart = false;
        if ($this$advanceAndValidateMantissa.charAt(start2) == '.') {
            checkpoint = ++start2;
            String string2 = $this$advanceAndValidateMantissa;
            for (n2 = start2; n2 <= endInclusive && predicate.invoke(Character.valueOf(string2.charAt(n2))).booleanValue(); ++n2) {
            }
            start2 = n2;
            boolean bl3 = hasFractionalPart = checkpoint != start2;
        }
        if (!hasIntegerPart && !hasFractionalPart) {
            String constant;
            if (hexFormat) {
                return -1;
            }
            n2 = endInclusive;
            String string3 = n2 == start2 + 3 - 1 ? "NaN" : (constant = n2 == start2 + 8 - 1 ? "Infinity" : null);
            if (constant == null) {
                return -1;
            }
            return StringsKt.indexOf((CharSequence)$this$advanceAndValidateMantissa, constant, start2, false) == start2 ? endInclusive + 1 : -1;
        }
        return start2;
    }
}

