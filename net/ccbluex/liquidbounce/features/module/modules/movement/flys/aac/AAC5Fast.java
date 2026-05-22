/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.util.math.AxisAlignedBB
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.flys.aac;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.flys.FlyMode;
import net.ccbluex.liquidbounce.handler.movement.MovementManager;
import net.ccbluex.liquidbounce.handler.network.packet.PacketManager;
import net.ccbluex.liquidbounce.injection.access.network.AccessorCPacketPlayer;
import net.ccbluex.liquidbounce.injection.extend.ExtendTimer;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.timer.MSTimer;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.math.AxisAlignedBB;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/flys/aac/AAC5Fast;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/flys/FlyMode;", "<init>", "()V", "speedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "purseValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "packetModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "packets", "", "Lnet/ccbluex/liquidbounce/injection/access/network/AccessorCPacketPlayer;", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "flyClip", "", "flyStart", "onEnable", "", "onDisable", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "sendPackets", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAAC5Fast.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AAC5Fast.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/flys/aac/AAC5Fast\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,144:1\n1869#2,2:145\n*S KotlinDebug\n*F\n+ 1 AAC5Fast.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/flys/aac/AAC5Fast\n*L\n110#1:145,2\n*E\n"})
public final class AAC5Fast
extends FlyMode {
    @NotNull
    private final FloatValue speedValue = new FloatValue(this.getValuePrefix() + "Speed", 2.0f, 0.0f, 5.0f);
    @NotNull
    private final IntegerValue purseValue = new IntegerValue(this.getValuePrefix() + "Purse", 7, 3, 20);
    @NotNull
    private final ListValue packetModeValue;
    @NotNull
    private final List<AccessorCPacketPlayer> packets;
    @NotNull
    private final MSTimer timer;
    private boolean flyClip;
    private boolean flyStart;

    public AAC5Fast() {
        super("AAC5FastFly");
        String[] stringArray = new String[]{"Normal", "Rise"};
        this.packetModeValue = new ListValue(this.getValuePrefix() + "PacketMode", stringArray, "Normal");
        this.packets = new ArrayList();
        this.timer = new MSTimer();
    }

    @Override
    public void onEnable() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (MinecraftInstance.mc.isSingleplayer()) {
            DarkMeow.INSTANCE.getMessageManager().display.displayInfo("\u5728\u5355\u4eba\u4e16\u754c\u4f7f\u7528\u6b64AAC5\u98de\u884c\u4f1a\u5bfc\u81f4\u6e38\u620f\u5d29\u6e83\u54e6");
            this.getFly().setState(false);
            return;
        }
        this.packets.clear();
        this.flyClip = false;
        this.flyStart = false;
        this.timer.reset();
    }

    @Override
    public void onDisable() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        this.sendPackets();
        this.packets.clear();
        player.field_70145_X = false;
    }

    @Override
    public void onUpdate(@NotNull UpdateEvent event) {
        EntityPlayerSP entityPlayerSP;
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP2 = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP2 == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP2;
        this.getFly().setAntiDesync(true);
        player.field_70145_X = !MovementManager.isMoving$default(DarkMeow.INSTANCE.getMovementManager(), false, 1, null);
        EntityPlayerSP $this$onUpdate_u24lambda_u240 = entityPlayerSP = player;
        boolean bl2 = false;
        $this$onUpdate_u24lambda_u240.field_71075_bZ.field_75100_b = false;
        $this$onUpdate_u24lambda_u240.field_70159_w = 0.0;
        $this$onUpdate_u24lambda_u240.field_70181_x = 0.0;
        $this$onUpdate_u24lambda_u240.field_70179_y = 0.0;
        if (MinecraftInstance.mc.getGameSettings().field_74314_A.func_151470_d()) {
            $this$onUpdate_u24lambda_u240.field_70181_x += ((Number)this.speedValue.get()).doubleValue() * 0.5;
        }
        if (MinecraftInstance.mc.getGameSettings().field_74311_E.func_151470_d()) {
            $this$onUpdate_u24lambda_u240.field_70181_x -= ((Number)this.speedValue.get()).doubleValue() * 0.5;
        }
        DarkMeow.INSTANCE.getMovementManager().strafe(((Number)this.speedValue.get()).floatValue());
    }

    @Override
    public void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof SPacketPlayerPosLook) {
            this.flyStart = true;
            if (this.timer.hasTimePassed(2000)) {
                this.flyClip = true;
                ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), 1.3f);
            }
            event.cancelEvent();
        } else if (packet instanceof AccessorCPacketPlayer) {
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return;
            }
            EntityPlayerSP player = entityPlayerSP;
            double halfWidth = (double)player.field_70130_N / 2.0;
            if (((AccessorCPacketPlayer)packet).getY() < 4545.0721) {
                AxisAlignedBB box = new AxisAlignedBB(((AccessorCPacketPlayer)packet).getX() - halfWidth, ((AccessorCPacketPlayer)packet).getY(), ((AccessorCPacketPlayer)packet).getZ() - halfWidth, ((AccessorCPacketPlayer)packet).getX() + halfWidth, ((AccessorCPacketPlayer)packet).getY() + (double)player.field_70131_O, ((AccessorCPacketPlayer)packet).getZ() + halfWidth);
                WorldClient worldClient = MinecraftInstance.mc.getWorld();
                boolean bl2 = worldClient != null ? worldClient.func_72829_c(box) : false;
                if (bl2) {
                    return;
                }
                this.packets.add((AccessorCPacketPlayer)packet);
                event.cancelEvent();
                if (this.packets.size() > ((Number)this.purseValue.get()).intValue()) {
                    this.sendPackets();
                }
            }
        }
    }

    private final void sendPackets() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        float yaw = 0.0f;
        yaw = player.field_70177_z;
        float pitch = 0.0f;
        pitch = player.field_70125_A;
        Iterable $this$forEach$iv = this.packets;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            AccessorCPacketPlayer packet = (AccessorCPacketPlayer)element$iv;
            boolean bl2 = false;
            if (!MovementManager.isMoving$default(DarkMeow.INSTANCE.getMovementManager(), false, 1, null)) continue;
            PacketManager packetManager = DarkMeow.INSTANCE.getNetworkManager().packetManager;
            Intrinsics.checkNotNull(packet, "null cannot be cast to non-null type net.minecraft.network.Packet<*>");
            PacketManager.sendPacket$default(packetManager, (Packet)packet, true, null, 4, null);
            if (packet instanceof CPacketPlayer.PositionRotation) {
                yaw = packet.getYaw();
                pitch = packet.getPitch();
            }
            double xPos = packet.getX();
            double yPos = Intrinsics.areEqual(this.packetModeValue.get(), "Normal") ? 1.0E308 : -1.0E159;
            double zPos = Intrinsics.areEqual(this.packetModeValue.get(), "Normal") ? packet.getZ() : packet.getZ() + (double)10;
            CPacketPlayer.PositionRotation finalPacket = new CPacketPlayer.PositionRotation(xPos, yPos, zPos, yaw, pitch, true);
            PacketManager.sendPacket$default(DarkMeow.INSTANCE.getNetworkManager().packetManager, (Packet)finalPacket, true, null, 4, null);
            PacketManager.sendPacket$default(DarkMeow.INSTANCE.getNetworkManager().packetManager, (Packet)new CPacketPlayer.Position(xPos, packet.getY(), packet.getZ(), false), true, null, 4, null);
        }
        this.packets.clear();
    }
}

