/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.event.events.player.PlayerSPLookEvent;
import net.ccbluex.liquidbounce.event.events.player.control.UpdateMouseOverEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPUpdateWalkingEvent;
import net.ccbluex.liquidbounce.event.events.tick.TickProcessKeyBindsEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.base.ModuleBaseConfig;
import net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura.KillAuraExtend;
import net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura.KillAuraRotation;
import net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura.manager.KillAuraTargetManager;
import net.ccbluex.liquidbounce.handler.combat.CombatManager;
import net.ccbluex.liquidbounce.handler.combat.targets.TargetsManager;
import net.ccbluex.liquidbounce.handler.movement.stuck.MovementStuckManagerExtend;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.ccbluex.liquidbounce.handler.rotation.data.RotationTask;
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.impl.MovementModeSmart;
import net.ccbluex.liquidbounce.handler.rotation.value.MovementModeValue;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayerSP;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.utils.math.RandomUtils;
import net.ccbluex.liquidbounce.utils.minecraft.enums.EnumAnimationMode;
import net.ccbluex.liquidbounce.utils.minecraft.enums.EnumAttackEntityMode;
import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
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
import net.darkmeow.darkmeow.utils.movement.ray_cast.through_wall.ThroughWallCheck;
import net.darkmeow.darkmeow.utils.movement.ray_cast.through_wall.impl.ThroughWallCheckExpand;
import net.darkmeow.darkmeow.utils.movement.ray_cast.through_wall.impl.ThroughWallCheckLimit;
import net.darkmeow.darkmeow.utils.world.WorldUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020NH\u0016J\b\u0010P\u001a\u00020QH\u0002J\u0010\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020TH\u0002J\u000e\u0010U\u001a\u00020Q2\u0006\u0010S\u001a\u00020VJ\n\u0010W\u001a\u00020N*\u00020XJ\u0012\u0010Y\u001a\u00020N*\u00020X2\u0006\u0010S\u001a\u00020TJ\u0010\u0010Z\u001a\u00020Q2\u0006\u0010S\u001a\u00020VH\u0002R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010!\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010#\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010%\u001a\u00020&\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0011\u0010+\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0018R\u0011\u0010-\u001a\u00020.\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u0011\u00103\u001a\u00020.\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00100R\u0011\u00105\u001a\u00020&\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u0011\u00107\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0018R\u0011\u00109\u001a\u00020:\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010=\u001a\u00020&\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010(R\u0011\u0010?\u001a\u00020.\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u00100R\u0011\u0010A\u001a\u00020.\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u00100R\u0011\u0010C\u001a\u00020&\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010(R\u0011\u0010E\u001a\u00020.\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u00100R\u0011\u0010G\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0018R\u0011\u0010I\u001a\u00020J\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0014\u0010[\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\\\u0010]\u00a8\u0006^"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "extends", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/KillAuraExtend;", "getExtends", "()Ljava/util/Map;", "rotations", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/KillAuraRotation;", "getRotations", "targetManager", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/manager/KillAuraTargetManager;", "getTargetManager", "()Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/manager/KillAuraTargetManager;", "cpsValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "getCpsValue", "()Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "atValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "getAtValue", "()Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "attackRangeModeValue", "getAttackRangeModeValue", "attackRangeCustomNormalValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "getAttackRangeCustomNormalValue", "()Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "attackRangeCustomThroughWallValue", "getAttackRangeCustomThroughWallValue", "attackRangeCustomThroughWallLimitRangeValue", "getAttackRangeCustomThroughWallLimitRangeValue", "attackRangeCustomThroughWallExpandRangeValue", "getAttackRangeCustomThroughWallExpandRangeValue", "backTrackValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "getBackTrackValue", "()Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "backTrackAttackRangeValue", "getBackTrackAttackRangeValue", "backTrackAttackModeValue", "getBackTrackAttackModeValue", "backTrackAttackMultiLimitValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "getBackTrackAttackMultiLimitValue", "()Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "rotationRangeValue", "getRotationRangeValue", "rotationKeepTickValue", "getRotationKeepTickValue", "rotationOnStuckValue", "getRotationOnStuckValue", "rotationModeValue", "getRotationModeValue", "rotationStrafeValue", "Lnet/ccbluex/liquidbounce/handler/rotation/value/MovementModeValue;", "getRotationStrafeValue", "()Lnet/ccbluex/liquidbounce/handler/rotation/value/MovementModeValue;", "failHitValue", "getFailHitValue", "failHitRandomRateValue", "getFailHitRandomRateValue", "failHitHurtTimeValue", "getFailHitHurtTimeValue", "failHitAnimationValue", "getFailHitAnimationValue", "failHitAnimationRateValue", "getFailHitAnimationRateValue", "failHitAnimationModeValue", "getFailHitAnimationModeValue", "attackDelay", "Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "getAttackDelay", "()Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "onEnable", "", "onDisable", "isCancelRun", "", "checkFailHit", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "isEnemy", "Lnet/minecraft/entity/Entity;", "runAttack", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "attackEntity", "updateRotations", "tag", "getTag", "()Ljava/lang/String;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nKillAura.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KillAura.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,421:1\n1#2:422\n1#2:510\n1869#3,2:423\n1563#3:425\n1634#3,3:426\n1056#3:429\n1869#3:430\n1869#3,2:431\n1870#3:433\n1563#3:438\n1634#3,3:439\n1056#3:442\n1869#3:443\n1869#3,2:444\n1870#3:446\n774#3:461\n865#3,2:462\n1869#3,2:464\n774#3:466\n865#3,2:467\n1869#3,2:469\n774#3:473\n865#3,2:474\n808#3,11:476\n774#3:487\n865#3,2:488\n774#3:490\n865#3,2:491\n1869#3,2:493\n774#3:495\n865#3,2:496\n1740#3,3:498\n774#3:501\n865#3,2:502\n1869#3,2:504\n1761#3,3:506\n2756#3:509\n1761#3,3:511\n37#4:434\n36#4,3:435\n20#5,3:447\n20#5,3:450\n20#5,3:453\n20#5,3:456\n21#5,2:459\n12637#6,2:471\n*S KotlinDebug\n*F\n+ 1 KillAura.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura\n*L\n228#1:510\n135#1:423,2\n146#1:425\n146#1:426,3\n147#1:429\n148#1:430\n151#1:431,2\n148#1:433\n172#1:438\n172#1:439,3\n173#1:442\n174#1:443\n182#1:444,2\n174#1:446\n200#1:461\n200#1:462,2\n201#1:464,2\n206#1:466\n206#1:467,2\n207#1:469,2\n349#1:473\n349#1:474,2\n355#1:476,11\n359#1:487\n359#1:488,2\n372#1:490\n372#1:491,2\n376#1:493,2\n383#1:495\n383#1:496,2\n384#1:498,3\n391#1:501\n391#1:502,2\n392#1:504,2\n242#1:506,3\n228#1:509\n337#1:511,3\n163#1:434\n163#1:435,3\n214#1:447,3\n217#1:450,3\n220#1:453,3\n256#1:456,3\n273#1:459,2\n297#1:471,2\n*E\n"})
public final class KillAura
extends Module {
    @NotNull
    private final Map<String, KillAuraExtend> extends;
    @NotNull
    private final Map<String, KillAuraRotation> rotations;
    @NotNull
    private final KillAuraTargetManager targetManager;
    @NotNull
    private final IntegerRangeValue cpsValue;
    @NotNull
    private final ListValue atValue;
    @NotNull
    private final ListValue attackRangeModeValue;
    @NotNull
    private final FloatValue attackRangeCustomNormalValue;
    @NotNull
    private final ListValue attackRangeCustomThroughWallValue;
    @NotNull
    private final FloatValue attackRangeCustomThroughWallLimitRangeValue;
    @NotNull
    private final FloatValue attackRangeCustomThroughWallExpandRangeValue;
    @NotNull
    private final BoolValue backTrackValue;
    @NotNull
    private final FloatValue backTrackAttackRangeValue;
    @NotNull
    private final ListValue backTrackAttackModeValue;
    @NotNull
    private final IntegerValue backTrackAttackMultiLimitValue;
    @NotNull
    private final FloatValue rotationRangeValue;
    @NotNull
    private final IntegerValue rotationKeepTickValue;
    @NotNull
    private final BoolValue rotationOnStuckValue;
    @NotNull
    private final ListValue rotationModeValue;
    @NotNull
    private final MovementModeValue rotationStrafeValue;
    @NotNull
    private final BoolValue failHitValue;
    @NotNull
    private final IntegerValue failHitRandomRateValue;
    @NotNull
    private final IntegerValue failHitHurtTimeValue;
    @NotNull
    private final BoolValue failHitAnimationValue;
    @NotNull
    private final IntegerValue failHitAnimationRateValue;
    @NotNull
    private final ListValue failHitAnimationModeValue;
    @NotNull
    private final MSDelay attackDelay;

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public KillAura() {
        block14: {
            Unit unit;
            Iterator iterator2;
            Value value;
            boolean $i$f$forEach;
            block13: {
                block12: {
                    List<Class<KillAuraExtend>> list;
                    List<Class<KillAuraExtend>> list2;
                    Object thisCollection$iv;
                    void it;
                    boolean $i$f$mapTo22;
                    Object object;
                    block11: {
                        Unit unit2;
                        Unit unit3;
                        Iterator $i$f$mapTo22;
                        block10: {
                            block9: {
                                List<Class<KillAuraRotation>> list3;
                                List<Class<KillAuraRotation>> list4;
                                ListValue listValue;
                                IntegerValue integerValue;
                                BoolValue boolValue;
                                IntegerValue integerValue2;
                                IntegerValue integerValue3;
                                IntegerValue integerValue4;
                                IntegerValue integerValue5;
                                ListValue listValue2;
                                FloatValue floatValue;
                                FloatValue floatValue2;
                                FloatValue floatValue3;
                                FloatValue floatValue4;
                                FloatValue floatValue5;
                                ListValue listValue3;
                                ListValue listValue4;
                                FloatValue floatValue6;
                                FloatValue floatValue7;
                                super("KillAura", ModuleCategory.COMBAT, new ModuleBaseConfig(19, null, false, false, 14, null), null, 8, null);
                                this.extends = new LinkedHashMap();
                                this.rotations = new LinkedHashMap();
                                this.targetManager = new KillAuraTargetManager();
                                this.cpsValue = new IntegerRangeValue("CPS", new IntRange(5, 18), new IntRange(1, 20));
                                String[] stringArray = new String[]{"Tick", "Update"};
                                this.atValue = new ListValue("At", stringArray, "Update");
                                String[] stringArray2 = new String[]{"Vanilla", "Custom"};
                                this.attackRangeModeValue = new ListValue("AttackRangeMode", stringArray2, "Custom");
                                FloatValue floatValue8 = floatValue7 = new FloatValue("AttackRangeCustomNormal", 2.9f, (ClosedRange<Float>)RangesKt.rangeTo(0.1f, 8.0f));
                                object = this;
                                boolean bl2 = false;
                                floatValue8.setSuperValue(this.attackRangeModeValue);
                                FloatValue floatValue9 = floatValue6 = floatValue7;
                                boolean bl3 = false;
                                floatValue9.setSuperValueMeta("Custom");
                                ((KillAura)object).attackRangeCustomNormalValue = floatValue6;
                                String[] stringArray3 = new String[]{"Disable", "Expand", "Limit"};
                                ListValue listValue5 = listValue4 = new ListValue("AttackRangeCustomThroughWall", stringArray3, "Limit");
                                object = this;
                                boolean bl4 = false;
                                listValue5.setSuperValue(this.attackRangeModeValue);
                                ListValue listValue6 = listValue3 = listValue4;
                                boolean bl5 = false;
                                listValue6.setSuperValueMeta("Custom");
                                ((KillAura)object).attackRangeCustomThroughWallValue = listValue3;
                                FloatValue floatValue10 = floatValue5 = new FloatValue("AttackRangeCustomThroughWallLimitRange", 1.0f, (ClosedRange<Float>)RangesKt.rangeTo(0.1f, 8.0f));
                                object = this;
                                boolean bl6 = false;
                                floatValue10.setSuperValue(this.attackRangeCustomThroughWallValue);
                                FloatValue floatValue11 = floatValue4 = floatValue5;
                                boolean bl7 = false;
                                floatValue11.setSuperValueMeta("Limit");
                                ((KillAura)object).attackRangeCustomThroughWallLimitRangeValue = floatValue4;
                                FloatValue floatValue12 = floatValue3 = new FloatValue("AttackRangeCustomThroughWallExpandRange", 1.0f, (ClosedRange<Float>)RangesKt.rangeTo(0.1f, 8.0f));
                                object = this;
                                boolean bl8 = false;
                                floatValue12.setSuperValue(this.attackRangeCustomThroughWallValue);
                                FloatValue floatValue13 = floatValue2 = floatValue3;
                                boolean bl9 = false;
                                floatValue13.setSuperValueMeta("Expand");
                                ((KillAura)object).attackRangeCustomThroughWallExpandRangeValue = floatValue2;
                                this.backTrackValue = new BoolValue("BackTrack", true);
                                FloatValue floatValue14 = floatValue = new FloatValue("BackTrackAttackRange", 6.0f, (ClosedRange<Float>)RangesKt.rangeTo(0.1f, 8.0f));
                                object = this;
                                boolean bl10 = false;
                                floatValue14.setSuperValue(this.backTrackValue);
                                ((KillAura)object).backTrackAttackRangeValue = floatValue;
                                String[] stringArray4 = new String[]{"LastRayTrace", "RayTracesFirst", "RayTracesLast", "RayTracesRandom", "RayTracesMulti"};
                                ListValue listValue7 = listValue2 = new ListValue("BackTrackAttackMode", stringArray4, "LastRayTrace");
                                object = this;
                                boolean bl11 = false;
                                listValue7.setSuperValue(this.backTrackValue);
                                ((KillAura)object).backTrackAttackModeValue = listValue2;
                                IntegerValue integerValue6 = integerValue5 = new IntegerValue("BackTrackAttackMultiLimit", 4, new IntRange(1, 10));
                                object = this;
                                boolean bl12 = false;
                                integerValue6.setSuperValue(this.backTrackAttackModeValue);
                                IntegerValue integerValue7 = integerValue4 = integerValue5;
                                boolean bl13 = false;
                                integerValue7.setSuperValueMeta("Multi");
                                ((KillAura)object).backTrackAttackMultiLimitValue = integerValue4;
                                this.rotationRangeValue = new FloatValue("RotationRange", 3.8f, (ClosedRange<Float>)RangesKt.rangeTo(0.1f, 8.0f));
                                this.rotationKeepTickValue = new IntegerValue("RotationKeepTick", 2, new IntRange(0, 20));
                                this.rotationOnStuckValue = new BoolValue("RotationOnStuck", false);
                                this.rotationModeValue = new ListValue("RotationMode", null, "Closest", 2, null);
                                this.rotationStrafeValue = new MovementModeValue("RotationStrafe", MovementModeSmart.INSTANCE);
                                this.failHitValue = new BoolValue("FailHit", true);
                                IntegerValue integerValue8 = integerValue3 = new IntegerValue("FailHitRandomRate", 0, new IntRange(0, 100));
                                object = this;
                                boolean bl14 = false;
                                integerValue8.setSuperValue(this.failHitValue);
                                ((KillAura)object).failHitRandomRateValue = integerValue3;
                                IntegerValue integerValue9 = integerValue2 = new IntegerValue("FailHitHurTime", 10, new IntRange(0, 10));
                                object = this;
                                boolean bl15 = false;
                                integerValue9.setSuperValue(this.failHitValue);
                                ((KillAura)object).failHitHurtTimeValue = integerValue2;
                                BoolValue boolValue2 = boolValue = new BoolValue("FailHitAnimation", true);
                                object = this;
                                boolean bl16 = false;
                                boolValue2.setSuperValue(this.failHitValue);
                                ((KillAura)object).failHitAnimationValue = boolValue;
                                IntegerValue integerValue10 = integerValue = new IntegerValue("FailHitAnimationRate", 0, new IntRange(0, 100));
                                object = this;
                                boolean bl17 = false;
                                integerValue10.setSuperValue(this.failHitAnimationValue);
                                ((KillAura)object).failHitAnimationRateValue = integerValue;
                                String[] stringArray5 = new String[]{"Normal", "Packet"};
                                ListValue listValue8 = listValue = new ListValue("FailHitAnimationMode", stringArray5, "Normal");
                                object = this;
                                boolean bl18 = false;
                                listValue8.setSuperValue(this.failHitAnimationValue);
                                ((KillAura)object).failHitAnimationModeValue = listValue;
                                Value[] valueArray = new Value[]{this.cpsValue, this.atValue, this.attackRangeModeValue, this.attackRangeCustomNormalValue, this.attackRangeCustomThroughWallValue, this.attackRangeCustomThroughWallLimitRangeValue, this.attackRangeCustomThroughWallExpandRangeValue, this.backTrackValue, this.backTrackAttackModeValue, this.backTrackAttackRangeValue, this.backTrackAttackMultiLimitValue, this.rotationRangeValue};
                                CollectionsKt.addAll((Collection)this.getValues(), valueArray);
                                this.targetManager.setModule(this);
                                Iterable iterable = this.targetManager.getValues();
                                boolean bl19 = false;
                                for (Object t2 : iterable) {
                                    Value value2 = (Value)t2;
                                    boolean bl20 = false;
                                    value2.setName("Target" + value2.getName());
                                    this.getValues().add(value2);
                                }
                                Value[] valueArray2 = new Value[]{this.rotationKeepTickValue, this.rotationOnStuckValue, this.rotationModeValue, this.rotationStrafeValue};
                                CollectionsKt.addAll((Collection)this.getValues(), valueArray2);
                                List<Class<KillAuraRotation>> list5 = list4 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".kill_aura.rotations", KillAuraRotation.class);
                                boolean bl21 = false;
                                List<Class<KillAuraRotation>> list6 = list3 = !((Collection)list5).isEmpty() ? list4 : null;
                                if (list3 == null) break block9;
                                Iterable iterable2 = list3;
                                boolean bl22 = false;
                                Iterable iterable3 = iterable2;
                                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                                $i$f$mapTo22 = false;
                                for (Object item$iv$iv : iterable3) {
                                    Class clazz = (Class)item$iv$iv;
                                    object = destination$iv$iv;
                                    boolean bl23 = false;
                                    object.add((KillAuraRotation)it.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                                }
                                Iterable iterable4 = (List)destination$iv$iv;
                                boolean bl24 = false;
                                List list7 = CollectionsKt.sortedWith(iterable4, new Comparator(){

                                    public final int compare(T a2, T b2) {
                                        KillAuraRotation it = (KillAuraRotation)a2;
                                        boolean bl2 = false;
                                        Comparable comparable = (Comparable)((Object)it.getName());
                                        it = (KillAuraRotation)b2;
                                        Comparable comparable2 = comparable;
                                        bl2 = false;
                                        return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                                    }
                                });
                                if (list7 == null) break block9;
                                Iterable iterable5 = list7;
                                boolean $i$f$forEach2 = false;
                                $i$f$mapTo22 = iterable5.iterator();
                                break block10;
                            }
                            unit3 = null;
                            break block11;
                        }
                        while ($i$f$mapTo22.hasNext()) {
                            Object element$iv = $i$f$mapTo22.next();
                            KillAuraRotation it2 = (KillAuraRotation)element$iv;
                            boolean bl25 = false;
                            it2.setInstance(this);
                            Iterable $this$forEach$iv = it2.getValues();
                            $i$f$forEach = false;
                            for (Object element$iv2 : $this$forEach$iv) {
                                value = (Value)element$iv2;
                                boolean bl26 = false;
                                value.setName(it2.getName() + value.getName());
                                if (value.getSuperValue() == null) {
                                    value.setSuperValue(this.rotationModeValue);
                                    value.setSuperValueMeta(it2.getName());
                                }
                                this.getValues().add(value);
                            }
                            this.rotations.put(it2.getName(), it2);
                        }
                        Unit it3 = unit2 = Unit.INSTANCE;
                        boolean bl27 = false;
                        Collection $this$toTypedArray$iv = this.rotations.keySet();
                        boolean $i$f$toTypedArray = false;
                        thisCollection$iv = $this$toTypedArray$iv;
                        this.rotationModeValue.setValues(thisCollection$iv.toArray(new String[0]));
                        unit3 = Unit.INSTANCE;
                    }
                    Value[] valueArray = new Value[]{this.failHitValue, this.failHitRandomRateValue, this.failHitAnimationValue, this.failHitAnimationRateValue, this.failHitAnimationModeValue};
                    CollectionsKt.addAll((Collection)this.getValues(), valueArray);
                    List<Class<KillAuraExtend>> list8 = list2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".kill_aura.extend", KillAuraExtend.class);
                    boolean bl28 = false;
                    List<Class<KillAuraExtend>> list9 = list = !((Collection)list8).isEmpty() ? list2 : null;
                    if (list == null) break block12;
                    Iterable iterable = list;
                    boolean bl29 = false;
                    Iterable iterable6 = iterable;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                    $i$f$mapTo22 = false;
                    for (Object item$iv$iv : iterable6) {
                        thisCollection$iv = (Class)item$iv$iv;
                        object = destination$iv$iv;
                        boolean bl30 = false;
                        object.add((KillAuraExtend)it.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    }
                    Iterable iterable7 = (List)destination$iv$iv;
                    boolean bl31 = false;
                    List list10 = CollectionsKt.sortedWith(iterable7, new Comparator(){

                        public final int compare(T a2, T b2) {
                            KillAuraExtend it = (KillAuraExtend)a2;
                            boolean bl2 = false;
                            Comparable comparable = (Comparable)((Object)it.getName());
                            it = (KillAuraExtend)b2;
                            Comparable comparable2 = comparable;
                            bl2 = false;
                            return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                        }
                    });
                    if (list10 == null) break block12;
                    Iterable iterable8 = list10;
                    boolean bl32 = false;
                    iterator2 = iterable8.iterator();
                    break block13;
                }
                unit = null;
                break block14;
            }
            while (iterator2.hasNext()) {
                Object element$iv = iterator2.next();
                KillAuraExtend it = (KillAuraExtend)element$iv;
                boolean bl33 = false;
                BoolValue modulesMode2 = new BoolValue(it.getName(), it.getDefaultState());
                it.setLinkedStatValue(modulesMode2);
                it.setInstance(this);
                this.getValues().add(modulesMode2);
                Iterable $this$forEach$iv = it.getValues();
                $i$f$forEach = false;
                for (Object element$iv2 : $this$forEach$iv) {
                    value = (Value)element$iv2;
                    boolean bl34 = false;
                    value.setName(it.getName() + value.getName());
                    if (value.getSuperValue() == null) {
                        value.setSuperValue(modulesMode2);
                    }
                    this.getValues().add(value);
                }
                this.extends.put(it.getName(), it);
                EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                Intrinsics.checkNotNull(it);
                EventManager.registerListener$default(eventManager, it, false, false, 6, null);
            }
            unit = Unit.INSTANCE;
        }
        this.attackDelay = new MSDelay();
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<SafeListenerBase, TickProcessKeyBindsEvent, Unit> function2 = (arg_0, arg_1) -> KillAura._init_$lambda$33(this, arg_0, arg_1);
        int n2 = 0;
        boolean bl35 = false;
        ListenableOwnerStaticStorage.INSTANCE.get(listenableOwner).add(new EventHookSafeOwnerCheck<TickProcessKeyBindsEvent>(n2, function2, Reflection.getOrCreateKotlinClass(TickProcessKeyBindsEvent.class), listenableOwner));
        ListenableOwnerExtends listenableOwnerExtends2 = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner2 = this;
        Function2<SafeListenerBase, PlayerSPUpdateWalkingEvent.PRE, Unit> function22 = (arg_0, arg_1) -> KillAura._init_$lambda$34(this, arg_0, arg_1);
        int n3 = 0;
        boolean bl36 = false;
        ListenableOwnerStaticStorage.INSTANCE.get(listenableOwner2).add(new EventHookSafeOwnerCheck<PlayerSPUpdateWalkingEvent.PRE>(n3, function22, Reflection.getOrCreateKotlinClass(PlayerSPUpdateWalkingEvent.PRE.class), listenableOwner2));
        ListenableOwnerExtends listenableOwnerExtends3 = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner3 = this;
        Function2<SafeListenerBase, MovementInputEvent.PRE, Unit> function23 = (arg_0, arg_1) -> KillAura._init_$lambda$45(this, arg_0, arg_1);
        int n4 = 0;
        boolean bl37 = false;
        ListenableOwnerStaticStorage.INSTANCE.get(listenableOwner3).add(new EventHookSafeOwnerCheck<MovementInputEvent.PRE>(n4, function23, Reflection.getOrCreateKotlinClass(MovementInputEvent.PRE.class), listenableOwner3));
        ListenableOwnerExtends listenableOwnerExtends4 = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner4 = this;
        Function2<SafeListenerBase, UpdateMouseOverEvent.PRE, Unit> function24 = (arg_0, arg_1) -> KillAura._init_$lambda$46(this, arg_0, arg_1);
        int n5 = 0;
        boolean bl38 = false;
        ListenableOwnerStaticStorage.INSTANCE.get(listenableOwner4).add(new EventHookSafeOwnerCheck<UpdateMouseOverEvent.PRE>(n5, function24, Reflection.getOrCreateKotlinClass(UpdateMouseOverEvent.PRE.class), listenableOwner4));
        ListenableOwnerExtends listenableOwnerExtends5 = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner5 = this;
        int n6 = 2000;
        Function2<SafeListenerBase, PlayerSPLookEvent, Unit> function25 = KillAura::_init_$lambda$50;
        boolean bl39 = false;
        ListenableOwnerStaticStorage.INSTANCE.get(listenableOwner5).add(new EventHookSafeOwnerCheck<PlayerSPLookEvent>(n6, function25, Reflection.getOrCreateKotlinClass(PlayerSPLookEvent.class), listenableOwner5));
    }

    @NotNull
    public final Map<String, KillAuraExtend> getExtends() {
        return this.extends;
    }

    @NotNull
    public final Map<String, KillAuraRotation> getRotations() {
        return this.rotations;
    }

    @NotNull
    public final KillAuraTargetManager getTargetManager() {
        return this.targetManager;
    }

    @NotNull
    public final IntegerRangeValue getCpsValue() {
        return this.cpsValue;
    }

    @NotNull
    public final ListValue getAtValue() {
        return this.atValue;
    }

    @NotNull
    public final ListValue getAttackRangeModeValue() {
        return this.attackRangeModeValue;
    }

    @NotNull
    public final FloatValue getAttackRangeCustomNormalValue() {
        return this.attackRangeCustomNormalValue;
    }

    @NotNull
    public final ListValue getAttackRangeCustomThroughWallValue() {
        return this.attackRangeCustomThroughWallValue;
    }

    @NotNull
    public final FloatValue getAttackRangeCustomThroughWallLimitRangeValue() {
        return this.attackRangeCustomThroughWallLimitRangeValue;
    }

    @NotNull
    public final FloatValue getAttackRangeCustomThroughWallExpandRangeValue() {
        return this.attackRangeCustomThroughWallExpandRangeValue;
    }

    @NotNull
    public final BoolValue getBackTrackValue() {
        return this.backTrackValue;
    }

    @NotNull
    public final FloatValue getBackTrackAttackRangeValue() {
        return this.backTrackAttackRangeValue;
    }

    @NotNull
    public final ListValue getBackTrackAttackModeValue() {
        return this.backTrackAttackModeValue;
    }

    @NotNull
    public final IntegerValue getBackTrackAttackMultiLimitValue() {
        return this.backTrackAttackMultiLimitValue;
    }

    @NotNull
    public final FloatValue getRotationRangeValue() {
        return this.rotationRangeValue;
    }

    @NotNull
    public final IntegerValue getRotationKeepTickValue() {
        return this.rotationKeepTickValue;
    }

    @NotNull
    public final BoolValue getRotationOnStuckValue() {
        return this.rotationOnStuckValue;
    }

    @NotNull
    public final ListValue getRotationModeValue() {
        return this.rotationModeValue;
    }

    @NotNull
    public final MovementModeValue getRotationStrafeValue() {
        return this.rotationStrafeValue;
    }

    @NotNull
    public final BoolValue getFailHitValue() {
        return this.failHitValue;
    }

    @NotNull
    public final IntegerValue getFailHitRandomRateValue() {
        return this.failHitRandomRateValue;
    }

    @NotNull
    public final IntegerValue getFailHitHurtTimeValue() {
        return this.failHitHurtTimeValue;
    }

    @NotNull
    public final BoolValue getFailHitAnimationValue() {
        return this.failHitAnimationValue;
    }

    @NotNull
    public final IntegerValue getFailHitAnimationRateValue() {
        return this.failHitAnimationRateValue;
    }

    @NotNull
    public final ListValue getFailHitAnimationModeValue() {
        return this.failHitAnimationModeValue;
    }

    @NotNull
    public final MSDelay getAttackDelay() {
        return this.attackDelay;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onEnable() {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this.extends.values();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            KillAuraExtend it = (KillAuraExtend)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            KillAuraExtend it = (KillAuraExtend)element$iv;
            boolean bl3 = false;
            it.onEnable();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onDisable() {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this.extends.values();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            KillAuraExtend it = (KillAuraExtend)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            KillAuraExtend it = (KillAuraExtend)element$iv;
            boolean bl3 = false;
            it.onDisable();
        }
        this.targetManager.reset();
        DarkMeow.INSTANCE.getRotationManager().delTask("KillAura");
    }

    /*
     * WARNING - void declaration
     */
    private final boolean isCancelRun() {
        boolean bl2;
        block3: {
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP != null) {
                void $this$any$iv;
                EntityPlayerSP player = entityPlayerSP;
                boolean bl3 = false;
                Boolean[] booleanArray = new Boolean[]{player.func_110143_aJ() <= 0.0f, !player.func_70089_S(), player.func_175149_v()};
                boolean $i$f$any = false;
                for (void element$iv : $this$any$iv) {
                    boolean it = element$iv.booleanValue();
                    boolean bl4 = false;
                    if (!it) continue;
                    bl2 = true;
                    break block3;
                }
                bl2 = false;
            } else {
                bl2 = true;
            }
        }
        return bl2;
    }

    /*
     * Unable to fully structure code
     */
    private final boolean checkFailHit(EntityLivingBase entity) {
        block7: {
            block6: {
                var3_2 = this.failHitValue.get();
                it = (Boolean)var3_2;
                $i$a$-takeIf-KillAura$checkFailHit$1 = false;
                var3_2 = ((Number)this.failHitRandomRateValue.get()).intValue() < RandomUtils.INSTANCE.random(0, 100) != false ? var3_2 : null;
                it = (Boolean)var3_2;
                $i$a$-takeIf-KillAura$checkFailHit$2 = false;
                var2_7 = (Boolean)(((Number)this.failHitHurtTimeValue.get()).intValue() >= entity.field_70737_aN != false ? var3_2 : null);
                if (var2_7 == null) break block6;
                it = var2_7;
                $i$a$-let-KillAura$checkFailHit$3 = false;
                v0 = true;
                break block7;
            }
            it = this.failHitValue.get();
            it = (Boolean)it;
            $i$a$-takeIf-KillAura$checkFailHit$4 = false;
            var4_4 = (Boolean)(it != false ? it : null);
            if (var4_4 == null) ** GOTO lbl-1000
            it = var4_4;
            it = it.booleanValue();
            $i$a$-takeIf-KillAura$checkFailHit$5 = false;
            v1 = it = (Boolean)this.failHitAnimationValue.get() != false ? it : null;
            if (it == null) ** GOTO lbl-1000
            var7_13 = it;
            it = var7_13.booleanValue();
            $i$a$-takeIf-KillAura$checkFailHit$6 = false;
            v2 = it = ((Number)this.failHitAnimationRateValue.get()).intValue() < RandomUtils.INSTANCE.random(0, 100) != false ? var7_13 : null;
            if (it != null) {
                var7_13 = it;
                it = var7_13.booleanValue();
                $i$a$-also-KillAura$checkFailHit$7 = false;
                v3 = MinecraftInstance.mc.getPlayer();
                if (v3 != null) {
                    player = v3;
                    var11_17 = (String)this.failHitAnimationModeValue.get();
                    if (Intrinsics.areEqual(var11_17, "Normal")) {
                        player.func_184609_a(EnumHand.MAIN_HAND);
                    } else if (Intrinsics.areEqual(var11_17, "Packet")) {
                        player.field_71174_a.func_147297_a((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
                    }
                }
                v4 = var7_13;
            } else lbl-1000:
            // 3 sources

            {
                v4 = null;
            }
            it = v4;
            $i$a$-let-KillAura$checkFailHit$8 = false;
            v0 = !((Boolean)this.failHitValue.get()).booleanValue();
        }
        return v0;
    }

    public final boolean isEnemy(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        return TargetsManager.isSelected$default(DarkMeow.INSTANCE.getCombatManager().getTargetsManager(), entity, true, false, 4, null);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void runAttack(@NotNull SafeListenerBase $this$runAttack) {
        void $this$forEach$iv;
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv;
        List list;
        List<Object> list2;
        EntityLivingBase[] $this$filter$iv2;
        block28: {
            List it;
            block26: {
                void $this$filterIsInstanceTo$iv$iv;
                void $this$filterIsInstance$iv;
                void $this$filterTo$iv$iv2;
                Set<Entity> set;
                Set<EntityLivingBase> set2;
                Set<EntityLivingBase> set3;
                Intrinsics.checkNotNullParameter($this$runAttack, "<this>");
                Set<EntityLivingBase> it2 = set3 = DarkMeow.INSTANCE.getCombatManager().getAllowAttackManager().allows;
                boolean bl2 = false;
                if (!MSDelay.hasPassed$default(this.attackDelay, 0L, 1, null)) return;
                Set<EntityLivingBase> set4 = set3;
                Set<EntityLivingBase> set5 = set4;
                if (set5 == null) return;
                Set<EntityLivingBase> it3 = set2 = set5;
                boolean bl3 = false;
                this.attackDelay.reset(TimeUtils.randomClickDelay(((Number)((ClosedRange)this.cpsValue.getValue()).getStart()).intValue(), ((Number)((ClosedRange)this.cpsValue.getValue()).getEndInclusive()).intValue()));
                Set<EntityLivingBase> set6 = set2;
                boolean bl4 = false;
                boolean bl5 = (Boolean)this.backTrackValue.get();
                if (bl5) {
                    World world = $this$runAttack.getPlayer().field_70170_p;
                    Intrinsics.checkNotNullExpressionValue(world, "world");
                    set = WorldUtils.quickGetNearEntities(world, $this$runAttack.getPlayer(), ((Number)this.backTrackAttackRangeValue.get()).floatValue(), arg_0 -> KillAura.runAttack$lambda$67$lambda$64(set6, arg_0));
                } else {
                    if (bl5) throw new NoWhenBranchMatchedException();
                    RayTraceResult rayTraceResult = MinecraftInstance.mc.getObjectMouseOver();
                    if (rayTraceResult == null) return;
                    RayTraceResult rayTraceResult2 = rayTraceResult;
                    RayTraceResult obj = rayTraceResult2;
                    boolean bl6 = false;
                    if (obj.field_72313_a != RayTraceResult.Type.ENTITY) return;
                    boolean bl7 = true;
                    if (!bl7) return;
                    RayTraceResult rayTraceResult3 = rayTraceResult2;
                    RayTraceResult rayTraceResult4 = rayTraceResult3;
                    if (rayTraceResult4 == null) return;
                    rayTraceResult2 = rayTraceResult4.field_72308_g;
                    if (rayTraceResult2 == null) return;
                    RayTraceResult it4 = rayTraceResult2;
                    boolean bl8 = false;
                    Entity[] entityArray = new Entity[]{it4};
                    set = SetsKt.mutableSetOf(entityArray);
                }
                set2 = set;
                if (set2 == null) return;
                Iterable iterable = set2;
                boolean $i$f$filter22 = false;
                Iterable iterable2 = iterable;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                for (Object element$iv$iv : $this$filterTo$iv$iv2) {
                    Entity entity = (Entity)element$iv$iv;
                    boolean bl9 = false;
                    if (!TargetsManager.isSelected$default(DarkMeow.INSTANCE.getCombatManager().getTargetsManager(), entity, true, false, 4, null)) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                Iterable $i$f$filter22 = (List)destination$iv$iv;
                boolean $i$f$filterIsInstance = false;
                destination$iv$iv = $this$filterIsInstance$iv;
                Collection destination$iv$iv2 = new ArrayList();
                boolean $i$f$filterIsInstanceTo = false;
                for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
                    if (!(element$iv$iv instanceof EntityLivingBase)) continue;
                    destination$iv$iv2.add(element$iv$iv);
                }
                it = (List)destination$iv$iv2;
                boolean bl10 = false;
                if (!((Boolean)this.backTrackValue.get()).booleanValue()) break block26;
                switch ((String)this.backTrackAttackModeValue.get()) {
                    case "LastRayTrace": {
                        void $this$filterTo$iv$iv3;
                        $this$filter$iv2 = (EntityLivingBase[])it;
                        boolean $i$f$filter = false;
                        EntityLivingBase[] bl9 = $this$filter$iv2;
                        Collection destination$iv$iv3 = new ArrayList();
                        boolean $i$f$filterTo2 = false;
                        for (Object element$iv$iv : $this$filterTo$iv$iv3) {
                            EntityLivingBase entity = (EntityLivingBase)element$iv$iv;
                            boolean bl11 = false;
                            if (!(entity == DarkMeow.INSTANCE.getCombatManager().getAllowAttackManager().lastAllow)) continue;
                            destination$iv$iv3.add(element$iv$iv);
                        }
                        list2 = (List)destination$iv$iv3;
                        break;
                    }
                    case "RayTracesFirst": {
                        $this$filter$iv2 = new EntityLivingBase[]{CollectionsKt.firstOrNull(it)};
                        list2 = CollectionsKt.mutableListOf($this$filter$iv2);
                        break;
                    }
                    case "RayTracesLast": {
                        $this$filter$iv2 = new EntityLivingBase[]{CollectionsKt.lastOrNull(it)};
                        list2 = CollectionsKt.mutableListOf($this$filter$iv2);
                        break;
                    }
                    case "RayTracesRandom": {
                        $this$filter$iv2 = new EntityLivingBase[]{CollectionsKt.randomOrNull(it, Random.Default)};
                        list2 = CollectionsKt.mutableListOf($this$filter$iv2);
                        break;
                    }
                    case "RayTracesMulti": {
                        list2 = CollectionsKt.take(it, ((Number)this.backTrackAttackMultiLimitValue.get()).intValue());
                        break;
                    }
                    default: {
                        return;
                    }
                }
                break block28;
            }
            list2 = it;
        }
        if ((list = list2) == null) return;
        List list3 = CollectionsKt.filterNotNull(list);
        if (list3 == null) return;
        Iterable bl10 = list3;
        boolean $i$f$filter = false;
        $this$filter$iv2 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            EntityLivingBase entity = (EntityLivingBase)element$iv$iv;
            boolean bl12 = false;
            if (!((Boolean)this.failHitValue.get() != false ? this.checkFailHit(entity) : true)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.iterator();
        while (iterator2.hasNext()) {
            Object element$iv = iterator2.next();
            EntityLivingBase entity = (EntityLivingBase)element$iv;
            boolean bl13 = false;
            this.attackEntity($this$runAttack, entity);
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void attackEntity(@NotNull SafeListenerBase $this$attackEntity, @NotNull EntityLivingBase entity) {
        Object object;
        boolean bl2;
        Object object2;
        block8: {
            void $this$all$iv;
            Iterator $this$filterTo$iv$iv;
            Iterable $this$filter$iv;
            Intrinsics.checkNotNullParameter($this$attackEntity, "<this>");
            Intrinsics.checkNotNullParameter(entity, "entity");
            object2 = this.extends.values();
            boolean $i$f$filter = false;
            void var6_5 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            Iterator iterator2 = $this$filterTo$iv$iv.iterator();
            while (iterator2.hasNext()) {
                Object element$iv$iv = iterator2.next();
                KillAuraExtend it = (KillAuraExtend)element$iv$iv;
                boolean bl3 = false;
                if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            $this$filter$iv = (List)destination$iv$iv;
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl2 = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    KillAuraExtend it = (KillAuraExtend)element$iv;
                    boolean bl4 = false;
                    KillAuraExtend $this$attackEntity_u24lambda_u2475_u24lambda_u2474 = it;
                    boolean bl5 = false;
                    if ($this$attackEntity_u24lambda_u2475_u24lambda_u2474.onAttackPre($this$attackEntity, entity)) continue;
                    bl2 = false;
                    break block8;
                }
                bl2 = true;
            }
        }
        object2 = bl2;
        boolean it = (Boolean)object2;
        boolean bl6 = false;
        Object object3 = object = it ? object2 : null;
        if (object != null) {
            object2 = object;
            it = (Boolean)object2;
            boolean bl7 = false;
            this.targetManager.setPrevTarget(entity);
            if (CombatManager.attackEntity$default(DarkMeow.INSTANCE.getCombatManager(), (Entity)entity, EnumAnimationMode.NORMAL, EnumHand.MAIN_HAND, EnumAttackEntityMode.PACKET, false, 16, null)) {
                void $this$forEach$iv;
                void $this$filterTo$iv$iv;
                Iterable $this$filter$iv;
                Object element$iv;
                $this$attackEntity.getPlayer().func_184821_cY();
                element$iv = this.extends.values();
                boolean $i$f$filter = false;
                void bl4 = $this$filter$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    KillAuraExtend it2 = (KillAuraExtend)element$iv$iv;
                    boolean bl8 = false;
                    if (!((Boolean)it2.getLinkedStatValue().get()).booleanValue()) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                $this$filter$iv = (List)destination$iv$iv;
                boolean $i$f$forEach = false;
                for (Object element$iv2 : $this$forEach$iv) {
                    KillAuraExtend it3 = (KillAuraExtend)element$iv2;
                    boolean bl9 = false;
                    KillAuraExtend $this$attackEntity_u24lambda_u2480_u24lambda_u2479_u24lambda_u2478 = it3;
                    boolean bl10 = false;
                    $this$attackEntity_u24lambda_u2480_u24lambda_u2479_u24lambda_u2478.onAttackPost($this$attackEntity, entity);
                }
            }
        }
    }

    private final boolean updateRotations(Entity entity) {
        Rotation rotation;
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return false;
        }
        EntityPlayerSP player = entityPlayerSP;
        KillAuraRotation killAuraRotation = this.rotations.get(this.rotationModeValue.get());
        if (killAuraRotation != null && (rotation = killAuraRotation.apply(player, entity)) != null) {
            Rotation rotation2;
            Rotation rotation3 = rotation2 = rotation;
            boolean bl2 = false;
            if (!DarkMeow.INSTANCE.getRotationManager().addTask(new RotationTask(this.getName(), new Rotation(rotation3.yaw, rotation3.pitch), this.rotationStrafeValue.getMovementMode(), ((Number)this.rotationKeepTickValue.get()).intValue()))) {
                // empty if block
            }
        }
        return true;
    }

    @Override
    @NotNull
    public String getTag() {
        return String.valueOf(this.targetManager.getTargets().size());
    }

    private static final Unit _init_$lambda$33(KillAura this$0, SafeListenerBase $this$safeListener, TickProcessKeyBindsEvent it) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(this$0.atValue.get(), "Tick") && !this$0.isCancelRun()) {
            this$0.runAttack($this$safeListener);
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$34(KillAura this$0, SafeListenerBase $this$safeListener, PlayerSPUpdateWalkingEvent.PRE it) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(this$0.atValue.get(), "Update") && !this$0.isCancelRun()) {
            this$0.runAttack($this$safeListener);
        }
        return Unit.INSTANCE;
    }

    private static final boolean lambda$45$lambda$42$lambda$41(KillAura this$0, Entity entity) {
        boolean bl2;
        block5: {
            Intrinsics.checkNotNullParameter(entity, "entity");
            if (Intrinsics.areEqual(this$0.backTrackAttackModeValue.get(), "LastRayTrace")) {
                bl2 = DarkMeow.INSTANCE.getCombatManager().getAllowAttackManager().lastAllow == entity;
            } else {
                Iterable $this$any$iv = DarkMeow.INSTANCE.getCombatManager().getAllowAttackManager().allows;
                boolean $i$f$any = false;
                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                    bl2 = false;
                } else {
                    for (Object element$iv : $this$any$iv) {
                        EntityLivingBase it = (EntityLivingBase)element$iv;
                        boolean bl3 = false;
                        if (!(it == entity)) continue;
                        bl2 = true;
                        break block5;
                    }
                    bl2 = false;
                }
            }
        }
        return bl2;
    }

    private static final Unit _init_$lambda$45(KillAura this$0, SafeListenerBase $this$safeListener, MovementInputEvent.PRE it) {
        block6: {
            Object object;
            Iterable iterable;
            Object object2;
            Set<EntityLivingBase> set;
            Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
            Intrinsics.checkNotNullParameter(it, "it");
            if (this$0.isCancelRun()) {
                return Unit.INSTANCE;
            }
            Object object3 = this$0.targetManager;
            KillAuraTargetManager $this$lambda_u2445_u24lambda_u2435 = object3;
            boolean bl2 = false;
            $this$lambda_u2445_u24lambda_u2435.update($this$safeListener);
            Set<EntityLivingBase> it2 = set = this$0.targetManager.getTargets();
            boolean bl3 = false;
            Object object4 = object3 = !((Collection)it2).isEmpty() ? set : null;
            if (object3 == null) break block6;
            Object it3 = object2 = object3;
            boolean bl4 = false;
            Iterable $this$onEach$iv = (Iterable)it3;
            boolean $i$f$onEach = false;
            Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
            boolean bl5 = false;
            for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
                EntityLivingBase entity = (EntityLivingBase)element$iv;
                boolean bl6 = false;
                if (this$0.updateRotations((Entity)entity)) break;
            }
            Object it4 = object = object2;
            boolean bl7 = false;
            Object object5 = object2 = DarkMeow.INSTANCE.getMovementManager().getStuckManager().getCancelPlayerSPUpdateWalkingCount() > 1 && (Boolean)this$0.rotationOnStuckValue.get() != false ? object : null;
            if (object2 != null) {
                Object object6;
                Object it5 = object6 = object2;
                boolean bl8 = false;
                World world = $this$safeListener.getPlayer().field_70170_p;
                Intrinsics.checkNotNullExpressionValue(world, "world");
                Object object7 = object = WorldUtils.quickGetNearEntities(world, $this$safeListener.getPlayer(), ((Number)this$0.backTrackAttackRangeValue.get()).floatValue(), arg_0 -> KillAura.lambda$45$lambda$42$lambda$41(this$0, arg_0)).isEmpty() ? object6 : null;
                if (object != null) {
                    it5 = object6 = object;
                    boolean bl9 = false;
                    EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
                    if (entityPlayerSP != null) {
                        Iterable player = iterable = entityPlayerSP;
                        boolean bl10 = false;
                        if (ExtendEntityPlayerSP.INSTANCE.getPositionUpdateTicks((EntityPlayerSP)player) >= 19) {
                            MovementStuckManagerExtend.travelOnStuck$default(MovementStuckManagerExtend.INSTANCE, (EntityPlayerSP)player, 0.0f, 0.0f, 0.0f, 7, null);
                        }
                        MovementStuckManagerExtend.INSTANCE.syncPositionToServerOnStuck((EntityPlayerSP)player);
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$46(KillAura this$0, SafeListenerBase $this$safeListener, UpdateMouseOverEvent.PRE event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (this$0.isCancelRun()) {
            return Unit.INSTANCE;
        }
        RotationTask rotationTask = DarkMeow.INSTANCE.getRotationManager().getTask();
        if (Intrinsics.areEqual(rotationTask != null ? rotationTask.getName() : null, this$0.getName())) {
            event.setCurrentEntity((Entity)$this$safeListener.getPlayer());
            if (Intrinsics.areEqual(this$0.attackRangeModeValue.get(), "Custom")) {
                event.setEntityRange(((Number)this$0.attackRangeCustomNormalValue.get()).floatValue());
                String string = (String)this$0.attackRangeCustomThroughWallValue.get();
                event.setEntityThroughWall(Intrinsics.areEqual(string, "Expand") ? (ThroughWallCheck)new ThroughWallCheckExpand(((Number)this$0.attackRangeCustomThroughWallExpandRangeValue.get()).floatValue()) : (Intrinsics.areEqual(string, "Limit") ? (ThroughWallCheck)new ThroughWallCheckLimit(((Number)this$0.attackRangeCustomThroughWallExpandRangeValue.get()).floatValue()) : event.getEntityThroughWall()));
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$50(SafeListenerBase $this$safeListener, PlayerSPLookEvent event) {
        block1: {
            PlayerSPLookEvent playerSPLookEvent;
            PlayerSPLookEvent playerSPLookEvent2;
            PlayerSPLookEvent playerSPLookEvent3;
            Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
            Intrinsics.checkNotNullParameter(event, "event");
            PlayerSPLookEvent it = playerSPLookEvent3 = event;
            boolean bl2 = false;
            PlayerSPLookEvent playerSPLookEvent4 = playerSPLookEvent2 = DarkMeow.INSTANCE.getMovementManager().getStuckManager().isInStuck() ? playerSPLookEvent3 : null;
            if (playerSPLookEvent2 == null) break block1;
            PlayerSPLookEvent it2 = playerSPLookEvent = playerSPLookEvent2;
            boolean bl3 = false;
            PlayerSPLookEvent playerSPLookEvent5 = playerSPLookEvent3 = !((Collection)DarkMeow.INSTANCE.getCombatManager().getAllowAttackManager().allows).isEmpty() ? playerSPLookEvent : null;
            if (playerSPLookEvent3 != null) {
                PlayerSPLookEvent $this$lambda_u2450_u24lambda_u2449 = playerSPLookEvent = playerSPLookEvent3;
                boolean bl4 = false;
                $this$lambda_u2450_u24lambda_u2449.setReturnValue(DarkMeow.INSTANCE.getRotationManager().serverRotation);
                $this$lambda_u2450_u24lambda_u2449.cancelNext();
            }
        }
        return Unit.INSTANCE;
    }

    private static final boolean runAttack$lambda$67$lambda$64(Set $entities, Entity entity) {
        boolean bl2;
        block3: {
            Intrinsics.checkNotNullParameter(entity, "entity");
            Iterable $this$any$iv = $entities;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    EntityLivingBase it = (EntityLivingBase)element$iv;
                    boolean bl3 = false;
                    if (!(it == entity)) continue;
                    bl2 = true;
                    break block3;
                }
                bl2 = false;
            }
        }
        return bl2;
    }
}

