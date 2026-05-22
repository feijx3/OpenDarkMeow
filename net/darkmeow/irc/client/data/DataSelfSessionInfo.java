/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client.data;

import java.util.UUID;
import lombok.Generated;
import net.darkmeow.irc.client.data.DataSessionInfo;
import net.darkmeow.irc.client.interfaces.data.IRCDataSelfSessionInfo;
import net.darkmeow.irc.data.enmus.EnumUserPremium;
import org.jetbrains.annotations.NotNull;

public final class DataSelfSessionInfo
extends DataSessionInfo
implements IRCDataSelfSessionInfo {
    @NotNull
    public String name;
    @NotNull
    public EnumUserPremium premium;
    public boolean invisible;

    public DataSelfSessionInfo(@NotNull UUID clientUniqueId, @NotNull String name, @NotNull EnumUserPremium premium, boolean invisible) {
        super(clientUniqueId);
        this.name = name;
        this.premium = premium;
        this.invisible = invisible;
    }

    public void update(@NotNull String name, @NotNull EnumUserPremium premium, boolean invisible) {
        this.valid = true;
        this.name = name;
        this.premium = premium;
        this.invisible = invisible;
    }

    @Override
    @NotNull
    public UUID getUniqueId() {
        return this.uniqueId;
    }

    @Override
    public boolean getIsInvisible() {
        return false;
    }

    @Override
    @NotNull
    @Generated
    public String getName() {
        return this.name;
    }

    @Override
    @NotNull
    @Generated
    public EnumUserPremium getPremium() {
        return this.premium;
    }
}

