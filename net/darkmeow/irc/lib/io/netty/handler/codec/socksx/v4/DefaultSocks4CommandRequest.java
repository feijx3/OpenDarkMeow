/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4;

import java.net.IDN;
import net.darkmeow.irc.lib.io.netty.handler.codec.DecoderResult;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4.AbstractSocks4Message;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4.Socks4CommandRequest;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4.Socks4CommandType;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.StringUtil;

public class DefaultSocks4CommandRequest
extends AbstractSocks4Message
implements Socks4CommandRequest {
    private final Socks4CommandType type;
    private final String dstAddr;
    private final int dstPort;
    private final String userId;

    public DefaultSocks4CommandRequest(Socks4CommandType type, String dstAddr, int dstPort) {
        this(type, dstAddr, dstPort, "");
    }

    public DefaultSocks4CommandRequest(Socks4CommandType type, String dstAddr, int dstPort, String userId) {
        if (dstPort <= 0 || dstPort >= 65536) {
            throw new IllegalArgumentException("dstPort: " + dstPort + " (expected: 1~65535)");
        }
        this.type = ObjectUtil.checkNotNull(type, "type");
        this.dstAddr = IDN.toASCII(ObjectUtil.checkNotNull(dstAddr, "dstAddr"));
        this.userId = ObjectUtil.checkNotNull(userId, "userId");
        this.dstPort = dstPort;
    }

    @Override
    public Socks4CommandType type() {
        return this.type;
    }

    @Override
    public String dstAddr() {
        return this.dstAddr;
    }

    @Override
    public int dstPort() {
        return this.dstPort;
    }

    @Override
    public String userId() {
        return this.userId;
    }

    public String toString() {
        StringBuilder buf = new StringBuilder(128);
        buf.append(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = this.decoderResult();
        if (!decoderResult.isSuccess()) {
            buf.append("(decoderResult: ");
            buf.append(decoderResult);
            buf.append(", type: ");
        } else {
            buf.append("(type: ");
        }
        buf.append(this.type());
        buf.append(", dstAddr: ");
        buf.append(this.dstAddr());
        buf.append(", dstPort: ");
        buf.append(this.dstPort());
        buf.append(", userId: ");
        buf.append(this.userId());
        buf.append(')');
        return buf.toString();
    }
}

