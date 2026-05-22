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
import net.darkmeow.irc.data.DataUser;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.S2CPacket;
import org.jetbrains.annotations.NotNull;

public class S2CPacketSessionMessage
implements S2CPacket {
    @NotNull
    private final Type type;
    @NotNull
    private final UUID sender;
    @NotNull
    private final DataUser senderData;
    @NotNull
    private final String message;
    @NotNull
    private final UUID id;

    public S2CPacketSessionMessage(@NotNull Type type, @NotNull UUID sender, @NotNull DataUser senderData, @NotNull String message, @NotNull UUID id) {
        this.type = type;
        this.sender = sender;
        this.senderData = senderData;
        this.message = message;
        this.id = id;
    }

    public S2CPacketSessionMessage(@NotNull FriendBuffer buffer) {
        this.type = buffer.readEnumValue(Type.class);
        this.sender = buffer.readUniqueId();
        this.senderData = buffer.readUser();
        this.message = buffer.readString(Short.MAX_VALUE);
        this.id = buffer.readUniqueId();
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeEnumValue(this.type);
        buffer.writeUniqueId(this.sender);
        buffer.writeUser(this.senderData);
        buffer.writeString(this.message);
        buffer.writeUniqueId(this.id);
    }

    @NotNull
    @Generated
    public Type getType() {
        return this.type;
    }

    @NotNull
    @Generated
    public UUID getSender() {
        return this.sender;
    }

    @NotNull
    @Generated
    public DataUser getSenderData() {
        return this.senderData;
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

    public static enum Type {
        PUBLIC,
        PRIVATE;

    }
}

