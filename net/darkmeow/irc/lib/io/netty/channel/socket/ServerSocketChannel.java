/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel.socket;

import java.net.InetSocketAddress;
import net.darkmeow.irc.lib.io.netty.channel.ServerChannel;
import net.darkmeow.irc.lib.io.netty.channel.socket.ServerSocketChannelConfig;

public interface ServerSocketChannel
extends ServerChannel {
    @Override
    public ServerSocketChannelConfig config();

    @Override
    public InetSocketAddress localAddress();

    @Override
    public InetSocketAddress remoteAddress();
}

