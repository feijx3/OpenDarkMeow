/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel.nio;

import java.nio.channels.SelectableChannel;
import net.darkmeow.irc.lib.io.netty.channel.IoHandle;

public interface NioIoHandle
extends IoHandle {
    public SelectableChannel selectableChannel();
}

