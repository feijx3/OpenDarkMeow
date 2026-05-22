/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockBed
 *  net.minecraft.block.BlockLadder
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.BlockPistonMoving
 *  net.minecraft.block.BlockSlime
 *  net.minecraft.block.BlockVine
 *  net.minecraft.block.BlockWeb
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.grim;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPVelocityEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.VelocityMode;
import net.ccbluex.liquidbounce.handler.movement.MovementManager;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntity;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockPistonMoving;
import net.minecraft.block.BlockSlime;
import net.minecraft.block.BlockVine;
import net.minecraft.block.BlockWeb;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0002\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/VelocityModeGrimSpecialBlock;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/VelocityMode;", "<init>", "()V", "onPlayerSPVelocity", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPVelocityEvent;", "canIgnoreVelocity", "", "DarkMeow"})
public final class VelocityModeGrimSpecialBlock
extends VelocityMode {
    public VelocityModeGrimSpecialBlock() {
        super("GrimSpecialBlockList");
    }

    @EventTarget(ignoreCanceled=true)
    public final void onPlayerSPVelocity(@NotNull PlayerSPVelocityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.canIgnoreVelocity()) {
            event.cancelEvent();
        }
    }

    private final boolean canIgnoreVelocity() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return false;
        }
        EntityPlayerSP player = entityPlayerSP;
        WorldClient worldClient = MinecraftInstance.mc.getWorld();
        if (worldClient == null) {
            return false;
        }
        WorldClient world = worldClient;
        if (ExtendEntity.INSTANCE.isInWeb((Entity)player) || player.func_180799_ab() || player.func_70617_f_()) {
            return true;
        }
        AxisAlignedBB playerBoundingBox = player.func_174813_aQ();
        AxisAlignedBB largecheckArea = new AxisAlignedBB(playerBoundingBox.field_72340_a - 0.03, playerBoundingBox.field_72338_b - 1.03, playerBoundingBox.field_72339_c - 0.03, playerBoundingBox.field_72336_d + 0.03, playerBoundingBox.field_72337_e, playerBoundingBox.field_72334_f + 0.03);
        for (BlockPos pos : BlockPos.func_191532_a((int)((int)largecheckArea.field_72340_a), (int)((int)largecheckArea.field_72338_b), (int)((int)largecheckArea.field_72339_c), (int)((int)largecheckArea.field_72336_d), (int)((int)largecheckArea.field_72337_e), (int)((int)largecheckArea.field_72334_f))) {
            Block block = world.func_180495_p(pos).func_177230_c();
            if (!(block instanceof BlockSlime) && !(block instanceof BlockBed) && !(block instanceof BlockWeb) && !(block instanceof BlockPistonMoving)) continue;
            return true;
        }
        AxisAlignedBB lowcheckArea = new AxisAlignedBB(playerBoundingBox.field_72340_a - 0.03, playerBoundingBox.field_72338_b - 0.03, playerBoundingBox.field_72339_c - 0.03, playerBoundingBox.field_72336_d + 0.03, playerBoundingBox.field_72337_e, playerBoundingBox.field_72334_f + 0.03);
        for (BlockPos pos : BlockPos.func_191532_a((int)((int)lowcheckArea.field_72340_a), (int)((int)lowcheckArea.field_72338_b), (int)((int)lowcheckArea.field_72339_c), (int)((int)lowcheckArea.field_72336_d), (int)((int)lowcheckArea.field_72337_e), (int)((int)lowcheckArea.field_72334_f))) {
            Block block = world.func_180495_p(pos).func_177230_c();
            if (!(block instanceof BlockLiquid) && !(block instanceof BlockLadder) && !(block instanceof BlockVine) || MovementManager.isMoving$default(DarkMeow.INSTANCE.getMovementManager(), false, 1, null)) continue;
            return true;
        }
        return false;
    }
}

