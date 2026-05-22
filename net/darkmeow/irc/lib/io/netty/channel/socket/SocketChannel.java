/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel.socket;

import java.net.InetSocketAddress;
import net.darkmeow.irc.lib.io.netty.channel.socket.DuplexChannel;
import net.darkmeow.irc.lib.io.netty.channel.socket.ServerSocketChannel;
import net.darkmeow.irc.lib.io.netty.channel.socket.SocketChannelConfig;

public interface SocketChannel
extends DuplexChannel {
    @Override
    public ServerSocketChannel parent();

    @Override
    public SocketChannelConfig config();

    @Override
    public InetSocketAddress localAddress();

    @Override
    public InetSocketAddress remoteAddress();
}

