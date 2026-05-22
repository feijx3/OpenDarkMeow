/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client.interfaces.data;

import net.darkmeow.irc.client.interfaces.data.IRCDataSessionInfo;
import net.darkmeow.irc.data.enmus.EnumUserPremium;
import org.jetbrains.annotations.NotNull;

public interface IRCDataSelfSessionInfo
extends IRCDataSessionInfo {
    @NotNull
    public String getName();

    @NotNull
    public EnumUserPremium getPremium();

    public boolean getIsInvisible();
}

