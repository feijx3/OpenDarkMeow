/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.resolver;

import java.util.List;
import net.darkmeow.irc.lib.io.netty.resolver.NameResolver;
import net.darkmeow.irc.lib.io.netty.util.concurrent.EventExecutor;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Future;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Promise;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;

public abstract class SimpleNameResolver<T>
implements NameResolver<T> {
    private final EventExecutor executor;

    protected SimpleNameResolver(EventExecutor executor) {
        this.executor = ObjectUtil.checkNotNull(executor, "executor");
    }

    protected EventExecutor executor() {
        return this.executor;
    }

    @Override
    public final Future<T> resolve(String inetHost) {
        Promise promise = this.executor().newPromise();
        return this.resolve(inetHost, promise);
    }

    @Override
    public Future<T> resolve(String inetHost, Promise<T> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        try {
            this.doResolve(inetHost, promise);
            return promise;
        }
        catch (Exception e2) {
            return promise.setFailure(e2);
        }
    }

    @Override
    public final Future<List<T>> resolveAll(String inetHost) {
        Promise<List<T>> promise = this.executor().newPromise();
        return this.resolveAll(inetHost, promise);
    }

    @Override
    public Future<List<T>> resolveAll(String inetHost, Promise<List<T>> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        try {
            this.doResolveAll(inetHost, promise);
            return promise;
        }
        catch (Exception e2) {
            return promise.setFailure(e2);
        }
    }

    protected abstract void doResolve(String var1, Promise<T> var2) throws Exception;

    protected abstract void doResolveAll(String var1, Promise<List<T>> var2) throws Exception;

    @Override
    public void close() {
    }
}

