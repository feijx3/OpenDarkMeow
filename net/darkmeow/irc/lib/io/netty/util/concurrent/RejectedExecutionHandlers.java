/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.concurrent;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import net.darkmeow.irc.lib.io.netty.util.concurrent.RejectedExecutionHandler;
import net.darkmeow.irc.lib.io.netty.util.concurrent.SingleThreadEventExecutor;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;

public final class RejectedExecutionHandlers {
    private static final RejectedExecutionHandler REJECT = new RejectedExecutionHandler(){

        @Override
        public void rejected(Runnable task, SingleThreadEventExecutor executor) {
            throw new RejectedExecutionException();
        }
    };

    private RejectedExecutionHandlers() {
    }

    public static RejectedExecutionHandler reject() {
        return REJECT;
    }

    public static RejectedExecutionHandler backoff(final int retries, long backoffAmount, TimeUnit unit) {
        ObjectUtil.checkPositive(retries, "retries");
        final long backOffNanos = unit.toNanos(backoffAmount);
        return new RejectedExecutionHandler(){

            @Override
            public void rejected(Runnable task, SingleThreadEventExecutor executor) {
                if (!executor.inEventLoop()) {
                    for (int i2 = 0; i2 < retries; ++i2) {
                        executor.wakeup(false);
                        LockSupport.parkNanos(backOffNanos);
                        if (!executor.offerTask(task)) continue;
                        return;
                    }
                }
                throw new RejectedExecutionException();
            }
        };
    }
}

