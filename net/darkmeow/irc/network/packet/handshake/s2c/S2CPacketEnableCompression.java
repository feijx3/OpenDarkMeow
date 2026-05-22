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

public class S2CPacketEnableCompression
implements S2CPacket {
    private final int threshold;

    public S2CPacketEnableCompression(int threshold) {
        this.threshold = threshold;
    }

    public S2CPacketEnableCompression(@NotNull FriendBuffer buffer) {
        this.threshold = buffer.readInt();
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeInt(this.threshold);
    }

    @Generated
    public int getThreshold() {
        return this.threshold;
    }
}

