/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.velocitypowered.api.event.Subscribe
 *  com.velocitypowered.api.event.connection.PluginMessageEvent
 *  com.velocitypowered.api.event.connection.PluginMessageEvent$ForwardResult
 *  com.velocitypowered.api.event.player.ServerPostConnectEvent
 *  com.velocitypowered.api.event.proxy.ProxyInitializeEvent
 *  com.velocitypowered.api.proxy.messages.ChannelIdentifier
 *  com.velocitypowered.api.proxy.messages.MinecraftChannelIdentifier
 */
package com.viaversion.viaversion.velocity.listeners;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PluginMessageEvent;
import com.velocitypowered.api.event.player.ServerPostConnectEvent;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.proxy.messages.ChannelIdentifier;
import com.velocitypowered.api.proxy.messages.MinecraftChannelIdentifier;
import com.viaversion.viaversion.VelocityPlugin;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.connection.ConnectionDetails;

public class ConnectionDetailsListener {
    private static final MinecraftChannelIdentifier CHANNEL = MinecraftChannelIdentifier.from((String)"vv:proxy_details");

    @Subscribe
    public void onPostServerJoin(ServerPostConnectEvent event) {
        UserConnection connection = Via.getManager().getConnectionManager().getClientConnection(event.getPlayer().getUniqueId());
        if (connection != null) {
            ConnectionDetails.sendConnectionDetails(connection, "vv:proxy_details");
        }
    }

    @Subscribe
    public void onProxyInitialize(ProxyInitializeEvent event) {
        VelocityPlugin.PROXY.getChannelRegistrar().register(new ChannelIdentifier[]{CHANNEL});
    }

    @Subscribe
    public void onPluginMessage(PluginMessageEvent event) {
        if (CHANNEL.equals((Object)event.getIdentifier())) {
            event.setResult(PluginMessageEvent.ForwardResult.handled());
        }
    }
}

