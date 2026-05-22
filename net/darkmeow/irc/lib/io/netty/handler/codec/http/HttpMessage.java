/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.http;

import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpHeaders;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpObject;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpVersion;

public interface HttpMessage
extends HttpObject {
    @Deprecated
    public HttpVersion getProtocolVersion();

    public HttpVersion protocolVersion();

    public HttpMessage setProtocolVersion(HttpVersion var1);

    public HttpHeaders headers();
}

