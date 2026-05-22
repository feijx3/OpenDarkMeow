/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.resolver;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.IdentityHashMap;
import java.util.Map;
import net.darkmeow.irc.lib.io.netty.resolver.AddressResolver;
import net.darkmeow.irc.lib.io.netty.util.concurrent.EventExecutor;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Future;
import net.darkmeow.irc.lib.io.netty.util.concurrent.FutureListener;
import net.darkmeow.irc.lib.io.netty.util.concurrent.GenericFutureListener;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLogger;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLoggerFactory;

public abstract class AddressResolverGroup<T extends SocketAddress>
implements Closeable {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AddressResolverGroup.class);
    private final Map<EventExecutor, AddressResolver<T>> resolvers = new IdentityHashMap<EventExecutor, AddressResolver<T>>();
    private final Map<EventExecutor, GenericFutureListener<Future<Object>>> executorTerminationListeners = new IdentityHashMap<EventExecutor, GenericFutureListener<Future<Object>>>();

    protected AddressResolverGroup() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public AddressResolver<T> getResolver(final EventExecutor executor) {
        AddressResolver<T> r2;
        ObjectUtil.checkNotNull(executor, "executor");
        if (executor.isShuttingDown()) {
            throw new IllegalStateException("executor not accepting a task");
        }
        Map<EventExecutor, AddressResolver<T>> map = this.resolvers;
        synchronized (map) {
            r2 = this.resolvers.get(executor);
            if (r2 == null) {
                AddressResolver<T> newResolver;
                try {
                    newResolver = this.newResolver(executor);
                }
                catch (Exception e2) {
                    throw new IllegalStateException("failed to create a new resolver", e2);
                }
                this.resolvers.put(executor, newResolver);
                FutureListener<Object> terminationListener = new FutureListener<Object>(){

                    /*
                     * WARNING - Removed try catching itself - possible behaviour change.
                     */
                    @Override
                    public void operationComplete(Future<Object> future) {
                        Map map = AddressResolverGroup.this.resolvers;
                        synchronized (map) {
                            AddressResolverGroup.this.resolvers.remove(executor);
                            AddressResolverGroup.this.executorTerminationListeners.remove(executor);
                        }
                        newResolver.close();
                    }
                };
                this.executorTerminationListeners.put(executor, (GenericFutureListener<Future<Object>>)terminationListener);
                executor.terminationFuture().addListener(terminationListener);
                r2 = newResolver;
            }
        }
        return r2;
    }

    protected abstract AddressResolver<T> newResolver(EventExecutor var1) throws Exception;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        Object[] objectArray = this.resolvers;
        synchronized (this.resolvers) {
            AddressResolver[] rArray = this.resolvers.values().toArray(new AddressResolver[0]);
            this.resolvers.clear();
            Map.Entry[] listeners = this.executorTerminationListeners.entrySet().toArray(new Map.Entry[0]);
            this.executorTerminationListeners.clear();
            // ** MonitorExit[var3_1] (shouldn't be in output)
            for (Map.Entry entry : listeners) {
                ((EventExecutor)entry.getKey()).terminationFuture().removeListener((GenericFutureListener)entry.getValue());
            }
            for (AddressResolver r2 : rArray) {
                try {
                    r2.close();
                }
                catch (Throwable t2) {
                    logger.warn("Failed to close a resolver:", t2);
                }
            }
            return;
        }
    }
}

