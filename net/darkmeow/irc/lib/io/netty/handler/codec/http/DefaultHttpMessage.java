/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.http;

import net.darkmeow.irc.lib.io.netty.handler.codec.http.DefaultHttpHeadersFactory;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.DefaultHttpObject;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpHeaders;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpHeadersFactory;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpMessage;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpVersion;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;

public abstract class DefaultHttpMessage
extends DefaultHttpObject
implements HttpMessage {
    private static final int HASH_CODE_PRIME = 31;
    private HttpVersion version;
    private final HttpHeaders headers;

    protected DefaultHttpMessage(HttpVersion version) {
        this(version, DefaultHttpHeadersFactory.headersFactory());
    }

    @Deprecated
    protected DefaultHttpMessage(HttpVersion version, boolean validateHeaders, boolean singleFieldHeaders) {
        this(version, DefaultHttpHeadersFactory.headersFactory().withValidation(validateHeaders).withCombiningHeaders(singleFieldHeaders));
    }

    protected DefaultHttpMessage(HttpVersion version, HttpHeadersFactory headersFactory) {
        this(version, headersFactory.newHeaders());
    }

    protected DefaultHttpMessage(HttpVersion version, HttpHeaders headers) {
        this.version = ObjectUtil.checkNotNull(version, "version");
        this.headers = ObjectUtil.checkNotNull(headers, "headers");
    }

    @Override
    public HttpHeaders headers() {
        return this.headers;
    }

    @Override
    @Deprecated
    public HttpVersion getProtocolVersion() {
        return this.protocolVersion();
    }

    @Override
    public HttpVersion protocolVersion() {
        return this.version;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + this.headers.hashCode();
        result = 31 * result + this.version.hashCode();
        result = 31 * result + super.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o2) {
        if (!(o2 instanceof DefaultHttpMessage)) {
            return false;
        }
        DefaultHttpMessage other = (DefaultHttpMessage)o2;
        return this.headers().equals(other.headers()) && this.protocolVersion().equals(other.protocolVersion()) && super.equals(o2);
    }

    @Override
    public HttpMessage setProtocolVersion(HttpVersion version) {
        this.version = ObjectUtil.checkNotNull(version, "version");
        return this;
    }
}

