/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.online.s2c;

import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.S2CPacket;
import org.jetbrains.annotations.NotNull;

public class S2CPacketDisconnect
implements S2CPacket {
    private final boolean markSessionTokenInvalid;
    @NotNull
    private final String message;

    public S2CPacketDisconnect(boolean markSessionTokenInvalid, @NotNull String message) {
        this.markSessionTokenInvalid = markSessionTokenInvalid;
        this.message = message;
    }

    public S2CPacketDisconnect(@NotNull FriendBuffer buffer) {
        this.markSessionTokenInvalid = buffer.readBoolean();
        this.message = buffer.readString(Short.MAX_VALUE);
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeBoolean(this.markSessionTokenInvalid);
        buffer.writeString(this.message);
    }

    @Generated
    public boolean isMarkSessionTokenInvalid() {
        return this.markSessionTokenInvalid;
    }

    @NotNull
    @Generated
    public String getMessage() {
        return this.message;
    }
}

