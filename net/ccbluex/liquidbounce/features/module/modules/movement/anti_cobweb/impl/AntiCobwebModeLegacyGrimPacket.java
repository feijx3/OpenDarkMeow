/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.block.BlockWeb
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.anti_cobweb.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPUpdateWalkingEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.anti_cobweb.AntiCobwebMode;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntity;
import net.minecraft.block.BlockWeb;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0007\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/anti_cobweb/impl/AntiCobwebModeLegacyGrimPacket;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/anti_cobweb/AntiCobwebMode;", "<init>", "()V", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onPlayerSPUpdateWalkingPre", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$PRE;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAntiCobwebModeLegacyGrimPacket.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AntiCobwebModeLegacyGrimPacket.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/anti_cobweb/impl/AntiCobwebModeLegacyGrimPacket\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,50:1\n1#2:51\n*E\n"})
public final class AntiCobwebModeLegacyGrimPacket
extends AntiCobwebMode {
    public AntiCobwebModeLegacyGrimPacket() {
        super("LegacyGrimPacket");
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ExtendEntity.INSTANCE.setInWeb((Entity)event.getPlayer(), false);
    }

    @EventTarget
    public final void onPlayerSPUpdateWalkingPre(@NotNull PlayerSPUpdateWalkingEvent.PRE event) {
        PlayerSPUpdateWalkingEvent.PRE pRE;
        PlayerSPUpdateWalkingEvent.PRE pRE2;
        Intrinsics.checkNotNullParameter(event, "event");
        PlayerSPUpdateWalkingEvent.PRE it = pRE2 = event;
        boolean bl2 = false;
        PlayerSPUpdateWalkingEvent.PRE pRE3 = pRE = it.getSyncPositionType().getPosition() ? pRE2 : null;
        if (pRE != null) {
            it = pRE2 = pRE;
            boolean bl3 = false;
            BlockPos playerPos = new BlockPos(it.posX, it.posY, it.posZ);
            for (int x2 = -1; x2 < 2; ++x2) {
                for (int y2 = -2; y2 < 4; ++y2) {
                    for (int z2 = -1; z2 < 2; ++z2) {
                        BlockPos blockPos = playerPos.func_177982_a(x2, y2, z2);
                        if (!(event.player.field_70170_p.func_180495_p(blockPos).func_177230_c() instanceof BlockWeb)) continue;
                        event.player.field_71174_a.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos, EnumFacing.DOWN));
                    }
                }
            }
        }
    }
}

