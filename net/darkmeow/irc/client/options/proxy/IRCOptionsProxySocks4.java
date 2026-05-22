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
import net.darkmeow.irc.lib.io.netty.handler.proxy.Socks4ProxyHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IRCOptionsProxySocks4
implements IRCOptionsProxy {
    @NotNull
    public String host;
    public int port;
    @Nullable
    public String username;

    @Override
    @Nullable
    public ChannelHandler getNettyHandler() {
        return new Socks4ProxyHandler(new InetSocketAddress(this.host, this.port), this.username);
    }

    @Generated
    public IRCOptionsProxySocks4(@NotNull String host, int port, @Nullable String username) {
        if (host == null) {
            throw new NullPointerException("host is marked non-null but is null");
        }
        this.host = host;
        this.port = port;
        this.username = username;
    }
}

