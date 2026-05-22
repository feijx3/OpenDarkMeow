/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.irc.client.manager;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import net.darkmeow.irc.client.data.DataOtherSessionInfo;
import net.darkmeow.irc.client.data.DataSelfSessionInfo;
import net.darkmeow.irc.client.interfaces.data.IRCDataOtherSessionInfo;
import net.darkmeow.irc.client.interfaces.data.IRCDataSelfSessionInfo;
import net.darkmeow.irc.client.interfaces.manager.IRCSessionManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SessionManager
implements IRCSessionManager {
    @Nullable
    public UUID sessionId;
    @Nullable
    public DataSelfSessionInfo self;
    @NotNull
    public ConcurrentHashMap<UUID, DataOtherSessionInfo> users = new ConcurrentHashMap();

    public void clearInvalidUsers() {
        this.users.entrySet().removeIf(entry -> !((DataOtherSessionInfo)entry.getValue()).isValid());
    }

    public void reset(UUID sessionId) {
        this.self = null;
        this.users.forEach((uuid, info) -> info.markInvalid());
        this.users.clear();
        this.sessionId = sessionId;
    }

    @Override
    @Nullable
    public IRCDataSelfSessionInfo getSelfSession() {
        return this.self;
    }

    @Override
    @NotNull
    public ConcurrentHashMap<UUID, ? extends IRCDataOtherSessionInfo> getSessions() {
        return this.users;
    }

    @Override
    @Nullable
    @Generated
    public UUID getSessionId() {
        return this.sessionId;
    }
}

