/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGlass
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.network.Blink;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="Phase", description="", category=ModuleCategory.MOVEMENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/Phase;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "glassValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "blinkValue", "stop", "", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
public final class Phase
extends Module {
    @NotNull
    private final BoolValue glassValue = new BoolValue("OnlyGlass", true);
    @NotNull
    private final BoolValue blinkValue = new BoolValue("OnlyBlink", true);
    private boolean stop;

    public Phase() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        WorldClient worldClient = MinecraftInstance.mc.getWorld();
        if (worldClient == null) {
            return;
        }
        WorldClient world = worldClient;
        Blink blink = DarkMeow.INSTANCE.getModuleManager().get(Blink.class);
        boolean bl2 = blink != null ? blink.getState() : false;
        if (!(!bl2 && ((Boolean)this.blinkValue.get()).booleanValue() || this.stop)) {
            BlockPos playerPos = new BlockPos(player.field_70165_t, player.field_70163_u, player.field_70161_v);
            for (int x2 = -1; x2 < 2; ++x2) {
                for (int y2 = -1; y2 < 2; ++y2) {
                    for (int z2 = -1; z2 < 2; ++z2) {
                        BlockPos blockPos = playerPos.func_177982_a(x2, y2, z2);
                        Block block = world.func_180495_p(blockPos).func_177230_c();
                        if (!(block instanceof BlockGlass) && ((Boolean)this.glassValue.get()).booleanValue()) continue;
                        player.field_71174_a.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, blockPos, EnumFacing.DOWN));
                        player.field_71174_a.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos, EnumFacing.DOWN));
                        world.func_180501_a(blockPos, Blocks.field_150350_a.func_176223_P(), 2);
                    }
                }
            }
            this.stop = true;
        }
        Blink blink2 = DarkMeow.INSTANCE.getModuleManager().get(Blink.class);
        boolean bl3 = blink2 != null ? !blink2.getState() : false;
        if (bl3) {
            this.stop = false;
        }
    }
}

