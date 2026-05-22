/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.irc.network.packet.online.s2c;

import java.util.UUID;
import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.S2CPacket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class S2CPacketPrivateMessageResult
implements S2CPacket {
    @NotNull
    private final String receiver;
    @Nullable
    private final String message;
    @Nullable
    private final UUID id;

    public S2CPacketPrivateMessageResult(@NotNull String receiver) {
        this.receiver = receiver;
        this.message = null;
        this.id = null;
    }

    public S2CPacketPrivateMessageResult(@NotNull String receiver, @NotNull String message, @NotNull UUID id) {
        this.receiver = receiver;
        this.message = message;
        this.id = id;
    }

    public S2CPacketPrivateMessageResult(@NotNull FriendBuffer buffer) {
        this.receiver = buffer.readString(Short.MAX_VALUE);
        if (buffer.readBoolean()) {
            this.message = buffer.readString(Short.MAX_VALUE);
            this.id = buffer.readUniqueId();
        } else {
            this.message = null;
            this.id = null;
        }
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeString(this.receiver);
        if (this.message != null && this.id != null) {
            buffer.writeBoolean(true);
            buffer.writeString(this.message);
            buffer.writeUniqueId(this.id);
        } else {
            buffer.writeBoolean(false);
        }
    }

    public boolean isSuccess() {
        return this.message != null && this.id != null;
    }

    @NotNull
    @Generated
    public String getReceiver() {
        return this.receiver;
    }

    @Nullable
    @Generated
    public String getMessage() {
        return this.message;
    }

    @Nullable
    @Generated
    public UUID getId() {
        return this.id;
    }
}

