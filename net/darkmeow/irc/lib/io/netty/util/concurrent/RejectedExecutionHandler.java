/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.concurrent;

import net.darkmeow.irc.lib.io.netty.util.concurrent.SingleThreadEventExecutor;

public interface RejectedExecutionHandler {
    public void rejected(Runnable var1, SingleThreadEventExecutor var2);
}

