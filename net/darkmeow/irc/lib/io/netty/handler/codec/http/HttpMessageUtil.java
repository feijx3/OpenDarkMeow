/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.http;

import java.util.Map;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.FullHttpMessage;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.FullHttpRequest;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.FullHttpResponse;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpHeaders;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpMessage;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpRequest;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpResponse;
import net.darkmeow.irc.lib.io.netty.util.internal.StringUtil;

final class HttpMessageUtil {
    static StringBuilder appendRequest(StringBuilder buf, HttpRequest req) {
        HttpMessageUtil.appendCommon(buf, req);
        HttpMessageUtil.appendInitialLine(buf, req);
        HttpMessageUtil.appendHeaders(buf, req.headers());
        HttpMessageUtil.removeLastNewLine(buf);
        return buf;
    }

    static StringBuilder appendResponse(StringBuilder buf, HttpResponse res) {
        HttpMessageUtil.appendCommon(buf, res);
        HttpMessageUtil.appendInitialLine(buf, res);
        HttpMessageUtil.appendHeaders(buf, res.headers());
        HttpMessageUtil.removeLastNewLine(buf);
        return buf;
    }

    private static void appendCommon(StringBuilder buf, HttpMessage msg) {
        buf.append(StringUtil.simpleClassName(msg));
        buf.append("(decodeResult: ");
        buf.append(msg.decoderResult());
        buf.append(", version: ");
        buf.append(msg.protocolVersion());
        buf.append(')');
        buf.append(StringUtil.NEWLINE);
    }

    static StringBuilder appendFullRequest(StringBuilder buf, FullHttpRequest req) {
        HttpMessageUtil.appendFullCommon(buf, req);
        HttpMessageUtil.appendInitialLine(buf, req);
        HttpMessageUtil.appendHeaders(buf, req.headers());
        HttpMessageUtil.appendHeaders(buf, req.trailingHeaders());
        HttpMessageUtil.removeLastNewLine(buf);
        return buf;
    }

    static StringBuilder appendFullResponse(StringBuilder buf, FullHttpResponse res) {
        HttpMessageUtil.appendFullCommon(buf, res);
        HttpMessageUtil.appendInitialLine(buf, res);
        HttpMessageUtil.appendHeaders(buf, res.headers());
        HttpMessageUtil.appendHeaders(buf, res.trailingHeaders());
        HttpMessageUtil.removeLastNewLine(buf);
        return buf;
    }

    private static void appendFullCommon(StringBuilder buf, FullHttpMessage msg) {
        buf.append(StringUtil.simpleClassName(msg));
        buf.append("(decodeResult: ");
        buf.append(msg.decoderResult());
        buf.append(", version: ");
        buf.append(msg.protocolVersion());
        buf.append(", content: ");
        buf.append(msg.content());
        buf.append(')');
        buf.append(StringUtil.NEWLINE);
    }

    private static void appendInitialLine(StringBuilder buf, HttpRequest req) {
        buf.append(req.method());
        buf.append(' ');
        buf.append(req.uri());
        buf.append(' ');
        buf.append(req.protocolVersion());
        buf.append(StringUtil.NEWLINE);
    }

    private static void appendInitialLine(StringBuilder buf, HttpResponse res) {
        buf.append(res.protocolVersion());
        buf.append(' ');
        buf.append(res.status());
        buf.append(StringUtil.NEWLINE);
    }

    private static void appendHeaders(StringBuilder buf, HttpHeaders headers) {
        for (Map.Entry<String, String> e2 : headers) {
            buf.append(e2.getKey());
            buf.append(": ");
            buf.append(e2.getValue());
            buf.append(StringUtil.NEWLINE);
        }
    }

    private static void removeLastNewLine(StringBuilder buf) {
        buf.setLength(buf.length() - StringUtil.NEWLINE.length());
    }

    private HttpMessageUtil() {
    }
}

