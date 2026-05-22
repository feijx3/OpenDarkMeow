/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.login.s2c;

import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.S2CPacket;
import org.jetbrains.annotations.NotNull;

public class S2CPacketLoginFailed
implements S2CPacket {
    @NotNull
    private final String reason;
    private final boolean markSessionTokenInvalid;

    public S2CPacketLoginFailed(@NotNull String reason, boolean markSessionTokenInvalid) {
        this.reason = reason;
        this.markSessionTokenInvalid = markSessionTokenInvalid;
    }

    public S2CPacketLoginFailed(@NotNull FriendBuffer buffer) {
        this.reason = buffer.readString(Short.MAX_VALUE);
        this.markSessionTokenInvalid = buffer.readBoolean();
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeString(this.reason);
        buffer.writeBoolean(this.markSessionTokenInvalid);
    }

    @NotNull
    @Generated
    public String getReason() {
        return this.reason;
    }

    @Generated
    public boolean isMarkSessionTokenInvalid() {
        return this.markSessionTokenInvalid;
    }
}

