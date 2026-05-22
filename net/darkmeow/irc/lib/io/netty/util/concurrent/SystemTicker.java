/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.concurrent;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Ticker;

final class SystemTicker
implements Ticker {
    static final SystemTicker INSTANCE = new SystemTicker();
    private static final long START_TIME = System.nanoTime();

    SystemTicker() {
    }

    @Override
    public long initialNanoTime() {
        return START_TIME;
    }

    @Override
    public long nanoTime() {
        return System.nanoTime() - START_TIME;
    }

    @Override
    public void sleep(long delay, TimeUnit unit) throws InterruptedException {
        Objects.requireNonNull(unit, "unit");
        unit.sleep(delay);
    }
}

