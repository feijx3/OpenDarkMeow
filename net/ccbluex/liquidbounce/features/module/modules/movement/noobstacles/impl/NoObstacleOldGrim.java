/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.block.Block
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noobstacles.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.noobstacles.NoObstacleMode;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.world.WorldUtils;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noobstacles/impl/NoObstacleOldGrim;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noobstacles/NoObstacleMode;", "<init>", "()V", "rangeValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "tryBreakWaterValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "tryBreakLavaValue", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "checkBlock", "", "block", "Lnet/minecraft/block/Block;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoObstacleOldGrim.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoObstacleOldGrim.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noobstacles/impl/NoObstacleOldGrim\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n536#2:44\n521#2,6:45\n216#3,2:51\n1761#4,3:53\n*S KotlinDebug\n*F\n+ 1 NoObstacleOldGrim.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noobstacles/impl/NoObstacleOldGrim\n*L\n27#1:44\n27#1:45,6\n29#1:51,2\n39#1:53,3\n*E\n"})
public final class NoObstacleOldGrim
extends NoObstacleMode {
    @NotNull
    private final IntegerValue rangeValue = new IntegerValue(this.getValuePrefix() + "Range", 12, new IntRange(0, 32));
    @NotNull
    private final BoolValue tryBreakWaterValue = new BoolValue(this.getValuePrefix() + "TryBreakWater", true);
    @NotNull
    private final BoolValue tryBreakLavaValue = new BoolValue(this.getValuePrefix() + "TryBreakLava", true);

    public NoObstacleOldGrim() {
        super("OldGrim");
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        void $this$forEach$iv;
        void $this$filterTo$iv$iv;
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
        NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
        if (netHandlerPlayClient == null) {
            return;
        }
        NetHandlerPlayClient connection = netHandlerPlayClient;
        Map $this$filter$iv = WorldUtils.searchBlocks$default((World)world, (Entity)player, ((Number)this.rangeValue.get()).intValue(), null, 4, null);
        boolean $i$f$filter = false;
        Object object = $this$filter$iv;
        Map destination$iv$iv = new LinkedHashMap();
        boolean $i$f$filterTo = false;
        Iterator iterator2 = $this$filterTo$iv$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv$iv;
            Map.Entry entry = element$iv$iv = iterator2.next();
            boolean bl2 = false;
            Block block = (Block)entry.getValue();
            if (!this.checkBlock(block)) continue;
            destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
        }
        $this$filter$iv = destination$iv$iv;
        boolean $i$f$forEach = false;
        object = $this$forEach$iv.entrySet().iterator();
        while (object.hasNext()) {
            Map.Entry element$iv;
            Map.Entry entry = element$iv = (Map.Entry)object.next();
            boolean bl3 = false;
            BlockPos pos = (BlockPos)entry.getKey();
            connection.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, pos, EnumFacing.DOWN));
            world.func_175698_g(pos);
        }
    }

    private final boolean checkBlock(Block block) {
        boolean bl2;
        block3: {
            Boolean[] booleanArray = new Boolean[]{(Boolean)this.tryBreakWaterValue.get() != false && (Intrinsics.areEqual(block, Blocks.field_150355_j) || Intrinsics.areEqual(block, Blocks.field_150358_i)), (Boolean)this.tryBreakLavaValue.get() != false && (Intrinsics.areEqual(block, Blocks.field_150353_l) || Intrinsics.areEqual(block, Blocks.field_150356_k))};
            Iterable $this$any$iv = CollectionsKt.listOf(booleanArray);
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    boolean it = (Boolean)element$iv;
                    boolean bl3 = false;
                    if (!it) continue;
                    bl2 = true;
                    break block3;
                }
                bl2 = false;
            }
        }
        return bl2;
    }
}

