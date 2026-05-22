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
import net.darkmeow.irc.lib.io.netty.handler.proxy.HttpProxyHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IRCOptionsProxyHttp
implements IRCOptionsProxy {
    @NotNull
    public String host;
    public int port;

    @Override
    @Nullable
    public ChannelHandler getNettyHandler() {
        return new HttpProxyHandler(new InetSocketAddress(this.host, this.port));
    }

    @Generated
    public IRCOptionsProxyHttp(@NotNull String host, int port) {
        if (host == null) {
            throw new NullPointerException("host is marked non-null but is null");
        }
        this.host = host;
        this.port = port;
    }
}

