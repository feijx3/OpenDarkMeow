/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.Unpooled
 *  net.minecraft.network.INetHandler
 *  net.minecraft.network.Packet
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.network.play.client.CPacketCustomPayload
 *  net.minecraft.network.play.server.SPacketCustomPayload
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.packet;

import io.netty.buffer.Unpooled;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.network.play.server.SPacketCustomPayload;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u0012\u0012\u000e\b\u0001\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001a"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/packet/HytPacket;", "", "<init>", "()V", "packetType", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/packet/HytPacket$PacketType;", "getPacketType", "()Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/packet/HytPacket$PacketType;", "channel", "", "getChannel", "()Ljava/lang/String;", "byte", "Lnet/minecraft/network/PacketBuffer;", "getByte", "()Lnet/minecraft/network/PacketBuffer;", "setByte", "(Lnet/minecraft/network/PacketBuffer;)V", "build", "Lnet/minecraft/network/Packet;", "Lnet/minecraft/network/INetHandler;", "kotlin.jvm.PlatformType", "process", "", "byteBuf", "PacketType", "DarkMeow"})
public class HytPacket {
    @NotNull
    private final PacketType packetType = PacketType.CLIENT;
    @NotNull
    private final String channel;
    @NotNull
    private PacketBuffer byte = new PacketBuffer(Unpooled.buffer());

    public HytPacket() {
        this.channel = "";
    }

    @NotNull
    public PacketType getPacketType() {
        return this.packetType;
    }

    @NotNull
    public String getChannel() {
        return this.channel;
    }

    @NotNull
    public PacketBuffer getByte() {
        return this.byte;
    }

    public void setByte(@NotNull PacketBuffer packetBuffer) {
        Intrinsics.checkNotNullParameter(packetBuffer, "<set-?>");
        this.byte = packetBuffer;
    }

    @NotNull
    public Packet<? extends INetHandler> build() {
        Packet packet;
        switch (WhenMappings.$EnumSwitchMapping$0[this.getPacketType().ordinal()]) {
            case 1: {
                packet = (Packet)new CPacketCustomPayload(this.getChannel(), this.getByte());
                break;
            }
            case 2: {
                packet = (Packet)new SPacketCustomPayload(this.getChannel(), this.getByte());
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return packet;
    }

    public void process(@NotNull PacketBuffer byteBuf) {
        Intrinsics.checkNotNullParameter(byteBuf, "byteBuf");
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/packet/HytPacket$PacketType;", "", "<init>", "(Ljava/lang/String;I)V", "CLIENT", "SERVER", "DarkMeow"})
    public static final class PacketType
    extends Enum<PacketType> {
        public static final /* enum */ PacketType CLIENT = new PacketType();
        public static final /* enum */ PacketType SERVER = new PacketType();
        private static final /* synthetic */ PacketType[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static PacketType[] values() {
            return (PacketType[])$VALUES.clone();
        }

        public static PacketType valueOf(String value) {
            return Enum.valueOf(PacketType.class, value);
        }

        @NotNull
        public static EnumEntries<PacketType> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = packetTypeArray = new PacketType[]{PacketType.CLIENT, PacketType.SERVER};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[PacketType.values().length];
            try {
                nArray[PacketType.CLIENT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PacketType.SERVER.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

