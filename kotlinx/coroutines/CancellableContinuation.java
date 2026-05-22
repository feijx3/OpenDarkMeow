/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.ReplaceWith
 *  kotlin.SubclassOptInRequired
 *  kotlinx.coroutines.ExperimentalCoroutinesApi
 *  kotlinx.coroutines.InternalCoroutinesApi
 *  kotlinx.coroutines.InternalForInheritanceCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SubclassOptInRequired;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.InternalForInheritanceCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002J#\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00028\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH'\u00a2\u0006\u0002\u0010\fJz\u0010\b\u001a\u0004\u0018\u00010\t\"\b\b\u0001\u0010\r*\u00028\u00002\u0006\u0010\n\u001a\u0002H\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2M\u0010\u000e\u001aI\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u0011H\r\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000fH'\u00a2\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020\u0010H'J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\tH'J\b\u0010\u001c\u001a\u00020\u0016H'J\u0014\u0010\u001d\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010H&J1\u0010\u001e\u001a\u00020\u00162'\u0010\u001f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00160 j\u0002`!H&J\u0019\u0010\"\u001a\u00020\u0016*\u00020#2\u0006\u0010\n\u001a\u00028\u0000H'\u00a2\u0006\u0002\u0010$J\u0014\u0010%\u001a\u00020\u0016*\u00020#2\u0006\u0010\u0019\u001a\u00020\u0010H'J:\u0010&\u001a\u00020\u00162\u0006\u0010\n\u001a\u00028\u00002#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0016\u0018\u00010 H'\u00a2\u0006\u0002\u0010'Jn\u0010&\u001a\u00020\u0016\"\b\b\u0001\u0010\r*\u00028\u00002\u0006\u0010\n\u001a\u0002H\r2M\u0010\u000e\u001aI\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u0011H\r\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000fH&\u00a2\u0006\u0002\u0010(R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005R\u0012\u0010\u0007\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\u00a8\u0006)"}, d2={"Lkotlinx/coroutines/CancellableContinuation;", "T", "Lkotlin/coroutines/Continuation;", "isActive", "", "()Z", "isCompleted", "isCancelled", "tryResume", "", "value", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "R", "onCancellation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/CoroutineContext;", "context", "", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "tryResumeWithException", "exception", "completeResume", "token", "initCancellability", "cancel", "invokeOnCancellation", "handler", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "kotlinx-coroutines-core"})
@SubclassOptInRequired(markerClass={InternalForInheritanceCoroutinesApi.class})
public interface CancellableContinuation<T>
extends Continuation<T> {
    public boolean isActive();

    public boolean isCompleted();

    public boolean isCancelled();

    @InternalCoroutinesApi
    @Nullable
    public Object tryResume(T var1, @Nullable Object var2);

    @InternalCoroutinesApi
    @Nullable
    public <R extends T> Object tryResume(R var1, @Nullable Object var2, @Nullable Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> var3);

    @InternalCoroutinesApi
    @Nullable
    public Object tryResumeWithException(@NotNull Throwable var1);

    @InternalCoroutinesApi
    public void completeResume(@NotNull Object var1);

    @InternalCoroutinesApi
    public void initCancellability();

    public boolean cancel(@Nullable Throwable var1);

    public void invokeOnCancellation(@NotNull Function1<? super Throwable, Unit> var1);

    @ExperimentalCoroutinesApi
    public void resumeUndispatched(@NotNull CoroutineDispatcher var1, T var2);

    @ExperimentalCoroutinesApi
    public void resumeUndispatchedWithException(@NotNull CoroutineDispatcher var1, @NotNull Throwable var2);

    @Deprecated(message="Use the overload that also accepts the `value` and the coroutine context in lambda", replaceWith=@ReplaceWith(expression="resume(value) { cause, _, _ -> onCancellation(cause) }", imports={}), level=DeprecationLevel.WARNING)
    public void resume(T var1, @Nullable Function1<? super Throwable, Unit> var2);

    public <R extends T> void resume(R var1, @Nullable Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> var2);

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object tryResume$default(CancellableContinuation cancellableContinuation, Object object, Object object2, int n2, Object object3) {
            if (object3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
            }
            if ((n2 & 2) != 0) {
                object2 = null;
            }
            return cancellableContinuation.tryResume(object, object2);
        }

        public static /* synthetic */ boolean cancel$default(CancellableContinuation cancellableContinuation, Throwable throwable, int n2, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((n2 & 1) != 0) {
                throwable = null;
            }
            return cancellableContinuation.cancel(throwable);
        }
    }
}

