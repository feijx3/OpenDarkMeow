/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.online.c2s;

import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.C2SPacket;
import org.jetbrains.annotations.NotNull;

public class C2SPacketUpdatePassword
implements C2SPacket {
    @NotNull
    private final String password;

    public C2SPacketUpdatePassword(@NotNull String password) {
        this.password = password;
    }

    public C2SPacketUpdatePassword(@NotNull FriendBuffer buffer) {
        this.password = buffer.readString(Short.MAX_VALUE);
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeString(this.password);
    }

    @NotNull
    @Generated
    public String getPassword() {
        return this.password;
    }
}

