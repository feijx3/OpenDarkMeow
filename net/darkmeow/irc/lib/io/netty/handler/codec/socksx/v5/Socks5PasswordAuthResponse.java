/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5;

import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5Message;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5PasswordAuthStatus;

public interface Socks5PasswordAuthResponse
extends Socks5Message {
    public Socks5PasswordAuthStatus status();
}

