/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.http;

import net.darkmeow.irc.lib.io.netty.handler.codec.http.DefaultHttpHeadersFactory;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.DefaultHttpMessage;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpHeaders;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpHeadersFactory;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpMessageUtil;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpMethod;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpRequest;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpVersion;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;

public class DefaultHttpRequest
extends DefaultHttpMessage
implements HttpRequest {
    private static final int HASH_CODE_PRIME = 31;
    private HttpMethod method;
    private String uri;

    public DefaultHttpRequest(HttpVersion httpVersion, HttpMethod method, String uri) {
        this(httpVersion, method, uri, DefaultHttpHeadersFactory.headersFactory().newHeaders());
    }

    @Deprecated
    public DefaultHttpRequest(HttpVersion httpVersion, HttpMethod method, String uri, boolean validateHeaders) {
        this(httpVersion, method, uri, DefaultHttpHeadersFactory.headersFactory().withValidation(validateHeaders));
    }

    public DefaultHttpRequest(HttpVersion httpVersion, HttpMethod method, String uri, HttpHeadersFactory headersFactory) {
        this(httpVersion, method, uri, headersFactory.newHeaders());
    }

    public DefaultHttpRequest(HttpVersion httpVersion, HttpMethod method, String uri, HttpHeaders headers) {
        super(httpVersion, headers);
        this.method = ObjectUtil.checkNotNull(method, "method");
        this.uri = ObjectUtil.checkNotNull(uri, "uri");
    }

    @Override
    @Deprecated
    public HttpMethod getMethod() {
        return this.method();
    }

    @Override
    public HttpMethod method() {
        return this.method;
    }

    @Override
    @Deprecated
    public String getUri() {
        return this.uri();
    }

    @Override
    public String uri() {
        return this.uri;
    }

    @Override
    public HttpRequest setMethod(HttpMethod method) {
        this.method = ObjectUtil.checkNotNull(method, "method");
        return this;
    }

    @Override
    public HttpRequest setUri(String uri) {
        this.uri = ObjectUtil.checkNotNull(uri, "uri");
        return this;
    }

    @Override
    public HttpRequest setProtocolVersion(HttpVersion version) {
        super.setProtocolVersion(version);
        return this;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + this.method.hashCode();
        result = 31 * result + this.uri.hashCode();
        result = 31 * result + super.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o2) {
        if (!(o2 instanceof DefaultHttpRequest)) {
            return false;
        }
        DefaultHttpRequest other = (DefaultHttpRequest)o2;
        return this.method().equals(other.method()) && this.uri().equalsIgnoreCase(other.uri()) && super.equals(o2);
    }

    public String toString() {
        return HttpMessageUtil.appendRequest(new StringBuilder(256), this).toString();
    }
}

