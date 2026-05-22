/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.flys.grim;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPVelocityEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.Fly;
import net.ccbluex.liquidbounce.features.module.modules.movement.flys.FlyMode;
import net.ccbluex.liquidbounce.handler.network.packet.PacketManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0017J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0011H\u0017J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/flys/grim/GrimYBoost;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/flys/FlyMode;", "<init>", "()V", "startTimeValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "ticks", "", "set", "", "onWorld", "", "event", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onPlayerSPVelocity", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPVelocityEvent;", "onEnable", "onDisable", "sendIllegalCPacketPlayer", "DarkMeow"})
public final class GrimYBoost
extends FlyMode {
    @NotNull
    private final IntegerValue startTimeValue = new IntegerValue("StartTime", 2, new IntRange(2, 4));
    private int ticks;
    private boolean set;

    public GrimYBoost() {
        super("GrimYBoost");
    }

    @Override
    @EventTarget
    public void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Fly.INSTANCE.setState(false);
    }

    @Override
    @EventTarget
    public void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getPacket() instanceof SPacketPlayerPosLook) {
            this.set = true;
        }
    }

    @Override
    @EventTarget
    public void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (player.field_70181_x < -0.3) {
            Fly.INSTANCE.setState(false);
        }
        if (this.ticks == 0) {
            DarkMeow.INSTANCE.getMovementManager().getJumpManager().jump();
        }
        int n2 = this.ticks;
        this.ticks = n2 + 1;
        if (this.ticks == ((Number)this.startTimeValue.get()).intValue()) {
            DarkMeow.INSTANCE.getMovementManager().getStuckManager().start();
            this.sendIllegalCPacketPlayer();
        }
        if (this.set) {
            this.set = false;
            this.sendIllegalCPacketPlayer();
        }
    }

    @EventTarget
    public final void onPlayerSPVelocity(@NotNull PlayerSPVelocityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Fly.INSTANCE.setState(false);
    }

    @Override
    public void onEnable() {
        this.ticks = 0;
        this.set = false;
    }

    @Override
    public void onDisable() {
        if (this.ticks >= ((Number)this.startTimeValue.get()).intValue()) {
            DarkMeow.INSTANCE.getMovementManager().getStuckManager().stop();
        }
    }

    private final void sendIllegalCPacketPlayer() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        PacketManager.sendPacket$default(DarkMeow.INSTANCE.getNetworkManager().packetManager, (Packet)new CPacketPlayer.Position(player.field_70165_t + (double)450721, player.field_70163_u, player.field_70161_v, player.field_70122_E), true, null, 4, null);
    }
}

