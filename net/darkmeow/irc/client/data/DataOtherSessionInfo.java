/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.irc.client.data;

import java.util.UUID;
import lombok.Generated;
import net.darkmeow.irc.client.data.DataSessionInfo;
import net.darkmeow.irc.client.interfaces.data.IRCDataOtherSessionInfo;
import net.darkmeow.irc.data.DataSkin;
import net.darkmeow.irc.data.DataUser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DataOtherSessionInfo
extends DataSessionInfo
implements IRCDataOtherSessionInfo {
    public long lastUpdate;
    @Nullable
    public DataUser info;
    @Nullable
    public DataSkin skin;

    public DataOtherSessionInfo(UUID clientUniqueId) {
        super(clientUniqueId);
        this.valid = false;
        this.lastUpdate = System.currentTimeMillis();
        this.info = null;
    }

    public void update(@NotNull DataUser info) {
        this.valid = true;
        this.lastUpdate = System.currentTimeMillis();
        this.info = info;
    }

    public void update(@Nullable DataSkin skin) {
        this.valid = true;
        this.lastUpdate = System.currentTimeMillis();
        this.skin = skin;
    }

    @Override
    @Nullable
    @Generated
    public DataUser getInfo() {
        return this.info;
    }

    @Override
    @Nullable
    @Generated
    public DataSkin getSkin() {
        return this.skin;
    }
}

