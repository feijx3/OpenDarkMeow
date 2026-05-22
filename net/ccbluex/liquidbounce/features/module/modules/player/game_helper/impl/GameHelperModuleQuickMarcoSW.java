/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.block.BlockGlass
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketClickWindow
 *  net.minecraft.network.play.client.CPacketCloseWindow
 *  net.minecraft.network.play.client.CPacketConfirmTransaction
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.server.SPacketOpenWindow
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.game_helper.impl;

import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.render.AddMessageEvent;
import net.ccbluex.liquidbounce.event.events.world.WorldSetBlockStateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.modules.network.Blink;
import net.ccbluex.liquidbounce.features.module.modules.player.InvManager;
import net.ccbluex.liquidbounce.features.module.modules.player.game_helper.GameHelperModule;
import net.ccbluex.liquidbounce.features.module.modules.world.ContainerStealer;
import net.ccbluex.liquidbounce.handler.network.packet.PacketManager;
import net.ccbluex.liquidbounce.injection.extend.ExtendPlayerControllerMP;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.block.BlockGlass;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraft.network.play.client.CPacketConfirmTransaction;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.server.SPacketOpenWindow;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/game_helper/impl/GameHelperModuleQuickMarcoSW;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/game_helper/GameHelperModule;", "<init>", "()V", "autoKitValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "autoKitSelectValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "autoBlinkValue", "autoToggleModulesValue", "state", "Lnet/ccbluex/liquidbounce/features/module/modules/player/game_helper/impl/GameHelperModuleQuickMarcoSW$State;", "getState", "()Lnet/ccbluex/liquidbounce/features/module/modules/player/game_helper/impl/GameHelperModuleQuickMarcoSW$State;", "setState", "(Lnet/ccbluex/liquidbounce/features/module/modules/player/game_helper/impl/GameHelperModuleQuickMarcoSW$State;)V", "spawnPos", "Lnet/minecraft/util/math/BlockPos;", "getSpawnPos", "()Lnet/minecraft/util/math/BlockPos;", "setSpawnPos", "(Lnet/minecraft/util/math/BlockPos;)V", "Companion", "State", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nGameHelperModuleQuickMarcoSW.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameHelperModuleQuickMarcoSW.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/game_helper/impl/GameHelperModuleQuickMarcoSW\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,164:1\n37#2:165\n36#2,3:166\n1#3:169\n20#4,3:170\n20#4,3:173\n20#4,3:176\n21#4,2:179\n*S KotlinDebug\n*F\n+ 1 GameHelperModuleQuickMarcoSW.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/game_helper/impl/GameHelperModuleQuickMarcoSW\n*L\n50#1:165\n50#1:166,3\n78#1:170,3\n81#1:173,3\n121#1:176,3\n131#1:179,2\n*E\n"})
public final class GameHelperModuleQuickMarcoSW
extends GameHelperModule {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public final BoolValue autoKitValue = new BoolValue("AutoKit", true);
    @JvmField
    @NotNull
    public final ListValue autoKitSelectValue;
    @JvmField
    @NotNull
    public final BoolValue autoBlinkValue;
    @JvmField
    @NotNull
    public final BoolValue autoToggleModulesValue;
    @NotNull
    private State state;
    @NotNull
    private BlockPos spawnPos;
    @NotNull
    private static final Map<String, Integer> KITS;

    /*
     * WARNING - void declaration
     */
    public GameHelperModuleQuickMarcoSW() {
        super("QuickMarcoSW");
        void $this$safeListener$iv;
        ListenableOwner $receiver$iv;
        ListenableOwner $this$autoKitSelectValue_u24lambda_u240;
        Object $this$toTypedArray$iv = KITS.keySet();
        boolean $i$f$toTypedArray22 = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        Object $i$f$toTypedArray22 = $this$toTypedArray$iv = new ListValue("AutoKitSelect", thisCollection$iv.toArray(new String[0]), "Enchanter");
        GameHelperModuleQuickMarcoSW gameHelperModuleQuickMarcoSW = this;
        boolean bl2 = false;
        ((Value)((Object)$this$autoKitSelectValue_u24lambda_u240)).setSuperValue(this.autoKitValue);
        gameHelperModuleQuickMarcoSW.autoKitSelectValue = $this$toTypedArray$iv;
        this.autoBlinkValue = new BoolValue("AutoBlink", true);
        this.autoToggleModulesValue = new BoolValue("AutoToggleModules", true);
        this.state = State.WAITING;
        BlockPos blockPos = BlockPos.field_177992_a;
        Intrinsics.checkNotNullExpressionValue(blockPos, "ORIGIN");
        this.spawnPos = blockPos;
        $this$toTypedArray$iv = ListenableOwnerExtends.INSTANCE;
        $this$autoKitSelectValue_u24lambda_u240 = this;
        Function2<SafeListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> GameHelperModuleQuickMarcoSW._init_$lambda$1(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(WorldEvent.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> GameHelperModuleQuickMarcoSW._init_$lambda$8(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(AddMessageEvent.class), $receiver$iv));
        $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> GameHelperModuleQuickMarcoSW._init_$lambda$9(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(WorldSetBlockStateEvent.class), $receiver$iv));
        $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        priority$iv = 2000;
        function$iv = (arg_0, arg_1) -> GameHelperModuleQuickMarcoSW._init_$lambda$10(this, arg_0, arg_1);
        $i$f$safeListener = false;
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

    @NotNull
    public final BlockPos getSpawnPos() {
        return this.spawnPos;
    }

    public final void setSpawnPos(@NotNull BlockPos blockPos) {
        Intrinsics.checkNotNullParameter(blockPos, "<set-?>");
        this.spawnPos = blockPos;
    }

    private static final Unit _init_$lambda$1(GameHelperModuleQuickMarcoSW this$0, SafeListenerBase $this$safeListener, WorldEvent it) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.state = State.WAITING;
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$8(GameHelperModuleQuickMarcoSW this$0, SafeListenerBase $this$safeListener, AddMessageEvent event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (this$0.state == State.WAITING) {
            String string = event.getMessage().func_150260_c();
            Intrinsics.checkNotNullExpressionValue(string, "getUnformattedText(...)");
            Object object = string;
            if (new Regex("^\u5f00\u59cb\u5012\u8ba1\u65f6: [1-5] \u79d2$").containsMatchIn((CharSequence)object)) {
                if (((Boolean)this$0.autoKitValue.get()).booleanValue()) {
                    $this$safeListener.getPlayer().field_71071_by.field_70461_c = 0;
                    ExtendPlayerControllerMP.INSTANCE.syncCurrentPlayItem($this$safeListener.getPlayerController());
                    $this$safeListener.getPlayerController().func_187101_a((EntityPlayer)$this$safeListener.getPlayer(), (World)$this$safeListener.getWorld(), EnumHand.MAIN_HAND);
                }
                if (((Boolean)this$0.autoToggleModulesValue.get()).booleanValue()) {
                    ContainerStealer containerStealer = DarkMeow.INSTANCE.getModuleManager().get(ContainerStealer.class);
                    if (containerStealer != null) {
                        containerStealer.setState(true);
                    }
                    InvManager invManager = DarkMeow.INSTANCE.getModuleManager().get(InvManager.class);
                    if (invManager != null) {
                        invManager.setState(true);
                    }
                }
                if (((Boolean)this$0.autoBlinkValue.get()).booleanValue() && (object = DarkMeow.INSTANCE.getModuleManager().get(Blink.class)) != null) {
                    Object object2;
                    Object object3;
                    Object it = object3 = object;
                    boolean bl2 = false;
                    Object object4 = object2 = !((Module)it).getState() ? object3 : null;
                    if (object2 != null) {
                        BlockPos blockPos;
                        Object $this$lambda_u248_u24lambda_u247 = object3 = object2;
                        boolean bl3 = false;
                        ((Module)$this$lambda_u248_u24lambda_u247).setState(true);
                        BlockPos pos = blockPos = new BlockPos((Entity)$this$safeListener.getPlayer());
                        boolean bl4 = false;
                        this$0.spawnPos = pos;
                        int n2 = 3;
                        for (int i2 = 0; i2 < n2; ++i2) {
                            BlockPos blockPos2;
                            BlockPos blockPos3;
                            int offset = i2;
                            boolean bl5 = false;
                            BlockPos it2 = blockPos3 = pos.func_177979_c(offset);
                            boolean bl6 = false;
                            Object object5 = blockPos2 = $this$safeListener.getWorld().func_180495_p(it2).func_177230_c() instanceof BlockGlass ? blockPos3 : null;
                            if (blockPos2 == null) continue;
                            BlockPos blockPos4 = blockPos3 = blockPos2;
                            boolean bl7 = false;
                            $this$safeListener.getConnection().func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, blockPos4, EnumFacing.DOWN));
                            $this$safeListener.getConnection().func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos4, EnumFacing.DOWN));
                            $this$safeListener.getWorld().func_175698_g(blockPos4);
                        }
                    }
                }
                this$0.state = State.READY;
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$9(GameHelperModuleQuickMarcoSW this$0, SafeListenerBase $this$safeListener, WorldSetBlockStateEvent event) {
        block3: {
            Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
            Intrinsics.checkNotNullParameter(event, "event");
            if (this$0.state != State.READY || event.getPos().func_177958_n() != this$0.spawnPos.func_177958_n()) break block3;
            int n2 = this$0.spawnPos.func_177956_o() - 2;
            int n3 = this$0.spawnPos.func_177956_o();
            int n4 = event.getPos().func_177956_o();
            boolean bl2 = n2 <= n4 ? n4 <= n3 : false;
            if (bl2 && event.getPos().func_177952_p() == this$0.spawnPos.func_177952_p()) {
                this$0.state = State.PLAYING;
                if (((Boolean)this$0.autoBlinkValue.get()).booleanValue()) {
                    Blink blink = DarkMeow.INSTANCE.getModuleManager().get(Blink.class);
                    if (blink != null) {
                        blink.setState(false);
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$10(GameHelperModuleQuickMarcoSW this$0, SafeListenerBase $this$safeListener, PacketEvent event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof SPacketOpenWindow) {
            String string = ((SPacketOpenWindow)packet).func_179840_c().func_150254_d();
            Intrinsics.checkNotNullExpressionValue(string, "getFormattedText(...)");
            if (StringsKt.contains$default((CharSequence)string, "\u9009\u62e9\u4f60\u7684\u804c\u4e1a", false, 2, null)) {
                Integer n2 = KITS.get(this$0.autoKitSelectValue.get());
                PacketManager.sendPacket$default(DarkMeow.INSTANCE.getNetworkManager().packetManager, (Packet)new CPacketClickWindow(((SPacketOpenWindow)packet).func_148901_c(), n2 != null ? n2 : 6, 0, ClickType.PICKUP, ItemStack.field_190927_a, 1), true, null, 4, null);
                PacketManager.sendPacket$default(DarkMeow.INSTANCE.getNetworkManager().packetManager, (Packet)new CPacketConfirmTransaction(((SPacketOpenWindow)packet).func_148901_c(), 1, true), true, null, 4, null);
                PacketManager.sendPacket$default(DarkMeow.INSTANCE.getNetworkManager().packetManager, (Packet)new CPacketCloseWindow(((SPacketOpenWindow)packet).func_148901_c()), true, null, 4, null);
                event.cancelEvent();
            }
        }
        return Unit.INSTANCE;
    }

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to("KnockBacker", 0), TuplesKt.to("Fisher", 1), TuplesKt.to("Miner", 2), TuplesKt.to("Archer", 3), TuplesKt.to("Controller", 4), TuplesKt.to("Flamer", 5), TuplesKt.to("Enchanter", 6), TuplesKt.to("GoldWarrior", 7)};
        KITS = MapsKt.mutableMapOf(pairArray);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/game_helper/impl/GameHelperModuleQuickMarcoSW$Companion;", "", "<init>", "()V", "KITS", "", "", "", "getKITS", "()Ljava/util/Map;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Map<String, Integer> getKITS() {
            return KITS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/game_helper/impl/GameHelperModuleQuickMarcoSW$State;", "", "<init>", "(Ljava/lang/String;I)V", "WAITING", "READY", "PLAYING", "DarkMeow"})
    public static final class State
    extends Enum<State> {
        public static final /* enum */ State WAITING = new State();
        public static final /* enum */ State READY = new State();
        public static final /* enum */ State PLAYING = new State();
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
            $VALUES = stateArray = new State[]{State.WAITING, State.READY, State.PLAYING};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

