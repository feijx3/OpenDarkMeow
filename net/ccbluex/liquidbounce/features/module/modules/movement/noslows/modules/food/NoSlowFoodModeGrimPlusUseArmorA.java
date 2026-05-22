/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketSetSlot
 *  net.minecraft.network.play.server.SPacketWindowItems
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.NonNullList
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.audio.SoundEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.base.NoSlowBaseModeGrimAC;
import net.ccbluex.liquidbounce.injection.access.AccessorMinecraft;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.network.play.server.SPacketWindowItems;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeGrimPlusUseArmorA;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/base/NoSlowBaseModeGrimAC;", "<init>", "()V", "stopSprintTickValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "failOnWindowItemsValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "state", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeGrimPlusUseArmorA$State;", "getState", "()Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeGrimPlusUseArmorA$State;", "setState", "(Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeGrimPlusUseArmorA$State;)V", "overrideActiveSleepTick", "", "getOverrideActiveSleepTick", "()Z", "setOverrideActiveSleepTick", "(Z)V", "applyNoSlow", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "getStopSprintTick", "", "getActiveSleepTick", "State", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoSlowFoodModeGrimPlusUseArmorA.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoSlowFoodModeGrimPlusUseArmorA.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeGrimPlusUseArmorA\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,113:1\n12#2,3:114\n12#2,3:117\n21#2,2:120\n1#3:122\n1#3:136\n1583#4,11:123\n1878#4,2:134\n1880#4:137\n1594#4:138\n295#4,2:139\n*S KotlinDebug\n*F\n+ 1 NoSlowFoodModeGrimPlusUseArmorA.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeGrimPlusUseArmorA\n*L\n42#1:114,3\n46#1:117,3\n49#1:120,2\n78#1:136\n78#1:123,11\n78#1:134,2\n78#1:137\n78#1:138\n81#1:139,2\n*E\n"})
public final class NoSlowFoodModeGrimPlusUseArmorA
extends NoSlowBaseModeGrimAC {
    @JvmField
    @NotNull
    public final IntegerValue stopSprintTickValue = new IntegerValue("StopSprintTick", 1, new IntRange(0, 10));
    @JvmField
    @NotNull
    public final BoolValue failOnWindowItemsValue = new BoolValue("FailOnWindowItems", true);
    @NotNull
    private volatile State state = State.NONE;
    private volatile boolean overrideActiveSleepTick;

    /*
     * WARNING - void declaration
     */
    public NoSlowFoodModeGrimPlusUseArmorA() {
        super("GrimPlusUseArmorA");
        void $this$safeListener$iv;
        ListenableOwner $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<ListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> NoSlowFoodModeGrimPlusUseArmorA._init_$lambda$0(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(WorldEvent.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> NoSlowFoodModeGrimPlusUseArmorA._init_$lambda$1(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(SoundEvent.class), $receiver$iv));
        $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        priority$iv = 1001;
        function$iv = (arg_0, arg_1) -> NoSlowFoodModeGrimPlusUseArmorA._init_$lambda$2(this, arg_0, arg_1);
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$this$safeListener$iv).add(new EventHookSafeOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(PacketEvent.class), (ListenableOwner)$this$safeListener$iv));
    }

    @NotNull
    public final State getState() {
        return this.state;
    }

    public final void setState(@NotNull State state) {
        Intrinsics.checkNotNullParameter((Object)state, "<set-?>");
        this.state = state;
    }

    public final boolean getOverrideActiveSleepTick() {
        return this.overrideActiveSleepTick;
    }

    public final void setOverrideActiveSleepTick(boolean bl2) {
        this.overrideActiveSleepTick = bl2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void applyNoSlow(@NotNull SafeListenerBase $this$applyNoSlow) {
        block6: {
            Object v1;
            block5: {
                void $this$firstOrNull$iv;
                void $this$mapIndexedNotNullTo$iv$iv;
                void $this$mapIndexedNotNull$iv;
                NonNullList nonNullList;
                NonNullList nonNullList2;
                Intrinsics.checkNotNullParameter($this$applyNoSlow, "<this>");
                if ($this$applyNoSlow.getPlayer().func_184600_cs() != EnumHand.MAIN_HAND) {
                    return;
                }
                Object it = nonNullList2 = $this$applyNoSlow.getPlayer().field_71069_bz.func_75138_a();
                boolean bl2 = false;
                Object object = nonNullList = ((ItemStack)it.get(3)).func_190926_b() ? nonNullList2 : null;
                if (nonNullList == null) break block6;
                it = (Iterable)nonNullList;
                boolean $i$f$mapIndexedNotNull22 = false;
                void var6_7 = $this$mapIndexedNotNull$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$mapIndexedNotNullTo = false;
                void $this$forEachIndexed$iv$iv$iv = $this$mapIndexedNotNullTo$iv$iv;
                boolean $i$f$forEachIndexed = false;
                int index$iv$iv$iv = 0;
                for (Object item$iv$iv$iv : $this$forEachIndexed$iv$iv$iv) {
                    Pair<Integer, void> it$iv$iv;
                    void itemStack;
                    void element$iv$iv;
                    int n2;
                    if ((n2 = index$iv$iv$iv++) < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Object t2 = item$iv$iv$iv;
                    int index$iv$iv = n2;
                    boolean bl3 = false;
                    ItemStack itemStack2 = (ItemStack)element$iv$iv;
                    int index = index$iv$iv;
                    boolean bl4 = false;
                    if (((5 <= index ? index < 9 : false) ? new Pair<Integer, void>(index, itemStack) : null) == null) continue;
                    it$iv$iv = it$iv$iv;
                    boolean bl5 = false;
                    destination$iv$iv.add(it$iv$iv);
                }
                Iterable $i$f$mapIndexedNotNull22 = (List)destination$iv$iv;
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    Pair pair = (Pair)element$iv;
                    boolean bl6 = false;
                    ItemStack itemStack = (ItemStack)pair.component2();
                    if (!(!itemStack.func_190926_b())) continue;
                    v1 = element$iv;
                    break block5;
                }
                v1 = null;
            }
            Pair pair = v1;
            if (pair != null) {
                Integer n3 = ((Number)pair.getFirst()).intValue();
                int armorSlot = ((Number)n3).intValue();
                boolean bl7 = false;
                this.state = State.USE_ARMORING;
                $this$applyNoSlow.getPlayerController().func_187098_a(0, 3, $this$applyNoSlow.getPlayer().field_71071_by.field_70461_c, ClickType.SWAP, (EntityPlayer)$this$applyNoSlow.getPlayer());
                $this$applyNoSlow.getPlayerController().func_187098_a(0, armorSlot, $this$applyNoSlow.getPlayer().field_71071_by.field_70461_c, ClickType.SWAP, (EntityPlayer)$this$applyNoSlow.getPlayer());
                $this$applyNoSlow.getPlayerController().func_187101_a((EntityPlayer)$this$applyNoSlow.getPlayer(), (World)$this$applyNoSlow.getWorld(), EnumHand.MAIN_HAND);
                Minecraft minecraft = $this$applyNoSlow.getMc();
                Intrinsics.checkNotNull(minecraft, "null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.access.AccessorMinecraft");
                ((AccessorMinecraft)minecraft).setRightClickDelayTimer(10);
                this.state = State.WAITING_SET_SLOT;
            }
        }
    }

    @Override
    public int getStopSprintTick() {
        return ((Number)this.stopSprintTickValue.get()).intValue();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public int getActiveSleepTick() {
        int n2;
        int base = super.getActiveSleepTick();
        boolean bl2 = false;
        if (this.overrideActiveSleepTick) {
            this.overrideActiveSleepTick = false;
            n2 = base + 4;
        } else {
            void var1_1;
            n2 = var1_1;
        }
        return n2;
    }

    private static final Unit _init_$lambda$0(NoSlowFoodModeGrimPlusUseArmorA this$0, ListenerBase $this$listener, WorldEvent it) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.state = State.NONE;
        this$0.overrideActiveSleepTick = false;
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(NoSlowFoodModeGrimPlusUseArmorA this$0, ListenerBase $this$listener, SoundEvent event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (this$0.state == State.USE_ARMORING) {
            String string = event.getSound().func_147650_b().func_110623_a();
            Intrinsics.checkNotNullExpressionValue(string, "getPath(...)");
            if (StringsKt.startsWith$default(string, "item.armor.equip_", false, 2, null)) {
                event.cancelEvent();
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$2(NoSlowFoodModeGrimPlusUseArmorA this$0, SafeListenerBase $this$safeListener, PacketEvent event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof SPacketWindowItems) {
            if (((Boolean)this$0.failOnWindowItemsValue.get()).booleanValue() && this$0.state == State.WAITING_SET_SLOT) {
                this$0.state = State.NONE;
                this$0.markDisAllowNoSlow();
            }
        } else if (packet instanceof SPacketSetSlot && ((SPacketSetSlot)packet).func_149175_c() == 0 && this$0.state == State.WAITING_SET_SLOT && ((SPacketSetSlot)packet).func_149173_d() - 36 == $this$safeListener.getPlayer().field_71071_by.field_70461_c) {
            $this$safeListener.getPlayer().field_71069_bz.func_75138_a().set(((SPacketSetSlot)packet).func_149173_d(), (Object)((SPacketSetSlot)packet).func_149174_e());
            NoSlowBaseModeGrimAC.markAllowNoSlow$default(this$0, $this$safeListener, 1, 0, false, 6, null);
            $this$safeListener.getPlayerController().func_187098_a(0, 3, $this$safeListener.getPlayer().field_71071_by.field_70461_c, ClickType.SWAP, (EntityPlayer)$this$safeListener.getPlayer());
            $this$safeListener.getPlayerController().func_187101_a((EntityPlayer)$this$safeListener.getPlayer(), (World)$this$safeListener.getWorld(), EnumHand.MAIN_HAND);
            this$0.state = State.NONE;
            this$0.overrideActiveSleepTick = true;
            event.cancelEvent();
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeGrimPlusUseArmorA$State;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "USE_ARMORING", "WAITING_SET_SLOT", "DarkMeow"})
    public static final class State
    extends Enum<State> {
        public static final /* enum */ State NONE = new State();
        public static final /* enum */ State USE_ARMORING = new State();
        public static final /* enum */ State WAITING_SET_SLOT = new State();
        private static final /* synthetic */ State[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static State[] values() {
            return (State[])$VALUES.clone();
        }

        public static State valueOf(String value) {
            return Enum.valueOf(State.class, value);
        }

        @NotNull
        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = stateArray = new State[]{State.NONE, State.USE_ARMORING, State.WAITING_SET_SLOT};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

