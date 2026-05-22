/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.http;

import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpHeaders;

public interface HttpHeadersFactory {
    public HttpHeaders newHeaders();

    public HttpHeaders newEmptyHeaders();
}

