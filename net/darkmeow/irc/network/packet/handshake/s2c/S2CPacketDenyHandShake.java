/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.handshake.s2c;

import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.S2CPacket;
import org.jetbrains.annotations.NotNull;

public class S2CPacketDenyHandShake
implements S2CPacket {
    @NotNull
    private final String reason;

    public S2CPacketDenyHandShake(@NotNull String reason) {
        this.reason = reason;
    }

    public S2CPacketDenyHandShake(@NotNull FriendBuffer buffer) {
        this.reason = buffer.readString(Short.MAX_VALUE);
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeString(this.reason);
    }

    @NotNull
    @Generated
    public String getReason() {
        return this.reason;
    }
}

