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

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text._OneToManyTitlecaseMappingsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=5, xi=49, d1={"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007\u00a2\u0006\u0002\u0010\u0005\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u00a2\u0006\u0002\u0010\u0006\u001a\f\u0010\u0007\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a\u0014\u0010\u0007\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0002H\u0007\u001a\u0015\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\tH\u0087\n\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r\u001a\n\u0010\u000f\u001a\u00020\r*\u00020\u0002\u00a8\u0006\u0010"}, d2={"digitToInt", "", "", "radix", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "digitToChar", "titlecase", "", "plus", "other", "equals", "", "ignoreCase", "isSurrogate", "kotlin-stdlib"}, xs="kotlin/text/CharsKt")
@SourceDebugExtension(value={"SMAP\nChar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Char.kt\nkotlin/text/CharsKt__CharKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,339:1\n1#2:340\n*E\n"})
class CharsKt__CharKt
extends CharsKt__CharJVMKt {
    @SinceKotlin(version="1.5")
    public static final int digitToInt(char $this$digitToInt) {
        int n2;
        int it = n2 = CharsKt.digitOf($this$digitToInt, 10);
        boolean bl2 = false;
        if (it < 0) {
            throw new IllegalArgumentException("Char " + $this$digitToInt + " is not a decimal digit");
        }
        return n2;
    }

    @SinceKotlin(version="1.5")
    public static final int digitToInt(char $this$digitToInt, int radix) {
        Integer n2 = CharsKt.digitToIntOrNull($this$digitToInt, radix);
        if (n2 == null) {
            throw new IllegalArgumentException("Char " + $this$digitToInt + " is not a digit in the given radix=" + radix);
        }
        return n2;
    }

    @SinceKotlin(version="1.5")
    @Nullable
    public static final Integer digitToIntOrNull(char $this$digitToIntOrNull) {
        Integer n2 = CharsKt.digitOf($this$digitToIntOrNull, 10);
        int it = ((Number)n2).intValue();
        boolean bl2 = false;
        return it >= 0 ? n2 : null;
    }

    @SinceKotlin(version="1.5")
    @Nullable
    public static final Integer digitToIntOrNull(char $this$digitToIntOrNull, int radix) {
        CharsKt.checkRadix(radix);
        Integer n2 = CharsKt.digitOf($this$digitToIntOrNull, radix);
        int it = ((Number)n2).intValue();
        boolean bl2 = false;
        return it >= 0 ? n2 : null;
    }

    @SinceKotlin(version="1.5")
    public static final char digitToChar(int $this$digitToChar) {
        boolean bl2 = 0 <= $this$digitToChar ? $this$digitToChar < 10 : false;
        if (bl2) {
            return (char)(48 + $this$digitToChar);
        }
        throw new IllegalArgumentException("Int " + $this$digitToChar + " is not a decimal digit");
    }

    @SinceKotlin(version="1.5")
    public static final char digitToChar(int $this$digitToChar, int radix) {
        if (!(2 <= radix ? radix < 37 : false)) {
            throw new IllegalArgumentException("Invalid radix: " + radix + ". Valid radix values are in range 2..36");
        }
        if ($this$digitToChar < 0 || $this$digitToChar >= radix) {
            throw new IllegalArgumentException("Digit " + $this$digitToChar + " does not represent a valid digit in radix " + radix);
        }
        return $this$digitToChar < 10 ? (char)(48 + $this$digitToChar) : (char)((char)(65 + $this$digitToChar) - 10);
    }

    @SinceKotlin(version="1.5")
    @NotNull
    public static final String titlecase(char $this$titlecase) {
        return _OneToManyTitlecaseMappingsKt.titlecaseImpl($this$titlecase);
    }

    @InlineOnly
    private static final String plus(char $this$plus, String other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return $this$plus + other;
    }

    public static final boolean equals(char $this$equals, char other, boolean ignoreCase) {
        char otherUpper;
        if ($this$equals == other) {
            return true;
        }
        if (!ignoreCase) {
            return false;
        }
        char thisUpper = Character.toUpperCase($this$equals);
        return thisUpper == (otherUpper = Character.toUpperCase(other)) || Character.toLowerCase(thisUpper) == Character.toLowerCase(otherUpper);
    }

    public static /* synthetic */ boolean equals$default(char c2, char c3, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return CharsKt.equals(c2, c3, bl2);
    }

    public static final boolean isSurrogate(char $this$isSurrogate) {
        return '\ud800' <= $this$isSurrogate ? $this$isSurrogate < '\ue000' : false;
    }
}

