/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.handshake.c2s;

import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.SecretKey;
import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.C2SPacket;
import net.darkmeow.irc.utils.ByteUtils;
import net.darkmeow.irc.utils.CryptUtils;
import org.jetbrains.annotations.NotNull;

public class C2SPacketEncryptionResponse
implements C2SPacket {
    private final byte[] secretKeyEncrypted;
    private final byte[] signatureByte;

    public C2SPacketEncryptionResponse(PublicKey publicKey, SecretKey secretKey) {
        this.secretKeyEncrypted = CryptUtils.encryptData(publicKey, secretKey.getEncoded());
        this.signatureByte = new byte[0];
    }

    public C2SPacketEncryptionResponse(PublicKey publicKey, SecretKey secretKey, PrivateKey signaturePrivateKey, byte[] signatureData) throws Exception {
        this.secretKeyEncrypted = CryptUtils.encryptData(publicKey, secretKey.getEncoded());
        this.signatureByte = CryptUtils.signData(ByteUtils.concatByteArrays(publicKey.getEncoded(), signatureData), signaturePrivateKey);
    }

    public C2SPacketEncryptionResponse(@NotNull FriendBuffer buffer) {
        this.secretKeyEncrypted = buffer.readByteArray();
        this.signatureByte = buffer.readByteArray();
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeByteArray(this.secretKeyEncrypted);
        buffer.writeByteArray(this.signatureByte);
    }

    @NotNull
    public SecretKey getSecretKey(@NotNull PrivateKey key) {
        return CryptUtils.decryptSharedKey(key, this.secretKeyEncrypted);
    }

    public boolean hasSignatureResponse() {
        return this.signatureByte.length != 0;
    }

    public boolean verifySignature(@NotNull PublicKey connectionPublickey, @NotNull PublicKey signaturePublicKey, byte[] data) {
        try {
            return CryptUtils.verifyData(ByteUtils.concatByteArrays(connectionPublickey.getEncoded(), data), this.signatureByte, signaturePublicKey);
        }
        catch (Exception ignored) {
            return false;
        }
    }

    @Generated
    public byte[] getSecretKeyEncrypted() {
        return this.secretKeyEncrypted;
    }

    @Generated
    public byte[] getSignatureByte() {
        return this.signatureByte;
    }
}

