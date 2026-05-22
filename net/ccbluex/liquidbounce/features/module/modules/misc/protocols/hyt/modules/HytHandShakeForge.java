/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.Unpooled
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.network.play.client.CPacketCustomPayload
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.modules;

import io.netty.buffer.Unpooled;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.HytModule;
import net.ccbluex.liquidbounce.injection.access.network.AccessorCPacketCustomPayload;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/modules/HytHandShakeForge;", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/HytModule;", "<init>", "()V", "registerValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "process", "", "onWorld", "", "event", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nHytHandShakeForge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HytHandShakeForge.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/modules/HytHandShakeForge\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,57:1\n1#2:58\n*E\n"})
public final class HytHandShakeForge
extends HytModule {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public final BoolValue registerValue = new BoolValue(this.getValuePrefix() + "Register", false);
    private boolean process;
    @NotNull
    private static final String REGISTER_LEGIT;

    public HytHandShakeForge() {
        super("HandShakeForge");
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.process = false;
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof AccessorCPacketCustomPayload) {
            String string = ((AccessorCPacketCustomPayload)packet).getChannel();
            if (Intrinsics.areEqual(string, "MC|Brand")) {
                if (!((Boolean)this.registerValue.get()).booleanValue()) {
                    return;
                }
                NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
                if (netHandlerPlayClient == null) {
                    return;
                }
                NetHandlerPlayClient connection = netHandlerPlayClient;
                this.process = true;
                PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
                String string2 = REGISTER_LEGIT;
                byte[] byArray = string2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(byArray, "getBytes(...)");
                connection.func_147297_a((Packet)new CPacketCustomPayload("REGISTER", packetBuffer.func_179250_a(byArray)));
                this.process = false;
            } else if (Intrinsics.areEqual(string, "REGISTER")) {
                PacketEvent packetEvent;
                PacketEvent packetEvent2;
                PacketEvent it = packetEvent2 = event;
                boolean bl2 = false;
                PacketEvent packetEvent3 = packetEvent = !this.process ? packetEvent2 : null;
                if (packetEvent != null) {
                    packetEvent.cancelEvent();
                }
            }
        }
    }

    static {
        String[] stringArray = new String[]{"FML|HS", "FML", "FML|MP", "Forge", "armourers", "hyt0", "germplugin-netease", "VexView"};
        REGISTER_LEGIT = CollectionsKt.joinToString$default(CollectionsKt.mutableListOf(stringArray), "\u0000", null, null, 0, null, null, 62, null);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/modules/HytHandShakeForge$Companion;", "", "<init>", "()V", "REGISTER_LEGIT", "", "getREGISTER_LEGIT$annotations", "getREGISTER_LEGIT", "()Ljava/lang/String;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getREGISTER_LEGIT() {
            return REGISTER_LEGIT;
        }

        public static /* synthetic */ void getREGISTER_LEGIT$annotations() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

