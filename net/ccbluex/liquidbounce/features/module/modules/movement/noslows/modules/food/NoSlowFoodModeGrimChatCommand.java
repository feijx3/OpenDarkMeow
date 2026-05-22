/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBucketMilk
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemPotion
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketCloseWindow
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.network.play.server.SPacketOpenWindow
 *  net.minecraft.network.play.server.SPacketSetSlot
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.modules.exploit.Disabler;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.NoSlowSubMode;
import net.ccbluex.liquidbounce.handler.network.packet.PacketManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.timer.delay.MSDelay;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.IntegerRangeValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.server.SPacketOpenWindow;
import net.minecraft.network.play.server.SPacketSetSlot;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeGrimChatCommand;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/NoSlowSubMode;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "customTextValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "compensationValue", "compensationTimeValue", "", "delayValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "delay", "Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "canNoSlow", "", "packetSent", "compensationTick", "canEnable", "onEnable", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onSlowDown", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "onUpdateMoveState", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$POST;", "reset", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoSlowFoodModeGrimChatCommand.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoSlowFoodModeGrimChatCommand.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeGrimChatCommand\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,113:1\n1#2:114\n774#3:115\n865#3,2:116\n*S KotlinDebug\n*F\n+ 1 NoSlowFoodModeGrimChatCommand.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeGrimChatCommand\n*L\n84#1:115\n84#1:116,2\n*E\n"})
public class NoSlowFoodModeGrimChatCommand
extends NoSlowSubMode {
    @NotNull
    private final ListValue modeValue;
    @NotNull
    private final Value<String> customTextValue;
    @NotNull
    private final ListValue compensationValue;
    @NotNull
    private final Value<Integer> compensationTimeValue;
    @NotNull
    private final IntegerRangeValue delayValue;
    @NotNull
    private final MSDelay delay;
    private boolean canNoSlow;
    private boolean packetSent;
    private int compensationTick;

    public NoSlowFoodModeGrimChatCommand() {
        super("GrimChatCommand");
        String[] stringArray = new String[]{"Report", "HytBW", "Custom"};
        this.modeValue = new ListValue("Mode", stringArray, "Report");
        this.customTextValue = new TextValue("CustomText", "/warp").displayable(() -> NoSlowFoodModeGrimChatCommand.customTextValue$lambda$0(this));
        stringArray = new String[]{"DoSlow", "Stop", "None"};
        this.compensationValue = new ListValue("CompensationMode", stringArray, "DoSlow");
        this.compensationTimeValue = new IntegerValue("CompensationTime", 3, 1, 5).displayable(() -> NoSlowFoodModeGrimChatCommand.compensationTimeValue$lambda$1(this));
        this.delayValue = new IntegerRangeValue("ChatDelay", new IntRange(15000, 16000), new IntRange(0, 40000));
        this.delay = new MSDelay();
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

    @Override
    public void onEnable() {
        if (!this.canEnable()) {
            DarkMeow.INSTANCE.getMessageManager().display.displayError("NoSlow\\Food\\GrimDropPlus \u9700\u8981\u914d\u5408 Disabler\\GrimPost \u624d\u80fd\u4f7f\u7528 \u8bf7\u5148\u542f\u7528");
            return;
        }
        this.reset();
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof CPacketPlayerTryUseItem) {
            this.packetSent = false;
        } else if (packet instanceof CPacketHeldItemChange) {
            this.canNoSlow = false;
        } else if (packet instanceof CPacketPlayerDigging) {
            if (((CPacketPlayerDigging)packet).func_180762_c() == CPacketPlayerDigging.Action.RELEASE_USE_ITEM) {
                this.canNoSlow = false;
            }
        } else if (packet instanceof SPacketOpenWindow) {
            if (this.packetSent) {
                this.canNoSlow = true;
                PacketManager.sendPacket$default(DarkMeow.INSTANCE.getNetworkManager().packetManager, (Packet)new CPacketCloseWindow(((SPacketOpenWindow)packet).func_148901_c()), true, null, 4, null);
                event.cancelEvent();
            }
        } else if (packet instanceof SPacketSetSlot) {
            Item activeItem = DarkMeow.INSTANCE.getInventoryManager().getHeldItemMainHand().func_77973_b();
            if (((SPacketSetSlot)packet).func_149175_c() == 0) {
                InventoryPlayer inventoryPlayer;
                EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
                boolean bl2 = entityPlayerSP != null && (inventoryPlayer = entityPlayerSP.field_71071_by) != null ? ((SPacketSetSlot)packet).func_149173_d() - 36 == inventoryPlayer.field_70461_c : false;
                if (bl2 && (activeItem instanceof ItemFood || activeItem instanceof ItemPotion || activeItem instanceof ItemBucketMilk)) {
                    this.compensationTick = ((Number)this.compensationTimeValue.get()).intValue();
                    this.canNoSlow = true;
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onSlowDown(@NotNull CancellableEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (this.compensationTick > 0 && Intrinsics.areEqual(this.compensationValue.get(), "DoSlow")) {
            int n2 = this.compensationTick;
            this.compensationTick = n2 + -1;
            return;
        }
        if (MSDelay.hasPassed$default(this.delay, 0L, 1, null) && !this.packetSent && !this.canNoSlow) {
            List list;
            Object object = MinecraftInstance.mc.getWorld();
            if (object != null && (object = object.field_73010_i) != null) {
                void $this$filterTo$iv$iv;
                Iterable $this$filter$iv = (Iterable)object;
                boolean $i$f$filter = false;
                Iterable iterable = $this$filter$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    EntityPlayer it = (EntityPlayer)element$iv$iv;
                    boolean bl2 = false;
                    if (!(!Intrinsics.areEqual(it, player))) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                list = (List)destination$iv$iv;
            } else {
                list = null;
            }
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<net.minecraft.entity.player.EntityPlayer>");
            List players = list;
            String string = (String)this.modeValue.get();
            String chatMessage = Intrinsics.areEqual(string, "Report") ? "/report " + ((EntityPlayer)CollectionsKt.random(players, Random.Default)).func_70005_c_() : (Intrinsics.areEqual(string, "HytBW") ? "/lizi open" : this.customTextValue.get());
            player.func_71165_d(chatMessage);
            this.packetSent = true;
            this.delay.reset(this.delayValue);
        }
        if (this.canNoSlow) {
            event.cancelEvent();
        }
    }

    @EventTarget
    public final void onUpdateMoveState(@NotNull MovementInputEvent.POST event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.compensationTick > 0 && Intrinsics.areEqual(this.compensationValue.get(), "Stop")) {
            event.getMovementInput().field_192832_b = 0.0f;
            event.getMovementInput().field_78902_a = 0.0f;
            int n2 = this.compensationTick;
            this.compensationTick = n2 + -1;
        }
    }

    private final void reset() {
        this.canNoSlow = false;
        this.packetSent = false;
        this.compensationTick = 0;
    }

    private static final boolean customTextValue$lambda$0(NoSlowFoodModeGrimChatCommand this$0) {
        return Intrinsics.areEqual(this$0.modeValue.get(), "Custom");
    }

    private static final boolean compensationTimeValue$lambda$1(NoSlowFoodModeGrimChatCommand this$0) {
        return !Intrinsics.areEqual(this$0.compensationValue.get(), "None");
    }
}

