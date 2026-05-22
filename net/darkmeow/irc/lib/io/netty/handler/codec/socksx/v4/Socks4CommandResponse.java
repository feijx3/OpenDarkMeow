/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4;

import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4.Socks4CommandStatus;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4.Socks4Message;

public interface Socks4CommandResponse
extends Socks4Message {
    public Socks4CommandStatus status();

    public String dstAddr();

    public int dstPort();
}

