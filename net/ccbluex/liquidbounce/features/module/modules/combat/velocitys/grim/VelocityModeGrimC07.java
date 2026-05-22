/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.grim;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPVelocityEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.VelocityMode;
import net.ccbluex.liquidbounce.handler.movement.MovementManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/VelocityModeGrimC07;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/VelocityMode;", "<init>", "()V", "noMoveFix", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "isDestroyingBlock", "", "onVelocity", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPVelocityEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "DarkMeow"})
public final class VelocityModeGrimC07
extends VelocityMode {
    @NotNull
    private final BoolValue noMoveFix = new BoolValue("NoMoveFix", true);
    private boolean isDestroyingBlock;

    public VelocityModeGrimC07() {
        super("GrimC07");
    }

    @EventTarget
    public final void onVelocity(@NotNull PlayerSPVelocityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (this.isDestroyingBlock) {
            return;
        }
        if (((Boolean)this.noMoveFix.get()).booleanValue() && !MovementManager.isMoving$default(DarkMeow.INSTANCE.getMovementManager(), false, 1, null) && player.field_70122_E && player.field_70737_aN == 9 && player.field_70159_w == 0.0 && player.field_70179_y == 0.0 && !MinecraftInstance.mc.getGameSettings().field_74314_A.func_151470_d()) {
            DarkMeow.INSTANCE.getMovementManager().getJumpManager().jump();
        }
        NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
        if (netHandlerPlayClient != null) {
            netHandlerPlayClient.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, new BlockPos(player.field_70165_t, player.field_70163_u + 1.0, player.field_70161_v), EnumFacing.NORTH));
        }
        event.cancelEvent();
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (!(packet instanceof CPacketPlayerDigging)) {
            return;
        }
        CPacketPlayerDigging.Action action = ((CPacketPlayerDigging)packet).func_180762_c();
        switch (action == null ? -1 : WhenMappings.$EnumSwitchMapping$0[action.ordinal()]) {
            case 1: {
                this.isDestroyingBlock = true;
                break;
            }
            case 2: {
                this.isDestroyingBlock = false;
                break;
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[CPacketPlayerDigging.Action.values().length];
            try {
                nArray[CPacketPlayerDigging.Action.START_DESTROY_BLOCK.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

