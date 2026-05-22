/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.timeout;

import net.darkmeow.irc.lib.io.netty.channel.ChannelException;

public class TimeoutException
extends ChannelException {
    private static final long serialVersionUID = 4673641882869672533L;

    TimeoutException() {
    }

    TimeoutException(String message, boolean shared) {
        super(message, null, shared);
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}

