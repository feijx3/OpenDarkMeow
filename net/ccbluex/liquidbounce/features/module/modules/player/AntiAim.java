/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.MathHelper
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.ccbluex.liquidbounce.handler.rotation.data.RotationTask;
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.impl.MovementModeSilent;
import net.ccbluex.liquidbounce.handler.rotation.value.MovementModeValue;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatRangeValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="AntiAim", category=ModuleCategory.PLAYER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/AntiAim;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "yawModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "yawSpinSpeedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatRangeValue;", "yawRandomSpeedValue", "pitchModeValue", "pitchRandomSpeedValue", "rotationStrafeValue", "Lnet/ccbluex/liquidbounce/handler/rotation/value/MovementModeValue;", "onlyMovingValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "lastRotation", "Lnet/ccbluex/liquidbounce/handler/rotation/data/Rotation;", "onEnable", "", "onMovementInputPre", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAntiAim.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AntiAim.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/AntiAim\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n1#2:87\n*E\n"})
public final class AntiAim
extends Module {
    @JvmField
    @NotNull
    public final ListValue yawModeValue;
    @JvmField
    @NotNull
    public final FloatRangeValue yawSpinSpeedValue;
    @JvmField
    @NotNull
    public final FloatRangeValue yawRandomSpeedValue;
    @JvmField
    @NotNull
    public final ListValue pitchModeValue;
    @JvmField
    @NotNull
    public final FloatRangeValue pitchRandomSpeedValue;
    @JvmField
    @NotNull
    public final MovementModeValue rotationStrafeValue;
    @JvmField
    @NotNull
    public final BoolValue onlyMovingValue;
    @NotNull
    private Rotation lastRotation;

    /*
     * WARNING - void declaration
     */
    public AntiAim() {
        super(null, null, null, null, 15, null);
        void $this$pitchRandomSpeedValue_u24lambda_u245;
        Object $this$pitchRandomSpeedValue_u24lambda_u244;
        Object $this$yawRandomSpeedValue_u24lambda_u243;
        String[] $this$yawRandomSpeedValue_u24lambda_u242;
        String[] $this$yawSpinSpeedValue_u24lambda_u241;
        Object $this$yawSpinSpeedValue_u24lambda_u240;
        Object object = new String[]{"Spin", "Random", "Static", "None"};
        this.yawModeValue = new ListValue("YawMode", (String[])object, null, 4, null);
        Object object2 = object = new FloatRangeValue("YawSpinSpeed", (ClosedRange<Float>)RangesKt.rangeTo(10.0f, 10.0f), (ClosedRange<Float>)RangesKt.rangeTo(-45.0f, 45.0f));
        AntiAim antiAim = this;
        boolean bl2 = false;
        $this$yawSpinSpeedValue_u24lambda_u240.setSuperValue(this.yawModeValue);
        $this$yawSpinSpeedValue_u24lambda_u240 = object;
        boolean bl3 = false;
        $this$yawSpinSpeedValue_u24lambda_u241.setSuperValueMeta("Spin");
        antiAim.yawSpinSpeedValue = object;
        object = new FloatRangeValue("YawRandomRange", (ClosedRange<Float>)RangesKt.rangeTo(-180.0f, 180.0f), (ClosedRange<Float>)RangesKt.rangeTo(-180.0f, 180.0f));
        $this$yawSpinSpeedValue_u24lambda_u241 = object;
        antiAim = this;
        boolean bl4 = false;
        $this$yawRandomSpeedValue_u24lambda_u242.setSuperValue(this.yawModeValue);
        $this$yawRandomSpeedValue_u24lambda_u242 = object;
        boolean bl5 = false;
        $this$yawRandomSpeedValue_u24lambda_u243.setSuperValueMeta("Random");
        antiAim.yawRandomSpeedValue = object;
        object = new String[]{"Random", "Static", "None"};
        this.pitchModeValue = new ListValue("PitchMode", (String[])object, "Random");
        $this$yawRandomSpeedValue_u24lambda_u243 = object = new FloatRangeValue("YawRandomRange", (ClosedRange<Float>)RangesKt.rangeTo(-180.0f, 180.0f), (ClosedRange<Float>)RangesKt.rangeTo(-180.0f, 180.0f));
        antiAim = this;
        boolean bl6 = false;
        $this$pitchRandomSpeedValue_u24lambda_u244.setSuperValue(this.pitchModeValue);
        $this$pitchRandomSpeedValue_u24lambda_u244 = object;
        boolean bl7 = false;
        $this$pitchRandomSpeedValue_u24lambda_u245.setSuperValueMeta("Random");
        antiAim.pitchRandomSpeedValue = object;
        this.rotationStrafeValue = new MovementModeValue("RotationStrafe", MovementModeSilent.INSTANCE);
        this.onlyMovingValue = new BoolValue("OnlyMoving", false);
        this.lastRotation = new Rotation(0.0f, 0.0f, 3, null);
    }

    @Override
    public void onEnable() {
        block0: {
            EntityPlayerSP entityPlayerSP;
            EntityPlayerSP entityPlayerSP2 = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP2 == null) break block0;
            EntityPlayerSP player = entityPlayerSP = entityPlayerSP2;
            boolean bl2 = false;
            this.lastRotation.fromEntity((Entity)player);
        }
    }

    @EventTarget
    public final void onMovementInputPre(@NotNull MovementInputEvent.PRE event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (DarkMeow.INSTANCE.getRotationManager().getTask() != null) {
            return;
        }
        if (((Boolean)this.onlyMovingValue.get()).booleanValue() && !MovementInputEvent.PRE.isMoving$default(event, false, false, 3, null)) {
            return;
        }
        Rotation finalRotation = new Rotation((Entity)player);
        switch ((String)this.yawModeValue.get()) {
            case "Spin": {
                finalRotation.yaw = MathHelper.func_76142_g((float)(this.lastRotation.yaw + this.yawSpinSpeedValue.random()));
                break;
            }
            case "Random": {
                finalRotation.yaw = this.yawRandomSpeedValue.random();
                break;
            }
            case "Static": {
                finalRotation.yaw = this.lastRotation.yaw;
            }
        }
        String string = (String)this.yawModeValue.get();
        if (Intrinsics.areEqual(string, "Random")) {
            finalRotation.pitch = this.pitchRandomSpeedValue.random();
        } else if (Intrinsics.areEqual(string, "Static")) {
            finalRotation.pitch = this.lastRotation.pitch;
        }
        this.lastRotation.fromRotation(finalRotation);
        DarkMeow.INSTANCE.getRotationManager().addTask(new RotationTask(this.getName(), finalRotation, this.rotationStrafeValue.getMovementMode(), 0));
    }
}

