/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.concurrent;

import java.util.concurrent.TimeUnit;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Ticker;

public interface MockTicker
extends Ticker {
    @Override
    default public long initialNanoTime() {
        return 0L;
    }

    public void advance(long var1, TimeUnit var3);

    default public void advanceMillis(long amountMillis) {
        this.advance(amountMillis, TimeUnit.MILLISECONDS);
    }
}

