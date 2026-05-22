/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.http;

import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpMessage;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpResponseStatus;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpVersion;

public interface HttpResponse
extends HttpMessage {
    @Deprecated
    public HttpResponseStatus getStatus();

    public HttpResponseStatus status();

    public HttpResponse setStatus(HttpResponseStatus var1);

    @Override
    public HttpResponse setProtocolVersion(HttpVersion var1);
}

