/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.velocitypowered.api.proxy.Player
 */
package com.viaversion.viaversion.velocity.storage;

import com.velocitypowered.api.proxy.Player;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.util.ReflectionUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

public class VelocityStorage
implements StorableObject {
    private final Player player;
    private List<UUID> cachedBossbar;
    private static Method getServerBossBars;
    private static Class<?> clientPlaySessionHandler;
    private static Method getMinecraftConnection;

    public VelocityStorage(Player player) {
        this.player = player;
    }

    public List<UUID> getBossbar() {
        if (this.cachedBossbar == null) {
            if (clientPlaySessionHandler == null) {
                return null;
            }
            if (getServerBossBars == null) {
                return null;
            }
            if (getMinecraftConnection == null) {
                return null;
            }
            try {
                Object connection = getMinecraftConnection.invoke(this.player, new Object[0]);
                Object sessionHandler = ReflectionUtil.invoke(connection, "getSessionHandler");
                if (clientPlaySessionHandler.isInstance(sessionHandler)) {
                    this.cachedBossbar = (List)getServerBossBars.invoke(sessionHandler, new Object[0]);
                }
            }
            catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                Via.getPlatform().getLogger().log(Level.SEVERE, "Failed to get bossbar list", e2);
            }
        }
        return this.cachedBossbar;
    }

    static {
        try {
            clientPlaySessionHandler = Class.forName("com.velocitypowered.proxy.connection.client.ClientPlaySessionHandler");
            getServerBossBars = clientPlaySessionHandler.getDeclaredMethod("getServerBossBars", new Class[0]);
            getMinecraftConnection = Class.forName("com.velocitypowered.proxy.connection.client.ConnectedPlayer").getDeclaredMethod("getMinecraftConnection", new Class[0]);
        }
        catch (ClassNotFoundException | NoSuchMethodException e2) {
            Via.getPlatform().getLogger().log(Level.SEVERE, "Failed to initialize Velocity bossbar support, bossbars will not work.", e2);
        }
    }
}

