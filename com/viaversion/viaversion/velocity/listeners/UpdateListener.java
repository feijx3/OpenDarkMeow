/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.velocitypowered.api.event.Subscribe
 *  com.velocitypowered.api.event.connection.PostLoginEvent
 *  com.velocitypowered.api.proxy.Player
 */
package com.viaversion.viaversion.velocity.listeners;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PostLoginEvent;
import com.velocitypowered.api.proxy.Player;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.update.UpdateUtil;

public class UpdateListener {
    @Subscribe
    public void onJoin(PostLoginEvent e2) {
        Player player = e2.getPlayer();
        if (player.hasPermission("viaversion.update") && Via.getConfig().isCheckForUpdates()) {
            UserConnection connection = Via.getManager().getConnectionManager().getServerConnection(player.getUniqueId());
            UpdateUtil.sendUpdateMessage(connection);
        }
    }
}

