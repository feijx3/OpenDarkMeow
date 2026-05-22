/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

public interface IoHandlerContext {
    public boolean canBlock();

    public long delayNanos(long var1);

    public long deadlineNanos();
}

