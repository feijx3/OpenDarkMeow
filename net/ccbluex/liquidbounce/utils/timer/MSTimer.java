/*
 * Decompiled with CFR 0.152.
 */
package net.ccbluex.liquidbounce.utils.timer;

import kotlin.Metadata;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "", "<init>", "()V", "time", "", "getTime", "()J", "setTime", "(J)V", "hasTimePassed", "", "ms", "", "hasTimeLeft", "timePassed", "reset", "", "DarkMeow"})
public class MSTimer {
    private long time = -1L;

    public final long getTime() {
        return this.time;
    }

    public final void setTime(long l2) {
        this.time = l2;
    }

    public final boolean hasTimePassed(long ms) {
        return System.currentTimeMillis() >= this.time + ms;
    }

    public final boolean hasTimePassed(int ms) {
        return this.hasTimePassed((long)ms);
    }

    public final long hasTimeLeft(long ms) {
        return ms + this.time - System.currentTimeMillis();
    }

    public final long hasTimeLeft(int ms) {
        return this.hasTimeLeft((long)ms);
    }

    public final long timePassed() {
        return System.currentTimeMillis() - this.time;
    }

    public final void reset() {
        this.time = System.currentTimeMillis();
    }
}

