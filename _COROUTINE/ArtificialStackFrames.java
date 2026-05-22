/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package _COROUTINE;

import _COROUTINE.CoroutineDebuggingKt;
import _COROUTINE._BOUNDARY;
import _COROUTINE._CREATION;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u0007"}, d2={"L_COROUTINE/ArtificialStackFrames;", "", "<init>", "()V", "coroutineCreation", "Ljava/lang/StackTraceElement;", "coroutineBoundary", "kotlinx-coroutines-core"})
public final class ArtificialStackFrames {
    @NotNull
    public final StackTraceElement coroutineCreation() {
        return CoroutineDebuggingKt.access$artificialFrame(new Exception(), _CREATION.class.getSimpleName());
    }

    @NotNull
    public final StackTraceElement coroutineBoundary() {
        return CoroutineDebuggingKt.access$artificialFrame(new Exception(), _BOUNDARY.class.getSimpleName());
    }
}

