/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel.nio;

import net.darkmeow.irc.lib.io.netty.channel.IoEvent;
import net.darkmeow.irc.lib.io.netty.channel.nio.NioIoOps;

public interface NioIoEvent
extends IoEvent {
    public NioIoOps ops();
}

