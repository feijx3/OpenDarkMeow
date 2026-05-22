/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import net.darkmeow.irc.lib.io.netty.channel.Channel;

public interface ChannelFactory<T extends Channel>
extends net.darkmeow.irc.lib.io.netty.bootstrap.ChannelFactory<T> {
    @Override
    public T newChannel();
}

