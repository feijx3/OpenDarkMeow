/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.resolver;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import net.darkmeow.irc.lib.io.netty.resolver.AddressResolver;
import net.darkmeow.irc.lib.io.netty.resolver.InetSocketAddressResolver;
import net.darkmeow.irc.lib.io.netty.resolver.SimpleNameResolver;
import net.darkmeow.irc.lib.io.netty.util.concurrent.EventExecutor;

public abstract class InetNameResolver
extends SimpleNameResolver<InetAddress> {
    private volatile AddressResolver<InetSocketAddress> addressResolver;

    protected InetNameResolver(EventExecutor executor) {
        super(executor);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public AddressResolver<InetSocketAddress> asAddressResolver() {
        InetSocketAddressResolver result = this.addressResolver;
        if (result == null) {
            InetNameResolver inetNameResolver = this;
            synchronized (inetNameResolver) {
                result = this.addressResolver;
                if (result == null) {
                    this.addressResolver = result = new InetSocketAddressResolver(this.executor(), this);
                }
            }
        }
        return result;
    }
}

