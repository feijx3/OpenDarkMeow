/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.irc.network;

import java.util.ArrayList;
import java.util.EnumMap;
import net.darkmeow.irc.network.EnumPacketDirection;
import net.darkmeow.irc.network.FriendBuffer;
import net.darkmeow.irc.network.packet.Packet;
import net.darkmeow.irc.network.packet.handshake.c2s.C2SPacketEncryptionResponse;
import net.darkmeow.irc.network.packet.handshake.c2s.C2SPacketHandShake;
import net.darkmeow.irc.network.packet.handshake.s2c.S2CPacketDenyHandShake;
import net.darkmeow.irc.network.packet.handshake.s2c.S2CPacketEnableCompression;
import net.darkmeow.irc.network.packet.handshake.s2c.S2CPacketEncryptionRequest;
import net.darkmeow.irc.network.packet.handshake.s2c.S2CPacketHandShakeSuccess;
import net.darkmeow.irc.network.packet.handshake.s2c.S2CPacketRedirectServer;
import net.darkmeow.irc.network.packet.handshake.s2c.S2CPacketServerInfo;
import net.darkmeow.irc.network.packet.login.c2s.C2SPacketLogin;
import net.darkmeow.irc.network.packet.login.s2c.S2CPacketLoginFailed;
import net.darkmeow.irc.network.packet.login.s2c.S2CPacketLoginSuccess;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketCustomPayload;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketInputStatus;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketKeepAlive;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketLogout;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketMessage;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketQuerySessions;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketQuerySkin;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketUpdatePassword;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketUploadSkin;
import net.darkmeow.irc.network.packet.online.c2s.C2SPacketUploadState;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketCustomPayload;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketDisconnect;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketKeepAlive;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketOtherInputState;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketPrivateMessageResult;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketSessionMessage;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketSystemMessage;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketUpdateMyProfile;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketUpdateSessionState;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketUpdateSessionStateMulti;
import net.darkmeow.irc.network.packet.online.s2c.S2CPacketUpdateSkin;
import org.jetbrains.annotations.Nullable;

public enum EnumConnectionState {
    HANDSHAKING(0){
        {
            this.registerPacket(EnumPacketDirection.SERVER_BOUND, C2SPacketHandShake.class);
            this.registerPacket(EnumPacketDirection.SERVER_BOUND, C2SPacketEncryptionResponse.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketHandShakeSuccess.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketEncryptionRequest.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketEnableCompression.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketRedirectServer.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketDenyHandShake.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketServerInfo.class);
        }
    }
    ,
    LOGIN(1){
        {
            this.registerPacket(EnumPacketDirection.SERVER_BOUND, C2SPacketLogin.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketLoginFailed.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketLoginSuccess.class);
        }
    }
    ,
    ONLINE(2){
        {
            this.registerPacket(EnumPacketDirection.SERVER_BOUND, C2SPacketKeepAlive.class);
            this.registerPacket(EnumPacketDirection.SERVER_BOUND, C2SPacketMessage.class);
            this.registerPacket(EnumPacketDirection.SERVER_BOUND, C2SPacketInputStatus.class);
            this.registerPacket(EnumPacketDirection.SERVER_BOUND, C2SPacketUploadState.class);
            this.registerPacket(EnumPacketDirection.SERVER_BOUND, C2SPacketQuerySessions.class);
            this.registerPacket(EnumPacketDirection.SERVER_BOUND, C2SPacketUploadSkin.class);
            this.registerPacket(EnumPacketDirection.SERVER_BOUND, C2SPacketQuerySkin.class);
            this.registerPacket(EnumPacketDirection.SERVER_BOUND, C2SPacketLogout.class);
            this.registerPacket(EnumPacketDirection.SERVER_BOUND, C2SPacketUpdatePassword.class);
            this.registerPacket(EnumPacketDirection.SERVER_BOUND, C2SPacketCustomPayload.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketKeepAlive.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketSessionMessage.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketSystemMessage.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketPrivateMessageResult.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketOtherInputState.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketUpdateMyProfile.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketUpdateSessionState.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketUpdateSessionStateMulti.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketUpdateSkin.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketDisconnect.class);
            this.registerPacket(EnumPacketDirection.CLIENT_BOUND, S2CPacketCustomPayload.class);
        }
    };

    private final int id;
    private final EnumMap<EnumPacketDirection, ArrayList<Class<? extends Packet>>> directionMaps = new EnumMap(EnumPacketDirection.class);

    private EnumConnectionState(int protocolId) {
        this.id = protocolId;
    }

    protected void registerPacket(EnumPacketDirection direction, Class<? extends Packet> packetClass) {
        ArrayList directionMap = this.directionMaps.computeIfAbsent(direction, k2 -> new ArrayList());
        if (directionMap.contains(packetClass)) {
            throw new IllegalArgumentException("Packet class " + packetClass + " is already registered.");
        }
        directionMap.add(packetClass);
    }

    public int getPacketId(EnumPacketDirection direction, Packet packetIn) throws IllegalArgumentException {
        int id = this.directionMaps.get((Object)direction).indexOf(packetIn.getClass());
        if (id < 0) {
            throw new IllegalArgumentException("Unknown packet " + packetIn.getClass() + ".");
        }
        return id;
    }

    @Nullable
    public Class<? extends Packet> getPacketClassById(EnumPacketDirection direction, int packetId) {
        try {
            return this.directionMaps.get((Object)direction).get(packetId);
        }
        catch (Exception e2) {
            return null;
        }
    }

    @Nullable
    public Packet newPacketClassById(EnumPacketDirection direction, int packetId, FriendBuffer buffer) throws Exception {
        Class<? extends Packet> clazz = this.getPacketClassById(direction, packetId);
        return clazz == null ? null : clazz.getConstructor(FriendBuffer.class).newInstance(buffer);
    }
}

