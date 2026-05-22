/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client.data;

import java.util.UUID;
import net.darkmeow.irc.client.interfaces.data.IRCDataSessionInfo;
import org.jetbrains.annotations.NotNull;

public abstract class DataSessionInfo
implements IRCDataSessionInfo {
    public final UUID uniqueId;
    public boolean valid;

    public DataSessionInfo(@NotNull UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public void markInvalid() {
        this.valid = false;
    }

    @Override
    public boolean isValid() {
        return this.valid;
    }

    @Override
    @NotNull
    public UUID getUniqueId() {
        return this.uniqueId;
    }
}

