/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.concurrent;

import java.util.concurrent.TimeUnit;
import net.darkmeow.irc.lib.io.netty.util.concurrent.DefaultMockTicker;
import net.darkmeow.irc.lib.io.netty.util.concurrent.MockTicker;
import net.darkmeow.irc.lib.io.netty.util.concurrent.SystemTicker;

public interface Ticker {
    public static Ticker systemTicker() {
        return SystemTicker.INSTANCE;
    }

    public static MockTicker newMockTicker() {
        return new DefaultMockTicker();
    }

    public long initialNanoTime();

    public long nanoTime();

    public void sleep(long var1, TimeUnit var3) throws InterruptedException;

    default public void sleepMillis(long delayMillis) throws InterruptedException {
        this.sleep(delayMillis, TimeUnit.MILLISECONDS);
    }
}

