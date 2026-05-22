/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import net.darkmeow.irc.lib.io.netty.channel.IoEvent;
import net.darkmeow.irc.lib.io.netty.channel.IoRegistration;

public interface IoHandle
extends AutoCloseable {
    public void handle(IoRegistration var1, IoEvent var2);
}

