/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client;

import java.util.ArrayList;
import java.util.UUID;
import net.darkmeow.irc.client.enums.EnumDisconnectType;
import net.darkmeow.irc.client.interfaces.IRCClientProvider;
import net.darkmeow.irc.client.interfaces.manager.IRCSessionManager;
import net.darkmeow.irc.client.listener.IRCClientListenableProvide;
import net.darkmeow.irc.client.manager.SessionManager;
import net.darkmeow.irc.client.network.IRCClientNetworkManager;
import net.darkmeow.irc.client.options.IRCClientOptions;
import net.darkmeow.irc.data.DataSkin;
import net.darkmeow.irc.data.DataUserState;
import net.darkmeow.irc.network.EnumConnectionState;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.login.c2s.C2SPacketLogin;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketCustomPayload;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketInputStatus;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketLogout;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketMessage;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketQuerySessions;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketQuerySkin;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketUpdatePassword;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketUploadSkin;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketUploadState;
import org.jetbrains.annotations.NotNull;

public class IRCClient
implements IRCClientProvider {
    @NotNull
    public final IRCClientListenableProvide listenable;
    @NotNull
    public final IRCClientOptions options;
    public IRCClientNetworkManager connection;
    @NotNull
    public final SessionManager sessionManager = new SessionManager();

    @NotNull
    public static IRCClientProvider newInstance(@NotNull IRCClientListenableProvide listenable, @NotNull IRCClientOptions options) {
        return new IRCClient(listenable, options);
    }

    public IRCClient(@NotNull IRCClientListenableProvide listenable, @NotNull IRCClientOptions options) {
        this.listenable = listenable;
        this.options = options;
    }

    @Override
    public void connect() throws Throwable {
        this.connection = IRCClientNetworkManager.createNetworkManagerAndConnect(this, this.options.host, this.options.port, this.options.proxy);
    }

    public void closeChannel(EnumDisconnectType type, String reason, boolean logout) {
        if (this.connection != null) {
            this.connection.close();
        }
        this.listenable.onDisconnect(type, reason, logout);
    }

    @Override
    public void disconnect(boolean destroySessionToken) {
        if (this.isConnected() && this.connection.getConnectionState() == EnumConnectionState.ONLINE) {
            this.connection.sendPacket(new C2SPacketLogout(destroySessionToken));
        }
        this.closeChannel(EnumDisconnectType.DISCONNECT_BY_USER, "", destroySessionToken);
    }

    @Override
    public boolean isConnected() {
        return this.connection != null && this.connection.isConnected();
    }

    @Override
    public boolean isLogin() {
        return this.isConnected() && this.sessionManager.self != null;
    }

    @Override
    public void login(@NotNull String username, @NotNull String password, boolean invisible) {
        if (this.isConnected() && this.connection.getConnectionState() == EnumConnectionState.LOGIN) {
            this.connection.sendPacket(new C2SPacketLogin(username, password, invisible));
        }
    }

    @Override
    @NotNull
    public IRCSessionManager getSessionManager() {
        return this.sessionManager;
    }

    @Override
    public void sendMessageToPublic(@NotNull String message) {
        if (this.isConnected() && this.connection.getConnectionState() == EnumConnectionState.ONLINE) {
            this.connection.sendPacket(new C2SPacketMessage(message));
        }
    }

    @Override
    public void sendMessageToPrivate(@NotNull String receiver, @NotNull String message) {
        if (this.isConnected() && this.connection.getConnectionState() == EnumConnectionState.ONLINE) {
            this.connection.sendPacket(new C2SPacketMessage(receiver, message));
        }
    }

    @Override
    public void sendCommand(@NotNull String root, @NotNull ArrayList<String> args) {
        if (this.isConnected() && this.connection.getConnectionState() == EnumConnectionState.ONLINE) {
            this.connection.sendPacket(new C2SPacketMessage(root, args));
        }
    }

    @Override
    public void updateInputStatus() {
        if (this.isConnected() && this.connection.getConnectionState() == EnumConnectionState.ONLINE) {
            this.connection.sendPacket(new C2SPacketInputStatus());
        }
    }

    @Override
    public void updateInputStatus(@NotNull String message) {
        if (this.isConnected() && this.connection.getConnectionState() == EnumConnectionState.ONLINE) {
            this.connection.sendPacket(new C2SPacketInputStatus(message));
        }
    }

    @Override
    public void updateInputStatus(@NotNull String receiver, @NotNull String message) {
        if (this.isConnected() && this.connection.getConnectionState() == EnumConnectionState.ONLINE) {
            this.connection.sendPacket(new C2SPacketInputStatus(receiver, message));
        }
    }

    @Override
    public void uploadState(@NotNull DataUserState state) {
        if (this.isConnected() && this.connection.getConnectionState() == EnumConnectionState.ONLINE) {
            this.connection.sendPacket(new C2SPacketUploadState(state));
        }
    }

    @Override
    public void querySkin(@NotNull UUID sessionId) {
        if (this.isConnected() && this.connection.getConnectionState() == EnumConnectionState.ONLINE) {
            this.connection.sendPacket(new C2SPacketQuerySkin(sessionId));
        }
    }

    @Override
    public void queryOnlineSessions() {
        if (this.isConnected() && this.connection.getConnectionState() == EnumConnectionState.ONLINE) {
            this.connection.sendPacket(new C2SPacketQuerySessions(false));
        }
    }

    @Override
    public void uploadSkin(@NotNull DataSkin skin) {
        if (this.isConnected() && this.connection.getConnectionState() == EnumConnectionState.ONLINE) {
            this.connection.sendPacket(new C2SPacketUploadSkin(skin));
        }
    }

    @Override
    public void updatePassword(@NotNull String newPassword) {
        if (this.isConnected() && this.connection.getConnectionState() == EnumConnectionState.ONLINE) {
            this.connection.sendPacket(new C2SPacketUpdatePassword(newPassword));
        }
    }

    @Override
    public void sendCustomPayload(@NotNull String channel, @NotNull FriendBuffer data) {
        if (this.isConnected() && this.connection.getConnectionState() == EnumConnectionState.ONLINE) {
            this.connection.sendPacket(new C2SPacketCustomPayload(channel, data));
        }
    }
}

