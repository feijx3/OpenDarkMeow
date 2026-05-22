/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.network;

import net.darkmeow.irc.lib.io.netty.util.AttributeKey;
import net.darkmeow.irc.network.EnumConnectionState;

public class IRCNetworkAttributes {
    public static final AttributeKey<EnumConnectionState> PROTOCOL_TYPE = AttributeKey.valueOf("protocol_type");
}

