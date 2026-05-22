/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.handshake.c2s;

import lombok.Generated;
import net.darkmeow.irc.data.DataClientBrand;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.C2SPacket;
import org.jetbrains.annotations.NotNull;

public class C2SPacketHandShake
implements C2SPacket {
    private final int protocolVersion;
    @NotNull
    private final String host;
    private final int port;
    @NotNull
    private final String hardWareUniqueId;
    @NotNull
    private final DataClientBrand brand;
    private final long timestamp;

    public C2SPacketHandShake(int protocolVersion, @NotNull String host, int port, @NotNull String hardWareUniqueId, @NotNull DataClientBrand brand, long timestamp) {
        this.protocolVersion = protocolVersion;
        this.host = host;
        this.port = port;
        this.hardWareUniqueId = hardWareUniqueId;
        this.brand = brand;
        this.timestamp = timestamp;
    }

    public C2SPacketHandShake(@NotNull FriendBuffer buffer) {
        this.protocolVersion = buffer.readInt();
        this.host = buffer.readString(Short.MAX_VALUE);
        this.port = buffer.readInt();
        this.hardWareUniqueId = buffer.readString(Short.MAX_VALUE);
        this.brand = buffer.readClientBrand();
        this.timestamp = buffer.readLong();
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeInt(this.protocolVersion);
        buffer.writeString(this.host);
        buffer.writeInt(this.port);
        buffer.writeString(this.hardWareUniqueId);
        buffer.writeClientBrand(this.brand);
        buffer.writeLong(this.timestamp);
    }

    @Generated
    public int getProtocolVersion() {
        return this.protocolVersion;
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

    @NotNull
    @Generated
    public String getHardWareUniqueId() {
        return this.hardWareUniqueId;
    }

    @NotNull
    @Generated
    public DataClientBrand getBrand() {
        return this.brand;
    }

    @Generated
    public long getTimestamp() {
        return this.timestamp;
    }
}

