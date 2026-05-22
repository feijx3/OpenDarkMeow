/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketCloseWindow
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.InventoryUtils;
import net.ccbluex.liquidbounce.utils.timer.MSTimer;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(name="AutoSoup", category=ModuleCategory.COMBAT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoSoup;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "healthValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "delayValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "openInventoryValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "simulateInventoryValue", "bowlValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "tag", "", "getTag", "()Ljava/lang/String;", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAutoSoup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoSoup.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/AutoSoup\n+ 2 BackendExtentions.kt\nnet/ccbluex/liquidbounce/utils/extensions/BackendExtentionsKt\n*L\n1#1,106:1\n12#2,9:107\n12#2,9:116\n*S KotlinDebug\n*F\n+ 1 AutoSoup.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/AutoSoup\n*L\n83#1:107,9\n97#1:116,9\n*E\n"})
public final class AutoSoup
extends Module {
    @NotNull
    private final FloatValue healthValue = new FloatValue("Health", 15.0f, 0.0f, 20.0f);
    @NotNull
    private final IntegerValue delayValue = new IntegerValue("Delay", 150, 0, 500);
    @NotNull
    private final BoolValue openInventoryValue = new BoolValue("OpenInv", false);
    @NotNull
    private final BoolValue simulateInventoryValue = new BoolValue("SimulateInventory", true);
    @NotNull
    private final ListValue bowlValue;
    @NotNull
    private final MSTimer timer;

    public AutoSoup() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"Drop", "Move", "Stay"};
        this.bowlValue = new ListValue("Bowl", stringArray, "Drop");
        this.timer = new MSTimer();
    }

    @Override
    @NotNull
    public String getTag() {
        return String.valueOf(((Number)this.healthValue.get()).floatValue());
    }

    @EventTarget
    public final void onUpdate(@Nullable UpdateEvent event) {
        int soupInInventory;
        boolean $i$f$toClickType;
        boolean openInventory;
        if (!this.timer.hasTimePassed((long)((Number)this.delayValue.get()).intValue())) {
            return;
        }
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
        if (netHandlerPlayClient == null) {
            return;
        }
        NetHandlerPlayClient connection = netHandlerPlayClient;
        int soupInHotbar = InventoryUtils.findItem(36, 45, Items.field_151009_A);
        if (player.func_110143_aJ() <= ((Number)this.healthValue.get()).floatValue() && soupInHotbar != -1) {
            connection.func_147297_a((Packet)new CPacketHeldItemChange(soupInHotbar - 36));
            connection.func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
            if (StringsKt.equals((String)this.bowlValue.get(), "Drop", true)) {
                connection.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.DROP_ITEM, BlockPos.field_177992_a, EnumFacing.DOWN));
            }
            connection.func_147297_a((Packet)new CPacketHeldItemChange(player.field_71071_by.field_70461_c));
            this.timer.reset();
            return;
        }
        int bowlInHotbar = InventoryUtils.findItem(36, 45, Items.field_151054_z);
        if (StringsKt.equals((String)this.bowlValue.get(), "Move", true) && bowlInHotbar != -1) {
            if (((Boolean)this.openInventoryValue.get()).booleanValue() && !(MinecraftInstance.mc.getCurrentScreen() instanceof GuiInventory)) {
                return;
            }
            boolean bowlMovable = false;
            for (int i2 = 9; i2 < 37; ++i2) {
                ItemStack itemStack = player.field_71071_by.func_70301_a(i2);
                if (itemStack == null) {
                    bowlMovable = true;
                    break;
                }
                if (!Intrinsics.areEqual(itemStack.func_77973_b(), Items.field_151054_z) || itemStack.func_190916_E() >= 64) continue;
                bowlMovable = true;
                break;
            }
            if (bowlMovable) {
                ClickType clickType;
                boolean bl2 = openInventory = !(MinecraftInstance.mc.getCurrentScreen() instanceof GuiInventory) && (Boolean)this.simulateInventoryValue.get() != false;
                if (openInventory) {
                    connection.func_147297_a((Packet)new CPacketEntityAction((Entity)player, CPacketEntityAction.Action.OPEN_INVENTORY));
                }
                PlayerControllerMP playerControllerMP = MinecraftInstance.mc.getPlayerController();
                int $this$toClickType$iv = 1;
                $i$f$toClickType = false;
                switch ($this$toClickType$iv) {
                    case 0: {
                        clickType = ClickType.PICKUP;
                        break;
                    }
                    case 1: {
                        clickType = ClickType.QUICK_MOVE;
                        break;
                    }
                    case 2: {
                        clickType = ClickType.SWAP;
                        break;
                    }
                    case 3: {
                        clickType = ClickType.CLONE;
                        break;
                    }
                    case 4: {
                        clickType = ClickType.THROW;
                        break;
                    }
                    case 5: {
                        clickType = ClickType.QUICK_CRAFT;
                        break;
                    }
                    case 6: {
                        clickType = ClickType.PICKUP_ALL;
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("Invalid mode " + $this$toClickType$iv);
                    }
                }
                playerControllerMP.func_187098_a(0, bowlInHotbar, 0, clickType, (EntityPlayer)player);
            }
        }
        if ((soupInInventory = InventoryUtils.findItem(9, 36, Items.field_151009_A)) != -1 && InventoryUtils.hasSpaceHotbar()) {
            ClickType clickType;
            if (((Boolean)this.openInventoryValue.get()).booleanValue() && !(MinecraftInstance.mc.getCurrentScreen() instanceof GuiInventory)) {
                return;
            }
            boolean bl3 = openInventory = !(MinecraftInstance.mc.getCurrentScreen() instanceof GuiInventory) && (Boolean)this.simulateInventoryValue.get() != false;
            if (openInventory) {
                connection.func_147297_a((Packet)new CPacketEntityAction((Entity)player, CPacketEntityAction.Action.OPEN_INVENTORY));
            }
            PlayerControllerMP playerControllerMP = MinecraftInstance.mc.getPlayerController();
            int $this$toClickType$iv = 1;
            $i$f$toClickType = false;
            switch ($this$toClickType$iv) {
                case 0: {
                    clickType = ClickType.PICKUP;
                    break;
                }
                case 1: {
                    clickType = ClickType.QUICK_MOVE;
                    break;
                }
                case 2: {
                    clickType = ClickType.SWAP;
                    break;
                }
                case 3: {
                    clickType = ClickType.CLONE;
                    break;
                }
                case 4: {
                    clickType = ClickType.THROW;
                    break;
                }
                case 5: {
                    clickType = ClickType.QUICK_CRAFT;
                    break;
                }
                case 6: {
                    clickType = ClickType.PICKUP_ALL;
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid mode " + $this$toClickType$iv);
                }
            }
            playerControllerMP.func_187098_a(0, soupInInventory, 0, clickType, (EntityPlayer)player);
            if (openInventory) {
                connection.func_147297_a((Packet)new CPacketCloseWindow());
            }
            this.timer.reset();
        }
    }
}

