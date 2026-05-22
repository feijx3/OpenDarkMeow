/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.proxy;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.channel.ChannelPipeline;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4.DefaultSocks4CommandRequest;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4.Socks4ClientDecoder;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4.Socks4ClientEncoder;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4.Socks4CommandResponse;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4.Socks4CommandStatus;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4.Socks4CommandType;
import net.darkmeow.irc.lib.io.netty.handler.proxy.ProxyConnectException;
import net.darkmeow.irc.lib.io.netty.handler.proxy.ProxyHandler;

public final class Socks4ProxyHandler
extends ProxyHandler {
    private static final String PROTOCOL = "socks4";
    private static final String AUTH_USERNAME = "username";
    private final String username;
    private String decoderName;
    private String encoderName;

    public Socks4ProxyHandler(SocketAddress proxyAddress) {
        this(proxyAddress, null);
    }

    public Socks4ProxyHandler(SocketAddress proxyAddress, String username) {
        super(proxyAddress);
        if (username != null && username.isEmpty()) {
            username = null;
        }
        this.username = username;
    }

    @Override
    public String protocol() {
        return PROTOCOL;
    }

    @Override
    public String authScheme() {
        return this.username != null ? AUTH_USERNAME : "none";
    }

    public String username() {
        return this.username;
    }

    @Override
    protected void addCodec(ChannelHandlerContext ctx) throws Exception {
        ChannelPipeline p2 = ctx.pipeline();
        String name = ctx.name();
        Socks4ClientDecoder decoder = new Socks4ClientDecoder();
        p2.addBefore(name, null, decoder);
        this.decoderName = p2.context(decoder).name();
        this.encoderName = this.decoderName + ".encoder";
        p2.addBefore(name, this.encoderName, Socks4ClientEncoder.INSTANCE);
    }

    @Override
    protected void removeEncoder(ChannelHandlerContext ctx) throws Exception {
        ChannelPipeline p2 = ctx.pipeline();
        p2.remove(this.encoderName);
    }

    @Override
    protected void removeDecoder(ChannelHandlerContext ctx) throws Exception {
        ChannelPipeline p2 = ctx.pipeline();
        p2.remove(this.decoderName);
    }

    @Override
    protected Object newInitialMessage(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress raddr = (InetSocketAddress)this.destinationAddress();
        String rhost = raddr.isUnresolved() ? raddr.getHostString() : raddr.getAddress().getHostAddress();
        return new DefaultSocks4CommandRequest(Socks4CommandType.CONNECT, rhost, raddr.getPort(), this.username != null ? this.username : "");
    }

    @Override
    protected boolean handleResponse(ChannelHandlerContext ctx, Object response) throws Exception {
        Socks4CommandResponse res = (Socks4CommandResponse)response;
        Socks4CommandStatus status = res.status();
        if (status == Socks4CommandStatus.SUCCESS) {
            return true;
        }
        throw new ProxyConnectException(this.exceptionMessage("status: " + status));
    }
}

