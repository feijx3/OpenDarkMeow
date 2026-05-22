/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import java.nio.channels.ClosedChannelException;
import net.darkmeow.irc.lib.io.netty.util.internal.ThrowableUtil;

final class StacklessClosedChannelException
extends ClosedChannelException {
    private static final long serialVersionUID = -2214806025529435136L;

    private StacklessClosedChannelException() {
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    static StacklessClosedChannelException newInstance(Class<?> clazz, String method) {
        return ThrowableUtil.unknownStackTrace(new StacklessClosedChannelException(), clazz, method);
    }
}

