/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.online.c2s;

import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.C2SPacket;
import org.jetbrains.annotations.NotNull;

public class C2SPacketKeepAlive
implements C2SPacket {
    private final long id;

    public C2SPacketKeepAlive(long id) {
        this.id = id;
    }

    public C2SPacketKeepAlive(@NotNull FriendBuffer buffer) {
        this.id = buffer.readLong();
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeLong(this.id);
    }

    @Generated
    public long getId() {
        return this.id;
    }
}

