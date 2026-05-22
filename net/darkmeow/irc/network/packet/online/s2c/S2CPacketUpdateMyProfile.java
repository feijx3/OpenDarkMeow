/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.network.packet.online.s2c;

import lombok.Generated;
import net.darkmeow.irc.data.enmus.EnumUserPremium;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.S2CPacket;
import org.jetbrains.annotations.NotNull;

public class S2CPacketUpdateMyProfile
implements S2CPacket {
    @NotNull
    private final String name;
    @NotNull
    private final EnumUserPremium premium;
    private final boolean invisible;

    public S2CPacketUpdateMyProfile(@NotNull String name, @NotNull EnumUserPremium premium, boolean invisible) {
        this.name = name;
        this.premium = premium;
        this.invisible = invisible;
    }

    public S2CPacketUpdateMyProfile(@NotNull FriendBuffer buffer) {
        this.name = buffer.readString(100);
        this.premium = buffer.readEnumValue(EnumUserPremium.class);
        this.invisible = buffer.readBoolean();
    }

    @Override
    public void write(@NotNull FriendBuffer buffer) {
        buffer.writeString(this.name);
        buffer.writeEnumValue(this.premium);
        buffer.writeBoolean(this.invisible);
    }

    @NotNull
    @Generated
    public String getName() {
        return this.name;
    }

    @NotNull
    @Generated
    public EnumUserPremium getPremium() {
        return this.premium;
    }

    @Generated
    public boolean isInvisible() {
        return this.invisible;
    }
}

