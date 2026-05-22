/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Timer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.injection.extend;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.utils.AccessorTimer;
import net.ccbluex.liquidbounce.injection.implementations.IMixinTimer;
import net.minecraft.util.Timer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0006\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u00020\f*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b\u00a8\u0006\u0015"}, d2={"Lnet/ccbluex/liquidbounce/injection/extend/ExtendTimer;", "", "<init>", "()V", "value", "", "tickLength", "Lnet/minecraft/util/Timer;", "getTickLength", "(Lnet/minecraft/util/Timer;)F", "setTickLength", "(Lnet/minecraft/util/Timer;F)V", "", "lastSyncSysClock", "getLastSyncSysClock", "(Lnet/minecraft/util/Timer;)J", "setLastSyncSysClock", "(Lnet/minecraft/util/Timer;J)V", "timerSpeed", "getTimerSpeed", "setTimerSpeed", "DarkMeow"})
public final class ExtendTimer {
    @NotNull
    public static final ExtendTimer INSTANCE = new ExtendTimer();

    private ExtendTimer() {
    }

    public final float getTickLength(@NotNull Timer $this$tickLength) {
        Intrinsics.checkNotNullParameter($this$tickLength, "<this>");
        return ((AccessorTimer)$this$tickLength).getTickLength();
    }

    public final void setTickLength(@NotNull Timer $this$tickLength, float value) {
        Intrinsics.checkNotNullParameter($this$tickLength, "<this>");
        ((AccessorTimer)$this$tickLength).setTickLength(value);
    }

    public final long getLastSyncSysClock(@NotNull Timer $this$lastSyncSysClock) {
        Intrinsics.checkNotNullParameter($this$lastSyncSysClock, "<this>");
        return ((AccessorTimer)$this$lastSyncSysClock).getLastSyncSysClock();
    }

    public final void setLastSyncSysClock(@NotNull Timer $this$lastSyncSysClock, long value) {
        Intrinsics.checkNotNullParameter($this$lastSyncSysClock, "<this>");
        ((AccessorTimer)$this$lastSyncSysClock).setLastSyncSysClock(value);
    }

    public final float getTimerSpeed(@NotNull Timer $this$timerSpeed) {
        Intrinsics.checkNotNullParameter($this$timerSpeed, "<this>");
        return ((IMixinTimer)$this$timerSpeed).darkMeow_getTimerSpeed();
    }

    public final void setTimerSpeed(@NotNull Timer $this$timerSpeed, float value) {
        Intrinsics.checkNotNullParameter($this$timerSpeed, "<this>");
        ((IMixinTimer)$this$timerSpeed).darkMeow_setTimerSpeed(value);
    }
}

