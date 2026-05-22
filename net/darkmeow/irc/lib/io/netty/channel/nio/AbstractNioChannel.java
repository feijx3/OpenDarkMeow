/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel.nio;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.concurrent.TimeUnit;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufAllocator;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufUtil;
import net.darkmeow.irc.lib.io.netty.buffer.Unpooled;
import net.darkmeow.irc.lib.io.netty.channel.AbstractChannel;
import net.darkmeow.irc.lib.io.netty.channel.Channel;
import net.darkmeow.irc.lib.io.netty.channel.ChannelException;
import net.darkmeow.irc.lib.io.netty.channel.ChannelFuture;
import net.darkmeow.irc.lib.io.netty.channel.ChannelFutureListener;
import net.darkmeow.irc.lib.io.netty.channel.ChannelPromise;
import net.darkmeow.irc.lib.io.netty.channel.ConnectTimeoutException;
import net.darkmeow.irc.lib.io.netty.channel.EventLoop;
import net.darkmeow.irc.lib.io.netty.channel.IoEvent;
import net.darkmeow.irc.lib.io.netty.channel.IoEventLoop;
import net.darkmeow.irc.lib.io.netty.channel.IoEventLoopGroup;
import net.darkmeow.irc.lib.io.netty.channel.IoRegistration;
import net.darkmeow.irc.lib.io.netty.channel.nio.NioIoEvent;
import net.darkmeow.irc.lib.io.netty.channel.nio.NioIoHandle;
import net.darkmeow.irc.lib.io.netty.channel.nio.NioIoOps;
import net.darkmeow.irc.lib.io.netty.util.ReferenceCountUtil;
import net.darkmeow.irc.lib.io.netty.util.ReferenceCounted;
import net.darkmeow.irc.lib.io.netty.util.concurrent.Future;
import net.darkmeow.irc.lib.io.netty.util.concurrent.GenericFutureListener;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLogger;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLoggerFactory;

