/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BlockingCoroutine;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ThreadLocalEventLoop;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=5, xi=48, d1={"\u0000\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aQ\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00a2\u0006\u0002\b\t\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2={"runBlocking", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/BuildersKt")
@SourceDebugExtension(value={"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/BuildersKt__BuildersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,112:1\n1#2:113\n*E\n"})
final class BuildersKt__BuildersKt {
    public static final <T> T runBlocking(@NotNull CoroutineContext context, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) throws InterruptedException {
        CoroutineContext newContext;
        EventLoop eventLoop;
        Thread currentThread;
        block3: {
            EventLoop eventLoop2;
            block5: {
                block4: {
                    EventLoop eventLoop3;
                    ContinuationInterceptor contextInterceptor;
                    block2: {
                        currentThread = Thread.currentThread();
                        contextInterceptor = (ContinuationInterceptor)context.get(ContinuationInterceptor.Key);
                        eventLoop = null;
                        newContext = null;
                        if (contextInterceptor != null) break block2;
                        eventLoop = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
                        newContext = CoroutineContextKt.newCoroutineContext(GlobalScope.INSTANCE, context.plus(eventLoop));
                        break block3;
                    }
                    eventLoop2 = contextInterceptor instanceof EventLoop ? (EventLoop)contextInterceptor : null;
                    if (eventLoop2 == null) break block4;
                    EventLoop it = eventLoop3 = eventLoop2;
                    boolean bl2 = false;
                    eventLoop2 = it.shouldBeProcessedFromContext() ? eventLoop3 : null;
                    if (eventLoop2 != null) break block5;
                }
                eventLoop2 = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
            }
            eventLoop = eventLoop2;
            newContext = CoroutineContextKt.newCoroutineContext(GlobalScope.INSTANCE, context);
        }
        BlockingCoroutine coroutine = new BlockingCoroutine(newContext, currentThread, eventLoop);
        coroutine.start(CoroutineStart.DEFAULT, coroutine, block);
        return coroutine.joinBlocking();
    }

    public static /* synthetic */ Object runBlocking$default(CoroutineContext coroutineContext, Function2 function2, int n2, Object object) throws InterruptedException {
        if ((n2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return BuildersKt.runBlocking(coroutineContext, function2);
    }
}

