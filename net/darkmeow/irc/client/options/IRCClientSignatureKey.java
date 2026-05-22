/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client.options;

import java.security.PrivateKey;
import java.util.Base64;
import lombok.Generated;
import net.darkmeow.irc.utils.CryptUtils;
import org.jetbrains.annotations.NotNull;

public class IRCClientSignatureKey {
    @NotNull
    private final PrivateKey key;

    public IRCClientSignatureKey(byte[] data) throws Exception {
        this.key = CryptUtils.loadPrivateKeyFromByte(data);
    }

    public IRCClientSignatureKey(@NotNull String src) throws Exception {
        this(Base64.getDecoder().decode(src.replace("\n", "").replace(" ", "")));
    }

    @Generated
    public IRCClientSignatureKey(@NotNull PrivateKey key) {
        if (key == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        this.key = key;
    }

    @NotNull
    @Generated
    public PrivateKey getKey() {
        return this.key;
    }
}

