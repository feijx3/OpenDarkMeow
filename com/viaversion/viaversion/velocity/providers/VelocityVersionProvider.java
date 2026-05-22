/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.velocitypowered.api.network.ProtocolVersion
 *  com.velocitypowered.api.proxy.ServerConnection
 *  io.netty.channel.ChannelHandler
 *  org.jetbrains.annotations.Nullable
 */
package com.viaversion.viaversion.velocity.providers;

import com.velocitypowered.api.proxy.ServerConnection;
import com.viaversion.viaversion.VelocityPlugin;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.protocol.version.VersionProvider;
import com.viaversion.viaversion.velocity.platform.VelocityViaInjector;
import io.netty.channel.ChannelHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.stream.IntStream;
import org.jetbrains.annotations.Nullable;

public class VelocityVersionProvider
implements VersionProvider {
    private static final Method GET_ASSOCIATION = VelocityVersionProvider.getAssociationMethod();

    @Nullable
    private static Method getAssociationMethod() {
        try {
            return Class.forName("com.velocitypowered.proxy.connection.MinecraftConnection").getMethod("getAssociation", new Class[0]);
        }
        catch (ClassNotFoundException | NoSuchMethodException e2) {
            Via.getPlatform().getLogger().log(Level.SEVERE, "Failed to get association method from Velocity, please report this issue on our GitHub.", e2);
            return null;
        }
    }

    @Override
    public ProtocolVersion getClosestServerProtocol(UserConnection user) throws Exception {
        return user.isClientSide() ? this.getBackProtocol(user) : this.getFrontProtocol(user);
    }

    private ProtocolVersion getBackProtocol(UserConnection user) throws Exception {
        ChannelHandler mcHandler = user.getChannel().pipeline().get("handler");
        ServerConnection serverConnection = (ServerConnection)GET_ASSOCIATION.invoke(mcHandler, new Object[0]);
        return Via.proxyPlatform().protocolDetectorService().serverProtocolVersion(serverConnection.getServerInfo().getName());
    }

    private ProtocolVersion getFrontProtocol(UserConnection user) throws Exception {
        int[] compatibleProtocols;
        ProtocolVersion playerVersion = user.getProtocolInfo().protocolVersion();
        IntStream versions = com.velocitypowered.api.network.ProtocolVersion.SUPPORTED_VERSIONS.stream().mapToInt(com.velocitypowered.api.network.ProtocolVersion::getProtocol);
        if (VelocityViaInjector.GET_PLAYER_INFO_FORWARDING_MODE != null && ((Enum)VelocityViaInjector.GET_PLAYER_INFO_FORWARDING_MODE.invoke(VelocityPlugin.PROXY.getConfiguration(), new Object[0])).name().equals("MODERN")) {
            versions = versions.filter(ver -> ver >= ProtocolVersion.v1_13.getVersion());
        }
        if (Arrays.binarySearch(compatibleProtocols = versions.toArray(), playerVersion.getVersion()) >= 0) {
            return playerVersion;
        }
        if (playerVersion.getVersion() < compatibleProtocols[0]) {
            return ProtocolVersion.getProtocol(compatibleProtocols[0]);
        }
        for (int i2 = compatibleProtocols.length - 1; i2 >= 0; --i2) {
            int protocol = compatibleProtocols[i2];
            if (playerVersion.getVersion() <= protocol || !ProtocolVersion.isRegistered(protocol)) continue;
            return ProtocolVersion.getProtocol(protocol);
        }
        Via.getPlatform().getLogger().severe(VelocityVersionProvider.jvmdowngrader$concat$getFrontProtocol$1(String.valueOf(playerVersion)));
        return playerVersion;
    }

    private static String jvmdowngrader$concat$getFrontProtocol$1(String string) {
        return "Panic, no protocol id found for " + string;
    }
}

