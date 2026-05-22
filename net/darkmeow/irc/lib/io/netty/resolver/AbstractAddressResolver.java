/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.resolver;

import java.net.SocketAddress;
import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Collections;
import java.util.List;
import net.darkmeow.irc.lib.io.netty.resolver.AddressResolver;
import net.darkmeow.irc.lib.io.netty.util.concurrent.EventExecutor;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Future;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Promise;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.TypeParameterMatcher;

public abstract class AbstractAddressResolver<T extends SocketAddress>
implements AddressResolver<T> {
    private final EventExecutor executor;
    private final TypeParameterMatcher matcher;

    protected AbstractAddressResolver(EventExecutor executor) {
        this.executor = ObjectUtil.checkNotNull(executor, "executor");
        this.matcher = TypeParameterMatcher.find(this, AbstractAddressResolver.class, "T");
    }

    protected AbstractAddressResolver(EventExecutor executor, Class<? extends T> addressType) {
        this.executor = ObjectUtil.checkNotNull(executor, "executor");
        this.matcher = TypeParameterMatcher.get(addressType);
    }

    protected EventExecutor executor() {
        return this.executor;
    }

    @Override
    public boolean isSupported(SocketAddress address) {
        return this.matcher.match(address);
    }

    @Override
    public final boolean isResolved(SocketAddress address) {
        if (!this.isSupported(address)) {
            throw new UnsupportedAddressTypeException();
        }
        SocketAddress castAddress = address;
        return this.doIsResolved(castAddress);
    }

    protected abstract boolean doIsResolved(T var1);

    @Override
    public final Future<T> resolve(SocketAddress address) {
        if (!this.isSupported(ObjectUtil.checkNotNull(address, "address"))) {
            return this.executor().newFailedFuture(new UnsupportedAddressTypeException());
        }
        if (this.isResolved(address)) {
            SocketAddress cast = address;
            return this.executor.newSucceededFuture(cast);
        }
        try {
            SocketAddress cast = address;
            Promise promise = this.executor().newPromise();
            this.doResolve(cast, promise);
            return promise;
        }
        catch (Exception e2) {
            return this.executor().newFailedFuture(e2);
        }
    }

    @Override
    public final Future<T> resolve(SocketAddress address, Promise<T> promise) {
        ObjectUtil.checkNotNull(address, "address");
        ObjectUtil.checkNotNull(promise, "promise");
        if (!this.isSupported(address)) {
            return promise.setFailure(new UnsupportedAddressTypeException());
        }
        if (this.isResolved(address)) {
            SocketAddress cast = address;
            return promise.setSuccess(cast);
        }
        try {
            SocketAddress cast = address;
            this.doResolve(cast, promise);
            return promise;
        }
        catch (Exception e2) {
            return promise.setFailure(e2);
        }
    }

    @Override
    public final Future<List<T>> resolveAll(SocketAddress address) {
        if (!this.isSupported(ObjectUtil.checkNotNull(address, "address"))) {
            return this.executor().newFailedFuture(new UnsupportedAddressTypeException());
        }
        if (this.isResolved(address)) {
            SocketAddress cast = address;
            return this.executor.newSucceededFuture(Collections.singletonList(cast));
        }
        try {
            SocketAddress cast = address;
            Promise<List<T>> promise = this.executor().newPromise();
            this.doResolveAll(cast, promise);
            return promise;
        }
        catch (Exception e2) {
            return this.executor().newFailedFuture(e2);
        }
    }

    @Override
    public final Future<List<T>> resolveAll(SocketAddress address, Promise<List<T>> promise) {
        ObjectUtil.checkNotNull(address, "address");
        ObjectUtil.checkNotNull(promise, "promise");
        if (!this.isSupported(address)) {
            return promise.setFailure(new UnsupportedAddressTypeException());
        }
        if (this.isResolved(address)) {
            SocketAddress cast = address;
            return promise.setSuccess(Collections.singletonList(cast));
        }
        try {
            SocketAddress cast = address;
            this.doResolveAll(cast, promise);
            return promise;
        }
        catch (Exception e2) {
            return promise.setFailure(e2);
        }
    }

    protected abstract void doResolve(T var1, Promise<T> var2) throws Exception;

    protected abstract void doResolveAll(T var1, Promise<List<T>> var2) throws Exception;

    @Override
    public void close() {
    }
}

