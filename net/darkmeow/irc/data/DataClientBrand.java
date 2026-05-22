/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.data;

import lombok.Generated;
import org.jetbrains.annotations.NotNull;

public class DataClientBrand {
    @NotNull
    private final String name;
    @NotNull
    private final String versionText;
    private final int versionId;

    public DataClientBrand(@NotNull String name, @NotNull String versionText, int versionId) {
        this.name = name;
        this.versionText = versionText;
        this.versionId = versionId;
    }

    @NotNull
    @Generated
    public String getName() {
        return this.name;
    }

    @NotNull
    @Generated
    public String getVersionText() {
        return this.versionText;
    }

    @Generated
    public int getVersionId() {
        return this.versionId;
    }
}

