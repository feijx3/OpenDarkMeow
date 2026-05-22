/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5;

import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5AddressType;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5CommandStatus;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5Message;

public interface Socks5CommandResponse
extends Socks5Message {
    public Socks5CommandStatus status();

    public Socks5AddressType bndAddrType();

    public String bndAddr();

    public int bndPort();
}

