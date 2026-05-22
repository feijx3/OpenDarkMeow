/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.PublishedApi
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u00006\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u001a+\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u001a@\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\t*\u0002H\r2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\t0\u000e\u00a2\u0006\u0002\b\u000fH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u0011\u001a\u0002H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u0006H\u0087\b\u00a2\u0006\u0002\u0010\u0012\u001a[\u0010\u0013\u001a\u0002H\t\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\r*\u0002H\t*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\t0\u000eH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0002\u0010\u0010\u001a0\u0010\u0017\u001a\u0002H\t\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\r*\u0002H\t*\b\u0012\u0004\u0012\u0002H\r0\u00062\u0006\u0010\u0018\u001a\u0002H\tH\u0087\b\u00a2\u0006\u0002\u0010\u0019\u001a\u0084\u0001\u0010\u001a\u001a\u0002H\t\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u0011H\r\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\t0\u000e2!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\t0\u000eH\u0087\b\u00f8\u0001\u0000\u0082\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000\u00a2\u0006\u0002\u0010\u001d\u001a]\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u0011H\r\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\t0\u000eH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0002\u0010\u0010\u001aP\u0010 \u001a\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u0011H\r\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\t0\u000eH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001aa\u0010!\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\r*\u0002H\t*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\t0\u000eH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0002\u0010\u0010\u001aT\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\r*\u0002H\t*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\t0\u000eH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001aW\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\r0\u0006\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00050\u000eH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0002\u0010\u0010\u001aW\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\r0\u0006\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00062!\u0010#\u001a\u001d\u0012\u0013\u0012\u0011H\r\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00050\u000eH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006$"}, d2={"createFailure", "", "exception", "", "throwOnFailure", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "runCatching", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrThrow", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "onFailure", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "fold", "onSuccess", "value", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "map", "transform", "mapCatching", "recover", "recoverCatching", "action", "kotlin-stdlib"})
@SourceDebugExtension(value={"SMAP\nResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Result.kt\nkotlin/ResultKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,340:1\n1#2:341\n*E\n"})
public final class ResultKt {
    @PublishedApi
    @SinceKotlin(version="1.3")
    @NotNull
    public static final Object createFailure(@NotNull Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        return new Result.Failure(exception);
    }

    @PublishedApi
    @SinceKotlin(version="1.3")
    public static final void throwOnFailure(@NotNull Object $this$throwOnFailure) {
        if ($this$throwOnFailure instanceof Result.Failure) {
            throw ((Result.Failure)$this$throwOnFailure).exception;
        }
    }

    @InlineOnly
    @SinceKotlin(version="1.3")
    private static final <R> Object runCatching(Function0<? extends R> block) {
        Object object;
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            object = Result.constructor-impl(block.invoke());
        }
        catch (Throwable e2) {
            object = Result.constructor-impl(ResultKt.createFailure(e2));
        }
        return object;
    }

    @InlineOnly
    @SinceKotlin(version="1.3")
    private static final <T, R> Object runCatching(T $this$runCatching, Function1<? super T, ? extends R> block) {
        Object object;
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            object = Result.constructor-impl(block.invoke($this$runCatching));
        }
        catch (Throwable e2) {
            object = Result.constructor-impl(ResultKt.createFailure(e2));
        }
        return object;
    }

    @InlineOnly
    @SinceKotlin(version="1.3")
    private static final <T> T getOrThrow(Object $this$getOrThrow) {
        ResultKt.throwOnFailure($this$getOrThrow);
        return (T)$this$getOrThrow;
    }

    @InlineOnly
    @SinceKotlin(version="1.3")
    private static final <R, T extends R> R getOrElse(Object $this$getOrElse, Function1<? super Throwable, ? extends R> onFailure) {
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Throwable exception = Result.exceptionOrNull-impl($this$getOrElse);
        return (R)(exception == null ? $this$getOrElse : onFailure.invoke(exception));
    }

    @InlineOnly
    @SinceKotlin(version="1.3")
    private static final <R, T extends R> R getOrDefault(Object $this$getOrDefault, R defaultValue) {
        if (Result.isFailure-impl($this$getOrDefault)) {
            return defaultValue;
        }
        return (R)$this$getOrDefault;
    }

    @InlineOnly
    @SinceKotlin(version="1.3")
    private static final <R, T> R fold(Object $this$fold, Function1<? super T, ? extends R> onSuccess, Function1<? super Throwable, ? extends R> onFailure) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Throwable exception = Result.exceptionOrNull-impl($this$fold);
        return exception == null ? onSuccess.invoke($this$fold) : onFailure.invoke(exception);
    }

    @InlineOnly
    @SinceKotlin(version="1.3")
    private static final <R, T> Object map(Object $this$map, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        return Result.isSuccess-impl($this$map) ? Result.constructor-impl(transform.invoke($this$map)) : Result.constructor-impl($this$map);
    }

    @InlineOnly
    @SinceKotlin(version="1.3")
    private static final <R, T> Object mapCatching(Object $this$mapCatching, Function1<? super T, ? extends R> transform) {
        Object object;
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (Result.isSuccess-impl($this$mapCatching)) {
            Object object2;
            Object object3 = $this$mapCatching;
            try {
                Object $this$mapCatching_u24lambda_u240 = object3;
                boolean bl2 = false;
                object2 = Result.constructor-impl(transform.invoke($this$mapCatching_u24lambda_u240));
            }
            catch (Throwable throwable) {
                object2 = Result.constructor-impl(ResultKt.createFailure(throwable));
            }
            object = object2;
        } else {
            object = Result.constructor-impl($this$mapCatching);
        }
        return object;
    }

    @InlineOnly
    @SinceKotlin(version="1.3")
    private static final <R, T extends R> Object recover(Object $this$recover, Function1<? super Throwable, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        Throwable exception = Result.exceptionOrNull-impl($this$recover);
        return exception == null ? $this$recover : Result.constructor-impl(transform.invoke(exception));
    }

    @InlineOnly
    @SinceKotlin(version="1.3")
    private static final <R, T extends R> Object recoverCatching(Object $this$recoverCatching, Function1<? super Throwable, ? extends R> transform) {
        Object object;
        Intrinsics.checkNotNullParameter(transform, "transform");
        Throwable exception = Result.exceptionOrNull-impl($this$recoverCatching);
        if (exception == null) {
            object = $this$recoverCatching;
        } else {
            Object object2;
            Object object3 = $this$recoverCatching;
            try {
                Object $this$recoverCatching_u24lambda_u241 = object3;
                boolean bl2 = false;
                object2 = Result.constructor-impl(transform.invoke(exception));
            }
            catch (Throwable throwable) {
                object2 = Result.constructor-impl(ResultKt.createFailure(throwable));
            }
            object = object2;
        }
        return object;
    }

    @InlineOnly
    @SinceKotlin(version="1.3")
    private static final <T> Object onFailure(Object $this$onFailure, Function1<? super Throwable, Unit> action) {
        block0: {
            Intrinsics.checkNotNullParameter(action, "action");
            Throwable throwable = Result.exceptionOrNull-impl($this$onFailure);
            if (throwable == null) break block0;
            Throwable it = throwable;
            boolean bl2 = false;
            action.invoke(it);
        }
        return $this$onFailure;
    }

    @InlineOnly
    @SinceKotlin(version="1.3")
    private static final <T> Object onSuccess(Object $this$onSuccess, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (Result.isSuccess-impl($this$onSuccess)) {
            action.invoke($this$onSuccess);
        }
        return $this$onSuccess;
    }
}

