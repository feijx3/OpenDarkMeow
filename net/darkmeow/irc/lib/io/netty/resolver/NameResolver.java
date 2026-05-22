/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.resolver;

import java.io.Closeable;
import java.util.List;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Future;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Promise;

public interface NameResolver<T>
extends Closeable {
    public Future<T> resolve(String var1);

    public Future<T> resolve(String var1, Promise<T> var2);

    public Future<List<T>> resolveAll(String var1);

    public Future<List<T>> resolveAll(String var1, Promise<List<T>> var2);

    @Override
    public void close();
}

