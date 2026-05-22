/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.socksx;

import net.darkmeow.irc.lib.io.netty.handler.codec.DecoderResultProvider;
import net.darkmeow.irc.lib.io.netty.handler.codec.socksx.SocksVersion;

public interface SocksMessage
extends DecoderResultProvider {
    public SocksVersion version();
}

