/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.irc.client.listener;

import java.util.Set;
import java.util.UUID;
import net.darkmeow.irc.client.enums.EnumDisconnectType;
import net.darkmeow.irc.client.interfaces.IRCClientProvider;
import net.darkmeow.irc.client.interfaces.data.IRCDataOtherSessionInfo;
import net.darkmeow.irc.client.interfaces.data.IRCDataSelfSessionInfo;
import net.darkmeow.irc.network.FriendBuffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IRCClientListenableProvide {
    public void onReadyLogin(IRCClientProvider var1);

    public void onUpdateSession(@NotNull String var1);

    public void onUpdateUserInfo(@NotNull IRCDataSelfSessionInfo var1, boolean var2);

    public void onUpdateSessionSkin(@NotNull IRCDataOtherSessionInfo var1);

    public void onMessagePublic(@NotNull IRCDataOtherSessionInfo var1, @NotNull String var2);

    public void onMessagePrivate(@NotNull IRCDataOtherSessionInfo var1, @NotNull String var2);

    public void onUpdateOtherInputs(@NotNull Set<UUID> var1, @NotNull Set<UUID> var2);

    public void onPrivateMessageSendSuccess(@NotNull String var1, @NotNull String var2);

    public void onPrivateMessageSendFailed(@NotNull String var1);

    public void onMessageSystem(@NotNull String var1);

    public void onCustomPayload(@NotNull String var1, @NotNull FriendBuffer var2);

    public void onDisconnect(@NotNull EnumDisconnectType var1, @Nullable String var2, boolean var3);
}

