/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.PublishedApi
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  kotlin.jvm.JvmName
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.jdk7;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\u001a \u0010\u0000\u001a\u00060\u0001j\u0002`\u00052\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0087\b\u00f8\u0001\u0000\u001aN\u0010\t\u001a\u0002H\n\"\u0010\b\u0000\u0010\u000b*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0005\"\u0004\b\u0001\u0010\n*\u0002H\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\n0\rH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0002\u0010\u000e\u001a\u001e\u0010\u000f\u001a\u00020\b*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001*\u001a\b\u0007\u0010\u0000\"\u00020\u00012\u00020\u0001B\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0012"}, d2={"AutoCloseable", "Ljava/lang/AutoCloseable;", "Lkotlin/SinceKotlin;", "version", "2.0", "Lkotlin/AutoCloseable;", "closeAction", "Lkotlin/Function0;", "", "use", "R", "T", "block", "Lkotlin/Function1;", "(Ljava/lang/AutoCloseable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "closeFinally", "cause", "", "kotlin-stdlib"}, pn="kotlin")
@JvmName(name="AutoCloseableKt")
public final class AutoCloseableKt {
    @SinceKotlin(version="2.0")
    @InlineOnly
    private static final AutoCloseable AutoCloseable(Function0<Unit> closeAction) {
        Intrinsics.checkNotNullParameter(closeAction, "closeAction");
        return new AutoCloseable(closeAction){
            final /* synthetic */ Function0<Unit> $closeAction;
            {
                this.$closeAction = $closeAction;
            }

            public final void close() {
                this.$closeAction.invoke();
            }
        };
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @SinceKotlin(version="1.2")
    @InlineOnly
    private static final <T extends AutoCloseable, R> R use(T $this$use, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Throwable exception = null;
        try {
            R r2 = block.invoke($this$use);
            return r2;
        }
        catch (Throwable e2) {
            exception = e2;
            throw e2;
        }
        finally {
            InlineMarker.finallyStart(1);
            AutoCloseableKt.closeFinally($this$use, exception);
            InlineMarker.finallyEnd(1);
        }
    }

    @SinceKotlin(version="1.2")
    @PublishedApi
    public static final void closeFinally(@Nullable AutoCloseable $this$closeFinally, @Nullable Throwable cause) {
        if ($this$closeFinally != null) {
            if (cause == null) {
                $this$closeFinally.close();
            } else {
                try {
                    $this$closeFinally.close();
                }
                catch (Throwable closeException) {
                    ExceptionsKt.addSuppressed(cause, closeException);
                }
            }
        }
    }

    @SinceKotlin(version="2.0")
    public static /* synthetic */ void AutoCloseable$annotations() {
    }
}

