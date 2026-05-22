/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.online.c2s;

import lombok.Generated;
import net.darkmeow.irc.data.DataSkin;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.C2SPacket;
import org.jetbrains.annotations.NotNull;

public class C2SPacketUploadSkin
implements C2SPacket {
    private final DataSkin skin;

    public C2SPacketUploadSkin(DataSkin skin) {
        this.skin = skin;
    }

    public C2SPacketUploadSkin(@NotNull FriendBuffer buffer) {
        this.skin = buffer.readSkin();
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeSkin(this.skin);
    }

    @Generated
    public DataSkin getSkin() {
        return this.skin;
    }
}

