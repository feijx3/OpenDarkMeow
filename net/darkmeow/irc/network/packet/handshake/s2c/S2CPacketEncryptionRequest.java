/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.handshake.s2c;

import java.security.PublicKey;
import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.S2CPacket;
import net.darkmeow.irc.utils.CryptUtils;
import org.jetbrains.annotations.NotNull;

public class S2CPacketEncryptionRequest
implements S2CPacket {
    @NotNull
    private final PublicKey publicKey;
    private final byte[] signatureData;

    public S2CPacketEncryptionRequest(@NotNull PublicKey publicKey) {
        this.publicKey = publicKey;
        this.signatureData = new byte[0];
    }

    public S2CPacketEncryptionRequest(@NotNull PublicKey publicKey, byte[] signatureData) {
        this.publicKey = publicKey;
        this.signatureData = signatureData;
    }

    public S2CPacketEncryptionRequest(@NotNull FriendBuffer buffer) {
        this.publicKey = CryptUtils.decodePublicKey(buffer.readByteArray());
        this.signatureData = buffer.readByteArray();
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeByteArray(this.publicKey.getEncoded());
        buffer.writeByteArray(this.signatureData);
    }

    public boolean hasSignatureRequire() {
        return this.signatureData.length > 0;
    }

    @NotNull
    @Generated
    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    @Generated
    public byte[] getSignatureData() {
        return this.signatureData;
    }
}

