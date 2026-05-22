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
package kotlin.internal;

import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;
import kotlin.time.Clock;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0017\u00a8\u0006\u0016"}, d2={"Lkotlin/internal/PlatformImplementations;", "", "<init>", "()V", "addSuppressed", "", "cause", "", "exception", "getSuppressed", "", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "defaultPlatformRandom", "Lkotlin/random/Random;", "getSystemClock", "Lkotlin/time/Clock;", "ReflectThrowable", "kotlin-stdlib"})
@SourceDebugExtension(value={"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n1#2:87\n*E\n"})
public class PlatformImplementations {
    public void addSuppressed(@NotNull Throwable cause, @NotNull Throwable exception) {
        block0: {
            Intrinsics.checkNotNullParameter(cause, "cause");
            Intrinsics.checkNotNullParameter(exception, "exception");
            Method method = ReflectThrowable.addSuppressed;
            if (method == null) break block0;
            Object[] objectArray = new Object[]{exception};
            method.invoke(cause, objectArray);
        }
    }

    @NotNull
    public List<Throwable> getSuppressed(@NotNull Throwable exception) {
        Object object;
        block3: {
            block2: {
                Intrinsics.checkNotNullParameter(exception, "exception");
                object = ReflectThrowable.getSuppressed;
                if (object == null || (object = ((Method)object).invoke(exception, new Object[0])) == null) break block2;
                List<Throwable> it = object;
                boolean bl2 = false;
                List<Throwable> list = ArraysKt.asList((Throwable[])it);
                object = list;
                if (list != null) break block3;
            }
            object = CollectionsKt.emptyList();
        }
        return object;
    }

    @Nullable
    public MatchGroup getMatchResultNamedGroup(@NotNull MatchResult matchResult, @NotNull String name) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        Intrinsics.checkNotNullParameter(name, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    @NotNull
    public Random defaultPlatformRandom() {
        return new FallbackThreadLocalRandom();
    }

    @ExperimentalTime
    @NotNull
    public Clock getSystemClock() {
        throw new UnsupportedOperationException("getSystemClock should not be called on the base PlatformImplementations.");
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "<init>", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib"})
    @SourceDebugExtension(value={"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations$ReflectThrowable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n1#2:87\n*E\n"})
    private static final class ReflectThrowable {
        @NotNull
        public static final ReflectThrowable INSTANCE;
        @JvmField
        @Nullable
        public static final Method addSuppressed;
        @JvmField
        @Nullable
        public static final Method getSuppressed;

        private ReflectThrowable() {
        }

        /*
         * Unable to fully structure code
         */
        static {
            block5: {
                block4: {
                    ReflectThrowable.INSTANCE = new ReflectThrowable();
                    throwableClass = Throwable.class;
                    throwableMethods = throwableClass.getMethods();
                    Intrinsics.checkNotNull(throwableMethods);
                    var2_2 = throwableMethods;
                    var4_4 = var2_2.length;
                    for (var3_3 = 0; var3_3 < var4_4; ++var3_3) {
                        it = var5_5 = var2_2[var3_3];
                        $i$a$-find-PlatformImplementations$ReflectThrowable$1 = false;
                        if (!Intrinsics.areEqual(it.getName(), "addSuppressed")) ** GOTO lbl-1000
                        v0 = it.getParameterTypes();
                        Intrinsics.checkNotNullExpressionValue(v0, "getParameterTypes(...)");
                        if (Intrinsics.areEqual(ArraysKt.singleOrNull((Object[])v0), throwableClass)) {
                            v1 = true;
                        } else lbl-1000:
                        // 2 sources

                        {
                            v1 = false;
                        }
                        if (!v1) continue;
                        v2 = var5_5;
                        break block4;
                    }
                    v2 = null;
                }
                ReflectThrowable.addSuppressed = v2;
                var2_2 = throwableMethods;
                var4_4 = var2_2.length;
                for (var3_3 = 0; var3_3 < var4_4; ++var3_3) {
                    it = var5_5 = var2_2[var3_3];
                    $i$a$-find-PlatformImplementations$ReflectThrowable$2 = false;
                    if (!Intrinsics.areEqual(it.getName(), "getSuppressed")) continue;
                    v3 = var5_5;
                    break block5;
                }
                v3 = null;
            }
            ReflectThrowable.getSuppressed = v3;
        }
    }
}

