/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
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
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.audio.SoundEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPUpdateWalkingEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.base.NoSlowBaseModeGrimAC;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
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

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeGrimPlusUseArmorB;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/base/NoSlowBaseModeGrimAC;", "<init>", "()V", "stopSprintTick", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "processing", "", "getProcessing", "()Z", "setProcessing", "(Z)V", "applyNoSlow", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "getStopSprintTick", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoSlowFoodModeGrimPlusUseArmorB.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoSlowFoodModeGrimPlusUseArmorB.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeGrimPlusUseArmorB\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,82:1\n12#2,3:83\n21#2,2:86\n20#2,3:88\n1#3:91\n1#3:105\n1583#4,11:92\n1878#4,2:103\n1880#4:106\n1594#4:107\n295#4,2:108\n*S KotlinDebug\n*F\n+ 1 NoSlowFoodModeGrimPlusUseArmorB.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/food/NoSlowFoodModeGrimPlusUseArmorB\n*L\n28#1:83,3\n31#1:86,2\n48#1:88,3\n59#1:105\n59#1:92,11\n59#1:103,2\n59#1:106\n59#1:107\n62#1:108,2\n*E\n"})
public final class NoSlowFoodModeGrimPlusUseArmorB
extends NoSlowBaseModeGrimAC {
    @JvmField
    @NotNull
    public final IntegerValue stopSprintTick = new IntegerValue("StopSprintTick", 1, new IntRange(0, 10));
    private volatile boolean processing;

    public NoSlowFoodModeGrimPlusUseArmorB() {
        super("GrimPlusUseArmorB");
        ListenableOwner $this$safeListener$iv;
        ListenableOwner $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<ListenerBase, CancellableEvent, Unit> function$iv = (arg_0, arg_1) -> NoSlowFoodModeGrimPlusUseArmorB._init_$lambda$0(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<SoundEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(SoundEvent.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        priority$iv = 1000;
        function$iv = (arg_0, arg_1) -> NoSlowFoodModeGrimPlusUseArmorB._init_$lambda$1(this, arg_0, arg_1);
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($this$safeListener$iv).add(new EventHookSafeOwnerCheck<SoundEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(PacketEvent.class), $this$safeListener$iv));
        ListenableOwnerExtends this_$iv = ListenableOwnerExtends.INSTANCE;
        $this$safeListener$iv = this;
        function$iv = (arg_0, arg_1) -> NoSlowFoodModeGrimPlusUseArmorB._init_$lambda$2(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<SoundEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(PlayerSPUpdateWalkingEvent.PRE.class), $receiver$iv));
    }

    public final boolean getProcessing() {
        return this.processing;
    }

    public final void setProcessing(boolean bl2) {
        this.processing = bl2;
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
                this.processing = true;
                $this$applyNoSlow.getPlayerController().func_187098_a(0, 3, $this$applyNoSlow.getPlayer().field_71071_by.field_70461_c, ClickType.SWAP, (EntityPlayer)$this$applyNoSlow.getPlayer());
                $this$applyNoSlow.getPlayerController().func_187098_a(0, armorSlot, $this$applyNoSlow.getPlayer().field_71071_by.field_70461_c, ClickType.SWAP, (EntityPlayer)$this$applyNoSlow.getPlayer());
                $this$applyNoSlow.getPlayerController().func_187101_a((EntityPlayer)$this$applyNoSlow.getPlayer(), (World)$this$applyNoSlow.getWorld(), EnumHand.MAIN_HAND);
                $this$applyNoSlow.getPlayerController().func_187098_a(0, 3, $this$applyNoSlow.getPlayer().field_71071_by.field_70461_c, ClickType.SWAP, (EntityPlayer)$this$applyNoSlow.getPlayer());
            }
        }
    }

    @Override
    public int getStopSprintTick() {
        return ((Number)this.stopSprintTick.get()).intValue();
    }

    private static final Unit _init_$lambda$0(NoSlowFoodModeGrimPlusUseArmorB this$0, ListenerBase $this$listener, SoundEvent event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (this$0.processing) {
            String string = event.getSound().func_147650_b().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (StringsKt.startsWith$default(string, "minecraft:item.armor.equip_", false, 2, null)) {
                event.cancelEvent();
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(NoSlowFoodModeGrimPlusUseArmorB this$0, SafeListenerBase $this$safeListener, PacketEvent event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof SPacketWindowItems) {
            if (this$0.processing) {
                event.cancelEvent();
                this$0.processing = false;
            }
        } else if (packet instanceof SPacketSetSlot && ((SPacketSetSlot)packet).func_149175_c() == 0 && this$0.processing) {
            if (((SPacketSetSlot)packet).func_149173_d() == 0) {
                event.cancelEvent();
            }
            if (((SPacketSetSlot)packet).func_149173_d() - 36 == $this$safeListener.getPlayer().field_71071_by.field_70461_c) {
                NoSlowBaseModeGrimAC.markAllowNoSlow$default(this$0, $this$safeListener, 1, 0, false, 6, null);
                $this$safeListener.getPlayerController().func_187101_a((EntityPlayer)$this$safeListener.getPlayer(), (World)$this$safeListener.getWorld(), EnumHand.MAIN_HAND);
                event.cancelEvent();
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$2(NoSlowFoodModeGrimPlusUseArmorB this$0, SafeListenerBase $this$safeListener, PlayerSPUpdateWalkingEvent.PRE it) {
        int n2;
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.getCanNoSlowTickMainHand() > 0) {
            n2 = this$0.getCanNoSlowTickMainHand();
            this$0.setCanNoSlowTickMainHand(n2 + -1);
        }
        if (this$0.getCanNoSlowTickOffHand() > 0) {
            n2 = this$0.getCanNoSlowTickOffHand();
            this$0.setCanNoSlowTickOffHand(n2 + -1);
        }
        return Unit.INSTANCE;
    }
}

