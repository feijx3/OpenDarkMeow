/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.PublishedApi
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFrames;
import _COROUTINE.CoroutineDebuggingKt;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ExceptionsConstructorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000d\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u001a\u001f\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\nH\u0000\u00a2\u0006\u0002\u0010\r\u001a\u001b\u0010\u000e\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b*\u0002H\nH\u0002\u00a2\u0006\u0002\u0010\r\u001a,\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\n2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0080\b\u00a2\u0006\u0002\u0010\u0011\u001a+\u0010\u0012\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\n2\n\u0010\u000f\u001a\u00060\u0013j\u0002`\u0014H\u0002\u00a2\u0006\u0002\u0010\u0015\u001a9\u0010\u0016\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\u0017\u001a\u0002H\n2\u0006\u0010\u0018\u001a\u0002H\n2\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u001b0\u001aH\u0002\u00a2\u0006\u0002\u0010\u001c\u001a1\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u0002H\n\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0004j\u0002`\u001b0\u001f0\u001e\"\b\b\u0000\u0010\n*\u00020\u000b*\u0002H\nH\u0002\u00a2\u0006\u0002\u0010 \u001a1\u0010!\u001a\u00020\"2\u0010\u0010#\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u001b0\u001f2\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u001b0\u001aH\u0002\u00a2\u0006\u0002\u0010$\u001a\u0016\u0010%\u001a\u00020&2\u0006\u0010\f\u001a\u00020\u000bH\u0080H\u00a2\u0006\u0002\u0010'\u001a \u0010(\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\nH\u0081\b\u00a2\u0006\u0002\u0010\r\u001a\u001f\u0010)\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\nH\u0001\u00a2\u0006\u0002\u0010\r\u001a\u001e\u0010*\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u001b0\u001a2\n\u0010\u000f\u001a\u00060\u0013j\u0002`\u0014H\u0002\u001a\u0010\u0010+\u001a\u00020,*\u00060\u0004j\u0002`\u001bH\u0000\u001a#\u0010-\u001a\u00020.*\f\u0012\b\u0012\u00060\u0004j\u0002`\u001b0\u001f2\u0006\u0010/\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\u00100\u001a\u001c\u00101\u001a\u00020,*\u00060\u0004j\u0002`\u001b2\n\u00102\u001a\u00060\u0004j\u0002`\u001bH\u0002\u001a\u0014\u00105\u001a\u00020\"*\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0018\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007\"\u0018\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007*\f\b\u0000\u00103\"\u00020\u00132\u00020\u0013*\f\b\u0000\u00104\"\u00020\u00042\u00020\u0004\u00a8\u00066"}, d2={"baseContinuationImplClass", "", "stackTraceRecoveryClass", "ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "stackTraceRecoveryClassName", "recoverStackTrace", "E", "", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "sanitizeStackTrace", "continuation", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "recoverFromStackFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "createFinalException", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "Lkotlinx/coroutines/internal/StackTraceElement;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "causeAndStacktrace", "Lkotlin/Pair;", "", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "mergeRecoveredTraces", "", "recoveredStacktrace", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unwrap", "unwrapImpl", "createStackTrace", "isArtificial", "", "firstFrameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "elementWiseEquals", "e", "CoroutineStackFrame", "StackTraceElement", "initCause", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nStackTraceRecovery.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,210:1\n1790#2,6:211\n12567#2,2:221\n1682#2,6:223\n12567#2,2:229\n1682#2,6:232\n37#3:217\n36#3,3:218\n1#4:231\n*S KotlinDebug\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n39#1:211,6\n127#1:221,2\n137#1:223,6\n169#1:229,2\n190#1:232,6\n102#1:217\n102#1:218,3\n*E\n"})
public final class StackTraceRecoveryKt {
    @NotNull
    private static final String baseContinuationImplClass = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    @NotNull
    private static final String stackTraceRecoveryClass = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    @NotNull
    private static final StackTraceElement ARTIFICIAL_FRAME;
    private static final String baseContinuationImplClassName;
    private static final String stackTraceRecoveryClassName;

