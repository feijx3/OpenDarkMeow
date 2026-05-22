/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.http;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.util.CharsetUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;

public class HttpVersion
implements Comparable<HttpVersion> {
    private static final Pattern VERSION_PATTERN = Pattern.compile("(\\S+)/(\\d+)\\.(\\d+)");
    static final String HTTP_1_0_STRING = "HTTP/1.0";
    static final String HTTP_1_1_STRING = "HTTP/1.1";
    public static final HttpVersion HTTP_1_0 = new HttpVersion("HTTP", 1, 0, false, true);
    public static final HttpVersion HTTP_1_1 = new HttpVersion("HTTP", 1, 1, true, true);
    private final String protocolName;
    private final int majorVersion;
    private final int minorVersion;
    private final String text;
    private final boolean keepAliveDefault;
    private final byte[] bytes;

    public static HttpVersion valueOf(String text) {
        return HttpVersion.valueOf(text, false);
    }

    static HttpVersion valueOf(String text, boolean strict) {
        ObjectUtil.checkNotNull(text, "text");
        if (text == HTTP_1_1_STRING) {
            return HTTP_1_1;
        }
        if (text == HTTP_1_0_STRING) {
            return HTTP_1_0;
        }
        if ((text = text.trim()).isEmpty()) {
            throw new IllegalArgumentException("text is empty (possibly HTTP/0.9)");
        }
        HttpVersion version = HttpVersion.version0(text);
        if (version == null) {
            version = new HttpVersion(text, strict, true);
        }
        return version;
    }

    private static HttpVersion version0(String text) {
        if (HTTP_1_1_STRING.equals(text)) {
            return HTTP_1_1;
        }
        if (HTTP_1_0_STRING.equals(text)) {
            return HTTP_1_0;
        }
        return null;
    }

    public HttpVersion(String text, boolean keepAliveDefault) {
        this(text, false, keepAliveDefault);
    }

    HttpVersion(String text, boolean strict, boolean keepAliveDefault) {
        text = ObjectUtil.checkNonEmptyAfterTrim(text, "text").toUpperCase();
        if (strict) {
            if (text.length() != 8 || !text.startsWith("HTTP/") || text.charAt(6) != '.') {
                throw new IllegalArgumentException("invalid version format: " + text);
            }
            this.protocolName = "HTTP";
            this.majorVersion = HttpVersion.toDecimal(text.charAt(5));
            this.minorVersion = HttpVersion.toDecimal(text.charAt(7));
        } else {
            Matcher m2 = VERSION_PATTERN.matcher(text);
            if (!m2.matches()) {
                throw new IllegalArgumentException("invalid version format: " + text);
            }
            this.protocolName = m2.group(1);
            this.majorVersion = Integer.parseInt(m2.group(2));
            this.minorVersion = Integer.parseInt(m2.group(3));
        }
        this.text = this.protocolName + '/' + this.majorVersion + '.' + this.minorVersion;
        this.keepAliveDefault = keepAliveDefault;
        this.bytes = null;
    }

    private static int toDecimal(int value) {
        if (value < 48 || value > 57) {
            throw new IllegalArgumentException("Invalid version number, only 0-9 (0x30-0x39) allowed, but received a '" + (char)value + "' (0x" + Integer.toHexString(value) + ")");
        }
        return value - 48;
    }

    public HttpVersion(String protocolName, int majorVersion, int minorVersion, boolean keepAliveDefault) {
        this(protocolName, majorVersion, minorVersion, keepAliveDefault, false);
    }

    private HttpVersion(String protocolName, int majorVersion, int minorVersion, boolean keepAliveDefault, boolean bytes) {
        protocolName = ObjectUtil.checkNonEmptyAfterTrim(protocolName, "protocolName").toUpperCase();
        for (int i2 = 0; i2 < protocolName.length(); ++i2) {
            if (!Character.isISOControl(protocolName.charAt(i2)) && !Character.isWhitespace(protocolName.charAt(i2))) continue;
            throw new IllegalArgumentException("invalid character in protocolName");
        }
        ObjectUtil.checkPositiveOrZero(majorVersion, "majorVersion");
        ObjectUtil.checkPositiveOrZero(minorVersion, "minorVersion");
        this.protocolName = protocolName;
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.text = protocolName + '/' + majorVersion + '.' + minorVersion;
        this.keepAliveDefault = keepAliveDefault;
        this.bytes = (byte[])(bytes ? this.text.getBytes(CharsetUtil.US_ASCII) : null);
    }

    public String protocolName() {
        return this.protocolName;
    }

    public int majorVersion() {
        return this.majorVersion;
    }

    public int minorVersion() {
        return this.minorVersion;
    }

    public String text() {
        return this.text;
    }

    public boolean isKeepAliveDefault() {
        return this.keepAliveDefault;
    }

    public String toString() {
        return this.text();
    }

    public int hashCode() {
        return (this.protocolName().hashCode() * 31 + this.majorVersion()) * 31 + this.minorVersion();
    }

    public boolean equals(Object o2) {
        if (!(o2 instanceof HttpVersion)) {
            return false;
        }
        HttpVersion that = (HttpVersion)o2;
        return this.minorVersion() == that.minorVersion() && this.majorVersion() == that.majorVersion() && this.protocolName().equals(that.protocolName());
    }

    @Override
    public int compareTo(HttpVersion o2) {
        int v2 = this.protocolName().compareTo(o2.protocolName());
        if (v2 != 0) {
            return v2;
        }
        v2 = this.majorVersion() - o2.majorVersion();
        if (v2 != 0) {
            return v2;
        }
        return this.minorVersion() - o2.minorVersion();
    }

    void encode(ByteBuf buf) {
        if (this.bytes == null) {
            buf.writeCharSequence(this.text, CharsetUtil.US_ASCII);
        } else {
            buf.writeBytes(this.bytes);
        }
    }
}

