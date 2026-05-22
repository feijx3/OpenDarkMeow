/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.resolver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import net.darkmeow.irc.lib.io.netty.resolver.InetNameResolver;
import net.darkmeow.irc.lib.io.netty.util.concurrent.EventExecutor;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Promise;
import net.darkmeow.irc.lib.io.netty.util.internal.SocketUtils;

public class DefaultNameResolver
extends InetNameResolver {
    public DefaultNameResolver(EventExecutor executor) {
        super(executor);
    }

    @Override
    protected void doResolve(String inetHost, Promise<InetAddress> promise) throws Exception {
        try {
            promise.setSuccess(SocketUtils.addressByName(inetHost));
        }
        catch (UnknownHostException e2) {
            promise.setFailure(e2);
        }
    }

    @Override
    protected void doResolveAll(String inetHost, Promise<List<InetAddress>> promise) throws Exception {
        try {
            promise.setSuccess(Arrays.asList(SocketUtils.allAddressesByName(inetHost)));
        }
        catch (UnknownHostException e2) {
            promise.setFailure(e2);
        }
    }
}