    @NotNull
    public static final <E extends Throwable> E recoverStackTrace(@NotNull E exception) {
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            return exception;
        }
        E e2 = ExceptionsConstructorKt.tryCopyException(exception);
        if (e2 == null) {
            return exception;
        }
        E copy = e2;
        return StackTraceRecoveryKt.sanitizeStackTrace(copy);
    }

    private static final <E extends Throwable> E sanitizeStackTrace(E $this$sanitizeStackTrace) {
        int n2;
        int size;
        StackTraceElement[] stackTrace;
        block3: {
            stackTrace = $this$sanitizeStackTrace.getStackTrace();
            size = stackTrace.length;
            StackTraceElement[] $this$indexOfLast$iv = stackTrace;
            boolean $i$f$indexOfLast = false;
            int n3 = $this$indexOfLast$iv.length + -1;
            if (0 <= n3) {
                do {
                    int index$iv = n3--;
                    StackTraceElement it = $this$indexOfLast$iv[index$iv];
                    boolean bl2 = false;
                    if (!Intrinsics.areEqual(stackTraceRecoveryClassName, it.getClassName())) continue;
                    n2 = index$iv;
                    break block3;
                } while (0 <= n3);
            }
            n2 = -1;
        }
        int lastIntrinsic = n2;
        int startIndex = lastIntrinsic + 1;
        int endIndex = StackTraceRecoveryKt.firstFrameIndex(stackTrace, baseContinuationImplClassName);
        int adjustment = endIndex == -1 ? 0 : size - endIndex;
        int n4 = size - lastIntrinsic - adjustment;
        StackTraceElement[] stackTraceElementArray = new StackTraceElement[n4];
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2;
            stackTraceElementArray[n5] = n5 == 0 ? ARTIFICIAL_FRAME : stackTrace[startIndex + n5 - 1];
        }
        StackTraceElement[] trace = stackTraceElementArray;
        $this$sanitizeStackTrace.setStackTrace(trace);
        return $this$sanitizeStackTrace;
    }

    @NotNull
    public static final <E extends Throwable> E recoverStackTrace(@NotNull E exception, @NotNull Continuation<?> continuation) {
        boolean $i$f$recoverStackTrace = false;
        if (!DebugKt.getRECOVER_STACK_TRACES() || !(continuation instanceof CoroutineStackFrame)) {
            return exception;
        }
        return (E)StackTraceRecoveryKt.recoverFromStackFrame(exception, (CoroutineStackFrame)((Object)continuation));
    }

    private static final <E extends Throwable> E recoverFromStackFrame(E exception, CoroutineStackFrame continuation) {
        Pair<E, StackTraceElement[]> pair = StackTraceRecoveryKt.causeAndStacktrace(exception);
        E cause = pair.component1();
        StackTraceElement[] recoveredStacktrace = pair.component2();
        E e2 = ExceptionsConstructorKt.tryCopyException(cause);
        if (e2 == null) {
            return exception;
        }
        E newException = e2;
        ArrayDeque<StackTraceElement> stacktrace = StackTraceRecoveryKt.createStackTrace(continuation);
        if (stacktrace.isEmpty()) {
            return exception;
        }
        if (cause != exception) {
            StackTraceRecoveryKt.mergeRecoveredTraces(recoveredStacktrace, stacktrace);
        }
        return StackTraceRecoveryKt.createFinalException(cause, newException, stacktrace);
    }

    private static final <E extends Throwable> E createFinalException(E cause, E result, ArrayDeque<StackTraceElement> resultStackTrace) {
        resultStackTrace.addFirst(ARTIFICIAL_FRAME);
        StackTraceElement[] causeTrace = cause.getStackTrace();
        int size = StackTraceRecoveryKt.firstFrameIndex(causeTrace, baseContinuationImplClassName);
        if (size == -1) {
            Collection $this$toTypedArray$iv = resultStackTrace;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            result.setStackTrace(thisCollection$iv.toArray(new StackTraceElement[0]));
            return result;
        }
        StackTraceElement[] mergedStackTrace = new StackTraceElement[resultStackTrace.size() + size];
        for (int i2 = 0; i2 < size; ++i2) {
            mergedStackTrace[i2] = causeTrace[i2];
        }
        Iterator iterator2 = ((Iterable)resultStackTrace).iterator();
        int n2 = 0;
        while (iterator2.hasNext()) {
            StackTraceElement element;
            int index = n2++;
            mergedStackTrace[size + index] = element = (StackTraceElement)iterator2.next();
        }
        result.setStackTrace(mergedStackTrace);
        return result;
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> causeAndStacktrace(E $this$causeAndStacktrace) {
        Pair<Object, StackTraceElement[]> pair;
        Throwable cause = $this$causeAndStacktrace.getCause();
        if (cause != null && Intrinsics.areEqual(cause.getClass(), $this$causeAndStacktrace.getClass())) {
            boolean bl2;
            StackTraceElement[] currentTrace;
            block3: {
                StackTraceElement[] $this$any$iv = currentTrace = $this$causeAndStacktrace.getStackTrace();
                boolean $i$f$any = false;
                int n2 = $this$any$iv.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    StackTraceElement element$iv;
                    StackTraceElement it = element$iv = $this$any$iv[i2];
                    boolean bl3 = false;
                    if (!StackTraceRecoveryKt.isArtificial(it)) continue;
                    bl2 = true;
                    break block3;
                }
                bl2 = false;
            }
            pair = bl2 ? TuplesKt.to(cause, currentTrace) : TuplesKt.to($this$causeAndStacktrace, new StackTraceElement[0]);
        } else {
            pair = TuplesKt.to($this$causeAndStacktrace, new StackTraceElement[0]);
        }
        return pair;
    }

    private static final void mergeRecoveredTraces(StackTraceElement[] recoveredStacktrace, ArrayDeque<StackTraceElement> result) {
        int lastFrameIndex;
        int n2;
        block4: {
            StackTraceElement[] $this$indexOfFirst$iv = recoveredStacktrace;
            boolean $i$f$indexOfFirst = false;
            int n3 = $this$indexOfFirst$iv.length;
            for (int index$iv = 0; index$iv < n3; ++index$iv) {
                StackTraceElement it = $this$indexOfFirst$iv[index$iv];
                boolean bl2 = false;
                if (!StackTraceRecoveryKt.isArtificial(it)) continue;
                n2 = index$iv;
                break block4;
            }
            n2 = -1;
        }
        int startIndex = n2 + 1;
        int i2 = lastFrameIndex = recoveredStacktrace.length - 1;
        if (startIndex <= i2) {
            while (true) {
                StackTraceElement element;
                if (StackTraceRecoveryKt.elementWiseEquals(element = recoveredStacktrace[i2], result.getLast())) {
                    result.removeLast();
                }
                result.addFirst(recoveredStacktrace[i2]);
                if (i2 == startIndex) break;
                --i2;
            }
        }
    }

    @Nullable
    public static final Object recoverAndThrow(@NotNull Throwable exception, @NotNull Continuation<?> $completion) {
        boolean $i$f$recoverAndThrow = false;
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            throw exception;
        }
        Continuation<?> it = $completion;
        boolean bl2 = false;
        if (!(it instanceof CoroutineStackFrame)) {
            throw exception;
        }
        throw StackTraceRecoveryKt.recoverFromStackFrame(exception, (CoroutineStackFrame)((Object)it));
    }

    private static final Object recoverAndThrow$$forInline(Throwable exception, Continuation<?> $completion) {
        boolean $i$f$recoverAndThrow = false;
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            throw exception;
        }
        InlineMarker.mark(0);
        Continuation<?> it = $completion;
        boolean bl2 = false;
        if (!(it instanceof CoroutineStackFrame)) {
            throw exception;
        }
        throw StackTraceRecoveryKt.recoverFromStackFrame(exception, (CoroutineStackFrame)((Object)it));
    }

    @PublishedApi
    @NotNull
    public static final <E extends Throwable> E unwrap(@NotNull E exception) {
        boolean $i$f$unwrap = false;
        return !DebugKt.getRECOVER_STACK_TRACES() ? exception : StackTraceRecoveryKt.unwrapImpl(exception);
    }

    @PublishedApi
    @NotNull
    public static final <E extends Throwable> E unwrapImpl(@NotNull E exception) {
        boolean bl2;
        Throwable cause;
        block3: {
            cause = exception.getCause();
            if (cause == null || !Intrinsics.areEqual(cause.getClass(), exception.getClass())) {
                return exception;
            }
            StackTraceElement[] $this$any$iv = exception.getStackTrace();
            boolean $i$f$any = false;
            int n2 = $this$any$iv.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                StackTraceElement element$iv;
                StackTraceElement it = element$iv = $this$any$iv[i2];
                boolean bl3 = false;
                if (!StackTraceRecoveryKt.isArtificial(it)) continue;
                bl2 = true;
                break block3;
            }
            bl2 = false;
        }
        if (bl2) {
            return (E)cause;
        }
        return exception;
    }

    private static final ArrayDeque<StackTraceElement> createStackTrace(CoroutineStackFrame continuation) {
        CoroutineStackFrame coroutineStackFrame;
        CoroutineStackFrame coroutineStackFrame2;
        ArrayDeque<StackTraceElement> stack = new ArrayDeque<StackTraceElement>();
        StackTraceElement stackTraceElement = continuation.getStackTraceElement();
        if (stackTraceElement != null) {
            StackTraceElement it = stackTraceElement;
            boolean bl2 = false;
            stack.add(it);
        }
        CoroutineStackFrame last = continuation;
        while ((coroutineStackFrame2 = (coroutineStackFrame = last) instanceof CoroutineStackFrame ? coroutineStackFrame : null) != null && (coroutineStackFrame2 = coroutineStackFrame2.getCallerFrame()) != null) {
            StackTraceElement it;
            last = coroutineStackFrame2;
            if (last.getStackTraceElement() == null) continue;
            boolean bl3 = false;
            stack.add(it);
        }
        return stack;
    }

    public static final boolean isArtificial(@NotNull StackTraceElement $this$isArtificial) {
        return StringsKt.startsWith$default($this$isArtificial.getClassName(), CoroutineDebuggingKt.getARTIFICIAL_FRAME_PACKAGE_NAME(), false, 2, null);
    }

    private static final int firstFrameIndex(StackTraceElement[] $this$firstFrameIndex, String methodName) {
        int n2;
        block1: {
            StackTraceElement[] $this$indexOfFirst$iv = $this$firstFrameIndex;
            boolean $i$f$indexOfFirst = false;
            int n3 = $this$indexOfFirst$iv.length;
            for (int index$iv = 0; index$iv < n3; ++index$iv) {
                StackTraceElement it = $this$indexOfFirst$iv[index$iv];
                boolean bl2 = false;
                if (!Intrinsics.areEqual(methodName, it.getClassName())) continue;
                n2 = index$iv;
                break block1;
            }
            n2 = -1;
        }
        return n2;
    }

    private static final boolean elementWiseEquals(StackTraceElement $this$elementWiseEquals, StackTraceElement e2) {
        return $this$elementWiseEquals.getLineNumber() == e2.getLineNumber() && Intrinsics.areEqual($this$elementWiseEquals.getMethodName(), e2.getMethodName()) && Intrinsics.areEqual($this$elementWiseEquals.getFileName(), e2.getFileName()) && Intrinsics.areEqual($this$elementWiseEquals.getClassName(), e2.getClassName());
    }

    public static final void initCause(@NotNull Throwable $this$initCause, @NotNull Throwable cause) {
        $this$initCause.initCause(cause);
    }

    static {
        Object object;
        Object object2;
        Object object3;
        Object $i$a$-runCatching-StackTraceRecoveryKt$baseContinuationImplClassName$22;
        ARTIFICIAL_FRAME = new ArtificialStackFrames().coroutineBoundary();
        try {
            boolean $i$a$-runCatching-StackTraceRecoveryKt$baseContinuationImplClassName$22 = false;
            $i$a$-runCatching-StackTraceRecoveryKt$baseContinuationImplClassName$22 = Result.constructor-impl(Class.forName(baseContinuationImplClass).getCanonicalName());
        }
        catch (Throwable throwable) {
            $i$a$-runCatching-StackTraceRecoveryKt$baseContinuationImplClassName$22 = Result.constructor-impl(ResultKt.createFailure(throwable));
        }
        Throwable throwable = Result.exceptionOrNull-impl($i$a$-runCatching-StackTraceRecoveryKt$baseContinuationImplClassName$22);
        if (throwable == null) {
            object3 = $i$a$-runCatching-StackTraceRecoveryKt$baseContinuationImplClassName$22;
        } else {
            Throwable it = throwable;
            boolean bl2 = false;
            object3 = baseContinuationImplClass;
        }
        baseContinuationImplClassName = (String)object3;
        try {
            boolean bl3 = false;
            object2 = Result.constructor-impl(Class.forName(stackTraceRecoveryClass).getCanonicalName());
        }
        catch (Throwable it) {
            object2 = Result.constructor-impl(ResultKt.createFailure(it));
        }
        Throwable throwable2 = Result.exceptionOrNull-impl(object2);
        if (throwable2 == null) {
            object = object2;
        } else {
            it = throwable2;
            boolean bl4 = false;
            object = stackTraceRecoveryClass;
        }
        stackTraceRecoveryClassName = (String)object;
    }
}

