/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5;

import java.util.List;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5AuthMethod;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.v5.Socks5Message;

public interface Socks5InitialRequest
extends Socks5Message {
    public List<Socks5AuthMethod> authMethods();
}

