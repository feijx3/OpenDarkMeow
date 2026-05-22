/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package net.darkmeow.irc.data;

import lombok.Generated;

public class DataSkin {
    public static DataSkin EMPTY = new DataSkin(new byte[0], new byte[0], false);
    private final byte[] skin;
    private final byte[] cape;
    private final boolean slim;

    public DataSkin(byte[] skin, byte[] cape, boolean slim) {
        this.skin = skin;
        this.cape = cape;
        this.slim = slim;
    }

    @Generated
    public byte[] getSkin() {
        return this.skin;
    }

    @Generated
    public byte[] getCape() {
        return this.cape;
    }

    @Generated
    public boolean isSlim() {
        return this.slim;
    }
}

