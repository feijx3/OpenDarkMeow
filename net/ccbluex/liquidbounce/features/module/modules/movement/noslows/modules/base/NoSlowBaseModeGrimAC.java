/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketEntityStatus
 *  net.minecraft.network.play.server.SPacketOpenWindow
 *  net.minecraft.network.play.server.SPacketSetSlot
 *  net.minecraft.network.play.server.SPacketWindowItems
 *  net.minecraft.util.EnumHand
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.base;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerTryUseItemEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPUpdateWalkingEvent;
import net.ccbluex.liquidbounce.event.events.player.move.SlowDownEvent;
import net.ccbluex.liquidbounce.event.events.tick.TickInputEvent;
import net.ccbluex.liquidbounce.features.module.modules.exploit.Disabler;
import net.ccbluex.liquidbounce.features.module.modules.movement.Sprint;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.NoSlowSubMode;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.category.NoSlowFoodMode;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayerSP;
import net.ccbluex.liquidbounce.injection.extend.packet.ExtendSPacketEntityStatus;
import net.ccbluex.liquidbounce.value.Value;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.network.play.server.SPacketOpenWindow;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.network.play.server.SPacketWindowItems;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 32\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0014\u0010!\u001a\u00020\u001f*\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0014\u0010%\u001a\u00020\u001f*\u00020\"2\u0006\u0010#\u001a\u00020&H\u0016J\n\u0010'\u001a\u00020\u0007*\u00020\"J(\u0010(\u001a\u00020\u001f*\u00020\"2\b\b\u0002\u0010)\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\r2\b\b\u0002\u0010+\u001a\u00020\u0007J\u0006\u0010,\u001a\u00020\u001fJ\f\u0010-\u001a\u00020\u001f*\u00020\"H&J\b\u0010.\u001a\u00020\rH\u0016J\b\u0010/\u001a\u00020\rH\u0016J\u0010\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u000202H\u0016R\u001a\u0010\b\u001a\u00020\u0007X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0007X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u0007X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\rX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011\u00a8\u00064"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/base/NoSlowBaseModeGrimAC;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/NoSlowSubMode;", "name", "", "<init>", "(Ljava/lang/String;)V", "canEnable", "", "isApplyNoSlow", "()Z", "setApplyNoSlow", "(Z)V", "canNoSlowTickMainHand", "", "getCanNoSlowTickMainHand", "()I", "setCanNoSlowTickMainHand", "(I)V", "canNoSlowTickOffHand", "getCanNoSlowTickOffHand", "setCanNoSlowTickOffHand", "acceptNoSlow", "getAcceptNoSlow", "setAcceptNoSlow", "acceptNoEatDelay", "getAcceptNoEatDelay", "setAcceptNoEatDelay", "acceptSleepTick", "getAcceptSleepTick", "setAcceptSleepTick", "onEnable", "", "onDisable", "handleSPacketSetSlot", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "packet", "Lnet/minecraft/network/play/server/SPacketSetSlot;", "handleSPacketWindowItems", "Lnet/minecraft/network/play/server/SPacketWindowItems;", "handleStopSprint", "markAllowNoSlow", "mainHandTick", "offHandTick", "useFastEat", "markDisAllowNoSlow", "applyNoSlow", "getStopSprintTick", "getActiveSleepTick", "onSlowDown", "event", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoSlowBaseModeGrimAC.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoSlowBaseModeGrimAC.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/base/NoSlowBaseModeGrimAC\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,207:1\n20#2,3:208\n20#2,3:211\n20#2,3:214\n21#2,2:217\n20#2,3:219\n1#3:222\n*S KotlinDebug\n*F\n+ 1 NoSlowBaseModeGrimAC.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/base/NoSlowBaseModeGrimAC\n*L\n77#1:208,3\n83#1:211,3\n102#1:214,3\n106#1:217,2\n120#1:219,3\n*E\n"})
public abstract class NoSlowBaseModeGrimAC
extends NoSlowSubMode {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private volatile boolean isApplyNoSlow;
    private volatile int canNoSlowTickMainHand;
    private volatile int canNoSlowTickOffHand;
    private volatile boolean acceptNoSlow;
    private volatile boolean acceptNoEatDelay;
    private volatile int acceptSleepTick;
    @NotNull
    public static final String SPRINT_LOCK_NAME = "NoSlowBaseModeGrimAC";

    public NoSlowBaseModeGrimAC(@NotNull String name) {
        ListenableOwner $this$safeListener$iv;
        ListenableOwner $receiver$iv;
        Intrinsics.checkNotNullParameter(name, "name");
        super(name);
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<SafeListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> NoSlowBaseModeGrimAC._init_$lambda$1(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<TickInputEvent.UpdateKeyboard>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(TickInputEvent.UpdateKeyboard.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> NoSlowBaseModeGrimAC._init_$lambda$2(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<TickInputEvent.UpdateKeyboard>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(SlowDownEvent.class), $receiver$iv));
        $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> NoSlowBaseModeGrimAC._init_$lambda$3(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<TickInputEvent.UpdateKeyboard>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(PlayerSPUpdateWalkingEvent.PRE.class), $receiver$iv));
        $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        priority$iv = 1000;
        function$iv = (arg_0, arg_1) -> NoSlowBaseModeGrimAC._init_$lambda$4(this, arg_0, arg_1);
        $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($this$safeListener$iv).add(new EventHookSafeOwnerCheck<TickInputEvent.UpdateKeyboard>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(PacketEvent.class), $this$safeListener$iv));
        ListenableOwnerExtends this_$iv = ListenableOwnerExtends.INSTANCE;
        $this$safeListener$iv = this;
        function$iv = (arg_0, arg_1) -> NoSlowBaseModeGrimAC._init_$lambda$5(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<TickInputEvent.UpdateKeyboard>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(ControllerTryUseItemEvent.class), $receiver$iv));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean canEnable() {
        Disabler disabler = DarkMeow.INSTANCE.getModuleManager().get(Disabler.class);
        if (disabler == null) return false;
        Disabler it = disabler;
        boolean bl2 = false;
        if (!it.getState()) return false;
        Value<?> value = it.getValue("GrimPost");
        if (value == null) return false;
        boolean bl3 = Intrinsics.areEqual(value.getValue(), true);
        if (!bl3) return false;
        return true;
    }

    protected final boolean isApplyNoSlow() {
        return this.isApplyNoSlow;
    }

    protected final void setApplyNoSlow(boolean bl2) {
        this.isApplyNoSlow = bl2;
    }

    protected final int getCanNoSlowTickMainHand() {
        return this.canNoSlowTickMainHand;
    }

    protected final void setCanNoSlowTickMainHand(int n2) {
        this.canNoSlowTickMainHand = n2;
    }

    protected final int getCanNoSlowTickOffHand() {
        return this.canNoSlowTickOffHand;
    }

    protected final void setCanNoSlowTickOffHand(int n2) {
        this.canNoSlowTickOffHand = n2;
    }

    protected final boolean getAcceptNoSlow() {
        return this.acceptNoSlow;
    }

    protected final void setAcceptNoSlow(boolean bl2) {
        this.acceptNoSlow = bl2;
    }

    protected final boolean getAcceptNoEatDelay() {
        return this.acceptNoEatDelay;
    }

    protected final void setAcceptNoEatDelay(boolean bl2) {
        this.acceptNoEatDelay = bl2;
    }

    protected final int getAcceptSleepTick() {
        return this.acceptSleepTick;
    }

    protected final void setAcceptSleepTick(int n2) {
        this.acceptSleepTick = n2;
    }

    @Override
    public void onEnable() {
        if (!this.canEnable()) {
            DarkMeow.INSTANCE.getMessageManager().display.displayError("NoSlow \u5f53\u524d\u6240\u9009\u6a21\u5f0f\u9700\u8981\u914d\u5408 Disabler\\GrimPost \u624d\u80fd\u4f7f\u7528 \u8bf7\u5148\u542f\u7528");
        }
        this.onDisable();
    }

    @Override
    public void onDisable() {
        this.markDisAllowNoSlow();
        this.isApplyNoSlow = false;
        Sprint.unlockNoSprint(SPRINT_LOCK_NAME);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void handleSPacketSetSlot(@NotNull SafeListenerBase $this$handleSPacketSetSlot, @NotNull SPacketSetSlot packet) {
        boolean bl2;
        Intrinsics.checkNotNullParameter($this$handleSPacketSetSlot, "<this>");
        Intrinsics.checkNotNullParameter(packet, "packet");
        if (packet.func_149175_c() != 0 || packet.func_149173_d() - 36 != $this$handleSPacketSetSlot.getPlayer().field_71071_by.field_70461_c && packet.func_149173_d() != 45) return;
        Object object = $this$handleSPacketSetSlot.getPlayer().field_71069_bz.func_75138_a().get(packet.func_149173_d());
        Intrinsics.checkNotNullExpressionValue(object, "get(...)");
        ItemStack clientStack = (ItemStack)object;
        ItemStack serverStack = packet.func_149174_e();
        boolean bl3 = bl2 = !Intrinsics.areEqual(clientStack.func_77973_b(), serverStack.func_77973_b());
        if (bl2) {
            boolean bl4;
            boolean bl5 = bl4 = packet.func_149173_d() == 45;
            if (!bl4) {
                NoSlowBaseModeGrimAC.markAllowNoSlow$default(this, $this$handleSPacketSetSlot, 1, 0, true, 2, null);
                return;
            } else {
                if (!bl4) throw new NoWhenBranchMatchedException();
                NoSlowBaseModeGrimAC.markAllowNoSlow$default(this, $this$handleSPacketSetSlot, 0, 1, true, 1, null);
            }
            return;
        } else {
            if (bl2) throw new NoWhenBranchMatchedException();
            if (clientStack.func_190916_E() >= serverStack.func_190916_E()) return;
            this.markDisAllowNoSlow();
        }
    }

    public void handleSPacketWindowItems(@NotNull SafeListenerBase $this$handleSPacketWindowItems, @NotNull SPacketWindowItems packet) {
        Intrinsics.checkNotNullParameter($this$handleSPacketWindowItems, "<this>");
        Intrinsics.checkNotNullParameter(packet, "packet");
        if (packet.func_148911_c() == 0 && packet.func_148910_d().size() > 45) {
            boolean bl2;
            SafeListenerBase $this$handleSPacketWindowItems_u24lambda_u246 = $this$handleSPacketWindowItems;
            boolean bl3 = false;
            Object object = $this$handleSPacketWindowItems_u24lambda_u246.getPlayer().field_71069_bz.func_75138_a().get($this$handleSPacketWindowItems_u24lambda_u246.getPlayer().field_71071_by.field_70461_c + 36);
            Intrinsics.checkNotNullExpressionValue(object, "get(...)");
            ItemStack clientStack = (ItemStack)object;
            ItemStack serverStack = (ItemStack)packet.func_148910_d().get($this$handleSPacketWindowItems_u24lambda_u246.getPlayer().field_71071_by.field_70461_c + 36);
            boolean bl4 = bl2 = !Intrinsics.areEqual(clientStack.func_77973_b(), serverStack.func_77973_b());
            if (bl2) {
                NoSlowBaseModeGrimAC.markAllowNoSlow$default(this, $this$handleSPacketWindowItems_u24lambda_u246, 1, 0, false, 6, null);
            } else if (!bl2) {
                if (clientStack.func_190916_E() < serverStack.func_190916_E()) {
                    this.markDisAllowNoSlow();
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            SafeListenerBase $this$handleSPacketWindowItems_u24lambda_u247 = $this$handleSPacketWindowItems;
            boolean bl5 = false;
            Object object2 = $this$handleSPacketWindowItems_u24lambda_u247.getPlayer().field_71069_bz.func_75138_a().get(45);
            Intrinsics.checkNotNullExpressionValue(object2, "get(...)");
            clientStack = (ItemStack)object2;
            serverStack = (ItemStack)packet.func_148910_d().get(45);
            boolean bl6 = bl2 = !Intrinsics.areEqual(clientStack.func_77973_b(), serverStack.func_77973_b());
            if (bl2) {
                NoSlowBaseModeGrimAC.markAllowNoSlow$default(this, $this$handleSPacketWindowItems_u24lambda_u247, 0, 1, false, 5, null);
            } else if (!bl2) {
                if (clientStack.func_190916_E() < serverStack.func_190916_E()) {
                    this.markDisAllowNoSlow();
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final boolean handleStopSprint(@NotNull SafeListenerBase $this$handleStopSprint) {
        boolean bl2;
        Integer n2;
        Intrinsics.checkNotNullParameter($this$handleStopSprint, "<this>");
        Integer n3 = this.getStopSprintTick();
        int it = ((Number)n3).intValue();
        boolean bl3 = false;
        Integer n4 = n2 = it > 0 ? n3 : null;
        if (n2 != null) {
            int tick = ((Number)n2).intValue();
            boolean bl4 = false;
            if ($this$handleStopSprint.getPlayer().func_70051_ag() || ExtendEntityPlayerSP.INSTANCE.getServerSprintState($this$handleStopSprint.getPlayer())) {
                Sprint.lockNoSprint(SPRINT_LOCK_NAME, RangesKt.coerceAtLeast(tick, 2));
                bl2 = false;
            } else {
                bl2 = true;
            }
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public final void markAllowNoSlow(@NotNull SafeListenerBase $this$markAllowNoSlow, int mainHandTick, int offHandTick, boolean useFastEat) {
        Intrinsics.checkNotNullParameter($this$markAllowNoSlow, "<this>");
        if (mainHandTick > 0) {
            this.canNoSlowTickMainHand = mainHandTick + 1;
        }
        if (offHandTick > 0) {
            this.canNoSlowTickOffHand = offHandTick + 1;
        }
        if (useFastEat && this.acceptNoSlow && $this$markAllowNoSlow.getMc().field_71474_y.field_74313_G.func_151470_d()) {
            $this$markAllowNoSlow.getPlayerController().func_187101_a((EntityPlayer)$this$markAllowNoSlow.getPlayer(), (World)$this$markAllowNoSlow.getWorld(), $this$markAllowNoSlow.getPlayer().func_184600_cs());
        }
    }

    public static /* synthetic */ void markAllowNoSlow$default(NoSlowBaseModeGrimAC noSlowBaseModeGrimAC, SafeListenerBase safeListenerBase, int n2, int n3, boolean bl2, int n4, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: markAllowNoSlow");
        }
        if ((n4 & 1) != 0) {
            n2 = 0;
        }
        if ((n4 & 2) != 0) {
            n3 = 0;
        }
        if ((n4 & 4) != 0) {
            bl2 = false;
        }
        noSlowBaseModeGrimAC.markAllowNoSlow(safeListenerBase, n2, n3, bl2);
    }

    public final void markDisAllowNoSlow() {
        this.acceptNoSlow = false;
        this.acceptNoEatDelay = false;
        this.canNoSlowTickMainHand = 0;
        this.canNoSlowTickOffHand = 0;
    }

    public abstract void applyNoSlow(@NotNull SafeListenerBase var1);

    public int getStopSprintTick() {
        return 0;
    }

    public int getActiveSleepTick() {
        return 1;
    }

    @Override
    public void onSlowDown(@NotNull CancellableEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    private static final Unit _init_$lambda$1(NoSlowBaseModeGrimAC this$0, SafeListenerBase $this$safeListener, TickInputEvent.UpdateKeyboard event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (!event.getGameSettings().field_74313_G.func_151470_d() && (this$0.acceptNoSlow || this$0.isApplyNoSlow)) {
            this$0.markDisAllowNoSlow();
            this$0.isApplyNoSlow = false;
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$2(NoSlowBaseModeGrimAC this$0, SafeListenerBase $this$safeListener, SlowDownEvent event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (!NoSlowFoodMode.INSTANCE.isApplyNoSlow($this$safeListener.getPlayer())) {
            return Unit.INSTANCE;
        }
        if (this$0.acceptNoSlow) {
            if (this$0.acceptSleepTick == 0) {
                event.cancelEvent();
            } else {
                int n2 = this$0.acceptSleepTick;
                this$0.acceptSleepTick = n2 + -1;
            }
        } else {
            if (!this$0.handleStopSprint($this$safeListener)) {
                return Unit.INSTANCE;
            }
            if (!this$0.isApplyNoSlow) {
                this$0.applyNoSlow($this$safeListener);
                this$0.isApplyNoSlow = true;
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$3(NoSlowBaseModeGrimAC this$0, SafeListenerBase $this$safeListener, PlayerSPUpdateWalkingEvent.PRE it) {
        int n2;
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.canNoSlowTickMainHand > 0) {
            n2 = this$0.canNoSlowTickMainHand;
            this$0.canNoSlowTickMainHand = n2 + -1;
        }
        if (this$0.canNoSlowTickOffHand > 0) {
            n2 = this$0.canNoSlowTickOffHand;
            this$0.canNoSlowTickOffHand = n2 + -1;
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$4(NoSlowBaseModeGrimAC this$0, SafeListenerBase $this$safeListener, PacketEvent event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.isCancelled()) {
            return Unit.INSTANCE;
        }
        Packet<?> packet = event.getPacket();
        if (packet instanceof SPacketSetSlot) {
            this$0.handleSPacketSetSlot($this$safeListener, (SPacketSetSlot)packet);
        } else if (packet instanceof SPacketWindowItems) {
            this$0.handleSPacketWindowItems($this$safeListener, (SPacketWindowItems)packet);
        } else if (packet instanceof SPacketOpenWindow) {
            NoSlowBaseModeGrimAC.markAllowNoSlow$default(this$0, $this$safeListener, 1, 1, false, 4, null);
        } else if (packet instanceof SPacketEntityStatus && ExtendSPacketEntityStatus.INSTANCE.getEntityId((SPacketEntityStatus)packet) == $this$safeListener.getPlayer().func_145782_y() && ((SPacketEntityStatus)packet).func_149160_c() == 9) {
            NoSlowBaseModeGrimAC.markAllowNoSlow$default(this$0, $this$safeListener, 2, 2, false, 4, null);
            this$0.acceptNoEatDelay = true;
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$5(NoSlowBaseModeGrimAC this$0, SafeListenerBase $this$safeListener, ControllerTryUseItemEvent event) {
        boolean bl2;
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.isCancelled()) {
            return Unit.INSTANCE;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[event.getHand().ordinal()]) {
            case 1: {
                if (this$0.canNoSlowTickMainHand > 0) {
                    bl2 = true;
                    break;
                }
                bl2 = false;
                break;
            }
            case 2: {
                if (this$0.canNoSlowTickOffHand > 0) {
                    bl2 = true;
                    break;
                }
                bl2 = false;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        this$0.acceptNoSlow = bl2;
        if (this$0.acceptNoSlow) {
            this$0.acceptSleepTick = this$0.getActiveSleepTick();
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/base/NoSlowBaseModeGrimAC$Companion;", "", "<init>", "()V", "SPRINT_LOCK_NAME", "", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[EnumHand.values().length];
            try {
                nArray[EnumHand.MAIN_HAND.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumHand.OFF_HAND.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

