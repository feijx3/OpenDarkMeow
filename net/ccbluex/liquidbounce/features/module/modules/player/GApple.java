/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.item.ItemAppleGold
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.EnumHand
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.player;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.exclusive.ExtendModuleExclusive;
import net.ccbluex.liquidbounce.features.module.modules.movement.Sprint;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.GAppleExtend;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.event.GAppleDoEatPostEvent;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.event.GAppleDoEatPreEvent;
import net.ccbluex.liquidbounce.handler.movement.stuck.MovementStuckManagerExtend;
import net.ccbluex.liquidbounce.injection.extend.ExtendPlayerControllerMP;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayerSP;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.utils.MovementUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013J\n\u0010\u0014\u001a\u00020\u0012*\u00020\u0013R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/GApple;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "eatTicksValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "eatTravelModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "debugValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "extends", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/GAppleExtend;", "onEnable", "", "onDisable", "isAllowExecute", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "isAllowEat", "tag", "getTag", "()Ljava/lang/String;", "TravelMode", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nGApple.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GApple.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/GApple\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,218:1\n1563#2:219\n1634#2,3:220\n774#2:227\n865#2,2:228\n1563#2:230\n1634#2,3:231\n1056#2:234\n1869#2:235\n1869#2,2:237\n1870#2:239\n774#2:243\n865#2,2:244\n1869#2,2:246\n774#2:248\n865#2,2:249\n1869#2,2:251\n774#2:253\n865#2,2:254\n1740#2,3:256\n774#2:259\n865#2,2:260\n1740#2,3:262\n774#2:265\n865#2,2:266\n1869#2,2:268\n774#2:270\n865#2,2:271\n1869#2,2:273\n37#3:223\n36#3,3:224\n1#4:236\n20#5,3:240\n*S KotlinDebug\n*F\n+ 1 GApple.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/GApple\n*L\n67#1:219\n67#1:220,3\n82#1:227\n82#1:228,2\n83#1:230\n83#1:231,3\n84#1:234\n85#1:235\n89#1:237,2\n85#1:239\n109#1:243\n109#1:244,2\n110#1:246,2\n117#1:248\n117#1:249,2\n118#1:251,2\n187#1:253\n187#1:254,2\n188#1:256,3\n196#1:259\n196#1:260,2\n197#1:262,3\n142#1:265\n142#1:266,2\n143#1:268,2\n161#1:270\n161#1:271,2\n162#1:273,2\n67#1:223\n67#1:224,3\n128#1:240,3\n*E\n"})
public final class GApple
extends Module {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public final IntegerValue eatTicksValue = new IntegerValue("EatTicks", 32, new IntRange(0, 40));
    @JvmField
    @NotNull
    public final ListValue eatTravelModeValue;
    @JvmField
    @NotNull
    public final BoolValue debugValue;
    @NotNull
    private final Map<String, GAppleExtend> extends;

    /*
     * WARNING - void declaration
     */
    public GApple() {
        super("GApple", ModuleCategory.PLAYER, null, null, 12, null);
        void $receiver$iv;
        Iterable $this$filterTo$iv$iv;
        Class it;
        Collection<String> collection;
        Object item$iv$iv;
        Iterator $this$mapTo$iv$iv;
        Iterable $this$map$iv;
        Iterable iterable = TravelMode.getEntries();
        String string = "EatTravelMode";
        Object object = this;
        boolean $i$f$map = false;
        void var3_6 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            item$iv$iv = iterator2.next();
            TravelMode travelMode = (TravelMode)((Object)item$iv$iv);
            collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(((Enum)((Object)it)).name());
        }
        collection = (List)destination$iv$iv;
        Value[] $this$toTypedArray$iv = (Value[])collection;
        boolean $i$f$toTypedArray = false;
        Object thisCollection$iv = $this$toTypedArray$iv;
        String string2 = "LessTravel";
        String[] stringArray = thisCollection$iv.toArray(new String[0]);
        String string3 = string;
        ((GApple)object).eatTravelModeValue = new ListValue(string3, stringArray, string2);
        this.debugValue = new BoolValue("Debug", false);
        this.extends = new LinkedHashMap();
        ExtendModuleExclusive.INSTANCE.registerExclusive(this, "stuck");
        $this$toTypedArray$iv = new Value[]{this.eatTicksValue, this.eatTravelModeValue};
        this.getValues().addAll((Collection)CollectionsKt.listOf($this$toTypedArray$iv));
        Iterable $this$filter$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".g_apple.extend.impl", GAppleExtend.class);
        boolean $i$f$filter = false;
        thisCollection$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (Class)element$iv$iv;
            boolean bl3 = false;
            if (!(!Modifier.isAbstract(it.getModifiers()))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$map$iv = (List)destination$iv$iv;
        $i$f$map = false;
        $this$filterTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        $i$f$mapTo = false;
        iterator2 = $this$mapTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            item$iv$iv = iterator2.next();
            it = (Class)item$iv$iv;
            object = destination$iv$iv;
            boolean bl4 = false;
            object.add((GAppleExtend)it.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        Iterable $this$sortedBy$iv = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        Object $this$forEach$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                GAppleExtend it = (GAppleExtend)a2;
                boolean bl2 = false;
                Comparable comparable = (Comparable)((Object)it.getName());
                it = (GAppleExtend)b2;
                Comparable comparable2 = comparable;
                bl2 = false;
                return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
            }
        });
        boolean $i$f$forEach22 = false;
        $this$mapTo$iv$iv = $this$forEach$iv.iterator();
        while ($this$mapTo$iv$iv.hasNext()) {
            Object element$iv = $this$mapTo$iv$iv.next();
            GAppleExtend extend = (GAppleExtend)element$iv;
            boolean bl5 = false;
            Object it2 = item$iv$iv = new BoolValue(extend.getName(), extend.getDefaultState());
            GAppleExtend gAppleExtend = extend;
            boolean bl6 = false;
            this.getValues().add((Value<?>)it2);
            gAppleExtend.setLinkedStatValue((BoolValue)item$iv$iv);
            extend.setInstance(this);
            Iterable $this$forEach$iv2 = extend.getValues();
            boolean $i$f$forEach = false;
            for (Object element$iv2 : $this$forEach$iv2) {
                Value value = (Value)element$iv2;
                boolean bl7 = false;
                value.setName(extend.getName() + value.getName());
                if (value.getSuperValue() == null) {
                    value.setSuperValue(extend.getLinkedStatValue());
                }
                this.getValues().add(value);
            }
            this.extends.put(extend.getName(), extend);
            EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
            Intrinsics.checkNotNull(extend);
            EventManager.registerListener$default(eventManager, extend, false, false, 6, null);
        }
        this.getValues().add(this.debugValue);
        $this$forEach$iv = ListenableOwnerExtends.INSTANCE;
        ListenableOwner $i$f$forEach22 = this;
        Function2<SafeListenerBase, MovementInputEvent.POST, Unit> function$iv = (arg_0, arg_1) -> GApple._init_$lambda$21(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookSafeOwnerCheck<MovementInputEvent.POST>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(MovementInputEvent.POST.class), (ListenableOwner)$receiver$iv));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onEnable() {
        void $this$filterTo$iv$iv;
        Sprint.lockNoSprint$default(this.getName(), null, 2, null);
        Iterable $this$filter$iv = this.extends.values();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            GAppleExtend it = (GAppleExtend)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GAppleExtend extend = (GAppleExtend)element$iv;
            boolean bl3 = false;
            GAppleExtend $this$onEnable_u24lambda_u249_u24lambda_u248 = extend;
            boolean bl4 = false;
            $this$onEnable_u24lambda_u249_u24lambda_u248.onEnable();
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
            GAppleExtend it = (GAppleExtend)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GAppleExtend extend = (GAppleExtend)element$iv;
            boolean bl3 = false;
            GAppleExtend $this$onDisable_u24lambda_u2412_u24lambda_u2411 = extend;
            boolean bl4 = false;
            $this$onDisable_u24lambda_u2412_u24lambda_u2411.onDisable();
        }
        DarkMeow.INSTANCE.getMovementManager().getStuckManager().setCancelPlayerSPUpdateWalkingCount(0);
        DarkMeow.INSTANCE.getMovementManager().getStuckManager().stop();
        Sprint.unlockNoSprint(this.getName());
    }

    /*
     * WARNING - void declaration
     */
    public final boolean isAllowExecute(@NotNull SafeListenerBase $this$isAllowExecute) {
        boolean bl2;
        block4: {
            void $this$filterTo$iv$iv;
            Intrinsics.checkNotNullParameter($this$isAllowExecute, "<this>");
            Iterable $this$filter$iv = this.extends.values();
            boolean $i$f$filter = false;
            Iterable iterable = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                GAppleExtend it = (GAppleExtend)element$iv$iv;
                boolean bl3 = false;
                if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Iterable $this$all$iv = (List)destination$iv$iv;
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl2 = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    GAppleExtend extend = (GAppleExtend)element$iv;
                    boolean bl4 = false;
                    GAppleExtend $this$isAllowExecute_u24lambda_u2424_u24lambda_u2423 = extend;
                    boolean bl5 = false;
                    if ($this$isAllowExecute_u24lambda_u2424_u24lambda_u2423.preExecute($this$isAllowExecute)) continue;
                    bl2 = false;
                    break block4;
                }
                bl2 = true;
            }
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean isAllowEat(@NotNull SafeListenerBase $this$isAllowEat) {
        boolean bl2;
        block4: {
            void $this$filterTo$iv$iv;
            Intrinsics.checkNotNullParameter($this$isAllowEat, "<this>");
            Iterable $this$filter$iv = this.extends.values();
            boolean $i$f$filter = false;
            Iterable iterable = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                GAppleExtend it = (GAppleExtend)element$iv$iv;
                boolean bl3 = false;
                if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Iterable $this$all$iv = (List)destination$iv$iv;
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl2 = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    GAppleExtend extend = (GAppleExtend)element$iv;
                    boolean bl4 = false;
                    GAppleExtend $this$isAllowEat_u24lambda_u2427_u24lambda_u2426 = extend;
                    boolean bl5 = false;
                    if ($this$isAllowEat_u24lambda_u2427_u24lambda_u2426.preEat($this$isAllowEat)) continue;
                    bl2 = false;
                    break block4;
                }
                bl2 = true;
            }
        }
        return bl2;
    }

    @Override
    @NotNull
    public String getTag() {
        return "" + MovementStuckManagerExtend.INSTANCE.getSafeReleaseCount(DarkMeow.INSTANCE.getMovementManager().getStuckManager()) + '/' + ((Number)this.eatTicksValue.get()).intValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit _init_$lambda$21(GApple this$0, SafeListenerBase $this$safeListener, MovementInputEvent.POST event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this$0.isAllowExecute($this$safeListener)) {
            return Unit.INSTANCE;
        }
        if (((Boolean)this$0.debugValue.get()).booleanValue() && $this$safeListener.getPlayer().field_70173_aa % 4 == 0) {
            DarkMeow.INSTANCE.getMessageManager().display.displayInfo("[GApple] " + MovementStuckManagerExtend.INSTANCE.getSafeReleaseCount(DarkMeow.INSTANCE.getMovementManager().getStuckManager()));
        }
        if (DarkMeow.INSTANCE.getMovementManager().getStuckManager().isInStuck()) {
            if (MovementStuckManagerExtend.INSTANCE.getSafeReleaseCount(DarkMeow.INSTANCE.getMovementManager().getStuckManager()) >= ((Number)this$0.eatTicksValue.get()).intValue() && this$0.isAllowEat($this$safeListener)) {
                Integer n2 = Companion.searchGAppleSlot($this$safeListener.getPlayer());
                if (n2 != null) {
                    void $this$forEach$iv;
                    void $this$filterTo$iv$iv;
                    Iterable $this$filter$iv;
                    void $this$forEach$iv22;
                    Iterator $this$filterTo$iv$iv2;
                    Iterable $this$filter$iv2;
                    Integer n3 = n2;
                    int selectSlot = ((Number)n3).intValue();
                    boolean bl2 = false;
                    GAppleDoEatPreEvent preEvent = new GAppleDoEatPreEvent(selectSlot, $this$safeListener.getPlayer().field_71071_by.field_70461_c, TravelMode.valueOf((String)this$0.eatTravelModeValue.get()), ((Number)this$0.eatTicksValue.get()).intValue());
                    Iterable iterable = this$0.extends.values();
                    boolean $i$f$filter = false;
                    void var10_12 = $this$filter$iv2;
                    Collection destination$iv$iv = new ArrayList();
                    boolean $i$f$filterTo = false;
                    Iterator iterator2 = $this$filterTo$iv$iv2.iterator();
                    while (iterator2.hasNext()) {
                        Object element$iv$iv = iterator2.next();
                        GAppleExtend it = (GAppleExtend)element$iv$iv;
                        boolean bl3 = false;
                        if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $this$filter$iv2 = (List)destination$iv$iv;
                    int $i$f$forEach22 = 0;
                    for (Object element$iv : $this$forEach$iv22) {
                        GAppleExtend extend = (GAppleExtend)element$iv;
                        boolean bl4 = false;
                        GAppleExtend $this$lambda_u2421_u24lambda_u2420_u24lambda_u2415_u24lambda_u2414 = extend;
                        boolean bl5 = false;
                        $this$lambda_u2421_u24lambda_u2420_u24lambda_u2415_u24lambda_u2414.doEatPre($this$safeListener, preEvent);
                    }
                    $this$safeListener.getPlayer().field_71071_by.field_70461_c = preEvent.getSelectSlot();
                    ExtendPlayerControllerMP.INSTANCE.syncCurrentPlayItem($this$safeListener.getPlayerController());
                    $this$safeListener.getConnection().func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                    int $this$forEach$iv22 = preEvent.getEatTick();
                    $i$f$forEach22 = 0;
                    while ($i$f$forEach22 < $this$forEach$iv22) {
                        int it = $i$f$forEach22++;
                        boolean bl6 = false;
                        preEvent.getTravelMode().getBlock().invoke($this$safeListener.getPlayer());
                    }
                    DarkMeow.INSTANCE.getMovementManager().getStuckManager().setCancelPlayerSPUpdateWalkingCount(0);
                    $this$safeListener.getPlayer().field_71071_by.field_70461_c = preEvent.getPrevSlot();
                    ExtendPlayerControllerMP.INSTANCE.syncCurrentPlayItem($this$safeListener.getPlayerController());
                    GAppleDoEatPostEvent postEvent = new GAppleDoEatPostEvent(preEvent);
                    Iterable $i$f$forEach22 = this$0.extends.values();
                    boolean $i$f$filter2 = false;
                    void bl6 = $this$filter$iv;
                    Collection destination$iv$iv2 = new ArrayList();
                    boolean $i$f$filterTo2 = false;
                    for (Object element$iv$iv : $this$filterTo$iv$iv) {
                        GAppleExtend it = (GAppleExtend)element$iv$iv;
                        boolean bl7 = false;
                        if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
                        destination$iv$iv2.add(element$iv$iv);
                    }
                    $this$filter$iv = (List)destination$iv$iv2;
                    boolean $i$f$forEach = false;
                    for (Object element$iv : $this$forEach$iv) {
                        GAppleExtend extend = (GAppleExtend)element$iv;
                        boolean bl8 = false;
                        GAppleExtend $this$lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2418 = extend;
                        boolean bl9 = false;
                        $this$lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2418.doEatPost($this$safeListener, postEvent);
                    }
                    if (((Boolean)this$0.debugValue.get()).booleanValue()) {
                        DarkMeow.INSTANCE.getMessageManager().display.displayInfo("[GApple] Eat(slot=" + selectSlot + ')');
                    }
                }
            }
        } else {
            boolean bl10;
            boolean bl11 = bl10 = $this$safeListener.getPlayer().func_70051_ag() || ExtendEntityPlayerSP.INSTANCE.getServerSprintState($this$safeListener.getPlayer());
            if (bl10) {
                $this$safeListener.getPlayer().func_70031_b(false);
                MovementUtils.INSTANCE.resetMove(event.getMovementInput());
            } else if (!bl10) {
                DarkMeow.INSTANCE.getMovementManager().getStuckManager().start();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/GApple$Companion;", "", "<init>", "()V", "searchGAppleSlot", "", "Lnet/minecraft/client/entity/EntityPlayerSP;", "(Lnet/minecraft/client/entity/EntityPlayerSP;)Ljava/lang/Integer;", "DarkMeow"})
    @SourceDebugExtension(value={"SMAP\nGApple.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GApple.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/GApple$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,218:1\n360#2,7:219\n1#3:226\n*S KotlinDebug\n*F\n+ 1 GApple.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/GApple$Companion\n*L\n209#1:219,7\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final Integer searchGAppleSlot(@NotNull EntityPlayerSP $this$searchGAppleSlot) {
            int n2;
            block2: {
                Intrinsics.checkNotNullParameter($this$searchGAppleSlot, "<this>");
                List list = $this$searchGAppleSlot.field_71069_bz.func_75138_a().subList(36, 45);
                Intrinsics.checkNotNullExpressionValue(list, "subList(...)");
                List $this$indexOfFirst$iv = list;
                boolean $i$f$indexOfFirst = false;
                int index$iv = 0;
                for (Object item$iv : $this$indexOfFirst$iv) {
                    ItemStack slot = (ItemStack)item$iv;
                    boolean bl2 = false;
                    if (slot.func_77973_b() instanceof ItemAppleGold) {
                        n2 = index$iv;
                        break block2;
                    }
                    ++index$iv;
                }
                n2 = -1;
            }
            Integer n3 = n2;
            int it = ((Number)n3).intValue();
            boolean bl3 = false;
            return it >= 0 ? n3 : null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B,\b\u0002\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\u0004\b\t\u0010\nR,\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/GApple$TravelMode;", "", "block", "Lkotlin/Function1;", "Lnet/minecraft/client/entity/EntityPlayerSP;", "Lkotlin/ParameterName;", "name", "player", "", "<init>", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", "LessTravel", "FullTravel", "DarkMeow"})
    public static final class TravelMode
    extends Enum<TravelMode> {
        @NotNull
        private final Function1<EntityPlayerSP, Unit> block;
        public static final /* enum */ TravelMode LessTravel = new TravelMode(TravelMode::_init_$lambda$0);
        public static final /* enum */ TravelMode FullTravel = new TravelMode(TravelMode::_init_$lambda$1);
        private static final /* synthetic */ TravelMode[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private TravelMode(Function1<? super EntityPlayerSP, Unit> block) {
            this.block = block;
        }

        @NotNull
        public final Function1<EntityPlayerSP, Unit> getBlock() {
            return this.block;
        }

        public static TravelMode[] values() {
            return (TravelMode[])$VALUES.clone();
        }

        public static TravelMode valueOf(String value) {
            return Enum.valueOf(TravelMode.class, value);
        }

        @NotNull
        public static EnumEntries<TravelMode> getEntries() {
            return $ENTRIES;
        }

        private static final Unit _init_$lambda$0(EntityPlayerSP player) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (ExtendEntityPlayerSP.INSTANCE.getPositionUpdateTicks(player) >= 19) {
                MovementStuckManagerExtend.travelOnStuck$default(MovementStuckManagerExtend.INSTANCE, player, 0.0f, 0.0f, 0.0f, 7, null);
                MovementStuckManagerExtend.INSTANCE.syncPositionToServerOnStuck(player);
            } else {
                player.field_71174_a.func_147297_a((Packet)new CPacketPlayer(player.field_70122_E));
                int n2 = ExtendEntityPlayerSP.INSTANCE.getPositionUpdateTicks(player);
                ExtendEntityPlayerSP.INSTANCE.setPositionUpdateTicks(player, n2 + 1);
            }
            return Unit.INSTANCE;
        }

        private static final Unit _init_$lambda$1(EntityPlayerSP player) {
            Intrinsics.checkNotNullParameter(player, "player");
            MovementStuckManagerExtend.travelOnStuck$default(MovementStuckManagerExtend.INSTANCE, player, 0.0f, 0.0f, 0.0f, 7, null);
            MovementStuckManagerExtend.INSTANCE.syncPositionToServerOnStuck(player);
            return Unit.INSTANCE;
        }

        static {
            $VALUES = travelModeArray = new TravelMode[]{TravelMode.LessTravel, TravelMode.FullTravel};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

