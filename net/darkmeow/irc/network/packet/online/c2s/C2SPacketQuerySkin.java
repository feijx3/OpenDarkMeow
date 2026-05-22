/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.online.c2s;

import java.util.UUID;
import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.C2SPacket;
import org.jetbrains.annotations.NotNull;

public class C2SPacketQuerySkin
implements C2SPacket {
    private final UUID sessionId;

    public C2SPacketQuerySkin(UUID sessionId) {
        this.sessionId = sessionId;
    }

    public C2SPacketQuerySkin(@NotNull FriendBuffer buffer) {
        this.sessionId = buffer.readUniqueId();
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeUniqueId(this.sessionId);
    }

    @Generated
    public UUID getSessionId() {
        return this.sessionId;
    }
}

