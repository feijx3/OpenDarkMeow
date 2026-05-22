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
import org.jetbrains.annotations.NotNull;

public class DataPlayInGameProfile {
    @NotNull
    private final String name;
    @NotNull
    private final UUID id;

    public DataPlayInGameProfile(@NotNull String name, @NotNull UUID id) {
        this.name = name;
        this.id = id;
    }

    @NotNull
    @Generated
    public String getName() {
        return this.name;
    }

    @NotNull
    @Generated
    public UUID getId() {
        return this.id;
    }
}

