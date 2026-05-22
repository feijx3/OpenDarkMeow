/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.ReplaceWith
 *  kotlin.SinceKotlin
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.time.ExperimentalTime
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.ExperimentalTime;
import kotlin.time.InstantJvmKt;
import kotlin.time.InstantKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u0001'B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u0005J\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001cH\u0002J\u0019\u0010!\u001a\u00020\"2\n\u0010#\u001a\u00060$j\u0002`%H\u0002\u00a2\u0006\u0002\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006("}, d2={"Lkotlin/time/Instant;", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "epochSeconds", "", "nanosecondsOfSecond", "", "<init>", "(JI)V", "getEpochSeconds", "()J", "getNanosecondsOfSecond", "()I", "toEpochMilliseconds", "plus", "duration", "Lkotlin/time/Duration;", "plus-LRDsOJo", "(J)Lkotlin/time/Instant;", "minus", "minus-LRDsOJo", "other", "minus-UwyO8pc", "(Lkotlin/time/Instant;)J", "compareTo", "equals", "", "", "hashCode", "toString", "", "writeReplace", "readObject", "", "input", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "(Ljava/io/ObjectInputStream;)V", "Companion", "kotlin-stdlib"})
@SinceKotlin(version="2.1")
@ExperimentalTime
@SourceDebugExtension(value={"SMAP\nInstant.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Instant.kt\nkotlin/time/Instant\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Instant.kt\nkotlin/time/InstantKt\n+ 4 Duration.kt\nkotlin/time/Duration\n*L\n1#1,864:1\n1#2:865\n803#3,14:866\n786#3,6:880\n803#3,14:886\n786#3,6:900\n786#3,6:907\n548#4:906\n*S KotlinDebug\n*F\n+ 1 Instant.kt\nkotlin/time/Instant\n*L\n150#1:866,14\n153#1:880,6\n161#1:886,14\n164#1:900,6\n188#1:907,6\n184#1:906\n*E\n"})
public final class Instant
implements Comparable<Instant>,
Serializable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final long epochSeconds;
    private final int nanosecondsOfSecond;
    @NotNull
    private static final Instant MIN = new Instant(-31557014167219200L, 0);
    @NotNull
    private static final Instant MAX = new Instant(31556889864403199L, 999999999);

    public Instant(long epochSeconds, int nanosecondsOfSecond) {
        this.epochSeconds = epochSeconds;
        this.nanosecondsOfSecond = nanosecondsOfSecond;
        long l2 = this.epochSeconds;
        if (!(-31557014167219200L <= l2 ? l2 < 31556889864403200L : false)) {
            boolean bl2 = false;
            String string = "Instant exceeds minimum or maximum instant";
            throw new IllegalArgumentException(string.toString());
        }
    }

    public final long getEpochSeconds() {
        return this.epochSeconds;
    }

    public final int getNanosecondsOfSecond() {
        return this.nanosecondsOfSecond;
    }

    /*
     * WARNING - void declaration
     */
    public final long toEpochMilliseconds() {
        long l2;
        void a$iv;
        if (this.epochSeconds >= 0L) {
            long l3;
            void a$iv2;
            long l4 = this.epochSeconds;
            long b$iv = 1000L;
            boolean $i$f$safeMultiplyOrElse = false;
            if (b$iv == 1L) {
                l3 = a$iv2;
            } else if (a$iv2 == 1L) {
                l3 = b$iv;
            } else if (a$iv2 == 0L || b$iv == 0L) {
                l3 = 0L;
            } else {
                void total$iv = a$iv2 * b$iv;
                if (total$iv / b$iv != a$iv2 || a$iv2 == Long.MIN_VALUE && b$iv == -1L || b$iv == Long.MIN_VALUE && a$iv2 == -1L) {
                    boolean bl2 = false;
                    return Long.MAX_VALUE;
                }
                l3 = total$iv;
            }
            void millis = l3;
            long b$iv2 = this.nanosecondsOfSecond / 1000000;
            boolean $i$f$safeAddOrElse = false;
            void sum$iv = millis + b$iv2;
            if ((millis ^ sum$iv) < 0L && (millis ^ b$iv2) >= 0L) {
                boolean bl3 = false;
                return Long.MAX_VALUE;
            }
            return (long)sum$iv;
        }
        long b$iv2 = this.epochSeconds + 1L;
        long b$iv = 1000L;
        boolean $i$f$safeMultiplyOrElse = false;
        if (b$iv == 1L) {
            l2 = a$iv;
        } else if (a$iv == 1L) {
            l2 = b$iv;
        } else if (a$iv == 0L || b$iv == 0L) {
            l2 = 0L;
        } else {
            void total$iv = a$iv * b$iv;
            if (total$iv / b$iv != a$iv || a$iv == Long.MIN_VALUE && b$iv == -1L || b$iv == Long.MIN_VALUE && a$iv == -1L) {
                boolean bl4 = false;
                return Long.MIN_VALUE;
            }
            l2 = total$iv;
        }
        void millis = l2;
        b$iv2 = this.nanosecondsOfSecond / 1000000 - 1000;
        boolean $i$f$safeAddOrElse = false;
        void sum$iv = millis + b$iv2;
        if ((millis ^ sum$iv) < 0L && (millis ^ b$iv2) >= 0L) {
            boolean bl5 = false;
            return Long.MIN_VALUE;
        }
        return (long)sum$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Instant plus-LRDsOJo(long duration) {
        void nanosecondsToAdd;
        boolean bl2 = false;
        int n2 = Duration.getNanosecondsComponent-impl(duration);
        long secondsToAdd = Duration.getInWholeSeconds-impl(duration);
        boolean bl3 = false;
        if (secondsToAdd == 0L && nanosecondsToAdd == false) {
            return this;
        }
        long a$iv = this.epochSeconds;
        boolean $i$f$safeAddOrElse = false;
        long sum$iv = a$iv + secondsToAdd;
        if ((a$iv ^ sum$iv) < 0L && (a$iv ^ secondsToAdd) >= 0L) {
            boolean bl4 = false;
            return Duration.isPositive-impl(duration) ? MAX : MIN;
        }
        long newEpochSeconds = sum$iv;
        int nanoAdjustment = this.nanosecondsOfSecond + nanosecondsToAdd;
        return Companion.fromEpochSeconds(newEpochSeconds, nanoAdjustment);
    }

    @NotNull
    public final Instant minus-LRDsOJo(long duration) {
        return this.plus-LRDsOJo(Duration.unaryMinus-UwyO8pc(duration));
    }

    public final long minus-UwyO8pc(@NotNull Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return Duration.plus-LRDsOJo(DurationKt.toDuration(this.epochSeconds - other.epochSeconds, DurationUnit.SECONDS), DurationKt.toDuration(this.nanosecondsOfSecond - other.nanosecondsOfSecond, DurationUnit.NANOSECONDS));
    }

    @Override
    public int compareTo(@NotNull Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int s2 = Intrinsics.compare(this.epochSeconds, other.epochSeconds);
        if (s2 != 0) {
            return s2;
        }
        return Intrinsics.compare(this.nanosecondsOfSecond, other.nanosecondsOfSecond);
    }

    public boolean equals(@Nullable Object other) {
        return this == other || other instanceof Instant && this.epochSeconds == ((Instant)other).epochSeconds && this.nanosecondsOfSecond == ((Instant)other).nanosecondsOfSecond;
    }

    public int hashCode() {
        return Long.hashCode(this.epochSeconds) + 51 * this.nanosecondsOfSecond;
    }

    @NotNull
    public String toString() {
        return InstantKt.access$formatIso(this);
    }

    private final Object writeReplace() {
        return InstantJvmKt.serializedInstant(this);
    }

    private final void readObject(ObjectInputStream input) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u0011\u0010\u0011\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013\u00a8\u0006\u001a"}, d2={"Lkotlin/time/Instant$Companion;", "", "<init>", "()V", "now", "Lkotlin/time/Instant;", "fromEpochMilliseconds", "epochMilliseconds", "", "fromEpochSeconds", "epochSeconds", "nanosecondAdjustment", "", "parse", "input", "", "parseOrNull", "DISTANT_PAST", "getDISTANT_PAST", "()Lkotlin/time/Instant;", "DISTANT_FUTURE", "getDISTANT_FUTURE", "MIN", "getMIN$kotlin_stdlib", "MAX", "getMAX$kotlin_stdlib", "kotlin-stdlib"})
    @SourceDebugExtension(value={"SMAP\nInstant.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Instant.kt\nkotlin/time/Instant$Companion\n+ 2 Instant.kt\nkotlin/time/InstantKt\n*L\n1#1,864:1\n786#2,6:865\n*S KotlinDebug\n*F\n+ 1 Instant.kt\nkotlin/time/Instant$Companion\n*L\n312#1:865,6\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @Deprecated(message="Use Clock.System.now() instead", replaceWith=@ReplaceWith(expression="Clock.System.now()", imports={"kotlin.time.Clock"}), level=DeprecationLevel.ERROR)
        @NotNull
        public final Instant now() {
            throw new NotImplementedError(null, 1, null);
        }

        @NotNull
        public final Instant fromEpochMilliseconds(long epochMilliseconds) {
            long l2 = epochMilliseconds;
            long l3 = 1000L;
            long l4 = l2 / l3;
            if ((l2 ^ l3) < 0L && l4 * l3 != l2) {
                l4 += -1L;
            }
            long epochSeconds = l4;
            long l5 = epochMilliseconds;
            long l6 = 1000L;
            long l7 = l5 % l6;
            int nanosecondsOfSecond = (int)((l7 + (l6 & ((l7 ^ l6) & (l7 | -l7)) >> 63)) * (long)1000000);
            return epochSeconds < -31557014167219200L ? this.getMIN$kotlin_stdlib() : (epochSeconds > 31556889864403199L ? this.getMAX$kotlin_stdlib() : this.fromEpochSeconds(epochSeconds, nanosecondsOfSecond));
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final Instant fromEpochSeconds(long epochSeconds, long nanosecondAdjustment) {
            Instant instant;
            void b$iv;
            long l2 = nanosecondAdjustment;
            long l3 = 1000000000L;
            long l4 = l2 / l3;
            if ((l2 ^ l3) < 0L && l4 * l3 != l2) {
                l4 += -1L;
            }
            l2 = l4;
            boolean $i$f$safeAddOrElse = false;
            long sum$iv = epochSeconds + b$iv;
            if ((epochSeconds ^ sum$iv) < 0L && (epochSeconds ^ b$iv) >= 0L) {
                boolean bl2 = false;
                return epochSeconds > 0L ? Companion.getMAX$kotlin_stdlib() : Companion.getMIN$kotlin_stdlib();
            }
            long seconds = sum$iv;
            if (seconds < -31557014167219200L) {
                instant = this.getMIN$kotlin_stdlib();
            } else if (seconds > 31556889864403199L) {
                instant = this.getMAX$kotlin_stdlib();
            } else {
                long l5 = nanosecondAdjustment;
                long l6 = 1000000000L;
                long l7 = l5 % l6;
                int nanoseconds = (int)(l7 + (l6 & ((l7 ^ l6) & (l7 | -l7)) >> 63));
                instant = new Instant(seconds, nanoseconds);
            }
            return instant;
        }

        public static /* synthetic */ Instant fromEpochSeconds$default(Companion companion, long l2, long l3, int n2, Object object) {
            if ((n2 & 2) != 0) {
                l3 = 0L;
            }
            return companion.fromEpochSeconds(l2, l3);
        }

        @NotNull
        public final Instant fromEpochSeconds(long epochSeconds, int nanosecondAdjustment) {
            return this.fromEpochSeconds(epochSeconds, (long)nanosecondAdjustment);
        }

        @NotNull
        public final Instant parse(@NotNull CharSequence input) {
            Intrinsics.checkNotNullParameter(input, "input");
            return InstantKt.access$parseIso(input).toInstant();
        }

        @SinceKotlin(version="2.2")
        @Nullable
        public final Instant parseOrNull(@NotNull CharSequence input) {
            Intrinsics.checkNotNullParameter(input, "input");
            return InstantKt.access$parseIso(input).toInstantOrNull();
        }

        @NotNull
        public final Instant getDISTANT_PAST() {
            return this.fromEpochSeconds(-3217862419201L, 999999999);
        }

        @NotNull
        public final Instant getDISTANT_FUTURE() {
            return this.fromEpochSeconds(3093527980800L, 0);
        }

        @NotNull
        public final Instant getMIN$kotlin_stdlib() {
            return MIN;
        }

        @NotNull
        public final Instant getMAX$kotlin_stdlib() {
            return MAX;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

