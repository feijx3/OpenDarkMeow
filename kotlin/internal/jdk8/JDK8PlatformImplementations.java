/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.time.ExperimentalTime
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.internal.jdk8;

import java.time.Instant;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.random.jdk8.PlatformThreadLocalRandom;
import kotlin.ranges.IntRange;
import kotlin.text.MatchGroup;
import kotlin.time.Clock;
import kotlin.time.ExperimentalTime;
import kotlin.time.jdk8.InstantConversionsJDK8Kt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0017\u00a8\u0006\u0013"}, d2={"Lkotlin/internal/jdk8/JDK8PlatformImplementations;", "Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "<init>", "()V", "sdkIsNullOrAtLeast", "", "version", "", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "defaultPlatformRandom", "Lkotlin/random/Random;", "getSystemClock", "Lkotlin/time/Clock;", "ReflectSdkVersion", "kotlin-stdlib-jdk8"})
public class JDK8PlatformImplementations
extends JDK7PlatformImplementations {
    private final boolean sdkIsNullOrAtLeast(int version) {
        return ReflectSdkVersion.sdkVersion == null || ReflectSdkVersion.sdkVersion >= version;
    }

    @Override
    @Nullable
    public MatchGroup getMatchResultNamedGroup(@NotNull MatchResult matchResult, @NotNull String name) {
        MatchGroup matchGroup;
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        Intrinsics.checkNotNullParameter(name, "name");
        Matcher matcher = matchResult instanceof Matcher ? (Matcher)matchResult : null;
        if (matcher == null) {
            throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        }
        Matcher matcher2 = matcher;
        IntRange range = new IntRange(matcher2.start(name), matcher2.end(name) - 1);
        if (range.getStart() >= 0) {
            String string = matcher2.group(name);
            Intrinsics.checkNotNullExpressionValue(string, "group(...)");
            matchGroup = new MatchGroup(string, range);
        } else {
            matchGroup = null;
        }
        return matchGroup;
    }

    @Override
    @NotNull
    public Random defaultPlatformRandom() {
        return this.sdkIsNullOrAtLeast(34) ? (Random)new PlatformThreadLocalRandom() : super.defaultPlatformRandom();
    }

    @Override
    @ExperimentalTime
    @NotNull
    public Clock getSystemClock() {
        return this.sdkIsNullOrAtLeast(26) ? (Clock)new Clock(){

            public kotlin.time.Instant now() {
                Instant instant = Instant.now();
                Intrinsics.checkNotNullExpressionValue(instant, "now(...)");
                return InstantConversionsJDK8Kt.toKotlinInstant(instant);
            }
        } : (Clock)new Clock(){

            public kotlin.time.Instant now() {
                return kotlin.time.Instant.Companion.fromEpochMilliseconds(System.currentTimeMillis());
            }
        };
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion;", "", "<init>", "()V", "sdkVersion", "", "Ljava/lang/Integer;", "kotlin-stdlib-jdk8"})
    @SourceDebugExtension(value={"SMAP\nJDK8PlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JDK8PlatformImplementations.kt\nkotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,76:1\n1#2:77\n*E\n"})
    private static final class ReflectSdkVersion {
        @NotNull
        public static final ReflectSdkVersion INSTANCE;
        @JvmField
        @Nullable
        public static final Integer sdkVersion;

        private ReflectSdkVersion() {
        }

        static {
            Object object;
            Object object2;
            INSTANCE = new ReflectSdkVersion();
            try {
                object2 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
                object2 = object2 instanceof Integer ? (Integer)object2 : null;
            }
            catch (Throwable e2) {
                object2 = null;
            }
            Object object3 = object2;
            if (object3 != null) {
                object2 = object3;
                int it = ((Number)object2).intValue();
                boolean bl2 = false;
                object = it > 0 ? object2 : null;
            } else {
                object = null;
            }
            sdkVersion = object;
        }
    }
}

