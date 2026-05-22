/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerJoinEvent
 */
package com.viaversion.viaversion.bukkit.listeners;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.update.UpdateUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class UpdateListener
implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e2) {
        Player player = e2.getPlayer();
        if (player.hasPermission("viaversion.update") && Via.getConfig().isCheckForUpdates()) {
            UserConnection connection = Via.getManager().getConnectionManager().getServerConnection(player.getUniqueId());
            UpdateUtil.sendUpdateMessage(connection);
        }
    }
}

