/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel.socket;

import net.darkmeow.irc.lib.io.netty.channel.Channel;
import net.darkmeow.irc.lib.io.netty.channel.ChannelFuture;
import net.darkmeow.irc.lib.io.netty.channel.ChannelPromise;

public interface DuplexChannel
extends Channel {
    public boolean isInputShutdown();

    public ChannelFuture shutdownInput();

    public ChannelFuture shutdownInput(ChannelPromise var1);

    public boolean isOutputShutdown();

    public ChannelFuture shutdownOutput();

    public ChannelFuture shutdownOutput(ChannelPromise var1);

    public boolean isShutdown();

    public ChannelFuture shutdown();

    public ChannelFuture shutdown(ChannelPromise var1);
}

