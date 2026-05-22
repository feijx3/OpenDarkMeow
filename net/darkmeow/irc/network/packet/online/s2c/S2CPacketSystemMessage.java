/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.online.s2c;

import java.util.UUID;
import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.S2CPacket;
import org.jetbrains.annotations.NotNull;

public class S2CPacketSystemMessage
implements S2CPacket {
    @NotNull
    private final String message;
    @NotNull
    private final UUID id;

    public S2CPacketSystemMessage(@NotNull String message, @NotNull UUID id) {
        this.message = message;
        this.id = id;
    }

    public S2CPacketSystemMessage(@NotNull FriendBuffer buffer) {
        this.message = buffer.readString(Short.MAX_VALUE);
        this.id = buffer.readUniqueId();
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeString(this.message);
        buffer.writeUniqueId(this.id);
    }

    @NotNull
    @Generated
    public String getMessage() {
        return this.message;
    }

    @NotNull
    @Generated
    public UUID getId() {
        return this.id;
    }
}

