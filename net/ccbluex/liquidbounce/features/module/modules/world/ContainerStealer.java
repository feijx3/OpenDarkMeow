/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.inventory.Slot
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.Render2DEvent;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.ContainerStealerClickMode;
import net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.ContainerStealerExtend;
import net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.ContainerStealerStatic;
import net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.enums.EnumPreContainerCloseAction;
import net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.enums.EnumPreStealerAction;
import net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.enums.EnumPreTakenAction;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.utils.minecraft.container.ContainerUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\n\u0010\u0014\u001a\u00020\u0015*\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0006\u0010\u0019\u001a\u00020\u0015R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/ContainerStealer;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "clickModes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/ContainerStealerClickMode;", "getClickModes", "()Ljava/util/Map;", "extends", "Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/ContainerStealerExtend;", "getExtends", "atValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "clickModeValue", "allowStealer", "", "screen", "Lnet/minecraft/client/gui/inventory/GuiContainer;", "handle", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "onEnable", "onDisable", "closeContainer", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nContainerStealer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContainerStealer.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/ContainerStealer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,208:1\n1#2:209\n1563#3:210\n1634#3,3:211\n1056#3:214\n1869#3:215\n1869#3,2:216\n1870#3:218\n1563#3:223\n1634#3,3:224\n1056#3:227\n1869#3:228\n1869#3,2:229\n1870#3:231\n774#3:238\n865#3,2:239\n1740#3,3:241\n774#3:244\n865#3,2:245\n1573#3:247\n1604#3,4:248\n774#3:252\n865#3,2:253\n1869#3:255\n774#3:256\n865#3,2:257\n774#3:259\n865#3,2:260\n1869#3,2:262\n1870#3:264\n774#3:265\n865#3,2:266\n1869#3,2:268\n774#3:270\n865#3,2:271\n1869#3,2:273\n774#3:275\n865#3,2:276\n774#3:278\n865#3,2:279\n1869#3,2:281\n37#4:219\n36#4,3:220\n20#5,3:232\n20#5,3:235\n*S KotlinDebug\n*F\n+ 1 ContainerStealer.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/ContainerStealer\n*L\n41#1:210\n41#1:211,3\n42#1:214\n43#1:215\n46#1:216,2\n43#1:218\n63#1:223\n63#1:224,3\n64#1:227\n65#1:228\n82#1:229,2\n65#1:231\n104#1:238\n104#1:239,2\n105#1:241,3\n116#1:244\n116#1:245,2\n136#1:247\n136#1:248,4\n139#1:252\n139#1:253,2\n142#1:255\n144#1:256\n144#1:257,2\n166#1:259\n166#1:260,2\n167#1:262,2\n142#1:264\n180#1:265\n180#1:266,2\n181#1:268,2\n187#1:270\n187#1:271,2\n188#1:273,2\n193#1:275\n193#1:276,2\n201#1:278\n201#1:279,2\n202#1:281,2\n58#1:219\n58#1:220,3\n95#1:232,3\n98#1:235,3\n*E\n"})
public final class ContainerStealer
extends Module {
    @NotNull
    private final Map<String, ContainerStealerClickMode> clickModes = new LinkedHashMap();
    @NotNull
    private final Map<String, ContainerStealerExtend> extends = new LinkedHashMap();
    @JvmField
    @NotNull
    public final ListValue atValue;
    @JvmField
    @NotNull
    public final ListValue clickModeValue;

    /*
     * WARNING - void declaration
     */
    public ContainerStealer() {
        super("ContainerStealer", ModuleCategory.WORLD, null, null, 12, null);
        ListenableOwner $receiver$iv;
        Object thisCollection$iv;
        Value value;
        String it;
        Collection collection;
        boolean $i$f$mapTo2;
        Collection destination$iv$iv;
        List $this$map$iv;
        Object object = new String[]{"Tick", "Update"};
        this.atValue = new ListValue("At", (String[])object, "Update");
        this.clickModeValue = new ListValue("ClickMode", null, "QuickMove", 2, null);
        this.getValues().add(this.atValue);
        this.getValues().add(this.clickModeValue);
        Object object2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".container_stealer.click_mode", ContainerStealerClickMode.class);
        List<Class<ContainerStealerClickMode>> it2 = object2;
        boolean bl2 = false;
        Object object3 = object = !((Collection)it2).isEmpty() ? object2 : null;
        if (object != null) {
            void $this$sortedBy$iv;
            void $this$mapTo$iv$iv;
            $this$map$iv = (List)object;
            boolean $i$f$map22 = false;
            List list = $this$map$iv;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            $i$f$mapTo2 = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Class clazz = (Class)item$iv$iv;
                collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add((ContainerStealerClickMode)((Class)((Object)it)).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            boolean $i$f$sortedBy2 = false;
            $this$map$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    ContainerStealerClickMode it = (ContainerStealerClickMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (ContainerStealerClickMode)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                }
            });
            if ($this$map$iv != null) {
                Unit $this$forEach$iv;
                Iterable $i$f$sortedBy2 = $this$map$iv;
                boolean $i$f$forEach = false;
                Iterator $i$f$mapTo2 = $this$forEach$iv.iterator();
                while ($i$f$mapTo2.hasNext()) {
                    Object element$iv = $i$f$mapTo2.next();
                    ContainerStealerClickMode it3 = (ContainerStealerClickMode)element$iv;
                    boolean bl4 = false;
                    it3.setInstance(this);
                    Iterable $this$forEach$iv2 = it3.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        value = (Value)element$iv2;
                        boolean bl5 = false;
                        value.setName("ClickMode" + it3.getName() + value.getName());
                        if (value.getSuperValue() == null) {
                            value.setSuperValue(this.clickModeValue);
                            value.setSuperValueMeta(it3.getName());
                        }
                        this.getValues().add(value);
                    }
                    this.clickModes.put(it3.getName(), it3);
                }
                Unit it4 = $this$forEach$iv = Unit.INSTANCE;
                boolean bl6 = false;
                Collection $this$toTypedArray$iv = this.clickModes.keySet();
                boolean $i$f$toTypedArray = false;
                thisCollection$iv = $this$toTypedArray$iv;
                this.clickModeValue.setValues(thisCollection$iv.toArray(new String[0]));
            }
        }
        object2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".container_stealer.extend", ContainerStealerExtend.class);
        it2 = object2;
        boolean bl7 = false;
        Object object4 = object = !((Collection)it2).isEmpty() ? object2 : null;
        if (object != null) {
            Iterable $this$sortedBy$iv;
            boolean bl8;
            void $this$mapTo$iv$iv;
            $this$map$iv = (Iterable)object;
            boolean $i$f$map32 = false;
            List $this$forEach$iv = $this$map$iv;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            $i$f$mapTo2 = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                thisCollection$iv = (Class)item$iv$iv;
                collection = destination$iv$iv;
                bl8 = false;
                collection.add((ContainerStealerExtend)((Class)((Object)it)).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map32 = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            $this$map$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    ContainerStealerExtend it = (ContainerStealerExtend)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (ContainerStealerExtend)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                }
            });
            if ($this$map$iv != null) {
                void $this$forEach$iv3;
                $this$sortedBy$iv = $this$map$iv;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv3) {
                    ContainerStealerExtend it5 = (ContainerStealerExtend)element$iv;
                    boolean bl9 = false;
                    it = it5.getName();
                    bl8 = it5.getDefaultState();
                    BoolValue modulesMode2 = new BoolValue(this, it5, it, bl8){
                        final /* synthetic */ ContainerStealer this$0;
                        final /* synthetic */ ContainerStealerExtend $it;
                        {
                            this.this$0 = $receiver;
                            this.$it = $it;
                            super($super_call_param$1, $super_call_param$2);
                        }

                        protected void onChanged(boolean oldValue, boolean newValue) {
                            if (this.this$0.getState()) {
                                boolean bl2 = newValue;
                                if (bl2) {
                                    this.$it.onEnable();
                                } else if (!bl2) {
                                    this.$it.onDisable();
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                        }
                    };
                    it5.setLinkedStatValue(modulesMode2);
                    it5.setInstance(this);
                    this.getValues().add(modulesMode2);
                    Iterable $this$forEach$iv4 = it5.getValues();
                    boolean $i$f$forEach3 = false;
                    for (Object element$iv2 : $this$forEach$iv4) {
                        value = (Value)element$iv2;
                        boolean bl10 = false;
                        value.setName(it5.getName() + value.getName());
                        if (value.getSuperValue() == null) {
                            value.setSuperValue(modulesMode2);
                        }
                        this.getValues().add(value);
                    }
                    this.extends.put(it5.getName(), it5);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(it5);
                    EventManager.registerListener$default(eventManager, it5, false, false, 6, null);
                }
            }
        }
        object = ListenableOwnerExtends.INSTANCE;
        object2 = this;
        Function2<SafeListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> ContainerStealer._init_$lambda$11(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<Render2DEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(Render2DEvent.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> ContainerStealer._init_$lambda$12(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<Render2DEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(MovementInputEvent.PRE.class), $receiver$iv));
    }

    @NotNull
    public final Map<String, ContainerStealerClickMode> getClickModes() {
        return this.clickModes;
    }

    @NotNull
    public final Map<String, ContainerStealerExtend> getExtends() {
        return this.extends;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean allowStealer(@NotNull GuiContainer screen) {
        ContainerStealerExtend it;
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (!ContainerStealerStatic.INSTANCE.allowStealer(screen)) return false;
        Iterable $this$filter$iv = this.extends.values();
        boolean $i$f$filter = false;
        Object object = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            ContainerStealerExtend it2 = (ContainerStealerExtend)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it2.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$all$iv = (List)destination$iv$iv;
        boolean $i$f$all = false;
        if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
            return true;
        }
        object = $this$all$iv.iterator();
        do {
            if (!object.hasNext()) return true;
            Object element$iv = object.next();
            it = (ContainerStealerExtend)element$iv;
            boolean bl3 = false;
        } while (it.allowStealer(screen));
        return false;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void handle(@NotNull SafeListenerBase $this$handle) {
        block24: {
            block25: {
                block22: {
                    Intrinsics.checkNotNullParameter($this$handle, "<this>");
                    it = var3_2 = DarkMeow.INSTANCE.getInventoryManager().getContainerManager();
                    $i$a$-takeIf-ContainerStealer$handle$1 = false;
                    v0 = var2_6 = it.getReadyWindowItems() != false ? var3_2 : null;
                    if (var2_6 == null || (var3_2 = var2_6.getScreen()) == null) break block24;
                    screen = var5_5 = var3_2;
                    $i$a$-takeIf-ContainerStealer$handle$2 = false;
                    v1 = var4_3 = this.allowStealer((GuiContainer)screen) != false ? var5_5 : null;
                    if (var4_3 == null) break block24;
                    screen = var6_7 = var4_3;
                    $i$a$-takeIf-ContainerStealer$handle$3 = false;
                    var9_11 = this.extends.values();
                    $i$f$filter = false;
                    var11_15 = $this$filter$iv;
                    destination$iv$iv = new ArrayList<E>();
                    $i$f$filterTo = false;
                    for (T element$iv$iv : $this$filterTo$iv$iv) {
                        it = (ContainerStealerExtend)element$iv$iv;
                        $i$a$-filter-ContainerStealer$handle$3$1 = false;
                        if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
                        destination$iv$iv.add(element$iv$iv);
                    }
                    for (ContainerStealerExtend it : (Iterable)((List)destination$iv$iv)) {
                        $i$a$-firstNotNullOfOrNull-ContainerStealer$handle$3$2 = false;
                        if ((it /* !! */  = it /* !! */ .preStealer((GuiContainer)screen)) == null) continue;
                        v2 /* !! */  = it /* !! */ ;
                        break block22;
                    }
                    v2 /* !! */  = null;
                }
                result = v2 /* !! */ ;
                $i$a$-let-ContainerStealer$handle$3$3 = false;
                v3 = result;
                switch (v3 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[v3.ordinal()]) {
                    case 1: {
                        v4 = false;
                        break;
                    }
                    case 2: {
                        this.closeContainer();
                        v4 = false;
                        break;
                    }
                    default: {
                        v4 = true;
                    }
                }
                v5 = var5_5 = v4 != false ? var6_7 : null;
                if (var5_5 == null) break block24;
                screen = var6_7 = var5_5;
                $i$a$-also-ContainerStealer$handle$4 = false;
                closeOnDone = false;
                closeOnDone = true;
                it = var10_14 = screen.field_147002_h.field_75151_b;
                $i$a$-takeUnless-ContainerStealer$handle$4$1 = false;
                v6 = $this$handle.getPlayer().field_71069_bz;
                Intrinsics.checkNotNullExpressionValue(v6, "inventoryContainer");
                v7 = var13_23 = ContainerUtils.isFull$default(ContainerUtils.INSTANCE, v6, null, 1, null) == false ? var10_14 : null;
                if (var13_23 == null || (var10_14 = var13_23.subList(0, screen.field_147002_h.field_75151_b.size() - 36)) == null) break block25;
                $i$a$-takeUnless-ContainerStealer$handle$4$1 = var10_14;
                $i$f$mapIndexed = false;
                element$iv$iv = $this$mapIndexed$iv;
                destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                $i$f$mapIndexedTo = false;
                index$iv$iv = 0;
                for (T item$iv$iv : $this$mapIndexedTo$iv$iv) {
                    if ((var21_38 = index$iv$iv++) < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    var22_41 = (Slot)item$iv$iv;
                    var23_44 = var21_38;
                    var24_48 = destination$iv$iv;
                    $i$a$-mapIndexed-ContainerStealer$handle$4$2 = false;
                    var24_48.add(new Pair<Integer, void>((int)index, slot));
                }
                $i$f$mapIndexed = (List)destination$iv$iv;
                $i$f$filter = false;
                destination$iv$iv = $this$filter$iv;
                destination$iv$iv = new ArrayList<E>();
                $i$f$filterTo = false;
                for (T element$iv$iv : $this$filterTo$iv$iv) {
                    var21_39 = (Pair)element$iv$iv;
                    $i$a$-filter-ContainerStealer$handle$4$3 = false;
                    slot = (Slot)var21_39.component2();
                    if (!(slot.func_75216_d() != false && slot.func_111238_b() != false)) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                $this$filter$iv = (List)destination$iv$iv;
                $i$f$forEach = false;
                block14: for (T element$iv : $this$forEach$iv) {
                    block23: {
                        var18_33 = (Pair)element$iv;
                        $i$a$-forEach-ContainerStealer$handle$4$4 = false;
                        index = ((Number)var18_33.component1()).intValue();
                        slot = (Slot)var18_33.component2();
                        $i$a$-filter-ContainerStealer$handle$4$3 = this.extends.values();
                        $i$f$filter = false;
                        $i$a$-mapIndexed-ContainerStealer$handle$4$2 = $this$filter$iv;
                        destination$iv$iv = new ArrayList<E>();
                        $i$f$filterTo = false;
                        for (T element$iv$iv : $this$filterTo$iv$iv) {
                            it = (ContainerStealerExtend)element$iv$iv;
                            $i$a$-filter-ContainerStealer$handle$4$4$1 = false;
                            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
                            destination$iv$iv.add(element$iv$iv);
                        }
                        for (ContainerStealerExtend it : (Iterable)((List)destination$iv$iv)) {
                            $i$a$-firstNotNullOfOrNull-ContainerStealer$handle$4$4$2 = false;
                            v8 = slot.func_75211_c();
                            Intrinsics.checkNotNullExpressionValue(v8, "getStack(...)");
                            if ((it /* !! */  = it /* !! */ .preTaken((GuiContainer)screen, v8)) == null) continue;
                            v9 /* !! */  = it /* !! */ ;
                            break block23;
                        }
                        v9 /* !! */  = null;
                    }
                    result = var22_43 = v9 /* !! */ ;
                    $i$a$-also-ContainerStealer$handle$4$4$3 = false;
                    v10 = result;
                    switch (v10 == null ? -1 : WhenMappings.$EnumSwitchMapping$1[v10.ordinal()]) {
                        case 1: {
                            continue block14;
                        }
                        case 2: {
                            break block24;
                        }
                        case 3: {
                            this.closeContainer();
                            break block24;
                        }
                        case -1: {
                            $i$a$-firstNotNullOfOrNull-ContainerStealer$handle$4$4$2 = this.clickModes.get(this.clickModeValue.get());
                            if ($i$a$-firstNotNullOfOrNull-ContainerStealer$handle$4$4$2 == null) ** GOTO lbl-1000
                            $i$f$filterTo = $i$a$-firstNotNullOfOrNull-ContainerStealer$handle$4$4$2.click($this$handle.getPlayerController(), $this$handle.getPlayer(), screen.field_147002_h.field_75152_c, index);
                            it = $i$f$filterTo;
                            $i$a$-takeIf-ContainerStealer$handle$4$4$3$state$1 = false;
                            v11 = it = it != false ? $i$f$filterTo : null;
                            if (it != null) {
                                v12 = it.booleanValue();
                            } else lbl-1000:
                            // 2 sources

                            {
                                v12 = false;
                            }
                            state = v12;
                            $i$a$-firstNotNullOfOrNull-ContainerStealer$handle$4$4$2 = this.extends.values();
                            $i$f$filter = false;
                            it = $this$filter$iv;
                            destination$iv$iv = new ArrayList<E>();
                            $i$f$filterTo = false;
                            for (T element$iv$iv : $this$filterTo$iv$iv) {
                                it = (ContainerStealerExtend)element$iv$iv;
                                $i$a$-filter-ContainerStealer$handle$4$4$3$1 = false;
                                if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
                                destination$iv$iv.add(element$iv$iv);
                            }
                            $this$filter$iv = (List)destination$iv$iv;
                            $i$f$forEach = false;
                            for (T element$iv : $this$forEach$iv) {
                                it = (ContainerStealerExtend)element$iv;
                                $i$a$-forEach-ContainerStealer$handle$4$4$3$2 = false;
                                v13 = slot.func_75211_c();
                                Intrinsics.checkNotNullExpressionValue(v13, "getStack(...)");
                                it.postTaken((GuiContainer)screen, v13, state);
                            }
                            closeOnDone = false;
                            break;
                        }
                        default: {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
            }
            if (!closeOnDone) break block24;
            this.closeContainer();
        }
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
            ContainerStealerExtend it = (ContainerStealerExtend)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ContainerStealerExtend it = (ContainerStealerExtend)element$iv;
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
        this.closeContainer();
        Iterable $this$filter$iv = this.extends.values();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            ContainerStealerExtend it = (ContainerStealerExtend)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ContainerStealerExtend it = (ContainerStealerExtend)element$iv;
            boolean bl3 = false;
            it.onDisable();
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void closeContainer() {
        Object object;
        Object object2;
        block8: {
            void $this$filterTo$iv$iv;
            Iterable $this$filter$iv = this.extends.values();
            boolean $i$f$filter = false;
            Iterable iterable = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                ContainerStealerExtend it = (ContainerStealerExtend)element$iv$iv;
                boolean bl2 = false;
                if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            for (Object it : (Iterable)((List)destination$iv$iv)) {
                boolean bl3 = false;
                if ((it = ((ContainerStealerExtend)it).preContainerClose()) == null) continue;
                object2 = it;
                break block8;
            }
            object2 = null;
        }
        Object result = object = object2;
        boolean bl4 = false;
        Object object3 = result;
        switch (object3 == null ? -1 : WhenMappings.$EnumSwitchMapping$2[((Enum)object3).ordinal()]) {
            case 1: {
                return;
            }
            case -1: {
                void $this$forEach$iv;
                void $this$filterTo$iv$iv;
                Iterable $this$filter$iv;
                DarkMeow.INSTANCE.getInventoryManager().getContainerManager().closeContainer();
                Iterable bl3 = this.extends.values();
                boolean $i$f$filter = false;
                Iterator iterator2 = $this$filter$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    ContainerStealerExtend it = (ContainerStealerExtend)element$iv$iv;
                    boolean bl5 = false;
                    if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                $this$filter$iv = (List)destination$iv$iv;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    ContainerStealerExtend it = (ContainerStealerExtend)element$iv;
                    boolean bl6 = false;
                    it.postContainerClose();
                }
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    private static final Unit _init_$lambda$11(ContainerStealer this$0, SafeListenerBase $this$safeListener, Render2DEvent it) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(this$0.atValue.get(), "Tick")) {
            this$0.handle($this$safeListener);
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$12(ContainerStealer this$0, SafeListenerBase $this$safeListener, MovementInputEvent.PRE it) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(this$0.atValue.get(), "Update")) {
            this$0.handle($this$safeListener);
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] nArray = new int[EnumPreStealerAction.values().length];
            try {
                nArray[EnumPreStealerAction.CANCEL_CURRENT_TASK.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumPreStealerAction.CANCEL_CURRENT_TASK_AND_CLOSE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[EnumPreTakenAction.values().length];
            try {
                nArray[EnumPreTakenAction.CANCEL_CURRENT_SLOT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumPreTakenAction.CANCEL_CURRENT_TASK.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumPreTakenAction.CANCEL_CURRENT_TASK_AND_CLOSE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
            nArray = new int[EnumPreContainerCloseAction.values().length];
            try {
                nArray[EnumPreContainerCloseAction.CANCEL.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$2 = nArray;
        }
    }
}

