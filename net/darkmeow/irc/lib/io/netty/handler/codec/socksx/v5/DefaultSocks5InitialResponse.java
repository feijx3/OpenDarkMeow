/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5;

import net.darkmeow.irc.lib.io.netty.handler.codec.DecoderResult;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.AbstractSocks5Message;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5AuthMethod;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5InitialResponse;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.StringUtil;

public class DefaultSocks5InitialResponse
extends AbstractSocks5Message
implements Socks5InitialResponse {
    private final Socks5AuthMethod authMethod;

    public DefaultSocks5InitialResponse(Socks5AuthMethod authMethod) {
        this.authMethod = ObjectUtil.checkNotNull(authMethod, "authMethod");
    }

    @Override
    public Socks5AuthMethod authMethod() {
        return this.authMethod;
    }

    public String toString() {
        StringBuilder buf = new StringBuilder(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = this.decoderResult();
        if (!decoderResult.isSuccess()) {
            buf.append("(decoderResult: ");
            buf.append(decoderResult);
            buf.append(", authMethod: ");
        } else {
            buf.append("(authMethod: ");
        }
        buf.append(this.authMethod());
        buf.append(')');
        return buf.toString();
    }
}

