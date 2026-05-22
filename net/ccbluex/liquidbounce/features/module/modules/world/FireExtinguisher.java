/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockFire
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.timer.delay.MSDelay;
import net.ccbluex.liquidbounce.utils.world.WorldUtils;
import net.ccbluex.liquidbounce.value.impl.IntegerRangeValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/FireExtinguisher;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "rangeValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "delayModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "delayValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "delay", "Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "onMovementInput", "", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nFireExtinguisher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FireExtinguisher.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/FireExtinguisher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,50:1\n1#2:51\n1#2:60\n536#3:52\n521#3,6:53\n640#4:59\n*S KotlinDebug\n*F\n+ 1 FireExtinguisher.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/FireExtinguisher\n*L\n42#1:60\n41#1:52\n41#1:53,6\n42#1:59\n*E\n"})
public final class FireExtinguisher
extends Module {
    @JvmField
    @NotNull
    public final IntegerValue rangeValue = new IntegerValue("Range", 6, new IntRange(3, 8));
    @JvmField
    @NotNull
    public final ListValue delayModeValue;
    @JvmField
    @NotNull
    public final IntegerRangeValue delayValue;
    @NotNull
    private final MSDelay delay;

    public FireExtinguisher() {
        super("FireExtinguisher", ModuleCategory.WORLD, null, null, 12, null);
        String[] stringArray = new String[]{"Single", "All"};
        this.delayModeValue = new ListValue("DelayMode", stringArray, "Single");
        this.delayValue = new IntegerRangeValue("Delay", new IntRange(200, 200), new IntRange(0, 1000));
        this.delay = new MSDelay();
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget
    public final void onMovementInput(@NotNull MovementInputEvent.PRE event) {
        block6: {
            Map map;
            void $this$onEach$iv;
            void $this$filterTo$iv$iv;
            void $this$filter$iv;
            WorldClient worldClient;
            WorldClient world;
            Object object;
            Intrinsics.checkNotNullParameter(event, "event");
            NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
            if (netHandlerPlayClient == null) {
                return;
            }
            NetHandlerPlayClient connection = netHandlerPlayClient;
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return;
            }
            EntityPlayerSP player = entityPlayerSP;
            WorldClient worldClient2 = MinecraftInstance.mc.getWorld();
            if (worldClient2 == null) {
                return;
            }
            WorldClient it = object = (world = worldClient2);
            boolean $i$a$-takeIf-FireExtinguisher$onMovementInput$22 = false;
            Object object2 = worldClient = MSDelay.hasPassed$default(this.delay, 0L, 1, null) ? object : null;
            if (worldClient == null || (object = WorldUtils.searchBlocks$default((World)worldClient, (Entity)player, ((Number)this.rangeValue.get()).intValue(), null, 4, null)) == null) break block6;
            Object $i$a$-takeIf-FireExtinguisher$onMovementInput$22 = object;
            boolean $i$f$filter22 = false;
            void var10_12 = $this$filter$iv;
            Map destination$iv$iv = new LinkedHashMap();
            boolean $i$f$filterTo = false;
            Iterator iterator2 = $this$filterTo$iv$iv.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry element$iv$iv;
                Map.Entry entry = element$iv$iv = iterator2.next();
                boolean bl2 = false;
                Block block = (Block)entry.getValue();
                if (!(block instanceof BlockFire)) continue;
                destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
            }
            Map $i$f$filter22 = destination$iv$iv;
            boolean $i$f$onEach = false;
            Map $this$onEach_u24lambda_u242$iv = destination$iv$iv = $this$onEach$iv;
            boolean bl3 = false;
            Iterator iterator3 = $this$onEach_u24lambda_u242$iv.entrySet().iterator();
            while (iterator3.hasNext()) {
                Map.Entry element$iv;
                Map.Entry entry = element$iv = iterator3.next();
                boolean bl4 = false;
                BlockPos pos = (BlockPos)entry.getKey();
                if (!MSDelay.hasPassed$default(this.delay, 0L, 1, null) && Intrinsics.areEqual(this.delayModeValue.get(), "Single")) {
                    return;
                }
                connection.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, pos, EnumFacing.UP));
                connection.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, pos, EnumFacing.DOWN));
            }
            Map it2 = map = destination$iv$iv;
            boolean bl5 = false;
            this.delay.reset(this.delayValue);
        }
    }
}

