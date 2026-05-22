/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.data;

import java.util.UUID;
import lombok.Generated;
import net.darkmeow.irc.data.DataPlayInGameProfile;
import org.jetbrains.annotations.NotNull;

public class DataUserState {
    public static final String SERVER_SINGLE_PLAY = "SinglePlay";
    public static final String SERVER_DISCONNECTED = "Disconnected";
    public static final DataUserState EMPTY = new DataUserState(new DataPlayInGameProfile("", new UUID(0L, 0L)), "Disconnected", 0, false);
    @NotNull
    private final DataPlayInGameProfile profile;
    @NotNull
    private final String currentServer;
    private final int clientFps;
    private final boolean friend;

    public DataUserState(@NotNull DataPlayInGameProfile profile, @NotNull String currentServer, int clientFps, boolean friend) {
        this.profile = profile;
        this.currentServer = currentServer;
        this.clientFps = clientFps;
        this.friend = friend;
    }

    @NotNull
    @Generated
    public DataPlayInGameProfile getProfile() {
        return this.profile;
    }

    @NotNull
    @Generated
    public String getCurrentServer() {
        return this.currentServer;
    }

    @Generated
    public int getClientFps() {
        return this.clientFps;
    }

    @Generated
    public boolean isFriend() {
        return this.friend;
    }
}

