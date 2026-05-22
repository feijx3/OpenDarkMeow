/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.platform;

import com.viaversion.viaversion.api.ViaAPI;
import com.viaversion.viaversion.api.configuration.ViaVersionConfig;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.platform.PlatformTask;
import com.viaversion.viaversion.api.platform.UnsupportedSoftware;
import com.viaversion.viaversion.libs.gson.JsonObject;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Logger;

public interface ViaPlatform<T> {
    public Logger getLogger();

    public String getPlatformName();

    public String getPlatformVersion();

    default public boolean isProxy() {
        return false;
    }

    public String getPluginVersion();

    public PlatformTask runAsync(Runnable var1);

    public PlatformTask runRepeatingAsync(Runnable var1, long var2);

    public PlatformTask runSync(Runnable var1);

    public PlatformTask runSync(Runnable var1, long var2);

    public PlatformTask runRepeatingSync(Runnable var1, long var2);

    default public void sendMessage(UserConnection connection, String message) {
        throw new UnsupportedOperationException("ViaPlatform#sendMessage is not implemented on this platform.");
    }

    default public boolean kickPlayer(UserConnection connection, String message) {
        throw new UnsupportedOperationException("ViaPlatform#kickPlayer is not implemented on this platform.");
    }

    default public void sendCustomPayload(UserConnection connection, String channel, byte[] message) {
        throw new UnsupportedOperationException("ViaPlatform#sendCustomPayload is not implemented on this platform.");
    }

    public ViaAPI<T> getApi();

    public ViaVersionConfig getConf();

    public File getDataFolder();

    default public void onReload() {
    }

    default public JsonObject getDump() {
        return new JsonObject();
    }

    default public Collection<UnsupportedSoftware> getUnsupportedSoftwareClasses() {
        return Collections.emptyList();
    }

    public boolean hasPlugin(String var1);

    default public boolean couldBeReloading() {
        return true;
    }
}

