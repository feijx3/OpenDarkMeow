/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4;

import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4.Socks4CommandType;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v4.Socks4Message;

public interface Socks4CommandRequest
extends Socks4Message {
    public Socks4CommandType type();

    public String userId();

    public String dstAddr();

    public int dstPort();
}

