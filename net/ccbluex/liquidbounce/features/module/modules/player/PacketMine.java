/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.player;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerDestroyBlockEvent;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntity;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.font.Fonts;
import net.ccbluex.liquidbounce.utils.KeyUtils;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.utils.movement.RayCastUtils;
import net.darkmeow.darkmeow.utils.visual.ColorUtils;
import net.darkmeow.darkmeow.utils.visual.FontRendererUtils;
import net.darkmeow.darkmeow.utils.visual.GlStateManagerUtils;
import net.darkmeow.darkmeow.utils.visual.Render3DUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"H\u0002J\u0010\u0010)\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"H\u0002J\u0010\u0010*\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"H\u0002J\u0010\u0010+\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0007J\u0010\u00101\u001a\u00020-2\u0006\u0010/\u001a\u000202H\u0007J\u0016\u00103\u001a\u00020-2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020 J\u0010\u00107\u001a\u00020-2\u0006\u0010/\u001a\u000208H\u0007J\u0010\u00109\u001a\u00020-2\u0006\u0010/\u001a\u00020:H\u0007J\u0018\u0010;\u001a\u00020-2\u0006\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020>H\u0002R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u0010\u0010\u0016\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\fR\u0010\u0010\u001e\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/PacketMine;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "breakDamageValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "ignoreRotationMouseOverFixValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "renderSideValue", "renderSideColorValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "getRenderSideColorValue", "()Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "renderProgressAnimationValue", "renderProgressAnimationModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "getRenderProgressAnimationModeValue", "()Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "renderProgressAnimationSpeedValue", "getRenderProgressAnimationSpeedValue", "renderProgressAnimationColorValue", "getRenderProgressAnimationColorValue", "renderProgressTextValue", "renderCompleteSideValue", "renderCompleteSideTimeValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "getRenderCompleteSideTimeValue", "()Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "renderCompleteSideColorValue", "getRenderCompleteSideColorValue", "breakRangeValue", "destroyData", "Lnet/ccbluex/liquidbounce/features/module/modules/player/PacketMine$BlockData;", "destroyProgress", "", "lastDestroyedPos", "Lnet/minecraft/util/math/BlockPos;", "lastDestroyTime", "", "easeInQuint", "t", "easeOutExpo", "easeInOutQuart", "easeInOutSine", "onEnable", "", "onWorld", "event", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "onControllerDestroyBlock", "Lnet/ccbluex/liquidbounce/event/events/controller/ControllerDestroyBlockEvent;", "startDestroy", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "data", "onMovementInputPre", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "renderTextAtBlockCenter", "pos", "text", "", "BlockData", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nPacketMine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PacketMine.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/PacketMine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,302:1\n1#2:303\n*E\n"})
public final class PacketMine
extends Module {
    @JvmField
    @NotNull
    public final FloatValue breakDamageValue = new FloatValue("BreakDamage", 1.04f, (ClosedRange<Float>)RangesKt.rangeTo(0.0f, 1.4f));
    @JvmField
    @NotNull
    public final BoolValue ignoreRotationMouseOverFixValue = new BoolValue("IgnoreRotationMouseOverFix", false);
    @JvmField
    @NotNull
    public final BoolValue renderSideValue = new BoolValue("RenderSide", true);
    @NotNull
    private final ColorValue renderSideColorValue;
    @JvmField
    @NotNull
    public final BoolValue renderProgressAnimationValue;
    @NotNull
    private final ListValue renderProgressAnimationModeValue;
    @NotNull
    private final ListValue renderProgressAnimationSpeedValue;
    @NotNull
    private final ColorValue renderProgressAnimationColorValue;
    @JvmField
    @NotNull
    public final BoolValue renderProgressTextValue;
    @JvmField
    @NotNull
    public final BoolValue renderCompleteSideValue;
    @NotNull
    private final IntegerValue renderCompleteSideTimeValue;
    @NotNull
    private final ColorValue renderCompleteSideColorValue;
    @JvmField
    @NotNull
    public final FloatValue breakRangeValue;
    @Nullable
    private BlockData destroyData;
    private float destroyProgress;
    @Nullable
    private BlockPos lastDestroyedPos;
    private long lastDestroyTime;

    /*
     * WARNING - void declaration
     */
    public PacketMine() {
        super("PacketMine", ModuleCategory.PLAYER, null, null, 12, null);
        void $this$renderCompleteSideColorValue_u24lambda_u244;
        Object $this$renderCompleteSideTimeValue_u24lambda_u243;
        Object $this$renderProgressAnimationColorValue_u24lambda_u242;
        Object $this$renderProgressAnimationSpeedValue_u24lambda_u241;
        Object $this$renderSideColorValue_u24lambda_u240;
        Object object;
        String[] stringArray = object = new ColorValue("RenderSideColor", new ColorValueInfo(new Color(255, 0, 0, 100)), false, 4, null);
        PacketMine packetMine = this;
        boolean bl2 = false;
        $this$renderSideColorValue_u24lambda_u240.setSuperValue(this.renderSideValue);
        packetMine.renderSideColorValue = object;
        this.renderProgressAnimationValue = new BoolValue("RenderProgressAnimation", true);
        object = new String[]{"Center", "Bottom", "Top", "Face"};
        this.renderProgressAnimationModeValue = new ListValue("RenderProgressAnimationMode", (String[])object, "Center");
        object = new String[]{"Percentage", "EaseInQuint", "EaseOutExpo", "EaseInOutQuart", "EaseInOutSine"};
        $this$renderSideColorValue_u24lambda_u240 = object = new ListValue("RenderProgressAnimationSpeed", (String[])object, "Percentage");
        packetMine = this;
        boolean bl3 = false;
        $this$renderProgressAnimationSpeedValue_u24lambda_u241.setSuperValue(this.renderProgressAnimationValue);
        packetMine.renderProgressAnimationSpeedValue = object;
        Color color = Color.RED;
        Intrinsics.checkNotNullExpressionValue(color, "RED");
        $this$renderProgressAnimationSpeedValue_u24lambda_u241 = object = new ColorValue("RenderProgressAnimationColor", new ColorValueInfo(color), false, 4, null);
        packetMine = this;
        boolean bl4 = false;
        $this$renderProgressAnimationColorValue_u24lambda_u242.setSuperValue(this.renderProgressAnimationValue);
        packetMine.renderProgressAnimationColorValue = object;
        this.renderProgressTextValue = new BoolValue("RenderProgressText", true);
        this.renderCompleteSideValue = new BoolValue("RenderCompleteBlock", true);
        $this$renderProgressAnimationColorValue_u24lambda_u242 = object = new IntegerValue("RenderCompleteTime", 500, new IntRange(0, 5000));
        packetMine = this;
        boolean bl5 = false;
        $this$renderCompleteSideTimeValue_u24lambda_u243.setSuperValue(this.renderCompleteSideValue);
        packetMine.renderCompleteSideTimeValue = object;
        $this$renderCompleteSideTimeValue_u24lambda_u243 = object = new ColorValue("RenderCompleteBlockColor", new ColorValueInfo(new Color(0, 255, 0, 100)), false, 4, null);
        packetMine = this;
        boolean bl6 = false;
        $this$renderCompleteSideColorValue_u24lambda_u244.setSuperValue(this.renderCompleteSideValue);
        packetMine.renderCompleteSideColorValue = object;
        this.breakRangeValue = new FloatValue("BreakRange", 4.5f, (ClosedRange<Float>)RangesKt.rangeTo(1.0f, 6.0f));
    }

    @NotNull
    public final ColorValue getRenderSideColorValue() {
        return this.renderSideColorValue;
    }

    @NotNull
    public final ListValue getRenderProgressAnimationModeValue() {
        return this.renderProgressAnimationModeValue;
    }

    @NotNull
    public final ListValue getRenderProgressAnimationSpeedValue() {
        return this.renderProgressAnimationSpeedValue;
    }

    @NotNull
    public final ColorValue getRenderProgressAnimationColorValue() {
        return this.renderProgressAnimationColorValue;
    }

    @NotNull
    public final IntegerValue getRenderCompleteSideTimeValue() {
        return this.renderCompleteSideTimeValue;
    }

    @NotNull
    public final ColorValue getRenderCompleteSideColorValue() {
        return this.renderCompleteSideColorValue;
    }

    private final float easeInQuint(float t2) {
        return t2 * t2 * t2 * t2 * t2;
    }

    private final float easeOutExpo(float t2) {
        return t2 >= 1.0f ? 1.0f : 1.0f - (float)Math.pow(2.0f, -10.0f * t2);
    }

    private final float easeInOutQuart(float t2) {
        return t2 < 0.5f ? 8.0f * t2 * t2 * t2 * t2 : 1.0f - 8.0f * (float)Math.pow(t2 - 1.0f, 4);
    }

    private final float easeInOutSine(float t2) {
        return (1.0f - (float)Math.cos(Math.PI * (double)t2)) / 2.0f;
    }

    @Override
    public void onEnable() {
        this.destroyData = null;
        this.destroyProgress = 0.0f;
        this.lastDestroyedPos = null;
        this.lastDestroyTime = 0L;
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.onEnable();
    }

    @EventTarget
    public final void onControllerDestroyBlock(@NotNull ControllerDestroyBlockEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (!((Boolean)this.ignoreRotationMouseOverFixValue.get()).booleanValue()) {
            this.startDestroy(player, new BlockData(event.getPos(), event.getFacing()));
        }
        event.cancelEvent();
    }

    public final void startDestroy(@NotNull EntityPlayerSP player, @NotNull BlockData data) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(data, "data");
        BlockData blockData = this.destroyData;
        if (!Intrinsics.areEqual(blockData != null ? blockData.getPos() : null, data.getPos())) {
            BlockData blockData2 = this.destroyData;
            if (blockData2 != null) {
                BlockData blockData3;
                BlockData lastData = blockData3 = blockData2;
                boolean bl2 = false;
                player.field_71174_a.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, lastData.getPos(), lastData.getFacing()));
            }
            player.field_71174_a.func_147297_a((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
            player.field_71174_a.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, data.getPos(), data.getFacing()));
            this.destroyData = data;
            this.destroyProgress = 0.0f;
            this.lastDestroyedPos = null;
        }
    }

    @EventTarget
    public final void onMovementInputPre(@NotNull MovementInputEvent.PRE event) {
        block8: {
            double distance;
            Object object;
            EntityPlayerSP player;
            EntityPlayerSP entityPlayerSP;
            Intrinsics.checkNotNullParameter(event, "event");
            EntityPlayerSP entityPlayerSP2 = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP2 == null) {
                return;
            }
            EntityPlayerSP it = entityPlayerSP = (player = entityPlayerSP2);
            boolean bl2 = false;
            Object object2 = object = (Boolean)this.ignoreRotationMouseOverFixValue.get() != false ? entityPlayerSP : null;
            if (object != null) {
                EntityPlayerSP it2 = it = object;
                boolean bl3 = false;
                Object object3 = entityPlayerSP = MinecraftInstance.mc.getCurrentScreen() == null ? it : null;
                if (entityPlayerSP != null) {
                    EntityPlayerSP it3 = it2 = entityPlayerSP;
                    boolean bl4 = false;
                    KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74312_F;
                    Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindAttack");
                    Object object4 = it = KeyUtils.INSTANCE.isKeyDownSystem(keyBinding) ? it2 : null;
                    if (it != null) {
                        Entity entity = (Entity)it;
                        Vec3d vec3d = ExtendEntity.INSTANCE.getVectorForRotation((Entity)player, player.field_70125_A, player.field_70177_z);
                        Intrinsics.checkNotNullExpressionValue(vec3d, "getVectorForRotation(...)");
                        it2 = RayCastUtils.rayTraceBlock$default(entity, 0.0, 0.0f, vec3d, 3, null);
                        if (it2 != null) {
                            EntityPlayerSP entityPlayerSP3;
                            EntityPlayerSP it4 = entityPlayerSP3 = it2;
                            boolean bl5 = false;
                            Object object5 = it3 = it4.field_72313_a == RayTraceResult.Type.BLOCK ? entityPlayerSP3 : null;
                            if (it3 != null) {
                                BlockData blockData;
                                EntityPlayerSP result = it3;
                                boolean bl6 = false;
                                BlockPos blockPos = result.func_178782_a();
                                Intrinsics.checkNotNullExpressionValue(blockPos, "getBlockPos(...)");
                                EnumFacing enumFacing = result.field_178784_b;
                                Intrinsics.checkNotNullExpressionValue(enumFacing, "sideHit");
                                BlockData it5 = blockData = new BlockData(blockPos, enumFacing);
                                boolean bl7 = false;
                                this.startDestroy(player, it5);
                            }
                        }
                    }
                }
            }
            object = this.destroyData;
            if (object == null) break block8;
            EntityPlayerSP data = entityPlayerSP = object;
            boolean bl8 = false;
            this.destroyProgress += player.field_70170_p.func_180495_p(data.getPos()).func_185903_a((EntityPlayer)player, player.field_70170_p, data.getPos());
            if (this.destroyProgress > ((Number)this.breakDamageValue.get()).floatValue() && (distance = player.func_70011_f((double)data.getPos().func_177958_n() + 0.5, (double)data.getPos().func_177956_o() + 0.5, (double)data.getPos().func_177952_p() + 0.5)) <= (double)((Number)this.breakRangeValue.get()).floatValue()) {
                player.field_71174_a.func_147297_a((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
                player.field_71174_a.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, data.getPos(), data.getFacing()));
                this.destroyData = null;
                this.lastDestroyedPos = data.getPos();
                this.lastDestroyTime = System.currentTimeMillis();
            }
            if (this.destroyProgress == 0.0f) {
                this.destroyData = null;
            }
        }
    }

    @EventTarget
    public final void onRender3D(@NotNull Render3DEvent event) {
        block91: {
            float f2;
            Render3DUtils.OriginPoint originPoint;
            float f3;
            Render3DUtils.OriginPoint originPoint2;
            Object object;
            Intrinsics.checkNotNullParameter(event, "event");
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return;
            }
            EntityPlayerSP player = entityPlayerSP;
            BlockPos blockPos = this.lastDestroyedPos;
            if (blockPos != null) {
                object = blockPos;
                BlockPos pos = object;
                boolean bl2 = false;
                long currentTime = System.currentTimeMillis();
                if (((Boolean)this.renderCompleteSideValue.get()).booleanValue() && currentTime - this.lastDestroyTime <= (long)((Number)this.renderCompleteSideTimeValue.get()).intValue() && Intrinsics.areEqual(player.field_70170_p.func_180495_p(pos).func_177230_c(), Blocks.field_150350_a)) {
                    this.renderTextAtBlockCenter(pos, "Complete");
                    Render3DUtils.drawBlockBoxOutlined$default(Render3DUtils.INSTANCE, (Entity)player, pos, event.getPartialTicks(), ColorValue.getColor$default(this.renderCompleteSideColorValue, null, 1, null), null, true, null, 1.0f, 40, null);
                    Color fillDoneColor = new Color(ColorValue.getColor$default(this.renderCompleteSideColorValue, null, 1, null).getRed(), ColorValue.getColor$default(this.renderCompleteSideColorValue, null, 1, null).getGreen(), ColorValue.getColor$default(this.renderCompleteSideColorValue, null, 1, null).getBlue(), 28);
                    Render3DUtils.drawBlockBoxFilled$default(Render3DUtils.INSTANCE, (Entity)player, pos, event.getPartialTicks(), fillDoneColor, true, null, 1.0f, 16, null);
                }
            }
            BlockData blockData = this.destroyData;
            if (blockData == null) break block91;
            Object data = object = blockData;
            boolean bl3 = false;
            float progress = ((Number)RangesKt.coerceIn((Comparable)Float.valueOf(this.destroyProgress / ((Number)this.breakDamageValue.get()).floatValue()), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
            if (((Boolean)this.renderProgressTextValue.get()).booleanValue()) {
                this.renderTextAtBlockCenter(((BlockData)data).getPos(), "" + (int)(progress * (float)100) + '%');
            }
            if (((Boolean)this.renderSideValue.get()).booleanValue()) {
                Render3DUtils.drawBlockBoxOutlined$default(Render3DUtils.INSTANCE, (Entity)player, ((BlockData)data).getPos(), event.getPartialTicks(), ColorValue.getColor$default(this.renderSideColorValue, null, 1, null), null, true, null, 0.0f, 104, null);
            }
            if (!((Boolean)this.renderProgressAnimationValue.get()).booleanValue()) break block91;
            Entity entity = (Entity)player;
            BlockPos blockPos2 = ((BlockData)data).getPos();
            float f4 = event.getPartialTicks();
            Color color = ColorValue.getColor$default(this.renderProgressAnimationColorValue, null, 1, null);
            block6 : switch ((String)this.renderProgressAnimationModeValue.get()) {
                case "Center": {
                    originPoint2 = Render3DUtils.OriginPoint.CENTER;
                    break;
                }
                case "Bottom": {
                    originPoint2 = Render3DUtils.OriginPoint.BOTTOM;
                    break;
                }
                case "Top": {
                    originPoint2 = Render3DUtils.OriginPoint.TOP;
                    break;
                }
                case "Face": {
                    switch (WhenMappings.$EnumSwitchMapping$0[((BlockData)data).getFacing().ordinal()]) {
                        case 1: {
                            originPoint2 = Render3DUtils.OriginPoint.TOP;
                            break block6;
                        }
                        case 2: {
                            originPoint2 = Render3DUtils.OriginPoint.BOTTOM;
                            break block6;
                        }
                        case 3: {
                            originPoint2 = Render3DUtils.OriginPoint.NORTH;
                            break block6;
                        }
                        case 4: {
                            originPoint2 = Render3DUtils.OriginPoint.SOUTH;
                            break block6;
                        }
                        case 5: {
                            originPoint2 = Render3DUtils.OriginPoint.WEST;
                            break block6;
                        }
                        case 6: {
                            originPoint2 = Render3DUtils.OriginPoint.EAST;
                            break block6;
                        }
                    }
                    throw new NoWhenBranchMatchedException();
                }
                default: {
                    originPoint2 = Render3DUtils.OriginPoint.CENTER;
                }
            }
            switch ((String)this.renderProgressAnimationSpeedValue.get()) {
                case "Percentage": {
                    f3 = progress;
                    break;
                }
                case "EaseInQuint": {
                    f3 = this.easeInQuint(progress);
                    break;
                }
                case "EaseOutExpo": {
                    f3 = this.easeOutExpo(progress);
                    break;
                }
                case "EaseInOutQuart": {
                    f3 = this.easeInOutQuart(progress);
                    break;
                }
                case "EaseInOutSine": {
                    f3 = this.easeInOutSine(progress);
                    break;
                }
                default: {
                    f3 = progress;
                }
            }
            Render3DUtils.drawBlockBoxOutlined$default(Render3DUtils.INSTANCE, entity, blockPos2, f4, color, null, true, originPoint2, f3, 8, null);
            Entity entity2 = (Entity)player;
            BlockPos blockPos3 = ((BlockData)data).getPos();
            float f5 = event.getPartialTicks();
            Color color2 = ColorUtils.INSTANCE.withAlpha(ColorValue.getColor$default(this.renderProgressAnimationColorValue, null, 1, null), 28);
            block40 : switch ((String)this.renderProgressAnimationModeValue.get()) {
                case "Center": {
                    originPoint = Render3DUtils.OriginPoint.CENTER;
                    break;
                }
                case "Bottom": {
                    originPoint = Render3DUtils.OriginPoint.BOTTOM;
                    break;
                }
                case "Top": {
                    originPoint = Render3DUtils.OriginPoint.TOP;
                    break;
                }
                case "Face": {
                    switch (WhenMappings.$EnumSwitchMapping$0[((BlockData)data).getFacing().ordinal()]) {
                        case 1: {
                            originPoint = Render3DUtils.OriginPoint.TOP;
                            break block40;
                        }
                        case 2: {
                            originPoint = Render3DUtils.OriginPoint.BOTTOM;
                            break block40;
                        }
                        case 3: {
                            originPoint = Render3DUtils.OriginPoint.NORTH;
                            break block40;
                        }
                        case 4: {
                            originPoint = Render3DUtils.OriginPoint.SOUTH;
                            break block40;
                        }
                        case 6: {
                            originPoint = Render3DUtils.OriginPoint.EAST;
                            break block40;
                        }
                        case 5: {
                            originPoint = Render3DUtils.OriginPoint.WEST;
                            break block40;
                        }
                    }
                    throw new NoWhenBranchMatchedException();
                }
                default: {
                    originPoint = Render3DUtils.OriginPoint.CENTER;
                }
            }
            switch ((String)this.renderProgressAnimationSpeedValue.get()) {
                case "Percentage": {
                    f2 = progress;
                    break;
                }
                case "EaseInQuint": {
                    f2 = this.easeInQuint(progress);
                    break;
                }
                case "EaseOutExpo": {
                    f2 = this.easeOutExpo(progress);
                    break;
                }
                case "EaseInOutQuart": {
                    f2 = this.easeInOutQuart(progress);
                    break;
                }
                case "EaseInOutSine": {
                    f2 = this.easeInOutSine(progress);
                    break;
                }
                default: {
                    f2 = progress;
                }
            }
            Render3DUtils.INSTANCE.drawBlockBoxFilled(entity2, blockPos3, f5, color2, true, originPoint, f2);
        }
    }

    private final void renderTextAtBlockCenter(BlockPos pos, String text) {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        FontRenderer font = Fonts.minecraftFont;
        GlStateManager.func_179094_E();
        GlStateManager.func_179137_b((double)((double)pos.func_177958_n() + 0.5 - MinecraftInstance.mc.getRenderManager().field_78730_l), (double)((double)pos.func_177956_o() + 0.5 - MinecraftInstance.mc.getRenderManager().field_78731_m), (double)((double)pos.func_177952_p() + 0.5 - MinecraftInstance.mc.getRenderManager().field_78728_n));
        GlStateManager.func_187432_a((float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)(-player.field_70177_z), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)player.field_70125_A, (float)(MinecraftInstance.mc.getGameSettings().field_74320_O == 2 ? -1.0f : 1.0f), (float)0.0f, (float)0.0f);
        GlStateManager.func_179152_a((float)-0.025f, (float)-0.025f, (float)0.025f);
        GlStateManager.func_179132_a((boolean)false);
        GlStateManager.func_179097_i();
        GlStateManagerUtils.INSTANCE.applyBlend();
        FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, font, text, Float.valueOf((float)(-font.func_78256_a(text)) / 2.0f), -font.field_78288_b / 2, null, false, 24, null);
        GlStateManager.func_179126_j();
        GlStateManager.func_179132_a((boolean)true);
        GlStateManager.func_179117_G();
        GlStateManager.func_179121_F();
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/PacketMine$BlockData;", "", "pos", "Lnet/minecraft/util/math/BlockPos;", "facing", "Lnet/minecraft/util/EnumFacing;", "<init>", "(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;)V", "getPos", "()Lnet/minecraft/util/math/BlockPos;", "getFacing", "()Lnet/minecraft/util/EnumFacing;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "DarkMeow"})
    public static final class BlockData {
        @NotNull
        private final BlockPos pos;
        @NotNull
        private final EnumFacing facing;

        public BlockData(@NotNull BlockPos pos, @NotNull EnumFacing facing) {
            Intrinsics.checkNotNullParameter(pos, "pos");
            Intrinsics.checkNotNullParameter(facing, "facing");
            this.pos = pos;
            this.facing = facing;
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
        public final BlockPos component1() {
            return this.pos;
        }

        @NotNull
        public final EnumFacing component2() {
            return this.facing;
        }

        @NotNull
        public final BlockData copy(@NotNull BlockPos pos, @NotNull EnumFacing facing) {
            Intrinsics.checkNotNullParameter(pos, "pos");
            Intrinsics.checkNotNullParameter(facing, "facing");
            return new BlockData(pos, facing);
        }

        public static /* synthetic */ BlockData copy$default(BlockData blockData, BlockPos blockPos, EnumFacing enumFacing, int n2, Object object) {
            if ((n2 & 1) != 0) {
                blockPos = blockData.pos;
            }
            if ((n2 & 2) != 0) {
                enumFacing = blockData.facing;
            }
            return blockData.copy(blockPos, enumFacing);
        }

        @NotNull
        public String toString() {
            return "BlockData(pos=" + this.pos + ", facing=" + this.facing + ')';
        }

        public int hashCode() {
            int result = this.pos.hashCode();
            result = result * 31 + this.facing.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BlockData)) {
                return false;
            }
            BlockData blockData = (BlockData)other;
            if (!Intrinsics.areEqual(this.pos, blockData.pos)) {
                return false;
            }
            return this.facing == blockData.facing;
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[EnumFacing.values().length];
            try {
                nArray[EnumFacing.UP.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumFacing.DOWN.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

