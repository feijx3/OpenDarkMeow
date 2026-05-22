/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5;

import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5AuthMethod;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5Message;

public interface Socks5InitialResponse
extends Socks5Message {
    public Socks5AuthMethod authMethod();
}

