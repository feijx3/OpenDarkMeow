/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.init.MobEffects
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.EnumHand
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.input.Mouse
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.MotionEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.extend.ExtendKeyBinding;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Mouse;

@ModuleInfo(name="AutoHead", description="a?", category=ModuleCategory.COMBAT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoHead;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "eatingApple", "", "switched", "", "doingStuff", "getDoingStuff", "()Z", "setDoingStuff", "(Z)V", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/TimeUtils;", "eatHeads", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "eatApples", "health", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "delay", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "onEnable", "", "onDisable", "repairItemPress", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "repairItemSwitch", "getItemFromHotbar", "id", "DarkMeow"})
public final class AutoHead
extends Module {
    private boolean eatingApple;
    private int switched = -1;
    private boolean doingStuff;
    @NotNull
    private final TimeUtils timer = new TimeUtils();
    @NotNull
    private final BoolValue eatHeads = new BoolValue("EatHead", true);
    @NotNull
    private final BoolValue eatApples = new BoolValue("EatApples", true);
    @NotNull
    private final FloatValue health = new FloatValue("Health", 10.0f, 1.0f, 20.0f);
    @NotNull
    private final IntegerValue delay = new IntegerValue("Delay", 750, 100, 2000);

    public AutoHead() {
        super(null, null, null, null, 15, null);
    }

    public final boolean getDoingStuff() {
        return this.doingStuff;
    }

    public final void setDoingStuff(boolean bl2) {
        this.doingStuff = bl2;
    }

    @Override
    public void onEnable() {
        this.eatingApple = this.doingStuff = false;
        this.switched = -1;
        this.timer.reset();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.doingStuff = false;
        if (this.eatingApple) {
            this.repairItemPress();
            this.repairItemSwitch();
        }
        super.onDisable();
    }

    private final void repairItemPress() {
        KeyBinding keyBindUseItem;
        if (MinecraftInstance.mc.getGameSettings() != null && (keyBindUseItem = MinecraftInstance.mc.getGameSettings().field_74313_G) != null) {
            ExtendKeyBinding.INSTANCE.unPressKey(keyBindUseItem);
        }
    }

    @EventTarget
    public final void onUpdate(@Nullable MotionEvent event) {
        block13: {
            KeyBinding useItem;
            InventoryPlayer inventory;
            block15: {
                block14: {
                    if (MinecraftInstance.mc.getPlayer() == null) {
                        return;
                    }
                    EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
                    Intrinsics.checkNotNull(entityPlayerSP);
                    inventory = entityPlayerSP.field_71071_by;
                    this.doingStuff = false;
                    if (Mouse.isButtonDown((int)0) || Mouse.isButtonDown((int)1)) break block13;
                    useItem = MinecraftInstance.mc.getGameSettings().field_74313_G;
                    if (!this.timer.hasReached(((Number)this.delay.get()).intValue())) {
                        this.eatingApple = false;
                        this.repairItemPress();
                        this.repairItemSwitch();
                        return;
                    }
                    EntityPlayerSP entityPlayerSP2 = MinecraftInstance.mc.getPlayer();
                    Intrinsics.checkNotNull(entityPlayerSP2);
                    if (entityPlayerSP2.field_71075_bZ.field_75098_d) break block14;
                    EntityPlayerSP entityPlayerSP3 = MinecraftInstance.mc.getPlayer();
                    Intrinsics.checkNotNull(entityPlayerSP3);
                    if (entityPlayerSP3.func_70644_a(MobEffects.field_76428_l)) break block14;
                    EntityPlayerSP entityPlayerSP4 = MinecraftInstance.mc.getPlayer();
                    Intrinsics.checkNotNull(entityPlayerSP4);
                    if (!(entityPlayerSP4.func_110143_aJ() >= ((Number)this.health.get()).floatValue())) break block15;
                }
                this.timer.reset();
                if (this.eatingApple) {
                    this.eatingApple = false;
                    this.repairItemPress();
                    this.repairItemSwitch();
                }
                return;
            }
            for (int i2 = 0; i2 < 2; ++i2) {
                boolean doEatHeads;
                boolean bl2 = doEatHeads = i2 != 0;
                if (doEatHeads) {
                    if (!((Boolean)this.eatHeads.get()).booleanValue()) {
                        continue;
                    }
                } else if (!((Boolean)this.eatApples.get()).booleanValue()) {
                    this.eatingApple = false;
                    this.repairItemPress();
                    this.repairItemSwitch();
                    continue;
                }
                int slot = 0;
                int n2 = slot = doEatHeads ? this.getItemFromHotbar(397) : this.getItemFromHotbar(322);
                if (slot == -1) continue;
                int tempSlot = inventory.field_70461_c;
                this.doingStuff = true;
                if (doEatHeads) {
                    NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
                    Intrinsics.checkNotNull(netHandlerPlayClient);
                    netHandlerPlayClient.func_147297_a((Packet)new CPacketHeldItemChange(slot));
                    NetHandlerPlayClient netHandlerPlayClient2 = MinecraftInstance.mc.getConnection();
                    Intrinsics.checkNotNull(netHandlerPlayClient2);
                    netHandlerPlayClient2.func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                    NetHandlerPlayClient netHandlerPlayClient3 = MinecraftInstance.mc.getConnection();
                    Intrinsics.checkNotNull(netHandlerPlayClient3);
                    netHandlerPlayClient3.func_147297_a((Packet)new CPacketHeldItemChange(tempSlot));
                    this.timer.reset();
                    continue;
                }
                inventory.field_70461_c = slot;
                Intrinsics.checkNotNull(useItem);
                ExtendKeyBinding.INSTANCE.setPressed(useItem, true);
                if (this.eatingApple) continue;
                this.eatingApple = true;
                this.switched = tempSlot;
            }
        }
    }

    private final void repairItemSwitch() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP p2 = entityPlayerSP;
        InventoryPlayer inventory = p2.field_71071_by;
        int switched = this.switched;
        if (switched == -1) {
            return;
        }
        inventory.field_70461_c = switched;
        this.switched = switched = -1;
    }

    private final int getItemFromHotbar(int id) {
        for (int i2 = 0; i2 < 9; ++i2) {
            Item item;
            ItemStack a2;
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            Intrinsics.checkNotNull(entityPlayerSP);
            if (entityPlayerSP.field_71071_by.field_70462_a.get(i2) == null) continue;
            EntityPlayerSP entityPlayerSP2 = MinecraftInstance.mc.getPlayer();
            Intrinsics.checkNotNull(entityPlayerSP2);
            ItemStack itemStack = a2 = (ItemStack)entityPlayerSP2.field_71071_by.field_70462_a.get(i2);
            Intrinsics.checkNotNull(itemStack);
            Item item2 = item = itemStack.func_77973_b();
            Intrinsics.checkNotNull(item2);
            if (Item.func_150891_b((Item)item2) != id) continue;
            return i2;
        }
        return -1;
    }
}

