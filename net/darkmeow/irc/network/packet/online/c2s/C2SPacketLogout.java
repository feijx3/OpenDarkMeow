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

public class C2SPacketLogout
implements C2SPacket {
    private final boolean destroySessionKey;

    public C2SPacketLogout(boolean destroySessionKey) {
        this.destroySessionKey = destroySessionKey;
    }

    public C2SPacketLogout(@NotNull FriendBuffer buffer) {
        this.destroySessionKey = buffer.readBoolean();
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeBoolean(this.destroySessionKey);
    }

    @Generated
    public boolean isDestroySessionKey() {
        return this.destroySessionKey;
    }
}

