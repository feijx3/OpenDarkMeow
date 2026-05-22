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
import net.darkmeow.irc.data.DataSkin;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.S2CPacket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class S2CPacketUpdateSkin
implements S2CPacket {
    private final UUID sessionId;
    @Nullable
    private final DataSkin skin;

    public S2CPacketUpdateSkin(UUID sessionId, @NotNull DataSkin skin) {
        this.sessionId = sessionId;
        this.skin = skin;
    }

    public S2CPacketUpdateSkin(UUID sessionId) {
        this.sessionId = sessionId;
        this.skin = null;
    }

    public S2CPacketUpdateSkin(@NotNull FriendBuffer buffer) {
        this.sessionId = buffer.readUniqueId();
        this.skin = buffer.readBoolean() ? buffer.readSkin() : null;
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeUniqueId(this.sessionId);
        if (this.skin != null) {
            buffer.writeBoolean(true);
            buffer.writeSkin(this.skin);
        } else {
            buffer.writeBoolean(false);
        }
    }

    @Generated
    public UUID getSessionId() {
        return this.sessionId;
    }

    @Nullable
    @Generated
    public DataSkin getSkin() {
        return this.skin;
    }
}

