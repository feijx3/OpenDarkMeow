/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.protocols.v1_20to1_20_2.storage;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ServerboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.Protocol1_20To1_20_2;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={ClientInformation.class, QueuedPacket.class, BridgePhase.class})
public class ConfigurationState
implements StorableObject {
    private static final QueuedPacket[] EMPTY_PACKET_ARRAY = new QueuedPacket[0];
    private final List<QueuedPacket> packetQueue = new ArrayList<QueuedPacket>();
    private BridgePhase bridgePhase = BridgePhase.NONE;
    private QueuedPacket joinGamePacket;
    private boolean queuedJoinGame;
    private CompoundTag lastDimensionRegistry;
    private ClientInformation clientInformation;

    public BridgePhase bridgePhase() {
        return this.bridgePhase;
    }

    public void setBridgePhase(BridgePhase bridgePhase) {
        this.bridgePhase = bridgePhase;
    }

    public @Nullable CompoundTag lastDimensionRegistry() {
        return this.lastDimensionRegistry;
    }

    public boolean setLastDimensionRegistry(CompoundTag dimensionRegistry) {
        boolean equals = Objects.equals(this.lastDimensionRegistry, dimensionRegistry);
        this.lastDimensionRegistry = dimensionRegistry;
        return !equals;
    }

    public void setClientInformation(ClientInformation clientInformation) {
        this.clientInformation = clientInformation;
    }

    public void addPacketToQueue(PacketWrapper wrapper, boolean clientbound) {
        this.packetQueue.add(this.toQueuedPacket(wrapper, clientbound, false));
    }

    private QueuedPacket toQueuedPacket(PacketWrapper wrapper, boolean clientbound, boolean skipCurrentPipeline) {
        ByteBuf copy = Unpooled.buffer();
        PacketType packetType = wrapper.getPacketType();
        int packetId = wrapper.getId();
        wrapper.setId(-1);
        wrapper.writeToBuffer(copy);
        return new QueuedPacket(copy, clientbound, packetType, packetId, skipCurrentPipeline);
    }

    public void setJoinGamePacket(PacketWrapper wrapper) {
        this.joinGamePacket = this.toQueuedPacket(wrapper, true, true);
        this.queuedJoinGame = true;
    }

    @Override
    public void onRemove() {
        for (QueuedPacket packet : this.packetQueue) {
            packet.buf().release();
        }
        if (this.joinGamePacket != null) {
            this.joinGamePacket.buf().release();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void sendQueuedPackets(UserConnection connection) {
        PacketWrapper clientInformationPacket;
        boolean hasJoinGamePacket;
        boolean bl2 = hasJoinGamePacket = this.joinGamePacket != null;
        if (hasJoinGamePacket) {
            this.packetQueue.add(0, this.joinGamePacket);
            this.joinGamePacket = null;
        }
        if ((clientInformationPacket = this.clientInformationPacket(connection)) != null) {
            this.packetQueue.add(hasJoinGamePacket ? 1 : 0, this.toQueuedPacket(clientInformationPacket, false, true));
        }
        QueuedPacket[] queuedPackets = this.packetQueue.toArray(EMPTY_PACKET_ARRAY);
        this.packetQueue.clear();
        for (QueuedPacket packet : queuedPackets) {
            try {
                PacketWrapper queuedWrapper = packet.packetType() != null ? PacketWrapper.create(packet.packetType(), packet.buf(), connection) : PacketWrapper.create(packet.packetId(), packet.buf(), connection);
                if (packet.clientbound()) {
                    queuedWrapper.send(Protocol1_20To1_20_2.class, packet.skipCurrentPipeline());
                    continue;
                }
                queuedWrapper.sendToServer(Protocol1_20To1_20_2.class, packet.skipCurrentPipeline());
            }
            finally {
                packet.buf().release();
            }
        }
    }

    public void clear() {
        this.packetQueue.clear();
        this.bridgePhase = BridgePhase.NONE;
        this.queuedJoinGame = false;
    }

    public boolean queuedOrSentJoinGame() {
        return this.queuedJoinGame;
    }

    public @Nullable PacketWrapper clientInformationPacket(UserConnection connection) {
        if (this.clientInformation == null) {
            return null;
        }
        PacketWrapper settingsPacket = PacketWrapper.create(ServerboundPackets1_19_4.CLIENT_INFORMATION, connection);
        settingsPacket.write(Types.STRING, this.clientInformation.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$get$language());
        settingsPacket.write(Types.BYTE, this.clientInformation.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$get$viewDistance());
        settingsPacket.write(Types.VAR_INT, this.clientInformation.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$get$chatVisibility());
        settingsPacket.write(Types.BOOLEAN, this.clientInformation.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$get$showChatColors());
        settingsPacket.write(Types.UNSIGNED_BYTE, this.clientInformation.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$get$modelCustomization());
        settingsPacket.write(Types.VAR_INT, this.clientInformation.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$get$mainHand());
        settingsPacket.write(Types.BOOLEAN, this.clientInformation.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$get$textFiltering());
        settingsPacket.write(Types.BOOLEAN, this.clientInformation.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$get$allowListing());
        return settingsPacket;
    }

    @NestHost(value=ConfigurationState.class)
    public static enum BridgePhase {
        NONE,
        PROFILE_SENT,
        CONFIGURATION,
        REENTERING_CONFIGURATION;

    }

    @NestHost(value=ConfigurationState.class)
    public static final class ClientInformation {
        private final String language;
        private final byte viewDistance;
        private final int chatVisibility;
        private final boolean showChatColors;
        private final short modelCustomization;
        private final int mainHand;
        private final boolean textFiltering;
        private final boolean allowListing;

        public ClientInformation(String language, byte viewDistance, int chatVisibility, boolean showChatColors, short modelCustomization, int mainHand, boolean textFiltering, boolean allowListing) {
            this.language = language;
            this.viewDistance = viewDistance;
            this.chatVisibility = chatVisibility;
            this.showChatColors = showChatColors;
            this.modelCustomization = modelCustomization;
            this.mainHand = mainHand;
            this.textFiltering = textFiltering;
            this.allowListing = allowListing;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$get$mainHand() {
            return this.mainHand;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$set$mainHand(int n2) {
            this.mainHand = n2;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$get$chatVisibility() {
            return this.chatVisibility;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$set$chatVisibility(int n2) {
            this.chatVisibility = n2;
        }

        public boolean jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$get$textFiltering() {
            return this.textFiltering;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$set$textFiltering(boolean bl2) {
            this.textFiltering = bl2;
        }

        public boolean jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$get$showChatColors() {
            return this.showChatColors;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$set$showChatColors(boolean bl2) {
            this.showChatColors = bl2;
        }

        public String jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$get$language() {
            return this.language;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$set$language(String string) {
            this.language = string;
        }

        public boolean jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$get$allowListing() {
            return this.allowListing;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$set$allowListing(boolean bl2) {
            this.allowListing = bl2;
        }

        public short jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$get$modelCustomization() {
            return this.modelCustomization;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$set$modelCustomization(short s2) {
            this.modelCustomization = s2;
        }

        public byte jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$get$viewDistance() {
            return this.viewDistance;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_ConfigurationState$ClientInformation$set$viewDistance(byte by2) {
            this.viewDistance = by2;
        }
    }

    @NestHost(value=ConfigurationState.class)
    public static final class QueuedPacket {
        private final ByteBuf buf;
        private final boolean clientbound;
        private final PacketType packetType;
        private final int packetId;
        private final boolean skipCurrentPipeline;

        QueuedPacket(ByteBuf buf, boolean clientbound, PacketType packetType, int packetId, boolean skipCurrentPipeline) {
            this.buf = buf;
            this.clientbound = clientbound;
            this.packetType = packetType;
            this.packetId = packetId;
            this.skipCurrentPipeline = skipCurrentPipeline;
        }

        public ByteBuf buf() {
            return this.buf;
        }

        public boolean clientbound() {
            return this.clientbound;
        }

        public int packetId() {
            return this.packetId;
        }

        public @Nullable PacketType packetType() {
            return this.packetType;
        }

        public boolean skipCurrentPipeline() {
            return this.skipCurrentPipeline;
        }
    }
}

