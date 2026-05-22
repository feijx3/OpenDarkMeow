/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.irc.client.interfaces.manager;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.darkmeow.irc.client.interfaces.data.IRCDataOtherSessionInfo;
import net.darkmeow.irc.client.interfaces.data.IRCDataSelfSessionInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IRCSessionManager {
    @Nullable
    public UUID getSessionId();

    @Nullable
    public IRCDataSelfSessionInfo getSelfSession();

    @NotNull
    public ConcurrentHashMap<UUID, ? extends IRCDataOtherSessionInfo> getSessions();
}

