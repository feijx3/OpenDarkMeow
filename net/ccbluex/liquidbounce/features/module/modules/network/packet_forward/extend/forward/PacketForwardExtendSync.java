/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.util.concurrent.GenericFutureListener
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.server.SPacketAnimation
 *  net.minecraft.network.play.server.SPacketCloseWindow
 *  net.minecraft.network.play.server.SPacketCustomPayload
 *  net.minecraft.network.play.server.SPacketDisconnect
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 *  net.minecraft.network.play.server.SPacketHeldItemChange
 *  net.minecraft.network.play.server.SPacketKeepAlive
 *  net.minecraft.util.EnumHand
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.extend.forward;

import io.netty.util.concurrent.GenericFutureListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.PacketForwardChannel;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.PacketForwardExtend;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.PacketForwardUtils;
import net.ccbluex.liquidbounce.injection.access.network.AccessorCPacketCloseWindow;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.darkmeow.darkmeow.utils.network.PacketSide;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.server.SPacketAnimation;
import net.minecraft.network.play.server.SPacketCloseWindow;
import net.minecraft.network.play.server.SPacketCustomPayload;
import net.minecraft.network.play.server.SPacketDisconnect;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketHeldItemChange;
import net.minecraft.network.play.server.SPacketKeepAlive;
import net.minecraft.util.EnumHand;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/extend/forward/PacketForwardExtendSync;", "Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardExtend;", "<init>", "()V", "blockCustomPayloadValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "blockDisconnectPacketValue", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nPacketForwardExtendSync.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PacketForwardExtendSync.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/extend/forward/PacketForwardExtendSync\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,61:1\n20#2,3:62\n*S KotlinDebug\n*F\n+ 1 PacketForwardExtendSync.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/extend/forward/PacketForwardExtendSync\n*L\n29#1:62,3\n*E\n"})
public final class PacketForwardExtendSync
extends PacketForwardExtend {
    @JvmField
    @NotNull
    public final BoolValue blockCustomPayloadValue = new BoolValue("BlockCustomPayload", true);
    @JvmField
    @NotNull
    public final BoolValue blockDisconnectPacketValue = new BoolValue("BlockDisconnectPacket", true);

    /*
     * WARNING - void declaration
     */
    public PacketForwardExtendSync() {
        super("Sync", false, true, 2, null);
        void $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<SafeListenerBase, PacketEvent, Unit> function$iv = (arg_0, arg_1) -> PacketForwardExtendSync._init_$lambda$1(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookSafeOwnerCheck<PacketEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(PacketEvent.class), (ListenableOwner)$receiver$iv));
    }

    private static final Unit lambda$1$lambda$0(Packet $packet, PacketForwardChannel client) {
        Intrinsics.checkNotNullParameter(client, "client");
        client.sendPacket((Packet)new SPacketCustomPayload(((SPacketCustomPayload)$packet).func_149169_c(), new PacketBuffer(((SPacketCustomPayload)$packet).func_180735_b().copy())), new GenericFutureListener[0]);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(PacketForwardExtendSync this$0, SafeListenerBase $this$safeListener, PacketEvent event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        switch (WhenMappings.$EnumSwitchMapping$0[event.getSide().ordinal()]) {
            case 1: {
                Packet<?> packet = event.getPacket();
                if (packet instanceof SPacketCustomPayload) {
                    if (((Boolean)this$0.blockCustomPayloadValue.get()).booleanValue()) break;
                    PacketForwardUtils.INSTANCE.forEachClients(this$0.getInstance(), arg_0 -> PacketForwardExtendSync.lambda$1$lambda$0(packet, arg_0));
                    break;
                }
                if (packet instanceof SPacketDisconnect) {
                    if (((Boolean)this$0.blockDisconnectPacketValue.get()).booleanValue()) break;
                    PacketForwardUtils.INSTANCE.broadCastPacket(this$0.getInstance(), packet);
                    break;
                }
                if (packet instanceof SPacketEntityVelocity) {
                    if (((SPacketEntityVelocity)packet).func_149412_c() == $this$safeListener.getPlayer().func_145782_y()) break;
                    PacketForwardUtils.INSTANCE.broadCastPacket(this$0.getInstance(), packet);
                    break;
                }
                if (packet instanceof SPacketKeepAlive) break;
                PacketForwardUtils.INSTANCE.broadCastPacket(this$0.getInstance(), event.getPacket());
                break;
            }
            case 2: {
                Packet<?> packet = event.getPacket();
                if (packet instanceof CPacketAnimation) {
                    PacketForwardUtils.INSTANCE.broadCastPacket(this$0.getInstance(), (Packet)new SPacketAnimation((Entity)$this$safeListener.getPlayer(), ((CPacketAnimation)packet).func_187018_a() == EnumHand.MAIN_HAND ? 0 : 3));
                    break;
                }
                if (packet instanceof CPacketHeldItemChange) {
                    PacketForwardUtils.INSTANCE.broadCastPacket(this$0.getInstance(), (Packet)new SPacketHeldItemChange(((CPacketHeldItemChange)packet).func_149614_c()));
                    break;
                }
                if (!(packet instanceof AccessorCPacketCloseWindow) || ((AccessorCPacketCloseWindow)packet).getWindowId() == 0) break;
                PacketForwardUtils.INSTANCE.broadCastPacket(this$0.getInstance(), (Packet)new SPacketCloseWindow(((AccessorCPacketCloseWindow)packet).getWindowId()));
            }
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[PacketSide.values().length];
            try {
                nArray[PacketSide.SERVER.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PacketSide.CLIENT.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

