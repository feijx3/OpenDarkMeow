/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockWeb
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.anti_cobweb.impl;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.anti_cobweb.AntiCobwebMode;
import net.ccbluex.liquidbounce.utils.world.WorldUtils;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWeb;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/anti_cobweb/impl/AntiCobwebModeLegacyGrimRemove;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/anti_cobweb/AntiCobwebMode;", "<init>", "()V", "rangeValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAntiCobwebModeLegacyGrimRemove.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AntiCobwebModeLegacyGrimRemove.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/anti_cobweb/impl/AntiCobwebModeLegacyGrimRemove\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,30:1\n216#2,2:31\n*S KotlinDebug\n*F\n+ 1 AntiCobwebModeLegacyGrimRemove.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/anti_cobweb/impl/AntiCobwebModeLegacyGrimRemove\n*L\n25#1:31,2\n*E\n"})
public final class AntiCobwebModeLegacyGrimRemove
extends AntiCobwebMode {
    @JvmField
    @NotNull
    public final IntegerValue rangeValue = new IntegerValue("Range", 12, new IntRange(0, 32));

    public AntiCobwebModeLegacyGrimRemove() {
        super("LegacyGrimRemove");
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        World world = event.getPlayer().field_70170_p;
        Intrinsics.checkNotNullExpressionValue(world, "world");
        Map<BlockPos, Block> $this$forEach$iv = WorldUtils.searchBlocks(world, (Entity)event.getPlayer(), ((Number)this.rangeValue.get()).intValue(), AntiCobwebModeLegacyGrimRemove::onUpdate$lambda$0);
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<BlockPos, Block>> iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<BlockPos, Block> element$iv;
            Map.Entry<BlockPos, Block> entry = element$iv = iterator2.next();
            boolean bl2 = false;
            BlockPos pos = entry.getKey();
            event.getPlayer().field_71174_a.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, pos, EnumFacing.DOWN));
            event.getPlayer().field_70170_p.func_175698_g(pos);
        }
    }

    private static final boolean onUpdate$lambda$0(BlockPos blockPos, Block block) {
        Intrinsics.checkNotNullParameter(blockPos, "<unused var>");
        Intrinsics.checkNotNullParameter(block, "block");
        return block instanceof BlockWeb;
    }
}

