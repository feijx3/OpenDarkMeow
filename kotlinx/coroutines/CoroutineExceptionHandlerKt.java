/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlinx.coroutines.InternalCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.CoroutineExceptionHandlerImpl_commonKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a%\u0010\t\u001a\u00020\n2\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\fH\u0086\b\u00a8\u0006\r"}, d2={"handleCoroutineException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "handlerException", "originalException", "thrownException", "CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "kotlinx-coroutines-core"})
public final class CoroutineExceptionHandlerKt {
    @InternalCoroutinesApi
    public static final void handleCoroutineException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        Throwable reportException = exception instanceof DispatchException ? ((DispatchException)exception).getCause() : exception;
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler)context.get(CoroutineExceptionHandler.Key);
            if (coroutineExceptionHandler != null) {
                CoroutineExceptionHandler it = coroutineExceptionHandler;
                boolean bl2 = false;
                it.handleException(context, reportException);
                return;
            }
        }
        catch (Throwable t2) {
            CoroutineExceptionHandlerImpl_commonKt.handleUncaughtCoroutineException(context, CoroutineExceptionHandlerKt.handlerException(reportException, t2));
            return;
        }
        CoroutineExceptionHandlerImpl_commonKt.handleUncaughtCoroutineException(context, reportException);
    }

    @NotNull
    public static final Throwable handlerException(@NotNull Throwable originalException, @NotNull Throwable thrownException) {
        RuntimeException runtimeException;
        if (originalException == thrownException) {
            return originalException;
        }
        RuntimeException $this$handlerException_u24lambda_u241 = runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", thrownException);
        boolean bl2 = false;
        ExceptionsKt.addSuppressed($this$handlerException_u24lambda_u241, originalException);
        return runtimeException;
    }

    @NotNull
    public static final CoroutineExceptionHandler CoroutineExceptionHandler(@NotNull Function2<? super CoroutineContext, ? super Throwable, Unit> handler) {
        boolean $i$f$CoroutineExceptionHandler = false;
        CoroutineExceptionHandler.Key key = CoroutineExceptionHandler.Key;
        return new CoroutineExceptionHandler(handler, key){
            final /* synthetic */ Function2<CoroutineContext, Throwable, Unit> $handler;
            {
                this.$handler = $handler;
                super($super_call_param$1);
            }

            public void handleException(CoroutineContext context, Throwable exception) {
                this.$handler.invoke(context, exception);
            }
        };
    }
}

