/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.timer.delay;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.utils.math.RandomUtils;
import net.ccbluex.liquidbounce.value.impl.IntegerRangeValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0005R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "", "<init>", "()V", "launcherMS", "", "delayMS", "reset", "", "delay", "", "minDelay", "maxDelay", "value", "Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "hasPassed", "", "currentMS", "DarkMeow"})
public final class MSDelay {
    @JvmField
    public long launcherMS;
    @JvmField
    public long delayMS;

    public final void reset(long delay) {
        this.launcherMS = System.currentTimeMillis();
        this.delayMS = delay;
    }

    public final void reset(int delay) {
        this.reset((long)delay);
    }

    public final void reset(long minDelay, long maxDelay) {
        this.reset(RandomUtils.INSTANCE.random(minDelay, maxDelay));
    }

    public final void reset(int minDelay, int maxDelay) {
        this.reset(RandomUtils.INSTANCE.random(minDelay, maxDelay));
    }

    public final void reset(@NotNull IntegerRangeValue value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.reset(value.random());
    }

    public final void reset(@NotNull IntegerValue value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.reset(((Number)value.get()).intValue());
    }

    public final boolean hasPassed(long currentMS) {
        return currentMS >= this.launcherMS + this.delayMS;
    }

    public static /* synthetic */ boolean hasPassed$default(MSDelay mSDelay, long l2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = System.currentTimeMillis();
        }
        return mSDelay.hasPassed(l2);
    }
}

