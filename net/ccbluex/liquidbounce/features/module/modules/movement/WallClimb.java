/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventState;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.MotionEvent;
import net.ccbluex.liquidbounce.event.events.player.move.MoveEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="WallClimb", description="", category=ModuleCategory.MOVEMENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0013H\u0007J8\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/WallClimb;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "replace", "Lnet/ccbluex/liquidbounce/value/Value;", "", "replaceY", "brokenBlocks", "", "Lnet/minecraft/util/math/BlockPos;", "Lnet/minecraft/block/state/IBlockState;", "onMove", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/move/MoveEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "doBreak", "x1", "x2", "y1", "y2", "z1", "z2", "restoreBlock", "", "pos", "state", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nWallClimb.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WallClimb.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/WallClimb\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,115:1\n1761#2,3:116\n*S KotlinDebug\n*F\n+ 1 WallClimb.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/WallClimb\n*L\n43#1:116,3\n*E\n"})
public final class WallClimb
extends Module {
    @NotNull
    private final ListValue modeValue;
    @NotNull
    private final Value<Integer> replace;
    @NotNull
    private final Value<Integer> replaceY;
    @NotNull
    private final Map<BlockPos, IBlockState> brokenBlocks;

    public WallClimb() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"Simple", "GrimClip"};
        this.modeValue = new ListValue("Mode", stringArray, "Simple");
        this.replace = new IntegerValue("AutoReplaceBlockDistance", 6, 0, 10).displayable(() -> WallClimb.replace$lambda$0(this));
        this.replaceY = new IntegerValue("ReplaceYDistance", 0, -10, 10).displayable(() -> WallClimb.replaceY$lambda$1(this));
        this.brokenBlocks = new LinkedHashMap();
    }

    @EventTarget
    public final void onMove(@NotNull MoveEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (!player.field_70123_F || player.func_70617_f_() || player.func_70090_H() || player.func_180799_ab()) {
            return;
        }
        if (StringsKt.equals("simple", (String)this.modeValue.get(), true)) {
            event.setY(0.2);
            player.field_70181_x = 0.0;
        }
    }

    @EventTarget
    public final void onUpdate(@NotNull MotionEvent event) {
        boolean bl2;
        BlockPos playerPos;
        EntityPlayerSP player;
        block12: {
            Intrinsics.checkNotNullParameter(event, "event");
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return;
            }
            player = entityPlayerSP;
            playerPos = new BlockPos(player.field_70165_t, player.field_70163_u + ((Number)this.replaceY.get()).doubleValue(), player.field_70161_v);
            WorldClient worldClient = MinecraftInstance.mc.getWorld();
            Intrinsics.checkNotNull(worldClient);
            WorldClient world = worldClient;
            boolean bl3 = false;
            AxisAlignedBB playerBoundingBox = player.func_174813_aQ();
            List list = world.func_184144_a((Entity)player, playerBoundingBox);
            Intrinsics.checkNotNullExpressionValue(list, "getCollisionBoxes(...)");
            Iterable $this$any$iv = list;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    AxisAlignedBB it = (AxisAlignedBB)element$iv;
                    boolean bl4 = false;
                    if (!it.func_72326_a(playerBoundingBox)) continue;
                    bl2 = true;
                    break block12;
                }
                bl2 = false;
            }
        }
        boolean isInBlock = bl2;
        if (event.getEventState() != EventState.POST) {
            return;
        }
        String string = ((String)this.modeValue.get()).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
        if (Intrinsics.areEqual(string, "grimclip")) {
            if (!isInBlock) {
                if (player.field_70123_F) {
                    DarkMeow.INSTANCE.getMovementManager().getJumpManager().jump();
                    if (player.field_70181_x < 0.0) {
                        this.doBreak(-1, 1, 0, 3, -1, 1);
                    }
                }
            } else {
                this.doBreak(-1, 1, 0, 3, -1, 1);
                if (player.field_70122_E) {
                    DarkMeow.INSTANCE.getMovementManager().getJumpManager().jump();
                }
            }
            if (player.field_70181_x < 0.0) {
                this.brokenBlocks.entrySet().removeIf(arg_0 -> WallClimb.onUpdate$lambda$5(arg_0 -> WallClimb.onUpdate$lambda$4(playerPos, this, arg_0), arg_0));
            }
        }
    }

    private final void doBreak(int x1, int x2, int y1, int y2, int z1, int z2) {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        BlockPos playerPos = new BlockPos(player.field_70165_t, player.field_70163_u, player.field_70161_v);
        int x3 = x1;
        if (x3 <= x2) {
            while (true) {
                int y3;
                if ((y3 = y1) <= y2) {
                    while (true) {
                        int z3;
                        if ((z3 = z1) <= z2) {
                            while (true) {
                                BlockPos blockPos;
                                IBlockState blockState;
                                if ((blockState = player.field_70170_p.func_180495_p(blockPos = playerPos.func_177982_a(x3, y3, z3))).func_177230_c() != Blocks.field_150350_a) {
                                    this.brokenBlocks.put(blockPos, blockState);
                                    player.field_71174_a.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, blockPos, EnumFacing.DOWN));
                                    player.field_71174_a.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos, EnumFacing.DOWN));
                                    player.field_70170_p.func_180501_a(blockPos, Blocks.field_150350_a.func_176223_P(), 2);
                                }
                                if (z3 == z2) break;
                                ++z3;
                            }
                        }
                        if (y3 == y2) break;
                        ++y3;
                    }
                }
                if (x3 == x2) break;
                ++x3;
            }
        }
    }

    private final boolean restoreBlock(BlockPos pos, IBlockState state) {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return false;
        }
        EntityPlayerSP player = entityPlayerSP;
        player.field_70170_p.func_180501_a(pos, state, 2);
        return true;
    }

    private static final boolean replace$lambda$0(WallClimb this$0) {
        return Intrinsics.areEqual(this$0.modeValue.get(), "GrimClip");
    }

    private static final boolean replaceY$lambda$1(WallClimb this$0) {
        return Intrinsics.areEqual(this$0.modeValue.get(), "GrimClip");
    }

    private static final boolean onUpdate$lambda$4(BlockPos $playerPos, WallClimb this$0, Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "<destruct>");
        BlockPos pos = (BlockPos)entry.getKey();
        IBlockState state = (IBlockState)entry.getValue();
        return pos.func_177951_i((Vec3i)$playerPos) > (double)((Number)this$0.replace.get()).intValue() && this$0.restoreBlock(pos, state);
    }

    private static final boolean onUpdate$lambda$5(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }
}

