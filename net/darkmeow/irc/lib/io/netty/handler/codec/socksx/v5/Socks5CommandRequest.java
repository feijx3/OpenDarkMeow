/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5;

import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5AddressType;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5CommandType;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5Message;

public interface Socks5CommandRequest
extends Socks5Message {
    public Socks5CommandType type();

    public Socks5AddressType dstAddrType();

    public String dstAddr();

    public int dstPort();
}

