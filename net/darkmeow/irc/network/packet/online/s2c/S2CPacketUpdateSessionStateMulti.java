/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.online.s2c;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.Generated;
import net.darkmeow.irc.data.DataUser;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.S2CPacket;
import org.jetbrains.annotations.NotNull;

public class S2CPacketUpdateSessionStateMulti
implements S2CPacket {
    private final boolean onlySameServer;
    private final boolean overrideAll;
    @NotNull
    private final Map<UUID, DataUser> userMap;

    public S2CPacketUpdateSessionStateMulti(boolean onlySameServer, boolean overrideAll, @NotNull Map<UUID, DataUser> userMap) {
        this.onlySameServer = onlySameServer;
        this.overrideAll = overrideAll;
        this.userMap = userMap;
    }

    public S2CPacketUpdateSessionStateMulti(@NotNull FriendBuffer buffer) {
        this.onlySameServer = buffer.readBoolean();
        this.overrideAll = buffer.readBoolean();
        int size = buffer.readInt();
        this.userMap = new HashMap<UUID, DataUser>(size);
        for (int i2 = 0; i2 < size; ++i2) {
            this.userMap.put(buffer.readUniqueId(), buffer.readUser());
        }
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeBoolean(this.onlySameServer);
        buffer.writeBoolean(this.overrideAll);
        buffer.writeInt(this.userMap.size());
        for (Map.Entry<UUID, DataUser> entry : this.userMap.entrySet()) {
            buffer.writeUniqueId(entry.getKey());
            buffer.writeUser(entry.getValue());
        }
    }

    @Generated
    public boolean isOnlySameServer() {
        return this.onlySameServer;
    }

    @Generated
    public boolean isOverrideAll() {
        return this.overrideAll;
    }

    @NotNull
    @Generated
    public Map<UUID, DataUser> getUserMap() {
        return this.userMap;
    }
}

