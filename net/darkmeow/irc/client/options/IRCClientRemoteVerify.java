/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client.options;

import java.security.PublicKey;
import java.util.Base64;
import lombok.Generated;
import net.darkmeow.irc.utils.CryptUtils;
import org.jetbrains.annotations.NotNull;

public class IRCClientRemoteVerify {
    public boolean verify = false;
    @NotNull
    private final PublicKey key;

    public IRCClientRemoteVerify(@NotNull PublicKey key) throws Exception {
        this.key = key;
    }

    public IRCClientRemoteVerify(byte[] data) throws Exception {
        this.key = CryptUtils.loadPublicKeyFromByte(data);
    }

    public IRCClientRemoteVerify(@NotNull String src) throws Exception {
        this(Base64.getDecoder().decode(src.replace("\n", "").replace(" ", "")));
    }

    @NotNull
    @Generated
    public PublicKey getKey() {
        return this.key;
    }
}

