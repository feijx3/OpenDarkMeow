/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.concurrent;

import net.darkmeow.irc.lib.io.netty.util.concurrent.EventExecutor;

public interface EventExecutorChooserFactory {
    public EventExecutorChooser newChooser(EventExecutor[] var1);

    public static interface EventExecutorChooser {
        public EventExecutor next();
    }
}

