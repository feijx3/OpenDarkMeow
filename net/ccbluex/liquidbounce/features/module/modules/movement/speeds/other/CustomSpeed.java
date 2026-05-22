/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.Timer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.other;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPUpdateWalkingEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode;
import net.ccbluex.liquidbounce.handler.movement.MovementManager;
import net.ccbluex.liquidbounce.injection.extend.ExtendKeyBinding;
import net.ccbluex.liquidbounce.injection.extend.ExtendTimer;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayer;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Timer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0007J\u0010\u0010*\u001a\u00020'2\u0006\u0010(\u001a\u00020+H\u0007J\b\u0010,\u001a\u00020'H\u0016J\b\u0010-\u001a\u00020'H\u0016J\b\u0010.\u001a\u00020'H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/other/CustomSpeed;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "<init>", "()V", "speedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "doLaunchSpeedValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "launchSpeedValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "strafeBeforeJump", "doMinimumSpeedValue", "minimumSpeedValue", "addYMotionValue", "doCustomYValue", "yValue", "upTimerValue", "jumpTimerValue", "downTimerValue", "upAirSpeedValue", "downAirSpeedValue", "strafeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "plusModeValue", "", "plusMultiplyValue", "groundStayValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "groundResetXZValue", "resetXZValue", "resetYValue", "doJumpValue", "groundSpaceKeyPressedValue", "airSpaceKepPressedValue", "usePreMotionValue", "groundTick", "", "onPreMotion", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPUpdateWalkingEvent$PRE;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onEnable", "onDisable", "doSpeed", "DarkMeow"})
public final class CustomSpeed
extends SpeedMode {
    @NotNull
    private final FloatValue speedValue = new FloatValue("Speed", 1.6f, 0.0f, 2.0f);
    @NotNull
    private final BoolValue doLaunchSpeedValue = new BoolValue("DoLaunchSpeed", true);
    @NotNull
    private final Value<Float> launchSpeedValue = new FloatValue("LaunchSpeed", 1.6f, 0.2f, 2.0f).displayable(() -> CustomSpeed.launchSpeedValue$lambda$0(this));
    @NotNull
    private final BoolValue strafeBeforeJump = new BoolValue("LaunchMoveBeforeJump", false);
    @NotNull
    private final BoolValue doMinimumSpeedValue = new BoolValue("DoMinimumSpeed", true);
    @NotNull
    private final Value<Float> minimumSpeedValue = new FloatValue("MinimumSpeed", 0.25f, 0.1f, 2.0f).displayable(() -> CustomSpeed.minimumSpeedValue$lambda$1(this));
    @NotNull
    private final FloatValue addYMotionValue = new FloatValue("AddYMotion", 0.0f, 0.0f, 2.0f);
    @NotNull
    private final BoolValue doCustomYValue = new BoolValue("DoModifyJumpY", true);
    @NotNull
    private final Value<Float> yValue = new FloatValue("Y", 0.42f, 0.0f, 4.0f).displayable(() -> CustomSpeed.yValue$lambda$2(this));
    @NotNull
    private final FloatValue upTimerValue = new FloatValue("UpTimer", 1.0f, 0.1f, 2.0f);
    @NotNull
    private final FloatValue jumpTimerValue = new FloatValue("JumpTimer", 1.25f, 0.1f, 2.0f);
    @NotNull
    private final FloatValue downTimerValue = new FloatValue("DownTimer", 1.0f, 0.1f, 2.0f);
    @NotNull
    private final FloatValue upAirSpeedValue = new FloatValue("UpAirSpeed", 2.03f, 0.5f, 3.5f);
    @NotNull
    private final FloatValue downAirSpeedValue = new FloatValue("DownAirSpeed", 2.01f, 0.5f, 3.5f);
    @NotNull
    private final ListValue strafeValue;
    @NotNull
    private final Value<String> plusModeValue;
    @NotNull
    private final Value<Float> plusMultiplyValue;
    @NotNull
    private final IntegerValue groundStayValue;
    @NotNull
    private final BoolValue groundResetXZValue;
    @NotNull
    private final BoolValue resetXZValue;
    @NotNull
    private final BoolValue resetYValue;
    @NotNull
    private final BoolValue doJumpValue;
    @NotNull
    private final BoolValue groundSpaceKeyPressedValue;
    @NotNull
    private final BoolValue airSpaceKepPressedValue;
    @NotNull
    private final BoolValue usePreMotionValue;
    private int groundTick;

    public CustomSpeed() {
        super("Custom");
        String[] stringArray = new String[]{"Strafe", "Boost", "AirSpeed", "Plus", "PlusOnlyUp", "PlusOnlyDown", "Non-Strafe"};
        this.strafeValue = new ListValue("Strafe", stringArray, "Boost");
        stringArray = new String[]{"Add", "Multiply"};
        this.plusModeValue = new ListValue("PlusBoostMode", stringArray, "Add").displayable(() -> CustomSpeed.plusModeValue$lambda$3(this));
        this.plusMultiplyValue = new FloatValue("PlusMultiplyAmount", 1.1f, 1.0f, 2.0f).displayable(() -> CustomSpeed.plusMultiplyValue$lambda$4(this));
        this.groundStayValue = new IntegerValue("GroundStay", 0, 0, 10);
        this.groundResetXZValue = new BoolValue("GroundResetXZ", false);
        this.resetXZValue = new BoolValue("ResetXZ", false);
        this.resetYValue = new BoolValue("ResetY", false);
        this.doJumpValue = new BoolValue("DoJump", true);
        this.groundSpaceKeyPressedValue = new BoolValue("PressSpaceKeyOnGround", true);
        this.airSpaceKepPressedValue = new BoolValue("PressSpaceKeyInAir", false);
        this.usePreMotionValue = new BoolValue("UsePreMotion", true);
    }

    @EventTarget
    public final void onPreMotion(@NotNull PlayerSPUpdateWalkingEvent.PRE event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (((Boolean)this.usePreMotionValue.get()).booleanValue()) {
            this.doSpeed();
        }
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!((Boolean)this.usePreMotionValue.get()).booleanValue()) {
            this.doSpeed();
        }
    }

    @Override
    public void onEnable() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (((Boolean)this.resetXZValue.get()).booleanValue()) {
            player.field_70159_w = 0.0;
            player.field_70179_y = 0.0;
        }
        if (((Boolean)this.resetYValue.get()).booleanValue()) {
            player.field_70181_x = 0.0;
        }
    }

    @Override
    public void onDisable() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        Timer timer = MinecraftInstance.mc.getTimer();
        ExtendTimer.INSTANCE.setTimerSpeed(timer, 1.0f);
        ExtendEntityPlayer.INSTANCE.setSpeedInAir((EntityPlayer)player, 0.02f);
    }

    private final void doSpeed() {
        block47: {
            block45: {
                EntityPlayerSP player;
                block46: {
                    EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
                    if (entityPlayerSP == null) {
                        return;
                    }
                    player = entityPlayerSP;
                    if (!MovementManager.isMoving$default(DarkMeow.INSTANCE.getMovementManager(), false, 1, null)) break block45;
                    ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), player.field_70181_x > 0.0 ? ((Number)this.upTimerValue.get()).floatValue() : ((Number)this.downTimerValue.get()).floatValue());
                    if (!player.field_70122_E) break block46;
                    if (this.groundTick >= ((Number)this.groundStayValue.get()).intValue()) {
                        if (((Boolean)this.groundSpaceKeyPressedValue.get()).booleanValue()) {
                            KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74314_A;
                            Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindJump");
                            ExtendKeyBinding.INSTANCE.setPressed(keyBinding, MinecraftInstance.mc.getGameSettings().field_74314_A.func_151470_d());
                        }
                        ExtendTimer.INSTANCE.setTimerSpeed(MinecraftInstance.mc.getTimer(), ((Number)this.jumpTimerValue.get()).floatValue());
                        if (((Boolean)this.doLaunchSpeedValue.get()).booleanValue() && ((Boolean)this.strafeBeforeJump.get()).booleanValue()) {
                            DarkMeow.INSTANCE.getMovementManager().strafe(((Number)this.launchSpeedValue.get()).floatValue());
                        }
                        if (((Boolean)this.doJumpValue.get()).booleanValue()) {
                            player.func_70664_aZ();
                        } else if (!((Boolean)this.doCustomYValue.get()).booleanValue()) {
                            player.field_70181_x = 0.42;
                        }
                        if (((Boolean)this.doLaunchSpeedValue.get()).booleanValue() && !((Boolean)this.strafeBeforeJump.get()).booleanValue()) {
                            DarkMeow.INSTANCE.getMovementManager().strafe(((Number)this.launchSpeedValue.get()).floatValue());
                        }
                        if (((Boolean)this.doCustomYValue.get()).booleanValue() && !(((Number)this.yValue.get()).floatValue() == 0.0f)) {
                            player.field_70181_x = ((Number)this.yValue.get()).floatValue();
                        }
                    } else if (((Boolean)this.groundResetXZValue.get()).booleanValue()) {
                        player.field_70159_w = 0.0;
                        player.field_70179_y = 0.0;
                    }
                    int n2 = this.groundTick;
                    this.groundTick = n2 + 1;
                    break block47;
                }
                this.groundTick = 0;
                if (((Boolean)this.airSpaceKepPressedValue.get()).booleanValue()) {
                    KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74314_A;
                    Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindJump");
                    ExtendKeyBinding.INSTANCE.setPressed(keyBinding, MinecraftInstance.mc.getGameSettings().field_74314_A.func_151470_d());
                }
                if (((Boolean)this.doMinimumSpeedValue.get()).booleanValue() && DarkMeow.INSTANCE.getMovementManager().getSpeed() < ((Number)this.minimumSpeedValue.get()).floatValue()) {
                    DarkMeow.INSTANCE.getMovementManager().strafe(((Number)this.minimumSpeedValue.get()).floatValue());
                }
                String string = ((String)this.strafeValue.get()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
                switch (string) {
                    case "strafe": {
                        DarkMeow.INSTANCE.getMovementManager().strafe(((Number)this.speedValue.get()).floatValue());
                        break;
                    }
                    case "non-strafe": {
                        MovementManager.strafe$default(DarkMeow.INSTANCE.getMovementManager(), 0.0f, 1, null);
                        break;
                    }
                    case "boost": {
                        MovementManager.strafe$default(DarkMeow.INSTANCE.getMovementManager(), 0.0f, 1, null);
                        break;
                    }
                    case "airspeed": {
                        if (player.field_70181_x > 0.0) {
                            ExtendEntityPlayer.INSTANCE.setSpeedInAir((EntityPlayer)player, 0.01f * ((Number)this.upAirSpeedValue.get()).floatValue());
                            MovementManager.strafe$default(DarkMeow.INSTANCE.getMovementManager(), 0.0f, 1, null);
                            break;
                        }
                        ExtendEntityPlayer.INSTANCE.setSpeedInAir((EntityPlayer)player, 0.01f * ((Number)this.downAirSpeedValue.get()).floatValue());
                        MovementManager.strafe$default(DarkMeow.INSTANCE.getMovementManager(), 0.0f, 1, null);
                        break;
                    }
                    case "plus": {
                        String string2 = this.plusModeValue.get().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(string2, "toLowerCase(...)");
                        String string3 = string2;
                        if (Intrinsics.areEqual(string3, "plus")) {
                            DarkMeow.INSTANCE.getMovementManager().move(((Number)this.speedValue.get()).floatValue() * 0.1f);
                            break;
                        }
                        if (!Intrinsics.areEqual(string3, "multiply")) break;
                        player.field_70159_w *= ((Number)this.plusMultiplyValue.get()).doubleValue();
                        player.field_70179_y *= ((Number)this.plusMultiplyValue.get()).doubleValue();
                        break;
                    }
                    case "plusonlyup": {
                        if (player.field_70181_x > 0.0) {
                            String string4 = this.plusModeValue.get().toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(string4, "toLowerCase(...)");
                            String string5 = string4;
                            if (Intrinsics.areEqual(string5, "plus")) {
                                DarkMeow.INSTANCE.getMovementManager().move(((Number)this.speedValue.get()).floatValue() * 0.1f);
                                break;
                            }
                            if (!Intrinsics.areEqual(string5, "multiply")) break;
                            player.field_70159_w *= ((Number)this.plusMultiplyValue.get()).doubleValue();
                            player.field_70179_y *= ((Number)this.plusMultiplyValue.get()).doubleValue();
                            break;
                        }
                        MovementManager.strafe$default(DarkMeow.INSTANCE.getMovementManager(), 0.0f, 1, null);
                        break;
                    }
                    case "plusonlydown": {
                        if (player.field_70181_x < 0.0) {
                            String string6 = this.plusModeValue.get().toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(string6, "toLowerCase(...)");
                            String string7 = string6;
                            if (Intrinsics.areEqual(string7, "plus")) {
                                DarkMeow.INSTANCE.getMovementManager().move(((Number)this.speedValue.get()).floatValue() * 0.1f);
                                break;
                            }
                            if (!Intrinsics.areEqual(string7, "multiply")) break;
                            player.field_70159_w *= ((Number)this.plusMultiplyValue.get()).doubleValue();
                            player.field_70179_y *= ((Number)this.plusMultiplyValue.get()).doubleValue();
                            break;
                        }
                        MovementManager.strafe$default(DarkMeow.INSTANCE.getMovementManager(), 0.0f, 1, null);
                    }
                }
                player.field_70181_x += ((Number)this.addYMotionValue.get()).doubleValue() * 0.03;
                break block47;
            }
            if (((Boolean)this.resetXZValue.get()).booleanValue()) {
                player.field_70159_w = 0.0;
                player.field_70179_y = 0.0;
            }
        }
    }

    private static final boolean launchSpeedValue$lambda$0(CustomSpeed this$0) {
        return (Boolean)this$0.doLaunchSpeedValue.get();
    }

    private static final boolean minimumSpeedValue$lambda$1(CustomSpeed this$0) {
        return (Boolean)this$0.doMinimumSpeedValue.get();
    }

    private static final boolean yValue$lambda$2(CustomSpeed this$0) {
        return (Boolean)this$0.doCustomYValue.get();
    }

    private static final boolean plusModeValue$lambda$3(CustomSpeed this$0) {
        return this$0.strafeValue.equals("Plus") || this$0.strafeValue.equals("PlusOnlyUp") || this$0.strafeValue.equals("PlusOnlyDown");
    }

    private static final boolean plusMultiplyValue$lambda$4(CustomSpeed this$0) {
        return this$0.plusModeValue.equals("Multiply") && (this$0.strafeValue.equals("Plus") || this$0.strafeValue.equals("PlusOnlyUp") || this$0.strafeValue.equals("PlusOnlyDown"));
    }
}

