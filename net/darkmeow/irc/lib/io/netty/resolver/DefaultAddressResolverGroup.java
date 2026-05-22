/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.resolver;

import java.net.InetSocketAddress;
import net.darkmeow.irc.lib.io.netty.resolver.AddressResolver;
import net.darkmeow.irc.lib.io.netty.resolver.AddressResolverGroup;
import net.darkmeow.irc.lib.io.netty.resolver.DefaultNameResolver;
import net.darkmeow.irc.lib.io.netty.util.concurrent.EventExecutor;

public final class DefaultAddressResolverGroup
extends AddressResolverGroup<InetSocketAddress> {
    public static final DefaultAddressResolverGroup INSTANCE = new DefaultAddressResolverGroup();

    private DefaultAddressResolverGroup() {
    }

    @Override
    protected AddressResolver<InetSocketAddress> newResolver(EventExecutor executor) throws Exception {
        return new DefaultNameResolver(executor).asAddressResolver();
    }
}

