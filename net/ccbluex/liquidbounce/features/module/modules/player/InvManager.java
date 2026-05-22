/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.InvManagerExtend;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.InvManagerModeStatusCode;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.InvManagerModule;
import net.ccbluex.liquidbounce.features.module.modules.player.inv_manager.enums.InvManagerEnumPreExecuteAction;
import net.ccbluex.liquidbounce.handler.movement.MovementManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.utils.timer.delay.MSDelay;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerRangeValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0014J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J \u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0014R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/InvManager;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modules", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/InvManagerModule;", "extends", "Lnet/ccbluex/liquidbounce/features/module/modules/player/inv_manager/InvManagerExtend;", "normalDelayValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "moveDelayValue", "debugValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "delayTimer", "Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "newRandomDelay", "", "debug", "", "opt", "(Ljava/lang/String;)Ljava/lang/Boolean;", "checkDelay", "onEnable", "onDisable", "onMovementInputPost", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$POST;", "isUseful", "itemStack", "Lnet/minecraft/item/ItemStack;", "slot", "", "default", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nInvManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvManager.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/InvManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,173:1\n1563#2:174\n1634#2,3:175\n1056#2:178\n1869#2:179\n1869#2,2:180\n1870#2:182\n1563#2:183\n1634#2,3:184\n1869#2:187\n1869#2,2:188\n1870#2:190\n774#2:191\n865#2,2:192\n1869#2,2:194\n774#2:196\n865#2,2:197\n1869#2,2:199\n774#2:201\n865#2,2:202\n1869#2,2:205\n1#3:204\n*S KotlinDebug\n*F\n+ 1 InvManager.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/InvManager\n*L\n41#1:174\n41#1:175,3\n42#1:178\n43#1:179\n50#1:180,2\n43#1:182\n61#1:183\n61#1:184,3\n62#1:187\n78#1:188,2\n62#1:190\n125#1:191\n125#1:192,2\n126#1:194,2\n131#1:196\n131#1:197,2\n132#1:199,2\n140#1:201\n140#1:202,2\n152#1:205,2\n*E\n"})
public final class InvManager
extends Module {
    @NotNull
    private final Map<String, InvManagerModule> modules = new LinkedHashMap();
    @NotNull
    private final Map<String, InvManagerExtend> extends = new LinkedHashMap();
    @NotNull
    private final IntegerRangeValue normalDelayValue = new IntegerRangeValue("NormalDelay", new IntRange(0, 0), new IntRange(0, 1000));
    @NotNull
    private final IntegerRangeValue moveDelayValue = new IntegerRangeValue("MoveDelay", new IntRange(0, 0), new IntRange(0, 1000));
    @NotNull
    private final BoolValue debugValue = new BoolValue("Debug", false);
    @NotNull
    private final MSDelay delayTimer = new MSDelay();

    /*
     * WARNING - void declaration
     */
    public InvManager() {
        super("InvManager", ModuleCategory.PLAYER, null, null, 12, null);
        Value value;
        Object $this$forEach$iv;
        void it;
        Collection collection;
        Object item$iv$iv;
        Iterable $this$mapTo$iv$iv;
        IntegerRangeValue[] integerRangeValueArray = new IntegerRangeValue[]{this.normalDelayValue, this.moveDelayValue};
        CollectionsKt.addAll((Collection)this.getValues(), integerRangeValueArray);
        Iterable $this$map$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".inv_manager.modules", InvManagerModule.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            item$iv$iv = iterator2.next();
            Class clazz = (Class)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add((InvManagerModule)it.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        Iterable $this$sortedBy$iv = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        Iterable $this$forEach$iv2 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                InvManagerModule it = (InvManagerModule)a2;
                boolean bl2 = false;
                Comparable comparable = Integer.valueOf(it.getSort());
                it = (InvManagerModule)b2;
                Comparable comparable2 = comparable;
                bl2 = false;
                return ComparisonsKt.compareValues(comparable2, it.getSort());
            }
        });
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv2) {
            InvManagerModule it2 = (InvManagerModule)element$iv;
            boolean bl3 = false;
            BoolValue modulesValue2 = new BoolValue(it2.getName(), false);
            it2.setInstance(this);
            it2.setLinkedStatValue(modulesValue2);
            this.getValues().add(modulesValue2);
            $this$forEach$iv = it2.getValues();
            boolean $i$f$forEach2 = false;
            Iterator iterator3 = $this$forEach$iv.iterator();
            while (iterator3.hasNext()) {
                Object element$iv2 = iterator3.next();
                value = (Value)element$iv2;
                boolean bl4 = false;
                value.setName(it2.getName() + value.getName());
                value.setSuperValue(modulesValue2);
                value.setSuperValueMeta(it2.getName());
                this.getValues().add(value);
            }
            this.modules.put(it2.getName(), it2);
        }
        $this$map$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".inv_manager.extend", InvManagerExtend.class);
        $i$f$map = false;
        $this$mapTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        $i$f$mapTo = false;
        Iterator bl3 = $this$mapTo$iv$iv.iterator();
        while (bl3.hasNext()) {
            item$iv$iv = bl3.next();
            $this$forEach$iv = (Class)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl5 = false;
            collection.add((InvManagerExtend)it.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        $this$forEach$iv2 = (List)destination$iv$iv;
        $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv2) {
            InvManagerExtend it3 = (InvManagerExtend)element$iv;
            boolean bl6 = false;
            item$iv$iv = it3.getName();
            boolean it4 = it3.getDefaultState();
            BoolValue modulesValue3 = new BoolValue(this, it3, (String)item$iv$iv, it4){
                final /* synthetic */ InvManager this$0;
                final /* synthetic */ InvManagerExtend $it;
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
            it3.setInstance(this);
            it3.setLinkedStatValue(modulesValue3);
            this.getValues().add(modulesValue3);
            Iterable $this$forEach$iv3 = it3.getValues();
            boolean $i$f$forEach3 = false;
            for (Object element$iv2 : $this$forEach$iv3) {
                value = (Value)element$iv2;
                boolean bl7 = false;
                value.setName(it3.getName() + value.getName());
                value.setSuperValue(modulesValue3);
                value.setSuperValueMeta(it3.getName());
                this.getValues().add(value);
            }
            this.extends.put(it3.getName(), it3);
            EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
            Intrinsics.checkNotNull(it3);
            EventManager.registerListener$default(eventManager, it3, false, false, 6, null);
        }
        this.getValues().add(this.debugValue);
    }

    private final void newRandomDelay() {
        this.delayTimer.reset(MovementManager.isMoving$default(DarkMeow.INSTANCE.getMovementManager(), false, 1, null) ? this.moveDelayValue : this.normalDelayValue);
    }

    @Nullable
    public final Boolean debug(@NotNull String opt) {
        Object object;
        Intrinsics.checkNotNullParameter(opt, "opt");
        Object object2 = this.debugValue.get();
        boolean it = (Boolean)object2;
        boolean bl2 = false;
        Boolean bl3 = (Boolean)(it ? object2 : null);
        if (bl3 != null) {
            object2 = bl3;
            it = (Boolean)object2;
            boolean bl4 = false;
            DarkMeow.INSTANCE.getMessageManager().display.displayInfo(opt);
            object = object2;
        } else {
            object = null;
        }
        return object;
    }

    public final boolean checkDelay() {
        boolean bl2;
        boolean it = bl2 = MSDelay.hasPassed$default(this.delayTimer, 0L, 1, null);
        boolean bl3 = false;
        if (it) {
            this.newRandomDelay();
        }
        return bl2;
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
            InvManagerExtend it = (InvManagerExtend)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            InvManagerExtend it = (InvManagerExtend)element$iv;
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
            InvManagerExtend it = (InvManagerExtend)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            InvManagerExtend it = (InvManagerExtend)element$iv;
            boolean bl3 = false;
            it.onDisable();
        }
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget(priority=0)
    public final void onMovementInputPost(@NotNull MovementInputEvent.POST event) {
        Object object;
        Object object2;
        Object object3;
        block5: {
            void $this$filterTo$iv$iv;
            void $this$filter$iv;
            Intrinsics.checkNotNullParameter(event, "event");
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return;
            }
            EntityPlayerSP player = entityPlayerSP;
            object3 = this.extends.values();
            boolean $i$f$filter = false;
            void var6_7 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                InvManagerExtend it = (InvManagerExtend)element$iv$iv;
                boolean bl2 = false;
                if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            for (Object it : (Iterable)((List)destination$iv$iv)) {
                boolean bl3 = false;
                if ((it = it.preExecute(player)) == null) continue;
                object2 = it;
                break block5;
            }
            object2 = null;
        }
        Enum result = object2;
        boolean bl4 = false;
        Enum enum_ = result;
        object3 = (enum_ == null ? -1 : WhenMappings.$EnumSwitchMapping$0[enum_.ordinal()]) != 1;
        boolean it = (Boolean)object3;
        boolean bl5 = false;
        Object object4 = object = it ? object3 : null;
        if (object != null) {
            void $this$forEach$iv;
            object3 = object;
            it = (Boolean)object3;
            boolean bl6 = false;
            Iterable bl3 = this.modules.values();
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                InvManagerModeStatusCode invManagerModeStatusCode;
                InvManagerModule mode = (InvManagerModule)element$iv;
                boolean bl7 = false;
                if (!((Boolean)mode.getLinkedStatValue().get()).booleanValue()) continue;
                InvManagerModeStatusCode ret = invManagerModeStatusCode = mode.onExecute();
                boolean bl8 = false;
                if (ret.isCancel()) break;
            }
        }
    }

    public final boolean isUseful(@NotNull ItemStack itemStack, int slot, boolean bl2) {
        Boolean bl3;
        block1: {
            Intrinsics.checkNotNullParameter(itemStack, "itemStack");
            for (InvManagerModule it : (Iterable)this.modules.values()) {
                boolean bl4 = false;
                Boolean bl5 = it.isUseful(slot, itemStack);
                if (bl5 == null) continue;
                bl3 = bl5;
                break block1;
            }
            bl3 = null;
        }
        return bl3 != null ? bl3 : bl2;
    }

    public static /* synthetic */ boolean isUseful$default(InvManager invManager, ItemStack itemStack, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        return invManager.isUseful(itemStack, n2, bl2);
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[InvManagerEnumPreExecuteAction.values().length];
            try {
                nArray[InvManagerEnumPreExecuteAction.CANCEL.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

