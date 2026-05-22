/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.Unpooled
 *  net.minecraft.network.Packet
 *  net.minecraft.network.PacketBuffer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client.clientspoof.impl;

import io.netty.buffer.Unpooled;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.features.module.modules.client.clientspoof.ClientSpoofMode;
import net.ccbluex.liquidbounce.injection.access.network.AccessorCPacketCustomPayload;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/clientspoof/impl/ClientSpoofModeClientBrand;", "Lnet/ccbluex/liquidbounce/features/module/modules/client/clientspoof/ClientSpoofMode;", "<init>", "()V", "clientBrandStringValue", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "DarkMeow"})
public final class ClientSpoofModeClientBrand
extends ClientSpoofMode {
    @NotNull
    private final TextValue clientBrandStringValue = new TextValue(this.getValuePrefix() + "String", "vanilla");

    public ClientSpoofModeClientBrand() {
        super("ClientBrand");
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof AccessorCPacketCustomPayload && Intrinsics.areEqual(((AccessorCPacketCustomPayload)packet).getChannel(), "MC|Brand")) {
            ((AccessorCPacketCustomPayload)packet).setData(new PacketBuffer(Unpooled.buffer()).func_180714_a((String)this.clientBrandStringValue.get()));
        }
    }
}

