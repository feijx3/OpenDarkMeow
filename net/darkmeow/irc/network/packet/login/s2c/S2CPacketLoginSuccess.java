/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.irc.network.packet.login.s2c;

import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.S2CPacket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class S2CPacketLoginSuccess
implements S2CPacket {
    @NotNull
    private final String username;
    @NotNull
    private final String token;

    public S2CPacketLoginSuccess(@NotNull String username) {
        this.username = username;
        this.token = "";
    }

    public S2CPacketLoginSuccess(@NotNull String username, @Nullable String token) {
        this.username = username;
        this.token = token == null ? "" : token;
    }

    public S2CPacketLoginSuccess(@NotNull FriendBuffer buffer) {
        this.username = buffer.readString(100);
        this.token = buffer.readString(1024);
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeString(this.username);
        buffer.writeString(this.token);
    }

    @NotNull
    @Generated
    public String getUsername() {
        return this.username;
    }

    @NotNull
    @Generated
    public String getToken() {
        return this.token;
    }
}

