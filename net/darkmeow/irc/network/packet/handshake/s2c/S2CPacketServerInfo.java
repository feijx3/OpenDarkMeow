/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.handshake.s2c;

import java.security.PrivateKey;
import java.security.PublicKey;
import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.S2CPacket;
import net.darkmeow.irc.utils.ByteUtils;
import net.darkmeow.irc.utils.CryptUtils;
import org.jetbrains.annotations.NotNull;

public class S2CPacketServerInfo
implements S2CPacket {
    private final long timestamp;
    private final byte[] signature;

    public S2CPacketServerInfo(long timestamp, @NotNull PrivateKey key) throws Exception {
        this.timestamp = timestamp;
        this.signature = CryptUtils.signData(ByteUtils.buildByteArray(buffer -> buffer.writeLong(timestamp)), key);
    }

    public S2CPacketServerInfo(@NotNull FriendBuffer buffer) {
        this.timestamp = buffer.readLong();
        this.signature = buffer.readByteArray();
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeLong(this.timestamp);
        buffer.writeByteArray(this.signature);
    }

    public boolean checkSignature(@NotNull PublicKey key) throws Exception {
        return CryptUtils.verifyData(ByteUtils.buildByteArray(buffer -> buffer.writeLong(this.timestamp)), this.signature, key);
    }

    @Generated
    public long getTimestamp() {
        return this.timestamp;
    }

    @Generated
    public byte[] getSignature() {
        return this.signature;
    }
}

