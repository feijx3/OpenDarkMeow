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

public class S2CPacketRedirectServer
implements S2CPacket {
    @NotNull
    private final String host;
    private final int port;

    public S2CPacketRedirectServer(@NotNull String host, int port) {
        this.host = host;
        this.port = port;
    }

    public S2CPacketRedirectServer(@NotNull FriendBuffer buffer) {
        this.host = buffer.readString(Short.MAX_VALUE);
        this.port = buffer.readInt();
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeString(this.host);
        buffer.writeInt(this.port);
    }

    @NotNull
    @Generated
    public String getHost() {
        return this.host;
    }

    @Generated
    public int getPort() {
        return this.port;
    }
}

