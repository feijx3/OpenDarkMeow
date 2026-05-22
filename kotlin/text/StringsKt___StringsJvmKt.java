/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecatedSinceKotlin
 *  kotlin.OverloadResolutionByLambdaReturnType
 *  kotlin.ReplaceWith
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=5, xi=49, d1={"\u0000B\n\u0000\n\u0002\u0010\f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0010\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006*\u00020\u0002\u001a\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007\u00a2\u0006\u0002\u0010\b\u001a;\u0010\t\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\n0\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u001a/\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010\u0011j\n\u0012\u0006\b\u0000\u0012\u00020\u0001`\u0012H\u0007\u00a2\u0006\u0002\u0010\u0013\u001a\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007\u00a2\u0006\u0002\u0010\b\u001a;\u0010\u0015\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\n0\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u001a/\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010\u0011j\n\u0012\u0006\b\u0000\u0012\u00020\u0001`\u0012H\u0007\u00a2\u0006\u0002\u0010\u0013\u001a)\u0010\u0017\u001a\u00020\u0018*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00180\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\b\u0019\u001a)\u0010\u0017\u001a\u00020\u001a*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001a0\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\b\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001c"}, d2={"elementAt", "", "", "index", "", "toSortedSet", "Ljava/util/SortedSet;", "max", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "min", "minBy", "minWith", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Ljava/math/BigInteger;", "sumOfBigInteger", "kotlin-stdlib"}, xs="kotlin/text/StringsKt")
@SourceDebugExtension(value={"SMAP\n_StringsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _StringsJvm.kt\nkotlin/text/StringsKt___StringsJvmKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,108:1\n1260#2,14:109\n1584#2,14:123\n*S KotlinDebug\n*F\n+ 1 _StringsJvm.kt\nkotlin/text/StringsKt___StringsJvmKt\n*L\n45#1:109,14\n66#1:123,14\n*E\n"})
class StringsKt___StringsJvmKt
extends StringsKt__StringsKt {
    @InlineOnly
    private static final char elementAt(CharSequence $this$elementAt, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt, "<this>");
        return $this$elementAt.charAt(index);
    }

    @NotNull
    public static final SortedSet<Character> toSortedSet(@NotNull CharSequence $this$toSortedSet) {
        Intrinsics.checkNotNullParameter($this$toSortedSet, "<this>");
        return (SortedSet)StringsKt.toCollection($this$toSortedSet, (Collection)new TreeSet());
    }

    @Deprecated(message="Use maxOrNull instead.", replaceWith=@ReplaceWith(expression="this.maxOrNull()", imports={}))
    @DeprecatedSinceKotlin(warningSince="1.4", errorSince="1.5", hiddenSince="1.6")
    public static final /* synthetic */ Character max(CharSequence $this$max) {
        Intrinsics.checkNotNullParameter($this$max, "<this>");
        return StringsKt.maxOrNull($this$max);
    }

    @Deprecated(message="Use maxByOrNull instead.", replaceWith=@ReplaceWith(expression="this.maxByOrNull(selector)", imports={}))
    @DeprecatedSinceKotlin(warningSince="1.4", errorSince="1.5", hiddenSince="1.6")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character maxBy(CharSequence $this$maxBy, Function1<? super Character, ? extends R> selector) {
        Character c2;
        Intrinsics.checkNotNullParameter($this$maxBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        boolean $i$f$maxBy = false;
        CharSequence $this$maxByOrNull$iv = $this$maxBy;
        boolean $i$f$maxByOrNull = false;
        if ($this$maxByOrNull$iv.length() == 0) {
            c2 = null;
        } else {
            char maxElem$iv = $this$maxByOrNull$iv.charAt(0);
            int lastIndex$iv = StringsKt.getLastIndex($this$maxByOrNull$iv);
            if (lastIndex$iv == 0) {
                c2 = Character.valueOf(maxElem$iv);
            } else {
                Comparable maxValue$iv = (Comparable)selector.invoke(Character.valueOf(maxElem$iv));
                int i$iv = 1;
                if (i$iv <= lastIndex$iv) {
                    while (true) {
                        char e$iv;
                        Comparable v$iv;
                        if (maxValue$iv.compareTo(v$iv = (Comparable)selector.invoke(Character.valueOf(e$iv = $this$maxByOrNull$iv.charAt(i$iv)))) < 0) {
                            maxElem$iv = e$iv;
                            maxValue$iv = v$iv;
                        }
                        if (i$iv == lastIndex$iv) break;
                        ++i$iv;
                    }
                }
                c2 = Character.valueOf(maxElem$iv);
            }
        }
        return c2;
    }

    @Deprecated(message="Use maxWithOrNull instead.", replaceWith=@ReplaceWith(expression="this.maxWithOrNull(comparator)", imports={}))
    @DeprecatedSinceKotlin(warningSince="1.4", errorSince="1.5", hiddenSince="1.6")
    public static final /* synthetic */ Character maxWith(CharSequence $this$maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return StringsKt.maxWithOrNull($this$maxWith, comparator);
    }

    @Deprecated(message="Use minOrNull instead.", replaceWith=@ReplaceWith(expression="this.minOrNull()", imports={}))
    @DeprecatedSinceKotlin(warningSince="1.4", errorSince="1.5", hiddenSince="1.6")
    public static final /* synthetic */ Character min(CharSequence $this$min) {
        Intrinsics.checkNotNullParameter($this$min, "<this>");
        return StringsKt.minOrNull($this$min);
    }

    @Deprecated(message="Use minByOrNull instead.", replaceWith=@ReplaceWith(expression="this.minByOrNull(selector)", imports={}))
    @DeprecatedSinceKotlin(warningSince="1.4", errorSince="1.5", hiddenSince="1.6")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character minBy(CharSequence $this$minBy, Function1<? super Character, ? extends R> selector) {
        Character c2;
        Intrinsics.checkNotNullParameter($this$minBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        boolean $i$f$minBy = false;
        CharSequence $this$minByOrNull$iv = $this$minBy;
        boolean $i$f$minByOrNull = false;
        if ($this$minByOrNull$iv.length() == 0) {
            c2 = null;
        } else {
            char minElem$iv = $this$minByOrNull$iv.charAt(0);
            int lastIndex$iv = StringsKt.getLastIndex($this$minByOrNull$iv);
            if (lastIndex$iv == 0) {
                c2 = Character.valueOf(minElem$iv);
            } else {
                Comparable minValue$iv = (Comparable)selector.invoke(Character.valueOf(minElem$iv));
                int i$iv = 1;
                if (i$iv <= lastIndex$iv) {
                    while (true) {
                        char e$iv;
                        Comparable v$iv;
                        if (minValue$iv.compareTo(v$iv = (Comparable)selector.invoke(Character.valueOf(e$iv = $this$minByOrNull$iv.charAt(i$iv)))) > 0) {
                            minElem$iv = e$iv;
                            minValue$iv = v$iv;
                        }
                        if (i$iv == lastIndex$iv) break;
                        ++i$iv;
                    }
                }
                c2 = Character.valueOf(minElem$iv);
            }
        }
        return c2;
    }

    @Deprecated(message="Use minWithOrNull instead.", replaceWith=@ReplaceWith(expression="this.minWithOrNull(comparator)", imports={}))
    @DeprecatedSinceKotlin(warningSince="1.4", errorSince="1.5", hiddenSince="1.6")
    public static final /* synthetic */ Character minWith(CharSequence $this$minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return StringsKt.minWithOrNull($this$minWith, comparator);
    }

    @SinceKotlin(version="1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name="sumOfBigDecimal")
    @InlineOnly
    private static final BigDecimal sumOfBigDecimal(CharSequence $this$sumOf, Function1<? super Character, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimal = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimal, "valueOf(...)");
        BigDecimal sum = bigDecimal;
        for (int i2 = 0; i2 < $this$sumOf.length(); ++i2) {
            char element = $this$sumOf.charAt(i2);
            Intrinsics.checkNotNullExpressionValue(sum.add(selector.invoke(Character.valueOf(element))), "add(...)");
        }
        return sum;
    }

    @SinceKotlin(version="1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name="sumOfBigInteger")
    @InlineOnly
    private static final BigInteger sumOfBigInteger(CharSequence $this$sumOf, Function1<? super Character, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigInteger = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigInteger, "valueOf(...)");
        BigInteger sum = bigInteger;
        for (int i2 = 0; i2 < $this$sumOf.length(); ++i2) {
            char element = $this$sumOf.charAt(i2);
            Intrinsics.checkNotNullExpressionValue(sum.add(selector.invoke(Character.valueOf(element))), "add(...)");
        }
        return sum;
    }
}

