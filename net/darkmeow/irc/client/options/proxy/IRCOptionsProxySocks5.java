/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.irc.client.options.proxy;

import java.net.InetSocketAddress;
import lombok.Generated;
import net.darkmeow.irc.client.options.proxy.IRCOptionsProxy;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandler;
import net.darkmeow.irc.lib.io.netty.handler.proxy.Socks5ProxyHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IRCOptionsProxySocks5
implements IRCOptionsProxy {
    @NotNull
    public String host;
    public int port;
    @Nullable
    public String username;
    @Nullable
    public String password;

    @Override
    @Nullable
    public ChannelHandler getNettyHandler() {
        return new Socks5ProxyHandler(new InetSocketAddress(this.host, this.port), this.username, this.password);
    }

    @Generated
    public IRCOptionsProxySocks5(@NotNull String host, int port, @Nullable String username, @Nullable String password) {
        if (host == null) {
            throw new NullPointerException("host is marked non-null but is null");
        }
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }
}

