/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.irc.client.options.proxy;

import net.darkmeow.irc.lib.io.netty.channel.ChannelHandler;
import org.jetbrains.annotations.Nullable;

public interface IRCOptionsProxy {
    @Nullable
    public ChannelHandler getNettyHandler();
}

