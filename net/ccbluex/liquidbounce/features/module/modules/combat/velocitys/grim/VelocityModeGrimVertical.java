/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.grim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPVelocityEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.VelocityMode;
import net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.grim.targets.VelocityModeGrimVerticalTargetMode;
import net.ccbluex.liquidbounce.handler.combat.CombatManager;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayerSP;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.utils.minecraft.enums.EnumAnimationMode;
import net.ccbluex.liquidbounce.utils.minecraft.enums.EnumAttackEntityMode;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0003R\u001e\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&\u00a8\u0006("}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/VelocityModeGrimVertical;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/VelocityMode;", "<init>", "()V", "modes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/targets/VelocityModeGrimVerticalTargetMode;", "settingsModuleValues", "", "Lnet/ccbluex/liquidbounce/value/Value;", "sprintModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "attackCountModeValue", "attackCountModeSmartReduceMotionValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "attackCountModeSmartCountLimit", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "dynamicAdjustmentValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "dynamicLowSpeedThresholdValue", "dynamicHighSpeedThresholdValue", "dynamicSpeedBoundaryValue", "getDynamicSpeedBoundaryValue", "()Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "attackCountModeCustomCountValue", "motionSafeValue", "getMotionSafeValue$annotations", "onPlayerSPVelocity", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/move/PlayerSPVelocityEvent;", "findEntity", "Lnet/minecraft/entity/Entity;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "values", "getValues", "()Ljava/util/List;", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nVelocityModeGrimVertical.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VelocityModeGrimVertical.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/VelocityModeGrimVertical\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,298:1\n1#2:299\n1563#3:300\n1634#3,3:301\n1056#3:304\n1869#3:305\n1869#3,2:306\n1870#3:308\n774#3:309\n865#3,2:310\n*S KotlinDebug\n*F\n+ 1 VelocityModeGrimVertical.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/VelocityModeGrimVertical\n*L\n36#1:300\n36#1:301,3\n37#1:304\n38#1:305\n46#1:306,2\n38#1:308\n276#1:309\n276#1:310,2\n*E\n"})
public final class VelocityModeGrimVertical
extends VelocityMode {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Map<String, VelocityModeGrimVerticalTargetMode> modes = new LinkedHashMap();
    @NotNull
    private final List<Value<?>> settingsModuleValues = new ArrayList();
    @JvmField
    @NotNull
    public final ListValue sprintModeValue;
    @JvmField
    @NotNull
    public final ListValue attackCountModeValue;
    @JvmField
    @NotNull
    public final FloatValue attackCountModeSmartReduceMotionValue;
    @JvmField
    @NotNull
    public final IntegerValue attackCountModeSmartCountLimit;
    @JvmField
    @NotNull
    public final BoolValue dynamicAdjustmentValue;
    @JvmField
    @NotNull
    public final FloatValue dynamicLowSpeedThresholdValue;
    @JvmField
    @NotNull
    public final FloatValue dynamicHighSpeedThresholdValue;
    @NotNull
    private final FloatValue dynamicSpeedBoundaryValue;
    @JvmField
    @NotNull
    public final IntegerValue attackCountModeCustomCountValue;
    @JvmField
    @NotNull
    public final BoolValue motionSafeValue;
    @NotNull
    private final List<Value<?>> values;
    public static final double VELOCITY_REDUCE_PER_ATTACK = 0.6;

    /*
     * WARNING - void declaration
     */
    public VelocityModeGrimVertical() {
        super("GrimVertical");
        void $this$values_u24lambda_u2427;
        Object $this$attackCountModeCustomCountValue_u24lambda_u2418;
        Object $this$attackCountModeCustomCountValue_u24lambda_u2417;
        Object $this$dynamicSpeedBoundaryValue_u24lambda_u2416;
        Object $this$dynamicSpeedBoundaryValue_u24lambda_u2415;
        Object $this$dynamicHighSpeedThresholdValue_u24lambda_u2414;
        Object $this$dynamicHighSpeedThresholdValue_u24lambda_u2413;
        Object $this$dynamicLowSpeedThresholdValue_u24lambda_u2412;
        Object $this$dynamicLowSpeedThresholdValue_u24lambda_u2411;
        Object $this$dynamicAdjustmentValue_u24lambda_u2410;
        Object $this$dynamicAdjustmentValue_u24lambda_u249;
        Object $this$attackCountModeSmartCountLimit_u24lambda_u248;
        Object $this$attackCountModeSmartCountLimit_u24lambda_u247;
        Object $this$attackCountModeSmartReduceMotionValue_u24lambda_u246;
        Object $this$attackCountModeSmartReduceMotionValue_u24lambda_u245;
        Object object;
        Object object2;
        String[] stringArray;
        String[] it = stringArray = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".targets.impl", VelocityModeGrimVerticalTargetMode.class);
        boolean bl2 = false;
        Object object3 = object2 = !((Collection)it).isEmpty() ? stringArray : null;
        if (object2 != null) {
            Iterable $this$sortedBy$iv;
            void $this$mapTo$iv$iv;
            List $this$map$iv = (List)object2;
            boolean $i$f$map22 = false;
            List list = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it2;
                Class clazz = (Class)item$iv$iv;
                object = destination$iv$iv;
                boolean bl3 = false;
                object.add((VelocityModeGrimVerticalTargetMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            $this$map$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    VelocityModeGrimVerticalTargetMode it = (VelocityModeGrimVerticalTargetMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = Integer.valueOf(it.getPriority());
                    it = (VelocityModeGrimVerticalTargetMode)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, it.getPriority());
                }
            });
            if ($this$map$iv != null) {
                void $this$forEach$iv;
                $this$sortedBy$iv = $this$map$iv;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    VelocityModeGrimVerticalTargetMode it3 = (VelocityModeGrimVerticalTargetMode)element$iv;
                    boolean bl4 = false;
                    BoolValue subStateValue = new BoolValue(this.getValuePrefix() + "Target" + it3.getName(), false);
                    it3.setInstance(this);
                    it3.setLinkedStateValue(subStateValue);
                    this.settingsModuleValues.add(subStateValue);
                    Iterable $this$forEach$iv2 = it3.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl5 = false;
                        value.setName(this.getValuePrefix() + "Target" + it3.getName() + value.getName());
                        value.setSuperValue(subStateValue);
                        this.settingsModuleValues.add(value);
                    }
                    this.modes.put(it3.getName(), it3);
                }
            }
        }
        object2 = new String[]{"OnlySprinting", "ToggleOn", "ToggleSilent"};
        this.sprintModeValue = new ListValue(this.getValuePrefix() + "SprintMode", (String[])object2, "ToggleOn");
        object2 = new String[]{"Smart", "Custom"};
        this.attackCountModeValue = new ListValue(this.getValuePrefix() + "AttackCountMode", (String[])object2, "Smart");
        stringArray = object2 = new FloatValue(this.getValuePrefix() + "AttackCountModeSmartReduceMotion", 0.05f, (ClosedRange<Float>)RangesKt.rangeTo(0.001f, 1.0f));
        object = this;
        boolean bl6 = false;
        $this$attackCountModeSmartReduceMotionValue_u24lambda_u245.setSuperValue(this.attackCountModeValue);
        $this$attackCountModeSmartReduceMotionValue_u24lambda_u245 = object2;
        boolean bl7 = false;
        $this$attackCountModeSmartReduceMotionValue_u24lambda_u246.setSuperValueMeta("Smart");
        ((VelocityModeGrimVertical)object).attackCountModeSmartReduceMotionValue = object2;
        $this$attackCountModeSmartReduceMotionValue_u24lambda_u246 = object2 = new IntegerValue(this.getValuePrefix() + "AttackCountModeSmartCountLimit", 5, new IntRange(1, 6));
        object = this;
        boolean bl8 = false;
        $this$attackCountModeSmartCountLimit_u24lambda_u247.setSuperValue(this.attackCountModeValue);
        $this$attackCountModeSmartCountLimit_u24lambda_u247 = object2;
        boolean bl9 = false;
        $this$attackCountModeSmartCountLimit_u24lambda_u248.setSuperValueMeta("Smart");
        ((VelocityModeGrimVertical)object).attackCountModeSmartCountLimit = object2;
        $this$attackCountModeSmartCountLimit_u24lambda_u248 = object2 = new BoolValue(this.getValuePrefix() + "DynamicAdjustment", true);
        object = this;
        boolean bl10 = false;
        $this$dynamicAdjustmentValue_u24lambda_u249.setSuperValue(this.attackCountModeValue);
        $this$dynamicAdjustmentValue_u24lambda_u249 = object2;
        boolean bl11 = false;
        $this$dynamicAdjustmentValue_u24lambda_u2410.setSuperValueMeta("Smart");
        ((VelocityModeGrimVertical)object).dynamicAdjustmentValue = object2;
        $this$dynamicAdjustmentValue_u24lambda_u2410 = object2 = new FloatValue(this.getValuePrefix() + "DynamicLowSpeedThreshold", 0.02f, (ClosedRange<Float>)RangesKt.rangeTo(0.001f, 1.0f));
        object = this;
        boolean bl12 = false;
        $this$dynamicLowSpeedThresholdValue_u24lambda_u2411.setSuperValue(this.dynamicAdjustmentValue);
        $this$dynamicLowSpeedThresholdValue_u24lambda_u2411 = object2;
        boolean bl13 = false;
        $this$dynamicLowSpeedThresholdValue_u24lambda_u2412.setSuperValueMeta("true");
        ((VelocityModeGrimVertical)object).dynamicLowSpeedThresholdValue = object2;
        $this$dynamicLowSpeedThresholdValue_u24lambda_u2412 = object2 = new FloatValue(this.getValuePrefix() + "DynamicHighSpeedThreshold", 0.15f, (ClosedRange<Float>)RangesKt.rangeTo(0.01f, 1.0f));
        object = this;
        boolean bl14 = false;
        $this$dynamicHighSpeedThresholdValue_u24lambda_u2413.setSuperValue(this.dynamicAdjustmentValue);
        $this$dynamicHighSpeedThresholdValue_u24lambda_u2413 = object2;
        boolean bl15 = false;
        $this$dynamicHighSpeedThresholdValue_u24lambda_u2414.setSuperValueMeta("true");
        ((VelocityModeGrimVertical)object).dynamicHighSpeedThresholdValue = object2;
        $this$dynamicHighSpeedThresholdValue_u24lambda_u2414 = object2 = new FloatValue(this.getValuePrefix() + "DynamicSpeedBoundary", 0.5f, (ClosedRange<Float>)RangesKt.rangeTo(0.1f, 5.0f));
        object = this;
        boolean bl16 = false;
        $this$dynamicSpeedBoundaryValue_u24lambda_u2415.setSuperValue(this.dynamicAdjustmentValue);
        $this$dynamicSpeedBoundaryValue_u24lambda_u2415 = object2;
        boolean bl17 = false;
        $this$dynamicSpeedBoundaryValue_u24lambda_u2416.setSuperValueMeta("true");
        ((VelocityModeGrimVertical)object).dynamicSpeedBoundaryValue = object2;
        $this$dynamicSpeedBoundaryValue_u24lambda_u2416 = object2 = new IntegerValue(this.getValuePrefix() + "AttackCountModeCustomCount", 5, new IntRange(1, 10));
        object = this;
        boolean bl18 = false;
        $this$attackCountModeCustomCountValue_u24lambda_u2417.setSuperValue(this.attackCountModeValue);
        $this$attackCountModeCustomCountValue_u24lambda_u2417 = object2;
        boolean bl19 = false;
        $this$attackCountModeCustomCountValue_u24lambda_u2418.setSuperValueMeta("Custom");
        ((VelocityModeGrimVertical)object).attackCountModeCustomCountValue = object2;
        this.motionSafeValue = new BoolValue(this.getValuePrefix() + "MotionSafe", false);
        $this$attackCountModeCustomCountValue_u24lambda_u2418 = object2 = (List)new ArrayList();
        object = this;
        boolean bl20 = false;
        $this$values_u24lambda_u2427.add(this.sprintModeValue);
        $this$values_u24lambda_u2427.add(this.attackCountModeValue);
        $this$values_u24lambda_u2427.add(this.attackCountModeSmartReduceMotionValue);
        $this$values_u24lambda_u2427.add(this.attackCountModeSmartCountLimit);
        $this$values_u24lambda_u2427.add(this.attackCountModeCustomCountValue);
        $this$values_u24lambda_u2427.add(this.dynamicAdjustmentValue);
        $this$values_u24lambda_u2427.add(this.dynamicLowSpeedThresholdValue);
        $this$values_u24lambda_u2427.add(this.dynamicHighSpeedThresholdValue);
        $this$values_u24lambda_u2427.add(this.dynamicSpeedBoundaryValue);
        $this$values_u24lambda_u2427.addAll((Collection)this.settingsModuleValues);
        $this$values_u24lambda_u2427.add(this.motionSafeValue);
        ((VelocityModeGrimVertical)object).values = object2;
    }

    @NotNull
    public final FloatValue getDynamicSpeedBoundaryValue() {
        return this.dynamicSpeedBoundaryValue;
    }

    public static /* synthetic */ void getMotionSafeValue$annotations() {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @EventTarget(ignoreCanceled=true)
    public final void onPlayerSPVelocity(@NotNull PlayerSPVelocityEvent event) {
        block19: {
            block17: {
                block18: {
                    Intrinsics.checkNotNullParameter(event, "event");
                    v0 = MinecraftInstance.mc.getPlayer();
                    if (v0 == null) {
                        return;
                    }
                    player = v0;
                    v1 = MinecraftInstance.mc.getConnection();
                    if (v1 == null) {
                        return;
                    }
                    connection = v1;
                    if (((Boolean)this.motionSafeValue.get()).booleanValue()) {
                        var4_4 = player.field_70181_x;
                        if (!(-0.2 <= var4_4 ? var4_4 <= 0.2 : false)) {
                            return;
                        }
                    }
                    if ((var4_5 = this.findEntity(player)) == null) ** GOTO lbl-1000
                    it = var6_6 = var4_5;
                    $i$a$-takeIf-VelocityModeGrimVertical$onPlayerSPVelocity$1 = false;
                    if (ExtendEntityPlayerSP.INSTANCE.getServerSprintState(event.player)) break block17;
                    var9_10 = (String)this.sprintModeValue.get();
                    switch (var9_10.hashCode()) {
                        case 1274659049: {
                            if (!var9_10.equals("ToggleSilent")) {
                                ** break;
                            }
                            break block18;
                        }
                        case -1151884173: {
                            if (var9_10.equals("ToggleOn")) break;
                            ** break;
                        }
                        case -56542948: {
                            if (!var9_10.equals("OnlySprinting")) ** break;
                            v2 = event.player.func_70051_ag();
                            break block19;
                        }
                    }
                    connection.func_147297_a((Packet)new CPacketEntityAction((Entity)event.player, CPacketEntityAction.Action.START_SPRINTING));
                    ExtendEntityPlayerSP.INSTANCE.setServerSprintState(event.player, true);
                    event.player.func_70031_b(true);
                    v2 = true;
                    break block19;
                }
                connection.func_147297_a((Packet)new CPacketEntityAction((Entity)event.player, CPacketEntityAction.Action.START_SPRINTING));
                event.player.func_70031_b(true);
                v2 = true;
                break block19;
lbl41:
                // 4 sources

                v2 = false;
                break block19;
            }
            v2 = true;
        }
        v3 /* !! */  = var5_12 = v2 != false ? var6_6 : null;
        if (var5_12 != null) {
            entity = var6_6 = var5_12;
            $i$a$-also-VelocityModeGrimVertical$onPlayerSPVelocity$2 = false;
            var9_10 = (String)this.attackCountModeValue.get();
            if (Intrinsics.areEqual(var9_10, "Smart")) {
                motionX = event.motionX;
                motionZ = event.motionZ;
                speed = Math.sqrt(motionX * motionX + motionZ * motionZ);
                threshold = ((Boolean)this.dynamicAdjustmentValue.get()).booleanValue() ? (speed >= (double)((Number)this.dynamicSpeedBoundaryValue.get()).floatValue() ? ((Number)this.dynamicHighSpeedThresholdValue.get()).floatValue() : ((Number)this.dynamicLowSpeedThresholdValue.get()).floatValue()) : ((Number)this.attackCountModeSmartReduceMotionValue.get()).floatValue();
                currentCount = 0;
                currentMotionX = motionX;
                for (currentMotionZ = motionZ; (currentMotionX > (double)threshold || currentMotionZ > (double)threshold) && currentCount < ((Number)this.attackCountModeSmartCountLimit.get()).intValue(); currentMotionX *= 0.6, currentMotionZ *= 0.6, ++currentCount) {
                }
                this.getInstance().debug("Current Speed: " + speed + ", Threshold: " + threshold + ", Attack Count: " + currentCount);
                v4 = currentCount;
            } else {
                v4 = Intrinsics.areEqual(var9_10, "Custom") != false ? ((Number)this.attackCountModeCustomCountValue.get()).intValue() : 0;
            }
            count = var9_11 = v4;
            $i$a$-also-VelocityModeGrimVertical$onPlayerSPVelocity$2$1 = false;
            var24_22 = 0;
            while (var24_22 < count) {
                it = var24_22++;
                $i$a$-repeat-VelocityModeGrimVertical$onPlayerSPVelocity$2$1$1 = false;
                CombatManager.attackEntity$default(DarkMeow.INSTANCE.getCombatManager(), entity, EnumAnimationMode.PACKET, null, EnumAttackEntityMode.PACKET, false, 20, null);
                PlayerSPVelocityEvent.setReduceMotion$default(event, 0.6, 0.0, 2, null);
            }
            count = var9_11;
            $i$a$-also-VelocityModeGrimVertical$onPlayerSPVelocity$2$2 = false;
            var24_23 = new String[]{"GrimNoXZ Attack(entityId=" + entity.func_145782_y(), "type=" + entity.getClass().getSimpleName(), "distance=" + event.player.func_70032_d(entity), "motion=[" + event.motionX + ", " + event.motionY + ", " + event.motionZ + ']', "count=" + count + ')'};
            this.getInstance().debug(ArraysKt.joinToString$default(var24_23, (CharSequence)", ", null, null, 0, null, null, 62, null));
            v5 = var6_6;
        } else lbl-1000:
        // 2 sources

        {
            v5 = null;
        }
        it = var4_5 = v5;
        $i$a$-also-VelocityModeGrimVertical$onPlayerSPVelocity$3 = false;
        if (!ExtendEntityPlayerSP.INSTANCE.getServerSprintState(event.player) && Intrinsics.areEqual((String)this.sprintModeValue.get(), "ToggleSilent")) {
            connection.func_147297_a((Packet)new CPacketEntityAction((Entity)event.player, CPacketEntityAction.Action.STOP_SPRINTING));
        }
    }

    /*
     * WARNING - void declaration
     */
    private final Entity findEntity(EntityPlayerSP player) {
        Iterable iterable;
        block2: {
            void $this$filterTo$iv$iv;
            Iterable $this$filter$iv = this.modes.values();
            boolean $i$f$filter = false;
            Iterable iterable2 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                VelocityModeGrimVerticalTargetMode it = (VelocityModeGrimVerticalTargetMode)element$iv$iv;
                boolean bl2 = false;
                if (!((Boolean)it.getLinkedStateValue().get()).booleanValue()) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            for (VelocityModeGrimVerticalTargetMode it : (Iterable)((List)destination$iv$iv)) {
                boolean bl3 = false;
                iterable2 = it.findTarget(player);
                if (iterable2 == null) continue;
                iterable = iterable2;
                break block2;
            }
            iterable = null;
        }
        return iterable;
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return this.values;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/VelocityModeGrimVertical$Companion;", "", "<init>", "()V", "VELOCITY_REDUCE_PER_ATTACK", "", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

