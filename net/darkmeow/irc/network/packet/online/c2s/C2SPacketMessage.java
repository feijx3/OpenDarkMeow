/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.online.c2s;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Generated;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.C2SPacket;
import org.jetbrains.annotations.NotNull;

public class C2SPacketMessage
implements C2SPacket {
    @NotNull
    private final Type type;
    @NotNull
    public final List<String> arg;
    @NotNull
    public final String message;

    public C2SPacketMessage(@NotNull String message) {
        this.type = Type.PUBLIC;
        this.arg = new ArrayList<String>();
        this.message = message;
    }

    public C2SPacketMessage(@NotNull String receiver, @NotNull String message) {
        this.type = Type.PRIVATE;
        this.arg = new ArrayList<String>(Collections.singleton(receiver));
        this.message = message;
    }

    public C2SPacketMessage(@NotNull String root, @NotNull List<String> args) {
        this.type = Type.COMMAND;
        this.arg = args;
        this.message = root;
    }

    public C2SPacketMessage(@NotNull FriendBuffer buffer) {
        this.type = buffer.readEnumValue(Type.class);
        int size = buffer.readInt();
        this.arg = new ArrayList<String>(size);
        for (int i2 = 0; i2 < size; ++i2) {
            this.arg.add(buffer.readString(Short.MAX_VALUE));
        }
        this.message = buffer.readString(Short.MAX_VALUE);
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeEnumValue(this.type);
        buffer.writeInt(this.arg.size());
        for (String s2 : this.arg) {
            buffer.writeString(s2);
        }
        buffer.writeString(this.message);
    }

    @NotNull
    @Generated
    public Type getType() {
        return this.type;
    }

    @NotNull
    @Generated
    public List<String> getArg() {
        return this.arg;
    }

    @NotNull
    @Generated
    public String getMessage() {
        return this.message;
    }

    public static enum Type {
        PUBLIC,
        PRIVATE,
        COMMAND;

    }
}

