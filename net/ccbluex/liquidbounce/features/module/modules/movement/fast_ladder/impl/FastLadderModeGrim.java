/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.fast_ladder.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPMoveRelativeEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.fast_ladder.FastLadderMode;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\f\u0010\u000e\u001a\u00020\r*\u00020\u000fH\u0016J\f\u0010\u0010\u001a\u00020\u0007*\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/fast_ladder/impl/FastLadderModeGrim;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/fast_ladder/FastLadderMode;", "<init>", "()V", "fastFallValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "shouldOverride", "", "getShouldOverride", "()Z", "setShouldOverride", "(Z)V", "onEnable", "", "handleFastClimb", "Lnet/minecraft/client/entity/EntityPlayerSP;", "handleFastFall", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nFastLadderModeGrim.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastLadderModeGrim.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/fast_ladder/impl/FastLadderModeGrim\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,62:1\n12#2,3:63\n20#2,3:66\n1#3:69\n*S KotlinDebug\n*F\n+ 1 FastLadderModeGrim.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/fast_ladder/impl/FastLadderModeGrim\n*L\n30#1:63,3\n33#1:66,3\n*E\n"})
public final class FastLadderModeGrim
extends FastLadderMode {
    @JvmField
    @NotNull
    public final BoolValue fastFallValue = new BoolValue("FastFall", false);
    private boolean shouldOverride;

    public FastLadderModeGrim() {
        super("Grim");
        ListenableOwner $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<ListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> FastLadderModeGrim._init_$lambda$0(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(WorldEvent.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> FastLadderModeGrim._init_$lambda$1(this, arg_0, arg_1);
        priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(PlayerSPMoveRelativeEvent.class), $receiver$iv));
    }

    public final boolean getShouldOverride() {
        return this.shouldOverride;
    }

    public final void setShouldOverride(boolean bl2) {
        this.shouldOverride = bl2;
    }

    @Override
    public void onEnable() {
        this.shouldOverride = false;
    }

    @Override
    public void handleFastClimb(@NotNull EntityPlayerSP $this$handleFastClimb) {
        Intrinsics.checkNotNullParameter($this$handleFastClimb, "<this>");
        this.shouldOverride = true;
    }

    @Override
    public boolean handleFastFall(@NotNull EntityPlayerSP $this$handleFastFall) {
        boolean bl2;
        Intrinsics.checkNotNullParameter($this$handleFastFall, "<this>");
        Object t2 = this.fastFallValue.get();
        boolean it = (Boolean)t2;
        boolean bl3 = false;
        Boolean bl4 = (Boolean)(it ? t2 : null);
        if (bl4 != null) {
            Boolean bl5 = bl4;
            boolean it2 = bl5;
            boolean bl6 = false;
            $this$handleFastFall.field_71174_a.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, new BlockPos(MathHelper.func_76128_c((double)$this$handleFastFall.field_70165_t), MathHelper.func_76128_c((double)$this$handleFastFall.func_174813_aQ().field_72338_b), MathHelper.func_76128_c((double)$this$handleFastFall.field_70161_v)), EnumFacing.DOWN));
            boolean it3 = bl5;
            boolean bl7 = false;
            bl2 = true;
        } else {
            bl2 = false;
        }
        return bl2;
    }

    private static final Unit _init_$lambda$0(FastLadderModeGrim this$0, ListenerBase $this$listener, WorldEvent it) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.onEnable();
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(FastLadderModeGrim this$0, SafeListenerBase $this$safeListener, PlayerSPMoveRelativeEvent it) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(it, "it");
        if (!this$0.shouldOverride) {
            return Unit.INSTANCE;
        }
        this$0.shouldOverride = false;
        $this$safeListener.getPlayer().field_70181_x = RangesKt.coerceAtLeast(0.1786 - new Vec3d($this$safeListener.getPlayer().field_70159_w, 0.0, $this$safeListener.getPlayer().field_70179_y).func_72433_c(), $this$safeListener.getPlayer().field_70181_x);
        return Unit.INSTANCE;
    }
}

