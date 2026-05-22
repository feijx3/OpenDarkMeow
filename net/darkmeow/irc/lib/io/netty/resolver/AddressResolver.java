/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.resolver;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.List;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Future;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Promise;

public interface AddressResolver<T extends SocketAddress>
extends Closeable {
    public boolean isSupported(SocketAddress var1);

    public boolean isResolved(SocketAddress var1);

    public Future<T> resolve(SocketAddress var1);

    public Future<T> resolve(SocketAddress var1, Promise<T> var2);

    public Future<List<T>> resolveAll(SocketAddress var1);

    public Future<List<T>> resolveAll(SocketAddress var1, Promise<List<T>> var2);

    @Override
    public void close();
}

