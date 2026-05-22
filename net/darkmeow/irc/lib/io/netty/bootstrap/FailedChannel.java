/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.bootstrap;

import java.net.SocketAddress;
import net.darkmeow.irc.lib.io.netty.channel.AbstractChannel;
import net.darkmeow.irc.lib.io.netty.channel.ChannelConfig;
import net.darkmeow.irc.lib.io.netty.channel.ChannelMetadata;
import net.darkmeow.irc.lib.io.netty.channel.ChannelOutboundBuffer;
import net.darkmeow.irc.lib.io.netty.channel.ChannelPromise;
import net.darkmeow.irc.lib.io.netty.channel.DefaultChannelConfig;
import net.darkmeow.irc.lib.io.netty.channel.EventLoop;

final class FailedChannel
extends AbstractChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private final ChannelConfig config = new DefaultChannelConfig(this);

    FailedChannel() {
        super(null);
    }

    @Override
    protected AbstractChannel.AbstractUnsafe newUnsafe() {
        return new FailedChannelUnsafe();
    }

    @Override
    protected boolean isCompatible(EventLoop loop) {
        return false;
    }

    @Override
    protected SocketAddress localAddress0() {
        return null;
    }

    @Override
    protected SocketAddress remoteAddress0() {
        return null;
    }

    @Override
    protected void doBind(SocketAddress localAddress) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doDisconnect() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doClose() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doBeginRead() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doWrite(ChannelOutboundBuffer in) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChannelConfig config() {
        return this.config;
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public ChannelMetadata metadata() {
        return METADATA;
    }

    private final class FailedChannelUnsafe
    extends AbstractChannel.AbstractUnsafe {
        private FailedChannelUnsafe() {
            super(FailedChannel.this);
        }

        @Override
        public void connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
            promise.setFailure(new UnsupportedOperationException());
        }
    }
}

