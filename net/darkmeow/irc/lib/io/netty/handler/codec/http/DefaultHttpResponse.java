/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.http;

import net.darkmeow.irc.lib.io.netty.handler.codec.http.DefaultHttpHeadersFactory;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.DefaultHttpMessage;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpHeaders;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpHeadersFactory;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpMessageUtil;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpResponse;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpResponseStatus;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpVersion;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;

public class DefaultHttpResponse
extends DefaultHttpMessage
implements HttpResponse {
    private HttpResponseStatus status;

    public DefaultHttpResponse(HttpVersion version, HttpResponseStatus status) {
        this(version, status, DefaultHttpHeadersFactory.headersFactory());
    }

    @Deprecated
    public DefaultHttpResponse(HttpVersion version, HttpResponseStatus status, boolean validateHeaders) {
        this(version, status, DefaultHttpHeadersFactory.headersFactory().withValidation(validateHeaders));
    }

    @Deprecated
    public DefaultHttpResponse(HttpVersion version, HttpResponseStatus status, boolean validateHeaders, boolean singleFieldHeaders) {
        this(version, status, DefaultHttpHeadersFactory.headersFactory().withValidation(validateHeaders).withCombiningHeaders(singleFieldHeaders));
    }

    public DefaultHttpResponse(HttpVersion version, HttpResponseStatus status, HttpHeadersFactory headersFactory) {
        this(version, status, headersFactory.newHeaders());
    }

    public DefaultHttpResponse(HttpVersion version, HttpResponseStatus status, HttpHeaders headers) {
        super(version, headers);
        this.status = ObjectUtil.checkNotNull(status, "status");
    }

    @Override
    @Deprecated
    public HttpResponseStatus getStatus() {
        return this.status();
    }

    @Override
    public HttpResponseStatus status() {
        return this.status;
    }

    @Override
    public HttpResponse setStatus(HttpResponseStatus status) {
        this.status = ObjectUtil.checkNotNull(status, "status");
        return this;
    }

    @Override
    public HttpResponse setProtocolVersion(HttpVersion version) {
        super.setProtocolVersion(version);
        return this;
    }

    public String toString() {
        return HttpMessageUtil.appendResponse(new StringBuilder(256), this).toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + this.status.hashCode();
        result = 31 * result + super.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o2) {
        if (!(o2 instanceof DefaultHttpResponse)) {
            return false;
        }
        DefaultHttpResponse other = (DefaultHttpResponse)o2;
        return this.status.equals(other.status()) && super.equals(o2);
    }
}

