/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.http;

import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.FullHttpMessage;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpMethod;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpRequest;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpVersion;

public interface FullHttpRequest
extends HttpRequest,
FullHttpMessage {
    @Override
    public FullHttpRequest copy();

    @Override
    public FullHttpRequest duplicate();

    @Override
    public FullHttpRequest retainedDuplicate();

    @Override
    public FullHttpRequest replace(ByteBuf var1);

    @Override
    public FullHttpRequest retain(int var1);

    @Override
    public FullHttpRequest retain();

    @Override
    public FullHttpRequest touch();

    @Override
    public FullHttpRequest touch(Object var1);

    @Override
    public FullHttpRequest setProtocolVersion(HttpVersion var1);

    @Override
    public FullHttpRequest setMethod(HttpMethod var1);

    @Override
    public FullHttpRequest setUri(String var1);
}

