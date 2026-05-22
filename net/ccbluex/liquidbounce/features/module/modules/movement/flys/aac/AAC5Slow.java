/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.util.Timer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.flys.aac;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.flys.FlyMode;
import net.ccbluex.liquidbounce.injection.extend.ExtendKeyBinding;
import net.ccbluex.liquidbounce.injection.extend.ExtendTimer;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.Timer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/flys/aac/AAC5Slow;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/flys/FlyMode;", "<init>", "()V", "debugValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "status", "", "packet", "Lnet/minecraft/network/play/client/CPacketPlayer;", "packets", "", "tick", "launchYaw", "", "launchPitch", "lastPosX", "", "lastPosZ", "sameCount", "sameCountReach", "onEnable", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "onDisable", "sendPacketNoEvent", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAAC5Slow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AAC5Slow.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/flys/aac/AAC5Slow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n"})
public final class AAC5Slow
extends FlyMode {
    @NotNull
    private final BoolValue debugValue = new BoolValue("Debug", false);
    private int status;
    @Nullable
    private CPacketPlayer packet;
    @NotNull
    private final List<CPacketPlayer> packets = new ArrayList();
    private int tick;
    private float launchYaw;
    private float launchPitch;
    private double lastPosX;
    private double lastPosZ;
    private int sameCount;
    private int sameCountReach = 5;

    public AAC5Slow() {
        super("AAC5SlowFly");
    }

    @Override
    public void onEnable() {
        block2: {
            if (((Boolean)this.debugValue.get()).booleanValue()) {
                DarkMeow.INSTANCE.getMessageManager().display.displayInfo("\u5f00\u59cb\u521d\u59cb\u5316...");
            }
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) break block2;
            EntityPlayerSP player = entityPlayerSP;
            boolean bl2 = false;
            player.field_70159_w = 0.0;
            player.field_70181_x = player.field_70122_E ? 0.1 : 0.0;
            player.field_70179_y = 0.0;
            this.status = 0;
            this.lastPosX = 0.0;
            this.lastPosZ = 0.0;
            this.sameCount = 0;
            this.tick = 0;
            this.launchYaw = player.field_70177_z;
            this.launchPitch = player.field_70125_A;
            this.sameCountReach = 5;
            this.packet = null;
            this.sendPacketNoEvent((CPacketPlayer)new CPacketPlayer.Position(player.field_70165_t, Double.MAX_VALUE, player.field_70161_v, true));
            if (((Boolean)this.debugValue.get()).booleanValue()) {
                DarkMeow.INSTANCE.getMessageManager().display.displayInfo("\u521d\u59cb\u5316\u5b8c\u6210");
            }
        }
    }

    @Override
    public void onUpdate(@NotNull UpdateEvent event) {
        block7: {
            Intrinsics.checkNotNullParameter(event, "event");
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) break block7;
            EntityPlayerSP player = entityPlayerSP;
            boolean bl2 = false;
            KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74351_w;
            Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindForward");
            ExtendKeyBinding.INSTANCE.setPressed(keyBinding, this.status != 1);
            player.field_70159_w = 0.0;
            player.field_70179_y = 0.0;
            player.field_70181_x = 0.0;
            player.field_70177_z = this.launchYaw;
            player.field_70125_A = this.launchPitch;
            switch (this.status) {
                case 1: {
                    CPacketPlayer cPacketPlayer = this.packet;
                    if (cPacketPlayer != null) {
                        CPacketPlayer it = cPacketPlayer;
                        boolean bl3 = false;
                        this.sendPacketNoEvent(it);
                        double dist = 0.13;
                        double yaw = Math.toRadians(player.field_70177_z);
                        double x2 = -Math.sin(yaw) * dist;
                        double z2 = Math.cos(yaw) * dist;
                        player.func_70107_b(player.field_70165_t + x2, player.field_70163_u, player.field_70161_v + z2);
                        this.sendPacketNoEvent((CPacketPlayer)new CPacketPlayer.Position(player.field_70165_t, player.field_70163_u, player.field_70161_v, false));
                        if (((Boolean)this.debugValue.get()).booleanValue()) {
                            DarkMeow.INSTANCE.getMessageManager().display.displayInfo("\u5c1d\u8bd5\u5207\u5165 " + player.field_70165_t + ' ' + player.field_70163_u + ' ' + player.field_70161_v);
                        }
                    }
                    this.sendPacketNoEvent((CPacketPlayer)new CPacketPlayer.Position(player.field_70165_t, Double.MAX_VALUE, player.field_70161_v, true));
                    this.packet = (CPacketPlayer)new CPacketPlayer.PositionRotation(player.field_70165_t, player.field_70163_u, player.field_70161_v, player.field_70177_z, player.field_70125_A, false);
                    if (!((Boolean)this.debugValue.get()).booleanValue()) break;
                    DarkMeow.INSTANCE.getMessageManager().display.displayInfo("\u5b8c\u6210\u56de\u5f39 " + player.field_70165_t + ' ' + player.field_70163_u + ' ' + player.field_70161_v);
                    break;
                }
                case 2: {
                    int n2 = this.tick;
                    this.tick = n2 + 1;
                    if (this.tick >= 2) {
                        this.status = 1;
                        break;
                    }
                    throw new NotImplementedError(null, 1, null);
                }
            }
        }
    }

    @Override
    public void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof SPacketPlayerPosLook) {
            event.cancelEvent();
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP != null) {
                EntityPlayerSP player = entityPlayerSP;
                boolean bl2 = false;
                if (this.status == 0) {
                    player.func_70107_b(((SPacketPlayerPosLook)packet).func_148932_c(), ((SPacketPlayerPosLook)packet).func_148928_d(), ((SPacketPlayerPosLook)packet).func_148933_e());
                    this.sendPacketNoEvent((CPacketPlayer)new CPacketPlayer.PositionRotation(player.field_70165_t, player.field_70163_u, player.field_70161_v, ((SPacketPlayerPosLook)packet).func_148931_f(), ((SPacketPlayerPosLook)packet).func_148930_g(), false));
                    if (((Boolean)this.debugValue.get()).booleanValue()) {
                        DarkMeow.INSTANCE.getMessageManager().display.displayInfo("\u5b8c\u6210\u56de\u5f39 " + player.field_70165_t + ' ' + player.field_70163_u + ' ' + player.field_70161_v);
                    }
                    if (player.field_70165_t == this.lastPosX && player.field_70161_v == this.lastPosZ) {
                        int n2 = this.sameCount;
                        this.sameCount = n2 + 1;
                        if (((Boolean)this.debugValue.get()).booleanValue()) {
                            DarkMeow.INSTANCE.getMessageManager().display.displayInfo("\u6536\u5230\u76f8\u540c\u5305 - " + this.sameCount);
                        }
                        if (this.sameCount >= 5) {
                            this.status = 1;
                            ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), 0.1f);
                            this.sameCount = 0;
                            return;
                        }
                    }
                    double dist = 0.13;
                    double yaw = player.field_70177_z;
                    double x2 = -Math.sin(yaw) * dist;
                    double z2 = Math.cos(yaw) * dist;
                    player.func_70107_b(player.field_70165_t + x2, player.field_70163_u, player.field_70161_v + z2);
                    this.sendPacketNoEvent((CPacketPlayer)new CPacketPlayer.Position(player.field_70165_t, player.field_70163_u, player.field_70161_v, false));
                    if (((Boolean)this.debugValue.get()).booleanValue()) {
                        DarkMeow.INSTANCE.getMessageManager().display.displayInfo("\u5c1d\u8bd5\u5207\u5165 " + player.field_70165_t + ' ' + player.field_70163_u + ' ' + player.field_70161_v);
                    }
                    this.lastPosX = player.field_70165_t;
                    this.lastPosZ = player.field_70161_v;
                    this.sendPacketNoEvent((CPacketPlayer)new CPacketPlayer.Position(player.field_70165_t, Double.MAX_VALUE, player.field_70161_v, true));
                } else {
                    if (ExtendTimer.INSTANCE.getTimerSpeed(MinecraftInstance.mc.getTimer()) <= 1.2f) {
                        int n3 = this.sameCount;
                        this.sameCount = n3 + 1;
                        if (((Boolean)this.debugValue.get()).booleanValue()) {
                            DarkMeow.INSTANCE.getMessageManager().display.displayInfo("\u6536\u5230\u76f8\u540c\u5305 - " + this.sameCount);
                        }
                        if (this.sameCount >= this.sameCountReach) {
                            this.sameCount = 0;
                            this.sameCountReach += 13;
                            Timer timer = MinecraftInstance.mc.getTimer();
                            ExtendTimer.INSTANCE.setTimerSpeed(timer, ExtendTimer.INSTANCE.getTimerSpeed(timer) + 0.4f);
                        }
                    }
                    if (((Boolean)this.debugValue.get()).booleanValue()) {
                        DarkMeow.INSTANCE.getMessageManager().display.displayInfo("\u8fbe\u6210\u56de\u5f39 " + ((SPacketPlayerPosLook)packet).func_148932_c() + ' ' + ((SPacketPlayerPosLook)packet).func_148928_d() + ' ' + ((SPacketPlayerPosLook)packet).func_148933_e());
                    }
                }
            }
        }
        if (packet instanceof CPacketPlayer && !this.packets.contains(packet)) {
            event.cancelEvent();
        }
    }

    @Override
    public void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.getFly().setState(false);
    }

    @Override
    public void onDisable() {
        block1: {
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) break block1;
            EntityPlayerSP player = entityPlayerSP;
            boolean bl2 = false;
            player.field_70181_x = 0.0;
            ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), 1.0f);
            KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74351_w;
            Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindForward");
            ExtendKeyBinding.INSTANCE.setPressed(keyBinding, false);
            CPacketPlayer cPacketPlayer = this.packet;
            if (cPacketPlayer != null) {
                CPacketPlayer it = cPacketPlayer;
                boolean bl3 = false;
                this.sendPacketNoEvent(it);
            }
            this.packets.clear();
        }
    }

    private final void sendPacketNoEvent(CPacketPlayer packet) {
        block0: {
            this.packets.add(packet);
            NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
            if (netHandlerPlayClient == null) break block0;
            netHandlerPlayClient.func_147297_a((Packet)packet);
        }
    }
}

