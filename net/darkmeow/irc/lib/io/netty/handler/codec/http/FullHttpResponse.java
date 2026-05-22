/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.http;

import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.FullHttpMessage;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpResponse;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpResponseStatus;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpVersion;

public interface FullHttpResponse
extends HttpResponse,
FullHttpMessage {
    @Override
    public FullHttpResponse copy();

    @Override
    public FullHttpResponse duplicate();

    @Override
    public FullHttpResponse retainedDuplicate();

    @Override
    public FullHttpResponse replace(ByteBuf var1);

    @Override
    public FullHttpResponse retain(int var1);

    @Override
    public FullHttpResponse retain();

    @Override
    public FullHttpResponse touch();

    @Override
    public FullHttpResponse touch(Object var1);

    @Override
    public FullHttpResponse setProtocolVersion(HttpVersion var1);

    @Override
    public FullHttpResponse setStatus(HttpResponseStatus var1);
}

