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

public class C2SPacketInputStatus
implements C2SPacket {
    @NotNull
    private final Type type;
    @NotNull
    public final String receiver;
    @NotNull
    public final String message;

    public C2SPacketInputStatus() {
        this.type = Type.CLEAR;
        this.receiver = "";
        this.message = "";
    }

    public C2SPacketInputStatus(@NotNull String message) {
        this.type = Type.PUBLIC;
        this.receiver = "";
        this.message = message;
    }

    public C2SPacketInputStatus(@NotNull String receiver, @NotNull String message) {
        this.type = Type.PRIVATE;
        this.receiver = receiver;
        this.message = message;
    }

    public C2SPacketInputStatus(@NotNull FriendBuffer buffer) {
        this.type = buffer.readEnumValue(Type.class);
        this.receiver = buffer.readString(Short.MAX_VALUE);
        this.message = buffer.readString(Short.MAX_VALUE);
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeEnumValue(this.type);
        buffer.writeString(this.receiver);
        buffer.writeString(this.message);
    }

    @NotNull
    @Generated
    public Type getType() {
        return this.type;
    }

    @NotNull
    @Generated
    public String getReceiver() {
        return this.receiver;
    }

    @NotNull
    @Generated
    public String getMessage() {
        return this.message;
    }

    public static enum Type {
        PUBLIC,
        PRIVATE,
        CLEAR;

    }
}

