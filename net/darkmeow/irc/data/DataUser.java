/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.data;

import lombok.Generated;
import net.darkmeow.irc.data.DataSkin;
import net.darkmeow.irc.data.DataUserState;
import net.darkmeow.irc.data.enmus.EnumUserPremium;
import org.jetbrains.annotations.NotNull;

public class DataUser {
    @NotNull
    private final String name;
    @NotNull
    private final EnumUserPremium premium;
    private final DataUserState state;

    public DataUser(@NotNull String name, @NotNull EnumUserPremium premium, DataUserState state) {
        this.name = name;
        this.premium = premium;
        this.state = state;
        new DataSkin(new byte[0], new byte[0], false);
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
    public DataUserState getState() {
        return this.state;
    }
}

