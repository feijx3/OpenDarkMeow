/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.irc.client.interfaces.data;

import net.darkmeow.irc.client.interfaces.data.IRCDataSessionInfo;
import net.darkmeow.irc.data.DataSkin;
import net.darkmeow.irc.data.DataUser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IRCDataOtherSessionInfo
extends IRCDataSessionInfo {
    @NotNull
    public DataUser getInfo();

    @Nullable
    public DataSkin getSkin();
}

