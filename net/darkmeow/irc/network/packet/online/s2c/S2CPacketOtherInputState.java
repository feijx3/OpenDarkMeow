/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.online.s2c;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.S2CPacket;
import org.jetbrains.annotations.NotNull;

public class S2CPacketOtherInputState
implements S2CPacket {
    @NotNull
    private final Set<UUID> publicInputs;
    @NotNull
    private final Set<UUID> privateInputs;

    public S2CPacketOtherInputState(@NotNull Set<UUID> publicInputs, @NotNull Set<UUID> privateInputs) {
        this.publicInputs = publicInputs;
        this.privateInputs = privateInputs;
    }

    public S2CPacketOtherInputState(@NotNull FriendBuffer buffer) {
        int publicInputSize = buffer.readInt();
        this.publicInputs = new LinkedHashSet<UUID>(publicInputSize);
        for (int i2 = 0; i2 < publicInputSize; ++i2) {
            this.publicInputs.add(buffer.readUniqueId());
        }
        int privateInputSize = buffer.readInt();
        this.privateInputs = new LinkedHashSet<UUID>(privateInputSize);
        for (int i3 = 0; i3 < privateInputSize; ++i3) {
            this.privateInputs.add(buffer.readUniqueId());
        }
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeInt(this.publicInputs.size());
        for (UUID uuid : this.publicInputs) {
            buffer.writeUniqueId(uuid);
        }
        buffer.writeInt(this.privateInputs.size());
        for (UUID uuid : this.privateInputs) {
            buffer.writeUniqueId(uuid);
        }
    }

    @NotNull
    @Generated
    public Set<UUID> getPublicInputs() {
        return this.publicInputs;
    }

    @NotNull
    @Generated
    public Set<UUID> getPrivateInputs() {
        return this.privateInputs;
    }
}

