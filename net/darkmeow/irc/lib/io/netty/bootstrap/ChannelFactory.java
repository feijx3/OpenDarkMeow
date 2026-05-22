/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.bootstrap;

import net.darkmeow.irc.lib.io.netty.channel.Channel;

@Deprecated
public interface ChannelFactory<T extends Channel> {
    public T newChannel();
}

