/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.inventory.Container
 *  net.minecraft.item.ItemEgg
 *  net.minecraft.item.ItemSnowball
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.handler.combat.targets.TargetsManager;
import net.ccbluex.liquidbounce.handler.rotation.data.RotationTask;
import net.ccbluex.liquidbounce.handler.rotation.value.MovementModeValue;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.KeyUtils;
import net.ccbluex.liquidbounce.utils.timer.delay.MSDelay;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatRangeValue;
import net.ccbluex.liquidbounce.value.impl.IntegerRangeValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.utils.movement.RotationUtils;
import net.darkmeow.darkmeow.utils.world.WorldUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(name="ThrowableAura", category=ModuleCategory.COMBAT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002\u00a2\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/ThrowableAura;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "delayValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "useEggValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "useSnowballValue", "rangeValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatRangeValue;", "priorityValue", "rotationModeValue", "Lnet/ccbluex/liquidbounce/handler/rotation/value/MovementModeValue;", "rotationKeepLengthValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "lastTickTarget", "Lnet/minecraft/entity/EntityLivingBase;", "throwDelay", "Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "onEnable", "", "onMovementInput", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "searchThrowableSlot", "", "()Ljava/lang/Integer;", "checkItemIsThrowable", "", "stack", "Lnet/minecraft/item/ItemStack;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nThrowableAura.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThrowableAura.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/ThrowableAura\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,128:1\n1#2:129\n12434#3,2:130\n12637#3,2:163\n808#4,11:132\n774#4:143\n865#4,2:144\n1056#4:146\n1056#4:147\n785#4:148\n796#4:149\n1878#4,2:150\n797#4,2:152\n1880#4:154\n799#4:155\n1573#4:156\n1604#4,4:157\n295#4,2:161\n*S KotlinDebug\n*F\n+ 1 ThrowableAura.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/ThrowableAura\n*L\n77#1:130,2\n126#1:163,2\n88#1:132,11\n89#1:143\n89#1:144,2\n92#1:146\n93#1:147\n112#1:148\n112#1:149\n112#1:150,2\n112#1:152,2\n112#1:154\n112#1:155\n115#1:156\n115#1:157,4\n118#1:161,2\n*E\n"})
public final class ThrowableAura
extends Module {
    @NotNull
    private final IntegerRangeValue delayValue = new IntegerRangeValue("Delay", new IntRange(200, 200), new IntRange(0, 1000));
    @NotNull
    private final ListValue modeValue;
    @NotNull
    private final BoolValue useEggValue;
    @NotNull
    private final BoolValue useSnowballValue;
    @NotNull
    private final FloatRangeValue rangeValue;
    @NotNull
    private final ListValue priorityValue;
    @NotNull
    private final MovementModeValue rotationModeValue;
    @NotNull
    private final IntegerValue rotationKeepLengthValue;
    @Nullable
    private EntityLivingBase lastTickTarget;
    @NotNull
    private final MSDelay throwDelay;

    public ThrowableAura() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"Auto", "OnlyAttackKeyDown"};
        this.modeValue = new ListValue("Mode", stringArray, "OnlyAttackKeyDown");
        this.useEggValue = new BoolValue("UseEgg", true);
        this.useSnowballValue = new BoolValue("UseSnowball", true);
        this.rangeValue = new FloatRangeValue("Range", (ClosedRange<Float>)RangesKt.rangeTo(3.0f, 8.0f), (ClosedRange<Float>)RangesKt.rangeTo(0.0f, 32.0f));
        stringArray = new String[]{"Distance", "Health"};
        this.priorityValue = new ListValue("Priority", stringArray, "Distance");
        this.rotationModeValue = new MovementModeValue("RotationMode", null, 2, null);
        this.rotationKeepLengthValue = new IntegerValue("RotationKeepLength", 1, new IntRange(0, 20));
        this.throwDelay = new MSDelay();
    }

    @Override
    public void onEnable() {
        this.lastTickTarget = null;
        this.throwDelay.reset(this.delayValue);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @EventTarget
    public final void onMovementInput(@NotNull MovementInputEvent.PRE event) {
        block20: {
            Intrinsics.checkNotNullParameter(event, "event");
            v0 = MinecraftInstance.mc.getPlayer();
            if (v0 == null) {
                return;
            }
            player = v0;
            v1 = MinecraftInstance.mc.getWorld();
            if (v1 == null) {
                return;
            }
            world = v1;
            v2 = MinecraftInstance.mc.getConnection();
            if (v2 == null) {
                return;
            }
            connection = v2;
            v3 = this.lastTickTarget;
            if (v3 != null) {
                it = var6_5 = v3;
                $i$a$-also-ThrowableAura$onMovementInput$1 = false;
                v4 = this.searchThrowableSlot();
                if (v4 != null) {
                    var9_9 = v4;
                    slot = ((Number)var9_9).intValue();
                    $i$a$-also-ThrowableAura$onMovementInput$1$1 = false;
                    if (slot != player.field_71071_by.field_70461_c) {
                        connection.func_147297_a((Packet)new CPacketHeldItemChange(slot));
                    }
                    connection.func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                    if (slot != player.field_71071_by.field_70461_c) {
                        connection.func_147297_a((Packet)new CPacketHeldItemChange(player.field_71071_by.field_70461_c));
                    }
                }
            }
            it = var6_5 = world;
            var22_16 = this;
            $i$a$-takeIf-ThrowableAura$onMovementInput$2 = false;
            var23_17 = DarkMeow.INSTANCE.getMovementManager().getStuckManager().isInStuck() == false;
            v5 = var22_16;
            v6 /* !! */  = var5_18 = var23_17 != false ? var6_5 : null;
            if (var5_18 == null) ** GOTO lbl-1000
            $i$a$-takeIf-ThrowableAura$onMovementInput$2 = var7_6 = var5_18;
            var22_16 = v5;
            $i$a$-takeIf-ThrowableAura$onMovementInput$3 = false;
            var23_17 = MSDelay.hasPassed$default(this.throwDelay, 0L, 1, null);
            v5 = var22_16;
            v7 /* !! */  = var6_5 = var23_17 != false ? var7_6 : null;
            if (var6_5 == null) ** GOTO lbl-1000
            $i$a$-takeIf-ThrowableAura$onMovementInput$3 = var8_8 = var6_5;
            var22_16 = v5;
            $i$a$-also-ThrowableAura$onMovementInput$4 = false;
            this.onEnable();
            $i$a$-also-ThrowableAura$onMovementInput$4 = var9_11 = var8_8;
            $i$a$-takeIf-ThrowableAura$onMovementInput$5 = false;
            var23_17 = this.searchThrowableSlot() != null;
            v5 = var22_16;
            v8 /* !! */  = var8_8 = var23_17 != false ? var9_11 : null;
            if (var8_8 == null) ** GOTO lbl-1000
            $i$a$-takeIf-ThrowableAura$onMovementInput$5 = var10_13 /* !! */  = var8_8;
            var22_16 = v5;
            $i$a$-takeIf-ThrowableAura$onMovementInput$6 = false;
            var13_21 = (String)this.modeValue.get();
            if (Intrinsics.areEqual(var13_21, "Auto")) {
                v9 = true;
            } else if (Intrinsics.areEqual(var13_21, "OnlyAttackKeyDown")) {
                var14_24 = new Boolean[2];
                v10 = MinecraftInstance.mc.getGameSettings().field_74312_F;
                Intrinsics.checkNotNullExpressionValue(v10, "keyBindAttack");
                var14_24[0] = KeyUtils.INSTANCE.isKeyDownSystem(v10);
                v11 = MinecraftInstance.mc.getObjectMouseOver();
                var14_24[1] = (v11 != null ? v11.field_72313_a : null) == RayTraceResult.Type.MISS;
                $i$f$all = false;
                for (void element$iv : $this$all$iv) {
                    it = element$iv.booleanValue();
                    $i$a$-all-ThrowableAura$onMovementInput$6$1 = false;
                    if (it) continue;
                    v9 = false;
                    break block20;
                }
                v9 = true;
            } else {
                v9 = false;
            }
        }
        var23_17 = v9;
        v5 = var22_16;
        v12 /* !! */  = var9_11 = var23_17 != false ? var10_13 /* !! */  : null;
        if (var9_11 == null || (var10_13 /* !! */  = WorldUtils.quickGetNearEntities((World)var9_11, player, ((Number)((ClosedRange)this.rangeValue.getValue()).getEndInclusive()).floatValue(), (Function1<Entity, Boolean>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, onMovementInput$lambda$8(net.minecraft.entity.Entity ), (Lnet/minecraft/entity/Entity;)Ljava/lang/Boolean;)())) == null) ** GOTO lbl-1000
        $i$a$-takeIf-ThrowableAura$onMovementInput$6 = (Iterable)var10_13 /* !! */ ;
        var22_16 = v5;
        $i$f$filterIsInstance = false;
        $this$all$iv = $this$filterIsInstance$iv;
        destination$iv$iv = new ArrayList<E>();
        $i$f$filterIsInstanceTo = false;
        for (T element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv /* !! */  instanceof EntityLivingBase)) continue;
            destination$iv$iv.add(element$iv$iv /* !! */ );
        }
        $i$f$filterIsInstance = (List)destination$iv$iv;
        $i$f$filter = false;
        destination$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList<E>();
        $i$f$filterTo = false;
        for (E element$iv$iv : $this$filterTo$iv$iv) {
            it = (EntityLivingBase)element$iv$iv;
            $i$a$-filter-ThrowableAura$onMovementInput$8 = false;
            if (!((ClosedRange)this.rangeValue.getValue()).contains((Comparable)Float.valueOf(it.func_70032_d((Entity)player)))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filterTo$iv$iv = (List)destination$iv$iv;
        $i$a$-let-ThrowableAura$onMovementInput$9 = false;
        $i$f$filterTo = (String)this.priorityValue.get();
        if (Intrinsics.areEqual($i$f$filterTo, "Distance")) {
            $this$sortedBy$iv = (Iterable)targets;
            $i$f$sortedBy = false;
            v13 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(player){
                final /* synthetic */ EntityPlayerSP $player$inlined;
                {
                    this.$player$inlined = entityPlayerSP;
                }

                public final int compare(T a2, T b2) {
                    EntityLivingBase it = (EntityLivingBase)a2;
                    boolean bl2 = false;
                    Comparable comparable = Float.valueOf(this.$player$inlined.func_70032_d((Entity)it));
                    it = (EntityLivingBase)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)Float.valueOf(this.$player$inlined.func_70032_d((Entity)it)));
                }
            });
        } else if (Intrinsics.areEqual($i$f$filterTo, "Health")) {
            $this$sortedBy$iv = (Iterable)targets;
            $i$f$sortedBy = false;
            v13 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    EntityLivingBase it = (EntityLivingBase)a2;
                    boolean bl2 = false;
                    Comparable comparable = Float.valueOf(it.func_110143_aJ());
                    it = (EntityLivingBase)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)Float.valueOf(it.func_110143_aJ()));
                }
            });
        } else {
            v13 = null;
        }
        v5 = var22_16;
        var13_23 = v13;
        if (var13_23 != null && (var14_26 = (EntityLivingBase)CollectionsKt.firstOrNull(var13_23)) != null) {
            $i$a$-let-ThrowableAura$onMovementInput$9 = var15_28 = var14_26;
            var22_16 = v5;
            $i$a$-also-ThrowableAura$onMovementInput$10 = false;
            DarkMeow.INSTANCE.getRotationManager().addTask(new RotationTask("ThrowableAura", RotationUtils.INSTANCE.getThrowRotation(player, (Entity)target), this.rotationModeValue.getMovementMode(), ((Number)this.rotationKeepLengthValue.get()).intValue()));
            v5 = var22_16;
            v14 = var15_28;
        } else lbl-1000:
        // 5 sources

        {
            v14 = null;
        }
        v5.lastTickTarget = v14;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final Integer searchThrowableSlot() {
        Object v1;
        block5: {
            void $this$firstOrNull$iv;
            void $this$mapIndexedTo$iv$iv;
            void $this$mapIndexed$iv;
            void $this$filterIndexedTo$iv$iv;
            void $this$filterIndexed$iv;
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) return null;
            Container container = entityPlayerSP.field_71069_bz;
            if (container == null) return null;
            NonNullList nonNullList = container.func_75138_a();
            if (nonNullList == null) return null;
            Iterable iterable = (Iterable)nonNullList;
            boolean $i$f$filterIndexed22 = false;
            void var6_7 = $this$filterIndexed$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterIndexedTo = false;
            void $this$forEachIndexed$iv$iv$iv = $this$filterIndexedTo$iv$iv;
            boolean $i$f$forEachIndexed = false;
            int index$iv$iv$iv = 0;
            for (Object item$iv$iv$iv : $this$forEachIndexed$iv$iv$iv) {
                void element$iv$iv;
                int n2;
                if ((n2 = index$iv$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Object t2 = item$iv$iv$iv;
                int index$iv$iv = n2;
                boolean bl2 = false;
                ItemStack cfr_ignored_0 = (ItemStack)element$iv$iv;
                int index = index$iv$iv;
                boolean bl3 = false;
                boolean bl4 = 36 <= index ? index < 45 : false;
                if (!bl4) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Iterable $i$f$filterIndexed22 = (List)destination$iv$iv;
            boolean $i$f$mapIndexed22 = false;
            destination$iv$iv = $this$mapIndexed$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            boolean $i$f$mapIndexedTo = false;
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
                void stack;
                void index;
                int n3;
                if ((n3 = index$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ItemStack itemStack = (ItemStack)item$iv$iv;
                int element$iv$iv = n3;
                Collection collection = destination$iv$iv2;
                boolean bl5 = false;
                collection.add(TuplesKt.to((int)index, stack));
            }
            Iterable $i$f$mapIndexed22 = (List)destination$iv$iv2;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                Pair pair = (Pair)element$iv;
                boolean bl6 = false;
                ItemStack stack = (ItemStack)pair.component2();
                Intrinsics.checkNotNull(stack);
                if (!this.checkItemIsThrowable(stack)) continue;
                v1 = element$iv;
                break block5;
            }
            v1 = null;
        }
        Pair pair = v1;
        if (pair == null) return null;
        Integer n4 = (Integer)pair.getFirst();
        return n4;
    }

    private final boolean checkItemIsThrowable(ItemStack stack) {
        boolean bl2;
        block1: {
            Boolean[] booleanArray = new Boolean[]{stack.func_77973_b() instanceof ItemEgg && (Boolean)this.useEggValue.get() != false, stack.func_77973_b() instanceof ItemSnowball && (Boolean)this.useSnowballValue.get() != false};
            Boolean[] $this$any$iv = booleanArray;
            boolean $i$f$any = false;
            for (Boolean element$iv : $this$any$iv) {
                boolean it = element$iv;
                boolean bl3 = false;
                if (!it) continue;
                bl2 = true;
                break block1;
            }
            bl2 = false;
        }
        return bl2;
    }

    private static final boolean onMovementInput$lambda$8(Entity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return TargetsManager.isSelected$default(DarkMeow.INSTANCE.getCombatManager().getTargetsManager(), it, true, false, 4, null);
    }
}

