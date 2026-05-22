/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.handshake.s2c;

import java.util.UUID;
import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.S2CPacket;
import org.jetbrains.annotations.NotNull;

public class S2CPacketHandShakeSuccess
implements S2CPacket {
    @NotNull
    private final UUID sessionId;

    public S2CPacketHandShakeSuccess(@NotNull UUID sessionId) {
        this.sessionId = sessionId;
    }

    public S2CPacketHandShakeSuccess(@NotNull FriendBuffer buffer) {
        this.sessionId = buffer.readUniqueId();
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeUniqueId(this.sessionId);
    }

    @NotNull
    @Generated
    public UUID getSessionId() {
        return this.sessionId;
    }
}

