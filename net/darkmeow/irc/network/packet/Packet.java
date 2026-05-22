/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet;

import net.darkmeow.irc.network.FriendBuffer;
import org.jetbrains.annotations.NotNull;

public interface Packet {
    public void write(@NotNull FriendBuffer var1);
}

