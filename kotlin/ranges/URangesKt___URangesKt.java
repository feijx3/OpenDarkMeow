/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongProgression;
import kotlin.ranges.ULongRange;
import kotlin.ranges.URangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=5, xi=49, d1={"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u00a2\u0006\u0002\u0010\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0004*\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010\u0006\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\u0005H\u0007\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0007\u00a2\u0006\u0002\u0010\u0003\u001a\u0011\u0010\b\u001a\u00020\u0004*\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010\u0006\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\u0004*\u00020\u0005H\u0007\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u000bH\u0087\b\u00a2\u0006\u0002\u0010\f\u001a\u0012\u0010\n\u001a\u00020\u0004*\u00020\rH\u0087\b\u00a2\u0006\u0002\u0010\u000e\u001a\u0019\u0010\n\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\u0010\u0010\u001a\u0019\u0010\n\u001a\u00020\u0004*\u00020\r2\u0006\u0010\n\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\u0010\u0011\u001a\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u000bH\u0087\b\u001a\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0004*\u00020\rH\u0087\b\u001a\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000fH\u0007\u001a\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0004*\u00020\r2\u0006\u0010\n\u001a\u00020\u000fH\u0007\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0087\n\u00a2\u0006\u0002\b\u0016\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0087\n\u00a2\u0006\u0002\b\u0017\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0001H\u0087\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001f\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0004H\u0087\u0002\u00a2\u0006\u0004\b \u0010!\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\"H\u0087\u0002\u00a2\u0006\u0004\b#\u0010$\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\r2\u0006\u0010\u0018\u001a\u00020\"H\u0087\u0002\u00a2\u0006\u0004\b%\u0010&\u001a\u001c\u0010'\u001a\u00020\u0002*\u00020\u00192\u0006\u0010(\u001a\u00020\u0019H\u0087\u0004\u00a2\u0006\u0004\b)\u0010*\u001a\u001c\u0010'\u001a\u00020\u0002*\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0087\u0004\u00a2\u0006\u0004\b+\u0010,\u001a\u001c\u0010'\u001a\u00020\u0005*\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0087\u0004\u00a2\u0006\u0004\b-\u0010.\u001a\u001c\u0010'\u001a\u00020\u0002*\u00020\"2\u0006\u0010(\u001a\u00020\"H\u0087\u0004\u00a2\u0006\u0004\b/\u00100\u001a\f\u00101\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\f\u00101\u001a\u00020\u0005*\u00020\u0005H\u0007\u001a\u0015\u00102\u001a\u00020\u0002*\u00020\u00022\u0006\u00102\u001a\u000203H\u0087\u0004\u001a\u0015\u00102\u001a\u00020\u0005*\u00020\u00052\u0006\u00102\u001a\u000204H\u0087\u0004\u001a\u001c\u00105\u001a\u00020\u000b*\u00020\u00192\u0006\u0010(\u001a\u00020\u0019H\u0087\u0004\u00a2\u0006\u0004\b6\u00107\u001a\u001c\u00105\u001a\u00020\u000b*\u00020\u00012\u0006\u0010(\u001a\u00020\u0001H\u0087\u0004\u00a2\u0006\u0004\b8\u00109\u001a\u001c\u00105\u001a\u00020\r*\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0087\u0004\u00a2\u0006\u0004\b:\u0010;\u001a\u001c\u00105\u001a\u00020\u000b*\u00020\"2\u0006\u0010(\u001a\u00020\"H\u0087\u0004\u00a2\u0006\u0004\b<\u0010=\u001a\u001b\u0010>\u001a\u00020\u0001*\u00020\u00012\u0006\u0010?\u001a\u00020\u0001H\u0007\u00a2\u0006\u0004\b@\u0010A\u001a\u001b\u0010>\u001a\u00020\u0004*\u00020\u00042\u0006\u0010?\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\bB\u0010C\u001a\u001b\u0010>\u001a\u00020\u0019*\u00020\u00192\u0006\u0010?\u001a\u00020\u0019H\u0007\u00a2\u0006\u0004\bD\u0010E\u001a\u001b\u0010>\u001a\u00020\"*\u00020\"2\u0006\u0010?\u001a\u00020\"H\u0007\u00a2\u0006\u0004\bF\u0010G\u001a\u001b\u0010H\u001a\u00020\u0001*\u00020\u00012\u0006\u0010I\u001a\u00020\u0001H\u0007\u00a2\u0006\u0004\bJ\u0010A\u001a\u001b\u0010H\u001a\u00020\u0004*\u00020\u00042\u0006\u0010I\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\bK\u0010C\u001a\u001b\u0010H\u001a\u00020\u0019*\u00020\u00192\u0006\u0010I\u001a\u00020\u0019H\u0007\u00a2\u0006\u0004\bL\u0010E\u001a\u001b\u0010H\u001a\u00020\"*\u00020\"2\u0006\u0010I\u001a\u00020\"H\u0007\u00a2\u0006\u0004\bM\u0010G\u001a#\u0010N\u001a\u00020\u0001*\u00020\u00012\u0006\u0010?\u001a\u00020\u00012\u0006\u0010I\u001a\u00020\u0001H\u0007\u00a2\u0006\u0004\bO\u0010P\u001a#\u0010N\u001a\u00020\u0004*\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\bQ\u0010R\u001a#\u0010N\u001a\u00020\u0019*\u00020\u00192\u0006\u0010?\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u0019H\u0007\u00a2\u0006\u0004\bS\u0010T\u001a#\u0010N\u001a\u00020\"*\u00020\"2\u0006\u0010?\u001a\u00020\"2\u0006\u0010I\u001a\u00020\"H\u0007\u00a2\u0006\u0004\bU\u0010V\u001a!\u0010N\u001a\u00020\u0001*\u00020\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00010XH\u0007\u00a2\u0006\u0004\bY\u0010Z\u001a!\u0010N\u001a\u00020\u0004*\u00020\u00042\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00040XH\u0007\u00a2\u0006\u0004\b[\u0010\\\u00a8\u0006]"}, d2={"first", "Lkotlin/UInt;", "Lkotlin/ranges/UIntProgression;", "(Lkotlin/ranges/UIntProgression;)I", "Lkotlin/ULong;", "Lkotlin/ranges/ULongProgression;", "(Lkotlin/ranges/ULongProgression;)J", "firstOrNull", "last", "lastOrNull", "random", "Lkotlin/ranges/UIntRange;", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/ranges/ULongRange;", "(Lkotlin/ranges/ULongRange;)J", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "contains", "", "element", "contains-biwQdVI", "contains-GYNo2lE", "value", "Lkotlin/UByte;", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "Lkotlin/UShort;", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "coerceAtLeast", "minimumValue", "coerceAtLeast-J1ME1BU", "(II)I", "coerceAtLeast-eb3DHEI", "(JJ)J", "coerceAtLeast-Kr8caGY", "(BB)B", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-Kr8caGY", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-WZ9TVnA", "(III)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-VKSA0NQ", "(SSS)S", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "kotlin-stdlib"}, xs="kotlin/ranges/URangesKt")
class URangesKt___URangesKt {
    @SinceKotlin(version="1.7")
    public static final int first(@NotNull UIntProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$first + " is empty.");
        }
        return $this$first.getFirst-pVg5ArA();
    }

    @SinceKotlin(version="1.7")
    public static final long first(@NotNull ULongProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$first + " is empty.");
        }
        return $this$first.getFirst-s-VKNKU();
    }

    @SinceKotlin(version="1.7")
    @Nullable
    public static final UInt firstOrNull(@NotNull UIntProgression $this$firstOrNull) {
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        return $this$firstOrNull.isEmpty() ? null : UInt.box-impl($this$firstOrNull.getFirst-pVg5ArA());
    }

    @SinceKotlin(version="1.7")
    @Nullable
    public static final ULong firstOrNull(@NotNull ULongProgression $this$firstOrNull) {
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        return $this$firstOrNull.isEmpty() ? null : ULong.box-impl($this$firstOrNull.getFirst-s-VKNKU());
    }

    @SinceKotlin(version="1.7")
    public static final int last(@NotNull UIntProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$last + " is empty.");
        }
        return $this$last.getLast-pVg5ArA();
    }

    @SinceKotlin(version="1.7")
    public static final long last(@NotNull ULongProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$last + " is empty.");
        }
        return $this$last.getLast-s-VKNKU();
    }

    @SinceKotlin(version="1.7")
    @Nullable
    public static final UInt lastOrNull(@NotNull UIntProgression $this$lastOrNull) {
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        return $this$lastOrNull.isEmpty() ? null : UInt.box-impl($this$lastOrNull.getLast-pVg5ArA());
    }

    @SinceKotlin(version="1.7")
    @Nullable
    public static final ULong lastOrNull(@NotNull ULongProgression $this$lastOrNull) {
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        return $this$lastOrNull.isEmpty() ? null : ULong.box-impl($this$lastOrNull.getLast-s-VKNKU());
    }

    @SinceKotlin(version="1.5")
    @InlineOnly
    private static final int random(UIntRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return URangesKt.random($this$random, (Random)Random.Default);
    }

    @SinceKotlin(version="1.5")
    @InlineOnly
    private static final long random(ULongRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return URangesKt.random($this$random, (Random)Random.Default);
    }

    @SinceKotlin(version="1.5")
    public static final int random(@NotNull UIntRange $this$random, @NotNull Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextUInt(random, $this$random);
        }
        catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @SinceKotlin(version="1.5")
    public static final long random(@NotNull ULongRange $this$random, @NotNull Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextULong(random, $this$random);
        }
        catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @SinceKotlin(version="1.5")
    @InlineOnly
    private static final UInt randomOrNull(UIntRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return URangesKt.randomOrNull($this$randomOrNull, (Random)Random.Default);
    }

    @SinceKotlin(version="1.5")
    @InlineOnly
    private static final ULong randomOrNull(ULongRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return URangesKt.randomOrNull($this$randomOrNull, (Random)Random.Default);
    }

    @SinceKotlin(version="1.5")
    @Nullable
    public static final UInt randomOrNull(@NotNull UIntRange $this$randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return UInt.box-impl(URandomKt.nextUInt(random, $this$randomOrNull));
    }

    @SinceKotlin(version="1.5")
    @Nullable
    public static final ULong randomOrNull(@NotNull ULongRange $this$randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return ULong.box-impl(URandomKt.nextULong(random, $this$randomOrNull));
    }

    @SinceKotlin(version="1.5")
    @InlineOnly
    private static final boolean contains-biwQdVI(UIntRange $this$contains_u2dbiwQdVI, UInt element) {
        Intrinsics.checkNotNullParameter($this$contains_u2dbiwQdVI, "$this$contains");
        return element != null && $this$contains_u2dbiwQdVI.contains-WZ4Q5Ns(element.unbox-impl());
    }

    @SinceKotlin(version="1.5")
    @InlineOnly
    private static final boolean contains-GYNo2lE(ULongRange $this$contains_u2dGYNo2lE, ULong element) {
        Intrinsics.checkNotNullParameter($this$contains_u2dGYNo2lE, "$this$contains");
        return element != null && $this$contains_u2dGYNo2lE.contains-VKZWuLQ(element.unbox-impl());
    }

    @SinceKotlin(version="1.5")
    public static final boolean contains-68kG9v0(@NotNull UIntRange $this$contains_u2d68kG9v0, byte value) {
        Intrinsics.checkNotNullParameter($this$contains_u2d68kG9v0, "$this$contains");
        return $this$contains_u2d68kG9v0.contains-WZ4Q5Ns(UInt.constructor-impl(value & 0xFF));
    }

    @SinceKotlin(version="1.5")
    public static final boolean contains-ULb-yJY(@NotNull ULongRange $this$contains_u2dULb_u2dyJY, byte value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dULb_u2dyJY, "$this$contains");
        return $this$contains_u2dULb_u2dyJY.contains-VKZWuLQ(ULong.constructor-impl((long)value & 0xFFL));
    }

    @SinceKotlin(version="1.5")
    public static final boolean contains-Gab390E(@NotNull ULongRange $this$contains_u2dGab390E, int value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dGab390E, "$this$contains");
        return $this$contains_u2dGab390E.contains-VKZWuLQ(ULong.constructor-impl((long)value & 0xFFFFFFFFL));
    }

    @SinceKotlin(version="1.5")
    public static final boolean contains-fz5IDCE(@NotNull UIntRange $this$contains_u2dfz5IDCE, long value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dfz5IDCE, "$this$contains");
        int n2 = 32;
        return ULong.constructor-impl(value >>> n2) == 0L && $this$contains_u2dfz5IDCE.contains-WZ4Q5Ns(UInt.constructor-impl((int)value));
    }

    @SinceKotlin(version="1.5")
    public static final boolean contains-ZsK3CEQ(@NotNull UIntRange $this$contains_u2dZsK3CEQ, short value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dZsK3CEQ, "$this$contains");
        return $this$contains_u2dZsK3CEQ.contains-WZ4Q5Ns(UInt.constructor-impl(value & 0xFFFF));
    }

    @SinceKotlin(version="1.5")
    public static final boolean contains-uhHAxoY(@NotNull ULongRange $this$contains_u2duhHAxoY, short value) {
        Intrinsics.checkNotNullParameter($this$contains_u2duhHAxoY, "$this$contains");
        return $this$contains_u2duhHAxoY.contains-VKZWuLQ(ULong.constructor-impl((long)value & 0xFFFFL));
    }

    @SinceKotlin(version="1.5")
    @NotNull
    public static final UIntProgression downTo-Kr8caGY(byte $this$downTo_u2dKr8caGY, byte to) {
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs(UInt.constructor-impl($this$downTo_u2dKr8caGY & 0xFF), UInt.constructor-impl(to & 0xFF), -1);
    }

    @SinceKotlin(version="1.5")
    @NotNull
    public static final UIntProgression downTo-J1ME1BU(int $this$downTo_u2dJ1ME1BU, int to) {
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs($this$downTo_u2dJ1ME1BU, to, -1);
    }

    @SinceKotlin(version="1.5")
    @NotNull
    public static final ULongProgression downTo-eb3DHEI(long $this$downTo_u2deb3DHEI, long to) {
        return ULongProgression.Companion.fromClosedRange-7ftBX0g($this$downTo_u2deb3DHEI, to, -1L);
    }

    @SinceKotlin(version="1.5")
    @NotNull
    public static final UIntProgression downTo-5PvTz6A(short $this$downTo_u2d5PvTz6A, short to) {
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs(UInt.constructor-impl($this$downTo_u2d5PvTz6A & 0xFFFF), UInt.constructor-impl(to & 0xFFFF), -1);
    }

    @SinceKotlin(version="1.5")
    @NotNull
    public static final UIntProgression reversed(@NotNull UIntProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs($this$reversed.getLast-pVg5ArA(), $this$reversed.getFirst-pVg5ArA(), -$this$reversed.getStep());
    }

    @SinceKotlin(version="1.5")
    @NotNull
    public static final ULongProgression reversed(@NotNull ULongProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return ULongProgression.Companion.fromClosedRange-7ftBX0g($this$reversed.getLast-s-VKNKU(), $this$reversed.getFirst-s-VKNKU(), -$this$reversed.getStep());
    }

    @SinceKotlin(version="1.5")
    @NotNull
    public static final UIntProgression step(@NotNull UIntProgression $this$step, int step) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt.checkStepIsPositive(step > 0, step);
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs($this$step.getFirst-pVg5ArA(), $this$step.getLast-pVg5ArA(), $this$step.getStep() > 0 ? step : -step);
    }

    @SinceKotlin(version="1.5")
    @NotNull
    public static final ULongProgression step(@NotNull ULongProgression $this$step, long step) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt.checkStepIsPositive(step > 0L, step);
        return ULongProgression.Companion.fromClosedRange-7ftBX0g($this$step.getFirst-s-VKNKU(), $this$step.getLast-s-VKNKU(), $this$step.getStep() > 0L ? step : -step);
    }

    @SinceKotlin(version="1.5")
    @NotNull
    public static final UIntRange until-Kr8caGY(byte $this$until_u2dKr8caGY, byte to) {
        int n2 = 0;
        if (Intrinsics.compare(to & 0xFF, n2 & 0xFF) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        n2 = UInt.constructor-impl($this$until_u2dKr8caGY & 0xFF);
        int n3 = 1;
        n3 = UInt.constructor-impl(UInt.constructor-impl(to & 0xFF) - n3);
        return new UIntRange(n2, n3, null);
    }

    @SinceKotlin(version="1.5")
    @NotNull
    public static final UIntRange until-J1ME1BU(int $this$until_u2dJ1ME1BU, int to) {
        if (Integer.compareUnsigned(to, 0) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        return new UIntRange($this$until_u2dJ1ME1BU, UInt.constructor-impl(to - 1), null);
    }

    @SinceKotlin(version="1.5")
    @NotNull
    public static final ULongRange until-eb3DHEI(long $this$until_u2deb3DHEI, long to) {
        if (Long.compareUnsigned(to, 0L) <= 0) {
            return ULongRange.Companion.getEMPTY();
        }
        int n2 = 1;
        long l2 = ULong.constructor-impl(to - ULong.constructor-impl((long)n2 & 0xFFFFFFFFL));
        return new ULongRange($this$until_u2deb3DHEI, l2, null);
    }

    @SinceKotlin(version="1.5")
    @NotNull
    public static final UIntRange until-5PvTz6A(short $this$until_u2d5PvTz6A, short to) {
        int n2 = 0;
        if (Intrinsics.compare(to & 0xFFFF, n2 & 0xFFFF) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        n2 = UInt.constructor-impl($this$until_u2d5PvTz6A & 0xFFFF);
        int n3 = 1;
        n3 = UInt.constructor-impl(UInt.constructor-impl(to & 0xFFFF) - n3);
        return new UIntRange(n2, n3, null);
    }

    @SinceKotlin(version="1.5")
    public static final int coerceAtLeast-J1ME1BU(int $this$coerceAtLeast_u2dJ1ME1BU, int minimumValue) {
        return Integer.compareUnsigned($this$coerceAtLeast_u2dJ1ME1BU, minimumValue) < 0 ? minimumValue : $this$coerceAtLeast_u2dJ1ME1BU;
    }

    @SinceKotlin(version="1.5")
    public static final long coerceAtLeast-eb3DHEI(long $this$coerceAtLeast_u2deb3DHEI, long minimumValue) {
        return Long.compareUnsigned($this$coerceAtLeast_u2deb3DHEI, minimumValue) < 0 ? minimumValue : $this$coerceAtLeast_u2deb3DHEI;
    }

    @SinceKotlin(version="1.5")
    public static final byte coerceAtLeast-Kr8caGY(byte $this$coerceAtLeast_u2dKr8caGY, byte minimumValue) {
        return Intrinsics.compare($this$coerceAtLeast_u2dKr8caGY & 0xFF, minimumValue & 0xFF) < 0 ? minimumValue : $this$coerceAtLeast_u2dKr8caGY;
    }

    @SinceKotlin(version="1.5")
    public static final short coerceAtLeast-5PvTz6A(short $this$coerceAtLeast_u2d5PvTz6A, short minimumValue) {
        return Intrinsics.compare($this$coerceAtLeast_u2d5PvTz6A & 0xFFFF, minimumValue & 0xFFFF) < 0 ? minimumValue : $this$coerceAtLeast_u2d5PvTz6A;
    }

    @SinceKotlin(version="1.5")
    public static final int coerceAtMost-J1ME1BU(int $this$coerceAtMost_u2dJ1ME1BU, int maximumValue) {
        return Integer.compareUnsigned($this$coerceAtMost_u2dJ1ME1BU, maximumValue) > 0 ? maximumValue : $this$coerceAtMost_u2dJ1ME1BU;
    }

    @SinceKotlin(version="1.5")
    public static final long coerceAtMost-eb3DHEI(long $this$coerceAtMost_u2deb3DHEI, long maximumValue) {
        return Long.compareUnsigned($this$coerceAtMost_u2deb3DHEI, maximumValue) > 0 ? maximumValue : $this$coerceAtMost_u2deb3DHEI;
    }

    @SinceKotlin(version="1.5")
    public static final byte coerceAtMost-Kr8caGY(byte $this$coerceAtMost_u2dKr8caGY, byte maximumValue) {
        return Intrinsics.compare($this$coerceAtMost_u2dKr8caGY & 0xFF, maximumValue & 0xFF) > 0 ? maximumValue : $this$coerceAtMost_u2dKr8caGY;
    }

    @SinceKotlin(version="1.5")
    public static final short coerceAtMost-5PvTz6A(short $this$coerceAtMost_u2d5PvTz6A, short maximumValue) {
        return Intrinsics.compare($this$coerceAtMost_u2d5PvTz6A & 0xFFFF, maximumValue & 0xFFFF) > 0 ? maximumValue : $this$coerceAtMost_u2d5PvTz6A;
    }

    @SinceKotlin(version="1.5")
    public static final int coerceIn-WZ9TVnA(int $this$coerceIn_u2dWZ9TVnA, int minimumValue, int maximumValue) {
        if (Integer.compareUnsigned(minimumValue, maximumValue) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UInt.toString-impl(maximumValue) + " is less than minimum " + UInt.toString-impl(minimumValue) + '.');
        }
        if (Integer.compareUnsigned($this$coerceIn_u2dWZ9TVnA, minimumValue) < 0) {
            return minimumValue;
        }
        if (Integer.compareUnsigned($this$coerceIn_u2dWZ9TVnA, maximumValue) > 0) {
            return maximumValue;
        }
        return $this$coerceIn_u2dWZ9TVnA;
    }

    @SinceKotlin(version="1.5")
    public static final long coerceIn-sambcqE(long $this$coerceIn_u2dsambcqE, long minimumValue, long maximumValue) {
        if (Long.compareUnsigned(minimumValue, maximumValue) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ULong.toString-impl(maximumValue) + " is less than minimum " + ULong.toString-impl(minimumValue) + '.');
        }
        if (Long.compareUnsigned($this$coerceIn_u2dsambcqE, minimumValue) < 0) {
            return minimumValue;
        }
        if (Long.compareUnsigned($this$coerceIn_u2dsambcqE, maximumValue) > 0) {
            return maximumValue;
        }
        return $this$coerceIn_u2dsambcqE;
    }

    @SinceKotlin(version="1.5")
    public static final byte coerceIn-b33U2AM(byte $this$coerceIn_u2db33U2AM, byte minimumValue, byte maximumValue) {
        if (Intrinsics.compare(minimumValue & 0xFF, maximumValue & 0xFF) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UByte.toString-impl(maximumValue) + " is less than minimum " + UByte.toString-impl(minimumValue) + '.');
        }
        if (Intrinsics.compare($this$coerceIn_u2db33U2AM & 0xFF, minimumValue & 0xFF) < 0) {
            return minimumValue;
        }
        if (Intrinsics.compare($this$coerceIn_u2db33U2AM & 0xFF, maximumValue & 0xFF) > 0) {
            return maximumValue;
        }
        return $this$coerceIn_u2db33U2AM;
    }

    @SinceKotlin(version="1.5")
    public static final short coerceIn-VKSA0NQ(short $this$coerceIn_u2dVKSA0NQ, short minimumValue, short maximumValue) {
        if (Intrinsics.compare(minimumValue & 0xFFFF, maximumValue & 0xFFFF) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UShort.toString-impl(maximumValue) + " is less than minimum " + UShort.toString-impl(minimumValue) + '.');
        }
        if (Intrinsics.compare($this$coerceIn_u2dVKSA0NQ & 0xFFFF, minimumValue & 0xFFFF) < 0) {
            return minimumValue;
        }
        if (Intrinsics.compare($this$coerceIn_u2dVKSA0NQ & 0xFFFF, maximumValue & 0xFFFF) > 0) {
            return maximumValue;
        }
        return $this$coerceIn_u2dVKSA0NQ;
    }

    @SinceKotlin(version="1.5")
    public static final int coerceIn-wuiCnnA(int $this$coerceIn_u2dwuiCnnA, @NotNull ClosedRange<UInt> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return RangesKt.coerceIn(UInt.box-impl($this$coerceIn_u2dwuiCnnA), (ClosedFloatingPointRange)range).unbox-impl();
        }
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        return Integer.compareUnsigned($this$coerceIn_u2dwuiCnnA, range.getStart().unbox-impl()) < 0 ? range.getStart().unbox-impl() : (Integer.compareUnsigned($this$coerceIn_u2dwuiCnnA, range.getEndInclusive().unbox-impl()) > 0 ? range.getEndInclusive().unbox-impl() : $this$coerceIn_u2dwuiCnnA);
    }

    @SinceKotlin(version="1.5")
    public static final long coerceIn-JPwROB0(long $this$coerceIn_u2dJPwROB0, @NotNull ClosedRange<ULong> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return RangesKt.coerceIn(ULong.box-impl($this$coerceIn_u2dJPwROB0), (ClosedFloatingPointRange)range).unbox-impl();
        }
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        return Long.compareUnsigned($this$coerceIn_u2dJPwROB0, range.getStart().unbox-impl()) < 0 ? range.getStart().unbox-impl() : (Long.compareUnsigned($this$coerceIn_u2dJPwROB0, range.getEndInclusive().unbox-impl()) > 0 ? range.getEndInclusive().unbox-impl() : $this$coerceIn_u2dJPwROB0);
    }
}

