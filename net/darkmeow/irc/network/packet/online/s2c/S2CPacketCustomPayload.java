/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.online.s2c;

import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.S2CPacket;
import org.jetbrains.annotations.NotNull;

public class S2CPacketCustomPayload
implements S2CPacket {
    @NotNull
    private final String channel;
    @NotNull
    private final FriendBuffer data;

    public S2CPacketCustomPayload(@NotNull String channel, @NotNull FriendBuffer data) {
        this.channel = channel;
        this.data = data;
    }

    public S2CPacketCustomPayload(@NotNull FriendBuffer buffer) {
        this.channel = buffer.readString(100);
        this.data = new FriendBuffer(buffer.readBytes(buffer.readableBytes()));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeString(this.channel);
        FriendBuffer friendBuffer = this.data;
        synchronized (friendBuffer) {
            this.data.markReaderIndex();
            buffer.writeBytes(this.data);
            this.data.resetReaderIndex();
        }
    }

    @NotNull
    @Generated
    public String getChannel() {
        return this.channel;
    }

    @NotNull
    @Generated
    public FriendBuffer getData() {
        return this.data;
    }
}

