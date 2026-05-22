/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.viamcp;

import com.viaversion.viabackwards.protocol.v1_17to1_16_4.Protocol1_17To1_16_4;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ServerboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ClientboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/darkmeow/viamcp/ViaMCP;", "", "<init>", "()V", "NATIVE_VERSION", "", "initViaMCP", "", "DarkMeow"})
public final class ViaMCP {
    @NotNull
    public static final ViaMCP INSTANCE = new ViaMCP();
    public static final int NATIVE_VERSION = 340;

    private ViaMCP() {
    }

    @JvmStatic
    public static final void initViaMCP() {
        block0: {
            Protocol1_17To1_16_4 protocol1_17To1_16_4;
            ViaLoadingBase.ViaLoadingBaseBuilder.create().runDirectory(new File("ViaMCP")).nativeVersion(340).onProtocolReload(ViaMCP::initViaMCP$lambda$0).build();
            Protocol1_17To1_16_4 protocol1_17To1_16_42 = Via.getManager().getProtocolManager().getProtocol(Protocol1_17To1_16_4.class);
            if (protocol1_17To1_16_42 == null) break block0;
            Protocol1_17To1_16_4 it = protocol1_17To1_16_4 = protocol1_17To1_16_42;
            boolean bl2 = false;
            it.registerClientbound((ClientboundPacketType)ClientboundPackets1_17.PING, (ClientboundPacketType)ClientboundPackets1_16_2.CONTAINER_ACK, ViaMCP::initViaMCP$lambda$3$lambda$1, true);
            it.registerServerbound((ServerboundPacketType)ServerboundPackets1_16_2.CONTAINER_ACK, (ServerboundPacketType)ServerboundPackets1_17.PONG, ViaMCP::initViaMCP$lambda$3$lambda$2, true);
        }
    }

    private static final void initViaMCP$lambda$0(ProtocolVersion it) {
    }

    private static final void initViaMCP$lambda$3$lambda$1(PacketWrapper it) {
    }

    private static final void initViaMCP$lambda$3$lambda$2(PacketWrapper it) {
    }
}

