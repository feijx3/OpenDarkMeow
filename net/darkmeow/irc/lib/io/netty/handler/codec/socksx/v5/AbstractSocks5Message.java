/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5;

import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.AbstractSocksMessage;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.SocksVersion;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5Message;

public abstract class AbstractSocks5Message
extends AbstractSocksMessage
implements Socks5Message {
    @Override
    public final SocksVersion version() {
        return SocksVersion.SOCKS5;
    }
}

