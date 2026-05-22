/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.Unpooled
 *  net.minecraft.network.PacketBuffer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.packet.client;

import io.netty.buffer.Unpooled;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.packet.HytPacket;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.utils.HytPacketUtils;
import net.minecraft.network.PacketBuffer;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u0003X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u000fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/packet/client/CPacketHytVexView;", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/packet/HytPacket;", "type", "", "subType", "params", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getSubType", "getParams", "channel", "getChannel", "byte", "Lnet/minecraft/network/PacketBuffer;", "getByte", "()Lnet/minecraft/network/PacketBuffer;", "setByte", "(Lnet/minecraft/network/PacketBuffer;)V", "DarkMeow"})
public final class CPacketHytVexView
extends HytPacket {
    @NotNull
    private final String type;
    @NotNull
    private final String subType;
    @NotNull
    private final String params;
    @NotNull
    private final String channel;
    @NotNull
    private PacketBuffer byte;

    public CPacketHytVexView(@NotNull String type, @NotNull String subType, @NotNull String params) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(params, "params");
        this.type = type;
        this.subType = subType;
        this.params = params;
        this.channel = "VexView";
        this.byte = new PacketBuffer(Unpooled.wrappedBuffer((byte[])HytPacketUtils.INSTANCE.encodePacketByte("{\"packet_sub_type\":\"" + this.subType + "\",\"packet_data\":\"" + this.type + "\",\"packet_type\":\"" + this.params + "\"}")));
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getSubType() {
        return this.subType;
    }

    @NotNull
    public final String getParams() {
        return this.params;
    }

    @Override
    @NotNull
    public String getChannel() {
        return this.channel;
    }

    @Override
    @NotNull
    public PacketBuffer getByte() {
        return this.byte;
    }

    @Override
    public void setByte(@NotNull PacketBuffer packetBuffer) {
        Intrinsics.checkNotNullParameter(packetBuffer, "<set-?>");
        this.byte = packetBuffer;
    }
}

