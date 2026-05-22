/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.concurrent;

import java.util.concurrent.Executor;

public interface ThreadAwareExecutor
extends Executor {
    public boolean isExecutorThread(Thread var1);
}

