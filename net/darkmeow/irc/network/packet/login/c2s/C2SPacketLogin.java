/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.login.c2s;

import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.C2SPacket;
import org.jetbrains.annotations.NotNull;

public class C2SPacketLogin
implements C2SPacket {
    @NotNull
    private final String username;
    @NotNull
    private final String password;
    private final boolean invisible;
    private final boolean disableGenerateToken;

    public C2SPacketLogin(@NotNull String username, @NotNull String password) {
        this.username = username;
        this.password = password;
        this.invisible = false;
        this.disableGenerateToken = false;
    }

    public C2SPacketLogin(@NotNull String username, @NotNull String password, boolean invisible) {
        this.username = username;
        this.password = password;
        this.invisible = invisible;
        this.disableGenerateToken = false;
    }

    public C2SPacketLogin(@NotNull String username, @NotNull String password, boolean invisible, boolean disableGenerateToken) {
        this.username = username;
        this.password = password;
        this.invisible = invisible;
        this.disableGenerateToken = disableGenerateToken;
    }

    public C2SPacketLogin(@NotNull FriendBuffer buffer) {
        this.username = buffer.readString(100);
        this.password = buffer.readString(1024);
        this.invisible = buffer.readBoolean();
        this.disableGenerateToken = buffer.readBoolean();
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeString(this.username);
        buffer.writeString(this.password);
        buffer.writeBoolean(this.invisible);
        buffer.writeBoolean(this.disableGenerateToken);
    }

    @NotNull
    @Generated
    public String getUsername() {
        return this.username;
    }

    @NotNull
    @Generated
    public String getPassword() {
        return this.password;
    }

    @Generated
    public boolean isInvisible() {
        return this.invisible;
    }

    @Generated
    public boolean isDisableGenerateToken() {
        return this.disableGenerateToken;
    }
}

