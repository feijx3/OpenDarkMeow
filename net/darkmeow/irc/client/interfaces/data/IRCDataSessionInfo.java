/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.client.interfaces.data;

import java.util.UUID;
import org.jetbrains.annotations.NotNull;

public interface IRCDataSessionInfo {
    public boolean isValid();

    @NotNull
    public UUID getUniqueId();
}

