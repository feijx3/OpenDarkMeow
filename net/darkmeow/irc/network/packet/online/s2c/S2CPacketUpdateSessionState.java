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
import net.darkmeow.irc.data.DataUser;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.S2CPacket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class S2CPacketUpdateSessionState
implements S2CPacket {
    @NotNull
    private final UUID id;
    @Nullable
    private final DataUser user;

    public S2CPacketUpdateSessionState(@NotNull UUID id, @NotNull DataUser user) {
        this.id = id;
        this.user = user;
    }

    public S2CPacketUpdateSessionState(@NotNull UUID id) {
        this.id = id;
        this.user = null;
    }

    public S2CPacketUpdateSessionState(@NotNull FriendBuffer buffer) {
        this.id = buffer.readUniqueId();
        this.user = buffer.readBoolean() ? buffer.readUser() : null;
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeUniqueId(this.id);
        if (this.user != null) {
            buffer.writeBoolean(true);
            buffer.writeUser(this.user);
        } else {
            buffer.writeBoolean(false);
        }
    }

    @NotNull
    @Generated
    public UUID getId() {
        return this.id;
    }

    @Nullable
    @Generated
    public DataUser getUser() {
        return this.user;
    }
}

