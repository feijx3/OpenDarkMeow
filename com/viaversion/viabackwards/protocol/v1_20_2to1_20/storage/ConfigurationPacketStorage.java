/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.protocol.v1_20_2to1_20.storage;

import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.protocol.v1_20_2to1_20.Protocol1_20_2To1_20;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={QueuedPacket.class})
public final class ConfigurationPacketStorage
implements StorableObject {
    private final List<QueuedPacket> rawPackets = new ArrayList<QueuedPacket>();
    private CompoundTag registry;
    private String[] enabledFeatures;
    private boolean finished;
    private QueuedPacket resourcePack;

    public void setResourcePack(PacketWrapper wrapper) {
        this.resourcePack = this.toQueuedPacket(wrapper, ClientboundPackets1_19_4.RESOURCE_PACK);
    }

    public CompoundTag registry() {
        Preconditions.checkNotNull((Object)this.registry);
        return this.registry;
    }

    public void setRegistry(CompoundTag registry) {
        this.registry = registry;
    }

    public String @Nullable [] enabledFeatures() {
        return this.enabledFeatures;
    }

    public void setEnabledFeatures(String[] enabledFeatures) {
        this.enabledFeatures = enabledFeatures;
    }

    public void addRawPacket(PacketWrapper wrapper, PacketType type) {
        this.rawPackets.add(this.toQueuedPacket(wrapper, type));
    }

    private QueuedPacket toQueuedPacket(PacketWrapper wrapper, PacketType type) {
        Preconditions.checkArgument((!wrapper.isCancelled() ? 1 : 0) != 0, (Object)"Wrapper should be cancelled AFTER calling toQueuedPacket");
        ByteBuf buf = Unpooled.buffer();
        wrapper.setId(-1);
        wrapper.writeToBuffer(buf);
        return new QueuedPacket(buf, type);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void sendQueuedPackets(UserConnection connection) {
        List<QueuedPacket> packets = this.rawPackets;
        if (this.resourcePack != null) {
            packets = new ArrayList<QueuedPacket>(this.rawPackets);
            packets.add(this.resourcePack);
            this.resourcePack = null;
        }
        for (QueuedPacket queuedPacket : packets) {
            ByteBuf buf = queuedPacket.buf().copy();
            try {
                PacketWrapper packet = PacketWrapper.create(queuedPacket.packetType(), buf, connection);
                packet.send(Protocol1_20_2To1_20.class);
            }
            finally {
                buf.release();
            }
        }
    }

    public boolean isFinished() {
        return this.finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @RecordComponents(value={@RecordComponents.Value(name="buf", type=ByteBuf.class), @RecordComponents.Value(name="packetType", type=PacketType.class)})
    @NestHost(value=ConfigurationPacketStorage.class)
    public static final class QueuedPacket
    extends J_L_Record {
        private final ByteBuf buf;
        private final PacketType packetType;

        public QueuedPacket(ByteBuf buf, PacketType packetType) {
            this.buf = buf;
            this.packetType = packetType;
        }

        @Override
        public final String toString() {
            return QueuedPacket.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return QueuedPacket.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return QueuedPacket.jvmdowngrader$equals$equals(this, o2);
        }

        public ByteBuf buf() {
            return this.buf;
        }

        public PacketType packetType() {
            return this.packetType;
        }

        private static String jvmdowngrader$toString$toString(QueuedPacket queuedPacket) {
            QueuedPacket queuedPacket2 = queuedPacket;
            return "ConfigurationPacketStorage$QueuedPacket[" + "buf=" + queuedPacket.buf + ", " + "packetType=" + queuedPacket.packetType + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(QueuedPacket queuedPacket) {
            Object[] objectArray = new Object[]{queuedPacket.buf, queuedPacket.packetType};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(QueuedPacket queuedPacket, Object object) {
            if (queuedPacket == object) {
                return true;
            }
            if (object != null && object instanceof QueuedPacket) {
                QueuedPacket queuedPacket2 = (QueuedPacket)object;
                if (Objects.equals(queuedPacket.buf, queuedPacket2.buf) && Objects.equals(queuedPacket.packetType, queuedPacket2.packetType)) {
                    return true;
                }
            }
            return false;
        }
    }
}