public abstract class AbstractNioChannel
extends AbstractChannel {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractNioChannel.class);
    private final SelectableChannel ch;
    protected final int readInterestOp;
    protected final NioIoOps readOps;
    volatile IoRegistration registration;
    boolean readPending;
    private final Runnable clearReadPendingRunnable = new Runnable(){

        @Override
        public void run() {
            AbstractNioChannel.this.clearReadPending0();
        }
    };
    private ChannelPromise connectPromise;
    private Future<?> connectTimeoutFuture;
    private SocketAddress requestedRemoteAddress;

    protected AbstractNioChannel(Channel parent, SelectableChannel ch2, int readOps) {
        this(parent, ch2, NioIoOps.valueOf(readOps));
    }

    protected AbstractNioChannel(Channel parent, SelectableChannel ch2, NioIoOps readOps) {
        super(parent);
        this.ch = ch2;
        this.readInterestOp = ObjectUtil.checkNotNull(readOps, (String)"readOps").value;
        this.readOps = readOps;
        try {
            ch2.configureBlocking(false);
        }
        catch (IOException e2) {
            try {
                ch2.close();
            }
            catch (IOException e22) {
                logger.warn("Failed to close a partially initialized socket.", e22);
            }
            throw new ChannelException("Failed to enter non-blocking mode.", e2);
        }
    }

    protected void addAndSubmit(NioIoOps addOps) {
        int interestOps = this.selectionKey().interestOps();
        if (!addOps.isIncludedIn(interestOps)) {
            try {
                this.registration().submit(NioIoOps.valueOf(interestOps).with(addOps));
            }
            catch (Exception e2) {
                throw new ChannelException(e2);
            }
        }
    }

    protected void removeAndSubmit(NioIoOps removeOps) {
        int interestOps = this.selectionKey().interestOps();
        if (removeOps.isIncludedIn(interestOps)) {
            try {
                this.registration().submit(NioIoOps.valueOf(interestOps).without(removeOps));
            }
            catch (Exception e2) {
                throw new ChannelException(e2);
            }
        }
    }

    @Override
    public boolean isOpen() {
        return this.ch.isOpen();
    }

    @Override
    public NioUnsafe unsafe() {
        return (NioUnsafe)super.unsafe();
    }

    protected SelectableChannel javaChannel() {
        return this.ch;
    }

    @Deprecated
    protected SelectionKey selectionKey() {
        return (SelectionKey)this.registration().attachment();
    }

    protected IoRegistration registration() {
        assert (this.registration != null);
        return this.registration;
    }

    @Deprecated
    protected boolean isReadPending() {
        return this.readPending;
    }

    @Deprecated
    protected void setReadPending(final boolean readPending) {
        if (this.isRegistered()) {
            EventLoop eventLoop = this.eventLoop();
            if (eventLoop.inEventLoop()) {
                this.setReadPending0(readPending);
            } else {
                eventLoop.execute(new Runnable(){

                    @Override
                    public void run() {
                        AbstractNioChannel.this.setReadPending0(readPending);
                    }
                });
            }
        } else {
            this.readPending = readPending;
        }
    }

    protected final void clearReadPending() {
        if (this.isRegistered()) {
            EventLoop eventLoop = this.eventLoop();
            if (eventLoop.inEventLoop()) {
                this.clearReadPending0();
            } else {
                eventLoop.execute(this.clearReadPendingRunnable);
            }
        } else {
            this.readPending = false;
        }
    }

    private void setReadPending0(boolean readPending) {
        this.readPending = readPending;
        if (!readPending) {
            ((AbstractNioUnsafe)this.unsafe()).removeReadOp();
        }
    }

    private void clearReadPending0() {
        this.readPending = false;
        ((AbstractNioUnsafe)this.unsafe()).removeReadOp();
    }

    @Override
    protected boolean isCompatible(EventLoop loop) {
        return loop instanceof IoEventLoop && ((IoEventLoopGroup)((Object)loop)).isCompatible(AbstractNioUnsafe.class);
    }

    @Override
    protected void doRegister(ChannelPromise promise) {
        assert (this.registration == null);
        ((IoEventLoop)this.eventLoop()).register((AbstractNioUnsafe)this.unsafe()).addListener(f2 -> {
            if (f2.isSuccess()) {
                this.registration = (IoRegistration)f2.getNow();
                promise.setSuccess();
            } else {
                promise.setFailure(f2.cause());
            }
        });
    }

    @Override
    protected void doDeregister() throws Exception {
        IoRegistration registration = this.registration;
        if (registration != null) {
            this.registration = null;
            registration.cancel();
        }
    }

    @Override
    protected void doBeginRead() throws Exception {
        IoRegistration registration = this.registration;
        if (registration == null || !registration.isValid()) {
            return;
        }
        this.readPending = true;
        this.addAndSubmit(this.readOps);
    }

    protected abstract boolean doConnect(SocketAddress var1, SocketAddress var2) throws Exception;

    protected abstract void doFinishConnect() throws Exception;

    protected final ByteBuf newDirectBuffer(ByteBuf buf) {
        int readableBytes = buf.readableBytes();
        if (readableBytes == 0) {
            ReferenceCountUtil.safeRelease(buf);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator alloc = this.alloc();
        if (alloc.isDirectBufferPooled()) {
            ByteBuf directBuf = alloc.directBuffer(readableBytes);
            directBuf.writeBytes(buf, buf.readerIndex(), readableBytes);
            ReferenceCountUtil.safeRelease(buf);
            return directBuf;
        }
        ByteBuf directBuf = ByteBufUtil.threadLocalDirectBuffer();
        if (directBuf != null) {
            directBuf.writeBytes(buf, buf.readerIndex(), readableBytes);
            ReferenceCountUtil.safeRelease(buf);
            return directBuf;
        }
        return buf;
    }

    protected final ByteBuf newDirectBuffer(ReferenceCounted holder, ByteBuf buf) {
        int readableBytes = buf.readableBytes();
        if (readableBytes == 0) {
            ReferenceCountUtil.safeRelease(holder);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator alloc = this.alloc();
        if (alloc.isDirectBufferPooled()) {
            ByteBuf directBuf = alloc.directBuffer(readableBytes);
            directBuf.writeBytes(buf, buf.readerIndex(), readableBytes);
            ReferenceCountUtil.safeRelease(holder);
            return directBuf;
        }
        ByteBuf directBuf = ByteBufUtil.threadLocalDirectBuffer();
        if (directBuf != null) {
            directBuf.writeBytes(buf, buf.readerIndex(), readableBytes);
            ReferenceCountUtil.safeRelease(holder);
            return directBuf;
        }
        if (holder != buf) {
            buf.retain();
            ReferenceCountUtil.safeRelease(holder);
        }
        return buf;
    }

    @Override
    protected void doClose() throws Exception {
        Future<?> future;
        ChannelPromise promise = this.connectPromise;
        if (promise != null) {
            promise.tryFailure(new ClosedChannelException());
            this.connectPromise = null;
        }
        if ((future = this.connectTimeoutFuture) != null) {
            future.cancel(false);
            this.connectTimeoutFuture = null;
        }
    }

    protected abstract class AbstractNioUnsafe
    extends AbstractChannel.AbstractUnsafe
    implements NioUnsafe,
    NioIoHandle {
        protected AbstractNioUnsafe() {
        }

        @Override
        public void close() {
            this.close(this.voidPromise());
        }

        @Override
        public SelectableChannel selectableChannel() {
            return this.ch();
        }

        Channel channel() {
            return AbstractNioChannel.this;
        }

        protected final void removeReadOp() {
            IoRegistration registration = AbstractNioChannel.this.registration();
            if (!registration.isValid()) {
                return;
            }
            AbstractNioChannel.this.removeAndSubmit(AbstractNioChannel.this.readOps);
        }

        @Override
        public final SelectableChannel ch() {
            return AbstractNioChannel.this.javaChannel();
        }

        @Override
        public final void connect(final SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
            if (promise.isDone() || !this.ensureOpen(promise)) {
                return;
            }
            try {
                if (AbstractNioChannel.this.connectPromise != null) {
                    throw new ConnectionPendingException();
                }
                boolean wasActive = AbstractNioChannel.this.isActive();
                if (AbstractNioChannel.this.doConnect(remoteAddress, localAddress)) {
                    this.fulfillConnectPromise(promise, wasActive);
                } else {
                    AbstractNioChannel.this.connectPromise = promise;
                    AbstractNioChannel.this.requestedRemoteAddress = remoteAddress;
                    final int connectTimeoutMillis = AbstractNioChannel.this.config().getConnectTimeoutMillis();
                    if (connectTimeoutMillis > 0) {
                        AbstractNioChannel.this.connectTimeoutFuture = (Future)((Object)AbstractNioChannel.this.eventLoop().schedule(new Runnable(){

                            @Override
                            public void run() {
                                ChannelPromise connectPromise = AbstractNioChannel.this.connectPromise;
                                if (connectPromise != null && !connectPromise.isDone() && connectPromise.tryFailure(new ConnectTimeoutException("connection timed out after " + connectTimeoutMillis + " ms: " + remoteAddress))) {
                                    AbstractNioUnsafe.this.close(AbstractNioUnsafe.this.voidPromise());
                                }
                            }
                        }, (long)connectTimeoutMillis, TimeUnit.MILLISECONDS));
                    }
                    promise.addListener((GenericFutureListener)new ChannelFutureListener(){

                        @Override
                        public void operationComplete(ChannelFuture future) {
                            if (future.isCancelled()) {
                                if (AbstractNioChannel.this.connectTimeoutFuture != null) {
                                    AbstractNioChannel.this.connectTimeoutFuture.cancel(false);
                                }
                                AbstractNioChannel.this.connectPromise = null;
                                AbstractNioUnsafe.this.close(AbstractNioUnsafe.this.voidPromise());
                            }
                        }
                    });
                }
            }
            catch (Throwable t2) {
                promise.tryFailure(this.annotateConnectException(t2, remoteAddress));
                this.closeIfClosed();
            }
        }

        private void fulfillConnectPromise(ChannelPromise promise, boolean wasActive) {
            if (promise == null) {
                return;
            }
            boolean active = AbstractNioChannel.this.isActive();
            boolean promiseSet = promise.trySuccess();
            if (!wasActive && active) {
                AbstractNioChannel.this.pipeline().fireChannelActive();
            }
            if (!promiseSet) {
                this.close(this.voidPromise());
            }
        }

        private void fulfillConnectPromise(ChannelPromise promise, Throwable cause) {
            if (promise == null) {
                return;
            }
            promise.tryFailure(cause);
            this.closeIfClosed();
        }

        @Override
        public final void finishConnect() {
            assert (AbstractNioChannel.this.eventLoop().inEventLoop());
            try {
                boolean wasActive = AbstractNioChannel.this.isActive();
                AbstractNioChannel.this.doFinishConnect();
                this.fulfillConnectPromise(AbstractNioChannel.this.connectPromise, wasActive);
            }
            catch (Throwable t2) {
                this.fulfillConnectPromise(AbstractNioChannel.this.connectPromise, this.annotateConnectException(t2, AbstractNioChannel.this.requestedRemoteAddress));
            }
            finally {
                if (AbstractNioChannel.this.connectTimeoutFuture != null) {
                    AbstractNioChannel.this.connectTimeoutFuture.cancel(false);
                }
                AbstractNioChannel.this.connectPromise = null;
            }
        }

        @Override
        protected final void flush0() {
            if (!this.isFlushPending()) {
                super.flush0();
            }
        }

        @Override
        public final void forceFlush() {
            super.flush0();
        }

        private boolean isFlushPending() {
            IoRegistration registration = AbstractNioChannel.this.registration();
            return registration.isValid() && NioIoOps.WRITE.isIncludedIn(((SelectionKey)registration.attachment()).interestOps());
        }

        @Override
        public void handle(IoRegistration registration, IoEvent event) {
            try {
                NioIoEvent nioEvent = (NioIoEvent)event;
                NioIoOps nioReadyOps = nioEvent.ops();
                if (nioReadyOps.contains(NioIoOps.CONNECT)) {
                    AbstractNioChannel.this.removeAndSubmit(NioIoOps.CONNECT);
                    AbstractNioChannel.this.unsafe().finishConnect();
                }
                if (nioReadyOps.contains(NioIoOps.WRITE)) {
                    this.forceFlush();
                }
                if (nioReadyOps.contains(NioIoOps.READ_AND_ACCEPT) || nioReadyOps.equals(NioIoOps.NONE)) {
                    this.read();
                }
            }
            catch (CancelledKeyException ignored) {
                this.close(this.voidPromise());
            }
        }
    }

    public static interface NioUnsafe
    extends Channel.Unsafe {
        public SelectableChannel ch();

        public void finishConnect();

        public void read();

        public void forceFlush();
    }
}

