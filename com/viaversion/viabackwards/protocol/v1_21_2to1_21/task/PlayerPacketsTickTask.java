/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.task;

import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.Protocol1_21_2To1_21;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.PlayerStorage;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.protocol.ProtocolRunnable;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.ClientVehicleStorage;
import io.netty.channel.Channel;
import java.util.logging.Level;

public final class PlayerPacketsTickTask
extends ProtocolRunnable {
    public PlayerPacketsTickTask() {
        super(Protocol1_21_2To1_21.class);
    }

    @Override
    public void run(UserConnection connection) {
        ProtocolInfo protocolInfo = connection.getProtocolInfo();
        if (protocolInfo.getClientState() != State.PLAY || protocolInfo.getServerState() != State.PLAY) {
            return;
        }
        Channel channel = connection.getChannel();
        channel.eventLoop().submit(() -> {
            if (!channel.isActive() || protocolInfo.getClientState() != State.PLAY || protocolInfo.getServerState() != State.PLAY) {
                return;
            }
            try {
                if (!connection.has(ClientVehicleStorage.class)) {
                    PlayerStorage playerStorage = connection.get(PlayerStorage.class);
                    playerStorage.tick(connection);
                }
            }
            catch (Throwable t2) {
                ViaBackwards.getPlatform().getLogger().log(Level.SEVERE, "Error while sending player input packet.", t2);
            }
            try {
                PacketWrapper clientTickEndPacket = PacketWrapper.create(ServerboundPackets1_21_2.CLIENT_TICK_END, connection);
                clientTickEndPacket.sendToServer(Protocol1_21_2To1_21.class);
            }
            catch (Throwable t3) {
                ViaBackwards.getPlatform().getLogger().log(Level.SEVERE, "Error while sending client tick end packet.", t3);
            }
        });
    }
}

