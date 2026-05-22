/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client.interfaces;

import java.util.ArrayList;
import java.util.UUID;
import net.darkmeow.irc.client.interfaces.manager.IRCSessionManager;
import net.darkmeow.irc.data.DataSkin;
import net.darkmeow.irc.data.DataUserState;
import net.darkmeow.irc.network.FriendBuffer;
import org.jetbrains.annotations.NotNull;

public interface IRCClientProvider {
    public void connect() throws Throwable;

    public void disconnect(boolean var1);

    public boolean isConnected();

    public boolean isLogin();

    public void login(@NotNull String var1, @NotNull String var2, boolean var3);

    @NotNull
    public IRCSessionManager getSessionManager();

    public void sendMessageToPublic(@NotNull String var1);

    public void sendMessageToPrivate(@NotNull String var1, @NotNull String var2);

    public void sendCommand(@NotNull String var1, @NotNull ArrayList<String> var2);

    public void updateInputStatus();

    public void updateInputStatus(@NotNull String var1);

    public void updateInputStatus(@NotNull String var1, @NotNull String var2);

    public void uploadState(@NotNull DataUserState var1);

    public void querySkin(@NotNull UUID var1);

    public void queryOnlineSessions();

    public void uploadSkin(@NotNull DataSkin var1);

    public void updatePassword(@NotNull String var1);

    public void sendCustomPayload(@NotNull String var1, @NotNull FriendBuffer var2);
}

