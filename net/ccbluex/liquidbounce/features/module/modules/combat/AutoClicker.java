/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemSword
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.input.Mouse
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.extend.ExtendKeyBinding;
import net.ccbluex.liquidbounce.injection.extend.ExtendPlayerControllerMP;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.misc.RandomUtils;
import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerRangeValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.utils.math.MathUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSword;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Mouse;

@ModuleInfo(name="AutoClicker", category=ModuleCategory.COMBAT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0007J\u0010\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020(H\u0007J\b\u0010)\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoClicker;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "legitJitterValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "legitButterflyValue", "normalCPSValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "rightValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "rightBlockOnlyValue", "leftValue", "leftSwordOnlyValue", "breakStopValue", "blockValue", "blockOnClick", "jitterValue", "gaussianCpsValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "gaussianSigmaValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "gaussianClickDelay", "", "rightDelay", "", "rightLastSwing", "leftDelay", "leftLastSwing", "delayNum", "", "cDelay", "onRender", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onEnable", "gaussianUpdateDelay", "updateClicks", "DarkMeow"})
public final class AutoClicker
extends Module {
    @NotNull
    private final ListValue modeValue;
    @NotNull
    private final Value<String> legitJitterValue;
    @NotNull
    private final Value<String> legitButterflyValue;
    @NotNull
    private final IntegerRangeValue normalCPSValue;
    @NotNull
    private final BoolValue rightValue;
    @NotNull
    private final BoolValue rightBlockOnlyValue;
    @NotNull
    private final BoolValue leftValue;
    @NotNull
    private final BoolValue leftSwordOnlyValue;
    @NotNull
    private final BoolValue breakStopValue;
    @NotNull
    private final BoolValue blockValue;
    @NotNull
    private final BoolValue blockOnClick;
    @NotNull
    private final BoolValue jitterValue;
    @NotNull
    private final IntegerValue gaussianCpsValue;
    @NotNull
    private final FloatValue gaussianSigmaValue;
    private float gaussianClickDelay;
    private long rightDelay;
    private long rightLastSwing;
    private long leftDelay;
    private long leftLastSwing;
    private int delayNum;
    private int cDelay;

    public AutoClicker() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"Normal", "Gaussian", "LegitJitter", "LegitButterfly"};
        this.modeValue = new ListValue("Mode", stringArray, "Normal");
        stringArray = new String[]{"Jitter1", "Jitter2", "Jitter3", "SimpleJitter"};
        this.legitJitterValue = new ListValue("LegitJitterMode", stringArray, "Jitter1").displayable(() -> AutoClicker.legitJitterValue$lambda$0(this));
        stringArray = new String[]{"Butterfly1", "Butterfly2"};
        this.legitButterflyValue = new ListValue("LegitButterflyMode", stringArray, "Butterfly1").displayable(() -> AutoClicker.legitButterflyValue$lambda$1(this));
        this.normalCPSValue = new IntegerRangeValue("Normal-CPS", new IntRange(5, 8), new IntRange(1, 40));
        this.rightValue = new BoolValue("RightClick", true);
        this.rightBlockOnlyValue = new BoolValue("RightBlockOnly", false);
        this.leftValue = new BoolValue("LeftClick", true);
        this.leftSwordOnlyValue = new BoolValue("LeftSwordOnly", false);
        this.breakStopValue = new BoolValue("BreakingStop", true);
        this.blockValue = new BoolValue("AutoBlock", false);
        this.blockOnClick = new BoolValue("AutoBlockOnRightClick", true);
        this.jitterValue = new BoolValue("Jitter", false);
        this.gaussianCpsValue = new IntegerValue("Gaussian-CPS", 5, 1, 40);
        this.gaussianSigmaValue = new FloatValue("Gaussian-Sigma", 0.5f, 0.1f, 5.0f);
        this.rightDelay = 50L;
        this.leftDelay = 50L;
    }

    @EventTarget
    public final void onRender(@NotNull Render3DEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (MinecraftInstance.mc.getGameSettings().field_74312_F.func_151470_d() && ((Boolean)this.leftValue.get()).booleanValue() && System.currentTimeMillis() - this.leftLastSwing >= this.leftDelay && (!((Boolean)this.leftSwordOnlyValue.get()).booleanValue() || player.func_184614_ca().func_77973_b() instanceof ItemSword) && (!((Boolean)this.breakStopValue.get()).booleanValue() || ExtendPlayerControllerMP.INSTANCE.getCurBlockDamageMP(MinecraftInstance.mc.getPlayerController()) == 0.0f)) {
            KeyBinding.func_74507_a((int)MinecraftInstance.mc.getGameSettings().field_74312_F.func_151463_i());
            this.leftLastSwing = System.currentTimeMillis();
            this.leftDelay = this.updateClicks();
        }
        if (MinecraftInstance.mc.getGameSettings().field_74313_G.func_151470_d() && !player.func_184587_cr() && ((Boolean)this.rightValue.get()).booleanValue() && System.currentTimeMillis() - this.rightLastSwing >= this.rightDelay && (!((Boolean)this.rightBlockOnlyValue.get()).booleanValue() || player.func_184614_ca().func_77973_b() instanceof ItemBlock) && ((Boolean)this.rightValue.get()).booleanValue()) {
            KeyBinding.func_74507_a((int)MinecraftInstance.mc.getGameSettings().field_74313_G.func_151463_i());
            this.rightLastSwing = System.currentTimeMillis();
            this.rightDelay = (long)this.updateClicks() - 1L;
        }
        if (((Boolean)this.blockValue.get()).booleanValue() && player.func_184614_ca().func_77973_b() instanceof ItemSword && MinecraftInstance.mc.getGameSettings().field_74312_F.func_151470_d() && ((Boolean)this.leftValue.get()).booleanValue() && ((Boolean)this.blockOnClick.get()).booleanValue() && Mouse.isButtonDown((int)1) && (!((Boolean)this.breakStopValue.get()).booleanValue() || ExtendPlayerControllerMP.INSTANCE.getCurBlockDamageMP(MinecraftInstance.mc.getPlayerController()) == 0.0f)) {
            KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74313_G;
            Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindUseItem");
            ExtendKeyBinding.INSTANCE.setPressed(keyBinding, false);
        }
        if (((Boolean)this.blockValue.get()).booleanValue() && player.func_184614_ca().func_77973_b() instanceof ItemSword && MinecraftInstance.mc.getGameSettings().field_74312_F.func_151470_d() && ((Boolean)this.leftValue.get()).booleanValue() && (!((Boolean)this.breakStopValue.get()).booleanValue() || ExtendPlayerControllerMP.INSTANCE.getCurBlockDamageMP(MinecraftInstance.mc.getPlayerController()) == 0.0f)) {
            if ((double)(System.currentTimeMillis() - this.leftLastSwing) >= (double)this.leftDelay * 0.1 && (double)(System.currentTimeMillis() - this.leftLastSwing) <= (double)this.leftDelay * 0.8) {
                if (((Boolean)this.blockOnClick.get()).booleanValue()) {
                    if (Mouse.isButtonDown((int)1)) {
                        KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74313_G;
                        Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindUseItem");
                        ExtendKeyBinding.INSTANCE.setPressed(keyBinding, true);
                    }
                } else {
                    KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74313_G;
                    Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindUseItem");
                    ExtendKeyBinding.INSTANCE.setPressed(keyBinding, true);
                }
            } else {
                KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74313_G;
                Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindUseItem");
                ExtendKeyBinding.INSTANCE.setPressed(keyBinding, false);
            }
        }
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (((Boolean)this.jitterValue.get()).booleanValue() && (((Boolean)this.leftValue.get()).booleanValue() && MinecraftInstance.mc.getGameSettings().field_74312_F.func_151470_d() || ((Boolean)this.rightValue.get()).booleanValue() && MinecraftInstance.mc.getGameSettings().field_74313_G.func_151470_d() && !player.func_184587_cr())) {
            if (Random.Default.nextBoolean()) {
                player.field_70177_z = player.field_70177_z + (Random.Default.nextBoolean() ? -RandomUtils.INSTANCE.nextFloat(0.0f, 1.0f) : RandomUtils.INSTANCE.nextFloat(0.0f, 1.0f));
            }
            if (Random.Default.nextBoolean()) {
                player.field_70125_A = player.field_70125_A + (Random.Default.nextBoolean() ? -RandomUtils.INSTANCE.nextFloat(0.0f, 1.0f) : RandomUtils.INSTANCE.nextFloat(0.0f, 1.0f));
                if (player.field_70125_A > 90.0f) {
                    player.field_70125_A = 90.0f;
                } else if (player.field_70125_A < -90.0f) {
                    player.field_70125_A = -90.0f;
                }
            }
        }
    }

    @Override
    public void onEnable() {
        if (this.modeValue.equals("Gaussian")) {
            this.gaussianUpdateDelay();
        }
    }

    private final float gaussianUpdateDelay() {
        this.gaussianClickDelay = 1000.0f / RangesKt.coerceAtLeast(MathUtils.INSTANCE.calculateGaussianValue(((Number)this.gaussianCpsValue.get()).intValue(), ((Number)this.gaussianSigmaValue.get()).floatValue()), 1.0f);
        return this.gaussianClickDelay;
    }

    /*
     * Unable to fully structure code
     */
    private final int updateClicks() {
        random = Random.Default;
        var3_2 = (String)this.modeValue.get();
        v0 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(v0, "getDefault(...)");
        v1 = var3_2.toLowerCase(v0);
        Intrinsics.checkNotNullExpressionValue(v1, "toLowerCase(...)");
        var2_3 = v1;
        tmp = -1;
        switch (var2_3.hashCode()) {
            case -1039745817: {
                if (var2_3.equals("normal")) {
                    tmp = 1;
                }
                break;
            }
            case 1056334554: {
                if (var2_3.equals("legitbutterfly")) {
                    tmp = 2;
                }
                break;
            }
            case -1526272517: {
                if (var2_3.equals("gaussian")) {
                    tmp = 3;
                }
                break;
            }
            case 663471589: {
                if (var2_3.equals("legitjitter")) {
                    tmp = 4;
                }
                break;
            }
        }
        switch (tmp) {
            case 1: {
                this.cDelay = (int)TimeUtils.randomClickDelay(((Number)this.normalCPSValue.getRange().getStart()).intValue(), ((Number)this.normalCPSValue.getRange().getEndInclusive()).intValue());
                break;
            }
            case 3: {
                this.gaussianUpdateDelay();
                this.cDelay = (int)this.gaussianClickDelay;
                break;
            }
            case 4: {
                var4_4 = this.legitJitterValue.get();
                v2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(v2, "getDefault(...)");
                v3 = var4_4.toLowerCase(v2);
                Intrinsics.checkNotNullExpressionValue(v3, "toLowerCase(...)");
                var3_2 = v3;
                switch (var3_2.hashCode()) {
                    case -729516770: {
                        if (!var3_2.equals("simplejitter")) {
                            ** break;
                        }
                        ** GOTO lbl83
                    }
                    case -1592111930: {
                        if (var3_2.equals("jitter2")) break;
                        ** break;
                    }
                    case -1592111929: {
                        if (!var3_2.equals("jitter3")) {
                            ** break;
                        }
                        ** GOTO lbl73
                    }
                    case -1592111931: {
                        if (!var3_2.equals("jitter1")) ** break;
                        if (random.nextInt(1, 5) == 1) {
                            this.delayNum = 0;
                        }
                        if (this.delayNum == 0) {
                            this.cDelay = random.nextInt(1, 3) == 1 ? random.nextInt(98, 110) : (random.nextInt(1, 2) == 1 ? random.nextInt(125, 138) : random.nextInt(148, 153));
                            this.delayNum = 1;
                            ** break;
                        }
                        if (random.nextInt(1, 4) == 1) ** break;
                        this.cDelay = random.nextBoolean() != false ? random.nextInt(65, 69) : (random.nextInt(1, 5) == 1 ? random.nextInt(81, 87) : random.nextInt(97, 101));
                        ** break;
                    }
                }
                this.cDelay = random.nextInt(1, 14) <= 3 ? (random.nextInt(1, 3) == 1 ? random.nextInt(98, 102) : random.nextInt(114, 117)) : (random.nextInt(1, 4) == 1 ? random.nextInt(64, 69) : random.nextInt(83, 85));
                break;
lbl73:
                // 1 sources

                if (random.nextInt(1, 5) == 1 && this.delayNum == 0) {
                    this.delayNum = 1;
                    this.cDelay = random.nextInt(1, 4) == 1 ? random.nextInt(114, 118) : random.nextInt(98, 104);
                    break;
                }
                if (this.delayNum == 1) {
                    this.delayNum = 0;
                    this.cDelay = random.nextInt(65, 70);
                    break;
                }
                this.cDelay = random.nextInt(84, 88);
                break;
lbl83:
                // 1 sources

                if (random.nextInt(1, 5) == 1) {
                    this.cDelay = random.nextBoolean() != false ? random.nextInt(105, 110) : random.nextInt(120, 128);
                    break;
                }
                this.cDelay = random.nextInt(1, 3) == 1 ? random.nextInt(76, 79) : (random.nextBoolean() != false ? 78 : 77);
lbl87:
                // 9 sources

                break;
            }
            case 2: {
                var4_5 = this.legitButterflyValue.get();
                v4 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(v4, "getDefault(...)");
                v5 = var4_5.toLowerCase(v4);
                Intrinsics.checkNotNullExpressionValue(v5, "toLowerCase(...)");
                var3_2 = v5;
                if (Intrinsics.areEqual(var3_2, "butterfly1")) {
                    this.cDelay = random.nextInt(1, 7) == 1 ? random.nextInt(80, 104) : (random.nextInt(1, 7) <= 2 ? 117 : random.nextInt(114, 119));
                    break;
                }
                if (!Intrinsics.areEqual(var3_2, "butterfly2")) break;
                if (random.nextInt(1, 10) == 1) {
                    v6 = random.nextInt(225, 250);
                } else {
                    switch (random.nextInt(1, 6)) {
                        case 1: {
                            v6 = random.nextInt(89, 94);
                            break;
                        }
                        case 2: {
                            v6 = random.nextInt(95, 103);
                            break;
                        }
                        case 3: {
                            v6 = random.nextInt(115, 123);
                            break;
                        }
                        default: {
                            v6 = random.nextBoolean() != false ? random.nextInt(131, 136) : random.nextInt(165, 174);
                        }
                    }
                }
                this.cDelay = v6;
            }
        }
        return this.cDelay;
    }

    private static final boolean legitJitterValue$lambda$0(AutoClicker this$0) {
        return Intrinsics.areEqual(this$0.modeValue.get(), "LegitJitter");
    }

    private static final boolean legitButterflyValue$lambda$1(AutoClicker this$0) {
        return Intrinsics.areEqual(this$0.modeValue.get(), "LegitButterfly");
    }
}

