/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityBrewingStand
 *  net.minecraft.tileentity.TileEntityChest
 *  net.minecraft.tileentity.TileEntityFurnace
 *  net.minecraft.util.EnumActionResult
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.world;

import java.lang.invoke.LambdaMetafactory;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPUpdateWalkingEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.world.ContainerStealer;
import net.ccbluex.liquidbounce.features.module.modules.world.container_aura.ContainerAuraClickedBlocksTracker;
import net.ccbluex.liquidbounce.handler.movement.MovementManager;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.ccbluex.liquidbounce.handler.rotation.data.RotationTask;
import net.ccbluex.liquidbounce.handler.rotation.value.MovementModeValue;
import net.ccbluex.liquidbounce.utils.extensions.BlockExtensionKt;
import net.ccbluex.liquidbounce.utils.timer.delay.MSDelay;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerRangeValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.darkmeow.darkmeow.utils.movement.RotationUtils;
import net.darkmeow.darkmeow.utils.world.WorldUtils;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001-B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0019J\n\u0010)\u001a\u00020'*\u00020*J\n\u0010+\u001a\u00020,*\u00020*R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u00a8\u0006."}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/ContainerAura;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "rangeValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "delayValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "clickModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "clickNormalAllowThroughWalls", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "clickNormalAtValue", "rotationValue", "rotationKeepTickValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "rotationMoveModeValue", "Lnet/ccbluex/liquidbounce/handler/rotation/value/MovementModeValue;", "blockChestValue", "blockFurnaceValue", "blockBrewingStandValue", "onlyNoMoveValue", "onlyOnContainerStealerValue", "swingValue", "prevClickPos", "Lnet/minecraft/util/math/BlockPos;", "getPrevClickPos", "()Lnet/minecraft/util/math/BlockPos;", "setPrevClickPos", "(Lnet/minecraft/util/math/BlockPos;)V", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "getTimer", "()Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "clickedBlocksTracker", "Lnet/ccbluex/liquidbounce/features/module/modules/world/container_aura/ContainerAuraClickedBlocksTracker;", "getClickedBlocksTracker", "()Lnet/ccbluex/liquidbounce/features/module/modules/world/container_aura/ContainerAuraClickedBlocksTracker;", "isOpened", "", "pos", "doClick", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "doSearch", "", "ProcessRightClickBlockArgs", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nContainerAura.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContainerAura.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/ContainerAura\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,210:1\n1#2:211\n536#3:212\n521#3,6:213\n21#4,2:219\n20#4,3:221\n*S KotlinDebug\n*F\n+ 1 ContainerAura.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/ContainerAura\n*L\n175#1:212\n175#1:213,6\n96#1:219,2\n100#1:221,3\n*E\n"})
public final class ContainerAura
extends Module {
    @NotNull
    public static final ContainerAura INSTANCE;
    @JvmField
    @NotNull
    public static final FloatValue rangeValue;
    @JvmField
    @NotNull
    public static final IntegerRangeValue delayValue;
    @JvmField
    @NotNull
    public static final ListValue clickModeValue;
    @JvmField
    @NotNull
    public static final BoolValue clickNormalAllowThroughWalls;
    @JvmField
    @NotNull
    public static final ListValue clickNormalAtValue;
    @JvmField
    @NotNull
    public static final BoolValue rotationValue;
    @JvmField
    @NotNull
    public static final IntegerValue rotationKeepTickValue;
    @JvmField
    @NotNull
    public static final MovementModeValue rotationMoveModeValue;
    @JvmField
    @NotNull
    public static final BoolValue blockChestValue;
    @JvmField
    @NotNull
    public static final BoolValue blockFurnaceValue;
    @JvmField
    @NotNull
    public static final BoolValue blockBrewingStandValue;
    @JvmField
    @NotNull
    public static final BoolValue onlyNoMoveValue;
    @JvmField
    @NotNull
    public static final BoolValue onlyOnContainerStealerValue;
    @JvmField
    @NotNull
    public static final ListValue swingValue;
    @Nullable
    private static BlockPos prevClickPos;
    @NotNull
    private static final MSDelay timer;
    @NotNull
    private static final ContainerAuraClickedBlocksTracker clickedBlocksTracker;

    private ContainerAura() {
        super("ContainerAura", ModuleCategory.WORLD, null, null, 12, null);
    }

    @Nullable
    public final BlockPos getPrevClickPos() {
        return prevClickPos;
    }

    public final void setPrevClickPos(@Nullable BlockPos blockPos) {
        prevClickPos = blockPos;
    }

    @NotNull
    public final MSDelay getTimer() {
        return timer;
    }

    @NotNull
    public final ContainerAuraClickedBlocksTracker getClickedBlocksTracker() {
        return clickedBlocksTracker;
    }

    public final boolean isOpened(@NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        return clickedBlocksTracker.isClicked(pos);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean doClick(@NotNull SafeListenerBase $this$doClick) {
        RayTraceResult rayTraceResult;
        BlockPos blockPos;
        ProcessRightClickBlockArgs processRightClickBlockArgs;
        RayTraceResult rayTraceResult2;
        RayTraceResult it;
        RayTraceResult rayTraceResult3;
        BlockPos blockPos2;
        BlockPos blockPos3;
        Intrinsics.checkNotNullParameter($this$doClick, "<this>");
        Vec3d eyesPos = new Vec3d($this$doClick.getPlayer().field_70165_t, $this$doClick.getPlayer().func_174813_aQ().field_72338_b + (double)$this$doClick.getPlayer().func_70047_e(), $this$doClick.getPlayer().field_70161_v);
        BlockPos blockPos4 = prevClickPos;
        if (blockPos4 == null) return false;
        BlockPos it2 = blockPos3 = blockPos4;
        boolean bl2 = false;
        RotationTask rotationTask = DarkMeow.INSTANCE.getRotationManager().getTask();
        if (!Intrinsics.areEqual(rotationTask != null ? rotationTask.getName() : null, INSTANCE.getName())) return false;
        BlockPos blockPos5 = blockPos3;
        BlockPos blockPos6 = blockPos5;
        if (blockPos6 == null) return false;
        BlockPos it3 = blockPos2 = blockPos6;
        boolean bl3 = false;
        if (DarkMeow.INSTANCE.getInventoryManager().getContainerManager().hasOpenContainer()) return false;
        BlockPos blockPos7 = blockPos2;
        blockPos3 = blockPos7;
        if (blockPos3 == null) return false;
        BlockPos pos = blockPos3;
        boolean bl4 = false;
        String string = (String)clickModeValue.get();
        if (Intrinsics.areEqual(string, "Legit")) {
            it = rayTraceResult3 = $this$doClick.getMc().field_71476_x;
            boolean bl5 = false;
            System.out.println(it);
            it = rayTraceResult3;
            boolean bl6 = false;
            if (it.field_72313_a != RayTraceResult.Type.BLOCK) return false;
            boolean bl7 = true;
            if (!bl7) return false;
            RayTraceResult rayTraceResult4 = rayTraceResult3;
            rayTraceResult2 = rayTraceResult4;
            if (rayTraceResult2 == null) return false;
            RayTraceResult it4 = it = rayTraceResult2;
            boolean bl8 = false;
            if (!Intrinsics.areEqual(it4.func_178782_a(), pos)) return false;
            RayTraceResult rayTraceResult5 = it;
            rayTraceResult3 = rayTraceResult5;
            if (rayTraceResult3 == null) return false;
            it4 = rayTraceResult3;
            boolean bl9 = false;
            processRightClickBlockArgs = new ProcessRightClickBlockArgs(it4);
        } else {
            if (!Intrinsics.areEqual(string, "Normal")) return false;
            rayTraceResult2 = $this$doClick.getWorld().func_147447_a(eyesPos, BlockExtensionKt.getVec(pos), false, true, true);
            if (rayTraceResult2 == null) return false;
            RayTraceResult it5 = it = rayTraceResult2;
            boolean bl10 = false;
            if (!((Boolean)clickNormalAllowThroughWalls.get()).booleanValue()) {
                if (!Intrinsics.areEqual(it5.func_178782_a(), pos)) return false;
            }
            boolean bl11 = true;
            if (!bl11) return false;
            RayTraceResult rayTraceResult6 = it;
            rayTraceResult3 = rayTraceResult6;
            if (rayTraceResult3 == null) return false;
            RayTraceResult result = rayTraceResult3;
            boolean bl12 = false;
            EnumFacing enumFacing = result.field_178784_b;
            Intrinsics.checkNotNullExpressionValue(enumFacing, "sideHit");
            Vec3d vec3d = result.field_72307_f;
            Intrinsics.checkNotNullExpressionValue(vec3d, "hitVec");
            processRightClickBlockArgs = new ProcessRightClickBlockArgs(pos, enumFacing, vec3d);
        }
        if ((blockPos2 = processRightClickBlockArgs) == null) return false;
        BlockPos blockPos8 = blockPos = blockPos2;
        boolean bl13 = false;
        BlockPos pos2 = blockPos8.component1();
        EnumFacing facing = blockPos8.component2();
        Vec3d vec = blockPos8.component3();
        RayTraceResult it6 = rayTraceResult2 = $this$doClick.getPlayerController().func_187099_a($this$doClick.getPlayer(), $this$doClick.getWorld(), pos2, facing, vec, EnumHand.MAIN_HAND);
        boolean bl14 = false;
        Object object = rayTraceResult = it6 == EnumActionResult.SUCCESS ? rayTraceResult2 : null;
        if (rayTraceResult != null) {
            it6 = rayTraceResult2 = rayTraceResult;
            boolean bl15 = false;
            String string2 = (String)swingValue.get();
            if (Intrinsics.areEqual(string2, "Normal")) {
                $this$doClick.getPlayer().func_184609_a(EnumHand.MAIN_HAND);
            } else if (Intrinsics.areEqual(string2, "Silent")) {
                $this$doClick.getPlayer().field_71174_a.func_147297_a((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
            }
            timer.reset(delayValue);
            clickedBlocksTracker.addClicked(pos2);
            prevClickPos = null;
        }
        BlockPos it7 = blockPos;
        return true;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void doSearch(@NotNull SafeListenerBase $this$doSearch) {
        block15: {
            block12: {
                block14: {
                    block13: {
                        Intrinsics.checkNotNullParameter($this$doSearch, "<this>");
                        eyesPos = new Vec3d($this$doSearch.getPlayer().field_70165_t, $this$doSearch.getPlayer().func_174813_aQ().field_72338_b + (double)$this$doSearch.getPlayer().func_70047_e(), $this$doSearch.getPlayer().field_70161_v);
                        it = var4_3 = $this$doSearch.getWorld();
                        $i$a$-takeUnless-ContainerAura$doSearch$1 = false;
                        v0 /* !! */  = var3_7 = DarkMeow.INSTANCE.getInventoryManager().getContainerManager().hasOpenContainer() == false ? var4_3 : null;
                        if (var3_7 == null) break block12;
                        it = var5_4 = var3_7;
                        $i$a$-takeIf-ContainerAura$doSearch$2 = false;
                        v1 /* !! */  = var4_3 = ((Boolean)ContainerAura.onlyNoMoveValue.get() == false || MovementManager.isMoving$default(DarkMeow.INSTANCE.getMovementManager(), false, 1, null) == false) != false ? var5_4 : null;
                        if (var4_3 == null) break block12;
                        it = var6_6 = var4_3;
                        $i$a$-takeIf-ContainerAura$doSearch$3 = false;
                        if (!((Boolean)ContainerAura.onlyOnContainerStealerValue.get()).booleanValue()) ** GOTO lbl-1000
                        v2 = DarkMeow.INSTANCE.getModuleManager().get(ContainerStealer.class);
                        if (v2 != null ? v2.getState() : false) lbl-1000:
                        // 2 sources

                        {
                            v3 = true;
                        } else {
                            v3 = false;
                        }
                        v4 /* !! */  = var5_4 = v3 != false ? var6_6 : null;
                        if (var5_4 == null) break block12;
                        it = var7_9 = var5_4;
                        $i$a$-takeIf-ContainerAura$doSearch$4 = false;
                        v5 /* !! */  = var6_6 = DarkMeow.INSTANCE.getMovementManager().getStuckManager().isInStuck() == false != false ? var7_9 : null;
                        if (var6_6 == null) break block12;
                        it = var8_11 /* !! */  = var6_6;
                        $i$a$-takeIf-ContainerAura$doSearch$5 = false;
                        v6 /* !! */  = var7_9 = MSDelay.hasPassed$default(ContainerAura.timer, 0L, 1, null) != false ? var8_11 /* !! */  : null;
                        if (var7_9 == null || (var8_11 /* !! */  = WorldUtils.quickGetNearTileEntities((World)var7_9, $this$doSearch.getPlayer(), ((Number)ContainerAura.rangeValue.get()).floatValue(), (Function2<BlockPos, TileEntity, Boolean>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;, doSearch$lambda$26(net.darkmeow.darkmeow.event.listenable.SafeListenerBase net.minecraft.util.math.BlockPos net.minecraft.tileentity.TileEntity ), (Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/tileentity/TileEntity;)Ljava/lang/Boolean;)((SafeListenerBase)$this$doSearch))) == null) break block12;
                        $i$a$-takeIf-ContainerAura$doSearch$5 = (Map)var8_11 /* !! */ ;
                        $i$f$filter = false;
                        var12_18 = $this$filter$iv;
                        destination$iv$iv = new LinkedHashMap<K, V>();
                        $i$f$filterTo = false;
                        var15_22 = $this$filterTo$iv$iv.entrySet().iterator();
                        while (var15_22.hasNext()) {
                            var18_27 = element$iv$iv = var15_22.next();
                            $i$a$-filter-ContainerAura$doSearch$7 = false;
                            pos = (BlockPos)var18_27.getKey();
                            var22_34 /* !! */  = $this$doSearch.getWorld().func_147447_a(eyesPos, BlockExtensionKt.getVec(pos), false, true, false);
                            rayTractResult = Intrinsics.areEqual(var22_34 /* !! */  != null ? var22_34 /* !! */ .func_178782_a() : null, pos);
                            var22_34 /* !! */  = (String)ContainerAura.clickModeValue.get();
                            v7 = Intrinsics.areEqual(var22_34 /* !! */ , "Legit") ? rayTractResult : (Intrinsics.areEqual(var22_34 /* !! */ , "Normal") ? ((Boolean)ContainerAura.clickNormalAllowThroughWalls.get()).booleanValue() || rayTractResult : false);
                            if (!v7) continue;
                            destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
                        }
                        var12_18 = (Iterable<T>)destination$iv$iv.entrySet();
                        if (!(destination$iv$iv = var12_18.iterator()).hasNext()) {
                            v8 = null;
                        } else {
                            $i$f$filterTo /* !! */  = destination$iv$iv.next();
                            if (!destination$iv$iv.hasNext()) {
                                v8 = $i$f$filterTo /* !! */ ;
                            } else {
                                var15_22 = (Map.Entry)$i$f$filterTo /* !! */ ;
                                $i$a$-minByOrNull-ContainerAura$doSearch$8 = false;
                                pos = (BlockPos)var15_22.getKey();
                                var15_23 = $this$doSearch.getPlayer().func_174831_c(pos);
                                do {
                                    var17_25 = destination$iv$iv.next();
                                    pos = (Map.Entry)var17_25;
                                    $i$a$-minByOrNull-ContainerAura$doSearch$8 = false;
                                    pos = (BlockPos)pos.getKey();
                                    pos = $this$doSearch.getPlayer().func_174831_c(pos);
                                    if (Double.compare(var15_23, pos) <= 0) continue;
                                    $i$f$filterTo /* !! */  = var17_25;
                                    var15_23 = pos;
                                } while (destination$iv$iv.hasNext());
                                v8 = $i$f$filterTo /* !! */ ;
                            }
                        }
                        var10_15 = v8;
                        if (var10_15 == null || (var11_17 = (BlockPos)var10_15.getKey()) == null) break block12;
                        pos = var12_18 = var11_17;
                        $i$a$-takeIf-ContainerAura$doSearch$9 = false;
                        var15_24 = (Boolean)ContainerAura.rotationValue.get();
                        if (!var15_24) break block13;
                        it = var17_25 = DarkMeow.INSTANCE.getRotationManager();
                        $i$a$-takeIf-ContainerAura$doSearch$9$1 = false;
                        v9 = var21_33 = it.getTask() == null != false ? var17_25 : null;
                        if (var21_33 == null) ** GOTO lbl-1000
                        it = var21_33;
                        $i$a$-let-ContainerAura$doSearch$9$2 = false;
                        var17_25 = RotationUtils.getRotationBlock$default(RotationUtils.INSTANCE, (Entity)$this$doSearch.getPlayer(), (BlockPos)pos, 0.0, null, null, 14, null);
                        if (var17_25 != null) {
                            rotation = var17_25;
                            $i$a$-let-ContainerAura$doSearch$9$3 = false;
                            v10 = DarkMeow.INSTANCE.getRotationManager().addTask(new RotationTask(ContainerAura.INSTANCE.getName(), (Rotation)rotation, ContainerAura.rotationMoveModeValue.getMovementMode(), ((Number)ContainerAura.rotationKeepTickValue.get()).intValue()));
                        } else lbl-1000:
                        // 2 sources

                        {
                            v10 = false;
                        }
                        break block14;
                    }
                    if (!var15_24) {
                        v10 = true;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                v11 = v10 ? var12_18 : null;
                break block15;
            }
            v11 = null;
        }
        ContainerAura.prevClickPos = v11;
    }

    private static final Unit _init_$lambda$6(SafeListenerBase $this$safeListener, MovementInputEvent.PRE it) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(clickModeValue.get(), "Legit") || Intrinsics.areEqual(clickNormalAtValue.get(), "Pre")) {
            INSTANCE.doClick($this$safeListener);
        }
        INSTANCE.doSearch($this$safeListener);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$7(SafeListenerBase $this$safeListener, PlayerSPUpdateWalkingEvent.POST it) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(clickModeValue.get(), "Normal") && Intrinsics.areEqual(clickNormalAtValue.get(), "Post")) {
            INSTANCE.doClick($this$safeListener);
        }
        return Unit.INSTANCE;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean doSearch$lambda$26(SafeListenerBase $this_doSearch, BlockPos pos, TileEntity tile) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(tile, "tile");
        TileEntity tileEntity = tile;
        if (tileEntity instanceof TileEntityChest) {
            if ((Boolean)blockChestValue.get() == false) return false;
            if ($this_doSearch.getWorld().func_180495_p(pos.func_177984_a()).func_185913_b()) return false;
            bl2 = true;
        } else if (tileEntity instanceof TileEntityFurnace) {
            bl2 = (Boolean)blockFurnaceValue.get();
        } else {
            if (!(tileEntity instanceof TileEntityBrewingStand)) return false;
            bl2 = (Boolean)blockBrewingStandValue.get();
        }
        if (!bl2) return false;
        if (clickedBlocksTracker.isClicked(pos)) return false;
        return true;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void $receiver$iv;
        int priority$iv;
        ListenableOwner $this$safeListener$iv;
        INSTANCE = new ContainerAura();
        rangeValue = new FloatValue("Range", 4.5f, (ClosedRange<Float>)RangesKt.rangeTo(1.0f, 6.0f));
        delayValue = new IntegerRangeValue("Delay", new IntRange(100, 100), new IntRange(0, 1000));
        Object object = new String[]{"Normal", "Legit"};
        clickModeValue = new ListValue("ClickMode", (String[])object, "Normal");
        Object $this$clickNormalAllowThroughWalls_u24lambda_u240 = object = new BoolValue("ClickNormalAllowThroughWalls", false);
        boolean bl2 = false;
        ((Value)$this$clickNormalAllowThroughWalls_u24lambda_u240).setSuperValue(clickModeValue);
        Object $this$clickNormalAllowThroughWalls_u24lambda_u241 = object;
        boolean bl3 = false;
        ((Value)$this$clickNormalAllowThroughWalls_u24lambda_u241).setSuperValueMeta("Normal");
        clickNormalAllowThroughWalls = object;
        object = new String[]{"Pre", "Post"};
        Object $this$clickNormalAtValue_u24lambda_u242 = object = new ListValue("ClickNormalAt", (String[])object, "Post");
        boolean bl4 = false;
        ((Value)$this$clickNormalAtValue_u24lambda_u242).setSuperValue(clickModeValue);
        Object $this$clickNormalAtValue_u24lambda_u243 = object;
        boolean bl5 = false;
        ((Value)$this$clickNormalAtValue_u24lambda_u243).setSuperValueMeta("Normal");
        clickNormalAtValue = object;
        rotationValue = new BoolValue("Rotation", true);
        Object $this$rotationKeepTickValue_u24lambda_u244 = object = new IntegerValue("RotationKeepTick", 1, new IntRange(0, 20));
        boolean bl6 = false;
        ((Value)$this$rotationKeepTickValue_u24lambda_u244).setSuperValue(rotationValue);
        rotationKeepTickValue = object;
        Object $this$rotationMoveModeValue_u24lambda_u245 = object = new MovementModeValue("RotationMoveMode", null, 2, null);
        int n2 = 0;
        ((Value)$this$rotationMoveModeValue_u24lambda_u245).setSuperValue(rotationValue);
        rotationMoveModeValue = object;
        blockChestValue = new BoolValue("BlockChest", true);
        blockFurnaceValue = new BoolValue("BlockFurnace", false);
        blockBrewingStandValue = new BoolValue("BlockBrewingStand", false);
        onlyNoMoveValue = new BoolValue("OnlyNoMove", false);
        onlyOnContainerStealerValue = new BoolValue("OnlyOnContainerStealer", true);
        object = new String[]{"Normal", "Silent", "None"};
        swingValue = new ListValue("Swing", (String[])object, "Normal");
        timer = new MSDelay();
        clickedBlocksTracker = new ContainerAuraClickedBlocksTracker();
        EventManager.registerListener$default(DarkMeow.INSTANCE.getEventManager(), clickedBlocksTracker, false, false, 6, null);
        object = ListenableOwnerExtends.INSTANCE;
        $this$rotationMoveModeValue_u24lambda_u245 = INSTANCE;
        n2 = -100;
        Function2<SafeListenerBase, Event, Unit> function$iv = ContainerAura::_init_$lambda$6;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($this$safeListener$iv).add(new EventHookSafeOwnerCheck<MovementInputEvent.PRE>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(MovementInputEvent.PRE.class), $this$safeListener$iv));
        ListenableOwnerExtends this_$iv = ListenableOwnerExtends.INSTANCE;
        $this$safeListener$iv = INSTANCE;
        function$iv = ContainerAura::_init_$lambda$7;
        priority$iv = 0;
        $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookSafeOwnerCheck<MovementInputEvent.PRE>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(PlayerSPUpdateWalkingEvent.POST.class), (ListenableOwner)$receiver$iv));
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\b\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/ContainerAura$ProcessRightClickBlockArgs;", "", "pos", "Lnet/minecraft/util/math/BlockPos;", "facing", "Lnet/minecraft/util/EnumFacing;", "vec", "Lnet/minecraft/util/math/Vec3d;", "<init>", "(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/math/Vec3d;)V", "result", "Lnet/minecraft/util/math/RayTraceResult;", "(Lnet/minecraft/util/math/RayTraceResult;)V", "getPos", "()Lnet/minecraft/util/math/BlockPos;", "getFacing", "()Lnet/minecraft/util/EnumFacing;", "getVec", "()Lnet/minecraft/util/math/Vec3d;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "DarkMeow"})
    public static final class ProcessRightClickBlockArgs {
        @NotNull
        private final BlockPos pos;
        @NotNull
        private final EnumFacing facing;
        @NotNull
        private final Vec3d vec;

        public ProcessRightClickBlockArgs(@NotNull BlockPos pos, @NotNull EnumFacing facing, @NotNull Vec3d vec) {
            Intrinsics.checkNotNullParameter(pos, "pos");
            Intrinsics.checkNotNullParameter(facing, "facing");
            Intrinsics.checkNotNullParameter(vec, "vec");
            this.pos = pos;
            this.facing = facing;
            this.vec = vec;
        }

        @NotNull
        public final BlockPos getPos() {
            return this.pos;
        }

        @NotNull
        public final EnumFacing getFacing() {
            return this.facing;
        }

        @NotNull
        public final Vec3d getVec() {
            return this.vec;
        }

        public ProcessRightClickBlockArgs(@NotNull RayTraceResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            BlockPos blockPos = result.func_178782_a();
            Intrinsics.checkNotNullExpressionValue(blockPos, "getBlockPos(...)");
            EnumFacing enumFacing = result.field_178784_b;
            Intrinsics.checkNotNullExpressionValue(enumFacing, "sideHit");
            Vec3d vec3d = result.field_72307_f;
            Intrinsics.checkNotNullExpressionValue(vec3d, "hitVec");
            this(blockPos, enumFacing, vec3d);
        }

        @NotNull
        public final BlockPos component1() {
            return this.pos;
        }

        @NotNull
        public final EnumFacing component2() {
            return this.facing;
        }

        @NotNull
        public final Vec3d component3() {
            return this.vec;
        }

        @NotNull
        public final ProcessRightClickBlockArgs copy(@NotNull BlockPos pos, @NotNull EnumFacing facing, @NotNull Vec3d vec) {
            Intrinsics.checkNotNullParameter(pos, "pos");
            Intrinsics.checkNotNullParameter(facing, "facing");
            Intrinsics.checkNotNullParameter(vec, "vec");
            return new ProcessRightClickBlockArgs(pos, facing, vec);
        }

        public static /* synthetic */ ProcessRightClickBlockArgs copy$default(ProcessRightClickBlockArgs processRightClickBlockArgs, BlockPos blockPos, EnumFacing enumFacing, Vec3d vec3d, int n2, Object object) {
            if ((n2 & 1) != 0) {
                blockPos = processRightClickBlockArgs.pos;
            }
            if ((n2 & 2) != 0) {
                enumFacing = processRightClickBlockArgs.facing;
            }
            if ((n2 & 4) != 0) {
                vec3d = processRightClickBlockArgs.vec;
            }
            return processRightClickBlockArgs.copy(blockPos, enumFacing, vec3d);
        }

        @NotNull
        public String toString() {
            return "ProcessRightClickBlockArgs(pos=" + this.pos + ", facing=" + this.facing + ", vec=" + this.vec + ')';
        }

        public int hashCode() {
            int result = this.pos.hashCode();
            result = result * 31 + this.facing.hashCode();
            result = result * 31 + this.vec.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProcessRightClickBlockArgs)) {
                return false;
            }
            ProcessRightClickBlockArgs processRightClickBlockArgs = (ProcessRightClickBlockArgs)other;
            if (!Intrinsics.areEqual(this.pos, processRightClickBlockArgs.pos)) {
                return false;
            }
            if (this.facing != processRightClickBlockArgs.facing) {
                return false;
            }
            return Intrinsics.areEqual(this.vec, processRightClickBlockArgs.vec);
        }
    }
}

